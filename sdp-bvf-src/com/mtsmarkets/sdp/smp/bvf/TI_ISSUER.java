package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_ISSUER extends SMPMessage
{
	public static final long CLASS_ID = 100012;

	private long IssuerId = 0;
	private String IssuerDesc = "";
	private String CountryCode = "";
	private long IndustryId = 0;

	public TI_ISSUER()
	{
	}

	public long getIssuerId()
	{
		return IssuerId;
	}
	public void setIssuerId(long value)
	{
		IssuerId = value;
	}
	public String getIssuerDesc()
	{
		return IssuerDesc;
	}
	public void setIssuerDesc(String value)
	{
		IssuerDesc = value;
	}
	public String getCountryCode()
	{
		return CountryCode;
	}
	public void setCountryCode(String value)
	{
		CountryCode = value;
	}
	public long getIndustryId()
	{
		return IndustryId;
	}
	public void setIndustryId(long value)
	{
		IndustryId = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		IssuerId = (long)byteBuffer.readInt();
		IssuerDesc = byteBuffer.readString();
		CountryCode = byteBuffer.readString();
		IndustryId = (long)byteBuffer.readInt();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(IssuerId & 0xFFFFFFFFL));
		byteBuffer.writeString(IssuerDesc);
		byteBuffer.writeString(CountryCode);
		byteBuffer.writeInt((int)(IndustryId & 0xFFFFFFFFL));

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
		stringBuilder.append("TI_ISSUER::");
		stringBuilder.append("IssuerId(").append(IssuerId).append(")");
		stringBuilder.append("IssuerDesc(").append(IssuerDesc).append(")");
		stringBuilder.append("CountryCode(").append(CountryCode).append(")");
		stringBuilder.append("IndustryId(").append(IndustryId).append(")");
		return stringBuilder.toString();
	}
}
