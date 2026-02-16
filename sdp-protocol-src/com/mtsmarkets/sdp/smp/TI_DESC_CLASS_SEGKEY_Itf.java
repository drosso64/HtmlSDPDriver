/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mtsmarkets.sdp.smp;

import com.mtsmarkets.io.xdr.ULong;


public interface TI_DESC_CLASS_SEGKEY_Itf {

    ULong getEntityID();
    void setEntityID(ULong value);
    ULong getKeyID();
    void setKeyID(ULong value);
    ULong getKeyIndex();
    void setKeyIndex(ULong value);
    ULong getKeyOffset();
    void setKeyOffset(ULong value);
    ULong getKeyType();
    void setKeyType(ULong value);
    ULong getKeyLen();
    void setKeyLen(ULong value);
}
