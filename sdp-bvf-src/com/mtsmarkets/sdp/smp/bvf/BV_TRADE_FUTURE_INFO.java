package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_TRADE_FUTURE_INFO extends SMPMessage
{
	public static final long CLASS_ID = 410010;

	private TI_MSG_INFO TradeMsgInfo = new TI_MSG_INFO();
	private long CashTradeId = 0;
	private long DealId = 0;
	private long CashDealId = 0;
	private long ExchangeId = 0;
	private BV_TRADE_MEMBER_INFO Provider = new BV_TRADE_MEMBER_INFO();
	private BV_TRADE_FUTURE_ACCOUNT_INFO ProviderExchangeAccountInfo = new BV_TRADE_FUTURE_ACCOUNT_INFO();
	private BV_TRADE_MEMBER_INFO Aggressor = new BV_TRADE_MEMBER_INFO();
	private BV_TRADE_FUTURE_ACCOUNT_INFO AggressorExchangeAccountInfo = new BV_TRADE_FUTURE_ACCOUNT_INFO();
	private BV_INSTRUMENT_INFO Instrument = new BV_INSTRUMENT_INFO();
	private long FinancialInstrumentId = 0;
	private String FinancialInstrumentCode = "";
	private TI_VERB_Enum Verb = TI_VERB_Enum.TI_VERB_Buy;
	private BV_TRADE_FUTURE_TRADING_INFO TradeInfo = new BV_TRADE_FUTURE_TRADING_INFO();
	private TI_FILL_STATUS_Enum Status = TI_FILL_STATUS_Enum.TI_FILL_STATUS_Active;
	private BV_MATCH_MODE_Enum FillMode = BV_MATCH_MODE_Enum.BV_MATCH_MODE_Automatic;
	private String SettlTradeId = "";
	private BV_SETTL_STATUS_Enum SettlStatus = BV_SETTL_STATUS_Enum.BV_SETTL_STATUS_Waiting;
	private long AccountId = 0;
	private double NominalValue = 0;
	private String Currency = "";
	private long UpdateTime = 0;
	private short MarketAffiliation = 0;
	private long ParentTradeId = 0;
	private TI_FLAG_Enum SplittableFg = TI_FLAG_Enum.TI_FLAG_No;
	private long PreAllocationTime = 0;
	private double Adjustment = 0;
	private TI_FLAG_Enum AdjustmentFg = TI_FLAG_Enum.TI_FLAG_No;
	private TI_TRADE_TYPE_Enum TradeType = TI_TRADE_TYPE_Enum.TI_TRADE_TYPE_Normal;
	private short AreaCodeId = 0;
	private String MicCode = "";
	private long TransactionId = 0;
	private short LegId = 0;
	private TI_RFCQ_TYPE_Enum RfcqType = TI_RFCQ_TYPE_Enum.TI_RFCQ_TYPE_Outright;
	private BV_TRANSPARENCY_INFO TransparencyInfo = new BV_TRANSPARENCY_INFO();

	public BV_TRADE_FUTURE_INFO()
	{
	}

	public TI_MSG_INFO getTradeMsgInfo()
	{
		return TradeMsgInfo;
	}
	public void setTradeMsgInfo(TI_MSG_INFO value)
	{
		TradeMsgInfo = value;
	}
	public long getCashTradeId()
	{
		return CashTradeId;
	}
	public void setCashTradeId(long value)
	{
		CashTradeId = value;
	}
	public long getDealId()
	{
		return DealId;
	}
	public void setDealId(long value)
	{
		DealId = value;
	}
	public long getCashDealId()
	{
		return CashDealId;
	}
	public void setCashDealId(long value)
	{
		CashDealId = value;
	}
	public long getExchangeId()
	{
		return ExchangeId;
	}
	public void setExchangeId(long value)
	{
		ExchangeId = value;
	}
	public BV_TRADE_MEMBER_INFO getProvider()
	{
		return Provider;
	}
	public void setProvider(BV_TRADE_MEMBER_INFO value)
	{
		Provider = value;
	}
	public BV_TRADE_FUTURE_ACCOUNT_INFO getProviderExchangeAccountInfo()
	{
		return ProviderExchangeAccountInfo;
	}
	public void setProviderExchangeAccountInfo(BV_TRADE_FUTURE_ACCOUNT_INFO value)
	{
		ProviderExchangeAccountInfo = value;
	}
	public BV_TRADE_MEMBER_INFO getAggressor()
	{
		return Aggressor;
	}
	public void setAggressor(BV_TRADE_MEMBER_INFO value)
	{
		Aggressor = value;
	}
	public BV_TRADE_FUTURE_ACCOUNT_INFO getAggressorExchangeAccountInfo()
	{
		return AggressorExchangeAccountInfo;
	}
	public void setAggressorExchangeAccountInfo(BV_TRADE_FUTURE_ACCOUNT_INFO value)
	{
		AggressorExchangeAccountInfo = value;
	}
	public BV_INSTRUMENT_INFO getInstrument()
	{
		return Instrument;
	}
	public void setInstrument(BV_INSTRUMENT_INFO value)
	{
		Instrument = value;
	}
	public long getFinancialInstrumentId()
	{
		return FinancialInstrumentId;
	}
	public void setFinancialInstrumentId(long value)
	{
		FinancialInstrumentId = value;
	}
	public String getFinancialInstrumentCode()
	{
		return FinancialInstrumentCode;
	}
	public void setFinancialInstrumentCode(String value)
	{
		FinancialInstrumentCode = value;
	}
	public TI_VERB_Enum getVerb()
	{
		return Verb;
	}
	public void setVerb(TI_VERB_Enum value)
	{
		Verb = value;
	}
	public BV_TRADE_FUTURE_TRADING_INFO getTradeInfo()
	{
		return TradeInfo;
	}
	public void setTradeInfo(BV_TRADE_FUTURE_TRADING_INFO value)
	{
		TradeInfo = value;
	}
	public TI_FILL_STATUS_Enum getStatus()
	{
		return Status;
	}
	public void setStatus(TI_FILL_STATUS_Enum value)
	{
		Status = value;
	}
	public BV_MATCH_MODE_Enum getFillMode()
	{
		return FillMode;
	}
	public void setFillMode(BV_MATCH_MODE_Enum value)
	{
		FillMode = value;
	}
	public String getSettlTradeId()
	{
		return SettlTradeId;
	}
	public void setSettlTradeId(String value)
	{
		SettlTradeId = value;
	}
	public BV_SETTL_STATUS_Enum getSettlStatus()
	{
		return SettlStatus;
	}
	public void setSettlStatus(BV_SETTL_STATUS_Enum value)
	{
		SettlStatus = value;
	}
	public long getAccountId()
	{
		return AccountId;
	}
	public void setAccountId(long value)
	{
		AccountId = value;
	}
	public double getNominalValue()
	{
		return NominalValue;
	}
	public void setNominalValue(double value)
	{
		NominalValue = value;
	}
	public String getCurrency()
	{
		return Currency;
	}
	public void setCurrency(String value)
	{
		Currency = value;
	}
	public long getUpdateTime()
	{
		return UpdateTime;
	}
	public void setUpdateTime(long value)
	{
		UpdateTime = value;
	}
	public short getMarketAffiliation()
	{
		return MarketAffiliation;
	}
	public void setMarketAffiliation(short value)
	{
		MarketAffiliation = value;
	}
	public long getParentTradeId()
	{
		return ParentTradeId;
	}
	public void setParentTradeId(long value)
	{
		ParentTradeId = value;
	}
	public TI_FLAG_Enum getSplittableFg()
	{
		return SplittableFg;
	}
	public void setSplittableFg(TI_FLAG_Enum value)
	{
		SplittableFg = value;
	}
	public long getPreAllocationTime()
	{
		return PreAllocationTime;
	}
	public void setPreAllocationTime(long value)
	{
		PreAllocationTime = value;
	}
	public double getAdjustment()
	{
		return Adjustment;
	}
	public void setAdjustment(double value)
	{
		Adjustment = value;
	}
	public TI_FLAG_Enum getAdjustmentFg()
	{
		return AdjustmentFg;
	}
	public void setAdjustmentFg(TI_FLAG_Enum value)
	{
		AdjustmentFg = value;
	}
	public TI_TRADE_TYPE_Enum getTradeType()
	{
		return TradeType;
	}
	public void setTradeType(TI_TRADE_TYPE_Enum value)
	{
		TradeType = value;
	}
	public short getAreaCodeId()
	{
		return AreaCodeId;
	}
	public void setAreaCodeId(short value)
	{
		AreaCodeId = value;
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
		TradeMsgInfo.readXDR(byteBuffer);
		CashTradeId = (long)byteBuffer.readInt();
		DealId = (long)byteBuffer.readInt();
		CashDealId = (long)byteBuffer.readInt();
		ExchangeId = (long)byteBuffer.readInt();
		Provider.readXDR(byteBuffer);
		ProviderExchangeAccountInfo.readXDR(byteBuffer);
		Aggressor.readXDR(byteBuffer);
		AggressorExchangeAccountInfo.readXDR(byteBuffer);
		Instrument.readXDR(byteBuffer);
		FinancialInstrumentId = (long)byteBuffer.readInt();
		FinancialInstrumentCode = byteBuffer.readString();
		Verb = Verb.getEnum(byteBuffer.readInt());
		TradeInfo.readXDR(byteBuffer);
		Status = Status.getEnum(byteBuffer.readInt());
		FillMode = FillMode.getEnum(byteBuffer.readInt());
		SettlTradeId = byteBuffer.readString();
		SettlStatus = SettlStatus.getEnum(byteBuffer.readInt());
		AccountId = (long)byteBuffer.readInt();
		NominalValue = byteBuffer.readDouble();
		Currency = byteBuffer.readString();
		UpdateTime = byteBuffer.readLong();
		MarketAffiliation = (short)byteBuffer.readInt();
		ParentTradeId = (long)byteBuffer.readInt();
		SplittableFg = SplittableFg.getEnum(byteBuffer.readInt());
		PreAllocationTime = byteBuffer.readLong();
		Adjustment = byteBuffer.readDouble();
		AdjustmentFg = AdjustmentFg.getEnum(byteBuffer.readInt());
		TradeType = TradeType.getEnum(byteBuffer.readInt());
		AreaCodeId = (short)byteBuffer.readInt();
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

		TradeMsgInfo.writeXDR(byteBuffer);
		byteBuffer.writeInt((int)(CashTradeId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(DealId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(CashDealId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(ExchangeId & 0xFFFFFFFFL));
		Provider.writeXDR(byteBuffer);
		ProviderExchangeAccountInfo.writeXDR(byteBuffer);
		Aggressor.writeXDR(byteBuffer);
		AggressorExchangeAccountInfo.writeXDR(byteBuffer);
		Instrument.writeXDR(byteBuffer);
		byteBuffer.writeInt((int)(FinancialInstrumentId & 0xFFFFFFFFL));
		byteBuffer.writeString(FinancialInstrumentCode);
		byteBuffer.writeInt(Verb.getValue());
		TradeInfo.writeXDR(byteBuffer);
		byteBuffer.writeInt(Status.getValue());
		byteBuffer.writeInt(FillMode.getValue());
		byteBuffer.writeString(SettlTradeId);
		byteBuffer.writeInt(SettlStatus.getValue());
		byteBuffer.writeInt((int)(AccountId & 0xFFFFFFFFL));
		byteBuffer.writeDouble(NominalValue);
		byteBuffer.writeString(Currency);
		byteBuffer.writeLong(UpdateTime);
		byteBuffer.writeInt((int)(MarketAffiliation & 0xFFFFL));
		byteBuffer.writeInt((int)(ParentTradeId & 0xFFFFFFFFL));
		byteBuffer.writeInt(SplittableFg.getValue());
		byteBuffer.writeLong(PreAllocationTime);
		byteBuffer.writeDouble(Adjustment);
		byteBuffer.writeInt(AdjustmentFg.getValue());
		byteBuffer.writeInt(TradeType.getValue());
		byteBuffer.writeInt((int)(AreaCodeId & 0xFFFFL));
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
		stringBuilder.append("BV_TRADE_FUTURE_INFO::");
		stringBuilder.append("TradeMsgInfo(").append(TradeMsgInfo.toString()).append(")");
		stringBuilder.append("CashTradeId(").append(CashTradeId).append(")");
		stringBuilder.append("DealId(").append(DealId).append(")");
		stringBuilder.append("CashDealId(").append(CashDealId).append(")");
		stringBuilder.append("ExchangeId(").append(ExchangeId).append(")");
		stringBuilder.append("Provider(").append(Provider.toString()).append(")");
		stringBuilder.append("ProviderExchangeAccountInfo(").append(ProviderExchangeAccountInfo.toString()).append(")");
		stringBuilder.append("Aggressor(").append(Aggressor.toString()).append(")");
		stringBuilder.append("AggressorExchangeAccountInfo(").append(AggressorExchangeAccountInfo.toString()).append(")");
		stringBuilder.append("Instrument(").append(Instrument.toString()).append(")");
		stringBuilder.append("FinancialInstrumentId(").append(FinancialInstrumentId).append(")");
		stringBuilder.append("FinancialInstrumentCode(").append(FinancialInstrumentCode).append(")");
		stringBuilder.append("Verb(").append(Verb).append(")");
		stringBuilder.append("TradeInfo(").append(TradeInfo.toString()).append(")");
		stringBuilder.append("Status(").append(Status).append(")");
		stringBuilder.append("FillMode(").append(FillMode).append(")");
		stringBuilder.append("SettlTradeId(").append(SettlTradeId).append(")");
		stringBuilder.append("SettlStatus(").append(SettlStatus).append(")");
		stringBuilder.append("AccountId(").append(AccountId).append(")");
		stringBuilder.append("NominalValue(").append(NominalValue).append(")");
		stringBuilder.append("Currency(").append(Currency).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		stringBuilder.append("MarketAffiliation(").append(MarketAffiliation).append(")");
		stringBuilder.append("ParentTradeId(").append(ParentTradeId).append(")");
		stringBuilder.append("SplittableFg(").append(SplittableFg).append(")");
		stringBuilder.append("PreAllocationTime(").append(PreAllocationTime).append(")");
		stringBuilder.append("Adjustment(").append(Adjustment).append(")");
		stringBuilder.append("AdjustmentFg(").append(AdjustmentFg).append(")");
		stringBuilder.append("TradeType(").append(TradeType).append(")");
		stringBuilder.append("AreaCodeId(").append(AreaCodeId).append(")");
		stringBuilder.append("MicCode(").append(MicCode).append(")");
		stringBuilder.append("TransactionId(").append(TransactionId).append(")");
		stringBuilder.append("LegId(").append(LegId).append(")");
		stringBuilder.append("RfcqType(").append(RfcqType).append(")");
		stringBuilder.append("TransparencyInfo(").append(TransparencyInfo.toString()).append(")");
		return stringBuilder.toString();
	}
}
