package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class DF_BV_CLIENT_REGISTRATION extends SMPMessage
{
	public static final long CLASS_ID = 170044;

	private BV_CLIENT_REGISTRATION DF = new BV_CLIENT_REGISTRATION();

	public DF_BV_CLIENT_REGISTRATION()
	{
	}

	public BV_CLIENT_REGISTRATION getDF()
	{
		return DF;
	}
	public void setDF(BV_CLIENT_REGISTRATION value)
	{
		DF = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		DF.readXDR(byteBuffer);
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		DF.writeXDR(byteBuffer);

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
		stringBuilder.append("DF_BV_CLIENT_REGISTRATION::");
		stringBuilder.append("DF(").append(DF.toString()).append(")");
		return stringBuilder.toString();
	}
}
