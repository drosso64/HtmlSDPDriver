package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_INSTRUMENT_GROUP extends SMPMessage
{
	public static final long CLASS_ID = 114110;

	private long MarketId = 0;
	private long GroupId = 0;
	private String GroupName = "";
	private BV_INSTRUMENT_GROUP_TYPE_Enum GroupType = BV_INSTRUMENT_GROUP_TYPE_Enum.BV_INSTRUMENT_GROUP_TYPE_InfoFilter;
	private BV_INSTRUMENT_GROUP_LEVEL_Enum GroupLevel = BV_INSTRUMENT_GROUP_LEVEL_Enum.BV_INSTRUMENT_GROUP_LEVEL_None;
	private long ParentGroupId = 0;
	private long SortNumber = 0;
	private BV_INSTRUMENT_GROUP_STATUS_Enum Status = BV_INSTRUMENT_GROUP_STATUS_Enum.BV_INSTRUMENT_GROUP_STATUS_Active;
	private long CreationDate = 0;
	private long CreationTime = 0;
	private long UpdateDate = 0;
	private long UpdateTime = 0;
	private TI_FLAG_Enum AutoExecutionFg = TI_FLAG_Enum.TI_FLAG_No;

	public BV_INSTRUMENT_GROUP()
	{
	}

	public long getMarketId()
	{
		return MarketId;
	}
	public void setMarketId(long value)
	{
		MarketId = value;
	}
	public long getGroupId()
	{
		return GroupId;
	}
	public void setGroupId(long value)
	{
		GroupId = value;
	}
	public String getGroupName()
	{
		return GroupName;
	}
	public void setGroupName(String value)
	{
		GroupName = value;
	}
	public BV_INSTRUMENT_GROUP_TYPE_Enum getGroupType()
	{
		return GroupType;
	}
	public void setGroupType(BV_INSTRUMENT_GROUP_TYPE_Enum value)
	{
		GroupType = value;
	}
	public BV_INSTRUMENT_GROUP_LEVEL_Enum getGroupLevel()
	{
		return GroupLevel;
	}
	public void setGroupLevel(BV_INSTRUMENT_GROUP_LEVEL_Enum value)
	{
		GroupLevel = value;
	}
	public long getParentGroupId()
	{
		return ParentGroupId;
	}
	public void setParentGroupId(long value)
	{
		ParentGroupId = value;
	}
	public long getSortNumber()
	{
		return SortNumber;
	}
	public void setSortNumber(long value)
	{
		SortNumber = value;
	}
	public BV_INSTRUMENT_GROUP_STATUS_Enum getStatus()
	{
		return Status;
	}
	public void setStatus(BV_INSTRUMENT_GROUP_STATUS_Enum value)
	{
		Status = value;
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
	public TI_FLAG_Enum getAutoExecutionFg()
	{
		return AutoExecutionFg;
	}
	public void setAutoExecutionFg(TI_FLAG_Enum value)
	{
		AutoExecutionFg = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MarketId = (long)byteBuffer.readInt();
		GroupId = (long)byteBuffer.readInt();
		GroupName = byteBuffer.readString();
		GroupType = GroupType.getEnum(byteBuffer.readInt());
		GroupLevel = GroupLevel.getEnum(byteBuffer.readInt());
		ParentGroupId = (long)byteBuffer.readInt();
		SortNumber = (long)byteBuffer.readInt();
		Status = Status.getEnum(byteBuffer.readInt());
		CreationDate = (long)byteBuffer.readInt();
		CreationTime = byteBuffer.readLong();
		UpdateDate = (long)byteBuffer.readInt();
		UpdateTime = byteBuffer.readLong();
		AutoExecutionFg = AutoExecutionFg.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MarketId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(GroupId & 0xFFFFFFFFL));
		byteBuffer.writeString(GroupName);
		byteBuffer.writeInt(GroupType.getValue());
		byteBuffer.writeInt(GroupLevel.getValue());
		byteBuffer.writeInt((int)(ParentGroupId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SortNumber & 0xFFFFFFFFL));
		byteBuffer.writeInt(Status.getValue());
		byteBuffer.writeInt((int)(CreationDate & 0xFFFFFFFFL));
		byteBuffer.writeLong(CreationTime);
		byteBuffer.writeInt((int)(UpdateDate & 0xFFFFFFFFL));
		byteBuffer.writeLong(UpdateTime);
		byteBuffer.writeInt(AutoExecutionFg.getValue());

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
		stringBuilder.append("BV_INSTRUMENT_GROUP::");
		stringBuilder.append("MarketId(").append(MarketId).append(")");
		stringBuilder.append("GroupId(").append(GroupId).append(")");
		stringBuilder.append("GroupName(").append(GroupName).append(")");
		stringBuilder.append("GroupType(").append(GroupType).append(")");
		stringBuilder.append("GroupLevel(").append(GroupLevel).append(")");
		stringBuilder.append("ParentGroupId(").append(ParentGroupId).append(")");
		stringBuilder.append("SortNumber(").append(SortNumber).append(")");
		stringBuilder.append("Status(").append(Status).append(")");
		stringBuilder.append("CreationDate(").append(CreationDate).append(")");
		stringBuilder.append("CreationTime(").append(CreationTime).append(")");
		stringBuilder.append("UpdateDate(").append(UpdateDate).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		stringBuilder.append("AutoExecutionFg(").append(AutoExecutionFg).append(")");
		return stringBuilder.toString();
	}
}
