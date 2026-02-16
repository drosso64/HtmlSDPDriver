package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_PORTFOLIO_RFCQ_DEALER_LIST_PREVIEW extends SMPMessage
{
	public static final long CLASS_ID = 400077;

	private long PreviewId = 0;
	private long MemberId = 0;
	private long TraderId = 0;
	private String TraderName = "";
	private short NumOfLegs = 0;
	private BV_PORTFOLIO_RFCQ_DEALER_LIST_PREVIEW_LEG[] PreviewLeg = new BV_PORTFOLIO_RFCQ_DEALER_LIST_PREVIEW_LEG[200];
	private short NumOfDealers = 0;
	private BV_PORTFOLIO_RFCQ_DEALER_LIST_INFO[] DealerList = new BV_PORTFOLIO_RFCQ_DEALER_LIST_INFO[100];
	private BV_PORTFOLIO_RFCQ_CLOSING_TYPE_Enum ClosingType = BV_PORTFOLIO_RFCQ_CLOSING_TYPE_Enum.BV_PORTFOLIO_RFCQ_CLOSING_TYPE_None;

	public BV_PORTFOLIO_RFCQ_DEALER_LIST_PREVIEW()
	{
		for (int i=0; i < PreviewLeg.length; ++i)
		{
			PreviewLeg[i] = new BV_PORTFOLIO_RFCQ_DEALER_LIST_PREVIEW_LEG();
		}
		for (int i=0; i < DealerList.length; ++i)
		{
			DealerList[i] = new BV_PORTFOLIO_RFCQ_DEALER_LIST_INFO();
		}
	}

	public long getPreviewId()
	{
		return PreviewId;
	}
	public void setPreviewId(long value)
	{
		PreviewId = value;
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
	public BV_PORTFOLIO_RFCQ_DEALER_LIST_PREVIEW_LEG[] getPreviewLeg()
	{
		return PreviewLeg;
	}
	public void setPreviewLeg(BV_PORTFOLIO_RFCQ_DEALER_LIST_PREVIEW_LEG[] value)
	{
		PreviewLeg = value;
	}
	public short getNumOfDealers()
	{
		return NumOfDealers;
	}
	public void setNumOfDealers(short value)
	{
		NumOfDealers = value;
	}
	public BV_PORTFOLIO_RFCQ_DEALER_LIST_INFO[] getDealerList()
	{
		return DealerList;
	}
	public void setDealerList(BV_PORTFOLIO_RFCQ_DEALER_LIST_INFO[] value)
	{
		DealerList = value;
	}
	public BV_PORTFOLIO_RFCQ_CLOSING_TYPE_Enum getClosingType()
	{
		return ClosingType;
	}
	public void setClosingType(BV_PORTFOLIO_RFCQ_CLOSING_TYPE_Enum value)
	{
		ClosingType = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		PreviewId = (long)byteBuffer.readInt();
		MemberId = (long)byteBuffer.readInt();
		TraderId = (long)byteBuffer.readInt();
		TraderName = byteBuffer.readString();
		NumOfLegs = (short)byteBuffer.readInt();
		for (int i=0; i < PreviewLeg.length; ++i)
		{
			PreviewLeg[i].readXDR(byteBuffer);
		}
		NumOfDealers = (short)byteBuffer.readInt();
		for (int i=0; i < DealerList.length; ++i)
		{
			DealerList[i].readXDR(byteBuffer);
		}
		ClosingType = ClosingType.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(PreviewId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(MemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(TraderId & 0xFFFFFFFFL));
		byteBuffer.writeString(TraderName);
		byteBuffer.writeInt((int)(NumOfLegs & 0xFFFFL));
		for (int i=0; i < PreviewLeg.length; ++i)
		{
			PreviewLeg[i].writeXDR(byteBuffer);
		}
		byteBuffer.writeInt((int)(NumOfDealers & 0xFFFFL));
		for (int i=0; i < DealerList.length; ++i)
		{
			DealerList[i].writeXDR(byteBuffer);
		}
		byteBuffer.writeInt(ClosingType.getValue());

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
		stringBuilder.append("BV_PORTFOLIO_RFCQ_DEALER_LIST_PREVIEW::");
		stringBuilder.append("PreviewId(").append(PreviewId).append(")");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("TraderId(").append(TraderId).append(")");
		stringBuilder.append("TraderName(").append(TraderName).append(")");
		stringBuilder.append("NumOfLegs(").append(NumOfLegs).append(")");
		for (int i=0; i < PreviewLeg.length; ++i)
		{
			stringBuilder.append("PreviewLeg[").append(i).append("](").append(PreviewLeg[i].toString()).append(")");
		}
		stringBuilder.append("NumOfDealers(").append(NumOfDealers).append(")");
		for (int i=0; i < DealerList.length; ++i)
		{
			stringBuilder.append("DealerList[").append(i).append("](").append(DealerList[i].toString()).append(")");
		}
		stringBuilder.append("ClosingType(").append(ClosingType).append(")");
		return stringBuilder.toString();
	}
}
