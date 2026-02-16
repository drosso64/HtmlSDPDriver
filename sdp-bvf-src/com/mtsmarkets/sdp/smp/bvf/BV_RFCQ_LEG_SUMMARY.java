package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_RFCQ_LEG_SUMMARY extends SMPMessage
{
	public static final long CLASS_ID = 114933;

	private long InstrumentId = 0;
	private String InstrumentIsinCode = "";
	private String InstrumentDescription = "";
	private String SectionCode = "";
	private String InstrumentClassCode = "";
	private TI_VERB_Enum Verb = TI_VERB_Enum.TI_VERB_Buy;
	private double Quantity = 0;
	private double MinQty = 0;
	private double ExecutedQuantity = 0;
	private double NominalValue = 0;
	private long DealId = 0;
	private double Price = 0;
	private double Yield = 0;
	private long SettlementDate = 0;
	private short SettlementOffset = 0;
	private double Principal = 0;
	private double Accrued = 0;
	private short AccrualDays = 0;
	private String Currency = "";
	private double Bpv = 0;
	private TI_ALLOCATION_TYPE_Enum AllocationType = TI_ALLOCATION_TYPE_Enum.TI_ALLOCATION_TYPE_Unspecified;
	private long AllocationId = 0;
	private String AccountCode = "";
	private String AccountInfo = "";
	private long StageOrderNr = 0;
	private String ClientOrderId = "";
	private String SettlementInfo = "";
	private double ModDuration = 0;
	private TI_FLAG_Enum QuotationFg = TI_FLAG_Enum.TI_FLAG_No;
	private double Quotation = 0;
	private TI_FLAG_Enum DiscloseIOIFg = TI_FLAG_Enum.TI_FLAG_No;
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
	private String BenchmarkISINCode = "";
	private String BenchmarkDescription = "";
	private double BenchmarkPrice = 0;
	private double BenchmarkYield = 0;
	private double BenchmarkSpreadValue = 0;
	private BV_SHORT_SELLING_INDICATOR_Enum ShortSellingIndicator = BV_SHORT_SELLING_INDICATOR_Enum.BV_SHORT_SELLING_INDICATOR_None;
	private String MicCode = "";
	private BV_TRANSPARENCY_INFO TransparencyInfo = new BV_TRANSPARENCY_INFO();

	public BV_RFCQ_LEG_SUMMARY()
	{
	}

	public long getInstrumentId()
	{
		return InstrumentId;
	}
	public void setInstrumentId(long value)
	{
		InstrumentId = value;
	}
	public String getInstrumentIsinCode()
	{
		return InstrumentIsinCode;
	}
	public void setInstrumentIsinCode(String value)
	{
		InstrumentIsinCode = value;
	}
	public String getInstrumentDescription()
	{
		return InstrumentDescription;
	}
	public void setInstrumentDescription(String value)
	{
		InstrumentDescription = value;
	}
	public String getSectionCode()
	{
		return SectionCode;
	}
	public void setSectionCode(String value)
	{
		SectionCode = value;
	}
	public String getInstrumentClassCode()
	{
		return InstrumentClassCode;
	}
	public void setInstrumentClassCode(String value)
	{
		InstrumentClassCode = value;
	}
	public TI_VERB_Enum getVerb()
	{
		return Verb;
	}
	public void setVerb(TI_VERB_Enum value)
	{
		Verb = value;
	}
	public double getQuantity()
	{
		return Quantity;
	}
	public void setQuantity(double value)
	{
		Quantity = value;
	}
	public double getMinQty()
	{
		return MinQty;
	}
	public void setMinQty(double value)
	{
		MinQty = value;
	}
	public double getExecutedQuantity()
	{
		return ExecutedQuantity;
	}
	public void setExecutedQuantity(double value)
	{
		ExecutedQuantity = value;
	}
	public double getNominalValue()
	{
		return NominalValue;
	}
	public void setNominalValue(double value)
	{
		NominalValue = value;
	}
	public long getDealId()
	{
		return DealId;
	}
	public void setDealId(long value)
	{
		DealId = value;
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
	public long getSettlementDate()
	{
		return SettlementDate;
	}
	public void setSettlementDate(long value)
	{
		SettlementDate = value;
	}
	public short getSettlementOffset()
	{
		return SettlementOffset;
	}
	public void setSettlementOffset(short value)
	{
		SettlementOffset = value;
	}
	public double getPrincipal()
	{
		return Principal;
	}
	public void setPrincipal(double value)
	{
		Principal = value;
	}
	public double getAccrued()
	{
		return Accrued;
	}
	public void setAccrued(double value)
	{
		Accrued = value;
	}
	public short getAccrualDays()
	{
		return AccrualDays;
	}
	public void setAccrualDays(short value)
	{
		AccrualDays = value;
	}
	public String getCurrency()
	{
		return Currency;
	}
	public void setCurrency(String value)
	{
		Currency = value;
	}
	public double getBpv()
	{
		return Bpv;
	}
	public void setBpv(double value)
	{
		Bpv = value;
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
	public long getStageOrderNr()
	{
		return StageOrderNr;
	}
	public void setStageOrderNr(long value)
	{
		StageOrderNr = value;
	}
	public String getClientOrderId()
	{
		return ClientOrderId;
	}
	public void setClientOrderId(String value)
	{
		ClientOrderId = value;
	}
	public String getSettlementInfo()
	{
		return SettlementInfo;
	}
	public void setSettlementInfo(String value)
	{
		SettlementInfo = value;
	}
	public double getModDuration()
	{
		return ModDuration;
	}
	public void setModDuration(double value)
	{
		ModDuration = value;
	}
	public TI_FLAG_Enum getQuotationFg()
	{
		return QuotationFg;
	}
	public void setQuotationFg(TI_FLAG_Enum value)
	{
		QuotationFg = value;
	}
	public double getQuotation()
	{
		return Quotation;
	}
	public void setQuotation(double value)
	{
		Quotation = value;
	}
	public TI_FLAG_Enum getDiscloseIOIFg()
	{
		return DiscloseIOIFg;
	}
	public void setDiscloseIOIFg(TI_FLAG_Enum value)
	{
		DiscloseIOIFg = value;
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
	public String getBenchmarkISINCode()
	{
		return BenchmarkISINCode;
	}
	public void setBenchmarkISINCode(String value)
	{
		BenchmarkISINCode = value;
	}
	public String getBenchmarkDescription()
	{
		return BenchmarkDescription;
	}
	public void setBenchmarkDescription(String value)
	{
		BenchmarkDescription = value;
	}
	public double getBenchmarkPrice()
	{
		return BenchmarkPrice;
	}
	public void setBenchmarkPrice(double value)
	{
		BenchmarkPrice = value;
	}
	public double getBenchmarkYield()
	{
		return BenchmarkYield;
	}
	public void setBenchmarkYield(double value)
	{
		BenchmarkYield = value;
	}
	public double getBenchmarkSpreadValue()
	{
		return BenchmarkSpreadValue;
	}
	public void setBenchmarkSpreadValue(double value)
	{
		BenchmarkSpreadValue = value;
	}
	public BV_SHORT_SELLING_INDICATOR_Enum getShortSellingIndicator()
	{
		return ShortSellingIndicator;
	}
	public void setShortSellingIndicator(BV_SHORT_SELLING_INDICATOR_Enum value)
	{
		ShortSellingIndicator = value;
	}
	public String getMicCode()
	{
		return MicCode;
	}
	public void setMicCode(String value)
	{
		MicCode = value;
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
		InstrumentId = (long)byteBuffer.readInt();
		InstrumentIsinCode = byteBuffer.readString();
		InstrumentDescription = byteBuffer.readString();
		SectionCode = byteBuffer.readString();
		InstrumentClassCode = byteBuffer.readString();
		Verb = Verb.getEnum(byteBuffer.readInt());
		Quantity = byteBuffer.readDouble();
		MinQty = byteBuffer.readDouble();
		ExecutedQuantity = byteBuffer.readDouble();
		NominalValue = byteBuffer.readDouble();
		DealId = (long)byteBuffer.readInt();
		Price = byteBuffer.readDouble();
		Yield = byteBuffer.readDouble();
		SettlementDate = (long)byteBuffer.readInt();
		SettlementOffset = (short)byteBuffer.readInt();
		Principal = byteBuffer.readDouble();
		Accrued = byteBuffer.readDouble();
		AccrualDays = (short)byteBuffer.readInt();
		Currency = byteBuffer.readString();
		Bpv = byteBuffer.readDouble();
		AllocationType = AllocationType.getEnum(byteBuffer.readInt());
		AllocationId = (long)byteBuffer.readInt();
		AccountCode = byteBuffer.readString();
		AccountInfo = byteBuffer.readString();
		StageOrderNr = (long)byteBuffer.readInt();
		ClientOrderId = byteBuffer.readString();
		SettlementInfo = byteBuffer.readString();
		ModDuration = byteBuffer.readDouble();
		QuotationFg = QuotationFg.getEnum(byteBuffer.readInt());
		Quotation = byteBuffer.readDouble();
		DiscloseIOIFg = DiscloseIOIFg.getEnum(byteBuffer.readInt());
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
		BenchmarkISINCode = byteBuffer.readString();
		BenchmarkDescription = byteBuffer.readString();
		BenchmarkPrice = byteBuffer.readDouble();
		BenchmarkYield = byteBuffer.readDouble();
		BenchmarkSpreadValue = byteBuffer.readDouble();
		ShortSellingIndicator = ShortSellingIndicator.getEnum(byteBuffer.readInt());
		MicCode = byteBuffer.readString();
		TransparencyInfo.readXDR(byteBuffer);
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(InstrumentId & 0xFFFFFFFFL));
		byteBuffer.writeString(InstrumentIsinCode);
		byteBuffer.writeString(InstrumentDescription);
		byteBuffer.writeString(SectionCode);
		byteBuffer.writeString(InstrumentClassCode);
		byteBuffer.writeInt(Verb.getValue());
		byteBuffer.writeDouble(Quantity);
		byteBuffer.writeDouble(MinQty);
		byteBuffer.writeDouble(ExecutedQuantity);
		byteBuffer.writeDouble(NominalValue);
		byteBuffer.writeInt((int)(DealId & 0xFFFFFFFFL));
		byteBuffer.writeDouble(Price);
		byteBuffer.writeDouble(Yield);
		byteBuffer.writeInt((int)(SettlementDate & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SettlementOffset & 0xFFFFL));
		byteBuffer.writeDouble(Principal);
		byteBuffer.writeDouble(Accrued);
		byteBuffer.writeInt((int)(AccrualDays & 0xFFFFL));
		byteBuffer.writeString(Currency);
		byteBuffer.writeDouble(Bpv);
		byteBuffer.writeInt(AllocationType.getValue());
		byteBuffer.writeInt((int)(AllocationId & 0xFFFFFFFFL));
		byteBuffer.writeString(AccountCode);
		byteBuffer.writeString(AccountInfo);
		byteBuffer.writeInt((int)(StageOrderNr & 0xFFFFFFFFL));
		byteBuffer.writeString(ClientOrderId);
		byteBuffer.writeString(SettlementInfo);
		byteBuffer.writeDouble(ModDuration);
		byteBuffer.writeInt(QuotationFg.getValue());
		byteBuffer.writeDouble(Quotation);
		byteBuffer.writeInt(DiscloseIOIFg.getValue());
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
		byteBuffer.writeString(BenchmarkISINCode);
		byteBuffer.writeString(BenchmarkDescription);
		byteBuffer.writeDouble(BenchmarkPrice);
		byteBuffer.writeDouble(BenchmarkYield);
		byteBuffer.writeDouble(BenchmarkSpreadValue);
		byteBuffer.writeInt(ShortSellingIndicator.getValue());
		byteBuffer.writeString(MicCode);
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
		stringBuilder.append("BV_RFCQ_LEG_SUMMARY::");
		stringBuilder.append("InstrumentId(").append(InstrumentId).append(")");
		stringBuilder.append("InstrumentIsinCode(").append(InstrumentIsinCode).append(")");
		stringBuilder.append("InstrumentDescription(").append(InstrumentDescription).append(")");
		stringBuilder.append("SectionCode(").append(SectionCode).append(")");
		stringBuilder.append("InstrumentClassCode(").append(InstrumentClassCode).append(")");
		stringBuilder.append("Verb(").append(Verb).append(")");
		stringBuilder.append("Quantity(").append(Quantity).append(")");
		stringBuilder.append("MinQty(").append(MinQty).append(")");
		stringBuilder.append("ExecutedQuantity(").append(ExecutedQuantity).append(")");
		stringBuilder.append("NominalValue(").append(NominalValue).append(")");
		stringBuilder.append("DealId(").append(DealId).append(")");
		stringBuilder.append("Price(").append(Price).append(")");
		stringBuilder.append("Yield(").append(Yield).append(")");
		stringBuilder.append("SettlementDate(").append(SettlementDate).append(")");
		stringBuilder.append("SettlementOffset(").append(SettlementOffset).append(")");
		stringBuilder.append("Principal(").append(Principal).append(")");
		stringBuilder.append("Accrued(").append(Accrued).append(")");
		stringBuilder.append("AccrualDays(").append(AccrualDays).append(")");
		stringBuilder.append("Currency(").append(Currency).append(")");
		stringBuilder.append("Bpv(").append(Bpv).append(")");
		stringBuilder.append("AllocationType(").append(AllocationType).append(")");
		stringBuilder.append("AllocationId(").append(AllocationId).append(")");
		stringBuilder.append("AccountCode(").append(AccountCode).append(")");
		stringBuilder.append("AccountInfo(").append(AccountInfo).append(")");
		stringBuilder.append("StageOrderNr(").append(StageOrderNr).append(")");
		stringBuilder.append("ClientOrderId(").append(ClientOrderId).append(")");
		stringBuilder.append("SettlementInfo(").append(SettlementInfo).append(")");
		stringBuilder.append("ModDuration(").append(ModDuration).append(")");
		stringBuilder.append("QuotationFg(").append(QuotationFg).append(")");
		stringBuilder.append("Quotation(").append(Quotation).append(")");
		stringBuilder.append("DiscloseIOIFg(").append(DiscloseIOIFg).append(")");
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
		stringBuilder.append("BenchmarkISINCode(").append(BenchmarkISINCode).append(")");
		stringBuilder.append("BenchmarkDescription(").append(BenchmarkDescription).append(")");
		stringBuilder.append("BenchmarkPrice(").append(BenchmarkPrice).append(")");
		stringBuilder.append("BenchmarkYield(").append(BenchmarkYield).append(")");
		stringBuilder.append("BenchmarkSpreadValue(").append(BenchmarkSpreadValue).append(")");
		stringBuilder.append("ShortSellingIndicator(").append(ShortSellingIndicator).append(")");
		stringBuilder.append("MicCode(").append(MicCode).append(")");
		stringBuilder.append("TransparencyInfo(").append(TransparencyInfo.toString()).append(")");
		return stringBuilder.toString();
	}
}
