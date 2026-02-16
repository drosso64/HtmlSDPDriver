package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_CLIENT_IDENTIFICATION_INFO extends SMPMessage
{
	public static final long CLASS_ID = 114987;

	private String ClientId = "";
	private BV_CLIENT_IDENTIFICATION_TYPE_Enum ClientIdentificationType = BV_CLIENT_IDENTIFICATION_TYPE_Enum.BV_CLIENT_IDENTIFICATION_TYPE_None;
	private long TradingCapacityId = 0;

	public BV_CLIENT_IDENTIFICATION_INFO()
	{
	}

	public String getClientId()
	{
		return ClientId;
	}
	public void setClientId(String value)
	{
		ClientId = value;
	}
	public BV_CLIENT_IDENTIFICATION_TYPE_Enum getClientIdentificationType()
	{
		return ClientIdentificationType;
	}
	public void setClientIdentificationType(BV_CLIENT_IDENTIFICATION_TYPE_Enum value)
	{
		ClientIdentificationType = value;
	}
	public long getTradingCapacityId()
	{
		return TradingCapacityId;
	}
	public void setTradingCapacityId(long value)
	{
		TradingCapacityId = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		ClientId = byteBuffer.readString();
		ClientIdentificationType = ClientIdentificationType.getEnum(byteBuffer.readInt());
		TradingCapacityId = (long)byteBuffer.readInt();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeString(ClientId);
		byteBuffer.writeInt(ClientIdentificationType.getValue());
		byteBuffer.writeInt((int)(TradingCapacityId & 0xFFFFFFFFL));

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
		stringBuilder.append("BV_CLIENT_IDENTIFICATION_INFO::");
		stringBuilder.append("ClientId(").append(ClientId).append(")");
		stringBuilder.append("ClientIdentificationType(").append(ClientIdentificationType).append(")");
		stringBuilder.append("TradingCapacityId(").append(TradingCapacityId).append(")");
		return stringBuilder.toString();
	}
}
