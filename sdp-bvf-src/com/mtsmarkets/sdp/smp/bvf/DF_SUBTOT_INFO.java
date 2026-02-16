package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class DF_SUBTOT_INFO extends SMPMessage
{
	public static final long CLASS_ID = 107902;

	private long ClickAndTradeNum = 0;
	private double ClickAndTradeNomValue = 0;
	private long RFQNum = 0;
	private double RFQNomValue = 0;
	private long RFCQNum = 0;
	private double RFCQNomValue = 0;
	private long OTCNum = 0;
	private double OTCNomValue = 0;

	public DF_SUBTOT_INFO()
	{
	}

	public long getClickAndTradeNum()
	{
		return ClickAndTradeNum;
	}
	public void setClickAndTradeNum(long value)
	{
		ClickAndTradeNum = value;
	}
	public double getClickAndTradeNomValue()
	{
		return ClickAndTradeNomValue;
	}
	public void setClickAndTradeNomValue(double value)
	{
		ClickAndTradeNomValue = value;
	}
	public long getRFQNum()
	{
		return RFQNum;
	}
	public void setRFQNum(long value)
	{
		RFQNum = value;
	}
	public double getRFQNomValue()
	{
		return RFQNomValue;
	}
	public void setRFQNomValue(double value)
	{
		RFQNomValue = value;
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
	public long getOTCNum()
	{
		return OTCNum;
	}
	public void setOTCNum(long value)
	{
		OTCNum = value;
	}
	public double getOTCNomValue()
	{
		return OTCNomValue;
	}
	public void setOTCNomValue(double value)
	{
		OTCNomValue = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		ClickAndTradeNum = (long)byteBuffer.readInt();
		ClickAndTradeNomValue = byteBuffer.readDouble();
		RFQNum = (long)byteBuffer.readInt();
		RFQNomValue = byteBuffer.readDouble();
		RFCQNum = (long)byteBuffer.readInt();
		RFCQNomValue = byteBuffer.readDouble();
		OTCNum = (long)byteBuffer.readInt();
		OTCNomValue = byteBuffer.readDouble();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(ClickAndTradeNum & 0xFFFFFFFFL));
		byteBuffer.writeDouble(ClickAndTradeNomValue);
		byteBuffer.writeInt((int)(RFQNum & 0xFFFFFFFFL));
		byteBuffer.writeDouble(RFQNomValue);
		byteBuffer.writeInt((int)(RFCQNum & 0xFFFFFFFFL));
		byteBuffer.writeDouble(RFCQNomValue);
		byteBuffer.writeInt((int)(OTCNum & 0xFFFFFFFFL));
		byteBuffer.writeDouble(OTCNomValue);

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
		stringBuilder.append("DF_SUBTOT_INFO::");
		stringBuilder.append("ClickAndTradeNum(").append(ClickAndTradeNum).append(")");
		stringBuilder.append("ClickAndTradeNomValue(").append(ClickAndTradeNomValue).append(")");
		stringBuilder.append("RFQNum(").append(RFQNum).append(")");
		stringBuilder.append("RFQNomValue(").append(RFQNomValue).append(")");
		stringBuilder.append("RFCQNum(").append(RFCQNum).append(")");
		stringBuilder.append("RFCQNomValue(").append(RFCQNomValue).append(")");
		stringBuilder.append("OTCNum(").append(OTCNum).append(")");
		stringBuilder.append("OTCNomValue(").append(OTCNomValue).append(")");
		return stringBuilder.toString();
	}
}
