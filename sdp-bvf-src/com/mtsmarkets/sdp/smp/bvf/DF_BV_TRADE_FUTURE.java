package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class DF_BV_TRADE_FUTURE extends SMPMessage
{
	public static final long CLASS_ID = 170051;

	private BV_TRADE_FUTURE DFTr = new BV_TRADE_FUTURE();
	private TI_SETTL_ERROR_CODE[] SettlError = new TI_SETTL_ERROR_CODE[5];
	private DF_BV_ALGO_INFO ProviderAlgoInfo = new DF_BV_ALGO_INFO();
	private DF_BV_ALGO_INFO AggressorAlgoInfo = new DF_BV_ALGO_INFO();

	public DF_BV_TRADE_FUTURE()
	{
		for (int i=0; i < SettlError.length; ++i)
		{
			SettlError[i] = new TI_SETTL_ERROR_CODE();
		}
	}

	public BV_TRADE_FUTURE getDFTr()
	{
		return DFTr;
	}
	public void setDFTr(BV_TRADE_FUTURE value)
	{
		DFTr = value;
	}
	public TI_SETTL_ERROR_CODE[] getSettlError()
	{
		return SettlError;
	}
	public void setSettlError(TI_SETTL_ERROR_CODE[] value)
	{
		SettlError = value;
	}
	public DF_BV_ALGO_INFO getProviderAlgoInfo()
	{
		return ProviderAlgoInfo;
	}
	public void setProviderAlgoInfo(DF_BV_ALGO_INFO value)
	{
		ProviderAlgoInfo = value;
	}
	public DF_BV_ALGO_INFO getAggressorAlgoInfo()
	{
		return AggressorAlgoInfo;
	}
	public void setAggressorAlgoInfo(DF_BV_ALGO_INFO value)
	{
		AggressorAlgoInfo = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		DFTr.readXDR(byteBuffer);
		for (int i=0; i < SettlError.length; ++i)
		{
			SettlError[i].readXDR(byteBuffer);
		}
		ProviderAlgoInfo.readXDR(byteBuffer);
		AggressorAlgoInfo.readXDR(byteBuffer);
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		DFTr.writeXDR(byteBuffer);
		for (int i=0; i < SettlError.length; ++i)
		{
			SettlError[i].writeXDR(byteBuffer);
		}
		ProviderAlgoInfo.writeXDR(byteBuffer);
		AggressorAlgoInfo.writeXDR(byteBuffer);

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
		stringBuilder.append("DF_BV_TRADE_FUTURE::");
		stringBuilder.append("DFTr(").append(DFTr.toString()).append(")");
		for (int i=0; i < SettlError.length; ++i)
		{
			stringBuilder.append("SettlError[").append(i).append("](").append(SettlError[i].toString()).append(")");
		}
		stringBuilder.append("ProviderAlgoInfo(").append(ProviderAlgoInfo.toString()).append(")");
		stringBuilder.append("AggressorAlgoInfo(").append(AggressorAlgoInfo.toString()).append(")");
		return stringBuilder.toString();
	}
}
