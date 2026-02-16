package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_DESC_CLASS_KEY extends SMPMessage
{
	public static final long CLASS_ID = 100051;

	private long EntityID = 0;
	private long KeyID = 0;
	private long KeyIndx = 0;
	private String KeyName = "";
	private long KeySize = 0;
	private TI_DESC_KEY_TYPE_Enum KeyType = TI_DESC_KEY_TYPE_Enum.TI_DESC_KEY_TYPE_DuplicateKey;
	private long NumSegs = 0;

	public TI_DESC_CLASS_KEY()
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
	public long getKeyIndx()
	{
		return KeyIndx;
	}
	public void setKeyIndx(long value)
	{
		KeyIndx = value;
	}
	public String getKeyName()
	{
		return KeyName;
	}
	public void setKeyName(String value)
	{
		KeyName = value;
	}
	public long getKeySize()
	{
		return KeySize;
	}
	public void setKeySize(long value)
	{
		KeySize = value;
	}
	public TI_DESC_KEY_TYPE_Enum getKeyType()
	{
		return KeyType;
	}
	public void setKeyType(TI_DESC_KEY_TYPE_Enum value)
	{
		KeyType = value;
	}
	public long getNumSegs()
	{
		return NumSegs;
	}
	public void setNumSegs(long value)
	{
		NumSegs = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		EntityID = (long)byteBuffer.readInt();
		KeyID = (long)byteBuffer.readInt();
		KeyIndx = (long)byteBuffer.readInt();
		KeyName = byteBuffer.readString();
		KeySize = (long)byteBuffer.readInt();
		KeyType = KeyType.getEnum(byteBuffer.readInt());
		NumSegs = (long)byteBuffer.readInt();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(EntityID & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(KeyID & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(KeyIndx & 0xFFFFFFFFL));
		byteBuffer.writeString(KeyName);
		byteBuffer.writeInt((int)(KeySize & 0xFFFFFFFFL));
		byteBuffer.writeInt(KeyType.getValue());
		byteBuffer.writeInt((int)(NumSegs & 0xFFFFFFFFL));

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
		stringBuilder.append("TI_DESC_CLASS_KEY::");
		stringBuilder.append("EntityID(").append(EntityID).append(")");
		stringBuilder.append("KeyID(").append(KeyID).append(")");
		stringBuilder.append("KeyIndx(").append(KeyIndx).append(")");
		stringBuilder.append("KeyName(").append(KeyName).append(")");
		stringBuilder.append("KeySize(").append(KeySize).append(")");
		stringBuilder.append("KeyType(").append(KeyType).append(")");
		stringBuilder.append("NumSegs(").append(NumSegs).append(")");
		return stringBuilder.toString();
	}
}
