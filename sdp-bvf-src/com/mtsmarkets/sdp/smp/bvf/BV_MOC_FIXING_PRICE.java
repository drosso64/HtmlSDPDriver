package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_MOC_FIXING_PRICE extends SMPMessage
{
	public static final long CLASS_ID = 400101;

	private long MemberId = 0;
	private long TraderId = 0;
	private String TraderName = "";
	private long FinancialInstrumentId = 0;
	private double ContributedValue = 0;
	private String UserInfo = "";
	private long CreationDate = 0;
	private long CreationTime = 0;

	public BV_MOC_FIXING_PRICE()
	{
	}

	public long getMemberId()
	{
		return MemberId;
	}
	public void setMemberId(long value)
	{
		MemberId = value;
	}
	public long getTraderId()
	{
		return TraderId;
	}
	public void setTraderId(long value)
	{
		TraderId = value;
	}
	public String getTraderName()
	{
		return TraderName;
	}
	public void setTraderName(String value)
	{
		TraderName = value;
	}
	public long getFinancialInstrumentId()
	{
		return FinancialInstrumentId;
	}
	public void setFinancialInstrumentId(long value)
	{
		FinancialInstrumentId = value;
	}
	public double getContributedValue()
	{
		return ContributedValue;
	}
	public void setContributedValue(double value)
	{
		ContributedValue = value;
	}
	public String getUserInfo()
	{
		return UserInfo;
	}
	public void setUserInfo(String value)
	{
		UserInfo = value;
	}
	public long getCreationDate()
	{
		return CreationDate;
	}
	public void setCreationDate(long value)
	{
		CreationDate = value;
	}
	public long getCreationTime()
	{
		return CreationTime;
	}
	public void setCreationTime(long value)
	{
		CreationTime = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MemberId = (long)byteBuffer.readInt();
		TraderId = (long)byteBuffer.readInt();
		TraderName = byteBuffer.readString();
		FinancialInstrumentId = (long)byteBuffer.readInt();
		ContributedValue = byteBuffer.readDouble();
		UserInfo = byteBuffer.readString();
		CreationDate = (long)byteBuffer.readInt();
		CreationTime = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(TraderId & 0xFFFFFFFFL));
		byteBuffer.writeString(TraderName);
		byteBuffer.writeInt((int)(FinancialInstrumentId & 0xFFFFFFFFL));
		byteBuffer.writeDouble(ContributedValue);
		byteBuffer.writeString(UserInfo);
		byteBuffer.writeInt((int)(CreationDate & 0xFFFFFFFFL));
		byteBuffer.writeLong(CreationTime);

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
		stringBuilder.append("BV_MOC_FIXING_PRICE::");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("TraderId(").append(TraderId).append(")");
		stringBuilder.append("TraderName(").append(TraderName).append(")");
		stringBuilder.append("FinancialInstrumentId(").append(FinancialInstrumentId).append(")");
		stringBuilder.append("ContributedValue(").append(ContributedValue).append(")");
		stringBuilder.append("UserInfo(").append(UserInfo).append(")");
		stringBuilder.append("CreationDate(").append(CreationDate).append(")");
		stringBuilder.append("CreationTime(").append(CreationTime).append(")");
		return stringBuilder.toString();
	}
}
