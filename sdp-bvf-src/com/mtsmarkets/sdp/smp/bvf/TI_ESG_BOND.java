package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_ESG_BOND extends SMPMessage
{
	public static final long CLASS_ID = 100239;

	private long InstrumentId = 0;
	private String ESGBondType = "";
	private String ESGComplianceCodes = "";

	public TI_ESG_BOND()
	{
	}

	public long getInstrumentId()
	{
		return InstrumentId;
	}
	public void setInstrumentId(long value)
	{
		InstrumentId = value;
	}
	public String getESGBondType()
	{
		return ESGBondType;
	}
	public void setESGBondType(String value)
	{
		ESGBondType = value;
	}
	public String getESGComplianceCodes()
	{
		return ESGComplianceCodes;
	}
	public void setESGComplianceCodes(String value)
	{
		ESGComplianceCodes = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		InstrumentId = (long)byteBuffer.readInt();
		ESGBondType = byteBuffer.readString();
		ESGComplianceCodes = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(InstrumentId & 0xFFFFFFFFL));
		byteBuffer.writeString(ESGBondType);
		byteBuffer.writeString(ESGComplianceCodes);

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
		stringBuilder.append("TI_ESG_BOND::");
		stringBuilder.append("InstrumentId(").append(InstrumentId).append(")");
		stringBuilder.append("ESGBondType(").append(ESGBondType).append(")");
		stringBuilder.append("ESGComplianceCodes(").append(ESGComplianceCodes).append(")");
		return stringBuilder.toString();
	}
}
