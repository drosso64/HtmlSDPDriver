package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_SETTLEMENT_SYSTEM_TRADER extends SMPMessage
{
	public static final long CLASS_ID = 100054;

	private long MarketId = 0;
	private long SettlSystemId = 0;
	private long MemberId = 0;
	private long TraderId = 0;
	private String TraderCode = "";

	public TI_SETTLEMENT_SYSTEM_TRADER()
	{
	}

	public long getMarketId()
	{
		return MarketId;
	}
	public void setMarketId(long value)
	{
		MarketId = value;
	}
	public long getSettlSystemId()
	{
		return SettlSystemId;
	}
	public void setSettlSystemId(long value)
	{
		SettlSystemId = value;
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
	public String getTraderCode()
	{
		return TraderCode;
	}
	public void setTraderCode(String value)
	{
		TraderCode = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MarketId = (long)byteBuffer.readInt();
		SettlSystemId = (long)byteBuffer.readInt();
		MemberId = (long)byteBuffer.readInt();
		TraderId = (long)byteBuffer.readInt();
		TraderCode = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MarketId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SettlSystemId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(MemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(TraderId & 0xFFFFFFFFL));
		byteBuffer.writeString(TraderCode);

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
		stringBuilder.append("TI_SETTLEMENT_SYSTEM_TRADER::");
		stringBuilder.append("MarketId(").append(MarketId).append(")");
		stringBuilder.append("SettlSystemId(").append(SettlSystemId).append(")");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("TraderId(").append(TraderId).append(")");
		stringBuilder.append("TraderCode(").append(TraderCode).append(")");
		return stringBuilder.toString();
	}
}
