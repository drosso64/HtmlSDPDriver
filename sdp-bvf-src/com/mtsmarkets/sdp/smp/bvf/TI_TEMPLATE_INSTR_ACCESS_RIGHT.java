package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_TEMPLATE_INSTR_ACCESS_RIGHT extends SMPMessage
{
	public static final long CLASS_ID = 100235;

	private TI_TRADER_TYPE_Enum TraderType = TI_TRADER_TYPE_Enum.TI_TRADER_TYPE_Manager;
	private long MarketId = 0;
	private long SectionId = 0;
	private long InstrumentClassId = 0;
	private TI_INSTR_CLASS_TYPE_Enum ClassType = TI_INSTR_CLASS_TYPE_Enum.TI_INSTR_CLASS_TYPE_All;
	private TI_ACCESS_RIGHT_Enum TraderProfile = TI_ACCESS_RIGHT_Enum.TI_ACCESS_RIGHT_None;

	public TI_TEMPLATE_INSTR_ACCESS_RIGHT()
	{
	}

	public TI_TRADER_TYPE_Enum getTraderType()
	{
		return TraderType;
	}
	public void setTraderType(TI_TRADER_TYPE_Enum value)
	{
		TraderType = value;
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
	public long getInstrumentClassId()
	{
		return InstrumentClassId;
	}
	public void setInstrumentClassId(long value)
	{
		InstrumentClassId = value;
	}
	public TI_INSTR_CLASS_TYPE_Enum getClassType()
	{
		return ClassType;
	}
	public void setClassType(TI_INSTR_CLASS_TYPE_Enum value)
	{
		ClassType = value;
	}
	public TI_ACCESS_RIGHT_Enum getTraderProfile()
	{
		return TraderProfile;
	}
	public void setTraderProfile(TI_ACCESS_RIGHT_Enum value)
	{
		TraderProfile = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		TraderType = TraderType.getEnum(byteBuffer.readInt());
		MarketId = (long)byteBuffer.readInt();
		SectionId = (long)byteBuffer.readInt();
		InstrumentClassId = (long)byteBuffer.readInt();
		ClassType = ClassType.getEnum(byteBuffer.readInt());
		TraderProfile = TraderProfile.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt(TraderType.getValue());
		byteBuffer.writeInt((int)(MarketId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SectionId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(InstrumentClassId & 0xFFFFFFFFL));
		byteBuffer.writeInt(ClassType.getValue());
		byteBuffer.writeInt(TraderProfile.getValue());

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
		stringBuilder.append("TI_TEMPLATE_INSTR_ACCESS_RIGHT::");
		stringBuilder.append("TraderType(").append(TraderType).append(")");
		stringBuilder.append("MarketId(").append(MarketId).append(")");
		stringBuilder.append("SectionId(").append(SectionId).append(")");
		stringBuilder.append("InstrumentClassId(").append(InstrumentClassId).append(")");
		stringBuilder.append("ClassType(").append(ClassType).append(")");
		stringBuilder.append("TraderProfile(").append(TraderProfile).append(")");
		return stringBuilder.toString();
	}
}
