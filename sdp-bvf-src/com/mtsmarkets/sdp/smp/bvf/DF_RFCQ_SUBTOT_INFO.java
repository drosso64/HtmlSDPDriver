package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class DF_RFCQ_SUBTOT_INFO extends SMPMessage
{
	public static final long CLASS_ID = 107905;

	private long RFCQNum = 0;
	private double RFCQNomValue = 0;
	private long IONum = 0;
	private double IONomValue = 0;

	public DF_RFCQ_SUBTOT_INFO()
	{
	}

	public long getRFCQNum()
	{
		return RFCQNum;
	}
	public void setRFCQNum(long value)
	{
		RFCQNum = value;
	}
	public double getRFCQNomValue()
	{
		return RFCQNomValue;
	}
	public void setRFCQNomValue(double value)
	{
		RFCQNomValue = value;
	}
	public long getIONum()
	{
		return IONum;
	}
	public void setIONum(long value)
	{
		IONum = value;
	}
	public double getIONomValue()
	{
		return IONomValue;
	}
	public void setIONomValue(double value)
	{
		IONomValue = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		RFCQNum = (long)byteBuffer.readInt();
		RFCQNomValue = byteBuffer.readDouble();
		IONum = (long)byteBuffer.readInt();
		IONomValue = byteBuffer.readDouble();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(RFCQNum & 0xFFFFFFFFL));
		byteBuffer.writeDouble(RFCQNomValue);
		byteBuffer.writeInt((int)(IONum & 0xFFFFFFFFL));
		byteBuffer.writeDouble(IONomValue);

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
		stringBuilder.append("DF_RFCQ_SUBTOT_INFO::");
		stringBuilder.append("RFCQNum(").append(RFCQNum).append(")");
		stringBuilder.append("RFCQNomValue(").append(RFCQNomValue).append(")");
		stringBuilder.append("IONum(").append(IONum).append(")");
		stringBuilder.append("IONomValue(").append(IONomValue).append(")");
		return stringBuilder.toString();
	}
}
