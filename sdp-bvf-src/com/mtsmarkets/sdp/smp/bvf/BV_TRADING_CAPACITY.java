package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_TRADING_CAPACITY extends SMPMessage
{
	public static final long CLASS_ID = 400034;

	private long TradingCapacityId = 0;
	private String TradingCapacityCode = "";
	private String TradingCapacityDes = "";

	public BV_TRADING_CAPACITY()
	{
	}

	public long getTradingCapacityId()
	{
		return TradingCapacityId;
	}
	public void setTradingCapacityId(long value)
	{
		TradingCapacityId = value;
	}
	public String getTradingCapacityCode()
	{
		return TradingCapacityCode;
	}
	public void setTradingCapacityCode(String value)
	{
		TradingCapacityCode = value;
	}
	public String getTradingCapacityDes()
	{
		return TradingCapacityDes;
	}
	public void setTradingCapacityDes(String value)
	{
		TradingCapacityDes = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		TradingCapacityId = (long)byteBuffer.readInt();
		TradingCapacityCode = byteBuffer.readString();
		TradingCapacityDes = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(TradingCapacityId & 0xFFFFFFFFL));
		byteBuffer.writeString(TradingCapacityCode);
		byteBuffer.writeString(TradingCapacityDes);

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
		stringBuilder.append("BV_TRADING_CAPACITY::");
		stringBuilder.append("TradingCapacityId(").append(TradingCapacityId).append(")");
		stringBuilder.append("TradingCapacityCode(").append(TradingCapacityCode).append(")");
		stringBuilder.append("TradingCapacityDes(").append(TradingCapacityDes).append(")");
		return stringBuilder.toString();
	}
}
