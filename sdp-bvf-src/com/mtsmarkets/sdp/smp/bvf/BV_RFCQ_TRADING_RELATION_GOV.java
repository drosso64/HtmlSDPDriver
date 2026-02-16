package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_RFCQ_TRADING_RELATION_GOV extends SMPMessage
{
	public static final long CLASS_ID = 100818;

	private long MarketId = 0;
	private long OnBehalfOfId = 0;
	private long BuySideMemberId = 0;
	private String BuySideFreeText = "";
	private long SellSideMemberId = 0;
	private String SellSideFreeText = "";
	private BV_RFCQ_TRADING_RELATION_EVENT_Enum Event = BV_RFCQ_TRADING_RELATION_EVENT_Enum.BV_RFCQ_TRADING_RELATION_EVENT_Accept;
	private TI_FLAG_Enum UnseasonedBondTradingFg = TI_FLAG_Enum.TI_FLAG_No;
	private long CreationDate = 0;
	private long CreationTime = 0;
	private long UpdateDate = 0;
	private long UpdateTime = 0;

	public BV_RFCQ_TRADING_RELATION_GOV()
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
	public long getOnBehalfOfId()
	{
		return OnBehalfOfId;
	}
	public void setOnBehalfOfId(long value)
	{
		OnBehalfOfId = value;
	}
	public long getBuySideMemberId()
	{
		return BuySideMemberId;
	}
	public void setBuySideMemberId(long value)
	{
		BuySideMemberId = value;
	}
	public String getBuySideFreeText()
	{
		return BuySideFreeText;
	}
	public void setBuySideFreeText(String value)
	{
		BuySideFreeText = value;
	}
	public long getSellSideMemberId()
	{
		return SellSideMemberId;
	}
	public void setSellSideMemberId(long value)
	{
		SellSideMemberId = value;
	}
	public String getSellSideFreeText()
	{
		return SellSideFreeText;
	}
	public void setSellSideFreeText(String value)
	{
		SellSideFreeText = value;
	}
	public BV_RFCQ_TRADING_RELATION_EVENT_Enum getEvent()
	{
		return Event;
	}
	public void setEvent(BV_RFCQ_TRADING_RELATION_EVENT_Enum value)
	{
		Event = value;
	}
	public TI_FLAG_Enum getUnseasonedBondTradingFg()
	{
		return UnseasonedBondTradingFg;
	}
	public void setUnseasonedBondTradingFg(TI_FLAG_Enum value)
	{
		UnseasonedBondTradingFg = value;
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
		OnBehalfOfId = (long)byteBuffer.readInt();
		BuySideMemberId = (long)byteBuffer.readInt();
		BuySideFreeText = byteBuffer.readString();
		SellSideMemberId = (long)byteBuffer.readInt();
		SellSideFreeText = byteBuffer.readString();
		Event = Event.getEnum(byteBuffer.readInt());
		UnseasonedBondTradingFg = UnseasonedBondTradingFg.getEnum(byteBuffer.readInt());
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
		byteBuffer.writeInt((int)(OnBehalfOfId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(BuySideMemberId & 0xFFFFFFFFL));
		byteBuffer.writeString(BuySideFreeText);
		byteBuffer.writeInt((int)(SellSideMemberId & 0xFFFFFFFFL));
		byteBuffer.writeString(SellSideFreeText);
		byteBuffer.writeInt(Event.getValue());
		byteBuffer.writeInt(UnseasonedBondTradingFg.getValue());
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
		stringBuilder.append("BV_RFCQ_TRADING_RELATION_GOV::");
		stringBuilder.append("MarketId(").append(MarketId).append(")");
		stringBuilder.append("OnBehalfOfId(").append(OnBehalfOfId).append(")");
		stringBuilder.append("BuySideMemberId(").append(BuySideMemberId).append(")");
		stringBuilder.append("BuySideFreeText(").append(BuySideFreeText).append(")");
		stringBuilder.append("SellSideMemberId(").append(SellSideMemberId).append(")");
		stringBuilder.append("SellSideFreeText(").append(SellSideFreeText).append(")");
		stringBuilder.append("Event(").append(Event).append(")");
		stringBuilder.append("UnseasonedBondTradingFg(").append(UnseasonedBondTradingFg).append(")");
		stringBuilder.append("CreationDate(").append(CreationDate).append(")");
		stringBuilder.append("CreationTime(").append(CreationTime).append(")");
		stringBuilder.append("UpdateDate(").append(UpdateDate).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		return stringBuilder.toString();
	}
}
