package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_FUTURE extends SMPMessage
{
	public static final long CLASS_ID = 400069;

	private long InstrumentId = 0;
	private String InstrumentCode = "";
	private String InstrumentDesc = "";
	private long FinancialInstrumentId = 0;
	private long InstrumentClassId = 0;
	private double LotValue = 0;
	private double MinBasisSize = 0;
	private double MinOutrightSize = 0;
	private double IncrementQty = 0;
	private double RFCQMinStageOrderQty = 0;
	private double RFCQMinPriceTick = 0;
	private double RFCQMinYieldTick = 0;
	private double RFCQMinSplitFillQty = 0;
	private long SortNumber = 0;

	public BV_FUTURE()
	{
	}

	public long getInstrumentId()
	{
		return InstrumentId;
	}
	public void setInstrumentId(long value)
	{
		InstrumentId = value;
	}
	public String getInstrumentCode()
	{
		return InstrumentCode;
	}
	public void setInstrumentCode(String value)
	{
		InstrumentCode = value;
	}
	public String getInstrumentDesc()
	{
		return InstrumentDesc;
	}
	public void setInstrumentDesc(String value)
	{
		InstrumentDesc = value;
	}
	public long getFinancialInstrumentId()
	{
		return FinancialInstrumentId;
	}
	public void setFinancialInstrumentId(long value)
	{
		FinancialInstrumentId = value;
	}
	public long getInstrumentClassId()
	{
		return InstrumentClassId;
	}
	public void setInstrumentClassId(long value)
	{
		InstrumentClassId = value;
	}
	public double getLotValue()
	{
		return LotValue;
	}
	public void setLotValue(double value)
	{
		LotValue = value;
	}
	public double getMinBasisSize()
	{
		return MinBasisSize;
	}
	public void setMinBasisSize(double value)
	{
		MinBasisSize = value;
	}
	public double getMinOutrightSize()
	{
		return MinOutrightSize;
	}
	public void setMinOutrightSize(double value)
	{
		MinOutrightSize = value;
	}
	public double getIncrementQty()
	{
		return IncrementQty;
	}
	public void setIncrementQty(double value)
	{
		IncrementQty = value;
	}
	public double getRFCQMinStageOrderQty()
	{
		return RFCQMinStageOrderQty;
	}
	public void setRFCQMinStageOrderQty(double value)
	{
		RFCQMinStageOrderQty = value;
	}
	public double getRFCQMinPriceTick()
	{
		return RFCQMinPriceTick;
	}
	public void setRFCQMinPriceTick(double value)
	{
		RFCQMinPriceTick = value;
	}
	public double getRFCQMinYieldTick()
	{
		return RFCQMinYieldTick;
	}
	public void setRFCQMinYieldTick(double value)
	{
		RFCQMinYieldTick = value;
	}
	public double getRFCQMinSplitFillQty()
	{
		return RFCQMinSplitFillQty;
	}
	public void setRFCQMinSplitFillQty(double value)
	{
		RFCQMinSplitFillQty = value;
	}
	public long getSortNumber()
	{
		return SortNumber;
	}
	public void setSortNumber(long value)
	{
		SortNumber = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		InstrumentId = (long)byteBuffer.readInt();
		InstrumentCode = byteBuffer.readString();
		InstrumentDesc = byteBuffer.readString();
		FinancialInstrumentId = (long)byteBuffer.readInt();
		InstrumentClassId = (long)byteBuffer.readInt();
		LotValue = byteBuffer.readDouble();
		MinBasisSize = byteBuffer.readDouble();
		MinOutrightSize = byteBuffer.readDouble();
		IncrementQty = byteBuffer.readDouble();
		RFCQMinStageOrderQty = byteBuffer.readDouble();
		RFCQMinPriceTick = byteBuffer.readDouble();
		RFCQMinYieldTick = byteBuffer.readDouble();
		RFCQMinSplitFillQty = byteBuffer.readDouble();
		SortNumber = (long)byteBuffer.readInt();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(InstrumentId & 0xFFFFFFFFL));
		byteBuffer.writeString(InstrumentCode);
		byteBuffer.writeString(InstrumentDesc);
		byteBuffer.writeInt((int)(FinancialInstrumentId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(InstrumentClassId & 0xFFFFFFFFL));
		byteBuffer.writeDouble(LotValue);
		byteBuffer.writeDouble(MinBasisSize);
		byteBuffer.writeDouble(MinOutrightSize);
		byteBuffer.writeDouble(IncrementQty);
		byteBuffer.writeDouble(RFCQMinStageOrderQty);
		byteBuffer.writeDouble(RFCQMinPriceTick);
		byteBuffer.writeDouble(RFCQMinYieldTick);
		byteBuffer.writeDouble(RFCQMinSplitFillQty);
		byteBuffer.writeInt((int)(SortNumber & 0xFFFFFFFFL));

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
		stringBuilder.append("BV_FUTURE::");
		stringBuilder.append("InstrumentId(").append(InstrumentId).append(")");
		stringBuilder.append("InstrumentCode(").append(InstrumentCode).append(")");
		stringBuilder.append("InstrumentDesc(").append(InstrumentDesc).append(")");
		stringBuilder.append("FinancialInstrumentId(").append(FinancialInstrumentId).append(")");
		stringBuilder.append("InstrumentClassId(").append(InstrumentClassId).append(")");
		stringBuilder.append("LotValue(").append(LotValue).append(")");
		stringBuilder.append("MinBasisSize(").append(MinBasisSize).append(")");
		stringBuilder.append("MinOutrightSize(").append(MinOutrightSize).append(")");
		stringBuilder.append("IncrementQty(").append(IncrementQty).append(")");
		stringBuilder.append("RFCQMinStageOrderQty(").append(RFCQMinStageOrderQty).append(")");
		stringBuilder.append("RFCQMinPriceTick(").append(RFCQMinPriceTick).append(")");
		stringBuilder.append("RFCQMinYieldTick(").append(RFCQMinYieldTick).append(")");
		stringBuilder.append("RFCQMinSplitFillQty(").append(RFCQMinSplitFillQty).append(")");
		stringBuilder.append("SortNumber(").append(SortNumber).append(")");
		return stringBuilder.toString();
	}
}
