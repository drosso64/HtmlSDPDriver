package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class DF_BV_RFCQ_TRADE_SUMMARY extends SMPMessage
{
	public static final long CLASS_ID = 114603;

	private long MarketId = 0;
	private long SectionId = 0;
	private long InstrumentClassId = 0;
	private long FinancialInstrumentId = 0;
	private TI_FINANCIAL_INSTRUMENT_TYPE_Enum FinancialInstrumentType = TI_FINANCIAL_INSTRUMENT_TYPE_Enum.TI_FINANCIAL_INSTRUMENT_TYPE_Bond;
	private TI_INSTRUMENT_TYPE_Enum InstrumentType = TI_INSTRUMENT_TYPE_Enum.TI_INSTRUMENT_TYPE_Bond;
	private String Currency = "";
	private long ActiveTrades = 0;
	private double ActiveTradesNominalValue = 0;
	private DF_RFCQ_SUBTOT_INFO SubTotActiveTrades = new DF_RFCQ_SUBTOT_INFO();
	private DF_SUBTOT_SETTL_INFO SubTotActiveSettl = new DF_SUBTOT_SETTL_INFO();
	private long CancTrades = 0;
	private double CancTradesNominalValue = 0;
	private DF_RFCQ_SUBTOT_INFO SubTotCancTrades = new DF_RFCQ_SUBTOT_INFO();
	private DF_SUBTOT_SETTL_INFO SubTotCancSettl = new DF_SUBTOT_SETTL_INFO();
	private short MarketAffiliation = 0;

	public DF_BV_RFCQ_TRADE_SUMMARY()
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
	public long getFinancialInstrumentId()
	{
		return FinancialInstrumentId;
	}
	public void setFinancialInstrumentId(long value)
	{
		FinancialInstrumentId = value;
	}
	public TI_FINANCIAL_INSTRUMENT_TYPE_Enum getFinancialInstrumentType()
	{
		return FinancialInstrumentType;
	}
	public void setFinancialInstrumentType(TI_FINANCIAL_INSTRUMENT_TYPE_Enum value)
	{
		FinancialInstrumentType = value;
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
	public long getActiveTrades()
	{
		return ActiveTrades;
	}
	public void setActiveTrades(long value)
	{
		ActiveTrades = value;
	}
	public double getActiveTradesNominalValue()
	{
		return ActiveTradesNominalValue;
	}
	public void setActiveTradesNominalValue(double value)
	{
		ActiveTradesNominalValue = value;
	}
	public DF_RFCQ_SUBTOT_INFO getSubTotActiveTrades()
	{
		return SubTotActiveTrades;
	}
	public void setSubTotActiveTrades(DF_RFCQ_SUBTOT_INFO value)
	{
		SubTotActiveTrades = value;
	}
	public DF_SUBTOT_SETTL_INFO getSubTotActiveSettl()
	{
		return SubTotActiveSettl;
	}
	public void setSubTotActiveSettl(DF_SUBTOT_SETTL_INFO value)
	{
		SubTotActiveSettl = value;
	}
	public long getCancTrades()
	{
		return CancTrades;
	}
	public void setCancTrades(long value)
	{
		CancTrades = value;
	}
	public double getCancTradesNominalValue()
	{
		return CancTradesNominalValue;
	}
	public void setCancTradesNominalValue(double value)
	{
		CancTradesNominalValue = value;
	}
	public DF_RFCQ_SUBTOT_INFO getSubTotCancTrades()
	{
		return SubTotCancTrades;
	}
	public void setSubTotCancTrades(DF_RFCQ_SUBTOT_INFO value)
	{
		SubTotCancTrades = value;
	}
	public DF_SUBTOT_SETTL_INFO getSubTotCancSettl()
	{
		return SubTotCancSettl;
	}
	public void setSubTotCancSettl(DF_SUBTOT_SETTL_INFO value)
	{
		SubTotCancSettl = value;
	}
	public short getMarketAffiliation()
	{
		return MarketAffiliation;
	}
	public void setMarketAffiliation(short value)
	{
		MarketAffiliation = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MarketId = (long)byteBuffer.readInt();
		SectionId = (long)byteBuffer.readInt();
		InstrumentClassId = (long)byteBuffer.readInt();
		FinancialInstrumentId = (long)byteBuffer.readInt();
		FinancialInstrumentType = FinancialInstrumentType.getEnum(byteBuffer.readInt());
		InstrumentType = InstrumentType.getEnum(byteBuffer.readInt());
		Currency = byteBuffer.readString();
		ActiveTrades = (long)byteBuffer.readInt();
		ActiveTradesNominalValue = byteBuffer.readDouble();
		SubTotActiveTrades.readXDR(byteBuffer);
		SubTotActiveSettl.readXDR(byteBuffer);
		CancTrades = (long)byteBuffer.readInt();
		CancTradesNominalValue = byteBuffer.readDouble();
		SubTotCancTrades.readXDR(byteBuffer);
		SubTotCancSettl.readXDR(byteBuffer);
		MarketAffiliation = (short)byteBuffer.readInt();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MarketId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SectionId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(InstrumentClassId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(FinancialInstrumentId & 0xFFFFFFFFL));
		byteBuffer.writeInt(FinancialInstrumentType.getValue());
		byteBuffer.writeInt(InstrumentType.getValue());
		byteBuffer.writeString(Currency);
		byteBuffer.writeInt((int)(ActiveTrades & 0xFFFFFFFFL));
		byteBuffer.writeDouble(ActiveTradesNominalValue);
		SubTotActiveTrades.writeXDR(byteBuffer);
		SubTotActiveSettl.writeXDR(byteBuffer);
		byteBuffer.writeInt((int)(CancTrades & 0xFFFFFFFFL));
		byteBuffer.writeDouble(CancTradesNominalValue);
		SubTotCancTrades.writeXDR(byteBuffer);
		SubTotCancSettl.writeXDR(byteBuffer);
		byteBuffer.writeInt((int)(MarketAffiliation & 0xFFFFL));

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
		stringBuilder.append("DF_BV_RFCQ_TRADE_SUMMARY::");
		stringBuilder.append("MarketId(").append(MarketId).append(")");
		stringBuilder.append("SectionId(").append(SectionId).append(")");
		stringBuilder.append("InstrumentClassId(").append(InstrumentClassId).append(")");
		stringBuilder.append("FinancialInstrumentId(").append(FinancialInstrumentId).append(")");
		stringBuilder.append("FinancialInstrumentType(").append(FinancialInstrumentType).append(")");
		stringBuilder.append("InstrumentType(").append(InstrumentType).append(")");
		stringBuilder.append("Currency(").append(Currency).append(")");
		stringBuilder.append("ActiveTrades(").append(ActiveTrades).append(")");
		stringBuilder.append("ActiveTradesNominalValue(").append(ActiveTradesNominalValue).append(")");
		stringBuilder.append("SubTotActiveTrades(").append(SubTotActiveTrades.toString()).append(")");
		stringBuilder.append("SubTotActiveSettl(").append(SubTotActiveSettl.toString()).append(")");
		stringBuilder.append("CancTrades(").append(CancTrades).append(")");
		stringBuilder.append("CancTradesNominalValue(").append(CancTradesNominalValue).append(")");
		stringBuilder.append("SubTotCancTrades(").append(SubTotCancTrades.toString()).append(")");
		stringBuilder.append("SubTotCancSettl(").append(SubTotCancSettl.toString()).append(")");
		stringBuilder.append("MarketAffiliation(").append(MarketAffiliation).append(")");
		return stringBuilder.toString();
	}
}
