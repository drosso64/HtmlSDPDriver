package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_MEMBER_STAT extends SMPMessage
{
	public static final long CLASS_ID = 114908;

	private double AvgPrice = 0;
	private double AvgYield = 0;
	private long NumOfDeals = 0;
	private double Qty = 0;
	private double NominalValue = 0;

	public BV_MEMBER_STAT()
	{
	}

	public double getAvgPrice()
	{
		return AvgPrice;
	}
	public void setAvgPrice(double value)
	{
		AvgPrice = value;
	}
	public double getAvgYield()
	{
		return AvgYield;
	}
	public void setAvgYield(double value)
	{
		AvgYield = value;
	}
	public long getNumOfDeals()
	{
		return NumOfDeals;
	}
	public void setNumOfDeals(long value)
	{
		NumOfDeals = value;
	}
	public double getQty()
	{
		return Qty;
	}
	public void setQty(double value)
	{
		Qty = value;
	}
	public double getNominalValue()
	{
		return NominalValue;
	}
	public void setNominalValue(double value)
	{
		NominalValue = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		AvgPrice = byteBuffer.readDouble();
		AvgYield = byteBuffer.readDouble();
		NumOfDeals = (long)byteBuffer.readInt();
		Qty = byteBuffer.readDouble();
		NominalValue = byteBuffer.readDouble();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeDouble(AvgPrice);
		byteBuffer.writeDouble(AvgYield);
		byteBuffer.writeInt((int)(NumOfDeals & 0xFFFFFFFFL));
		byteBuffer.writeDouble(Qty);
		byteBuffer.writeDouble(NominalValue);

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
		stringBuilder.append("BV_MEMBER_STAT::");
		stringBuilder.append("AvgPrice(").append(AvgPrice).append(")");
		stringBuilder.append("AvgYield(").append(AvgYield).append(")");
		stringBuilder.append("NumOfDeals(").append(NumOfDeals).append(")");
		stringBuilder.append("Qty(").append(Qty).append(")");
		stringBuilder.append("NominalValue(").append(NominalValue).append(")");
		return stringBuilder.toString();
	}
}
