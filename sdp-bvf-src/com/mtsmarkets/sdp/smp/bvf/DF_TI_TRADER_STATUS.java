package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class DF_TI_TRADER_STATUS extends SMPMessage
{
	public static final long CLASS_ID = 170001;

	private TI_TRADER_STATUS DFTraderStatus = new TI_TRADER_STATUS();
	private long Signature = 0;
	private long Version = 0;
	private TI_NETWORK_TYPE_Enum NetworkType = TI_NETWORK_TYPE_Enum.TI_NETWORK_TYPE_Undefined;

	public DF_TI_TRADER_STATUS()
	{
	}

	public TI_TRADER_STATUS getDFTraderStatus()
	{
		return DFTraderStatus;
	}
	public void setDFTraderStatus(TI_TRADER_STATUS value)
	{
		DFTraderStatus = value;
	}
	public long getSignature()
	{
		return Signature;
	}
	public void setSignature(long value)
	{
		Signature = value;
	}
	public long getVersion()
	{
		return Version;
	}
	public void setVersion(long value)
	{
		Version = value;
	}
	public TI_NETWORK_TYPE_Enum getNetworkType()
	{
		return NetworkType;
	}
	public void setNetworkType(TI_NETWORK_TYPE_Enum value)
	{
		NetworkType = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		DFTraderStatus.readXDR(byteBuffer);
		Signature = (long)byteBuffer.readInt();
		Version = (long)byteBuffer.readInt();
		NetworkType = NetworkType.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		DFTraderStatus.writeXDR(byteBuffer);
		byteBuffer.writeInt((int)(Signature & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(Version & 0xFFFFFFFFL));
		byteBuffer.writeInt(NetworkType.getValue());

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
		stringBuilder.append("DF_TI_TRADER_STATUS::");
		stringBuilder.append("DFTraderStatus(").append(DFTraderStatus.toString()).append(")");
		stringBuilder.append("Signature(").append(Signature).append(")");
		stringBuilder.append("Version(").append(Version).append(")");
		stringBuilder.append("NetworkType(").append(NetworkType).append(")");
		return stringBuilder.toString();
	}
}
