package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_CURVE_FLOW_INFO extends SMPMessage
{
	public static final long CLASS_ID = 114815;

	private long Tenor = 0;
	private double Value = 0;

	public BV_CURVE_FLOW_INFO()
	{
	}

	public long getTenor()
	{
		return Tenor;
	}
	public void setTenor(long value)
	{
		Tenor = value;
	}
	public double getValue()
	{
		return Value;
	}
	public void setValue(double value)
	{
		Value = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		Tenor = (long)byteBuffer.readInt();
		Value = byteBuffer.readDouble();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(Tenor & 0xFFFFFFFFL));
		byteBuffer.writeDouble(Value);

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
		stringBuilder.append("BV_CURVE_FLOW_INFO::");
		stringBuilder.append("Tenor(").append(Tenor).append(")");
		stringBuilder.append("Value(").append(Value).append(")");
		return stringBuilder.toString();
	}
}
