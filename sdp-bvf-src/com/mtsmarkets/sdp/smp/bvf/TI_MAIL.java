package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_MAIL extends SMPMessage
{
	public static final long CLASS_ID = 100037;

	private long MemberId = 0;
	private long TraderId = 0;
	private String TraderName = "";
	private long MailDate = 0;
	private long MailTime = 0;
	private long MailExpiryDate = 0;
	private TI_MAIL_TYPE_Enum MailType = TI_MAIL_TYPE_Enum.TI_MAIL_TYPE_MemberToMember;
	private TI_ADDRESSEE_TYPE_Enum AddresseeType = TI_ADDRESSEE_TYPE_Enum.TI_ADDRESSEE_TYPE_AllMembersSingleMarket;
	private long AddresseeMarketId = 0;
	private long AddresseeSectionId = 0;
	private long AddresseeMemberId = 0;
	private TI_MEMBER_PROFILE_Enum AddresseeMemberProfile = TI_MEMBER_PROFILE_Enum.TI_MEMBER_PROFILE_None;
	private String MailSubject = "";
	private String MailText = "";
	private String UserData = "";

	public TI_MAIL()
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
	public long getMailDate()
	{
		return MailDate;
	}
	public void setMailDate(long value)
	{
		MailDate = value;
	}
	public long getMailTime()
	{
		return MailTime;
	}
	public void setMailTime(long value)
	{
		MailTime = value;
	}
	public long getMailExpiryDate()
	{
		return MailExpiryDate;
	}
	public void setMailExpiryDate(long value)
	{
		MailExpiryDate = value;
	}
	public TI_MAIL_TYPE_Enum getMailType()
	{
		return MailType;
	}
	public void setMailType(TI_MAIL_TYPE_Enum value)
	{
		MailType = value;
	}
	public TI_ADDRESSEE_TYPE_Enum getAddresseeType()
	{
		return AddresseeType;
	}
	public void setAddresseeType(TI_ADDRESSEE_TYPE_Enum value)
	{
		AddresseeType = value;
	}
	public long getAddresseeMarketId()
	{
		return AddresseeMarketId;
	}
	public void setAddresseeMarketId(long value)
	{
		AddresseeMarketId = value;
	}
	public long getAddresseeSectionId()
	{
		return AddresseeSectionId;
	}
	public void setAddresseeSectionId(long value)
	{
		AddresseeSectionId = value;
	}
	public long getAddresseeMemberId()
	{
		return AddresseeMemberId;
	}
	public void setAddresseeMemberId(long value)
	{
		AddresseeMemberId = value;
	}
	public TI_MEMBER_PROFILE_Enum getAddresseeMemberProfile()
	{
		return AddresseeMemberProfile;
	}
	public void setAddresseeMemberProfile(TI_MEMBER_PROFILE_Enum value)
	{
		AddresseeMemberProfile = value;
	}
	public String getMailSubject()
	{
		return MailSubject;
	}
	public void setMailSubject(String value)
	{
		MailSubject = value;
	}
	public String getMailText()
	{
		return MailText;
	}
	public void setMailText(String value)
	{
		MailText = value;
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
		MailDate = (long)byteBuffer.readInt();
		MailTime = byteBuffer.readLong();
		MailExpiryDate = (long)byteBuffer.readInt();
		MailType = MailType.getEnum(byteBuffer.readInt());
		AddresseeType = AddresseeType.getEnum(byteBuffer.readInt());
		AddresseeMarketId = (long)byteBuffer.readInt();
		AddresseeSectionId = (long)byteBuffer.readInt();
		AddresseeMemberId = (long)byteBuffer.readInt();
		AddresseeMemberProfile = AddresseeMemberProfile.getEnum(byteBuffer.readInt());
		MailSubject = byteBuffer.readString();
		MailText = byteBuffer.readString();
		UserData = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(TraderId & 0xFFFFFFFFL));
		byteBuffer.writeString(TraderName);
		byteBuffer.writeInt((int)(MailDate & 0xFFFFFFFFL));
		byteBuffer.writeLong(MailTime);
		byteBuffer.writeInt((int)(MailExpiryDate & 0xFFFFFFFFL));
		byteBuffer.writeInt(MailType.getValue());
		byteBuffer.writeInt(AddresseeType.getValue());
		byteBuffer.writeInt((int)(AddresseeMarketId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(AddresseeSectionId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(AddresseeMemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt(AddresseeMemberProfile.getValue());
		byteBuffer.writeString(MailSubject);
		byteBuffer.writeString(MailText);
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
		stringBuilder.append("TI_MAIL::");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("TraderId(").append(TraderId).append(")");
		stringBuilder.append("TraderName(").append(TraderName).append(")");
		stringBuilder.append("MailDate(").append(MailDate).append(")");
		stringBuilder.append("MailTime(").append(MailTime).append(")");
		stringBuilder.append("MailExpiryDate(").append(MailExpiryDate).append(")");
		stringBuilder.append("MailType(").append(MailType).append(")");
		stringBuilder.append("AddresseeType(").append(AddresseeType).append(")");
		stringBuilder.append("AddresseeMarketId(").append(AddresseeMarketId).append(")");
		stringBuilder.append("AddresseeSectionId(").append(AddresseeSectionId).append(")");
		stringBuilder.append("AddresseeMemberId(").append(AddresseeMemberId).append(")");
		stringBuilder.append("AddresseeMemberProfile(").append(AddresseeMemberProfile).append(")");
		stringBuilder.append("MailSubject(").append(MailSubject).append(")");
		stringBuilder.append("MailText(").append(MailText).append(")");
		stringBuilder.append("UserData(").append(UserData).append(")");
		return stringBuilder.toString();
	}
}
