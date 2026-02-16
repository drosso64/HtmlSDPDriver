package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_RFCQ_BUY_SIDE_SUMMARY extends SMPMessage
{
	public static final long CLASS_ID = 114280;

	private long BuySideMemberId = 0;
	private long BuySideTraderId = 0;
	private TI_MSG_INFO RfcqReqMsgInfo = new TI_MSG_INFO();
	private TI_RFCQ_TYPE_Enum RfcqType = TI_RFCQ_TYPE_Enum.TI_RFCQ_TYPE_Outright;
	private TI_RFCQ_ORIGIN_Enum RfcqOrigin = TI_RFCQ_ORIGIN_Enum.TI_RFCQ_ORIGIN_FromScratch;
	private TI_FLAG_Enum PreAgreedFg = TI_FLAG_Enum.TI_FLAG_No;
	private TI_FLAG_Enum PreTradeFg = TI_FLAG_Enum.TI_FLAG_No;
	private long VoiceListId = 0;
	private long OriginSellSideMemberId = 0;
	private short DueInTime = 0;
	private long DueInTimeout = 0;
	private TI_RFCQ_QUANTITY_CALCULATION_Enum QuantityCalculation = TI_RFCQ_QUANTITY_CALCULATION_Enum.TI_RFCQ_QUANTITY_CALCULATION_UserInput;
	private long TradingListId = 0;
	private short LegId = 0;
	private short IOIMatchingQuotes = 0;
	private TI_FLAG_Enum MsgFg = TI_FLAG_Enum.TI_FLAG_No;
	private long SellSideMemberId = 0;
	private String SellSideTraderName = "";
	private TI_RFCQ_REQUEST_STATUS_Enum FinalStatus = TI_RFCQ_REQUEST_STATUS_Enum.TI_RFCQ_REQUEST_STATUS_Processing;
	private long ClosingTime = 0;
	private short SellSideNr = 0;
	private short ParticipatingSellSideNr = 0;
	private String ClientRfcqId = "";
	private long Delay = 0;
	private long BookTimestamp = 0;
	private double PriceCoverValue = 0;
	private double ProceedsCoverValue = 0;
	private double GrossYieldCoverValue = 0;
	private double DurWeightedYieldCoverValue = 0;
	private double GrossYieldSpread = 0;
	private double ProceedsSpread = 0;
	private double RiskWeightedYieldSpread = 0;
	private TI_FLAG_Enum LimitSpreadFg = TI_FLAG_Enum.TI_FLAG_No;
	private double LimitSpread = 0;
	private short NumOfLegs = 0;
	private BV_RFCQ_BUY_SIDE_LEG_SUMMARY[] LegSummary = new BV_RFCQ_BUY_SIDE_LEG_SUMMARY[3];
	private BV_RFCQ_PROVIDER_INFO[] ProviderInfo = new BV_RFCQ_PROVIDER_INFO[20];
	private BV_INVENTORY_TRADING_INFO[] InventoryDepthBid = new BV_INVENTORY_TRADING_INFO[30];
	private BV_INVENTORY_TRADING_INFO[] InventoryDepthAsk = new BV_INVENTORY_TRADING_INFO[30];
	private BV_IOI_TRADING_INFO[] IOIDepthBid = new BV_IOI_TRADING_INFO[30];
	private BV_IOI_TRADING_INFO[] IOIDepthAsk = new BV_IOI_TRADING_INFO[30];
	private short AreaCodeId = 0;
	private String Comment = "";
	private String UserInfo1 = "";
	private String UserInfo2 = "";
	private TI_FLAG_Enum AutoExecutionFg = TI_FLAG_Enum.TI_FLAG_No;
	private long AutoExecutionRuleId = 0;
	private long ManualOverrideStartTime = 0;
	private long ManualOverrideEndTime = 0;

	public BV_RFCQ_BUY_SIDE_SUMMARY()
	{
		for (int i=0; i < LegSummary.length; ++i)
		{
			LegSummary[i] = new BV_RFCQ_BUY_SIDE_LEG_SUMMARY();
		}
		for (int i=0; i < ProviderInfo.length; ++i)
		{
			ProviderInfo[i] = new BV_RFCQ_PROVIDER_INFO();
		}
		for (int i=0; i < InventoryDepthBid.length; ++i)
		{
			InventoryDepthBid[i] = new BV_INVENTORY_TRADING_INFO();
		}
		for (int i=0; i < InventoryDepthAsk.length; ++i)
		{
			InventoryDepthAsk[i] = new BV_INVENTORY_TRADING_INFO();
		}
		for (int i=0; i < IOIDepthBid.length; ++i)
		{
			IOIDepthBid[i] = new BV_IOI_TRADING_INFO();
		}
		for (int i=0; i < IOIDepthAsk.length; ++i)
		{
			IOIDepthAsk[i] = new BV_IOI_TRADING_INFO();
		}
	}

	public long getBuySideMemberId()
	{
		return BuySideMemberId;
	}
	public void setBuySideMemberId(long value)
	{
		BuySideMemberId = value;
	}
	public long getBuySideTraderId()
	{
		return BuySideTraderId;
	}
	public void setBuySideTraderId(long value)
	{
		BuySideTraderId = value;
	}
	public TI_MSG_INFO getRfcqReqMsgInfo()
	{
		return RfcqReqMsgInfo;
	}
	public void setRfcqReqMsgInfo(TI_MSG_INFO value)
	{
		RfcqReqMsgInfo = value;
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
	public TI_FLAG_Enum getPreTradeFg()
	{
		return PreTradeFg;
	}
	public void setPreTradeFg(TI_FLAG_Enum value)
	{
		PreTradeFg = value;
	}
	public long getVoiceListId()
	{
		return VoiceListId;
	}
	public void setVoiceListId(long value)
	{
		VoiceListId = value;
	}
	public long getOriginSellSideMemberId()
	{
		return OriginSellSideMemberId;
	}
	public void setOriginSellSideMemberId(long value)
	{
		OriginSellSideMemberId = value;
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
	public TI_RFCQ_QUANTITY_CALCULATION_Enum getQuantityCalculation()
	{
		return QuantityCalculation;
	}
	public void setQuantityCalculation(TI_RFCQ_QUANTITY_CALCULATION_Enum value)
	{
		QuantityCalculation = value;
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
	public short getIOIMatchingQuotes()
	{
		return IOIMatchingQuotes;
	}
	public void setIOIMatchingQuotes(short value)
	{
		IOIMatchingQuotes = value;
	}
	public TI_FLAG_Enum getMsgFg()
	{
		return MsgFg;
	}
	public void setMsgFg(TI_FLAG_Enum value)
	{
		MsgFg = value;
	}
	public long getSellSideMemberId()
	{
		return SellSideMemberId;
	}
	public void setSellSideMemberId(long value)
	{
		SellSideMemberId = value;
	}
	public String getSellSideTraderName()
	{
		return SellSideTraderName;
	}
	public void setSellSideTraderName(String value)
	{
		SellSideTraderName = value;
	}
	public TI_RFCQ_REQUEST_STATUS_Enum getFinalStatus()
	{
		return FinalStatus;
	}
	public void setFinalStatus(TI_RFCQ_REQUEST_STATUS_Enum value)
	{
		FinalStatus = value;
	}
	public long getClosingTime()
	{
		return ClosingTime;
	}
	public void setClosingTime(long value)
	{
		ClosingTime = value;
	}
	public short getSellSideNr()
	{
		return SellSideNr;
	}
	public void setSellSideNr(short value)
	{
		SellSideNr = value;
	}
	public short getParticipatingSellSideNr()
	{
		return ParticipatingSellSideNr;
	}
	public void setParticipatingSellSideNr(short value)
	{
		ParticipatingSellSideNr = value;
	}
	public String getClientRfcqId()
	{
		return ClientRfcqId;
	}
	public void setClientRfcqId(String value)
	{
		ClientRfcqId = value;
	}
	public long getDelay()
	{
		return Delay;
	}
	public void setDelay(long value)
	{
		Delay = value;
	}
	public long getBookTimestamp()
	{
		return BookTimestamp;
	}
	public void setBookTimestamp(long value)
	{
		BookTimestamp = value;
	}
	public double getPriceCoverValue()
	{
		return PriceCoverValue;
	}
	public void setPriceCoverValue(double value)
	{
		PriceCoverValue = value;
	}
	public double getProceedsCoverValue()
	{
		return ProceedsCoverValue;
	}
	public void setProceedsCoverValue(double value)
	{
		ProceedsCoverValue = value;
	}
	public double getGrossYieldCoverValue()
	{
		return GrossYieldCoverValue;
	}
	public void setGrossYieldCoverValue(double value)
	{
		GrossYieldCoverValue = value;
	}
	public double getDurWeightedYieldCoverValue()
	{
		return DurWeightedYieldCoverValue;
	}
	public void setDurWeightedYieldCoverValue(double value)
	{
		DurWeightedYieldCoverValue = value;
	}
	public double getGrossYieldSpread()
	{
		return GrossYieldSpread;
	}
	public void setGrossYieldSpread(double value)
	{
		GrossYieldSpread = value;
	}
	public double getProceedsSpread()
	{
		return ProceedsSpread;
	}
	public void setProceedsSpread(double value)
	{
		ProceedsSpread = value;
	}
	public double getRiskWeightedYieldSpread()
	{
		return RiskWeightedYieldSpread;
	}
	public void setRiskWeightedYieldSpread(double value)
	{
		RiskWeightedYieldSpread = value;
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
	public short getNumOfLegs()
	{
		return NumOfLegs;
	}
	public void setNumOfLegs(short value)
	{
		NumOfLegs = value;
	}
	public BV_RFCQ_BUY_SIDE_LEG_SUMMARY[] getLegSummary()
	{
		return LegSummary;
	}
	public void setLegSummary(BV_RFCQ_BUY_SIDE_LEG_SUMMARY[] value)
	{
		LegSummary = value;
	}
	public BV_RFCQ_PROVIDER_INFO[] getProviderInfo()
	{
		return ProviderInfo;
	}
	public void setProviderInfo(BV_RFCQ_PROVIDER_INFO[] value)
	{
		ProviderInfo = value;
	}
	public BV_INVENTORY_TRADING_INFO[] getInventoryDepthBid()
	{
		return InventoryDepthBid;
	}
	public void setInventoryDepthBid(BV_INVENTORY_TRADING_INFO[] value)
	{
		InventoryDepthBid = value;
	}
	public BV_INVENTORY_TRADING_INFO[] getInventoryDepthAsk()
	{
		return InventoryDepthAsk;
	}
	public void setInventoryDepthAsk(BV_INVENTORY_TRADING_INFO[] value)
	{
		InventoryDepthAsk = value;
	}
	public BV_IOI_TRADING_INFO[] getIOIDepthBid()
	{
		return IOIDepthBid;
	}
	public void setIOIDepthBid(BV_IOI_TRADING_INFO[] value)
	{
		IOIDepthBid = value;
	}
	public BV_IOI_TRADING_INFO[] getIOIDepthAsk()
	{
		return IOIDepthAsk;
	}
	public void setIOIDepthAsk(BV_IOI_TRADING_INFO[] value)
	{
		IOIDepthAsk = value;
	}
	public short getAreaCodeId()
	{
		return AreaCodeId;
	}
	public void setAreaCodeId(short value)
	{
		AreaCodeId = value;
	}
	public String getComment()
	{
		return Comment;
	}
	public void setComment(String value)
	{
		Comment = value;
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

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		BuySideMemberId = (long)byteBuffer.readInt();
		BuySideTraderId = (long)byteBuffer.readInt();
		RfcqReqMsgInfo.readXDR(byteBuffer);
		RfcqType = RfcqType.getEnum(byteBuffer.readInt());
		RfcqOrigin = RfcqOrigin.getEnum(byteBuffer.readInt());
		PreAgreedFg = PreAgreedFg.getEnum(byteBuffer.readInt());
		PreTradeFg = PreTradeFg.getEnum(byteBuffer.readInt());
		VoiceListId = (long)byteBuffer.readInt();
		OriginSellSideMemberId = (long)byteBuffer.readInt();
		DueInTime = (short)byteBuffer.readInt();
		DueInTimeout = byteBuffer.readLong();
		QuantityCalculation = QuantityCalculation.getEnum(byteBuffer.readInt());
		TradingListId = (long)byteBuffer.readInt();
		LegId = (short)byteBuffer.readInt();
		IOIMatchingQuotes = (short)byteBuffer.readInt();
		MsgFg = MsgFg.getEnum(byteBuffer.readInt());
		SellSideMemberId = (long)byteBuffer.readInt();
		SellSideTraderName = byteBuffer.readString();
		FinalStatus = FinalStatus.getEnum(byteBuffer.readInt());
		ClosingTime = byteBuffer.readLong();
		SellSideNr = (short)byteBuffer.readInt();
		ParticipatingSellSideNr = (short)byteBuffer.readInt();
		ClientRfcqId = byteBuffer.readString();
		Delay = (long)byteBuffer.readInt();
		BookTimestamp = byteBuffer.readLong();
		PriceCoverValue = byteBuffer.readDouble();
		ProceedsCoverValue = byteBuffer.readDouble();
		GrossYieldCoverValue = byteBuffer.readDouble();
		DurWeightedYieldCoverValue = byteBuffer.readDouble();
		GrossYieldSpread = byteBuffer.readDouble();
		ProceedsSpread = byteBuffer.readDouble();
		RiskWeightedYieldSpread = byteBuffer.readDouble();
		LimitSpreadFg = LimitSpreadFg.getEnum(byteBuffer.readInt());
		LimitSpread = byteBuffer.readDouble();
		NumOfLegs = (short)byteBuffer.readInt();
		for (int i=0; i < LegSummary.length; ++i)
		{
			LegSummary[i].readXDR(byteBuffer);
		}
		for (int i=0; i < ProviderInfo.length; ++i)
		{
			ProviderInfo[i].readXDR(byteBuffer);
		}
		for (int i=0; i < InventoryDepthBid.length; ++i)
		{
			InventoryDepthBid[i].readXDR(byteBuffer);
		}
		for (int i=0; i < InventoryDepthAsk.length; ++i)
		{
			InventoryDepthAsk[i].readXDR(byteBuffer);
		}
		for (int i=0; i < IOIDepthBid.length; ++i)
		{
			IOIDepthBid[i].readXDR(byteBuffer);
		}
		for (int i=0; i < IOIDepthAsk.length; ++i)
		{
			IOIDepthAsk[i].readXDR(byteBuffer);
		}
		AreaCodeId = (short)byteBuffer.readInt();
		Comment = byteBuffer.readString();
		UserInfo1 = byteBuffer.readString();
		UserInfo2 = byteBuffer.readString();
		AutoExecutionFg = AutoExecutionFg.getEnum(byteBuffer.readInt());
		AutoExecutionRuleId = (long)byteBuffer.readInt();
		ManualOverrideStartTime = byteBuffer.readLong();
		ManualOverrideEndTime = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(BuySideMemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(BuySideTraderId & 0xFFFFFFFFL));
		RfcqReqMsgInfo.writeXDR(byteBuffer);
		byteBuffer.writeInt(RfcqType.getValue());
		byteBuffer.writeInt(RfcqOrigin.getValue());
		byteBuffer.writeInt(PreAgreedFg.getValue());
		byteBuffer.writeInt(PreTradeFg.getValue());
		byteBuffer.writeInt((int)(VoiceListId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(OriginSellSideMemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(DueInTime & 0xFFFFL));
		byteBuffer.writeLong(DueInTimeout);
		byteBuffer.writeInt(QuantityCalculation.getValue());
		byteBuffer.writeInt((int)(TradingListId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(LegId & 0xFFFFL));
		byteBuffer.writeInt((int)(IOIMatchingQuotes & 0xFFFFL));
		byteBuffer.writeInt(MsgFg.getValue());
		byteBuffer.writeInt((int)(SellSideMemberId & 0xFFFFFFFFL));
		byteBuffer.writeString(SellSideTraderName);
		byteBuffer.writeInt(FinalStatus.getValue());
		byteBuffer.writeLong(ClosingTime);
		byteBuffer.writeInt((int)(SellSideNr & 0xFFFFL));
		byteBuffer.writeInt((int)(ParticipatingSellSideNr & 0xFFFFL));
		byteBuffer.writeString(ClientRfcqId);
		byteBuffer.writeInt((int)(Delay & 0xFFFFFFFFL));
		byteBuffer.writeLong(BookTimestamp);
		byteBuffer.writeDouble(PriceCoverValue);
		byteBuffer.writeDouble(ProceedsCoverValue);
		byteBuffer.writeDouble(GrossYieldCoverValue);
		byteBuffer.writeDouble(DurWeightedYieldCoverValue);
		byteBuffer.writeDouble(GrossYieldSpread);
		byteBuffer.writeDouble(ProceedsSpread);
		byteBuffer.writeDouble(RiskWeightedYieldSpread);
		byteBuffer.writeInt(LimitSpreadFg.getValue());
		byteBuffer.writeDouble(LimitSpread);
		byteBuffer.writeInt((int)(NumOfLegs & 0xFFFFL));
		for (int i=0; i < LegSummary.length; ++i)
		{
			LegSummary[i].writeXDR(byteBuffer);
		}
		for (int i=0; i < ProviderInfo.length; ++i)
		{
			ProviderInfo[i].writeXDR(byteBuffer);
		}
		for (int i=0; i < InventoryDepthBid.length; ++i)
		{
			InventoryDepthBid[i].writeXDR(byteBuffer);
		}
		for (int i=0; i < InventoryDepthAsk.length; ++i)
		{
			InventoryDepthAsk[i].writeXDR(byteBuffer);
		}
		for (int i=0; i < IOIDepthBid.length; ++i)
		{
			IOIDepthBid[i].writeXDR(byteBuffer);
		}
		for (int i=0; i < IOIDepthAsk.length; ++i)
		{
			IOIDepthAsk[i].writeXDR(byteBuffer);
		}
		byteBuffer.writeInt((int)(AreaCodeId & 0xFFFFL));
		byteBuffer.writeString(Comment);
		byteBuffer.writeString(UserInfo1);
		byteBuffer.writeString(UserInfo2);
		byteBuffer.writeInt(AutoExecutionFg.getValue());
		byteBuffer.writeInt((int)(AutoExecutionRuleId & 0xFFFFFFFFL));
		byteBuffer.writeLong(ManualOverrideStartTime);
		byteBuffer.writeLong(ManualOverrideEndTime);

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
		stringBuilder.append("BV_RFCQ_BUY_SIDE_SUMMARY::");
		stringBuilder.append("BuySideMemberId(").append(BuySideMemberId).append(")");
		stringBuilder.append("BuySideTraderId(").append(BuySideTraderId).append(")");
		stringBuilder.append("RfcqReqMsgInfo(").append(RfcqReqMsgInfo.toString()).append(")");
		stringBuilder.append("RfcqType(").append(RfcqType).append(")");
		stringBuilder.append("RfcqOrigin(").append(RfcqOrigin).append(")");
		stringBuilder.append("PreAgreedFg(").append(PreAgreedFg).append(")");
		stringBuilder.append("PreTradeFg(").append(PreTradeFg).append(")");
		stringBuilder.append("VoiceListId(").append(VoiceListId).append(")");
		stringBuilder.append("OriginSellSideMemberId(").append(OriginSellSideMemberId).append(")");
		stringBuilder.append("DueInTime(").append(DueInTime).append(")");
		stringBuilder.append("DueInTimeout(").append(DueInTimeout).append(")");
		stringBuilder.append("QuantityCalculation(").append(QuantityCalculation).append(")");
		stringBuilder.append("TradingListId(").append(TradingListId).append(")");
		stringBuilder.append("LegId(").append(LegId).append(")");
		stringBuilder.append("IOIMatchingQuotes(").append(IOIMatchingQuotes).append(")");
		stringBuilder.append("MsgFg(").append(MsgFg).append(")");
		stringBuilder.append("SellSideMemberId(").append(SellSideMemberId).append(")");
		stringBuilder.append("SellSideTraderName(").append(SellSideTraderName).append(")");
		stringBuilder.append("FinalStatus(").append(FinalStatus).append(")");
		stringBuilder.append("ClosingTime(").append(ClosingTime).append(")");
		stringBuilder.append("SellSideNr(").append(SellSideNr).append(")");
		stringBuilder.append("ParticipatingSellSideNr(").append(ParticipatingSellSideNr).append(")");
		stringBuilder.append("ClientRfcqId(").append(ClientRfcqId).append(")");
		stringBuilder.append("Delay(").append(Delay).append(")");
		stringBuilder.append("BookTimestamp(").append(BookTimestamp).append(")");
		stringBuilder.append("PriceCoverValue(").append(PriceCoverValue).append(")");
		stringBuilder.append("ProceedsCoverValue(").append(ProceedsCoverValue).append(")");
		stringBuilder.append("GrossYieldCoverValue(").append(GrossYieldCoverValue).append(")");
		stringBuilder.append("DurWeightedYieldCoverValue(").append(DurWeightedYieldCoverValue).append(")");
		stringBuilder.append("GrossYieldSpread(").append(GrossYieldSpread).append(")");
		stringBuilder.append("ProceedsSpread(").append(ProceedsSpread).append(")");
		stringBuilder.append("RiskWeightedYieldSpread(").append(RiskWeightedYieldSpread).append(")");
		stringBuilder.append("LimitSpreadFg(").append(LimitSpreadFg).append(")");
		stringBuilder.append("LimitSpread(").append(LimitSpread).append(")");
		stringBuilder.append("NumOfLegs(").append(NumOfLegs).append(")");
		for (int i=0; i < LegSummary.length; ++i)
		{
			stringBuilder.append("LegSummary[").append(i).append("](").append(LegSummary[i].toString()).append(")");
		}
		for (int i=0; i < ProviderInfo.length; ++i)
		{
			stringBuilder.append("ProviderInfo[").append(i).append("](").append(ProviderInfo[i].toString()).append(")");
		}
		for (int i=0; i < InventoryDepthBid.length; ++i)
		{
			stringBuilder.append("InventoryDepthBid[").append(i).append("](").append(InventoryDepthBid[i].toString()).append(")");
		}
		for (int i=0; i < InventoryDepthAsk.length; ++i)
		{
			stringBuilder.append("InventoryDepthAsk[").append(i).append("](").append(InventoryDepthAsk[i].toString()).append(")");
		}
		for (int i=0; i < IOIDepthBid.length; ++i)
		{
			stringBuilder.append("IOIDepthBid[").append(i).append("](").append(IOIDepthBid[i].toString()).append(")");
		}
		for (int i=0; i < IOIDepthAsk.length; ++i)
		{
			stringBuilder.append("IOIDepthAsk[").append(i).append("](").append(IOIDepthAsk[i].toString()).append(")");
		}
		stringBuilder.append("AreaCodeId(").append(AreaCodeId).append(")");
		stringBuilder.append("Comment(").append(Comment).append(")");
		stringBuilder.append("UserInfo1(").append(UserInfo1).append(")");
		stringBuilder.append("UserInfo2(").append(UserInfo2).append(")");
		stringBuilder.append("AutoExecutionFg(").append(AutoExecutionFg).append(")");
		stringBuilder.append("AutoExecutionRuleId(").append(AutoExecutionRuleId).append(")");
		stringBuilder.append("ManualOverrideStartTime(").append(ManualOverrideStartTime).append(")");
		stringBuilder.append("ManualOverrideEndTime(").append(ManualOverrideEndTime).append(")");
		return stringBuilder.toString();
	}
}
