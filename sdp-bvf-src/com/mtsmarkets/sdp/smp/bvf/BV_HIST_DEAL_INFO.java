package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_HIST_DEAL_INFO extends SMPMessage
{
	public static final long CLASS_ID = 114916;

	private TI_MSG_INFO DealMsgInfo = new TI_MSG_INFO();
	private String SectionCode = "";
	private BV_HIST_DEAL_MEMBER_INFO Provider = new BV_HIST_DEAL_MEMBER_INFO();
	private BV_HIST_DEAL_MEMBER_INFO Aggressor = new BV_HIST_DEAL_MEMBER_INFO();
	private BV_HIST_INSTRUMENT_INFO Instrument = new BV_HIST_INSTRUMENT_INFO();
	private BV_MATCH_MODE_Enum MatchMode = BV_MATCH_MODE_Enum.BV_MATCH_MODE_Automatic;
	private BV_DEAL_STATUS_Enum Status = BV_DEAL_STATUS_Enum.BV_DEAL_STATUS_Active;
	private BV_DEAL_SPLIT_STATUS_Enum SplitStatus = BV_DEAL_SPLIT_STATUS_Enum.BV_DEAL_SPLIT_STATUS_WaitingForSplit;
	private TI_VERB_Enum Verb = TI_VERB_Enum.TI_VERB_Buy;
	private BV_DEAL_TRADING_INFO DealInfo = new BV_DEAL_TRADING_INFO();
	private short NumberOfTrades = 0;
	private long UpdateTime = 0;
	private String MktAffiliationShortDesc = "";
	private String MktAffiliationDesc = "";
	private TI_TRADE_TYPE_Enum TradeType = TI_TRADE_TYPE_Enum.TI_TRADE_TYPE_Normal;
	private String AreaCodeShortDesc = "";
	private String AreaCodeDesc = "";
	private String MicCode = "";
	private long TransactionId = 0;
	private short LegId = 0;
	private TI_RFCQ_TYPE_Enum RfcqType = TI_RFCQ_TYPE_Enum.TI_RFCQ_TYPE_Outright;
	private BV_TRANSPARENCY_INFO TransparencyInfo = new BV_TRANSPARENCY_INFO();

	public BV_HIST_DEAL_INFO()
	{
	}

	public TI_MSG_INFO getDealMsgInfo()
	{
		return DealMsgInfo;
	}
	public void setDealMsgInfo(TI_MSG_INFO value)
	{
		DealMsgInfo = value;
	}
	public String getSectionCode()
	{
		return SectionCode;
	}
	public void setSectionCode(String value)
	{
		SectionCode = value;
	}
	public BV_HIST_DEAL_MEMBER_INFO getProvider()
	{
		return Provider;
	}
	public void setProvider(BV_HIST_DEAL_MEMBER_INFO value)
	{
		Provider = value;
	}
	public BV_HIST_DEAL_MEMBER_INFO getAggressor()
	{
		return Aggressor;
	}
	public void setAggressor(BV_HIST_DEAL_MEMBER_INFO value)
	{
		Aggressor = value;
	}
	public BV_HIST_INSTRUMENT_INFO getInstrument()
	{
		return Instrument;
	}
	public void setInstrument(BV_HIST_INSTRUMENT_INFO value)
	{
		Instrument = value;
	}
	public BV_MATCH_MODE_Enum getMatchMode()
	{
		return MatchMode;
	}
	public void setMatchMode(BV_MATCH_MODE_Enum value)
	{
		MatchMode = value;
	}
	public BV_DEAL_STATUS_Enum getStatus()
	{
		return Status;
	}
	public void setStatus(BV_DEAL_STATUS_Enum value)
	{
		Status = value;
	}
	public BV_DEAL_SPLIT_STATUS_Enum getSplitStatus()
	{
		return SplitStatus;
	}
	public void setSplitStatus(BV_DEAL_SPLIT_STATUS_Enum value)
	{
		SplitStatus = value;
	}
	public TI_VERB_Enum getVerb()
	{
		return Verb;
	}
	public void setVerb(TI_VERB_Enum value)
	{
		Verb = value;
	}
	public BV_DEAL_TRADING_INFO getDealInfo()
	{
		return DealInfo;
	}
	public void setDealInfo(BV_DEAL_TRADING_INFO value)
	{
		DealInfo = value;
	}
	public short getNumberOfTrades()
	{
		return NumberOfTrades;
	}
	public void setNumberOfTrades(short value)
	{
		NumberOfTrades = value;
	}
	public long getUpdateTime()
	{
		return UpdateTime;
	}
	public void setUpdateTime(long value)
	{
		UpdateTime = value;
	}
	public String getMktAffiliationShortDesc()
	{
		return MktAffiliationShortDesc;
	}
	public void setMktAffiliationShortDesc(String value)
	{
		MktAffiliationShortDesc = value;
	}
	public String getMktAffiliationDesc()
	{
		return MktAffiliationDesc;
	}
	public void setMktAffiliationDesc(String value)
	{
		MktAffiliationDesc = value;
	}
	public TI_TRADE_TYPE_Enum getTradeType()
	{
		return TradeType;
	}
	public void setTradeType(TI_TRADE_TYPE_Enum value)
	{
		TradeType = value;
	}
	public String getAreaCodeShortDesc()
	{
		return AreaCodeShortDesc;
	}
	public void setAreaCodeShortDesc(String value)
	{
		AreaCodeShortDesc = value;
	}
	public String getAreaCodeDesc()
	{
		return AreaCodeDesc;
	}
	public void setAreaCodeDesc(String value)
	{
		AreaCodeDesc = value;
	}
	public String getMicCode()
	{
		return MicCode;
	}
	public void setMicCode(String value)
	{
		MicCode = value;
	}
	public long getTransactionId()
	{
		return TransactionId;
	}
	public void setTransactionId(long value)
	{
		TransactionId = value;
	}
	public short getLegId()
	{
		return LegId;
	}
	public void setLegId(short value)
	{
		LegId = value;
	}
	public TI_RFCQ_TYPE_Enum getRfcqType()
	{
		return RfcqType;
	}
	public void setRfcqType(TI_RFCQ_TYPE_Enum value)
	{
		RfcqType = value;
	}
	public BV_TRANSPARENCY_INFO getTransparencyInfo()
	{
		return TransparencyInfo;
	}
	public void setTransparencyInfo(BV_TRANSPARENCY_INFO value)
	{
		TransparencyInfo = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		DealMsgInfo.readXDR(byteBuffer);
		SectionCode = byteBuffer.readString();
		Provider.readXDR(byteBuffer);
		Aggressor.readXDR(byteBuffer);
		Instrument.readXDR(byteBuffer);
		MatchMode = MatchMode.getEnum(byteBuffer.readInt());
		Status = Status.getEnum(byteBuffer.readInt());
		SplitStatus = SplitStatus.getEnum(byteBuffer.readInt());
		Verb = Verb.getEnum(byteBuffer.readInt());
		DealInfo.readXDR(byteBuffer);
		NumberOfTrades = (short)byteBuffer.readInt();
		UpdateTime = byteBuffer.readLong();
		MktAffiliationShortDesc = byteBuffer.readString();
		MktAffiliationDesc = byteBuffer.readString();
		TradeType = TradeType.getEnum(byteBuffer.readInt());
		AreaCodeShortDesc = byteBuffer.readString();
		AreaCodeDesc = byteBuffer.readString();
		MicCode = byteBuffer.readString();
		TransactionId = (long)byteBuffer.readInt();
		LegId = (short)byteBuffer.readInt();
		RfcqType = RfcqType.getEnum(byteBuffer.readInt());
		TransparencyInfo.readXDR(byteBuffer);
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		DealMsgInfo.writeXDR(byteBuffer);
		byteBuffer.writeString(SectionCode);
		Provider.writeXDR(byteBuffer);
		Aggressor.writeXDR(byteBuffer);
		Instrument.writeXDR(byteBuffer);
		byteBuffer.writeInt(MatchMode.getValue());
		byteBuffer.writeInt(Status.getValue());
		byteBuffer.writeInt(SplitStatus.getValue());
		byteBuffer.writeInt(Verb.getValue());
		DealInfo.writeXDR(byteBuffer);
		byteBuffer.writeInt((int)(NumberOfTrades & 0xFFFFL));
		byteBuffer.writeLong(UpdateTime);
		byteBuffer.writeString(MktAffiliationShortDesc);
		byteBuffer.writeString(MktAffiliationDesc);
		byteBuffer.writeInt(TradeType.getValue());
		byteBuffer.writeString(AreaCodeShortDesc);
		byteBuffer.writeString(AreaCodeDesc);
		byteBuffer.writeString(MicCode);
		byteBuffer.writeInt((int)(TransactionId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(LegId & 0xFFFFL));
		byteBuffer.writeInt(RfcqType.getValue());
		TransparencyInfo.writeXDR(byteBuffer);

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
		stringBuilder.append("BV_HIST_DEAL_INFO::");
		stringBuilder.append("DealMsgInfo(").append(DealMsgInfo.toString()).append(")");
		stringBuilder.append("SectionCode(").append(SectionCode).append(")");
		stringBuilder.append("Provider(").append(Provider.toString()).append(")");
		stringBuilder.append("Aggressor(").append(Aggressor.toString()).append(")");
		stringBuilder.append("Instrument(").append(Instrument.toString()).append(")");
		stringBuilder.append("MatchMode(").append(MatchMode).append(")");
		stringBuilder.append("Status(").append(Status).append(")");
		stringBuilder.append("SplitStatus(").append(SplitStatus).append(")");
		stringBuilder.append("Verb(").append(Verb).append(")");
		stringBuilder.append("DealInfo(").append(DealInfo.toString()).append(")");
		stringBuilder.append("NumberOfTrades(").append(NumberOfTrades).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		stringBuilder.append("MktAffiliationShortDesc(").append(MktAffiliationShortDesc).append(")");
		stringBuilder.append("MktAffiliationDesc(").append(MktAffiliationDesc).append(")");
		stringBuilder.append("TradeType(").append(TradeType).append(")");
		stringBuilder.append("AreaCodeShortDesc(").append(AreaCodeShortDesc).append(")");
		stringBuilder.append("AreaCodeDesc(").append(AreaCodeDesc).append(")");
		stringBuilder.append("MicCode(").append(MicCode).append(")");
		stringBuilder.append("TransactionId(").append(TransactionId).append(")");
		stringBuilder.append("LegId(").append(LegId).append(")");
		stringBuilder.append("RfcqType(").append(RfcqType).append(")");
		stringBuilder.append("TransparencyInfo(").append(TransparencyInfo.toString()).append(")");
		return stringBuilder.toString();
	}
}
