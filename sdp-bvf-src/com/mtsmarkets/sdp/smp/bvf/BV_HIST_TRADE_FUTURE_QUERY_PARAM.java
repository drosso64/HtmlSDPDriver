package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_HIST_TRADE_FUTURE_QUERY_PARAM extends SMPMessage
{
	public static final long CLASS_ID = 214219;

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
	private TI_QUERY_OP_Enum CtpyCodeOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String CtpyCode = "";
	private TI_QUERY_OP_Enum CtpyShortDescOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String CtpyShortDesc = "";
	private TI_QUERY_OP_Enum TraderNameOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String TraderName = "";
	private TI_QUERY_OP_Enum FinancialInstrumentCodeOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String FinancialInstrumentCode = "";
	private TI_QUERY_OP_Enum InstrumentCodeOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String InstrumentCode = "";
	private TI_QUERY_OP_Enum InstrumentTypeOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private TI_INSTRUMENT_TYPE_Enum InstrumentType = TI_INSTRUMENT_TYPE_Enum.TI_INSTRUMENT_TYPE_Bond;
	private TI_QUERY_OP_Enum SectionCodeOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String SectionCode = "";
	private TI_QUERY_OP_Enum VerbOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private TI_VERB_Enum Verb = TI_VERB_Enum.TI_VERB_Buy;
	private TI_QUERY_OP_Enum DealIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long DealId = 0;
	private TI_QUERY_OP_Enum CashTradeIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long CashTradeId = 0;
	private TI_QUERY_OP_Enum SettlTradeIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String SettlTradeId = "";
	private TI_QUERY_OP_Enum ParentTradeIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long ParentTradeId = 0;

	public BV_HIST_TRADE_FUTURE_QUERY_PARAM()
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
	public TI_QUERY_OP_Enum getCtpyCodeOp()
	{
		return CtpyCodeOp;
	}
	public void setCtpyCodeOp(TI_QUERY_OP_Enum value)
	{
		CtpyCodeOp = value;
	}
	public String getCtpyCode()
	{
		return CtpyCode;
	}
	public void setCtpyCode(String value)
	{
		CtpyCode = value;
	}
	public TI_QUERY_OP_Enum getCtpyShortDescOp()
	{
		return CtpyShortDescOp;
	}
	public void setCtpyShortDescOp(TI_QUERY_OP_Enum value)
	{
		CtpyShortDescOp = value;
	}
	public String getCtpyShortDesc()
	{
		return CtpyShortDesc;
	}
	public void setCtpyShortDesc(String value)
	{
		CtpyShortDesc = value;
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
	public TI_QUERY_OP_Enum getInstrumentTypeOp()
	{
		return InstrumentTypeOp;
	}
	public void setInstrumentTypeOp(TI_QUERY_OP_Enum value)
	{
		InstrumentTypeOp = value;
	}
	public TI_INSTRUMENT_TYPE_Enum getInstrumentType()
	{
		return InstrumentType;
	}
	public void setInstrumentType(TI_INSTRUMENT_TYPE_Enum value)
	{
		InstrumentType = value;
	}
	public TI_QUERY_OP_Enum getSectionCodeOp()
	{
		return SectionCodeOp;
	}
	public void setSectionCodeOp(TI_QUERY_OP_Enum value)
	{
		SectionCodeOp = value;
	}
	public String getSectionCode()
	{
		return SectionCode;
	}
	public void setSectionCode(String value)
	{
		SectionCode = value;
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
	public TI_QUERY_OP_Enum getDealIdOp()
	{
		return DealIdOp;
	}
	public void setDealIdOp(TI_QUERY_OP_Enum value)
	{
		DealIdOp = value;
	}
	public long getDealId()
	{
		return DealId;
	}
	public void setDealId(long value)
	{
		DealId = value;
	}
	public TI_QUERY_OP_Enum getCashTradeIdOp()
	{
		return CashTradeIdOp;
	}
	public void setCashTradeIdOp(TI_QUERY_OP_Enum value)
	{
		CashTradeIdOp = value;
	}
	public long getCashTradeId()
	{
		return CashTradeId;
	}
	public void setCashTradeId(long value)
	{
		CashTradeId = value;
	}
	public TI_QUERY_OP_Enum getSettlTradeIdOp()
	{
		return SettlTradeIdOp;
	}
	public void setSettlTradeIdOp(TI_QUERY_OP_Enum value)
	{
		SettlTradeIdOp = value;
	}
	public String getSettlTradeId()
	{
		return SettlTradeId;
	}
	public void setSettlTradeId(String value)
	{
		SettlTradeId = value;
	}
	public TI_QUERY_OP_Enum getParentTradeIdOp()
	{
		return ParentTradeIdOp;
	}
	public void setParentTradeIdOp(TI_QUERY_OP_Enum value)
	{
		ParentTradeIdOp = value;
	}
	public long getParentTradeId()
	{
		return ParentTradeId;
	}
	public void setParentTradeId(long value)
	{
		ParentTradeId = value;
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
		CtpyCodeOp = CtpyCodeOp.getEnum(byteBuffer.readInt());
		CtpyCode = byteBuffer.readString();
		CtpyShortDescOp = CtpyShortDescOp.getEnum(byteBuffer.readInt());
		CtpyShortDesc = byteBuffer.readString();
		TraderNameOp = TraderNameOp.getEnum(byteBuffer.readInt());
		TraderName = byteBuffer.readString();
		FinancialInstrumentCodeOp = FinancialInstrumentCodeOp.getEnum(byteBuffer.readInt());
		FinancialInstrumentCode = byteBuffer.readString();
		InstrumentCodeOp = InstrumentCodeOp.getEnum(byteBuffer.readInt());
		InstrumentCode = byteBuffer.readString();
		InstrumentTypeOp = InstrumentTypeOp.getEnum(byteBuffer.readInt());
		InstrumentType = InstrumentType.getEnum(byteBuffer.readInt());
		SectionCodeOp = SectionCodeOp.getEnum(byteBuffer.readInt());
		SectionCode = byteBuffer.readString();
		VerbOp = VerbOp.getEnum(byteBuffer.readInt());
		Verb = Verb.getEnum(byteBuffer.readInt());
		DealIdOp = DealIdOp.getEnum(byteBuffer.readInt());
		DealId = (long)byteBuffer.readInt();
		CashTradeIdOp = CashTradeIdOp.getEnum(byteBuffer.readInt());
		CashTradeId = (long)byteBuffer.readInt();
		SettlTradeIdOp = SettlTradeIdOp.getEnum(byteBuffer.readInt());
		SettlTradeId = byteBuffer.readString();
		ParentTradeIdOp = ParentTradeIdOp.getEnum(byteBuffer.readInt());
		ParentTradeId = (long)byteBuffer.readInt();
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
		byteBuffer.writeInt(CtpyCodeOp.getValue());
		byteBuffer.writeString(CtpyCode);
		byteBuffer.writeInt(CtpyShortDescOp.getValue());
		byteBuffer.writeString(CtpyShortDesc);
		byteBuffer.writeInt(TraderNameOp.getValue());
		byteBuffer.writeString(TraderName);
		byteBuffer.writeInt(FinancialInstrumentCodeOp.getValue());
		byteBuffer.writeString(FinancialInstrumentCode);
		byteBuffer.writeInt(InstrumentCodeOp.getValue());
		byteBuffer.writeString(InstrumentCode);
		byteBuffer.writeInt(InstrumentTypeOp.getValue());
		byteBuffer.writeInt(InstrumentType.getValue());
		byteBuffer.writeInt(SectionCodeOp.getValue());
		byteBuffer.writeString(SectionCode);
		byteBuffer.writeInt(VerbOp.getValue());
		byteBuffer.writeInt(Verb.getValue());
		byteBuffer.writeInt(DealIdOp.getValue());
		byteBuffer.writeInt((int)(DealId & 0xFFFFFFFFL));
		byteBuffer.writeInt(CashTradeIdOp.getValue());
		byteBuffer.writeInt((int)(CashTradeId & 0xFFFFFFFFL));
		byteBuffer.writeInt(SettlTradeIdOp.getValue());
		byteBuffer.writeString(SettlTradeId);
		byteBuffer.writeInt(ParentTradeIdOp.getValue());
		byteBuffer.writeInt((int)(ParentTradeId & 0xFFFFFFFFL));

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
		stringBuilder.append("BV_HIST_TRADE_FUTURE_QUERY_PARAM::");
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
		stringBuilder.append("CtpyCodeOp(").append(CtpyCodeOp).append(")");
		stringBuilder.append("CtpyCode(").append(CtpyCode).append(")");
		stringBuilder.append("CtpyShortDescOp(").append(CtpyShortDescOp).append(")");
		stringBuilder.append("CtpyShortDesc(").append(CtpyShortDesc).append(")");
		stringBuilder.append("TraderNameOp(").append(TraderNameOp).append(")");
		stringBuilder.append("TraderName(").append(TraderName).append(")");
		stringBuilder.append("FinancialInstrumentCodeOp(").append(FinancialInstrumentCodeOp).append(")");
		stringBuilder.append("FinancialInstrumentCode(").append(FinancialInstrumentCode).append(")");
		stringBuilder.append("InstrumentCodeOp(").append(InstrumentCodeOp).append(")");
		stringBuilder.append("InstrumentCode(").append(InstrumentCode).append(")");
		stringBuilder.append("InstrumentTypeOp(").append(InstrumentTypeOp).append(")");
		stringBuilder.append("InstrumentType(").append(InstrumentType).append(")");
		stringBuilder.append("SectionCodeOp(").append(SectionCodeOp).append(")");
		stringBuilder.append("SectionCode(").append(SectionCode).append(")");
		stringBuilder.append("VerbOp(").append(VerbOp).append(")");
		stringBuilder.append("Verb(").append(Verb).append(")");
		stringBuilder.append("DealIdOp(").append(DealIdOp).append(")");
		stringBuilder.append("DealId(").append(DealId).append(")");
		stringBuilder.append("CashTradeIdOp(").append(CashTradeIdOp).append(")");
		stringBuilder.append("CashTradeId(").append(CashTradeId).append(")");
		stringBuilder.append("SettlTradeIdOp(").append(SettlTradeIdOp).append(")");
		stringBuilder.append("SettlTradeId(").append(SettlTradeId).append(")");
		stringBuilder.append("ParentTradeIdOp(").append(ParentTradeIdOp).append(")");
		stringBuilder.append("ParentTradeId(").append(ParentTradeId).append(")");
		return stringBuilder.toString();
	}
}
