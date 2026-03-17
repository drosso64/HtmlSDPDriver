package com.mtsmarkets.sdp.ssp;

import com.mtsmarkets.io.xdr.ULong;
import com.mtsmarkets.io.xdr.UShort;
import com.mtsmarkets.io.xdr.XDRByteBuffer;
import com.mtsmarkets.io.xdr.XDRable;


public class SSPHeader implements XDRable {

    private ULong pduId = new ULong(0);
    private ULong pduLen = new ULong(0);
  

    public SSPHeader() {
    }

    public SSPHeader(int pduId, int pduLen) {
        this.pduId.setValue(pduId);
        this.pduLen.setValue(pduLen);
    }

    public SSPHeader(SSPMessage sspMessage) {
        pduId = sspMessage.getPduId();
        pduLen = sspMessage.getPduLen();
    }

    // dimensione dell'header della PDU
    public int size() {
        return 8;
    }

    public int writeXDR(XDRByteBuffer byteBuff) throws Exception {
        int size = byteBuff.position();

        byteBuff.writeInt((int) pduId.getValue());
        byteBuff.writeInt((int) pduLen.getValue());
        size = byteBuff.position() - size;
        return size;
    }

    public void readXDR(XDRByteBuffer byteBuff) throws Exception {
        pduId.setValue(byteBuff.readInt());
        pduLen.setValue(byteBuff.readInt());
    }

    public ULong getPduId() {
        return pduId;
    }

    public void setPduId(ULong pduId) {
        this.pduId = pduId;
    }

    public void setPduId(int pduId) {
        this.pduId.setValue(pduId);
    }

    public ULong getPduLen() {
        return pduLen;
    }

    public void setPduLen(ULong pduLen) {
        this.pduLen = pduLen;
    }

    public void setPduLen(int pduLen) {
        this.pduLen.setValue(pduLen);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder().append("PduID(").append(pduId.getValue()).append(")").append("PduLen(").append(pduLen.getValue()).append(")");
        return str.toString();
    }
}
