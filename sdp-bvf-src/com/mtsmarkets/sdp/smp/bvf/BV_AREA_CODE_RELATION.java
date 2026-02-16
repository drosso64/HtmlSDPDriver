package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_AREA_CODE_RELATION extends SMPMessage
{
	public static final long CLASS_ID = 100230;

	private long MarketId = 0;
	private short BuySideAreaCodeId = 0;
	private short SellSideAreaCodeId = 0;

	public BV_AREA_CODE_RELATION()
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
	public short getBuySideAreaCodeId()
	{
		return BuySideAreaCodeId;
	}
	public void setBuySideAreaCodeId(short value)
	{
		BuySideAreaCodeId = value;
	}
	public short getSellSideAreaCodeId()
	{
		return SellSideAreaCodeId;
	}
	public void setSellSideAreaCodeId(short value)
	{
		SellSideAreaCodeId = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MarketId = (long)byteBuffer.readInt();
		BuySideAreaCodeId = (short)byteBuffer.readInt();
		SellSideAreaCodeId = (short)byteBuffer.readInt();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MarketId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(BuySideAreaCodeId & 0xFFFFL));
		byteBuffer.writeInt((int)(SellSideAreaCodeId & 0xFFFFL));

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
		stringBuilder.append("BV_AREA_CODE_RELATION::");
		stringBuilder.append("MarketId(").append(MarketId).append(")");
		stringBuilder.append("BuySideAreaCodeId(").append(BuySideAreaCodeId).append(")");
		stringBuilder.append("SellSideAreaCodeId(").append(SellSideAreaCodeId).append(")");
		return stringBuilder.toString();
	}
}
