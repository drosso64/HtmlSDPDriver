package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class DF_BV_PORTFOLIO_RFCQ_REQUEST extends SMPMessage
{
	public static final long CLASS_ID = 170053;

	private BV_PORTFOLIO_RFCQ_REQUEST DFRfcqReq = new BV_PORTFOLIO_RFCQ_REQUEST();

	public DF_BV_PORTFOLIO_RFCQ_REQUEST()
	{
	}

	public BV_PORTFOLIO_RFCQ_REQUEST getDFRfcqReq()
	{
		return DFRfcqReq;
	}
	public void setDFRfcqReq(BV_PORTFOLIO_RFCQ_REQUEST value)
	{
		DFRfcqReq = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		DFRfcqReq.readXDR(byteBuffer);
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		DFRfcqReq.writeXDR(byteBuffer);

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
		stringBuilder.append("DF_BV_PORTFOLIO_RFCQ_REQUEST::");
		stringBuilder.append("DFRfcqReq(").append(DFRfcqReq.toString()).append(")");
		return stringBuilder.toString();
	}
}
