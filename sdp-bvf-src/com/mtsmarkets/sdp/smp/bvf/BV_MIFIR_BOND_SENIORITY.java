package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_MIFIR_BOND_SENIORITY extends SMPMessage
{
	public static final long CLASS_ID = 400026;

	private long MiFIRBondSeniorityId = 0;
	private String MiFIRBondSeniorityCode = "";
	private String MiFIRBondSeniorityDesc = "";

	public BV_MIFIR_BOND_SENIORITY()
	{
	}

	public long getMiFIRBondSeniorityId()
	{
		return MiFIRBondSeniorityId;
	}
	public void setMiFIRBondSeniorityId(long value)
	{
		MiFIRBondSeniorityId = value;
	}
	public String getMiFIRBondSeniorityCode()
	{
		return MiFIRBondSeniorityCode;
	}
	public void setMiFIRBondSeniorityCode(String value)
	{
		MiFIRBondSeniorityCode = value;
	}
	public String getMiFIRBondSeniorityDesc()
	{
		return MiFIRBondSeniorityDesc;
	}
	public void setMiFIRBondSeniorityDesc(String value)
	{
		MiFIRBondSeniorityDesc = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MiFIRBondSeniorityId = (long)byteBuffer.readInt();
		MiFIRBondSeniorityCode = byteBuffer.readString();
		MiFIRBondSeniorityDesc = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MiFIRBondSeniorityId & 0xFFFFFFFFL));
		byteBuffer.writeString(MiFIRBondSeniorityCode);
		byteBuffer.writeString(MiFIRBondSeniorityDesc);

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
		stringBuilder.append("BV_MIFIR_BOND_SENIORITY::");
		stringBuilder.append("MiFIRBondSeniorityId(").append(MiFIRBondSeniorityId).append(")");
		stringBuilder.append("MiFIRBondSeniorityCode(").append(MiFIRBondSeniorityCode).append(")");
		stringBuilder.append("MiFIRBondSeniorityDesc(").append(MiFIRBondSeniorityDesc).append(")");
		return stringBuilder.toString();
	}
}
