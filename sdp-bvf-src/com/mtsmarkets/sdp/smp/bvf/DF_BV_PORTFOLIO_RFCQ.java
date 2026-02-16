package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class DF_BV_PORTFOLIO_RFCQ extends SMPMessage
{
	public static final long CLASS_ID = 170054;

	private BV_PORTFOLIO_RFCQ DFRfcq = new BV_PORTFOLIO_RFCQ();

	public DF_BV_PORTFOLIO_RFCQ()
	{
	}

	public BV_PORTFOLIO_RFCQ getDFRfcq()
	{
		return DFRfcq;
	}
	public void setDFRfcq(BV_PORTFOLIO_RFCQ value)
	{
		DFRfcq = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		DFRfcq.readXDR(byteBuffer);
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		DFRfcq.writeXDR(byteBuffer);

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
		stringBuilder.append("DF_BV_PORTFOLIO_RFCQ::");
		stringBuilder.append("DFRfcq(").append(DFRfcq.toString()).append(")");
		return stringBuilder.toString();
	}
}
