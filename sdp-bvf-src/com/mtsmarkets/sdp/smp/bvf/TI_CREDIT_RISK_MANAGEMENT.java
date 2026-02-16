package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_CREDIT_RISK_MANAGEMENT extends SMPMessage
{
	public static final long CLASS_ID = 100023;

	private long MarketId = 0;
	private long InstrumentClassId = 0;
	private long FirstMemberId = 0;
	private long SecondMemberId = 0;
	private TI_CREDIT_PROFILE_Enum CreditProfile = TI_CREDIT_PROFILE_Enum.TI_CREDIT_PROFILE_Welcome;
	private String UserData = "";

	public TI_CREDIT_RISK_MANAGEMENT()
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
	public long getInstrumentClassId()
	{
		return InstrumentClassId;
	}
	public void setInstrumentClassId(long value)
	{
		InstrumentClassId = value;
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
	public TI_CREDIT_PROFILE_Enum getCreditProfile()
	{
		return CreditProfile;
	}
	public void setCreditProfile(TI_CREDIT_PROFILE_Enum value)
	{
		CreditProfile = value;
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
		InstrumentClassId = (long)byteBuffer.readInt();
		FirstMemberId = (long)byteBuffer.readInt();
		SecondMemberId = (long)byteBuffer.readInt();
		CreditProfile = CreditProfile.getEnum(byteBuffer.readInt());
		UserData = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MarketId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(InstrumentClassId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(FirstMemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SecondMemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt(CreditProfile.getValue());
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
		stringBuilder.append("TI_CREDIT_RISK_MANAGEMENT::");
		stringBuilder.append("MarketId(").append(MarketId).append(")");
		stringBuilder.append("InstrumentClassId(").append(InstrumentClassId).append(")");
		stringBuilder.append("FirstMemberId(").append(FirstMemberId).append(")");
		stringBuilder.append("SecondMemberId(").append(SecondMemberId).append(")");
		stringBuilder.append("CreditProfile(").append(CreditProfile).append(")");
		stringBuilder.append("UserData(").append(UserData).append(")");
		return stringBuilder.toString();
	}
}
