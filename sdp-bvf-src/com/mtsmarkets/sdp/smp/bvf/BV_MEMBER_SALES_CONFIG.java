package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_MEMBER_SALES_CONFIG extends SMPMessage
{
	public static final long CLASS_ID = 100068;

	private long MarketId = 0;
	private long SellSideMemberId = 0;
	private long SellSideTraderId = 0;
	private String SellSideTraderName = "";
	private long SalesId = 0;
	private String SalesName = "";
	private long BuySideMemberId = 0;
	private long BuySideTraderId = 0;
	private String BuySideTraderName = "";
	private TI_RELATION_TYPE_Enum RelationType = TI_RELATION_TYPE_Enum.TI_RELATION_TYPE_Undefined;
	private TI_RELATION_LEVEL_Enum RelationLevel = TI_RELATION_LEVEL_Enum.TI_RELATION_LEVEL_Member;
	private String RelationInfo = "";
	private long CreationDate = 0;
	private long CreationTime = 0;
	private long UpdateDate = 0;
	private long UpdateTime = 0;

	public BV_MEMBER_SALES_CONFIG()
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
	public long getSellSideTraderId()
	{
		return SellSideTraderId;
	}
	public void setSellSideTraderId(long value)
	{
		SellSideTraderId = value;
	}
	public String getSellSideTraderName()
	{
		return SellSideTraderName;
	}
	public void setSellSideTraderName(String value)
	{
		SellSideTraderName = value;
	}
	public long getSalesId()
	{
		return SalesId;
	}
	public void setSalesId(long value)
	{
		SalesId = value;
	}
	public String getSalesName()
	{
		return SalesName;
	}
	public void setSalesName(String value)
	{
		SalesName = value;
	}
	public long getBuySideMemberId()
	{
		return BuySideMemberId;
	}
	public void setBuySideMemberId(long value)
	{
		BuySideMemberId = value;
	}
	public long getBuySideTraderId()
	{
		return BuySideTraderId;
	}
	public void setBuySideTraderId(long value)
	{
		BuySideTraderId = value;
	}
	public String getBuySideTraderName()
	{
		return BuySideTraderName;
	}
	public void setBuySideTraderName(String value)
	{
		BuySideTraderName = value;
	}
	public TI_RELATION_TYPE_Enum getRelationType()
	{
		return RelationType;
	}
	public void setRelationType(TI_RELATION_TYPE_Enum value)
	{
		RelationType = value;
	}
	public TI_RELATION_LEVEL_Enum getRelationLevel()
	{
		return RelationLevel;
	}
	public void setRelationLevel(TI_RELATION_LEVEL_Enum value)
	{
		RelationLevel = value;
	}
	public String getRelationInfo()
	{
		return RelationInfo;
	}
	public void setRelationInfo(String value)
	{
		RelationInfo = value;
	}
	public long getCreationDate()
	{
		return CreationDate;
	}
	public void setCreationDate(long value)
	{
		CreationDate = value;
	}
	public long getCreationTime()
	{
		return CreationTime;
	}
	public void setCreationTime(long value)
	{
		CreationTime = value;
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
		SellSideMemberId = (long)byteBuffer.readInt();
		SellSideTraderId = (long)byteBuffer.readInt();
		SellSideTraderName = byteBuffer.readString();
		SalesId = (long)byteBuffer.readInt();
		SalesName = byteBuffer.readString();
		BuySideMemberId = (long)byteBuffer.readInt();
		BuySideTraderId = (long)byteBuffer.readInt();
		BuySideTraderName = byteBuffer.readString();
		RelationType = RelationType.getEnum(byteBuffer.readInt());
		RelationLevel = RelationLevel.getEnum(byteBuffer.readInt());
		RelationInfo = byteBuffer.readString();
		CreationDate = (long)byteBuffer.readInt();
		CreationTime = byteBuffer.readLong();
		UpdateDate = (long)byteBuffer.readInt();
		UpdateTime = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MarketId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SellSideMemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SellSideTraderId & 0xFFFFFFFFL));
		byteBuffer.writeString(SellSideTraderName);
		byteBuffer.writeInt((int)(SalesId & 0xFFFFFFFFL));
		byteBuffer.writeString(SalesName);
		byteBuffer.writeInt((int)(BuySideMemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(BuySideTraderId & 0xFFFFFFFFL));
		byteBuffer.writeString(BuySideTraderName);
		byteBuffer.writeInt(RelationType.getValue());
		byteBuffer.writeInt(RelationLevel.getValue());
		byteBuffer.writeString(RelationInfo);
		byteBuffer.writeInt((int)(CreationDate & 0xFFFFFFFFL));
		byteBuffer.writeLong(CreationTime);
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
		stringBuilder.append("BV_MEMBER_SALES_CONFIG::");
		stringBuilder.append("MarketId(").append(MarketId).append(")");
		stringBuilder.append("SellSideMemberId(").append(SellSideMemberId).append(")");
		stringBuilder.append("SellSideTraderId(").append(SellSideTraderId).append(")");
		stringBuilder.append("SellSideTraderName(").append(SellSideTraderName).append(")");
		stringBuilder.append("SalesId(").append(SalesId).append(")");
		stringBuilder.append("SalesName(").append(SalesName).append(")");
		stringBuilder.append("BuySideMemberId(").append(BuySideMemberId).append(")");
		stringBuilder.append("BuySideTraderId(").append(BuySideTraderId).append(")");
		stringBuilder.append("BuySideTraderName(").append(BuySideTraderName).append(")");
		stringBuilder.append("RelationType(").append(RelationType).append(")");
		stringBuilder.append("RelationLevel(").append(RelationLevel).append(")");
		stringBuilder.append("RelationInfo(").append(RelationInfo).append(")");
		stringBuilder.append("CreationDate(").append(CreationDate).append(")");
		stringBuilder.append("CreationTime(").append(CreationTime).append(")");
		stringBuilder.append("UpdateDate(").append(UpdateDate).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		return stringBuilder.toString();
	}
}
