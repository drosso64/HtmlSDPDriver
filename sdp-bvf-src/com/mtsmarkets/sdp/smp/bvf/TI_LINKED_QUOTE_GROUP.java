package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_LINKED_QUOTE_GROUP extends SMPMessage
{
	public static final long CLASS_ID = 100026;

	private TI_MSG_INFO LinkedQuoteGroupInfo = new TI_MSG_INFO();
	private long MemberId = 0;
	private long UpdateTime = 0;
	private TI_LINKED_QUOTE_STATUS_Enum Status = TI_LINKED_QUOTE_STATUS_Enum.TI_LINKED_QUOTE_STATUS_Deleted;
	private long QuoteCount = 0;
	private TI_QUOTE_SEQNO[] QuoteList = new TI_QUOTE_SEQNO[100];
	private String UserData = "";

	public TI_LINKED_QUOTE_GROUP()
	{
		for (int i=0; i < QuoteList.length; ++i)
		{
			QuoteList[i] = new TI_QUOTE_SEQNO();
		}
	}

	public TI_MSG_INFO getLinkedQuoteGroupInfo()
	{
		return LinkedQuoteGroupInfo;
	}
	public void setLinkedQuoteGroupInfo(TI_MSG_INFO value)
	{
		LinkedQuoteGroupInfo = value;
	}
	public long getMemberId()
	{
		return MemberId;
	}
	public void setMemberId(long value)
	{
		MemberId = value;
	}
	public long getUpdateTime()
	{
		return UpdateTime;
	}
	public void setUpdateTime(long value)
	{
		UpdateTime = value;
	}
	public TI_LINKED_QUOTE_STATUS_Enum getStatus()
	{
		return Status;
	}
	public void setStatus(TI_LINKED_QUOTE_STATUS_Enum value)
	{
		Status = value;
	}
	public long getQuoteCount()
	{
		return QuoteCount;
	}
	public void setQuoteCount(long value)
	{
		QuoteCount = value;
	}
	public TI_QUOTE_SEQNO[] getQuoteList()
	{
		return QuoteList;
	}
	public void setQuoteList(TI_QUOTE_SEQNO[] value)
	{
		QuoteList = value;
	}
	public String getUserData()
	{
		return UserData;
	}
	public void setUserData(String value)
	{
		UserData = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		LinkedQuoteGroupInfo.readXDR(byteBuffer);
		MemberId = (long)byteBuffer.readInt();
		UpdateTime = byteBuffer.readLong();
		Status = Status.getEnum(byteBuffer.readInt());
		QuoteCount = (long)byteBuffer.readInt();
		for (int i=0; i < QuoteList.length; ++i)
		{
			QuoteList[i].readXDR(byteBuffer);
		}
		UserData = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		LinkedQuoteGroupInfo.writeXDR(byteBuffer);
		byteBuffer.writeInt((int)(MemberId & 0xFFFFFFFFL));
		byteBuffer.writeLong(UpdateTime);
		byteBuffer.writeInt(Status.getValue());
		byteBuffer.writeInt((int)(QuoteCount & 0xFFFFFFFFL));
		for (int i=0; i < QuoteList.length; ++i)
		{
			QuoteList[i].writeXDR(byteBuffer);
		}
		byteBuffer.writeString(UserData);

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
		stringBuilder.append("TI_LINKED_QUOTE_GROUP::");
		stringBuilder.append("LinkedQuoteGroupInfo(").append(LinkedQuoteGroupInfo.toString()).append(")");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		stringBuilder.append("Status(").append(Status).append(")");
		stringBuilder.append("QuoteCount(").append(QuoteCount).append(")");
		for (int i=0; i < QuoteList.length; ++i)
		{
			stringBuilder.append("QuoteList[").append(i).append("](").append(QuoteList[i].toString()).append(")");
		}
		stringBuilder.append("UserData(").append(UserData).append(")");
		return stringBuilder.toString();
	}
}
