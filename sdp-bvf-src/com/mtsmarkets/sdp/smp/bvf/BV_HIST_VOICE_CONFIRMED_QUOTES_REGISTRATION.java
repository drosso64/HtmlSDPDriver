package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_HIST_VOICE_CONFIRMED_QUOTES_REGISTRATION extends SMPMessage
{
	public static final long CLASS_ID = 400030;

	private long VoiceListId = 0;
	private BV_HIST_MEMBER_INFO Submitter = new BV_HIST_MEMBER_INFO();
	private String InstrumentCode = "";
	private long SettlementDate = 0;
	private short SettlementOffset = 0;
	private BV_HIST_VOICE_CONFIRMED_QUOTES[] Quotes = new BV_HIST_VOICE_CONFIRMED_QUOTES[20];
	private BV_VOICE_CONFIRMED_QUOTES_REGISTRATION_EVENT_Enum Event = BV_VOICE_CONFIRMED_QUOTES_REGISTRATION_EVENT_Enum.BV_VOICE_CONFIRMED_QUOTES_REGISTRATION_EVENT_Add;
	private BV_VOICE_CONFIRMED_QUOTES_REGISTRATION_STATUS_Enum Status = BV_VOICE_CONFIRMED_QUOTES_REGISTRATION_STATUS_Enum.BV_VOICE_CONFIRMED_QUOTES_REGISTRATION_STATUS_Active;
	private long CreationDate = 0;
	private long CreationTime = 0;
	private long UpdateDate = 0;
	private long UpdateTime = 0;

	public BV_HIST_VOICE_CONFIRMED_QUOTES_REGISTRATION()
	{
		for (int i=0; i < Quotes.length; ++i)
		{
			Quotes[i] = new BV_HIST_VOICE_CONFIRMED_QUOTES();
		}
	}

	public long getVoiceListId()
	{
		return VoiceListId;
	}
	public void setVoiceListId(long value)
	{
		VoiceListId = value;
	}
	public BV_HIST_MEMBER_INFO getSubmitter()
	{
		return Submitter;
	}
	public void setSubmitter(BV_HIST_MEMBER_INFO value)
	{
		Submitter = value;
	}
	public String getInstrumentCode()
	{
		return InstrumentCode;
	}
	public void setInstrumentCode(String value)
	{
		InstrumentCode = value;
	}
	public long getSettlementDate()
	{
		return SettlementDate;
	}
	public void setSettlementDate(long value)
	{
		SettlementDate = value;
	}
	public short getSettlementOffset()
	{
		return SettlementOffset;
	}
	public void setSettlementOffset(short value)
	{
		SettlementOffset = value;
	}
	public BV_HIST_VOICE_CONFIRMED_QUOTES[] getQuotes()
	{
		return Quotes;
	}
	public void setQuotes(BV_HIST_VOICE_CONFIRMED_QUOTES[] value)
	{
		Quotes = value;
	}
	public BV_VOICE_CONFIRMED_QUOTES_REGISTRATION_EVENT_Enum getEvent()
	{
		return Event;
	}
	public void setEvent(BV_VOICE_CONFIRMED_QUOTES_REGISTRATION_EVENT_Enum value)
	{
		Event = value;
	}
	public BV_VOICE_CONFIRMED_QUOTES_REGISTRATION_STATUS_Enum getStatus()
	{
		return Status;
	}
	public void setStatus(BV_VOICE_CONFIRMED_QUOTES_REGISTRATION_STATUS_Enum value)
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

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		VoiceListId = (long)byteBuffer.readInt();
		Submitter.readXDR(byteBuffer);
		InstrumentCode = byteBuffer.readString();
		SettlementDate = (long)byteBuffer.readInt();
		SettlementOffset = (short)byteBuffer.readInt();
		for (int i=0; i < Quotes.length; ++i)
		{
			Quotes[i].readXDR(byteBuffer);
		}
		Event = Event.getEnum(byteBuffer.readInt());
		Status = Status.getEnum(byteBuffer.readInt());
		CreationDate = (long)byteBuffer.readInt();
		CreationTime = byteBuffer.readLong();
		UpdateDate = (long)byteBuffer.readInt();
		UpdateTime = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(VoiceListId & 0xFFFFFFFFL));
		Submitter.writeXDR(byteBuffer);
		byteBuffer.writeString(InstrumentCode);
		byteBuffer.writeInt((int)(SettlementDate & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SettlementOffset & 0xFFFFL));
		for (int i=0; i < Quotes.length; ++i)
		{
			Quotes[i].writeXDR(byteBuffer);
		}
		byteBuffer.writeInt(Event.getValue());
		byteBuffer.writeInt(Status.getValue());
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
		stringBuilder.append("BV_HIST_VOICE_CONFIRMED_QUOTES_REGISTRATION::");
		stringBuilder.append("VoiceListId(").append(VoiceListId).append(")");
		stringBuilder.append("Submitter(").append(Submitter.toString()).append(")");
		stringBuilder.append("InstrumentCode(").append(InstrumentCode).append(")");
		stringBuilder.append("SettlementDate(").append(SettlementDate).append(")");
		stringBuilder.append("SettlementOffset(").append(SettlementOffset).append(")");
		for (int i=0; i < Quotes.length; ++i)
		{
			stringBuilder.append("Quotes[").append(i).append("](").append(Quotes[i].toString()).append(")");
		}
		stringBuilder.append("Event(").append(Event).append(")");
		stringBuilder.append("Status(").append(Status).append(")");
		stringBuilder.append("CreationDate(").append(CreationDate).append(")");
		stringBuilder.append("CreationTime(").append(CreationTime).append(")");
		stringBuilder.append("UpdateDate(").append(UpdateDate).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		return stringBuilder.toString();
	}
}
