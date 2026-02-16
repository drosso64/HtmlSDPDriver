package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_TRADE_REGISTRATION_MEMBER_INFO extends SMPMessage
{
	public static final long CLASS_ID = 410006;

	private long MemberId = 0;
	private String MemberCode = "";
	private String MemberShortDes = "";
	private String MemberDes = "";
	private long TraderId = 0;
	private String TraderName = "";
	private String PublicInfo = "";
	private String PrivateInfo = "";
	private String UserData = "";

	public BV_TRADE_REGISTRATION_MEMBER_INFO()
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
	public String getMemberShortDes()
	{
		return MemberShortDes;
	}
	public void setMemberShortDes(String value)
	{
		MemberShortDes = value;
	}
	public String getMemberDes()
	{
		return MemberDes;
	}
	public void setMemberDes(String value)
	{
		MemberDes = value;
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
	public String getPublicInfo()
	{
		return PublicInfo;
	}
	public void setPublicInfo(String value)
	{
		PublicInfo = value;
	}
	public String getPrivateInfo()
	{
		return PrivateInfo;
	}
	public void setPrivateInfo(String value)
	{
		PrivateInfo = value;
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
		MemberCode = byteBuffer.readString();
		MemberShortDes = byteBuffer.readString();
		MemberDes = byteBuffer.readString();
		TraderId = (long)byteBuffer.readInt();
		TraderName = byteBuffer.readString();
		PublicInfo = byteBuffer.readString();
		PrivateInfo = byteBuffer.readString();
		UserData = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MemberId & 0xFFFFFFFFL));
		byteBuffer.writeString(MemberCode);
		byteBuffer.writeString(MemberShortDes);
		byteBuffer.writeString(MemberDes);
		byteBuffer.writeInt((int)(TraderId & 0xFFFFFFFFL));
		byteBuffer.writeString(TraderName);
		byteBuffer.writeString(PublicInfo);
		byteBuffer.writeString(PrivateInfo);
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
		stringBuilder.append("BV_TRADE_REGISTRATION_MEMBER_INFO::");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("MemberCode(").append(MemberCode).append(")");
		stringBuilder.append("MemberShortDes(").append(MemberShortDes).append(")");
		stringBuilder.append("MemberDes(").append(MemberDes).append(")");
		stringBuilder.append("TraderId(").append(TraderId).append(")");
		stringBuilder.append("TraderName(").append(TraderName).append(")");
		stringBuilder.append("PublicInfo(").append(PublicInfo).append(")");
		stringBuilder.append("PrivateInfo(").append(PrivateInfo).append(")");
		stringBuilder.append("UserData(").append(UserData).append(")");
		return stringBuilder.toString();
	}
}
