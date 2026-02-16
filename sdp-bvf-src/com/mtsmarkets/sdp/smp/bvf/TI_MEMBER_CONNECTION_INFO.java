package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_MEMBER_CONNECTION_INFO extends SMPMessage
{
	public static final long CLASS_ID = 100200;

	private long MemberId = 0;
	private long MarketId = 0;
	private long ClassId = 0;
	private TI_FLAG_Enum IsInternetTrader = TI_FLAG_Enum.TI_FLAG_No;
	private TI_FLAG_Enum IsFiltered = TI_FLAG_Enum.TI_FLAG_No;
	private long NumberOfSubscriptions = 0;

	public TI_MEMBER_CONNECTION_INFO()
	{
	}

	public long getMemberId()
	{
		return MemberId;
	}
	public void setMemberId(long value)
	{
		MemberId = value;
	}
	public long getMarketId()
	{
		return MarketId;
	}
	public void setMarketId(long value)
	{
		MarketId = value;
	}
	public long getClassId()
	{
		return ClassId;
	}
	public void setClassId(long value)
	{
		ClassId = value;
	}
	public TI_FLAG_Enum getIsInternetTrader()
	{
		return IsInternetTrader;
	}
	public void setIsInternetTrader(TI_FLAG_Enum value)
	{
		IsInternetTrader = value;
	}
	public TI_FLAG_Enum getIsFiltered()
	{
		return IsFiltered;
	}
	public void setIsFiltered(TI_FLAG_Enum value)
	{
		IsFiltered = value;
	}
	public long getNumberOfSubscriptions()
	{
		return NumberOfSubscriptions;
	}
	public void setNumberOfSubscriptions(long value)
	{
		NumberOfSubscriptions = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MemberId = (long)byteBuffer.readInt();
		MarketId = (long)byteBuffer.readInt();
		ClassId = (long)byteBuffer.readInt();
		IsInternetTrader = IsInternetTrader.getEnum(byteBuffer.readInt());
		IsFiltered = IsFiltered.getEnum(byteBuffer.readInt());
		NumberOfSubscriptions = (long)byteBuffer.readInt();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(MarketId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(ClassId & 0xFFFFFFFFL));
		byteBuffer.writeInt(IsInternetTrader.getValue());
		byteBuffer.writeInt(IsFiltered.getValue());
		byteBuffer.writeInt((int)(NumberOfSubscriptions & 0xFFFFFFFFL));

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
		stringBuilder.append("TI_MEMBER_CONNECTION_INFO::");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("MarketId(").append(MarketId).append(")");
		stringBuilder.append("ClassId(").append(ClassId).append(")");
		stringBuilder.append("IsInternetTrader(").append(IsInternetTrader).append(")");
		stringBuilder.append("IsFiltered(").append(IsFiltered).append(")");
		stringBuilder.append("NumberOfSubscriptions(").append(NumberOfSubscriptions).append(")");
		return stringBuilder.toString();
	}
}
