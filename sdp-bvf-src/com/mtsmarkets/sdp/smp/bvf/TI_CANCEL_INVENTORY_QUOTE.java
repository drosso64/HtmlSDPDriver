package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_CANCEL_INVENTORY_QUOTE extends SMPMessage
{
	public static final long CLASS_ID = 100808;

	private long QuoteId = 0;
	private long MarketId = 0;
	private long InstrumentId = 0;
	private long CancelDate = 0;
	private long CancelTime = 0;

	public TI_CANCEL_INVENTORY_QUOTE()
	{
	}

	public long getQuoteId()
	{
		return QuoteId;
	}
	public void setQuoteId(long value)
	{
		QuoteId = value;
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
	public long getCancelDate()
	{
		return CancelDate;
	}
	public void setCancelDate(long value)
	{
		CancelDate = value;
	}
	public long getCancelTime()
	{
		return CancelTime;
	}
	public void setCancelTime(long value)
	{
		CancelTime = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		QuoteId = (long)byteBuffer.readInt();
		MarketId = (long)byteBuffer.readInt();
		InstrumentId = (long)byteBuffer.readInt();
		CancelDate = (long)byteBuffer.readInt();
		CancelTime = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(QuoteId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(MarketId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(InstrumentId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(CancelDate & 0xFFFFFFFFL));
		byteBuffer.writeLong(CancelTime);

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
		stringBuilder.append("TI_CANCEL_INVENTORY_QUOTE::");
		stringBuilder.append("QuoteId(").append(QuoteId).append(")");
		stringBuilder.append("MarketId(").append(MarketId).append(")");
		stringBuilder.append("InstrumentId(").append(InstrumentId).append(")");
		stringBuilder.append("CancelDate(").append(CancelDate).append(")");
		stringBuilder.append("CancelTime(").append(CancelTime).append(")");
		return stringBuilder.toString();
	}
}
