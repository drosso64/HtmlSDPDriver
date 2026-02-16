package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class DF_BV_RFCQ_TRADING_RELATION extends SMPMessage
{
	public static final long CLASS_ID = 170016;

	private BV_LOG_RFCQ_TRADING_RELATION DFRfcqTR = new BV_LOG_RFCQ_TRADING_RELATION();

	public DF_BV_RFCQ_TRADING_RELATION()
	{
	}

	public BV_LOG_RFCQ_TRADING_RELATION getDFRfcqTR()
	{
		return DFRfcqTR;
	}
	public void setDFRfcqTR(BV_LOG_RFCQ_TRADING_RELATION value)
	{
		DFRfcqTR = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		DFRfcqTR.readXDR(byteBuffer);
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		DFRfcqTR.writeXDR(byteBuffer);

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
		stringBuilder.append("DF_BV_RFCQ_TRADING_RELATION::");
		stringBuilder.append("DFRfcqTR(").append(DFRfcqTR.toString()).append(")");
		return stringBuilder.toString();
	}
}
