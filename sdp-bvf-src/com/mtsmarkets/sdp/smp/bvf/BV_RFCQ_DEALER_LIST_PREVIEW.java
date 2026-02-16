package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_RFCQ_DEALER_LIST_PREVIEW extends SMPMessage
{
	public static final long CLASS_ID = 400001;

	private long PreviewId = 0;
	private long MemberId = 0;
	private TI_FLAG_Enum PartialFillFg = TI_FLAG_Enum.TI_FLAG_No;
	private long TraderId = 0;
	private TI_RFCQ_TYPE_Enum RFCQType = TI_RFCQ_TYPE_Enum.TI_RFCQ_TYPE_Outright;
	private TI_FLAG_Enum PreAgreedFg = TI_FLAG_Enum.TI_FLAG_No;
	private TI_FLAG_Enum PreTradeFg = TI_FLAG_Enum.TI_FLAG_No;
	private BV_RFCQ_DEALER_LIST_PREVIEW_LEG[] PreviewLeg = new BV_RFCQ_DEALER_LIST_PREVIEW_LEG[3];
	private short NumOfDealers = 0;
	private BV_RFCQ_DEALER_SELECTION_TYPE_Enum DealerSelectionType = BV_RFCQ_DEALER_SELECTION_TYPE_Enum.BV_RFCQ_DEALER_SELECTION_Manual;
	private BV_TRANSPARENCY_INFO[] TransparencyInfo = new BV_TRANSPARENCY_INFO[3];
	private BV_DEALER_LIST_INFO[] DealerList = new BV_DEALER_LIST_INFO[100];

	public BV_RFCQ_DEALER_LIST_PREVIEW()
	{
		for (int i=0; i < PreviewLeg.length; ++i)
		{
			PreviewLeg[i] = new BV_RFCQ_DEALER_LIST_PREVIEW_LEG();
		}
		for (int i=0; i < TransparencyInfo.length; ++i)
		{
			TransparencyInfo[i] = new BV_TRANSPARENCY_INFO();
		}
		for (int i=0; i < DealerList.length; ++i)
		{
			DealerList[i] = new BV_DEALER_LIST_INFO();
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
	public TI_FLAG_Enum getPartialFillFg()
	{
		return PartialFillFg;
	}
	public void setPartialFillFg(TI_FLAG_Enum value)
	{
		PartialFillFg = value;
	}
	public long getTraderId()
	{
		return TraderId;
	}
	public void setTraderId(long value)
	{
		TraderId = value;
	}
	public TI_RFCQ_TYPE_Enum getRFCQType()
	{
		return RFCQType;
	}
	public void setRFCQType(TI_RFCQ_TYPE_Enum value)
	{
		RFCQType = value;
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
	public BV_RFCQ_DEALER_LIST_PREVIEW_LEG[] getPreviewLeg()
	{
		return PreviewLeg;
	}
	public void setPreviewLeg(BV_RFCQ_DEALER_LIST_PREVIEW_LEG[] value)
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
	public BV_RFCQ_DEALER_SELECTION_TYPE_Enum getDealerSelectionType()
	{
		return DealerSelectionType;
	}
	public void setDealerSelectionType(BV_RFCQ_DEALER_SELECTION_TYPE_Enum value)
	{
		DealerSelectionType = value;
	}
	public BV_TRANSPARENCY_INFO[] getTransparencyInfo()
	{
		return TransparencyInfo;
	}
	public void setTransparencyInfo(BV_TRANSPARENCY_INFO[] value)
	{
		TransparencyInfo = value;
	}
	public BV_DEALER_LIST_INFO[] getDealerList()
	{
		return DealerList;
	}
	public void setDealerList(BV_DEALER_LIST_INFO[] value)
	{
		DealerList = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		PreviewId = (long)byteBuffer.readInt();
		MemberId = (long)byteBuffer.readInt();
		PartialFillFg = PartialFillFg.getEnum(byteBuffer.readInt());
		TraderId = (long)byteBuffer.readInt();
		RFCQType = RFCQType.getEnum(byteBuffer.readInt());
		PreAgreedFg = PreAgreedFg.getEnum(byteBuffer.readInt());
		PreTradeFg = PreTradeFg.getEnum(byteBuffer.readInt());
		for (int i=0; i < PreviewLeg.length; ++i)
		{
			PreviewLeg[i].readXDR(byteBuffer);
		}
		NumOfDealers = (short)byteBuffer.readInt();
		DealerSelectionType = DealerSelectionType.getEnum(byteBuffer.readInt());
		for (int i=0; i < TransparencyInfo.length; ++i)
		{
			TransparencyInfo[i].readXDR(byteBuffer);
		}
		for (int i=0; i < DealerList.length; ++i)
		{
			DealerList[i].readXDR(byteBuffer);
		}
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(PreviewId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(MemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt(PartialFillFg.getValue());
		byteBuffer.writeInt((int)(TraderId & 0xFFFFFFFFL));
		byteBuffer.writeInt(RFCQType.getValue());
		byteBuffer.writeInt(PreAgreedFg.getValue());
		byteBuffer.writeInt(PreTradeFg.getValue());
		for (int i=0; i < PreviewLeg.length; ++i)
		{
			PreviewLeg[i].writeXDR(byteBuffer);
		}
		byteBuffer.writeInt((int)(NumOfDealers & 0xFFFFL));
		byteBuffer.writeInt(DealerSelectionType.getValue());
		for (int i=0; i < TransparencyInfo.length; ++i)
		{
			TransparencyInfo[i].writeXDR(byteBuffer);
		}
		for (int i=0; i < DealerList.length; ++i)
		{
			DealerList[i].writeXDR(byteBuffer);
		}

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
		stringBuilder.append("BV_RFCQ_DEALER_LIST_PREVIEW::");
		stringBuilder.append("PreviewId(").append(PreviewId).append(")");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("PartialFillFg(").append(PartialFillFg).append(")");
		stringBuilder.append("TraderId(").append(TraderId).append(")");
		stringBuilder.append("RFCQType(").append(RFCQType).append(")");
		stringBuilder.append("PreAgreedFg(").append(PreAgreedFg).append(")");
		stringBuilder.append("PreTradeFg(").append(PreTradeFg).append(")");
		for (int i=0; i < PreviewLeg.length; ++i)
		{
			stringBuilder.append("PreviewLeg[").append(i).append("](").append(PreviewLeg[i].toString()).append(")");
		}
		stringBuilder.append("NumOfDealers(").append(NumOfDealers).append(")");
		stringBuilder.append("DealerSelectionType(").append(DealerSelectionType).append(")");
		for (int i=0; i < TransparencyInfo.length; ++i)
		{
			stringBuilder.append("TransparencyInfo[").append(i).append("](").append(TransparencyInfo[i].toString()).append(")");
		}
		for (int i=0; i < DealerList.length; ++i)
		{
			stringBuilder.append("DealerList[").append(i).append("](").append(DealerList[i].toString()).append(")");
		}
		return stringBuilder.toString();
	}
}
