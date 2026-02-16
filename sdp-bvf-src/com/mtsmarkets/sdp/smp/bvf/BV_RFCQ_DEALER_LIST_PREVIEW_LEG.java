package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_RFCQ_DEALER_LIST_PREVIEW_LEG extends SMPMessage
{
	public static final long CLASS_ID = 114973;

	private long InstrumentId = 0;
	private TI_VERB_Enum Verb = TI_VERB_Enum.TI_VERB_Buy;
	private double Qty = 0;
	private double MinQty = 0;
	private long StageOrderId = 0;
	private TI_ALLOCATION_TYPE_Enum AllocationType = TI_ALLOCATION_TYPE_Enum.TI_ALLOCATION_TYPE_Unspecified;
	private long AllocationId = 0;
	private short SettlementOffset = 0;
	private long SettlementDate = 0;
	private BV_SETTLEMENT_MODE_Enum SettlementMode = BV_SETTLEMENT_MODE_Enum.BV_SETTLEMENT_MODE_Any;

	public BV_RFCQ_DEALER_LIST_PREVIEW_LEG()
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
	public TI_VERB_Enum getVerb()
	{
		return Verb;
	}
	public void setVerb(TI_VERB_Enum value)
	{
		Verb = value;
	}
	public double getQty()
	{
		return Qty;
	}
	public void setQty(double value)
	{
		Qty = value;
	}
	public double getMinQty()
	{
		return MinQty;
	}
	public void setMinQty(double value)
	{
		MinQty = value;
	}
	public long getStageOrderId()
	{
		return StageOrderId;
	}
	public void setStageOrderId(long value)
	{
		StageOrderId = value;
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

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		InstrumentId = (long)byteBuffer.readInt();
		Verb = Verb.getEnum(byteBuffer.readInt());
		Qty = byteBuffer.readDouble();
		MinQty = byteBuffer.readDouble();
		StageOrderId = (long)byteBuffer.readInt();
		AllocationType = AllocationType.getEnum(byteBuffer.readInt());
		AllocationId = (long)byteBuffer.readInt();
		SettlementOffset = (short)byteBuffer.readInt();
		SettlementDate = (long)byteBuffer.readInt();
		SettlementMode = SettlementMode.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(InstrumentId & 0xFFFFFFFFL));
		byteBuffer.writeInt(Verb.getValue());
		byteBuffer.writeDouble(Qty);
		byteBuffer.writeDouble(MinQty);
		byteBuffer.writeInt((int)(StageOrderId & 0xFFFFFFFFL));
		byteBuffer.writeInt(AllocationType.getValue());
		byteBuffer.writeInt((int)(AllocationId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SettlementOffset & 0xFFFFL));
		byteBuffer.writeInt((int)(SettlementDate & 0xFFFFFFFFL));
		byteBuffer.writeInt(SettlementMode.getValue());

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
		stringBuilder.append("BV_RFCQ_DEALER_LIST_PREVIEW_LEG::");
		stringBuilder.append("InstrumentId(").append(InstrumentId).append(")");
		stringBuilder.append("Verb(").append(Verb).append(")");
		stringBuilder.append("Qty(").append(Qty).append(")");
		stringBuilder.append("MinQty(").append(MinQty).append(")");
		stringBuilder.append("StageOrderId(").append(StageOrderId).append(")");
		stringBuilder.append("AllocationType(").append(AllocationType).append(")");
		stringBuilder.append("AllocationId(").append(AllocationId).append(")");
		stringBuilder.append("SettlementOffset(").append(SettlementOffset).append(")");
		stringBuilder.append("SettlementDate(").append(SettlementDate).append(")");
		stringBuilder.append("SettlementMode(").append(SettlementMode).append(")");
		return stringBuilder.toString();
	}
}
