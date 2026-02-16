package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_RFCQ_SELL_SIDE_TRADING_LIST_LEG_REJECT extends SMPMessage
{
	public static final long CLASS_ID = 100218;

	private long SellSideMemberId = 0;
	private long TradingListId = 0;
	private long RfcqReqId = 0;
	private short LegId = 0;
	private long UpdateTime = 0;

	public BV_RFCQ_SELL_SIDE_TRADING_LIST_LEG_REJECT()
	{
	}

	public long getSellSideMemberId()
	{
		return SellSideMemberId;
	}
	public void setSellSideMemberId(long value)
	{
		SellSideMemberId = value;
	}
	public long getTradingListId()
	{
		return TradingListId;
	}
	public void setTradingListId(long value)
	{
		TradingListId = value;
	}
	public long getRfcqReqId()
	{
		return RfcqReqId;
	}
	public void setRfcqReqId(long value)
	{
		RfcqReqId = value;
	}
	public short getLegId()
	{
		return LegId;
	}
	public void setLegId(short value)
	{
		LegId = value;
	}
	public long getUpdateTime()
	{
		return UpdateTime;
	}
	public void setUpdateTime(long value)
	{
		UpdateTime = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		SellSideMemberId = (long)byteBuffer.readInt();
		TradingListId = (long)byteBuffer.readInt();
		RfcqReqId = (long)byteBuffer.readInt();
		LegId = (short)byteBuffer.readInt();
		UpdateTime = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(SellSideMemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(TradingListId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(RfcqReqId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(LegId & 0xFFFFL));
		byteBuffer.writeLong(UpdateTime);

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
		stringBuilder.append("BV_RFCQ_SELL_SIDE_TRADING_LIST_LEG_REJECT::");
		stringBuilder.append("SellSideMemberId(").append(SellSideMemberId).append(")");
		stringBuilder.append("TradingListId(").append(TradingListId).append(")");
		stringBuilder.append("RfcqReqId(").append(RfcqReqId).append(")");
		stringBuilder.append("LegId(").append(LegId).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		return stringBuilder.toString();
	}
}
