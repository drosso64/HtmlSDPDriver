package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_INVENTORY_QUOTE_INFO extends SMPMessage
{
	public static final long CLASS_ID = 114928;

	private TI_MSG_INFO QuoteMsgInfo = new TI_MSG_INFO();
	private BV_MEMBER_INFO Provider = new BV_MEMBER_INFO();
	private BV_INSTRUMENT_INFO Instrument = new BV_INSTRUMENT_INFO();
	private long GroupId = 0;
	private BV_QUOTE_EVENT_Enum Event = BV_QUOTE_EVENT_Enum.BV_QUOTE_EVENT_Activate;
	private BV_INVENTORY_QUOTE_STATUS_Enum QuoteStatus = BV_INVENTORY_QUOTE_STATUS_Enum.BV_INVENTORY_QUOTE_STATUS_Active;
	private BV_QUOTING_SIDE_Enum QuotingSide = BV_QUOTING_SIDE_Enum.BV_QUOTING_SIDE_Bid;
	private BV_INVENTORY_QUOTING_DATA Bid = new BV_INVENTORY_QUOTING_DATA();
	private BV_INVENTORY_QUOTING_DATA Ask = new BV_INVENTORY_QUOTING_DATA();
	private TI_FLAG_Enum AdjustedFg = TI_FLAG_Enum.TI_FLAG_No;
	private TI_FLAG_Enum ShowOnlyInDealerPageFg = TI_FLAG_Enum.TI_FLAG_No;
	private TI_FLAG_Enum ExecutableFg = TI_FLAG_Enum.TI_FLAG_No;
	private TI_FLAG_Enum SystematicInternaliserFg = TI_FLAG_Enum.TI_FLAG_No;
	private String DealerReferenceId = "";
	private long EditTime = 0;

	public BV_INVENTORY_QUOTE_INFO()
	{
	}

	public TI_MSG_INFO getQuoteMsgInfo()
	{
		return QuoteMsgInfo;
	}
	public void setQuoteMsgInfo(TI_MSG_INFO value)
	{
		QuoteMsgInfo = value;
	}
	public BV_MEMBER_INFO getProvider()
	{
		return Provider;
	}
	public void setProvider(BV_MEMBER_INFO value)
	{
		Provider = value;
	}
	public BV_INSTRUMENT_INFO getInstrument()
	{
		return Instrument;
	}
	public void setInstrument(BV_INSTRUMENT_INFO value)
	{
		Instrument = value;
	}
	public long getGroupId()
	{
		return GroupId;
	}
	public void setGroupId(long value)
	{
		GroupId = value;
	}
	public BV_QUOTE_EVENT_Enum getEvent()
	{
		return Event;
	}
	public void setEvent(BV_QUOTE_EVENT_Enum value)
	{
		Event = value;
	}
	public BV_INVENTORY_QUOTE_STATUS_Enum getQuoteStatus()
	{
		return QuoteStatus;
	}
	public void setQuoteStatus(BV_INVENTORY_QUOTE_STATUS_Enum value)
	{
		QuoteStatus = value;
	}
	public BV_QUOTING_SIDE_Enum getQuotingSide()
	{
		return QuotingSide;
	}
	public void setQuotingSide(BV_QUOTING_SIDE_Enum value)
	{
		QuotingSide = value;
	}
	public BV_INVENTORY_QUOTING_DATA getBid()
	{
		return Bid;
	}
	public void setBid(BV_INVENTORY_QUOTING_DATA value)
	{
		Bid = value;
	}
	public BV_INVENTORY_QUOTING_DATA getAsk()
	{
		return Ask;
	}
	public void setAsk(BV_INVENTORY_QUOTING_DATA value)
	{
		Ask = value;
	}
	public TI_FLAG_Enum getAdjustedFg()
	{
		return AdjustedFg;
	}
	public void setAdjustedFg(TI_FLAG_Enum value)
	{
		AdjustedFg = value;
	}
	public TI_FLAG_Enum getShowOnlyInDealerPageFg()
	{
		return ShowOnlyInDealerPageFg;
	}
	public void setShowOnlyInDealerPageFg(TI_FLAG_Enum value)
	{
		ShowOnlyInDealerPageFg = value;
	}
	public TI_FLAG_Enum getExecutableFg()
	{
		return ExecutableFg;
	}
	public void setExecutableFg(TI_FLAG_Enum value)
	{
		ExecutableFg = value;
	}
	public TI_FLAG_Enum getSystematicInternaliserFg()
	{
		return SystematicInternaliserFg;
	}
	public void setSystematicInternaliserFg(TI_FLAG_Enum value)
	{
		SystematicInternaliserFg = value;
	}
	public String getDealerReferenceId()
	{
		return DealerReferenceId;
	}
	public void setDealerReferenceId(String value)
	{
		DealerReferenceId = value;
	}
	public long getEditTime()
	{
		return EditTime;
	}
	public void setEditTime(long value)
	{
		EditTime = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		QuoteMsgInfo.readXDR(byteBuffer);
		Provider.readXDR(byteBuffer);
		Instrument.readXDR(byteBuffer);
		GroupId = (long)byteBuffer.readInt();
		Event = Event.getEnum(byteBuffer.readInt());
		QuoteStatus = QuoteStatus.getEnum(byteBuffer.readInt());
		QuotingSide = QuotingSide.getEnum(byteBuffer.readInt());
		Bid.readXDR(byteBuffer);
		Ask.readXDR(byteBuffer);
		AdjustedFg = AdjustedFg.getEnum(byteBuffer.readInt());
		ShowOnlyInDealerPageFg = ShowOnlyInDealerPageFg.getEnum(byteBuffer.readInt());
		ExecutableFg = ExecutableFg.getEnum(byteBuffer.readInt());
		SystematicInternaliserFg = SystematicInternaliserFg.getEnum(byteBuffer.readInt());
		DealerReferenceId = byteBuffer.readString();
		EditTime = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		QuoteMsgInfo.writeXDR(byteBuffer);
		Provider.writeXDR(byteBuffer);
		Instrument.writeXDR(byteBuffer);
		byteBuffer.writeInt((int)(GroupId & 0xFFFFFFFFL));
		byteBuffer.writeInt(Event.getValue());
		byteBuffer.writeInt(QuoteStatus.getValue());
		byteBuffer.writeInt(QuotingSide.getValue());
		Bid.writeXDR(byteBuffer);
		Ask.writeXDR(byteBuffer);
		byteBuffer.writeInt(AdjustedFg.getValue());
		byteBuffer.writeInt(ShowOnlyInDealerPageFg.getValue());
		byteBuffer.writeInt(ExecutableFg.getValue());
		byteBuffer.writeInt(SystematicInternaliserFg.getValue());
		byteBuffer.writeString(DealerReferenceId);
		byteBuffer.writeLong(EditTime);

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
		stringBuilder.append("BV_INVENTORY_QUOTE_INFO::");
		stringBuilder.append("QuoteMsgInfo(").append(QuoteMsgInfo.toString()).append(")");
		stringBuilder.append("Provider(").append(Provider.toString()).append(")");
		stringBuilder.append("Instrument(").append(Instrument.toString()).append(")");
		stringBuilder.append("GroupId(").append(GroupId).append(")");
		stringBuilder.append("Event(").append(Event).append(")");
		stringBuilder.append("QuoteStatus(").append(QuoteStatus).append(")");
		stringBuilder.append("QuotingSide(").append(QuotingSide).append(")");
		stringBuilder.append("Bid(").append(Bid.toString()).append(")");
		stringBuilder.append("Ask(").append(Ask.toString()).append(")");
		stringBuilder.append("AdjustedFg(").append(AdjustedFg).append(")");
		stringBuilder.append("ShowOnlyInDealerPageFg(").append(ShowOnlyInDealerPageFg).append(")");
		stringBuilder.append("ExecutableFg(").append(ExecutableFg).append(")");
		stringBuilder.append("SystematicInternaliserFg(").append(SystematicInternaliserFg).append(")");
		stringBuilder.append("DealerReferenceId(").append(DealerReferenceId).append(")");
		stringBuilder.append("EditTime(").append(EditTime).append(")");
		return stringBuilder.toString();
	}
}
