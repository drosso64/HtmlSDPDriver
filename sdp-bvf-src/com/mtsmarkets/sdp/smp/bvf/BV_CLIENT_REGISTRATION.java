package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_CLIENT_REGISTRATION extends SMPMessage
{
	public static final long CLASS_ID = 400031;

	private long SubmitterMemberId = 0;
	private long SubmitterTraderId = 0;
	private String SubmitterTraderName = "";
	private long MemberId = 0;
	private String ClientLeiCode = "";
	private String ClientLeiShortName = "";
	private String IdNameDisplay = "";
	private TI_FLAG_Enum DefaultFg = TI_FLAG_Enum.TI_FLAG_No;
	private BV_REGISTRATION_EVENT_Enum Event = BV_REGISTRATION_EVENT_Enum.BV_REGISTRATION_EVENT_Enable;
	private BV_REGISTRATION_STATUS_Enum Status = BV_REGISTRATION_STATUS_Enum.BV_REGISTRATION_STATUS_Enabled;
	private String UserData = "";
	private long CreationDate = 0;
	private long CreationTime = 0;
	private long UpdateDate = 0;
	private long UpdateTime = 0;

	public BV_CLIENT_REGISTRATION()
	{
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
	public long getMemberId()
	{
		return MemberId;
	}
	public void setMemberId(long value)
	{
		MemberId = value;
	}
	public String getClientLeiCode()
	{
		return ClientLeiCode;
	}
	public void setClientLeiCode(String value)
	{
		ClientLeiCode = value;
	}
	public String getClientLeiShortName()
	{
		return ClientLeiShortName;
	}
	public void setClientLeiShortName(String value)
	{
		ClientLeiShortName = value;
	}
	public String getIdNameDisplay()
	{
		return IdNameDisplay;
	}
	public void setIdNameDisplay(String value)
	{
		IdNameDisplay = value;
	}
	public TI_FLAG_Enum getDefaultFg()
	{
		return DefaultFg;
	}
	public void setDefaultFg(TI_FLAG_Enum value)
	{
		DefaultFg = value;
	}
	public BV_REGISTRATION_EVENT_Enum getEvent()
	{
		return Event;
	}
	public void setEvent(BV_REGISTRATION_EVENT_Enum value)
	{
		Event = value;
	}
	public BV_REGISTRATION_STATUS_Enum getStatus()
	{
		return Status;
	}
	public void setStatus(BV_REGISTRATION_STATUS_Enum value)
	{
		Status = value;
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
		SubmitterMemberId = (long)byteBuffer.readInt();
		SubmitterTraderId = (long)byteBuffer.readInt();
		SubmitterTraderName = byteBuffer.readString();
		MemberId = (long)byteBuffer.readInt();
		ClientLeiCode = byteBuffer.readString();
		ClientLeiShortName = byteBuffer.readString();
		IdNameDisplay = byteBuffer.readString();
		DefaultFg = DefaultFg.getEnum(byteBuffer.readInt());
		Event = Event.getEnum(byteBuffer.readInt());
		Status = Status.getEnum(byteBuffer.readInt());
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

		byteBuffer.writeInt((int)(SubmitterMemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SubmitterTraderId & 0xFFFFFFFFL));
		byteBuffer.writeString(SubmitterTraderName);
		byteBuffer.writeInt((int)(MemberId & 0xFFFFFFFFL));
		byteBuffer.writeString(ClientLeiCode);
		byteBuffer.writeString(ClientLeiShortName);
		byteBuffer.writeString(IdNameDisplay);
		byteBuffer.writeInt(DefaultFg.getValue());
		byteBuffer.writeInt(Event.getValue());
		byteBuffer.writeInt(Status.getValue());
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
		stringBuilder.append("BV_CLIENT_REGISTRATION::");
		stringBuilder.append("SubmitterMemberId(").append(SubmitterMemberId).append(")");
		stringBuilder.append("SubmitterTraderId(").append(SubmitterTraderId).append(")");
		stringBuilder.append("SubmitterTraderName(").append(SubmitterTraderName).append(")");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("ClientLeiCode(").append(ClientLeiCode).append(")");
		stringBuilder.append("ClientLeiShortName(").append(ClientLeiShortName).append(")");
		stringBuilder.append("IdNameDisplay(").append(IdNameDisplay).append(")");
		stringBuilder.append("DefaultFg(").append(DefaultFg).append(")");
		stringBuilder.append("Event(").append(Event).append(")");
		stringBuilder.append("Status(").append(Status).append(")");
		stringBuilder.append("UserData(").append(UserData).append(")");
		stringBuilder.append("CreationDate(").append(CreationDate).append(")");
		stringBuilder.append("CreationTime(").append(CreationTime).append(")");
		stringBuilder.append("UpdateDate(").append(UpdateDate).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		return stringBuilder.toString();
	}
}
