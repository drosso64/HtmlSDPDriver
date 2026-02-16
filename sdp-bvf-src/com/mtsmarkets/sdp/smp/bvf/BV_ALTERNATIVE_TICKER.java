package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_ALTERNATIVE_TICKER extends SMPMessage
{
	public static final long CLASS_ID = 400053;

	private long FinancialInstrumentId = 0;
	private String AlternativeTicker = "";

	public BV_ALTERNATIVE_TICKER()
	{
	}

	public long getFinancialInstrumentId()
	{
		return FinancialInstrumentId;
	}
	public void setFinancialInstrumentId(long value)
	{
		FinancialInstrumentId = value;
	}
	public String getAlternativeTicker()
	{
		return AlternativeTicker;
	}
	public void setAlternativeTicker(String value)
	{
		AlternativeTicker = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		FinancialInstrumentId = (long)byteBuffer.readInt();
		AlternativeTicker = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(FinancialInstrumentId & 0xFFFFFFFFL));
		byteBuffer.writeString(AlternativeTicker);

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
		stringBuilder.append("BV_ALTERNATIVE_TICKER::");
		stringBuilder.append("FinancialInstrumentId(").append(FinancialInstrumentId).append(")");
		stringBuilder.append("AlternativeTicker(").append(AlternativeTicker).append(")");
		return stringBuilder.toString();
	}
}
