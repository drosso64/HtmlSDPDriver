package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_ORDER_STAGING extends SMPMessage
{
	public static final long CLASS_ID = 114177;

	private TI_MSG_INFO OrderMsgInfo = new TI_MSG_INFO();
	private String ClientOrderId = "";
	private long AllocationId = 0;
	private String ClientPreAllocationId = "";
	private long ClientPreAllocationTraderId = 0;
	private String ClientPreAllocationTraderName = "";
	private TI_PROTOCOL_SOURCE_Enum OrderSource = TI_PROTOCOL_SOURCE_Enum.TI_PROTOCOL_SOURCE_Sdp;
	private BV_MEMBER_INFO MemberInfo = new BV_MEMBER_INFO();
	private BV_ORDER_STAGING_EXEC_TYPE_Enum ExecutionType = BV_ORDER_STAGING_EXEC_TYPE_Enum.BV_ORDER_STAGING_EXEC_TYPE_Undefined;
	private String LinkId = "";
	private TI_FLAG_Enum LinkedByOriginatorFg = TI_FLAG_Enum.TI_FLAG_No;
	private BV_INSTRUMENT_INFO Instrument = new BV_INSTRUMENT_INFO();
	private TI_VERB_Enum Verb = TI_VERB_Enum.TI_VERB_Buy;
	private double Qty = 0;
	private double NominalQty = 0;
	private double RemainingQty = 0;
	private double RemainingNominalQty = 0;
	private double CumQty = 0;
	private double CumNominalQty = 0;
	private double AveragePrice = 0;
	private String Currency = "";
	private TI_TRADING_TYPE_Enum ClientLimitQuotationType = TI_TRADING_TYPE_Enum.TI_TRADING_TYPE_CleanPrice;
	private double ClientLimitQuotation = 0;
	private TI_TRADING_TYPE_Enum LimitQuotationType = TI_TRADING_TYPE_Enum.TI_TRADING_TYPE_CleanPrice;
	private double LimitQuotation = 0;
	private long ExecutionTime = 0;
	private BV_HANDLING_INSTRUCTION_Enum HandlingInstruction = BV_HANDLING_INSTRUCTION_Enum.BV_HANDLING_INSTRUCTION_None;
	private short SettlementOffset = 0;
	private long SettlementDate = 0;
	private TI_FLAG_Enum SettlDateModifyFlag = TI_FLAG_Enum.TI_FLAG_No;
	private long AccountId = 0;
	private TI_FLAG_Enum NoPartialFill = TI_FLAG_Enum.TI_FLAG_No;
	private TI_FLAG_Enum PartiallyExecutedFg = TI_FLAG_Enum.TI_FLAG_No;
	private TI_FLAG_Enum WarningOnLimitPrice = TI_FLAG_Enum.TI_FLAG_No;
	private BV_ORDER_STAGING_EVENT_Enum Event = BV_ORDER_STAGING_EVENT_Enum.BV_ORDER_STAGING_EVENT_Insert;
	private BV_ORDER_STAGING_STATUS_Enum Status = BV_ORDER_STAGING_STATUS_Enum.BV_ORDER_STAGING_STATUS_Active;
	private BV_ORDER_STAGING_TYPE_Enum OrderType = BV_ORDER_STAGING_TYPE_Enum.BV_ORDER_STAGING_TYPE_Market;
	private long ExecTraderId = 0;
	private long WorkingTraderId = 0;
	private TI_FLAG_Enum WorkInProgressFg = TI_FLAG_Enum.TI_FLAG_No;
	private String ExternalTraderId = "";
	private BV_ORDER_STAGING_DEALER_LIST_TYPE_Enum DealerListType = BV_ORDER_STAGING_DEALER_LIST_TYPE_Enum.BV_ORDER_STAGING_DEALER_LIST_TYPE_None;
	private short DealerListNum = 0;
	private BV_ORDER_STAGING_DEALER_INFO[] DealerList = new BV_ORDER_STAGING_DEALER_INFO[50];
	private String UserInfo1 = "";
	private String UserInfo2 = "";
	private long EditTime = 0;
	private BV_WAIVER_INDICATOR_Enum WaiverIndicator = BV_WAIVER_INDICATOR_Enum.BV_WAIVER_INDICATOR_None;
	private String MicCode = "";
	private String AutoDeleteReasonCode = "";

	public BV_ORDER_STAGING()
	{
		for (int i=0; i < DealerList.length; ++i)
		{
			DealerList[i] = new BV_ORDER_STAGING_DEALER_INFO();
		}
	}

	public TI_MSG_INFO getOrderMsgInfo()
	{
		return OrderMsgInfo;
	}
	public void setOrderMsgInfo(TI_MSG_INFO value)
	{
		OrderMsgInfo = value;
	}
	public String getClientOrderId()
	{
		return ClientOrderId;
	}
	public void setClientOrderId(String value)
	{
		ClientOrderId = value;
	}
	public long getAllocationId()
	{
		return AllocationId;
	}
	public void setAllocationId(long value)
	{
		AllocationId = value;
	}
	public String getClientPreAllocationId()
	{
		return ClientPreAllocationId;
	}
	public void setClientPreAllocationId(String value)
	{
		ClientPreAllocationId = value;
	}
	public long getClientPreAllocationTraderId()
	{
		return ClientPreAllocationTraderId;
	}
	public void setClientPreAllocationTraderId(long value)
	{
		ClientPreAllocationTraderId = value;
	}
	public String getClientPreAllocationTraderName()
	{
		return ClientPreAllocationTraderName;
	}
	public void setClientPreAllocationTraderName(String value)
	{
		ClientPreAllocationTraderName = value;
	}
	public TI_PROTOCOL_SOURCE_Enum getOrderSource()
	{
		return OrderSource;
	}
	public void setOrderSource(TI_PROTOCOL_SOURCE_Enum value)
	{
		OrderSource = value;
	}
	public BV_MEMBER_INFO getMemberInfo()
	{
		return MemberInfo;
	}
	public void setMemberInfo(BV_MEMBER_INFO value)
	{
		MemberInfo = value;
	}
	public BV_ORDER_STAGING_EXEC_TYPE_Enum getExecutionType()
	{
		return ExecutionType;
	}
	public void setExecutionType(BV_ORDER_STAGING_EXEC_TYPE_Enum value)
	{
		ExecutionType = value;
	}
	public String getLinkId()
	{
		return LinkId;
	}
	public void setLinkId(String value)
	{
		LinkId = value;
	}
	public TI_FLAG_Enum getLinkedByOriginatorFg()
	{
		return LinkedByOriginatorFg;
	}
	public void setLinkedByOriginatorFg(TI_FLAG_Enum value)
	{
		LinkedByOriginatorFg = value;
	}
	public BV_INSTRUMENT_INFO getInstrument()
	{
		return Instrument;
	}
	public void setInstrument(BV_INSTRUMENT_INFO value)
	{
		Instrument = value;
	}
	public TI_VERB_Enum getVerb()
	{
		return Verb;
	}
	public void setVerb(TI_VERB_Enum value)
	{
		Verb = value;
	}
	public double getQty()
	{
		return Qty;
	}
	public void setQty(double value)
	{
		Qty = value;
	}
	public double getNominalQty()
	{
		return NominalQty;
	}
	public void setNominalQty(double value)
	{
		NominalQty = value;
	}
	public double getRemainingQty()
	{
		return RemainingQty;
	}
	public void setRemainingQty(double value)
	{
		RemainingQty = value;
	}
	public double getRemainingNominalQty()
	{
		return RemainingNominalQty;
	}
	public void setRemainingNominalQty(double value)
	{
		RemainingNominalQty = value;
	}
	public double getCumQty()
	{
		return CumQty;
	}
	public void setCumQty(double value)
	{
		CumQty = value;
	}
	public double getCumNominalQty()
	{
		return CumNominalQty;
	}
	public void setCumNominalQty(double value)
	{
		CumNominalQty = value;
	}
	public double getAveragePrice()
	{
		return AveragePrice;
	}
	public void setAveragePrice(double value)
	{
		AveragePrice = value;
	}
	public String getCurrency()
	{
		return Currency;
	}
	public void setCurrency(String value)
	{
		Currency = value;
	}
	public TI_TRADING_TYPE_Enum getClientLimitQuotationType()
	{
		return ClientLimitQuotationType;
	}
	public void setClientLimitQuotationType(TI_TRADING_TYPE_Enum value)
	{
		ClientLimitQuotationType = value;
	}
	public double getClientLimitQuotation()
	{
		return ClientLimitQuotation;
	}
	public void setClientLimitQuotation(double value)
	{
		ClientLimitQuotation = value;
	}
	public TI_TRADING_TYPE_Enum getLimitQuotationType()
	{
		return LimitQuotationType;
	}
	public void setLimitQuotationType(TI_TRADING_TYPE_Enum value)
	{
		LimitQuotationType = value;
	}
	public double getLimitQuotation()
	{
		return LimitQuotation;
	}
	public void setLimitQuotation(double value)
	{
		LimitQuotation = value;
	}
	public long getExecutionTime()
	{
		return ExecutionTime;
	}
	public void setExecutionTime(long value)
	{
		ExecutionTime = value;
	}
	public BV_HANDLING_INSTRUCTION_Enum getHandlingInstruction()
	{
		return HandlingInstruction;
	}
	public void setHandlingInstruction(BV_HANDLING_INSTRUCTION_Enum value)
	{
		HandlingInstruction = value;
	}
	public short getSettlementOffset()
	{
		return SettlementOffset;
	}
	public void setSettlementOffset(short value)
	{
		SettlementOffset = value;
	}
	public long getSettlementDate()
	{
		return SettlementDate;
	}
	public void setSettlementDate(long value)
	{
		SettlementDate = value;
	}
	public TI_FLAG_Enum getSettlDateModifyFlag()
	{
		return SettlDateModifyFlag;
	}
	public void setSettlDateModifyFlag(TI_FLAG_Enum value)
	{
		SettlDateModifyFlag = value;
	}
	public long getAccountId()
	{
		return AccountId;
	}
	public void setAccountId(long value)
	{
		AccountId = value;
	}
	public TI_FLAG_Enum getNoPartialFill()
	{
		return NoPartialFill;
	}
	public void setNoPartialFill(TI_FLAG_Enum value)
	{
		NoPartialFill = value;
	}
	public TI_FLAG_Enum getPartiallyExecutedFg()
	{
		return PartiallyExecutedFg;
	}
	public void setPartiallyExecutedFg(TI_FLAG_Enum value)
	{
		PartiallyExecutedFg = value;
	}
	public TI_FLAG_Enum getWarningOnLimitPrice()
	{
		return WarningOnLimitPrice;
	}
	public void setWarningOnLimitPrice(TI_FLAG_Enum value)
	{
		WarningOnLimitPrice = value;
	}
	public BV_ORDER_STAGING_EVENT_Enum getEvent()
	{
		return Event;
	}
	public void setEvent(BV_ORDER_STAGING_EVENT_Enum value)
	{
		Event = value;
	}
	public BV_ORDER_STAGING_STATUS_Enum getStatus()
	{
		return Status;
	}
	public void setStatus(BV_ORDER_STAGING_STATUS_Enum value)
	{
		Status = value;
	}
	public BV_ORDER_STAGING_TYPE_Enum getOrderType()
	{
		return OrderType;
	}
	public void setOrderType(BV_ORDER_STAGING_TYPE_Enum value)
	{
		OrderType = value;
	}
	public long getExecTraderId()
	{
		return ExecTraderId;
	}
	public void setExecTraderId(long value)
	{
		ExecTraderId = value;
	}
	public long getWorkingTraderId()
	{
		return WorkingTraderId;
	}
	public void setWorkingTraderId(long value)
	{
		WorkingTraderId = value;
	}
	public TI_FLAG_Enum getWorkInProgressFg()
	{
		return WorkInProgressFg;
	}
	public void setWorkInProgressFg(TI_FLAG_Enum value)
	{
		WorkInProgressFg = value;
	}
	public String getExternalTraderId()
	{
		return ExternalTraderId;
	}
	public void setExternalTraderId(String value)
	{
		ExternalTraderId = value;
	}
	public BV_ORDER_STAGING_DEALER_LIST_TYPE_Enum getDealerListType()
	{
		return DealerListType;
	}
	public void setDealerListType(BV_ORDER_STAGING_DEALER_LIST_TYPE_Enum value)
	{
		DealerListType = value;
	}
	public short getDealerListNum()
	{
		return DealerListNum;
	}
	public void setDealerListNum(short value)
	{
		DealerListNum = value;
	}
	public BV_ORDER_STAGING_DEALER_INFO[] getDealerList()
	{
		return DealerList;
	}
	public void setDealerList(BV_ORDER_STAGING_DEALER_INFO[] value)
	{
		DealerList = value;
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
	public long getEditTime()
	{
		return EditTime;
	}
	public void setEditTime(long value)
	{
		EditTime = value;
	}
	public BV_WAIVER_INDICATOR_Enum getWaiverIndicator()
	{
		return WaiverIndicator;
	}
	public void setWaiverIndicator(BV_WAIVER_INDICATOR_Enum value)
	{
		WaiverIndicator = value;
	}
	public String getMicCode()
	{
		return MicCode;
	}
	public void setMicCode(String value)
	{
		MicCode = value;
	}
	public String getAutoDeleteReasonCode()
	{
		return AutoDeleteReasonCode;
	}
	public void setAutoDeleteReasonCode(String value)
	{
		AutoDeleteReasonCode = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		OrderMsgInfo.readXDR(byteBuffer);
		ClientOrderId = byteBuffer.readString();
		AllocationId = (long)byteBuffer.readInt();
		ClientPreAllocationId = byteBuffer.readString();
		ClientPreAllocationTraderId = (long)byteBuffer.readInt();
		ClientPreAllocationTraderName = byteBuffer.readString();
		OrderSource = OrderSource.getEnum(byteBuffer.readInt());
		MemberInfo.readXDR(byteBuffer);
		ExecutionType = ExecutionType.getEnum(byteBuffer.readInt());
		LinkId = byteBuffer.readString();
		LinkedByOriginatorFg = LinkedByOriginatorFg.getEnum(byteBuffer.readInt());
		Instrument.readXDR(byteBuffer);
		Verb = Verb.getEnum(byteBuffer.readInt());
		Qty = byteBuffer.readDouble();
		NominalQty = byteBuffer.readDouble();
		RemainingQty = byteBuffer.readDouble();
		RemainingNominalQty = byteBuffer.readDouble();
		CumQty = byteBuffer.readDouble();
		CumNominalQty = byteBuffer.readDouble();
		AveragePrice = byteBuffer.readDouble();
		Currency = byteBuffer.readString();
		ClientLimitQuotationType = ClientLimitQuotationType.getEnum(byteBuffer.readInt());
		ClientLimitQuotation = byteBuffer.readDouble();
		LimitQuotationType = LimitQuotationType.getEnum(byteBuffer.readInt());
		LimitQuotation = byteBuffer.readDouble();
		ExecutionTime = byteBuffer.readLong();
		HandlingInstruction = HandlingInstruction.getEnum(byteBuffer.readInt());
		SettlementOffset = (short)byteBuffer.readInt();
		SettlementDate = (long)byteBuffer.readInt();
		SettlDateModifyFlag = SettlDateModifyFlag.getEnum(byteBuffer.readInt());
		AccountId = (long)byteBuffer.readInt();
		NoPartialFill = NoPartialFill.getEnum(byteBuffer.readInt());
		PartiallyExecutedFg = PartiallyExecutedFg.getEnum(byteBuffer.readInt());
		WarningOnLimitPrice = WarningOnLimitPrice.getEnum(byteBuffer.readInt());
		Event = Event.getEnum(byteBuffer.readInt());
		Status = Status.getEnum(byteBuffer.readInt());
		OrderType = OrderType.getEnum(byteBuffer.readInt());
		ExecTraderId = (long)byteBuffer.readInt();
		WorkingTraderId = (long)byteBuffer.readInt();
		WorkInProgressFg = WorkInProgressFg.getEnum(byteBuffer.readInt());
		ExternalTraderId = byteBuffer.readString();
		DealerListType = DealerListType.getEnum(byteBuffer.readInt());
		DealerListNum = (short)byteBuffer.readInt();
		for (int i=0; i < DealerList.length; ++i)
		{
			DealerList[i].readXDR(byteBuffer);
		}
		UserInfo1 = byteBuffer.readString();
		UserInfo2 = byteBuffer.readString();
		EditTime = byteBuffer.readLong();
		WaiverIndicator = WaiverIndicator.getEnum(byteBuffer.readInt());
		MicCode = byteBuffer.readString();
		AutoDeleteReasonCode = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		OrderMsgInfo.writeXDR(byteBuffer);
		byteBuffer.writeString(ClientOrderId);
		byteBuffer.writeInt((int)(AllocationId & 0xFFFFFFFFL));
		byteBuffer.writeString(ClientPreAllocationId);
		byteBuffer.writeInt((int)(ClientPreAllocationTraderId & 0xFFFFFFFFL));
		byteBuffer.writeString(ClientPreAllocationTraderName);
		byteBuffer.writeInt(OrderSource.getValue());
		MemberInfo.writeXDR(byteBuffer);
		byteBuffer.writeInt(ExecutionType.getValue());
		byteBuffer.writeString(LinkId);
		byteBuffer.writeInt(LinkedByOriginatorFg.getValue());
		Instrument.writeXDR(byteBuffer);
		byteBuffer.writeInt(Verb.getValue());
		byteBuffer.writeDouble(Qty);
		byteBuffer.writeDouble(NominalQty);
		byteBuffer.writeDouble(RemainingQty);
		byteBuffer.writeDouble(RemainingNominalQty);
		byteBuffer.writeDouble(CumQty);
		byteBuffer.writeDouble(CumNominalQty);
		byteBuffer.writeDouble(AveragePrice);
		byteBuffer.writeString(Currency);
		byteBuffer.writeInt(ClientLimitQuotationType.getValue());
		byteBuffer.writeDouble(ClientLimitQuotation);
		byteBuffer.writeInt(LimitQuotationType.getValue());
		byteBuffer.writeDouble(LimitQuotation);
		byteBuffer.writeLong(ExecutionTime);
		byteBuffer.writeInt(HandlingInstruction.getValue());
		byteBuffer.writeInt((int)(SettlementOffset & 0xFFFFL));
		byteBuffer.writeInt((int)(SettlementDate & 0xFFFFFFFFL));
		byteBuffer.writeInt(SettlDateModifyFlag.getValue());
		byteBuffer.writeInt((int)(AccountId & 0xFFFFFFFFL));
		byteBuffer.writeInt(NoPartialFill.getValue());
		byteBuffer.writeInt(PartiallyExecutedFg.getValue());
		byteBuffer.writeInt(WarningOnLimitPrice.getValue());
		byteBuffer.writeInt(Event.getValue());
		byteBuffer.writeInt(Status.getValue());
		byteBuffer.writeInt(OrderType.getValue());
		byteBuffer.writeInt((int)(ExecTraderId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(WorkingTraderId & 0xFFFFFFFFL));
		byteBuffer.writeInt(WorkInProgressFg.getValue());
		byteBuffer.writeString(ExternalTraderId);
		byteBuffer.writeInt(DealerListType.getValue());
		byteBuffer.writeInt((int)(DealerListNum & 0xFFFFL));
		for (int i=0; i < DealerList.length; ++i)
		{
			DealerList[i].writeXDR(byteBuffer);
		}
		byteBuffer.writeString(UserInfo1);
		byteBuffer.writeString(UserInfo2);
		byteBuffer.writeLong(EditTime);
		byteBuffer.writeInt(WaiverIndicator.getValue());
		byteBuffer.writeString(MicCode);
		byteBuffer.writeString(AutoDeleteReasonCode);

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
		stringBuilder.append("BV_ORDER_STAGING::");
		stringBuilder.append("OrderMsgInfo(").append(OrderMsgInfo.toString()).append(")");
		stringBuilder.append("ClientOrderId(").append(ClientOrderId).append(")");
		stringBuilder.append("AllocationId(").append(AllocationId).append(")");
		stringBuilder.append("ClientPreAllocationId(").append(ClientPreAllocationId).append(")");
		stringBuilder.append("ClientPreAllocationTraderId(").append(ClientPreAllocationTraderId).append(")");
		stringBuilder.append("ClientPreAllocationTraderName(").append(ClientPreAllocationTraderName).append(")");
		stringBuilder.append("OrderSource(").append(OrderSource).append(")");
		stringBuilder.append("MemberInfo(").append(MemberInfo.toString()).append(")");
		stringBuilder.append("ExecutionType(").append(ExecutionType).append(")");
		stringBuilder.append("LinkId(").append(LinkId).append(")");
		stringBuilder.append("LinkedByOriginatorFg(").append(LinkedByOriginatorFg).append(")");
		stringBuilder.append("Instrument(").append(Instrument.toString()).append(")");
		stringBuilder.append("Verb(").append(Verb).append(")");
		stringBuilder.append("Qty(").append(Qty).append(")");
		stringBuilder.append("NominalQty(").append(NominalQty).append(")");
		stringBuilder.append("RemainingQty(").append(RemainingQty).append(")");
		stringBuilder.append("RemainingNominalQty(").append(RemainingNominalQty).append(")");
		stringBuilder.append("CumQty(").append(CumQty).append(")");
		stringBuilder.append("CumNominalQty(").append(CumNominalQty).append(")");
		stringBuilder.append("AveragePrice(").append(AveragePrice).append(")");
		stringBuilder.append("Currency(").append(Currency).append(")");
		stringBuilder.append("ClientLimitQuotationType(").append(ClientLimitQuotationType).append(")");
		stringBuilder.append("ClientLimitQuotation(").append(ClientLimitQuotation).append(")");
		stringBuilder.append("LimitQuotationType(").append(LimitQuotationType).append(")");
		stringBuilder.append("LimitQuotation(").append(LimitQuotation).append(")");
		stringBuilder.append("ExecutionTime(").append(ExecutionTime).append(")");
		stringBuilder.append("HandlingInstruction(").append(HandlingInstruction).append(")");
		stringBuilder.append("SettlementOffset(").append(SettlementOffset).append(")");
		stringBuilder.append("SettlementDate(").append(SettlementDate).append(")");
		stringBuilder.append("SettlDateModifyFlag(").append(SettlDateModifyFlag).append(")");
		stringBuilder.append("AccountId(").append(AccountId).append(")");
		stringBuilder.append("NoPartialFill(").append(NoPartialFill).append(")");
		stringBuilder.append("PartiallyExecutedFg(").append(PartiallyExecutedFg).append(")");
		stringBuilder.append("WarningOnLimitPrice(").append(WarningOnLimitPrice).append(")");
		stringBuilder.append("Event(").append(Event).append(")");
		stringBuilder.append("Status(").append(Status).append(")");
		stringBuilder.append("OrderType(").append(OrderType).append(")");
		stringBuilder.append("ExecTraderId(").append(ExecTraderId).append(")");
		stringBuilder.append("WorkingTraderId(").append(WorkingTraderId).append(")");
		stringBuilder.append("WorkInProgressFg(").append(WorkInProgressFg).append(")");
		stringBuilder.append("ExternalTraderId(").append(ExternalTraderId).append(")");
		stringBuilder.append("DealerListType(").append(DealerListType).append(")");
		stringBuilder.append("DealerListNum(").append(DealerListNum).append(")");
		for (int i=0; i < DealerList.length; ++i)
		{
			stringBuilder.append("DealerList[").append(i).append("](").append(DealerList[i].toString()).append(")");
		}
		stringBuilder.append("UserInfo1(").append(UserInfo1).append(")");
		stringBuilder.append("UserInfo2(").append(UserInfo2).append(")");
		stringBuilder.append("EditTime(").append(EditTime).append(")");
		stringBuilder.append("WaiverIndicator(").append(WaiverIndicator).append(")");
		stringBuilder.append("MicCode(").append(MicCode).append(")");
		stringBuilder.append("AutoDeleteReasonCode(").append(AutoDeleteReasonCode).append(")");
		return stringBuilder.toString();
	}
}
