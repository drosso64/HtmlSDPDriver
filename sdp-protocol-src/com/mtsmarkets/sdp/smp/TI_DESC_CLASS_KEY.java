package com.mtsmarkets.sdp.smp;

import com.mtsmarkets.io.xdr.*;

public class TI_DESC_CLASS_KEY extends SMPMessage implements TI_DESC_CLASS_KEY_Itf {

	public static final long CLASS_ID = 100051;
	private ULong EntityID;
	private ULong KeyID;
	private ULong KeyIndx;
	private String KeyName;
	private ULong KeySize;
	private TI_DESC_KEY_TYPE_Enum KeyType;
	private ULong NumSegs;

	public TI_DESC_CLASS_KEY () throws Exception
	{
		initValues();
	}

	private void initValues() throws Exception
	{
		EntityID = new ULong(0);
		KeyID = new ULong(0);
		KeyIndx = new ULong(0);
		KeyName = "";
		KeySize = new ULong(0);
		KeyType = TI_DESC_KEY_TYPE_Enum.values()[0];
		NumSegs = new ULong(0);
	}

	public ULong getEntityID() {
		return EntityID;
	}
	public void setEntityID(ULong value) {
		EntityID = value;
	}
	public ULong getKeyID() {
		return KeyID;
	}
	public void setKeyID(ULong value) {
		KeyID = value;
	}
	public ULong getKeyIndx() {
		return KeyIndx;
	}
	public void setKeyIndx(ULong value) {
		KeyIndx = value;
	}
	public String getKeyName() {
		return KeyName;
	}
	public void setKeyName(String value) {
		KeyName = value;
	}
	public ULong getKeySize() {
		return KeySize;
	}
	public void setKeySize(ULong value) {
		KeySize = value;
	}
	public TI_DESC_KEY_TYPE_Enum getKeyType() {
		return KeyType;
	}
	public void setKeyType(TI_DESC_KEY_TYPE_Enum value) {
		KeyType = value;
	}
	public ULong getNumSegs() {
		return NumSegs;
	}
	public void setNumSegs(ULong value) {
		NumSegs = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		EntityID.setValue(byteBuffer.readInt());
		KeyID.setValue(byteBuffer.readInt());
		KeyIndx.setValue(byteBuffer.readInt());
		KeyName = byteBuffer.readString();
		KeySize.setValue(byteBuffer.readInt());
		KeyType = KeyType.getEnum(byteBuffer.readInt());
		NumSegs.setValue(byteBuffer.readInt());
	}

	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();
		byteBuffer.writeInt((int)EntityID.getValue());
		byteBuffer.writeInt((int)KeyID.getValue());
		byteBuffer.writeInt((int)KeyIndx.getValue());
		byteBuffer.writeString(KeyName);
		byteBuffer.writeInt((int)KeySize.getValue());
		byteBuffer.writeInt(KeyType.getValue());
		byteBuffer.writeInt((int)NumSegs.getValue());
		return byteBuffer.position() - init;
	}

	@Override
	public String toString()
	{
		StringBuilder stringBuilder = new StringBuilder(1024);
		stringBuilder.append("TI_DESC_CLASS_KEY::");
		stringBuilder.append("EntityID(").append(EntityID.getValue()).append(")");
		stringBuilder.append("KeyID(").append(KeyID.getValue()).append(")");
		stringBuilder.append("KeyIndx(").append(KeyIndx.getValue()).append(")");
		stringBuilder.append("KeyName(").append(KeyName).append(")");
		stringBuilder.append("KeySize(").append(KeySize.getValue()).append(")");
		stringBuilder.append("KeyType(").append(KeyType.toString()).append(")");
		stringBuilder.append("NumSegs(").append(NumSegs.getValue()).append(")");
		return stringBuilder.toString();
	}

	@Override
	public long getSMPClassId() {
		return 100051;
	}
}