package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_MEMBER extends SMPMessage
{
	public static final long CLASS_ID = 100020;

	private long MemberId = 0;
	private String MemberCode = "";
	private String MemberDesc = "";
	private String MemberShortDesc = "";
	private long MainMemberId = 0;
	private TI_MEMBER_TYPE_Enum MemberType = TI_MEMBER_TYPE_Enum.TI_MEMBER_TYPE_NormalTrader;
	private String CountryCode = "";
	private String BICCode = "";
	private TI_MEMBER_CLASSIFICATION_Enum MemberClassification = TI_MEMBER_CLASSIFICATION_Enum.TI_MEMBER_CLASSIFICATION_None;

	public TI_MEMBER()
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
	public String getMemberCode()
	{
		return MemberCode;
	}
	public void setMemberCode(String value)
	{
		MemberCode = value;
	}
	public String getMemberDesc()
	{
		return MemberDesc;
	}
	public void setMemberDesc(String value)
	{
		MemberDesc = value;
	}
	public String getMemberShortDesc()
	{
		return MemberShortDesc;
	}
	public void setMemberShortDesc(String value)
	{
		MemberShortDesc = value;
	}
	public long getMainMemberId()
	{
		return MainMemberId;
	}
	public void setMainMemberId(long value)
	{
		MainMemberId = value;
	}
	public TI_MEMBER_TYPE_Enum getMemberType()
	{
		return MemberType;
	}
	public void setMemberType(TI_MEMBER_TYPE_Enum value)
	{
		MemberType = value;
	}
	public String getCountryCode()
	{
		return CountryCode;
	}
	public void setCountryCode(String value)
	{
		CountryCode = value;
	}
	public String getBICCode()
	{
		return BICCode;
	}
	public void setBICCode(String value)
	{
		BICCode = value;
	}
	public TI_MEMBER_CLASSIFICATION_Enum getMemberClassification()
	{
		return MemberClassification;
	}
	public void setMemberClassification(TI_MEMBER_CLASSIFICATION_Enum value)
	{
		MemberClassification = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MemberId = (long)byteBuffer.readInt();
		MemberCode = byteBuffer.readString();
		MemberDesc = byteBuffer.readString();
		MemberShortDesc = byteBuffer.readString();
		MainMemberId = (long)byteBuffer.readInt();
		MemberType = MemberType.getEnum(byteBuffer.readInt());
		CountryCode = byteBuffer.readString();
		BICCode = byteBuffer.readString();
		MemberClassification = MemberClassification.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MemberId & 0xFFFFFFFFL));
		byteBuffer.writeString(MemberCode);
		byteBuffer.writeString(MemberDesc);
		byteBuffer.writeString(MemberShortDesc);
		byteBuffer.writeInt((int)(MainMemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt(MemberType.getValue());
		byteBuffer.writeString(CountryCode);
		byteBuffer.writeString(BICCode);
		byteBuffer.writeInt(MemberClassification.getValue());

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
		stringBuilder.append("TI_MEMBER::");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("MemberCode(").append(MemberCode).append(")");
		stringBuilder.append("MemberDesc(").append(MemberDesc).append(")");
		stringBuilder.append("MemberShortDesc(").append(MemberShortDesc).append(")");
		stringBuilder.append("MainMemberId(").append(MainMemberId).append(")");
		stringBuilder.append("MemberType(").append(MemberType).append(")");
		stringBuilder.append("CountryCode(").append(CountryCode).append(")");
		stringBuilder.append("BICCode(").append(BICCode).append(")");
		stringBuilder.append("MemberClassification(").append(MemberClassification).append(")");
		return stringBuilder.toString();
	}
}
