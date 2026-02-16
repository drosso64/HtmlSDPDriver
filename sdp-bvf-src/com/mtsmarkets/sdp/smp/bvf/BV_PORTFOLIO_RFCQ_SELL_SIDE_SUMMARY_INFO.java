package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_PORTFOLIO_RFCQ_SELL_SIDE_SUMMARY_INFO extends SMPMessage
{
	public static final long CLASS_ID = 410030;

	private long SellSideMemberId = 0;
	private String SellSideMemberCode = "";
	private String SellSideMemberDesc = "";
	private String SellSideMemberShortDesc = "";
	private long SellSideTraderId = 0;
	private String SellSideTraderName = "";
	private BV_PORTFOLIO_RFCQ_CLOSING_TYPE_Enum ClosingType = BV_PORTFOLIO_RFCQ_CLOSING_TYPE_Enum.BV_PORTFOLIO_RFCQ_CLOSING_TYPE_None;
	private long RfcqReqId = 0;
	private long CreationDate = 0;
	private long CreationTime = 0;
	private short DueInTime = 0;
	private long DueInTimeout = 0;
	private TI_FLAG_Enum PreAgreedFg = TI_FLAG_Enum.TI_FLAG_No;
	private long BuySideMemberId = 0;
	private String BuySideMemberCode = "";
	private String BuySideMemberDesc = "";
	private String BuySideMemberShortDesc = "";
	private String BuySideTraderName = "";
	private BV_PORTFOLIO_RFCQ_REQUEST_STATUS_Enum FinalStatus = BV_PORTFOLIO_RFCQ_REQUEST_STATUS_Enum.BV_PORTFOLIO_RFCQ_REQUEST_STATUS_Processing;
	private BV_PORTFOLIO_RFCQ_PROVIDER_STATUS_Enum ProviderStatus = BV_PORTFOLIO_RFCQ_PROVIDER_STATUS_Enum.BV_PORTFOLIO_RFCQ_PROVIDER_STATUS_None;
	private long ClosingTime = 0;
	private short SellSideNr = 0;
	private short ParticipatingSellSideNr = 0;
	private short QuotingSellSideNr = 0;
	private String PortfolioProceedsCurrency = "";
	private double NetProceeds = 0;
	private BV_VALUE BVMidNetProceeds = new BV_VALUE();
	private BV_RFCQ_COVER_INFO PriceCoverInfo = new BV_RFCQ_COVER_INFO();
	private BV_ALGO_INFO AlgoInfo = new BV_ALGO_INFO();
	private BV_CLIENT_IDENTIFICATION_INFO ClientIdentificationInfo = new BV_CLIENT_IDENTIFICATION_INFO();
	private short NumOfLegs = 0;
	private short AreaCodeId = 0;
	private short MOCAcceptanceTime = 0;
	private String Comment = "";

	public BV_PORTFOLIO_RFCQ_SELL_SIDE_SUMMARY_INFO()
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
	public BV_PORTFOLIO_RFCQ_CLOSING_TYPE_Enum getClosingType()
	{
		return ClosingType;
	}
	public void setClosingType(BV_PORTFOLIO_RFCQ_CLOSING_TYPE_Enum value)
	{
		ClosingType = value;
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
	public TI_FLAG_Enum getPreAgreedFg()
	{
		return PreAgreedFg;
	}
	public void setPreAgreedFg(TI_FLAG_Enum value)
	{
		PreAgreedFg = value;
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
	public String getBuySideTraderName()
	{
		return BuySideTraderName;
	}
	public void setBuySideTraderName(String value)
	{
		BuySideTraderName = value;
	}
	public BV_PORTFOLIO_RFCQ_REQUEST_STATUS_Enum getFinalStatus()
	{
		return FinalStatus;
	}
	public void setFinalStatus(BV_PORTFOLIO_RFCQ_REQUEST_STATUS_Enum value)
	{
		FinalStatus = value;
	}
	public BV_PORTFOLIO_RFCQ_PROVIDER_STATUS_Enum getProviderStatus()
	{
		return ProviderStatus;
	}
	public void setProviderStatus(BV_PORTFOLIO_RFCQ_PROVIDER_STATUS_Enum value)
	{
		ProviderStatus = value;
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
	public BV_RFCQ_COVER_INFO getPriceCoverInfo()
	{
		return PriceCoverInfo;
	}
	public void setPriceCoverInfo(BV_RFCQ_COVER_INFO value)
	{
		PriceCoverInfo = value;
	}
	public BV_ALGO_INFO getAlgoInfo()
	{
		return AlgoInfo;
	}
	public void setAlgoInfo(BV_ALGO_INFO value)
	{
		AlgoInfo = value;
	}
	public BV_CLIENT_IDENTIFICATION_INFO getClientIdentificationInfo()
	{
		return ClientIdentificationInfo;
	}
	public void setClientIdentificationInfo(BV_CLIENT_IDENTIFICATION_INFO value)
	{
		ClientIdentificationInfo = value;
	}
	public short getNumOfLegs()
	{
		return NumOfLegs;
	}
	public void setNumOfLegs(short value)
	{
		NumOfLegs = value;
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
	public String getComment()
	{
		return Comment;
	}
	public void setComment(String value)
	{
		Comment = value;
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
		ClosingType = ClosingType.getEnum(byteBuffer.readInt());
		RfcqReqId = (long)byteBuffer.readInt();
		CreationDate = (long)byteBuffer.readInt();
		CreationTime = byteBuffer.readLong();
		DueInTime = (short)byteBuffer.readInt();
		DueInTimeout = byteBuffer.readLong();
		PreAgreedFg = PreAgreedFg.getEnum(byteBuffer.readInt());
		BuySideMemberId = (long)byteBuffer.readInt();
		BuySideMemberCode = byteBuffer.readString();
		BuySideMemberDesc = byteBuffer.readString();
		BuySideMemberShortDesc = byteBuffer.readString();
		BuySideTraderName = byteBuffer.readString();
		FinalStatus = FinalStatus.getEnum(byteBuffer.readInt());
		ProviderStatus = ProviderStatus.getEnum(byteBuffer.readInt());
		ClosingTime = byteBuffer.readLong();
		SellSideNr = (short)byteBuffer.readInt();
		ParticipatingSellSideNr = (short)byteBuffer.readInt();
		QuotingSellSideNr = (short)byteBuffer.readInt();
		PortfolioProceedsCurrency = byteBuffer.readString();
		NetProceeds = byteBuffer.readDouble();
		BVMidNetProceeds.readXDR(byteBuffer);
		PriceCoverInfo.readXDR(byteBuffer);
		AlgoInfo.readXDR(byteBuffer);
		ClientIdentificationInfo.readXDR(byteBuffer);
		NumOfLegs = (short)byteBuffer.readInt();
		AreaCodeId = (short)byteBuffer.readInt();
		MOCAcceptanceTime = (short)byteBuffer.readInt();
		Comment = byteBuffer.readString();
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
		byteBuffer.writeInt(ClosingType.getValue());
		byteBuffer.writeInt((int)(RfcqReqId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(CreationDate & 0xFFFFFFFFL));
		byteBuffer.writeLong(CreationTime);
		byteBuffer.writeInt((int)(DueInTime & 0xFFFFL));
		byteBuffer.writeLong(DueInTimeout);
		byteBuffer.writeInt(PreAgreedFg.getValue());
		byteBuffer.writeInt((int)(BuySideMemberId & 0xFFFFFFFFL));
		byteBuffer.writeString(BuySideMemberCode);
		byteBuffer.writeString(BuySideMemberDesc);
		byteBuffer.writeString(BuySideMemberShortDesc);
		byteBuffer.writeString(BuySideTraderName);
		byteBuffer.writeInt(FinalStatus.getValue());
		byteBuffer.writeInt(ProviderStatus.getValue());
		byteBuffer.writeLong(ClosingTime);
		byteBuffer.writeInt((int)(SellSideNr & 0xFFFFL));
		byteBuffer.writeInt((int)(ParticipatingSellSideNr & 0xFFFFL));
		byteBuffer.writeInt((int)(QuotingSellSideNr & 0xFFFFL));
		byteBuffer.writeString(PortfolioProceedsCurrency);
		byteBuffer.writeDouble(NetProceeds);
		BVMidNetProceeds.writeXDR(byteBuffer);
		PriceCoverInfo.writeXDR(byteBuffer);
		AlgoInfo.writeXDR(byteBuffer);
		ClientIdentificationInfo.writeXDR(byteBuffer);
		byteBuffer.writeInt((int)(NumOfLegs & 0xFFFFL));
		byteBuffer.writeInt((int)(AreaCodeId & 0xFFFFL));
		byteBuffer.writeInt((int)(MOCAcceptanceTime & 0xFFFFL));
		byteBuffer.writeString(Comment);

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
		stringBuilder.append("BV_PORTFOLIO_RFCQ_SELL_SIDE_SUMMARY_INFO::");
		stringBuilder.append("SellSideMemberId(").append(SellSideMemberId).append(")");
		stringBuilder.append("SellSideMemberCode(").append(SellSideMemberCode).append(")");
		stringBuilder.append("SellSideMemberDesc(").append(SellSideMemberDesc).append(")");
		stringBuilder.append("SellSideMemberShortDesc(").append(SellSideMemberShortDesc).append(")");
		stringBuilder.append("SellSideTraderId(").append(SellSideTraderId).append(")");
		stringBuilder.append("SellSideTraderName(").append(SellSideTraderName).append(")");
		stringBuilder.append("ClosingType(").append(ClosingType).append(")");
		stringBuilder.append("RfcqReqId(").append(RfcqReqId).append(")");
		stringBuilder.append("CreationDate(").append(CreationDate).append(")");
		stringBuilder.append("CreationTime(").append(CreationTime).append(")");
		stringBuilder.append("DueInTime(").append(DueInTime).append(")");
		stringBuilder.append("DueInTimeout(").append(DueInTimeout).append(")");
		stringBuilder.append("PreAgreedFg(").append(PreAgreedFg).append(")");
		stringBuilder.append("BuySideMemberId(").append(BuySideMemberId).append(")");
		stringBuilder.append("BuySideMemberCode(").append(BuySideMemberCode).append(")");
		stringBuilder.append("BuySideMemberDesc(").append(BuySideMemberDesc).append(")");
		stringBuilder.append("BuySideMemberShortDesc(").append(BuySideMemberShortDesc).append(")");
		stringBuilder.append("BuySideTraderName(").append(BuySideTraderName).append(")");
		stringBuilder.append("FinalStatus(").append(FinalStatus).append(")");
		stringBuilder.append("ProviderStatus(").append(ProviderStatus).append(")");
		stringBuilder.append("ClosingTime(").append(ClosingTime).append(")");
		stringBuilder.append("SellSideNr(").append(SellSideNr).append(")");
		stringBuilder.append("ParticipatingSellSideNr(").append(ParticipatingSellSideNr).append(")");
		stringBuilder.append("QuotingSellSideNr(").append(QuotingSellSideNr).append(")");
		stringBuilder.append("PortfolioProceedsCurrency(").append(PortfolioProceedsCurrency).append(")");
		stringBuilder.append("NetProceeds(").append(NetProceeds).append(")");
		stringBuilder.append("BVMidNetProceeds(").append(BVMidNetProceeds.toString()).append(")");
		stringBuilder.append("PriceCoverInfo(").append(PriceCoverInfo.toString()).append(")");
		stringBuilder.append("AlgoInfo(").append(AlgoInfo.toString()).append(")");
		stringBuilder.append("ClientIdentificationInfo(").append(ClientIdentificationInfo.toString()).append(")");
		stringBuilder.append("NumOfLegs(").append(NumOfLegs).append(")");
		stringBuilder.append("AreaCodeId(").append(AreaCodeId).append(")");
		stringBuilder.append("MOCAcceptanceTime(").append(MOCAcceptanceTime).append(")");
		stringBuilder.append("Comment(").append(Comment).append(")");
		return stringBuilder.toString();
	}
}
