package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_DESC_CLASS extends SMPMessage
{
	public static final long CLASS_ID = 100049;

	private String SourceName = "";
	private String EntityName = "";
	private long EntityID = 0;
	private TI_DESC_ENTITY_TYPE_Enum EntityType = TI_DESC_ENTITY_TYPE_Enum.TI_DESC_ENTITY_TYPE_NoType;
	private long ClassIndx = 0;
	private long ESize = 0;
	private long NumFields = 0;
	private long NumKeys = 0;
	private long UAccess = 0;

	public TI_DESC_CLASS()
	{
	}

	public String getSourceName()
	{
		return SourceName;
	}
	public void setSourceName(String value)
	{
		SourceName = value;
	}
	public String getEntityName()
	{
		return EntityName;
	}
	public void setEntityName(String value)
	{
		EntityName = value;
	}
	public long getEntityID()
	{
		return EntityID;
	}
	public void setEntityID(long value)
	{
		EntityID = value;
	}
	public TI_DESC_ENTITY_TYPE_Enum getEntityType()
	{
		return EntityType;
	}
	public void setEntityType(TI_DESC_ENTITY_TYPE_Enum value)
	{
		EntityType = value;
	}
	public long getClassIndx()
	{
		return ClassIndx;
	}
	public void setClassIndx(long value)
	{
		ClassIndx = value;
	}
	public long getESize()
	{
		return ESize;
	}
	public void setESize(long value)
	{
		ESize = value;
	}
	public long getNumFields()
	{
		return NumFields;
	}
	public void setNumFields(long value)
	{
		NumFields = value;
	}
	public long getNumKeys()
	{
		return NumKeys;
	}
	public void setNumKeys(long value)
	{
		NumKeys = value;
	}
	public long getUAccess()
	{
		return UAccess;
	}
	public void setUAccess(long value)
	{
		UAccess = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		SourceName = byteBuffer.readString();
		EntityName = byteBuffer.readString();
		EntityID = (long)byteBuffer.readInt();
		EntityType = EntityType.getEnum(byteBuffer.readInt());
		ClassIndx = (long)byteBuffer.readInt();
		ESize = (long)byteBuffer.readInt();
		NumFields = (long)byteBuffer.readInt();
		NumKeys = (long)byteBuffer.readInt();
		UAccess = (long)byteBuffer.readInt();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeString(SourceName);
		byteBuffer.writeString(EntityName);
		byteBuffer.writeInt((int)(EntityID & 0xFFFFFFFFL));
		byteBuffer.writeInt(EntityType.getValue());
		byteBuffer.writeInt((int)(ClassIndx & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(ESize & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(NumFields & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(NumKeys & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(UAccess & 0xFFFFFFFFL));

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
		stringBuilder.append("TI_DESC_CLASS::");
		stringBuilder.append("SourceName(").append(SourceName).append(")");
		stringBuilder.append("EntityName(").append(EntityName).append(")");
		stringBuilder.append("EntityID(").append(EntityID).append(")");
		stringBuilder.append("EntityType(").append(EntityType).append(")");
		stringBuilder.append("ClassIndx(").append(ClassIndx).append(")");
		stringBuilder.append("ESize(").append(ESize).append(")");
		stringBuilder.append("NumFields(").append(NumFields).append(")");
		stringBuilder.append("NumKeys(").append(NumKeys).append(")");
		stringBuilder.append("UAccess(").append(UAccess).append(")");
		return stringBuilder.toString();
	}
}
