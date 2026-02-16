package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class DF_BV_BUYBACK_PRICE extends SMPMessage
{
	public static final long CLASS_ID = 114609;

	private long InstrumentId = 0;
	private double Price = 0;
	private long RefDate = 0;
	private long RefTime = 0;
	private long UpdateDate = 0;
	private long UpdateTime = 0;

	public DF_BV_BUYBACK_PRICE()
	{
	}

	public long getInstrumentId()
	{
		return InstrumentId;
	}
	public void setInstrumentId(long value)
	{
		InstrumentId = value;
	}
	public double getPrice()
	{
		return Price;
	}
	public void setPrice(double value)
	{
		Price = value;
	}
	public long getRefDate()
	{
		return RefDate;
	}
	public void setRefDate(long value)
	{
		RefDate = value;
	}
	public long getRefTime()
	{
		return RefTime;
	}
	public void setRefTime(long value)
	{
		RefTime = value;
	}
	public long getUpdateDate()
	{
		return UpdateDate;
	}
	public void setUpdateDate(long value)
	{
		UpdateDate = value;
	}
	public long getUpdateTime()
	{
		return UpdateTime;
	}
	public void setUpdateTime(long value)
	{
		UpdateTime = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		InstrumentId = (long)byteBuffer.readInt();
		Price = byteBuffer.readDouble();
		RefDate = (long)byteBuffer.readInt();
		RefTime = byteBuffer.readLong();
		UpdateDate = (long)byteBuffer.readInt();
		UpdateTime = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(InstrumentId & 0xFFFFFFFFL));
		byteBuffer.writeDouble(Price);
		byteBuffer.writeInt((int)(RefDate & 0xFFFFFFFFL));
		byteBuffer.writeLong(RefTime);
		byteBuffer.writeInt((int)(UpdateDate & 0xFFFFFFFFL));
		byteBuffer.writeLong(UpdateTime);

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
		stringBuilder.append("DF_BV_BUYBACK_PRICE::");
		stringBuilder.append("InstrumentId(").append(InstrumentId).append(")");
		stringBuilder.append("Price(").append(Price).append(")");
		stringBuilder.append("RefDate(").append(RefDate).append(")");
		stringBuilder.append("RefTime(").append(RefTime).append(")");
		stringBuilder.append("UpdateDate(").append(UpdateDate).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		return stringBuilder.toString();
	}
}
