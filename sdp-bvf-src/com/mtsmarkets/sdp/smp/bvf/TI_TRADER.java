package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_TRADER extends SMPMessage
{
	public static final long CLASS_ID = 100025;

	private long MemberId = 0;
	private long TraderId = 0;
	private String TraderName = "";
	private TI_TRADER_TYPE_Enum TraderType = TI_TRADER_TYPE_Enum.TI_TRADER_TYPE_Manager;
	private long GroupId = 0;
	private TI_TRADER_ACCOUNT_STATUS_Enum TraderAccountStatus = TI_TRADER_ACCOUNT_STATUS_Enum.TI_TRADER_ACCOUNT_STATUS_Inactive;
	private short PasswordExpiryPeriod = 0;
	private long PasswordExpiryDate = 0;
	private TI_FLAG_Enum FixedWindowSizeFlag = TI_FLAG_Enum.TI_FLAG_No;
	private long VariableWindowSize = 0;
	private long StartDate = 0;
	private long StopDate = 0;
	private String Password = "";
	private TI_FLAG_Enum MultiTraderSlaveFg = TI_FLAG_Enum.TI_FLAG_No;
	private TI_FLAG_Enum MultiTraderMasterFg = TI_FLAG_Enum.TI_FLAG_No;
	private short WorkstationLockTimeout = 0;
	private String FirstName = "";
	private String LastName = "";
	private String Email = "";
	private String Phone = "";
	private String Fax = "";
	private String OtherInfo = "";
	private String OtherInfo2 = "";
	private long TemplateId = 0;
	private String TemplateDescription = "";
	private TI_FLAG_Enum MTSCertifiedFg = TI_FLAG_Enum.TI_FLAG_No;
	private long SubmitterMemberId = 0;
	private long SubmitterTraderId = 0;
	private String SubmitterTraderName = "";
	private long CreationDate = 0;
	private long CreationTime = 0;
	private long UpdateDate = 0;
	private long UpdateTime = 0;

	public TI_TRADER()
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
	public TI_TRADER_TYPE_Enum getTraderType()
	{
		return TraderType;
	}
	public void setTraderType(TI_TRADER_TYPE_Enum value)
	{
		TraderType = value;
	}
	public long getGroupId()
	{
		return GroupId;
	}
	public void setGroupId(long value)
	{
		GroupId = value;
	}
	public TI_TRADER_ACCOUNT_STATUS_Enum getTraderAccountStatus()
	{
		return TraderAccountStatus;
	}
	public void setTraderAccountStatus(TI_TRADER_ACCOUNT_STATUS_Enum value)
	{
		TraderAccountStatus = value;
	}
	public short getPasswordExpiryPeriod()
	{
		return PasswordExpiryPeriod;
	}
	public void setPasswordExpiryPeriod(short value)
	{
		PasswordExpiryPeriod = value;
	}
	public long getPasswordExpiryDate()
	{
		return PasswordExpiryDate;
	}
	public void setPasswordExpiryDate(long value)
	{
		PasswordExpiryDate = value;
	}
	public TI_FLAG_Enum getFixedWindowSizeFlag()
	{
		return FixedWindowSizeFlag;
	}
	public void setFixedWindowSizeFlag(TI_FLAG_Enum value)
	{
		FixedWindowSizeFlag = value;
	}
	public long getVariableWindowSize()
	{
		return VariableWindowSize;
	}
	public void setVariableWindowSize(long value)
	{
		VariableWindowSize = value;
	}
	public long getStartDate()
	{
		return StartDate;
	}
	public void setStartDate(long value)
	{
		StartDate = value;
	}
	public long getStopDate()
	{
		return StopDate;
	}
	public void setStopDate(long value)
	{
		StopDate = value;
	}
	public String getPassword()
	{
		return Password;
	}
	public void setPassword(String value)
	{
		Password = value;
	}
	public TI_FLAG_Enum getMultiTraderSlaveFg()
	{
		return MultiTraderSlaveFg;
	}
	public void setMultiTraderSlaveFg(TI_FLAG_Enum value)
	{
		MultiTraderSlaveFg = value;
	}
	public TI_FLAG_Enum getMultiTraderMasterFg()
	{
		return MultiTraderMasterFg;
	}
	public void setMultiTraderMasterFg(TI_FLAG_Enum value)
	{
		MultiTraderMasterFg = value;
	}
	public short getWorkstationLockTimeout()
	{
		return WorkstationLockTimeout;
	}
	public void setWorkstationLockTimeout(short value)
	{
		WorkstationLockTimeout = value;
	}
	public String getFirstName()
	{
		return FirstName;
	}
	public void setFirstName(String value)
	{
		FirstName = value;
	}
	public String getLastName()
	{
		return LastName;
	}
	public void setLastName(String value)
	{
		LastName = value;
	}
	public String getEmail()
	{
		return Email;
	}
	public void setEmail(String value)
	{
		Email = value;
	}
	public String getPhone()
	{
		return Phone;
	}
	public void setPhone(String value)
	{
		Phone = value;
	}
	public String getFax()
	{
		return Fax;
	}
	public void setFax(String value)
	{
		Fax = value;
	}
	public String getOtherInfo()
	{
		return OtherInfo;
	}
	public void setOtherInfo(String value)
	{
		OtherInfo = value;
	}
	public String getOtherInfo2()
	{
		return OtherInfo2;
	}
	public void setOtherInfo2(String value)
	{
		OtherInfo2 = value;
	}
	public long getTemplateId()
	{
		return TemplateId;
	}
	public void setTemplateId(long value)
	{
		TemplateId = value;
	}
	public String getTemplateDescription()
	{
		return TemplateDescription;
	}
	public void setTemplateDescription(String value)
	{
		TemplateDescription = value;
	}
	public TI_FLAG_Enum getMTSCertifiedFg()
	{
		return MTSCertifiedFg;
	}
	public void setMTSCertifiedFg(TI_FLAG_Enum value)
	{
		MTSCertifiedFg = value;
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
		TraderType = TraderType.getEnum(byteBuffer.readInt());
		GroupId = (long)byteBuffer.readInt();
		TraderAccountStatus = TraderAccountStatus.getEnum(byteBuffer.readInt());
		PasswordExpiryPeriod = (short)byteBuffer.readInt();
		PasswordExpiryDate = (long)byteBuffer.readInt();
		FixedWindowSizeFlag = FixedWindowSizeFlag.getEnum(byteBuffer.readInt());
		VariableWindowSize = (long)byteBuffer.readInt();
		StartDate = (long)byteBuffer.readInt();
		StopDate = (long)byteBuffer.readInt();
		Password = byteBuffer.readString();
		MultiTraderSlaveFg = MultiTraderSlaveFg.getEnum(byteBuffer.readInt());
		MultiTraderMasterFg = MultiTraderMasterFg.getEnum(byteBuffer.readInt());
		WorkstationLockTimeout = (short)byteBuffer.readInt();
		FirstName = byteBuffer.readString();
		LastName = byteBuffer.readString();
		Email = byteBuffer.readString();
		Phone = byteBuffer.readString();
		Fax = byteBuffer.readString();
		OtherInfo = byteBuffer.readString();
		OtherInfo2 = byteBuffer.readString();
		TemplateId = (long)byteBuffer.readInt();
		TemplateDescription = byteBuffer.readString();
		MTSCertifiedFg = MTSCertifiedFg.getEnum(byteBuffer.readInt());
		SubmitterMemberId = (long)byteBuffer.readInt();
		SubmitterTraderId = (long)byteBuffer.readInt();
		SubmitterTraderName = byteBuffer.readString();
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
		byteBuffer.writeInt(TraderType.getValue());
		byteBuffer.writeInt((int)(GroupId & 0xFFFFFFFFL));
		byteBuffer.writeInt(TraderAccountStatus.getValue());
		byteBuffer.writeInt((int)(PasswordExpiryPeriod & 0xFFFFL));
		byteBuffer.writeInt((int)(PasswordExpiryDate & 0xFFFFFFFFL));
		byteBuffer.writeInt(FixedWindowSizeFlag.getValue());
		byteBuffer.writeInt((int)(VariableWindowSize & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(StartDate & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(StopDate & 0xFFFFFFFFL));
		byteBuffer.writeString(Password);
		byteBuffer.writeInt(MultiTraderSlaveFg.getValue());
		byteBuffer.writeInt(MultiTraderMasterFg.getValue());
		byteBuffer.writeInt((int)(WorkstationLockTimeout & 0xFFFFL));
		byteBuffer.writeString(FirstName);
		byteBuffer.writeString(LastName);
		byteBuffer.writeString(Email);
		byteBuffer.writeString(Phone);
		byteBuffer.writeString(Fax);
		byteBuffer.writeString(OtherInfo);
		byteBuffer.writeString(OtherInfo2);
		byteBuffer.writeInt((int)(TemplateId & 0xFFFFFFFFL));
		byteBuffer.writeString(TemplateDescription);
		byteBuffer.writeInt(MTSCertifiedFg.getValue());
		byteBuffer.writeInt((int)(SubmitterMemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SubmitterTraderId & 0xFFFFFFFFL));
		byteBuffer.writeString(SubmitterTraderName);
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
		stringBuilder.append("TI_TRADER::");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("TraderId(").append(TraderId).append(")");
		stringBuilder.append("TraderName(").append(TraderName).append(")");
		stringBuilder.append("TraderType(").append(TraderType).append(")");
		stringBuilder.append("GroupId(").append(GroupId).append(")");
		stringBuilder.append("TraderAccountStatus(").append(TraderAccountStatus).append(")");
		stringBuilder.append("PasswordExpiryPeriod(").append(PasswordExpiryPeriod).append(")");
		stringBuilder.append("PasswordExpiryDate(").append(PasswordExpiryDate).append(")");
		stringBuilder.append("FixedWindowSizeFlag(").append(FixedWindowSizeFlag).append(")");
		stringBuilder.append("VariableWindowSize(").append(VariableWindowSize).append(")");
		stringBuilder.append("StartDate(").append(StartDate).append(")");
		stringBuilder.append("StopDate(").append(StopDate).append(")");
		stringBuilder.append("Password(").append(Password).append(")");
		stringBuilder.append("MultiTraderSlaveFg(").append(MultiTraderSlaveFg).append(")");
		stringBuilder.append("MultiTraderMasterFg(").append(MultiTraderMasterFg).append(")");
		stringBuilder.append("WorkstationLockTimeout(").append(WorkstationLockTimeout).append(")");
		stringBuilder.append("FirstName(").append(FirstName).append(")");
		stringBuilder.append("LastName(").append(LastName).append(")");
		stringBuilder.append("Email(").append(Email).append(")");
		stringBuilder.append("Phone(").append(Phone).append(")");
		stringBuilder.append("Fax(").append(Fax).append(")");
		stringBuilder.append("OtherInfo(").append(OtherInfo).append(")");
		stringBuilder.append("OtherInfo2(").append(OtherInfo2).append(")");
		stringBuilder.append("TemplateId(").append(TemplateId).append(")");
		stringBuilder.append("TemplateDescription(").append(TemplateDescription).append(")");
		stringBuilder.append("MTSCertifiedFg(").append(MTSCertifiedFg).append(")");
		stringBuilder.append("SubmitterMemberId(").append(SubmitterMemberId).append(")");
		stringBuilder.append("SubmitterTraderId(").append(SubmitterTraderId).append(")");
		stringBuilder.append("SubmitterTraderName(").append(SubmitterTraderName).append(")");
		stringBuilder.append("CreationDate(").append(CreationDate).append(")");
		stringBuilder.append("CreationTime(").append(CreationTime).append(")");
		stringBuilder.append("UpdateDate(").append(UpdateDate).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		return stringBuilder.toString();
	}
}
