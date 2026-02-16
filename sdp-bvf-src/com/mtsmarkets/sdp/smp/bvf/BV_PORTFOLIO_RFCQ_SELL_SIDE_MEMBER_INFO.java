package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_PORTFOLIO_RFCQ_SELL_SIDE_MEMBER_INFO extends SMPMessage
{
	public static final long CLASS_ID = 410014;

	private long ProviderId = 0;
	private BV_PORTFOLIO_RFCQ_PROVIDER_STATUS_Enum ProviderStatus = BV_PORTFOLIO_RFCQ_PROVIDER_STATUS_Enum.BV_PORTFOLIO_RFCQ_PROVIDER_STATUS_None;

	public BV_PORTFOLIO_RFCQ_SELL_SIDE_MEMBER_INFO()
	{
	}

	public long getProviderId()
	{
		return ProviderId;
	}
	public void setProviderId(long value)
	{
		ProviderId = value;
	}
	public BV_PORTFOLIO_RFCQ_PROVIDER_STATUS_Enum getProviderStatus()
	{
		return ProviderStatus;
	}
	public void setProviderStatus(BV_PORTFOLIO_RFCQ_PROVIDER_STATUS_Enum value)
	{
		ProviderStatus = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		ProviderId = (long)byteBuffer.readInt();
		ProviderStatus = ProviderStatus.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(ProviderId & 0xFFFFFFFFL));
		byteBuffer.writeInt(ProviderStatus.getValue());

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
		stringBuilder.append("BV_PORTFOLIO_RFCQ_SELL_SIDE_MEMBER_INFO::");
		stringBuilder.append("ProviderId(").append(ProviderId).append(")");
		stringBuilder.append("ProviderStatus(").append(ProviderStatus).append(")");
		return stringBuilder.toString();
	}
}
