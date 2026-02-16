package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_HIST_BUY_SIDE_INVENTORY_ORDER extends SMPMessage
{
	public static final long CLASS_ID = 114529;

	private TI_MSG_INFO OrderMsgInfo = new TI_MSG_INFO();
	private String SectionCode = "";
	private long InventoryQuoteId = 0;
	private String DealerReferenceId = "";
	private String QuoteDigest = "";
	private long QuoteUpdateTime = 0;
	private BV_HIST_MEMBER_INFO Aggressor = new BV_HIST_MEMBER_INFO();
	private BV_HIST_MEMBER_INFO Provider = new BV_HIST_MEMBER_INFO();
	private BV_HIST_INSTRUMENT_INFO Instrument = new BV_HIST_INSTRUMENT_INFO();
	private BV_INVENTORY_ORDER_STATUS_Enum Status = BV_INVENTORY_ORDER_STATUS_Enum.BV_INVENTORY_ORDER_STATUS_Processing;
	private double Price = 0;
	private double Yield = 0;
	private double Qty = 0;
	private TI_VERB_Enum Verb = TI_VERB_Enum.TI_VERB_Buy;
	private long AcceptanceTimeout = 0;
	private double Principal = 0;
	private double NominalValue = 0;
	private double Accrued = 0;
	private String Currency = "";
	private short AccrualDays = 0;
	private double Bpv = 0;
	private short SettlementOffset = 0;
	private long SettlementDate = 0;
	private BV_SETTLEMENT_MODE_Enum SettlementMode = BV_SETTLEMENT_MODE_Enum.BV_SETTLEMENT_MODE_Any;
	private BV_EXEC_SETTLEMENT_MODE_Enum ExecSettlementMode = BV_EXEC_SETTLEMENT_MODE_Enum.BV_EXEC_SETTLEMENT_MODE_None;
	private long StageOrderId = 0;
	private String ClientOrderId = "";
	private String ClientExecID = "";
	private TI_ALLOCATION_TYPE_Enum AllocationType = TI_ALLOCATION_TYPE_Enum.TI_ALLOCATION_TYPE_Unspecified;
	private long AllocationId = 0;
	private String AccountCode = "";
	private String AccountInfo = "";
	private String SettlementInfo = "";
	private String MktAffiliationShortDesc = "";
	private String MktAffiliationDesc = "";
	private String UserInfo1 = "";
	private String UserInfo2 = "";
	private short NextOrderDenialTime = 0;
	private BV_INVENTORY_TRADING_INFO[] BidDepth = new BV_INVENTORY_TRADING_INFO[30];
	private BV_INVENTORY_TRADING_INFO[] AskDepth = new BV_INVENTORY_TRADING_INFO[30];
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
	private long DealId = 0;
	private BV_TRANSPARENCY_INFO TransparencyInfo = new BV_TRANSPARENCY_INFO();
	private long CreationDate = 0;
	private long CreationTime = 0;
	private long UpdateTime = 0;
	private BV_SHORT_SELLING_INDICATOR_Enum ShortSellingIndicator = BV_SHORT_SELLING_INDICATOR_Enum.BV_SHORT_SELLING_INDICATOR_None;

	public BV_HIST_BUY_SIDE_INVENTORY_ORDER()
	{
		for (int i=0; i < BidDepth.length; ++i)
		{
			BidDepth[i] = new BV_INVENTORY_TRADING_INFO();
		}
		for (int i=0; i < AskDepth.length; ++i)
		{
			AskDepth[i] = new BV_INVENTORY_TRADING_INFO();
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
	public String getSectionCode()
	{
		return SectionCode;
	}
	public void setSectionCode(String value)
	{
		SectionCode = value;
	}
	public long getInventoryQuoteId()
	{
		return InventoryQuoteId;
	}
	public void setInventoryQuoteId(long value)
	{
		InventoryQuoteId = value;
	}
	public String getDealerReferenceId()
	{
		return DealerReferenceId;
	}
	public void setDealerReferenceId(String value)
	{
		DealerReferenceId = value;
	}
	public String getQuoteDigest()
	{
		return QuoteDigest;
	}
	public void setQuoteDigest(String value)
	{
		QuoteDigest = value;
	}
	public long getQuoteUpdateTime()
	{
		return QuoteUpdateTime;
	}
	public void setQuoteUpdateTime(long value)
	{
		QuoteUpdateTime = value;
	}
	public BV_HIST_MEMBER_INFO getAggressor()
	{
		return Aggressor;
	}
	public void setAggressor(BV_HIST_MEMBER_INFO value)
	{
		Aggressor = value;
	}
	public BV_HIST_MEMBER_INFO getProvider()
	{
		return Provider;
	}
	public void setProvider(BV_HIST_MEMBER_INFO value)
	{
		Provider = value;
	}
	public BV_HIST_INSTRUMENT_INFO getInstrument()
	{
		return Instrument;
	}
	public void setInstrument(BV_HIST_INSTRUMENT_INFO value)
	{
		Instrument = value;
	}
	public BV_INVENTORY_ORDER_STATUS_Enum getStatus()
	{
		return Status;
	}
	public void setStatus(BV_INVENTORY_ORDER_STATUS_Enum value)
	{
		Status = value;
	}
	public double getPrice()
	{
		return Price;
	}
	public void setPrice(double value)
	{
		Price = value;
	}
	public double getYield()
	{
		return Yield;
	}
	public void setYield(double value)
	{
		Yield = value;
	}
	public double getQty()
	{
		return Qty;
	}
	public void setQty(double value)
	{
		Qty = value;
	}
	public TI_VERB_Enum getVerb()
	{
		return Verb;
	}
	public void setVerb(TI_VERB_Enum value)
	{
		Verb = value;
	}
	public long getAcceptanceTimeout()
	{
		return AcceptanceTimeout;
	}
	public void setAcceptanceTimeout(long value)
	{
		AcceptanceTimeout = value;
	}
	public double getPrincipal()
	{
		return Principal;
	}
	public void setPrincipal(double value)
	{
		Principal = value;
	}
	public double getNominalValue()
	{
		return NominalValue;
	}
	public void setNominalValue(double value)
	{
		NominalValue = value;
	}
	public double getAccrued()
	{
		return Accrued;
	}
	public void setAccrued(double value)
	{
		Accrued = value;
	}
	public String getCurrency()
	{
		return Currency;
	}
	public void setCurrency(String value)
	{
		Currency = value;
	}
	public short getAccrualDays()
	{
		return AccrualDays;
	}
	public void setAccrualDays(short value)
	{
		AccrualDays = value;
	}
	public double getBpv()
	{
		return Bpv;
	}
	public void setBpv(double value)
	{
		Bpv = value;
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
	public BV_SETTLEMENT_MODE_Enum getSettlementMode()
	{
		return SettlementMode;
	}
	public void setSettlementMode(BV_SETTLEMENT_MODE_Enum value)
	{
		SettlementMode = value;
	}
	public BV_EXEC_SETTLEMENT_MODE_Enum getExecSettlementMode()
	{
		return ExecSettlementMode;
	}
	public void setExecSettlementMode(BV_EXEC_SETTLEMENT_MODE_Enum value)
	{
		ExecSettlementMode = value;
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
	public String getClientExecID()
	{
		return ClientExecID;
	}
	public void setClientExecID(String value)
	{
		ClientExecID = value;
	}
	public TI_ALLOCATION_TYPE_Enum getAllocationType()
	{
		return AllocationType;
	}
	public void setAllocationType(TI_ALLOCATION_TYPE_Enum value)
	{
		AllocationType = value;
	}
	public long getAllocationId()
	{
		return AllocationId;
	}
	public void setAllocationId(long value)
	{
		AllocationId = value;
	}
	public String getAccountCode()
	{
		return AccountCode;
	}
	public void setAccountCode(String value)
	{
		AccountCode = value;
	}
	public String getAccountInfo()
	{
		return AccountInfo;
	}
	public void setAccountInfo(String value)
	{
		AccountInfo = value;
	}
	public String getSettlementInfo()
	{
		return SettlementInfo;
	}
	public void setSettlementInfo(String value)
	{
		SettlementInfo = value;
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
	public short getNextOrderDenialTime()
	{
		return NextOrderDenialTime;
	}
	public void setNextOrderDenialTime(short value)
	{
		NextOrderDenialTime = value;
	}
	public BV_INVENTORY_TRADING_INFO[] getBidDepth()
	{
		return BidDepth;
	}
	public void setBidDepth(BV_INVENTORY_TRADING_INFO[] value)
	{
		BidDepth = value;
	}
	public BV_INVENTORY_TRADING_INFO[] getAskDepth()
	{
		return AskDepth;
	}
	public void setAskDepth(BV_INVENTORY_TRADING_INFO[] value)
	{
		AskDepth = value;
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
	public long getDealId()
	{
		return DealId;
	}
	public void setDealId(long value)
	{
		DealId = value;
	}
	public BV_TRANSPARENCY_INFO getTransparencyInfo()
	{
		return TransparencyInfo;
	}
	public void setTransparencyInfo(BV_TRANSPARENCY_INFO value)
	{
		TransparencyInfo = value;
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
	public BV_SHORT_SELLING_INDICATOR_Enum getShortSellingIndicator()
	{
		return ShortSellingIndicator;
	}
	public void setShortSellingIndicator(BV_SHORT_SELLING_INDICATOR_Enum value)
	{
		ShortSellingIndicator = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		OrderMsgInfo.readXDR(byteBuffer);
		SectionCode = byteBuffer.readString();
		InventoryQuoteId = (long)byteBuffer.readInt();
		DealerReferenceId = byteBuffer.readString();
		QuoteDigest = byteBuffer.readString();
		QuoteUpdateTime = byteBuffer.readLong();
		Aggressor.readXDR(byteBuffer);
		Provider.readXDR(byteBuffer);
		Instrument.readXDR(byteBuffer);
		Status = Status.getEnum(byteBuffer.readInt());
		Price = byteBuffer.readDouble();
		Yield = byteBuffer.readDouble();
		Qty = byteBuffer.readDouble();
		Verb = Verb.getEnum(byteBuffer.readInt());
		AcceptanceTimeout = byteBuffer.readLong();
		Principal = byteBuffer.readDouble();
		NominalValue = byteBuffer.readDouble();
		Accrued = byteBuffer.readDouble();
		Currency = byteBuffer.readString();
		AccrualDays = (short)byteBuffer.readInt();
		Bpv = byteBuffer.readDouble();
		SettlementOffset = (short)byteBuffer.readInt();
		SettlementDate = (long)byteBuffer.readInt();
		SettlementMode = SettlementMode.getEnum(byteBuffer.readInt());
		ExecSettlementMode = ExecSettlementMode.getEnum(byteBuffer.readInt());
		StageOrderId = (long)byteBuffer.readInt();
		ClientOrderId = byteBuffer.readString();
		ClientExecID = byteBuffer.readString();
		AllocationType = AllocationType.getEnum(byteBuffer.readInt());
		AllocationId = (long)byteBuffer.readInt();
		AccountCode = byteBuffer.readString();
		AccountInfo = byteBuffer.readString();
		SettlementInfo = byteBuffer.readString();
		MktAffiliationShortDesc = byteBuffer.readString();
		MktAffiliationDesc = byteBuffer.readString();
		UserInfo1 = byteBuffer.readString();
		UserInfo2 = byteBuffer.readString();
		NextOrderDenialTime = (short)byteBuffer.readInt();
		for (int i=0; i < BidDepth.length; ++i)
		{
			BidDepth[i].readXDR(byteBuffer);
		}
		for (int i=0; i < AskDepth.length; ++i)
		{
			AskDepth[i].readXDR(byteBuffer);
		}
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
		DealId = (long)byteBuffer.readInt();
		TransparencyInfo.readXDR(byteBuffer);
		CreationDate = (long)byteBuffer.readInt();
		CreationTime = byteBuffer.readLong();
		UpdateTime = byteBuffer.readLong();
		ShortSellingIndicator = ShortSellingIndicator.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		OrderMsgInfo.writeXDR(byteBuffer);
		byteBuffer.writeString(SectionCode);
		byteBuffer.writeInt((int)(InventoryQuoteId & 0xFFFFFFFFL));
		byteBuffer.writeString(DealerReferenceId);
		byteBuffer.writeString(QuoteDigest);
		byteBuffer.writeLong(QuoteUpdateTime);
		Aggressor.writeXDR(byteBuffer);
		Provider.writeXDR(byteBuffer);
		Instrument.writeXDR(byteBuffer);
		byteBuffer.writeInt(Status.getValue());
		byteBuffer.writeDouble(Price);
		byteBuffer.writeDouble(Yield);
		byteBuffer.writeDouble(Qty);
		byteBuffer.writeInt(Verb.getValue());
		byteBuffer.writeLong(AcceptanceTimeout);
		byteBuffer.writeDouble(Principal);
		byteBuffer.writeDouble(NominalValue);
		byteBuffer.writeDouble(Accrued);
		byteBuffer.writeString(Currency);
		byteBuffer.writeInt((int)(AccrualDays & 0xFFFFL));
		byteBuffer.writeDouble(Bpv);
		byteBuffer.writeInt((int)(SettlementOffset & 0xFFFFL));
		byteBuffer.writeInt((int)(SettlementDate & 0xFFFFFFFFL));
		byteBuffer.writeInt(SettlementMode.getValue());
		byteBuffer.writeInt(ExecSettlementMode.getValue());
		byteBuffer.writeInt((int)(StageOrderId & 0xFFFFFFFFL));
		byteBuffer.writeString(ClientOrderId);
		byteBuffer.writeString(ClientExecID);
		byteBuffer.writeInt(AllocationType.getValue());
		byteBuffer.writeInt((int)(AllocationId & 0xFFFFFFFFL));
		byteBuffer.writeString(AccountCode);
		byteBuffer.writeString(AccountInfo);
		byteBuffer.writeString(SettlementInfo);
		byteBuffer.writeString(MktAffiliationShortDesc);
		byteBuffer.writeString(MktAffiliationDesc);
		byteBuffer.writeString(UserInfo1);
		byteBuffer.writeString(UserInfo2);
		byteBuffer.writeInt((int)(NextOrderDenialTime & 0xFFFFL));
		for (int i=0; i < BidDepth.length; ++i)
		{
			BidDepth[i].writeXDR(byteBuffer);
		}
		for (int i=0; i < AskDepth.length; ++i)
		{
			AskDepth[i].writeXDR(byteBuffer);
		}
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
		byteBuffer.writeInt((int)(DealId & 0xFFFFFFFFL));
		TransparencyInfo.writeXDR(byteBuffer);
		byteBuffer.writeInt((int)(CreationDate & 0xFFFFFFFFL));
		byteBuffer.writeLong(CreationTime);
		byteBuffer.writeLong(UpdateTime);
		byteBuffer.writeInt(ShortSellingIndicator.getValue());

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
		stringBuilder.append("BV_HIST_BUY_SIDE_INVENTORY_ORDER::");
		stringBuilder.append("OrderMsgInfo(").append(OrderMsgInfo.toString()).append(")");
		stringBuilder.append("SectionCode(").append(SectionCode).append(")");
		stringBuilder.append("InventoryQuoteId(").append(InventoryQuoteId).append(")");
		stringBuilder.append("DealerReferenceId(").append(DealerReferenceId).append(")");
		stringBuilder.append("QuoteDigest(").append(QuoteDigest).append(")");
		stringBuilder.append("QuoteUpdateTime(").append(QuoteUpdateTime).append(")");
		stringBuilder.append("Aggressor(").append(Aggressor.toString()).append(")");
		stringBuilder.append("Provider(").append(Provider.toString()).append(")");
		stringBuilder.append("Instrument(").append(Instrument.toString()).append(")");
		stringBuilder.append("Status(").append(Status).append(")");
		stringBuilder.append("Price(").append(Price).append(")");
		stringBuilder.append("Yield(").append(Yield).append(")");
		stringBuilder.append("Qty(").append(Qty).append(")");
		stringBuilder.append("Verb(").append(Verb).append(")");
		stringBuilder.append("AcceptanceTimeout(").append(AcceptanceTimeout).append(")");
		stringBuilder.append("Principal(").append(Principal).append(")");
		stringBuilder.append("NominalValue(").append(NominalValue).append(")");
		stringBuilder.append("Accrued(").append(Accrued).append(")");
		stringBuilder.append("Currency(").append(Currency).append(")");
		stringBuilder.append("AccrualDays(").append(AccrualDays).append(")");
		stringBuilder.append("Bpv(").append(Bpv).append(")");
		stringBuilder.append("SettlementOffset(").append(SettlementOffset).append(")");
		stringBuilder.append("SettlementDate(").append(SettlementDate).append(")");
		stringBuilder.append("SettlementMode(").append(SettlementMode).append(")");
		stringBuilder.append("ExecSettlementMode(").append(ExecSettlementMode).append(")");
		stringBuilder.append("StageOrderId(").append(StageOrderId).append(")");
		stringBuilder.append("ClientOrderId(").append(ClientOrderId).append(")");
		stringBuilder.append("ClientExecID(").append(ClientExecID).append(")");
		stringBuilder.append("AllocationType(").append(AllocationType).append(")");
		stringBuilder.append("AllocationId(").append(AllocationId).append(")");
		stringBuilder.append("AccountCode(").append(AccountCode).append(")");
		stringBuilder.append("AccountInfo(").append(AccountInfo).append(")");
		stringBuilder.append("SettlementInfo(").append(SettlementInfo).append(")");
		stringBuilder.append("MktAffiliationShortDesc(").append(MktAffiliationShortDesc).append(")");
		stringBuilder.append("MktAffiliationDesc(").append(MktAffiliationDesc).append(")");
		stringBuilder.append("UserInfo1(").append(UserInfo1).append(")");
		stringBuilder.append("UserInfo2(").append(UserInfo2).append(")");
		stringBuilder.append("NextOrderDenialTime(").append(NextOrderDenialTime).append(")");
		for (int i=0; i < BidDepth.length; ++i)
		{
			stringBuilder.append("BidDepth[").append(i).append("](").append(BidDepth[i].toString()).append(")");
		}
		for (int i=0; i < AskDepth.length; ++i)
		{
			stringBuilder.append("AskDepth[").append(i).append("](").append(AskDepth[i].toString()).append(")");
		}
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
		stringBuilder.append("DealId(").append(DealId).append(")");
		stringBuilder.append("TransparencyInfo(").append(TransparencyInfo.toString()).append(")");
		stringBuilder.append("CreationDate(").append(CreationDate).append(")");
		stringBuilder.append("CreationTime(").append(CreationTime).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		stringBuilder.append("ShortSellingIndicator(").append(ShortSellingIndicator).append(")");
		return stringBuilder.toString();
	}
}
