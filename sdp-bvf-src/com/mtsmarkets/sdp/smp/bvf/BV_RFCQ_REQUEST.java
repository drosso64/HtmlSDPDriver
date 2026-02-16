package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_RFCQ_REQUEST extends SMPMessage
{
	public static final long CLASS_ID = 114178;

	private TI_MSG_INFO MsgInfo = new TI_MSG_INFO();
	private BV_MEMBER_INFO Aggressor = new BV_MEMBER_INFO();
	private TI_RFCQ_TYPE_Enum RfcqType = TI_RFCQ_TYPE_Enum.TI_RFCQ_TYPE_Outright;
	private TI_RFCQ_ORIGIN_Enum RfcqOrigin = TI_RFCQ_ORIGIN_Enum.TI_RFCQ_ORIGIN_FromScratch;
	private TI_FLAG_Enum PreAgreedFg = TI_FLAG_Enum.TI_FLAG_No;
	private long VoiceListId = 0;
	private TI_FLAG_Enum PreTradeFg = TI_FLAG_Enum.TI_FLAG_No;
	private long SellSideMemberId = 0;
	private long TradingListId = 0;
	private long PreviewId = 0;
	private TI_RFCQ_QUANTITY_CALCULATION_Enum QuantityCalculation = TI_RFCQ_QUANTITY_CALCULATION_Enum.TI_RFCQ_QUANTITY_CALCULATION_UserInput;
	private TI_FLAG_Enum LimitSpreadFg = TI_FLAG_Enum.TI_FLAG_No;
	private double LimitSpread = 0;
	private BV_RFCQ_REQUEST_LEG[] RfcqRequestLeg = new BV_RFCQ_REQUEST_LEG[3];
	private BV_RFCQ_SELL_SIDE_MEMBER_INFO[] SellSideMemberInfo = new BV_RFCQ_SELL_SIDE_MEMBER_INFO[20];
	private short IOIMatchingQuotes = 0;
	private TI_RFCQ_REQUEST_EVENT_Enum Event = TI_RFCQ_REQUEST_EVENT_Enum.TI_RFCQ_REQUEST_EVENT_Insert;
	private TI_RFCQ_REQUEST_STATUS_Enum Status = TI_RFCQ_REQUEST_STATUS_Enum.TI_RFCQ_REQUEST_STATUS_Processing;
	private long RfcqDuration = 0;
	private long RfcqTimeout = 0;
	private String ClientRfcqId = "";
	private TI_FLAG_Enum AutoExecutionFg = TI_FLAG_Enum.TI_FLAG_No;
	private long AutoExecutionRuleId = 0;
	private long ManualOverrideStartTime = 0;
	private long ManualOverrideEndTime = 0;
	private String UserInfo1 = "";
	private String UserInfo2 = "";
	private short DueInTime = 0;
	private long DueInTimeout = 0;
	private long UpdateTime = 0;

	public BV_RFCQ_REQUEST()
	{
		for (int i=0; i < RfcqRequestLeg.length; ++i)
		{
			RfcqRequestLeg[i] = new BV_RFCQ_REQUEST_LEG();
		}
		for (int i=0; i < SellSideMemberInfo.length; ++i)
		{
			SellSideMemberInfo[i] = new BV_RFCQ_SELL_SIDE_MEMBER_INFO();
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
	public TI_RFCQ_TYPE_Enum getRfcqType()
	{
		return RfcqType;
	}
	public void setRfcqType(TI_RFCQ_TYPE_Enum value)
	{
		RfcqType = value;
	}
	public TI_RFCQ_ORIGIN_Enum getRfcqOrigin()
	{
		return RfcqOrigin;
	}
	public void setRfcqOrigin(TI_RFCQ_ORIGIN_Enum value)
	{
		RfcqOrigin = value;
	}
	public TI_FLAG_Enum getPreAgreedFg()
	{
		return PreAgreedFg;
	}
	public void setPreAgreedFg(TI_FLAG_Enum value)
	{
		PreAgreedFg = value;
	}
	public long getVoiceListId()
	{
		return VoiceListId;
	}
	public void setVoiceListId(long value)
	{
		VoiceListId = value;
	}
	public TI_FLAG_Enum getPreTradeFg()
	{
		return PreTradeFg;
	}
	public void setPreTradeFg(TI_FLAG_Enum value)
	{
		PreTradeFg = value;
	}
	public long getSellSideMemberId()
	{
		return SellSideMemberId;
	}
	public void setSellSideMemberId(long value)
	{
		SellSideMemberId = value;
	}
	public long getTradingListId()
	{
		return TradingListId;
	}
	public void setTradingListId(long value)
	{
		TradingListId = value;
	}
	public long getPreviewId()
	{
		return PreviewId;
	}
	public void setPreviewId(long value)
	{
		PreviewId = value;
	}
	public TI_RFCQ_QUANTITY_CALCULATION_Enum getQuantityCalculation()
	{
		return QuantityCalculation;
	}
	public void setQuantityCalculation(TI_RFCQ_QUANTITY_CALCULATION_Enum value)
	{
		QuantityCalculation = value;
	}
	public TI_FLAG_Enum getLimitSpreadFg()
	{
		return LimitSpreadFg;
	}
	public void setLimitSpreadFg(TI_FLAG_Enum value)
	{
		LimitSpreadFg = value;
	}
	public double getLimitSpread()
	{
		return LimitSpread;
	}
	public void setLimitSpread(double value)
	{
		LimitSpread = value;
	}
	public BV_RFCQ_REQUEST_LEG[] getRfcqRequestLeg()
	{
		return RfcqRequestLeg;
	}
	public void setRfcqRequestLeg(BV_RFCQ_REQUEST_LEG[] value)
	{
		RfcqRequestLeg = value;
	}
	public BV_RFCQ_SELL_SIDE_MEMBER_INFO[] getSellSideMemberInfo()
	{
		return SellSideMemberInfo;
	}
	public void setSellSideMemberInfo(BV_RFCQ_SELL_SIDE_MEMBER_INFO[] value)
	{
		SellSideMemberInfo = value;
	}
	public short getIOIMatchingQuotes()
	{
		return IOIMatchingQuotes;
	}
	public void setIOIMatchingQuotes(short value)
	{
		IOIMatchingQuotes = value;
	}
	public TI_RFCQ_REQUEST_EVENT_Enum getEvent()
	{
		return Event;
	}
	public void setEvent(TI_RFCQ_REQUEST_EVENT_Enum value)
	{
		Event = value;
	}
	public TI_RFCQ_REQUEST_STATUS_Enum getStatus()
	{
		return Status;
	}
	public void setStatus(TI_RFCQ_REQUEST_STATUS_Enum value)
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
	public String getClientRfcqId()
	{
		return ClientRfcqId;
	}
	public void setClientRfcqId(String value)
	{
		ClientRfcqId = value;
	}
	public TI_FLAG_Enum getAutoExecutionFg()
	{
		return AutoExecutionFg;
	}
	public void setAutoExecutionFg(TI_FLAG_Enum value)
	{
		AutoExecutionFg = value;
	}
	public long getAutoExecutionRuleId()
	{
		return AutoExecutionRuleId;
	}
	public void setAutoExecutionRuleId(long value)
	{
		AutoExecutionRuleId = value;
	}
	public long getManualOverrideStartTime()
	{
		return ManualOverrideStartTime;
	}
	public void setManualOverrideStartTime(long value)
	{
		ManualOverrideStartTime = value;
	}
	public long getManualOverrideEndTime()
	{
		return ManualOverrideEndTime;
	}
	public void setManualOverrideEndTime(long value)
	{
		ManualOverrideEndTime = value;
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
		RfcqType = RfcqType.getEnum(byteBuffer.readInt());
		RfcqOrigin = RfcqOrigin.getEnum(byteBuffer.readInt());
		PreAgreedFg = PreAgreedFg.getEnum(byteBuffer.readInt());
		VoiceListId = (long)byteBuffer.readInt();
		PreTradeFg = PreTradeFg.getEnum(byteBuffer.readInt());
		SellSideMemberId = (long)byteBuffer.readInt();
		TradingListId = (long)byteBuffer.readInt();
		PreviewId = (long)byteBuffer.readInt();
		QuantityCalculation = QuantityCalculation.getEnum(byteBuffer.readInt());
		LimitSpreadFg = LimitSpreadFg.getEnum(byteBuffer.readInt());
		LimitSpread = byteBuffer.readDouble();
		for (int i=0; i < RfcqRequestLeg.length; ++i)
		{
			RfcqRequestLeg[i].readXDR(byteBuffer);
		}
		for (int i=0; i < SellSideMemberInfo.length; ++i)
		{
			SellSideMemberInfo[i].readXDR(byteBuffer);
		}
		IOIMatchingQuotes = (short)byteBuffer.readInt();
		Event = Event.getEnum(byteBuffer.readInt());
		Status = Status.getEnum(byteBuffer.readInt());
		RfcqDuration = (long)byteBuffer.readInt();
		RfcqTimeout = byteBuffer.readLong();
		ClientRfcqId = byteBuffer.readString();
		AutoExecutionFg = AutoExecutionFg.getEnum(byteBuffer.readInt());
		AutoExecutionRuleId = (long)byteBuffer.readInt();
		ManualOverrideStartTime = byteBuffer.readLong();
		ManualOverrideEndTime = byteBuffer.readLong();
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
		byteBuffer.writeInt(RfcqType.getValue());
		byteBuffer.writeInt(RfcqOrigin.getValue());
		byteBuffer.writeInt(PreAgreedFg.getValue());
		byteBuffer.writeInt((int)(VoiceListId & 0xFFFFFFFFL));
		byteBuffer.writeInt(PreTradeFg.getValue());
		byteBuffer.writeInt((int)(SellSideMemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(TradingListId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(PreviewId & 0xFFFFFFFFL));
		byteBuffer.writeInt(QuantityCalculation.getValue());
		byteBuffer.writeInt(LimitSpreadFg.getValue());
		byteBuffer.writeDouble(LimitSpread);
		for (int i=0; i < RfcqRequestLeg.length; ++i)
		{
			RfcqRequestLeg[i].writeXDR(byteBuffer);
		}
		for (int i=0; i < SellSideMemberInfo.length; ++i)
		{
			SellSideMemberInfo[i].writeXDR(byteBuffer);
		}
		byteBuffer.writeInt((int)(IOIMatchingQuotes & 0xFFFFL));
		byteBuffer.writeInt(Event.getValue());
		byteBuffer.writeInt(Status.getValue());
		byteBuffer.writeInt((int)(RfcqDuration & 0xFFFFFFFFL));
		byteBuffer.writeLong(RfcqTimeout);
		byteBuffer.writeString(ClientRfcqId);
		byteBuffer.writeInt(AutoExecutionFg.getValue());
		byteBuffer.writeInt((int)(AutoExecutionRuleId & 0xFFFFFFFFL));
		byteBuffer.writeLong(ManualOverrideStartTime);
		byteBuffer.writeLong(ManualOverrideEndTime);
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
		stringBuilder.append("BV_RFCQ_REQUEST::");
		stringBuilder.append("MsgInfo(").append(MsgInfo.toString()).append(")");
		stringBuilder.append("Aggressor(").append(Aggressor.toString()).append(")");
		stringBuilder.append("RfcqType(").append(RfcqType).append(")");
		stringBuilder.append("RfcqOrigin(").append(RfcqOrigin).append(")");
		stringBuilder.append("PreAgreedFg(").append(PreAgreedFg).append(")");
		stringBuilder.append("VoiceListId(").append(VoiceListId).append(")");
		stringBuilder.append("PreTradeFg(").append(PreTradeFg).append(")");
		stringBuilder.append("SellSideMemberId(").append(SellSideMemberId).append(")");
		stringBuilder.append("TradingListId(").append(TradingListId).append(")");
		stringBuilder.append("PreviewId(").append(PreviewId).append(")");
		stringBuilder.append("QuantityCalculation(").append(QuantityCalculation).append(")");
		stringBuilder.append("LimitSpreadFg(").append(LimitSpreadFg).append(")");
		stringBuilder.append("LimitSpread(").append(LimitSpread).append(")");
		for (int i=0; i < RfcqRequestLeg.length; ++i)
		{
			stringBuilder.append("RfcqRequestLeg[").append(i).append("](").append(RfcqRequestLeg[i].toString()).append(")");
		}
		for (int i=0; i < SellSideMemberInfo.length; ++i)
		{
			stringBuilder.append("SellSideMemberInfo[").append(i).append("](").append(SellSideMemberInfo[i].toString()).append(")");
		}
		stringBuilder.append("IOIMatchingQuotes(").append(IOIMatchingQuotes).append(")");
		stringBuilder.append("Event(").append(Event).append(")");
		stringBuilder.append("Status(").append(Status).append(")");
		stringBuilder.append("RfcqDuration(").append(RfcqDuration).append(")");
		stringBuilder.append("RfcqTimeout(").append(RfcqTimeout).append(")");
		stringBuilder.append("ClientRfcqId(").append(ClientRfcqId).append(")");
		stringBuilder.append("AutoExecutionFg(").append(AutoExecutionFg).append(")");
		stringBuilder.append("AutoExecutionRuleId(").append(AutoExecutionRuleId).append(")");
		stringBuilder.append("ManualOverrideStartTime(").append(ManualOverrideStartTime).append(")");
		stringBuilder.append("ManualOverrideEndTime(").append(ManualOverrideEndTime).append(")");
		stringBuilder.append("UserInfo1(").append(UserInfo1).append(")");
		stringBuilder.append("UserInfo2(").append(UserInfo2).append(")");
		stringBuilder.append("DueInTime(").append(DueInTime).append(")");
		stringBuilder.append("DueInTimeout(").append(DueInTimeout).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		return stringBuilder.toString();
	}
}
