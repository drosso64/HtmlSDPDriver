package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_HIST_VOICE_CONFIRMED_QUOTES_REG_QUERY_PARAM extends SMPMessage
{
	public static final long CLASS_ID = 214213;

	private TI_QUERY_OP_Enum VoiceListIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long VoiceListId = 0;
	private TI_QUERY_OP_Enum InstrumentCodeOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String InstrumentCode = "";
	private TI_QUERY_OP_Enum DateFromOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long DateFrom = 0;
	private TI_QUERY_OP_Enum DateToOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long DateTo = 0;

	public BV_HIST_VOICE_CONFIRMED_QUOTES_REG_QUERY_PARAM()
	{
	}

	public TI_QUERY_OP_Enum getVoiceListIdOp()
	{
		return VoiceListIdOp;
	}
	public void setVoiceListIdOp(TI_QUERY_OP_Enum value)
	{
		VoiceListIdOp = value;
	}
	public long getVoiceListId()
	{
		return VoiceListId;
	}
	public void setVoiceListId(long value)
	{
		VoiceListId = value;
	}
	public TI_QUERY_OP_Enum getInstrumentCodeOp()
	{
		return InstrumentCodeOp;
	}
	public void setInstrumentCodeOp(TI_QUERY_OP_Enum value)
	{
		InstrumentCodeOp = value;
	}
	public String getInstrumentCode()
	{
		return InstrumentCode;
	}
	public void setInstrumentCode(String value)
	{
		InstrumentCode = value;
	}
	public TI_QUERY_OP_Enum getDateFromOp()
	{
		return DateFromOp;
	}
	public void setDateFromOp(TI_QUERY_OP_Enum value)
	{
		DateFromOp = value;
	}
	public long getDateFrom()
	{
		return DateFrom;
	}
	public void setDateFrom(long value)
	{
		DateFrom = value;
	}
	public TI_QUERY_OP_Enum getDateToOp()
	{
		return DateToOp;
	}
	public void setDateToOp(TI_QUERY_OP_Enum value)
	{
		DateToOp = value;
	}
	public long getDateTo()
	{
		return DateTo;
	}
	public void setDateTo(long value)
	{
		DateTo = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		VoiceListIdOp = VoiceListIdOp.getEnum(byteBuffer.readInt());
		VoiceListId = (long)byteBuffer.readInt();
		InstrumentCodeOp = InstrumentCodeOp.getEnum(byteBuffer.readInt());
		InstrumentCode = byteBuffer.readString();
		DateFromOp = DateFromOp.getEnum(byteBuffer.readInt());
		DateFrom = (long)byteBuffer.readInt();
		DateToOp = DateToOp.getEnum(byteBuffer.readInt());
		DateTo = (long)byteBuffer.readInt();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt(VoiceListIdOp.getValue());
		byteBuffer.writeInt((int)(VoiceListId & 0xFFFFFFFFL));
		byteBuffer.writeInt(InstrumentCodeOp.getValue());
		byteBuffer.writeString(InstrumentCode);
		byteBuffer.writeInt(DateFromOp.getValue());
		byteBuffer.writeInt((int)(DateFrom & 0xFFFFFFFFL));
		byteBuffer.writeInt(DateToOp.getValue());
		byteBuffer.writeInt((int)(DateTo & 0xFFFFFFFFL));

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
		stringBuilder.append("BV_HIST_VOICE_CONFIRMED_QUOTES_REG_QUERY_PARAM::");
		stringBuilder.append("VoiceListIdOp(").append(VoiceListIdOp).append(")");
		stringBuilder.append("VoiceListId(").append(VoiceListId).append(")");
		stringBuilder.append("InstrumentCodeOp(").append(InstrumentCodeOp).append(")");
		stringBuilder.append("InstrumentCode(").append(InstrumentCode).append(")");
		stringBuilder.append("DateFromOp(").append(DateFromOp).append(")");
		stringBuilder.append("DateFrom(").append(DateFrom).append(")");
		stringBuilder.append("DateToOp(").append(DateToOp).append(")");
		stringBuilder.append("DateTo(").append(DateTo).append(")");
		return stringBuilder.toString();
	}
}
