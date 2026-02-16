package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_PORTFOLIO_RFCQ extends SMPMessage
{
	public static final long CLASS_ID = 400078;

	private TI_MSG_INFO MsgInfo = new TI_MSG_INFO();
	private long RfcqReqId = 0;
	private BV_MEMBER_INFO Aggressor = new BV_MEMBER_INFO();
	private BV_MEMBER_INFO Provider = new BV_MEMBER_INFO();
	private BV_PORTFOLIO_RFCQ_CLOSING_TYPE_Enum ClosingType = BV_PORTFOLIO_RFCQ_CLOSING_TYPE_Enum.BV_PORTFOLIO_RFCQ_CLOSING_TYPE_None;
	private TI_FLAG_Enum PreAgreedFg = TI_FLAG_Enum.TI_FLAG_No;
	private short NumOfLegs = 0;
	private BV_PORTFOLIO_RFCQ_LEG[] PortfolioLeg = new BV_PORTFOLIO_RFCQ_LEG[200];
	private BV_PORTFOLIO_RFCQ_EVENT_Enum Event = BV_PORTFOLIO_RFCQ_EVENT_Enum.BV_PORTFOLIO_RFCQ_EVENT_Accept;
	private BV_PORTFOLIO_RFCQ_STATUS_Enum Status = BV_PORTFOLIO_RFCQ_STATUS_Enum.BV_PORTFOLIO_RFCQ_STATUS_Processing;
	private short NumOfCompetitors = 0;
	private long RfcqDuration = 0;
	private long RfcqTimeout = 0;
	private short MOCAcceptanceTime = 0;
	private short DueInTime = 0;
	private long DueInTimeout = 0;
	private long UpdateTime = 0;

	public BV_PORTFOLIO_RFCQ()
	{
		for (int i=0; i < PortfolioLeg.length; ++i)
		{
			PortfolioLeg[i] = new BV_PORTFOLIO_RFCQ_LEG();
		}
	}

	public TI_MSG_INFO getMsgInfo()
	{
		return MsgInfo;
	}
	public void setMsgInfo(TI_MSG_INFO value)
	{
		MsgInfo = value;
	}
	public long getRfcqReqId()
	{
		return RfcqReqId;
	}
	public void setRfcqReqId(long value)
	{
		RfcqReqId = value;
	}
	public BV_MEMBER_INFO getAggressor()
	{
		return Aggressor;
	}
	public void setAggressor(BV_MEMBER_INFO value)
	{
		Aggressor = value;
	}
	public BV_MEMBER_INFO getProvider()
	{
		return Provider;
	}
	public void setProvider(BV_MEMBER_INFO value)
	{
		Provider = value;
	}
	public BV_PORTFOLIO_RFCQ_CLOSING_TYPE_Enum getClosingType()
	{
		return ClosingType;
	}
	public void setClosingType(BV_PORTFOLIO_RFCQ_CLOSING_TYPE_Enum value)
	{
		ClosingType = value;
	}
	public TI_FLAG_Enum getPreAgreedFg()
	{
		return PreAgreedFg;
	}
	public void setPreAgreedFg(TI_FLAG_Enum value)
	{
		PreAgreedFg = value;
	}
	public short getNumOfLegs()
	{
		return NumOfLegs;
	}
	public void setNumOfLegs(short value)
	{
		NumOfLegs = value;
	}
	public BV_PORTFOLIO_RFCQ_LEG[] getPortfolioLeg()
	{
		return PortfolioLeg;
	}
	public void setPortfolioLeg(BV_PORTFOLIO_RFCQ_LEG[] value)
	{
		PortfolioLeg = value;
	}
	public BV_PORTFOLIO_RFCQ_EVENT_Enum getEvent()
	{
		return Event;
	}
	public void setEvent(BV_PORTFOLIO_RFCQ_EVENT_Enum value)
	{
		Event = value;
	}
	public BV_PORTFOLIO_RFCQ_STATUS_Enum getStatus()
	{
		return Status;
	}
	public void setStatus(BV_PORTFOLIO_RFCQ_STATUS_Enum value)
	{
		Status = value;
	}
	public short getNumOfCompetitors()
	{
		return NumOfCompetitors;
	}
	public void setNumOfCompetitors(short value)
	{
		NumOfCompetitors = value;
	}
	public long getRfcqDuration()
	{
		return RfcqDuration;
	}
	public void setRfcqDuration(long value)
	{
		RfcqDuration = value;
	}
	public long getRfcqTimeout()
	{
		return RfcqTimeout;
	}
	public void setRfcqTimeout(long value)
	{
		RfcqTimeout = value;
	}
	public short getMOCAcceptanceTime()
	{
		return MOCAcceptanceTime;
	}
	public void setMOCAcceptanceTime(short value)
	{
		MOCAcceptanceTime = value;
	}
	public short getDueInTime()
	{
		return DueInTime;
	}
	public void setDueInTime(short value)
	{
		DueInTime = value;
	}
	public long getDueInTimeout()
	{
		return DueInTimeout;
	}
	public void setDueInTimeout(long value)
	{
		DueInTimeout = value;
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
		MsgInfo.readXDR(byteBuffer);
		RfcqReqId = (long)byteBuffer.readInt();
		Aggressor.readXDR(byteBuffer);
		Provider.readXDR(byteBuffer);
		ClosingType = ClosingType.getEnum(byteBuffer.readInt());
		PreAgreedFg = PreAgreedFg.getEnum(byteBuffer.readInt());
		NumOfLegs = (short)byteBuffer.readInt();
		for (int i=0; i < PortfolioLeg.length; ++i)
		{
			PortfolioLeg[i].readXDR(byteBuffer);
		}
		Event = Event.getEnum(byteBuffer.readInt());
		Status = Status.getEnum(byteBuffer.readInt());
		NumOfCompetitors = (short)byteBuffer.readInt();
		RfcqDuration = (long)byteBuffer.readInt();
		RfcqTimeout = byteBuffer.readLong();
		MOCAcceptanceTime = (short)byteBuffer.readInt();
		DueInTime = (short)byteBuffer.readInt();
		DueInTimeout = byteBuffer.readLong();
		UpdateTime = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		MsgInfo.writeXDR(byteBuffer);
		byteBuffer.writeInt((int)(RfcqReqId & 0xFFFFFFFFL));
		Aggressor.writeXDR(byteBuffer);
		Provider.writeXDR(byteBuffer);
		byteBuffer.writeInt(ClosingType.getValue());
		byteBuffer.writeInt(PreAgreedFg.getValue());
		byteBuffer.writeInt((int)(NumOfLegs & 0xFFFFL));
		for (int i=0; i < PortfolioLeg.length; ++i)
		{
			PortfolioLeg[i].writeXDR(byteBuffer);
		}
		byteBuffer.writeInt(Event.getValue());
		byteBuffer.writeInt(Status.getValue());
		byteBuffer.writeInt((int)(NumOfCompetitors & 0xFFFFL));
		byteBuffer.writeInt((int)(RfcqDuration & 0xFFFFFFFFL));
		byteBuffer.writeLong(RfcqTimeout);
		byteBuffer.writeInt((int)(MOCAcceptanceTime & 0xFFFFL));
		byteBuffer.writeInt((int)(DueInTime & 0xFFFFL));
		byteBuffer.writeLong(DueInTimeout);
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
		stringBuilder.append("BV_PORTFOLIO_RFCQ::");
		stringBuilder.append("MsgInfo(").append(MsgInfo.toString()).append(")");
		stringBuilder.append("RfcqReqId(").append(RfcqReqId).append(")");
		stringBuilder.append("Aggressor(").append(Aggressor.toString()).append(")");
		stringBuilder.append("Provider(").append(Provider.toString()).append(")");
		stringBuilder.append("ClosingType(").append(ClosingType).append(")");
		stringBuilder.append("PreAgreedFg(").append(PreAgreedFg).append(")");
		stringBuilder.append("NumOfLegs(").append(NumOfLegs).append(")");
		for (int i=0; i < PortfolioLeg.length; ++i)
		{
			stringBuilder.append("PortfolioLeg[").append(i).append("](").append(PortfolioLeg[i].toString()).append(")");
		}
		stringBuilder.append("Event(").append(Event).append(")");
		stringBuilder.append("Status(").append(Status).append(")");
		stringBuilder.append("NumOfCompetitors(").append(NumOfCompetitors).append(")");
		stringBuilder.append("RfcqDuration(").append(RfcqDuration).append(")");
		stringBuilder.append("RfcqTimeout(").append(RfcqTimeout).append(")");
		stringBuilder.append("MOCAcceptanceTime(").append(MOCAcceptanceTime).append(")");
		stringBuilder.append("DueInTime(").append(DueInTime).append(")");
		stringBuilder.append("DueInTimeout(").append(DueInTimeout).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		return stringBuilder.toString();
	}
}
