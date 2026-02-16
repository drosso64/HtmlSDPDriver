package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class GOV_BV_TRADE_FUTURE extends SMPMessage
{
	public static final long CLASS_ID = 115009;

	private BV_TRADE_FUTURE_INFO Trade = new BV_TRADE_FUTURE_INFO();
	private TI_SETTL_ERROR_CODE[] SettlError = new TI_SETTL_ERROR_CODE[5];

	public GOV_BV_TRADE_FUTURE()
	{
		for (int i=0; i < SettlError.length; ++i)
		{
			SettlError[i] = new TI_SETTL_ERROR_CODE();
		}
	}

	public BV_TRADE_FUTURE_INFO getTrade()
	{
		return Trade;
	}
	public void setTrade(BV_TRADE_FUTURE_INFO value)
	{
		Trade = value;
	}
	public TI_SETTL_ERROR_CODE[] getSettlError()
	{
		return SettlError;
	}
	public void setSettlError(TI_SETTL_ERROR_CODE[] value)
	{
		SettlError = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		Trade.readXDR(byteBuffer);
		for (int i=0; i < SettlError.length; ++i)
		{
			SettlError[i].readXDR(byteBuffer);
		}
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		Trade.writeXDR(byteBuffer);
		for (int i=0; i < SettlError.length; ++i)
		{
			SettlError[i].writeXDR(byteBuffer);
		}

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
		stringBuilder.append("GOV_BV_TRADE_FUTURE::");
		stringBuilder.append("Trade(").append(Trade.toString()).append(")");
		for (int i=0; i < SettlError.length; ++i)
		{
			stringBuilder.append("SettlError[").append(i).append("](").append(SettlError[i].toString()).append(")");
		}
		return stringBuilder.toString();
	}
}
