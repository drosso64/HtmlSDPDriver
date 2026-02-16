package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_HIST_TRADE_SPLIT_QUERY_PARAM extends SMPMessage
{
	public static final long CLASS_ID = 214207;

	private TI_QUERY_OP_Enum AllocationIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long AllocationId = 0;
	private TI_QUERY_OP_Enum ClientAllocationIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String ClientAllocationId = "";
	private TI_QUERY_OP_Enum AllocationDescriptionOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String AllocationDescription = "";
	private TI_QUERY_OP_Enum ClientOrderIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String ClientOrderId = "";
	private TI_QUERY_OP_Enum TraderNameOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String TraderName = "";
	private TI_QUERY_OP_Enum CreationDateFromOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long CreationDateFrom = 0;
	private TI_QUERY_OP_Enum CreationDateToOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long CreationDateTo = 0;
	private TI_QUERY_OP_Enum CreationTimeFromOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long CreationTimeFrom = 0;
	private TI_QUERY_OP_Enum CreationTimeToOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long CreationTimeTo = 0;
	private TI_QUERY_OP_Enum InstrumentCodeOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String InstrumentCode = "";

	public BV_HIST_TRADE_SPLIT_QUERY_PARAM()
	{
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
	public TI_QUERY_OP_Enum getClientAllocationIdOp()
	{
		return ClientAllocationIdOp;
	}
	public void setClientAllocationIdOp(TI_QUERY_OP_Enum value)
	{
		ClientAllocationIdOp = value;
	}
	public String getClientAllocationId()
	{
		return ClientAllocationId;
	}
	public void setClientAllocationId(String value)
	{
		ClientAllocationId = value;
	}
	public TI_QUERY_OP_Enum getAllocationDescriptionOp()
	{
		return AllocationDescriptionOp;
	}
	public void setAllocationDescriptionOp(TI_QUERY_OP_Enum value)
	{
		AllocationDescriptionOp = value;
	}
	public String getAllocationDescription()
	{
		return AllocationDescription;
	}
	public void setAllocationDescription(String value)
	{
		AllocationDescription = value;
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
	public TI_QUERY_OP_Enum getCreationDateFromOp()
	{
		return CreationDateFromOp;
	}
	public void setCreationDateFromOp(TI_QUERY_OP_Enum value)
	{
		CreationDateFromOp = value;
	}
	public long getCreationDateFrom()
	{
		return CreationDateFrom;
	}
	public void setCreationDateFrom(long value)
	{
		CreationDateFrom = value;
	}
	public TI_QUERY_OP_Enum getCreationDateToOp()
	{
		return CreationDateToOp;
	}
	public void setCreationDateToOp(TI_QUERY_OP_Enum value)
	{
		CreationDateToOp = value;
	}
	public long getCreationDateTo()
	{
		return CreationDateTo;
	}
	public void setCreationDateTo(long value)
	{
		CreationDateTo = value;
	}
	public TI_QUERY_OP_Enum getCreationTimeFromOp()
	{
		return CreationTimeFromOp;
	}
	public void setCreationTimeFromOp(TI_QUERY_OP_Enum value)
	{
		CreationTimeFromOp = value;
	}
	public long getCreationTimeFrom()
	{
		return CreationTimeFrom;
	}
	public void setCreationTimeFrom(long value)
	{
		CreationTimeFrom = value;
	}
	public TI_QUERY_OP_Enum getCreationTimeToOp()
	{
		return CreationTimeToOp;
	}
	public void setCreationTimeToOp(TI_QUERY_OP_Enum value)
	{
		CreationTimeToOp = value;
	}
	public long getCreationTimeTo()
	{
		return CreationTimeTo;
	}
	public void setCreationTimeTo(long value)
	{
		CreationTimeTo = value;
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

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		AllocationIdOp = AllocationIdOp.getEnum(byteBuffer.readInt());
		AllocationId = (long)byteBuffer.readInt();
		ClientAllocationIdOp = ClientAllocationIdOp.getEnum(byteBuffer.readInt());
		ClientAllocationId = byteBuffer.readString();
		AllocationDescriptionOp = AllocationDescriptionOp.getEnum(byteBuffer.readInt());
		AllocationDescription = byteBuffer.readString();
		ClientOrderIdOp = ClientOrderIdOp.getEnum(byteBuffer.readInt());
		ClientOrderId = byteBuffer.readString();
		TraderNameOp = TraderNameOp.getEnum(byteBuffer.readInt());
		TraderName = byteBuffer.readString();
		CreationDateFromOp = CreationDateFromOp.getEnum(byteBuffer.readInt());
		CreationDateFrom = (long)byteBuffer.readInt();
		CreationDateToOp = CreationDateToOp.getEnum(byteBuffer.readInt());
		CreationDateTo = (long)byteBuffer.readInt();
		CreationTimeFromOp = CreationTimeFromOp.getEnum(byteBuffer.readInt());
		CreationTimeFrom = byteBuffer.readLong();
		CreationTimeToOp = CreationTimeToOp.getEnum(byteBuffer.readInt());
		CreationTimeTo = byteBuffer.readLong();
		InstrumentCodeOp = InstrumentCodeOp.getEnum(byteBuffer.readInt());
		InstrumentCode = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt(AllocationIdOp.getValue());
		byteBuffer.writeInt((int)(AllocationId & 0xFFFFFFFFL));
		byteBuffer.writeInt(ClientAllocationIdOp.getValue());
		byteBuffer.writeString(ClientAllocationId);
		byteBuffer.writeInt(AllocationDescriptionOp.getValue());
		byteBuffer.writeString(AllocationDescription);
		byteBuffer.writeInt(ClientOrderIdOp.getValue());
		byteBuffer.writeString(ClientOrderId);
		byteBuffer.writeInt(TraderNameOp.getValue());
		byteBuffer.writeString(TraderName);
		byteBuffer.writeInt(CreationDateFromOp.getValue());
		byteBuffer.writeInt((int)(CreationDateFrom & 0xFFFFFFFFL));
		byteBuffer.writeInt(CreationDateToOp.getValue());
		byteBuffer.writeInt((int)(CreationDateTo & 0xFFFFFFFFL));
		byteBuffer.writeInt(CreationTimeFromOp.getValue());
		byteBuffer.writeLong(CreationTimeFrom);
		byteBuffer.writeInt(CreationTimeToOp.getValue());
		byteBuffer.writeLong(CreationTimeTo);
		byteBuffer.writeInt(InstrumentCodeOp.getValue());
		byteBuffer.writeString(InstrumentCode);

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
		stringBuilder.append("BV_HIST_TRADE_SPLIT_QUERY_PARAM::");
		stringBuilder.append("AllocationIdOp(").append(AllocationIdOp).append(")");
		stringBuilder.append("AllocationId(").append(AllocationId).append(")");
		stringBuilder.append("ClientAllocationIdOp(").append(ClientAllocationIdOp).append(")");
		stringBuilder.append("ClientAllocationId(").append(ClientAllocationId).append(")");
		stringBuilder.append("AllocationDescriptionOp(").append(AllocationDescriptionOp).append(")");
		stringBuilder.append("AllocationDescription(").append(AllocationDescription).append(")");
		stringBuilder.append("ClientOrderIdOp(").append(ClientOrderIdOp).append(")");
		stringBuilder.append("ClientOrderId(").append(ClientOrderId).append(")");
		stringBuilder.append("TraderNameOp(").append(TraderNameOp).append(")");
		stringBuilder.append("TraderName(").append(TraderName).append(")");
		stringBuilder.append("CreationDateFromOp(").append(CreationDateFromOp).append(")");
		stringBuilder.append("CreationDateFrom(").append(CreationDateFrom).append(")");
		stringBuilder.append("CreationDateToOp(").append(CreationDateToOp).append(")");
		stringBuilder.append("CreationDateTo(").append(CreationDateTo).append(")");
		stringBuilder.append("CreationTimeFromOp(").append(CreationTimeFromOp).append(")");
		stringBuilder.append("CreationTimeFrom(").append(CreationTimeFrom).append(")");
		stringBuilder.append("CreationTimeToOp(").append(CreationTimeToOp).append(")");
		stringBuilder.append("CreationTimeTo(").append(CreationTimeTo).append(")");
		stringBuilder.append("InstrumentCodeOp(").append(InstrumentCodeOp).append(")");
		stringBuilder.append("InstrumentCode(").append(InstrumentCode).append(")");
		return stringBuilder.toString();
	}
}
