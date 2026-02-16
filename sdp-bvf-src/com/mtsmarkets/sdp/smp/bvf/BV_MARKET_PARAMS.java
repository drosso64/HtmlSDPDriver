package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_MARKET_PARAMS extends SMPMessage
{
	public static final long CLASS_ID = 114100;

	private long SectionId = 0;
	private TI_FLAG_Enum InventoryOrdersFg = TI_FLAG_Enum.TI_FLAG_No;
	private short MaxNumIOI = 0;
	private short IOIDDepthLenght = 0;
	private short MaxNumSingleSideInventoryQuotes = 0;
	private short MaxNumDoubleSideInventoryQuotes = 0;
	private short InventoryDepthLength = 0;

	public BV_MARKET_PARAMS()
	{
	}

	public long getSectionId()
	{
		return SectionId;
	}
	public void setSectionId(long value)
	{
		SectionId = value;
	}
	public TI_FLAG_Enum getInventoryOrdersFg()
	{
		return InventoryOrdersFg;
	}
	public void setInventoryOrdersFg(TI_FLAG_Enum value)
	{
		InventoryOrdersFg = value;
	}
	public short getMaxNumIOI()
	{
		return MaxNumIOI;
	}
	public void setMaxNumIOI(short value)
	{
		MaxNumIOI = value;
	}
	public short getIOIDDepthLenght()
	{
		return IOIDDepthLenght;
	}
	public void setIOIDDepthLenght(short value)
	{
		IOIDDepthLenght = value;
	}
	public short getMaxNumSingleSideInventoryQuotes()
	{
		return MaxNumSingleSideInventoryQuotes;
	}
	public void setMaxNumSingleSideInventoryQuotes(short value)
	{
		MaxNumSingleSideInventoryQuotes = value;
	}
	public short getMaxNumDoubleSideInventoryQuotes()
	{
		return MaxNumDoubleSideInventoryQuotes;
	}
	public void setMaxNumDoubleSideInventoryQuotes(short value)
	{
		MaxNumDoubleSideInventoryQuotes = value;
	}
	public short getInventoryDepthLength()
	{
		return InventoryDepthLength;
	}
	public void setInventoryDepthLength(short value)
	{
		InventoryDepthLength = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		SectionId = (long)byteBuffer.readInt();
		InventoryOrdersFg = InventoryOrdersFg.getEnum(byteBuffer.readInt());
		MaxNumIOI = (short)byteBuffer.readInt();
		IOIDDepthLenght = (short)byteBuffer.readInt();
		MaxNumSingleSideInventoryQuotes = (short)byteBuffer.readInt();
		MaxNumDoubleSideInventoryQuotes = (short)byteBuffer.readInt();
		InventoryDepthLength = (short)byteBuffer.readInt();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(SectionId & 0xFFFFFFFFL));
		byteBuffer.writeInt(InventoryOrdersFg.getValue());
		byteBuffer.writeInt((int)(MaxNumIOI & 0xFFFFL));
		byteBuffer.writeInt((int)(IOIDDepthLenght & 0xFFFFL));
		byteBuffer.writeInt((int)(MaxNumSingleSideInventoryQuotes & 0xFFFFL));
		byteBuffer.writeInt((int)(MaxNumDoubleSideInventoryQuotes & 0xFFFFL));
		byteBuffer.writeInt((int)(InventoryDepthLength & 0xFFFFL));

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
		stringBuilder.append("BV_MARKET_PARAMS::");
		stringBuilder.append("SectionId(").append(SectionId).append(")");
		stringBuilder.append("InventoryOrdersFg(").append(InventoryOrdersFg).append(")");
		stringBuilder.append("MaxNumIOI(").append(MaxNumIOI).append(")");
		stringBuilder.append("IOIDDepthLenght(").append(IOIDDepthLenght).append(")");
		stringBuilder.append("MaxNumSingleSideInventoryQuotes(").append(MaxNumSingleSideInventoryQuotes).append(")");
		stringBuilder.append("MaxNumDoubleSideInventoryQuotes(").append(MaxNumDoubleSideInventoryQuotes).append(")");
		stringBuilder.append("InventoryDepthLength(").append(InventoryDepthLength).append(")");
		return stringBuilder.toString();
	}
}
