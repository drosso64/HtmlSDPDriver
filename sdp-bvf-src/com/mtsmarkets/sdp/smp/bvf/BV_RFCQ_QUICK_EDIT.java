package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_RFCQ_QUICK_EDIT extends SMPMessage
{
	public static final long CLASS_ID = 114171;

	private long RfcqQuoteId = 0;
	private long RfcqReqId = 0;
	private long TradingListId = 0;
	private short LegId = 0;
	private TI_RFCQ_TYPE_Enum RfcqType = TI_RFCQ_TYPE_Enum.TI_RFCQ_TYPE_Outright;
	private long MemberId = 0;
	private long TraderId = 0;
	private BV_RFCQ_QUICK_QUOTING_LEG[] QuotingLeg = new BV_RFCQ_QUICK_QUOTING_LEG[3];
	private long EditTime = 0;
	private TI_RFCQ_QUOTE_EVENT_Enum Event = TI_RFCQ_QUOTE_EVENT_Enum.TI_RFCQ_QUOTE_EVENT_Activate;

	public BV_RFCQ_QUICK_EDIT()
	{
		for (int i=0; i < QuotingLeg.length; ++i)
		{
			QuotingLeg[i] = new BV_RFCQ_QUICK_QUOTING_LEG();
		}
	}

	public long getRfcqQuoteId()
	{
		return RfcqQuoteId;
	}
	public void setRfcqQuoteId(long value)
	{
		RfcqQuoteId = value;
	}
	public long getRfcqReqId()
	{
		return RfcqReqId;
	}
	public void setRfcqReqId(long value)
	{
		RfcqReqId = value;
	}
	public long getTradingListId()
	{
		return TradingListId;
	}
	public void setTradingListId(long value)
	{
		TradingListId = value;
	}
	public short getLegId()
	{
		return LegId;
	}
	public void setLegId(short value)
	{
		LegId = value;
	}
	public TI_RFCQ_TYPE_Enum getRfcqType()
	{
		return RfcqType;
	}
	public void setRfcqType(TI_RFCQ_TYPE_Enum value)
	{
		RfcqType = value;
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
	public BV_RFCQ_QUICK_QUOTING_LEG[] getQuotingLeg()
	{
		return QuotingLeg;
	}
	public void setQuotingLeg(BV_RFCQ_QUICK_QUOTING_LEG[] value)
	{
		QuotingLeg = value;
	}
	public long getEditTime()
	{
		return EditTime;
	}
	public void setEditTime(long value)
	{
		EditTime = value;
	}
	public TI_RFCQ_QUOTE_EVENT_Enum getEvent()
	{
		return Event;
	}
	public void setEvent(TI_RFCQ_QUOTE_EVENT_Enum value)
	{
		Event = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		RfcqQuoteId = (long)byteBuffer.readInt();
		RfcqReqId = (long)byteBuffer.readInt();
		TradingListId = (long)byteBuffer.readInt();
		LegId = (short)byteBuffer.readInt();
		RfcqType = RfcqType.getEnum(byteBuffer.readInt());
		MemberId = (long)byteBuffer.readInt();
		TraderId = (long)byteBuffer.readInt();
		for (int i=0; i < QuotingLeg.length; ++i)
		{
			QuotingLeg[i].readXDR(byteBuffer);
		}
		EditTime = byteBuffer.readLong();
		Event = Event.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(RfcqQuoteId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(RfcqReqId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(TradingListId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(LegId & 0xFFFFL));
		byteBuffer.writeInt(RfcqType.getValue());
		byteBuffer.writeInt((int)(MemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(TraderId & 0xFFFFFFFFL));
		for (int i=0; i < QuotingLeg.length; ++i)
		{
			QuotingLeg[i].writeXDR(byteBuffer);
		}
		byteBuffer.writeLong(EditTime);
		byteBuffer.writeInt(Event.getValue());

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
		stringBuilder.append("BV_RFCQ_QUICK_EDIT::");
		stringBuilder.append("RfcqQuoteId(").append(RfcqQuoteId).append(")");
		stringBuilder.append("RfcqReqId(").append(RfcqReqId).append(")");
		stringBuilder.append("TradingListId(").append(TradingListId).append(")");
		stringBuilder.append("LegId(").append(LegId).append(")");
		stringBuilder.append("RfcqType(").append(RfcqType).append(")");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("TraderId(").append(TraderId).append(")");
		for (int i=0; i < QuotingLeg.length; ++i)
		{
			stringBuilder.append("QuotingLeg[").append(i).append("](").append(QuotingLeg[i].toString()).append(")");
		}
		stringBuilder.append("EditTime(").append(EditTime).append(")");
		stringBuilder.append("Event(").append(Event).append(")");
		return stringBuilder.toString();
	}
}
