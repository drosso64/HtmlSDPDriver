package com.mtsmarkets.sdp.sap;

import com.mtsmarkets.io.xdr.ULong;
import com.mtsmarkets.io.xdr.XDRByteBuffer;

public class SAPSubscribeStartReq extends SAPMessage 
{
	public static final int  MSG_TYPE = 220;
	
	public enum SubscribeType
	{
		All(0),
		Stop(1),
		OnTime(2);

		SubscribeType(int value)
		{
		}
	}

	private ULong reqId = new ULong(0);
	private SubscribeType subscribeType = SubscribeType.All;
	private ULong classId = new ULong(0);
	private ULong classVer = new ULong(0);
	private ULong[] startTS = new ULong[2];
	private ULong filterKey = new ULong(0);
	private byte[] subMask = new byte[32]; 

	
	public SAPSubscribeStartReq()
	{
		super(new SAPHeader(MSG_TYPE));
		startTS[0] = new ULong(0);
		startTS[1] = new ULong(0);
		for (int i = 0; i < subMask.length; i++)
		{
			subMask[i] = 0;
		}
	}
	
	public SAPSubscribeStartReq(SAPHeader sapHeader)
	{
		super(sapHeader);
		startTS[0] = new ULong(0);
		startTS[1] = new ULong(0);
		for (int i = 0; i < subMask.length; i++)
		{
			subMask[i] = 0;
		}
	}

	public ULong getReqId() {
		return reqId;
	}

	public void setReqId(ULong reqId) {
		this.reqId = reqId;
	}

	public SubscribeType getSubscribeType() {
		return subscribeType;
	}

	public void setSubscribeType(SubscribeType subscribeType) {
		this.subscribeType = subscribeType;
	}

	public ULong getClassId() {
		return classId;
	}

	public void setClassId(ULong classId) {
		this.classId = classId;
	}

	public ULong getClassVer() {
		return classVer;
	}

	public void setClassVer(ULong classVer) {
		this.classVer = classVer;
	}

	public ULong[] getStartTS() {
		return startTS;
	}

	public void setStartTS(ULong[] startTS) {
		this.startTS = startTS;
	}

	public ULong getFilterKey() {
		return filterKey;
	}

	public void setFilterKey(ULong filterKey) {
		this.filterKey = filterKey;
	}

	public byte[] getSubMask() {
		return subMask;
	}

	public void setSubMask(byte[] subMask) {
		this.subMask = subMask;
	}

	@Override
	public void readBodyXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		reqId.setValue(byteBuffer.readInt());
		subscribeType = SubscribeType.values()[byteBuffer.readInt()];
		classId.setValue(byteBuffer.readInt());
		classVer.setValue(byteBuffer.readInt());		
		startTS[0].setValue(byteBuffer.readInt());
		startTS[1].setValue(byteBuffer.readInt());		
		filterKey.setValue(byteBuffer.readInt());		
		for (int i = 0; i < subMask.length; i++)
		{
			subMask[i] = (byte) byteBuffer.readByte();
		}	
	}

	@Override
	public int writeXDR(XDRByteBuffer byteBuff) throws Exception
	{
		int init = byteBuff.getByteBuff().position();
		// header pdu
		sapHeader.writeXDR(byteBuff);
		// body pdu
		byteBuff.writeInt((int) reqId.getValue());
		byteBuff.writeInt(subscribeType.ordinal());
		byteBuff.writeInt((int) classId.getValue());
		byteBuff.writeInt((int) classVer.getValue());
		byteBuff.writeInt((int) startTS[0].getValue());
		byteBuff.writeInt((int) startTS[1].getValue());
		byteBuff.writeInt((int) filterKey.getValue());
		for (int i = 0; i < subMask.length; i++)
		{
			byteBuff.writeByte(subMask[i]);
		}
		int end = byteBuff.getByteBuff().position();
		return end - init;
	}

	@Override
	public String toString()
	{
		StringBuilder str = new StringBuilder()
			.append("SAPSubscribeStartReq::")
			.append("MsgType(").append(getMessageType()).append(")")
			.append("ReqID(").append(reqId.getValue()).append(")")
			.append("SubscribeType(").append(subscribeType).append(")")
			.append("ClassID(").append(classId.getValue()).append(")")
			.append("ClassVer(").append(classVer.getValue()).append(")")
			.append("StartTS[0](").append(startTS[0].getValue()).append(")")
			.append("StartTS[1](").append(startTS[1].getValue()).append(")")
			.append("FilterKey(").append(filterKey.getValue()).append(")")
			.append("SubMask(").append(subMask).append(")");
		return str.toString();
	}
}

