package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_FIX_SESSION_STATISTIC extends SMPMessage
{
	public static final long CLASS_ID = 100840;

	private long SessionId = 0;
	private long RXSequenceNumber = 0;
	private long TXSequenceNumber = 0;
	private long NumLogonSuccess = 0;
	private long NumLogonFail = 0;
	private long NumSessionErrors = 0;
	private long TXNumMessageRejected = 0;
	private long RXNumMessageRejected = 0;
	private long TXNumMessageResend = 0;
	private long RXNumMessageResend = 0;
	private long TXNumTestRequest = 0;
	private long RXNumTestRequest = 0;
	private long UpdateTime = 0;

	public TI_FIX_SESSION_STATISTIC()
	{
	}

	public long getSessionId()
	{
		return SessionId;
	}
	public void setSessionId(long value)
	{
		SessionId = value;
	}
	public long getRXSequenceNumber()
	{
		return RXSequenceNumber;
	}
	public void setRXSequenceNumber(long value)
	{
		RXSequenceNumber = value;
	}
	public long getTXSequenceNumber()
	{
		return TXSequenceNumber;
	}
	public void setTXSequenceNumber(long value)
	{
		TXSequenceNumber = value;
	}
	public long getNumLogonSuccess()
	{
		return NumLogonSuccess;
	}
	public void setNumLogonSuccess(long value)
	{
		NumLogonSuccess = value;
	}
	public long getNumLogonFail()
	{
		return NumLogonFail;
	}
	public void setNumLogonFail(long value)
	{
		NumLogonFail = value;
	}
	public long getNumSessionErrors()
	{
		return NumSessionErrors;
	}
	public void setNumSessionErrors(long value)
	{
		NumSessionErrors = value;
	}
	public long getTXNumMessageRejected()
	{
		return TXNumMessageRejected;
	}
	public void setTXNumMessageRejected(long value)
	{
		TXNumMessageRejected = value;
	}
	public long getRXNumMessageRejected()
	{
		return RXNumMessageRejected;
	}
	public void setRXNumMessageRejected(long value)
	{
		RXNumMessageRejected = value;
	}
	public long getTXNumMessageResend()
	{
		return TXNumMessageResend;
	}
	public void setTXNumMessageResend(long value)
	{
		TXNumMessageResend = value;
	}
	public long getRXNumMessageResend()
	{
		return RXNumMessageResend;
	}
	public void setRXNumMessageResend(long value)
	{
		RXNumMessageResend = value;
	}
	public long getTXNumTestRequest()
	{
		return TXNumTestRequest;
	}
	public void setTXNumTestRequest(long value)
	{
		TXNumTestRequest = value;
	}
	public long getRXNumTestRequest()
	{
		return RXNumTestRequest;
	}
	public void setRXNumTestRequest(long value)
	{
		RXNumTestRequest = value;
	}
	public long getUpdateTime()
	{
		return UpdateTime;
	}
	public void setUpdateTime(long value)
	{
		UpdateTime = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		SessionId = (long)byteBuffer.readInt();
		RXSequenceNumber = (long)byteBuffer.readInt();
		TXSequenceNumber = (long)byteBuffer.readInt();
		NumLogonSuccess = (long)byteBuffer.readInt();
		NumLogonFail = (long)byteBuffer.readInt();
		NumSessionErrors = (long)byteBuffer.readInt();
		TXNumMessageRejected = (long)byteBuffer.readInt();
		RXNumMessageRejected = (long)byteBuffer.readInt();
		TXNumMessageResend = (long)byteBuffer.readInt();
		RXNumMessageResend = (long)byteBuffer.readInt();
		TXNumTestRequest = (long)byteBuffer.readInt();
		RXNumTestRequest = (long)byteBuffer.readInt();
		UpdateTime = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(SessionId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(RXSequenceNumber & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(TXSequenceNumber & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(NumLogonSuccess & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(NumLogonFail & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(NumSessionErrors & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(TXNumMessageRejected & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(RXNumMessageRejected & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(TXNumMessageResend & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(RXNumMessageResend & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(TXNumTestRequest & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(RXNumTestRequest & 0xFFFFFFFFL));
		byteBuffer.writeLong(UpdateTime);

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
		stringBuilder.append("TI_FIX_SESSION_STATISTIC::");
		stringBuilder.append("SessionId(").append(SessionId).append(")");
		stringBuilder.append("RXSequenceNumber(").append(RXSequenceNumber).append(")");
		stringBuilder.append("TXSequenceNumber(").append(TXSequenceNumber).append(")");
		stringBuilder.append("NumLogonSuccess(").append(NumLogonSuccess).append(")");
		stringBuilder.append("NumLogonFail(").append(NumLogonFail).append(")");
		stringBuilder.append("NumSessionErrors(").append(NumSessionErrors).append(")");
		stringBuilder.append("TXNumMessageRejected(").append(TXNumMessageRejected).append(")");
		stringBuilder.append("RXNumMessageRejected(").append(RXNumMessageRejected).append(")");
		stringBuilder.append("TXNumMessageResend(").append(TXNumMessageResend).append(")");
		stringBuilder.append("RXNumMessageResend(").append(RXNumMessageResend).append(")");
		stringBuilder.append("TXNumTestRequest(").append(TXNumTestRequest).append(")");
		stringBuilder.append("RXNumTestRequest(").append(RXNumTestRequest).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		return stringBuilder.toString();
	}
}
