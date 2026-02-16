package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class DF_BV_PRETRADE_LIMIT extends SMPMessage
{
	public static final long CLASS_ID = 170046;

	private BV_PRETRADE_LIMIT DF = new BV_PRETRADE_LIMIT();

	public DF_BV_PRETRADE_LIMIT()
	{
	}

	public BV_PRETRADE_LIMIT getDF()
	{
		return DF;
	}
	public void setDF(BV_PRETRADE_LIMIT value)
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
		stringBuilder.append("DF_BV_PRETRADE_LIMIT::");
		stringBuilder.append("DF(").append(DF.toString()).append(")");
		return stringBuilder.toString();
	}
}
