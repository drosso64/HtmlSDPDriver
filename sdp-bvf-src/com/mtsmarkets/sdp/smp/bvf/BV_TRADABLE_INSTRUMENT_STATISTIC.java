package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_TRADABLE_INSTRUMENT_STATISTIC extends SMPMessage
{
	public static final long CLASS_ID = 114146;

	private BV_INSTRUMENT_INFO Instrument = new BV_INSTRUMENT_INFO();
	private long SectionId = 0;
	private TI_STATISTIC_TYPE_Enum Type = TI_STATISTIC_TYPE_Enum.TI_STATISTIC_TYPE_Life;
	private short Hour = 0;
	private double MinPrice = 0;
	private double MaxPrice = 0;
	private double AvgPrice = 0;
	private double MinYield = 0;
	private double MaxYield = 0;
	private double AvgYield = 0;
	private double TradedQty = 0;
	private long NumberOfDeals = 0;
	private long LastDealTime = 0;
	private TI_TRADE_TYPE_Enum TradeType = TI_TRADE_TYPE_Enum.TI_TRADE_TYPE_Normal;
	private short MarketAffiliation = 0;
	private TI_FLAG_Enum RecalculationFg = TI_FLAG_Enum.TI_FLAG_No;

	public BV_TRADABLE_INSTRUMENT_STATISTIC()
	{
	}

	public BV_INSTRUMENT_INFO getInstrument()
	{
		return Instrument;
	}
	public void setInstrument(BV_INSTRUMENT_INFO value)
	{
		Instrument = value;
	}
	public long getSectionId()
	{
		return SectionId;
	}
	public void setSectionId(long value)
	{
		SectionId = value;
	}
	public TI_STATISTIC_TYPE_Enum getType()
	{
		return Type;
	}
	public void setType(TI_STATISTIC_TYPE_Enum value)
	{
		Type = value;
	}
	public short getHour()
	{
		return Hour;
	}
	public void setHour(short value)
	{
		Hour = value;
	}
	public double getMinPrice()
	{
		return MinPrice;
	}
	public void setMinPrice(double value)
	{
		MinPrice = value;
	}
	public double getMaxPrice()
	{
		return MaxPrice;
	}
	public void setMaxPrice(double value)
	{
		MaxPrice = value;
	}
	public double getAvgPrice()
	{
		return AvgPrice;
	}
	public void setAvgPrice(double value)
	{
		AvgPrice = value;
	}
	public double getMinYield()
	{
		return MinYield;
	}
	public void setMinYield(double value)
	{
		MinYield = value;
	}
	public double getMaxYield()
	{
		return MaxYield;
	}
	public void setMaxYield(double value)
	{
		MaxYield = value;
	}
	public double getAvgYield()
	{
		return AvgYield;
	}
	public void setAvgYield(double value)
	{
		AvgYield = value;
	}
	public double getTradedQty()
	{
		return TradedQty;
	}
	public void setTradedQty(double value)
	{
		TradedQty = value;
	}
	public long getNumberOfDeals()
	{
		return NumberOfDeals;
	}
	public void setNumberOfDeals(long value)
	{
		NumberOfDeals = value;
	}
	public long getLastDealTime()
	{
		return LastDealTime;
	}
	public void setLastDealTime(long value)
	{
		LastDealTime = value;
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
		Instrument.readXDR(byteBuffer);
		SectionId = (long)byteBuffer.readInt();
		Type = Type.getEnum(byteBuffer.readInt());
		Hour = (short)byteBuffer.readInt();
		MinPrice = byteBuffer.readDouble();
		MaxPrice = byteBuffer.readDouble();
		AvgPrice = byteBuffer.readDouble();
		MinYield = byteBuffer.readDouble();
		MaxYield = byteBuffer.readDouble();
		AvgYield = byteBuffer.readDouble();
		TradedQty = byteBuffer.readDouble();
		NumberOfDeals = (long)byteBuffer.readInt();
		LastDealTime = byteBuffer.readLong();
		TradeType = TradeType.getEnum(byteBuffer.readInt());
		MarketAffiliation = (short)byteBuffer.readInt();
		RecalculationFg = RecalculationFg.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		Instrument.writeXDR(byteBuffer);
		byteBuffer.writeInt((int)(SectionId & 0xFFFFFFFFL));
		byteBuffer.writeInt(Type.getValue());
		byteBuffer.writeInt((int)(Hour & 0xFFFFL));
		byteBuffer.writeDouble(MinPrice);
		byteBuffer.writeDouble(MaxPrice);
		byteBuffer.writeDouble(AvgPrice);
		byteBuffer.writeDouble(MinYield);
		byteBuffer.writeDouble(MaxYield);
		byteBuffer.writeDouble(AvgYield);
		byteBuffer.writeDouble(TradedQty);
		byteBuffer.writeInt((int)(NumberOfDeals & 0xFFFFFFFFL));
		byteBuffer.writeLong(LastDealTime);
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
		stringBuilder.append("BV_TRADABLE_INSTRUMENT_STATISTIC::");
		stringBuilder.append("Instrument(").append(Instrument.toString()).append(")");
		stringBuilder.append("SectionId(").append(SectionId).append(")");
		stringBuilder.append("Type(").append(Type).append(")");
		stringBuilder.append("Hour(").append(Hour).append(")");
		stringBuilder.append("MinPrice(").append(MinPrice).append(")");
		stringBuilder.append("MaxPrice(").append(MaxPrice).append(")");
		stringBuilder.append("AvgPrice(").append(AvgPrice).append(")");
		stringBuilder.append("MinYield(").append(MinYield).append(")");
		stringBuilder.append("MaxYield(").append(MaxYield).append(")");
		stringBuilder.append("AvgYield(").append(AvgYield).append(")");
		stringBuilder.append("TradedQty(").append(TradedQty).append(")");
		stringBuilder.append("NumberOfDeals(").append(NumberOfDeals).append(")");
		stringBuilder.append("LastDealTime(").append(LastDealTime).append(")");
		stringBuilder.append("TradeType(").append(TradeType).append(")");
		stringBuilder.append("MarketAffiliation(").append(MarketAffiliation).append(")");
		stringBuilder.append("RecalculationFg(").append(RecalculationFg).append(")");
		return stringBuilder.toString();
	}
}
