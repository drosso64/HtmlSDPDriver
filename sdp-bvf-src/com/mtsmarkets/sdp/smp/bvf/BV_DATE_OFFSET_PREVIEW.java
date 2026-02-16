package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_DATE_OFFSET_PREVIEW extends SMPMessage
{
	public static final long CLASS_ID = 114291;

	private long DateOffsetPreviewId = 0;
	private long InstrumentId = 0;
	private short SettlementOffset = 0;
	private long SettlementDate = 0;
	private String UserData = "";

	public BV_DATE_OFFSET_PREVIEW()
	{
	}

	public long getDateOffsetPreviewId()
	{
		return DateOffsetPreviewId;
	}
	public void setDateOffsetPreviewId(long value)
	{
		DateOffsetPreviewId = value;
	}
	public long getInstrumentId()
	{
		return InstrumentId;
	}
	public void setInstrumentId(long value)
	{
		InstrumentId = value;
	}
	public short getSettlementOffset()
	{
		return SettlementOffset;
	}
	public void setSettlementOffset(short value)
	{
		SettlementOffset = value;
	}
	public long getSettlementDate()
	{
		return SettlementDate;
	}
	public void setSettlementDate(long value)
	{
		SettlementDate = value;
	}
	public String getUserData()
	{
		return UserData;
	}
	public void setUserData(String value)
	{
		UserData = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		DateOffsetPreviewId = (long)byteBuffer.readInt();
		InstrumentId = (long)byteBuffer.readInt();
		SettlementOffset = (short)byteBuffer.readInt();
		SettlementDate = (long)byteBuffer.readInt();
		UserData = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(DateOffsetPreviewId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(InstrumentId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SettlementOffset & 0xFFFFL));
		byteBuffer.writeInt((int)(SettlementDate & 0xFFFFFFFFL));
		byteBuffer.writeString(UserData);

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
		stringBuilder.append("BV_DATE_OFFSET_PREVIEW::");
		stringBuilder.append("DateOffsetPreviewId(").append(DateOffsetPreviewId).append(")");
		stringBuilder.append("InstrumentId(").append(InstrumentId).append(")");
		stringBuilder.append("SettlementOffset(").append(SettlementOffset).append(")");
		stringBuilder.append("SettlementDate(").append(SettlementDate).append(")");
		stringBuilder.append("UserData(").append(UserData).append(")");
		return stringBuilder.toString();
	}
}
