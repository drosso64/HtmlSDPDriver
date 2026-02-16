package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_CURRENCY extends SMPMessage
{
	public static final long CLASS_ID = 100007;

	private String CurrencyCode = "";
	private String CurrencyDesc = "";
	private short CurrencyPrecision = 0;
	private String ReferenceCurrency = "";

	public TI_CURRENCY()
	{
	}

	public String getCurrencyCode()
	{
		return CurrencyCode;
	}
	public void setCurrencyCode(String value)
	{
		CurrencyCode = value;
	}
	public String getCurrencyDesc()
	{
		return CurrencyDesc;
	}
	public void setCurrencyDesc(String value)
	{
		CurrencyDesc = value;
	}
	public short getCurrencyPrecision()
	{
		return CurrencyPrecision;
	}
	public void setCurrencyPrecision(short value)
	{
		CurrencyPrecision = value;
	}
	public String getReferenceCurrency()
	{
		return ReferenceCurrency;
	}
	public void setReferenceCurrency(String value)
	{
		ReferenceCurrency = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		CurrencyCode = byteBuffer.readString();
		CurrencyDesc = byteBuffer.readString();
		CurrencyPrecision = (short)byteBuffer.readInt();
		ReferenceCurrency = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeString(CurrencyCode);
		byteBuffer.writeString(CurrencyDesc);
		byteBuffer.writeInt((int)(CurrencyPrecision & 0xFFFFL));
		byteBuffer.writeString(ReferenceCurrency);

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
		stringBuilder.append("TI_CURRENCY::");
		stringBuilder.append("CurrencyCode(").append(CurrencyCode).append(")");
		stringBuilder.append("CurrencyDesc(").append(CurrencyDesc).append(")");
		stringBuilder.append("CurrencyPrecision(").append(CurrencyPrecision).append(")");
		stringBuilder.append("ReferenceCurrency(").append(ReferenceCurrency).append(")");
		return stringBuilder.toString();
	}
}
