package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_DESC_CLASS_FIELD extends SMPMessage
{
	public static final long CLASS_ID = 100050;

	private String EntityName = "";
	private long EntityID = 0;
	private long FieldIndx = 0;
	private String FieldName = "";
	private String FieldType = "";
	private short Derived = 0;
	private TI_DESC_FIELD_TYPE_Enum Ptype = TI_DESC_FIELD_TYPE_Enum.TI_DESC_FIELD_TYPE_TypeNONE;
	private long Offset = 0;
	private long Len = 0;
	private long NumElems = 0;

	public TI_DESC_CLASS_FIELD()
	{
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
	public long getFieldIndx()
	{
		return FieldIndx;
	}
	public void setFieldIndx(long value)
	{
		FieldIndx = value;
	}
	public String getFieldName()
	{
		return FieldName;
	}
	public void setFieldName(String value)
	{
		FieldName = value;
	}
	public String getFieldType()
	{
		return FieldType;
	}
	public void setFieldType(String value)
	{
		FieldType = value;
	}
	public short getDerived()
	{
		return Derived;
	}
	public void setDerived(short value)
	{
		Derived = value;
	}
	public TI_DESC_FIELD_TYPE_Enum getPtype()
	{
		return Ptype;
	}
	public void setPtype(TI_DESC_FIELD_TYPE_Enum value)
	{
		Ptype = value;
	}
	public long getOffset()
	{
		return Offset;
	}
	public void setOffset(long value)
	{
		Offset = value;
	}
	public long getLen()
	{
		return Len;
	}
	public void setLen(long value)
	{
		Len = value;
	}
	public long getNumElems()
	{
		return NumElems;
	}
	public void setNumElems(long value)
	{
		NumElems = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		EntityName = byteBuffer.readString();
		EntityID = (long)byteBuffer.readInt();
		FieldIndx = (long)byteBuffer.readInt();
		FieldName = byteBuffer.readString();
		FieldType = byteBuffer.readString();
		Derived = (short)byteBuffer.readInt();
		Ptype = Ptype.getEnum(byteBuffer.readInt());
		Offset = (long)byteBuffer.readInt();
		Len = (long)byteBuffer.readInt();
		NumElems = (long)byteBuffer.readInt();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeString(EntityName);
		byteBuffer.writeInt((int)(EntityID & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(FieldIndx & 0xFFFFFFFFL));
		byteBuffer.writeString(FieldName);
		byteBuffer.writeString(FieldType);
		byteBuffer.writeInt((int)(Derived & 0xFFFFL));
		byteBuffer.writeInt(Ptype.getValue());
		byteBuffer.writeInt((int)(Offset & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(Len & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(NumElems & 0xFFFFFFFFL));

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
		stringBuilder.append("TI_DESC_CLASS_FIELD::");
		stringBuilder.append("EntityName(").append(EntityName).append(")");
		stringBuilder.append("EntityID(").append(EntityID).append(")");
		stringBuilder.append("FieldIndx(").append(FieldIndx).append(")");
		stringBuilder.append("FieldName(").append(FieldName).append(")");
		stringBuilder.append("FieldType(").append(FieldType).append(")");
		stringBuilder.append("Derived(").append(Derived).append(")");
		stringBuilder.append("Ptype(").append(Ptype).append(")");
		stringBuilder.append("Offset(").append(Offset).append(")");
		stringBuilder.append("Len(").append(Len).append(")");
		stringBuilder.append("NumElems(").append(NumElems).append(")");
		return stringBuilder.toString();
	}
}
