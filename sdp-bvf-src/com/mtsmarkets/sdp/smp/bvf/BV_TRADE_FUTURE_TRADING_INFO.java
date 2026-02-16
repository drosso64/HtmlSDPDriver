package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_TRADE_FUTURE_TRADING_INFO extends SMPMessage
{
	public static final long CLASS_ID = 410011;

	private double Price = 0;
	private double Qty = 0;
	private double ConversionFactor = 0;
	private BV_VALUE GrossBasis = new BV_VALUE();
	private BV_HEDGE_RATIO_Enum HedgeRatio = BV_HEDGE_RATIO_Enum.BV_HEDGE_RATIO_None;

	public BV_TRADE_FUTURE_TRADING_INFO()
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
	public double getQty()
	{
		return Qty;
	}
	public void setQty(double value)
	{
		Qty = value;
	}
	public double getConversionFactor()
	{
		return ConversionFactor;
	}
	public void setConversionFactor(double value)
	{
		ConversionFactor = value;
	}
	public BV_VALUE getGrossBasis()
	{
		return GrossBasis;
	}
	public void setGrossBasis(BV_VALUE value)
	{
		GrossBasis = value;
	}
	public BV_HEDGE_RATIO_Enum getHedgeRatio()
	{
		return HedgeRatio;
	}
	public void setHedgeRatio(BV_HEDGE_RATIO_Enum value)
	{
		HedgeRatio = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		Price = byteBuffer.readDouble();
		Qty = byteBuffer.readDouble();
		ConversionFactor = byteBuffer.readDouble();
		GrossBasis.readXDR(byteBuffer);
		HedgeRatio = HedgeRatio.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeDouble(Price);
		byteBuffer.writeDouble(Qty);
		byteBuffer.writeDouble(ConversionFactor);
		GrossBasis.writeXDR(byteBuffer);
		byteBuffer.writeInt(HedgeRatio.getValue());

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
		stringBuilder.append("BV_TRADE_FUTURE_TRADING_INFO::");
		stringBuilder.append("Price(").append(Price).append(")");
		stringBuilder.append("Qty(").append(Qty).append(")");
		stringBuilder.append("ConversionFactor(").append(ConversionFactor).append(")");
		stringBuilder.append("GrossBasis(").append(GrossBasis.toString()).append(")");
		stringBuilder.append("HedgeRatio(").append(HedgeRatio).append(")");
		return stringBuilder.toString();
	}
}
