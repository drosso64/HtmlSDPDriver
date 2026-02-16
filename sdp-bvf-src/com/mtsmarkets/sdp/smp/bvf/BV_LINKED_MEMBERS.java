package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_LINKED_MEMBERS extends SMPMessage
{
	public static final long CLASS_ID = 114108;

	private long MarketId = 0;
	private long SectionId = 0;
	private long InstrumentClassId = 0;
	private long FirstMemberId = 0;
	private long SecondMemberId = 0;
	private BV_LINK_TYPE_Enum LinkType = BV_LINK_TYPE_Enum.BV_LINK_TYPE_NoTrading;

	public BV_LINKED_MEMBERS()
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
	public long getFirstMemberId()
	{
		return FirstMemberId;
	}
	public void setFirstMemberId(long value)
	{
		FirstMemberId = value;
	}
	public long getSecondMemberId()
	{
		return SecondMemberId;
	}
	public void setSecondMemberId(long value)
	{
		SecondMemberId = value;
	}
	public BV_LINK_TYPE_Enum getLinkType()
	{
		return LinkType;
	}
	public void setLinkType(BV_LINK_TYPE_Enum value)
	{
		LinkType = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MarketId = (long)byteBuffer.readInt();
		SectionId = (long)byteBuffer.readInt();
		InstrumentClassId = (long)byteBuffer.readInt();
		FirstMemberId = (long)byteBuffer.readInt();
		SecondMemberId = (long)byteBuffer.readInt();
		LinkType = LinkType.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MarketId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SectionId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(InstrumentClassId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(FirstMemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SecondMemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt(LinkType.getValue());

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
		stringBuilder.append("BV_LINKED_MEMBERS::");
		stringBuilder.append("MarketId(").append(MarketId).append(")");
		stringBuilder.append("SectionId(").append(SectionId).append(")");
		stringBuilder.append("InstrumentClassId(").append(InstrumentClassId).append(")");
		stringBuilder.append("FirstMemberId(").append(FirstMemberId).append(")");
		stringBuilder.append("SecondMemberId(").append(SecondMemberId).append(")");
		stringBuilder.append("LinkType(").append(LinkType).append(")");
		return stringBuilder.toString();
	}
}
