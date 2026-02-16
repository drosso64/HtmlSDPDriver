package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_SERVICE_PROVIDER extends SMPMessage
{
	public static final long CLASS_ID = 100001;

	private long ServiceProviderId = 0;
	private String ServiceProviderCode = "";
	private String ServiceProviderDesc = "";
	private TI_ENVIRONMENT_Enum EnvironmentId = TI_ENVIRONMENT_Enum.TI_ENVIRONMENT_LiveMarket;
	private TI_UTC_Enum UTC = TI_UTC_Enum.TI_UTC_None;
	private TI_FLAG_Enum DSTFg = TI_FLAG_Enum.TI_FLAG_No;

	public TI_SERVICE_PROVIDER()
	{
	}

	public long getServiceProviderId()
	{
		return ServiceProviderId;
	}
	public void setServiceProviderId(long value)
	{
		ServiceProviderId = value;
	}
	public String getServiceProviderCode()
	{
		return ServiceProviderCode;
	}
	public void setServiceProviderCode(String value)
	{
		ServiceProviderCode = value;
	}
	public String getServiceProviderDesc()
	{
		return ServiceProviderDesc;
	}
	public void setServiceProviderDesc(String value)
	{
		ServiceProviderDesc = value;
	}
	public TI_ENVIRONMENT_Enum getEnvironmentId()
	{
		return EnvironmentId;
	}
	public void setEnvironmentId(TI_ENVIRONMENT_Enum value)
	{
		EnvironmentId = value;
	}
	public TI_UTC_Enum getUTC()
	{
		return UTC;
	}
	public void setUTC(TI_UTC_Enum value)
	{
		UTC = value;
	}
	public TI_FLAG_Enum getDSTFg()
	{
		return DSTFg;
	}
	public void setDSTFg(TI_FLAG_Enum value)
	{
		DSTFg = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		ServiceProviderId = (long)byteBuffer.readInt();
		ServiceProviderCode = byteBuffer.readString();
		ServiceProviderDesc = byteBuffer.readString();
		EnvironmentId = EnvironmentId.getEnum(byteBuffer.readInt());
		UTC = UTC.getEnum(byteBuffer.readInt());
		DSTFg = DSTFg.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(ServiceProviderId & 0xFFFFFFFFL));
		byteBuffer.writeString(ServiceProviderCode);
		byteBuffer.writeString(ServiceProviderDesc);
		byteBuffer.writeInt(EnvironmentId.getValue());
		byteBuffer.writeInt(UTC.getValue());
		byteBuffer.writeInt(DSTFg.getValue());

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
		stringBuilder.append("TI_SERVICE_PROVIDER::");
		stringBuilder.append("ServiceProviderId(").append(ServiceProviderId).append(")");
		stringBuilder.append("ServiceProviderCode(").append(ServiceProviderCode).append(")");
		stringBuilder.append("ServiceProviderDesc(").append(ServiceProviderDesc).append(")");
		stringBuilder.append("EnvironmentId(").append(EnvironmentId).append(")");
		stringBuilder.append("UTC(").append(UTC).append(")");
		stringBuilder.append("DSTFg(").append(DSTFg).append(")");
		return stringBuilder.toString();
	}
}
