package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_PORTFOLIO_RFCQ_REQUEST_LEG extends SMPMessage
{
	public static final long CLASS_ID = 410013;

	private short LegId = 0;
	private BV_INSTRUMENT_INFO Instrument = new BV_INSTRUMENT_INFO();
	private TI_VERB_Enum Verb = TI_VERB_Enum.TI_VERB_Buy;
	private double Quantity = 0;
	private long StageOrderId = 0;
	private String ClientOrderId = "";
	private short SettlementOffset = 0;
	private long SettlementDate = 0;
	private TI_ALLOCATION_TYPE_Enum AllocationType = TI_ALLOCATION_TYPE_Enum.TI_ALLOCATION_TYPE_Unspecified;
	private long AllocationId = 0;
	private String SettlementInfo = "";
	private BV_VALUE ReferenceLevel = new BV_VALUE();
	private BV_VALUE ReferencePrice = new BV_VALUE();
	private BV_VALUE ReferenceYield = new BV_VALUE();
	private double Bpv = 0;
	private double Markup = 0;
	private BV_SHORT_SELLING_INDICATOR_Enum ShortSellingIndicator = BV_SHORT_SELLING_INDICATOR_Enum.BV_SHORT_SELLING_INDICATOR_None;
	private BV_ALGO_INFO AlgoInfo = new BV_ALGO_INFO();
	private BV_CLIENT_IDENTIFICATION_INFO ClientIdentificationInfo = new BV_CLIENT_IDENTIFICATION_INFO();
	private TI_ERROR_Enum ErrorCode = TI_ERROR_Enum.TI_ERROR_NoError;

	public BV_PORTFOLIO_RFCQ_REQUEST_LEG()
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
	public BV_INSTRUMENT_INFO getInstrument()
	{
		return Instrument;
	}
	public void setInstrument(BV_INSTRUMENT_INFO value)
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
	public double getQuantity()
	{
		return Quantity;
	}
	public void setQuantity(double value)
	{
		Quantity = value;
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
	public String getSettlementInfo()
	{
		return SettlementInfo;
	}
	public void setSettlementInfo(String value)
	{
		SettlementInfo = value;
	}
	public BV_VALUE getReferenceLevel()
	{
		return ReferenceLevel;
	}
	public void setReferenceLevel(BV_VALUE value)
	{
		ReferenceLevel = value;
	}
	public BV_VALUE getReferencePrice()
	{
		return ReferencePrice;
	}
	public void setReferencePrice(BV_VALUE value)
	{
		ReferencePrice = value;
	}
	public BV_VALUE getReferenceYield()
	{
		return ReferenceYield;
	}
	public void setReferenceYield(BV_VALUE value)
	{
		ReferenceYield = value;
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
	public TI_ERROR_Enum getErrorCode()
	{
		return ErrorCode;
	}
	public void setErrorCode(TI_ERROR_Enum value)
	{
		ErrorCode = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		LegId = (short)byteBuffer.readInt();
		Instrument.readXDR(byteBuffer);
		Verb = Verb.getEnum(byteBuffer.readInt());
		Quantity = byteBuffer.readDouble();
		StageOrderId = (long)byteBuffer.readInt();
		ClientOrderId = byteBuffer.readString();
		SettlementOffset = (short)byteBuffer.readInt();
		SettlementDate = (long)byteBuffer.readInt();
		AllocationType = AllocationType.getEnum(byteBuffer.readInt());
		AllocationId = (long)byteBuffer.readInt();
		SettlementInfo = byteBuffer.readString();
		ReferenceLevel.readXDR(byteBuffer);
		ReferencePrice.readXDR(byteBuffer);
		ReferenceYield.readXDR(byteBuffer);
		Bpv = byteBuffer.readDouble();
		Markup = byteBuffer.readDouble();
		ShortSellingIndicator = ShortSellingIndicator.getEnum(byteBuffer.readInt());
		AlgoInfo.readXDR(byteBuffer);
		ClientIdentificationInfo.readXDR(byteBuffer);
		ErrorCode = ErrorCode.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(LegId & 0xFFFFL));
		Instrument.writeXDR(byteBuffer);
		byteBuffer.writeInt(Verb.getValue());
		byteBuffer.writeDouble(Quantity);
		byteBuffer.writeInt((int)(StageOrderId & 0xFFFFFFFFL));
		byteBuffer.writeString(ClientOrderId);
		byteBuffer.writeInt((int)(SettlementOffset & 0xFFFFL));
		byteBuffer.writeInt((int)(SettlementDate & 0xFFFFFFFFL));
		byteBuffer.writeInt(AllocationType.getValue());
		byteBuffer.writeInt((int)(AllocationId & 0xFFFFFFFFL));
		byteBuffer.writeString(SettlementInfo);
		ReferenceLevel.writeXDR(byteBuffer);
		ReferencePrice.writeXDR(byteBuffer);
		ReferenceYield.writeXDR(byteBuffer);
		byteBuffer.writeDouble(Bpv);
		byteBuffer.writeDouble(Markup);
		byteBuffer.writeInt(ShortSellingIndicator.getValue());
		AlgoInfo.writeXDR(byteBuffer);
		ClientIdentificationInfo.writeXDR(byteBuffer);
		byteBuffer.writeInt(ErrorCode.getValue());

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
		stringBuilder.append("BV_PORTFOLIO_RFCQ_REQUEST_LEG::");
		stringBuilder.append("LegId(").append(LegId).append(")");
		stringBuilder.append("Instrument(").append(Instrument.toString()).append(")");
		stringBuilder.append("Verb(").append(Verb).append(")");
		stringBuilder.append("Quantity(").append(Quantity).append(")");
		stringBuilder.append("StageOrderId(").append(StageOrderId).append(")");
		stringBuilder.append("ClientOrderId(").append(ClientOrderId).append(")");
		stringBuilder.append("SettlementOffset(").append(SettlementOffset).append(")");
		stringBuilder.append("SettlementDate(").append(SettlementDate).append(")");
		stringBuilder.append("AllocationType(").append(AllocationType).append(")");
		stringBuilder.append("AllocationId(").append(AllocationId).append(")");
		stringBuilder.append("SettlementInfo(").append(SettlementInfo).append(")");
		stringBuilder.append("ReferenceLevel(").append(ReferenceLevel.toString()).append(")");
		stringBuilder.append("ReferencePrice(").append(ReferencePrice.toString()).append(")");
		stringBuilder.append("ReferenceYield(").append(ReferenceYield.toString()).append(")");
		stringBuilder.append("Bpv(").append(Bpv).append(")");
		stringBuilder.append("Markup(").append(Markup).append(")");
		stringBuilder.append("ShortSellingIndicator(").append(ShortSellingIndicator).append(")");
		stringBuilder.append("AlgoInfo(").append(AlgoInfo.toString()).append(")");
		stringBuilder.append("ClientIdentificationInfo(").append(ClientIdentificationInfo.toString()).append(")");
		stringBuilder.append("ErrorCode(").append(ErrorCode).append(")");
		return stringBuilder.toString();
	}
}
