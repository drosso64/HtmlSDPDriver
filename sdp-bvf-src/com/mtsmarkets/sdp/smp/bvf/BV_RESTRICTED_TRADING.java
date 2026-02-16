package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_RESTRICTED_TRADING extends SMPMessage
{
	public static final long CLASS_ID = 400002;

	private short AreaCodeId = 0;
	private long SectionId = 0;
	private TI_FUNCTION_Enum FunctionId = TI_FUNCTION_Enum.TI_FUNCTION_FirmQuote;
	private long StartRestrictedTrading = 0;
	private long StopRestrictedTrading = 0;

	public BV_RESTRICTED_TRADING()
	{
	}

	public short getAreaCodeId()
	{
		return AreaCodeId;
	}
	public void setAreaCodeId(short value)
	{
		AreaCodeId = value;
	}
	public long getSectionId()
	{
		return SectionId;
	}
	public void setSectionId(long value)
	{
		SectionId = value;
	}
	public TI_FUNCTION_Enum getFunctionId()
	{
		return FunctionId;
	}
	public void setFunctionId(TI_FUNCTION_Enum value)
	{
		FunctionId = value;
	}
	public long getStartRestrictedTrading()
	{
		return StartRestrictedTrading;
	}
	public void setStartRestrictedTrading(long value)
	{
		StartRestrictedTrading = value;
	}
	public long getStopRestrictedTrading()
	{
		return StopRestrictedTrading;
	}
	public void setStopRestrictedTrading(long value)
	{
		StopRestrictedTrading = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		AreaCodeId = (short)byteBuffer.readInt();
		SectionId = (long)byteBuffer.readInt();
		FunctionId = FunctionId.getEnum(byteBuffer.readInt());
		StartRestrictedTrading = byteBuffer.readLong();
		StopRestrictedTrading = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(AreaCodeId & 0xFFFFL));
		byteBuffer.writeInt((int)(SectionId & 0xFFFFFFFFL));
		byteBuffer.writeInt(FunctionId.getValue());
		byteBuffer.writeLong(StartRestrictedTrading);
		byteBuffer.writeLong(StopRestrictedTrading);

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
		stringBuilder.append("BV_RESTRICTED_TRADING::");
		stringBuilder.append("AreaCodeId(").append(AreaCodeId).append(")");
		stringBuilder.append("SectionId(").append(SectionId).append(")");
		stringBuilder.append("FunctionId(").append(FunctionId).append(")");
		stringBuilder.append("StartRestrictedTrading(").append(StartRestrictedTrading).append(")");
		stringBuilder.append("StopRestrictedTrading(").append(StopRestrictedTrading).append(")");
		return stringBuilder.toString();
	}
}
