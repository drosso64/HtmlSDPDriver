package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_TRADE_REGISTRATION_LEG_INFO extends SMPMessage
{
	public static final long CLASS_ID = 410008;

	private short LegId = 0;
	private long InstrumentId = 0;
	private String InstrumentCode = "";
	private String InstrumentDesc = "";
	private TI_INSTRUMENT_TYPE_Enum InstrumentType = TI_INSTRUMENT_TYPE_Enum.TI_INSTRUMENT_TYPE_Bond;
	private TI_VERB_Enum Verb = TI_VERB_Enum.TI_VERB_Buy;
	private short SettlementOffset = 0;
	private long SettlementDate = 0;
	private BV_SETTLEMENT_MODE_Enum SettlementMode = BV_SETTLEMENT_MODE_Enum.BV_SETTLEMENT_MODE_Any;
	private BV_EXEC_SETTLEMENT_MODE_Enum ExecSettlementMode = BV_EXEC_SETTLEMENT_MODE_Enum.BV_EXEC_SETTLEMENT_MODE_None;
	private long StageOrderId = 0;
	private String ClientOrderId = "";
	private TI_ALLOCATION_TYPE_Enum AllocationType = TI_ALLOCATION_TYPE_Enum.TI_ALLOCATION_TYPE_Unspecified;
	private long AllocationId = 0;
	private String AccountCode = "";
	private String AccountInfo = "";
	private String SettlementInfo = "";
	private double Price = 0;
	private BV_VALUE YieldValue = new BV_VALUE();
	private BV_VALUE DiscountMarginValue = new BV_VALUE();
	private BV_VALUE DiscountRateValue = new BV_VALUE();
	private double Quantity = 0;
	private double NominalValue = 0;
	private double Principal = 0;
	private double Accrued = 0;
	private String Currency = "";
	private double Bpv = 0;
	private short AccrualDays = 0;
	private short MarketAffiliation = 0;
	private String MarketAffiliationShortDesc = "";
	private String MarketAffiliationDesc = "";
	private long DealId = 0;
	private BV_TRANSPARENCY_INFO TransparencyInfo = new BV_TRANSPARENCY_INFO();
	private BV_TRADE_REGISTRATION_LEG_MEMBER_INFO ProviderInfo = new BV_TRADE_REGISTRATION_LEG_MEMBER_INFO();
	private BV_TRADE_REGISTRATION_LEG_MEMBER_INFO AggressorInfo = new BV_TRADE_REGISTRATION_LEG_MEMBER_INFO();

	public BV_TRADE_REGISTRATION_LEG_INFO()
	{
	}

	public short getLegId()
	{
		return LegId;
	}
	public void setLegId(short value)
	{
		LegId = value;
	}
	public long getInstrumentId()
	{
		return InstrumentId;
	}
	public void setInstrumentId(long value)
	{
		InstrumentId = value;
	}
	public String getInstrumentCode()
	{
		return InstrumentCode;
	}
	public void setInstrumentCode(String value)
	{
		InstrumentCode = value;
	}
	public String getInstrumentDesc()
	{
		return InstrumentDesc;
	}
	public void setInstrumentDesc(String value)
	{
		InstrumentDesc = value;
	}
	public TI_INSTRUMENT_TYPE_Enum getInstrumentType()
	{
		return InstrumentType;
	}
	public void setInstrumentType(TI_INSTRUMENT_TYPE_Enum value)
	{
		InstrumentType = value;
	}
	public TI_VERB_Enum getVerb()
	{
		return Verb;
	}
	public void setVerb(TI_VERB_Enum value)
	{
		Verb = value;
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
	public double getPrice()
	{
		return Price;
	}
	public void setPrice(double value)
	{
		Price = value;
	}
	public BV_VALUE getYieldValue()
	{
		return YieldValue;
	}
	public void setYieldValue(BV_VALUE value)
	{
		YieldValue = value;
	}
	public BV_VALUE getDiscountMarginValue()
	{
		return DiscountMarginValue;
	}
	public void setDiscountMarginValue(BV_VALUE value)
	{
		DiscountMarginValue = value;
	}
	public BV_VALUE getDiscountRateValue()
	{
		return DiscountRateValue;
	}
	public void setDiscountRateValue(BV_VALUE value)
	{
		DiscountRateValue = value;
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
	public short getAccrualDays()
	{
		return AccrualDays;
	}
	public void setAccrualDays(short value)
	{
		AccrualDays = value;
	}
	public short getMarketAffiliation()
	{
		return MarketAffiliation;
	}
	public void setMarketAffiliation(short value)
	{
		MarketAffiliation = value;
	}
	public String getMarketAffiliationShortDesc()
	{
		return MarketAffiliationShortDesc;
	}
	public void setMarketAffiliationShortDesc(String value)
	{
		MarketAffiliationShortDesc = value;
	}
	public String getMarketAffiliationDesc()
	{
		return MarketAffiliationDesc;
	}
	public void setMarketAffiliationDesc(String value)
	{
		MarketAffiliationDesc = value;
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
	public BV_TRADE_REGISTRATION_LEG_MEMBER_INFO getProviderInfo()
	{
		return ProviderInfo;
	}
	public void setProviderInfo(BV_TRADE_REGISTRATION_LEG_MEMBER_INFO value)
	{
		ProviderInfo = value;
	}
	public BV_TRADE_REGISTRATION_LEG_MEMBER_INFO getAggressorInfo()
	{
		return AggressorInfo;
	}
	public void setAggressorInfo(BV_TRADE_REGISTRATION_LEG_MEMBER_INFO value)
	{
		AggressorInfo = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		LegId = (short)byteBuffer.readInt();
		InstrumentId = (long)byteBuffer.readInt();
		InstrumentCode = byteBuffer.readString();
		InstrumentDesc = byteBuffer.readString();
		InstrumentType = InstrumentType.getEnum(byteBuffer.readInt());
		Verb = Verb.getEnum(byteBuffer.readInt());
		SettlementOffset = (short)byteBuffer.readInt();
		SettlementDate = (long)byteBuffer.readInt();
		SettlementMode = SettlementMode.getEnum(byteBuffer.readInt());
		ExecSettlementMode = ExecSettlementMode.getEnum(byteBuffer.readInt());
		StageOrderId = (long)byteBuffer.readInt();
		ClientOrderId = byteBuffer.readString();
		AllocationType = AllocationType.getEnum(byteBuffer.readInt());
		AllocationId = (long)byteBuffer.readInt();
		AccountCode = byteBuffer.readString();
		AccountInfo = byteBuffer.readString();
		SettlementInfo = byteBuffer.readString();
		Price = byteBuffer.readDouble();
		YieldValue.readXDR(byteBuffer);
		DiscountMarginValue.readXDR(byteBuffer);
		DiscountRateValue.readXDR(byteBuffer);
		Quantity = byteBuffer.readDouble();
		NominalValue = byteBuffer.readDouble();
		Principal = byteBuffer.readDouble();
		Accrued = byteBuffer.readDouble();
		Currency = byteBuffer.readString();
		Bpv = byteBuffer.readDouble();
		AccrualDays = (short)byteBuffer.readInt();
		MarketAffiliation = (short)byteBuffer.readInt();
		MarketAffiliationShortDesc = byteBuffer.readString();
		MarketAffiliationDesc = byteBuffer.readString();
		DealId = (long)byteBuffer.readInt();
		TransparencyInfo.readXDR(byteBuffer);
		ProviderInfo.readXDR(byteBuffer);
		AggressorInfo.readXDR(byteBuffer);
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(LegId & 0xFFFFL));
		byteBuffer.writeInt((int)(InstrumentId & 0xFFFFFFFFL));
		byteBuffer.writeString(InstrumentCode);
		byteBuffer.writeString(InstrumentDesc);
		byteBuffer.writeInt(InstrumentType.getValue());
		byteBuffer.writeInt(Verb.getValue());
		byteBuffer.writeInt((int)(SettlementOffset & 0xFFFFL));
		byteBuffer.writeInt((int)(SettlementDate & 0xFFFFFFFFL));
		byteBuffer.writeInt(SettlementMode.getValue());
		byteBuffer.writeInt(ExecSettlementMode.getValue());
		byteBuffer.writeInt((int)(StageOrderId & 0xFFFFFFFFL));
		byteBuffer.writeString(ClientOrderId);
		byteBuffer.writeInt(AllocationType.getValue());
		byteBuffer.writeInt((int)(AllocationId & 0xFFFFFFFFL));
		byteBuffer.writeString(AccountCode);
		byteBuffer.writeString(AccountInfo);
		byteBuffer.writeString(SettlementInfo);
		byteBuffer.writeDouble(Price);
		YieldValue.writeXDR(byteBuffer);
		DiscountMarginValue.writeXDR(byteBuffer);
		DiscountRateValue.writeXDR(byteBuffer);
		byteBuffer.writeDouble(Quantity);
		byteBuffer.writeDouble(NominalValue);
		byteBuffer.writeDouble(Principal);
		byteBuffer.writeDouble(Accrued);
		byteBuffer.writeString(Currency);
		byteBuffer.writeDouble(Bpv);
		byteBuffer.writeInt((int)(AccrualDays & 0xFFFFL));
		byteBuffer.writeInt((int)(MarketAffiliation & 0xFFFFL));
		byteBuffer.writeString(MarketAffiliationShortDesc);
		byteBuffer.writeString(MarketAffiliationDesc);
		byteBuffer.writeInt((int)(DealId & 0xFFFFFFFFL));
		TransparencyInfo.writeXDR(byteBuffer);
		ProviderInfo.writeXDR(byteBuffer);
		AggressorInfo.writeXDR(byteBuffer);

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
		stringBuilder.append("BV_TRADE_REGISTRATION_LEG_INFO::");
		stringBuilder.append("LegId(").append(LegId).append(")");
		stringBuilder.append("InstrumentId(").append(InstrumentId).append(")");
		stringBuilder.append("InstrumentCode(").append(InstrumentCode).append(")");
		stringBuilder.append("InstrumentDesc(").append(InstrumentDesc).append(")");
		stringBuilder.append("InstrumentType(").append(InstrumentType).append(")");
		stringBuilder.append("Verb(").append(Verb).append(")");
		stringBuilder.append("SettlementOffset(").append(SettlementOffset).append(")");
		stringBuilder.append("SettlementDate(").append(SettlementDate).append(")");
		stringBuilder.append("SettlementMode(").append(SettlementMode).append(")");
		stringBuilder.append("ExecSettlementMode(").append(ExecSettlementMode).append(")");
		stringBuilder.append("StageOrderId(").append(StageOrderId).append(")");
		stringBuilder.append("ClientOrderId(").append(ClientOrderId).append(")");
		stringBuilder.append("AllocationType(").append(AllocationType).append(")");
		stringBuilder.append("AllocationId(").append(AllocationId).append(")");
		stringBuilder.append("AccountCode(").append(AccountCode).append(")");
		stringBuilder.append("AccountInfo(").append(AccountInfo).append(")");
		stringBuilder.append("SettlementInfo(").append(SettlementInfo).append(")");
		stringBuilder.append("Price(").append(Price).append(")");
		stringBuilder.append("YieldValue(").append(YieldValue.toString()).append(")");
		stringBuilder.append("DiscountMarginValue(").append(DiscountMarginValue.toString()).append(")");
		stringBuilder.append("DiscountRateValue(").append(DiscountRateValue.toString()).append(")");
		stringBuilder.append("Quantity(").append(Quantity).append(")");
		stringBuilder.append("NominalValue(").append(NominalValue).append(")");
		stringBuilder.append("Principal(").append(Principal).append(")");
		stringBuilder.append("Accrued(").append(Accrued).append(")");
		stringBuilder.append("Currency(").append(Currency).append(")");
		stringBuilder.append("Bpv(").append(Bpv).append(")");
		stringBuilder.append("AccrualDays(").append(AccrualDays).append(")");
		stringBuilder.append("MarketAffiliation(").append(MarketAffiliation).append(")");
		stringBuilder.append("MarketAffiliationShortDesc(").append(MarketAffiliationShortDesc).append(")");
		stringBuilder.append("MarketAffiliationDesc(").append(MarketAffiliationDesc).append(")");
		stringBuilder.append("DealId(").append(DealId).append(")");
		stringBuilder.append("TransparencyInfo(").append(TransparencyInfo.toString()).append(")");
		stringBuilder.append("ProviderInfo(").append(ProviderInfo.toString()).append(")");
		stringBuilder.append("AggressorInfo(").append(AggressorInfo.toString()).append(")");
		return stringBuilder.toString();
	}
}
