package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_HIST_PORTFOLIO_RFCQ_ORDER extends SMPMessage
{
	public static final long CLASS_ID = 400084;

	private TI_MSG_INFO MsgInfo = new TI_MSG_INFO();
	private long RfcqReqId = 0;
	private long RfcqQuoteId = 0;
	private TI_IN_OUT_FLAG_Enum InOutFlag = TI_IN_OUT_FLAG_Enum.TI_IN_OUT_FLAG_Out;
	private BV_HIST_MEMBER_INFO Aggressor = new BV_HIST_MEMBER_INFO();
	private BV_HIST_MEMBER_INFO Provider = new BV_HIST_MEMBER_INFO();
	private String DealerReferenceId = "";
	private String ClientExecID = "";
	private long ExecTraderId = 0;
	private String ExecTraderName = "";
	private BV_PORTFOLIO_RFCQ_ORDER_TYPE_Enum Type = BV_PORTFOLIO_RFCQ_ORDER_TYPE_Enum.BV_PORTFOLIO_RFCQ_ORDER_TYPE_Normal;
	private double NetProceeds = 0;
	private long CloseWithDealerId = 0;
	private BV_HIST_PORTFOLIO_RFCQ_ORDER_LEG OrderLeg = new BV_HIST_PORTFOLIO_RFCQ_ORDER_LEG();
	private BV_PORTFOLIO_RFCQ_ORDER_EVENT_Enum Event = BV_PORTFOLIO_RFCQ_ORDER_EVENT_Enum.BV_PORTFOLIO_RFCQ_ORDER_EVENT_Insert;
	private BV_PORTFOLIO_RFCQ_ORDER_STATUS_Enum Status = BV_PORTFOLIO_RFCQ_ORDER_STATUS_Enum.BV_PORTFOLIO_RFCQ_ORDER_STATUS_Processing;
	private long AcceptanceTimeout = 0;
	private long DepthUpdateTime = 0;
	private long UpdateTime = 0;

	public BV_HIST_PORTFOLIO_RFCQ_ORDER()
	{
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
	public long getExecTraderId()
	{
		return ExecTraderId;
	}
	public void setExecTraderId(long value)
	{
		ExecTraderId = value;
	}
	public String getExecTraderName()
	{
		return ExecTraderName;
	}
	public void setExecTraderName(String value)
	{
		ExecTraderName = value;
	}
	public BV_PORTFOLIO_RFCQ_ORDER_TYPE_Enum getType()
	{
		return Type;
	}
	public void setType(BV_PORTFOLIO_RFCQ_ORDER_TYPE_Enum value)
	{
		Type = value;
	}
	public double getNetProceeds()
	{
		return NetProceeds;
	}
	public void setNetProceeds(double value)
	{
		NetProceeds = value;
	}
	public long getCloseWithDealerId()
	{
		return CloseWithDealerId;
	}
	public void setCloseWithDealerId(long value)
	{
		CloseWithDealerId = value;
	}
	public BV_HIST_PORTFOLIO_RFCQ_ORDER_LEG getOrderLeg()
	{
		return OrderLeg;
	}
	public void setOrderLeg(BV_HIST_PORTFOLIO_RFCQ_ORDER_LEG value)
	{
		OrderLeg = value;
	}
	public BV_PORTFOLIO_RFCQ_ORDER_EVENT_Enum getEvent()
	{
		return Event;
	}
	public void setEvent(BV_PORTFOLIO_RFCQ_ORDER_EVENT_Enum value)
	{
		Event = value;
	}
	public BV_PORTFOLIO_RFCQ_ORDER_STATUS_Enum getStatus()
	{
		return Status;
	}
	public void setStatus(BV_PORTFOLIO_RFCQ_ORDER_STATUS_Enum value)
	{
		Status = value;
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
		InOutFlag = InOutFlag.getEnum(byteBuffer.readInt());
		Aggressor.readXDR(byteBuffer);
		Provider.readXDR(byteBuffer);
		DealerReferenceId = byteBuffer.readString();
		ClientExecID = byteBuffer.readString();
		ExecTraderId = (long)byteBuffer.readInt();
		ExecTraderName = byteBuffer.readString();
		Type = Type.getEnum(byteBuffer.readInt());
		NetProceeds = byteBuffer.readDouble();
		CloseWithDealerId = (long)byteBuffer.readInt();
		OrderLeg.readXDR(byteBuffer);
		Event = Event.getEnum(byteBuffer.readInt());
		Status = Status.getEnum(byteBuffer.readInt());
		AcceptanceTimeout = byteBuffer.readLong();
		DepthUpdateTime = byteBuffer.readLong();
		UpdateTime = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		MsgInfo.writeXDR(byteBuffer);
		byteBuffer.writeInt((int)(RfcqReqId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(RfcqQuoteId & 0xFFFFFFFFL));
		byteBuffer.writeInt(InOutFlag.getValue());
		Aggressor.writeXDR(byteBuffer);
		Provider.writeXDR(byteBuffer);
		byteBuffer.writeString(DealerReferenceId);
		byteBuffer.writeString(ClientExecID);
		byteBuffer.writeInt((int)(ExecTraderId & 0xFFFFFFFFL));
		byteBuffer.writeString(ExecTraderName);
		byteBuffer.writeInt(Type.getValue());
		byteBuffer.writeDouble(NetProceeds);
		byteBuffer.writeInt((int)(CloseWithDealerId & 0xFFFFFFFFL));
		OrderLeg.writeXDR(byteBuffer);
		byteBuffer.writeInt(Event.getValue());
		byteBuffer.writeInt(Status.getValue());
		byteBuffer.writeLong(AcceptanceTimeout);
		byteBuffer.writeLong(DepthUpdateTime);
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
		stringBuilder.append("BV_HIST_PORTFOLIO_RFCQ_ORDER::");
		stringBuilder.append("MsgInfo(").append(MsgInfo.toString()).append(")");
		stringBuilder.append("RfcqReqId(").append(RfcqReqId).append(")");
		stringBuilder.append("RfcqQuoteId(").append(RfcqQuoteId).append(")");
		stringBuilder.append("InOutFlag(").append(InOutFlag).append(")");
		stringBuilder.append("Aggressor(").append(Aggressor.toString()).append(")");
		stringBuilder.append("Provider(").append(Provider.toString()).append(")");
		stringBuilder.append("DealerReferenceId(").append(DealerReferenceId).append(")");
		stringBuilder.append("ClientExecID(").append(ClientExecID).append(")");
		stringBuilder.append("ExecTraderId(").append(ExecTraderId).append(")");
		stringBuilder.append("ExecTraderName(").append(ExecTraderName).append(")");
		stringBuilder.append("Type(").append(Type).append(")");
		stringBuilder.append("NetProceeds(").append(NetProceeds).append(")");
		stringBuilder.append("CloseWithDealerId(").append(CloseWithDealerId).append(")");
		stringBuilder.append("OrderLeg(").append(OrderLeg.toString()).append(")");
		stringBuilder.append("Event(").append(Event).append(")");
		stringBuilder.append("Status(").append(Status).append(")");
		stringBuilder.append("AcceptanceTimeout(").append(AcceptanceTimeout).append(")");
		stringBuilder.append("DepthUpdateTime(").append(DepthUpdateTime).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		return stringBuilder.toString();
	}
}
