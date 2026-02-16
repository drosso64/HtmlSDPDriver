package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_ALLOCATION_REPORT_INFO extends SMPMessage
{
	public static final long CLASS_ID = 410004;

	private TI_MSG_INFO ReportMsgInfo = new TI_MSG_INFO();
	private BV_ALLOCATION_REPORT_MEMBER_INFO BuySideMember = new BV_ALLOCATION_REPORT_MEMBER_INFO();
	private BV_ALLOCATION_REPORT_MEMBER_INFO SellSideMember = new BV_ALLOCATION_REPORT_MEMBER_INFO();
	private long TransactionId = 0;
	private short LegId = 0;
	private TI_RFCQ_TYPE_Enum RfcqType = TI_RFCQ_TYPE_Enum.TI_RFCQ_TYPE_Outright;
	private long StageOrderId = 0;
	private String ClientOrderId = "";
	private long AllocationId = 0;
	private String ClientAllocationId = "";
	private long TradeId = 0;
	private long DealId = 0;
	private String Currency = "";
	private String MicCode = "";
	private BV_ALLOCATION_REPORT_INSTRUMENT_INFO Instrument = new BV_ALLOCATION_REPORT_INSTRUMENT_INFO();
	private TI_VERB_Enum Verb = TI_VERB_Enum.TI_VERB_Buy;
	private long SettlDate = 0;
	private BV_TRADING_INFO TradingInfo = new BV_TRADING_INFO();
	private double YTW = 0;
	private double DiscountRate = 0;
	private double DiscountMargin = 0;
	private double AveragePrice = 0;
	private double NominalValue = 0;
	private double AccruedInterest = 0;
	private double GrossTradeAmt = 0;
	private short SplitTradeListNr = 0;
	private BV_SPLIT_TRADE_INFO[] SplitTradeList = new BV_SPLIT_TRADE_INFO[100];
	private BV_TRADE_SPLIT_EVENT_Enum SplitEvent = BV_TRADE_SPLIT_EVENT_Enum.BV_TRADE_SPLIT_EVENT_PreAllocate;
	private String AllocationDescription = "";
	private long PreAllocationTime = 0;
	private long OrderTraderId = 0;
	private String OrderTraderName = "";

	public BV_ALLOCATION_REPORT_INFO()
	{
		for (int i=0; i < SplitTradeList.length; ++i)
		{
			SplitTradeList[i] = new BV_SPLIT_TRADE_INFO();
		}
	}

	public TI_MSG_INFO getReportMsgInfo()
	{
		return ReportMsgInfo;
	}
	public void setReportMsgInfo(TI_MSG_INFO value)
	{
		ReportMsgInfo = value;
	}
	public BV_ALLOCATION_REPORT_MEMBER_INFO getBuySideMember()
	{
		return BuySideMember;
	}
	public void setBuySideMember(BV_ALLOCATION_REPORT_MEMBER_INFO value)
	{
		BuySideMember = value;
	}
	public BV_ALLOCATION_REPORT_MEMBER_INFO getSellSideMember()
	{
		return SellSideMember;
	}
	public void setSellSideMember(BV_ALLOCATION_REPORT_MEMBER_INFO value)
	{
		SellSideMember = value;
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
	public long getStageOrderId()
	{
		return StageOrderId;
	}
	public void setStageOrderId(long value)
	{
		StageOrderId = value;
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
	public String getClientAllocationId()
	{
		return ClientAllocationId;
	}
	public void setClientAllocationId(String value)
	{
		ClientAllocationId = value;
	}
	public long getTradeId()
	{
		return TradeId;
	}
	public void setTradeId(long value)
	{
		TradeId = value;
	}
	public long getDealId()
	{
		return DealId;
	}
	public void setDealId(long value)
	{
		DealId = value;
	}
	public String getCurrency()
	{
		return Currency;
	}
	public void setCurrency(String value)
	{
		Currency = value;
	}
	public String getMicCode()
	{
		return MicCode;
	}
	public void setMicCode(String value)
	{
		MicCode = value;
	}
	public BV_ALLOCATION_REPORT_INSTRUMENT_INFO getInstrument()
	{
		return Instrument;
	}
	public void setInstrument(BV_ALLOCATION_REPORT_INSTRUMENT_INFO value)
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
	public long getSettlDate()
	{
		return SettlDate;
	}
	public void setSettlDate(long value)
	{
		SettlDate = value;
	}
	public BV_TRADING_INFO getTradingInfo()
	{
		return TradingInfo;
	}
	public void setTradingInfo(BV_TRADING_INFO value)
	{
		TradingInfo = value;
	}
	public double getYTW()
	{
		return YTW;
	}
	public void setYTW(double value)
	{
		YTW = value;
	}
	public double getDiscountRate()
	{
		return DiscountRate;
	}
	public void setDiscountRate(double value)
	{
		DiscountRate = value;
	}
	public double getDiscountMargin()
	{
		return DiscountMargin;
	}
	public void setDiscountMargin(double value)
	{
		DiscountMargin = value;
	}
	public double getAveragePrice()
	{
		return AveragePrice;
	}
	public void setAveragePrice(double value)
	{
		AveragePrice = value;
	}
	public double getNominalValue()
	{
		return NominalValue;
	}
	public void setNominalValue(double value)
	{
		NominalValue = value;
	}
	public double getAccruedInterest()
	{
		return AccruedInterest;
	}
	public void setAccruedInterest(double value)
	{
		AccruedInterest = value;
	}
	public double getGrossTradeAmt()
	{
		return GrossTradeAmt;
	}
	public void setGrossTradeAmt(double value)
	{
		GrossTradeAmt = value;
	}
	public short getSplitTradeListNr()
	{
		return SplitTradeListNr;
	}
	public void setSplitTradeListNr(short value)
	{
		SplitTradeListNr = value;
	}
	public BV_SPLIT_TRADE_INFO[] getSplitTradeList()
	{
		return SplitTradeList;
	}
	public void setSplitTradeList(BV_SPLIT_TRADE_INFO[] value)
	{
		SplitTradeList = value;
	}
	public BV_TRADE_SPLIT_EVENT_Enum getSplitEvent()
	{
		return SplitEvent;
	}
	public void setSplitEvent(BV_TRADE_SPLIT_EVENT_Enum value)
	{
		SplitEvent = value;
	}
	public String getAllocationDescription()
	{
		return AllocationDescription;
	}
	public void setAllocationDescription(String value)
	{
		AllocationDescription = value;
	}
	public long getPreAllocationTime()
	{
		return PreAllocationTime;
	}
	public void setPreAllocationTime(long value)
	{
		PreAllocationTime = value;
	}
	public long getOrderTraderId()
	{
		return OrderTraderId;
	}
	public void setOrderTraderId(long value)
	{
		OrderTraderId = value;
	}
	public String getOrderTraderName()
	{
		return OrderTraderName;
	}
	public void setOrderTraderName(String value)
	{
		OrderTraderName = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		ReportMsgInfo.readXDR(byteBuffer);
		BuySideMember.readXDR(byteBuffer);
		SellSideMember.readXDR(byteBuffer);
		TransactionId = (long)byteBuffer.readInt();
		LegId = (short)byteBuffer.readInt();
		RfcqType = RfcqType.getEnum(byteBuffer.readInt());
		StageOrderId = (long)byteBuffer.readInt();
		ClientOrderId = byteBuffer.readString();
		AllocationId = (long)byteBuffer.readInt();
		ClientAllocationId = byteBuffer.readString();
		TradeId = (long)byteBuffer.readInt();
		DealId = (long)byteBuffer.readInt();
		Currency = byteBuffer.readString();
		MicCode = byteBuffer.readString();
		Instrument.readXDR(byteBuffer);
		Verb = Verb.getEnum(byteBuffer.readInt());
		SettlDate = (long)byteBuffer.readInt();
		TradingInfo.readXDR(byteBuffer);
		YTW = byteBuffer.readDouble();
		DiscountRate = byteBuffer.readDouble();
		DiscountMargin = byteBuffer.readDouble();
		AveragePrice = byteBuffer.readDouble();
		NominalValue = byteBuffer.readDouble();
		AccruedInterest = byteBuffer.readDouble();
		GrossTradeAmt = byteBuffer.readDouble();
		SplitTradeListNr = (short)byteBuffer.readInt();
		for (int i=0; i < SplitTradeList.length; ++i)
		{
			SplitTradeList[i].readXDR(byteBuffer);
		}
		SplitEvent = SplitEvent.getEnum(byteBuffer.readInt());
		AllocationDescription = byteBuffer.readString();
		PreAllocationTime = byteBuffer.readLong();
		OrderTraderId = (long)byteBuffer.readInt();
		OrderTraderName = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		ReportMsgInfo.writeXDR(byteBuffer);
		BuySideMember.writeXDR(byteBuffer);
		SellSideMember.writeXDR(byteBuffer);
		byteBuffer.writeInt((int)(TransactionId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(LegId & 0xFFFFL));
		byteBuffer.writeInt(RfcqType.getValue());
		byteBuffer.writeInt((int)(StageOrderId & 0xFFFFFFFFL));
		byteBuffer.writeString(ClientOrderId);
		byteBuffer.writeInt((int)(AllocationId & 0xFFFFFFFFL));
		byteBuffer.writeString(ClientAllocationId);
		byteBuffer.writeInt((int)(TradeId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(DealId & 0xFFFFFFFFL));
		byteBuffer.writeString(Currency);
		byteBuffer.writeString(MicCode);
		Instrument.writeXDR(byteBuffer);
		byteBuffer.writeInt(Verb.getValue());
		byteBuffer.writeInt((int)(SettlDate & 0xFFFFFFFFL));
		TradingInfo.writeXDR(byteBuffer);
		byteBuffer.writeDouble(YTW);
		byteBuffer.writeDouble(DiscountRate);
		byteBuffer.writeDouble(DiscountMargin);
		byteBuffer.writeDouble(AveragePrice);
		byteBuffer.writeDouble(NominalValue);
		byteBuffer.writeDouble(AccruedInterest);
		byteBuffer.writeDouble(GrossTradeAmt);
		byteBuffer.writeInt((int)(SplitTradeListNr & 0xFFFFL));
		for (int i=0; i < SplitTradeList.length; ++i)
		{
			SplitTradeList[i].writeXDR(byteBuffer);
		}
		byteBuffer.writeInt(SplitEvent.getValue());
		byteBuffer.writeString(AllocationDescription);
		byteBuffer.writeLong(PreAllocationTime);
		byteBuffer.writeInt((int)(OrderTraderId & 0xFFFFFFFFL));
		byteBuffer.writeString(OrderTraderName);

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
		stringBuilder.append("BV_ALLOCATION_REPORT_INFO::");
		stringBuilder.append("ReportMsgInfo(").append(ReportMsgInfo.toString()).append(")");
		stringBuilder.append("BuySideMember(").append(BuySideMember.toString()).append(")");
		stringBuilder.append("SellSideMember(").append(SellSideMember.toString()).append(")");
		stringBuilder.append("TransactionId(").append(TransactionId).append(")");
		stringBuilder.append("LegId(").append(LegId).append(")");
		stringBuilder.append("RfcqType(").append(RfcqType).append(")");
		stringBuilder.append("StageOrderId(").append(StageOrderId).append(")");
		stringBuilder.append("ClientOrderId(").append(ClientOrderId).append(")");
		stringBuilder.append("AllocationId(").append(AllocationId).append(")");
		stringBuilder.append("ClientAllocationId(").append(ClientAllocationId).append(")");
		stringBuilder.append("TradeId(").append(TradeId).append(")");
		stringBuilder.append("DealId(").append(DealId).append(")");
		stringBuilder.append("Currency(").append(Currency).append(")");
		stringBuilder.append("MicCode(").append(MicCode).append(")");
		stringBuilder.append("Instrument(").append(Instrument.toString()).append(")");
		stringBuilder.append("Verb(").append(Verb).append(")");
		stringBuilder.append("SettlDate(").append(SettlDate).append(")");
		stringBuilder.append("TradingInfo(").append(TradingInfo.toString()).append(")");
		stringBuilder.append("YTW(").append(YTW).append(")");
		stringBuilder.append("DiscountRate(").append(DiscountRate).append(")");
		stringBuilder.append("DiscountMargin(").append(DiscountMargin).append(")");
		stringBuilder.append("AveragePrice(").append(AveragePrice).append(")");
		stringBuilder.append("NominalValue(").append(NominalValue).append(")");
		stringBuilder.append("AccruedInterest(").append(AccruedInterest).append(")");
		stringBuilder.append("GrossTradeAmt(").append(GrossTradeAmt).append(")");
		stringBuilder.append("SplitTradeListNr(").append(SplitTradeListNr).append(")");
		for (int i=0; i < SplitTradeList.length; ++i)
		{
			stringBuilder.append("SplitTradeList[").append(i).append("](").append(SplitTradeList[i].toString()).append(")");
		}
		stringBuilder.append("SplitEvent(").append(SplitEvent).append(")");
		stringBuilder.append("AllocationDescription(").append(AllocationDescription).append(")");
		stringBuilder.append("PreAllocationTime(").append(PreAllocationTime).append(")");
		stringBuilder.append("OrderTraderId(").append(OrderTraderId).append(")");
		stringBuilder.append("OrderTraderName(").append(OrderTraderName).append(")");
		return stringBuilder.toString();
	}
}
