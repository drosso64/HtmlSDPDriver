package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_INSTRUMENT_CLASS extends SMPMessage
{
	public static final long CLASS_ID = 100015;

	private long InstrumentClassId = 0;
	private String InstrumentClassCode = "";
	private String InstrumentClassDesc = "";

	public TI_INSTRUMENT_CLASS()
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
	public String getInstrumentClassCode()
	{
		return InstrumentClassCode;
	}
	public void setInstrumentClassCode(String value)
	{
		InstrumentClassCode = value;
	}
	public String getInstrumentClassDesc()
	{
		return InstrumentClassDesc;
	}
	public void setInstrumentClassDesc(String value)
	{
		InstrumentClassDesc = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		InstrumentClassId = (long)byteBuffer.readInt();
		InstrumentClassCode = byteBuffer.readString();
		InstrumentClassDesc = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(InstrumentClassId & 0xFFFFFFFFL));
		byteBuffer.writeString(InstrumentClassCode);
		byteBuffer.writeString(InstrumentClassDesc);

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
		stringBuilder.append("TI_INSTRUMENT_CLASS::");
		stringBuilder.append("InstrumentClassId(").append(InstrumentClassId).append(")");
		stringBuilder.append("InstrumentClassCode(").append(InstrumentClassCode).append(")");
		stringBuilder.append("InstrumentClassDesc(").append(InstrumentClassDesc).append(")");
		return stringBuilder.toString();
	}
}
