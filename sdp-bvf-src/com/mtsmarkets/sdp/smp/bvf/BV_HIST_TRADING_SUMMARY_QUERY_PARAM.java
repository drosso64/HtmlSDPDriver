package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_HIST_TRADING_SUMMARY_QUERY_PARAM extends SMPMessage
{
	public static final long CLASS_ID = 214214;

	private TI_QUERY_OP_Enum TradingSummaryIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String TradingSummaryId = "";
	private TI_QUERY_OP_Enum TradingTypeOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private TI_TRADE_TYPE_Enum TradingType = TI_TRADE_TYPE_Enum.TI_TRADE_TYPE_Normal;
	private TI_QUERY_OP_Enum MsgIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long MsgId = 0;
	private TI_QUERY_OP_Enum RFCQTypeOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private TI_RFCQ_TYPE_Enum RFCQType = TI_RFCQ_TYPE_Enum.TI_RFCQ_TYPE_Outright;
	private TI_QUERY_OP_Enum LegIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private short LegId = 0;
	private TI_QUERY_OP_Enum AccountCodeOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String AccountCode = "";
	private TI_QUERY_OP_Enum StatusOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String Status = "";
	private TI_QUERY_OP_Enum StageOrderIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long StageOrderId = 0;
	private TI_QUERY_OP_Enum AutoExecutionFgOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private TI_FLAG_Enum AutoExecutionFg = TI_FLAG_Enum.TI_FLAG_No;
	private TI_QUERY_OP_Enum AutoExecutionIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long AutoExecutionId = 0;
	private TI_QUERY_OP_Enum DealIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long DealId = 0;
	private TI_QUERY_OP_Enum TradeIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long TradeId = 0;
	private TI_QUERY_OP_Enum InstrumentClassCodeOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String InstrumentClassCode = "";
	private TI_QUERY_OP_Enum TradableInstrumentCodeOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String TradableInstrumentCode = "";
	private TI_QUERY_OP_Enum CreationDateFromOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long CreationDateFrom = 0;
	private TI_QUERY_OP_Enum CreationDateToOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long CreationDateTo = 0;
	private TI_QUERY_OP_Enum CreationTimeFromOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long CreationTimeFrom = 0;
	private TI_QUERY_OP_Enum CreationTimeToOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long CreationTimeTo = 0;
	private TI_QUERY_OP_Enum BuySideMemberCodeOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String BuySideMemberCode = "";
	private TI_QUERY_OP_Enum BuySideTraderNameOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String BuySideTraderName = "";
	private TI_QUERY_OP_Enum SellSideMemberCodeOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String SellSideMemberCode = "";
	private TI_QUERY_OP_Enum SellSideTraderNameOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String SellSideTraderName = "";

	public BV_HIST_TRADING_SUMMARY_QUERY_PARAM()
	{
	}

	public TI_QUERY_OP_Enum getTradingSummaryIdOp()
	{
		return TradingSummaryIdOp;
	}
	public void setTradingSummaryIdOp(TI_QUERY_OP_Enum value)
	{
		TradingSummaryIdOp = value;
	}
	public String getTradingSummaryId()
	{
		return TradingSummaryId;
	}
	public void setTradingSummaryId(String value)
	{
		TradingSummaryId = value;
	}
	public TI_QUERY_OP_Enum getTradingTypeOp()
	{
		return TradingTypeOp;
	}
	public void setTradingTypeOp(TI_QUERY_OP_Enum value)
	{
		TradingTypeOp = value;
	}
	public TI_TRADE_TYPE_Enum getTradingType()
	{
		return TradingType;
	}
	public void setTradingType(TI_TRADE_TYPE_Enum value)
	{
		TradingType = value;
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
	public TI_QUERY_OP_Enum getRFCQTypeOp()
	{
		return RFCQTypeOp;
	}
	public void setRFCQTypeOp(TI_QUERY_OP_Enum value)
	{
		RFCQTypeOp = value;
	}
	public TI_RFCQ_TYPE_Enum getRFCQType()
	{
		return RFCQType;
	}
	public void setRFCQType(TI_RFCQ_TYPE_Enum value)
	{
		RFCQType = value;
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
	public TI_QUERY_OP_Enum getAccountCodeOp()
	{
		return AccountCodeOp;
	}
	public void setAccountCodeOp(TI_QUERY_OP_Enum value)
	{
		AccountCodeOp = value;
	}
	public String getAccountCode()
	{
		return AccountCode;
	}
	public void setAccountCode(String value)
	{
		AccountCode = value;
	}
	public TI_QUERY_OP_Enum getStatusOp()
	{
		return StatusOp;
	}
	public void setStatusOp(TI_QUERY_OP_Enum value)
	{
		StatusOp = value;
	}
	public String getStatus()
	{
		return Status;
	}
	public void setStatus(String value)
	{
		Status = value;
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
	public TI_QUERY_OP_Enum getAutoExecutionFgOp()
	{
		return AutoExecutionFgOp;
	}
	public void setAutoExecutionFgOp(TI_QUERY_OP_Enum value)
	{
		AutoExecutionFgOp = value;
	}
	public TI_FLAG_Enum getAutoExecutionFg()
	{
		return AutoExecutionFg;
	}
	public void setAutoExecutionFg(TI_FLAG_Enum value)
	{
		AutoExecutionFg = value;
	}
	public TI_QUERY_OP_Enum getAutoExecutionIdOp()
	{
		return AutoExecutionIdOp;
	}
	public void setAutoExecutionIdOp(TI_QUERY_OP_Enum value)
	{
		AutoExecutionIdOp = value;
	}
	public long getAutoExecutionId()
	{
		return AutoExecutionId;
	}
	public void setAutoExecutionId(long value)
	{
		AutoExecutionId = value;
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
	public TI_QUERY_OP_Enum getInstrumentClassCodeOp()
	{
		return InstrumentClassCodeOp;
	}
	public void setInstrumentClassCodeOp(TI_QUERY_OP_Enum value)
	{
		InstrumentClassCodeOp = value;
	}
	public String getInstrumentClassCode()
	{
		return InstrumentClassCode;
	}
	public void setInstrumentClassCode(String value)
	{
		InstrumentClassCode = value;
	}
	public TI_QUERY_OP_Enum getTradableInstrumentCodeOp()
	{
		return TradableInstrumentCodeOp;
	}
	public void setTradableInstrumentCodeOp(TI_QUERY_OP_Enum value)
	{
		TradableInstrumentCodeOp = value;
	}
	public String getTradableInstrumentCode()
	{
		return TradableInstrumentCode;
	}
	public void setTradableInstrumentCode(String value)
	{
		TradableInstrumentCode = value;
	}
	public TI_QUERY_OP_Enum getCreationDateFromOp()
	{
		return CreationDateFromOp;
	}
	public void setCreationDateFromOp(TI_QUERY_OP_Enum value)
	{
		CreationDateFromOp = value;
	}
	public long getCreationDateFrom()
	{
		return CreationDateFrom;
	}
	public void setCreationDateFrom(long value)
	{
		CreationDateFrom = value;
	}
	public TI_QUERY_OP_Enum getCreationDateToOp()
	{
		return CreationDateToOp;
	}
	public void setCreationDateToOp(TI_QUERY_OP_Enum value)
	{
		CreationDateToOp = value;
	}
	public long getCreationDateTo()
	{
		return CreationDateTo;
	}
	public void setCreationDateTo(long value)
	{
		CreationDateTo = value;
	}
	public TI_QUERY_OP_Enum getCreationTimeFromOp()
	{
		return CreationTimeFromOp;
	}
	public void setCreationTimeFromOp(TI_QUERY_OP_Enum value)
	{
		CreationTimeFromOp = value;
	}
	public long getCreationTimeFrom()
	{
		return CreationTimeFrom;
	}
	public void setCreationTimeFrom(long value)
	{
		CreationTimeFrom = value;
	}
	public TI_QUERY_OP_Enum getCreationTimeToOp()
	{
		return CreationTimeToOp;
	}
	public void setCreationTimeToOp(TI_QUERY_OP_Enum value)
	{
		CreationTimeToOp = value;
	}
	public long getCreationTimeTo()
	{
		return CreationTimeTo;
	}
	public void setCreationTimeTo(long value)
	{
		CreationTimeTo = value;
	}
	public TI_QUERY_OP_Enum getBuySideMemberCodeOp()
	{
		return BuySideMemberCodeOp;
	}
	public void setBuySideMemberCodeOp(TI_QUERY_OP_Enum value)
	{
		BuySideMemberCodeOp = value;
	}
	public String getBuySideMemberCode()
	{
		return BuySideMemberCode;
	}
	public void setBuySideMemberCode(String value)
	{
		BuySideMemberCode = value;
	}
	public TI_QUERY_OP_Enum getBuySideTraderNameOp()
	{
		return BuySideTraderNameOp;
	}
	public void setBuySideTraderNameOp(TI_QUERY_OP_Enum value)
	{
		BuySideTraderNameOp = value;
	}
	public String getBuySideTraderName()
	{
		return BuySideTraderName;
	}
	public void setBuySideTraderName(String value)
	{
		BuySideTraderName = value;
	}
	public TI_QUERY_OP_Enum getSellSideMemberCodeOp()
	{
		return SellSideMemberCodeOp;
	}
	public void setSellSideMemberCodeOp(TI_QUERY_OP_Enum value)
	{
		SellSideMemberCodeOp = value;
	}
	public String getSellSideMemberCode()
	{
		return SellSideMemberCode;
	}
	public void setSellSideMemberCode(String value)
	{
		SellSideMemberCode = value;
	}
	public TI_QUERY_OP_Enum getSellSideTraderNameOp()
	{
		return SellSideTraderNameOp;
	}
	public void setSellSideTraderNameOp(TI_QUERY_OP_Enum value)
	{
		SellSideTraderNameOp = value;
	}
	public String getSellSideTraderName()
	{
		return SellSideTraderName;
	}
	public void setSellSideTraderName(String value)
	{
		SellSideTraderName = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		TradingSummaryIdOp = TradingSummaryIdOp.getEnum(byteBuffer.readInt());
		TradingSummaryId = byteBuffer.readString();
		TradingTypeOp = TradingTypeOp.getEnum(byteBuffer.readInt());
		TradingType = TradingType.getEnum(byteBuffer.readInt());
		MsgIdOp = MsgIdOp.getEnum(byteBuffer.readInt());
		MsgId = (long)byteBuffer.readInt();
		RFCQTypeOp = RFCQTypeOp.getEnum(byteBuffer.readInt());
		RFCQType = RFCQType.getEnum(byteBuffer.readInt());
		LegIdOp = LegIdOp.getEnum(byteBuffer.readInt());
		LegId = (short)byteBuffer.readInt();
		AccountCodeOp = AccountCodeOp.getEnum(byteBuffer.readInt());
		AccountCode = byteBuffer.readString();
		StatusOp = StatusOp.getEnum(byteBuffer.readInt());
		Status = byteBuffer.readString();
		StageOrderIdOp = StageOrderIdOp.getEnum(byteBuffer.readInt());
		StageOrderId = (long)byteBuffer.readInt();
		AutoExecutionFgOp = AutoExecutionFgOp.getEnum(byteBuffer.readInt());
		AutoExecutionFg = AutoExecutionFg.getEnum(byteBuffer.readInt());
		AutoExecutionIdOp = AutoExecutionIdOp.getEnum(byteBuffer.readInt());
		AutoExecutionId = (long)byteBuffer.readInt();
		DealIdOp = DealIdOp.getEnum(byteBuffer.readInt());
		DealId = (long)byteBuffer.readInt();
		TradeIdOp = TradeIdOp.getEnum(byteBuffer.readInt());
		TradeId = (long)byteBuffer.readInt();
		InstrumentClassCodeOp = InstrumentClassCodeOp.getEnum(byteBuffer.readInt());
		InstrumentClassCode = byteBuffer.readString();
		TradableInstrumentCodeOp = TradableInstrumentCodeOp.getEnum(byteBuffer.readInt());
		TradableInstrumentCode = byteBuffer.readString();
		CreationDateFromOp = CreationDateFromOp.getEnum(byteBuffer.readInt());
		CreationDateFrom = (long)byteBuffer.readInt();
		CreationDateToOp = CreationDateToOp.getEnum(byteBuffer.readInt());
		CreationDateTo = (long)byteBuffer.readInt();
		CreationTimeFromOp = CreationTimeFromOp.getEnum(byteBuffer.readInt());
		CreationTimeFrom = byteBuffer.readLong();
		CreationTimeToOp = CreationTimeToOp.getEnum(byteBuffer.readInt());
		CreationTimeTo = byteBuffer.readLong();
		BuySideMemberCodeOp = BuySideMemberCodeOp.getEnum(byteBuffer.readInt());
		BuySideMemberCode = byteBuffer.readString();
		BuySideTraderNameOp = BuySideTraderNameOp.getEnum(byteBuffer.readInt());
		BuySideTraderName = byteBuffer.readString();
		SellSideMemberCodeOp = SellSideMemberCodeOp.getEnum(byteBuffer.readInt());
		SellSideMemberCode = byteBuffer.readString();
		SellSideTraderNameOp = SellSideTraderNameOp.getEnum(byteBuffer.readInt());
		SellSideTraderName = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt(TradingSummaryIdOp.getValue());
		byteBuffer.writeString(TradingSummaryId);
		byteBuffer.writeInt(TradingTypeOp.getValue());
		byteBuffer.writeInt(TradingType.getValue());
		byteBuffer.writeInt(MsgIdOp.getValue());
		byteBuffer.writeInt((int)(MsgId & 0xFFFFFFFFL));
		byteBuffer.writeInt(RFCQTypeOp.getValue());
		byteBuffer.writeInt(RFCQType.getValue());
		byteBuffer.writeInt(LegIdOp.getValue());
		byteBuffer.writeInt((int)(LegId & 0xFFFFL));
		byteBuffer.writeInt(AccountCodeOp.getValue());
		byteBuffer.writeString(AccountCode);
		byteBuffer.writeInt(StatusOp.getValue());
		byteBuffer.writeString(Status);
		byteBuffer.writeInt(StageOrderIdOp.getValue());
		byteBuffer.writeInt((int)(StageOrderId & 0xFFFFFFFFL));
		byteBuffer.writeInt(AutoExecutionFgOp.getValue());
		byteBuffer.writeInt(AutoExecutionFg.getValue());
		byteBuffer.writeInt(AutoExecutionIdOp.getValue());
		byteBuffer.writeInt((int)(AutoExecutionId & 0xFFFFFFFFL));
		byteBuffer.writeInt(DealIdOp.getValue());
		byteBuffer.writeInt((int)(DealId & 0xFFFFFFFFL));
		byteBuffer.writeInt(TradeIdOp.getValue());
		byteBuffer.writeInt((int)(TradeId & 0xFFFFFFFFL));
		byteBuffer.writeInt(InstrumentClassCodeOp.getValue());
		byteBuffer.writeString(InstrumentClassCode);
		byteBuffer.writeInt(TradableInstrumentCodeOp.getValue());
		byteBuffer.writeString(TradableInstrumentCode);
		byteBuffer.writeInt(CreationDateFromOp.getValue());
		byteBuffer.writeInt((int)(CreationDateFrom & 0xFFFFFFFFL));
		byteBuffer.writeInt(CreationDateToOp.getValue());
		byteBuffer.writeInt((int)(CreationDateTo & 0xFFFFFFFFL));
		byteBuffer.writeInt(CreationTimeFromOp.getValue());
		byteBuffer.writeLong(CreationTimeFrom);
		byteBuffer.writeInt(CreationTimeToOp.getValue());
		byteBuffer.writeLong(CreationTimeTo);
		byteBuffer.writeInt(BuySideMemberCodeOp.getValue());
		byteBuffer.writeString(BuySideMemberCode);
		byteBuffer.writeInt(BuySideTraderNameOp.getValue());
		byteBuffer.writeString(BuySideTraderName);
		byteBuffer.writeInt(SellSideMemberCodeOp.getValue());
		byteBuffer.writeString(SellSideMemberCode);
		byteBuffer.writeInt(SellSideTraderNameOp.getValue());
		byteBuffer.writeString(SellSideTraderName);

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
		stringBuilder.append("BV_HIST_TRADING_SUMMARY_QUERY_PARAM::");
		stringBuilder.append("TradingSummaryIdOp(").append(TradingSummaryIdOp).append(")");
		stringBuilder.append("TradingSummaryId(").append(TradingSummaryId).append(")");
		stringBuilder.append("TradingTypeOp(").append(TradingTypeOp).append(")");
		stringBuilder.append("TradingType(").append(TradingType).append(")");
		stringBuilder.append("MsgIdOp(").append(MsgIdOp).append(")");
		stringBuilder.append("MsgId(").append(MsgId).append(")");
		stringBuilder.append("RFCQTypeOp(").append(RFCQTypeOp).append(")");
		stringBuilder.append("RFCQType(").append(RFCQType).append(")");
		stringBuilder.append("LegIdOp(").append(LegIdOp).append(")");
		stringBuilder.append("LegId(").append(LegId).append(")");
		stringBuilder.append("AccountCodeOp(").append(AccountCodeOp).append(")");
		stringBuilder.append("AccountCode(").append(AccountCode).append(")");
		stringBuilder.append("StatusOp(").append(StatusOp).append(")");
		stringBuilder.append("Status(").append(Status).append(")");
		stringBuilder.append("StageOrderIdOp(").append(StageOrderIdOp).append(")");
		stringBuilder.append("StageOrderId(").append(StageOrderId).append(")");
		stringBuilder.append("AutoExecutionFgOp(").append(AutoExecutionFgOp).append(")");
		stringBuilder.append("AutoExecutionFg(").append(AutoExecutionFg).append(")");
		stringBuilder.append("AutoExecutionIdOp(").append(AutoExecutionIdOp).append(")");
		stringBuilder.append("AutoExecutionId(").append(AutoExecutionId).append(")");
		stringBuilder.append("DealIdOp(").append(DealIdOp).append(")");
		stringBuilder.append("DealId(").append(DealId).append(")");
		stringBuilder.append("TradeIdOp(").append(TradeIdOp).append(")");
		stringBuilder.append("TradeId(").append(TradeId).append(")");
		stringBuilder.append("InstrumentClassCodeOp(").append(InstrumentClassCodeOp).append(")");
		stringBuilder.append("InstrumentClassCode(").append(InstrumentClassCode).append(")");
		stringBuilder.append("TradableInstrumentCodeOp(").append(TradableInstrumentCodeOp).append(")");
		stringBuilder.append("TradableInstrumentCode(").append(TradableInstrumentCode).append(")");
		stringBuilder.append("CreationDateFromOp(").append(CreationDateFromOp).append(")");
		stringBuilder.append("CreationDateFrom(").append(CreationDateFrom).append(")");
		stringBuilder.append("CreationDateToOp(").append(CreationDateToOp).append(")");
		stringBuilder.append("CreationDateTo(").append(CreationDateTo).append(")");
		stringBuilder.append("CreationTimeFromOp(").append(CreationTimeFromOp).append(")");
		stringBuilder.append("CreationTimeFrom(").append(CreationTimeFrom).append(")");
		stringBuilder.append("CreationTimeToOp(").append(CreationTimeToOp).append(")");
		stringBuilder.append("CreationTimeTo(").append(CreationTimeTo).append(")");
		stringBuilder.append("BuySideMemberCodeOp(").append(BuySideMemberCodeOp).append(")");
		stringBuilder.append("BuySideMemberCode(").append(BuySideMemberCode).append(")");
		stringBuilder.append("BuySideTraderNameOp(").append(BuySideTraderNameOp).append(")");
		stringBuilder.append("BuySideTraderName(").append(BuySideTraderName).append(")");
		stringBuilder.append("SellSideMemberCodeOp(").append(SellSideMemberCodeOp).append(")");
		stringBuilder.append("SellSideMemberCode(").append(SellSideMemberCode).append(")");
		stringBuilder.append("SellSideTraderNameOp(").append(SellSideTraderNameOp).append(")");
		stringBuilder.append("SellSideTraderName(").append(SellSideTraderName).append(")");
		return stringBuilder.toString();
	}
}
