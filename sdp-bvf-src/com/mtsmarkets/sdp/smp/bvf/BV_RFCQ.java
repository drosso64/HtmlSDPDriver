package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_RFCQ extends SMPMessage
{
	public static final long CLASS_ID = 114179;

	private long RfcqMsgId = 0;
	private long RfcqReqId = 0;
	private BV_MEMBER_INFO Aggressor = new BV_MEMBER_INFO();
	private BV_MEMBER_INFO Provider = new BV_MEMBER_INFO();
	private TI_RFCQ_TYPE_Enum RfcqType = TI_RFCQ_TYPE_Enum.TI_RFCQ_TYPE_Outright;
	private TI_RFCQ_ORIGIN_Enum RfcqOrigin = TI_RFCQ_ORIGIN_Enum.TI_RFCQ_ORIGIN_FromScratch;
	private TI_FLAG_Enum PreAgreedFg = TI_FLAG_Enum.TI_FLAG_No;
	private TI_FLAG_Enum PreTradeFg = TI_FLAG_Enum.TI_FLAG_No;
	private TI_RFCQ_QUANTITY_CALCULATION_Enum QuantityCalculation = TI_RFCQ_QUANTITY_CALCULATION_Enum.TI_RFCQ_QUANTITY_CALCULATION_UserInput;
	private long TradingListId = 0;
	private BV_RFCQ_DEALER_SELECTION_TYPE_Enum DealerSelectionType = BV_RFCQ_DEALER_SELECTION_TYPE_Enum.BV_RFCQ_DEALER_SELECTION_Manual;
	private BV_RFCQ_LEG[] RfcqLeg = new BV_RFCQ_LEG[3];
	private short NumOfCompetitors = 0;
	private TI_RFCQ_EVENT_Enum Event = TI_RFCQ_EVENT_Enum.TI_RFCQ_EVENT_Accept;
	private TI_RFCQ_STATUS_Enum Status = TI_RFCQ_STATUS_Enum.TI_RFCQ_STATUS_Processing;
	private long RfcqDuration = 0;
	private long RfcqTimeout = 0;
	private short DueInTime = 0;
	private long DueInTimeout = 0;
	private long CreationDate = 0;
	private long CreationTime = 0;
	private long UpdateTime = 0;

	public BV_RFCQ()
	{
		for (int i=0; i < RfcqLeg.length; ++i)
		{
			RfcqLeg[i] = new BV_RFCQ_LEG();
		}
	}

	public long getRfcqMsgId()
	{
		return RfcqMsgId;
	}
	public void setRfcqMsgId(long value)
	{
		RfcqMsgId = value;
	}
	public long getRfcqReqId()
	{
		return RfcqReqId;
	}
	public void setRfcqReqId(long value)
	{
		RfcqReqId = value;
	}
	public BV_MEMBER_INFO getAggressor()
	{
		return Aggressor;
	}
	public void setAggressor(BV_MEMBER_INFO value)
	{
		Aggressor = value;
	}
	public BV_MEMBER_INFO getProvider()
	{
		return Provider;
	}
	public void setProvider(BV_MEMBER_INFO value)
	{
		Provider = value;
	}
	public TI_RFCQ_TYPE_Enum getRfcqType()
	{
		return RfcqType;
	}
	public void setRfcqType(TI_RFCQ_TYPE_Enum value)
	{
		RfcqType = value;
	}
	public TI_RFCQ_ORIGIN_Enum getRfcqOrigin()
	{
		return RfcqOrigin;
	}
	public void setRfcqOrigin(TI_RFCQ_ORIGIN_Enum value)
	{
		RfcqOrigin = value;
	}
	public TI_FLAG_Enum getPreAgreedFg()
	{
		return PreAgreedFg;
	}
	public void setPreAgreedFg(TI_FLAG_Enum value)
	{
		PreAgreedFg = value;
	}
	public TI_FLAG_Enum getPreTradeFg()
	{
		return PreTradeFg;
	}
	public void setPreTradeFg(TI_FLAG_Enum value)
	{
		PreTradeFg = value;
	}
	public TI_RFCQ_QUANTITY_CALCULATION_Enum getQuantityCalculation()
	{
		return QuantityCalculation;
	}
	public void setQuantityCalculation(TI_RFCQ_QUANTITY_CALCULATION_Enum value)
	{
		QuantityCalculation = value;
	}
	public long getTradingListId()
	{
		return TradingListId;
	}
	public void setTradingListId(long value)
	{
		TradingListId = value;
	}
	public BV_RFCQ_DEALER_SELECTION_TYPE_Enum getDealerSelectionType()
	{
		return DealerSelectionType;
	}
	public void setDealerSelectionType(BV_RFCQ_DEALER_SELECTION_TYPE_Enum value)
	{
		DealerSelectionType = value;
	}
	public BV_RFCQ_LEG[] getRfcqLeg()
	{
		return RfcqLeg;
	}
	public void setRfcqLeg(BV_RFCQ_LEG[] value)
	{
		RfcqLeg = value;
	}
	public short getNumOfCompetitors()
	{
		return NumOfCompetitors;
	}
	public void setNumOfCompetitors(short value)
	{
		NumOfCompetitors = value;
	}
	public TI_RFCQ_EVENT_Enum getEvent()
	{
		return Event;
	}
	public void setEvent(TI_RFCQ_EVENT_Enum value)
	{
		Event = value;
	}
	public TI_RFCQ_STATUS_Enum getStatus()
	{
		return Status;
	}
	public void setStatus(TI_RFCQ_STATUS_Enum value)
	{
		Status = value;
	}
	public long getRfcqDuration()
	{
		return RfcqDuration;
	}
	public void setRfcqDuration(long value)
	{
		RfcqDuration = value;
	}
	public long getRfcqTimeout()
	{
		return RfcqTimeout;
	}
	public void setRfcqTimeout(long value)
	{
		RfcqTimeout = value;
	}
	public short getDueInTime()
	{
		return DueInTime;
	}
	public void setDueInTime(short value)
	{
		DueInTime = value;
	}
	public long getDueInTimeout()
	{
		return DueInTimeout;
	}
	public void setDueInTimeout(long value)
	{
		DueInTimeout = value;
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
		RfcqMsgId = (long)byteBuffer.readInt();
		RfcqReqId = (long)byteBuffer.readInt();
		Aggressor.readXDR(byteBuffer);
		Provider.readXDR(byteBuffer);
		RfcqType = RfcqType.getEnum(byteBuffer.readInt());
		RfcqOrigin = RfcqOrigin.getEnum(byteBuffer.readInt());
		PreAgreedFg = PreAgreedFg.getEnum(byteBuffer.readInt());
		PreTradeFg = PreTradeFg.getEnum(byteBuffer.readInt());
		QuantityCalculation = QuantityCalculation.getEnum(byteBuffer.readInt());
		TradingListId = (long)byteBuffer.readInt();
		DealerSelectionType = DealerSelectionType.getEnum(byteBuffer.readInt());
		for (int i=0; i < RfcqLeg.length; ++i)
		{
			RfcqLeg[i].readXDR(byteBuffer);
		}
		NumOfCompetitors = (short)byteBuffer.readInt();
		Event = Event.getEnum(byteBuffer.readInt());
		Status = Status.getEnum(byteBuffer.readInt());
		RfcqDuration = (long)byteBuffer.readInt();
		RfcqTimeout = byteBuffer.readLong();
		DueInTime = (short)byteBuffer.readInt();
		DueInTimeout = byteBuffer.readLong();
		CreationDate = (long)byteBuffer.readInt();
		CreationTime = byteBuffer.readLong();
		UpdateTime = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(RfcqMsgId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(RfcqReqId & 0xFFFFFFFFL));
		Aggressor.writeXDR(byteBuffer);
		Provider.writeXDR(byteBuffer);
		byteBuffer.writeInt(RfcqType.getValue());
		byteBuffer.writeInt(RfcqOrigin.getValue());
		byteBuffer.writeInt(PreAgreedFg.getValue());
		byteBuffer.writeInt(PreTradeFg.getValue());
		byteBuffer.writeInt(QuantityCalculation.getValue());
		byteBuffer.writeInt((int)(TradingListId & 0xFFFFFFFFL));
		byteBuffer.writeInt(DealerSelectionType.getValue());
		for (int i=0; i < RfcqLeg.length; ++i)
		{
			RfcqLeg[i].writeXDR(byteBuffer);
		}
		byteBuffer.writeInt((int)(NumOfCompetitors & 0xFFFFL));
		byteBuffer.writeInt(Event.getValue());
		byteBuffer.writeInt(Status.getValue());
		byteBuffer.writeInt((int)(RfcqDuration & 0xFFFFFFFFL));
		byteBuffer.writeLong(RfcqTimeout);
		byteBuffer.writeInt((int)(DueInTime & 0xFFFFL));
		byteBuffer.writeLong(DueInTimeout);
		byteBuffer.writeInt((int)(CreationDate & 0xFFFFFFFFL));
		byteBuffer.writeLong(CreationTime);
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
		stringBuilder.append("BV_RFCQ::");
		stringBuilder.append("RfcqMsgId(").append(RfcqMsgId).append(")");
		stringBuilder.append("RfcqReqId(").append(RfcqReqId).append(")");
		stringBuilder.append("Aggressor(").append(Aggressor.toString()).append(")");
		stringBuilder.append("Provider(").append(Provider.toString()).append(")");
		stringBuilder.append("RfcqType(").append(RfcqType).append(")");
		stringBuilder.append("RfcqOrigin(").append(RfcqOrigin).append(")");
		stringBuilder.append("PreAgreedFg(").append(PreAgreedFg).append(")");
		stringBuilder.append("PreTradeFg(").append(PreTradeFg).append(")");
		stringBuilder.append("QuantityCalculation(").append(QuantityCalculation).append(")");
		stringBuilder.append("TradingListId(").append(TradingListId).append(")");
		stringBuilder.append("DealerSelectionType(").append(DealerSelectionType).append(")");
		for (int i=0; i < RfcqLeg.length; ++i)
		{
			stringBuilder.append("RfcqLeg[").append(i).append("](").append(RfcqLeg[i].toString()).append(")");
		}
		stringBuilder.append("NumOfCompetitors(").append(NumOfCompetitors).append(")");
		stringBuilder.append("Event(").append(Event).append(")");
		stringBuilder.append("Status(").append(Status).append(")");
		stringBuilder.append("RfcqDuration(").append(RfcqDuration).append(")");
		stringBuilder.append("RfcqTimeout(").append(RfcqTimeout).append(")");
		stringBuilder.append("DueInTime(").append(DueInTime).append(")");
		stringBuilder.append("DueInTimeout(").append(DueInTimeout).append(")");
		stringBuilder.append("CreationDate(").append(CreationDate).append(")");
		stringBuilder.append("CreationTime(").append(CreationTime).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		return stringBuilder.toString();
	}
}
