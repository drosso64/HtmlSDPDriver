package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_CMF_FINANCIAL_INSTRUMENT_STATISTIC extends SMPMessage
{
	public static final long CLASS_ID = 400007;

	private long FinancialInstrumentId = 0;
	private long SectionId = 0;
	private String CMFSectionCode = "";
	private String CMFSectionDesc = "";
	private TI_STATISTIC_TYPE_Enum Type = TI_STATISTIC_TYPE_Enum.TI_STATISTIC_TYPE_Life;
	private short Hour = 0;
	private TI_FLAG_Enum GreyMarketFlag = TI_FLAG_Enum.TI_FLAG_No;
	private double MinPrice = 0;
	private double MaxPrice = 0;
	private double AvgPrice = 0;
	private double MinYield = 0;
	private double MaxYield = 0;
	private double AvgYield = 0;
	private double TradedNominalValue = 0;
	private long NumberOfTrades = 0;
	private long LastTradeTime = 0;
	private TI_TRADE_TYPE_Enum TradeType = TI_TRADE_TYPE_Enum.TI_TRADE_TYPE_Normal;
	private TI_FINANCIAL_INSTRUMENT_TYPE_Enum InstrumentType = TI_FINANCIAL_INSTRUMENT_TYPE_Enum.TI_FINANCIAL_INSTRUMENT_TYPE_Bond;
	private TI_FLAG_Enum RecalculationFg = TI_FLAG_Enum.TI_FLAG_No;

	public BV_CMF_FINANCIAL_INSTRUMENT_STATISTIC()
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
	public long getSectionId()
	{
		return SectionId;
	}
	public void setSectionId(long value)
	{
		SectionId = value;
	}
	public String getCMFSectionCode()
	{
		return CMFSectionCode;
	}
	public void setCMFSectionCode(String value)
	{
		CMFSectionCode = value;
	}
	public String getCMFSectionDesc()
	{
		return CMFSectionDesc;
	}
	public void setCMFSectionDesc(String value)
	{
		CMFSectionDesc = value;
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
	public TI_FLAG_Enum getGreyMarketFlag()
	{
		return GreyMarketFlag;
	}
	public void setGreyMarketFlag(TI_FLAG_Enum value)
	{
		GreyMarketFlag = value;
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
	public double getTradedNominalValue()
	{
		return TradedNominalValue;
	}
	public void setTradedNominalValue(double value)
	{
		TradedNominalValue = value;
	}
	public long getNumberOfTrades()
	{
		return NumberOfTrades;
	}
	public void setNumberOfTrades(long value)
	{
		NumberOfTrades = value;
	}
	public long getLastTradeTime()
	{
		return LastTradeTime;
	}
	public void setLastTradeTime(long value)
	{
		LastTradeTime = value;
	}
	public TI_TRADE_TYPE_Enum getTradeType()
	{
		return TradeType;
	}
	public void setTradeType(TI_TRADE_TYPE_Enum value)
	{
		TradeType = value;
	}
	public TI_FINANCIAL_INSTRUMENT_TYPE_Enum getInstrumentType()
	{
		return InstrumentType;
	}
	public void setInstrumentType(TI_FINANCIAL_INSTRUMENT_TYPE_Enum value)
	{
		InstrumentType = value;
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
		FinancialInstrumentId = (long)byteBuffer.readInt();
		SectionId = (long)byteBuffer.readInt();
		CMFSectionCode = byteBuffer.readString();
		CMFSectionDesc = byteBuffer.readString();
		Type = Type.getEnum(byteBuffer.readInt());
		Hour = (short)byteBuffer.readInt();
		GreyMarketFlag = GreyMarketFlag.getEnum(byteBuffer.readInt());
		MinPrice = byteBuffer.readDouble();
		MaxPrice = byteBuffer.readDouble();
		AvgPrice = byteBuffer.readDouble();
		MinYield = byteBuffer.readDouble();
		MaxYield = byteBuffer.readDouble();
		AvgYield = byteBuffer.readDouble();
		TradedNominalValue = byteBuffer.readDouble();
		NumberOfTrades = (long)byteBuffer.readInt();
		LastTradeTime = byteBuffer.readLong();
		TradeType = TradeType.getEnum(byteBuffer.readInt());
		InstrumentType = InstrumentType.getEnum(byteBuffer.readInt());
		RecalculationFg = RecalculationFg.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(FinancialInstrumentId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SectionId & 0xFFFFFFFFL));
		byteBuffer.writeString(CMFSectionCode);
		byteBuffer.writeString(CMFSectionDesc);
		byteBuffer.writeInt(Type.getValue());
		byteBuffer.writeInt((int)(Hour & 0xFFFFL));
		byteBuffer.writeInt(GreyMarketFlag.getValue());
		byteBuffer.writeDouble(MinPrice);
		byteBuffer.writeDouble(MaxPrice);
		byteBuffer.writeDouble(AvgPrice);
		byteBuffer.writeDouble(MinYield);
		byteBuffer.writeDouble(MaxYield);
		byteBuffer.writeDouble(AvgYield);
		byteBuffer.writeDouble(TradedNominalValue);
		byteBuffer.writeInt((int)(NumberOfTrades & 0xFFFFFFFFL));
		byteBuffer.writeLong(LastTradeTime);
		byteBuffer.writeInt(TradeType.getValue());
		byteBuffer.writeInt(InstrumentType.getValue());
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
		stringBuilder.append("BV_CMF_FINANCIAL_INSTRUMENT_STATISTIC::");
		stringBuilder.append("FinancialInstrumentId(").append(FinancialInstrumentId).append(")");
		stringBuilder.append("SectionId(").append(SectionId).append(")");
		stringBuilder.append("CMFSectionCode(").append(CMFSectionCode).append(")");
		stringBuilder.append("CMFSectionDesc(").append(CMFSectionDesc).append(")");
		stringBuilder.append("Type(").append(Type).append(")");
		stringBuilder.append("Hour(").append(Hour).append(")");
		stringBuilder.append("GreyMarketFlag(").append(GreyMarketFlag).append(")");
		stringBuilder.append("MinPrice(").append(MinPrice).append(")");
		stringBuilder.append("MaxPrice(").append(MaxPrice).append(")");
		stringBuilder.append("AvgPrice(").append(AvgPrice).append(")");
		stringBuilder.append("MinYield(").append(MinYield).append(")");
		stringBuilder.append("MaxYield(").append(MaxYield).append(")");
		stringBuilder.append("AvgYield(").append(AvgYield).append(")");
		stringBuilder.append("TradedNominalValue(").append(TradedNominalValue).append(")");
		stringBuilder.append("NumberOfTrades(").append(NumberOfTrades).append(")");
		stringBuilder.append("LastTradeTime(").append(LastTradeTime).append(")");
		stringBuilder.append("TradeType(").append(TradeType).append(")");
		stringBuilder.append("InstrumentType(").append(InstrumentType).append(")");
		stringBuilder.append("RecalculationFg(").append(RecalculationFg).append(")");
		return stringBuilder.toString();
	}
}
