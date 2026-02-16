package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_TRADE_REGISTRATION_LEG_MEMBER_INFO extends SMPMessage
{
	public static final long CLASS_ID = 410007;

	private TI_ERROR_Enum ErrorCode = TI_ERROR_Enum.TI_ERROR_NoError;
	private BV_SHORT_SELLING_INDICATOR_Enum ShortSellingIndicator = BV_SHORT_SELLING_INDICATOR_Enum.BV_SHORT_SELLING_INDICATOR_None;
	private BV_ALGO_INFO AlgoInfo = new BV_ALGO_INFO();
	private BV_CLIENT_IDENTIFICATION_INFO ClientIdentificationInfo = new BV_CLIENT_IDENTIFICATION_INFO();

	public BV_TRADE_REGISTRATION_LEG_MEMBER_INFO()
	{
	}

	public TI_ERROR_Enum getErrorCode()
	{
		return ErrorCode;
	}
	public void setErrorCode(TI_ERROR_Enum value)
	{
		ErrorCode = value;
	}
	public BV_SHORT_SELLING_INDICATOR_Enum getShortSellingIndicator()
	{
		return ShortSellingIndicator;
	}
	public void setShortSellingIndicator(BV_SHORT_SELLING_INDICATOR_Enum value)
	{
		ShortSellingIndicator = value;
	}
	public BV_ALGO_INFO getAlgoInfo()
	{
		return AlgoInfo;
	}
	public void setAlgoInfo(BV_ALGO_INFO value)
	{
		AlgoInfo = value;
	}
	public BV_CLIENT_IDENTIFICATION_INFO getClientIdentificationInfo()
	{
		return ClientIdentificationInfo;
	}
	public void setClientIdentificationInfo(BV_CLIENT_IDENTIFICATION_INFO value)
	{
		ClientIdentificationInfo = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		ErrorCode = ErrorCode.getEnum(byteBuffer.readInt());
		ShortSellingIndicator = ShortSellingIndicator.getEnum(byteBuffer.readInt());
		AlgoInfo.readXDR(byteBuffer);
		ClientIdentificationInfo.readXDR(byteBuffer);
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt(ErrorCode.getValue());
		byteBuffer.writeInt(ShortSellingIndicator.getValue());
		AlgoInfo.writeXDR(byteBuffer);
		ClientIdentificationInfo.writeXDR(byteBuffer);

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
		stringBuilder.append("BV_TRADE_REGISTRATION_LEG_MEMBER_INFO::");
		stringBuilder.append("ErrorCode(").append(ErrorCode).append(")");
		stringBuilder.append("ShortSellingIndicator(").append(ShortSellingIndicator).append(")");
		stringBuilder.append("AlgoInfo(").append(AlgoInfo.toString()).append(")");
		stringBuilder.append("ClientIdentificationInfo(").append(ClientIdentificationInfo.toString()).append(")");
		return stringBuilder.toString();
	}
}
