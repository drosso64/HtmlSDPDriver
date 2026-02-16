package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_PHASE_SECTION extends SMPMessage
{
	public static final long CLASS_ID = 100006;

	private long MarketId = 0;
	private long SectionId = 0;
	private TI_PHASE_Enum Phase = TI_PHASE_Enum.TI_PHASE_SystemDown;
	private long StartTime = 0;
	private long EndTime = 0;
	private TI_FLAG_Enum Published = TI_FLAG_Enum.TI_FLAG_No;

	public TI_PHASE_SECTION()
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
	public TI_PHASE_Enum getPhase()
	{
		return Phase;
	}
	public void setPhase(TI_PHASE_Enum value)
	{
		Phase = value;
	}
	public long getStartTime()
	{
		return StartTime;
	}
	public void setStartTime(long value)
	{
		StartTime = value;
	}
	public long getEndTime()
	{
		return EndTime;
	}
	public void setEndTime(long value)
	{
		EndTime = value;
	}
	public TI_FLAG_Enum getPublished()
	{
		return Published;
	}
	public void setPublished(TI_FLAG_Enum value)
	{
		Published = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MarketId = (long)byteBuffer.readInt();
		SectionId = (long)byteBuffer.readInt();
		Phase = Phase.getEnum(byteBuffer.readInt());
		StartTime = byteBuffer.readLong();
		EndTime = byteBuffer.readLong();
		Published = Published.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MarketId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SectionId & 0xFFFFFFFFL));
		byteBuffer.writeInt(Phase.getValue());
		byteBuffer.writeLong(StartTime);
		byteBuffer.writeLong(EndTime);
		byteBuffer.writeInt(Published.getValue());

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
		stringBuilder.append("TI_PHASE_SECTION::");
		stringBuilder.append("MarketId(").append(MarketId).append(")");
		stringBuilder.append("SectionId(").append(SectionId).append(")");
		stringBuilder.append("Phase(").append(Phase).append(")");
		stringBuilder.append("StartTime(").append(StartTime).append(")");
		stringBuilder.append("EndTime(").append(EndTime).append(")");
		stringBuilder.append("Published(").append(Published).append(")");
		return stringBuilder.toString();
	}
}
