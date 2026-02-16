package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_INDUSTRY extends SMPMessage
{
	public static final long CLASS_ID = 100013;

	private long IndustryId = 0;
	private String IndustryDesc = "";

	public TI_INDUSTRY()
	{
	}

	public long getIndustryId()
	{
		return IndustryId;
	}
	public void setIndustryId(long value)
	{
		IndustryId = value;
	}
	public String getIndustryDesc()
	{
		return IndustryDesc;
	}
	public void setIndustryDesc(String value)
	{
		IndustryDesc = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		IndustryId = (long)byteBuffer.readInt();
		IndustryDesc = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(IndustryId & 0xFFFFFFFFL));
		byteBuffer.writeString(IndustryDesc);

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
		stringBuilder.append("TI_INDUSTRY::");
		stringBuilder.append("IndustryId(").append(IndustryId).append(")");
		stringBuilder.append("IndustryDesc(").append(IndustryDesc).append(")");
		return stringBuilder.toString();
	}
}
