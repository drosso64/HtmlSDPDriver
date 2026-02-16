package com.mtsmarkets.sdp.sap;

import com.mtsmarkets.io.xdr.ULong;
import com.mtsmarkets.io.xdr.XDRByteBuffer;

public class SAPSubscribeStopRes extends SAPMessage
{
	public static final int  MSG_TYPE = 223;

	public enum Result
	{
		SapSubscribeOK(0),
		SapSubscribeBad(1);
		Result(int value)
		{
		}
	}
	
	protected ULong reqID = new ULong(0);
	protected Result result = Result.SapSubscribeOK;
	protected ULong  subscribeKey = new ULong(0);

	public SAPSubscribeStopRes(SAPHeader sapHeader)
	{
		super(sapHeader);
	}
	
	public ULong getReqID()
	{
		return reqID;
	}
	
	public void setReqID(ULong reqID)
	{
		this.reqID = reqID;
	}
	
	public Result getResult() {
		return result;
	}
	
	public void setResult(Result result) {
		this.result = result;
	}
	
	public ULong getSubscribeKey() {
		return subscribeKey;
	}
	
	public void setSubscribeKey(ULong subscribeKey) {
		this.subscribeKey = subscribeKey;
	}

	@Override
	public void readBodyXDR(XDRByteBuffer byteBuff) throws Exception
	{
		reqID.setValue(byteBuff.readInt());
		result = Result.values()[byteBuff.readInt()];
		subscribeKey.setValue(byteBuff.readInt());
	}
	
	@Override
	public int writeXDR(XDRByteBuffer byteBuff) throws Exception {
		throw new Exception("SAPSubscribeStopRes can be only read from client side");
	}
	
	@Override
	public String toString()
	{
		StringBuilder stringBuilder = new StringBuilder()
			.append("SAPSubscribeStopRes::")
			.append("MsgType(").append(getMessageType()).append(")")
			.append("ReqID(").append(reqID.getValue()).append(")")		
			.append("Result(").append(result).append(")")
			.append("SubscribeKey(").append(subscribeKey.getValue()).append(")");
		return stringBuilder.toString();
	}
}

