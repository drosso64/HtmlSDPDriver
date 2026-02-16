package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_ACCRUED_INTEREST_PREVIEW extends SMPMessage
{
	public static final long CLASS_ID = 114290;

	private long AccruedInterestPreviewId = 0;
	private long InstrumentId = 0;
	private short SettlementOffset = 0;
	private long SettlementDate = 0;
	private double AccruedInterest = 0;
	private short AccrualDays = 0;
	private double IndexRatio = 0;
	private String UserData = "";

	public BV_ACCRUED_INTEREST_PREVIEW()
	{
	}

	public long getAccruedInterestPreviewId()
	{
		return AccruedInterestPreviewId;
	}
	public void setAccruedInterestPreviewId(long value)
	{
		AccruedInterestPreviewId = value;
	}
	public long getInstrumentId()
	{
		return InstrumentId;
	}
	public void setInstrumentId(long value)
	{
		InstrumentId = value;
	}
	public short getSettlementOffset()
	{
		return SettlementOffset;
	}
	public void setSettlementOffset(short value)
	{
		SettlementOffset = value;
	}
	public long getSettlementDate()
	{
		return SettlementDate;
	}
	public void setSettlementDate(long value)
	{
		SettlementDate = value;
	}
	public double getAccruedInterest()
	{
		return AccruedInterest;
	}
	public void setAccruedInterest(double value)
	{
		AccruedInterest = value;
	}
	public short getAccrualDays()
	{
		return AccrualDays;
	}
	public void setAccrualDays(short value)
	{
		AccrualDays = value;
	}
	public double getIndexRatio()
	{
		return IndexRatio;
	}
	public void setIndexRatio(double value)
	{
		IndexRatio = value;
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
		AccruedInterestPreviewId = (long)byteBuffer.readInt();
		InstrumentId = (long)byteBuffer.readInt();
		SettlementOffset = (short)byteBuffer.readInt();
		SettlementDate = (long)byteBuffer.readInt();
		AccruedInterest = byteBuffer.readDouble();
		AccrualDays = (short)byteBuffer.readInt();
		IndexRatio = byteBuffer.readDouble();
		UserData = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(AccruedInterestPreviewId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(InstrumentId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SettlementOffset & 0xFFFFL));
		byteBuffer.writeInt((int)(SettlementDate & 0xFFFFFFFFL));
		byteBuffer.writeDouble(AccruedInterest);
		byteBuffer.writeInt((int)(AccrualDays & 0xFFFFL));
		byteBuffer.writeDouble(IndexRatio);
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
		stringBuilder.append("BV_ACCRUED_INTEREST_PREVIEW::");
		stringBuilder.append("AccruedInterestPreviewId(").append(AccruedInterestPreviewId).append(")");
		stringBuilder.append("InstrumentId(").append(InstrumentId).append(")");
		stringBuilder.append("SettlementOffset(").append(SettlementOffset).append(")");
		stringBuilder.append("SettlementDate(").append(SettlementDate).append(")");
		stringBuilder.append("AccruedInterest(").append(AccruedInterest).append(")");
		stringBuilder.append("AccrualDays(").append(AccrualDays).append(")");
		stringBuilder.append("IndexRatio(").append(IndexRatio).append(")");
		stringBuilder.append("UserData(").append(UserData).append(")");
		return stringBuilder.toString();
	}
}
