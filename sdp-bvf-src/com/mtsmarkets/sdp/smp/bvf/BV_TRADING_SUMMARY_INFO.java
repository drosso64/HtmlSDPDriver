package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_TRADING_SUMMARY_INFO extends SMPMessage
{
	public static final long CLASS_ID = 114967;

	private String TradingSummaryId = "";
	private TI_TRADE_TYPE_Enum TradingType = TI_TRADE_TYPE_Enum.TI_TRADE_TYPE_Normal;
	private long MsgId = 0;
	private TI_RFCQ_TYPE_Enum RFCQType = TI_RFCQ_TYPE_Enum.TI_RFCQ_TYPE_Outright;
	private short LegId = 0;
	private String Status = "";
	private long StageOrderId = 0;
	private String AccountCode = "";
	private TI_FLAG_Enum AutoExecutionFg = TI_FLAG_Enum.TI_FLAG_No;
	private long AutoExecutionId = 0;
	private long DealId = 0;
	private long TradeId = 0;
	private String InstrumentClassCode = "";
	private String TradableInstrumentCode = "";
	private String BuySideMemberCode = "";
	private String BuySideTraderName = "";
	private String SellSideMemberCode = "";
	private String SellSideTraderName = "";
	private long CreationDate = 0;
	private long CreationTime = 0;
	private long UpdateTime = 0;
	private String Data = "";

	public BV_TRADING_SUMMARY_INFO()
	{
	}

	public String getTradingSummaryId()
	{
		return TradingSummaryId;
	}
	public void setTradingSummaryId(String value)
	{
		TradingSummaryId = value;
	}
	public TI_TRADE_TYPE_Enum getTradingType()
	{
		return TradingType;
	}
	public void setTradingType(TI_TRADE_TYPE_Enum value)
	{
		TradingType = value;
	}
	public long getMsgId()
	{
		return MsgId;
	}
	public void setMsgId(long value)
	{
		MsgId = value;
	}
	public TI_RFCQ_TYPE_Enum getRFCQType()
	{
		return RFCQType;
	}
	public void setRFCQType(TI_RFCQ_TYPE_Enum value)
	{
		RFCQType = value;
	}
	public short getLegId()
	{
		return LegId;
	}
	public void setLegId(short value)
	{
		LegId = value;
	}
	public String getStatus()
	{
		return Status;
	}
	public void setStatus(String value)
	{
		Status = value;
	}
	public long getStageOrderId()
	{
		return StageOrderId;
	}
	public void setStageOrderId(long value)
	{
		StageOrderId = value;
	}
	public String getAccountCode()
	{
		return AccountCode;
	}
	public void setAccountCode(String value)
	{
		AccountCode = value;
	}
	public TI_FLAG_Enum getAutoExecutionFg()
	{
		return AutoExecutionFg;
	}
	public void setAutoExecutionFg(TI_FLAG_Enum value)
	{
		AutoExecutionFg = value;
	}
	public long getAutoExecutionId()
	{
		return AutoExecutionId;
	}
	public void setAutoExecutionId(long value)
	{
		AutoExecutionId = value;
	}
	public long getDealId()
	{
		return DealId;
	}
	public void setDealId(long value)
	{
		DealId = value;
	}
	public long getTradeId()
	{
		return TradeId;
	}
	public void setTradeId(long value)
	{
		TradeId = value;
	}
	public String getInstrumentClassCode()
	{
		return InstrumentClassCode;
	}
	public void setInstrumentClassCode(String value)
	{
		InstrumentClassCode = value;
	}
	public String getTradableInstrumentCode()
	{
		return TradableInstrumentCode;
	}
	public void setTradableInstrumentCode(String value)
	{
		TradableInstrumentCode = value;
	}
	public String getBuySideMemberCode()
	{
		return BuySideMemberCode;
	}
	public void setBuySideMemberCode(String value)
	{
		BuySideMemberCode = value;
	}
	public String getBuySideTraderName()
	{
		return BuySideTraderName;
	}
	public void setBuySideTraderName(String value)
	{
		BuySideTraderName = value;
	}
	public String getSellSideMemberCode()
	{
		return SellSideMemberCode;
	}
	public void setSellSideMemberCode(String value)
	{
		SellSideMemberCode = value;
	}
	public String getSellSideTraderName()
	{
		return SellSideTraderName;
	}
	public void setSellSideTraderName(String value)
	{
		SellSideTraderName = value;
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
	public long getUpdateTime()
	{
		return UpdateTime;
	}
	public void setUpdateTime(long value)
	{
		UpdateTime = value;
	}
	public String getData()
	{
		return Data;
	}
	public void setData(String value)
	{
		Data = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		TradingSummaryId = byteBuffer.readString();
		TradingType = TradingType.getEnum(byteBuffer.readInt());
		MsgId = (long)byteBuffer.readInt();
		RFCQType = RFCQType.getEnum(byteBuffer.readInt());
		LegId = (short)byteBuffer.readInt();
		Status = byteBuffer.readString();
		StageOrderId = (long)byteBuffer.readInt();
		AccountCode = byteBuffer.readString();
		AutoExecutionFg = AutoExecutionFg.getEnum(byteBuffer.readInt());
		AutoExecutionId = (long)byteBuffer.readInt();
		DealId = (long)byteBuffer.readInt();
		TradeId = (long)byteBuffer.readInt();
		InstrumentClassCode = byteBuffer.readString();
		TradableInstrumentCode = byteBuffer.readString();
		BuySideMemberCode = byteBuffer.readString();
		BuySideTraderName = byteBuffer.readString();
		SellSideMemberCode = byteBuffer.readString();
		SellSideTraderName = byteBuffer.readString();
		CreationDate = (long)byteBuffer.readInt();
		CreationTime = byteBuffer.readLong();
		UpdateTime = byteBuffer.readLong();
		Data = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeString(TradingSummaryId);
		byteBuffer.writeInt(TradingType.getValue());
		byteBuffer.writeInt((int)(MsgId & 0xFFFFFFFFL));
		byteBuffer.writeInt(RFCQType.getValue());
		byteBuffer.writeInt((int)(LegId & 0xFFFFL));
		byteBuffer.writeString(Status);
		byteBuffer.writeInt((int)(StageOrderId & 0xFFFFFFFFL));
		byteBuffer.writeString(AccountCode);
		byteBuffer.writeInt(AutoExecutionFg.getValue());
		byteBuffer.writeInt((int)(AutoExecutionId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(DealId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(TradeId & 0xFFFFFFFFL));
		byteBuffer.writeString(InstrumentClassCode);
		byteBuffer.writeString(TradableInstrumentCode);
		byteBuffer.writeString(BuySideMemberCode);
		byteBuffer.writeString(BuySideTraderName);
		byteBuffer.writeString(SellSideMemberCode);
		byteBuffer.writeString(SellSideTraderName);
		byteBuffer.writeInt((int)(CreationDate & 0xFFFFFFFFL));
		byteBuffer.writeLong(CreationTime);
		byteBuffer.writeLong(UpdateTime);
		byteBuffer.writeString(Data);

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
		stringBuilder.append("BV_TRADING_SUMMARY_INFO::");
		stringBuilder.append("TradingSummaryId(").append(TradingSummaryId).append(")");
		stringBuilder.append("TradingType(").append(TradingType).append(")");
		stringBuilder.append("MsgId(").append(MsgId).append(")");
		stringBuilder.append("RFCQType(").append(RFCQType).append(")");
		stringBuilder.append("LegId(").append(LegId).append(")");
		stringBuilder.append("Status(").append(Status).append(")");
		stringBuilder.append("StageOrderId(").append(StageOrderId).append(")");
		stringBuilder.append("AccountCode(").append(AccountCode).append(")");
		stringBuilder.append("AutoExecutionFg(").append(AutoExecutionFg).append(")");
		stringBuilder.append("AutoExecutionId(").append(AutoExecutionId).append(")");
		stringBuilder.append("DealId(").append(DealId).append(")");
		stringBuilder.append("TradeId(").append(TradeId).append(")");
		stringBuilder.append("InstrumentClassCode(").append(InstrumentClassCode).append(")");
		stringBuilder.append("TradableInstrumentCode(").append(TradableInstrumentCode).append(")");
		stringBuilder.append("BuySideMemberCode(").append(BuySideMemberCode).append(")");
		stringBuilder.append("BuySideTraderName(").append(BuySideTraderName).append(")");
		stringBuilder.append("SellSideMemberCode(").append(SellSideMemberCode).append(")");
		stringBuilder.append("SellSideTraderName(").append(SellSideTraderName).append(")");
		stringBuilder.append("CreationDate(").append(CreationDate).append(")");
		stringBuilder.append("CreationTime(").append(CreationTime).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		stringBuilder.append("Data(").append(Data).append(")");
		return stringBuilder.toString();
	}
}
