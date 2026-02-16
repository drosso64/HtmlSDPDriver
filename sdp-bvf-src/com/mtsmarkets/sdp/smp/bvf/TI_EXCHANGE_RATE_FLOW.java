package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_EXCHANGE_RATE_FLOW extends SMPMessage
{
	public static final long CLASS_ID = 100801;

	private String CurrencyCodeFirst = "";
	private String CurrencyCodeSecond = "";
	private double ExchangeRate = 0;
	private long ReferenceDate = 0;
	private long ReferenceTime = 0;
	private long UpdateDate = 0;
	private long UpdateTime = 0;

	public TI_EXCHANGE_RATE_FLOW()
	{
	}

	public String getCurrencyCodeFirst()
	{
		return CurrencyCodeFirst;
	}
	public void setCurrencyCodeFirst(String value)
	{
		CurrencyCodeFirst = value;
	}
	public String getCurrencyCodeSecond()
	{
		return CurrencyCodeSecond;
	}
	public void setCurrencyCodeSecond(String value)
	{
		CurrencyCodeSecond = value;
	}
	public double getExchangeRate()
	{
		return ExchangeRate;
	}
	public void setExchangeRate(double value)
	{
		ExchangeRate = value;
	}
	public long getReferenceDate()
	{
		return ReferenceDate;
	}
	public void setReferenceDate(long value)
	{
		ReferenceDate = value;
	}
	public long getReferenceTime()
	{
		return ReferenceTime;
	}
	public void setReferenceTime(long value)
	{
		ReferenceTime = value;
	}
	public long getUpdateDate()
	{
		return UpdateDate;
	}
	public void setUpdateDate(long value)
	{
		UpdateDate = value;
	}
	public long getUpdateTime()
	{
		return UpdateTime;
	}
	public void setUpdateTime(long value)
	{
		UpdateTime = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		CurrencyCodeFirst = byteBuffer.readString();
		CurrencyCodeSecond = byteBuffer.readString();
		ExchangeRate = byteBuffer.readDouble();
		ReferenceDate = (long)byteBuffer.readInt();
		ReferenceTime = byteBuffer.readLong();
		UpdateDate = (long)byteBuffer.readInt();
		UpdateTime = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeString(CurrencyCodeFirst);
		byteBuffer.writeString(CurrencyCodeSecond);
		byteBuffer.writeDouble(ExchangeRate);
		byteBuffer.writeInt((int)(ReferenceDate & 0xFFFFFFFFL));
		byteBuffer.writeLong(ReferenceTime);
		byteBuffer.writeInt((int)(UpdateDate & 0xFFFFFFFFL));
		byteBuffer.writeLong(UpdateTime);

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
		stringBuilder.append("TI_EXCHANGE_RATE_FLOW::");
		stringBuilder.append("CurrencyCodeFirst(").append(CurrencyCodeFirst).append(")");
		stringBuilder.append("CurrencyCodeSecond(").append(CurrencyCodeSecond).append(")");
		stringBuilder.append("ExchangeRate(").append(ExchangeRate).append(")");
		stringBuilder.append("ReferenceDate(").append(ReferenceDate).append(")");
		stringBuilder.append("ReferenceTime(").append(ReferenceTime).append(")");
		stringBuilder.append("UpdateDate(").append(UpdateDate).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		return stringBuilder.toString();
	}
}
