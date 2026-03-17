package com.mts.gateway.smp.factory;

import com.mts.gateway.smp.SmpJsonMapper;
import com.mtsmarkets.sdp.smp.SMPMessage;
import com.mts.gateway.util.SMPMessageSerializer;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * BVF adapter that attempts to use BVF_Factory at runtime via reflection.
 * If the BVF classes are not present on classpath, it falls back to returning
 * the raw JSON map or throws at runtime when called for missing market.
 */
@Component
public class BvfFactoryAdapter implements SmpJsonMapper {

    private final Object factoryInstance;
    private final Method createSmpMethod;
    private final Constructor<?> uLongCtor;

    public BvfFactoryAdapter() {
        Object tmpFactory = null;
        Method tmpMethod = null;
        Constructor<?> tmpULong = null;
        try {
            Class<?> facClass = Class.forName("com.mtsmarkets.sdp.smp.bvf.BVF_Factory");
            tmpFactory = facClass.getDeclaredConstructor().newInstance();
            Class<?> uLongClass = Class.forName("com.mtsmarkets.io.xdr.ULong");
            tmpMethod = facClass.getMethod("createSMPMessage", uLongClass);
            tmpULong = uLongClass.getConstructor(long.class);
        } catch (ClassNotFoundException e) {
            // BVF library not on classpath; will fall back
        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize BVF adapter", e);
        }
        this.factoryInstance = tmpFactory;
        this.createSmpMethod = tmpMethod;
        this.uLongCtor = tmpULong;
    }

    @Override
    public Object fromJson(Map<String, Object> json, long classId) {
        try {
            if (createSmpMethod == null || factoryInstance == null || uLongCtor == null) {
                // Factory not available; return the raw map so upper layers can handle or fail gracefully
                return json;
            }
            Object u = uLongCtor.newInstance(classId);
            Object smp = createSmpMethod.invoke(factoryInstance, u);
            if (json == null || json.isEmpty()) return smp;
            populateObject(smp, json);
            return smp;
        } catch (RuntimeException re) {
            throw re;
        } catch (Exception e) {
            throw new RuntimeException("Failed to create SMP message for classId=" + classId, e);
        }
    }

    @Override
    public Map<String, Object> toJson(Object smpObject) {
        String json = SMPMessageSerializer.toJson(smpObject);
        try {
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            return mapper.readValue(json, LinkedHashMap.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to serialize SMP object to JSON map", e);
        }
    }

    private void populateObject(Object target, Map<String, Object> values) {
        Class<?> clazz = target.getClass();

        for (Field field : clazz.getDeclaredFields()) {
            String name = field.getName();
            String jsonKey = Character.toLowerCase(name.charAt(0)) + name.substring(1);
            if (!values.containsKey(jsonKey)) continue;
            Object value = values.get(jsonKey);
            try {
                String setterName = "set" + Character.toUpperCase(name.charAt(0)) + name.substring(1);
                Method setter = null;
                for (Method m : clazz.getMethods()) {
                    if (m.getName().equals(setterName) && m.getParameterCount() == 1) {
                        setter = m; break;
                    }
                }
                if (setter != null) {
                    Object converted = convertValue(value, setter.getParameterTypes()[0]);
                    setter.invoke(target, converted);
                } else {
                    field.setAccessible(true);
                    Object converted = convertValue(value, field.getType());
                    field.set(target, converted);
                }
            } catch (Exception e) {
                System.err.println("Failed to set field " + name + " on " + clazz.getSimpleName() + ": " + e.getMessage());
            }
        }
    }

    private Object convertValue(Object value, Class<?> targetType) throws Exception {
        if (value == null) return null;
        if (targetType.isInstance(value)) return value;
        if (targetType == String.class) return value.toString();
        if (Number.class.isAssignableFrom(targetType) || targetType.isPrimitive()) {
            if (value instanceof Number) {
                Number n = (Number) value;
                if (targetType == Integer.class || targetType == int.class) return n.intValue();
                if (targetType == Long.class || targetType == long.class) return n.longValue();
                if (targetType == Double.class || targetType == double.class) return n.doubleValue();
                if (targetType == Float.class || targetType == float.class) return n.floatValue();
            }
            String s = value.toString();
            if (targetType == Integer.class || targetType == int.class) return Integer.parseInt(s);
            if (targetType == Long.class || targetType == long.class) return Long.parseLong(s);
            if (targetType == Double.class || targetType == double.class) return Double.parseDouble(s);
            if (targetType == Float.class || targetType == float.class) return Float.parseFloat(s);
        }

        if (targetType.getName().equals("com.mtsmarkets.io.xdr.ULong")) {
            long v = Long.parseLong(value.toString());
            // construct via reflection
            Class<?> uClass = Class.forName("com.mtsmarkets.io.xdr.ULong");
            return uClass.getConstructor(long.class).newInstance(v);
        }

        if (com.mtsmarkets.sdp.smp.SMPMessage.class.isAssignableFrom(targetType)
                || targetType.getName().startsWith("com.mtsmarkets")) {
            if (value instanceof Map) {
                Object nested = targetType.getDeclaredConstructor().newInstance();
                populateObject(nested, (Map<String, Object>) value);
                return nested;
            }
        }

        com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
        return mapper.convertValue(value, targetType);
    }
}
