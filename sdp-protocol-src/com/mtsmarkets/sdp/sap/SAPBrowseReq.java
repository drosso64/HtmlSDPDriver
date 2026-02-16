package com.mtsmarkets.sdp.sap;

import com.mtsmarkets.io.xdr.ULong;
import com.mtsmarkets.io.xdr.XDRByteBuffer;

public class SAPBrowseReq extends SAPMessage 
{
	public static final int  MSG_TYPE = 260;
	
	private ULong reqId = new ULong(0);
	private ULong classId = new ULong(0);
	private ULong keyId = new ULong(0);
    protected String keyValue = "";

	
	public SAPBrowseReq()
	{
		super(new SAPHeader(MSG_TYPE));
	}
	
	public SAPBrowseReq(SAPHeader sapHeader)
	{
		super(sapHeader);		
	}

	public ULong getReqId() {
		return reqId;
	}

	public void setReqId(ULong reqId) {
		this.reqId = reqId;
	}


	public ULong getClassId() {
		return classId;
	}

	public void setClassId(ULong classId) {
		this.classId = classId;
	}


	public ULong getKeyId() {
		return keyId;
	}

	public void setKeyId(ULong keyId) {
		this.keyId = keyId;
	}

    public String getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
    }

	@Override
	public void readBodyXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		reqId.setValue(byteBuffer.readInt());
		classId.setValue(byteBuffer.readInt());	
		keyId.setValue(byteBuffer.readInt());
        keyValue = byteBuffer.readString();
	}

	@Override
	public int writeXDR(XDRByteBuffer byteBuff) throws Exception
	{
		int init = byteBuff.getByteBuff().position();
		// header pdu
		sapHeader.writeXDR(byteBuff);
		// body pdu
		byteBuff.writeInt((int) reqId.getValue());		
		byteBuff.writeInt((int) classId.getValue());	
		byteBuff.writeInt((int) keyId.getValue());
        byteBuff.writeString(keyValue);
        
		int end = byteBuff.getByteBuff().position();
		return end - init;
	}

	@Override
	public String toString()
	{
		StringBuilder str = new StringBuilder()
			.append("SAPBrowseReq::")
			.append("MsgType(").append(getMessageType()).append(")")
			.append("ReqID(").append(reqId.getValue()).append(")")
			.append("ClassID(").append(classId.getValue()).append(")")
			.append("KeyId(").append(keyId.getValue()).append(")")
            .append("KeyValue(").append(keyValue).append(")");
		return str.toString();
	}
}

