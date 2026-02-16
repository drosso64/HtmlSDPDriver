package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_HIST_ORDER_STAGING_DEALER_INFO extends SMPMessage
{
	public static final long CLASS_ID = 114975;

	private String MemberCode = "";
	private String MemberShortDesc = "";
	private String MemberDesc = "";

	public BV_HIST_ORDER_STAGING_DEALER_INFO()
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

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MemberCode = byteBuffer.readString();
		MemberShortDesc = byteBuffer.readString();
		MemberDesc = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeString(MemberCode);
		byteBuffer.writeString(MemberShortDesc);
		byteBuffer.writeString(MemberDesc);

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
		stringBuilder.append("BV_HIST_ORDER_STAGING_DEALER_INFO::");
		stringBuilder.append("MemberCode(").append(MemberCode).append(")");
		stringBuilder.append("MemberShortDesc(").append(MemberShortDesc).append(")");
		stringBuilder.append("MemberDesc(").append(MemberDesc).append(")");
		return stringBuilder.toString();
	}
}
