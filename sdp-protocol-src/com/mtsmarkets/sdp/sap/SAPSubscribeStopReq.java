package com.mtsmarkets.sdp.sap;

import com.mtsmarkets.io.xdr.ULong;
import com.mtsmarkets.io.xdr.XDRByteBuffer;

public class SAPSubscribeStopReq extends SAPMessage
{
	public static final int MSG_TYPE = 222;
	
	protected ULong reqId = new ULong(0);
	protected ULong subscribeKey = new ULong(0);

	public SAPSubscribeStopReq()
	{
		super(new SAPHeader(MSG_TYPE));
	}
	
	public SAPSubscribeStopReq(SAPHeader sapHeader)
	{
		super(sapHeader);
	}

	public ULong getReqId()
	{
		return reqId;
	}

	public void setReqId(ULong reqId)
	{
		this.reqId = reqId;
	}

	public ULong getSubscribeKey()
	{
		return subscribeKey;
	}

	public void setSubscribeKey(ULong subscribeKey)
	{
		this.subscribeKey = subscribeKey;
	}



	@Override
	public void readBodyXDR(XDRByteBuffer byteBuff) throws Exception
	{
		reqId.setValue(byteBuff.readInt());
		subscribeKey.setValue(byteBuff.readInt());
	}

	@Override
	public int writeXDR(XDRByteBuffer byteBuff) throws Exception
	{
		int init = byteBuff.getByteBuff().position();
		
		// header pdu
		sapHeader.writeXDR(byteBuff);
		// body pdu
		byteBuff.writeInt((int) reqId.getValue());
		byteBuff.writeInt((int) subscribeKey.getValue());
		
		return byteBuff.getByteBuff().position() - init;
	}

	@Override
	public String toString()
	{
		StringBuilder str = new StringBuilder()
			.append("SAPSubscribeStopReq::")
			.append("MsgType(").append(getMessageType()).append(")")
			.append("ReqID(").append(reqId.getValue()).append(")")
			.append("SubscribeKey(").append(subscribeKey.getValue()).append(")");
		return str.toString();
	}
}

