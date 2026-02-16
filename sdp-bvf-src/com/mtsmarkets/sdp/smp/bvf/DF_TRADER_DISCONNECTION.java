package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class DF_TRADER_DISCONNECTION extends SMPMessage
{
	public static final long CLASS_ID = 170003;

	private long MemberId = 0;
	private long TraderId = 0;
	private long DiscNo = 0;
	private long DiscTime = 0;
	private long FirstConnection = 0;
	private long LastConnection = 0;
	private long LastDisconnection = 0;
	private DF_TRADER_CONNEC_STATUS_Enum Status = DF_TRADER_CONNEC_STATUS_Enum.DF_TRADER_CONNEC_STATUS_LogOn;

	public DF_TRADER_DISCONNECTION()
	{
	}

	public long getMemberId()
	{
		return MemberId;
	}
	public void setMemberId(long value)
	{
		MemberId = value;
	}
	public long getTraderId()
	{
		return TraderId;
	}
	public void setTraderId(long value)
	{
		TraderId = value;
	}
	public long getDiscNo()
	{
		return DiscNo;
	}
	public void setDiscNo(long value)
	{
		DiscNo = value;
	}
	public long getDiscTime()
	{
		return DiscTime;
	}
	public void setDiscTime(long value)
	{
		DiscTime = value;
	}
	public long getFirstConnection()
	{
		return FirstConnection;
	}
	public void setFirstConnection(long value)
	{
		FirstConnection = value;
	}
	public long getLastConnection()
	{
		return LastConnection;
	}
	public void setLastConnection(long value)
	{
		LastConnection = value;
	}
	public long getLastDisconnection()
	{
		return LastDisconnection;
	}
	public void setLastDisconnection(long value)
	{
		LastDisconnection = value;
	}
	public DF_TRADER_CONNEC_STATUS_Enum getStatus()
	{
		return Status;
	}
	public void setStatus(DF_TRADER_CONNEC_STATUS_Enum value)
	{
		Status = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MemberId = (long)byteBuffer.readInt();
		TraderId = (long)byteBuffer.readInt();
		DiscNo = (long)byteBuffer.readInt();
		DiscTime = byteBuffer.readLong();
		FirstConnection = byteBuffer.readLong();
		LastConnection = byteBuffer.readLong();
		LastDisconnection = byteBuffer.readLong();
		Status = Status.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(TraderId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(DiscNo & 0xFFFFFFFFL));
		byteBuffer.writeLong(DiscTime);
		byteBuffer.writeLong(FirstConnection);
		byteBuffer.writeLong(LastConnection);
		byteBuffer.writeLong(LastDisconnection);
		byteBuffer.writeInt(Status.getValue());

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
		stringBuilder.append("DF_TRADER_DISCONNECTION::");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("TraderId(").append(TraderId).append(")");
		stringBuilder.append("DiscNo(").append(DiscNo).append(")");
		stringBuilder.append("DiscTime(").append(DiscTime).append(")");
		stringBuilder.append("FirstConnection(").append(FirstConnection).append(")");
		stringBuilder.append("LastConnection(").append(LastConnection).append(")");
		stringBuilder.append("LastDisconnection(").append(LastDisconnection).append(")");
		stringBuilder.append("Status(").append(Status).append(")");
		return stringBuilder.toString();
	}
}
