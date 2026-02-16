package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class DF_BV_RFCQ extends SMPMessage
{
	public static final long CLASS_ID = 114715;

	private BV_RFCQ DFRrfcq = new BV_RFCQ();

	public DF_BV_RFCQ()
	{
	}

	public BV_RFCQ getDFRrfcq()
	{
		return DFRrfcq;
	}
	public void setDFRrfcq(BV_RFCQ value)
	{
		DFRrfcq = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		DFRrfcq.readXDR(byteBuffer);
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		DFRrfcq.writeXDR(byteBuffer);

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
		stringBuilder.append("DF_BV_RFCQ::");
		stringBuilder.append("DFRrfcq(").append(DFRrfcq.toString()).append(")");
		return stringBuilder.toString();
	}
}
