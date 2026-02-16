package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_COUNTRY extends SMPMessage
{
	public static final long CLASS_ID = 100008;

	private String CountryCode = "";
	private String CountryDesc = "";

	public TI_COUNTRY()
	{
	}

	public String getCountryCode()
	{
		return CountryCode;
	}
	public void setCountryCode(String value)
	{
		CountryCode = value;
	}
	public String getCountryDesc()
	{
		return CountryDesc;
	}
	public void setCountryDesc(String value)
	{
		CountryDesc = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		CountryCode = byteBuffer.readString();
		CountryDesc = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeString(CountryCode);
		byteBuffer.writeString(CountryDesc);

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
		stringBuilder.append("TI_COUNTRY::");
		stringBuilder.append("CountryCode(").append(CountryCode).append(")");
		stringBuilder.append("CountryDesc(").append(CountryDesc).append(")");
		return stringBuilder.toString();
	}
}
