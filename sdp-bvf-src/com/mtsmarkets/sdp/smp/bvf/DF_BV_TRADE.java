package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class DF_BV_TRADE extends SMPMessage
{
	public static final long CLASS_ID = 114705;

	private TI_FLAG_Enum ExcludedFromOfficialPrice = TI_FLAG_Enum.TI_FLAG_No;
	private TI_FLAG_Enum StrikerRangeMatchingFg = TI_FLAG_Enum.TI_FLAG_No;
	private TI_SETTL_ERROR_CODE[] SettlError = new TI_SETTL_ERROR_CODE[5];
	private BV_TRADE DFTr = new BV_TRADE();
	private DF_BV_ALGO_INFO ProviderAlgoInfo = new DF_BV_ALGO_INFO();
	private DF_BV_ALGO_INFO AggressorAlgoInfo = new DF_BV_ALGO_INFO();

	public DF_BV_TRADE()
	{
		for (int i=0; i < SettlError.length; ++i)
		{
			SettlError[i] = new TI_SETTL_ERROR_CODE();
		}
	}

	public TI_FLAG_Enum getExcludedFromOfficialPrice()
	{
		return ExcludedFromOfficialPrice;
	}
	public void setExcludedFromOfficialPrice(TI_FLAG_Enum value)
	{
		ExcludedFromOfficialPrice = value;
	}
	public TI_FLAG_Enum getStrikerRangeMatchingFg()
	{
		return StrikerRangeMatchingFg;
	}
	public void setStrikerRangeMatchingFg(TI_FLAG_Enum value)
	{
		StrikerRangeMatchingFg = value;
	}
	public TI_SETTL_ERROR_CODE[] getSettlError()
	{
		return SettlError;
	}
	public void setSettlError(TI_SETTL_ERROR_CODE[] value)
	{
		SettlError = value;
	}
	public BV_TRADE getDFTr()
	{
		return DFTr;
	}
	public void setDFTr(BV_TRADE value)
	{
		DFTr = value;
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
		ExcludedFromOfficialPrice = ExcludedFromOfficialPrice.getEnum(byteBuffer.readInt());
		StrikerRangeMatchingFg = StrikerRangeMatchingFg.getEnum(byteBuffer.readInt());
		for (int i=0; i < SettlError.length; ++i)
		{
			SettlError[i].readXDR(byteBuffer);
		}
		DFTr.readXDR(byteBuffer);
		ProviderAlgoInfo.readXDR(byteBuffer);
		AggressorAlgoInfo.readXDR(byteBuffer);
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt(ExcludedFromOfficialPrice.getValue());
		byteBuffer.writeInt(StrikerRangeMatchingFg.getValue());
		for (int i=0; i < SettlError.length; ++i)
		{
			SettlError[i].writeXDR(byteBuffer);
		}
		DFTr.writeXDR(byteBuffer);
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
		stringBuilder.append("DF_BV_TRADE::");
		stringBuilder.append("ExcludedFromOfficialPrice(").append(ExcludedFromOfficialPrice).append(")");
		stringBuilder.append("StrikerRangeMatchingFg(").append(StrikerRangeMatchingFg).append(")");
		for (int i=0; i < SettlError.length; ++i)
		{
			stringBuilder.append("SettlError[").append(i).append("](").append(SettlError[i].toString()).append(")");
		}
		stringBuilder.append("DFTr(").append(DFTr.toString()).append(")");
		stringBuilder.append("ProviderAlgoInfo(").append(ProviderAlgoInfo.toString()).append(")");
		stringBuilder.append("AggressorAlgoInfo(").append(AggressorAlgoInfo.toString()).append(")");
		return stringBuilder.toString();
	}
}
