package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_REFERENCE_QUOTATION_FLOW extends SMPMessage
{
	public static final long CLASS_ID = 115003;

	private long InstrumentId = 0;
	private double Quotation = 0;
	private TI_TRADING_TYPE_Enum TradingType = TI_TRADING_TYPE_Enum.TI_TRADING_TYPE_CleanPrice;
	private long UpdateDate = 0;
	private long UpdateTime = 0;

	public BV_REFERENCE_QUOTATION_FLOW()
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
	public double getQuotation()
	{
		return Quotation;
	}
	public void setQuotation(double value)
	{
		Quotation = value;
	}
	public TI_TRADING_TYPE_Enum getTradingType()
	{
		return TradingType;
	}
	public void setTradingType(TI_TRADING_TYPE_Enum value)
	{
		TradingType = value;
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
		Quotation = byteBuffer.readDouble();
		TradingType = TradingType.getEnum(byteBuffer.readInt());
		UpdateDate = (long)byteBuffer.readInt();
		UpdateTime = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(InstrumentId & 0xFFFFFFFFL));
		byteBuffer.writeDouble(Quotation);
		byteBuffer.writeInt(TradingType.getValue());
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
		stringBuilder.append("BV_REFERENCE_QUOTATION_FLOW::");
		stringBuilder.append("InstrumentId(").append(InstrumentId).append(")");
		stringBuilder.append("Quotation(").append(Quotation).append(")");
		stringBuilder.append("TradingType(").append(TradingType).append(")");
		stringBuilder.append("UpdateDate(").append(UpdateDate).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		return stringBuilder.toString();
	}
}
