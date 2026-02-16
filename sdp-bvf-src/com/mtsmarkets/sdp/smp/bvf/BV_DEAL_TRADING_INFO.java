package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_DEAL_TRADING_INFO extends SMPMessage
{
	public static final long CLASS_ID = 114970;

	private double Price = 0;
	private double Yield = 0;
	private BV_VALUE YTC = new BV_VALUE();
	private BV_VALUE YTW = new BV_VALUE();
	private BV_VALUE YMWTh = new BV_VALUE();
	private double MWCPriceTh = 0;
	private BV_VALUE YMWExrc = new BV_VALUE();
	private BV_VALUE YTR = new BV_VALUE();
	private BV_ANALYTICS Analytics = new BV_ANALYTICS();
	private double DiscountRate = 0;
	private double DiscountMargin = 0;
	private double Qty = 0;

	public BV_DEAL_TRADING_INFO()
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
	public BV_VALUE getYTC()
	{
		return YTC;
	}
	public void setYTC(BV_VALUE value)
	{
		YTC = value;
	}
	public BV_VALUE getYTW()
	{
		return YTW;
	}
	public void setYTW(BV_VALUE value)
	{
		YTW = value;
	}
	public BV_VALUE getYMWTh()
	{
		return YMWTh;
	}
	public void setYMWTh(BV_VALUE value)
	{
		YMWTh = value;
	}
	public double getMWCPriceTh()
	{
		return MWCPriceTh;
	}
	public void setMWCPriceTh(double value)
	{
		MWCPriceTh = value;
	}
	public BV_VALUE getYMWExrc()
	{
		return YMWExrc;
	}
	public void setYMWExrc(BV_VALUE value)
	{
		YMWExrc = value;
	}
	public BV_VALUE getYTR()
	{
		return YTR;
	}
	public void setYTR(BV_VALUE value)
	{
		YTR = value;
	}
	public BV_ANALYTICS getAnalytics()
	{
		return Analytics;
	}
	public void setAnalytics(BV_ANALYTICS value)
	{
		Analytics = value;
	}
	public double getDiscountRate()
	{
		return DiscountRate;
	}
	public void setDiscountRate(double value)
	{
		DiscountRate = value;
	}
	public double getDiscountMargin()
	{
		return DiscountMargin;
	}
	public void setDiscountMargin(double value)
	{
		DiscountMargin = value;
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
		YTC.readXDR(byteBuffer);
		YTW.readXDR(byteBuffer);
		YMWTh.readXDR(byteBuffer);
		MWCPriceTh = byteBuffer.readDouble();
		YMWExrc.readXDR(byteBuffer);
		YTR.readXDR(byteBuffer);
		Analytics.readXDR(byteBuffer);
		DiscountRate = byteBuffer.readDouble();
		DiscountMargin = byteBuffer.readDouble();
		Qty = byteBuffer.readDouble();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeDouble(Price);
		byteBuffer.writeDouble(Yield);
		YTC.writeXDR(byteBuffer);
		YTW.writeXDR(byteBuffer);
		YMWTh.writeXDR(byteBuffer);
		byteBuffer.writeDouble(MWCPriceTh);
		YMWExrc.writeXDR(byteBuffer);
		YTR.writeXDR(byteBuffer);
		Analytics.writeXDR(byteBuffer);
		byteBuffer.writeDouble(DiscountRate);
		byteBuffer.writeDouble(DiscountMargin);
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
		stringBuilder.append("BV_DEAL_TRADING_INFO::");
		stringBuilder.append("Price(").append(Price).append(")");
		stringBuilder.append("Yield(").append(Yield).append(")");
		stringBuilder.append("YTC(").append(YTC.toString()).append(")");
		stringBuilder.append("YTW(").append(YTW.toString()).append(")");
		stringBuilder.append("YMWTh(").append(YMWTh.toString()).append(")");
		stringBuilder.append("MWCPriceTh(").append(MWCPriceTh).append(")");
		stringBuilder.append("YMWExrc(").append(YMWExrc.toString()).append(")");
		stringBuilder.append("YTR(").append(YTR.toString()).append(")");
		stringBuilder.append("Analytics(").append(Analytics.toString()).append(")");
		stringBuilder.append("DiscountRate(").append(DiscountRate).append(")");
		stringBuilder.append("DiscountMargin(").append(DiscountMargin).append(")");
		stringBuilder.append("Qty(").append(Qty).append(")");
		return stringBuilder.toString();
	}
}
