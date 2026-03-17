/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mtsmarkets.sdp.smp;

import com.mtsmarkets.io.xdr.ULong;


public interface TI_DESC_CLASS_KEY_Itf {

    ULong getEntityID();
    void setEntityID(ULong value);
    ULong getKeyID();
    void setKeyID(ULong value);
    ULong getKeyIndx();
    void setKeyIndx(ULong value);
    String getKeyName();
    void setKeyName(String value);
    ULong getKeySize();
    void setKeySize(ULong value);
    TI_DESC_KEY_TYPE_Enum getKeyType();
    void setKeyType(TI_DESC_KEY_TYPE_Enum value);
    ULong getNumSegs();
    void setNumSegs(ULong value);

}
