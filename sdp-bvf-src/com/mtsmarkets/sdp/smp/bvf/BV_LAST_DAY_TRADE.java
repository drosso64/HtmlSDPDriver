package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_LAST_DAY_TRADE extends SMPMessage
{
	public static final long CLASS_ID = 114304;

	private BV_HIST_TRADE_INFO Trade = new BV_HIST_TRADE_INFO();

	public BV_LAST_DAY_TRADE()
	{
	}

	public BV_HIST_TRADE_INFO getTrade()
	{
		return Trade;
	}
	public void setTrade(BV_HIST_TRADE_INFO value)
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
		stringBuilder.append("BV_LAST_DAY_TRADE::");
		stringBuilder.append("Trade(").append(Trade.toString()).append(")");
		return stringBuilder.toString();
	}
}
