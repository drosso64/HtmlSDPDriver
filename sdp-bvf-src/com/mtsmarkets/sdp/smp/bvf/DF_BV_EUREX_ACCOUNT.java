package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class DF_BV_EUREX_ACCOUNT extends SMPMessage
{
	public static final long CLASS_ID = 170052;

	private GOV_BV_EUREX_ACCOUNT DFAccountInfo = new GOV_BV_EUREX_ACCOUNT();

	public DF_BV_EUREX_ACCOUNT()
	{
	}

	public GOV_BV_EUREX_ACCOUNT getDFAccountInfo()
	{
		return DFAccountInfo;
	}
	public void setDFAccountInfo(GOV_BV_EUREX_ACCOUNT value)
	{
		DFAccountInfo = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		DFAccountInfo.readXDR(byteBuffer);
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		DFAccountInfo.writeXDR(byteBuffer);

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
		stringBuilder.append("DF_BV_EUREX_ACCOUNT::");
		stringBuilder.append("DFAccountInfo(").append(DFAccountInfo.toString()).append(")");
		return stringBuilder.toString();
	}
}
