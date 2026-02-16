package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_NATIONAL_ID_REGISTRATION extends SMPMessage
{
	public static final long CLASS_ID = 400032;

	private long SubmitterMemberId = 0;
	private long SubmitterTraderId = 0;
	private String SubmitterTraderName = "";
	private long MemberId = 0;
	private BV_NATIONAL_ID_TYPE_Enum NationalIdType = BV_NATIONAL_ID_TYPE_Enum.BV_NATIONAL_ID_TYPE_ID;
	private String NationalIdCode = "";
	private String ShortCode = "";
	private String IdNameDisplay = "";
	private String CountryCodeInvestmentDecision = "";
	private String CountryCodeOrderExecution = "";
	private BV_REGISTRATION_EVENT_Enum Event = BV_REGISTRATION_EVENT_Enum.BV_REGISTRATION_EVENT_Enable;
	private BV_REGISTRATION_STATUS_Enum Status = BV_REGISTRATION_STATUS_Enum.BV_REGISTRATION_STATUS_Enabled;
	private String UserData = "";
	private long CreationDate = 0;
	private long CreationTime = 0;
	private long UpdateDate = 0;
	private long UpdateTime = 0;

	public BV_NATIONAL_ID_REGISTRATION()
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
	public BV_NATIONAL_ID_TYPE_Enum getNationalIdType()
	{
		return NationalIdType;
	}
	public void setNationalIdType(BV_NATIONAL_ID_TYPE_Enum value)
	{
		NationalIdType = value;
	}
	public String getNationalIdCode()
	{
		return NationalIdCode;
	}
	public void setNationalIdCode(String value)
	{
		NationalIdCode = value;
	}
	public String getShortCode()
	{
		return ShortCode;
	}
	public void setShortCode(String value)
	{
		ShortCode = value;
	}
	public String getIdNameDisplay()
	{
		return IdNameDisplay;
	}
	public void setIdNameDisplay(String value)
	{
		IdNameDisplay = value;
	}
	public String getCountryCodeInvestmentDecision()
	{
		return CountryCodeInvestmentDecision;
	}
	public void setCountryCodeInvestmentDecision(String value)
	{
		CountryCodeInvestmentDecision = value;
	}
	public String getCountryCodeOrderExecution()
	{
		return CountryCodeOrderExecution;
	}
	public void setCountryCodeOrderExecution(String value)
	{
		CountryCodeOrderExecution = value;
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
		NationalIdType = NationalIdType.getEnum(byteBuffer.readInt());
		NationalIdCode = byteBuffer.readString();
		ShortCode = byteBuffer.readString();
		IdNameDisplay = byteBuffer.readString();
		CountryCodeInvestmentDecision = byteBuffer.readString();
		CountryCodeOrderExecution = byteBuffer.readString();
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
		byteBuffer.writeInt(NationalIdType.getValue());
		byteBuffer.writeString(NationalIdCode);
		byteBuffer.writeString(ShortCode);
		byteBuffer.writeString(IdNameDisplay);
		byteBuffer.writeString(CountryCodeInvestmentDecision);
		byteBuffer.writeString(CountryCodeOrderExecution);
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
		stringBuilder.append("BV_NATIONAL_ID_REGISTRATION::");
		stringBuilder.append("SubmitterMemberId(").append(SubmitterMemberId).append(")");
		stringBuilder.append("SubmitterTraderId(").append(SubmitterTraderId).append(")");
		stringBuilder.append("SubmitterTraderName(").append(SubmitterTraderName).append(")");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("NationalIdType(").append(NationalIdType).append(")");
		stringBuilder.append("NationalIdCode(").append(NationalIdCode).append(")");
		stringBuilder.append("ShortCode(").append(ShortCode).append(")");
		stringBuilder.append("IdNameDisplay(").append(IdNameDisplay).append(")");
		stringBuilder.append("CountryCodeInvestmentDecision(").append(CountryCodeInvestmentDecision).append(")");
		stringBuilder.append("CountryCodeOrderExecution(").append(CountryCodeOrderExecution).append(")");
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
