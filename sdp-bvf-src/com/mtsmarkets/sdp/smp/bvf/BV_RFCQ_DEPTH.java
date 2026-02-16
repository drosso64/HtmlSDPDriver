package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_RFCQ_DEPTH extends SMPMessage
{
	public static final long CLASS_ID = 114163;

	private long RfcqReqId = 0;
	private long MemberId = 0;
	private long TraderId = 0;
	private TI_RFCQ_TYPE_Enum RfcqType = TI_RFCQ_TYPE_Enum.TI_RFCQ_TYPE_Outright;
	private long TradingListId = 0;
	private short LegId = 0;
	private BV_RFCQ_DEPTH_LEG[] DepthLeg = new BV_RFCQ_DEPTH_LEG[3];
	private BV_RFCQ_TRADING_LEVEL[] TradingLevel = new BV_RFCQ_TRADING_LEVEL[20];
	private long UpdateTime = 0;

	public BV_RFCQ_DEPTH()
	{
		for (int i=0; i < DepthLeg.length; ++i)
		{
			DepthLeg[i] = new BV_RFCQ_DEPTH_LEG();
		}
		for (int i=0; i < TradingLevel.length; ++i)
		{
			TradingLevel[i] = new BV_RFCQ_TRADING_LEVEL();
		}
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
	public BV_RFCQ_DEPTH_LEG[] getDepthLeg()
	{
		return DepthLeg;
	}
	public void setDepthLeg(BV_RFCQ_DEPTH_LEG[] value)
	{
		DepthLeg = value;
	}
	public BV_RFCQ_TRADING_LEVEL[] getTradingLevel()
	{
		return TradingLevel;
	}
	public void setTradingLevel(BV_RFCQ_TRADING_LEVEL[] value)
	{
		TradingLevel = value;
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
		RfcqReqId = (long)byteBuffer.readInt();
		MemberId = (long)byteBuffer.readInt();
		TraderId = (long)byteBuffer.readInt();
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
		UpdateTime = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(RfcqReqId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(MemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(TraderId & 0xFFFFFFFFL));
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
		stringBuilder.append("BV_RFCQ_DEPTH::");
		stringBuilder.append("RfcqReqId(").append(RfcqReqId).append(")");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("TraderId(").append(TraderId).append(")");
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
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		return stringBuilder.toString();
	}
}
