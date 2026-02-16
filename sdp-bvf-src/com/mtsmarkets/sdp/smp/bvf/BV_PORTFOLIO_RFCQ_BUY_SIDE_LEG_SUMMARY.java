package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_PORTFOLIO_RFCQ_BUY_SIDE_LEG_SUMMARY extends SMPMessage
{
	public static final long CLASS_ID = 410029;

	private long InstrumentId = 0;
	private String InstrumentIsinCode = "";
	private String InstrumentDescription = "";
	private String InstrumentClassCode = "";
	private TI_VERB_Enum Verb = TI_VERB_Enum.TI_VERB_Buy;
	private long SettlementDate = 0;
	private short SettlementOffset = 0;
	private double Quantity = 0;
	private double NominalValue = 0;
	private long DealId = 0;
	private double Price = 0;
	private BV_VALUE Yield = new BV_VALUE();
	private double Countervalue = 0;
	private double Principal = 0;
	private double Proceeds = 0;
	private double Accrued = 0;
	private short AccrualDays = 0;
	private String Currency = "";
	private TI_ALLOCATION_TYPE_Enum AllocationType = TI_ALLOCATION_TYPE_Enum.TI_ALLOCATION_TYPE_Unspecified;
	private long AllocationId = 0;
	private String AccountCode = "";
	private String AccountInfo = "";
	private long StageOrderNr = 0;
	private String ClientOrderId = "";
	private double ReferenceLevelPrice = 0;
	private BV_VALUE ReferenceLevelYield = new BV_VALUE();
	private String SettlementInfo = "";
	private double BVBestMidPrice = 0;
	private double BVBestMidYield = 0;
	private double BVBestMidProceeds = 0;
	private double Bpv = 0;
	private double Markup = 0;
	private BV_SHORT_SELLING_INDICATOR_Enum ShortSellingIndicator = BV_SHORT_SELLING_INDICATOR_Enum.BV_SHORT_SELLING_INDICATOR_None;
	private BV_ALGO_INFO AlgoInfo = new BV_ALGO_INFO();
	private BV_CLIENT_IDENTIFICATION_INFO ClientIdentificationInfo = new BV_CLIENT_IDENTIFICATION_INFO();
	private String MicCode = "";
	private BV_TRANSPARENCY_INFO TransparencyInfo = new BV_TRANSPARENCY_INFO();

	public BV_PORTFOLIO_RFCQ_BUY_SIDE_LEG_SUMMARY()
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
	public double getQuantity()
	{
		return Quantity;
	}
	public void setQuantity(double value)
	{
		Quantity = value;
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
	public BV_VALUE getYield()
	{
		return Yield;
	}
	public void setYield(BV_VALUE value)
	{
		Yield = value;
	}
	public double getCountervalue()
	{
		return Countervalue;
	}
	public void setCountervalue(double value)
	{
		Countervalue = value;
	}
	public double getPrincipal()
	{
		return Principal;
	}
	public void setPrincipal(double value)
	{
		Principal = value;
	}
	public double getProceeds()
	{
		return Proceeds;
	}
	public void setProceeds(double value)
	{
		Proceeds = value;
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
	public double getReferenceLevelPrice()
	{
		return ReferenceLevelPrice;
	}
	public void setReferenceLevelPrice(double value)
	{
		ReferenceLevelPrice = value;
	}
	public BV_VALUE getReferenceLevelYield()
	{
		return ReferenceLevelYield;
	}
	public void setReferenceLevelYield(BV_VALUE value)
	{
		ReferenceLevelYield = value;
	}
	public String getSettlementInfo()
	{
		return SettlementInfo;
	}
	public void setSettlementInfo(String value)
	{
		SettlementInfo = value;
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
	public double getBVBestMidProceeds()
	{
		return BVBestMidProceeds;
	}
	public void setBVBestMidProceeds(double value)
	{
		BVBestMidProceeds = value;
	}
	public double getBpv()
	{
		return Bpv;
	}
	public void setBpv(double value)
	{
		Bpv = value;
	}
	public double getMarkup()
	{
		return Markup;
	}
	public void setMarkup(double value)
	{
		Markup = value;
	}
	public BV_SHORT_SELLING_INDICATOR_Enum getShortSellingIndicator()
	{
		return ShortSellingIndicator;
	}
	public void setShortSellingIndicator(BV_SHORT_SELLING_INDICATOR_Enum value)
	{
		ShortSellingIndicator = value;
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
		InstrumentClassCode = byteBuffer.readString();
		Verb = Verb.getEnum(byteBuffer.readInt());
		SettlementDate = (long)byteBuffer.readInt();
		SettlementOffset = (short)byteBuffer.readInt();
		Quantity = byteBuffer.readDouble();
		NominalValue = byteBuffer.readDouble();
		DealId = (long)byteBuffer.readInt();
		Price = byteBuffer.readDouble();
		Yield.readXDR(byteBuffer);
		Countervalue = byteBuffer.readDouble();
		Principal = byteBuffer.readDouble();
		Proceeds = byteBuffer.readDouble();
		Accrued = byteBuffer.readDouble();
		AccrualDays = (short)byteBuffer.readInt();
		Currency = byteBuffer.readString();
		AllocationType = AllocationType.getEnum(byteBuffer.readInt());
		AllocationId = (long)byteBuffer.readInt();
		AccountCode = byteBuffer.readString();
		AccountInfo = byteBuffer.readString();
		StageOrderNr = (long)byteBuffer.readInt();
		ClientOrderId = byteBuffer.readString();
		ReferenceLevelPrice = byteBuffer.readDouble();
		ReferenceLevelYield.readXDR(byteBuffer);
		SettlementInfo = byteBuffer.readString();
		BVBestMidPrice = byteBuffer.readDouble();
		BVBestMidYield = byteBuffer.readDouble();
		BVBestMidProceeds = byteBuffer.readDouble();
		Bpv = byteBuffer.readDouble();
		Markup = byteBuffer.readDouble();
		ShortSellingIndicator = ShortSellingIndicator.getEnum(byteBuffer.readInt());
		AlgoInfo.readXDR(byteBuffer);
		ClientIdentificationInfo.readXDR(byteBuffer);
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
		byteBuffer.writeString(InstrumentClassCode);
		byteBuffer.writeInt(Verb.getValue());
		byteBuffer.writeInt((int)(SettlementDate & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SettlementOffset & 0xFFFFL));
		byteBuffer.writeDouble(Quantity);
		byteBuffer.writeDouble(NominalValue);
		byteBuffer.writeInt((int)(DealId & 0xFFFFFFFFL));
		byteBuffer.writeDouble(Price);
		Yield.writeXDR(byteBuffer);
		byteBuffer.writeDouble(Countervalue);
		byteBuffer.writeDouble(Principal);
		byteBuffer.writeDouble(Proceeds);
		byteBuffer.writeDouble(Accrued);
		byteBuffer.writeInt((int)(AccrualDays & 0xFFFFL));
		byteBuffer.writeString(Currency);
		byteBuffer.writeInt(AllocationType.getValue());
		byteBuffer.writeInt((int)(AllocationId & 0xFFFFFFFFL));
		byteBuffer.writeString(AccountCode);
		byteBuffer.writeString(AccountInfo);
		byteBuffer.writeInt((int)(StageOrderNr & 0xFFFFFFFFL));
		byteBuffer.writeString(ClientOrderId);
		byteBuffer.writeDouble(ReferenceLevelPrice);
		ReferenceLevelYield.writeXDR(byteBuffer);
		byteBuffer.writeString(SettlementInfo);
		byteBuffer.writeDouble(BVBestMidPrice);
		byteBuffer.writeDouble(BVBestMidYield);
		byteBuffer.writeDouble(BVBestMidProceeds);
		byteBuffer.writeDouble(Bpv);
		byteBuffer.writeDouble(Markup);
		byteBuffer.writeInt(ShortSellingIndicator.getValue());
		AlgoInfo.writeXDR(byteBuffer);
		ClientIdentificationInfo.writeXDR(byteBuffer);
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
		stringBuilder.append("BV_PORTFOLIO_RFCQ_BUY_SIDE_LEG_SUMMARY::");
		stringBuilder.append("InstrumentId(").append(InstrumentId).append(")");
		stringBuilder.append("InstrumentIsinCode(").append(InstrumentIsinCode).append(")");
		stringBuilder.append("InstrumentDescription(").append(InstrumentDescription).append(")");
		stringBuilder.append("InstrumentClassCode(").append(InstrumentClassCode).append(")");
		stringBuilder.append("Verb(").append(Verb).append(")");
		stringBuilder.append("SettlementDate(").append(SettlementDate).append(")");
		stringBuilder.append("SettlementOffset(").append(SettlementOffset).append(")");
		stringBuilder.append("Quantity(").append(Quantity).append(")");
		stringBuilder.append("NominalValue(").append(NominalValue).append(")");
		stringBuilder.append("DealId(").append(DealId).append(")");
		stringBuilder.append("Price(").append(Price).append(")");
		stringBuilder.append("Yield(").append(Yield.toString()).append(")");
		stringBuilder.append("Countervalue(").append(Countervalue).append(")");
		stringBuilder.append("Principal(").append(Principal).append(")");
		stringBuilder.append("Proceeds(").append(Proceeds).append(")");
		stringBuilder.append("Accrued(").append(Accrued).append(")");
		stringBuilder.append("AccrualDays(").append(AccrualDays).append(")");
		stringBuilder.append("Currency(").append(Currency).append(")");
		stringBuilder.append("AllocationType(").append(AllocationType).append(")");
		stringBuilder.append("AllocationId(").append(AllocationId).append(")");
		stringBuilder.append("AccountCode(").append(AccountCode).append(")");
		stringBuilder.append("AccountInfo(").append(AccountInfo).append(")");
		stringBuilder.append("StageOrderNr(").append(StageOrderNr).append(")");
		stringBuilder.append("ClientOrderId(").append(ClientOrderId).append(")");
		stringBuilder.append("ReferenceLevelPrice(").append(ReferenceLevelPrice).append(")");
		stringBuilder.append("ReferenceLevelYield(").append(ReferenceLevelYield.toString()).append(")");
		stringBuilder.append("SettlementInfo(").append(SettlementInfo).append(")");
		stringBuilder.append("BVBestMidPrice(").append(BVBestMidPrice).append(")");
		stringBuilder.append("BVBestMidYield(").append(BVBestMidYield).append(")");
		stringBuilder.append("BVBestMidProceeds(").append(BVBestMidProceeds).append(")");
		stringBuilder.append("Bpv(").append(Bpv).append(")");
		stringBuilder.append("Markup(").append(Markup).append(")");
		stringBuilder.append("ShortSellingIndicator(").append(ShortSellingIndicator).append(")");
		stringBuilder.append("AlgoInfo(").append(AlgoInfo.toString()).append(")");
		stringBuilder.append("ClientIdentificationInfo(").append(ClientIdentificationInfo.toString()).append(")");
		stringBuilder.append("MicCode(").append(MicCode).append(")");
		stringBuilder.append("TransparencyInfo(").append(TransparencyInfo.toString()).append(")");
		return stringBuilder.toString();
	}
}
