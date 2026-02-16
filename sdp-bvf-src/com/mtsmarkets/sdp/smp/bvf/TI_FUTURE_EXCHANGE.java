package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_FUTURE_EXCHANGE extends SMPMessage
{
	public static final long CLASS_ID = 100057;

	private long ExchangeId = 0;
	private String ExchangeCode = "";
	private String ExchangeDesc = "";
	private long SortNumber = 0;

	public TI_FUTURE_EXCHANGE()
	{
	}

	public long getExchangeId()
	{
		return ExchangeId;
	}
	public void setExchangeId(long value)
	{
		ExchangeId = value;
	}
	public String getExchangeCode()
	{
		return ExchangeCode;
	}
	public void setExchangeCode(String value)
	{
		ExchangeCode = value;
	}
	public String getExchangeDesc()
	{
		return ExchangeDesc;
	}
	public void setExchangeDesc(String value)
	{
		ExchangeDesc = value;
	}
	public long getSortNumber()
	{
		return SortNumber;
	}
	public void setSortNumber(long value)
	{
		SortNumber = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		ExchangeId = (long)byteBuffer.readInt();
		ExchangeCode = byteBuffer.readString();
		ExchangeDesc = byteBuffer.readString();
		SortNumber = (long)byteBuffer.readInt();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(ExchangeId & 0xFFFFFFFFL));
		byteBuffer.writeString(ExchangeCode);
		byteBuffer.writeString(ExchangeDesc);
		byteBuffer.writeInt((int)(SortNumber & 0xFFFFFFFFL));

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
		stringBuilder.append("TI_FUTURE_EXCHANGE::");
		stringBuilder.append("ExchangeId(").append(ExchangeId).append(")");
		stringBuilder.append("ExchangeCode(").append(ExchangeCode).append(")");
		stringBuilder.append("ExchangeDesc(").append(ExchangeDesc).append(")");
		stringBuilder.append("SortNumber(").append(SortNumber).append(")");
		return stringBuilder.toString();
	}
}
