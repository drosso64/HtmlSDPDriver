package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class DF_TI_INSTRUMENT_CLASS extends SMPMessage
{
	public static final long CLASS_ID = 170038;

	private TI_INSTRUMENT_CLASS DF = new TI_INSTRUMENT_CLASS();
	private long UpdateDate = 0;
	private long UpdateTime = 0;

	public DF_TI_INSTRUMENT_CLASS()
	{
	}

	public TI_INSTRUMENT_CLASS getDF()
	{
		return DF;
	}
	public void setDF(TI_INSTRUMENT_CLASS value)
	{
		DF = value;
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
		DF.readXDR(byteBuffer);
		UpdateDate = (long)byteBuffer.readInt();
		UpdateTime = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		DF.writeXDR(byteBuffer);
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
		stringBuilder.append("DF_TI_INSTRUMENT_CLASS::");
		stringBuilder.append("DF(").append(DF.toString()).append(")");
		stringBuilder.append("UpdateDate(").append(UpdateDate).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		return stringBuilder.toString();
	}
}
