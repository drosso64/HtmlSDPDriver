package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_PORTFOLIO_RFCQ_DEPTH extends SMPMessage
{
	public static final long CLASS_ID = 400081;

	private long RfcqReqId = 0;
	private long MemberId = 0;
	private long TraderId = 0;
	private String TraderName = "";
	private short NumOfLegs = 0;
	private BV_PORTFOLIO_RFCQ_DEPTH_LEG[] DepthLeg = new BV_PORTFOLIO_RFCQ_DEPTH_LEG[200];
	private short NumTradingLevel = 0;
	private BV_PORTFOLIO_RFCQ_TRADING_LEVEL[] TradingLevel = new BV_PORTFOLIO_RFCQ_TRADING_LEVEL[10];
	private BV_VALUE BVMidNetProceeds = new BV_VALUE();
	private long UpdateTime = 0;

	public BV_PORTFOLIO_RFCQ_DEPTH()
	{
		for (int i=0; i < DepthLeg.length; ++i)
		{
			DepthLeg[i] = new BV_PORTFOLIO_RFCQ_DEPTH_LEG();
		}
		for (int i=0; i < TradingLevel.length; ++i)
		{
			TradingLevel[i] = new BV_PORTFOLIO_RFCQ_TRADING_LEVEL();
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
	public String getTraderName()
	{
		return TraderName;
	}
	public void setTraderName(String value)
	{
		TraderName = value;
	}
	public short getNumOfLegs()
	{
		return NumOfLegs;
	}
	public void setNumOfLegs(short value)
	{
		NumOfLegs = value;
	}
	public BV_PORTFOLIO_RFCQ_DEPTH_LEG[] getDepthLeg()
	{
		return DepthLeg;
	}
	public void setDepthLeg(BV_PORTFOLIO_RFCQ_DEPTH_LEG[] value)
	{
		DepthLeg = value;
	}
	public short getNumTradingLevel()
	{
		return NumTradingLevel;
	}
	public void setNumTradingLevel(short value)
	{
		NumTradingLevel = value;
	}
	public BV_PORTFOLIO_RFCQ_TRADING_LEVEL[] getTradingLevel()
	{
		return TradingLevel;
	}
	public void setTradingLevel(BV_PORTFOLIO_RFCQ_TRADING_LEVEL[] value)
	{
		TradingLevel = value;
	}
	public BV_VALUE getBVMidNetProceeds()
	{
		return BVMidNetProceeds;
	}
	public void setBVMidNetProceeds(BV_VALUE value)
	{
		BVMidNetProceeds = value;
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
		TraderName = byteBuffer.readString();
		NumOfLegs = (short)byteBuffer.readInt();
		for (int i=0; i < DepthLeg.length; ++i)
		{
			DepthLeg[i].readXDR(byteBuffer);
		}
		NumTradingLevel = (short)byteBuffer.readInt();
		for (int i=0; i < TradingLevel.length; ++i)
		{
			TradingLevel[i].readXDR(byteBuffer);
		}
		BVMidNetProceeds.readXDR(byteBuffer);
		UpdateTime = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(RfcqReqId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(MemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(TraderId & 0xFFFFFFFFL));
		byteBuffer.writeString(TraderName);
		byteBuffer.writeInt((int)(NumOfLegs & 0xFFFFL));
		for (int i=0; i < DepthLeg.length; ++i)
		{
			DepthLeg[i].writeXDR(byteBuffer);
		}
		byteBuffer.writeInt((int)(NumTradingLevel & 0xFFFFL));
		for (int i=0; i < TradingLevel.length; ++i)
		{
			TradingLevel[i].writeXDR(byteBuffer);
		}
		BVMidNetProceeds.writeXDR(byteBuffer);
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
		stringBuilder.append("BV_PORTFOLIO_RFCQ_DEPTH::");
		stringBuilder.append("RfcqReqId(").append(RfcqReqId).append(")");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("TraderId(").append(TraderId).append(")");
		stringBuilder.append("TraderName(").append(TraderName).append(")");
		stringBuilder.append("NumOfLegs(").append(NumOfLegs).append(")");
		for (int i=0; i < DepthLeg.length; ++i)
		{
			stringBuilder.append("DepthLeg[").append(i).append("](").append(DepthLeg[i].toString()).append(")");
		}
		stringBuilder.append("NumTradingLevel(").append(NumTradingLevel).append(")");
		for (int i=0; i < TradingLevel.length; ++i)
		{
			stringBuilder.append("TradingLevel[").append(i).append("](").append(TradingLevel[i].toString()).append(")");
		}
		stringBuilder.append("BVMidNetProceeds(").append(BVMidNetProceeds.toString()).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		return stringBuilder.toString();
	}
}
