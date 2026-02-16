package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_HIST_RFCQ_QUOTE extends SMPMessage
{
	public static final long CLASS_ID = 114168;

	private long RfcqQuoteMsgId = 0;
	private long RfcqReqId = 0;
	private TI_RFCQ_TYPE_Enum RfcqType = TI_RFCQ_TYPE_Enum.TI_RFCQ_TYPE_Outright;
	private long TradingListId = 0;
	private short LegId = 0;
	private BV_HIST_MEMBER_INFO Provider = new BV_HIST_MEMBER_INFO();
	private String DealerReferenceId = "";
	private BV_HIST_RFCQ_QUOTING_LEG[] QuotingLeg = new BV_HIST_RFCQ_QUOTING_LEG[3];
	private TI_RFCQ_QUOTE_EVENT_Enum Event = TI_RFCQ_QUOTE_EVENT_Enum.TI_RFCQ_QUOTE_EVENT_Activate;
	private TI_RFCQ_QUOTE_STATUS_Enum Status = TI_RFCQ_QUOTE_STATUS_Enum.TI_RFCQ_QUOTE_STATUS_Active;
	private short AutomaticMatchingThreshold = 0;
	private long AutomaticMatchingValidityTime = 0;
	private long CreationDate = 0;
	private long CreationTime = 0;
	private long EditTime = 0;

	public BV_HIST_RFCQ_QUOTE()
	{
		for (int i=0; i < QuotingLeg.length; ++i)
		{
			QuotingLeg[i] = new BV_HIST_RFCQ_QUOTING_LEG();
		}
	}

	public long getRfcqQuoteMsgId()
	{
		return RfcqQuoteMsgId;
	}
	public void setRfcqQuoteMsgId(long value)
	{
		RfcqQuoteMsgId = value;
	}
	public long getRfcqReqId()
	{
		return RfcqReqId;
	}
	public void setRfcqReqId(long value)
	{
		RfcqReqId = value;
	}
	public TI_RFCQ_TYPE_Enum getRfcqType()
	{
		return RfcqType;
	}
	public void setRfcqType(TI_RFCQ_TYPE_Enum value)
	{
		RfcqType = value;
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
	public BV_HIST_MEMBER_INFO getProvider()
	{
		return Provider;
	}
	public void setProvider(BV_HIST_MEMBER_INFO value)
	{
		Provider = value;
	}
	public String getDealerReferenceId()
	{
		return DealerReferenceId;
	}
	public void setDealerReferenceId(String value)
	{
		DealerReferenceId = value;
	}
	public BV_HIST_RFCQ_QUOTING_LEG[] getQuotingLeg()
	{
		return QuotingLeg;
	}
	public void setQuotingLeg(BV_HIST_RFCQ_QUOTING_LEG[] value)
	{
		QuotingLeg = value;
	}
	public TI_RFCQ_QUOTE_EVENT_Enum getEvent()
	{
		return Event;
	}
	public void setEvent(TI_RFCQ_QUOTE_EVENT_Enum value)
	{
		Event = value;
	}
	public TI_RFCQ_QUOTE_STATUS_Enum getStatus()
	{
		return Status;
	}
	public void setStatus(TI_RFCQ_QUOTE_STATUS_Enum value)
	{
		Status = value;
	}
	public short getAutomaticMatchingThreshold()
	{
		return AutomaticMatchingThreshold;
	}
	public void setAutomaticMatchingThreshold(short value)
	{
		AutomaticMatchingThreshold = value;
	}
	public long getAutomaticMatchingValidityTime()
	{
		return AutomaticMatchingValidityTime;
	}
	public void setAutomaticMatchingValidityTime(long value)
	{
		AutomaticMatchingValidityTime = value;
	}
	public long getCreationDate()
	{
		return CreationDate;
	}
	public void setCreationDate(long value)
	{
		CreationDate = value;
	}
	public long getCreationTime()
	{
		return CreationTime;
	}
	public void setCreationTime(long value)
	{
		CreationTime = value;
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
		RfcqQuoteMsgId = (long)byteBuffer.readInt();
		RfcqReqId = (long)byteBuffer.readInt();
		RfcqType = RfcqType.getEnum(byteBuffer.readInt());
		TradingListId = (long)byteBuffer.readInt();
		LegId = (short)byteBuffer.readInt();
		Provider.readXDR(byteBuffer);
		DealerReferenceId = byteBuffer.readString();
		for (int i=0; i < QuotingLeg.length; ++i)
		{
			QuotingLeg[i].readXDR(byteBuffer);
		}
		Event = Event.getEnum(byteBuffer.readInt());
		Status = Status.getEnum(byteBuffer.readInt());
		AutomaticMatchingThreshold = (short)byteBuffer.readInt();
		AutomaticMatchingValidityTime = byteBuffer.readLong();
		CreationDate = (long)byteBuffer.readInt();
		CreationTime = byteBuffer.readLong();
		EditTime = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(RfcqQuoteMsgId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(RfcqReqId & 0xFFFFFFFFL));
		byteBuffer.writeInt(RfcqType.getValue());
		byteBuffer.writeInt((int)(TradingListId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(LegId & 0xFFFFL));
		Provider.writeXDR(byteBuffer);
		byteBuffer.writeString(DealerReferenceId);
		for (int i=0; i < QuotingLeg.length; ++i)
		{
			QuotingLeg[i].writeXDR(byteBuffer);
		}
		byteBuffer.writeInt(Event.getValue());
		byteBuffer.writeInt(Status.getValue());
		byteBuffer.writeInt((int)(AutomaticMatchingThreshold & 0xFFFFL));
		byteBuffer.writeLong(AutomaticMatchingValidityTime);
		byteBuffer.writeInt((int)(CreationDate & 0xFFFFFFFFL));
		byteBuffer.writeLong(CreationTime);
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
		stringBuilder.append("BV_HIST_RFCQ_QUOTE::");
		stringBuilder.append("RfcqQuoteMsgId(").append(RfcqQuoteMsgId).append(")");
		stringBuilder.append("RfcqReqId(").append(RfcqReqId).append(")");
		stringBuilder.append("RfcqType(").append(RfcqType).append(")");
		stringBuilder.append("TradingListId(").append(TradingListId).append(")");
		stringBuilder.append("LegId(").append(LegId).append(")");
		stringBuilder.append("Provider(").append(Provider.toString()).append(")");
		stringBuilder.append("DealerReferenceId(").append(DealerReferenceId).append(")");
		for (int i=0; i < QuotingLeg.length; ++i)
		{
			stringBuilder.append("QuotingLeg[").append(i).append("](").append(QuotingLeg[i].toString()).append(")");
		}
		stringBuilder.append("Event(").append(Event).append(")");
		stringBuilder.append("Status(").append(Status).append(")");
		stringBuilder.append("AutomaticMatchingThreshold(").append(AutomaticMatchingThreshold).append(")");
		stringBuilder.append("AutomaticMatchingValidityTime(").append(AutomaticMatchingValidityTime).append(")");
		stringBuilder.append("CreationDate(").append(CreationDate).append(")");
		stringBuilder.append("CreationTime(").append(CreationTime).append(")");
		stringBuilder.append("EditTime(").append(EditTime).append(")");
		return stringBuilder.toString();
	}
}
