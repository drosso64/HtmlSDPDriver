package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_RFCQ_TRADING_RELATION_TRADER_EXCEPTION extends SMPMessage
{
	public static final long CLASS_ID = 100095;

	private long MarketId = 0;
	private long InstrumentClassId = 0;
	private long BuySideMemberId = 0;
	private long BuySideTraderId = 0;
	private String BuySideTraderName = "";
	private long SellSideMemberId = 0;
	private long SellSideTraderId = 0;
	private String SellSideTraderName = "";
	private BV_RFCQ_TRADING_RELATION_EXCEPTION_EVENT_Enum Event = BV_RFCQ_TRADING_RELATION_EXCEPTION_EVENT_Enum.BV_RFCQ_TRADING_RELATION_EXCEPTION_EVENT_Insert;
	private BV_RFCQ_TRADING_RELATION_EXCEPTION_STATUS_Enum Status = BV_RFCQ_TRADING_RELATION_EXCEPTION_STATUS_Enum.BV_RFCQ_TRADING_RELATION_EXCEPTION_STATUS_Active;
	private TI_RFCQ_TYPE_Enum RFCQType = TI_RFCQ_TYPE_Enum.TI_RFCQ_TYPE_Outright;
	private long CreationDate = 0;
	private long CreationTime = 0;
	private long UpdateDate = 0;
	private long UpdateTime = 0;

	public BV_RFCQ_TRADING_RELATION_TRADER_EXCEPTION()
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
	public long getInstrumentClassId()
	{
		return InstrumentClassId;
	}
	public void setInstrumentClassId(long value)
	{
		InstrumentClassId = value;
	}
	public long getBuySideMemberId()
	{
		return BuySideMemberId;
	}
	public void setBuySideMemberId(long value)
	{
		BuySideMemberId = value;
	}
	public long getBuySideTraderId()
	{
		return BuySideTraderId;
	}
	public void setBuySideTraderId(long value)
	{
		BuySideTraderId = value;
	}
	public String getBuySideTraderName()
	{
		return BuySideTraderName;
	}
	public void setBuySideTraderName(String value)
	{
		BuySideTraderName = value;
	}
	public long getSellSideMemberId()
	{
		return SellSideMemberId;
	}
	public void setSellSideMemberId(long value)
	{
		SellSideMemberId = value;
	}
	public long getSellSideTraderId()
	{
		return SellSideTraderId;
	}
	public void setSellSideTraderId(long value)
	{
		SellSideTraderId = value;
	}
	public String getSellSideTraderName()
	{
		return SellSideTraderName;
	}
	public void setSellSideTraderName(String value)
	{
		SellSideTraderName = value;
	}
	public BV_RFCQ_TRADING_RELATION_EXCEPTION_EVENT_Enum getEvent()
	{
		return Event;
	}
	public void setEvent(BV_RFCQ_TRADING_RELATION_EXCEPTION_EVENT_Enum value)
	{
		Event = value;
	}
	public BV_RFCQ_TRADING_RELATION_EXCEPTION_STATUS_Enum getStatus()
	{
		return Status;
	}
	public void setStatus(BV_RFCQ_TRADING_RELATION_EXCEPTION_STATUS_Enum value)
	{
		Status = value;
	}
	public TI_RFCQ_TYPE_Enum getRFCQType()
	{
		return RFCQType;
	}
	public void setRFCQType(TI_RFCQ_TYPE_Enum value)
	{
		RFCQType = value;
	}
	public long getCreationDate()
	{
		return CreationDate;
	}
	public void setCreationDate(long value)
	{
		CreationDate = value;
	}
	public long getCreationTime()
	{
		return CreationTime;
	}
	public void setCreationTime(long value)
	{
		CreationTime = value;
	}
	public long getUpdateDate()
	{
		return UpdateDate;
	}
	public void setUpdateDate(long value)
	{
		UpdateDate = value;
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
		MarketId = (long)byteBuffer.readInt();
		InstrumentClassId = (long)byteBuffer.readInt();
		BuySideMemberId = (long)byteBuffer.readInt();
		BuySideTraderId = (long)byteBuffer.readInt();
		BuySideTraderName = byteBuffer.readString();
		SellSideMemberId = (long)byteBuffer.readInt();
		SellSideTraderId = (long)byteBuffer.readInt();
		SellSideTraderName = byteBuffer.readString();
		Event = Event.getEnum(byteBuffer.readInt());
		Status = Status.getEnum(byteBuffer.readInt());
		RFCQType = RFCQType.getEnum(byteBuffer.readInt());
		CreationDate = (long)byteBuffer.readInt();
		CreationTime = byteBuffer.readLong();
		UpdateDate = (long)byteBuffer.readInt();
		UpdateTime = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MarketId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(InstrumentClassId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(BuySideMemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(BuySideTraderId & 0xFFFFFFFFL));
		byteBuffer.writeString(BuySideTraderName);
		byteBuffer.writeInt((int)(SellSideMemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SellSideTraderId & 0xFFFFFFFFL));
		byteBuffer.writeString(SellSideTraderName);
		byteBuffer.writeInt(Event.getValue());
		byteBuffer.writeInt(Status.getValue());
		byteBuffer.writeInt(RFCQType.getValue());
		byteBuffer.writeInt((int)(CreationDate & 0xFFFFFFFFL));
		byteBuffer.writeLong(CreationTime);
		byteBuffer.writeInt((int)(UpdateDate & 0xFFFFFFFFL));
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
		stringBuilder.append("BV_RFCQ_TRADING_RELATION_TRADER_EXCEPTION::");
		stringBuilder.append("MarketId(").append(MarketId).append(")");
		stringBuilder.append("InstrumentClassId(").append(InstrumentClassId).append(")");
		stringBuilder.append("BuySideMemberId(").append(BuySideMemberId).append(")");
		stringBuilder.append("BuySideTraderId(").append(BuySideTraderId).append(")");
		stringBuilder.append("BuySideTraderName(").append(BuySideTraderName).append(")");
		stringBuilder.append("SellSideMemberId(").append(SellSideMemberId).append(")");
		stringBuilder.append("SellSideTraderId(").append(SellSideTraderId).append(")");
		stringBuilder.append("SellSideTraderName(").append(SellSideTraderName).append(")");
		stringBuilder.append("Event(").append(Event).append(")");
		stringBuilder.append("Status(").append(Status).append(")");
		stringBuilder.append("RFCQType(").append(RFCQType).append(")");
		stringBuilder.append("CreationDate(").append(CreationDate).append(")");
		stringBuilder.append("CreationTime(").append(CreationTime).append(")");
		stringBuilder.append("UpdateDate(").append(UpdateDate).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		return stringBuilder.toString();
	}
}
