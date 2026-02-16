package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class DF_BV_ALGO_INFO extends SMPMessage
{
	public static final long CLASS_ID = 114790;

	private String CountryCode1 = "";
	private String CountryCode2 = "";

	public DF_BV_ALGO_INFO()
	{
	}

	public String getCountryCode1()
	{
		return CountryCode1;
	}
	public void setCountryCode1(String value)
	{
		CountryCode1 = value;
	}
	public String getCountryCode2()
	{
		return CountryCode2;
	}
	public void setCountryCode2(String value)
	{
		CountryCode2 = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		CountryCode1 = byteBuffer.readString();
		CountryCode2 = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeString(CountryCode1);
		byteBuffer.writeString(CountryCode2);

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
		stringBuilder.append("DF_BV_ALGO_INFO::");
		stringBuilder.append("CountryCode1(").append(CountryCode1).append(")");
		stringBuilder.append("CountryCode2(").append(CountryCode2).append(")");
		return stringBuilder.toString();
	}
}
