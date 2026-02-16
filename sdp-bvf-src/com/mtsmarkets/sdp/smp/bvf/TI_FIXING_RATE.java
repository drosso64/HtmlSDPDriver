package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_FIXING_RATE extends SMPMessage
{
	public static final long CLASS_ID = 100031;

	private long FinancialInstrumentId = 0;
	private long UpdateDate = 0;
	private long UpdateTime = 0;
	private long ReferenceDate = 0;
	private double FixingRate = 0;

	public TI_FIXING_RATE()
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
	public long getReferenceDate()
	{
		return ReferenceDate;
	}
	public void setReferenceDate(long value)
	{
		ReferenceDate = value;
	}
	public double getFixingRate()
	{
		return FixingRate;
	}
	public void setFixingRate(double value)
	{
		FixingRate = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		FinancialInstrumentId = (long)byteBuffer.readInt();
		UpdateDate = (long)byteBuffer.readInt();
		UpdateTime = byteBuffer.readLong();
		ReferenceDate = (long)byteBuffer.readInt();
		FixingRate = byteBuffer.readDouble();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(FinancialInstrumentId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(UpdateDate & 0xFFFFFFFFL));
		byteBuffer.writeLong(UpdateTime);
		byteBuffer.writeInt((int)(ReferenceDate & 0xFFFFFFFFL));
		byteBuffer.writeDouble(FixingRate);

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
		stringBuilder.append("TI_FIXING_RATE::");
		stringBuilder.append("FinancialInstrumentId(").append(FinancialInstrumentId).append(")");
		stringBuilder.append("UpdateDate(").append(UpdateDate).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		stringBuilder.append("ReferenceDate(").append(ReferenceDate).append(")");
		stringBuilder.append("FixingRate(").append(FixingRate).append(")");
		return stringBuilder.toString();
	}
}
