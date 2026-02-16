package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_AUTO_EXECUTION_CRITERIA extends SMPMessage
{
	public static final long CLASS_ID = 400021;

	private long MemberId = 0;
	private long TraderId = 0;
	private String TraderName = "";
	private long ResidualMaturityId = 0;
	private long InstrumentClassId = 0;
	private BV_AUTO_EXECUTION_CRITERIA_EVENT_Enum Event = BV_AUTO_EXECUTION_CRITERIA_EVENT_Enum.BV_AUTO_EXECUTION_CRITERIA_EVENT_Insert;
	private BV_AUTO_EXECUTION_CRITERIA_STATUS_Enum Status = BV_AUTO_EXECUTION_CRITERIA_STATUS_Enum.BV_AUTO_EXECUTION_CRITERIA_STATUS_Active;
	private double MaxNominalQuantity = 0;
	private short MinNumDealers = 0;
	private String UserData = "";
	private long CreationDate = 0;
	private long CreationTime = 0;
	private long UpdateDate = 0;
	private long UpdateTime = 0;

	public BV_AUTO_EXECUTION_CRITERIA()
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
	public long getResidualMaturityId()
	{
		return ResidualMaturityId;
	}
	public void setResidualMaturityId(long value)
	{
		ResidualMaturityId = value;
	}
	public long getInstrumentClassId()
	{
		return InstrumentClassId;
	}
	public void setInstrumentClassId(long value)
	{
		InstrumentClassId = value;
	}
	public BV_AUTO_EXECUTION_CRITERIA_EVENT_Enum getEvent()
	{
		return Event;
	}
	public void setEvent(BV_AUTO_EXECUTION_CRITERIA_EVENT_Enum value)
	{
		Event = value;
	}
	public BV_AUTO_EXECUTION_CRITERIA_STATUS_Enum getStatus()
	{
		return Status;
	}
	public void setStatus(BV_AUTO_EXECUTION_CRITERIA_STATUS_Enum value)
	{
		Status = value;
	}
	public double getMaxNominalQuantity()
	{
		return MaxNominalQuantity;
	}
	public void setMaxNominalQuantity(double value)
	{
		MaxNominalQuantity = value;
	}
	public short getMinNumDealers()
	{
		return MinNumDealers;
	}
	public void setMinNumDealers(short value)
	{
		MinNumDealers = value;
	}
	public String getUserData()
	{
		return UserData;
	}
	public void setUserData(String value)
	{
		UserData = value;
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

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MemberId = (long)byteBuffer.readInt();
		TraderId = (long)byteBuffer.readInt();
		TraderName = byteBuffer.readString();
		ResidualMaturityId = (long)byteBuffer.readInt();
		InstrumentClassId = (long)byteBuffer.readInt();
		Event = Event.getEnum(byteBuffer.readInt());
		Status = Status.getEnum(byteBuffer.readInt());
		MaxNominalQuantity = byteBuffer.readDouble();
		MinNumDealers = (short)byteBuffer.readInt();
		UserData = byteBuffer.readString();
		CreationDate = (long)byteBuffer.readInt();
		CreationTime = byteBuffer.readLong();
		UpdateDate = (long)byteBuffer.readInt();
		UpdateTime = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(TraderId & 0xFFFFFFFFL));
		byteBuffer.writeString(TraderName);
		byteBuffer.writeInt((int)(ResidualMaturityId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(InstrumentClassId & 0xFFFFFFFFL));
		byteBuffer.writeInt(Event.getValue());
		byteBuffer.writeInt(Status.getValue());
		byteBuffer.writeDouble(MaxNominalQuantity);
		byteBuffer.writeInt((int)(MinNumDealers & 0xFFFFL));
		byteBuffer.writeString(UserData);
		byteBuffer.writeInt((int)(CreationDate & 0xFFFFFFFFL));
		byteBuffer.writeLong(CreationTime);
		byteBuffer.writeInt((int)(UpdateDate & 0xFFFFFFFFL));
		byteBuffer.writeLong(UpdateTime);

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
		stringBuilder.append("BV_AUTO_EXECUTION_CRITERIA::");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("TraderId(").append(TraderId).append(")");
		stringBuilder.append("TraderName(").append(TraderName).append(")");
		stringBuilder.append("ResidualMaturityId(").append(ResidualMaturityId).append(")");
		stringBuilder.append("InstrumentClassId(").append(InstrumentClassId).append(")");
		stringBuilder.append("Event(").append(Event).append(")");
		stringBuilder.append("Status(").append(Status).append(")");
		stringBuilder.append("MaxNominalQuantity(").append(MaxNominalQuantity).append(")");
		stringBuilder.append("MinNumDealers(").append(MinNumDealers).append(")");
		stringBuilder.append("UserData(").append(UserData).append(")");
		stringBuilder.append("CreationDate(").append(CreationDate).append(")");
		stringBuilder.append("CreationTime(").append(CreationTime).append(")");
		stringBuilder.append("UpdateDate(").append(UpdateDate).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		return stringBuilder.toString();
	}
}
