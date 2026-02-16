package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_REPO_OFFICIAL_PRICE extends SMPMessage
{
	public static final long CLASS_ID = 400065;

	private long InstrumentId = 0;
	private String InstrumentCode = "";
	private String InstrumentDesc = "";
	private String InstrumentClassCode = "";
	private String CurrencyCode = "";
	private String FinancialInstrumentCode = "";
	private String FinancialInstrumentDesc = "";
	private long SectionId = 0;
	private String SectionCode = "";
	private String SectionDesc = "";
	private long StartDate = 0;
	private long EndDate = 0;
	private String StartDateCode = "";
	private String StartDateDesc = "";
	private String EndDateCode = "";
	private String EndDateDesc = "";
	private String VanillaCode = "";
	private String VanillaDesc = "";
	private TI_TRADE_TYPE_Enum TradeType = TI_TRADE_TYPE_Enum.TI_TRADE_TYPE_Normal;
	private String RefRateCode = "";
	private String RefRateDesc = "";
	private long ReferenceDate = 0;
	private double SpecialBondMinRate = 0;
	private double SpecialBondMaxRate = 0;
	private double SpecialBondAvgRate = 0;
	private double SpecialBondQty = 0;
	private double SpecialBondNominalValue = 0;
	private long GCInstrumentId = 0;
	private String GCInstrumentDesc = "";
	private String GCFinancialInstrumentCode = "";
	private String GCFinancialInstrumentDesc = "";
	private double GCMinRate = 0;
	private double GCMaxRate = 0;
	private double GCAvgRate = 0;
	private double GCQty = 0;
	private double GCNominalValue = 0;

	public BV_REPO_OFFICIAL_PRICE()
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
	public String getInstrumentClassCode()
	{
		return InstrumentClassCode;
	}
	public void setInstrumentClassCode(String value)
	{
		InstrumentClassCode = value;
	}
	public String getCurrencyCode()
	{
		return CurrencyCode;
	}
	public void setCurrencyCode(String value)
	{
		CurrencyCode = value;
	}
	public String getFinancialInstrumentCode()
	{
		return FinancialInstrumentCode;
	}
	public void setFinancialInstrumentCode(String value)
	{
		FinancialInstrumentCode = value;
	}
	public String getFinancialInstrumentDesc()
	{
		return FinancialInstrumentDesc;
	}
	public void setFinancialInstrumentDesc(String value)
	{
		FinancialInstrumentDesc = value;
	}
	public long getSectionId()
	{
		return SectionId;
	}
	public void setSectionId(long value)
	{
		SectionId = value;
	}
	public String getSectionCode()
	{
		return SectionCode;
	}
	public void setSectionCode(String value)
	{
		SectionCode = value;
	}
	public String getSectionDesc()
	{
		return SectionDesc;
	}
	public void setSectionDesc(String value)
	{
		SectionDesc = value;
	}
	public long getStartDate()
	{
		return StartDate;
	}
	public void setStartDate(long value)
	{
		StartDate = value;
	}
	public long getEndDate()
	{
		return EndDate;
	}
	public void setEndDate(long value)
	{
		EndDate = value;
	}
	public String getStartDateCode()
	{
		return StartDateCode;
	}
	public void setStartDateCode(String value)
	{
		StartDateCode = value;
	}
	public String getStartDateDesc()
	{
		return StartDateDesc;
	}
	public void setStartDateDesc(String value)
	{
		StartDateDesc = value;
	}
	public String getEndDateCode()
	{
		return EndDateCode;
	}
	public void setEndDateCode(String value)
	{
		EndDateCode = value;
	}
	public String getEndDateDesc()
	{
		return EndDateDesc;
	}
	public void setEndDateDesc(String value)
	{
		EndDateDesc = value;
	}
	public String getVanillaCode()
	{
		return VanillaCode;
	}
	public void setVanillaCode(String value)
	{
		VanillaCode = value;
	}
	public String getVanillaDesc()
	{
		return VanillaDesc;
	}
	public void setVanillaDesc(String value)
	{
		VanillaDesc = value;
	}
	public TI_TRADE_TYPE_Enum getTradeType()
	{
		return TradeType;
	}
	public void setTradeType(TI_TRADE_TYPE_Enum value)
	{
		TradeType = value;
	}
	public String getRefRateCode()
	{
		return RefRateCode;
	}
	public void setRefRateCode(String value)
	{
		RefRateCode = value;
	}
	public String getRefRateDesc()
	{
		return RefRateDesc;
	}
	public void setRefRateDesc(String value)
	{
		RefRateDesc = value;
	}
	public long getReferenceDate()
	{
		return ReferenceDate;
	}
	public void setReferenceDate(long value)
	{
		ReferenceDate = value;
	}
	public double getSpecialBondMinRate()
	{
		return SpecialBondMinRate;
	}
	public void setSpecialBondMinRate(double value)
	{
		SpecialBondMinRate = value;
	}
	public double getSpecialBondMaxRate()
	{
		return SpecialBondMaxRate;
	}
	public void setSpecialBondMaxRate(double value)
	{
		SpecialBondMaxRate = value;
	}
	public double getSpecialBondAvgRate()
	{
		return SpecialBondAvgRate;
	}
	public void setSpecialBondAvgRate(double value)
	{
		SpecialBondAvgRate = value;
	}
	public double getSpecialBondQty()
	{
		return SpecialBondQty;
	}
	public void setSpecialBondQty(double value)
	{
		SpecialBondQty = value;
	}
	public double getSpecialBondNominalValue()
	{
		return SpecialBondNominalValue;
	}
	public void setSpecialBondNominalValue(double value)
	{
		SpecialBondNominalValue = value;
	}
	public long getGCInstrumentId()
	{
		return GCInstrumentId;
	}
	public void setGCInstrumentId(long value)
	{
		GCInstrumentId = value;
	}
	public String getGCInstrumentDesc()
	{
		return GCInstrumentDesc;
	}
	public void setGCInstrumentDesc(String value)
	{
		GCInstrumentDesc = value;
	}
	public String getGCFinancialInstrumentCode()
	{
		return GCFinancialInstrumentCode;
	}
	public void setGCFinancialInstrumentCode(String value)
	{
		GCFinancialInstrumentCode = value;
	}
	public String getGCFinancialInstrumentDesc()
	{
		return GCFinancialInstrumentDesc;
	}
	public void setGCFinancialInstrumentDesc(String value)
	{
		GCFinancialInstrumentDesc = value;
	}
	public double getGCMinRate()
	{
		return GCMinRate;
	}
	public void setGCMinRate(double value)
	{
		GCMinRate = value;
	}
	public double getGCMaxRate()
	{
		return GCMaxRate;
	}
	public void setGCMaxRate(double value)
	{
		GCMaxRate = value;
	}
	public double getGCAvgRate()
	{
		return GCAvgRate;
	}
	public void setGCAvgRate(double value)
	{
		GCAvgRate = value;
	}
	public double getGCQty()
	{
		return GCQty;
	}
	public void setGCQty(double value)
	{
		GCQty = value;
	}
	public double getGCNominalValue()
	{
		return GCNominalValue;
	}
	public void setGCNominalValue(double value)
	{
		GCNominalValue = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		InstrumentId = (long)byteBuffer.readInt();
		InstrumentCode = byteBuffer.readString();
		InstrumentDesc = byteBuffer.readString();
		InstrumentClassCode = byteBuffer.readString();
		CurrencyCode = byteBuffer.readString();
		FinancialInstrumentCode = byteBuffer.readString();
		FinancialInstrumentDesc = byteBuffer.readString();
		SectionId = (long)byteBuffer.readInt();
		SectionCode = byteBuffer.readString();
		SectionDesc = byteBuffer.readString();
		StartDate = (long)byteBuffer.readInt();
		EndDate = (long)byteBuffer.readInt();
		StartDateCode = byteBuffer.readString();
		StartDateDesc = byteBuffer.readString();
		EndDateCode = byteBuffer.readString();
		EndDateDesc = byteBuffer.readString();
		VanillaCode = byteBuffer.readString();
		VanillaDesc = byteBuffer.readString();
		TradeType = TradeType.getEnum(byteBuffer.readInt());
		RefRateCode = byteBuffer.readString();
		RefRateDesc = byteBuffer.readString();
		ReferenceDate = (long)byteBuffer.readInt();
		SpecialBondMinRate = byteBuffer.readDouble();
		SpecialBondMaxRate = byteBuffer.readDouble();
		SpecialBondAvgRate = byteBuffer.readDouble();
		SpecialBondQty = byteBuffer.readDouble();
		SpecialBondNominalValue = byteBuffer.readDouble();
		GCInstrumentId = (long)byteBuffer.readInt();
		GCInstrumentDesc = byteBuffer.readString();
		GCFinancialInstrumentCode = byteBuffer.readString();
		GCFinancialInstrumentDesc = byteBuffer.readString();
		GCMinRate = byteBuffer.readDouble();
		GCMaxRate = byteBuffer.readDouble();
		GCAvgRate = byteBuffer.readDouble();
		GCQty = byteBuffer.readDouble();
		GCNominalValue = byteBuffer.readDouble();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(InstrumentId & 0xFFFFFFFFL));
		byteBuffer.writeString(InstrumentCode);
		byteBuffer.writeString(InstrumentDesc);
		byteBuffer.writeString(InstrumentClassCode);
		byteBuffer.writeString(CurrencyCode);
		byteBuffer.writeString(FinancialInstrumentCode);
		byteBuffer.writeString(FinancialInstrumentDesc);
		byteBuffer.writeInt((int)(SectionId & 0xFFFFFFFFL));
		byteBuffer.writeString(SectionCode);
		byteBuffer.writeString(SectionDesc);
		byteBuffer.writeInt((int)(StartDate & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(EndDate & 0xFFFFFFFFL));
		byteBuffer.writeString(StartDateCode);
		byteBuffer.writeString(StartDateDesc);
		byteBuffer.writeString(EndDateCode);
		byteBuffer.writeString(EndDateDesc);
		byteBuffer.writeString(VanillaCode);
		byteBuffer.writeString(VanillaDesc);
		byteBuffer.writeInt(TradeType.getValue());
		byteBuffer.writeString(RefRateCode);
		byteBuffer.writeString(RefRateDesc);
		byteBuffer.writeInt((int)(ReferenceDate & 0xFFFFFFFFL));
		byteBuffer.writeDouble(SpecialBondMinRate);
		byteBuffer.writeDouble(SpecialBondMaxRate);
		byteBuffer.writeDouble(SpecialBondAvgRate);
		byteBuffer.writeDouble(SpecialBondQty);
		byteBuffer.writeDouble(SpecialBondNominalValue);
		byteBuffer.writeInt((int)(GCInstrumentId & 0xFFFFFFFFL));
		byteBuffer.writeString(GCInstrumentDesc);
		byteBuffer.writeString(GCFinancialInstrumentCode);
		byteBuffer.writeString(GCFinancialInstrumentDesc);
		byteBuffer.writeDouble(GCMinRate);
		byteBuffer.writeDouble(GCMaxRate);
		byteBuffer.writeDouble(GCAvgRate);
		byteBuffer.writeDouble(GCQty);
		byteBuffer.writeDouble(GCNominalValue);

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
		stringBuilder.append("BV_REPO_OFFICIAL_PRICE::");
		stringBuilder.append("InstrumentId(").append(InstrumentId).append(")");
		stringBuilder.append("InstrumentCode(").append(InstrumentCode).append(")");
		stringBuilder.append("InstrumentDesc(").append(InstrumentDesc).append(")");
		stringBuilder.append("InstrumentClassCode(").append(InstrumentClassCode).append(")");
		stringBuilder.append("CurrencyCode(").append(CurrencyCode).append(")");
		stringBuilder.append("FinancialInstrumentCode(").append(FinancialInstrumentCode).append(")");
		stringBuilder.append("FinancialInstrumentDesc(").append(FinancialInstrumentDesc).append(")");
		stringBuilder.append("SectionId(").append(SectionId).append(")");
		stringBuilder.append("SectionCode(").append(SectionCode).append(")");
		stringBuilder.append("SectionDesc(").append(SectionDesc).append(")");
		stringBuilder.append("StartDate(").append(StartDate).append(")");
		stringBuilder.append("EndDate(").append(EndDate).append(")");
		stringBuilder.append("StartDateCode(").append(StartDateCode).append(")");
		stringBuilder.append("StartDateDesc(").append(StartDateDesc).append(")");
		stringBuilder.append("EndDateCode(").append(EndDateCode).append(")");
		stringBuilder.append("EndDateDesc(").append(EndDateDesc).append(")");
		stringBuilder.append("VanillaCode(").append(VanillaCode).append(")");
		stringBuilder.append("VanillaDesc(").append(VanillaDesc).append(")");
		stringBuilder.append("TradeType(").append(TradeType).append(")");
		stringBuilder.append("RefRateCode(").append(RefRateCode).append(")");
		stringBuilder.append("RefRateDesc(").append(RefRateDesc).append(")");
		stringBuilder.append("ReferenceDate(").append(ReferenceDate).append(")");
		stringBuilder.append("SpecialBondMinRate(").append(SpecialBondMinRate).append(")");
		stringBuilder.append("SpecialBondMaxRate(").append(SpecialBondMaxRate).append(")");
		stringBuilder.append("SpecialBondAvgRate(").append(SpecialBondAvgRate).append(")");
		stringBuilder.append("SpecialBondQty(").append(SpecialBondQty).append(")");
		stringBuilder.append("SpecialBondNominalValue(").append(SpecialBondNominalValue).append(")");
		stringBuilder.append("GCInstrumentId(").append(GCInstrumentId).append(")");
		stringBuilder.append("GCInstrumentDesc(").append(GCInstrumentDesc).append(")");
		stringBuilder.append("GCFinancialInstrumentCode(").append(GCFinancialInstrumentCode).append(")");
		stringBuilder.append("GCFinancialInstrumentDesc(").append(GCFinancialInstrumentDesc).append(")");
		stringBuilder.append("GCMinRate(").append(GCMinRate).append(")");
		stringBuilder.append("GCMaxRate(").append(GCMaxRate).append(")");
		stringBuilder.append("GCAvgRate(").append(GCAvgRate).append(")");
		stringBuilder.append("GCQty(").append(GCQty).append(")");
		stringBuilder.append("GCNominalValue(").append(GCNominalValue).append(")");
		return stringBuilder.toString();
	}
}
