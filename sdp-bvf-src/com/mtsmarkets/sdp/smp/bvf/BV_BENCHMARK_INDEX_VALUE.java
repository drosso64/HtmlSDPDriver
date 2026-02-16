package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_BENCHMARK_INDEX_VALUE extends SMPMessage
{
	public static final long CLASS_ID = 400010;

	private long BenchmarkIndexId = 0;
	private double CurrentValue = 0;
	private long ReferenceDate = 0;
	private long UpdateDate = 0;
	private long UpdateTime = 0;

	public BV_BENCHMARK_INDEX_VALUE()
	{
	}

	public long getBenchmarkIndexId()
	{
		return BenchmarkIndexId;
	}
	public void setBenchmarkIndexId(long value)
	{
		BenchmarkIndexId = value;
	}
	public double getCurrentValue()
	{
		return CurrentValue;
	}
	public void setCurrentValue(double value)
	{
		CurrentValue = value;
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
		BenchmarkIndexId = (long)byteBuffer.readInt();
		CurrentValue = byteBuffer.readDouble();
		ReferenceDate = (long)byteBuffer.readInt();
		UpdateDate = (long)byteBuffer.readInt();
		UpdateTime = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(BenchmarkIndexId & 0xFFFFFFFFL));
		byteBuffer.writeDouble(CurrentValue);
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
		stringBuilder.append("BV_BENCHMARK_INDEX_VALUE::");
		stringBuilder.append("BenchmarkIndexId(").append(BenchmarkIndexId).append(")");
		stringBuilder.append("CurrentValue(").append(CurrentValue).append(")");
		stringBuilder.append("ReferenceDate(").append(ReferenceDate).append(")");
		stringBuilder.append("UpdateDate(").append(UpdateDate).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		return stringBuilder.toString();
	}
}
