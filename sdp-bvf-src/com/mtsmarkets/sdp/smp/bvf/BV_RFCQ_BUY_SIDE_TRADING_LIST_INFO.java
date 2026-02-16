package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_RFCQ_BUY_SIDE_TRADING_LIST_INFO extends SMPMessage
{
	public static final long CLASS_ID = 114976;

	private long SectionId = 0;
	private long InstrumentId = 0;
	private TI_INSTRUMENT_TYPE_Enum InstrumentType = TI_INSTRUMENT_TYPE_Enum.TI_INSTRUMENT_TYPE_Bond;
	private long PreviewId = 0;
	private TI_VERB_Enum Verb = TI_VERB_Enum.TI_VERB_Buy;
	private BV_RFCQ_SELL_SIDE_MEMBER_INFO[] SellSideMemberInfo = new BV_RFCQ_SELL_SIDE_MEMBER_INFO[20];
	private double Quantity = 0;
	private TI_FLAG_Enum QuotationFg = TI_FLAG_Enum.TI_FLAG_No;
	private double Quotation = 0;
	private TI_FLAG_Enum DiscloseIOIFg = TI_FLAG_Enum.TI_FLAG_No;
	private short IOIMatchingQuotes = 0;
	private long StageOrderId = 0;
	private String ClientOrderId = "";
	private short SettlementOffset = 0;
	private long SettlementDate = 0;
	private BV_SETTLEMENT_MODE_Enum SettlementMode = BV_SETTLEMENT_MODE_Enum.BV_SETTLEMENT_MODE_Any;
	private TI_ALLOCATION_TYPE_Enum AllocationType = TI_ALLOCATION_TYPE_Enum.TI_ALLOCATION_TYPE_Unspecified;
	private long AllocationId = 0;
	private short[] MarketAffiliation = new short[20];
	private TI_ERROR_Enum ErrorCode = TI_ERROR_Enum.TI_ERROR_NoError;
	private String SettlementInfo = "";
	private TI_FLAG_Enum PreTradeFg = TI_FLAG_Enum.TI_FLAG_No;
	private BV_SHORT_SELLING_INDICATOR_Enum ShortSellingIndicator = BV_SHORT_SELLING_INDICATOR_Enum.BV_SHORT_SELLING_INDICATOR_None;
	private BV_ALGO_INFO AlgoInfo = new BV_ALGO_INFO();
	private BV_CLIENT_IDENTIFICATION_INFO ClientIdentificationInfo = new BV_CLIENT_IDENTIFICATION_INFO();

	public BV_RFCQ_BUY_SIDE_TRADING_LIST_INFO()
	{
		for (int i=0; i < SellSideMemberInfo.length; ++i)
		{
			SellSideMemberInfo[i] = new BV_RFCQ_SELL_SIDE_MEMBER_INFO();
		}
	}

	public long getSectionId()
	{
		return SectionId;
	}
	public void setSectionId(long value)
	{
		SectionId = value;
	}
	public long getInstrumentId()
	{
		return InstrumentId;
	}
	public void setInstrumentId(long value)
	{
		InstrumentId = value;
	}
	public TI_INSTRUMENT_TYPE_Enum getInstrumentType()
	{
		return InstrumentType;
	}
	public void setInstrumentType(TI_INSTRUMENT_TYPE_Enum value)
	{
		InstrumentType = value;
	}
	public long getPreviewId()
	{
		return PreviewId;
	}
	public void setPreviewId(long value)
	{
		PreviewId = value;
	}
	public TI_VERB_Enum getVerb()
	{
		return Verb;
	}
	public void setVerb(TI_VERB_Enum value)
	{
		Verb = value;
	}
	public BV_RFCQ_SELL_SIDE_MEMBER_INFO[] getSellSideMemberInfo()
	{
		return SellSideMemberInfo;
	}
	public void setSellSideMemberInfo(BV_RFCQ_SELL_SIDE_MEMBER_INFO[] value)
	{
		SellSideMemberInfo = value;
	}
	public double getQuantity()
	{
		return Quantity;
	}
	public void setQuantity(double value)
	{
		Quantity = value;
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
	public short getIOIMatchingQuotes()
	{
		return IOIMatchingQuotes;
	}
	public void setIOIMatchingQuotes(short value)
	{
		IOIMatchingQuotes = value;
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
	public short[] getMarketAffiliation()
	{
		return MarketAffiliation;
	}
	public void setMarketAffiliation(short[] value)
	{
		MarketAffiliation = value;
	}
	public TI_ERROR_Enum getErrorCode()
	{
		return ErrorCode;
	}
	public void setErrorCode(TI_ERROR_Enum value)
	{
		ErrorCode = value;
	}
	public String getSettlementInfo()
	{
		return SettlementInfo;
	}
	public void setSettlementInfo(String value)
	{
		SettlementInfo = value;
	}
	public TI_FLAG_Enum getPreTradeFg()
	{
		return PreTradeFg;
	}
	public void setPreTradeFg(TI_FLAG_Enum value)
	{
		PreTradeFg = value;
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

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		SectionId = (long)byteBuffer.readInt();
		InstrumentId = (long)byteBuffer.readInt();
		InstrumentType = InstrumentType.getEnum(byteBuffer.readInt());
		PreviewId = (long)byteBuffer.readInt();
		Verb = Verb.getEnum(byteBuffer.readInt());
		for (int i=0; i < SellSideMemberInfo.length; ++i)
		{
			SellSideMemberInfo[i].readXDR(byteBuffer);
		}
		Quantity = byteBuffer.readDouble();
		QuotationFg = QuotationFg.getEnum(byteBuffer.readInt());
		Quotation = byteBuffer.readDouble();
		DiscloseIOIFg = DiscloseIOIFg.getEnum(byteBuffer.readInt());
		IOIMatchingQuotes = (short)byteBuffer.readInt();
		StageOrderId = (long)byteBuffer.readInt();
		ClientOrderId = byteBuffer.readString();
		SettlementOffset = (short)byteBuffer.readInt();
		SettlementDate = (long)byteBuffer.readInt();
		SettlementMode = SettlementMode.getEnum(byteBuffer.readInt());
		AllocationType = AllocationType.getEnum(byteBuffer.readInt());
		AllocationId = (long)byteBuffer.readInt();
		for (int i=0; i < MarketAffiliation.length; ++i)
		{
			MarketAffiliation[i] = (short)byteBuffer.readInt();
		}
		ErrorCode = ErrorCode.getEnum(byteBuffer.readInt());
		SettlementInfo = byteBuffer.readString();
		PreTradeFg = PreTradeFg.getEnum(byteBuffer.readInt());
		ShortSellingIndicator = ShortSellingIndicator.getEnum(byteBuffer.readInt());
		AlgoInfo.readXDR(byteBuffer);
		ClientIdentificationInfo.readXDR(byteBuffer);
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(SectionId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(InstrumentId & 0xFFFFFFFFL));
		byteBuffer.writeInt(InstrumentType.getValue());
		byteBuffer.writeInt((int)(PreviewId & 0xFFFFFFFFL));
		byteBuffer.writeInt(Verb.getValue());
		for (int i=0; i < SellSideMemberInfo.length; ++i)
		{
			SellSideMemberInfo[i].writeXDR(byteBuffer);
		}
		byteBuffer.writeDouble(Quantity);
		byteBuffer.writeInt(QuotationFg.getValue());
		byteBuffer.writeDouble(Quotation);
		byteBuffer.writeInt(DiscloseIOIFg.getValue());
		byteBuffer.writeInt((int)(IOIMatchingQuotes & 0xFFFFL));
		byteBuffer.writeInt((int)(StageOrderId & 0xFFFFFFFFL));
		byteBuffer.writeString(ClientOrderId);
		byteBuffer.writeInt((int)(SettlementOffset & 0xFFFFL));
		byteBuffer.writeInt((int)(SettlementDate & 0xFFFFFFFFL));
		byteBuffer.writeInt(SettlementMode.getValue());
		byteBuffer.writeInt(AllocationType.getValue());
		byteBuffer.writeInt((int)(AllocationId & 0xFFFFFFFFL));
		for (int i=0; i < MarketAffiliation.length; ++i)
		{
			byteBuffer.writeInt((int)(MarketAffiliation[i] & 0xFFFFL));
		}
		byteBuffer.writeInt(ErrorCode.getValue());
		byteBuffer.writeString(SettlementInfo);
		byteBuffer.writeInt(PreTradeFg.getValue());
		byteBuffer.writeInt(ShortSellingIndicator.getValue());
		AlgoInfo.writeXDR(byteBuffer);
		ClientIdentificationInfo.writeXDR(byteBuffer);

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
		stringBuilder.append("BV_RFCQ_BUY_SIDE_TRADING_LIST_INFO::");
		stringBuilder.append("SectionId(").append(SectionId).append(")");
		stringBuilder.append("InstrumentId(").append(InstrumentId).append(")");
		stringBuilder.append("InstrumentType(").append(InstrumentType).append(")");
		stringBuilder.append("PreviewId(").append(PreviewId).append(")");
		stringBuilder.append("Verb(").append(Verb).append(")");
		for (int i=0; i < SellSideMemberInfo.length; ++i)
		{
			stringBuilder.append("SellSideMemberInfo[").append(i).append("](").append(SellSideMemberInfo[i].toString()).append(")");
		}
		stringBuilder.append("Quantity(").append(Quantity).append(")");
		stringBuilder.append("QuotationFg(").append(QuotationFg).append(")");
		stringBuilder.append("Quotation(").append(Quotation).append(")");
		stringBuilder.append("DiscloseIOIFg(").append(DiscloseIOIFg).append(")");
		stringBuilder.append("IOIMatchingQuotes(").append(IOIMatchingQuotes).append(")");
		stringBuilder.append("StageOrderId(").append(StageOrderId).append(")");
		stringBuilder.append("ClientOrderId(").append(ClientOrderId).append(")");
		stringBuilder.append("SettlementOffset(").append(SettlementOffset).append(")");
		stringBuilder.append("SettlementDate(").append(SettlementDate).append(")");
		stringBuilder.append("SettlementMode(").append(SettlementMode).append(")");
		stringBuilder.append("AllocationType(").append(AllocationType).append(")");
		stringBuilder.append("AllocationId(").append(AllocationId).append(")");
		for (int i=0; i < MarketAffiliation.length; ++i)
		{
			stringBuilder.append("MarketAffiliation[").append(i).append("](").append(MarketAffiliation[i]).append(")");
		}
		stringBuilder.append("ErrorCode(").append(ErrorCode).append(")");
		stringBuilder.append("SettlementInfo(").append(SettlementInfo).append(")");
		stringBuilder.append("PreTradeFg(").append(PreTradeFg).append(")");
		stringBuilder.append("ShortSellingIndicator(").append(ShortSellingIndicator).append(")");
		stringBuilder.append("AlgoInfo(").append(AlgoInfo.toString()).append(")");
		stringBuilder.append("ClientIdentificationInfo(").append(ClientIdentificationInfo.toString()).append(")");
		return stringBuilder.toString();
	}
}
