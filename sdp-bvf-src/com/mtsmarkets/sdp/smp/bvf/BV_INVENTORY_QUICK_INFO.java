package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_INVENTORY_QUICK_INFO extends SMPMessage
{
	public static final long CLASS_ID = 114173;

	private long QuoteId = 0;
	private long ValidationTime = 0;
	private BV_QUOTE_EVENT_Enum Event = BV_QUOTE_EVENT_Enum.BV_QUOTE_EVENT_Activate;

	public BV_INVENTORY_QUICK_INFO()
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
	public long getValidationTime()
	{
		return ValidationTime;
	}
	public void setValidationTime(long value)
	{
		ValidationTime = value;
	}
	public BV_QUOTE_EVENT_Enum getEvent()
	{
		return Event;
	}
	public void setEvent(BV_QUOTE_EVENT_Enum value)
	{
		Event = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		QuoteId = (long)byteBuffer.readInt();
		ValidationTime = byteBuffer.readLong();
		Event = Event.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(QuoteId & 0xFFFFFFFFL));
		byteBuffer.writeLong(ValidationTime);
		byteBuffer.writeInt(Event.getValue());

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
		stringBuilder.append("BV_INVENTORY_QUICK_INFO::");
		stringBuilder.append("QuoteId(").append(QuoteId).append(")");
		stringBuilder.append("ValidationTime(").append(ValidationTime).append(")");
		stringBuilder.append("Event(").append(Event).append(")");
		return stringBuilder.toString();
	}
}
