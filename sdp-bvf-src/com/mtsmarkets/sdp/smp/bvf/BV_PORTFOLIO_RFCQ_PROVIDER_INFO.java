package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_PORTFOLIO_RFCQ_PROVIDER_INFO extends SMPMessage
{
	public static final long CLASS_ID = 410026;

	private long MemberId = 0;
	private String MemberCode = "";
	private String MemberDesc = "";
	private String MemberShortDesc = "";
	private BV_PORTFOLIO_RFCQ_PROVIDER_STATUS_Enum Status = BV_PORTFOLIO_RFCQ_PROVIDER_STATUS_Enum.BV_PORTFOLIO_RFCQ_PROVIDER_STATUS_None;
	private long QuoteId = 0;
	private long QuoteUpdateTime = 0;
	private double NetProceeds = 0;
	private double NetProceedsCoverValue = 0;

	public BV_PORTFOLIO_RFCQ_PROVIDER_INFO()
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
	public BV_PORTFOLIO_RFCQ_PROVIDER_STATUS_Enum getStatus()
	{
		return Status;
	}
	public void setStatus(BV_PORTFOLIO_RFCQ_PROVIDER_STATUS_Enum value)
	{
		Status = value;
	}
	public long getQuoteId()
	{
		return QuoteId;
	}
	public void setQuoteId(long value)
	{
		QuoteId = value;
	}
	public long getQuoteUpdateTime()
	{
		return QuoteUpdateTime;
	}
	public void setQuoteUpdateTime(long value)
	{
		QuoteUpdateTime = value;
	}
	public double getNetProceeds()
	{
		return NetProceeds;
	}
	public void setNetProceeds(double value)
	{
		NetProceeds = value;
	}
	public double getNetProceedsCoverValue()
	{
		return NetProceedsCoverValue;
	}
	public void setNetProceedsCoverValue(double value)
	{
		NetProceedsCoverValue = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MemberId = (long)byteBuffer.readInt();
		MemberCode = byteBuffer.readString();
		MemberDesc = byteBuffer.readString();
		MemberShortDesc = byteBuffer.readString();
		Status = Status.getEnum(byteBuffer.readInt());
		QuoteId = (long)byteBuffer.readInt();
		QuoteUpdateTime = byteBuffer.readLong();
		NetProceeds = byteBuffer.readDouble();
		NetProceedsCoverValue = byteBuffer.readDouble();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MemberId & 0xFFFFFFFFL));
		byteBuffer.writeString(MemberCode);
		byteBuffer.writeString(MemberDesc);
		byteBuffer.writeString(MemberShortDesc);
		byteBuffer.writeInt(Status.getValue());
		byteBuffer.writeInt((int)(QuoteId & 0xFFFFFFFFL));
		byteBuffer.writeLong(QuoteUpdateTime);
		byteBuffer.writeDouble(NetProceeds);
		byteBuffer.writeDouble(NetProceedsCoverValue);

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
		stringBuilder.append("BV_PORTFOLIO_RFCQ_PROVIDER_INFO::");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("MemberCode(").append(MemberCode).append(")");
		stringBuilder.append("MemberDesc(").append(MemberDesc).append(")");
		stringBuilder.append("MemberShortDesc(").append(MemberShortDesc).append(")");
		stringBuilder.append("Status(").append(Status).append(")");
		stringBuilder.append("QuoteId(").append(QuoteId).append(")");
		stringBuilder.append("QuoteUpdateTime(").append(QuoteUpdateTime).append(")");
		stringBuilder.append("NetProceeds(").append(NetProceeds).append(")");
		stringBuilder.append("NetProceedsCoverValue(").append(NetProceedsCoverValue).append(")");
		return stringBuilder.toString();
	}
}
