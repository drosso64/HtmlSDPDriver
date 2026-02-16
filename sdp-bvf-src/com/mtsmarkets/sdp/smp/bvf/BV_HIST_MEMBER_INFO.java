package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_HIST_MEMBER_INFO extends SMPMessage
{
	public static final long CLASS_ID = 114921;

	private String MemberCode = "";
	private String MemberShortDesc = "";
	private String MemberDesc = "";
	private String TraderName = "";
	private BV_ALGO_INFO AlgoInfo = new BV_ALGO_INFO();
	private BV_CLIENT_IDENTIFICATION_INFO ClientIdentificationInfo = new BV_CLIENT_IDENTIFICATION_INFO();
	private String UserData = "";

	public BV_HIST_MEMBER_INFO()
	{
	}

	public String getMemberCode()
	{
		return MemberCode;
	}
	public void setMemberCode(String value)
	{
		MemberCode = value;
	}
	public String getMemberShortDesc()
	{
		return MemberShortDesc;
	}
	public void setMemberShortDesc(String value)
	{
		MemberShortDesc = value;
	}
	public String getMemberDesc()
	{
		return MemberDesc;
	}
	public void setMemberDesc(String value)
	{
		MemberDesc = value;
	}
	public String getTraderName()
	{
		return TraderName;
	}
	public void setTraderName(String value)
	{
		TraderName = value;
	}
	public BV_ALGO_INFO getAlgoInfo()
	{
		return AlgoInfo;
	}
	public void setAlgoInfo(BV_ALGO_INFO value)
	{
		AlgoInfo = value;
	}
	public BV_CLIENT_IDENTIFICATION_INFO getClientIdentificationInfo()
	{
		return ClientIdentificationInfo;
	}
	public void setClientIdentificationInfo(BV_CLIENT_IDENTIFICATION_INFO value)
	{
		ClientIdentificationInfo = value;
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
		MemberCode = byteBuffer.readString();
		MemberShortDesc = byteBuffer.readString();
		MemberDesc = byteBuffer.readString();
		TraderName = byteBuffer.readString();
		AlgoInfo.readXDR(byteBuffer);
		ClientIdentificationInfo.readXDR(byteBuffer);
		UserData = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeString(MemberCode);
		byteBuffer.writeString(MemberShortDesc);
		byteBuffer.writeString(MemberDesc);
		byteBuffer.writeString(TraderName);
		AlgoInfo.writeXDR(byteBuffer);
		ClientIdentificationInfo.writeXDR(byteBuffer);
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
		stringBuilder.append("BV_HIST_MEMBER_INFO::");
		stringBuilder.append("MemberCode(").append(MemberCode).append(")");
		stringBuilder.append("MemberShortDesc(").append(MemberShortDesc).append(")");
		stringBuilder.append("MemberDesc(").append(MemberDesc).append(")");
		stringBuilder.append("TraderName(").append(TraderName).append(")");
		stringBuilder.append("AlgoInfo(").append(AlgoInfo.toString()).append(")");
		stringBuilder.append("ClientIdentificationInfo(").append(ClientIdentificationInfo.toString()).append(")");
		stringBuilder.append("UserData(").append(UserData).append(")");
		return stringBuilder.toString();
	}
}
