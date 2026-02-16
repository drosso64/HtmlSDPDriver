package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_VOLUME_MARKET_STATISTIC extends SMPMessage
{
	public static final long CLASS_ID = 114124;

	private String Currency = "";
	private long SectionId = 0;
	private TI_INSTRUMENT_TYPE_Enum InstrumentType = TI_INSTRUMENT_TYPE_Enum.TI_INSTRUMENT_TYPE_Bond;
	private short Hour = 0;
	private double TradedNominalValue = 0;
	private TI_TRADE_TYPE_Enum TradeType = TI_TRADE_TYPE_Enum.TI_TRADE_TYPE_Normal;
	private short MarketAffiliation = 0;
	private TI_FLAG_Enum RecalculationFg = TI_FLAG_Enum.TI_FLAG_No;

	public BV_VOLUME_MARKET_STATISTIC()
	{
	}

	public String getCurrency()
	{
		return Currency;
	}
	public void setCurrency(String value)
	{
		Currency = value;
	}
	public long getSectionId()
	{
		return SectionId;
	}
	public void setSectionId(long value)
	{
		SectionId = value;
	}
	public TI_INSTRUMENT_TYPE_Enum getInstrumentType()
	{
		return InstrumentType;
	}
	public void setInstrumentType(TI_INSTRUMENT_TYPE_Enum value)
	{
		InstrumentType = value;
	}
	public short getHour()
	{
		return Hour;
	}
	public void setHour(short value)
	{
		Hour = value;
	}
	public double getTradedNominalValue()
	{
		return TradedNominalValue;
	}
	public void setTradedNominalValue(double value)
	{
		TradedNominalValue = value;
	}
	public TI_TRADE_TYPE_Enum getTradeType()
	{
		return TradeType;
	}
	public void setTradeType(TI_TRADE_TYPE_Enum value)
	{
		TradeType = value;
	}
	public short getMarketAffiliation()
	{
		return MarketAffiliation;
	}
	public void setMarketAffiliation(short value)
	{
		MarketAffiliation = value;
	}
	public TI_FLAG_Enum getRecalculationFg()
	{
		return RecalculationFg;
	}
	public void setRecalculationFg(TI_FLAG_Enum value)
	{
		RecalculationFg = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		Currency = byteBuffer.readString();
		SectionId = (long)byteBuffer.readInt();
		InstrumentType = InstrumentType.getEnum(byteBuffer.readInt());
		Hour = (short)byteBuffer.readInt();
		TradedNominalValue = byteBuffer.readDouble();
		TradeType = TradeType.getEnum(byteBuffer.readInt());
		MarketAffiliation = (short)byteBuffer.readInt();
		RecalculationFg = RecalculationFg.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeString(Currency);
		byteBuffer.writeInt((int)(SectionId & 0xFFFFFFFFL));
		byteBuffer.writeInt(InstrumentType.getValue());
		byteBuffer.writeInt((int)(Hour & 0xFFFFL));
		byteBuffer.writeDouble(TradedNominalValue);
		byteBuffer.writeInt(TradeType.getValue());
		byteBuffer.writeInt((int)(MarketAffiliation & 0xFFFFL));
		byteBuffer.writeInt(RecalculationFg.getValue());

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
		stringBuilder.append("BV_VOLUME_MARKET_STATISTIC::");
		stringBuilder.append("Currency(").append(Currency).append(")");
		stringBuilder.append("SectionId(").append(SectionId).append(")");
		stringBuilder.append("InstrumentType(").append(InstrumentType).append(")");
		stringBuilder.append("Hour(").append(Hour).append(")");
		stringBuilder.append("TradedNominalValue(").append(TradedNominalValue).append(")");
		stringBuilder.append("TradeType(").append(TradeType).append(")");
		stringBuilder.append("MarketAffiliation(").append(MarketAffiliation).append(")");
		stringBuilder.append("RecalculationFg(").append(RecalculationFg).append(")");
		return stringBuilder.toString();
	}
}
