package com.mtsmarkets.sdp.sap;


import com.mtsmarkets.io.xdr.ULong;
import com.mtsmarkets.io.xdr.XDRByteBuffer;


public class SAPAddressServiceReqExt extends SAPMessage
{
	public static final int  MSG_TYPE = 252;
	
	private ULong reqId = new ULong(0);

	
	public SAPAddressServiceReqExt(SAPHeader sapHeader)
	{
		super(sapHeader);
	}

	public SAPAddressServiceReqExt()
	{
		super(new SAPHeader(MSG_TYPE));
	}

	@Override
	public void readBodyXDR(XDRByteBuffer byteBuff) throws Exception
	{
		reqId.setValue(byteBuff.readInt());
	}

	@Override
	public int writeXDR(XDRByteBuffer byteBuff) throws Exception

	{
		int init = byteBuff.getByteBuff().position();
		// header pdu
		sapHeader.writeXDR(byteBuff);
		// body pdu
		byteBuff.writeInt((int) reqId.getValue());
		
		return byteBuff.getByteBuff().position() - init;
	}

	@Override
	public String toString()
	{
		StringBuilder str = new StringBuilder()
		.append("SAPAddressServiceReqExt::")
		.append("MsgType(").append(getMessageType()).append(")")
		.append("ReqID(").append(reqId.getValue()).append(")");
		return str.toString();
	}

	public void setReqId(ULong reqId)
	{
		this.reqId = reqId;
	}

	public ULong getReqId()
	{
		return reqId;
	}

}

