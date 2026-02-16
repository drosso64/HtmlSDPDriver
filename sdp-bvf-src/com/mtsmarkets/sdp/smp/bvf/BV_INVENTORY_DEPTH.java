package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_INVENTORY_DEPTH extends SMPMessage
{
	public static final long CLASS_ID = 114162;

	private long MemberId = 0;
	private BV_INSTRUMENT_INFO Instrument = new BV_INSTRUMENT_INFO();
	private long SectionId = 0;
	private BV_INVENTORY_TRADING_INFO[] Bid = new BV_INVENTORY_TRADING_INFO[30];
	private BV_INVENTORY_TRADING_INFO[] Ask = new BV_INVENTORY_TRADING_INFO[30];
	private long UpdateTime = 0;

	public BV_INVENTORY_DEPTH()
	{
		for (int i=0; i < Bid.length; ++i)
		{
			Bid[i] = new BV_INVENTORY_TRADING_INFO();
		}
		for (int i=0; i < Ask.length; ++i)
		{
			Ask[i] = new BV_INVENTORY_TRADING_INFO();
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
	public BV_INVENTORY_TRADING_INFO[] getBid()
	{
		return Bid;
	}
	public void setBid(BV_INVENTORY_TRADING_INFO[] value)
	{
		Bid = value;
	}
	public BV_INVENTORY_TRADING_INFO[] getAsk()
	{
		return Ask;
	}
	public void setAsk(BV_INVENTORY_TRADING_INFO[] value)
	{
		Ask = value;
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
		MemberId = (long)byteBuffer.readInt();
		Instrument.readXDR(byteBuffer);
		SectionId = (long)byteBuffer.readInt();
		for (int i=0; i < Bid.length; ++i)
		{
			Bid[i].readXDR(byteBuffer);
		}
		for (int i=0; i < Ask.length; ++i)
		{
			Ask[i].readXDR(byteBuffer);
		}
		UpdateTime = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MemberId & 0xFFFFFFFFL));
		Instrument.writeXDR(byteBuffer);
		byteBuffer.writeInt((int)(SectionId & 0xFFFFFFFFL));
		for (int i=0; i < Bid.length; ++i)
		{
			Bid[i].writeXDR(byteBuffer);
		}
		for (int i=0; i < Ask.length; ++i)
		{
			Ask[i].writeXDR(byteBuffer);
		}
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
		stringBuilder.append("BV_INVENTORY_DEPTH::");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("Instrument(").append(Instrument.toString()).append(")");
		stringBuilder.append("SectionId(").append(SectionId).append(")");
		for (int i=0; i < Bid.length; ++i)
		{
			stringBuilder.append("Bid[").append(i).append("](").append(Bid[i].toString()).append(")");
		}
		for (int i=0; i < Ask.length; ++i)
		{
			stringBuilder.append("Ask[").append(i).append("](").append(Ask[i].toString()).append(")");
		}
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		return stringBuilder.toString();
	}
}
