package com.mtsmarkets.sdp.sap;

import com.mtsmarkets.io.xdr.ULong;
import com.mtsmarkets.io.xdr.XDRByteBuffer;


public class SAPLogoffRes extends SAPMessage
{
	public static final int  MSG_TYPE = 204;

	public enum Result
	{
		LogoffOK(0),
		LogoffBad(1);
		Result(int value){}
	}
	
	private ULong reqId = new ULong(0);
	private Result result = Result.LogoffOK;
	private String userName = "";
	
	public SAPLogoffRes(SAPHeader sapHeader)
	{
		super(sapHeader);	
	}

	@Override
	public void readBodyXDR(XDRByteBuffer byteBuff) throws Exception
	{
		reqId.setValue(byteBuff.readInt());
		result = Result.values()[byteBuff.readInt()];
		userName = byteBuff.readString();
	}

	@Override
	public int writeXDR(XDRByteBuffer byteBuff) throws Exception
	{
		throw new Exception("SAPLogoffRes can only read from client side");
	}

	@Override
	public String toString()
	{
		StringBuilder strBd = new StringBuilder()
		.append("SAPLogoffRes::")
		.append("MsgType(").append(getMessageType()).append(")")
		.append("ReqID(").append(reqId.getValue()).append(")")
		.append("Result(").append(result).append(")")
		.append("UserName(").append(userName).append(")");
		return strBd.toString();
	}

	public void setReqId(ULong reqId)
	{
		this.reqId = reqId;
	}

	public ULong getReqId()
	{
		return reqId;
	}

	public void setResult(Result result)
	{
		this.result = result;
	}

	public Result getResult()
	{
		return result;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getUserName()
	{
		return userName;
	}
}

