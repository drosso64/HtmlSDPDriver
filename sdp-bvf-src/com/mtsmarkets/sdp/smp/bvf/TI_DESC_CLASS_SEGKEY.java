package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_DESC_CLASS_SEGKEY extends SMPMessage
{
	public static final long CLASS_ID = 100052;

	private long EntityID = 0;
	private long KeyID = 0;
	private long KeyIndex = 0;
	private long KeyOffset = 0;
	private long KeyType = 0;
	private long KeyLen = 0;

	public TI_DESC_CLASS_SEGKEY()
	{
	}

	public long getEntityID()
	{
		return EntityID;
	}
	public void setEntityID(long value)
	{
		EntityID = value;
	}
	public long getKeyID()
	{
		return KeyID;
	}
	public void setKeyID(long value)
	{
		KeyID = value;
	}
	public long getKeyIndex()
	{
		return KeyIndex;
	}
	public void setKeyIndex(long value)
	{
		KeyIndex = value;
	}
	public long getKeyOffset()
	{
		return KeyOffset;
	}
	public void setKeyOffset(long value)
	{
		KeyOffset = value;
	}
	public long getKeyType()
	{
		return KeyType;
	}
	public void setKeyType(long value)
	{
		KeyType = value;
	}
	public long getKeyLen()
	{
		return KeyLen;
	}
	public void setKeyLen(long value)
	{
		KeyLen = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		EntityID = (long)byteBuffer.readInt();
		KeyID = (long)byteBuffer.readInt();
		KeyIndex = (long)byteBuffer.readInt();
		KeyOffset = (long)byteBuffer.readInt();
		KeyType = (long)byteBuffer.readInt();
		KeyLen = (long)byteBuffer.readInt();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(EntityID & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(KeyID & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(KeyIndex & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(KeyOffset & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(KeyType & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(KeyLen & 0xFFFFFFFFL));

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
		stringBuilder.append("TI_DESC_CLASS_SEGKEY::");
		stringBuilder.append("EntityID(").append(EntityID).append(")");
		stringBuilder.append("KeyID(").append(KeyID).append(")");
		stringBuilder.append("KeyIndex(").append(KeyIndex).append(")");
		stringBuilder.append("KeyOffset(").append(KeyOffset).append(")");
		stringBuilder.append("KeyType(").append(KeyType).append(")");
		stringBuilder.append("KeyLen(").append(KeyLen).append(")");
		return stringBuilder.toString();
	}
}
