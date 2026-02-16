package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_DEALER_GROUP extends SMPMessage
{
	public static final long CLASS_ID = 400038;

	private long MemberId = 0;
	private long TraderId = 0;
	private String TraderName = "";
	private long OwnerTraderId = 0;
	private String OwnerTraderName = "";
	private long GroupId = 0;
	private String GroupName = "";
	private short DealersNum = 0;
	private long[] Dealers = new long[100];
	private BV_DEALER_GROUP_EVENT_Enum Event = BV_DEALER_GROUP_EVENT_Enum.BV_DEALER_GROUP_EVENT_Insert;
	private BV_DEALER_GROUP_STATUS_Enum Status = BV_DEALER_GROUP_STATUS_Enum.BV_DEALER_GROUP_STATUS_Active;
	private long CreationDate = 0;
	private long CreationTime = 0;
	private long UpdateDate = 0;
	private long UpdateTime = 0;
	private String UserData = "";

	public BV_DEALER_GROUP()
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
	public long getTraderId()
	{
		return TraderId;
	}
	public void setTraderId(long value)
	{
		TraderId = value;
	}
	public String getTraderName()
	{
		return TraderName;
	}
	public void setTraderName(String value)
	{
		TraderName = value;
	}
	public long getOwnerTraderId()
	{
		return OwnerTraderId;
	}
	public void setOwnerTraderId(long value)
	{
		OwnerTraderId = value;
	}
	public String getOwnerTraderName()
	{
		return OwnerTraderName;
	}
	public void setOwnerTraderName(String value)
	{
		OwnerTraderName = value;
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
	public short getDealersNum()
	{
		return DealersNum;
	}
	public void setDealersNum(short value)
	{
		DealersNum = value;
	}
	public long[] getDealers()
	{
		return Dealers;
	}
	public void setDealers(long[] value)
	{
		Dealers = value;
	}
	public BV_DEALER_GROUP_EVENT_Enum getEvent()
	{
		return Event;
	}
	public void setEvent(BV_DEALER_GROUP_EVENT_Enum value)
	{
		Event = value;
	}
	public BV_DEALER_GROUP_STATUS_Enum getStatus()
	{
		return Status;
	}
	public void setStatus(BV_DEALER_GROUP_STATUS_Enum value)
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
		TraderId = (long)byteBuffer.readInt();
		TraderName = byteBuffer.readString();
		OwnerTraderId = (long)byteBuffer.readInt();
		OwnerTraderName = byteBuffer.readString();
		GroupId = (long)byteBuffer.readInt();
		GroupName = byteBuffer.readString();
		DealersNum = (short)byteBuffer.readInt();
		for (int i=0; i < Dealers.length; ++i)
		{
			Dealers[i] = (long)byteBuffer.readInt();
		}
		Event = Event.getEnum(byteBuffer.readInt());
		Status = Status.getEnum(byteBuffer.readInt());
		CreationDate = (long)byteBuffer.readInt();
		CreationTime = byteBuffer.readLong();
		UpdateDate = (long)byteBuffer.readInt();
		UpdateTime = byteBuffer.readLong();
		UserData = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(TraderId & 0xFFFFFFFFL));
		byteBuffer.writeString(TraderName);
		byteBuffer.writeInt((int)(OwnerTraderId & 0xFFFFFFFFL));
		byteBuffer.writeString(OwnerTraderName);
		byteBuffer.writeInt((int)(GroupId & 0xFFFFFFFFL));
		byteBuffer.writeString(GroupName);
		byteBuffer.writeInt((int)(DealersNum & 0xFFFFL));
		for (int i=0; i < Dealers.length; ++i)
		{
			byteBuffer.writeInt((int)(Dealers[i] & 0xFFFFFFFFL));
		}
		byteBuffer.writeInt(Event.getValue());
		byteBuffer.writeInt(Status.getValue());
		byteBuffer.writeInt((int)(CreationDate & 0xFFFFFFFFL));
		byteBuffer.writeLong(CreationTime);
		byteBuffer.writeInt((int)(UpdateDate & 0xFFFFFFFFL));
		byteBuffer.writeLong(UpdateTime);
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
		stringBuilder.append("BV_DEALER_GROUP::");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("TraderId(").append(TraderId).append(")");
		stringBuilder.append("TraderName(").append(TraderName).append(")");
		stringBuilder.append("OwnerTraderId(").append(OwnerTraderId).append(")");
		stringBuilder.append("OwnerTraderName(").append(OwnerTraderName).append(")");
		stringBuilder.append("GroupId(").append(GroupId).append(")");
		stringBuilder.append("GroupName(").append(GroupName).append(")");
		stringBuilder.append("DealersNum(").append(DealersNum).append(")");
		for (int i=0; i < Dealers.length; ++i)
		{
			stringBuilder.append("Dealers[").append(i).append("](").append(Dealers[i]).append(")");
		}
		stringBuilder.append("Event(").append(Event).append(")");
		stringBuilder.append("Status(").append(Status).append(")");
		stringBuilder.append("CreationDate(").append(CreationDate).append(")");
		stringBuilder.append("CreationTime(").append(CreationTime).append(")");
		stringBuilder.append("UpdateDate(").append(UpdateDate).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		stringBuilder.append("UserData(").append(UserData).append(")");
		return stringBuilder.toString();
	}
}
