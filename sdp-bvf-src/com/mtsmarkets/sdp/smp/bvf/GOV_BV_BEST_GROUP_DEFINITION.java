package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class GOV_BV_BEST_GROUP_DEFINITION extends SMPMessage
{
	public static final long CLASS_ID = 115000;

	private long SubmitterMemberId = 0;
	private long SubmitterTraderId = 0;
	private long InventoryGroupId = 0;
	private long SellSideMemberId = 0;
	private long ProductType = 0;
	private long UpdateDate = 0;
	private long UpdateTime = 0;

	public GOV_BV_BEST_GROUP_DEFINITION()
	{
	}

	public long getSubmitterMemberId()
	{
		return SubmitterMemberId;
	}
	public void setSubmitterMemberId(long value)
	{
		SubmitterMemberId = value;
	}
	public long getSubmitterTraderId()
	{
		return SubmitterTraderId;
	}
	public void setSubmitterTraderId(long value)
	{
		SubmitterTraderId = value;
	}
	public long getInventoryGroupId()
	{
		return InventoryGroupId;
	}
	public void setInventoryGroupId(long value)
	{
		InventoryGroupId = value;
	}
	public long getSellSideMemberId()
	{
		return SellSideMemberId;
	}
	public void setSellSideMemberId(long value)
	{
		SellSideMemberId = value;
	}
	public long getProductType()
	{
		return ProductType;
	}
	public void setProductType(long value)
	{
		ProductType = value;
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
		SubmitterMemberId = (long)byteBuffer.readInt();
		SubmitterTraderId = (long)byteBuffer.readInt();
		InventoryGroupId = (long)byteBuffer.readInt();
		SellSideMemberId = (long)byteBuffer.readInt();
		ProductType = (long)byteBuffer.readInt();
		UpdateDate = (long)byteBuffer.readInt();
		UpdateTime = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(SubmitterMemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SubmitterTraderId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(InventoryGroupId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SellSideMemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(ProductType & 0xFFFFFFFFL));
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
		stringBuilder.append("GOV_BV_BEST_GROUP_DEFINITION::");
		stringBuilder.append("SubmitterMemberId(").append(SubmitterMemberId).append(")");
		stringBuilder.append("SubmitterTraderId(").append(SubmitterTraderId).append(")");
		stringBuilder.append("InventoryGroupId(").append(InventoryGroupId).append(")");
		stringBuilder.append("SellSideMemberId(").append(SellSideMemberId).append(")");
		stringBuilder.append("ProductType(").append(ProductType).append(")");
		stringBuilder.append("UpdateDate(").append(UpdateDate).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		return stringBuilder.toString();
	}
}
