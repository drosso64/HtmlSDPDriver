package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_HIST_PORTFOLIO_RFCQ_QUOTE extends SMPMessage
{
	public static final long CLASS_ID = 400080;

	private long RfcqQuoteMsgId = 0;
	private long RfcqReqId = 0;
	private BV_HIST_MEMBER_INFO Provider = new BV_HIST_MEMBER_INFO();
	private String AggressorMemberCode = "";
	private String AggressorMemberShortDesc = "";
	private String AggressorMemberDesc = "";
	private String DealerReferenceId = "";
	private short NumOfLegs = 0;
	private BV_HIST_PORTFOLIO_RFCQ_QUOTING_LEG QuotingLeg = new BV_HIST_PORTFOLIO_RFCQ_QUOTING_LEG();
	private double NetProceeds = 0;
	private BV_PORTFOLIO_RFCQ_QUOTE_EVENT_Enum Event = BV_PORTFOLIO_RFCQ_QUOTE_EVENT_Enum.BV_PORTFOLIO_RFCQ_QUOTE_EVENT_Activate;
	private BV_PORTFOLIO_RFCQ_QUOTE_STATUS_Enum Status = BV_PORTFOLIO_RFCQ_QUOTE_STATUS_Enum.BV_PORTFOLIO_RFCQ_QUOTE_STATUS_Active;
	private long CreationDate = 0;
	private long CreationTime = 0;
	private long EditTime = 0;

	public BV_HIST_PORTFOLIO_RFCQ_QUOTE()
	{
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
	public BV_HIST_MEMBER_INFO getProvider()
	{
		return Provider;
	}
	public void setProvider(BV_HIST_MEMBER_INFO value)
	{
		Provider = value;
	}
	public String getAggressorMemberCode()
	{
		return AggressorMemberCode;
	}
	public void setAggressorMemberCode(String value)
	{
		AggressorMemberCode = value;
	}
	public String getAggressorMemberShortDesc()
	{
		return AggressorMemberShortDesc;
	}
	public void setAggressorMemberShortDesc(String value)
	{
		AggressorMemberShortDesc = value;
	}
	public String getAggressorMemberDesc()
	{
		return AggressorMemberDesc;
	}
	public void setAggressorMemberDesc(String value)
	{
		AggressorMemberDesc = value;
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
	public BV_HIST_PORTFOLIO_RFCQ_QUOTING_LEG getQuotingLeg()
	{
		return QuotingLeg;
	}
	public void setQuotingLeg(BV_HIST_PORTFOLIO_RFCQ_QUOTING_LEG value)
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
		AggressorMemberCode = byteBuffer.readString();
		AggressorMemberShortDesc = byteBuffer.readString();
		AggressorMemberDesc = byteBuffer.readString();
		DealerReferenceId = byteBuffer.readString();
		NumOfLegs = (short)byteBuffer.readInt();
		QuotingLeg.readXDR(byteBuffer);
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
		byteBuffer.writeString(AggressorMemberCode);
		byteBuffer.writeString(AggressorMemberShortDesc);
		byteBuffer.writeString(AggressorMemberDesc);
		byteBuffer.writeString(DealerReferenceId);
		byteBuffer.writeInt((int)(NumOfLegs & 0xFFFFL));
		QuotingLeg.writeXDR(byteBuffer);
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
		stringBuilder.append("BV_HIST_PORTFOLIO_RFCQ_QUOTE::");
		stringBuilder.append("RfcqQuoteMsgId(").append(RfcqQuoteMsgId).append(")");
		stringBuilder.append("RfcqReqId(").append(RfcqReqId).append(")");
		stringBuilder.append("Provider(").append(Provider.toString()).append(")");
		stringBuilder.append("AggressorMemberCode(").append(AggressorMemberCode).append(")");
		stringBuilder.append("AggressorMemberShortDesc(").append(AggressorMemberShortDesc).append(")");
		stringBuilder.append("AggressorMemberDesc(").append(AggressorMemberDesc).append(")");
		stringBuilder.append("DealerReferenceId(").append(DealerReferenceId).append(")");
		stringBuilder.append("NumOfLegs(").append(NumOfLegs).append(")");
		stringBuilder.append("QuotingLeg(").append(QuotingLeg.toString()).append(")");
		stringBuilder.append("NetProceeds(").append(NetProceeds).append(")");
		stringBuilder.append("Event(").append(Event).append(")");
		stringBuilder.append("Status(").append(Status).append(")");
		stringBuilder.append("CreationDate(").append(CreationDate).append(")");
		stringBuilder.append("CreationTime(").append(CreationTime).append(")");
		stringBuilder.append("EditTime(").append(EditTime).append(")");
		return stringBuilder.toString();
	}
}
