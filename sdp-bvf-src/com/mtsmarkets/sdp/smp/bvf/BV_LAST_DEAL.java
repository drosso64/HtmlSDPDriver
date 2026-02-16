package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_LAST_DEAL extends SMPMessage
{
	public static final long CLASS_ID = 114113;

	private long DealMsgId = 0;
	private BV_INSTRUMENT_INFO Instrument = new BV_INSTRUMENT_INFO();
	private long SectionId = 0;
	private BV_TRADING_INFO LastTradingInfo = new BV_TRADING_INFO();
	private TI_EXEC_TREND_Enum Trend = TI_EXEC_TREND_Enum.TI_EXEC_TREND_Equal;
	private TI_LAST_DEAL_VERB_Enum Verb = TI_LAST_DEAL_VERB_Enum.TI_LAST_DEAL_VERB_Buy;
	private long DealTime = 0;
	private TI_TRADE_TYPE_Enum TradeType = TI_TRADE_TYPE_Enum.TI_TRADE_TYPE_Normal;
	private short MarketAffiliation = 0;
	private BV_DEAL_STATUS_Enum Status = BV_DEAL_STATUS_Enum.BV_DEAL_STATUS_Active;
	private String MicCode = "";
	private BV_WAIVER_INDICATOR_Enum WaiverIndicator = BV_WAIVER_INDICATOR_Enum.BV_WAIVER_INDICATOR_None;
	private long TransactionId = 0;
	private short LegId = 0;
	private TI_RFCQ_TYPE_Enum RfcqType = TI_RFCQ_TYPE_Enum.TI_RFCQ_TYPE_Outright;

	public BV_LAST_DEAL()
	{
	}

	public long getDealMsgId()
	{
		return DealMsgId;
	}
	public void setDealMsgId(long value)
	{
		DealMsgId = value;
	}
	public BV_INSTRUMENT_INFO getInstrument()
	{
		return Instrument;
	}
	public void setInstrument(BV_INSTRUMENT_INFO value)
	{
		Instrument = value;
	}
	public long getSectionId()
	{
		return SectionId;
	}
	public void setSectionId(long value)
	{
		SectionId = value;
	}
	public BV_TRADING_INFO getLastTradingInfo()
	{
		return LastTradingInfo;
	}
	public void setLastTradingInfo(BV_TRADING_INFO value)
	{
		LastTradingInfo = value;
	}
	public TI_EXEC_TREND_Enum getTrend()
	{
		return Trend;
	}
	public void setTrend(TI_EXEC_TREND_Enum value)
	{
		Trend = value;
	}
	public TI_LAST_DEAL_VERB_Enum getVerb()
	{
		return Verb;
	}
	public void setVerb(TI_LAST_DEAL_VERB_Enum value)
	{
		Verb = value;
	}
	public long getDealTime()
	{
		return DealTime;
	}
	public void setDealTime(long value)
	{
		DealTime = value;
	}
	public TI_TRADE_TYPE_Enum getTradeType()
	{
		return TradeType;
	}
	public void setTradeType(TI_TRADE_TYPE_Enum value)
	{
		TradeType = value;
	}
	public short getMarketAffiliation()
	{
		return MarketAffiliation;
	}
	public void setMarketAffiliation(short value)
	{
		MarketAffiliation = value;
	}
	public BV_DEAL_STATUS_Enum getStatus()
	{
		return Status;
	}
	public void setStatus(BV_DEAL_STATUS_Enum value)
	{
		Status = value;
	}
	public String getMicCode()
	{
		return MicCode;
	}
	public void setMicCode(String value)
	{
		MicCode = value;
	}
	public BV_WAIVER_INDICATOR_Enum getWaiverIndicator()
	{
		return WaiverIndicator;
	}
	public void setWaiverIndicator(BV_WAIVER_INDICATOR_Enum value)
	{
		WaiverIndicator = value;
	}
	public long getTransactionId()
	{
		return TransactionId;
	}
	public void setTransactionId(long value)
	{
		TransactionId = value;
	}
	public short getLegId()
	{
		return LegId;
	}
	public void setLegId(short value)
	{
		LegId = value;
	}
	public TI_RFCQ_TYPE_Enum getRfcqType()
	{
		return RfcqType;
	}
	public void setRfcqType(TI_RFCQ_TYPE_Enum value)
	{
		RfcqType = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		DealMsgId = (long)byteBuffer.readInt();
		Instrument.readXDR(byteBuffer);
		SectionId = (long)byteBuffer.readInt();
		LastTradingInfo.readXDR(byteBuffer);
		Trend = Trend.getEnum(byteBuffer.readInt());
		Verb = Verb.getEnum(byteBuffer.readInt());
		DealTime = byteBuffer.readLong();
		TradeType = TradeType.getEnum(byteBuffer.readInt());
		MarketAffiliation = (short)byteBuffer.readInt();
		Status = Status.getEnum(byteBuffer.readInt());
		MicCode = byteBuffer.readString();
		WaiverIndicator = WaiverIndicator.getEnum(byteBuffer.readInt());
		TransactionId = (long)byteBuffer.readInt();
		LegId = (short)byteBuffer.readInt();
		RfcqType = RfcqType.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(DealMsgId & 0xFFFFFFFFL));
		Instrument.writeXDR(byteBuffer);
		byteBuffer.writeInt((int)(SectionId & 0xFFFFFFFFL));
		LastTradingInfo.writeXDR(byteBuffer);
		byteBuffer.writeInt(Trend.getValue());
		byteBuffer.writeInt(Verb.getValue());
		byteBuffer.writeLong(DealTime);
		byteBuffer.writeInt(TradeType.getValue());
		byteBuffer.writeInt((int)(MarketAffiliation & 0xFFFFL));
		byteBuffer.writeInt(Status.getValue());
		byteBuffer.writeString(MicCode);
		byteBuffer.writeInt(WaiverIndicator.getValue());
		byteBuffer.writeInt((int)(TransactionId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(LegId & 0xFFFFL));
		byteBuffer.writeInt(RfcqType.getValue());

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
		stringBuilder.append("BV_LAST_DEAL::");
		stringBuilder.append("DealMsgId(").append(DealMsgId).append(")");
		stringBuilder.append("Instrument(").append(Instrument.toString()).append(")");
		stringBuilder.append("SectionId(").append(SectionId).append(")");
		stringBuilder.append("LastTradingInfo(").append(LastTradingInfo.toString()).append(")");
		stringBuilder.append("Trend(").append(Trend).append(")");
		stringBuilder.append("Verb(").append(Verb).append(")");
		stringBuilder.append("DealTime(").append(DealTime).append(")");
		stringBuilder.append("TradeType(").append(TradeType).append(")");
		stringBuilder.append("MarketAffiliation(").append(MarketAffiliation).append(")");
		stringBuilder.append("Status(").append(Status).append(")");
		stringBuilder.append("MicCode(").append(MicCode).append(")");
		stringBuilder.append("WaiverIndicator(").append(WaiverIndicator).append(")");
		stringBuilder.append("TransactionId(").append(TransactionId).append(")");
		stringBuilder.append("LegId(").append(LegId).append(")");
		stringBuilder.append("RfcqType(").append(RfcqType).append(")");
		return stringBuilder.toString();
	}
}
