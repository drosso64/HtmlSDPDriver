package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class DF_BV_QUOTATION_LIMIT extends SMPMessage
{
	public static final long CLASS_ID = 114000;

	private long InstrumentId = 0;
	private double MinQuotationLimit = 0;
	private double MaxQuotationLimit = 0;
	private TI_TRADING_TYPE_Enum TradingType = TI_TRADING_TYPE_Enum.TI_TRADING_TYPE_CleanPrice;
	private long UpdateDate = 0;
	private long UpdateTime = 0;
	private TI_FLAG_Enum ExternalContributionFg = TI_FLAG_Enum.TI_FLAG_No;

	public DF_BV_QUOTATION_LIMIT()
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
	public double getMinQuotationLimit()
	{
		return MinQuotationLimit;
	}
	public void setMinQuotationLimit(double value)
	{
		MinQuotationLimit = value;
	}
	public double getMaxQuotationLimit()
	{
		return MaxQuotationLimit;
	}
	public void setMaxQuotationLimit(double value)
	{
		MaxQuotationLimit = value;
	}
	public TI_TRADING_TYPE_Enum getTradingType()
	{
		return TradingType;
	}
	public void setTradingType(TI_TRADING_TYPE_Enum value)
	{
		TradingType = value;
	}
	public long getUpdateDate()
	{
		return UpdateDate;
	}
	public void setUpdateDate(long value)
	{
		UpdateDate = value;
	}
	public long getUpdateTime()
	{
		return UpdateTime;
	}
	public void setUpdateTime(long value)
	{
		UpdateTime = value;
	}
	public TI_FLAG_Enum getExternalContributionFg()
	{
		return ExternalContributionFg;
	}
	public void setExternalContributionFg(TI_FLAG_Enum value)
	{
		ExternalContributionFg = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		InstrumentId = (long)byteBuffer.readInt();
		MinQuotationLimit = byteBuffer.readDouble();
		MaxQuotationLimit = byteBuffer.readDouble();
		TradingType = TradingType.getEnum(byteBuffer.readInt());
		UpdateDate = (long)byteBuffer.readInt();
		UpdateTime = byteBuffer.readLong();
		ExternalContributionFg = ExternalContributionFg.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(InstrumentId & 0xFFFFFFFFL));
		byteBuffer.writeDouble(MinQuotationLimit);
		byteBuffer.writeDouble(MaxQuotationLimit);
		byteBuffer.writeInt(TradingType.getValue());
		byteBuffer.writeInt((int)(UpdateDate & 0xFFFFFFFFL));
		byteBuffer.writeLong(UpdateTime);
		byteBuffer.writeInt(ExternalContributionFg.getValue());

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
		stringBuilder.append("DF_BV_QUOTATION_LIMIT::");
		stringBuilder.append("InstrumentId(").append(InstrumentId).append(")");
		stringBuilder.append("MinQuotationLimit(").append(MinQuotationLimit).append(")");
		stringBuilder.append("MaxQuotationLimit(").append(MaxQuotationLimit).append(")");
		stringBuilder.append("TradingType(").append(TradingType).append(")");
		stringBuilder.append("UpdateDate(").append(UpdateDate).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		stringBuilder.append("ExternalContributionFg(").append(ExternalContributionFg).append(")");
		return stringBuilder.toString();
	}
}
