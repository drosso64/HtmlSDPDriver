package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_TRADE_SPLIT extends SMPMessage
{
	public static final long CLASS_ID = 114294;

	private BV_MEMBER_INFO Member = new BV_MEMBER_INFO();
	private long SellSideMemberId = 0;
	private long AllocationId = 0;
	private String ClientAllocationId = "";
	private String AllocationDescription = "";
	private BV_PREALLOCATION_TYPE_Enum PreAllocationType = BV_PREALLOCATION_TYPE_Enum.BV_PREALLOCATION_TYPE_Public;
	private long WorkingTraderId = 0;
	private long TradeId = 0;
	private long DealId = 0;
	private String ClientOrderId = "";
	private BV_INSTRUMENT_INFO Instrument = new BV_INSTRUMENT_INFO();
	private long PreAllocationTime = 0;
	private short SplitAttemptNo = 0;
	private short NumAccountInfo = 0;
	private BV_SPLIT_ACCOUNT_INFO[] AccountInfo = new BV_SPLIT_ACCOUNT_INFO[100];
	private short BlockId = 0;
	private short NumOfBlocks = 0;
	private BV_BLOCK_SPLIT_STATUS_Enum BlockValidity = BV_BLOCK_SPLIT_STATUS_Enum.BV_BLOCK_SPLIT_STATUS_Valid;
	private BV_TRADE_SPLIT_EVENT_Enum Event = BV_TRADE_SPLIT_EVENT_Enum.BV_TRADE_SPLIT_EVENT_PreAllocate;
	private BV_TRADE_SPLIT_STATUS_Enum Status = BV_TRADE_SPLIT_STATUS_Enum.BV_TRADE_SPLIT_STATUS_Accepted;
	private long CreationDate = 0;
	private long CreationTime = 0;
	private long UpdateDate = 0;
	private long UpdateTime = 0;
	private TI_TIME_ZONE TimeZone = new TI_TIME_ZONE();

	public BV_TRADE_SPLIT()
	{
		for (int i=0; i < AccountInfo.length; ++i)
		{
			AccountInfo[i] = new BV_SPLIT_ACCOUNT_INFO();
		}
	}

	public BV_MEMBER_INFO getMember()
	{
		return Member;
	}
	public void setMember(BV_MEMBER_INFO value)
	{
		Member = value;
	}
	public long getSellSideMemberId()
	{
		return SellSideMemberId;
	}
	public void setSellSideMemberId(long value)
	{
		SellSideMemberId = value;
	}
	public long getAllocationId()
	{
		return AllocationId;
	}
	public void setAllocationId(long value)
	{
		AllocationId = value;
	}
	public String getClientAllocationId()
	{
		return ClientAllocationId;
	}
	public void setClientAllocationId(String value)
	{
		ClientAllocationId = value;
	}
	public String getAllocationDescription()
	{
		return AllocationDescription;
	}
	public void setAllocationDescription(String value)
	{
		AllocationDescription = value;
	}
	public BV_PREALLOCATION_TYPE_Enum getPreAllocationType()
	{
		return PreAllocationType;
	}
	public void setPreAllocationType(BV_PREALLOCATION_TYPE_Enum value)
	{
		PreAllocationType = value;
	}
	public long getWorkingTraderId()
	{
		return WorkingTraderId;
	}
	public void setWorkingTraderId(long value)
	{
		WorkingTraderId = value;
	}
	public long getTradeId()
	{
		return TradeId;
	}
	public void setTradeId(long value)
	{
		TradeId = value;
	}
	public long getDealId()
	{
		return DealId;
	}
	public void setDealId(long value)
	{
		DealId = value;
	}
	public String getClientOrderId()
	{
		return ClientOrderId;
	}
	public void setClientOrderId(String value)
	{
		ClientOrderId = value;
	}
	public BV_INSTRUMENT_INFO getInstrument()
	{
		return Instrument;
	}
	public void setInstrument(BV_INSTRUMENT_INFO value)
	{
		Instrument = value;
	}
	public long getPreAllocationTime()
	{
		return PreAllocationTime;
	}
	public void setPreAllocationTime(long value)
	{
		PreAllocationTime = value;
	}
	public short getSplitAttemptNo()
	{
		return SplitAttemptNo;
	}
	public void setSplitAttemptNo(short value)
	{
		SplitAttemptNo = value;
	}
	public short getNumAccountInfo()
	{
		return NumAccountInfo;
	}
	public void setNumAccountInfo(short value)
	{
		NumAccountInfo = value;
	}
	public BV_SPLIT_ACCOUNT_INFO[] getAccountInfo()
	{
		return AccountInfo;
	}
	public void setAccountInfo(BV_SPLIT_ACCOUNT_INFO[] value)
	{
		AccountInfo = value;
	}
	public short getBlockId()
	{
		return BlockId;
	}
	public void setBlockId(short value)
	{
		BlockId = value;
	}
	public short getNumOfBlocks()
	{
		return NumOfBlocks;
	}
	public void setNumOfBlocks(short value)
	{
		NumOfBlocks = value;
	}
	public BV_BLOCK_SPLIT_STATUS_Enum getBlockValidity()
	{
		return BlockValidity;
	}
	public void setBlockValidity(BV_BLOCK_SPLIT_STATUS_Enum value)
	{
		BlockValidity = value;
	}
	public BV_TRADE_SPLIT_EVENT_Enum getEvent()
	{
		return Event;
	}
	public void setEvent(BV_TRADE_SPLIT_EVENT_Enum value)
	{
		Event = value;
	}
	public BV_TRADE_SPLIT_STATUS_Enum getStatus()
	{
		return Status;
	}
	public void setStatus(BV_TRADE_SPLIT_STATUS_Enum value)
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
	public TI_TIME_ZONE getTimeZone()
	{
		return TimeZone;
	}
	public void setTimeZone(TI_TIME_ZONE value)
	{
		TimeZone = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		Member.readXDR(byteBuffer);
		SellSideMemberId = (long)byteBuffer.readInt();
		AllocationId = (long)byteBuffer.readInt();
		ClientAllocationId = byteBuffer.readString();
		AllocationDescription = byteBuffer.readString();
		PreAllocationType = PreAllocationType.getEnum(byteBuffer.readInt());
		WorkingTraderId = (long)byteBuffer.readInt();
		TradeId = (long)byteBuffer.readInt();
		DealId = (long)byteBuffer.readInt();
		ClientOrderId = byteBuffer.readString();
		Instrument.readXDR(byteBuffer);
		PreAllocationTime = byteBuffer.readLong();
		SplitAttemptNo = (short)byteBuffer.readInt();
		NumAccountInfo = (short)byteBuffer.readInt();
		for (int i=0; i < AccountInfo.length; ++i)
		{
			AccountInfo[i].readXDR(byteBuffer);
		}
		BlockId = (short)byteBuffer.readInt();
		NumOfBlocks = (short)byteBuffer.readInt();
		BlockValidity = BlockValidity.getEnum(byteBuffer.readInt());
		Event = Event.getEnum(byteBuffer.readInt());
		Status = Status.getEnum(byteBuffer.readInt());
		CreationDate = (long)byteBuffer.readInt();
		CreationTime = byteBuffer.readLong();
		UpdateDate = (long)byteBuffer.readInt();
		UpdateTime = byteBuffer.readLong();
		TimeZone.readXDR(byteBuffer);
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		Member.writeXDR(byteBuffer);
		byteBuffer.writeInt((int)(SellSideMemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(AllocationId & 0xFFFFFFFFL));
		byteBuffer.writeString(ClientAllocationId);
		byteBuffer.writeString(AllocationDescription);
		byteBuffer.writeInt(PreAllocationType.getValue());
		byteBuffer.writeInt((int)(WorkingTraderId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(TradeId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(DealId & 0xFFFFFFFFL));
		byteBuffer.writeString(ClientOrderId);
		Instrument.writeXDR(byteBuffer);
		byteBuffer.writeLong(PreAllocationTime);
		byteBuffer.writeInt((int)(SplitAttemptNo & 0xFFFFL));
		byteBuffer.writeInt((int)(NumAccountInfo & 0xFFFFL));
		for (int i=0; i < AccountInfo.length; ++i)
		{
			AccountInfo[i].writeXDR(byteBuffer);
		}
		byteBuffer.writeInt((int)(BlockId & 0xFFFFL));
		byteBuffer.writeInt((int)(NumOfBlocks & 0xFFFFL));
		byteBuffer.writeInt(BlockValidity.getValue());
		byteBuffer.writeInt(Event.getValue());
		byteBuffer.writeInt(Status.getValue());
		byteBuffer.writeInt((int)(CreationDate & 0xFFFFFFFFL));
		byteBuffer.writeLong(CreationTime);
		byteBuffer.writeInt((int)(UpdateDate & 0xFFFFFFFFL));
		byteBuffer.writeLong(UpdateTime);
		TimeZone.writeXDR(byteBuffer);

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
		stringBuilder.append("BV_TRADE_SPLIT::");
		stringBuilder.append("Member(").append(Member.toString()).append(")");
		stringBuilder.append("SellSideMemberId(").append(SellSideMemberId).append(")");
		stringBuilder.append("AllocationId(").append(AllocationId).append(")");
		stringBuilder.append("ClientAllocationId(").append(ClientAllocationId).append(")");
		stringBuilder.append("AllocationDescription(").append(AllocationDescription).append(")");
		stringBuilder.append("PreAllocationType(").append(PreAllocationType).append(")");
		stringBuilder.append("WorkingTraderId(").append(WorkingTraderId).append(")");
		stringBuilder.append("TradeId(").append(TradeId).append(")");
		stringBuilder.append("DealId(").append(DealId).append(")");
		stringBuilder.append("ClientOrderId(").append(ClientOrderId).append(")");
		stringBuilder.append("Instrument(").append(Instrument.toString()).append(")");
		stringBuilder.append("PreAllocationTime(").append(PreAllocationTime).append(")");
		stringBuilder.append("SplitAttemptNo(").append(SplitAttemptNo).append(")");
		stringBuilder.append("NumAccountInfo(").append(NumAccountInfo).append(")");
		for (int i=0; i < AccountInfo.length; ++i)
		{
			stringBuilder.append("AccountInfo[").append(i).append("](").append(AccountInfo[i].toString()).append(")");
		}
		stringBuilder.append("BlockId(").append(BlockId).append(")");
		stringBuilder.append("NumOfBlocks(").append(NumOfBlocks).append(")");
		stringBuilder.append("BlockValidity(").append(BlockValidity).append(")");
		stringBuilder.append("Event(").append(Event).append(")");
		stringBuilder.append("Status(").append(Status).append(")");
		stringBuilder.append("CreationDate(").append(CreationDate).append(")");
		stringBuilder.append("CreationTime(").append(CreationTime).append(")");
		stringBuilder.append("UpdateDate(").append(UpdateDate).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		stringBuilder.append("TimeZone(").append(TimeZone.toString()).append(")");
		return stringBuilder.toString();
	}
}
