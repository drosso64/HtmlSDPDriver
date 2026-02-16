package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_GOV_MANAGE_FILL_REQ extends SMPMessage
{
	public static final long CLASS_ID = 100803;

	private long MarketId = 0;
	private long MsgId = 0;
	private TI_GOV_MANAGE_MSG_TYPE_Enum MsgType = TI_GOV_MANAGE_MSG_TYPE_Enum.TI_GOV_MANAGE_MSG_TYPE_Deal;
	private TI_GOV_MANAGE_FILL_EVENT_Enum Event = TI_GOV_MANAGE_FILL_EVENT_Enum.TI_GOV_MANAGE_FILL_EVENT_Activate;

	public TI_GOV_MANAGE_FILL_REQ()
	{
	}

	public long getMarketId()
	{
		return MarketId;
	}
	public void setMarketId(long value)
	{
		MarketId = value;
	}
	public long getMsgId()
	{
		return MsgId;
	}
	public void setMsgId(long value)
	{
		MsgId = value;
	}
	public TI_GOV_MANAGE_MSG_TYPE_Enum getMsgType()
	{
		return MsgType;
	}
	public void setMsgType(TI_GOV_MANAGE_MSG_TYPE_Enum value)
	{
		MsgType = value;
	}
	public TI_GOV_MANAGE_FILL_EVENT_Enum getEvent()
	{
		return Event;
	}
	public void setEvent(TI_GOV_MANAGE_FILL_EVENT_Enum value)
	{
		Event = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MarketId = (long)byteBuffer.readInt();
		MsgId = (long)byteBuffer.readInt();
		MsgType = MsgType.getEnum(byteBuffer.readInt());
		Event = Event.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MarketId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(MsgId & 0xFFFFFFFFL));
		byteBuffer.writeInt(MsgType.getValue());
		byteBuffer.writeInt(Event.getValue());

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
		stringBuilder.append("TI_GOV_MANAGE_FILL_REQ::");
		stringBuilder.append("MarketId(").append(MarketId).append(")");
		stringBuilder.append("MsgId(").append(MsgId).append(")");
		stringBuilder.append("MsgType(").append(MsgType).append(")");
		stringBuilder.append("Event(").append(Event).append(")");
		return stringBuilder.toString();
	}
}
