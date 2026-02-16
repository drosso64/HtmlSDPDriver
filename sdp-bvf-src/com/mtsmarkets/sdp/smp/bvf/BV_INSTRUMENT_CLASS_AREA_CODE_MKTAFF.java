package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_INSTRUMENT_CLASS_AREA_CODE_MKTAFF extends SMPMessage
{
	public static final long CLASS_ID = 100223;

	private long InstrumentClassId = 0;
	private short AreaCodeId = 0;
	private short MktAffiliationId = 0;
	private String MicCode = "";

	public BV_INSTRUMENT_CLASS_AREA_CODE_MKTAFF()
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
	public short getAreaCodeId()
	{
		return AreaCodeId;
	}
	public void setAreaCodeId(short value)
	{
		AreaCodeId = value;
	}
	public short getMktAffiliationId()
	{
		return MktAffiliationId;
	}
	public void setMktAffiliationId(short value)
	{
		MktAffiliationId = value;
	}
	public String getMicCode()
	{
		return MicCode;
	}
	public void setMicCode(String value)
	{
		MicCode = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		InstrumentClassId = (long)byteBuffer.readInt();
		AreaCodeId = (short)byteBuffer.readInt();
		MktAffiliationId = (short)byteBuffer.readInt();
		MicCode = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(InstrumentClassId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(AreaCodeId & 0xFFFFL));
		byteBuffer.writeInt((int)(MktAffiliationId & 0xFFFFL));
		byteBuffer.writeString(MicCode);

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
		stringBuilder.append("BV_INSTRUMENT_CLASS_AREA_CODE_MKTAFF::");
		stringBuilder.append("InstrumentClassId(").append(InstrumentClassId).append(")");
		stringBuilder.append("AreaCodeId(").append(AreaCodeId).append(")");
		stringBuilder.append("MktAffiliationId(").append(MktAffiliationId).append(")");
		stringBuilder.append("MicCode(").append(MicCode).append(")");
		return stringBuilder.toString();
	}
}
