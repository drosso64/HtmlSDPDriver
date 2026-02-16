package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class DF_BV_INVENTORY_GROUP_RFCQ_OPTION extends SMPMessage
{
	public static final long CLASS_ID = 114001;

	private long MemberId = 0;
	private long InstrumentClassId = 0;
	private long InventoryGroupId = 0;
	private BV_INVENTORY_GROUP_RFCQ_OPTION_EVENT_Enum Event = BV_INVENTORY_GROUP_RFCQ_OPTION_EVENT_Enum.BV_INVENTORY_GROUP_RFCQ_OPTION_EVENT_Insert;
	private BV_INVENTORY_GROUP_RFCQ_OPTION_STATUS_Enum Status = BV_INVENTORY_GROUP_RFCQ_OPTION_STATUS_Enum.BV_INVENTORY_GROUP_RFCQ_OPTION_STATUS_Active;
	private TI_FLAG_Enum RFCQAcceptedFg = TI_FLAG_Enum.TI_FLAG_No;
	private long CreationDate = 0;
	private long CreationTime = 0;
	private long UpdateDate = 0;
	private long UpdateTime = 0;
	private long SubmitterMemberId = 0;
	private long SubmitterTraderId = 0;
	private String SubmitterTraderName = "";
	private String UserData = "";

	public DF_BV_INVENTORY_GROUP_RFCQ_OPTION()
	{
	}

	public long getMemberId()
	{
		return MemberId;
	}
	public void setMemberId(long value)
	{
		MemberId = value;
	}
	public long getInstrumentClassId()
	{
		return InstrumentClassId;
	}
	public void setInstrumentClassId(long value)
	{
		InstrumentClassId = value;
	}
	public long getInventoryGroupId()
	{
		return InventoryGroupId;
	}
	public void setInventoryGroupId(long value)
	{
		InventoryGroupId = value;
	}
	public BV_INVENTORY_GROUP_RFCQ_OPTION_EVENT_Enum getEvent()
	{
		return Event;
	}
	public void setEvent(BV_INVENTORY_GROUP_RFCQ_OPTION_EVENT_Enum value)
	{
		Event = value;
	}
	public BV_INVENTORY_GROUP_RFCQ_OPTION_STATUS_Enum getStatus()
	{
		return Status;
	}
	public void setStatus(BV_INVENTORY_GROUP_RFCQ_OPTION_STATUS_Enum value)
	{
		Status = value;
	}
	public TI_FLAG_Enum getRFCQAcceptedFg()
	{
		return RFCQAcceptedFg;
	}
	public void setRFCQAcceptedFg(TI_FLAG_Enum value)
	{
		RFCQAcceptedFg = value;
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
	public long getUpdateDate()
	{
		return UpdateDate;
	}
	public void setUpdateDate(long value)
	{
		UpdateDate = value;
	}
	public long getUpdateTime()
	{
		return UpdateTime;
	}
	public void setUpdateTime(long value)
	{
		UpdateTime = value;
	}
	public long getSubmitterMemberId()
	{
		return SubmitterMemberId;
	}
	public void setSubmitterMemberId(long value)
	{
		SubmitterMemberId = value;
	}
	public long getSubmitterTraderId()
	{
		return SubmitterTraderId;
	}
	public void setSubmitterTraderId(long value)
	{
		SubmitterTraderId = value;
	}
	public String getSubmitterTraderName()
	{
		return SubmitterTraderName;
	}
	public void setSubmitterTraderName(String value)
	{
		SubmitterTraderName = value;
	}
	public String getUserData()
	{
		return UserData;
	}
	public void setUserData(String value)
	{
		UserData = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MemberId = (long)byteBuffer.readInt();
		InstrumentClassId = (long)byteBuffer.readInt();
		InventoryGroupId = (long)byteBuffer.readInt();
		Event = Event.getEnum(byteBuffer.readInt());
		Status = Status.getEnum(byteBuffer.readInt());
		RFCQAcceptedFg = RFCQAcceptedFg.getEnum(byteBuffer.readInt());
		CreationDate = (long)byteBuffer.readInt();
		CreationTime = byteBuffer.readLong();
		UpdateDate = (long)byteBuffer.readInt();
		UpdateTime = byteBuffer.readLong();
		SubmitterMemberId = (long)byteBuffer.readInt();
		SubmitterTraderId = (long)byteBuffer.readInt();
		SubmitterTraderName = byteBuffer.readString();
		UserData = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(InstrumentClassId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(InventoryGroupId & 0xFFFFFFFFL));
		byteBuffer.writeInt(Event.getValue());
		byteBuffer.writeInt(Status.getValue());
		byteBuffer.writeInt(RFCQAcceptedFg.getValue());
		byteBuffer.writeInt((int)(CreationDate & 0xFFFFFFFFL));
		byteBuffer.writeLong(CreationTime);
		byteBuffer.writeInt((int)(UpdateDate & 0xFFFFFFFFL));
		byteBuffer.writeLong(UpdateTime);
		byteBuffer.writeInt((int)(SubmitterMemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SubmitterTraderId & 0xFFFFFFFFL));
		byteBuffer.writeString(SubmitterTraderName);
		byteBuffer.writeString(UserData);

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
		stringBuilder.append("DF_BV_INVENTORY_GROUP_RFCQ_OPTION::");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("InstrumentClassId(").append(InstrumentClassId).append(")");
		stringBuilder.append("InventoryGroupId(").append(InventoryGroupId).append(")");
		stringBuilder.append("Event(").append(Event).append(")");
		stringBuilder.append("Status(").append(Status).append(")");
		stringBuilder.append("RFCQAcceptedFg(").append(RFCQAcceptedFg).append(")");
		stringBuilder.append("CreationDate(").append(CreationDate).append(")");
		stringBuilder.append("CreationTime(").append(CreationTime).append(")");
		stringBuilder.append("UpdateDate(").append(UpdateDate).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		stringBuilder.append("SubmitterMemberId(").append(SubmitterMemberId).append(")");
		stringBuilder.append("SubmitterTraderId(").append(SubmitterTraderId).append(")");
		stringBuilder.append("SubmitterTraderName(").append(SubmitterTraderName).append(")");
		stringBuilder.append("UserData(").append(UserData).append(")");
		return stringBuilder.toString();
	}
}
