package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_REQUEST_OP extends SMPMessage
{
	public static final long CLASS_ID = 100806;

	private long MarketID = 0;
	private long SectionId = 0;
	private long InstrumentClassId = 0;
	private TI_FLAG_Enum Preview = TI_FLAG_Enum.TI_FLAG_No;
	private short AreaCodeId = 0;

	public TI_REQUEST_OP()
	{
	}

	public long getMarketID()
	{
		return MarketID;
	}
	public void setMarketID(long value)
	{
		MarketID = value;
	}
	public long getSectionId()
	{
		return SectionId;
	}
	public void setSectionId(long value)
	{
		SectionId = value;
	}
	public long getInstrumentClassId()
	{
		return InstrumentClassId;
	}
	public void setInstrumentClassId(long value)
	{
		InstrumentClassId = value;
	}
	public TI_FLAG_Enum getPreview()
	{
		return Preview;
	}
	public void setPreview(TI_FLAG_Enum value)
	{
		Preview = value;
	}
	public short getAreaCodeId()
	{
		return AreaCodeId;
	}
	public void setAreaCodeId(short value)
	{
		AreaCodeId = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MarketID = (long)byteBuffer.readInt();
		SectionId = (long)byteBuffer.readInt();
		InstrumentClassId = (long)byteBuffer.readInt();
		Preview = Preview.getEnum(byteBuffer.readInt());
		AreaCodeId = (short)byteBuffer.readInt();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MarketID & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SectionId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(InstrumentClassId & 0xFFFFFFFFL));
		byteBuffer.writeInt(Preview.getValue());
		byteBuffer.writeInt((int)(AreaCodeId & 0xFFFFL));

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
		stringBuilder.append("TI_REQUEST_OP::");
		stringBuilder.append("MarketID(").append(MarketID).append(")");
		stringBuilder.append("SectionId(").append(SectionId).append(")");
		stringBuilder.append("InstrumentClassId(").append(InstrumentClassId).append(")");
		stringBuilder.append("Preview(").append(Preview).append(")");
		stringBuilder.append("AreaCodeId(").append(AreaCodeId).append(")");
		return stringBuilder.toString();
	}
}
