package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_BOND_TYPOLOGY_YIELD_TYPE extends SMPMessage
{
	public static final long CLASS_ID = 100081;

	private String BondTypologyCode = "";
	private long YieldTypeId = 0;
	private short SortNumber = 0;

	public TI_BOND_TYPOLOGY_YIELD_TYPE()
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
	public long getYieldTypeId()
	{
		return YieldTypeId;
	}
	public void setYieldTypeId(long value)
	{
		YieldTypeId = value;
	}
	public short getSortNumber()
	{
		return SortNumber;
	}
	public void setSortNumber(short value)
	{
		SortNumber = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		BondTypologyCode = byteBuffer.readString();
		YieldTypeId = (long)byteBuffer.readInt();
		SortNumber = (short)byteBuffer.readInt();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeString(BondTypologyCode);
		byteBuffer.writeInt((int)(YieldTypeId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SortNumber & 0xFFFFL));

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
		stringBuilder.append("TI_BOND_TYPOLOGY_YIELD_TYPE::");
		stringBuilder.append("BondTypologyCode(").append(BondTypologyCode).append(")");
		stringBuilder.append("YieldTypeId(").append(YieldTypeId).append(")");
		stringBuilder.append("SortNumber(").append(SortNumber).append(")");
		return stringBuilder.toString();
	}
}
