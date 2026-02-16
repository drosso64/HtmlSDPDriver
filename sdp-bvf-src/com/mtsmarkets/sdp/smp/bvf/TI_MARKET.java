package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_MARKET extends SMPMessage
{
	public static final long CLASS_ID = 100003;

	private long MarketId = 0;
	private long ServiceProviderId = 0;
	private String MarketCode = "";
	private String MarketDesc = "";
	private short GeographicalAreaCode = 0;
	private String GeographicalAreaDesc = "";
	private double DeltaGMT = 0;

	public TI_MARKET()
	{
	}

	public long getMarketId()
	{
		return MarketId;
	}
	public void setMarketId(long value)
	{
		MarketId = value;
	}
	public long getServiceProviderId()
	{
		return ServiceProviderId;
	}
	public void setServiceProviderId(long value)
	{
		ServiceProviderId = value;
	}
	public String getMarketCode()
	{
		return MarketCode;
	}
	public void setMarketCode(String value)
	{
		MarketCode = value;
	}
	public String getMarketDesc()
	{
		return MarketDesc;
	}
	public void setMarketDesc(String value)
	{
		MarketDesc = value;
	}
	public short getGeographicalAreaCode()
	{
		return GeographicalAreaCode;
	}
	public void setGeographicalAreaCode(short value)
	{
		GeographicalAreaCode = value;
	}
	public String getGeographicalAreaDesc()
	{
		return GeographicalAreaDesc;
	}
	public void setGeographicalAreaDesc(String value)
	{
		GeographicalAreaDesc = value;
	}
	public double getDeltaGMT()
	{
		return DeltaGMT;
	}
	public void setDeltaGMT(double value)
	{
		DeltaGMT = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MarketId = (long)byteBuffer.readInt();
		ServiceProviderId = (long)byteBuffer.readInt();
		MarketCode = byteBuffer.readString();
		MarketDesc = byteBuffer.readString();
		GeographicalAreaCode = (short)byteBuffer.readInt();
		GeographicalAreaDesc = byteBuffer.readString();
		DeltaGMT = byteBuffer.readDouble();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MarketId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(ServiceProviderId & 0xFFFFFFFFL));
		byteBuffer.writeString(MarketCode);
		byteBuffer.writeString(MarketDesc);
		byteBuffer.writeInt((int)(GeographicalAreaCode & 0xFFFFL));
		byteBuffer.writeString(GeographicalAreaDesc);
		byteBuffer.writeDouble(DeltaGMT);

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
		stringBuilder.append("TI_MARKET::");
		stringBuilder.append("MarketId(").append(MarketId).append(")");
		stringBuilder.append("ServiceProviderId(").append(ServiceProviderId).append(")");
		stringBuilder.append("MarketCode(").append(MarketCode).append(")");
		stringBuilder.append("MarketDesc(").append(MarketDesc).append(")");
		stringBuilder.append("GeographicalAreaCode(").append(GeographicalAreaCode).append(")");
		stringBuilder.append("GeographicalAreaDesc(").append(GeographicalAreaDesc).append(")");
		stringBuilder.append("DeltaGMT(").append(DeltaGMT).append(")");
		return stringBuilder.toString();
	}
}
