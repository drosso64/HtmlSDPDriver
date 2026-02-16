package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_LOG_RFCQ_TRADING_RELATION extends SMPMessage
{
	public static final long CLASS_ID = 100825;

	private long MarketId = 0;
	private long BuySideMemberId = 0;
	private long BuySideTraderId = 0;
	private String BuySideTraderName = "";
	private String BuySideFreeText = "";
	private long SellSideMemberId = 0;
	private long SellSideTraderId = 0;
	private String SellSideTraderName = "";
	private String SellSideFreeText = "";
	private String ClientId = "";
	private BV_RFCQ_TRADING_RELATION_EVENT_Enum Event = BV_RFCQ_TRADING_RELATION_EVENT_Enum.BV_RFCQ_TRADING_RELATION_EVENT_Accept;
	private BV_RFCQ_TRADING_RELATION_STATUS_Enum BuySideSubStatus = BV_RFCQ_TRADING_RELATION_STATUS_Enum.BV_RFCQ_TRADING_RELATION_STATUS_Processing;
	private BV_RFCQ_TRADING_RELATION_STATUS_Enum SellSideSubStatus = BV_RFCQ_TRADING_RELATION_STATUS_Enum.BV_RFCQ_TRADING_RELATION_STATUS_Processing;
	private BV_RFCQ_TRADING_RELATION_STATUS_Enum Status = BV_RFCQ_TRADING_RELATION_STATUS_Enum.BV_RFCQ_TRADING_RELATION_STATUS_Processing;
	private long CreationDate = 0;
	private long CreationTime = 0;
	private long UpdateDate = 0;
	private long UpdateTime = 0;
	private TI_FLAG_Enum UnseasonedBondTradingFg = TI_FLAG_Enum.TI_FLAG_No;
	private long SubmitterBuySideMemberId = 0;
	private long SubmitterBuySideTraderId = 0;
	private String SubmitterBuySideTraderName = "";
	private long SubmitterSellSideMemberId = 0;
	private long SubmitterSellSideTraderId = 0;
	private String SubmitterSellSideTraderName = "";
	private TI_FLAG_Enum BlockedMemberFg = TI_FLAG_Enum.TI_FLAG_No;

	public BV_LOG_RFCQ_TRADING_RELATION()
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
	public String getSellSideFreeText()
	{
		return SellSideFreeText;
	}
	public void setSellSideFreeText(String value)
	{
		SellSideFreeText = value;
	}
	public String getClientId()
	{
		return ClientId;
	}
	public void setClientId(String value)
	{
		ClientId = value;
	}
	public BV_RFCQ_TRADING_RELATION_EVENT_Enum getEvent()
	{
		return Event;
	}
	public void setEvent(BV_RFCQ_TRADING_RELATION_EVENT_Enum value)
	{
		Event = value;
	}
	public BV_RFCQ_TRADING_RELATION_STATUS_Enum getBuySideSubStatus()
	{
		return BuySideSubStatus;
	}
	public void setBuySideSubStatus(BV_RFCQ_TRADING_RELATION_STATUS_Enum value)
	{
		BuySideSubStatus = value;
	}
	public BV_RFCQ_TRADING_RELATION_STATUS_Enum getSellSideSubStatus()
	{
		return SellSideSubStatus;
	}
	public void setSellSideSubStatus(BV_RFCQ_TRADING_RELATION_STATUS_Enum value)
	{
		SellSideSubStatus = value;
	}
	public BV_RFCQ_TRADING_RELATION_STATUS_Enum getStatus()
	{
		return Status;
	}
	public void setStatus(BV_RFCQ_TRADING_RELATION_STATUS_Enum value)
	{
		Status = value;
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
	public TI_FLAG_Enum getUnseasonedBondTradingFg()
	{
		return UnseasonedBondTradingFg;
	}
	public void setUnseasonedBondTradingFg(TI_FLAG_Enum value)
	{
		UnseasonedBondTradingFg = value;
	}
	public long getSubmitterBuySideMemberId()
	{
		return SubmitterBuySideMemberId;
	}
	public void setSubmitterBuySideMemberId(long value)
	{
		SubmitterBuySideMemberId = value;
	}
	public long getSubmitterBuySideTraderId()
	{
		return SubmitterBuySideTraderId;
	}
	public void setSubmitterBuySideTraderId(long value)
	{
		SubmitterBuySideTraderId = value;
	}
	public String getSubmitterBuySideTraderName()
	{
		return SubmitterBuySideTraderName;
	}
	public void setSubmitterBuySideTraderName(String value)
	{
		SubmitterBuySideTraderName = value;
	}
	public long getSubmitterSellSideMemberId()
	{
		return SubmitterSellSideMemberId;
	}
	public void setSubmitterSellSideMemberId(long value)
	{
		SubmitterSellSideMemberId = value;
	}
	public long getSubmitterSellSideTraderId()
	{
		return SubmitterSellSideTraderId;
	}
	public void setSubmitterSellSideTraderId(long value)
	{
		SubmitterSellSideTraderId = value;
	}
	public String getSubmitterSellSideTraderName()
	{
		return SubmitterSellSideTraderName;
	}
	public void setSubmitterSellSideTraderName(String value)
	{
		SubmitterSellSideTraderName = value;
	}
	public TI_FLAG_Enum getBlockedMemberFg()
	{
		return BlockedMemberFg;
	}
	public void setBlockedMemberFg(TI_FLAG_Enum value)
	{
		BlockedMemberFg = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MarketId = (long)byteBuffer.readInt();
		BuySideMemberId = (long)byteBuffer.readInt();
		BuySideTraderId = (long)byteBuffer.readInt();
		BuySideTraderName = byteBuffer.readString();
		BuySideFreeText = byteBuffer.readString();
		SellSideMemberId = (long)byteBuffer.readInt();
		SellSideTraderId = (long)byteBuffer.readInt();
		SellSideTraderName = byteBuffer.readString();
		SellSideFreeText = byteBuffer.readString();
		ClientId = byteBuffer.readString();
		Event = Event.getEnum(byteBuffer.readInt());
		BuySideSubStatus = BuySideSubStatus.getEnum(byteBuffer.readInt());
		SellSideSubStatus = SellSideSubStatus.getEnum(byteBuffer.readInt());
		Status = Status.getEnum(byteBuffer.readInt());
		CreationDate = (long)byteBuffer.readInt();
		CreationTime = byteBuffer.readLong();
		UpdateDate = (long)byteBuffer.readInt();
		UpdateTime = byteBuffer.readLong();
		UnseasonedBondTradingFg = UnseasonedBondTradingFg.getEnum(byteBuffer.readInt());
		SubmitterBuySideMemberId = (long)byteBuffer.readInt();
		SubmitterBuySideTraderId = (long)byteBuffer.readInt();
		SubmitterBuySideTraderName = byteBuffer.readString();
		SubmitterSellSideMemberId = (long)byteBuffer.readInt();
		SubmitterSellSideTraderId = (long)byteBuffer.readInt();
		SubmitterSellSideTraderName = byteBuffer.readString();
		BlockedMemberFg = BlockedMemberFg.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MarketId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(BuySideMemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(BuySideTraderId & 0xFFFFFFFFL));
		byteBuffer.writeString(BuySideTraderName);
		byteBuffer.writeString(BuySideFreeText);
		byteBuffer.writeInt((int)(SellSideMemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SellSideTraderId & 0xFFFFFFFFL));
		byteBuffer.writeString(SellSideTraderName);
		byteBuffer.writeString(SellSideFreeText);
		byteBuffer.writeString(ClientId);
		byteBuffer.writeInt(Event.getValue());
		byteBuffer.writeInt(BuySideSubStatus.getValue());
		byteBuffer.writeInt(SellSideSubStatus.getValue());
		byteBuffer.writeInt(Status.getValue());
		byteBuffer.writeInt((int)(CreationDate & 0xFFFFFFFFL));
		byteBuffer.writeLong(CreationTime);
		byteBuffer.writeInt((int)(UpdateDate & 0xFFFFFFFFL));
		byteBuffer.writeLong(UpdateTime);
		byteBuffer.writeInt(UnseasonedBondTradingFg.getValue());
		byteBuffer.writeInt((int)(SubmitterBuySideMemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SubmitterBuySideTraderId & 0xFFFFFFFFL));
		byteBuffer.writeString(SubmitterBuySideTraderName);
		byteBuffer.writeInt((int)(SubmitterSellSideMemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SubmitterSellSideTraderId & 0xFFFFFFFFL));
		byteBuffer.writeString(SubmitterSellSideTraderName);
		byteBuffer.writeInt(BlockedMemberFg.getValue());

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
		stringBuilder.append("BV_LOG_RFCQ_TRADING_RELATION::");
		stringBuilder.append("MarketId(").append(MarketId).append(")");
		stringBuilder.append("BuySideMemberId(").append(BuySideMemberId).append(")");
		stringBuilder.append("BuySideTraderId(").append(BuySideTraderId).append(")");
		stringBuilder.append("BuySideTraderName(").append(BuySideTraderName).append(")");
		stringBuilder.append("BuySideFreeText(").append(BuySideFreeText).append(")");
		stringBuilder.append("SellSideMemberId(").append(SellSideMemberId).append(")");
		stringBuilder.append("SellSideTraderId(").append(SellSideTraderId).append(")");
		stringBuilder.append("SellSideTraderName(").append(SellSideTraderName).append(")");
		stringBuilder.append("SellSideFreeText(").append(SellSideFreeText).append(")");
		stringBuilder.append("ClientId(").append(ClientId).append(")");
		stringBuilder.append("Event(").append(Event).append(")");
		stringBuilder.append("BuySideSubStatus(").append(BuySideSubStatus).append(")");
		stringBuilder.append("SellSideSubStatus(").append(SellSideSubStatus).append(")");
		stringBuilder.append("Status(").append(Status).append(")");
		stringBuilder.append("CreationDate(").append(CreationDate).append(")");
		stringBuilder.append("CreationTime(").append(CreationTime).append(")");
		stringBuilder.append("UpdateDate(").append(UpdateDate).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		stringBuilder.append("UnseasonedBondTradingFg(").append(UnseasonedBondTradingFg).append(")");
		stringBuilder.append("SubmitterBuySideMemberId(").append(SubmitterBuySideMemberId).append(")");
		stringBuilder.append("SubmitterBuySideTraderId(").append(SubmitterBuySideTraderId).append(")");
		stringBuilder.append("SubmitterBuySideTraderName(").append(SubmitterBuySideTraderName).append(")");
		stringBuilder.append("SubmitterSellSideMemberId(").append(SubmitterSellSideMemberId).append(")");
		stringBuilder.append("SubmitterSellSideTraderId(").append(SubmitterSellSideTraderId).append(")");
		stringBuilder.append("SubmitterSellSideTraderName(").append(SubmitterSellSideTraderName).append(")");
		stringBuilder.append("BlockedMemberFg(").append(BlockedMemberFg).append(")");
		return stringBuilder.toString();
	}
}
