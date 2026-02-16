package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class DF_BV_AUTO_EXECUTION_CRITERIA extends SMPMessage
{
	public static final long CLASS_ID = 170042;

	private BV_AUTO_EXECUTION_CRITERIA DF = new BV_AUTO_EXECUTION_CRITERIA();

	public DF_BV_AUTO_EXECUTION_CRITERIA()
	{
	}

	public BV_AUTO_EXECUTION_CRITERIA getDF()
	{
		return DF;
	}
	public void setDF(BV_AUTO_EXECUTION_CRITERIA value)
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
		stringBuilder.append("DF_BV_AUTO_EXECUTION_CRITERIA::");
		stringBuilder.append("DF(").append(DF.toString()).append(")");
		return stringBuilder.toString();
	}
}
