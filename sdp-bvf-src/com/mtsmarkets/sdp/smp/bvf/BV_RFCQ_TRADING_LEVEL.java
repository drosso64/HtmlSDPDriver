package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_RFCQ_TRADING_LEVEL extends SMPMessage
{
	public static final long CLASS_ID = 114938;

	private long MemberId = 0;
	private long QuoteId = 0;
	private long QuoteUpdateTime = 0;
	private long AutomaticMatchingValidityTime = 0;
	private TI_RFCQ_MATCHING_TYPE_Enum QuoteMatchingType = TI_RFCQ_MATCHING_TYPE_Enum.TI_RFCQ_MATCHING_TYPE_Automatic;
	private BV_RFCQ_TRADING_LEG[] TradingLeg = new BV_RFCQ_TRADING_LEG[3];
	private double GrossYieldSpread = 0;
	private double ProceedsSpread = 0;
	private double RiskWeightedYieldSpread = 0;

	public BV_RFCQ_TRADING_LEVEL()
	{
		for (int i=0; i < TradingLeg.length; ++i)
		{
			TradingLeg[i] = new BV_RFCQ_TRADING_LEG();
		}
	}

	public long getMemberId()
	{
		return MemberId;
	}
	public void setMemberId(long value)
	{
		MemberId = value;
	}
	public long getQuoteId()
	{
		return QuoteId;
	}
	public void setQuoteId(long value)
	{
		QuoteId = value;
	}
	public long getQuoteUpdateTime()
	{
		return QuoteUpdateTime;
	}
	public void setQuoteUpdateTime(long value)
	{
		QuoteUpdateTime = value;
	}
	public long getAutomaticMatchingValidityTime()
	{
		return AutomaticMatchingValidityTime;
	}
	public void setAutomaticMatchingValidityTime(long value)
	{
		AutomaticMatchingValidityTime = value;
	}
	public TI_RFCQ_MATCHING_TYPE_Enum getQuoteMatchingType()
	{
		return QuoteMatchingType;
	}
	public void setQuoteMatchingType(TI_RFCQ_MATCHING_TYPE_Enum value)
	{
		QuoteMatchingType = value;
	}
	public BV_RFCQ_TRADING_LEG[] getTradingLeg()
	{
		return TradingLeg;
	}
	public void setTradingLeg(BV_RFCQ_TRADING_LEG[] value)
	{
		TradingLeg = value;
	}
	public double getGrossYieldSpread()
	{
		return GrossYieldSpread;
	}
	public void setGrossYieldSpread(double value)
	{
		GrossYieldSpread = value;
	}
	public double getProceedsSpread()
	{
		return ProceedsSpread;
	}
	public void setProceedsSpread(double value)
	{
		ProceedsSpread = value;
	}
	public double getRiskWeightedYieldSpread()
	{
		return RiskWeightedYieldSpread;
	}
	public void setRiskWeightedYieldSpread(double value)
	{
		RiskWeightedYieldSpread = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MemberId = (long)byteBuffer.readInt();
		QuoteId = (long)byteBuffer.readInt();
		QuoteUpdateTime = byteBuffer.readLong();
		AutomaticMatchingValidityTime = byteBuffer.readLong();
		QuoteMatchingType = QuoteMatchingType.getEnum(byteBuffer.readInt());
		for (int i=0; i < TradingLeg.length; ++i)
		{
			TradingLeg[i].readXDR(byteBuffer);
		}
		GrossYieldSpread = byteBuffer.readDouble();
		ProceedsSpread = byteBuffer.readDouble();
		RiskWeightedYieldSpread = byteBuffer.readDouble();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(QuoteId & 0xFFFFFFFFL));
		byteBuffer.writeLong(QuoteUpdateTime);
		byteBuffer.writeLong(AutomaticMatchingValidityTime);
		byteBuffer.writeInt(QuoteMatchingType.getValue());
		for (int i=0; i < TradingLeg.length; ++i)
		{
			TradingLeg[i].writeXDR(byteBuffer);
		}
		byteBuffer.writeDouble(GrossYieldSpread);
		byteBuffer.writeDouble(ProceedsSpread);
		byteBuffer.writeDouble(RiskWeightedYieldSpread);

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
		stringBuilder.append("BV_RFCQ_TRADING_LEVEL::");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("QuoteId(").append(QuoteId).append(")");
		stringBuilder.append("QuoteUpdateTime(").append(QuoteUpdateTime).append(")");
		stringBuilder.append("AutomaticMatchingValidityTime(").append(AutomaticMatchingValidityTime).append(")");
		stringBuilder.append("QuoteMatchingType(").append(QuoteMatchingType).append(")");
		for (int i=0; i < TradingLeg.length; ++i)
		{
			stringBuilder.append("TradingLeg[").append(i).append("](").append(TradingLeg[i].toString()).append(")");
		}
		stringBuilder.append("GrossYieldSpread(").append(GrossYieldSpread).append(")");
		stringBuilder.append("ProceedsSpread(").append(ProceedsSpread).append(")");
		stringBuilder.append("RiskWeightedYieldSpread(").append(RiskWeightedYieldSpread).append(")");
		return stringBuilder.toString();
	}
}
