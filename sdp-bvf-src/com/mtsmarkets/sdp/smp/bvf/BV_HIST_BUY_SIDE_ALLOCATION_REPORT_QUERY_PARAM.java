package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_HIST_BUY_SIDE_ALLOCATION_REPORT_QUERY_PARAM extends SMPMessage
{
	public static final long CLASS_ID = 214216;

	private TI_QUERY_OP_Enum MsgIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long MsgId = 0;
	private TI_QUERY_OP_Enum MsgDateFromOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long MsgDateFrom = 0;
	private TI_QUERY_OP_Enum MsgDateToOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long MsgDateTo = 0;
	private TI_QUERY_OP_Enum MsgTimeFromOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long MsgTimeFrom = 0;
	private TI_QUERY_OP_Enum MsgTimeToOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long MsgTimeTo = 0;
	private TI_QUERY_OP_Enum MemberCodeOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String MemberCode = "";
	private TI_QUERY_OP_Enum CtpCodeOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String CtpCode = "";
	private TI_QUERY_OP_Enum TraderNameOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String TraderName = "";
	private TI_QUERY_OP_Enum TransactionIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long TransactionId = 0;
	private TI_QUERY_OP_Enum LegIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private short LegId = 0;
	private TI_QUERY_OP_Enum RfcqTypeOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private TI_RFCQ_TYPE_Enum RFCQType = TI_RFCQ_TYPE_Enum.TI_RFCQ_TYPE_Outright;
	private TI_QUERY_OP_Enum StageOrderIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long StageOrderId = 0;
	private TI_QUERY_OP_Enum ClientOrderIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String ClientOrderId = "";
	private TI_QUERY_OP_Enum AllocationIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long AllocationId = 0;
	private TI_QUERY_OP_Enum ClientAllocationIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String ClientAllocationId = "";
	private TI_QUERY_OP_Enum TradeIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long TradeId = 0;
	private TI_QUERY_OP_Enum CurrencyOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String Currency = "";
	private TI_QUERY_OP_Enum MicCodeOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String MicCode = "";
	private TI_QUERY_OP_Enum InstrumentCodeOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String InstrumentCode = "";
	private TI_QUERY_OP_Enum FinancialInstrumentCodeOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String FinancialInstrumentCode = "";
	private TI_QUERY_OP_Enum VerbOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private TI_VERB_Enum Verb = TI_VERB_Enum.TI_VERB_Buy;
	private TI_QUERY_OP_Enum SettlDateOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long SettlDate = 0;
	private TI_QUERY_OP_Enum SplitEventOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private BV_TRADE_SPLIT_EVENT_Enum SplitEvent = BV_TRADE_SPLIT_EVENT_Enum.BV_TRADE_SPLIT_EVENT_PreAllocate;

	public BV_HIST_BUY_SIDE_ALLOCATION_REPORT_QUERY_PARAM()
	{
	}

	public TI_QUERY_OP_Enum getMsgIdOp()
	{
		return MsgIdOp;
	}
	public void setMsgIdOp(TI_QUERY_OP_Enum value)
	{
		MsgIdOp = value;
	}
	public long getMsgId()
	{
		return MsgId;
	}
	public void setMsgId(long value)
	{
		MsgId = value;
	}
	public TI_QUERY_OP_Enum getMsgDateFromOp()
	{
		return MsgDateFromOp;
	}
	public void setMsgDateFromOp(TI_QUERY_OP_Enum value)
	{
		MsgDateFromOp = value;
	}
	public long getMsgDateFrom()
	{
		return MsgDateFrom;
	}
	public void setMsgDateFrom(long value)
	{
		MsgDateFrom = value;
	}
	public TI_QUERY_OP_Enum getMsgDateToOp()
	{
		return MsgDateToOp;
	}
	public void setMsgDateToOp(TI_QUERY_OP_Enum value)
	{
		MsgDateToOp = value;
	}
	public long getMsgDateTo()
	{
		return MsgDateTo;
	}
	public void setMsgDateTo(long value)
	{
		MsgDateTo = value;
	}
	public TI_QUERY_OP_Enum getMsgTimeFromOp()
	{
		return MsgTimeFromOp;
	}
	public void setMsgTimeFromOp(TI_QUERY_OP_Enum value)
	{
		MsgTimeFromOp = value;
	}
	public long getMsgTimeFrom()
	{
		return MsgTimeFrom;
	}
	public void setMsgTimeFrom(long value)
	{
		MsgTimeFrom = value;
	}
	public TI_QUERY_OP_Enum getMsgTimeToOp()
	{
		return MsgTimeToOp;
	}
	public void setMsgTimeToOp(TI_QUERY_OP_Enum value)
	{
		MsgTimeToOp = value;
	}
	public long getMsgTimeTo()
	{
		return MsgTimeTo;
	}
	public void setMsgTimeTo(long value)
	{
		MsgTimeTo = value;
	}
	public TI_QUERY_OP_Enum getMemberCodeOp()
	{
		return MemberCodeOp;
	}
	public void setMemberCodeOp(TI_QUERY_OP_Enum value)
	{
		MemberCodeOp = value;
	}
	public String getMemberCode()
	{
		return MemberCode;
	}
	public void setMemberCode(String value)
	{
		MemberCode = value;
	}
	public TI_QUERY_OP_Enum getCtpCodeOp()
	{
		return CtpCodeOp;
	}
	public void setCtpCodeOp(TI_QUERY_OP_Enum value)
	{
		CtpCodeOp = value;
	}
	public String getCtpCode()
	{
		return CtpCode;
	}
	public void setCtpCode(String value)
	{
		CtpCode = value;
	}
	public TI_QUERY_OP_Enum getTraderNameOp()
	{
		return TraderNameOp;
	}
	public void setTraderNameOp(TI_QUERY_OP_Enum value)
	{
		TraderNameOp = value;
	}
	public String getTraderName()
	{
		return TraderName;
	}
	public void setTraderName(String value)
	{
		TraderName = value;
	}
	public TI_QUERY_OP_Enum getTransactionIdOp()
	{
		return TransactionIdOp;
	}
	public void setTransactionIdOp(TI_QUERY_OP_Enum value)
	{
		TransactionIdOp = value;
	}
	public long getTransactionId()
	{
		return TransactionId;
	}
	public void setTransactionId(long value)
	{
		TransactionId = value;
	}
	public TI_QUERY_OP_Enum getLegIdOp()
	{
		return LegIdOp;
	}
	public void setLegIdOp(TI_QUERY_OP_Enum value)
	{
		LegIdOp = value;
	}
	public short getLegId()
	{
		return LegId;
	}
	public void setLegId(short value)
	{
		LegId = value;
	}
	public TI_QUERY_OP_Enum getRfcqTypeOp()
	{
		return RfcqTypeOp;
	}
	public void setRfcqTypeOp(TI_QUERY_OP_Enum value)
	{
		RfcqTypeOp = value;
	}
	public TI_RFCQ_TYPE_Enum getRFCQType()
	{
		return RFCQType;
	}
	public void setRFCQType(TI_RFCQ_TYPE_Enum value)
	{
		RFCQType = value;
	}
	public TI_QUERY_OP_Enum getStageOrderIdOp()
	{
		return StageOrderIdOp;
	}
	public void setStageOrderIdOp(TI_QUERY_OP_Enum value)
	{
		StageOrderIdOp = value;
	}
	public long getStageOrderId()
	{
		return StageOrderId;
	}
	public void setStageOrderId(long value)
	{
		StageOrderId = value;
	}
	public TI_QUERY_OP_Enum getClientOrderIdOp()
	{
		return ClientOrderIdOp;
	}
	public void setClientOrderIdOp(TI_QUERY_OP_Enum value)
	{
		ClientOrderIdOp = value;
	}
	public String getClientOrderId()
	{
		return ClientOrderId;
	}
	public void setClientOrderId(String value)
	{
		ClientOrderId = value;
	}
	public TI_QUERY_OP_Enum getAllocationIdOp()
	{
		return AllocationIdOp;
	}
	public void setAllocationIdOp(TI_QUERY_OP_Enum value)
	{
		AllocationIdOp = value;
	}
	public long getAllocationId()
	{
		return AllocationId;
	}
	public void setAllocationId(long value)
	{
		AllocationId = value;
	}
	public TI_QUERY_OP_Enum getClientAllocationIdOp()
	{
		return ClientAllocationIdOp;
	}
	public void setClientAllocationIdOp(TI_QUERY_OP_Enum value)
	{
		ClientAllocationIdOp = value;
	}
	public String getClientAllocationId()
	{
		return ClientAllocationId;
	}
	public void setClientAllocationId(String value)
	{
		ClientAllocationId = value;
	}
	public TI_QUERY_OP_Enum getTradeIdOp()
	{
		return TradeIdOp;
	}
	public void setTradeIdOp(TI_QUERY_OP_Enum value)
	{
		TradeIdOp = value;
	}
	public long getTradeId()
	{
		return TradeId;
	}
	public void setTradeId(long value)
	{
		TradeId = value;
	}
	public TI_QUERY_OP_Enum getCurrencyOp()
	{
		return CurrencyOp;
	}
	public void setCurrencyOp(TI_QUERY_OP_Enum value)
	{
		CurrencyOp = value;
	}
	public String getCurrency()
	{
		return Currency;
	}
	public void setCurrency(String value)
	{
		Currency = value;
	}
	public TI_QUERY_OP_Enum getMicCodeOp()
	{
		return MicCodeOp;
	}
	public void setMicCodeOp(TI_QUERY_OP_Enum value)
	{
		MicCodeOp = value;
	}
	public String getMicCode()
	{
		return MicCode;
	}
	public void setMicCode(String value)
	{
		MicCode = value;
	}
	public TI_QUERY_OP_Enum getInstrumentCodeOp()
	{
		return InstrumentCodeOp;
	}
	public void setInstrumentCodeOp(TI_QUERY_OP_Enum value)
	{
		InstrumentCodeOp = value;
	}
	public String getInstrumentCode()
	{
		return InstrumentCode;
	}
	public void setInstrumentCode(String value)
	{
		InstrumentCode = value;
	}
	public TI_QUERY_OP_Enum getFinancialInstrumentCodeOp()
	{
		return FinancialInstrumentCodeOp;
	}
	public void setFinancialInstrumentCodeOp(TI_QUERY_OP_Enum value)
	{
		FinancialInstrumentCodeOp = value;
	}
	public String getFinancialInstrumentCode()
	{
		return FinancialInstrumentCode;
	}
	public void setFinancialInstrumentCode(String value)
	{
		FinancialInstrumentCode = value;
	}
	public TI_QUERY_OP_Enum getVerbOp()
	{
		return VerbOp;
	}
	public void setVerbOp(TI_QUERY_OP_Enum value)
	{
		VerbOp = value;
	}
	public TI_VERB_Enum getVerb()
	{
		return Verb;
	}
	public void setVerb(TI_VERB_Enum value)
	{
		Verb = value;
	}
	public TI_QUERY_OP_Enum getSettlDateOp()
	{
		return SettlDateOp;
	}
	public void setSettlDateOp(TI_QUERY_OP_Enum value)
	{
		SettlDateOp = value;
	}
	public long getSettlDate()
	{
		return SettlDate;
	}
	public void setSettlDate(long value)
	{
		SettlDate = value;
	}
	public TI_QUERY_OP_Enum getSplitEventOp()
	{
		return SplitEventOp;
	}
	public void setSplitEventOp(TI_QUERY_OP_Enum value)
	{
		SplitEventOp = value;
	}
	public BV_TRADE_SPLIT_EVENT_Enum getSplitEvent()
	{
		return SplitEvent;
	}
	public void setSplitEvent(BV_TRADE_SPLIT_EVENT_Enum value)
	{
		SplitEvent = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MsgIdOp = MsgIdOp.getEnum(byteBuffer.readInt());
		MsgId = (long)byteBuffer.readInt();
		MsgDateFromOp = MsgDateFromOp.getEnum(byteBuffer.readInt());
		MsgDateFrom = (long)byteBuffer.readInt();
		MsgDateToOp = MsgDateToOp.getEnum(byteBuffer.readInt());
		MsgDateTo = (long)byteBuffer.readInt();
		MsgTimeFromOp = MsgTimeFromOp.getEnum(byteBuffer.readInt());
		MsgTimeFrom = byteBuffer.readLong();
		MsgTimeToOp = MsgTimeToOp.getEnum(byteBuffer.readInt());
		MsgTimeTo = byteBuffer.readLong();
		MemberCodeOp = MemberCodeOp.getEnum(byteBuffer.readInt());
		MemberCode = byteBuffer.readString();
		CtpCodeOp = CtpCodeOp.getEnum(byteBuffer.readInt());
		CtpCode = byteBuffer.readString();
		TraderNameOp = TraderNameOp.getEnum(byteBuffer.readInt());
		TraderName = byteBuffer.readString();
		TransactionIdOp = TransactionIdOp.getEnum(byteBuffer.readInt());
		TransactionId = (long)byteBuffer.readInt();
		LegIdOp = LegIdOp.getEnum(byteBuffer.readInt());
		LegId = (short)byteBuffer.readInt();
		RfcqTypeOp = RfcqTypeOp.getEnum(byteBuffer.readInt());
		RFCQType = RFCQType.getEnum(byteBuffer.readInt());
		StageOrderIdOp = StageOrderIdOp.getEnum(byteBuffer.readInt());
		StageOrderId = (long)byteBuffer.readInt();
		ClientOrderIdOp = ClientOrderIdOp.getEnum(byteBuffer.readInt());
		ClientOrderId = byteBuffer.readString();
		AllocationIdOp = AllocationIdOp.getEnum(byteBuffer.readInt());
		AllocationId = (long)byteBuffer.readInt();
		ClientAllocationIdOp = ClientAllocationIdOp.getEnum(byteBuffer.readInt());
		ClientAllocationId = byteBuffer.readString();
		TradeIdOp = TradeIdOp.getEnum(byteBuffer.readInt());
		TradeId = (long)byteBuffer.readInt();
		CurrencyOp = CurrencyOp.getEnum(byteBuffer.readInt());
		Currency = byteBuffer.readString();
		MicCodeOp = MicCodeOp.getEnum(byteBuffer.readInt());
		MicCode = byteBuffer.readString();
		InstrumentCodeOp = InstrumentCodeOp.getEnum(byteBuffer.readInt());
		InstrumentCode = byteBuffer.readString();
		FinancialInstrumentCodeOp = FinancialInstrumentCodeOp.getEnum(byteBuffer.readInt());
		FinancialInstrumentCode = byteBuffer.readString();
		VerbOp = VerbOp.getEnum(byteBuffer.readInt());
		Verb = Verb.getEnum(byteBuffer.readInt());
		SettlDateOp = SettlDateOp.getEnum(byteBuffer.readInt());
		SettlDate = (long)byteBuffer.readInt();
		SplitEventOp = SplitEventOp.getEnum(byteBuffer.readInt());
		SplitEvent = SplitEvent.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt(MsgIdOp.getValue());
		byteBuffer.writeInt((int)(MsgId & 0xFFFFFFFFL));
		byteBuffer.writeInt(MsgDateFromOp.getValue());
		byteBuffer.writeInt((int)(MsgDateFrom & 0xFFFFFFFFL));
		byteBuffer.writeInt(MsgDateToOp.getValue());
		byteBuffer.writeInt((int)(MsgDateTo & 0xFFFFFFFFL));
		byteBuffer.writeInt(MsgTimeFromOp.getValue());
		byteBuffer.writeLong(MsgTimeFrom);
		byteBuffer.writeInt(MsgTimeToOp.getValue());
		byteBuffer.writeLong(MsgTimeTo);
		byteBuffer.writeInt(MemberCodeOp.getValue());
		byteBuffer.writeString(MemberCode);
		byteBuffer.writeInt(CtpCodeOp.getValue());
		byteBuffer.writeString(CtpCode);
		byteBuffer.writeInt(TraderNameOp.getValue());
		byteBuffer.writeString(TraderName);
		byteBuffer.writeInt(TransactionIdOp.getValue());
		byteBuffer.writeInt((int)(TransactionId & 0xFFFFFFFFL));
		byteBuffer.writeInt(LegIdOp.getValue());
		byteBuffer.writeInt((int)(LegId & 0xFFFFL));
		byteBuffer.writeInt(RfcqTypeOp.getValue());
		byteBuffer.writeInt(RFCQType.getValue());
		byteBuffer.writeInt(StageOrderIdOp.getValue());
		byteBuffer.writeInt((int)(StageOrderId & 0xFFFFFFFFL));
		byteBuffer.writeInt(ClientOrderIdOp.getValue());
		byteBuffer.writeString(ClientOrderId);
		byteBuffer.writeInt(AllocationIdOp.getValue());
		byteBuffer.writeInt((int)(AllocationId & 0xFFFFFFFFL));
		byteBuffer.writeInt(ClientAllocationIdOp.getValue());
		byteBuffer.writeString(ClientAllocationId);
		byteBuffer.writeInt(TradeIdOp.getValue());
		byteBuffer.writeInt((int)(TradeId & 0xFFFFFFFFL));
		byteBuffer.writeInt(CurrencyOp.getValue());
		byteBuffer.writeString(Currency);
		byteBuffer.writeInt(MicCodeOp.getValue());
		byteBuffer.writeString(MicCode);
		byteBuffer.writeInt(InstrumentCodeOp.getValue());
		byteBuffer.writeString(InstrumentCode);
		byteBuffer.writeInt(FinancialInstrumentCodeOp.getValue());
		byteBuffer.writeString(FinancialInstrumentCode);
		byteBuffer.writeInt(VerbOp.getValue());
		byteBuffer.writeInt(Verb.getValue());
		byteBuffer.writeInt(SettlDateOp.getValue());
		byteBuffer.writeInt((int)(SettlDate & 0xFFFFFFFFL));
		byteBuffer.writeInt(SplitEventOp.getValue());
		byteBuffer.writeInt(SplitEvent.getValue());

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
		stringBuilder.append("BV_HIST_BUY_SIDE_ALLOCATION_REPORT_QUERY_PARAM::");
		stringBuilder.append("MsgIdOp(").append(MsgIdOp).append(")");
		stringBuilder.append("MsgId(").append(MsgId).append(")");
		stringBuilder.append("MsgDateFromOp(").append(MsgDateFromOp).append(")");
		stringBuilder.append("MsgDateFrom(").append(MsgDateFrom).append(")");
		stringBuilder.append("MsgDateToOp(").append(MsgDateToOp).append(")");
		stringBuilder.append("MsgDateTo(").append(MsgDateTo).append(")");
		stringBuilder.append("MsgTimeFromOp(").append(MsgTimeFromOp).append(")");
		stringBuilder.append("MsgTimeFrom(").append(MsgTimeFrom).append(")");
		stringBuilder.append("MsgTimeToOp(").append(MsgTimeToOp).append(")");
		stringBuilder.append("MsgTimeTo(").append(MsgTimeTo).append(")");
		stringBuilder.append("MemberCodeOp(").append(MemberCodeOp).append(")");
		stringBuilder.append("MemberCode(").append(MemberCode).append(")");
		stringBuilder.append("CtpCodeOp(").append(CtpCodeOp).append(")");
		stringBuilder.append("CtpCode(").append(CtpCode).append(")");
		stringBuilder.append("TraderNameOp(").append(TraderNameOp).append(")");
		stringBuilder.append("TraderName(").append(TraderName).append(")");
		stringBuilder.append("TransactionIdOp(").append(TransactionIdOp).append(")");
		stringBuilder.append("TransactionId(").append(TransactionId).append(")");
		stringBuilder.append("LegIdOp(").append(LegIdOp).append(")");
		stringBuilder.append("LegId(").append(LegId).append(")");
		stringBuilder.append("RfcqTypeOp(").append(RfcqTypeOp).append(")");
		stringBuilder.append("RFCQType(").append(RFCQType).append(")");
		stringBuilder.append("StageOrderIdOp(").append(StageOrderIdOp).append(")");
		stringBuilder.append("StageOrderId(").append(StageOrderId).append(")");
		stringBuilder.append("ClientOrderIdOp(").append(ClientOrderIdOp).append(")");
		stringBuilder.append("ClientOrderId(").append(ClientOrderId).append(")");
		stringBuilder.append("AllocationIdOp(").append(AllocationIdOp).append(")");
		stringBuilder.append("AllocationId(").append(AllocationId).append(")");
		stringBuilder.append("ClientAllocationIdOp(").append(ClientAllocationIdOp).append(")");
		stringBuilder.append("ClientAllocationId(").append(ClientAllocationId).append(")");
		stringBuilder.append("TradeIdOp(").append(TradeIdOp).append(")");
		stringBuilder.append("TradeId(").append(TradeId).append(")");
		stringBuilder.append("CurrencyOp(").append(CurrencyOp).append(")");
		stringBuilder.append("Currency(").append(Currency).append(")");
		stringBuilder.append("MicCodeOp(").append(MicCodeOp).append(")");
		stringBuilder.append("MicCode(").append(MicCode).append(")");
		stringBuilder.append("InstrumentCodeOp(").append(InstrumentCodeOp).append(")");
		stringBuilder.append("InstrumentCode(").append(InstrumentCode).append(")");
		stringBuilder.append("FinancialInstrumentCodeOp(").append(FinancialInstrumentCodeOp).append(")");
		stringBuilder.append("FinancialInstrumentCode(").append(FinancialInstrumentCode).append(")");
		stringBuilder.append("VerbOp(").append(VerbOp).append(")");
		stringBuilder.append("Verb(").append(Verb).append(")");
		stringBuilder.append("SettlDateOp(").append(SettlDateOp).append(")");
		stringBuilder.append("SettlDate(").append(SettlDate).append(")");
		stringBuilder.append("SplitEventOp(").append(SplitEventOp).append(")");
		stringBuilder.append("SplitEvent(").append(SplitEvent).append(")");
		return stringBuilder.toString();
	}
}
