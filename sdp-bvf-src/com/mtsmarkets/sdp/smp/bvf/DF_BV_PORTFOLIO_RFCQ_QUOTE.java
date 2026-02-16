package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class DF_BV_PORTFOLIO_RFCQ_QUOTE extends SMPMessage
{
	public static final long CLASS_ID = 170055;

	private BV_PORTFOLIO_RFCQ_QUOTE DFRfcqQuote = new BV_PORTFOLIO_RFCQ_QUOTE();

	public DF_BV_PORTFOLIO_RFCQ_QUOTE()
	{
	}

	public BV_PORTFOLIO_RFCQ_QUOTE getDFRfcqQuote()
	{
		return DFRfcqQuote;
	}
	public void setDFRfcqQuote(BV_PORTFOLIO_RFCQ_QUOTE value)
	{
		DFRfcqQuote = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		DFRfcqQuote.readXDR(byteBuffer);
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		DFRfcqQuote.writeXDR(byteBuffer);

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
		stringBuilder.append("DF_BV_PORTFOLIO_RFCQ_QUOTE::");
		stringBuilder.append("DFRfcqQuote(").append(DFRfcqQuote.toString()).append(")");
		return stringBuilder.toString();
	}
}
