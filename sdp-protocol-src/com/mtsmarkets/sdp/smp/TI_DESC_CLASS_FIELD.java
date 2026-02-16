package com.mtsmarkets.sdp.smp;

import com.mtsmarkets.io.xdr.*;

public class TI_DESC_CLASS_FIELD extends SMPMessage implements TI_DESC_CLASS_FIELD_Itf {

	public static final long CLASS_ID = 100050;
	private String EntityName;
	private ULong EntityID;
	private ULong FieldIndx;
	private String FieldName;
	private String FieldType;
	private short Derived;
	private TI_DESC_FIELD_TYPE_Enum Ptype;
	private ULong Offset;
	private ULong Len;
	private ULong NumElems;

	public TI_DESC_CLASS_FIELD () throws Exception
	{
		initValues();
	}

	private void initValues() throws Exception
	{
		EntityName = "";
		EntityID = new ULong(0);
		FieldIndx = new ULong(0);
		FieldName = "";
		FieldType = "";
		Derived = 0;
		Ptype = TI_DESC_FIELD_TYPE_Enum.values()[0];
		Offset = new ULong(0);
		Len = new ULong(0);
		NumElems = new ULong(0);
	}

	public String getEntityName() {
		return EntityName;
	}
	public void setEntityName(String value) {
		EntityName = value;
	}
	public ULong getEntityID() {
		return EntityID;
	}
	public void setEntityID(ULong value) {
		EntityID = value;
	}
	public ULong getFieldIndx() {
		return FieldIndx;
	}
	public void setFieldIndx(ULong value) {
		FieldIndx = value;
	}
	public String getFieldName() {
		return FieldName;
	}
	public void setFieldName(String value) {
		FieldName = value;
	}
	public String getFieldType() {
		return FieldType;
	}
	public void setFieldType(String value) {
		FieldType = value;
	}
	public short getDerived() {
		return Derived;
	}
	public void setDerived(short value) {
		Derived = value;
	}
	public TI_DESC_FIELD_TYPE_Enum getPtype() {
		return Ptype;
	}
	public void setPtype(TI_DESC_FIELD_TYPE_Enum value) {
		Ptype = value;
	}
	public ULong getOffset() {
		return Offset;
	}
	public void setOffset(ULong value) {
		Offset = value;
	}
	public ULong getLen() {
		return Len;
	}
	public void setLen(ULong value) {
		Len = value;
	}
	public ULong getNumElems() {
		return NumElems;
	}
	public void setNumElems(ULong value) {
		NumElems = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		EntityName = byteBuffer.readString();
		EntityID.setValue(byteBuffer.readInt());
		FieldIndx.setValue(byteBuffer.readInt());
		FieldName = byteBuffer.readString();
		FieldType = byteBuffer.readString();
		Derived = (short)byteBuffer.readInt();
		Ptype = Ptype.getEnum(byteBuffer.readInt());
		Offset.setValue(byteBuffer.readInt());
		Len.setValue(byteBuffer.readInt());
		NumElems.setValue(byteBuffer.readInt());
	}

	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();
		byteBuffer.writeString(EntityName);
		byteBuffer.writeInt((int)EntityID.getValue());
		byteBuffer.writeInt((int)FieldIndx.getValue());
		byteBuffer.writeString(FieldName);
		byteBuffer.writeString(FieldType);
		byteBuffer.writeInt((short)Derived);
		byteBuffer.writeInt(Ptype.getValue());
		byteBuffer.writeInt((int)Offset.getValue());
		byteBuffer.writeInt((int)Len.getValue());
		byteBuffer.writeInt((int)NumElems.getValue());
		return byteBuffer.position() - init;
	}

	@Override
	public String toString()
	{
		StringBuilder stringBuilder = new StringBuilder(1024);
		stringBuilder.append("TI_DESC_CLASS_FIELD::");
		stringBuilder.append("EntityName(").append(EntityName).append(")");
		stringBuilder.append("EntityID(").append(EntityID.getValue()).append(")");
		stringBuilder.append("FieldIndx(").append(FieldIndx.getValue()).append(")");
		stringBuilder.append("FieldName(").append(FieldName).append(")");
		stringBuilder.append("FieldType(").append(FieldType).append(")");
		stringBuilder.append("Derived(").append(Derived);
		stringBuilder.append("Ptype(").append(Ptype.toString()).append(")");
		stringBuilder.append("Offset(").append(Offset.getValue()).append(")");
		stringBuilder.append("Len(").append(Len.getValue()).append(")");
		stringBuilder.append("NumElems(").append(NumElems.getValue()).append(")");
		return stringBuilder.toString();
	}

	@Override
	public long getSMPClassId() {
		return 100050;
	}
}