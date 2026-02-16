package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class DF_BV_MEMBER_SALES_CONFIG_QUERY_PARAM extends SMPMessage
{
	public static final long CLASS_ID = 170024;

	private TI_QUERY_OP_Enum MarketIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long MarketId = 0;
	private TI_QUERY_OP_Enum SellSideMemberIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long SellSideMemberId = 0;
	private TI_QUERY_OP_Enum BuySideMemberIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long BuySideMemberId = 0;

	public DF_BV_MEMBER_SALES_CONFIG_QUERY_PARAM()
	{
	}

	public TI_QUERY_OP_Enum getMarketIdOp()
	{
		return MarketIdOp;
	}
	public void setMarketIdOp(TI_QUERY_OP_Enum value)
	{
		MarketIdOp = value;
	}
	public long getMarketId()
	{
		return MarketId;
	}
	public void setMarketId(long value)
	{
		MarketId = value;
	}
	public TI_QUERY_OP_Enum getSellSideMemberIdOp()
	{
		return SellSideMemberIdOp;
	}
	public void setSellSideMemberIdOp(TI_QUERY_OP_Enum value)
	{
		SellSideMemberIdOp = value;
	}
	public long getSellSideMemberId()
	{
		return SellSideMemberId;
	}
	public void setSellSideMemberId(long value)
	{
		SellSideMemberId = value;
	}
	public TI_QUERY_OP_Enum getBuySideMemberIdOp()
	{
		return BuySideMemberIdOp;
	}
	public void setBuySideMemberIdOp(TI_QUERY_OP_Enum value)
	{
		BuySideMemberIdOp = value;
	}
	public long getBuySideMemberId()
	{
		return BuySideMemberId;
	}
	public void setBuySideMemberId(long value)
	{
		BuySideMemberId = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MarketIdOp = MarketIdOp.getEnum(byteBuffer.readInt());
		MarketId = (long)byteBuffer.readInt();
		SellSideMemberIdOp = SellSideMemberIdOp.getEnum(byteBuffer.readInt());
		SellSideMemberId = (long)byteBuffer.readInt();
		BuySideMemberIdOp = BuySideMemberIdOp.getEnum(byteBuffer.readInt());
		BuySideMemberId = (long)byteBuffer.readInt();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt(MarketIdOp.getValue());
		byteBuffer.writeInt((int)(MarketId & 0xFFFFFFFFL));
		byteBuffer.writeInt(SellSideMemberIdOp.getValue());
		byteBuffer.writeInt((int)(SellSideMemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt(BuySideMemberIdOp.getValue());
		byteBuffer.writeInt((int)(BuySideMemberId & 0xFFFFFFFFL));

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
		stringBuilder.append("DF_BV_MEMBER_SALES_CONFIG_QUERY_PARAM::");
		stringBuilder.append("MarketIdOp(").append(MarketIdOp).append(")");
		stringBuilder.append("MarketId(").append(MarketId).append(")");
		stringBuilder.append("SellSideMemberIdOp(").append(SellSideMemberIdOp).append(")");
		stringBuilder.append("SellSideMemberId(").append(SellSideMemberId).append(")");
		stringBuilder.append("BuySideMemberIdOp(").append(BuySideMemberIdOp).append(")");
		stringBuilder.append("BuySideMemberId(").append(BuySideMemberId).append(")");
		return stringBuilder.toString();
	}
}
