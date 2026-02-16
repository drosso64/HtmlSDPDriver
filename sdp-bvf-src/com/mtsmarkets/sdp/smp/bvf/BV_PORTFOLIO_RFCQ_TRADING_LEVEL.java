package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_PORTFOLIO_RFCQ_TRADING_LEVEL extends SMPMessage
{
	public static final long CLASS_ID = 410021;

	private long MemberId = 0;
	private long QuoteId = 0;
	private long QuoteUpdateTime = 0;
	private BV_PORTFOLIO_RFCQ_TRADING_LEG[] TradingLeg = new BV_PORTFOLIO_RFCQ_TRADING_LEG[200];
	private double NetProceeds = 0;

	public BV_PORTFOLIO_RFCQ_TRADING_LEVEL()
	{
		for (int i=0; i < TradingLeg.length; ++i)
		{
			TradingLeg[i] = new BV_PORTFOLIO_RFCQ_TRADING_LEG();
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
	public BV_PORTFOLIO_RFCQ_TRADING_LEG[] getTradingLeg()
	{
		return TradingLeg;
	}
	public void setTradingLeg(BV_PORTFOLIO_RFCQ_TRADING_LEG[] value)
	{
		TradingLeg = value;
	}
	public double getNetProceeds()
	{
		return NetProceeds;
	}
	public void setNetProceeds(double value)
	{
		NetProceeds = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MemberId = (long)byteBuffer.readInt();
		QuoteId = (long)byteBuffer.readInt();
		QuoteUpdateTime = byteBuffer.readLong();
		for (int i=0; i < TradingLeg.length; ++i)
		{
			TradingLeg[i].readXDR(byteBuffer);
		}
		NetProceeds = byteBuffer.readDouble();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(QuoteId & 0xFFFFFFFFL));
		byteBuffer.writeLong(QuoteUpdateTime);
		for (int i=0; i < TradingLeg.length; ++i)
		{
			TradingLeg[i].writeXDR(byteBuffer);
		}
		byteBuffer.writeDouble(NetProceeds);

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
		stringBuilder.append("BV_PORTFOLIO_RFCQ_TRADING_LEVEL::");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("QuoteId(").append(QuoteId).append(")");
		stringBuilder.append("QuoteUpdateTime(").append(QuoteUpdateTime).append(")");
		for (int i=0; i < TradingLeg.length; ++i)
		{
			stringBuilder.append("TradingLeg[").append(i).append("](").append(TradingLeg[i].toString()).append(")");
		}
		stringBuilder.append("NetProceeds(").append(NetProceeds).append(")");
		return stringBuilder.toString();
	}
}
