/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mtsmarkets.sdp.smp;

import com.mtsmarkets.io.xdr.ULong;


public interface TI_DESC_CLASS_Itf {

    long getClassId();
    String getSourceName();
    void setSourceName(String value);
    String getEntityName();
    void setEntityName(String value);
    ULong getEntityID();
    void setEntityID(ULong value);
    TI_DESC_ENTITY_TYPE_Enum getEntityType();
    void setEntityType(TI_DESC_ENTITY_TYPE_Enum value);
    ULong getClassIndx();
    void setClassIndx(ULong value);
    ULong getESize();
    void setESize(ULong value);
    ULong getNumFields();
    void setNumFields(ULong value);
    ULong getNumKeys();
    void setNumKeys(ULong value);
    ULong getUAccess();
    void setUAccess(ULong value);

}
