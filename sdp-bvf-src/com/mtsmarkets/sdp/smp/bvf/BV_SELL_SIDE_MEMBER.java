package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_SELL_SIDE_MEMBER extends SMPMessage
{
	public static final long CLASS_ID = 100066;

	private long MarketId = 0;
	private long SellSideMemberId = 0;
	private long InstrumentClassId = 0;
	private TI_FLAG_Enum EnabledFg = TI_FLAG_Enum.TI_FLAG_No;
	private TI_FLAG_Enum RFCQPartialFillFg = TI_FLAG_Enum.TI_FLAG_No;

	public BV_SELL_SIDE_MEMBER()
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
	public TI_FLAG_Enum getEnabledFg()
	{
		return EnabledFg;
	}
	public void setEnabledFg(TI_FLAG_Enum value)
	{
		EnabledFg = value;
	}
	public TI_FLAG_Enum getRFCQPartialFillFg()
	{
		return RFCQPartialFillFg;
	}
	public void setRFCQPartialFillFg(TI_FLAG_Enum value)
	{
		RFCQPartialFillFg = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MarketId = (long)byteBuffer.readInt();
		SellSideMemberId = (long)byteBuffer.readInt();
		InstrumentClassId = (long)byteBuffer.readInt();
		EnabledFg = EnabledFg.getEnum(byteBuffer.readInt());
		RFCQPartialFillFg = RFCQPartialFillFg.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MarketId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SellSideMemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(InstrumentClassId & 0xFFFFFFFFL));
		byteBuffer.writeInt(EnabledFg.getValue());
		byteBuffer.writeInt(RFCQPartialFillFg.getValue());

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
		stringBuilder.append("BV_SELL_SIDE_MEMBER::");
		stringBuilder.append("MarketId(").append(MarketId).append(")");
		stringBuilder.append("SellSideMemberId(").append(SellSideMemberId).append(")");
		stringBuilder.append("InstrumentClassId(").append(InstrumentClassId).append(")");
		stringBuilder.append("EnabledFg(").append(EnabledFg).append(")");
		stringBuilder.append("RFCQPartialFillFg(").append(RFCQPartialFillFg).append(")");
		return stringBuilder.toString();
	}
}
