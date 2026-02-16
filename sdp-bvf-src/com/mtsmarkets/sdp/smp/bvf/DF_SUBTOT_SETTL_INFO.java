package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class DF_SUBTOT_SETTL_INFO extends SMPMessage
{
	public static final long CLASS_ID = 107903;

	private long DefinedAutoTradeNum = 0;
	private double DefinedAutoTradeNomValue = 0;
	private long UndefinedAutoTradeNum = 0;
	private double UndefinedAutoTradeNomValue = 0;
	private long DefinedManualTradeNum = 0;
	private double DefinedManualTradeNomValue = 0;
	private long UndefinedManualTradeNum = 0;
	private double UndefinedManualTradeNomValue = 0;

	public DF_SUBTOT_SETTL_INFO()
	{
	}

	public long getDefinedAutoTradeNum()
	{
		return DefinedAutoTradeNum;
	}
	public void setDefinedAutoTradeNum(long value)
	{
		DefinedAutoTradeNum = value;
	}
	public double getDefinedAutoTradeNomValue()
	{
		return DefinedAutoTradeNomValue;
	}
	public void setDefinedAutoTradeNomValue(double value)
	{
		DefinedAutoTradeNomValue = value;
	}
	public long getUndefinedAutoTradeNum()
	{
		return UndefinedAutoTradeNum;
	}
	public void setUndefinedAutoTradeNum(long value)
	{
		UndefinedAutoTradeNum = value;
	}
	public double getUndefinedAutoTradeNomValue()
	{
		return UndefinedAutoTradeNomValue;
	}
	public void setUndefinedAutoTradeNomValue(double value)
	{
		UndefinedAutoTradeNomValue = value;
	}
	public long getDefinedManualTradeNum()
	{
		return DefinedManualTradeNum;
	}
	public void setDefinedManualTradeNum(long value)
	{
		DefinedManualTradeNum = value;
	}
	public double getDefinedManualTradeNomValue()
	{
		return DefinedManualTradeNomValue;
	}
	public void setDefinedManualTradeNomValue(double value)
	{
		DefinedManualTradeNomValue = value;
	}
	public long getUndefinedManualTradeNum()
	{
		return UndefinedManualTradeNum;
	}
	public void setUndefinedManualTradeNum(long value)
	{
		UndefinedManualTradeNum = value;
	}
	public double getUndefinedManualTradeNomValue()
	{
		return UndefinedManualTradeNomValue;
	}
	public void setUndefinedManualTradeNomValue(double value)
	{
		UndefinedManualTradeNomValue = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		DefinedAutoTradeNum = (long)byteBuffer.readInt();
		DefinedAutoTradeNomValue = byteBuffer.readDouble();
		UndefinedAutoTradeNum = (long)byteBuffer.readInt();
		UndefinedAutoTradeNomValue = byteBuffer.readDouble();
		DefinedManualTradeNum = (long)byteBuffer.readInt();
		DefinedManualTradeNomValue = byteBuffer.readDouble();
		UndefinedManualTradeNum = (long)byteBuffer.readInt();
		UndefinedManualTradeNomValue = byteBuffer.readDouble();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(DefinedAutoTradeNum & 0xFFFFFFFFL));
		byteBuffer.writeDouble(DefinedAutoTradeNomValue);
		byteBuffer.writeInt((int)(UndefinedAutoTradeNum & 0xFFFFFFFFL));
		byteBuffer.writeDouble(UndefinedAutoTradeNomValue);
		byteBuffer.writeInt((int)(DefinedManualTradeNum & 0xFFFFFFFFL));
		byteBuffer.writeDouble(DefinedManualTradeNomValue);
		byteBuffer.writeInt((int)(UndefinedManualTradeNum & 0xFFFFFFFFL));
		byteBuffer.writeDouble(UndefinedManualTradeNomValue);

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
		stringBuilder.append("DF_SUBTOT_SETTL_INFO::");
		stringBuilder.append("DefinedAutoTradeNum(").append(DefinedAutoTradeNum).append(")");
		stringBuilder.append("DefinedAutoTradeNomValue(").append(DefinedAutoTradeNomValue).append(")");
		stringBuilder.append("UndefinedAutoTradeNum(").append(UndefinedAutoTradeNum).append(")");
		stringBuilder.append("UndefinedAutoTradeNomValue(").append(UndefinedAutoTradeNomValue).append(")");
		stringBuilder.append("DefinedManualTradeNum(").append(DefinedManualTradeNum).append(")");
		stringBuilder.append("DefinedManualTradeNomValue(").append(DefinedManualTradeNomValue).append(")");
		stringBuilder.append("UndefinedManualTradeNum(").append(UndefinedManualTradeNum).append(")");
		stringBuilder.append("UndefinedManualTradeNomValue(").append(UndefinedManualTradeNomValue).append(")");
		return stringBuilder.toString();
	}
}
