package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_SECTION_PHASE_STATUS extends SMPMessage
{
	public static final long CLASS_ID = 100034;

	private long MarketId = 0;
	private long SectionId = 0;
	private TI_SUSP_STATUS_Enum SectionStatus = TI_SUSP_STATUS_Enum.TI_SUSP_STATUS_Active;
	private TI_PHASE_Enum CurrentPhase = TI_PHASE_Enum.TI_PHASE_SystemDown;
	private long UpdateDate = 0;
	private long UpdateTime = 0;

	public TI_SECTION_PHASE_STATUS()
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
	public TI_SUSP_STATUS_Enum getSectionStatus()
	{
		return SectionStatus;
	}
	public void setSectionStatus(TI_SUSP_STATUS_Enum value)
	{
		SectionStatus = value;
	}
	public TI_PHASE_Enum getCurrentPhase()
	{
		return CurrentPhase;
	}
	public void setCurrentPhase(TI_PHASE_Enum value)
	{
		CurrentPhase = value;
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
		SectionId = (long)byteBuffer.readInt();
		SectionStatus = SectionStatus.getEnum(byteBuffer.readInt());
		CurrentPhase = CurrentPhase.getEnum(byteBuffer.readInt());
		UpdateDate = (long)byteBuffer.readInt();
		UpdateTime = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MarketId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SectionId & 0xFFFFFFFFL));
		byteBuffer.writeInt(SectionStatus.getValue());
		byteBuffer.writeInt(CurrentPhase.getValue());
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
		stringBuilder.append("TI_SECTION_PHASE_STATUS::");
		stringBuilder.append("MarketId(").append(MarketId).append(")");
		stringBuilder.append("SectionId(").append(SectionId).append(")");
		stringBuilder.append("SectionStatus(").append(SectionStatus).append(")");
		stringBuilder.append("CurrentPhase(").append(CurrentPhase).append(")");
		stringBuilder.append("UpdateDate(").append(UpdateDate).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		return stringBuilder.toString();
	}
}
