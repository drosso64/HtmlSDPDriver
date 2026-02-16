package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_UPLOAD extends SMPMessage
{
	public static final long CLASS_ID = 100046;

	private long MarketId = 0;
	private long SectionId = 0;
	private long UploadId = 0;
	private long UploadDate = 0;
	private long UploadTime = 0;
	private long ReferenceDate = 0;
	private short BlockId = 0;
	private String UploadDescription = "";
	private long ExpiryDate = 0;
	private long UploadLen = 0;
	private short NumOfBlocks = 0;
	private short BlockLen = 0;
	private String UploadBlock = "";

	public TI_UPLOAD()
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
	public long getSectionId()
	{
		return SectionId;
	}
	public void setSectionId(long value)
	{
		SectionId = value;
	}
	public long getUploadId()
	{
		return UploadId;
	}
	public void setUploadId(long value)
	{
		UploadId = value;
	}
	public long getUploadDate()
	{
		return UploadDate;
	}
	public void setUploadDate(long value)
	{
		UploadDate = value;
	}
	public long getUploadTime()
	{
		return UploadTime;
	}
	public void setUploadTime(long value)
	{
		UploadTime = value;
	}
	public long getReferenceDate()
	{
		return ReferenceDate;
	}
	public void setReferenceDate(long value)
	{
		ReferenceDate = value;
	}
	public short getBlockId()
	{
		return BlockId;
	}
	public void setBlockId(short value)
	{
		BlockId = value;
	}
	public String getUploadDescription()
	{
		return UploadDescription;
	}
	public void setUploadDescription(String value)
	{
		UploadDescription = value;
	}
	public long getExpiryDate()
	{
		return ExpiryDate;
	}
	public void setExpiryDate(long value)
	{
		ExpiryDate = value;
	}
	public long getUploadLen()
	{
		return UploadLen;
	}
	public void setUploadLen(long value)
	{
		UploadLen = value;
	}
	public short getNumOfBlocks()
	{
		return NumOfBlocks;
	}
	public void setNumOfBlocks(short value)
	{
		NumOfBlocks = value;
	}
	public short getBlockLen()
	{
		return BlockLen;
	}
	public void setBlockLen(short value)
	{
		BlockLen = value;
	}
	public String getUploadBlock()
	{
		return UploadBlock;
	}
	public void setUploadBlock(String value)
	{
		UploadBlock = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MarketId = (long)byteBuffer.readInt();
		SectionId = (long)byteBuffer.readInt();
		UploadId = (long)byteBuffer.readInt();
		UploadDate = (long)byteBuffer.readInt();
		UploadTime = byteBuffer.readLong();
		ReferenceDate = (long)byteBuffer.readInt();
		BlockId = (short)byteBuffer.readInt();
		UploadDescription = byteBuffer.readString();
		ExpiryDate = (long)byteBuffer.readInt();
		UploadLen = (long)byteBuffer.readInt();
		NumOfBlocks = (short)byteBuffer.readInt();
		BlockLen = (short)byteBuffer.readInt();
		UploadBlock = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MarketId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SectionId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(UploadId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(UploadDate & 0xFFFFFFFFL));
		byteBuffer.writeLong(UploadTime);
		byteBuffer.writeInt((int)(ReferenceDate & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(BlockId & 0xFFFFL));
		byteBuffer.writeString(UploadDescription);
		byteBuffer.writeInt((int)(ExpiryDate & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(UploadLen & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(NumOfBlocks & 0xFFFFL));
		byteBuffer.writeInt((int)(BlockLen & 0xFFFFL));
		byteBuffer.writeString(UploadBlock);

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
		stringBuilder.append("TI_UPLOAD::");
		stringBuilder.append("MarketId(").append(MarketId).append(")");
		stringBuilder.append("SectionId(").append(SectionId).append(")");
		stringBuilder.append("UploadId(").append(UploadId).append(")");
		stringBuilder.append("UploadDate(").append(UploadDate).append(")");
		stringBuilder.append("UploadTime(").append(UploadTime).append(")");
		stringBuilder.append("ReferenceDate(").append(ReferenceDate).append(")");
		stringBuilder.append("BlockId(").append(BlockId).append(")");
		stringBuilder.append("UploadDescription(").append(UploadDescription).append(")");
		stringBuilder.append("ExpiryDate(").append(ExpiryDate).append(")");
		stringBuilder.append("UploadLen(").append(UploadLen).append(")");
		stringBuilder.append("NumOfBlocks(").append(NumOfBlocks).append(")");
		stringBuilder.append("BlockLen(").append(BlockLen).append(")");
		stringBuilder.append("UploadBlock(").append(UploadBlock).append(")");
		return stringBuilder.toString();
	}
}
