package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_PORTFOLIO_RFCQ_TRADING_LEG extends SMPMessage
{
	public static final long CLASS_ID = 410022;

	private double Price = 0;
	private double Yield = 0;
	private double Countervalue = 0;
	private double Quantity = 0;
	private double Proceeds = 0;

	public BV_PORTFOLIO_RFCQ_TRADING_LEG()
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
	public double getCountervalue()
	{
		return Countervalue;
	}
	public void setCountervalue(double value)
	{
		Countervalue = value;
	}
	public double getQuantity()
	{
		return Quantity;
	}
	public void setQuantity(double value)
	{
		Quantity = value;
	}
	public double getProceeds()
	{
		return Proceeds;
	}
	public void setProceeds(double value)
	{
		Proceeds = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		Price = byteBuffer.readDouble();
		Yield = byteBuffer.readDouble();
		Countervalue = byteBuffer.readDouble();
		Quantity = byteBuffer.readDouble();
		Proceeds = byteBuffer.readDouble();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeDouble(Price);
		byteBuffer.writeDouble(Yield);
		byteBuffer.writeDouble(Countervalue);
		byteBuffer.writeDouble(Quantity);
		byteBuffer.writeDouble(Proceeds);

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
		stringBuilder.append("BV_PORTFOLIO_RFCQ_TRADING_LEG::");
		stringBuilder.append("Price(").append(Price).append(")");
		stringBuilder.append("Yield(").append(Yield).append(")");
		stringBuilder.append("Countervalue(").append(Countervalue).append(")");
		stringBuilder.append("Quantity(").append(Quantity).append(")");
		stringBuilder.append("Proceeds(").append(Proceeds).append(")");
		return stringBuilder.toString();
	}
}
