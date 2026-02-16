package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_CANCEL_PORTFOLIO_RFCQ extends SMPMessage
{
	public static final long CLASS_ID = 115012;

	private long RfcqReqId = 0;
	private long AggressorMemberId = 0;
	private long CancelDate = 0;
	private long CancelTime = 0;

	public BV_CANCEL_PORTFOLIO_RFCQ()
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
	public long getAggressorMemberId()
	{
		return AggressorMemberId;
	}
	public void setAggressorMemberId(long value)
	{
		AggressorMemberId = value;
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
		AggressorMemberId = (long)byteBuffer.readInt();
		CancelDate = (long)byteBuffer.readInt();
		CancelTime = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(RfcqReqId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(AggressorMemberId & 0xFFFFFFFFL));
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
		stringBuilder.append("BV_CANCEL_PORTFOLIO_RFCQ::");
		stringBuilder.append("RfcqReqId(").append(RfcqReqId).append(")");
		stringBuilder.append("AggressorMemberId(").append(AggressorMemberId).append(")");
		stringBuilder.append("CancelDate(").append(CancelDate).append(")");
		stringBuilder.append("CancelTime(").append(CancelTime).append(")");
		return stringBuilder.toString();
	}
}
