package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class DF_BV_RFCQ_QUOTE extends SMPMessage
{
	public static final long CLASS_ID = 114712;

	private BV_RFCQ_QUOTE DFQuote = new BV_RFCQ_QUOTE();

	public DF_BV_RFCQ_QUOTE()
	{
	}

	public BV_RFCQ_QUOTE getDFQuote()
	{
		return DFQuote;
	}
	public void setDFQuote(BV_RFCQ_QUOTE value)
	{
		DFQuote = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		DFQuote.readXDR(byteBuffer);
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		DFQuote.writeXDR(byteBuffer);

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
		stringBuilder.append("DF_BV_RFCQ_QUOTE::");
		stringBuilder.append("DFQuote(").append(DFQuote.toString()).append(")");
		return stringBuilder.toString();
	}
}
