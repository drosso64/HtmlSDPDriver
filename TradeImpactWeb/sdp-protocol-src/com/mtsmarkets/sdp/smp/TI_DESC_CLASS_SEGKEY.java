package com.mtsmarkets.sdp.smp;

import com.mtsmarkets.io.xdr.*;

public class TI_DESC_CLASS_SEGKEY extends SMPMessage implements TI_DESC_CLASS_SEGKEY_Itf {

	public static final long CLASS_ID = 100052;
	private ULong EntityID;
	private ULong KeyID;
	private ULong KeyIndex;
	private ULong KeyOffset;
	private ULong KeyType;
	private ULong KeyLen;

	public TI_DESC_CLASS_SEGKEY () throws Exception
	{
		initValues();
	}

	private void initValues() throws Exception
	{
		EntityID = new ULong(0);
		KeyID = new ULong(0);
		KeyIndex = new ULong(0);
		KeyOffset = new ULong(0);
		KeyType = new ULong(0);
		KeyLen = new ULong(0);
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
	public ULong getKeyIndex() {
		return KeyIndex;
	}
	public void setKeyIndex(ULong value) {
		KeyIndex = value;
	}
	public ULong getKeyOffset() {
		return KeyOffset;
	}
	public void setKeyOffset(ULong value) {
		KeyOffset = value;
	}
	public ULong getKeyType() {
		return KeyType;
	}
	public void setKeyType(ULong value) {
		KeyType = value;
	}
	public ULong getKeyLen() {
		return KeyLen;
	}
	public void setKeyLen(ULong value) {
		KeyLen = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		EntityID.setValue(byteBuffer.readInt());
		KeyID.setValue(byteBuffer.readInt());
		KeyIndex.setValue(byteBuffer.readInt());
		KeyOffset.setValue(byteBuffer.readInt());
		KeyType.setValue(byteBuffer.readInt());
		KeyLen.setValue(byteBuffer.readInt());
	}

	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();
		byteBuffer.writeInt((int)EntityID.getValue());
		byteBuffer.writeInt((int)KeyID.getValue());
		byteBuffer.writeInt((int)KeyIndex.getValue());
		byteBuffer.writeInt((int)KeyOffset.getValue());
		byteBuffer.writeInt((int)KeyType.getValue());
		byteBuffer.writeInt((int)KeyLen.getValue());
		return byteBuffer.position() - init;
	}

	@Override
	public String toString()
	{
		StringBuilder stringBuilder = new StringBuilder(1024);
		stringBuilder.append("TI_DESC_CLASS_SEGKEY::");
		stringBuilder.append("EntityID(").append(EntityID.getValue()).append(")");
		stringBuilder.append("KeyID(").append(KeyID.getValue()).append(")");
		stringBuilder.append("KeyIndex(").append(KeyIndex.getValue()).append(")");
		stringBuilder.append("KeyOffset(").append(KeyOffset.getValue()).append(")");
		stringBuilder.append("KeyType(").append(KeyType.getValue()).append(")");
		stringBuilder.append("KeyLen(").append(KeyLen.getValue()).append(")");
		return stringBuilder.toString();
	}

	@Override
	public long getSMPClassId() {
		return 100052;
	}
}