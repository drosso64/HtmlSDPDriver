package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_IOI_TRADING_INFO extends SMPMessage
{
	public static final long CLASS_ID = 114981;

	private long MemberId = 0;
	private String MemberCode = "";
	private String MemberDesc = "";
	private String MemberShortDesc = "";
	private long IOIMsgId = 0;
	private BV_IOI_QUOTING_DATA IOIQuotingData = new BV_IOI_QUOTING_DATA();
	private long IOIUpdateTime = 0;

	public BV_IOI_TRADING_INFO()
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
	public long getIOIMsgId()
	{
		return IOIMsgId;
	}
	public void setIOIMsgId(long value)
	{
		IOIMsgId = value;
	}
	public BV_IOI_QUOTING_DATA getIOIQuotingData()
	{
		return IOIQuotingData;
	}
	public void setIOIQuotingData(BV_IOI_QUOTING_DATA value)
	{
		IOIQuotingData = value;
	}
	public long getIOIUpdateTime()
	{
		return IOIUpdateTime;
	}
	public void setIOIUpdateTime(long value)
	{
		IOIUpdateTime = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MemberId = (long)byteBuffer.readInt();
		MemberCode = byteBuffer.readString();
		MemberDesc = byteBuffer.readString();
		MemberShortDesc = byteBuffer.readString();
		IOIMsgId = (long)byteBuffer.readInt();
		IOIQuotingData.readXDR(byteBuffer);
		IOIUpdateTime = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MemberId & 0xFFFFFFFFL));
		byteBuffer.writeString(MemberCode);
		byteBuffer.writeString(MemberDesc);
		byteBuffer.writeString(MemberShortDesc);
		byteBuffer.writeInt((int)(IOIMsgId & 0xFFFFFFFFL));
		IOIQuotingData.writeXDR(byteBuffer);
		byteBuffer.writeLong(IOIUpdateTime);

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
		stringBuilder.append("BV_IOI_TRADING_INFO::");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("MemberCode(").append(MemberCode).append(")");
		stringBuilder.append("MemberDesc(").append(MemberDesc).append(")");
		stringBuilder.append("MemberShortDesc(").append(MemberShortDesc).append(")");
		stringBuilder.append("IOIMsgId(").append(IOIMsgId).append(")");
		stringBuilder.append("IOIQuotingData(").append(IOIQuotingData.toString()).append(")");
		stringBuilder.append("IOIUpdateTime(").append(IOIUpdateTime).append(")");
		return stringBuilder.toString();
	}
}
