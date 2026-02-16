package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_SELL_SIDE_X_IC_LEI_CODE extends SMPMessage
{
	public static final long CLASS_ID = 400040;

	private long BuySideMemberId = 0;
	private long SellSideMemberId = 0;
	private long InstrumentClassId = 0;
	private String SellSideLeiCode = "";
	private long SellSideMainMemberId = 0;

	public BV_SELL_SIDE_X_IC_LEI_CODE()
	{
	}

	public long getBuySideMemberId()
	{
		return BuySideMemberId;
	}
	public void setBuySideMemberId(long value)
	{
		BuySideMemberId = value;
	}
	public long getSellSideMemberId()
	{
		return SellSideMemberId;
	}
	public void setSellSideMemberId(long value)
	{
		SellSideMemberId = value;
	}
	public long getInstrumentClassId()
	{
		return InstrumentClassId;
	}
	public void setInstrumentClassId(long value)
	{
		InstrumentClassId = value;
	}
	public String getSellSideLeiCode()
	{
		return SellSideLeiCode;
	}
	public void setSellSideLeiCode(String value)
	{
		SellSideLeiCode = value;
	}
	public long getSellSideMainMemberId()
	{
		return SellSideMainMemberId;
	}
	public void setSellSideMainMemberId(long value)
	{
		SellSideMainMemberId = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		BuySideMemberId = (long)byteBuffer.readInt();
		SellSideMemberId = (long)byteBuffer.readInt();
		InstrumentClassId = (long)byteBuffer.readInt();
		SellSideLeiCode = byteBuffer.readString();
		SellSideMainMemberId = (long)byteBuffer.readInt();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(BuySideMemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SellSideMemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(InstrumentClassId & 0xFFFFFFFFL));
		byteBuffer.writeString(SellSideLeiCode);
		byteBuffer.writeInt((int)(SellSideMainMemberId & 0xFFFFFFFFL));

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
		stringBuilder.append("BV_SELL_SIDE_X_IC_LEI_CODE::");
		stringBuilder.append("BuySideMemberId(").append(BuySideMemberId).append(")");
		stringBuilder.append("SellSideMemberId(").append(SellSideMemberId).append(")");
		stringBuilder.append("InstrumentClassId(").append(InstrumentClassId).append(")");
		stringBuilder.append("SellSideLeiCode(").append(SellSideLeiCode).append(")");
		stringBuilder.append("SellSideMainMemberId(").append(SellSideMainMemberId).append(")");
		return stringBuilder.toString();
	}
}
