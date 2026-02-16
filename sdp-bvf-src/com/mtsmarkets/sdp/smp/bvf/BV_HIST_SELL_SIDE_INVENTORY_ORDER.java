package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_HIST_SELL_SIDE_INVENTORY_ORDER extends SMPMessage
{
	public static final long CLASS_ID = 114532;

	private TI_MSG_INFO OrderMsgInfo = new TI_MSG_INFO();
	private String SectionCode = "";
	private long InventoryQuoteId = 0;
	private String DealerReferenceId = "";
	private String ClientExecID = "";
	private String ExecTraderName = "";
	private long QuoteUpdateTime = 0;
	private BV_HIST_MEMBER_INFO Aggressor = new BV_HIST_MEMBER_INFO();
	private BV_HIST_MEMBER_INFO Provider = new BV_HIST_MEMBER_INFO();
	private BV_HIST_INSTRUMENT_INFO Instrument = new BV_HIST_INSTRUMENT_INFO();
	private BV_INVENTORY_ORDER_EVENT_Enum Event = BV_INVENTORY_ORDER_EVENT_Enum.BV_INVENTORY_ORDER_EVENT_Accept;
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
	private TI_ALLOCATION_TYPE_Enum AllocationType = TI_ALLOCATION_TYPE_Enum.TI_ALLOCATION_TYPE_Unspecified;
	private long AllocationId = 0;
	private String AccountCode = "";
	private String AccountInfo = "";
	private String SettlementInfo = "";
	private String MktAffiliationShortDesc = "";
	private String MktAffiliationDesc = "";
	private long DealId = 0;
	private BV_TRANSPARENCY_INFO TransparencyInfo = new BV_TRANSPARENCY_INFO();
	private long CreationDate = 0;
	private long CreationTime = 0;
	private long UpdateTime = 0;
	private BV_SHORT_SELLING_INDICATOR_Enum ShortSellingIndicator = BV_SHORT_SELLING_INDICATOR_Enum.BV_SHORT_SELLING_INDICATOR_None;

	public BV_HIST_SELL_SIDE_INVENTORY_ORDER()
	{
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
	public String getClientExecID()
	{
		return ClientExecID;
	}
	public void setClientExecID(String value)
	{
		ClientExecID = value;
	}
	public String getExecTraderName()
	{
		return ExecTraderName;
	}
	public void setExecTraderName(String value)
	{
		ExecTraderName = value;
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
	public BV_INVENTORY_ORDER_EVENT_Enum getEvent()
	{
		return Event;
	}
	public void setEvent(BV_INVENTORY_ORDER_EVENT_Enum value)
	{
		Event = value;
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
		ClientExecID = byteBuffer.readString();
		ExecTraderName = byteBuffer.readString();
		QuoteUpdateTime = byteBuffer.readLong();
		Aggressor.readXDR(byteBuffer);
		Provider.readXDR(byteBuffer);
		Instrument.readXDR(byteBuffer);
		Event = Event.getEnum(byteBuffer.readInt());
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
		AllocationType = AllocationType.getEnum(byteBuffer.readInt());
		AllocationId = (long)byteBuffer.readInt();
		AccountCode = byteBuffer.readString();
		AccountInfo = byteBuffer.readString();
		SettlementInfo = byteBuffer.readString();
		MktAffiliationShortDesc = byteBuffer.readString();
		MktAffiliationDesc = byteBuffer.readString();
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
		byteBuffer.writeString(ClientExecID);
		byteBuffer.writeString(ExecTraderName);
		byteBuffer.writeLong(QuoteUpdateTime);
		Aggressor.writeXDR(byteBuffer);
		Provider.writeXDR(byteBuffer);
		Instrument.writeXDR(byteBuffer);
		byteBuffer.writeInt(Event.getValue());
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
		byteBuffer.writeInt(AllocationType.getValue());
		byteBuffer.writeInt((int)(AllocationId & 0xFFFFFFFFL));
		byteBuffer.writeString(AccountCode);
		byteBuffer.writeString(AccountInfo);
		byteBuffer.writeString(SettlementInfo);
		byteBuffer.writeString(MktAffiliationShortDesc);
		byteBuffer.writeString(MktAffiliationDesc);
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
		stringBuilder.append("BV_HIST_SELL_SIDE_INVENTORY_ORDER::");
		stringBuilder.append("OrderMsgInfo(").append(OrderMsgInfo.toString()).append(")");
		stringBuilder.append("SectionCode(").append(SectionCode).append(")");
		stringBuilder.append("InventoryQuoteId(").append(InventoryQuoteId).append(")");
		stringBuilder.append("DealerReferenceId(").append(DealerReferenceId).append(")");
		stringBuilder.append("ClientExecID(").append(ClientExecID).append(")");
		stringBuilder.append("ExecTraderName(").append(ExecTraderName).append(")");
		stringBuilder.append("QuoteUpdateTime(").append(QuoteUpdateTime).append(")");
		stringBuilder.append("Aggressor(").append(Aggressor.toString()).append(")");
		stringBuilder.append("Provider(").append(Provider.toString()).append(")");
		stringBuilder.append("Instrument(").append(Instrument.toString()).append(")");
		stringBuilder.append("Event(").append(Event).append(")");
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
		stringBuilder.append("AllocationType(").append(AllocationType).append(")");
		stringBuilder.append("AllocationId(").append(AllocationId).append(")");
		stringBuilder.append("AccountCode(").append(AccountCode).append(")");
		stringBuilder.append("AccountInfo(").append(AccountInfo).append(")");
		stringBuilder.append("SettlementInfo(").append(SettlementInfo).append(")");
		stringBuilder.append("MktAffiliationShortDesc(").append(MktAffiliationShortDesc).append(")");
		stringBuilder.append("MktAffiliationDesc(").append(MktAffiliationDesc).append(")");
		stringBuilder.append("DealId(").append(DealId).append(")");
		stringBuilder.append("TransparencyInfo(").append(TransparencyInfo.toString()).append(")");
		stringBuilder.append("CreationDate(").append(CreationDate).append(")");
		stringBuilder.append("CreationTime(").append(CreationTime).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		stringBuilder.append("ShortSellingIndicator(").append(ShortSellingIndicator).append(")");
		return stringBuilder.toString();
	}
}
