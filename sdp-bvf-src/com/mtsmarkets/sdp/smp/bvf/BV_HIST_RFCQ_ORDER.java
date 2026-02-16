package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_HIST_RFCQ_ORDER extends SMPMessage
{
	public static final long CLASS_ID = 114176;

	private TI_MSG_INFO MsgInfo = new TI_MSG_INFO();
	private long RfcqReqId = 0;
	private long RfcqQuoteId = 0;
	private long TradingListId = 0;
	private short LegId = 0;
	private TI_IN_OUT_FLAG_Enum InOutFlag = TI_IN_OUT_FLAG_Enum.TI_IN_OUT_FLAG_Out;
	private BV_HIST_MEMBER_INFO Aggressor = new BV_HIST_MEMBER_INFO();
	private BV_HIST_MEMBER_INFO Provider = new BV_HIST_MEMBER_INFO();
	private String DealerReferenceId = "";
	private String ClientExecID = "";
	private String ExecTraderName = "";
	private BV_HIST_RFCQ_ORDER_LEG[] OrderLeg = new BV_HIST_RFCQ_ORDER_LEG[3];
	private TI_RFCQ_ORDER_TYPE_Enum Type = TI_RFCQ_ORDER_TYPE_Enum.TI_RFCQ_ORDER_TYPE_Normal;
	private BV_ORDER_EVENT_Enum Event = BV_ORDER_EVENT_Enum.BV_ORDER_EVENT_Insert;
	private TI_RFCQ_ORDER_STATUS_Enum Status = TI_RFCQ_ORDER_STATUS_Enum.TI_RFCQ_ORDER_STATUS_Processing;
	private TI_RFCQ_MATCHING_TYPE_Enum MatchingType = TI_RFCQ_MATCHING_TYPE_Enum.TI_RFCQ_MATCHING_TYPE_Automatic;
	private long AcceptanceTimeout = 0;
	private long DepthUpdateTime = 0;
	private TI_FLAG_Enum AutomatchingFg = TI_FLAG_Enum.TI_FLAG_No;
	private TI_FLAG_Enum PreTradeFg = TI_FLAG_Enum.TI_FLAG_No;
	private String CloseWithDealerCode = "";
	private String CloseWithDealerDesc = "";
	private String CloseWithDealerShortDesc = "";
	private long UpdateTime = 0;

	public BV_HIST_RFCQ_ORDER()
	{
		for (int i=0; i < OrderLeg.length; ++i)
		{
			OrderLeg[i] = new BV_HIST_RFCQ_ORDER_LEG();
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
	public long getRfcqQuoteId()
	{
		return RfcqQuoteId;
	}
	public void setRfcqQuoteId(long value)
	{
		RfcqQuoteId = value;
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
	public TI_IN_OUT_FLAG_Enum getInOutFlag()
	{
		return InOutFlag;
	}
	public void setInOutFlag(TI_IN_OUT_FLAG_Enum value)
	{
		InOutFlag = value;
	}
	public BV_HIST_MEMBER_INFO getAggressor()
	{
		return Aggressor;
	}
	public void setAggressor(BV_HIST_MEMBER_INFO value)
	{
		Aggressor = value;
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
	public String getClientExecID()
	{
		return ClientExecID;
	}
	public void setClientExecID(String value)
	{
		ClientExecID = value;
	}
	public String getExecTraderName()
	{
		return ExecTraderName;
	}
	public void setExecTraderName(String value)
	{
		ExecTraderName = value;
	}
	public BV_HIST_RFCQ_ORDER_LEG[] getOrderLeg()
	{
		return OrderLeg;
	}
	public void setOrderLeg(BV_HIST_RFCQ_ORDER_LEG[] value)
	{
		OrderLeg = value;
	}
	public TI_RFCQ_ORDER_TYPE_Enum getType()
	{
		return Type;
	}
	public void setType(TI_RFCQ_ORDER_TYPE_Enum value)
	{
		Type = value;
	}
	public BV_ORDER_EVENT_Enum getEvent()
	{
		return Event;
	}
	public void setEvent(BV_ORDER_EVENT_Enum value)
	{
		Event = value;
	}
	public TI_RFCQ_ORDER_STATUS_Enum getStatus()
	{
		return Status;
	}
	public void setStatus(TI_RFCQ_ORDER_STATUS_Enum value)
	{
		Status = value;
	}
	public TI_RFCQ_MATCHING_TYPE_Enum getMatchingType()
	{
		return MatchingType;
	}
	public void setMatchingType(TI_RFCQ_MATCHING_TYPE_Enum value)
	{
		MatchingType = value;
	}
	public long getAcceptanceTimeout()
	{
		return AcceptanceTimeout;
	}
	public void setAcceptanceTimeout(long value)
	{
		AcceptanceTimeout = value;
	}
	public long getDepthUpdateTime()
	{
		return DepthUpdateTime;
	}
	public void setDepthUpdateTime(long value)
	{
		DepthUpdateTime = value;
	}
	public TI_FLAG_Enum getAutomatchingFg()
	{
		return AutomatchingFg;
	}
	public void setAutomatchingFg(TI_FLAG_Enum value)
	{
		AutomatchingFg = value;
	}
	public TI_FLAG_Enum getPreTradeFg()
	{
		return PreTradeFg;
	}
	public void setPreTradeFg(TI_FLAG_Enum value)
	{
		PreTradeFg = value;
	}
	public String getCloseWithDealerCode()
	{
		return CloseWithDealerCode;
	}
	public void setCloseWithDealerCode(String value)
	{
		CloseWithDealerCode = value;
	}
	public String getCloseWithDealerDesc()
	{
		return CloseWithDealerDesc;
	}
	public void setCloseWithDealerDesc(String value)
	{
		CloseWithDealerDesc = value;
	}
	public String getCloseWithDealerShortDesc()
	{
		return CloseWithDealerShortDesc;
	}
	public void setCloseWithDealerShortDesc(String value)
	{
		CloseWithDealerShortDesc = value;
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
		RfcqQuoteId = (long)byteBuffer.readInt();
		TradingListId = (long)byteBuffer.readInt();
		LegId = (short)byteBuffer.readInt();
		InOutFlag = InOutFlag.getEnum(byteBuffer.readInt());
		Aggressor.readXDR(byteBuffer);
		Provider.readXDR(byteBuffer);
		DealerReferenceId = byteBuffer.readString();
		ClientExecID = byteBuffer.readString();
		ExecTraderName = byteBuffer.readString();
		for (int i=0; i < OrderLeg.length; ++i)
		{
			OrderLeg[i].readXDR(byteBuffer);
		}
		Type = Type.getEnum(byteBuffer.readInt());
		Event = Event.getEnum(byteBuffer.readInt());
		Status = Status.getEnum(byteBuffer.readInt());
		MatchingType = MatchingType.getEnum(byteBuffer.readInt());
		AcceptanceTimeout = byteBuffer.readLong();
		DepthUpdateTime = byteBuffer.readLong();
		AutomatchingFg = AutomatchingFg.getEnum(byteBuffer.readInt());
		PreTradeFg = PreTradeFg.getEnum(byteBuffer.readInt());
		CloseWithDealerCode = byteBuffer.readString();
		CloseWithDealerDesc = byteBuffer.readString();
		CloseWithDealerShortDesc = byteBuffer.readString();
		UpdateTime = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		MsgInfo.writeXDR(byteBuffer);
		byteBuffer.writeInt((int)(RfcqReqId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(RfcqQuoteId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(TradingListId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(LegId & 0xFFFFL));
		byteBuffer.writeInt(InOutFlag.getValue());
		Aggressor.writeXDR(byteBuffer);
		Provider.writeXDR(byteBuffer);
		byteBuffer.writeString(DealerReferenceId);
		byteBuffer.writeString(ClientExecID);
		byteBuffer.writeString(ExecTraderName);
		for (int i=0; i < OrderLeg.length; ++i)
		{
			OrderLeg[i].writeXDR(byteBuffer);
		}
		byteBuffer.writeInt(Type.getValue());
		byteBuffer.writeInt(Event.getValue());
		byteBuffer.writeInt(Status.getValue());
		byteBuffer.writeInt(MatchingType.getValue());
		byteBuffer.writeLong(AcceptanceTimeout);
		byteBuffer.writeLong(DepthUpdateTime);
		byteBuffer.writeInt(AutomatchingFg.getValue());
		byteBuffer.writeInt(PreTradeFg.getValue());
		byteBuffer.writeString(CloseWithDealerCode);
		byteBuffer.writeString(CloseWithDealerDesc);
		byteBuffer.writeString(CloseWithDealerShortDesc);
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
		stringBuilder.append("BV_HIST_RFCQ_ORDER::");
		stringBuilder.append("MsgInfo(").append(MsgInfo.toString()).append(")");
		stringBuilder.append("RfcqReqId(").append(RfcqReqId).append(")");
		stringBuilder.append("RfcqQuoteId(").append(RfcqQuoteId).append(")");
		stringBuilder.append("TradingListId(").append(TradingListId).append(")");
		stringBuilder.append("LegId(").append(LegId).append(")");
		stringBuilder.append("InOutFlag(").append(InOutFlag).append(")");
		stringBuilder.append("Aggressor(").append(Aggressor.toString()).append(")");
		stringBuilder.append("Provider(").append(Provider.toString()).append(")");
		stringBuilder.append("DealerReferenceId(").append(DealerReferenceId).append(")");
		stringBuilder.append("ClientExecID(").append(ClientExecID).append(")");
		stringBuilder.append("ExecTraderName(").append(ExecTraderName).append(")");
		for (int i=0; i < OrderLeg.length; ++i)
		{
			stringBuilder.append("OrderLeg[").append(i).append("](").append(OrderLeg[i].toString()).append(")");
		}
		stringBuilder.append("Type(").append(Type).append(")");
		stringBuilder.append("Event(").append(Event).append(")");
		stringBuilder.append("Status(").append(Status).append(")");
		stringBuilder.append("MatchingType(").append(MatchingType).append(")");
		stringBuilder.append("AcceptanceTimeout(").append(AcceptanceTimeout).append(")");
		stringBuilder.append("DepthUpdateTime(").append(DepthUpdateTime).append(")");
		stringBuilder.append("AutomatchingFg(").append(AutomatchingFg).append(")");
		stringBuilder.append("PreTradeFg(").append(PreTradeFg).append(")");
		stringBuilder.append("CloseWithDealerCode(").append(CloseWithDealerCode).append(")");
		stringBuilder.append("CloseWithDealerDesc(").append(CloseWithDealerDesc).append(")");
		stringBuilder.append("CloseWithDealerShortDesc(").append(CloseWithDealerShortDesc).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		return stringBuilder.toString();
	}
}
