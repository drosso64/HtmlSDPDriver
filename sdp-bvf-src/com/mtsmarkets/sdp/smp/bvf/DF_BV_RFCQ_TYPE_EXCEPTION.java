package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class DF_BV_RFCQ_TYPE_EXCEPTION extends SMPMessage
{
	public static final long CLASS_ID = 170025;

	private BV_LOG_RFCQ_TYPE_EXCEPTION DFRfcqTypeExc = new BV_LOG_RFCQ_TYPE_EXCEPTION();

	public DF_BV_RFCQ_TYPE_EXCEPTION()
	{
	}

	public BV_LOG_RFCQ_TYPE_EXCEPTION getDFRfcqTypeExc()
	{
		return DFRfcqTypeExc;
	}
	public void setDFRfcqTypeExc(BV_LOG_RFCQ_TYPE_EXCEPTION value)
	{
		DFRfcqTypeExc = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		DFRfcqTypeExc.readXDR(byteBuffer);
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		DFRfcqTypeExc.writeXDR(byteBuffer);

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
		stringBuilder.append("DF_BV_RFCQ_TYPE_EXCEPTION::");
		stringBuilder.append("DFRfcqTypeExc(").append(DFRfcqTypeExc.toString()).append(")");
		return stringBuilder.toString();
	}
}
