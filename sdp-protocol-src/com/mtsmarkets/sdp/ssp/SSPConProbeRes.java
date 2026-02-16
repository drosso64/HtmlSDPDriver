/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mtsmarkets.sdp.ssp;

import com.mtsmarkets.io.xdr.ULong;
import com.mtsmarkets.io.xdr.XDRByteBuffer;

public class SSPConProbeRes extends SSPMessage {
    
    public static final int PDU_ID = 109;
    
    ULong  probeData = new ULong(0);
    
    public SSPConProbeRes()
	{
		super(new SSPHeader(PDU_ID, 0));
	}

	public SSPConProbeRes(SSPHeader sspHeader)
	{
		super(sspHeader);
	}

    public ULong getProbeData() {
        return probeData;
    }

    public void setProbeData(ULong probeData) {
        this.probeData = probeData;
    } 

    @Override
    public int writeBodyXDR(XDRByteBuffer byteBuff) throws Exception {
        // body pdu
		int init = byteBuff.position();

		byteBuff.writeInt((int) probeData.getValue());

		int sizeBody = (byteBuff.position() - init);
		this.sspHeader.setPduLen(sizeBody);
		return sizeBody;
    }

    @Override
    public void readXDR(XDRByteBuffer byteBuff) throws Exception {
        sspHeader.readXDR(byteBuff);
		readBodyXDR(byteBuff);
    }

    @Override
    public void readBodyXDR(XDRByteBuffer byteBuff) throws Exception {
        probeData.setValue(byteBuff.readInt());
    }
    
    @Override
	public String toString()
	{
		StringBuilder stringBuilder = new StringBuilder(64)
		.append("SSPConProbeRes::")
		.append(sspHeader.toString())
		.append("ProbeData(").append(probeData).append(")");
		return stringBuilder.toString();
	}
    
}
