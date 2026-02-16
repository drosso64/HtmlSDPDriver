package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_CMF_DEPTH_2 extends SMPMessage
{
	public static final long CLASS_ID = 400049;

	private BV_INSTRUMENT_INFO Instrument = new BV_INSTRUMENT_INFO();
	private long SectionId = 0;
	private String CMFSectionCode = "";
	private String CMFSectionDesc = "";
	private BV_TRADING_INFO[] Bid = new BV_TRADING_INFO[20];
	private BV_TRADING_INFO[] Ask = new BV_TRADING_INFO[20];
	private long UpdateTime = 0;

	public BV_CMF_DEPTH_2()
	{
		for (int i=0; i < Bid.length; ++i)
		{
			Bid[i] = new BV_TRADING_INFO();
		}
		for (int i=0; i < Ask.length; ++i)
		{
			Ask[i] = new BV_TRADING_INFO();
		}
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
	public String getCMFSectionCode()
	{
		return CMFSectionCode;
	}
	public void setCMFSectionCode(String value)
	{
		CMFSectionCode = value;
	}
	public String getCMFSectionDesc()
	{
		return CMFSectionDesc;
	}
	public void setCMFSectionDesc(String value)
	{
		CMFSectionDesc = value;
	}
	public BV_TRADING_INFO[] getBid()
	{
		return Bid;
	}
	public void setBid(BV_TRADING_INFO[] value)
	{
		Bid = value;
	}
	public BV_TRADING_INFO[] getAsk()
	{
		return Ask;
	}
	public void setAsk(BV_TRADING_INFO[] value)
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
		Instrument.readXDR(byteBuffer);
		SectionId = (long)byteBuffer.readInt();
		CMFSectionCode = byteBuffer.readString();
		CMFSectionDesc = byteBuffer.readString();
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

		Instrument.writeXDR(byteBuffer);
		byteBuffer.writeInt((int)(SectionId & 0xFFFFFFFFL));
		byteBuffer.writeString(CMFSectionCode);
		byteBuffer.writeString(CMFSectionDesc);
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
		stringBuilder.append("BV_CMF_DEPTH_2::");
		stringBuilder.append("Instrument(").append(Instrument.toString()).append(")");
		stringBuilder.append("SectionId(").append(SectionId).append(")");
		stringBuilder.append("CMFSectionCode(").append(CMFSectionCode).append(")");
		stringBuilder.append("CMFSectionDesc(").append(CMFSectionDesc).append(")");
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
