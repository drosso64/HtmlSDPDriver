package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_PORTFOLIO_RFCQ_SELL_SIDE_SUMMARY_LEG_INFO extends SMPMessage
{
	public static final long CLASS_ID = 410031;

	private long SellSideMemberId = 0;
	private String SellSideMemberCode = "";
	private String SellSideMemberDesc = "";
	private String SellSideMemberShortDesc = "";
	private long SellSideTraderId = 0;
	private String SellSideTraderName = "";
	private long RfcqReqId = 0;
	private long CreationDate = 0;
	private long CreationTime = 0;
	private short LegId = 0;
	private BV_PORTFOLIO_RFCQ_SELL_SIDE_LEG_SUMMARY LegInfo = new BV_PORTFOLIO_RFCQ_SELL_SIDE_LEG_SUMMARY();

	public BV_PORTFOLIO_RFCQ_SELL_SIDE_SUMMARY_LEG_INFO()
	{
	}

	public long getSellSideMemberId()
	{
		return SellSideMemberId;
	}
	public void setSellSideMemberId(long value)
	{
		SellSideMemberId = value;
	}
	public String getSellSideMemberCode()
	{
		return SellSideMemberCode;
	}
	public void setSellSideMemberCode(String value)
	{
		SellSideMemberCode = value;
	}
	public String getSellSideMemberDesc()
	{
		return SellSideMemberDesc;
	}
	public void setSellSideMemberDesc(String value)
	{
		SellSideMemberDesc = value;
	}
	public String getSellSideMemberShortDesc()
	{
		return SellSideMemberShortDesc;
	}
	public void setSellSideMemberShortDesc(String value)
	{
		SellSideMemberShortDesc = value;
	}
	public long getSellSideTraderId()
	{
		return SellSideTraderId;
	}
	public void setSellSideTraderId(long value)
	{
		SellSideTraderId = value;
	}
	public String getSellSideTraderName()
	{
		return SellSideTraderName;
	}
	public void setSellSideTraderName(String value)
	{
		SellSideTraderName = value;
	}
	public long getRfcqReqId()
	{
		return RfcqReqId;
	}
	public void setRfcqReqId(long value)
	{
		RfcqReqId = value;
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
	public short getLegId()
	{
		return LegId;
	}
	public void setLegId(short value)
	{
		LegId = value;
	}
	public BV_PORTFOLIO_RFCQ_SELL_SIDE_LEG_SUMMARY getLegInfo()
	{
		return LegInfo;
	}
	public void setLegInfo(BV_PORTFOLIO_RFCQ_SELL_SIDE_LEG_SUMMARY value)
	{
		LegInfo = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		SellSideMemberId = (long)byteBuffer.readInt();
		SellSideMemberCode = byteBuffer.readString();
		SellSideMemberDesc = byteBuffer.readString();
		SellSideMemberShortDesc = byteBuffer.readString();
		SellSideTraderId = (long)byteBuffer.readInt();
		SellSideTraderName = byteBuffer.readString();
		RfcqReqId = (long)byteBuffer.readInt();
		CreationDate = (long)byteBuffer.readInt();
		CreationTime = byteBuffer.readLong();
		LegId = (short)byteBuffer.readInt();
		LegInfo.readXDR(byteBuffer);
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(SellSideMemberId & 0xFFFFFFFFL));
		byteBuffer.writeString(SellSideMemberCode);
		byteBuffer.writeString(SellSideMemberDesc);
		byteBuffer.writeString(SellSideMemberShortDesc);
		byteBuffer.writeInt((int)(SellSideTraderId & 0xFFFFFFFFL));
		byteBuffer.writeString(SellSideTraderName);
		byteBuffer.writeInt((int)(RfcqReqId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(CreationDate & 0xFFFFFFFFL));
		byteBuffer.writeLong(CreationTime);
		byteBuffer.writeInt((int)(LegId & 0xFFFFL));
		LegInfo.writeXDR(byteBuffer);

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
		stringBuilder.append("BV_PORTFOLIO_RFCQ_SELL_SIDE_SUMMARY_LEG_INFO::");
		stringBuilder.append("SellSideMemberId(").append(SellSideMemberId).append(")");
		stringBuilder.append("SellSideMemberCode(").append(SellSideMemberCode).append(")");
		stringBuilder.append("SellSideMemberDesc(").append(SellSideMemberDesc).append(")");
		stringBuilder.append("SellSideMemberShortDesc(").append(SellSideMemberShortDesc).append(")");
		stringBuilder.append("SellSideTraderId(").append(SellSideTraderId).append(")");
		stringBuilder.append("SellSideTraderName(").append(SellSideTraderName).append(")");
		stringBuilder.append("RfcqReqId(").append(RfcqReqId).append(")");
		stringBuilder.append("CreationDate(").append(CreationDate).append(")");
		stringBuilder.append("CreationTime(").append(CreationTime).append(")");
		stringBuilder.append("LegId(").append(LegId).append(")");
		stringBuilder.append("LegInfo(").append(LegInfo.toString()).append(")");
		return stringBuilder.toString();
	}
}
