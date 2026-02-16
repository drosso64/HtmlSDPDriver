package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_CANCEL_RFCQ extends SMPMessage
{
	public static final long CLASS_ID = 100810;

	private long RfcqReqId = 0;
	private long MarketId = 0;
	private long CancelDate = 0;
	private long CancelTime = 0;

	public TI_CANCEL_RFCQ()
	{
	}

	public long getRfcqReqId()
	{
		return RfcqReqId;
	}
	public void setRfcqReqId(long value)
	{
		RfcqReqId = value;
	}
	public long getMarketId()
	{
		return MarketId;
	}
	public void setMarketId(long value)
	{
		MarketId = value;
	}
	public long getCancelDate()
	{
		return CancelDate;
	}
	public void setCancelDate(long value)
	{
		CancelDate = value;
	}
	public long getCancelTime()
	{
		return CancelTime;
	}
	public void setCancelTime(long value)
	{
		CancelTime = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		RfcqReqId = (long)byteBuffer.readInt();
		MarketId = (long)byteBuffer.readInt();
		CancelDate = (long)byteBuffer.readInt();
		CancelTime = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(RfcqReqId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(MarketId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(CancelDate & 0xFFFFFFFFL));
		byteBuffer.writeLong(CancelTime);

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
		stringBuilder.append("TI_CANCEL_RFCQ::");
		stringBuilder.append("RfcqReqId(").append(RfcqReqId).append(")");
		stringBuilder.append("MarketId(").append(MarketId).append(")");
		stringBuilder.append("CancelDate(").append(CancelDate).append(")");
		stringBuilder.append("CancelTime(").append(CancelTime).append(")");
		return stringBuilder.toString();
	}
}
