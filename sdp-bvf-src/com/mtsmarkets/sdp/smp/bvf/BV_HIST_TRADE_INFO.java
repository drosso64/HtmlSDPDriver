package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_HIST_TRADE_INFO extends SMPMessage
{
	public static final long CLASS_ID = 114918;

	private TI_MSG_INFO TradeMsgInfo = new TI_MSG_INFO();
	private String SectionCode = "";
	private long DealId = 0;
	private BV_HIST_TRADE_MEMBER_INFO Provider = new BV_HIST_TRADE_MEMBER_INFO();
	private BV_HIST_TRADE_MEMBER_INFO Aggressor = new BV_HIST_TRADE_MEMBER_INFO();
	private BV_HIST_INSTRUMENT_INFO Instrument = new BV_HIST_INSTRUMENT_INFO();
	private String InstrumentClassCode = "";
	private String FinancialInstrumentCode = "";
	private TI_VERB_Enum Verb = TI_VERB_Enum.TI_VERB_Buy;
	private BV_TRADE_TRADING_INFO TradeInfo = new BV_TRADE_TRADING_INFO();
	private TI_FILL_STATUS_Enum Status = TI_FILL_STATUS_Enum.TI_FILL_STATUS_Active;
	private BV_MATCH_MODE_Enum FillMode = BV_MATCH_MODE_Enum.BV_MATCH_MODE_Automatic;
	private long SettlDate = 0;
	private TI_SETTL_TYPE_Enum SettlType = TI_SETTL_TYPE_Enum.TI_SETTL_TYPE_Manual;
	private BV_SETTL_STATUS_Enum SettlStatus = BV_SETTL_STATUS_Enum.BV_SETTL_STATUS_Waiting;
	private String AccountCode = "";
	private double NominalValue = 0;
	private double SettlCounterValue = 0;
	private double AccruedInterest = 0;
	private double GrossTradeAmt = 0;
	private String Currency = "";
	private TI_FLAG_Enum GreyMarketFlag = TI_FLAG_Enum.TI_FLAG_No;
	private long UpdateTime = 0;
	private String MktAffiliationShortDesc = "";
	private String MktAffiliationDesc = "";
	private double SettlementFXRate = 0;
	private long ParentTradeId = 0;
	private TI_FLAG_Enum SplittableFg = TI_FLAG_Enum.TI_FLAG_No;
	private long PreAllocationTime = 0;
	private short SettlementOffset = 0;
	private String AccountInfo = "";
	private long AllocationId = 0;
	private double Adjustment = 0;
	private TI_FLAG_Enum AdjustedFg = TI_FLAG_Enum.TI_FLAG_No;
	private TI_TRADE_TYPE_Enum TradeType = TI_TRADE_TYPE_Enum.TI_TRADE_TYPE_Normal;
	private String AreaCodeShortDesc = "";
	private String AreaCodeDesc = "";
	private BV_BEST_TRADING_INFO BVBestBid = new BV_BEST_TRADING_INFO();
	private BV_BEST_TRADING_INFO BVBestAsk = new BV_BEST_TRADING_INFO();
	private double BVBestMidPrice = 0;
	private double BVBestMidYield = 0;
	private BV_VALUE BVBestMidYTC = new BV_VALUE();
	private BV_VALUE BVBestMidYTW = new BV_VALUE();
	private BV_VALUE BvBestMidYMWTh = new BV_VALUE();
	private double BvBestMidMWCPriceTh = 0;
	private BV_VALUE BvBestMidYMWExrc = new BV_VALUE();
	private BV_VALUE BvBestMidYTR = new BV_VALUE();
	private BV_ANALYTICS BvBestMidAnalytics = new BV_ANALYTICS();
	private TI_FLAG_Enum BVBestMidValidityFg = TI_FLAG_Enum.TI_FLAG_No;
	private String MicCode = "";
	private long TransactionId = 0;
	private short LegId = 0;
	private TI_RFCQ_TYPE_Enum RfcqType = TI_RFCQ_TYPE_Enum.TI_RFCQ_TYPE_Outright;
	private BV_TRANSPARENCY_INFO TransparencyInfo = new BV_TRANSPARENCY_INFO();

	public BV_HIST_TRADE_INFO()
	{
	}

	public TI_MSG_INFO getTradeMsgInfo()
	{
		return TradeMsgInfo;
	}
	public void setTradeMsgInfo(TI_MSG_INFO value)
	{
		TradeMsgInfo = value;
	}
	public String getSectionCode()
	{
		return SectionCode;
	}
	public void setSectionCode(String value)
	{
		SectionCode = value;
	}
	public long getDealId()
	{
		return DealId;
	}
	public void setDealId(long value)
	{
		DealId = value;
	}
	public BV_HIST_TRADE_MEMBER_INFO getProvider()
	{
		return Provider;
	}
	public void setProvider(BV_HIST_TRADE_MEMBER_INFO value)
	{
		Provider = value;
	}
	public BV_HIST_TRADE_MEMBER_INFO getAggressor()
	{
		return Aggressor;
	}
	public void setAggressor(BV_HIST_TRADE_MEMBER_INFO value)
	{
		Aggressor = value;
	}
	public BV_HIST_INSTRUMENT_INFO getInstrument()
	{
		return Instrument;
	}
	public void setInstrument(BV_HIST_INSTRUMENT_INFO value)
	{
		Instrument = value;
	}
	public String getInstrumentClassCode()
	{
		return InstrumentClassCode;
	}
	public void setInstrumentClassCode(String value)
	{
		InstrumentClassCode = value;
	}
	public String getFinancialInstrumentCode()
	{
		return FinancialInstrumentCode;
	}
	public void setFinancialInstrumentCode(String value)
	{
		FinancialInstrumentCode = value;
	}
	public TI_VERB_Enum getVerb()
	{
		return Verb;
	}
	public void setVerb(TI_VERB_Enum value)
	{
		Verb = value;
	}
	public BV_TRADE_TRADING_INFO getTradeInfo()
	{
		return TradeInfo;
	}
	public void setTradeInfo(BV_TRADE_TRADING_INFO value)
	{
		TradeInfo = value;
	}
	public TI_FILL_STATUS_Enum getStatus()
	{
		return Status;
	}
	public void setStatus(TI_FILL_STATUS_Enum value)
	{
		Status = value;
	}
	public BV_MATCH_MODE_Enum getFillMode()
	{
		return FillMode;
	}
	public void setFillMode(BV_MATCH_MODE_Enum value)
	{
		FillMode = value;
	}
	public long getSettlDate()
	{
		return SettlDate;
	}
	public void setSettlDate(long value)
	{
		SettlDate = value;
	}
	public TI_SETTL_TYPE_Enum getSettlType()
	{
		return SettlType;
	}
	public void setSettlType(TI_SETTL_TYPE_Enum value)
	{
		SettlType = value;
	}
	public BV_SETTL_STATUS_Enum getSettlStatus()
	{
		return SettlStatus;
	}
	public void setSettlStatus(BV_SETTL_STATUS_Enum value)
	{
		SettlStatus = value;
	}
	public String getAccountCode()
	{
		return AccountCode;
	}
	public void setAccountCode(String value)
	{
		AccountCode = value;
	}
	public double getNominalValue()
	{
		return NominalValue;
	}
	public void setNominalValue(double value)
	{
		NominalValue = value;
	}
	public double getSettlCounterValue()
	{
		return SettlCounterValue;
	}
	public void setSettlCounterValue(double value)
	{
		SettlCounterValue = value;
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
	public String getCurrency()
	{
		return Currency;
	}
	public void setCurrency(String value)
	{
		Currency = value;
	}
	public TI_FLAG_Enum getGreyMarketFlag()
	{
		return GreyMarketFlag;
	}
	public void setGreyMarketFlag(TI_FLAG_Enum value)
	{
		GreyMarketFlag = value;
	}
	public long getUpdateTime()
	{
		return UpdateTime;
	}
	public void setUpdateTime(long value)
	{
		UpdateTime = value;
	}
	public String getMktAffiliationShortDesc()
	{
		return MktAffiliationShortDesc;
	}
	public void setMktAffiliationShortDesc(String value)
	{
		MktAffiliationShortDesc = value;
	}
	public String getMktAffiliationDesc()
	{
		return MktAffiliationDesc;
	}
	public void setMktAffiliationDesc(String value)
	{
		MktAffiliationDesc = value;
	}
	public double getSettlementFXRate()
	{
		return SettlementFXRate;
	}
	public void setSettlementFXRate(double value)
	{
		SettlementFXRate = value;
	}
	public long getParentTradeId()
	{
		return ParentTradeId;
	}
	public void setParentTradeId(long value)
	{
		ParentTradeId = value;
	}
	public TI_FLAG_Enum getSplittableFg()
	{
		return SplittableFg;
	}
	public void setSplittableFg(TI_FLAG_Enum value)
	{
		SplittableFg = value;
	}
	public long getPreAllocationTime()
	{
		return PreAllocationTime;
	}
	public void setPreAllocationTime(long value)
	{
		PreAllocationTime = value;
	}
	public short getSettlementOffset()
	{
		return SettlementOffset;
	}
	public void setSettlementOffset(short value)
	{
		SettlementOffset = value;
	}
	public String getAccountInfo()
	{
		return AccountInfo;
	}
	public void setAccountInfo(String value)
	{
		AccountInfo = value;
	}
	public long getAllocationId()
	{
		return AllocationId;
	}
	public void setAllocationId(long value)
	{
		AllocationId = value;
	}
	public double getAdjustment()
	{
		return Adjustment;
	}
	public void setAdjustment(double value)
	{
		Adjustment = value;
	}
	public TI_FLAG_Enum getAdjustedFg()
	{
		return AdjustedFg;
	}
	public void setAdjustedFg(TI_FLAG_Enum value)
	{
		AdjustedFg = value;
	}
	public TI_TRADE_TYPE_Enum getTradeType()
	{
		return TradeType;
	}
	public void setTradeType(TI_TRADE_TYPE_Enum value)
	{
		TradeType = value;
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
	public BV_BEST_TRADING_INFO getBVBestBid()
	{
		return BVBestBid;
	}
	public void setBVBestBid(BV_BEST_TRADING_INFO value)
	{
		BVBestBid = value;
	}
	public BV_BEST_TRADING_INFO getBVBestAsk()
	{
		return BVBestAsk;
	}
	public void setBVBestAsk(BV_BEST_TRADING_INFO value)
	{
		BVBestAsk = value;
	}
	public double getBVBestMidPrice()
	{
		return BVBestMidPrice;
	}
	public void setBVBestMidPrice(double value)
	{
		BVBestMidPrice = value;
	}
	public double getBVBestMidYield()
	{
		return BVBestMidYield;
	}
	public void setBVBestMidYield(double value)
	{
		BVBestMidYield = value;
	}
	public BV_VALUE getBVBestMidYTC()
	{
		return BVBestMidYTC;
	}
	public void setBVBestMidYTC(BV_VALUE value)
	{
		BVBestMidYTC = value;
	}
	public BV_VALUE getBVBestMidYTW()
	{
		return BVBestMidYTW;
	}
	public void setBVBestMidYTW(BV_VALUE value)
	{
		BVBestMidYTW = value;
	}
	public BV_VALUE getBvBestMidYMWTh()
	{
		return BvBestMidYMWTh;
	}
	public void setBvBestMidYMWTh(BV_VALUE value)
	{
		BvBestMidYMWTh = value;
	}
	public double getBvBestMidMWCPriceTh()
	{
		return BvBestMidMWCPriceTh;
	}
	public void setBvBestMidMWCPriceTh(double value)
	{
		BvBestMidMWCPriceTh = value;
	}
	public BV_VALUE getBvBestMidYMWExrc()
	{
		return BvBestMidYMWExrc;
	}
	public void setBvBestMidYMWExrc(BV_VALUE value)
	{
		BvBestMidYMWExrc = value;
	}
	public BV_VALUE getBvBestMidYTR()
	{
		return BvBestMidYTR;
	}
	public void setBvBestMidYTR(BV_VALUE value)
	{
		BvBestMidYTR = value;
	}
	public BV_ANALYTICS getBvBestMidAnalytics()
	{
		return BvBestMidAnalytics;
	}
	public void setBvBestMidAnalytics(BV_ANALYTICS value)
	{
		BvBestMidAnalytics = value;
	}
	public TI_FLAG_Enum getBVBestMidValidityFg()
	{
		return BVBestMidValidityFg;
	}
	public void setBVBestMidValidityFg(TI_FLAG_Enum value)
	{
		BVBestMidValidityFg = value;
	}
	public String getMicCode()
	{
		return MicCode;
	}
	public void setMicCode(String value)
	{
		MicCode = value;
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
	public BV_TRANSPARENCY_INFO getTransparencyInfo()
	{
		return TransparencyInfo;
	}
	public void setTransparencyInfo(BV_TRANSPARENCY_INFO value)
	{
		TransparencyInfo = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		TradeMsgInfo.readXDR(byteBuffer);
		SectionCode = byteBuffer.readString();
		DealId = (long)byteBuffer.readInt();
		Provider.readXDR(byteBuffer);
		Aggressor.readXDR(byteBuffer);
		Instrument.readXDR(byteBuffer);
		InstrumentClassCode = byteBuffer.readString();
		FinancialInstrumentCode = byteBuffer.readString();
		Verb = Verb.getEnum(byteBuffer.readInt());
		TradeInfo.readXDR(byteBuffer);
		Status = Status.getEnum(byteBuffer.readInt());
		FillMode = FillMode.getEnum(byteBuffer.readInt());
		SettlDate = (long)byteBuffer.readInt();
		SettlType = SettlType.getEnum(byteBuffer.readInt());
		SettlStatus = SettlStatus.getEnum(byteBuffer.readInt());
		AccountCode = byteBuffer.readString();
		NominalValue = byteBuffer.readDouble();
		SettlCounterValue = byteBuffer.readDouble();
		AccruedInterest = byteBuffer.readDouble();
		GrossTradeAmt = byteBuffer.readDouble();
		Currency = byteBuffer.readString();
		GreyMarketFlag = GreyMarketFlag.getEnum(byteBuffer.readInt());
		UpdateTime = byteBuffer.readLong();
		MktAffiliationShortDesc = byteBuffer.readString();
		MktAffiliationDesc = byteBuffer.readString();
		SettlementFXRate = byteBuffer.readDouble();
		ParentTradeId = (long)byteBuffer.readInt();
		SplittableFg = SplittableFg.getEnum(byteBuffer.readInt());
		PreAllocationTime = byteBuffer.readLong();
		SettlementOffset = (short)byteBuffer.readInt();
		AccountInfo = byteBuffer.readString();
		AllocationId = (long)byteBuffer.readInt();
		Adjustment = byteBuffer.readDouble();
		AdjustedFg = AdjustedFg.getEnum(byteBuffer.readInt());
		TradeType = TradeType.getEnum(byteBuffer.readInt());
		AreaCodeShortDesc = byteBuffer.readString();
		AreaCodeDesc = byteBuffer.readString();
		BVBestBid.readXDR(byteBuffer);
		BVBestAsk.readXDR(byteBuffer);
		BVBestMidPrice = byteBuffer.readDouble();
		BVBestMidYield = byteBuffer.readDouble();
		BVBestMidYTC.readXDR(byteBuffer);
		BVBestMidYTW.readXDR(byteBuffer);
		BvBestMidYMWTh.readXDR(byteBuffer);
		BvBestMidMWCPriceTh = byteBuffer.readDouble();
		BvBestMidYMWExrc.readXDR(byteBuffer);
		BvBestMidYTR.readXDR(byteBuffer);
		BvBestMidAnalytics.readXDR(byteBuffer);
		BVBestMidValidityFg = BVBestMidValidityFg.getEnum(byteBuffer.readInt());
		MicCode = byteBuffer.readString();
		TransactionId = (long)byteBuffer.readInt();
		LegId = (short)byteBuffer.readInt();
		RfcqType = RfcqType.getEnum(byteBuffer.readInt());
		TransparencyInfo.readXDR(byteBuffer);
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		TradeMsgInfo.writeXDR(byteBuffer);
		byteBuffer.writeString(SectionCode);
		byteBuffer.writeInt((int)(DealId & 0xFFFFFFFFL));
		Provider.writeXDR(byteBuffer);
		Aggressor.writeXDR(byteBuffer);
		Instrument.writeXDR(byteBuffer);
		byteBuffer.writeString(InstrumentClassCode);
		byteBuffer.writeString(FinancialInstrumentCode);
		byteBuffer.writeInt(Verb.getValue());
		TradeInfo.writeXDR(byteBuffer);
		byteBuffer.writeInt(Status.getValue());
		byteBuffer.writeInt(FillMode.getValue());
		byteBuffer.writeInt((int)(SettlDate & 0xFFFFFFFFL));
		byteBuffer.writeInt(SettlType.getValue());
		byteBuffer.writeInt(SettlStatus.getValue());
		byteBuffer.writeString(AccountCode);
		byteBuffer.writeDouble(NominalValue);
		byteBuffer.writeDouble(SettlCounterValue);
		byteBuffer.writeDouble(AccruedInterest);
		byteBuffer.writeDouble(GrossTradeAmt);
		byteBuffer.writeString(Currency);
		byteBuffer.writeInt(GreyMarketFlag.getValue());
		byteBuffer.writeLong(UpdateTime);
		byteBuffer.writeString(MktAffiliationShortDesc);
		byteBuffer.writeString(MktAffiliationDesc);
		byteBuffer.writeDouble(SettlementFXRate);
		byteBuffer.writeInt((int)(ParentTradeId & 0xFFFFFFFFL));
		byteBuffer.writeInt(SplittableFg.getValue());
		byteBuffer.writeLong(PreAllocationTime);
		byteBuffer.writeInt((int)(SettlementOffset & 0xFFFFL));
		byteBuffer.writeString(AccountInfo);
		byteBuffer.writeInt((int)(AllocationId & 0xFFFFFFFFL));
		byteBuffer.writeDouble(Adjustment);
		byteBuffer.writeInt(AdjustedFg.getValue());
		byteBuffer.writeInt(TradeType.getValue());
		byteBuffer.writeString(AreaCodeShortDesc);
		byteBuffer.writeString(AreaCodeDesc);
		BVBestBid.writeXDR(byteBuffer);
		BVBestAsk.writeXDR(byteBuffer);
		byteBuffer.writeDouble(BVBestMidPrice);
		byteBuffer.writeDouble(BVBestMidYield);
		BVBestMidYTC.writeXDR(byteBuffer);
		BVBestMidYTW.writeXDR(byteBuffer);
		BvBestMidYMWTh.writeXDR(byteBuffer);
		byteBuffer.writeDouble(BvBestMidMWCPriceTh);
		BvBestMidYMWExrc.writeXDR(byteBuffer);
		BvBestMidYTR.writeXDR(byteBuffer);
		BvBestMidAnalytics.writeXDR(byteBuffer);
		byteBuffer.writeInt(BVBestMidValidityFg.getValue());
		byteBuffer.writeString(MicCode);
		byteBuffer.writeInt((int)(TransactionId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(LegId & 0xFFFFL));
		byteBuffer.writeInt(RfcqType.getValue());
		TransparencyInfo.writeXDR(byteBuffer);

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
		stringBuilder.append("BV_HIST_TRADE_INFO::");
		stringBuilder.append("TradeMsgInfo(").append(TradeMsgInfo.toString()).append(")");
		stringBuilder.append("SectionCode(").append(SectionCode).append(")");
		stringBuilder.append("DealId(").append(DealId).append(")");
		stringBuilder.append("Provider(").append(Provider.toString()).append(")");
		stringBuilder.append("Aggressor(").append(Aggressor.toString()).append(")");
		stringBuilder.append("Instrument(").append(Instrument.toString()).append(")");
		stringBuilder.append("InstrumentClassCode(").append(InstrumentClassCode).append(")");
		stringBuilder.append("FinancialInstrumentCode(").append(FinancialInstrumentCode).append(")");
		stringBuilder.append("Verb(").append(Verb).append(")");
		stringBuilder.append("TradeInfo(").append(TradeInfo.toString()).append(")");
		stringBuilder.append("Status(").append(Status).append(")");
		stringBuilder.append("FillMode(").append(FillMode).append(")");
		stringBuilder.append("SettlDate(").append(SettlDate).append(")");
		stringBuilder.append("SettlType(").append(SettlType).append(")");
		stringBuilder.append("SettlStatus(").append(SettlStatus).append(")");
		stringBuilder.append("AccountCode(").append(AccountCode).append(")");
		stringBuilder.append("NominalValue(").append(NominalValue).append(")");
		stringBuilder.append("SettlCounterValue(").append(SettlCounterValue).append(")");
		stringBuilder.append("AccruedInterest(").append(AccruedInterest).append(")");
		stringBuilder.append("GrossTradeAmt(").append(GrossTradeAmt).append(")");
		stringBuilder.append("Currency(").append(Currency).append(")");
		stringBuilder.append("GreyMarketFlag(").append(GreyMarketFlag).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		stringBuilder.append("MktAffiliationShortDesc(").append(MktAffiliationShortDesc).append(")");
		stringBuilder.append("MktAffiliationDesc(").append(MktAffiliationDesc).append(")");
		stringBuilder.append("SettlementFXRate(").append(SettlementFXRate).append(")");
		stringBuilder.append("ParentTradeId(").append(ParentTradeId).append(")");
		stringBuilder.append("SplittableFg(").append(SplittableFg).append(")");
		stringBuilder.append("PreAllocationTime(").append(PreAllocationTime).append(")");
		stringBuilder.append("SettlementOffset(").append(SettlementOffset).append(")");
		stringBuilder.append("AccountInfo(").append(AccountInfo).append(")");
		stringBuilder.append("AllocationId(").append(AllocationId).append(")");
		stringBuilder.append("Adjustment(").append(Adjustment).append(")");
		stringBuilder.append("AdjustedFg(").append(AdjustedFg).append(")");
		stringBuilder.append("TradeType(").append(TradeType).append(")");
		stringBuilder.append("AreaCodeShortDesc(").append(AreaCodeShortDesc).append(")");
		stringBuilder.append("AreaCodeDesc(").append(AreaCodeDesc).append(")");
		stringBuilder.append("BVBestBid(").append(BVBestBid.toString()).append(")");
		stringBuilder.append("BVBestAsk(").append(BVBestAsk.toString()).append(")");
		stringBuilder.append("BVBestMidPrice(").append(BVBestMidPrice).append(")");
		stringBuilder.append("BVBestMidYield(").append(BVBestMidYield).append(")");
		stringBuilder.append("BVBestMidYTC(").append(BVBestMidYTC.toString()).append(")");
		stringBuilder.append("BVBestMidYTW(").append(BVBestMidYTW.toString()).append(")");
		stringBuilder.append("BvBestMidYMWTh(").append(BvBestMidYMWTh.toString()).append(")");
		stringBuilder.append("BvBestMidMWCPriceTh(").append(BvBestMidMWCPriceTh).append(")");
		stringBuilder.append("BvBestMidYMWExrc(").append(BvBestMidYMWExrc.toString()).append(")");
		stringBuilder.append("BvBestMidYTR(").append(BvBestMidYTR.toString()).append(")");
		stringBuilder.append("BvBestMidAnalytics(").append(BvBestMidAnalytics.toString()).append(")");
		stringBuilder.append("BVBestMidValidityFg(").append(BVBestMidValidityFg).append(")");
		stringBuilder.append("MicCode(").append(MicCode).append(")");
		stringBuilder.append("TransactionId(").append(TransactionId).append(")");
		stringBuilder.append("LegId(").append(LegId).append(")");
		stringBuilder.append("RfcqType(").append(RfcqType).append(")");
		stringBuilder.append("TransparencyInfo(").append(TransparencyInfo.toString()).append(")");
		return stringBuilder.toString();
	}
}
