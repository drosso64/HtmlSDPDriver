package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_PRE_TRADE_QUOTE extends SMPMessage
{
	public static final long CLASS_ID = 400036;

	private long RecordId = 0;
	private long InstrumentId = 0;
	private long ReferenceTime = 0;
	private double Price = 0;
	private TI_FLAG_Enum YieldFg = TI_FLAG_Enum.TI_FLAG_No;
	private double Yield = 0;
	private double NotionalAmount = 0;
	private String Currency = "";
	private BV_WAIVER_INDICATOR_Enum WaiverIndicator = BV_WAIVER_INDICATOR_Enum.BV_WAIVER_INDICATOR_None;
	private BV_PRE_TRADE_PUBLISH_FLAG_Enum PreTradePublishFg = BV_PRE_TRADE_PUBLISH_FLAG_Enum.BV_PRE_TRADE_PUBLISH_FLAG_None;

	public BV_PRE_TRADE_QUOTE()
	{
	}

	public long getRecordId()
	{
		return RecordId;
	}
	public void setRecordId(long value)
	{
		RecordId = value;
	}
	public long getInstrumentId()
	{
		return InstrumentId;
	}
	public void setInstrumentId(long value)
	{
		InstrumentId = value;
	}
	public long getReferenceTime()
	{
		return ReferenceTime;
	}
	public void setReferenceTime(long value)
	{
		ReferenceTime = value;
	}
	public double getPrice()
	{
		return Price;
	}
	public void setPrice(double value)
	{
		Price = value;
	}
	public TI_FLAG_Enum getYieldFg()
	{
		return YieldFg;
	}
	public void setYieldFg(TI_FLAG_Enum value)
	{
		YieldFg = value;
	}
	public double getYield()
	{
		return Yield;
	}
	public void setYield(double value)
	{
		Yield = value;
	}
	public double getNotionalAmount()
	{
		return NotionalAmount;
	}
	public void setNotionalAmount(double value)
	{
		NotionalAmount = value;
	}
	public String getCurrency()
	{
		return Currency;
	}
	public void setCurrency(String value)
	{
		Currency = value;
	}
	public BV_WAIVER_INDICATOR_Enum getWaiverIndicator()
	{
		return WaiverIndicator;
	}
	public void setWaiverIndicator(BV_WAIVER_INDICATOR_Enum value)
	{
		WaiverIndicator = value;
	}
	public BV_PRE_TRADE_PUBLISH_FLAG_Enum getPreTradePublishFg()
	{
		return PreTradePublishFg;
	}
	public void setPreTradePublishFg(BV_PRE_TRADE_PUBLISH_FLAG_Enum value)
	{
		PreTradePublishFg = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		RecordId = (long)byteBuffer.readInt();
		InstrumentId = (long)byteBuffer.readInt();
		ReferenceTime = byteBuffer.readLong();
		Price = byteBuffer.readDouble();
		YieldFg = YieldFg.getEnum(byteBuffer.readInt());
		Yield = byteBuffer.readDouble();
		NotionalAmount = byteBuffer.readDouble();
		Currency = byteBuffer.readString();
		WaiverIndicator = WaiverIndicator.getEnum(byteBuffer.readInt());
		PreTradePublishFg = PreTradePublishFg.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(RecordId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(InstrumentId & 0xFFFFFFFFL));
		byteBuffer.writeLong(ReferenceTime);
		byteBuffer.writeDouble(Price);
		byteBuffer.writeInt(YieldFg.getValue());
		byteBuffer.writeDouble(Yield);
		byteBuffer.writeDouble(NotionalAmount);
		byteBuffer.writeString(Currency);
		byteBuffer.writeInt(WaiverIndicator.getValue());
		byteBuffer.writeInt(PreTradePublishFg.getValue());

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
		stringBuilder.append("BV_PRE_TRADE_QUOTE::");
		stringBuilder.append("RecordId(").append(RecordId).append(")");
		stringBuilder.append("InstrumentId(").append(InstrumentId).append(")");
		stringBuilder.append("ReferenceTime(").append(ReferenceTime).append(")");
		stringBuilder.append("Price(").append(Price).append(")");
		stringBuilder.append("YieldFg(").append(YieldFg).append(")");
		stringBuilder.append("Yield(").append(Yield).append(")");
		stringBuilder.append("NotionalAmount(").append(NotionalAmount).append(")");
		stringBuilder.append("Currency(").append(Currency).append(")");
		stringBuilder.append("WaiverIndicator(").append(WaiverIndicator).append(")");
		stringBuilder.append("PreTradePublishFg(").append(PreTradePublishFg).append(")");
		return stringBuilder.toString();
	}
}
