package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_CANCEL_PROPOSAL extends SMPMessage
{
	public static final long CLASS_ID = 100802;

	private long SuspId = 0;
	private long MarketId = 0;
	private long InstrumentId = 0;
	private long SuspDate = 0;
	private long SuspTime = 0;

	public TI_CANCEL_PROPOSAL()
	{
	}

	public long getSuspId()
	{
		return SuspId;
	}
	public void setSuspId(long value)
	{
		SuspId = value;
	}
	public long getMarketId()
	{
		return MarketId;
	}
	public void setMarketId(long value)
	{
		MarketId = value;
	}
	public long getInstrumentId()
	{
		return InstrumentId;
	}
	public void setInstrumentId(long value)
	{
		InstrumentId = value;
	}
	public long getSuspDate()
	{
		return SuspDate;
	}
	public void setSuspDate(long value)
	{
		SuspDate = value;
	}
	public long getSuspTime()
	{
		return SuspTime;
	}
	public void setSuspTime(long value)
	{
		SuspTime = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		SuspId = (long)byteBuffer.readInt();
		MarketId = (long)byteBuffer.readInt();
		InstrumentId = (long)byteBuffer.readInt();
		SuspDate = (long)byteBuffer.readInt();
		SuspTime = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(SuspId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(MarketId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(InstrumentId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SuspDate & 0xFFFFFFFFL));
		byteBuffer.writeLong(SuspTime);

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
		stringBuilder.append("TI_CANCEL_PROPOSAL::");
		stringBuilder.append("SuspId(").append(SuspId).append(")");
		stringBuilder.append("MarketId(").append(MarketId).append(")");
		stringBuilder.append("InstrumentId(").append(InstrumentId).append(")");
		stringBuilder.append("SuspDate(").append(SuspDate).append(")");
		stringBuilder.append("SuspTime(").append(SuspTime).append(")");
		return stringBuilder.toString();
	}
}
