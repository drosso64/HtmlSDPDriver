package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_HIST_RFCQ_DEPTH extends SMPMessage
{
	public static final long CLASS_ID = 114164;

	private long Date = 0;
	private long RfcqReqId = 0;
	private String MemberCode = "";
	private String MemberShortDesc = "";
	private String TraderName = "";
	private TI_RFCQ_TYPE_Enum RfcqType = TI_RFCQ_TYPE_Enum.TI_RFCQ_TYPE_Outright;
	private long TradingListId = 0;
	private short LegId = 0;
	private BV_HIST_RFCQ_DEPTH_LEG[] DepthLeg = new BV_HIST_RFCQ_DEPTH_LEG[3];
	private BV_HIST_RFCQ_TRADING_LEVEL[] TradingLevel = new BV_HIST_RFCQ_TRADING_LEVEL[20];
	private long BookTimestamp = 0;

	public BV_HIST_RFCQ_DEPTH()
	{
		for (int i=0; i < DepthLeg.length; ++i)
		{
			DepthLeg[i] = new BV_HIST_RFCQ_DEPTH_LEG();
		}
		for (int i=0; i < TradingLevel.length; ++i)
		{
			TradingLevel[i] = new BV_HIST_RFCQ_TRADING_LEVEL();
		}
	}

	public long getDate()
	{
		return Date;
	}
	public void setDate(long value)
	{
		Date = value;
	}
	public long getRfcqReqId()
	{
		return RfcqReqId;
	}
	public void setRfcqReqId(long value)
	{
		RfcqReqId = value;
	}
	public String getMemberCode()
	{
		return MemberCode;
	}
	public void setMemberCode(String value)
	{
		MemberCode = value;
	}
	public String getMemberShortDesc()
	{
		return MemberShortDesc;
	}
	public void setMemberShortDesc(String value)
	{
		MemberShortDesc = value;
	}
	public String getTraderName()
	{
		return TraderName;
	}
	public void setTraderName(String value)
	{
		TraderName = value;
	}
	public TI_RFCQ_TYPE_Enum getRfcqType()
	{
		return RfcqType;
	}
	public void setRfcqType(TI_RFCQ_TYPE_Enum value)
	{
		RfcqType = value;
	}
	public long getTradingListId()
	{
		return TradingListId;
	}
	public void setTradingListId(long value)
	{
		TradingListId = value;
	}
	public short getLegId()
	{
		return LegId;
	}
	public void setLegId(short value)
	{
		LegId = value;
	}
	public BV_HIST_RFCQ_DEPTH_LEG[] getDepthLeg()
	{
		return DepthLeg;
	}
	public void setDepthLeg(BV_HIST_RFCQ_DEPTH_LEG[] value)
	{
		DepthLeg = value;
	}
	public BV_HIST_RFCQ_TRADING_LEVEL[] getTradingLevel()
	{
		return TradingLevel;
	}
	public void setTradingLevel(BV_HIST_RFCQ_TRADING_LEVEL[] value)
	{
		TradingLevel = value;
	}
	public long getBookTimestamp()
	{
		return BookTimestamp;
	}
	public void setBookTimestamp(long value)
	{
		BookTimestamp = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		Date = (long)byteBuffer.readInt();
		RfcqReqId = (long)byteBuffer.readInt();
		MemberCode = byteBuffer.readString();
		MemberShortDesc = byteBuffer.readString();
		TraderName = byteBuffer.readString();
		RfcqType = RfcqType.getEnum(byteBuffer.readInt());
		TradingListId = (long)byteBuffer.readInt();
		LegId = (short)byteBuffer.readInt();
		for (int i=0; i < DepthLeg.length; ++i)
		{
			DepthLeg[i].readXDR(byteBuffer);
		}
		for (int i=0; i < TradingLevel.length; ++i)
		{
			TradingLevel[i].readXDR(byteBuffer);
		}
		BookTimestamp = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(Date & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(RfcqReqId & 0xFFFFFFFFL));
		byteBuffer.writeString(MemberCode);
		byteBuffer.writeString(MemberShortDesc);
		byteBuffer.writeString(TraderName);
		byteBuffer.writeInt(RfcqType.getValue());
		byteBuffer.writeInt((int)(TradingListId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(LegId & 0xFFFFL));
		for (int i=0; i < DepthLeg.length; ++i)
		{
			DepthLeg[i].writeXDR(byteBuffer);
		}
		for (int i=0; i < TradingLevel.length; ++i)
		{
			TradingLevel[i].writeXDR(byteBuffer);
		}
		byteBuffer.writeLong(BookTimestamp);

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
		stringBuilder.append("BV_HIST_RFCQ_DEPTH::");
		stringBuilder.append("Date(").append(Date).append(")");
		stringBuilder.append("RfcqReqId(").append(RfcqReqId).append(")");
		stringBuilder.append("MemberCode(").append(MemberCode).append(")");
		stringBuilder.append("MemberShortDesc(").append(MemberShortDesc).append(")");
		stringBuilder.append("TraderName(").append(TraderName).append(")");
		stringBuilder.append("RfcqType(").append(RfcqType).append(")");
		stringBuilder.append("TradingListId(").append(TradingListId).append(")");
		stringBuilder.append("LegId(").append(LegId).append(")");
		for (int i=0; i < DepthLeg.length; ++i)
		{
			stringBuilder.append("DepthLeg[").append(i).append("](").append(DepthLeg[i].toString()).append(")");
		}
		for (int i=0; i < TradingLevel.length; ++i)
		{
			stringBuilder.append("TradingLevel[").append(i).append("](").append(TradingLevel[i].toString()).append(")");
		}
		stringBuilder.append("BookTimestamp(").append(BookTimestamp).append(")");
		return stringBuilder.toString();
	}
}
