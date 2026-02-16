package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_IOI extends SMPMessage
{
	public static final long CLASS_ID = 400011;

	private TI_MSG_INFO IOIMsgInfo = new TI_MSG_INFO();
	private String IOIClientInfo = "";
	private String IOIRefClientInfo = "";
	private BV_MEMBER_INFO Provider = new BV_MEMBER_INFO();
	private BV_MEMBER_INFO Submitter = new BV_MEMBER_INFO();
	private BV_INSTRUMENT_INFO Instrument = new BV_INSTRUMENT_INFO();
	private long GroupId = 0;
	private BV_IOI_EVENT_Enum Event = BV_IOI_EVENT_Enum.BV_IOI_EVENT_Activate;
	private BV_IOI_STATUS_Enum Status = BV_IOI_STATUS_Enum.BV_IOI_STATUS_Active;
	private TI_VERB_Enum Side = TI_VERB_Enum.TI_VERB_Buy;
	private BV_IOI_QUOTING_DATA QuotingData = new BV_IOI_QUOTING_DATA();
	private String FreeText = "";
	private String TransactionTime = "";
	private long UpdateTime = 0;

	public BV_IOI()
	{
	}

	public TI_MSG_INFO getIOIMsgInfo()
	{
		return IOIMsgInfo;
	}
	public void setIOIMsgInfo(TI_MSG_INFO value)
	{
		IOIMsgInfo = value;
	}
	public String getIOIClientInfo()
	{
		return IOIClientInfo;
	}
	public void setIOIClientInfo(String value)
	{
		IOIClientInfo = value;
	}
	public String getIOIRefClientInfo()
	{
		return IOIRefClientInfo;
	}
	public void setIOIRefClientInfo(String value)
	{
		IOIRefClientInfo = value;
	}
	public BV_MEMBER_INFO getProvider()
	{
		return Provider;
	}
	public void setProvider(BV_MEMBER_INFO value)
	{
		Provider = value;
	}
	public BV_MEMBER_INFO getSubmitter()
	{
		return Submitter;
	}
	public void setSubmitter(BV_MEMBER_INFO value)
	{
		Submitter = value;
	}
	public BV_INSTRUMENT_INFO getInstrument()
	{
		return Instrument;
	}
	public void setInstrument(BV_INSTRUMENT_INFO value)
	{
		Instrument = value;
	}
	public long getGroupId()
	{
		return GroupId;
	}
	public void setGroupId(long value)
	{
		GroupId = value;
	}
	public BV_IOI_EVENT_Enum getEvent()
	{
		return Event;
	}
	public void setEvent(BV_IOI_EVENT_Enum value)
	{
		Event = value;
	}
	public BV_IOI_STATUS_Enum getStatus()
	{
		return Status;
	}
	public void setStatus(BV_IOI_STATUS_Enum value)
	{
		Status = value;
	}
	public TI_VERB_Enum getSide()
	{
		return Side;
	}
	public void setSide(TI_VERB_Enum value)
	{
		Side = value;
	}
	public BV_IOI_QUOTING_DATA getQuotingData()
	{
		return QuotingData;
	}
	public void setQuotingData(BV_IOI_QUOTING_DATA value)
	{
		QuotingData = value;
	}
	public String getFreeText()
	{
		return FreeText;
	}
	public void setFreeText(String value)
	{
		FreeText = value;
	}
	public String getTransactionTime()
	{
		return TransactionTime;
	}
	public void setTransactionTime(String value)
	{
		TransactionTime = value;
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
		IOIMsgInfo.readXDR(byteBuffer);
		IOIClientInfo = byteBuffer.readString();
		IOIRefClientInfo = byteBuffer.readString();
		Provider.readXDR(byteBuffer);
		Submitter.readXDR(byteBuffer);
		Instrument.readXDR(byteBuffer);
		GroupId = (long)byteBuffer.readInt();
		Event = Event.getEnum(byteBuffer.readInt());
		Status = Status.getEnum(byteBuffer.readInt());
		Side = Side.getEnum(byteBuffer.readInt());
		QuotingData.readXDR(byteBuffer);
		FreeText = byteBuffer.readString();
		TransactionTime = byteBuffer.readString();
		UpdateTime = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		IOIMsgInfo.writeXDR(byteBuffer);
		byteBuffer.writeString(IOIClientInfo);
		byteBuffer.writeString(IOIRefClientInfo);
		Provider.writeXDR(byteBuffer);
		Submitter.writeXDR(byteBuffer);
		Instrument.writeXDR(byteBuffer);
		byteBuffer.writeInt((int)(GroupId & 0xFFFFFFFFL));
		byteBuffer.writeInt(Event.getValue());
		byteBuffer.writeInt(Status.getValue());
		byteBuffer.writeInt(Side.getValue());
		QuotingData.writeXDR(byteBuffer);
		byteBuffer.writeString(FreeText);
		byteBuffer.writeString(TransactionTime);
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
		stringBuilder.append("BV_IOI::");
		stringBuilder.append("IOIMsgInfo(").append(IOIMsgInfo.toString()).append(")");
		stringBuilder.append("IOIClientInfo(").append(IOIClientInfo).append(")");
		stringBuilder.append("IOIRefClientInfo(").append(IOIRefClientInfo).append(")");
		stringBuilder.append("Provider(").append(Provider.toString()).append(")");
		stringBuilder.append("Submitter(").append(Submitter.toString()).append(")");
		stringBuilder.append("Instrument(").append(Instrument.toString()).append(")");
		stringBuilder.append("GroupId(").append(GroupId).append(")");
		stringBuilder.append("Event(").append(Event).append(")");
		stringBuilder.append("Status(").append(Status).append(")");
		stringBuilder.append("Side(").append(Side).append(")");
		stringBuilder.append("QuotingData(").append(QuotingData.toString()).append(")");
		stringBuilder.append("FreeText(").append(FreeText).append(")");
		stringBuilder.append("TransactionTime(").append(TransactionTime).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		return stringBuilder.toString();
	}
}
