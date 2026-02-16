package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class DF_BV_IOI extends SMPMessage
{
	public static final long CLASS_ID = 170026;

	private BV_IOI DFIOI = new BV_IOI();

	public DF_BV_IOI()
	{
	}

	public BV_IOI getDFIOI()
	{
		return DFIOI;
	}
	public void setDFIOI(BV_IOI value)
	{
		DFIOI = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		DFIOI.readXDR(byteBuffer);
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		DFIOI.writeXDR(byteBuffer);

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
		stringBuilder.append("DF_BV_IOI::");
		stringBuilder.append("DFIOI(").append(DFIOI.toString()).append(")");
		return stringBuilder.toString();
	}
}
