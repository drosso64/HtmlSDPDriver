package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_HIST_PORTFOLIO_RFCQ_ORDER_LEG extends SMPMessage
{
	public static final long CLASS_ID = 410024;

	private short LegId = 0;
	private BV_HIST_INSTRUMENT_INFO Instrument = new BV_HIST_INSTRUMENT_INFO();
	private double Price = 0;
	private double Yield = 0;
	private double Countervalue = 0;
	private double Quantity = 0;
	private double Proceeds = 0;

	public BV_HIST_PORTFOLIO_RFCQ_ORDER_LEG()
	{
	}

	public short getLegId()
	{
		return LegId;
	}
	public void setLegId(short value)
	{
		LegId = value;
	}
	public BV_HIST_INSTRUMENT_INFO getInstrument()
	{
		return Instrument;
	}
	public void setInstrument(BV_HIST_INSTRUMENT_INFO value)
	{
		Instrument = value;
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
		LegId = (short)byteBuffer.readInt();
		Instrument.readXDR(byteBuffer);
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

		byteBuffer.writeInt((int)(LegId & 0xFFFFL));
		Instrument.writeXDR(byteBuffer);
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
		stringBuilder.append("BV_HIST_PORTFOLIO_RFCQ_ORDER_LEG::");
		stringBuilder.append("LegId(").append(LegId).append(")");
		stringBuilder.append("Instrument(").append(Instrument.toString()).append(")");
		stringBuilder.append("Price(").append(Price).append(")");
		stringBuilder.append("Yield(").append(Yield).append(")");
		stringBuilder.append("Countervalue(").append(Countervalue).append(")");
		stringBuilder.append("Quantity(").append(Quantity).append(")");
		stringBuilder.append("Proceeds(").append(Proceeds).append(")");
		return stringBuilder.toString();
	}
}
