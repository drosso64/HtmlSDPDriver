package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_RFCQ_INSTRUMENT_CLASS_ENABLE extends SMPMessage
{
	public static final long CLASS_ID = 100061;

	private long MemberId = 0;
	private long MarketId = 0;
	private long InstrumentClassId = 0;
	private TI_FLAG_Enum RFCQPartialFillFg = TI_FLAG_Enum.TI_FLAG_No;
	private BV_RFCQ_INSTRUMENT_CLASS_ENABLE_EVENT_Enum Event = BV_RFCQ_INSTRUMENT_CLASS_ENABLE_EVENT_Enum.BV_RFCQ_INSTRUMENT_CLASS_ENABLE_EVENT_Insert;
	private BV_RFCQ_INSTRUMENT_CLASS_ENABLE_STATUS_Enum Status = BV_RFCQ_INSTRUMENT_CLASS_ENABLE_STATUS_Enum.BV_RFCQ_INSTRUMENT_CLASS_ENABLE_STATUS_Active;
	private long CreationDate = 0;
	private long CreationTime = 0;
	private long UpdateDate = 0;
	private long UpdateTime = 0;
	private String UserData = "";

	public BV_RFCQ_INSTRUMENT_CLASS_ENABLE()
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
	public long getMarketId()
	{
		return MarketId;
	}
	public void setMarketId(long value)
	{
		MarketId = value;
	}
	public long getInstrumentClassId()
	{
		return InstrumentClassId;
	}
	public void setInstrumentClassId(long value)
	{
		InstrumentClassId = value;
	}
	public TI_FLAG_Enum getRFCQPartialFillFg()
	{
		return RFCQPartialFillFg;
	}
	public void setRFCQPartialFillFg(TI_FLAG_Enum value)
	{
		RFCQPartialFillFg = value;
	}
	public BV_RFCQ_INSTRUMENT_CLASS_ENABLE_EVENT_Enum getEvent()
	{
		return Event;
	}
	public void setEvent(BV_RFCQ_INSTRUMENT_CLASS_ENABLE_EVENT_Enum value)
	{
		Event = value;
	}
	public BV_RFCQ_INSTRUMENT_CLASS_ENABLE_STATUS_Enum getStatus()
	{
		return Status;
	}
	public void setStatus(BV_RFCQ_INSTRUMENT_CLASS_ENABLE_STATUS_Enum value)
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
		MarketId = (long)byteBuffer.readInt();
		InstrumentClassId = (long)byteBuffer.readInt();
		RFCQPartialFillFg = RFCQPartialFillFg.getEnum(byteBuffer.readInt());
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
		byteBuffer.writeInt((int)(MarketId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(InstrumentClassId & 0xFFFFFFFFL));
		byteBuffer.writeInt(RFCQPartialFillFg.getValue());
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
		stringBuilder.append("BV_RFCQ_INSTRUMENT_CLASS_ENABLE::");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("MarketId(").append(MarketId).append(")");
		stringBuilder.append("InstrumentClassId(").append(InstrumentClassId).append(")");
		stringBuilder.append("RFCQPartialFillFg(").append(RFCQPartialFillFg).append(")");
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
