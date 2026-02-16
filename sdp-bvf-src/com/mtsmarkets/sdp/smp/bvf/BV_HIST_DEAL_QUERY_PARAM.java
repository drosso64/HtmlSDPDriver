package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_HIST_DEAL_QUERY_PARAM extends SMPMessage
{
	public static final long CLASS_ID = 114181;

	private TI_QUERY_OP_Enum DealOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long Deal = 0;
	private TI_QUERY_OP_Enum MsgDateFromOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long MsgDateFrom = 0;
	private TI_QUERY_OP_Enum MsgDateToOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long MsgDateTo = 0;
	private TI_QUERY_OP_Enum MsgTimeFromOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long MsgTimeFrom = 0;
	private TI_QUERY_OP_Enum MsgTimeToOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long MsgTimeTo = 0;
	private TI_QUERY_OP_Enum CtpyCodeOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String CtpyCode = "";
	private TI_QUERY_OP_Enum CtpyShortDescOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String CtpyShortDesc = "";
	private TI_QUERY_OP_Enum TraderNameOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String TraderName = "";
	private TI_QUERY_OP_Enum InstrumentCodeOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String InstrumentCode = "";
	private TI_QUERY_OP_Enum SectionCodeOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String SectionCode = "";

	public BV_HIST_DEAL_QUERY_PARAM()
	{
	}

	public TI_QUERY_OP_Enum getDealOp()
	{
		return DealOp;
	}
	public void setDealOp(TI_QUERY_OP_Enum value)
	{
		DealOp = value;
	}
	public long getDeal()
	{
		return Deal;
	}
	public void setDeal(long value)
	{
		Deal = value;
	}
	public TI_QUERY_OP_Enum getMsgDateFromOp()
	{
		return MsgDateFromOp;
	}
	public void setMsgDateFromOp(TI_QUERY_OP_Enum value)
	{
		MsgDateFromOp = value;
	}
	public long getMsgDateFrom()
	{
		return MsgDateFrom;
	}
	public void setMsgDateFrom(long value)
	{
		MsgDateFrom = value;
	}
	public TI_QUERY_OP_Enum getMsgDateToOp()
	{
		return MsgDateToOp;
	}
	public void setMsgDateToOp(TI_QUERY_OP_Enum value)
	{
		MsgDateToOp = value;
	}
	public long getMsgDateTo()
	{
		return MsgDateTo;
	}
	public void setMsgDateTo(long value)
	{
		MsgDateTo = value;
	}
	public TI_QUERY_OP_Enum getMsgTimeFromOp()
	{
		return MsgTimeFromOp;
	}
	public void setMsgTimeFromOp(TI_QUERY_OP_Enum value)
	{
		MsgTimeFromOp = value;
	}
	public long getMsgTimeFrom()
	{
		return MsgTimeFrom;
	}
	public void setMsgTimeFrom(long value)
	{
		MsgTimeFrom = value;
	}
	public TI_QUERY_OP_Enum getMsgTimeToOp()
	{
		return MsgTimeToOp;
	}
	public void setMsgTimeToOp(TI_QUERY_OP_Enum value)
	{
		MsgTimeToOp = value;
	}
	public long getMsgTimeTo()
	{
		return MsgTimeTo;
	}
	public void setMsgTimeTo(long value)
	{
		MsgTimeTo = value;
	}
	public TI_QUERY_OP_Enum getCtpyCodeOp()
	{
		return CtpyCodeOp;
	}
	public void setCtpyCodeOp(TI_QUERY_OP_Enum value)
	{
		CtpyCodeOp = value;
	}
	public String getCtpyCode()
	{
		return CtpyCode;
	}
	public void setCtpyCode(String value)
	{
		CtpyCode = value;
	}
	public TI_QUERY_OP_Enum getCtpyShortDescOp()
	{
		return CtpyShortDescOp;
	}
	public void setCtpyShortDescOp(TI_QUERY_OP_Enum value)
	{
		CtpyShortDescOp = value;
	}
	public String getCtpyShortDesc()
	{
		return CtpyShortDesc;
	}
	public void setCtpyShortDesc(String value)
	{
		CtpyShortDesc = value;
	}
	public TI_QUERY_OP_Enum getTraderNameOp()
	{
		return TraderNameOp;
	}
	public void setTraderNameOp(TI_QUERY_OP_Enum value)
	{
		TraderNameOp = value;
	}
	public String getTraderName()
	{
		return TraderName;
	}
	public void setTraderName(String value)
	{
		TraderName = value;
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
	public TI_QUERY_OP_Enum getSectionCodeOp()
	{
		return SectionCodeOp;
	}
	public void setSectionCodeOp(TI_QUERY_OP_Enum value)
	{
		SectionCodeOp = value;
	}
	public String getSectionCode()
	{
		return SectionCode;
	}
	public void setSectionCode(String value)
	{
		SectionCode = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		DealOp = DealOp.getEnum(byteBuffer.readInt());
		Deal = (long)byteBuffer.readInt();
		MsgDateFromOp = MsgDateFromOp.getEnum(byteBuffer.readInt());
		MsgDateFrom = (long)byteBuffer.readInt();
		MsgDateToOp = MsgDateToOp.getEnum(byteBuffer.readInt());
		MsgDateTo = (long)byteBuffer.readInt();
		MsgTimeFromOp = MsgTimeFromOp.getEnum(byteBuffer.readInt());
		MsgTimeFrom = byteBuffer.readLong();
		MsgTimeToOp = MsgTimeToOp.getEnum(byteBuffer.readInt());
		MsgTimeTo = byteBuffer.readLong();
		CtpyCodeOp = CtpyCodeOp.getEnum(byteBuffer.readInt());
		CtpyCode = byteBuffer.readString();
		CtpyShortDescOp = CtpyShortDescOp.getEnum(byteBuffer.readInt());
		CtpyShortDesc = byteBuffer.readString();
		TraderNameOp = TraderNameOp.getEnum(byteBuffer.readInt());
		TraderName = byteBuffer.readString();
		InstrumentCodeOp = InstrumentCodeOp.getEnum(byteBuffer.readInt());
		InstrumentCode = byteBuffer.readString();
		SectionCodeOp = SectionCodeOp.getEnum(byteBuffer.readInt());
		SectionCode = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt(DealOp.getValue());
		byteBuffer.writeInt((int)(Deal & 0xFFFFFFFFL));
		byteBuffer.writeInt(MsgDateFromOp.getValue());
		byteBuffer.writeInt((int)(MsgDateFrom & 0xFFFFFFFFL));
		byteBuffer.writeInt(MsgDateToOp.getValue());
		byteBuffer.writeInt((int)(MsgDateTo & 0xFFFFFFFFL));
		byteBuffer.writeInt(MsgTimeFromOp.getValue());
		byteBuffer.writeLong(MsgTimeFrom);
		byteBuffer.writeInt(MsgTimeToOp.getValue());
		byteBuffer.writeLong(MsgTimeTo);
		byteBuffer.writeInt(CtpyCodeOp.getValue());
		byteBuffer.writeString(CtpyCode);
		byteBuffer.writeInt(CtpyShortDescOp.getValue());
		byteBuffer.writeString(CtpyShortDesc);
		byteBuffer.writeInt(TraderNameOp.getValue());
		byteBuffer.writeString(TraderName);
		byteBuffer.writeInt(InstrumentCodeOp.getValue());
		byteBuffer.writeString(InstrumentCode);
		byteBuffer.writeInt(SectionCodeOp.getValue());
		byteBuffer.writeString(SectionCode);

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
		stringBuilder.append("BV_HIST_DEAL_QUERY_PARAM::");
		stringBuilder.append("DealOp(").append(DealOp).append(")");
		stringBuilder.append("Deal(").append(Deal).append(")");
		stringBuilder.append("MsgDateFromOp(").append(MsgDateFromOp).append(")");
		stringBuilder.append("MsgDateFrom(").append(MsgDateFrom).append(")");
		stringBuilder.append("MsgDateToOp(").append(MsgDateToOp).append(")");
		stringBuilder.append("MsgDateTo(").append(MsgDateTo).append(")");
		stringBuilder.append("MsgTimeFromOp(").append(MsgTimeFromOp).append(")");
		stringBuilder.append("MsgTimeFrom(").append(MsgTimeFrom).append(")");
		stringBuilder.append("MsgTimeToOp(").append(MsgTimeToOp).append(")");
		stringBuilder.append("MsgTimeTo(").append(MsgTimeTo).append(")");
		stringBuilder.append("CtpyCodeOp(").append(CtpyCodeOp).append(")");
		stringBuilder.append("CtpyCode(").append(CtpyCode).append(")");
		stringBuilder.append("CtpyShortDescOp(").append(CtpyShortDescOp).append(")");
		stringBuilder.append("CtpyShortDesc(").append(CtpyShortDesc).append(")");
		stringBuilder.append("TraderNameOp(").append(TraderNameOp).append(")");
		stringBuilder.append("TraderName(").append(TraderName).append(")");
		stringBuilder.append("InstrumentCodeOp(").append(InstrumentCodeOp).append(")");
		stringBuilder.append("InstrumentCode(").append(InstrumentCode).append(")");
		stringBuilder.append("SectionCodeOp(").append(SectionCodeOp).append(")");
		stringBuilder.append("SectionCode(").append(SectionCode).append(")");
		return stringBuilder.toString();
	}
}
