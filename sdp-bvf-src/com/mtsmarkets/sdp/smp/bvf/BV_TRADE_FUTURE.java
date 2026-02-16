package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_TRADE_FUTURE extends SMPMessage
{
	public static final long CLASS_ID = 400072;

	private BV_TRADE_FUTURE_INFO Trade = new BV_TRADE_FUTURE_INFO();

	public BV_TRADE_FUTURE()
	{
	}

	public BV_TRADE_FUTURE_INFO getTrade()
	{
		return Trade;
	}
	public void setTrade(BV_TRADE_FUTURE_INFO value)
	{
		Trade = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		Trade.readXDR(byteBuffer);
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		Trade.writeXDR(byteBuffer);

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
		stringBuilder.append("BV_TRADE_FUTURE::");
		stringBuilder.append("Trade(").append(Trade.toString()).append(")");
		return stringBuilder.toString();
	}
}
