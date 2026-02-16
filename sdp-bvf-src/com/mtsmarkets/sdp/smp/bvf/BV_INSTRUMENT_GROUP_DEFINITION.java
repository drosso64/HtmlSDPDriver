package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_INSTRUMENT_GROUP_DEFINITION extends SMPMessage
{
	public static final long CLASS_ID = 114157;

	private long MarketId = 0;
	private long GroupId = 0;
	private long SectionId = 0;
	private long InstrumentClassId = 0;
	private long InstrumentId = 0;

	public BV_INSTRUMENT_GROUP_DEFINITION()
	{
	}

	public long getMarketId()
	{
		return MarketId;
	}
	public void setMarketId(long value)
	{
		MarketId = value;
	}
	public long getGroupId()
	{
		return GroupId;
	}
	public void setGroupId(long value)
	{
		GroupId = value;
	}
	public long getSectionId()
	{
		return SectionId;
	}
	public void setSectionId(long value)
	{
		SectionId = value;
	}
	public long getInstrumentClassId()
	{
		return InstrumentClassId;
	}
	public void setInstrumentClassId(long value)
	{
		InstrumentClassId = value;
	}
	public long getInstrumentId()
	{
		return InstrumentId;
	}
	public void setInstrumentId(long value)
	{
		InstrumentId = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MarketId = (long)byteBuffer.readInt();
		GroupId = (long)byteBuffer.readInt();
		SectionId = (long)byteBuffer.readInt();
		InstrumentClassId = (long)byteBuffer.readInt();
		InstrumentId = (long)byteBuffer.readInt();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MarketId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(GroupId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SectionId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(InstrumentClassId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(InstrumentId & 0xFFFFFFFFL));

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
		stringBuilder.append("BV_INSTRUMENT_GROUP_DEFINITION::");
		stringBuilder.append("MarketId(").append(MarketId).append(")");
		stringBuilder.append("GroupId(").append(GroupId).append(")");
		stringBuilder.append("SectionId(").append(SectionId).append(")");
		stringBuilder.append("InstrumentClassId(").append(InstrumentClassId).append(")");
		stringBuilder.append("InstrumentId(").append(InstrumentId).append(")");
		return stringBuilder.toString();
	}
}
