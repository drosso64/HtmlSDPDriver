package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class DF_BV_TRADE_REGISTRATION extends SMPMessage
{
	public static final long CLASS_ID = 170050;

	private BV_TRADE_REGISTRATION DFTradeRegistration = new BV_TRADE_REGISTRATION();

	public DF_BV_TRADE_REGISTRATION()
	{
	}

	public BV_TRADE_REGISTRATION getDFTradeRegistration()
	{
		return DFTradeRegistration;
	}
	public void setDFTradeRegistration(BV_TRADE_REGISTRATION value)
	{
		DFTradeRegistration = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		DFTradeRegistration.readXDR(byteBuffer);
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		DFTradeRegistration.writeXDR(byteBuffer);

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
		stringBuilder.append("DF_BV_TRADE_REGISTRATION::");
		stringBuilder.append("DFTradeRegistration(").append(DFTradeRegistration.toString()).append(")");
		return stringBuilder.toString();
	}
}
