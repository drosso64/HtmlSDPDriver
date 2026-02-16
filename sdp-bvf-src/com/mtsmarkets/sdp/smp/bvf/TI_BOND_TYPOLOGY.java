package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_BOND_TYPOLOGY extends SMPMessage
{
	public static final long CLASS_ID = 100080;

	private String BondTypologyCode = "";
	private String Description = "";

	public TI_BOND_TYPOLOGY()
	{
	}

	public String getBondTypologyCode()
	{
		return BondTypologyCode;
	}
	public void setBondTypologyCode(String value)
	{
		BondTypologyCode = value;
	}
	public String getDescription()
	{
		return Description;
	}
	public void setDescription(String value)
	{
		Description = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		BondTypologyCode = byteBuffer.readString();
		Description = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeString(BondTypologyCode);
		byteBuffer.writeString(Description);

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
		stringBuilder.append("TI_BOND_TYPOLOGY::");
		stringBuilder.append("BondTypologyCode(").append(BondTypologyCode).append(")");
		stringBuilder.append("Description(").append(Description).append(")");
		return stringBuilder.toString();
	}
}
