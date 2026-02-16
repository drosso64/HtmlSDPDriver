package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class DF_TI_EXCHANGE_RATE extends SMPMessage
{
	public static final long CLASS_ID = 170014;

	private TI_EXCHANGE_RATE_FLOW DFExchangeRate = new TI_EXCHANGE_RATE_FLOW();

	public DF_TI_EXCHANGE_RATE()
	{
	}

	public TI_EXCHANGE_RATE_FLOW getDFExchangeRate()
	{
		return DFExchangeRate;
	}
	public void setDFExchangeRate(TI_EXCHANGE_RATE_FLOW value)
	{
		DFExchangeRate = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		DFExchangeRate.readXDR(byteBuffer);
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		DFExchangeRate.writeXDR(byteBuffer);

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
		stringBuilder.append("DF_TI_EXCHANGE_RATE::");
		stringBuilder.append("DFExchangeRate(").append(DFExchangeRate.toString()).append(")");
		return stringBuilder.toString();
	}
}
