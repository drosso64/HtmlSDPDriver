package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class DF_BV_RFCQ_TRADING_RELATION_TRADER_EXCEPTION extends SMPMessage
{
	public static final long CLASS_ID = 170022;

	private BV_LOG_RFCQ_TRADING_RELATION_TRADER_EXCEPTION DFRfcqTRExc = new BV_LOG_RFCQ_TRADING_RELATION_TRADER_EXCEPTION();

	public DF_BV_RFCQ_TRADING_RELATION_TRADER_EXCEPTION()
	{
	}

	public BV_LOG_RFCQ_TRADING_RELATION_TRADER_EXCEPTION getDFRfcqTRExc()
	{
		return DFRfcqTRExc;
	}
	public void setDFRfcqTRExc(BV_LOG_RFCQ_TRADING_RELATION_TRADER_EXCEPTION value)
	{
		DFRfcqTRExc = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		DFRfcqTRExc.readXDR(byteBuffer);
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		DFRfcqTRExc.writeXDR(byteBuffer);

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
		stringBuilder.append("DF_BV_RFCQ_TRADING_RELATION_TRADER_EXCEPTION::");
		stringBuilder.append("DFRfcqTRExc(").append(DFRfcqTRExc.toString()).append(")");
		return stringBuilder.toString();
	}
}
