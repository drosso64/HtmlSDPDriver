package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_TRADE_EXCLUDED extends SMPMessage
{
	public static final long CLASS_ID = 100805;

	private long MarketId = 0;
	private long TradeId = 0;
	private TI_FLAG_Enum ExcludedFromOfficialPrice = TI_FLAG_Enum.TI_FLAG_No;

	public TI_TRADE_EXCLUDED()
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
	public long getTradeId()
	{
		return TradeId;
	}
	public void setTradeId(long value)
	{
		TradeId = value;
	}
	public TI_FLAG_Enum getExcludedFromOfficialPrice()
	{
		return ExcludedFromOfficialPrice;
	}
	public void setExcludedFromOfficialPrice(TI_FLAG_Enum value)
	{
		ExcludedFromOfficialPrice = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MarketId = (long)byteBuffer.readInt();
		TradeId = (long)byteBuffer.readInt();
		ExcludedFromOfficialPrice = ExcludedFromOfficialPrice.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MarketId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(TradeId & 0xFFFFFFFFL));
		byteBuffer.writeInt(ExcludedFromOfficialPrice.getValue());

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
		stringBuilder.append("TI_TRADE_EXCLUDED::");
		stringBuilder.append("MarketId(").append(MarketId).append(")");
		stringBuilder.append("TradeId(").append(TradeId).append(")");
		stringBuilder.append("ExcludedFromOfficialPrice(").append(ExcludedFromOfficialPrice).append(")");
		return stringBuilder.toString();
	}
}
