package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_RATES extends SMPMessage
{
	public static final long CLASS_ID = 100030;

	private long FinancialInstrumentId = 0;
	private String FinancialInstrumentCode = "";
	private String FinancialInstrumentDesc = "";
	private short RateCalculationPeriod = 0;
	private TI_PERIOD_Enum RateCalculationUnit = TI_PERIOD_Enum.TI_PERIOD_Day;
	private String CurrencyId = "";
	private String InstrumentBusinessCenterId = "";
	private String CurrencyBusinessCenterId = "";

	public TI_RATES()
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
	public short getRateCalculationPeriod()
	{
		return RateCalculationPeriod;
	}
	public void setRateCalculationPeriod(short value)
	{
		RateCalculationPeriod = value;
	}
	public TI_PERIOD_Enum getRateCalculationUnit()
	{
		return RateCalculationUnit;
	}
	public void setRateCalculationUnit(TI_PERIOD_Enum value)
	{
		RateCalculationUnit = value;
	}
	public String getCurrencyId()
	{
		return CurrencyId;
	}
	public void setCurrencyId(String value)
	{
		CurrencyId = value;
	}
	public String getInstrumentBusinessCenterId()
	{
		return InstrumentBusinessCenterId;
	}
	public void setInstrumentBusinessCenterId(String value)
	{
		InstrumentBusinessCenterId = value;
	}
	public String getCurrencyBusinessCenterId()
	{
		return CurrencyBusinessCenterId;
	}
	public void setCurrencyBusinessCenterId(String value)
	{
		CurrencyBusinessCenterId = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		FinancialInstrumentId = (long)byteBuffer.readInt();
		FinancialInstrumentCode = byteBuffer.readString();
		FinancialInstrumentDesc = byteBuffer.readString();
		RateCalculationPeriod = (short)byteBuffer.readInt();
		RateCalculationUnit = RateCalculationUnit.getEnum(byteBuffer.readInt());
		CurrencyId = byteBuffer.readString();
		InstrumentBusinessCenterId = byteBuffer.readString();
		CurrencyBusinessCenterId = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(FinancialInstrumentId & 0xFFFFFFFFL));
		byteBuffer.writeString(FinancialInstrumentCode);
		byteBuffer.writeString(FinancialInstrumentDesc);
		byteBuffer.writeInt((int)(RateCalculationPeriod & 0xFFFFL));
		byteBuffer.writeInt(RateCalculationUnit.getValue());
		byteBuffer.writeString(CurrencyId);
		byteBuffer.writeString(InstrumentBusinessCenterId);
		byteBuffer.writeString(CurrencyBusinessCenterId);

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
		stringBuilder.append("TI_RATES::");
		stringBuilder.append("FinancialInstrumentId(").append(FinancialInstrumentId).append(")");
		stringBuilder.append("FinancialInstrumentCode(").append(FinancialInstrumentCode).append(")");
		stringBuilder.append("FinancialInstrumentDesc(").append(FinancialInstrumentDesc).append(")");
		stringBuilder.append("RateCalculationPeriod(").append(RateCalculationPeriod).append(")");
		stringBuilder.append("RateCalculationUnit(").append(RateCalculationUnit).append(")");
		stringBuilder.append("CurrencyId(").append(CurrencyId).append(")");
		stringBuilder.append("InstrumentBusinessCenterId(").append(InstrumentBusinessCenterId).append(")");
		stringBuilder.append("CurrencyBusinessCenterId(").append(CurrencyBusinessCenterId).append(")");
		return stringBuilder.toString();
	}
}
