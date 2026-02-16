package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_CREDIT_LINE_ECL extends SMPMessage
{
	public static final long CLASS_ID = 100043;

	private long MarketId = 0;
	private long FirstMemberId = 0;
	private long SecondMemberId = 0;
	private String UserData = "";

	public TI_CREDIT_LINE_ECL()
	{
	}

	public long getMarketId()
	{
		return MarketId;
	}
	public void setMarketId(long value)
	{
		MarketId = value;
	}
	public long getFirstMemberId()
	{
		return FirstMemberId;
	}
	public void setFirstMemberId(long value)
	{
		FirstMemberId = value;
	}
	public long getSecondMemberId()
	{
		return SecondMemberId;
	}
	public void setSecondMemberId(long value)
	{
		SecondMemberId = value;
	}
	public String getUserData()
	{
		return UserData;
	}
	public void setUserData(String value)
	{
		UserData = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MarketId = (long)byteBuffer.readInt();
		FirstMemberId = (long)byteBuffer.readInt();
		SecondMemberId = (long)byteBuffer.readInt();
		UserData = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MarketId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(FirstMemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SecondMemberId & 0xFFFFFFFFL));
		byteBuffer.writeString(UserData);

		return byteBuffer.position() - init;
	}
	@Override
	public long getSMPClassId()
	{
		return CLASS_ID;
	}
	@Override
	public String toString()
	{
		StringBuilder stringBuilder = new StringBuilder(1024);
		stringBuilder.append("TI_CREDIT_LINE_ECL::");
		stringBuilder.append("MarketId(").append(MarketId).append(")");
		stringBuilder.append("FirstMemberId(").append(FirstMemberId).append(")");
		stringBuilder.append("SecondMemberId(").append(SecondMemberId).append(")");
		stringBuilder.append("UserData(").append(UserData).append(")");
		return stringBuilder.toString();
	}
}
