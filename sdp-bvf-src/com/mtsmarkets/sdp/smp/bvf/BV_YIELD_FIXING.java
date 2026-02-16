package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_YIELD_FIXING extends SMPMessage
{
	public static final long CLASS_ID = 400051;

	private BV_INSTRUMENT_INFO Instrument = new BV_INSTRUMENT_INFO();
	private long SectionId = 0;
	private double BidYield = 0;
	private double AskYield = 0;
	private double MidYield = 0;
	private long RefDate = 0;
	private long RefTime = 0;

	public BV_YIELD_FIXING()
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
	public double getBidYield()
	{
		return BidYield;
	}
	public void setBidYield(double value)
	{
		BidYield = value;
	}
	public double getAskYield()
	{
		return AskYield;
	}
	public void setAskYield(double value)
	{
		AskYield = value;
	}
	public double getMidYield()
	{
		return MidYield;
	}
	public void setMidYield(double value)
	{
		MidYield = value;
	}
	public long getRefDate()
	{
		return RefDate;
	}
	public void setRefDate(long value)
	{
		RefDate = value;
	}
	public long getRefTime()
	{
		return RefTime;
	}
	public void setRefTime(long value)
	{
		RefTime = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		Instrument.readXDR(byteBuffer);
		SectionId = (long)byteBuffer.readInt();
		BidYield = byteBuffer.readDouble();
		AskYield = byteBuffer.readDouble();
		MidYield = byteBuffer.readDouble();
		RefDate = (long)byteBuffer.readInt();
		RefTime = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		Instrument.writeXDR(byteBuffer);
		byteBuffer.writeInt((int)(SectionId & 0xFFFFFFFFL));
		byteBuffer.writeDouble(BidYield);
		byteBuffer.writeDouble(AskYield);
		byteBuffer.writeDouble(MidYield);
		byteBuffer.writeInt((int)(RefDate & 0xFFFFFFFFL));
		byteBuffer.writeLong(RefTime);

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
		stringBuilder.append("BV_YIELD_FIXING::");
		stringBuilder.append("Instrument(").append(Instrument.toString()).append(")");
		stringBuilder.append("SectionId(").append(SectionId).append(")");
		stringBuilder.append("BidYield(").append(BidYield).append(")");
		stringBuilder.append("AskYield(").append(AskYield).append(")");
		stringBuilder.append("MidYield(").append(MidYield).append(")");
		stringBuilder.append("RefDate(").append(RefDate).append(")");
		stringBuilder.append("RefTime(").append(RefTime).append(")");
		return stringBuilder.toString();
	}
}
