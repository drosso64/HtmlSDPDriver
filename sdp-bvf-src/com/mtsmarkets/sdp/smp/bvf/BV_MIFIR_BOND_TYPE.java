package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_MIFIR_BOND_TYPE extends SMPMessage
{
	public static final long CLASS_ID = 400025;

	private long MiFIRBondTypeId = 0;
	private String MiFIRBondTypeCode = "";
	private String MiFIRBondTypeDesc = "";

	public BV_MIFIR_BOND_TYPE()
	{
	}

	public long getMiFIRBondTypeId()
	{
		return MiFIRBondTypeId;
	}
	public void setMiFIRBondTypeId(long value)
	{
		MiFIRBondTypeId = value;
	}
	public String getMiFIRBondTypeCode()
	{
		return MiFIRBondTypeCode;
	}
	public void setMiFIRBondTypeCode(String value)
	{
		MiFIRBondTypeCode = value;
	}
	public String getMiFIRBondTypeDesc()
	{
		return MiFIRBondTypeDesc;
	}
	public void setMiFIRBondTypeDesc(String value)
	{
		MiFIRBondTypeDesc = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MiFIRBondTypeId = (long)byteBuffer.readInt();
		MiFIRBondTypeCode = byteBuffer.readString();
		MiFIRBondTypeDesc = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MiFIRBondTypeId & 0xFFFFFFFFL));
		byteBuffer.writeString(MiFIRBondTypeCode);
		byteBuffer.writeString(MiFIRBondTypeDesc);

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
		stringBuilder.append("BV_MIFIR_BOND_TYPE::");
		stringBuilder.append("MiFIRBondTypeId(").append(MiFIRBondTypeId).append(")");
		stringBuilder.append("MiFIRBondTypeCode(").append(MiFIRBondTypeCode).append(")");
		stringBuilder.append("MiFIRBondTypeDesc(").append(MiFIRBondTypeDesc).append(")");
		return stringBuilder.toString();
	}
}
