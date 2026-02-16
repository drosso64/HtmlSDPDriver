package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_INTERNET_TRADER extends SMPMessage
{
	public static final long CLASS_ID = 100047;

	private long MemberId = 0;
	private long TraderId = 0;
	private long MarketId = 0;
	private short MaxDepthSubscription = 0;

	public TI_INTERNET_TRADER()
	{
	}

	public long getMemberId()
	{
		return MemberId;
	}
	public void setMemberId(long value)
	{
		MemberId = value;
	}
	public long getTraderId()
	{
		return TraderId;
	}
	public void setTraderId(long value)
	{
		TraderId = value;
	}
	public long getMarketId()
	{
		return MarketId;
	}
	public void setMarketId(long value)
	{
		MarketId = value;
	}
	public short getMaxDepthSubscription()
	{
		return MaxDepthSubscription;
	}
	public void setMaxDepthSubscription(short value)
	{
		MaxDepthSubscription = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MemberId = (long)byteBuffer.readInt();
		TraderId = (long)byteBuffer.readInt();
		MarketId = (long)byteBuffer.readInt();
		MaxDepthSubscription = (short)byteBuffer.readInt();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(TraderId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(MarketId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(MaxDepthSubscription & 0xFFFFL));

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
		stringBuilder.append("TI_INTERNET_TRADER::");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("TraderId(").append(TraderId).append(")");
		stringBuilder.append("MarketId(").append(MarketId).append(")");
		stringBuilder.append("MaxDepthSubscription(").append(MaxDepthSubscription).append(")");
		return stringBuilder.toString();
	}
}
