package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_MARKET_STATUS extends SMPMessage
{
	public static final long CLASS_ID = 100033;

	private long MarketId = 0;
	private long MarketDate = 0;
	private TI_SUSP_STATUS_Enum MarketStatus = TI_SUSP_STATUS_Enum.TI_SUSP_STATUS_Active;
	private long UpdateDate = 0;
	private long UpdateTime = 0;

	public TI_MARKET_STATUS()
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
	public long getMarketDate()
	{
		return MarketDate;
	}
	public void setMarketDate(long value)
	{
		MarketDate = value;
	}
	public TI_SUSP_STATUS_Enum getMarketStatus()
	{
		return MarketStatus;
	}
	public void setMarketStatus(TI_SUSP_STATUS_Enum value)
	{
		MarketStatus = value;
	}
	public long getUpdateDate()
	{
		return UpdateDate;
	}
	public void setUpdateDate(long value)
	{
		UpdateDate = value;
	}
	public long getUpdateTime()
	{
		return UpdateTime;
	}
	public void setUpdateTime(long value)
	{
		UpdateTime = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MarketId = (long)byteBuffer.readInt();
		MarketDate = (long)byteBuffer.readInt();
		MarketStatus = MarketStatus.getEnum(byteBuffer.readInt());
		UpdateDate = (long)byteBuffer.readInt();
		UpdateTime = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MarketId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(MarketDate & 0xFFFFFFFFL));
		byteBuffer.writeInt(MarketStatus.getValue());
		byteBuffer.writeInt((int)(UpdateDate & 0xFFFFFFFFL));
		byteBuffer.writeLong(UpdateTime);

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
		stringBuilder.append("TI_MARKET_STATUS::");
		stringBuilder.append("MarketId(").append(MarketId).append(")");
		stringBuilder.append("MarketDate(").append(MarketDate).append(")");
		stringBuilder.append("MarketStatus(").append(MarketStatus).append(")");
		stringBuilder.append("UpdateDate(").append(UpdateDate).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		return stringBuilder.toString();
	}
}
