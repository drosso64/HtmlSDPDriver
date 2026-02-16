package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_INSTRUMENT_MODALITY extends SMPMessage
{
	public static final long CLASS_ID = 114297;

	private long InstrumentId = 0;
	private double MinPriceTick = 0;
	private double MinYieldTick = 0;
	private double IncrementQty = 0;
	private double LotValue = 0;
	private BV_INSTRUMENT_PER_FUNCTION[] FunctionParameters = new BV_INSTRUMENT_PER_FUNCTION[20];
	private double MinDiscountRateTick = 0;

	public BV_INSTRUMENT_MODALITY()
	{
		for (int i=0; i < FunctionParameters.length; ++i)
		{
			FunctionParameters[i] = new BV_INSTRUMENT_PER_FUNCTION();
		}
	}

	public long getInstrumentId()
	{
		return InstrumentId;
	}
	public void setInstrumentId(long value)
	{
		InstrumentId = value;
	}
	public double getMinPriceTick()
	{
		return MinPriceTick;
	}
	public void setMinPriceTick(double value)
	{
		MinPriceTick = value;
	}
	public double getMinYieldTick()
	{
		return MinYieldTick;
	}
	public void setMinYieldTick(double value)
	{
		MinYieldTick = value;
	}
	public double getIncrementQty()
	{
		return IncrementQty;
	}
	public void setIncrementQty(double value)
	{
		IncrementQty = value;
	}
	public double getLotValue()
	{
		return LotValue;
	}
	public void setLotValue(double value)
	{
		LotValue = value;
	}
	public BV_INSTRUMENT_PER_FUNCTION[] getFunctionParameters()
	{
		return FunctionParameters;
	}
	public void setFunctionParameters(BV_INSTRUMENT_PER_FUNCTION[] value)
	{
		FunctionParameters = value;
	}
	public double getMinDiscountRateTick()
	{
		return MinDiscountRateTick;
	}
	public void setMinDiscountRateTick(double value)
	{
		MinDiscountRateTick = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		InstrumentId = (long)byteBuffer.readInt();
		MinPriceTick = byteBuffer.readDouble();
		MinYieldTick = byteBuffer.readDouble();
		IncrementQty = byteBuffer.readDouble();
		LotValue = byteBuffer.readDouble();
		for (int i=0; i < FunctionParameters.length; ++i)
		{
			FunctionParameters[i].readXDR(byteBuffer);
		}
		MinDiscountRateTick = byteBuffer.readDouble();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(InstrumentId & 0xFFFFFFFFL));
		byteBuffer.writeDouble(MinPriceTick);
		byteBuffer.writeDouble(MinYieldTick);
		byteBuffer.writeDouble(IncrementQty);
		byteBuffer.writeDouble(LotValue);
		for (int i=0; i < FunctionParameters.length; ++i)
		{
			FunctionParameters[i].writeXDR(byteBuffer);
		}
		byteBuffer.writeDouble(MinDiscountRateTick);

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
		stringBuilder.append("BV_INSTRUMENT_MODALITY::");
		stringBuilder.append("InstrumentId(").append(InstrumentId).append(")");
		stringBuilder.append("MinPriceTick(").append(MinPriceTick).append(")");
		stringBuilder.append("MinYieldTick(").append(MinYieldTick).append(")");
		stringBuilder.append("IncrementQty(").append(IncrementQty).append(")");
		stringBuilder.append("LotValue(").append(LotValue).append(")");
		for (int i=0; i < FunctionParameters.length; ++i)
		{
			stringBuilder.append("FunctionParameters[").append(i).append("](").append(FunctionParameters[i].toString()).append(")");
		}
		stringBuilder.append("MinDiscountRateTick(").append(MinDiscountRateTick).append(")");
		return stringBuilder.toString();
	}
}
