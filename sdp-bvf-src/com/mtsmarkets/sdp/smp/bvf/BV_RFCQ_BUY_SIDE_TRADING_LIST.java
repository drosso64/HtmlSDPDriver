package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_RFCQ_BUY_SIDE_TRADING_LIST extends SMPMessage
{
	public static final long CLASS_ID = 100201;

	private TI_MSG_INFO TradingListMsgInfo = new TI_MSG_INFO();
	private long RfcqReqId = 0;
	private long MemberId = 0;
	private long TraderId = 0;
	private String TraderName = "";
	private TI_FLAG_Enum PrivateFg = TI_FLAG_Enum.TI_FLAG_No;
	private long WorkingTraderId = 0;
	private TI_RFCQ_TYPE_Enum RFCQType = TI_RFCQ_TYPE_Enum.TI_RFCQ_TYPE_Outright;
	private short NumOfLegs = 0;
	private BV_RFCQ_BUY_SIDE_TRADING_LIST_INFO[] TradingList = new BV_RFCQ_BUY_SIDE_TRADING_LIST_INFO[50];
	private String Comment = "";
	private TI_FLAG_Enum ShowCommentFg = TI_FLAG_Enum.TI_FLAG_No;
	private TI_RFCQ_TRADING_LIST_EVENT_Enum Event = TI_RFCQ_TRADING_LIST_EVENT_Enum.TI_RFCQ_TRADING_LIST_EVENT_Insert;
	private TI_RFCQ_TRADING_LIST_STATUS_Enum Status = TI_RFCQ_TRADING_LIST_STATUS_Enum.TI_RFCQ_TRADING_LIST_STATUS_Active;
	private String UserData = "";
	private long UpdateDate = 0;
	private long UpdateTime = 0;

	public BV_RFCQ_BUY_SIDE_TRADING_LIST()
	{
		for (int i=0; i < TradingList.length; ++i)
		{
			TradingList[i] = new BV_RFCQ_BUY_SIDE_TRADING_LIST_INFO();
		}
	}

	public TI_MSG_INFO getTradingListMsgInfo()
	{
		return TradingListMsgInfo;
	}
	public void setTradingListMsgInfo(TI_MSG_INFO value)
	{
		TradingListMsgInfo = value;
	}
	public long getRfcqReqId()
	{
		return RfcqReqId;
	}
	public void setRfcqReqId(long value)
	{
		RfcqReqId = value;
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
	public String getTraderName()
	{
		return TraderName;
	}
	public void setTraderName(String value)
	{
		TraderName = value;
	}
	public TI_FLAG_Enum getPrivateFg()
	{
		return PrivateFg;
	}
	public void setPrivateFg(TI_FLAG_Enum value)
	{
		PrivateFg = value;
	}
	public long getWorkingTraderId()
	{
		return WorkingTraderId;
	}
	public void setWorkingTraderId(long value)
	{
		WorkingTraderId = value;
	}
	public TI_RFCQ_TYPE_Enum getRFCQType()
	{
		return RFCQType;
	}
	public void setRFCQType(TI_RFCQ_TYPE_Enum value)
	{
		RFCQType = value;
	}
	public short getNumOfLegs()
	{
		return NumOfLegs;
	}
	public void setNumOfLegs(short value)
	{
		NumOfLegs = value;
	}
	public BV_RFCQ_BUY_SIDE_TRADING_LIST_INFO[] getTradingList()
	{
		return TradingList;
	}
	public void setTradingList(BV_RFCQ_BUY_SIDE_TRADING_LIST_INFO[] value)
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
	public TI_FLAG_Enum getShowCommentFg()
	{
		return ShowCommentFg;
	}
	public void setShowCommentFg(TI_FLAG_Enum value)
	{
		ShowCommentFg = value;
	}
	public TI_RFCQ_TRADING_LIST_EVENT_Enum getEvent()
	{
		return Event;
	}
	public void setEvent(TI_RFCQ_TRADING_LIST_EVENT_Enum value)
	{
		Event = value;
	}
	public TI_RFCQ_TRADING_LIST_STATUS_Enum getStatus()
	{
		return Status;
	}
	public void setStatus(TI_RFCQ_TRADING_LIST_STATUS_Enum value)
	{
		Status = value;
	}
	public String getUserData()
	{
		return UserData;
	}
	public void setUserData(String value)
	{
		UserData = value;
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
		TradingListMsgInfo.readXDR(byteBuffer);
		RfcqReqId = (long)byteBuffer.readInt();
		MemberId = (long)byteBuffer.readInt();
		TraderId = (long)byteBuffer.readInt();
		TraderName = byteBuffer.readString();
		PrivateFg = PrivateFg.getEnum(byteBuffer.readInt());
		WorkingTraderId = (long)byteBuffer.readInt();
		RFCQType = RFCQType.getEnum(byteBuffer.readInt());
		NumOfLegs = (short)byteBuffer.readInt();
		for (int i=0; i < TradingList.length; ++i)
		{
			TradingList[i].readXDR(byteBuffer);
		}
		Comment = byteBuffer.readString();
		ShowCommentFg = ShowCommentFg.getEnum(byteBuffer.readInt());
		Event = Event.getEnum(byteBuffer.readInt());
		Status = Status.getEnum(byteBuffer.readInt());
		UserData = byteBuffer.readString();
		UpdateDate = (long)byteBuffer.readInt();
		UpdateTime = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		TradingListMsgInfo.writeXDR(byteBuffer);
		byteBuffer.writeInt((int)(RfcqReqId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(MemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(TraderId & 0xFFFFFFFFL));
		byteBuffer.writeString(TraderName);
		byteBuffer.writeInt(PrivateFg.getValue());
		byteBuffer.writeInt((int)(WorkingTraderId & 0xFFFFFFFFL));
		byteBuffer.writeInt(RFCQType.getValue());
		byteBuffer.writeInt((int)(NumOfLegs & 0xFFFFL));
		for (int i=0; i < TradingList.length; ++i)
		{
			TradingList[i].writeXDR(byteBuffer);
		}
		byteBuffer.writeString(Comment);
		byteBuffer.writeInt(ShowCommentFg.getValue());
		byteBuffer.writeInt(Event.getValue());
		byteBuffer.writeInt(Status.getValue());
		byteBuffer.writeString(UserData);
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
		stringBuilder.append("BV_RFCQ_BUY_SIDE_TRADING_LIST::");
		stringBuilder.append("TradingListMsgInfo(").append(TradingListMsgInfo.toString()).append(")");
		stringBuilder.append("RfcqReqId(").append(RfcqReqId).append(")");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("TraderId(").append(TraderId).append(")");
		stringBuilder.append("TraderName(").append(TraderName).append(")");
		stringBuilder.append("PrivateFg(").append(PrivateFg).append(")");
		stringBuilder.append("WorkingTraderId(").append(WorkingTraderId).append(")");
		stringBuilder.append("RFCQType(").append(RFCQType).append(")");
		stringBuilder.append("NumOfLegs(").append(NumOfLegs).append(")");
		for (int i=0; i < TradingList.length; ++i)
		{
			stringBuilder.append("TradingList[").append(i).append("](").append(TradingList[i].toString()).append(")");
		}
		stringBuilder.append("Comment(").append(Comment).append(")");
		stringBuilder.append("ShowCommentFg(").append(ShowCommentFg).append(")");
		stringBuilder.append("Event(").append(Event).append(")");
		stringBuilder.append("Status(").append(Status).append(")");
		stringBuilder.append("UserData(").append(UserData).append(")");
		stringBuilder.append("UpdateDate(").append(UpdateDate).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		return stringBuilder.toString();
	}
}
