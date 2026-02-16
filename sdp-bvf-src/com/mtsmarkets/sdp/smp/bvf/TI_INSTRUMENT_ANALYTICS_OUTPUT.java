package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_INSTRUMENT_ANALYTICS_OUTPUT extends SMPMessage
{
	public static final long CLASS_ID = 100906;

	private long YieldType = 0;
	private double Yield = 0;
	private TI_FLAG_Enum YieldCalculatedFg = TI_FLAG_Enum.TI_FLAG_No;

	public TI_INSTRUMENT_ANALYTICS_OUTPUT()
	{
	}

	public long getYieldType()
	{
		return YieldType;
	}
	public void setYieldType(long value)
	{
		YieldType = value;
	}
	public double getYield()
	{
		return Yield;
	}
	public void setYield(double value)
	{
		Yield = value;
	}
	public TI_FLAG_Enum getYieldCalculatedFg()
	{
		return YieldCalculatedFg;
	}
	public void setYieldCalculatedFg(TI_FLAG_Enum value)
	{
		YieldCalculatedFg = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		YieldType = (long)byteBuffer.readInt();
		Yield = byteBuffer.readDouble();
		YieldCalculatedFg = YieldCalculatedFg.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(YieldType & 0xFFFFFFFFL));
		byteBuffer.writeDouble(Yield);
		byteBuffer.writeInt(YieldCalculatedFg.getValue());

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
		stringBuilder.append("TI_INSTRUMENT_ANALYTICS_OUTPUT::");
		stringBuilder.append("YieldType(").append(YieldType).append(")");
		stringBuilder.append("Yield(").append(Yield).append(")");
		stringBuilder.append("YieldCalculatedFg(").append(YieldCalculatedFg).append(")");
		return stringBuilder.toString();
	}
}
