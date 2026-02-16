package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_IOI_DEPTH_INFO extends SMPMessage
{
	public static final long CLASS_ID = 114982;

	private long MemberId = 0;
	private long IOIMsgId = 0;
	private double Quantity = 0;
	private double Price = 0;
	private double Yield = 0;
	private BV_YIELD_TYPE_Enum YieldType = BV_YIELD_TYPE_Enum.BV_YIELD_TYPE_None;
	private long GroupId = 0;

	public BV_IOI_DEPTH_INFO()
	{
	}

	public long getMemberId()
	{
		return MemberId;
	}
	public void setMemberId(long value)
	{
		MemberId = value;
	}
	public long getIOIMsgId()
	{
		return IOIMsgId;
	}
	public void setIOIMsgId(long value)
	{
		IOIMsgId = value;
	}
	public double getQuantity()
	{
		return Quantity;
	}
	public void setQuantity(double value)
	{
		Quantity = value;
	}
	public double getPrice()
	{
		return Price;
	}
	public void setPrice(double value)
	{
		Price = value;
	}
	public double getYield()
	{
		return Yield;
	}
	public void setYield(double value)
	{
		Yield = value;
	}
	public BV_YIELD_TYPE_Enum getYieldType()
	{
		return YieldType;
	}
	public void setYieldType(BV_YIELD_TYPE_Enum value)
	{
		YieldType = value;
	}
	public long getGroupId()
	{
		return GroupId;
	}
	public void setGroupId(long value)
	{
		GroupId = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MemberId = (long)byteBuffer.readInt();
		IOIMsgId = (long)byteBuffer.readInt();
		Quantity = byteBuffer.readDouble();
		Price = byteBuffer.readDouble();
		Yield = byteBuffer.readDouble();
		YieldType = YieldType.getEnum(byteBuffer.readInt());
		GroupId = (long)byteBuffer.readInt();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(IOIMsgId & 0xFFFFFFFFL));
		byteBuffer.writeDouble(Quantity);
		byteBuffer.writeDouble(Price);
		byteBuffer.writeDouble(Yield);
		byteBuffer.writeInt(YieldType.getValue());
		byteBuffer.writeInt((int)(GroupId & 0xFFFFFFFFL));

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
		stringBuilder.append("BV_IOI_DEPTH_INFO::");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("IOIMsgId(").append(IOIMsgId).append(")");
		stringBuilder.append("Quantity(").append(Quantity).append(")");
		stringBuilder.append("Price(").append(Price).append(")");
		stringBuilder.append("Yield(").append(Yield).append(")");
		stringBuilder.append("YieldType(").append(YieldType).append(")");
		stringBuilder.append("GroupId(").append(GroupId).append(")");
		return stringBuilder.toString();
	}
}
