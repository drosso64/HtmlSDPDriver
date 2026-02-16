package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class DF_RFCQ_TRAFFIC extends SMPMessage
{
	public static final long CLASS_ID = 170029;

	private long MarketId = 0;
	private long SectionId = 0;
	private int Hour = 0;
	private int Quarter = 0;
	private int Minutes = 0;
	private DF_STATISTICS_TYPE_Enum StatisticType = DF_STATISTICS_TYPE_Enum.Statistics_Hour;
	private DF_RFCQ_TRADING_INFO TradInfo = new DF_RFCQ_TRADING_INFO();

	public DF_RFCQ_TRAFFIC()
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
	public long getSectionId()
	{
		return SectionId;
	}
	public void setSectionId(long value)
	{
		SectionId = value;
	}
	public int getHour()
	{
		return Hour;
	}
	public void setHour(int value)
	{
		Hour = value;
	}
	public int getQuarter()
	{
		return Quarter;
	}
	public void setQuarter(int value)
	{
		Quarter = value;
	}
	public int getMinutes()
	{
		return Minutes;
	}
	public void setMinutes(int value)
	{
		Minutes = value;
	}
	public DF_STATISTICS_TYPE_Enum getStatisticType()
	{
		return StatisticType;
	}
	public void setStatisticType(DF_STATISTICS_TYPE_Enum value)
	{
		StatisticType = value;
	}
	public DF_RFCQ_TRADING_INFO getTradInfo()
	{
		return TradInfo;
	}
	public void setTradInfo(DF_RFCQ_TRADING_INFO value)
	{
		TradInfo = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MarketId = (long)byteBuffer.readInt();
		SectionId = (long)byteBuffer.readInt();
		Hour = (int)byteBuffer.readInt();
		Quarter = (int)byteBuffer.readInt();
		Minutes = (int)byteBuffer.readInt();
		StatisticType = StatisticType.getEnum(byteBuffer.readInt());
		TradInfo.readXDR(byteBuffer);
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MarketId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SectionId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(Hour & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(Quarter & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(Minutes & 0xFFFFFFFFL));
		byteBuffer.writeInt(StatisticType.getValue());
		TradInfo.writeXDR(byteBuffer);

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
		stringBuilder.append("DF_RFCQ_TRAFFIC::");
		stringBuilder.append("MarketId(").append(MarketId).append(")");
		stringBuilder.append("SectionId(").append(SectionId).append(")");
		stringBuilder.append("Hour(").append(Hour).append(")");
		stringBuilder.append("Quarter(").append(Quarter).append(")");
		stringBuilder.append("Minutes(").append(Minutes).append(")");
		stringBuilder.append("StatisticType(").append(StatisticType).append(")");
		stringBuilder.append("TradInfo(").append(TradInfo.toString()).append(")");
		return stringBuilder.toString();
	}
}
