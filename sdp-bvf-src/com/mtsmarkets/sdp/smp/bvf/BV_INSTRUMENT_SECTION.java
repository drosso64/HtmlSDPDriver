package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_INSTRUMENT_SECTION extends SMPMessage
{
	public static final long CLASS_ID = 114102;

	private BV_INSTRUMENT_INFO Instrument = new BV_INSTRUMENT_INFO();
	private long MarketId = 0;
	private long SectionId = 0;
	private long SettlGroupId = 0;
	private long LastTradingDate = 0;

	public BV_INSTRUMENT_SECTION()
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
	public long getSettlGroupId()
	{
		return SettlGroupId;
	}
	public void setSettlGroupId(long value)
	{
		SettlGroupId = value;
	}
	public long getLastTradingDate()
	{
		return LastTradingDate;
	}
	public void setLastTradingDate(long value)
	{
		LastTradingDate = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		Instrument.readXDR(byteBuffer);
		MarketId = (long)byteBuffer.readInt();
		SectionId = (long)byteBuffer.readInt();
		SettlGroupId = (long)byteBuffer.readInt();
		LastTradingDate = (long)byteBuffer.readInt();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		Instrument.writeXDR(byteBuffer);
		byteBuffer.writeInt((int)(MarketId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SectionId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SettlGroupId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(LastTradingDate & 0xFFFFFFFFL));

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
		stringBuilder.append("BV_INSTRUMENT_SECTION::");
		stringBuilder.append("Instrument(").append(Instrument.toString()).append(")");
		stringBuilder.append("MarketId(").append(MarketId).append(")");
		stringBuilder.append("SectionId(").append(SectionId).append(")");
		stringBuilder.append("SettlGroupId(").append(SettlGroupId).append(")");
		stringBuilder.append("LastTradingDate(").append(LastTradingDate).append(")");
		return stringBuilder.toString();
	}
}
