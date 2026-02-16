package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_MEMBER_SALES_EXCEPTION extends SMPMessage
{
	public static final long CLASS_ID = 400104;

	private long SellSideMemberId = 0;
	private long SellSideTraderId = 0;
	private String SellSideTraderName = "";
	private long SalesId = 0;
	private String SalesName = "";
	private long BuySideMemberId = 0;
	private long BuySideTraderId = 0;
	private String BuySideTraderName = "";
	private long TradableInstrumentId = 0;
	private long InstrumentClassId = 0;
	private long ProductTypeId = 0;
	private long RatingCategoryId = 0;
	private TI_RELATION_TYPE_Enum RelationType = TI_RELATION_TYPE_Enum.TI_RELATION_TYPE_Undefined;
	private TI_RELATION_LEVEL_Enum RelationLevel = TI_RELATION_LEVEL_Enum.TI_RELATION_LEVEL_Member;
	private String RelationInfo = "";
	private String InstrumentISINCode = "";
	private TI_INSTRUMENT_TYPE_Enum InstrumentType = TI_INSTRUMENT_TYPE_Enum.TI_INSTRUMENT_TYPE_Bond;
	private long CreationDate = 0;
	private long CreationTime = 0;

	public BV_MEMBER_SALES_EXCEPTION()
	{
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
	public long getTradableInstrumentId()
	{
		return TradableInstrumentId;
	}
	public void setTradableInstrumentId(long value)
	{
		TradableInstrumentId = value;
	}
	public long getInstrumentClassId()
	{
		return InstrumentClassId;
	}
	public void setInstrumentClassId(long value)
	{
		InstrumentClassId = value;
	}
	public long getProductTypeId()
	{
		return ProductTypeId;
	}
	public void setProductTypeId(long value)
	{
		ProductTypeId = value;
	}
	public long getRatingCategoryId()
	{
		return RatingCategoryId;
	}
	public void setRatingCategoryId(long value)
	{
		RatingCategoryId = value;
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
	public String getInstrumentISINCode()
	{
		return InstrumentISINCode;
	}
	public void setInstrumentISINCode(String value)
	{
		InstrumentISINCode = value;
	}
	public TI_INSTRUMENT_TYPE_Enum getInstrumentType()
	{
		return InstrumentType;
	}
	public void setInstrumentType(TI_INSTRUMENT_TYPE_Enum value)
	{
		InstrumentType = value;
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

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		SellSideMemberId = (long)byteBuffer.readInt();
		SellSideTraderId = (long)byteBuffer.readInt();
		SellSideTraderName = byteBuffer.readString();
		SalesId = (long)byteBuffer.readInt();
		SalesName = byteBuffer.readString();
		BuySideMemberId = (long)byteBuffer.readInt();
		BuySideTraderId = (long)byteBuffer.readInt();
		BuySideTraderName = byteBuffer.readString();
		TradableInstrumentId = (long)byteBuffer.readInt();
		InstrumentClassId = (long)byteBuffer.readInt();
		ProductTypeId = (long)byteBuffer.readInt();
		RatingCategoryId = (long)byteBuffer.readInt();
		RelationType = RelationType.getEnum(byteBuffer.readInt());
		RelationLevel = RelationLevel.getEnum(byteBuffer.readInt());
		RelationInfo = byteBuffer.readString();
		InstrumentISINCode = byteBuffer.readString();
		InstrumentType = InstrumentType.getEnum(byteBuffer.readInt());
		CreationDate = (long)byteBuffer.readInt();
		CreationTime = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(SellSideMemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SellSideTraderId & 0xFFFFFFFFL));
		byteBuffer.writeString(SellSideTraderName);
		byteBuffer.writeInt((int)(SalesId & 0xFFFFFFFFL));
		byteBuffer.writeString(SalesName);
		byteBuffer.writeInt((int)(BuySideMemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(BuySideTraderId & 0xFFFFFFFFL));
		byteBuffer.writeString(BuySideTraderName);
		byteBuffer.writeInt((int)(TradableInstrumentId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(InstrumentClassId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(ProductTypeId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(RatingCategoryId & 0xFFFFFFFFL));
		byteBuffer.writeInt(RelationType.getValue());
		byteBuffer.writeInt(RelationLevel.getValue());
		byteBuffer.writeString(RelationInfo);
		byteBuffer.writeString(InstrumentISINCode);
		byteBuffer.writeInt(InstrumentType.getValue());
		byteBuffer.writeInt((int)(CreationDate & 0xFFFFFFFFL));
		byteBuffer.writeLong(CreationTime);

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
		stringBuilder.append("BV_MEMBER_SALES_EXCEPTION::");
		stringBuilder.append("SellSideMemberId(").append(SellSideMemberId).append(")");
		stringBuilder.append("SellSideTraderId(").append(SellSideTraderId).append(")");
		stringBuilder.append("SellSideTraderName(").append(SellSideTraderName).append(")");
		stringBuilder.append("SalesId(").append(SalesId).append(")");
		stringBuilder.append("SalesName(").append(SalesName).append(")");
		stringBuilder.append("BuySideMemberId(").append(BuySideMemberId).append(")");
		stringBuilder.append("BuySideTraderId(").append(BuySideTraderId).append(")");
		stringBuilder.append("BuySideTraderName(").append(BuySideTraderName).append(")");
		stringBuilder.append("TradableInstrumentId(").append(TradableInstrumentId).append(")");
		stringBuilder.append("InstrumentClassId(").append(InstrumentClassId).append(")");
		stringBuilder.append("ProductTypeId(").append(ProductTypeId).append(")");
		stringBuilder.append("RatingCategoryId(").append(RatingCategoryId).append(")");
		stringBuilder.append("RelationType(").append(RelationType).append(")");
		stringBuilder.append("RelationLevel(").append(RelationLevel).append(")");
		stringBuilder.append("RelationInfo(").append(RelationInfo).append(")");
		stringBuilder.append("InstrumentISINCode(").append(InstrumentISINCode).append(")");
		stringBuilder.append("InstrumentType(").append(InstrumentType).append(")");
		stringBuilder.append("CreationDate(").append(CreationDate).append(")");
		stringBuilder.append("CreationTime(").append(CreationTime).append(")");
		return stringBuilder.toString();
	}
}
