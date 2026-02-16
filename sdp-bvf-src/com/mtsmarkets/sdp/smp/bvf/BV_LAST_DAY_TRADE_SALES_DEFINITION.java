package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_LAST_DAY_TRADE_SALES_DEFINITION extends SMPMessage
{
	public static final long CLASS_ID = 400106;

	private BV_TRADE_SALES_DEFINITION Trade = new BV_TRADE_SALES_DEFINITION();

	public BV_LAST_DAY_TRADE_SALES_DEFINITION()
	{
	}

	public BV_TRADE_SALES_DEFINITION getTrade()
	{
		return Trade;
	}
	public void setTrade(BV_TRADE_SALES_DEFINITION value)
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
		stringBuilder.append("BV_LAST_DAY_TRADE_SALES_DEFINITION::");
		stringBuilder.append("Trade(").append(Trade.toString()).append(")");
		return stringBuilder.toString();
	}
}
