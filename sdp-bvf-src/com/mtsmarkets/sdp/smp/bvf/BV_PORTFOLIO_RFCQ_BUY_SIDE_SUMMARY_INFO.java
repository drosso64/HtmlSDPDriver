package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_PORTFOLIO_RFCQ_BUY_SIDE_SUMMARY_INFO extends SMPMessage
{
	public static final long CLASS_ID = 410025;

	private TI_MSG_INFO RfcqReqMsgInfo = new TI_MSG_INFO();
	private long BuySideMemberId = 0;
	private String BuySideMemberCode = "";
	private String BuySideMemberDesc = "";
	private String BuySideMemberShortDesc = "";
	private long BuySideTraderId = 0;
	private String BuySideTraderName = "";
	private BV_PORTFOLIO_RFCQ_CLOSING_TYPE_Enum ClosingType = BV_PORTFOLIO_RFCQ_CLOSING_TYPE_Enum.BV_PORTFOLIO_RFCQ_CLOSING_TYPE_None;
	private TI_FLAG_Enum PreAgreedFg = TI_FLAG_Enum.TI_FLAG_No;
	private short DueInTime = 0;
	private long DueInTimeout = 0;
	private long SellSideMemberId = 0;
	private String SellSideMemberCode = "";
	private String SellSideMemberDesc = "";
	private String SellSideMemberShortDesc = "";
	private String SellSideTraderName = "";
	private BV_PORTFOLIO_RFCQ_REQUEST_STATUS_Enum FinalStatus = BV_PORTFOLIO_RFCQ_REQUEST_STATUS_Enum.BV_PORTFOLIO_RFCQ_REQUEST_STATUS_Processing;
	private double RefNetProceeds = 0;
	private String RefNetProceedsCurrency = "";
	private String PortfolioProceedsCurrency = "";
	private double NetProceeds = 0;
	private BV_VALUE BVMidNetProceeds = new BV_VALUE();
	private double NetProceedsCoverValue = 0;
	private long ClosingTime = 0;
	private short SellSideNr = 0;
	private short ParticipatingSellSideNr = 0;
	private short QuotingSellSideNr = 0;
	private String ClientRfcqId = "";
	private long BookTimestamp = 0;
	private TI_FLAG_Enum BestExecutionFg = TI_FLAG_Enum.TI_FLAG_No;
	private short NumOfLegs = 0;
	private BV_PORTFOLIO_RFCQ_PROVIDER_INFO[] ProviderInfo = new BV_PORTFOLIO_RFCQ_PROVIDER_INFO[10];
	private BV_PORTFOLIO_RFCQ_DEALER_LIST_INFO[] PreviewDealerListInfo = new BV_PORTFOLIO_RFCQ_DEALER_LIST_INFO[100];
	private short AreaCodeId = 0;
	private short MOCAcceptanceTime = 0;
	private String UserInfo1 = "";
	private String UserInfo2 = "";

	public BV_PORTFOLIO_RFCQ_BUY_SIDE_SUMMARY_INFO()
	{
		for (int i=0; i < ProviderInfo.length; ++i)
		{
			ProviderInfo[i] = new BV_PORTFOLIO_RFCQ_PROVIDER_INFO();
		}
		for (int i=0; i < PreviewDealerListInfo.length; ++i)
		{
			PreviewDealerListInfo[i] = new BV_PORTFOLIO_RFCQ_DEALER_LIST_INFO();
		}
	}

	public TI_MSG_INFO getRfcqReqMsgInfo()
	{
		return RfcqReqMsgInfo;
	}
	public void setRfcqReqMsgInfo(TI_MSG_INFO value)
	{
		RfcqReqMsgInfo = value;
	}
	public long getBuySideMemberId()
	{
		return BuySideMemberId;
	}
	public void setBuySideMemberId(long value)
	{
		BuySideMemberId = value;
	}
	public String getBuySideMemberCode()
	{
		return BuySideMemberCode;
	}
	public void setBuySideMemberCode(String value)
	{
		BuySideMemberCode = value;
	}
	public String getBuySideMemberDesc()
	{
		return BuySideMemberDesc;
	}
	public void setBuySideMemberDesc(String value)
	{
		BuySideMemberDesc = value;
	}
	public String getBuySideMemberShortDesc()
	{
		return BuySideMemberShortDesc;
	}
	public void setBuySideMemberShortDesc(String value)
	{
		BuySideMemberShortDesc = value;
	}
	public long getBuySideTraderId()
	{
		return BuySideTraderId;
	}
	public void setBuySideTraderId(long value)
	{
		BuySideTraderId = value;
	}
	public String getBuySideTraderName()
	{
		return BuySideTraderName;
	}
	public void setBuySideTraderName(String value)
	{
		BuySideTraderName = value;
	}
	public BV_PORTFOLIO_RFCQ_CLOSING_TYPE_Enum getClosingType()
	{
		return ClosingType;
	}
	public void setClosingType(BV_PORTFOLIO_RFCQ_CLOSING_TYPE_Enum value)
	{
		ClosingType = value;
	}
	public TI_FLAG_Enum getPreAgreedFg()
	{
		return PreAgreedFg;
	}
	public void setPreAgreedFg(TI_FLAG_Enum value)
	{
		PreAgreedFg = value;
	}
	public short getDueInTime()
	{
		return DueInTime;
	}
	public void setDueInTime(short value)
	{
		DueInTime = value;
	}
	public long getDueInTimeout()
	{
		return DueInTimeout;
	}
	public void setDueInTimeout(long value)
	{
		DueInTimeout = value;
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
	public String getSellSideTraderName()
	{
		return SellSideTraderName;
	}
	public void setSellSideTraderName(String value)
	{
		SellSideTraderName = value;
	}
	public BV_PORTFOLIO_RFCQ_REQUEST_STATUS_Enum getFinalStatus()
	{
		return FinalStatus;
	}
	public void setFinalStatus(BV_PORTFOLIO_RFCQ_REQUEST_STATUS_Enum value)
	{
		FinalStatus = value;
	}
	public double getRefNetProceeds()
	{
		return RefNetProceeds;
	}
	public void setRefNetProceeds(double value)
	{
		RefNetProceeds = value;
	}
	public String getRefNetProceedsCurrency()
	{
		return RefNetProceedsCurrency;
	}
	public void setRefNetProceedsCurrency(String value)
	{
		RefNetProceedsCurrency = value;
	}
	public String getPortfolioProceedsCurrency()
	{
		return PortfolioProceedsCurrency;
	}
	public void setPortfolioProceedsCurrency(String value)
	{
		PortfolioProceedsCurrency = value;
	}
	public double getNetProceeds()
	{
		return NetProceeds;
	}
	public void setNetProceeds(double value)
	{
		NetProceeds = value;
	}
	public BV_VALUE getBVMidNetProceeds()
	{
		return BVMidNetProceeds;
	}
	public void setBVMidNetProceeds(BV_VALUE value)
	{
		BVMidNetProceeds = value;
	}
	public double getNetProceedsCoverValue()
	{
		return NetProceedsCoverValue;
	}
	public void setNetProceedsCoverValue(double value)
	{
		NetProceedsCoverValue = value;
	}
	public long getClosingTime()
	{
		return ClosingTime;
	}
	public void setClosingTime(long value)
	{
		ClosingTime = value;
	}
	public short getSellSideNr()
	{
		return SellSideNr;
	}
	public void setSellSideNr(short value)
	{
		SellSideNr = value;
	}
	public short getParticipatingSellSideNr()
	{
		return ParticipatingSellSideNr;
	}
	public void setParticipatingSellSideNr(short value)
	{
		ParticipatingSellSideNr = value;
	}
	public short getQuotingSellSideNr()
	{
		return QuotingSellSideNr;
	}
	public void setQuotingSellSideNr(short value)
	{
		QuotingSellSideNr = value;
	}
	public String getClientRfcqId()
	{
		return ClientRfcqId;
	}
	public void setClientRfcqId(String value)
	{
		ClientRfcqId = value;
	}
	public long getBookTimestamp()
	{
		return BookTimestamp;
	}
	public void setBookTimestamp(long value)
	{
		BookTimestamp = value;
	}
	public TI_FLAG_Enum getBestExecutionFg()
	{
		return BestExecutionFg;
	}
	public void setBestExecutionFg(TI_FLAG_Enum value)
	{
		BestExecutionFg = value;
	}
	public short getNumOfLegs()
	{
		return NumOfLegs;
	}
	public void setNumOfLegs(short value)
	{
		NumOfLegs = value;
	}
	public BV_PORTFOLIO_RFCQ_PROVIDER_INFO[] getProviderInfo()
	{
		return ProviderInfo;
	}
	public void setProviderInfo(BV_PORTFOLIO_RFCQ_PROVIDER_INFO[] value)
	{
		ProviderInfo = value;
	}
	public BV_PORTFOLIO_RFCQ_DEALER_LIST_INFO[] getPreviewDealerListInfo()
	{
		return PreviewDealerListInfo;
	}
	public void setPreviewDealerListInfo(BV_PORTFOLIO_RFCQ_DEALER_LIST_INFO[] value)
	{
		PreviewDealerListInfo = value;
	}
	public short getAreaCodeId()
	{
		return AreaCodeId;
	}
	public void setAreaCodeId(short value)
	{
		AreaCodeId = value;
	}
	public short getMOCAcceptanceTime()
	{
		return MOCAcceptanceTime;
	}
	public void setMOCAcceptanceTime(short value)
	{
		MOCAcceptanceTime = value;
	}
	public String getUserInfo1()
	{
		return UserInfo1;
	}
	public void setUserInfo1(String value)
	{
		UserInfo1 = value;
	}
	public String getUserInfo2()
	{
		return UserInfo2;
	}
	public void setUserInfo2(String value)
	{
		UserInfo2 = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		RfcqReqMsgInfo.readXDR(byteBuffer);
		BuySideMemberId = (long)byteBuffer.readInt();
		BuySideMemberCode = byteBuffer.readString();
		BuySideMemberDesc = byteBuffer.readString();
		BuySideMemberShortDesc = byteBuffer.readString();
		BuySideTraderId = (long)byteBuffer.readInt();
		BuySideTraderName = byteBuffer.readString();
		ClosingType = ClosingType.getEnum(byteBuffer.readInt());
		PreAgreedFg = PreAgreedFg.getEnum(byteBuffer.readInt());
		DueInTime = (short)byteBuffer.readInt();
		DueInTimeout = byteBuffer.readLong();
		SellSideMemberId = (long)byteBuffer.readInt();
		SellSideMemberCode = byteBuffer.readString();
		SellSideMemberDesc = byteBuffer.readString();
		SellSideMemberShortDesc = byteBuffer.readString();
		SellSideTraderName = byteBuffer.readString();
		FinalStatus = FinalStatus.getEnum(byteBuffer.readInt());
		RefNetProceeds = byteBuffer.readDouble();
		RefNetProceedsCurrency = byteBuffer.readString();
		PortfolioProceedsCurrency = byteBuffer.readString();
		NetProceeds = byteBuffer.readDouble();
		BVMidNetProceeds.readXDR(byteBuffer);
		NetProceedsCoverValue = byteBuffer.readDouble();
		ClosingTime = byteBuffer.readLong();
		SellSideNr = (short)byteBuffer.readInt();
		ParticipatingSellSideNr = (short)byteBuffer.readInt();
		QuotingSellSideNr = (short)byteBuffer.readInt();
		ClientRfcqId = byteBuffer.readString();
		BookTimestamp = byteBuffer.readLong();
		BestExecutionFg = BestExecutionFg.getEnum(byteBuffer.readInt());
		NumOfLegs = (short)byteBuffer.readInt();
		for (int i=0; i < ProviderInfo.length; ++i)
		{
			ProviderInfo[i].readXDR(byteBuffer);
		}
		for (int i=0; i < PreviewDealerListInfo.length; ++i)
		{
			PreviewDealerListInfo[i].readXDR(byteBuffer);
		}
		AreaCodeId = (short)byteBuffer.readInt();
		MOCAcceptanceTime = (short)byteBuffer.readInt();
		UserInfo1 = byteBuffer.readString();
		UserInfo2 = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		RfcqReqMsgInfo.writeXDR(byteBuffer);
		byteBuffer.writeInt((int)(BuySideMemberId & 0xFFFFFFFFL));
		byteBuffer.writeString(BuySideMemberCode);
		byteBuffer.writeString(BuySideMemberDesc);
		byteBuffer.writeString(BuySideMemberShortDesc);
		byteBuffer.writeInt((int)(BuySideTraderId & 0xFFFFFFFFL));
		byteBuffer.writeString(BuySideTraderName);
		byteBuffer.writeInt(ClosingType.getValue());
		byteBuffer.writeInt(PreAgreedFg.getValue());
		byteBuffer.writeInt((int)(DueInTime & 0xFFFFL));
		byteBuffer.writeLong(DueInTimeout);
		byteBuffer.writeInt((int)(SellSideMemberId & 0xFFFFFFFFL));
		byteBuffer.writeString(SellSideMemberCode);
		byteBuffer.writeString(SellSideMemberDesc);
		byteBuffer.writeString(SellSideMemberShortDesc);
		byteBuffer.writeString(SellSideTraderName);
		byteBuffer.writeInt(FinalStatus.getValue());
		byteBuffer.writeDouble(RefNetProceeds);
		byteBuffer.writeString(RefNetProceedsCurrency);
		byteBuffer.writeString(PortfolioProceedsCurrency);
		byteBuffer.writeDouble(NetProceeds);
		BVMidNetProceeds.writeXDR(byteBuffer);
		byteBuffer.writeDouble(NetProceedsCoverValue);
		byteBuffer.writeLong(ClosingTime);
		byteBuffer.writeInt((int)(SellSideNr & 0xFFFFL));
		byteBuffer.writeInt((int)(ParticipatingSellSideNr & 0xFFFFL));
		byteBuffer.writeInt((int)(QuotingSellSideNr & 0xFFFFL));
		byteBuffer.writeString(ClientRfcqId);
		byteBuffer.writeLong(BookTimestamp);
		byteBuffer.writeInt(BestExecutionFg.getValue());
		byteBuffer.writeInt((int)(NumOfLegs & 0xFFFFL));
		for (int i=0; i < ProviderInfo.length; ++i)
		{
			ProviderInfo[i].writeXDR(byteBuffer);
		}
		for (int i=0; i < PreviewDealerListInfo.length; ++i)
		{
			PreviewDealerListInfo[i].writeXDR(byteBuffer);
		}
		byteBuffer.writeInt((int)(AreaCodeId & 0xFFFFL));
		byteBuffer.writeInt((int)(MOCAcceptanceTime & 0xFFFFL));
		byteBuffer.writeString(UserInfo1);
		byteBuffer.writeString(UserInfo2);

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
		stringBuilder.append("BV_PORTFOLIO_RFCQ_BUY_SIDE_SUMMARY_INFO::");
		stringBuilder.append("RfcqReqMsgInfo(").append(RfcqReqMsgInfo.toString()).append(")");
		stringBuilder.append("BuySideMemberId(").append(BuySideMemberId).append(")");
		stringBuilder.append("BuySideMemberCode(").append(BuySideMemberCode).append(")");
		stringBuilder.append("BuySideMemberDesc(").append(BuySideMemberDesc).append(")");
		stringBuilder.append("BuySideMemberShortDesc(").append(BuySideMemberShortDesc).append(")");
		stringBuilder.append("BuySideTraderId(").append(BuySideTraderId).append(")");
		stringBuilder.append("BuySideTraderName(").append(BuySideTraderName).append(")");
		stringBuilder.append("ClosingType(").append(ClosingType).append(")");
		stringBuilder.append("PreAgreedFg(").append(PreAgreedFg).append(")");
		stringBuilder.append("DueInTime(").append(DueInTime).append(")");
		stringBuilder.append("DueInTimeout(").append(DueInTimeout).append(")");
		stringBuilder.append("SellSideMemberId(").append(SellSideMemberId).append(")");
		stringBuilder.append("SellSideMemberCode(").append(SellSideMemberCode).append(")");
		stringBuilder.append("SellSideMemberDesc(").append(SellSideMemberDesc).append(")");
		stringBuilder.append("SellSideMemberShortDesc(").append(SellSideMemberShortDesc).append(")");
		stringBuilder.append("SellSideTraderName(").append(SellSideTraderName).append(")");
		stringBuilder.append("FinalStatus(").append(FinalStatus).append(")");
		stringBuilder.append("RefNetProceeds(").append(RefNetProceeds).append(")");
		stringBuilder.append("RefNetProceedsCurrency(").append(RefNetProceedsCurrency).append(")");
		stringBuilder.append("PortfolioProceedsCurrency(").append(PortfolioProceedsCurrency).append(")");
		stringBuilder.append("NetProceeds(").append(NetProceeds).append(")");
		stringBuilder.append("BVMidNetProceeds(").append(BVMidNetProceeds.toString()).append(")");
		stringBuilder.append("NetProceedsCoverValue(").append(NetProceedsCoverValue).append(")");
		stringBuilder.append("ClosingTime(").append(ClosingTime).append(")");
		stringBuilder.append("SellSideNr(").append(SellSideNr).append(")");
		stringBuilder.append("ParticipatingSellSideNr(").append(ParticipatingSellSideNr).append(")");
		stringBuilder.append("QuotingSellSideNr(").append(QuotingSellSideNr).append(")");
		stringBuilder.append("ClientRfcqId(").append(ClientRfcqId).append(")");
		stringBuilder.append("BookTimestamp(").append(BookTimestamp).append(")");
		stringBuilder.append("BestExecutionFg(").append(BestExecutionFg).append(")");
		stringBuilder.append("NumOfLegs(").append(NumOfLegs).append(")");
		for (int i=0; i < ProviderInfo.length; ++i)
		{
			stringBuilder.append("ProviderInfo[").append(i).append("](").append(ProviderInfo[i].toString()).append(")");
		}
		for (int i=0; i < PreviewDealerListInfo.length; ++i)
		{
			stringBuilder.append("PreviewDealerListInfo[").append(i).append("](").append(PreviewDealerListInfo[i].toString()).append(")");
		}
		stringBuilder.append("AreaCodeId(").append(AreaCodeId).append(")");
		stringBuilder.append("MOCAcceptanceTime(").append(MOCAcceptanceTime).append(")");
		stringBuilder.append("UserInfo1(").append(UserInfo1).append(")");
		stringBuilder.append("UserInfo2(").append(UserInfo2).append(")");
		return stringBuilder.toString();
	}
}
