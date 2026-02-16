package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_VALUE extends SMPMessage
{
	public static final long CLASS_ID = 114978;

	private double Value = 0;
	private TI_FLAG_Enum ValueFg = TI_FLAG_Enum.TI_FLAG_No;

	public BV_VALUE()
	{
	}

	public double getValue()
	{
		return Value;
	}
	public void setValue(double value)
	{
		Value = value;
	}
	public TI_FLAG_Enum getValueFg()
	{
		return ValueFg;
	}
	public void setValueFg(TI_FLAG_Enum value)
	{
		ValueFg = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		Value = byteBuffer.readDouble();
		ValueFg = ValueFg.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeDouble(Value);
		byteBuffer.writeInt(ValueFg.getValue());

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
		stringBuilder.append("BV_VALUE::");
		stringBuilder.append("Value(").append(Value).append(")");
		stringBuilder.append("ValueFg(").append(ValueFg).append(")");
		return stringBuilder.toString();
	}
}
