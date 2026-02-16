package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_LINKER_NOMINAL_BOND extends SMPMessage
{
	public static final long CLASS_ID = 400042;

	private long LinkerInstrumentId = 0;
	private long NominalInstrumentId = 0;

	public BV_LINKER_NOMINAL_BOND()
	{
	}

	public long getLinkerInstrumentId()
	{
		return LinkerInstrumentId;
	}
	public void setLinkerInstrumentId(long value)
	{
		LinkerInstrumentId = value;
	}
	public long getNominalInstrumentId()
	{
		return NominalInstrumentId;
	}
	public void setNominalInstrumentId(long value)
	{
		NominalInstrumentId = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		LinkerInstrumentId = (long)byteBuffer.readInt();
		NominalInstrumentId = (long)byteBuffer.readInt();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(LinkerInstrumentId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(NominalInstrumentId & 0xFFFFFFFFL));

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
		stringBuilder.append("BV_LINKER_NOMINAL_BOND::");
		stringBuilder.append("LinkerInstrumentId(").append(LinkerInstrumentId).append(")");
		stringBuilder.append("NominalInstrumentId(").append(NominalInstrumentId).append(")");
		return stringBuilder.toString();
	}
}
