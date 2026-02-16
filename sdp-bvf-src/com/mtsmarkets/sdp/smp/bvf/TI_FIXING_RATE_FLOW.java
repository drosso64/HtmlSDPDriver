package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_FIXING_RATE_FLOW extends SMPMessage
{
	public static final long CLASS_ID = 100821;

	private long FinancialInstrumentId = 0;
	private double FixingRate = 0;
	private long ReferenceDate = 0;
	private long UpdateDate = 0;
	private long UpdateTime = 0;

	public TI_FIXING_RATE_FLOW()
	{
	}

	public long getFinancialInstrumentId()
	{
		return FinancialInstrumentId;
	}
	public void setFinancialInstrumentId(long value)
	{
		FinancialInstrumentId = value;
	}
	public double getFixingRate()
	{
		return FixingRate;
	}
	public void setFixingRate(double value)
	{
		FixingRate = value;
	}
	public long getReferenceDate()
	{
		return ReferenceDate;
	}
	public void setReferenceDate(long value)
	{
		ReferenceDate = value;
	}
	public long getUpdateDate()
	{
		return UpdateDate;
	}
	public void setUpdateDate(long value)
	{
		UpdateDate = value;
	}
	public long getUpdateTime()
	{
		return UpdateTime;
	}
	public void setUpdateTime(long value)
	{
		UpdateTime = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		FinancialInstrumentId = (long)byteBuffer.readInt();
		FixingRate = byteBuffer.readDouble();
		ReferenceDate = (long)byteBuffer.readInt();
		UpdateDate = (long)byteBuffer.readInt();
		UpdateTime = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(FinancialInstrumentId & 0xFFFFFFFFL));
		byteBuffer.writeDouble(FixingRate);
		byteBuffer.writeInt((int)(ReferenceDate & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(UpdateDate & 0xFFFFFFFFL));
		byteBuffer.writeLong(UpdateTime);

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
		stringBuilder.append("TI_FIXING_RATE_FLOW::");
		stringBuilder.append("FinancialInstrumentId(").append(FinancialInstrumentId).append(")");
		stringBuilder.append("FixingRate(").append(FixingRate).append(")");
		stringBuilder.append("ReferenceDate(").append(ReferenceDate).append(")");
		stringBuilder.append("UpdateDate(").append(UpdateDate).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		return stringBuilder.toString();
	}
}
