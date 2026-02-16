package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_INVENTORY_QUOTE extends SMPMessage
{
	public static final long CLASS_ID = 114166;

	private BV_INVENTORY_QUOTE_INFO Quote = new BV_INVENTORY_QUOTE_INFO();

	public BV_INVENTORY_QUOTE()
	{
	}

	public BV_INVENTORY_QUOTE_INFO getQuote()
	{
		return Quote;
	}
	public void setQuote(BV_INVENTORY_QUOTE_INFO value)
	{
		Quote = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		Quote.readXDR(byteBuffer);
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		Quote.writeXDR(byteBuffer);

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
		stringBuilder.append("BV_INVENTORY_QUOTE::");
		stringBuilder.append("Quote(").append(Quote.toString()).append(")");
		return stringBuilder.toString();
	}
}
