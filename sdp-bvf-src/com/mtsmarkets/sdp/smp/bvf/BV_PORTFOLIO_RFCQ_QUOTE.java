package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_PORTFOLIO_RFCQ_QUOTE extends SMPMessage
{
	public static final long CLASS_ID = 400079;

	private long RfcqQuoteMsgId = 0;
	private long RfcqReqId = 0;
	private BV_MEMBER_INFO Provider = new BV_MEMBER_INFO();
	private long AggressorMemberId = 0;
	private String DealerReferenceId = "";
	private short NumOfLegs = 0;
	private BV_PORTFOLIO_RFCQ_QUOTING_LEG[] QuotingLeg = new BV_PORTFOLIO_RFCQ_QUOTING_LEG[200];
	private double NetProceeds = 0;
	private BV_PORTFOLIO_RFCQ_QUOTE_EVENT_Enum Event = BV_PORTFOLIO_RFCQ_QUOTE_EVENT_Enum.BV_PORTFOLIO_RFCQ_QUOTE_EVENT_Activate;
	private BV_PORTFOLIO_RFCQ_QUOTE_STATUS_Enum Status = BV_PORTFOLIO_RFCQ_QUOTE_STATUS_Enum.BV_PORTFOLIO_RFCQ_QUOTE_STATUS_Active;
	private long CreationDate = 0;
	private long CreationTime = 0;
	private long EditTime = 0;

	public BV_PORTFOLIO_RFCQ_QUOTE()
	{
		for (int i=0; i < QuotingLeg.length; ++i)
		{
			QuotingLeg[i] = new BV_PORTFOLIO_RFCQ_QUOTING_LEG();
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
	public BV_MEMBER_INFO getProvider()
	{
		return Provider;
	}
	public void setProvider(BV_MEMBER_INFO value)
	{
		Provider = value;
	}
	public long getAggressorMemberId()
	{
		return AggressorMemberId;
	}
	public void setAggressorMemberId(long value)
	{
		AggressorMemberId = value;
	}
	public String getDealerReferenceId()
	{
		return DealerReferenceId;
	}
	public void setDealerReferenceId(String value)
	{
		DealerReferenceId = value;
	}
	public short getNumOfLegs()
	{
		return NumOfLegs;
	}
	public void setNumOfLegs(short value)
	{
		NumOfLegs = value;
	}
	public BV_PORTFOLIO_RFCQ_QUOTING_LEG[] getQuotingLeg()
	{
		return QuotingLeg;
	}
	public void setQuotingLeg(BV_PORTFOLIO_RFCQ_QUOTING_LEG[] value)
	{
		QuotingLeg = value;
	}
	public double getNetProceeds()
	{
		return NetProceeds;
	}
	public void setNetProceeds(double value)
	{
		NetProceeds = value;
	}
	public BV_PORTFOLIO_RFCQ_QUOTE_EVENT_Enum getEvent()
	{
		return Event;
	}
	public void setEvent(BV_PORTFOLIO_RFCQ_QUOTE_EVENT_Enum value)
	{
		Event = value;
	}
	public BV_PORTFOLIO_RFCQ_QUOTE_STATUS_Enum getStatus()
	{
		return Status;
	}
	public void setStatus(BV_PORTFOLIO_RFCQ_QUOTE_STATUS_Enum value)
	{
		Status = value;
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
		Provider.readXDR(byteBuffer);
		AggressorMemberId = (long)byteBuffer.readInt();
		DealerReferenceId = byteBuffer.readString();
		NumOfLegs = (short)byteBuffer.readInt();
		for (int i=0; i < QuotingLeg.length; ++i)
		{
			QuotingLeg[i].readXDR(byteBuffer);
		}
		NetProceeds = byteBuffer.readDouble();
		Event = Event.getEnum(byteBuffer.readInt());
		Status = Status.getEnum(byteBuffer.readInt());
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
		Provider.writeXDR(byteBuffer);
		byteBuffer.writeInt((int)(AggressorMemberId & 0xFFFFFFFFL));
		byteBuffer.writeString(DealerReferenceId);
		byteBuffer.writeInt((int)(NumOfLegs & 0xFFFFL));
		for (int i=0; i < QuotingLeg.length; ++i)
		{
			QuotingLeg[i].writeXDR(byteBuffer);
		}
		byteBuffer.writeDouble(NetProceeds);
		byteBuffer.writeInt(Event.getValue());
		byteBuffer.writeInt(Status.getValue());
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
		stringBuilder.append("BV_PORTFOLIO_RFCQ_QUOTE::");
		stringBuilder.append("RfcqQuoteMsgId(").append(RfcqQuoteMsgId).append(")");
		stringBuilder.append("RfcqReqId(").append(RfcqReqId).append(")");
		stringBuilder.append("Provider(").append(Provider.toString()).append(")");
		stringBuilder.append("AggressorMemberId(").append(AggressorMemberId).append(")");
		stringBuilder.append("DealerReferenceId(").append(DealerReferenceId).append(")");
		stringBuilder.append("NumOfLegs(").append(NumOfLegs).append(")");
		for (int i=0; i < QuotingLeg.length; ++i)
		{
			stringBuilder.append("QuotingLeg[").append(i).append("](").append(QuotingLeg[i].toString()).append(")");
		}
		stringBuilder.append("NetProceeds(").append(NetProceeds).append(")");
		stringBuilder.append("Event(").append(Event).append(")");
		stringBuilder.append("Status(").append(Status).append(")");
		stringBuilder.append("CreationDate(").append(CreationDate).append(")");
		stringBuilder.append("CreationTime(").append(CreationTime).append(")");
		stringBuilder.append("EditTime(").append(EditTime).append(")");
		return stringBuilder.toString();
	}
}
