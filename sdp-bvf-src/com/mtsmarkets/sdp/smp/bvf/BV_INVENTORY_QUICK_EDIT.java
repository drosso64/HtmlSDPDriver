package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_INVENTORY_QUICK_EDIT extends SMPMessage
{
	public static final long CLASS_ID = 114170;

	private long QuoteId = 0;
	private long MarketId = 0;
	private long SectionId = 0;
	private long InstrumentId = 0;
	private long MemberId = 0;
	private long TraderId = 0;
	private long EditTime = 0;
	private double BidQuotation = 0;
	private double AskQuotation = 0;
	private TI_FLAG_Enum ShowOnlyInDealerPageFg = TI_FLAG_Enum.TI_FLAG_No;
	private BV_QUOTE_EVENT_Enum Event = BV_QUOTE_EVENT_Enum.BV_QUOTE_EVENT_Activate;
	private String DealerReferenceId = "";

	public BV_INVENTORY_QUICK_EDIT()
	{
	}

	public long getQuoteId()
	{
		return QuoteId;
	}
	public void setQuoteId(long value)
	{
		QuoteId = value;
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
	public long getInstrumentId()
	{
		return InstrumentId;
	}
	public void setInstrumentId(long value)
	{
		InstrumentId = value;
	}
	public long getMemberId()
	{
		return MemberId;
	}
	public void setMemberId(long value)
	{
		MemberId = value;
	}
	public long getTraderId()
	{
		return TraderId;
	}
	public void setTraderId(long value)
	{
		TraderId = value;
	}
	public long getEditTime()
	{
		return EditTime;
	}
	public void setEditTime(long value)
	{
		EditTime = value;
	}
	public double getBidQuotation()
	{
		return BidQuotation;
	}
	public void setBidQuotation(double value)
	{
		BidQuotation = value;
	}
	public double getAskQuotation()
	{
		return AskQuotation;
	}
	public void setAskQuotation(double value)
	{
		AskQuotation = value;
	}
	public TI_FLAG_Enum getShowOnlyInDealerPageFg()
	{
		return ShowOnlyInDealerPageFg;
	}
	public void setShowOnlyInDealerPageFg(TI_FLAG_Enum value)
	{
		ShowOnlyInDealerPageFg = value;
	}
	public BV_QUOTE_EVENT_Enum getEvent()
	{
		return Event;
	}
	public void setEvent(BV_QUOTE_EVENT_Enum value)
	{
		Event = value;
	}
	public String getDealerReferenceId()
	{
		return DealerReferenceId;
	}
	public void setDealerReferenceId(String value)
	{
		DealerReferenceId = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		QuoteId = (long)byteBuffer.readInt();
		MarketId = (long)byteBuffer.readInt();
		SectionId = (long)byteBuffer.readInt();
		InstrumentId = (long)byteBuffer.readInt();
		MemberId = (long)byteBuffer.readInt();
		TraderId = (long)byteBuffer.readInt();
		EditTime = byteBuffer.readLong();
		BidQuotation = byteBuffer.readDouble();
		AskQuotation = byteBuffer.readDouble();
		ShowOnlyInDealerPageFg = ShowOnlyInDealerPageFg.getEnum(byteBuffer.readInt());
		Event = Event.getEnum(byteBuffer.readInt());
		DealerReferenceId = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(QuoteId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(MarketId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SectionId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(InstrumentId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(MemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(TraderId & 0xFFFFFFFFL));
		byteBuffer.writeLong(EditTime);
		byteBuffer.writeDouble(BidQuotation);
		byteBuffer.writeDouble(AskQuotation);
		byteBuffer.writeInt(ShowOnlyInDealerPageFg.getValue());
		byteBuffer.writeInt(Event.getValue());
		byteBuffer.writeString(DealerReferenceId);

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
		stringBuilder.append("BV_INVENTORY_QUICK_EDIT::");
		stringBuilder.append("QuoteId(").append(QuoteId).append(")");
		stringBuilder.append("MarketId(").append(MarketId).append(")");
		stringBuilder.append("SectionId(").append(SectionId).append(")");
		stringBuilder.append("InstrumentId(").append(InstrumentId).append(")");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("TraderId(").append(TraderId).append(")");
		stringBuilder.append("EditTime(").append(EditTime).append(")");
		stringBuilder.append("BidQuotation(").append(BidQuotation).append(")");
		stringBuilder.append("AskQuotation(").append(AskQuotation).append(")");
		stringBuilder.append("ShowOnlyInDealerPageFg(").append(ShowOnlyInDealerPageFg).append(")");
		stringBuilder.append("Event(").append(Event).append(")");
		stringBuilder.append("DealerReferenceId(").append(DealerReferenceId).append(")");
		return stringBuilder.toString();
	}
}
