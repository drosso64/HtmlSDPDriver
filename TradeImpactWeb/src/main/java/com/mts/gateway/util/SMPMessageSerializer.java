package com.mts.gateway.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.mtsmarkets.sdp.smp.SMPMessage;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * SMPMessageSerializer - Serializzatore per messaggi SDP → JSON
 * 
 * FLUSSO DATI:
 * 1. Messaggio SDP arriva da TradeImpact server (oggetto Java)
 * 2. Questo serializer converte oggetto → JSON usando reflection
 * 3. JSON inviato ai client browser via WebSocket
 * 
 * DECISIONI ARCHITETTURALI CRITICHE:
 * - Usa LinkedHashMap invece di HashMap per preservare ordine campi
 *   (importante: frontend mostra colonne nell'ordine della classe Java)
 * - Normalizza nomi campi a camelCase (InstrumentId → instrumentId)
 *   per evitare duplicati (field + getter)
 * - Filtra campi interni (Class, ClassName, cLASS_ID, classid, SMPClassId)
 *   che sono metadati tecnici non rilevanti per l'utente
 * 
 * @author TradeImpact Web Gateway Team
 */
@Slf4j
public class SMPMessageSerializer {
    
    private static final ObjectMapper objectMapper = new ObjectMapper();
    
    /**
     * Serializza messaggio SDP a JSON string
     * 
     * ESEMPIO INPUT (oggetto Java BV_BOND):
     *   BV_BOND {
     *     InstrumentId: 12345
     *     InstrumentDesc: "IT0005429722"
     *     Coupon: 3.5
     *   }
     * 
     * ESEMPIO OUTPUT (JSON):
     *   {
     *     "_type": "BV_BOND",
     *     "instrumentId": 12345,         // ⚠️ Nota: prima lettera minuscola
     *     "instrumentDesc": "IT0005429722",
     *     "coupon": 3.5
     *   }
     * 
     * @param smpMessage Oggetto Java SDP da serializzare
     * @return JSON string pronto per WebSocket broadcast
     */
    public static String toJson(Object smpMessage) {
        if (smpMessage == null) {
            return "{}";
        }
        
        try {
            // ⚠️ IMPORTANTE: LinkedHashMap preserva ordine inserimento
            // getDeclaredFields() ritorna campi nell'ordine di dichiarazione
            // Quindi: ordine classe Java = ordine JSON = ordine colonne frontend
            Map<String, Object> result = new LinkedHashMap<>();
            Class<?> clazz = smpMessage.getClass();
            
            // Aggiungi tipo classe come "_type" (usato per identificare messaggi)
            result.put("_type", clazz.getSimpleName());
            
            // STEP 1: Itera su tutti i campi dichiarati nella classe Java
            // (reflection mantiene l'ordine di dichiarazione nel codice sorgente)
            for (Field field : clazz.getDeclaredFields()) {
                // Skip synthetic fields and internal fields
                if (field.isSynthetic() || 
                    field.getName().startsWith("this$") ||
                    field.getName().equals("Class") ||
                    field.getName().equals("ClassName") ||
                    field.getName().equals("cLASS_ID") ||
                    field.getName().equals("classid") ||
                    field.getName().equals("SMPClassId")) {
                    continue;
                }
                
                try {
                    field.setAccessible(true);
                    Object value = field.get(smpMessage);
                    
                    if (value != null) {
                        // Normalize field name to camelCase (lowercase first letter)
                        String fieldName = normalizeFieldName(field.getName());
                        result.put(fieldName, serializeValue(value));
                    }
                } catch (Exception e) {
                    log.debug("Cannot access field {}: {}", field.getName(), e.getMessage());
                }
            }
            
            // Also try getters
            for (Method method : clazz.getMethods()) {
                if (isGetter(method)) {
                    try {
                        String fieldName = getFieldNameFromGetter(method.getName());
                        if (!result.containsKey(fieldName)) {
                            Object value = method.invoke(smpMessage);
                            if (value != null) {
                                result.put(fieldName, serializeValue(value));
                            }
                        }
                    } catch (Exception e) {
                        log.debug("Cannot invoke getter {}: {}", method.getName(), e.getMessage());
                    }
                }
            }
            
            return objectMapper.writeValueAsString(result);
            
        } catch (Exception e) {
            log.error("Failed to serialize SMP message", e);
            return "{\"error\": \"Serialization failed: " + e.getMessage() + "\"}";
        }
    }
    
    /**
     * Serializza un valore (gestisce tipi primitivi, oggetti complessi, array)
     * 
     * STRATEGIA DI SERIALIZZAZIONE:
     * 1. Primitivi (int, double, String) → passa direttamente
     * 2. Enum → toString()
     * 3. Array → serializza ricorsivamente ogni elemento
     * 4. ULong e wrapper SDP → chiama getValue() per estrarre valore nativo
     * 5. Oggetti nested (com.mtsmarkets.*) → ricorsione con LinkedHashMap
     * 6. Altri oggetti → toString() come fallback
     * 
     * @param value Valore da serializzare
     * @return Valore serializzato per Jackson ObjectMapper
     */
    private static Object serializeValue(Object value) {
        if (value == null) {
            return null;
        }
        
        Class<?> type = value.getClass();
        
        // CASO 1: Tipi primitivi e wrapper standard
        // Questi valori possono essere passati direttamente a Jackson
        if (type.isPrimitive() || 
            value instanceof String ||
            value instanceof Number ||
            value instanceof Boolean) {
            return value;
        }
        
        // CASO 2: Enum → converti a stringa
        if (type.isEnum()) {
            return value.toString();
        }
        
        // CASO 3: Array → serializza ricorsivamente ogni elemento
        if (type.isArray()) {
            int length = Array.getLength(value);
            Object[] array = new Object[length];
            for (int i = 0; i < length; i++) {
                array[i] = serializeValue(Array.get(value, i));  // 🔁 Ricorsione
            }
            return array;
        }
        
        // CASO 4: Tipi SDP speciali (ULong, UInt, etc.)
        // Questi hanno un metodo getValue() che ritorna il valore primitivo
        // Es: ULong.getValue() → long
        try {
            Method getValueMethod = type.getMethod("getValue");
            return getValueMethod.invoke(value);
        } catch (NoSuchMethodException e) {
            // Nessun metodo getValue, procedi con altri casi
        } catch (Exception e) {
            log.debug("Error calling getValue(): {}", e.getMessage());
        }
        
        // CASO 5: Oggetti nested del dominio MTS
        // Serializza ricorsivamente con stessa strategia (LinkedHashMap + reflection)
        if (type.getName().startsWith("com.mtsmarkets") || 
            type.getName().startsWith("com.mts")) {
            
            // ⚠️ Usa LinkedHashMap anche per nested (preserva ordine)
            Map<String, Object> nested = new LinkedHashMap<>();
            nested.put("_type", type.getSimpleName());
            
            // Stessa logica del metodo toJson() - reflection sui field
            for (Field field : type.getDeclaredFields()) {
                // Applica stessi filtri campi interni
                if (field.isSynthetic() || 
                    field.getName().startsWith("this$") ||
                    field.getName().equals("Class") ||
                    field.getName().equals("ClassName") ||
                    field.getName().equals("cLASS_ID") ||
                    field.getName().equals("classid") ||
                    field.getName().equals("SMPClassId")) {
                    continue;
                }
                try {
                    field.setAccessible(true);
                    Object fieldValue = field.get(value);
                    if (fieldValue != null) {
                        // Stessa normalizzazione camelCase
                        String fieldName = normalizeFieldName(field.getName());
                        nested.put(fieldName, serializeValue(fieldValue));  // 🔁 Ricorsione
                    }
                } catch (Exception e) {
                    log.debug("Cannot access nested field {}: {}", field.getName(), e.getMessage());
                }
            }
            
            return nested;
        }
        
        // CASO 6: Fallback per oggetti unknown
        // Se non rientra in nessuna categoria, converti a stringa
        return value.toString();
    }
    
    /**
     * Check if method is a getter
     */
    private static boolean isGetter(Method method) {
        if (!method.getName().startsWith("get") && !method.getName().startsWith("is")) {
            return false;
        }
        if (method.getParameterCount() != 0) {
            return false;
        }
        if (void.class.equals(method.getReturnType())) {
            return false;
        }
        return true;
    }
    
    /**
     * Extract field name from getter method name
     */
    private static String getFieldNameFromGetter(String methodName) {
        String name = methodName.startsWith("is") 
            ? methodName.substring(2) 
            : methodName.substring(3);
        return Character.toLowerCase(name.charAt(0)) + name.substring(1);
    }
    
    /**
     * Normalize field name to camelCase (lowercase first letter)
     */
    private static String normalizeFieldName(String fieldName) {
        if (fieldName == null || fieldName.isEmpty()) {
            return fieldName;
        }
        return Character.toLowerCase(fieldName.charAt(0)) + fieldName.substring(1);
    }
}
