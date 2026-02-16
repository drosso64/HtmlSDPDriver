package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_BOND_TRANSPARENCY_DEFERRAL_ATTRIBUTES extends SMPMessage
{
	public static final long CLASS_ID = 100240;

	private long MarketId = 0;
	private short AreaCodeId = 0;
	private TI_POST_TRADE_DEFERRAL_Enum PostTradeDeferral = TI_POST_TRADE_DEFERRAL_Enum.TI_POST_TRADE_DEFERRAL_None;
	private short Category = 0;
	private TI_BOND_TRANSPARENCY_DEFERRAL_Enum PriceDeferral = TI_BOND_TRANSPARENCY_DEFERRAL_Enum.TI_BOND_TRANSPARENCY_DEFERRAL_None;
	private TI_BOND_TRANSPARENCY_DEFERRAL_Enum SizeDeferral = TI_BOND_TRANSPARENCY_DEFERRAL_Enum.TI_BOND_TRANSPARENCY_DEFERRAL_None;
	private TI_BOND_TRANSPARENCY_DEFERRAL_Enum OverallDeferral = TI_BOND_TRANSPARENCY_DEFERRAL_Enum.TI_BOND_TRANSPARENCY_DEFERRAL_None;
	private TI_POST_TRADE_DEFERRAL_Enum PostTradePublishFg = TI_POST_TRADE_DEFERRAL_Enum.TI_POST_TRADE_DEFERRAL_None;

	public TI_BOND_TRANSPARENCY_DEFERRAL_ATTRIBUTES()
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
	public short getAreaCodeId()
	{
		return AreaCodeId;
	}
	public void setAreaCodeId(short value)
	{
		AreaCodeId = value;
	}
	public TI_POST_TRADE_DEFERRAL_Enum getPostTradeDeferral()
	{
		return PostTradeDeferral;
	}
	public void setPostTradeDeferral(TI_POST_TRADE_DEFERRAL_Enum value)
	{
		PostTradeDeferral = value;
	}
	public short getCategory()
	{
		return Category;
	}
	public void setCategory(short value)
	{
		Category = value;
	}
	public TI_BOND_TRANSPARENCY_DEFERRAL_Enum getPriceDeferral()
	{
		return PriceDeferral;
	}
	public void setPriceDeferral(TI_BOND_TRANSPARENCY_DEFERRAL_Enum value)
	{
		PriceDeferral = value;
	}
	public TI_BOND_TRANSPARENCY_DEFERRAL_Enum getSizeDeferral()
	{
		return SizeDeferral;
	}
	public void setSizeDeferral(TI_BOND_TRANSPARENCY_DEFERRAL_Enum value)
	{
		SizeDeferral = value;
	}
	public TI_BOND_TRANSPARENCY_DEFERRAL_Enum getOverallDeferral()
	{
		return OverallDeferral;
	}
	public void setOverallDeferral(TI_BOND_TRANSPARENCY_DEFERRAL_Enum value)
	{
		OverallDeferral = value;
	}
	public TI_POST_TRADE_DEFERRAL_Enum getPostTradePublishFg()
	{
		return PostTradePublishFg;
	}
	public void setPostTradePublishFg(TI_POST_TRADE_DEFERRAL_Enum value)
	{
		PostTradePublishFg = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MarketId = (long)byteBuffer.readInt();
		AreaCodeId = (short)byteBuffer.readInt();
		PostTradeDeferral = PostTradeDeferral.getEnum(byteBuffer.readInt());
		Category = (short)byteBuffer.readInt();
		PriceDeferral = PriceDeferral.getEnum(byteBuffer.readInt());
		SizeDeferral = SizeDeferral.getEnum(byteBuffer.readInt());
		OverallDeferral = OverallDeferral.getEnum(byteBuffer.readInt());
		PostTradePublishFg = PostTradePublishFg.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MarketId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(AreaCodeId & 0xFFFFL));
		byteBuffer.writeInt(PostTradeDeferral.getValue());
		byteBuffer.writeInt((int)(Category & 0xFFFFL));
		byteBuffer.writeInt(PriceDeferral.getValue());
		byteBuffer.writeInt(SizeDeferral.getValue());
		byteBuffer.writeInt(OverallDeferral.getValue());
		byteBuffer.writeInt(PostTradePublishFg.getValue());

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
		stringBuilder.append("TI_BOND_TRANSPARENCY_DEFERRAL_ATTRIBUTES::");
		stringBuilder.append("MarketId(").append(MarketId).append(")");
		stringBuilder.append("AreaCodeId(").append(AreaCodeId).append(")");
		stringBuilder.append("PostTradeDeferral(").append(PostTradeDeferral).append(")");
		stringBuilder.append("Category(").append(Category).append(")");
		stringBuilder.append("PriceDeferral(").append(PriceDeferral).append(")");
		stringBuilder.append("SizeDeferral(").append(SizeDeferral).append(")");
		stringBuilder.append("OverallDeferral(").append(OverallDeferral).append(")");
		stringBuilder.append("PostTradePublishFg(").append(PostTradePublishFg).append(")");
		return stringBuilder.toString();
	}
}
