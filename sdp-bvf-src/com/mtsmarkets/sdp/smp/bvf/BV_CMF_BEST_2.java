package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_CMF_BEST_2 extends SMPMessage
{
	public static final long CLASS_ID = 400050;

	private BV_INSTRUMENT_INFO Instrument = new BV_INSTRUMENT_INFO();
	private long SectionId = 0;
	private String CMFSectionCode = "";
	private String CMFSectionDesc = "";
	private BV_TRADING_INFO Bid = new BV_TRADING_INFO();
	private BV_TRADING_INFO Ask = new BV_TRADING_INFO();
	private long UpdateTime = 0;

	public BV_CMF_BEST_2()
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
	public BV_TRADING_INFO getBid()
	{
		return Bid;
	}
	public void setBid(BV_TRADING_INFO value)
	{
		Bid = value;
	}
	public BV_TRADING_INFO getAsk()
	{
		return Ask;
	}
	public void setAsk(BV_TRADING_INFO value)
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
		Bid.readXDR(byteBuffer);
		Ask.readXDR(byteBuffer);
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
		Bid.writeXDR(byteBuffer);
		Ask.writeXDR(byteBuffer);
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
		stringBuilder.append("BV_CMF_BEST_2::");
		stringBuilder.append("Instrument(").append(Instrument.toString()).append(")");
		stringBuilder.append("SectionId(").append(SectionId).append(")");
		stringBuilder.append("CMFSectionCode(").append(CMFSectionCode).append(")");
		stringBuilder.append("CMFSectionDesc(").append(CMFSectionDesc).append(")");
		stringBuilder.append("Bid(").append(Bid.toString()).append(")");
		stringBuilder.append("Ask(").append(Ask.toString()).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		return stringBuilder.toString();
	}
}
