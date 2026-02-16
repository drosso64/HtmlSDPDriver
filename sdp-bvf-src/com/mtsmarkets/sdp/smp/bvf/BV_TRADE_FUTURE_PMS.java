package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_TRADE_FUTURE_PMS extends SMPMessage
{
	public static final long CLASS_ID = 400075;

	private BV_TRADE_FUTURE_INFO Trade = new BV_TRADE_FUTURE_INFO();
	private long OrderTraderId = 0;
	private String OrderTraderName = "";

	public BV_TRADE_FUTURE_PMS()
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
	public long getOrderTraderId()
	{
		return OrderTraderId;
	}
	public void setOrderTraderId(long value)
	{
		OrderTraderId = value;
	}
	public String getOrderTraderName()
	{
		return OrderTraderName;
	}
	public void setOrderTraderName(String value)
	{
		OrderTraderName = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		Trade.readXDR(byteBuffer);
		OrderTraderId = (long)byteBuffer.readInt();
		OrderTraderName = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		Trade.writeXDR(byteBuffer);
		byteBuffer.writeInt((int)(OrderTraderId & 0xFFFFFFFFL));
		byteBuffer.writeString(OrderTraderName);

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
		stringBuilder.append("BV_TRADE_FUTURE_PMS::");
		stringBuilder.append("Trade(").append(Trade.toString()).append(")");
		stringBuilder.append("OrderTraderId(").append(OrderTraderId).append(")");
		stringBuilder.append("OrderTraderName(").append(OrderTraderName).append(")");
		return stringBuilder.toString();
	}
}
