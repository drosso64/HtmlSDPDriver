package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_RFCQ_SELL_SIDE_TRADING_LIST extends SMPMessage
{
	public static final long CLASS_ID = 100202;

	private long TradingListId = 0;
	private long RfcqReqId = 0;
	private long BuySideMemberId = 0;
	private long SellSideMemberId = 0;
	private short NumOfLegs = 0;
	private short NumOfTradableLegs = 0;
	private BV_RFCQ_SELL_SIDE_TRADING_LIST_INFO[] TradingList = new BV_RFCQ_SELL_SIDE_TRADING_LIST_INFO[50];
	private String Comment = "";
	private long CreationDate = 0;
	private long CreationTime = 0;
	private long UpdateDate = 0;
	private long UpdateTime = 0;

	public BV_RFCQ_SELL_SIDE_TRADING_LIST()
	{
		for (int i=0; i < TradingList.length; ++i)
		{
			TradingList[i] = new BV_RFCQ_SELL_SIDE_TRADING_LIST_INFO();
		}
	}

	public long getTradingListId()
	{
		return TradingListId;
	}
	public void setTradingListId(long value)
	{
		TradingListId = value;
	}
	public long getRfcqReqId()
	{
		return RfcqReqId;
	}
	public void setRfcqReqId(long value)
	{
		RfcqReqId = value;
	}
	public long getBuySideMemberId()
	{
		return BuySideMemberId;
	}
	public void setBuySideMemberId(long value)
	{
		BuySideMemberId = value;
	}
	public long getSellSideMemberId()
	{
		return SellSideMemberId;
	}
	public void setSellSideMemberId(long value)
	{
		SellSideMemberId = value;
	}
	public short getNumOfLegs()
	{
		return NumOfLegs;
	}
	public void setNumOfLegs(short value)
	{
		NumOfLegs = value;
	}
	public short getNumOfTradableLegs()
	{
		return NumOfTradableLegs;
	}
	public void setNumOfTradableLegs(short value)
	{
		NumOfTradableLegs = value;
	}
	public BV_RFCQ_SELL_SIDE_TRADING_LIST_INFO[] getTradingList()
	{
		return TradingList;
	}
	public void setTradingList(BV_RFCQ_SELL_SIDE_TRADING_LIST_INFO[] value)
	{
		TradingList = value;
	}
	public String getComment()
	{
		return Comment;
	}
	public void setComment(String value)
	{
		Comment = value;
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
		TradingListId = (long)byteBuffer.readInt();
		RfcqReqId = (long)byteBuffer.readInt();
		BuySideMemberId = (long)byteBuffer.readInt();
		SellSideMemberId = (long)byteBuffer.readInt();
		NumOfLegs = (short)byteBuffer.readInt();
		NumOfTradableLegs = (short)byteBuffer.readInt();
		for (int i=0; i < TradingList.length; ++i)
		{
			TradingList[i].readXDR(byteBuffer);
		}
		Comment = byteBuffer.readString();
		CreationDate = (long)byteBuffer.readInt();
		CreationTime = byteBuffer.readLong();
		UpdateDate = (long)byteBuffer.readInt();
		UpdateTime = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(TradingListId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(RfcqReqId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(BuySideMemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SellSideMemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(NumOfLegs & 0xFFFFL));
		byteBuffer.writeInt((int)(NumOfTradableLegs & 0xFFFFL));
		for (int i=0; i < TradingList.length; ++i)
		{
			TradingList[i].writeXDR(byteBuffer);
		}
		byteBuffer.writeString(Comment);
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
		stringBuilder.append("BV_RFCQ_SELL_SIDE_TRADING_LIST::");
		stringBuilder.append("TradingListId(").append(TradingListId).append(")");
		stringBuilder.append("RfcqReqId(").append(RfcqReqId).append(")");
		stringBuilder.append("BuySideMemberId(").append(BuySideMemberId).append(")");
		stringBuilder.append("SellSideMemberId(").append(SellSideMemberId).append(")");
		stringBuilder.append("NumOfLegs(").append(NumOfLegs).append(")");
		stringBuilder.append("NumOfTradableLegs(").append(NumOfTradableLegs).append(")");
		for (int i=0; i < TradingList.length; ++i)
		{
			stringBuilder.append("TradingList[").append(i).append("](").append(TradingList[i].toString()).append(")");
		}
		stringBuilder.append("Comment(").append(Comment).append(")");
		stringBuilder.append("CreationDate(").append(CreationDate).append(")");
		stringBuilder.append("CreationTime(").append(CreationTime).append(")");
		stringBuilder.append("UpdateDate(").append(UpdateDate).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		return stringBuilder.toString();
	}
}
