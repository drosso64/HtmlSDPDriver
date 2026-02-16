package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_HIST_RFCQ_SELL_SIDE_SUMMARY_INFO extends SMPMessage
{
	public static final long CLASS_ID = 114956;

	private String SellSideMemberCode = "";
	private String SellSideTraderName = "";
	private long RfcqReqId = 0;
	private long CreationDate = 0;
	private long CreationTime = 0;
	private TI_RFCQ_TYPE_Enum RfcqType = TI_RFCQ_TYPE_Enum.TI_RFCQ_TYPE_Outright;
	private TI_RFCQ_ORIGIN_Enum RfcqOrigin = TI_RFCQ_ORIGIN_Enum.TI_RFCQ_ORIGIN_FromScratch;
	private BV_ALGO_INFO AlgoInfo = new BV_ALGO_INFO();
	private BV_CLIENT_IDENTIFICATION_INFO ClientIdentificationInfo = new BV_CLIENT_IDENTIFICATION_INFO();
	private TI_FLAG_Enum PreAgreedFg = TI_FLAG_Enum.TI_FLAG_No;
	private TI_FLAG_Enum PreTradeFg = TI_FLAG_Enum.TI_FLAG_No;
	private short DueInTime = 0;
	private long DueInTimeout = 0;
	private TI_RFCQ_QUANTITY_CALCULATION_Enum QuantityCalculation = TI_RFCQ_QUANTITY_CALCULATION_Enum.TI_RFCQ_QUANTITY_CALCULATION_UserInput;
	private long TradingListId = 0;
	private short LegId = 0;
	private TI_FLAG_Enum MsgFg = TI_FLAG_Enum.TI_FLAG_No;
	private String BuySideMemberCode = "";
	private String BuySideMemberDesc = "";
	private String BuySideMemberShortDesc = "";
	private String BuySideTraderName = "";
	private BV_RFCQ_DEALER_SELECTION_TYPE_Enum DealerSelectionType = BV_RFCQ_DEALER_SELECTION_TYPE_Enum.BV_RFCQ_DEALER_SELECTION_Manual;
	private TI_RFCQ_REQUEST_STATUS_Enum FinalStatus = TI_RFCQ_REQUEST_STATUS_Enum.TI_RFCQ_REQUEST_STATUS_Processing;
	private TI_RFCQ_PROVIDER_STATUS_Enum ProviderStatus = TI_RFCQ_PROVIDER_STATUS_Enum.TI_RFCQ_PROVIDER_STATUS_Processing;
	private long ClosingTime = 0;
	private short SellSideNr = 0;
	private short ParticipatingSellSideNr = 0;
	private long Delay = 0;
	private int ResponseTimeDifference = 0;
	private BV_RFCQ_COVER_INFO PriceCoverInfo = new BV_RFCQ_COVER_INFO();
	private BV_RFCQ_COVER_INFO ProceedsCoverInfo = new BV_RFCQ_COVER_INFO();
	private BV_RFCQ_COVER_INFO GrossYieldCoverInfo = new BV_RFCQ_COVER_INFO();
	private BV_RFCQ_COVER_INFO DurWeightedYieldCoverInfo = new BV_RFCQ_COVER_INFO();
	private double GrossYieldSpread = 0;
	private double ProceedsSpread = 0;
	private double RiskWeightedYieldSpread = 0;
	private short NumOfLegs = 0;
	private short NumOfTradableLegs = 0;
	private BV_RFCQ_LEG_SUMMARY[] LegSummary = new BV_RFCQ_LEG_SUMMARY[3];
	private String Comment = "";
	private String AreaCodeShortDesc = "";
	private String AreaCodeDesc = "";

	public BV_HIST_RFCQ_SELL_SIDE_SUMMARY_INFO()
	{
		for (int i=0; i < LegSummary.length; ++i)
		{
			LegSummary[i] = new BV_RFCQ_LEG_SUMMARY();
		}
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
	public long getRfcqReqId()
	{
		return RfcqReqId;
	}
	public void setRfcqReqId(long value)
	{
		RfcqReqId = value;
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
	public BV_ALGO_INFO getAlgoInfo()
	{
		return AlgoInfo;
	}
	public void setAlgoInfo(BV_ALGO_INFO value)
	{
		AlgoInfo = value;
	}
	public BV_CLIENT_IDENTIFICATION_INFO getClientIdentificationInfo()
	{
		return ClientIdentificationInfo;
	}
	public void setClientIdentificationInfo(BV_CLIENT_IDENTIFICATION_INFO value)
	{
		ClientIdentificationInfo = value;
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
	public TI_FLAG_Enum getMsgFg()
	{
		return MsgFg;
	}
	public void setMsgFg(TI_FLAG_Enum value)
	{
		MsgFg = value;
	}
	public String getBuySideMemberCode()
	{
		return BuySideMemberCode;
	}
	public void setBuySideMemberCode(String value)
	{
		BuySideMemberCode = value;
	}
	public String getBuySideMemberDesc()
	{
		return BuySideMemberDesc;
	}
	public void setBuySideMemberDesc(String value)
	{
		BuySideMemberDesc = value;
	}
	public String getBuySideMemberShortDesc()
	{
		return BuySideMemberShortDesc;
	}
	public void setBuySideMemberShortDesc(String value)
	{
		BuySideMemberShortDesc = value;
	}
	public String getBuySideTraderName()
	{
		return BuySideTraderName;
	}
	public void setBuySideTraderName(String value)
	{
		BuySideTraderName = value;
	}
	public BV_RFCQ_DEALER_SELECTION_TYPE_Enum getDealerSelectionType()
	{
		return DealerSelectionType;
	}
	public void setDealerSelectionType(BV_RFCQ_DEALER_SELECTION_TYPE_Enum value)
	{
		DealerSelectionType = value;
	}
	public TI_RFCQ_REQUEST_STATUS_Enum getFinalStatus()
	{
		return FinalStatus;
	}
	public void setFinalStatus(TI_RFCQ_REQUEST_STATUS_Enum value)
	{
		FinalStatus = value;
	}
	public TI_RFCQ_PROVIDER_STATUS_Enum getProviderStatus()
	{
		return ProviderStatus;
	}
	public void setProviderStatus(TI_RFCQ_PROVIDER_STATUS_Enum value)
	{
		ProviderStatus = value;
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
	public long getDelay()
	{
		return Delay;
	}
	public void setDelay(long value)
	{
		Delay = value;
	}
	public int getResponseTimeDifference()
	{
		return ResponseTimeDifference;
	}
	public void setResponseTimeDifference(int value)
	{
		ResponseTimeDifference = value;
	}
	public BV_RFCQ_COVER_INFO getPriceCoverInfo()
	{
		return PriceCoverInfo;
	}
	public void setPriceCoverInfo(BV_RFCQ_COVER_INFO value)
	{
		PriceCoverInfo = value;
	}
	public BV_RFCQ_COVER_INFO getProceedsCoverInfo()
	{
		return ProceedsCoverInfo;
	}
	public void setProceedsCoverInfo(BV_RFCQ_COVER_INFO value)
	{
		ProceedsCoverInfo = value;
	}
	public BV_RFCQ_COVER_INFO getGrossYieldCoverInfo()
	{
		return GrossYieldCoverInfo;
	}
	public void setGrossYieldCoverInfo(BV_RFCQ_COVER_INFO value)
	{
		GrossYieldCoverInfo = value;
	}
	public BV_RFCQ_COVER_INFO getDurWeightedYieldCoverInfo()
	{
		return DurWeightedYieldCoverInfo;
	}
	public void setDurWeightedYieldCoverInfo(BV_RFCQ_COVER_INFO value)
	{
		DurWeightedYieldCoverInfo = value;
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
	public short getNumOfLegs()
	{
		return NumOfLegs;
	}
	public void setNumOfLegs(short value)
	{
		NumOfLegs = value;
	}
	public short getNumOfTradableLegs()
	{
		return NumOfTradableLegs;
	}
	public void setNumOfTradableLegs(short value)
	{
		NumOfTradableLegs = value;
	}
	public BV_RFCQ_LEG_SUMMARY[] getLegSummary()
	{
		return LegSummary;
	}
	public void setLegSummary(BV_RFCQ_LEG_SUMMARY[] value)
	{
		LegSummary = value;
	}
	public String getComment()
	{
		return Comment;
	}
	public void setComment(String value)
	{
		Comment = value;
	}
	public String getAreaCodeShortDesc()
	{
		return AreaCodeShortDesc;
	}
	public void setAreaCodeShortDesc(String value)
	{
		AreaCodeShortDesc = value;
	}
	public String getAreaCodeDesc()
	{
		return AreaCodeDesc;
	}
	public void setAreaCodeDesc(String value)
	{
		AreaCodeDesc = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		SellSideMemberCode = byteBuffer.readString();
		SellSideTraderName = byteBuffer.readString();
		RfcqReqId = (long)byteBuffer.readInt();
		CreationDate = (long)byteBuffer.readInt();
		CreationTime = byteBuffer.readLong();
		RfcqType = RfcqType.getEnum(byteBuffer.readInt());
		RfcqOrigin = RfcqOrigin.getEnum(byteBuffer.readInt());
		AlgoInfo.readXDR(byteBuffer);
		ClientIdentificationInfo.readXDR(byteBuffer);
		PreAgreedFg = PreAgreedFg.getEnum(byteBuffer.readInt());
		PreTradeFg = PreTradeFg.getEnum(byteBuffer.readInt());
		DueInTime = (short)byteBuffer.readInt();
		DueInTimeout = byteBuffer.readLong();
		QuantityCalculation = QuantityCalculation.getEnum(byteBuffer.readInt());
		TradingListId = (long)byteBuffer.readInt();
		LegId = (short)byteBuffer.readInt();
		MsgFg = MsgFg.getEnum(byteBuffer.readInt());
		BuySideMemberCode = byteBuffer.readString();
		BuySideMemberDesc = byteBuffer.readString();
		BuySideMemberShortDesc = byteBuffer.readString();
		BuySideTraderName = byteBuffer.readString();
		DealerSelectionType = DealerSelectionType.getEnum(byteBuffer.readInt());
		FinalStatus = FinalStatus.getEnum(byteBuffer.readInt());
		ProviderStatus = ProviderStatus.getEnum(byteBuffer.readInt());
		ClosingTime = byteBuffer.readLong();
		SellSideNr = (short)byteBuffer.readInt();
		ParticipatingSellSideNr = (short)byteBuffer.readInt();
		Delay = (long)byteBuffer.readInt();
		ResponseTimeDifference = (int)byteBuffer.readInt();
		PriceCoverInfo.readXDR(byteBuffer);
		ProceedsCoverInfo.readXDR(byteBuffer);
		GrossYieldCoverInfo.readXDR(byteBuffer);
		DurWeightedYieldCoverInfo.readXDR(byteBuffer);
		GrossYieldSpread = byteBuffer.readDouble();
		ProceedsSpread = byteBuffer.readDouble();
		RiskWeightedYieldSpread = byteBuffer.readDouble();
		NumOfLegs = (short)byteBuffer.readInt();
		NumOfTradableLegs = (short)byteBuffer.readInt();
		for (int i=0; i < LegSummary.length; ++i)
		{
			LegSummary[i].readXDR(byteBuffer);
		}
		Comment = byteBuffer.readString();
		AreaCodeShortDesc = byteBuffer.readString();
		AreaCodeDesc = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeString(SellSideMemberCode);
		byteBuffer.writeString(SellSideTraderName);
		byteBuffer.writeInt((int)(RfcqReqId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(CreationDate & 0xFFFFFFFFL));
		byteBuffer.writeLong(CreationTime);
		byteBuffer.writeInt(RfcqType.getValue());
		byteBuffer.writeInt(RfcqOrigin.getValue());
		AlgoInfo.writeXDR(byteBuffer);
		ClientIdentificationInfo.writeXDR(byteBuffer);
		byteBuffer.writeInt(PreAgreedFg.getValue());
		byteBuffer.writeInt(PreTradeFg.getValue());
		byteBuffer.writeInt((int)(DueInTime & 0xFFFFL));
		byteBuffer.writeLong(DueInTimeout);
		byteBuffer.writeInt(QuantityCalculation.getValue());
		byteBuffer.writeInt((int)(TradingListId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(LegId & 0xFFFFL));
		byteBuffer.writeInt(MsgFg.getValue());
		byteBuffer.writeString(BuySideMemberCode);
		byteBuffer.writeString(BuySideMemberDesc);
		byteBuffer.writeString(BuySideMemberShortDesc);
		byteBuffer.writeString(BuySideTraderName);
		byteBuffer.writeInt(DealerSelectionType.getValue());
		byteBuffer.writeInt(FinalStatus.getValue());
		byteBuffer.writeInt(ProviderStatus.getValue());
		byteBuffer.writeLong(ClosingTime);
		byteBuffer.writeInt((int)(SellSideNr & 0xFFFFL));
		byteBuffer.writeInt((int)(ParticipatingSellSideNr & 0xFFFFL));
		byteBuffer.writeInt((int)(Delay & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(ResponseTimeDifference & 0xFFFFFFFFL));
		PriceCoverInfo.writeXDR(byteBuffer);
		ProceedsCoverInfo.writeXDR(byteBuffer);
		GrossYieldCoverInfo.writeXDR(byteBuffer);
		DurWeightedYieldCoverInfo.writeXDR(byteBuffer);
		byteBuffer.writeDouble(GrossYieldSpread);
		byteBuffer.writeDouble(ProceedsSpread);
		byteBuffer.writeDouble(RiskWeightedYieldSpread);
		byteBuffer.writeInt((int)(NumOfLegs & 0xFFFFL));
		byteBuffer.writeInt((int)(NumOfTradableLegs & 0xFFFFL));
		for (int i=0; i < LegSummary.length; ++i)
		{
			LegSummary[i].writeXDR(byteBuffer);
		}
		byteBuffer.writeString(Comment);
		byteBuffer.writeString(AreaCodeShortDesc);
		byteBuffer.writeString(AreaCodeDesc);

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
		stringBuilder.append("BV_HIST_RFCQ_SELL_SIDE_SUMMARY_INFO::");
		stringBuilder.append("SellSideMemberCode(").append(SellSideMemberCode).append(")");
		stringBuilder.append("SellSideTraderName(").append(SellSideTraderName).append(")");
		stringBuilder.append("RfcqReqId(").append(RfcqReqId).append(")");
		stringBuilder.append("CreationDate(").append(CreationDate).append(")");
		stringBuilder.append("CreationTime(").append(CreationTime).append(")");
		stringBuilder.append("RfcqType(").append(RfcqType).append(")");
		stringBuilder.append("RfcqOrigin(").append(RfcqOrigin).append(")");
		stringBuilder.append("AlgoInfo(").append(AlgoInfo.toString()).append(")");
		stringBuilder.append("ClientIdentificationInfo(").append(ClientIdentificationInfo.toString()).append(")");
		stringBuilder.append("PreAgreedFg(").append(PreAgreedFg).append(")");
		stringBuilder.append("PreTradeFg(").append(PreTradeFg).append(")");
		stringBuilder.append("DueInTime(").append(DueInTime).append(")");
		stringBuilder.append("DueInTimeout(").append(DueInTimeout).append(")");
		stringBuilder.append("QuantityCalculation(").append(QuantityCalculation).append(")");
		stringBuilder.append("TradingListId(").append(TradingListId).append(")");
		stringBuilder.append("LegId(").append(LegId).append(")");
		stringBuilder.append("MsgFg(").append(MsgFg).append(")");
		stringBuilder.append("BuySideMemberCode(").append(BuySideMemberCode).append(")");
		stringBuilder.append("BuySideMemberDesc(").append(BuySideMemberDesc).append(")");
		stringBuilder.append("BuySideMemberShortDesc(").append(BuySideMemberShortDesc).append(")");
		stringBuilder.append("BuySideTraderName(").append(BuySideTraderName).append(")");
		stringBuilder.append("DealerSelectionType(").append(DealerSelectionType).append(")");
		stringBuilder.append("FinalStatus(").append(FinalStatus).append(")");
		stringBuilder.append("ProviderStatus(").append(ProviderStatus).append(")");
		stringBuilder.append("ClosingTime(").append(ClosingTime).append(")");
		stringBuilder.append("SellSideNr(").append(SellSideNr).append(")");
		stringBuilder.append("ParticipatingSellSideNr(").append(ParticipatingSellSideNr).append(")");
		stringBuilder.append("Delay(").append(Delay).append(")");
		stringBuilder.append("ResponseTimeDifference(").append(ResponseTimeDifference).append(")");
		stringBuilder.append("PriceCoverInfo(").append(PriceCoverInfo.toString()).append(")");
		stringBuilder.append("ProceedsCoverInfo(").append(ProceedsCoverInfo.toString()).append(")");
		stringBuilder.append("GrossYieldCoverInfo(").append(GrossYieldCoverInfo.toString()).append(")");
		stringBuilder.append("DurWeightedYieldCoverInfo(").append(DurWeightedYieldCoverInfo.toString()).append(")");
		stringBuilder.append("GrossYieldSpread(").append(GrossYieldSpread).append(")");
		stringBuilder.append("ProceedsSpread(").append(ProceedsSpread).append(")");
		stringBuilder.append("RiskWeightedYieldSpread(").append(RiskWeightedYieldSpread).append(")");
		stringBuilder.append("NumOfLegs(").append(NumOfLegs).append(")");
		stringBuilder.append("NumOfTradableLegs(").append(NumOfTradableLegs).append(")");
		for (int i=0; i < LegSummary.length; ++i)
		{
			stringBuilder.append("LegSummary[").append(i).append("](").append(LegSummary[i].toString()).append(")");
		}
		stringBuilder.append("Comment(").append(Comment).append(")");
		stringBuilder.append("AreaCodeShortDesc(").append(AreaCodeShortDesc).append(")");
		stringBuilder.append("AreaCodeDesc(").append(AreaCodeDesc).append(")");
		return stringBuilder.toString();
	}
}
