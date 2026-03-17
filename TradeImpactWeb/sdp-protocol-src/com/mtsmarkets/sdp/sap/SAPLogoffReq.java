package com.mtsmarkets.sdp.sap;

import com.mtsmarkets.io.xdr.ULong;
import com.mtsmarkets.io.xdr.XDRByteBuffer;


public class SAPLogoffReq extends SAPMessage
{
	public static final int  MSG_TYPE = 203;

	private ULong reqId = new ULong(0);
	private String userName = "";

	public SAPLogoffReq(SAPHeader sapHeader)
	{
		super(sapHeader);	
	}
	
	public SAPLogoffReq()
	{
		super(new SAPHeader(MSG_TYPE));
	}

	@Override
	public void readBodyXDR(XDRByteBuffer byteBuff) throws Exception
	{
		reqId.setValue(byteBuff.readInt());
		userName = byteBuff.readString();
	}

	@Override
	public int writeXDR(XDRByteBuffer byteBuff) throws Exception
	{
		int init = byteBuff.getByteBuff().position();
		// header pdu
		sapHeader.writeXDR(byteBuff);
		// body pdu
		byteBuff.writeInt((int) reqId.getValue());
		byteBuff.writeString(userName);
		return byteBuff.getByteBuff().position() - init;
	}

	@Override
	public String toString()
	{
		StringBuilder strBd = new StringBuilder()
		.append("SAPLogoffReq::")
		.append("MsgType(").append(getMessageType()).append(")")
		.append("ReqID(").append(reqId.getValue()).append(")")
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

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getUserName()
	{
		return userName;
	}
}

