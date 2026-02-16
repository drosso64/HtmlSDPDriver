package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_MSG_INFO extends SMPMessage
{
	public static final long CLASS_ID = 100900;

	private long MsgId = 0;
	private String MsgInfo = "";
	private TI_TIME_ZONE TimeZone = new TI_TIME_ZONE();
	private long MarketId = 0;
	private long SectionId = 0;
	private long MsgDate = 0;
	private long MsgTime = 0;

	public TI_MSG_INFO()
	{
	}

	public long getMsgId()
	{
		return MsgId;
	}
	public void setMsgId(long value)
	{
		MsgId = value;
	}
	public String getMsgInfo()
	{
		return MsgInfo;
	}
	public void setMsgInfo(String value)
	{
		MsgInfo = value;
	}
	public TI_TIME_ZONE getTimeZone()
	{
		return TimeZone;
	}
	public void setTimeZone(TI_TIME_ZONE value)
	{
		TimeZone = value;
	}
	public long getMarketId()
	{
		return MarketId;
	}
	public void setMarketId(long value)
	{
		MarketId = value;
	}
	public long getSectionId()
	{
		return SectionId;
	}
	public void setSectionId(long value)
	{
		SectionId = value;
	}
	public long getMsgDate()
	{
		return MsgDate;
	}
	public void setMsgDate(long value)
	{
		MsgDate = value;
	}
	public long getMsgTime()
	{
		return MsgTime;
	}
	public void setMsgTime(long value)
	{
		MsgTime = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MsgId = (long)byteBuffer.readInt();
		MsgInfo = byteBuffer.readString();
		TimeZone.readXDR(byteBuffer);
		MarketId = (long)byteBuffer.readInt();
		SectionId = (long)byteBuffer.readInt();
		MsgDate = (long)byteBuffer.readInt();
		MsgTime = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MsgId & 0xFFFFFFFFL));
		byteBuffer.writeString(MsgInfo);
		TimeZone.writeXDR(byteBuffer);
		byteBuffer.writeInt((int)(MarketId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SectionId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(MsgDate & 0xFFFFFFFFL));
		byteBuffer.writeLong(MsgTime);

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
		stringBuilder.append("TI_MSG_INFO::");
		stringBuilder.append("MsgId(").append(MsgId).append(")");
		stringBuilder.append("MsgInfo(").append(MsgInfo).append(")");
		stringBuilder.append("TimeZone(").append(TimeZone.toString()).append(")");
		stringBuilder.append("MarketId(").append(MarketId).append(")");
		stringBuilder.append("SectionId(").append(SectionId).append(")");
		stringBuilder.append("MsgDate(").append(MsgDate).append(")");
		stringBuilder.append("MsgTime(").append(MsgTime).append(")");
		return stringBuilder.toString();
	}
}
