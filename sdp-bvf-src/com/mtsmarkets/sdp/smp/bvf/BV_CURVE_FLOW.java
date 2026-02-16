package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_CURVE_FLOW extends SMPMessage
{
	public static final long CLASS_ID = 115007;

	private long CurveID = 0;
	private String Currency = "";
	private BV_CURVE_FLOW_INFO[] CurveInfo = new BV_CURVE_FLOW_INFO[50];
	private long UpdateDate = 0;
	private long UpdateTime = 0;

	public BV_CURVE_FLOW()
	{
		for (int i=0; i < CurveInfo.length; ++i)
		{
			CurveInfo[i] = new BV_CURVE_FLOW_INFO();
		}
	}

	public long getCurveID()
	{
		return CurveID;
	}
	public void setCurveID(long value)
	{
		CurveID = value;
	}
	public String getCurrency()
	{
		return Currency;
	}
	public void setCurrency(String value)
	{
		Currency = value;
	}
	public BV_CURVE_FLOW_INFO[] getCurveInfo()
	{
		return CurveInfo;
	}
	public void setCurveInfo(BV_CURVE_FLOW_INFO[] value)
	{
		CurveInfo = value;
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
		CurveID = (long)byteBuffer.readInt();
		Currency = byteBuffer.readString();
		for (int i=0; i < CurveInfo.length; ++i)
		{
			CurveInfo[i].readXDR(byteBuffer);
		}
		UpdateDate = (long)byteBuffer.readInt();
		UpdateTime = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(CurveID & 0xFFFFFFFFL));
		byteBuffer.writeString(Currency);
		for (int i=0; i < CurveInfo.length; ++i)
		{
			CurveInfo[i].writeXDR(byteBuffer);
		}
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
		stringBuilder.append("BV_CURVE_FLOW::");
		stringBuilder.append("CurveID(").append(CurveID).append(")");
		stringBuilder.append("Currency(").append(Currency).append(")");
		for (int i=0; i < CurveInfo.length; ++i)
		{
			stringBuilder.append("CurveInfo[").append(i).append("](").append(CurveInfo[i].toString()).append(")");
		}
		stringBuilder.append("UpdateDate(").append(UpdateDate).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		return stringBuilder.toString();
	}
}
