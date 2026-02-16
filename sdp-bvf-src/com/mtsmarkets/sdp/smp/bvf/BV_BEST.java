package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_BEST extends SMPMessage
{
	public static final long CLASS_ID = 114161;

	private BV_INSTRUMENT_INFO Instrument = new BV_INSTRUMENT_INFO();
	private long SectionId = 0;
	private BV_BEST_TRADING_INFO Bid = new BV_BEST_TRADING_INFO();
	private BV_BEST_TRADING_INFO Ask = new BV_BEST_TRADING_INFO();
	private double MidPrice = 0;
	private double MidYield = 0;
	private BV_VALUE MidYTC = new BV_VALUE();
	private BV_VALUE MidYTW = new BV_VALUE();
	private BV_VALUE MidYMWTh = new BV_VALUE();
	private double MidMWCPriceTh = 0;
	private BV_VALUE MidYMWExrc = new BV_VALUE();
	private BV_VALUE MidYTR = new BV_VALUE();
	private BV_ANALYTICS MidAnalytics = new BV_ANALYTICS();
	private TI_FLAG_Enum MidValidityFg = TI_FLAG_Enum.TI_FLAG_No;
	private long UpdateTime = 0;

	public BV_BEST()
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
	public BV_BEST_TRADING_INFO getBid()
	{
		return Bid;
	}
	public void setBid(BV_BEST_TRADING_INFO value)
	{
		Bid = value;
	}
	public BV_BEST_TRADING_INFO getAsk()
	{
		return Ask;
	}
	public void setAsk(BV_BEST_TRADING_INFO value)
	{
		Ask = value;
	}
	public double getMidPrice()
	{
		return MidPrice;
	}
	public void setMidPrice(double value)
	{
		MidPrice = value;
	}
	public double getMidYield()
	{
		return MidYield;
	}
	public void setMidYield(double value)
	{
		MidYield = value;
	}
	public BV_VALUE getMidYTC()
	{
		return MidYTC;
	}
	public void setMidYTC(BV_VALUE value)
	{
		MidYTC = value;
	}
	public BV_VALUE getMidYTW()
	{
		return MidYTW;
	}
	public void setMidYTW(BV_VALUE value)
	{
		MidYTW = value;
	}
	public BV_VALUE getMidYMWTh()
	{
		return MidYMWTh;
	}
	public void setMidYMWTh(BV_VALUE value)
	{
		MidYMWTh = value;
	}
	public double getMidMWCPriceTh()
	{
		return MidMWCPriceTh;
	}
	public void setMidMWCPriceTh(double value)
	{
		MidMWCPriceTh = value;
	}
	public BV_VALUE getMidYMWExrc()
	{
		return MidYMWExrc;
	}
	public void setMidYMWExrc(BV_VALUE value)
	{
		MidYMWExrc = value;
	}
	public BV_VALUE getMidYTR()
	{
		return MidYTR;
	}
	public void setMidYTR(BV_VALUE value)
	{
		MidYTR = value;
	}
	public BV_ANALYTICS getMidAnalytics()
	{
		return MidAnalytics;
	}
	public void setMidAnalytics(BV_ANALYTICS value)
	{
		MidAnalytics = value;
	}
	public TI_FLAG_Enum getMidValidityFg()
	{
		return MidValidityFg;
	}
	public void setMidValidityFg(TI_FLAG_Enum value)
	{
		MidValidityFg = value;
	}
	public long getUpdateTime()
	{
		return UpdateTime;
	}
	public void setUpdateTime(long value)
	{
		UpdateTime = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		Instrument.readXDR(byteBuffer);
		SectionId = (long)byteBuffer.readInt();
		Bid.readXDR(byteBuffer);
		Ask.readXDR(byteBuffer);
		MidPrice = byteBuffer.readDouble();
		MidYield = byteBuffer.readDouble();
		MidYTC.readXDR(byteBuffer);
		MidYTW.readXDR(byteBuffer);
		MidYMWTh.readXDR(byteBuffer);
		MidMWCPriceTh = byteBuffer.readDouble();
		MidYMWExrc.readXDR(byteBuffer);
		MidYTR.readXDR(byteBuffer);
		MidAnalytics.readXDR(byteBuffer);
		MidValidityFg = MidValidityFg.getEnum(byteBuffer.readInt());
		UpdateTime = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		Instrument.writeXDR(byteBuffer);
		byteBuffer.writeInt((int)(SectionId & 0xFFFFFFFFL));
		Bid.writeXDR(byteBuffer);
		Ask.writeXDR(byteBuffer);
		byteBuffer.writeDouble(MidPrice);
		byteBuffer.writeDouble(MidYield);
		MidYTC.writeXDR(byteBuffer);
		MidYTW.writeXDR(byteBuffer);
		MidYMWTh.writeXDR(byteBuffer);
		byteBuffer.writeDouble(MidMWCPriceTh);
		MidYMWExrc.writeXDR(byteBuffer);
		MidYTR.writeXDR(byteBuffer);
		MidAnalytics.writeXDR(byteBuffer);
		byteBuffer.writeInt(MidValidityFg.getValue());
		byteBuffer.writeLong(UpdateTime);

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
		stringBuilder.append("BV_BEST::");
		stringBuilder.append("Instrument(").append(Instrument.toString()).append(")");
		stringBuilder.append("SectionId(").append(SectionId).append(")");
		stringBuilder.append("Bid(").append(Bid.toString()).append(")");
		stringBuilder.append("Ask(").append(Ask.toString()).append(")");
		stringBuilder.append("MidPrice(").append(MidPrice).append(")");
		stringBuilder.append("MidYield(").append(MidYield).append(")");
		stringBuilder.append("MidYTC(").append(MidYTC.toString()).append(")");
		stringBuilder.append("MidYTW(").append(MidYTW.toString()).append(")");
		stringBuilder.append("MidYMWTh(").append(MidYMWTh.toString()).append(")");
		stringBuilder.append("MidMWCPriceTh(").append(MidMWCPriceTh).append(")");
		stringBuilder.append("MidYMWExrc(").append(MidYMWExrc.toString()).append(")");
		stringBuilder.append("MidYTR(").append(MidYTR.toString()).append(")");
		stringBuilder.append("MidAnalytics(").append(MidAnalytics.toString()).append(")");
		stringBuilder.append("MidValidityFg(").append(MidValidityFg).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		return stringBuilder.toString();
	}
}
