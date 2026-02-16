package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_RFCQ_LEG_TRADING_LEVEL extends SMPMessage
{
	public static final long CLASS_ID = 114950;

	private long MemberId = 0;
	private long QuoteId = 0;
	private double Price = 0;
	private double Yield = 0;
	private BV_VALUE YTW = new BV_VALUE();
	private double Qty = 0;
	private double BenchmarkSpreadValue = 0;
	private TI_RFCQ_PROVIDER_STATUS_Enum ProviderStatus = TI_RFCQ_PROVIDER_STATUS_Enum.TI_RFCQ_PROVIDER_STATUS_Processing;

	public BV_RFCQ_LEG_TRADING_LEVEL()
	{
	}

	public long getMemberId()
	{
		return MemberId;
	}
	public void setMemberId(long value)
	{
		MemberId = value;
	}
	public long getQuoteId()
	{
		return QuoteId;
	}
	public void setQuoteId(long value)
	{
		QuoteId = value;
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
	public BV_VALUE getYTW()
	{
		return YTW;
	}
	public void setYTW(BV_VALUE value)
	{
		YTW = value;
	}
	public double getQty()
	{
		return Qty;
	}
	public void setQty(double value)
	{
		Qty = value;
	}
	public double getBenchmarkSpreadValue()
	{
		return BenchmarkSpreadValue;
	}
	public void setBenchmarkSpreadValue(double value)
	{
		BenchmarkSpreadValue = value;
	}
	public TI_RFCQ_PROVIDER_STATUS_Enum getProviderStatus()
	{
		return ProviderStatus;
	}
	public void setProviderStatus(TI_RFCQ_PROVIDER_STATUS_Enum value)
	{
		ProviderStatus = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MemberId = (long)byteBuffer.readInt();
		QuoteId = (long)byteBuffer.readInt();
		Price = byteBuffer.readDouble();
		Yield = byteBuffer.readDouble();
		YTW.readXDR(byteBuffer);
		Qty = byteBuffer.readDouble();
		BenchmarkSpreadValue = byteBuffer.readDouble();
		ProviderStatus = ProviderStatus.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(QuoteId & 0xFFFFFFFFL));
		byteBuffer.writeDouble(Price);
		byteBuffer.writeDouble(Yield);
		YTW.writeXDR(byteBuffer);
		byteBuffer.writeDouble(Qty);
		byteBuffer.writeDouble(BenchmarkSpreadValue);
		byteBuffer.writeInt(ProviderStatus.getValue());

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
		stringBuilder.append("BV_RFCQ_LEG_TRADING_LEVEL::");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("QuoteId(").append(QuoteId).append(")");
		stringBuilder.append("Price(").append(Price).append(")");
		stringBuilder.append("Yield(").append(Yield).append(")");
		stringBuilder.append("YTW(").append(YTW.toString()).append(")");
		stringBuilder.append("Qty(").append(Qty).append(")");
		stringBuilder.append("BenchmarkSpreadValue(").append(BenchmarkSpreadValue).append(")");
		stringBuilder.append("ProviderStatus(").append(ProviderStatus).append(")");
		return stringBuilder.toString();
	}
}
