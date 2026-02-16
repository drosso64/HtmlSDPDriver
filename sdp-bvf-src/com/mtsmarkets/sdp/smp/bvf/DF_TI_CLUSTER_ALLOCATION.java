package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class DF_TI_CLUSTER_ALLOCATION extends SMPMessage
{
	public static final long CLASS_ID = 170010;

	private long InstrumentClassId = 0;
	private long ClusterId = 0;

	public DF_TI_CLUSTER_ALLOCATION()
	{
	}

	public long getInstrumentClassId()
	{
		return InstrumentClassId;
	}
	public void setInstrumentClassId(long value)
	{
		InstrumentClassId = value;
	}
	public long getClusterId()
	{
		return ClusterId;
	}
	public void setClusterId(long value)
	{
		ClusterId = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		InstrumentClassId = (long)byteBuffer.readInt();
		ClusterId = (long)byteBuffer.readInt();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(InstrumentClassId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(ClusterId & 0xFFFFFFFFL));

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
		stringBuilder.append("DF_TI_CLUSTER_ALLOCATION::");
		stringBuilder.append("InstrumentClassId(").append(InstrumentClassId).append(")");
		stringBuilder.append("ClusterId(").append(ClusterId).append(")");
		return stringBuilder.toString();
	}
}
