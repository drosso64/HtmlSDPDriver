package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class DF_TI_TRADING_CAPS extends SMPMessage
{
	public static final long CLASS_ID = 170018;

	private TI_LOG_TRADING_CAPS DFTradingCaps = new TI_LOG_TRADING_CAPS();

	public DF_TI_TRADING_CAPS()
	{
	}

	public TI_LOG_TRADING_CAPS getDFTradingCaps()
	{
		return DFTradingCaps;
	}
	public void setDFTradingCaps(TI_LOG_TRADING_CAPS value)
	{
		DFTradingCaps = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		DFTradingCaps.readXDR(byteBuffer);
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		DFTradingCaps.writeXDR(byteBuffer);

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
		stringBuilder.append("DF_TI_TRADING_CAPS::");
		stringBuilder.append("DFTradingCaps(").append(DFTradingCaps.toString()).append(")");
		return stringBuilder.toString();
	}
}
