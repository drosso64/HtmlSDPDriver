package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_SECTION extends SMPMessage
{
	public static final long CLASS_ID = 100004;

	private long SectionId = 0;
	private long MarketId = 0;
	private String SectionCode = "";
	private String SectionDesc = "";
	private long TradingCalendarId = 0;
	private long SortNumber = 0;

	public TI_SECTION()
	{
	}

	public long getSectionId()
	{
		return SectionId;
	}
	public void setSectionId(long value)
	{
		SectionId = value;
	}
	public long getMarketId()
	{
		return MarketId;
	}
	public void setMarketId(long value)
	{
		MarketId = value;
	}
	public String getSectionCode()
	{
		return SectionCode;
	}
	public void setSectionCode(String value)
	{
		SectionCode = value;
	}
	public String getSectionDesc()
	{
		return SectionDesc;
	}
	public void setSectionDesc(String value)
	{
		SectionDesc = value;
	}
	public long getTradingCalendarId()
	{
		return TradingCalendarId;
	}
	public void setTradingCalendarId(long value)
	{
		TradingCalendarId = value;
	}
	public long getSortNumber()
	{
		return SortNumber;
	}
	public void setSortNumber(long value)
	{
		SortNumber = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		SectionId = (long)byteBuffer.readInt();
		MarketId = (long)byteBuffer.readInt();
		SectionCode = byteBuffer.readString();
		SectionDesc = byteBuffer.readString();
		TradingCalendarId = (long)byteBuffer.readInt();
		SortNumber = (long)byteBuffer.readInt();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(SectionId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(MarketId & 0xFFFFFFFFL));
		byteBuffer.writeString(SectionCode);
		byteBuffer.writeString(SectionDesc);
		byteBuffer.writeInt((int)(TradingCalendarId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SortNumber & 0xFFFFFFFFL));

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
		stringBuilder.append("TI_SECTION::");
		stringBuilder.append("SectionId(").append(SectionId).append(")");
		stringBuilder.append("MarketId(").append(MarketId).append(")");
		stringBuilder.append("SectionCode(").append(SectionCode).append(")");
		stringBuilder.append("SectionDesc(").append(SectionDesc).append(")");
		stringBuilder.append("TradingCalendarId(").append(TradingCalendarId).append(")");
		stringBuilder.append("SortNumber(").append(SortNumber).append(")");
		return stringBuilder.toString();
	}
}
