package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class DF_MEMBERSUMMARY extends SMPMessage
{
	public static final long CLASS_ID = 170005;

	private long MarketId = 0;
	private long MemberId = 0;
	private String CurrencyCode = "";
	private DF_TRADING_INFO TradingInfo = new DF_TRADING_INFO();

	public DF_MEMBERSUMMARY()
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
	public long getMemberId()
	{
		return MemberId;
	}
	public void setMemberId(long value)
	{
		MemberId = value;
	}
	public String getCurrencyCode()
	{
		return CurrencyCode;
	}
	public void setCurrencyCode(String value)
	{
		CurrencyCode = value;
	}
	public DF_TRADING_INFO getTradingInfo()
	{
		return TradingInfo;
	}
	public void setTradingInfo(DF_TRADING_INFO value)
	{
		TradingInfo = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MarketId = (long)byteBuffer.readInt();
		MemberId = (long)byteBuffer.readInt();
		CurrencyCode = byteBuffer.readString();
		TradingInfo.readXDR(byteBuffer);
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MarketId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(MemberId & 0xFFFFFFFFL));
		byteBuffer.writeString(CurrencyCode);
		TradingInfo.writeXDR(byteBuffer);

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
		stringBuilder.append("DF_MEMBERSUMMARY::");
		stringBuilder.append("MarketId(").append(MarketId).append(")");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("CurrencyCode(").append(CurrencyCode).append(")");
		stringBuilder.append("TradingInfo(").append(TradingInfo.toString()).append(")");
		return stringBuilder.toString();
	}
}
