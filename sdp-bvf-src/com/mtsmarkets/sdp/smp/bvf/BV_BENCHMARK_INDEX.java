package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_BENCHMARK_INDEX extends SMPMessage
{
	public static final long CLASS_ID = 400009;

	private long BenchmarkIndexId = 0;
	private String BenchmarkCode = "";
	private String BenchmarkIndexName = "";
	private short BenchmarkTerm = 0;
	private TI_PERIOD_Enum BenchmarkTermUnit = TI_PERIOD_Enum.TI_PERIOD_Day;

	public BV_BENCHMARK_INDEX()
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
	public String getBenchmarkCode()
	{
		return BenchmarkCode;
	}
	public void setBenchmarkCode(String value)
	{
		BenchmarkCode = value;
	}
	public String getBenchmarkIndexName()
	{
		return BenchmarkIndexName;
	}
	public void setBenchmarkIndexName(String value)
	{
		BenchmarkIndexName = value;
	}
	public short getBenchmarkTerm()
	{
		return BenchmarkTerm;
	}
	public void setBenchmarkTerm(short value)
	{
		BenchmarkTerm = value;
	}
	public TI_PERIOD_Enum getBenchmarkTermUnit()
	{
		return BenchmarkTermUnit;
	}
	public void setBenchmarkTermUnit(TI_PERIOD_Enum value)
	{
		BenchmarkTermUnit = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		BenchmarkIndexId = (long)byteBuffer.readInt();
		BenchmarkCode = byteBuffer.readString();
		BenchmarkIndexName = byteBuffer.readString();
		BenchmarkTerm = (short)byteBuffer.readInt();
		BenchmarkTermUnit = BenchmarkTermUnit.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(BenchmarkIndexId & 0xFFFFFFFFL));
		byteBuffer.writeString(BenchmarkCode);
		byteBuffer.writeString(BenchmarkIndexName);
		byteBuffer.writeInt((int)(BenchmarkTerm & 0xFFFFL));
		byteBuffer.writeInt(BenchmarkTermUnit.getValue());

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
		stringBuilder.append("BV_BENCHMARK_INDEX::");
		stringBuilder.append("BenchmarkIndexId(").append(BenchmarkIndexId).append(")");
		stringBuilder.append("BenchmarkCode(").append(BenchmarkCode).append(")");
		stringBuilder.append("BenchmarkIndexName(").append(BenchmarkIndexName).append(")");
		stringBuilder.append("BenchmarkTerm(").append(BenchmarkTerm).append(")");
		stringBuilder.append("BenchmarkTermUnit(").append(BenchmarkTermUnit).append(")");
		return stringBuilder.toString();
	}
}
