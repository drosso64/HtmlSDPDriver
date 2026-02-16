package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_FINANCIAL_CALCULATOR_VALUE extends SMPMessage
{
	public static final long CLASS_ID = 100905;

	private int LongValue = 0;
	private TI_FLAG_Enum LongValueNullIndicator = TI_FLAG_Enum.TI_FLAG_No;
	private double DoubleValue = 0;
	private TI_FLAG_Enum DoubleValueNullIndicator = TI_FLAG_Enum.TI_FLAG_No;
	private String StringValue = "";
	private TI_FLAG_Enum StringValueNullIndicator = TI_FLAG_Enum.TI_FLAG_No;
	private long DateValue = 0;
	private TI_FLAG_Enum DateValueNullIndicator = TI_FLAG_Enum.TI_FLAG_No;

	public TI_FINANCIAL_CALCULATOR_VALUE()
	{
	}

	public int getLongValue()
	{
		return LongValue;
	}
	public void setLongValue(int value)
	{
		LongValue = value;
	}
	public TI_FLAG_Enum getLongValueNullIndicator()
	{
		return LongValueNullIndicator;
	}
	public void setLongValueNullIndicator(TI_FLAG_Enum value)
	{
		LongValueNullIndicator = value;
	}
	public double getDoubleValue()
	{
		return DoubleValue;
	}
	public void setDoubleValue(double value)
	{
		DoubleValue = value;
	}
	public TI_FLAG_Enum getDoubleValueNullIndicator()
	{
		return DoubleValueNullIndicator;
	}
	public void setDoubleValueNullIndicator(TI_FLAG_Enum value)
	{
		DoubleValueNullIndicator = value;
	}
	public String getStringValue()
	{
		return StringValue;
	}
	public void setStringValue(String value)
	{
		StringValue = value;
	}
	public TI_FLAG_Enum getStringValueNullIndicator()
	{
		return StringValueNullIndicator;
	}
	public void setStringValueNullIndicator(TI_FLAG_Enum value)
	{
		StringValueNullIndicator = value;
	}
	public long getDateValue()
	{
		return DateValue;
	}
	public void setDateValue(long value)
	{
		DateValue = value;
	}
	public TI_FLAG_Enum getDateValueNullIndicator()
	{
		return DateValueNullIndicator;
	}
	public void setDateValueNullIndicator(TI_FLAG_Enum value)
	{
		DateValueNullIndicator = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		LongValue = (int)byteBuffer.readInt();
		LongValueNullIndicator = LongValueNullIndicator.getEnum(byteBuffer.readInt());
		DoubleValue = byteBuffer.readDouble();
		DoubleValueNullIndicator = DoubleValueNullIndicator.getEnum(byteBuffer.readInt());
		StringValue = byteBuffer.readString();
		StringValueNullIndicator = StringValueNullIndicator.getEnum(byteBuffer.readInt());
		DateValue = (long)byteBuffer.readInt();
		DateValueNullIndicator = DateValueNullIndicator.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(LongValue & 0xFFFFFFFFL));
		byteBuffer.writeInt(LongValueNullIndicator.getValue());
		byteBuffer.writeDouble(DoubleValue);
		byteBuffer.writeInt(DoubleValueNullIndicator.getValue());
		byteBuffer.writeString(StringValue);
		byteBuffer.writeInt(StringValueNullIndicator.getValue());
		byteBuffer.writeInt((int)(DateValue & 0xFFFFFFFFL));
		byteBuffer.writeInt(DateValueNullIndicator.getValue());

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
		stringBuilder.append("TI_FINANCIAL_CALCULATOR_VALUE::");
		stringBuilder.append("LongValue(").append(LongValue).append(")");
		stringBuilder.append("LongValueNullIndicator(").append(LongValueNullIndicator).append(")");
		stringBuilder.append("DoubleValue(").append(DoubleValue).append(")");
		stringBuilder.append("DoubleValueNullIndicator(").append(DoubleValueNullIndicator).append(")");
		stringBuilder.append("StringValue(").append(StringValue).append(")");
		stringBuilder.append("StringValueNullIndicator(").append(StringValueNullIndicator).append(")");
		stringBuilder.append("DateValue(").append(DateValue).append(")");
		stringBuilder.append("DateValueNullIndicator(").append(DateValueNullIndicator).append(")");
		return stringBuilder.toString();
	}
}
