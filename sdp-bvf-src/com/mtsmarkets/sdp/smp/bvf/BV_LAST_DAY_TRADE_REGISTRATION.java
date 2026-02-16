package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_LAST_DAY_TRADE_REGISTRATION extends SMPMessage
{
	public static final long CLASS_ID = 400068;

	private BV_HIST_TRADE_REGISTRATION Last = new BV_HIST_TRADE_REGISTRATION();

	public BV_LAST_DAY_TRADE_REGISTRATION()
	{
	}

	public BV_HIST_TRADE_REGISTRATION getLast()
	{
		return Last;
	}
	public void setLast(BV_HIST_TRADE_REGISTRATION value)
	{
		Last = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		Last.readXDR(byteBuffer);
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		Last.writeXDR(byteBuffer);

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
		stringBuilder.append("BV_LAST_DAY_TRADE_REGISTRATION::");
		stringBuilder.append("Last(").append(Last.toString()).append(")");
		return stringBuilder.toString();
	}
}
