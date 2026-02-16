package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_PORTFOLIO_RFCQ_REQUEST extends SMPMessage
{
	public static final long CLASS_ID = 400076;

	private TI_MSG_INFO MsgInfo = new TI_MSG_INFO();
	private BV_MEMBER_INFO Aggressor = new BV_MEMBER_INFO();
	private BV_PORTFOLIO_RFCQ_CLOSING_TYPE_Enum ClosingType = BV_PORTFOLIO_RFCQ_CLOSING_TYPE_Enum.BV_PORTFOLIO_RFCQ_CLOSING_TYPE_None;
	private TI_FLAG_Enum PreAgreedFg = TI_FLAG_Enum.TI_FLAG_No;
	private String ClientRfcqId = "";
	private long PreviewId = 0;
	private short NumOfLegs = 0;
	private BV_PORTFOLIO_RFCQ_REQUEST_LEG[] PortfolioLeg = new BV_PORTFOLIO_RFCQ_REQUEST_LEG[200];
	private BV_PORTFOLIO_RFCQ_SELL_SIDE_MEMBER_INFO[] SellSideMemberInfo = new BV_PORTFOLIO_RFCQ_SELL_SIDE_MEMBER_INFO[10];
	private double RefNetProceeds = 0;
	private String RefNetProceedsCurrency = "";
	private String PortfolioProceedsCurrency = "";
	private BV_PORTFOLIO_RFCQ_REQUEST_EVENT_Enum Event = BV_PORTFOLIO_RFCQ_REQUEST_EVENT_Enum.BV_PORTFOLIO_RFCQ_REQUEST_EVENT_Insert;
	private BV_PORTFOLIO_RFCQ_REQUEST_STATUS_Enum Status = BV_PORTFOLIO_RFCQ_REQUEST_STATUS_Enum.BV_PORTFOLIO_RFCQ_REQUEST_STATUS_Processing;
	private long RfcqDuration = 0;
	private long RfcqTimeout = 0;
	private short MOCAcceptanceTime = 0;
	private String UserInfo1 = "";
	private String UserInfo2 = "";
	private short DueInTime = 0;
	private long DueInTimeout = 0;
	private long UpdateTime = 0;

	public BV_PORTFOLIO_RFCQ_REQUEST()
	{
		for (int i=0; i < PortfolioLeg.length; ++i)
		{
			PortfolioLeg[i] = new BV_PORTFOLIO_RFCQ_REQUEST_LEG();
		}
		for (int i=0; i < SellSideMemberInfo.length; ++i)
		{
			SellSideMemberInfo[i] = new BV_PORTFOLIO_RFCQ_SELL_SIDE_MEMBER_INFO();
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
	public BV_MEMBER_INFO getAggressor()
	{
		return Aggressor;
	}
	public void setAggressor(BV_MEMBER_INFO value)
	{
		Aggressor = value;
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
	public String getClientRfcqId()
	{
		return ClientRfcqId;
	}
	public void setClientRfcqId(String value)
	{
		ClientRfcqId = value;
	}
	public long getPreviewId()
	{
		return PreviewId;
	}
	public void setPreviewId(long value)
	{
		PreviewId = value;
	}
	public short getNumOfLegs()
	{
		return NumOfLegs;
	}
	public void setNumOfLegs(short value)
	{
		NumOfLegs = value;
	}
	public BV_PORTFOLIO_RFCQ_REQUEST_LEG[] getPortfolioLeg()
	{
		return PortfolioLeg;
	}
	public void setPortfolioLeg(BV_PORTFOLIO_RFCQ_REQUEST_LEG[] value)
	{
		PortfolioLeg = value;
	}
	public BV_PORTFOLIO_RFCQ_SELL_SIDE_MEMBER_INFO[] getSellSideMemberInfo()
	{
		return SellSideMemberInfo;
	}
	public void setSellSideMemberInfo(BV_PORTFOLIO_RFCQ_SELL_SIDE_MEMBER_INFO[] value)
	{
		SellSideMemberInfo = value;
	}
	public double getRefNetProceeds()
	{
		return RefNetProceeds;
	}
	public void setRefNetProceeds(double value)
	{
		RefNetProceeds = value;
	}
	public String getRefNetProceedsCurrency()
	{
		return RefNetProceedsCurrency;
	}
	public void setRefNetProceedsCurrency(String value)
	{
		RefNetProceedsCurrency = value;
	}
	public String getPortfolioProceedsCurrency()
	{
		return PortfolioProceedsCurrency;
	}
	public void setPortfolioProceedsCurrency(String value)
	{
		PortfolioProceedsCurrency = value;
	}
	public BV_PORTFOLIO_RFCQ_REQUEST_EVENT_Enum getEvent()
	{
		return Event;
	}
	public void setEvent(BV_PORTFOLIO_RFCQ_REQUEST_EVENT_Enum value)
	{
		Event = value;
	}
	public BV_PORTFOLIO_RFCQ_REQUEST_STATUS_Enum getStatus()
	{
		return Status;
	}
	public void setStatus(BV_PORTFOLIO_RFCQ_REQUEST_STATUS_Enum value)
	{
		Status = value;
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
	public String getUserInfo1()
	{
		return UserInfo1;
	}
	public void setUserInfo1(String value)
	{
		UserInfo1 = value;
	}
	public String getUserInfo2()
	{
		return UserInfo2;
	}
	public void setUserInfo2(String value)
	{
		UserInfo2 = value;
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
		Aggressor.readXDR(byteBuffer);
		ClosingType = ClosingType.getEnum(byteBuffer.readInt());
		PreAgreedFg = PreAgreedFg.getEnum(byteBuffer.readInt());
		ClientRfcqId = byteBuffer.readString();
		PreviewId = (long)byteBuffer.readInt();
		NumOfLegs = (short)byteBuffer.readInt();
		for (int i=0; i < PortfolioLeg.length; ++i)
		{
			PortfolioLeg[i].readXDR(byteBuffer);
		}
		for (int i=0; i < SellSideMemberInfo.length; ++i)
		{
			SellSideMemberInfo[i].readXDR(byteBuffer);
		}
		RefNetProceeds = byteBuffer.readDouble();
		RefNetProceedsCurrency = byteBuffer.readString();
		PortfolioProceedsCurrency = byteBuffer.readString();
		Event = Event.getEnum(byteBuffer.readInt());
		Status = Status.getEnum(byteBuffer.readInt());
		RfcqDuration = (long)byteBuffer.readInt();
		RfcqTimeout = byteBuffer.readLong();
		MOCAcceptanceTime = (short)byteBuffer.readInt();
		UserInfo1 = byteBuffer.readString();
		UserInfo2 = byteBuffer.readString();
		DueInTime = (short)byteBuffer.readInt();
		DueInTimeout = byteBuffer.readLong();
		UpdateTime = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		MsgInfo.writeXDR(byteBuffer);
		Aggressor.writeXDR(byteBuffer);
		byteBuffer.writeInt(ClosingType.getValue());
		byteBuffer.writeInt(PreAgreedFg.getValue());
		byteBuffer.writeString(ClientRfcqId);
		byteBuffer.writeInt((int)(PreviewId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(NumOfLegs & 0xFFFFL));
		for (int i=0; i < PortfolioLeg.length; ++i)
		{
			PortfolioLeg[i].writeXDR(byteBuffer);
		}
		for (int i=0; i < SellSideMemberInfo.length; ++i)
		{
			SellSideMemberInfo[i].writeXDR(byteBuffer);
		}
		byteBuffer.writeDouble(RefNetProceeds);
		byteBuffer.writeString(RefNetProceedsCurrency);
		byteBuffer.writeString(PortfolioProceedsCurrency);
		byteBuffer.writeInt(Event.getValue());
		byteBuffer.writeInt(Status.getValue());
		byteBuffer.writeInt((int)(RfcqDuration & 0xFFFFFFFFL));
		byteBuffer.writeLong(RfcqTimeout);
		byteBuffer.writeInt((int)(MOCAcceptanceTime & 0xFFFFL));
		byteBuffer.writeString(UserInfo1);
		byteBuffer.writeString(UserInfo2);
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
		stringBuilder.append("BV_PORTFOLIO_RFCQ_REQUEST::");
		stringBuilder.append("MsgInfo(").append(MsgInfo.toString()).append(")");
		stringBuilder.append("Aggressor(").append(Aggressor.toString()).append(")");
		stringBuilder.append("ClosingType(").append(ClosingType).append(")");
		stringBuilder.append("PreAgreedFg(").append(PreAgreedFg).append(")");
		stringBuilder.append("ClientRfcqId(").append(ClientRfcqId).append(")");
		stringBuilder.append("PreviewId(").append(PreviewId).append(")");
		stringBuilder.append("NumOfLegs(").append(NumOfLegs).append(")");
		for (int i=0; i < PortfolioLeg.length; ++i)
		{
			stringBuilder.append("PortfolioLeg[").append(i).append("](").append(PortfolioLeg[i].toString()).append(")");
		}
		for (int i=0; i < SellSideMemberInfo.length; ++i)
		{
			stringBuilder.append("SellSideMemberInfo[").append(i).append("](").append(SellSideMemberInfo[i].toString()).append(")");
		}
		stringBuilder.append("RefNetProceeds(").append(RefNetProceeds).append(")");
		stringBuilder.append("RefNetProceedsCurrency(").append(RefNetProceedsCurrency).append(")");
		stringBuilder.append("PortfolioProceedsCurrency(").append(PortfolioProceedsCurrency).append(")");
		stringBuilder.append("Event(").append(Event).append(")");
		stringBuilder.append("Status(").append(Status).append(")");
		stringBuilder.append("RfcqDuration(").append(RfcqDuration).append(")");
		stringBuilder.append("RfcqTimeout(").append(RfcqTimeout).append(")");
		stringBuilder.append("MOCAcceptanceTime(").append(MOCAcceptanceTime).append(")");
		stringBuilder.append("UserInfo1(").append(UserInfo1).append(")");
		stringBuilder.append("UserInfo2(").append(UserInfo2).append(")");
		stringBuilder.append("DueInTime(").append(DueInTime).append(")");
		stringBuilder.append("DueInTimeout(").append(DueInTimeout).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		return stringBuilder.toString();
	}
}
