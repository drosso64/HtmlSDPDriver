package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_RFCQ_AUTO_EXECUTION_ELIGIBILITY_CRITERIA_CURRENCY extends SMPMessage
{
	public static final long CLASS_ID = 114994;

	private String CurrencyId = "";

	public BV_RFCQ_AUTO_EXECUTION_ELIGIBILITY_CRITERIA_CURRENCY()
	{
	}

	public String getCurrencyId()
	{
		return CurrencyId;
	}
	public void setCurrencyId(String value)
	{
		CurrencyId = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		CurrencyId = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeString(CurrencyId);

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
		stringBuilder.append("BV_RFCQ_AUTO_EXECUTION_ELIGIBILITY_CRITERIA_CURRENCY::");
		stringBuilder.append("CurrencyId(").append(CurrencyId).append(")");
		return stringBuilder.toString();
	}
}
