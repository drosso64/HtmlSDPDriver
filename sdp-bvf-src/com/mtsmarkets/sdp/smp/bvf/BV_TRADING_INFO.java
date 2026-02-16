package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_TRADING_INFO extends SMPMessage
{
	public static final long CLASS_ID = 114904;

	private double Price = 0;
	private double Yield = 0;
	private double Qty = 0;

	public BV_TRADING_INFO()
	{
	}

	public double getPrice()
	{
		return Price;
	}
	public void setPrice(double value)
	{
		Price = value;
	}
	public double getYield()
	{
		return Yield;
	}
	public void setYield(double value)
	{
		Yield = value;
	}
	public double getQty()
	{
		return Qty;
	}
	public void setQty(double value)
	{
		Qty = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		Price = byteBuffer.readDouble();
		Yield = byteBuffer.readDouble();
		Qty = byteBuffer.readDouble();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeDouble(Price);
		byteBuffer.writeDouble(Yield);
		byteBuffer.writeDouble(Qty);

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
		stringBuilder.append("BV_TRADING_INFO::");
		stringBuilder.append("Price(").append(Price).append(")");
		stringBuilder.append("Yield(").append(Yield).append(")");
		stringBuilder.append("Qty(").append(Qty).append(")");
		return stringBuilder.toString();
	}
}
