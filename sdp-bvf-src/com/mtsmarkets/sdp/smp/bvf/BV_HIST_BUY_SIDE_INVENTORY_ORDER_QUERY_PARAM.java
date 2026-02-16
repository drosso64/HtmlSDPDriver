package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_HIST_BUY_SIDE_INVENTORY_ORDER_QUERY_PARAM extends SMPMessage
{
	public static final long CLASS_ID = 214209;

	private TI_QUERY_OP_Enum MsgIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long MsgId = 0;
	private TI_QUERY_OP_Enum MsgDateFromOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long MsgDateFrom = 0;
	private TI_QUERY_OP_Enum MsgDateToOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long MsgDateTo = 0;
	private TI_QUERY_OP_Enum MsgTimeFromOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long MsgTimeFrom = 0;
	private TI_QUERY_OP_Enum MsgTimeToOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long MsgTimeTo = 0;
	private TI_QUERY_OP_Enum InstrumentCodeOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String InstrumentCode = "";
	private TI_QUERY_OP_Enum InventoryQuoteIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long InventoryQuoteId = 0;
	private TI_QUERY_OP_Enum ClientOrderIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String ClientOrderId = "";
	private TI_QUERY_OP_Enum StageOrderIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long StageOrderId = 0;
	private TI_QUERY_OP_Enum AllocationTypeOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private TI_ALLOCATION_TYPE_Enum AllocationType = TI_ALLOCATION_TYPE_Enum.TI_ALLOCATION_TYPE_Unspecified;
	private TI_QUERY_OP_Enum AllocationIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long AllocationId = 0;
	private TI_QUERY_OP_Enum DealIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long DealId = 0;
	private TI_QUERY_OP_Enum MemberCodeOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String MemberCode = "";
	private TI_QUERY_OP_Enum CtpCodeOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String CtpCode = "";
	private TI_QUERY_OP_Enum TraderNameOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String TraderName = "";

	public BV_HIST_BUY_SIDE_INVENTORY_ORDER_QUERY_PARAM()
	{
	}

	public TI_QUERY_OP_Enum getMsgIdOp()
	{
		return MsgIdOp;
	}
	public void setMsgIdOp(TI_QUERY_OP_Enum value)
	{
		MsgIdOp = value;
	}
	public long getMsgId()
	{
		return MsgId;
	}
	public void setMsgId(long value)
	{
		MsgId = value;
	}
	public TI_QUERY_OP_Enum getMsgDateFromOp()
	{
		return MsgDateFromOp;
	}
	public void setMsgDateFromOp(TI_QUERY_OP_Enum value)
	{
		MsgDateFromOp = value;
	}
	public long getMsgDateFrom()
	{
		return MsgDateFrom;
	}
	public void setMsgDateFrom(long value)
	{
		MsgDateFrom = value;
	}
	public TI_QUERY_OP_Enum getMsgDateToOp()
	{
		return MsgDateToOp;
	}
	public void setMsgDateToOp(TI_QUERY_OP_Enum value)
	{
		MsgDateToOp = value;
	}
	public long getMsgDateTo()
	{
		return MsgDateTo;
	}
	public void setMsgDateTo(long value)
	{
		MsgDateTo = value;
	}
	public TI_QUERY_OP_Enum getMsgTimeFromOp()
	{
		return MsgTimeFromOp;
	}
	public void setMsgTimeFromOp(TI_QUERY_OP_Enum value)
	{
		MsgTimeFromOp = value;
	}
	public long getMsgTimeFrom()
	{
		return MsgTimeFrom;
	}
	public void setMsgTimeFrom(long value)
	{
		MsgTimeFrom = value;
	}
	public TI_QUERY_OP_Enum getMsgTimeToOp()
	{
		return MsgTimeToOp;
	}
	public void setMsgTimeToOp(TI_QUERY_OP_Enum value)
	{
		MsgTimeToOp = value;
	}
	public long getMsgTimeTo()
	{
		return MsgTimeTo;
	}
	public void setMsgTimeTo(long value)
	{
		MsgTimeTo = value;
	}
	public TI_QUERY_OP_Enum getInstrumentCodeOp()
	{
		return InstrumentCodeOp;
	}
	public void setInstrumentCodeOp(TI_QUERY_OP_Enum value)
	{
		InstrumentCodeOp = value;
	}
	public String getInstrumentCode()
	{
		return InstrumentCode;
	}
	public void setInstrumentCode(String value)
	{
		InstrumentCode = value;
	}
	public TI_QUERY_OP_Enum getInventoryQuoteIdOp()
	{
		return InventoryQuoteIdOp;
	}
	public void setInventoryQuoteIdOp(TI_QUERY_OP_Enum value)
	{
		InventoryQuoteIdOp = value;
	}
	public long getInventoryQuoteId()
	{
		return InventoryQuoteId;
	}
	public void setInventoryQuoteId(long value)
	{
		InventoryQuoteId = value;
	}
	public TI_QUERY_OP_Enum getClientOrderIdOp()
	{
		return ClientOrderIdOp;
	}
	public void setClientOrderIdOp(TI_QUERY_OP_Enum value)
	{
		ClientOrderIdOp = value;
	}
	public String getClientOrderId()
	{
		return ClientOrderId;
	}
	public void setClientOrderId(String value)
	{
		ClientOrderId = value;
	}
	public TI_QUERY_OP_Enum getStageOrderIdOp()
	{
		return StageOrderIdOp;
	}
	public void setStageOrderIdOp(TI_QUERY_OP_Enum value)
	{
		StageOrderIdOp = value;
	}
	public long getStageOrderId()
	{
		return StageOrderId;
	}
	public void setStageOrderId(long value)
	{
		StageOrderId = value;
	}
	public TI_QUERY_OP_Enum getAllocationTypeOp()
	{
		return AllocationTypeOp;
	}
	public void setAllocationTypeOp(TI_QUERY_OP_Enum value)
	{
		AllocationTypeOp = value;
	}
	public TI_ALLOCATION_TYPE_Enum getAllocationType()
	{
		return AllocationType;
	}
	public void setAllocationType(TI_ALLOCATION_TYPE_Enum value)
	{
		AllocationType = value;
	}
	public TI_QUERY_OP_Enum getAllocationIdOp()
	{
		return AllocationIdOp;
	}
	public void setAllocationIdOp(TI_QUERY_OP_Enum value)
	{
		AllocationIdOp = value;
	}
	public long getAllocationId()
	{
		return AllocationId;
	}
	public void setAllocationId(long value)
	{
		AllocationId = value;
	}
	public TI_QUERY_OP_Enum getDealIdOp()
	{
		return DealIdOp;
	}
	public void setDealIdOp(TI_QUERY_OP_Enum value)
	{
		DealIdOp = value;
	}
	public long getDealId()
	{
		return DealId;
	}
	public void setDealId(long value)
	{
		DealId = value;
	}
	public TI_QUERY_OP_Enum getMemberCodeOp()
	{
		return MemberCodeOp;
	}
	public void setMemberCodeOp(TI_QUERY_OP_Enum value)
	{
		MemberCodeOp = value;
	}
	public String getMemberCode()
	{
		return MemberCode;
	}
	public void setMemberCode(String value)
	{
		MemberCode = value;
	}
	public TI_QUERY_OP_Enum getCtpCodeOp()
	{
		return CtpCodeOp;
	}
	public void setCtpCodeOp(TI_QUERY_OP_Enum value)
	{
		CtpCodeOp = value;
	}
	public String getCtpCode()
	{
		return CtpCode;
	}
	public void setCtpCode(String value)
	{
		CtpCode = value;
	}
	public TI_QUERY_OP_Enum getTraderNameOp()
	{
		return TraderNameOp;
	}
	public void setTraderNameOp(TI_QUERY_OP_Enum value)
	{
		TraderNameOp = value;
	}
	public String getTraderName()
	{
		return TraderName;
	}
	public void setTraderName(String value)
	{
		TraderName = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MsgIdOp = MsgIdOp.getEnum(byteBuffer.readInt());
		MsgId = (long)byteBuffer.readInt();
		MsgDateFromOp = MsgDateFromOp.getEnum(byteBuffer.readInt());
		MsgDateFrom = (long)byteBuffer.readInt();
		MsgDateToOp = MsgDateToOp.getEnum(byteBuffer.readInt());
		MsgDateTo = (long)byteBuffer.readInt();
		MsgTimeFromOp = MsgTimeFromOp.getEnum(byteBuffer.readInt());
		MsgTimeFrom = byteBuffer.readLong();
		MsgTimeToOp = MsgTimeToOp.getEnum(byteBuffer.readInt());
		MsgTimeTo = byteBuffer.readLong();
		InstrumentCodeOp = InstrumentCodeOp.getEnum(byteBuffer.readInt());
		InstrumentCode = byteBuffer.readString();
		InventoryQuoteIdOp = InventoryQuoteIdOp.getEnum(byteBuffer.readInt());
		InventoryQuoteId = (long)byteBuffer.readInt();
		ClientOrderIdOp = ClientOrderIdOp.getEnum(byteBuffer.readInt());
		ClientOrderId = byteBuffer.readString();
		StageOrderIdOp = StageOrderIdOp.getEnum(byteBuffer.readInt());
		StageOrderId = (long)byteBuffer.readInt();
		AllocationTypeOp = AllocationTypeOp.getEnum(byteBuffer.readInt());
		AllocationType = AllocationType.getEnum(byteBuffer.readInt());
		AllocationIdOp = AllocationIdOp.getEnum(byteBuffer.readInt());
		AllocationId = (long)byteBuffer.readInt();
		DealIdOp = DealIdOp.getEnum(byteBuffer.readInt());
		DealId = (long)byteBuffer.readInt();
		MemberCodeOp = MemberCodeOp.getEnum(byteBuffer.readInt());
		MemberCode = byteBuffer.readString();
		CtpCodeOp = CtpCodeOp.getEnum(byteBuffer.readInt());
		CtpCode = byteBuffer.readString();
		TraderNameOp = TraderNameOp.getEnum(byteBuffer.readInt());
		TraderName = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt(MsgIdOp.getValue());
		byteBuffer.writeInt((int)(MsgId & 0xFFFFFFFFL));
		byteBuffer.writeInt(MsgDateFromOp.getValue());
		byteBuffer.writeInt((int)(MsgDateFrom & 0xFFFFFFFFL));
		byteBuffer.writeInt(MsgDateToOp.getValue());
		byteBuffer.writeInt((int)(MsgDateTo & 0xFFFFFFFFL));
		byteBuffer.writeInt(MsgTimeFromOp.getValue());
		byteBuffer.writeLong(MsgTimeFrom);
		byteBuffer.writeInt(MsgTimeToOp.getValue());
		byteBuffer.writeLong(MsgTimeTo);
		byteBuffer.writeInt(InstrumentCodeOp.getValue());
		byteBuffer.writeString(InstrumentCode);
		byteBuffer.writeInt(InventoryQuoteIdOp.getValue());
		byteBuffer.writeInt((int)(InventoryQuoteId & 0xFFFFFFFFL));
		byteBuffer.writeInt(ClientOrderIdOp.getValue());
		byteBuffer.writeString(ClientOrderId);
		byteBuffer.writeInt(StageOrderIdOp.getValue());
		byteBuffer.writeInt((int)(StageOrderId & 0xFFFFFFFFL));
		byteBuffer.writeInt(AllocationTypeOp.getValue());
		byteBuffer.writeInt(AllocationType.getValue());
		byteBuffer.writeInt(AllocationIdOp.getValue());
		byteBuffer.writeInt((int)(AllocationId & 0xFFFFFFFFL));
		byteBuffer.writeInt(DealIdOp.getValue());
		byteBuffer.writeInt((int)(DealId & 0xFFFFFFFFL));
		byteBuffer.writeInt(MemberCodeOp.getValue());
		byteBuffer.writeString(MemberCode);
		byteBuffer.writeInt(CtpCodeOp.getValue());
		byteBuffer.writeString(CtpCode);
		byteBuffer.writeInt(TraderNameOp.getValue());
		byteBuffer.writeString(TraderName);

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
		stringBuilder.append("BV_HIST_BUY_SIDE_INVENTORY_ORDER_QUERY_PARAM::");
		stringBuilder.append("MsgIdOp(").append(MsgIdOp).append(")");
		stringBuilder.append("MsgId(").append(MsgId).append(")");
		stringBuilder.append("MsgDateFromOp(").append(MsgDateFromOp).append(")");
		stringBuilder.append("MsgDateFrom(").append(MsgDateFrom).append(")");
		stringBuilder.append("MsgDateToOp(").append(MsgDateToOp).append(")");
		stringBuilder.append("MsgDateTo(").append(MsgDateTo).append(")");
		stringBuilder.append("MsgTimeFromOp(").append(MsgTimeFromOp).append(")");
		stringBuilder.append("MsgTimeFrom(").append(MsgTimeFrom).append(")");
		stringBuilder.append("MsgTimeToOp(").append(MsgTimeToOp).append(")");
		stringBuilder.append("MsgTimeTo(").append(MsgTimeTo).append(")");
		stringBuilder.append("InstrumentCodeOp(").append(InstrumentCodeOp).append(")");
		stringBuilder.append("InstrumentCode(").append(InstrumentCode).append(")");
		stringBuilder.append("InventoryQuoteIdOp(").append(InventoryQuoteIdOp).append(")");
		stringBuilder.append("InventoryQuoteId(").append(InventoryQuoteId).append(")");
		stringBuilder.append("ClientOrderIdOp(").append(ClientOrderIdOp).append(")");
		stringBuilder.append("ClientOrderId(").append(ClientOrderId).append(")");
		stringBuilder.append("StageOrderIdOp(").append(StageOrderIdOp).append(")");
		stringBuilder.append("StageOrderId(").append(StageOrderId).append(")");
		stringBuilder.append("AllocationTypeOp(").append(AllocationTypeOp).append(")");
		stringBuilder.append("AllocationType(").append(AllocationType).append(")");
		stringBuilder.append("AllocationIdOp(").append(AllocationIdOp).append(")");
		stringBuilder.append("AllocationId(").append(AllocationId).append(")");
		stringBuilder.append("DealIdOp(").append(DealIdOp).append(")");
		stringBuilder.append("DealId(").append(DealId).append(")");
		stringBuilder.append("MemberCodeOp(").append(MemberCodeOp).append(")");
		stringBuilder.append("MemberCode(").append(MemberCode).append(")");
		stringBuilder.append("CtpCodeOp(").append(CtpCodeOp).append(")");
		stringBuilder.append("CtpCode(").append(CtpCode).append(")");
		stringBuilder.append("TraderNameOp(").append(TraderNameOp).append(")");
		stringBuilder.append("TraderName(").append(TraderName).append(")");
		return stringBuilder.toString();
	}
}
