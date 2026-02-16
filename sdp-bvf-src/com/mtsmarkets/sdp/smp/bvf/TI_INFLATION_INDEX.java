package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_INFLATION_INDEX extends SMPMessage
{
	public static final long CLASS_ID = 100089;

	private short IndexId = 0;
	private String Description = "";
	private long MaxIndexationDate = 0;

	public TI_INFLATION_INDEX()
	{
	}

	public short getIndexId()
	{
		return IndexId;
	}
	public void setIndexId(short value)
	{
		IndexId = value;
	}
	public String getDescription()
	{
		return Description;
	}
	public void setDescription(String value)
	{
		Description = value;
	}
	public long getMaxIndexationDate()
	{
		return MaxIndexationDate;
	}
	public void setMaxIndexationDate(long value)
	{
		MaxIndexationDate = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		IndexId = (short)byteBuffer.readInt();
		Description = byteBuffer.readString();
		MaxIndexationDate = (long)byteBuffer.readInt();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(IndexId & 0xFFFFL));
		byteBuffer.writeString(Description);
		byteBuffer.writeInt((int)(MaxIndexationDate & 0xFFFFFFFFL));

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
		stringBuilder.append("TI_INFLATION_INDEX::");
		stringBuilder.append("IndexId(").append(IndexId).append(")");
		stringBuilder.append("Description(").append(Description).append(")");
		stringBuilder.append("MaxIndexationDate(").append(MaxIndexationDate).append(")");
		return stringBuilder.toString();
	}
}
