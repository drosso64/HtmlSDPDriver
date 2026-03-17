package com.mtsmarkets.sdp.smp;

import com.mtsmarkets.io.xdr.*;

public class TI_DESC_CLASS extends SMPMessage implements TI_DESC_CLASS_Itf {

	public static final long CLASS_ID = 100049;
	private String SourceName;
	private String EntityName;
	private ULong EntityID;
	private TI_DESC_ENTITY_TYPE_Enum EntityType;
	private ULong ClassIndx;
	private ULong ESize;
	private ULong NumFields;
	private ULong NumKeys;
	private ULong UAccess;

	public TI_DESC_CLASS () throws Exception
	{
		initValues();
	}

	private void initValues() throws Exception
	{
		SourceName = "";
		EntityName = "";
		EntityID = new ULong(0);
		EntityType = TI_DESC_ENTITY_TYPE_Enum.values()[0];
		ClassIndx = new ULong(0);
		ESize = new ULong(0);
		NumFields = new ULong(0);
		NumKeys = new ULong(0);
		UAccess = new ULong(0);
	}

        public long getClassId() {
            return CLASS_ID;
        }
	public String getSourceName() {
		return SourceName;
	}
	public void setSourceName(String value) {
		SourceName = value;
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
	public TI_DESC_ENTITY_TYPE_Enum getEntityType() {
		return EntityType;
	}
	public void setEntityType(TI_DESC_ENTITY_TYPE_Enum value) {
		EntityType = value;
	}
	public ULong getClassIndx() {
		return ClassIndx;
	}
	public void setClassIndx(ULong value) {
		ClassIndx = value;
	}
	public ULong getESize() {
		return ESize;
	}
	public void setESize(ULong value) {
		ESize = value;
	}
	public ULong getNumFields() {
		return NumFields;
	}
	public void setNumFields(ULong value) {
		NumFields = value;
	}
	public ULong getNumKeys() {
		return NumKeys;
	}
	public void setNumKeys(ULong value) {
		NumKeys = value;
	}
	public ULong getUAccess() {
		return UAccess;
	}
	public void setUAccess(ULong value) {
		UAccess = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		SourceName = byteBuffer.readString();
		EntityName = byteBuffer.readString();
		EntityID.setValue(byteBuffer.readInt());
		EntityType = EntityType.getEnum(byteBuffer.readInt());
		ClassIndx.setValue(byteBuffer.readInt());
		ESize.setValue(byteBuffer.readInt());
		NumFields.setValue(byteBuffer.readInt());
		NumKeys.setValue(byteBuffer.readInt());
		UAccess.setValue(byteBuffer.readInt());
	}

	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();
		byteBuffer.writeString(SourceName);
		byteBuffer.writeString(EntityName);
		byteBuffer.writeInt((int)EntityID.getValue());
		byteBuffer.writeInt(EntityType.getValue());
		byteBuffer.writeInt((int)ClassIndx.getValue());
		byteBuffer.writeInt((int)ESize.getValue());
		byteBuffer.writeInt((int)NumFields.getValue());
		byteBuffer.writeInt((int)NumKeys.getValue());
		byteBuffer.writeInt((int)UAccess.getValue());
		return byteBuffer.position() - init;
	}

	@Override
	public String toString()
	{
		StringBuilder stringBuilder = new StringBuilder(1024);
		stringBuilder.append("TI_DESC_CLASS::");
		stringBuilder.append("SourceName(").append(SourceName).append(")");
		stringBuilder.append("EntityName(").append(EntityName).append(")");
		stringBuilder.append("EntityID(").append(EntityID.getValue()).append(")");
		stringBuilder.append("EntityType(").append(EntityType.toString()).append(")");
		stringBuilder.append("ClassIndx(").append(ClassIndx.getValue()).append(")");
		stringBuilder.append("ESize(").append(ESize.getValue()).append(")");
		stringBuilder.append("NumFields(").append(NumFields.getValue()).append(")");
		stringBuilder.append("NumKeys(").append(NumKeys.getValue()).append(")");
		stringBuilder.append("UAccess(").append(UAccess.getValue()).append(")");
		return stringBuilder.toString();
	}

	@Override
	public long getSMPClassId() {
		return 100049;
	}
}