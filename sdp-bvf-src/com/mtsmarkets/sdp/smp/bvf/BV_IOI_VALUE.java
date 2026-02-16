package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_IOI_VALUE extends SMPMessage
{
	public static final long CLASS_ID = 114979;

	private BV_VALUE Bid = new BV_VALUE();
	private BV_VALUE Mid = new BV_VALUE();
	private BV_VALUE Offer = new BV_VALUE();

	public BV_IOI_VALUE()
	{
	}

	public BV_VALUE getBid()
	{
		return Bid;
	}
	public void setBid(BV_VALUE value)
	{
		Bid = value;
	}
	public BV_VALUE getMid()
	{
		return Mid;
	}
	public void setMid(BV_VALUE value)
	{
		Mid = value;
	}
	public BV_VALUE getOffer()
	{
		return Offer;
	}
	public void setOffer(BV_VALUE value)
	{
		Offer = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		Bid.readXDR(byteBuffer);
		Mid.readXDR(byteBuffer);
		Offer.readXDR(byteBuffer);
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		Bid.writeXDR(byteBuffer);
		Mid.writeXDR(byteBuffer);
		Offer.writeXDR(byteBuffer);

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
		stringBuilder.append("BV_IOI_VALUE::");
		stringBuilder.append("Bid(").append(Bid.toString()).append(")");
		stringBuilder.append("Mid(").append(Mid.toString()).append(")");
		stringBuilder.append("Offer(").append(Offer.toString()).append(")");
		return stringBuilder.toString();
	}
}
