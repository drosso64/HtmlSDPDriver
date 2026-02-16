package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class GOV_BV_TRADE extends SMPMessage
{
	public static final long CLASS_ID = 114803;

	private TI_FLAG_Enum ExcludedFromOfficialPrice = TI_FLAG_Enum.TI_FLAG_No;
	private BV_TRADE_INFO Trade = new BV_TRADE_INFO();
	private TI_SETTL_ERROR_CODE[] SettlError = new TI_SETTL_ERROR_CODE[5];

	public GOV_BV_TRADE()
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
	public BV_TRADE_INFO getTrade()
	{
		return Trade;
	}
	public void setTrade(BV_TRADE_INFO value)
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
		ExcludedFromOfficialPrice = ExcludedFromOfficialPrice.getEnum(byteBuffer.readInt());
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

		byteBuffer.writeInt(ExcludedFromOfficialPrice.getValue());
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
		stringBuilder.append("GOV_BV_TRADE::");
		stringBuilder.append("ExcludedFromOfficialPrice(").append(ExcludedFromOfficialPrice).append(")");
		stringBuilder.append("Trade(").append(Trade.toString()).append(")");
		for (int i=0; i < SettlError.length; ++i)
		{
			stringBuilder.append("SettlError[").append(i).append("](").append(SettlError[i].toString()).append(")");
		}
		return stringBuilder.toString();
	}
}
