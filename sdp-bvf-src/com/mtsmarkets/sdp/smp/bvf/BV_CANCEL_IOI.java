package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_CANCEL_IOI extends SMPMessage
{
	public static final long CLASS_ID = 115006;

	private long IOIMgsId = 0;
	private long InstrumentId = 0;
	private long CancelDate = 0;
	private long CancelTime = 0;

	public BV_CANCEL_IOI()
	{
	}

	public long getIOIMgsId()
	{
		return IOIMgsId;
	}
	public void setIOIMgsId(long value)
	{
		IOIMgsId = value;
	}
	public long getInstrumentId()
	{
		return InstrumentId;
	}
	public void setInstrumentId(long value)
	{
		InstrumentId = value;
	}
	public long getCancelDate()
	{
		return CancelDate;
	}
	public void setCancelDate(long value)
	{
		CancelDate = value;
	}
	public long getCancelTime()
	{
		return CancelTime;
	}
	public void setCancelTime(long value)
	{
		CancelTime = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		IOIMgsId = (long)byteBuffer.readInt();
		InstrumentId = (long)byteBuffer.readInt();
		CancelDate = (long)byteBuffer.readInt();
		CancelTime = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(IOIMgsId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(InstrumentId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(CancelDate & 0xFFFFFFFFL));
		byteBuffer.writeLong(CancelTime);

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
		stringBuilder.append("BV_CANCEL_IOI::");
		stringBuilder.append("IOIMgsId(").append(IOIMgsId).append(")");
		stringBuilder.append("InstrumentId(").append(InstrumentId).append(")");
		stringBuilder.append("CancelDate(").append(CancelDate).append(")");
		stringBuilder.append("CancelTime(").append(CancelTime).append(")");
		return stringBuilder.toString();
	}
}
