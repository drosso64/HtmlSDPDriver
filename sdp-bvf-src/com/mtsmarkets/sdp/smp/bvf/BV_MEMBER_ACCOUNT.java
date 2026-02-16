package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_MEMBER_ACCOUNT extends SMPMessage
{
	public static final long CLASS_ID = 100064;

	private long OwnerId = 0;
	private long AccountId = 0;
	private String AccountCode = "";
	private String AccountInfo = "";
	private String ClearingInfo = "";
	private long SubmitterMemberId = 0;
	private long SubmitterTraderId = 0;
	private String SubmitterTraderName = "";
	private BV_MEMBER_ACCOUNT_EVENT_Enum Event = BV_MEMBER_ACCOUNT_EVENT_Enum.BV_MEMBER_ACCOUNT_EVENT_Insert;
	private BV_MEMBER_ACCOUNT_STATUS_Enum Status = BV_MEMBER_ACCOUNT_STATUS_Enum.BV_MEMBER_ACCOUNT_STATUS_Active;
	private long CreationDate = 0;
	private long CreationTime = 0;
	private long UpdateDate = 0;
	private long UpdateTime = 0;

	public BV_MEMBER_ACCOUNT()
	{
	}

	public long getOwnerId()
	{
		return OwnerId;
	}
	public void setOwnerId(long value)
	{
		OwnerId = value;
	}
	public long getAccountId()
	{
		return AccountId;
	}
	public void setAccountId(long value)
	{
		AccountId = value;
	}
	public String getAccountCode()
	{
		return AccountCode;
	}
	public void setAccountCode(String value)
	{
		AccountCode = value;
	}
	public String getAccountInfo()
	{
		return AccountInfo;
	}
	public void setAccountInfo(String value)
	{
		AccountInfo = value;
	}
	public String getClearingInfo()
	{
		return ClearingInfo;
	}
	public void setClearingInfo(String value)
	{
		ClearingInfo = value;
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
	public BV_MEMBER_ACCOUNT_EVENT_Enum getEvent()
	{
		return Event;
	}
	public void setEvent(BV_MEMBER_ACCOUNT_EVENT_Enum value)
	{
		Event = value;
	}
	public BV_MEMBER_ACCOUNT_STATUS_Enum getStatus()
	{
		return Status;
	}
	public void setStatus(BV_MEMBER_ACCOUNT_STATUS_Enum value)
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

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		OwnerId = (long)byteBuffer.readInt();
		AccountId = (long)byteBuffer.readInt();
		AccountCode = byteBuffer.readString();
		AccountInfo = byteBuffer.readString();
		ClearingInfo = byteBuffer.readString();
		SubmitterMemberId = (long)byteBuffer.readInt();
		SubmitterTraderId = (long)byteBuffer.readInt();
		SubmitterTraderName = byteBuffer.readString();
		Event = Event.getEnum(byteBuffer.readInt());
		Status = Status.getEnum(byteBuffer.readInt());
		CreationDate = (long)byteBuffer.readInt();
		CreationTime = byteBuffer.readLong();
		UpdateDate = (long)byteBuffer.readInt();
		UpdateTime = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(OwnerId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(AccountId & 0xFFFFFFFFL));
		byteBuffer.writeString(AccountCode);
		byteBuffer.writeString(AccountInfo);
		byteBuffer.writeString(ClearingInfo);
		byteBuffer.writeInt((int)(SubmitterMemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SubmitterTraderId & 0xFFFFFFFFL));
		byteBuffer.writeString(SubmitterTraderName);
		byteBuffer.writeInt(Event.getValue());
		byteBuffer.writeInt(Status.getValue());
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
		stringBuilder.append("BV_MEMBER_ACCOUNT::");
		stringBuilder.append("OwnerId(").append(OwnerId).append(")");
		stringBuilder.append("AccountId(").append(AccountId).append(")");
		stringBuilder.append("AccountCode(").append(AccountCode).append(")");
		stringBuilder.append("AccountInfo(").append(AccountInfo).append(")");
		stringBuilder.append("ClearingInfo(").append(ClearingInfo).append(")");
		stringBuilder.append("SubmitterMemberId(").append(SubmitterMemberId).append(")");
		stringBuilder.append("SubmitterTraderId(").append(SubmitterTraderId).append(")");
		stringBuilder.append("SubmitterTraderName(").append(SubmitterTraderName).append(")");
		stringBuilder.append("Event(").append(Event).append(")");
		stringBuilder.append("Status(").append(Status).append(")");
		stringBuilder.append("CreationDate(").append(CreationDate).append(")");
		stringBuilder.append("CreationTime(").append(CreationTime).append(")");
		stringBuilder.append("UpdateDate(").append(UpdateDate).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		return stringBuilder.toString();
	}
}
