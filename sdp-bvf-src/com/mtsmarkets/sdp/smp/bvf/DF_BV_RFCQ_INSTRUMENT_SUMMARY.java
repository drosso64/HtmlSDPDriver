package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class DF_BV_RFCQ_INSTRUMENT_SUMMARY extends SMPMessage
{
	public static final long CLASS_ID = 114604;

	private long MarketId = 0;
	private long SectionId = 0;
	private long InstrumentClassId = 0;
	private long InstrumentId = 0;
	private TI_INSTRUMENT_TYPE_Enum InstrumentType = TI_INSTRUMENT_TYPE_Enum.TI_INSTRUMENT_TYPE_Bond;
	private String Currency = "";
	private DF_RFCQ_TRADING_INFO TradInfo = new DF_RFCQ_TRADING_INFO();
	private double ActiveDealsNominalValue = 0;
	private DF_RFCQ_SUBTOT_INFO SubTotActiveDeals = new DF_RFCQ_SUBTOT_INFO();
	private double CancDealsNominalValue = 0;
	private DF_RFCQ_SUBTOT_INFO SubTotCancDeals = new DF_RFCQ_SUBTOT_INFO();

	public DF_BV_RFCQ_INSTRUMENT_SUMMARY()
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
	public long getSectionId()
	{
		return SectionId;
	}
	public void setSectionId(long value)
	{
		SectionId = value;
	}
	public long getInstrumentClassId()
	{
		return InstrumentClassId;
	}
	public void setInstrumentClassId(long value)
	{
		InstrumentClassId = value;
	}
	public long getInstrumentId()
	{
		return InstrumentId;
	}
	public void setInstrumentId(long value)
	{
		InstrumentId = value;
	}
	public TI_INSTRUMENT_TYPE_Enum getInstrumentType()
	{
		return InstrumentType;
	}
	public void setInstrumentType(TI_INSTRUMENT_TYPE_Enum value)
	{
		InstrumentType = value;
	}
	public String getCurrency()
	{
		return Currency;
	}
	public void setCurrency(String value)
	{
		Currency = value;
	}
	public DF_RFCQ_TRADING_INFO getTradInfo()
	{
		return TradInfo;
	}
	public void setTradInfo(DF_RFCQ_TRADING_INFO value)
	{
		TradInfo = value;
	}
	public double getActiveDealsNominalValue()
	{
		return ActiveDealsNominalValue;
	}
	public void setActiveDealsNominalValue(double value)
	{
		ActiveDealsNominalValue = value;
	}
	public DF_RFCQ_SUBTOT_INFO getSubTotActiveDeals()
	{
		return SubTotActiveDeals;
	}
	public void setSubTotActiveDeals(DF_RFCQ_SUBTOT_INFO value)
	{
		SubTotActiveDeals = value;
	}
	public double getCancDealsNominalValue()
	{
		return CancDealsNominalValue;
	}
	public void setCancDealsNominalValue(double value)
	{
		CancDealsNominalValue = value;
	}
	public DF_RFCQ_SUBTOT_INFO getSubTotCancDeals()
	{
		return SubTotCancDeals;
	}
	public void setSubTotCancDeals(DF_RFCQ_SUBTOT_INFO value)
	{
		SubTotCancDeals = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MarketId = (long)byteBuffer.readInt();
		SectionId = (long)byteBuffer.readInt();
		InstrumentClassId = (long)byteBuffer.readInt();
		InstrumentId = (long)byteBuffer.readInt();
		InstrumentType = InstrumentType.getEnum(byteBuffer.readInt());
		Currency = byteBuffer.readString();
		TradInfo.readXDR(byteBuffer);
		ActiveDealsNominalValue = byteBuffer.readDouble();
		SubTotActiveDeals.readXDR(byteBuffer);
		CancDealsNominalValue = byteBuffer.readDouble();
		SubTotCancDeals.readXDR(byteBuffer);
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MarketId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SectionId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(InstrumentClassId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(InstrumentId & 0xFFFFFFFFL));
		byteBuffer.writeInt(InstrumentType.getValue());
		byteBuffer.writeString(Currency);
		TradInfo.writeXDR(byteBuffer);
		byteBuffer.writeDouble(ActiveDealsNominalValue);
		SubTotActiveDeals.writeXDR(byteBuffer);
		byteBuffer.writeDouble(CancDealsNominalValue);
		SubTotCancDeals.writeXDR(byteBuffer);

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
		stringBuilder.append("DF_BV_RFCQ_INSTRUMENT_SUMMARY::");
		stringBuilder.append("MarketId(").append(MarketId).append(")");
		stringBuilder.append("SectionId(").append(SectionId).append(")");
		stringBuilder.append("InstrumentClassId(").append(InstrumentClassId).append(")");
		stringBuilder.append("InstrumentId(").append(InstrumentId).append(")");
		stringBuilder.append("InstrumentType(").append(InstrumentType).append(")");
		stringBuilder.append("Currency(").append(Currency).append(")");
		stringBuilder.append("TradInfo(").append(TradInfo.toString()).append(")");
		stringBuilder.append("ActiveDealsNominalValue(").append(ActiveDealsNominalValue).append(")");
		stringBuilder.append("SubTotActiveDeals(").append(SubTotActiveDeals.toString()).append(")");
		stringBuilder.append("CancDealsNominalValue(").append(CancDealsNominalValue).append(")");
		stringBuilder.append("SubTotCancDeals(").append(SubTotCancDeals.toString()).append(")");
		return stringBuilder.toString();
	}
}
