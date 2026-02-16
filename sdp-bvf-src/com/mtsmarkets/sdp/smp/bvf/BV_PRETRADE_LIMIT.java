package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_PRETRADE_LIMIT extends SMPMessage
{
	public static final long CLASS_ID = 400027;

	private long InstrumentId = 0;
	private double IndInventoryQuotesCap = 0;
	private double ExecInventoryQuotesCap = 0;
	private double MinExecQtyInventoryCAP = 0;
	private double AllOrdersCap = 0;
	private long UpdateDate = 0;
	private long UpdateTime = 0;

	public BV_PRETRADE_LIMIT()
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
	public double getIndInventoryQuotesCap()
	{
		return IndInventoryQuotesCap;
	}
	public void setIndInventoryQuotesCap(double value)
	{
		IndInventoryQuotesCap = value;
	}
	public double getExecInventoryQuotesCap()
	{
		return ExecInventoryQuotesCap;
	}
	public void setExecInventoryQuotesCap(double value)
	{
		ExecInventoryQuotesCap = value;
	}
	public double getMinExecQtyInventoryCAP()
	{
		return MinExecQtyInventoryCAP;
	}
	public void setMinExecQtyInventoryCAP(double value)
	{
		MinExecQtyInventoryCAP = value;
	}
	public double getAllOrdersCap()
	{
		return AllOrdersCap;
	}
	public void setAllOrdersCap(double value)
	{
		AllOrdersCap = value;
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
		IndInventoryQuotesCap = byteBuffer.readDouble();
		ExecInventoryQuotesCap = byteBuffer.readDouble();
		MinExecQtyInventoryCAP = byteBuffer.readDouble();
		AllOrdersCap = byteBuffer.readDouble();
		UpdateDate = (long)byteBuffer.readInt();
		UpdateTime = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(InstrumentId & 0xFFFFFFFFL));
		byteBuffer.writeDouble(IndInventoryQuotesCap);
		byteBuffer.writeDouble(ExecInventoryQuotesCap);
		byteBuffer.writeDouble(MinExecQtyInventoryCAP);
		byteBuffer.writeDouble(AllOrdersCap);
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
		stringBuilder.append("BV_PRETRADE_LIMIT::");
		stringBuilder.append("InstrumentId(").append(InstrumentId).append(")");
		stringBuilder.append("IndInventoryQuotesCap(").append(IndInventoryQuotesCap).append(")");
		stringBuilder.append("ExecInventoryQuotesCap(").append(ExecInventoryQuotesCap).append(")");
		stringBuilder.append("MinExecQtyInventoryCAP(").append(MinExecQtyInventoryCAP).append(")");
		stringBuilder.append("AllOrdersCap(").append(AllOrdersCap).append(")");
		stringBuilder.append("UpdateDate(").append(UpdateDate).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		return stringBuilder.toString();
	}
}
