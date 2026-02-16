package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_INSTRUMENT_CLASS extends SMPMessage
{
	public static final long CLASS_ID = 114107;

	private long InstrumentClassId = 0;
	private TI_TRADING_TYPE_Enum TradingType = TI_TRADING_TYPE_Enum.TI_TRADING_TYPE_CleanPrice;
	private TI_INSTRUMENT_TYPE_Enum InstrumentType = TI_INSTRUMENT_TYPE_Enum.TI_INSTRUMENT_TYPE_Bond;
	private long StatisticsTime = 0;
	private double MaxSettlSize = 0;
	private long SortNumber = 0;
	private BV_YIELD_PRICE_CONV_Enum BVBestYieldPriceConv = BV_YIELD_PRICE_CONV_Enum.BV_YIELD_PRICE_CONV_None;
	private BV_YIELD_PRICE_CONV_Enum InventoryYieldPriceConv = BV_YIELD_PRICE_CONV_Enum.BV_YIELD_PRICE_CONV_None;
	private short IODenialTime = 0;
	private BV_IO_DENIAL_TIME_TYPE_Enum IODenialTimeType = BV_IO_DENIAL_TIME_TYPE_Enum.BV_IO_DENIAL_TIME_TYPE_Last;
	private short IOLastLook = 0;
	private long ProductType = 0;
	private short InventoryDepthFreeze = 0;
	private short InventoryQuoteFreshness = 0;
	private TI_FLAG_Enum RFCQOutrightFg = TI_FLAG_Enum.TI_FLAG_No;
	private TI_FLAG_Enum RFCQSwitchFg = TI_FLAG_Enum.TI_FLAG_No;
	private TI_FLAG_Enum TradeRegistration = TI_FLAG_Enum.TI_FLAG_No;
	private TI_FLAG_Enum RFCQButterflyFreeFg = TI_FLAG_Enum.TI_FLAG_No;
	private TI_FLAG_Enum RFCQMultiLegFg = TI_FLAG_Enum.TI_FLAG_No;
	private TI_FLAG_Enum RFCQDoubleSidedFg = TI_FLAG_Enum.TI_FLAG_No;
	private TI_FLAG_Enum InventoryOrderFg = TI_FLAG_Enum.TI_FLAG_No;
	private long RFCQTimer = 0;
	private short RFCQMaxNumRecipients = 0;
	private short RFCQMaxOffsetSettlement = 0;
	private long RFCQSummaryDelay = 0;
	private short RFCQMinAutomaticMatchingTimeout = 0;
	private short RFCQAcceptanceTimeout = 0;
	private TI_FLAG_Enum ConcurrentBidAskRFCQFg = TI_FLAG_Enum.TI_FLAG_No;
	private long OutrightRFCQPreTradeTransparencyMinTime = 0;
	private long OutrightRFCQPreTradeTransparencyMaxTime = 0;
	private TI_FLAG_Enum EnablePortfolioRFCQFg = TI_FLAG_Enum.TI_FLAG_No;
	private TI_FLAG_Enum EnableMOCfg = TI_FLAG_Enum.TI_FLAG_No;
	private long MOCFixingTime = 0;
	private long MOCCutoff = 0;

	public BV_INSTRUMENT_CLASS()
	{
	}

	public long getInstrumentClassId()
	{
		return InstrumentClassId;
	}
	public void setInstrumentClassId(long value)
	{
		InstrumentClassId = value;
	}
	public TI_TRADING_TYPE_Enum getTradingType()
	{
		return TradingType;
	}
	public void setTradingType(TI_TRADING_TYPE_Enum value)
	{
		TradingType = value;
	}
	public TI_INSTRUMENT_TYPE_Enum getInstrumentType()
	{
		return InstrumentType;
	}
	public void setInstrumentType(TI_INSTRUMENT_TYPE_Enum value)
	{
		InstrumentType = value;
	}
	public long getStatisticsTime()
	{
		return StatisticsTime;
	}
	public void setStatisticsTime(long value)
	{
		StatisticsTime = value;
	}
	public double getMaxSettlSize()
	{
		return MaxSettlSize;
	}
	public void setMaxSettlSize(double value)
	{
		MaxSettlSize = value;
	}
	public long getSortNumber()
	{
		return SortNumber;
	}
	public void setSortNumber(long value)
	{
		SortNumber = value;
	}
	public BV_YIELD_PRICE_CONV_Enum getBVBestYieldPriceConv()
	{
		return BVBestYieldPriceConv;
	}
	public void setBVBestYieldPriceConv(BV_YIELD_PRICE_CONV_Enum value)
	{
		BVBestYieldPriceConv = value;
	}
	public BV_YIELD_PRICE_CONV_Enum getInventoryYieldPriceConv()
	{
		return InventoryYieldPriceConv;
	}
	public void setInventoryYieldPriceConv(BV_YIELD_PRICE_CONV_Enum value)
	{
		InventoryYieldPriceConv = value;
	}
	public short getIODenialTime()
	{
		return IODenialTime;
	}
	public void setIODenialTime(short value)
	{
		IODenialTime = value;
	}
	public BV_IO_DENIAL_TIME_TYPE_Enum getIODenialTimeType()
	{
		return IODenialTimeType;
	}
	public void setIODenialTimeType(BV_IO_DENIAL_TIME_TYPE_Enum value)
	{
		IODenialTimeType = value;
	}
	public short getIOLastLook()
	{
		return IOLastLook;
	}
	public void setIOLastLook(short value)
	{
		IOLastLook = value;
	}
	public long getProductType()
	{
		return ProductType;
	}
	public void setProductType(long value)
	{
		ProductType = value;
	}
	public short getInventoryDepthFreeze()
	{
		return InventoryDepthFreeze;
	}
	public void setInventoryDepthFreeze(short value)
	{
		InventoryDepthFreeze = value;
	}
	public short getInventoryQuoteFreshness()
	{
		return InventoryQuoteFreshness;
	}
	public void setInventoryQuoteFreshness(short value)
	{
		InventoryQuoteFreshness = value;
	}
	public TI_FLAG_Enum getRFCQOutrightFg()
	{
		return RFCQOutrightFg;
	}
	public void setRFCQOutrightFg(TI_FLAG_Enum value)
	{
		RFCQOutrightFg = value;
	}
	public TI_FLAG_Enum getRFCQSwitchFg()
	{
		return RFCQSwitchFg;
	}
	public void setRFCQSwitchFg(TI_FLAG_Enum value)
	{
		RFCQSwitchFg = value;
	}
	public TI_FLAG_Enum getTradeRegistration()
	{
		return TradeRegistration;
	}
	public void setTradeRegistration(TI_FLAG_Enum value)
	{
		TradeRegistration = value;
	}
	public TI_FLAG_Enum getRFCQButterflyFreeFg()
	{
		return RFCQButterflyFreeFg;
	}
	public void setRFCQButterflyFreeFg(TI_FLAG_Enum value)
	{
		RFCQButterflyFreeFg = value;
	}
	public TI_FLAG_Enum getRFCQMultiLegFg()
	{
		return RFCQMultiLegFg;
	}
	public void setRFCQMultiLegFg(TI_FLAG_Enum value)
	{
		RFCQMultiLegFg = value;
	}
	public TI_FLAG_Enum getRFCQDoubleSidedFg()
	{
		return RFCQDoubleSidedFg;
	}
	public void setRFCQDoubleSidedFg(TI_FLAG_Enum value)
	{
		RFCQDoubleSidedFg = value;
	}
	public TI_FLAG_Enum getInventoryOrderFg()
	{
		return InventoryOrderFg;
	}
	public void setInventoryOrderFg(TI_FLAG_Enum value)
	{
		InventoryOrderFg = value;
	}
	public long getRFCQTimer()
	{
		return RFCQTimer;
	}
	public void setRFCQTimer(long value)
	{
		RFCQTimer = value;
	}
	public short getRFCQMaxNumRecipients()
	{
		return RFCQMaxNumRecipients;
	}
	public void setRFCQMaxNumRecipients(short value)
	{
		RFCQMaxNumRecipients = value;
	}
	public short getRFCQMaxOffsetSettlement()
	{
		return RFCQMaxOffsetSettlement;
	}
	public void setRFCQMaxOffsetSettlement(short value)
	{
		RFCQMaxOffsetSettlement = value;
	}
	public long getRFCQSummaryDelay()
	{
		return RFCQSummaryDelay;
	}
	public void setRFCQSummaryDelay(long value)
	{
		RFCQSummaryDelay = value;
	}
	public short getRFCQMinAutomaticMatchingTimeout()
	{
		return RFCQMinAutomaticMatchingTimeout;
	}
	public void setRFCQMinAutomaticMatchingTimeout(short value)
	{
		RFCQMinAutomaticMatchingTimeout = value;
	}
	public short getRFCQAcceptanceTimeout()
	{
		return RFCQAcceptanceTimeout;
	}
	public void setRFCQAcceptanceTimeout(short value)
	{
		RFCQAcceptanceTimeout = value;
	}
	public TI_FLAG_Enum getConcurrentBidAskRFCQFg()
	{
		return ConcurrentBidAskRFCQFg;
	}
	public void setConcurrentBidAskRFCQFg(TI_FLAG_Enum value)
	{
		ConcurrentBidAskRFCQFg = value;
	}
	public long getOutrightRFCQPreTradeTransparencyMinTime()
	{
		return OutrightRFCQPreTradeTransparencyMinTime;
	}
	public void setOutrightRFCQPreTradeTransparencyMinTime(long value)
	{
		OutrightRFCQPreTradeTransparencyMinTime = value;
	}
	public long getOutrightRFCQPreTradeTransparencyMaxTime()
	{
		return OutrightRFCQPreTradeTransparencyMaxTime;
	}
	public void setOutrightRFCQPreTradeTransparencyMaxTime(long value)
	{
		OutrightRFCQPreTradeTransparencyMaxTime = value;
	}
	public TI_FLAG_Enum getEnablePortfolioRFCQFg()
	{
		return EnablePortfolioRFCQFg;
	}
	public void setEnablePortfolioRFCQFg(TI_FLAG_Enum value)
	{
		EnablePortfolioRFCQFg = value;
	}
	public TI_FLAG_Enum getEnableMOCfg()
	{
		return EnableMOCfg;
	}
	public void setEnableMOCfg(TI_FLAG_Enum value)
	{
		EnableMOCfg = value;
	}
	public long getMOCFixingTime()
	{
		return MOCFixingTime;
	}
	public void setMOCFixingTime(long value)
	{
		MOCFixingTime = value;
	}
	public long getMOCCutoff()
	{
		return MOCCutoff;
	}
	public void setMOCCutoff(long value)
	{
		MOCCutoff = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		InstrumentClassId = (long)byteBuffer.readInt();
		TradingType = TradingType.getEnum(byteBuffer.readInt());
		InstrumentType = InstrumentType.getEnum(byteBuffer.readInt());
		StatisticsTime = byteBuffer.readLong();
		MaxSettlSize = byteBuffer.readDouble();
		SortNumber = (long)byteBuffer.readInt();
		BVBestYieldPriceConv = BVBestYieldPriceConv.getEnum(byteBuffer.readInt());
		InventoryYieldPriceConv = InventoryYieldPriceConv.getEnum(byteBuffer.readInt());
		IODenialTime = (short)byteBuffer.readInt();
		IODenialTimeType = IODenialTimeType.getEnum(byteBuffer.readInt());
		IOLastLook = (short)byteBuffer.readInt();
		ProductType = (long)byteBuffer.readInt();
		InventoryDepthFreeze = (short)byteBuffer.readInt();
		InventoryQuoteFreshness = (short)byteBuffer.readInt();
		RFCQOutrightFg = RFCQOutrightFg.getEnum(byteBuffer.readInt());
		RFCQSwitchFg = RFCQSwitchFg.getEnum(byteBuffer.readInt());
		TradeRegistration = TradeRegistration.getEnum(byteBuffer.readInt());
		RFCQButterflyFreeFg = RFCQButterflyFreeFg.getEnum(byteBuffer.readInt());
		RFCQMultiLegFg = RFCQMultiLegFg.getEnum(byteBuffer.readInt());
		RFCQDoubleSidedFg = RFCQDoubleSidedFg.getEnum(byteBuffer.readInt());
		InventoryOrderFg = InventoryOrderFg.getEnum(byteBuffer.readInt());
		RFCQTimer = (long)byteBuffer.readInt();
		RFCQMaxNumRecipients = (short)byteBuffer.readInt();
		RFCQMaxOffsetSettlement = (short)byteBuffer.readInt();
		RFCQSummaryDelay = (long)byteBuffer.readInt();
		RFCQMinAutomaticMatchingTimeout = (short)byteBuffer.readInt();
		RFCQAcceptanceTimeout = (short)byteBuffer.readInt();
		ConcurrentBidAskRFCQFg = ConcurrentBidAskRFCQFg.getEnum(byteBuffer.readInt());
		OutrightRFCQPreTradeTransparencyMinTime = (long)byteBuffer.readInt();
		OutrightRFCQPreTradeTransparencyMaxTime = (long)byteBuffer.readInt();
		EnablePortfolioRFCQFg = EnablePortfolioRFCQFg.getEnum(byteBuffer.readInt());
		EnableMOCfg = EnableMOCfg.getEnum(byteBuffer.readInt());
		MOCFixingTime = byteBuffer.readLong();
		MOCCutoff = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(InstrumentClassId & 0xFFFFFFFFL));
		byteBuffer.writeInt(TradingType.getValue());
		byteBuffer.writeInt(InstrumentType.getValue());
		byteBuffer.writeLong(StatisticsTime);
		byteBuffer.writeDouble(MaxSettlSize);
		byteBuffer.writeInt((int)(SortNumber & 0xFFFFFFFFL));
		byteBuffer.writeInt(BVBestYieldPriceConv.getValue());
		byteBuffer.writeInt(InventoryYieldPriceConv.getValue());
		byteBuffer.writeInt((int)(IODenialTime & 0xFFFFL));
		byteBuffer.writeInt(IODenialTimeType.getValue());
		byteBuffer.writeInt((int)(IOLastLook & 0xFFFFL));
		byteBuffer.writeInt((int)(ProductType & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(InventoryDepthFreeze & 0xFFFFL));
		byteBuffer.writeInt((int)(InventoryQuoteFreshness & 0xFFFFL));
		byteBuffer.writeInt(RFCQOutrightFg.getValue());
		byteBuffer.writeInt(RFCQSwitchFg.getValue());
		byteBuffer.writeInt(TradeRegistration.getValue());
		byteBuffer.writeInt(RFCQButterflyFreeFg.getValue());
		byteBuffer.writeInt(RFCQMultiLegFg.getValue());
		byteBuffer.writeInt(RFCQDoubleSidedFg.getValue());
		byteBuffer.writeInt(InventoryOrderFg.getValue());
		byteBuffer.writeInt((int)(RFCQTimer & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(RFCQMaxNumRecipients & 0xFFFFL));
		byteBuffer.writeInt((int)(RFCQMaxOffsetSettlement & 0xFFFFL));
		byteBuffer.writeInt((int)(RFCQSummaryDelay & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(RFCQMinAutomaticMatchingTimeout & 0xFFFFL));
		byteBuffer.writeInt((int)(RFCQAcceptanceTimeout & 0xFFFFL));
		byteBuffer.writeInt(ConcurrentBidAskRFCQFg.getValue());
		byteBuffer.writeInt((int)(OutrightRFCQPreTradeTransparencyMinTime & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(OutrightRFCQPreTradeTransparencyMaxTime & 0xFFFFFFFFL));
		byteBuffer.writeInt(EnablePortfolioRFCQFg.getValue());
		byteBuffer.writeInt(EnableMOCfg.getValue());
		byteBuffer.writeLong(MOCFixingTime);
		byteBuffer.writeLong(MOCCutoff);

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
		stringBuilder.append("BV_INSTRUMENT_CLASS::");
		stringBuilder.append("InstrumentClassId(").append(InstrumentClassId).append(")");
		stringBuilder.append("TradingType(").append(TradingType).append(")");
		stringBuilder.append("InstrumentType(").append(InstrumentType).append(")");
		stringBuilder.append("StatisticsTime(").append(StatisticsTime).append(")");
		stringBuilder.append("MaxSettlSize(").append(MaxSettlSize).append(")");
		stringBuilder.append("SortNumber(").append(SortNumber).append(")");
		stringBuilder.append("BVBestYieldPriceConv(").append(BVBestYieldPriceConv).append(")");
		stringBuilder.append("InventoryYieldPriceConv(").append(InventoryYieldPriceConv).append(")");
		stringBuilder.append("IODenialTime(").append(IODenialTime).append(")");
		stringBuilder.append("IODenialTimeType(").append(IODenialTimeType).append(")");
		stringBuilder.append("IOLastLook(").append(IOLastLook).append(")");
		stringBuilder.append("ProductType(").append(ProductType).append(")");
		stringBuilder.append("InventoryDepthFreeze(").append(InventoryDepthFreeze).append(")");
		stringBuilder.append("InventoryQuoteFreshness(").append(InventoryQuoteFreshness).append(")");
		stringBuilder.append("RFCQOutrightFg(").append(RFCQOutrightFg).append(")");
		stringBuilder.append("RFCQSwitchFg(").append(RFCQSwitchFg).append(")");
		stringBuilder.append("TradeRegistration(").append(TradeRegistration).append(")");
		stringBuilder.append("RFCQButterflyFreeFg(").append(RFCQButterflyFreeFg).append(")");
		stringBuilder.append("RFCQMultiLegFg(").append(RFCQMultiLegFg).append(")");
		stringBuilder.append("RFCQDoubleSidedFg(").append(RFCQDoubleSidedFg).append(")");
		stringBuilder.append("InventoryOrderFg(").append(InventoryOrderFg).append(")");
		stringBuilder.append("RFCQTimer(").append(RFCQTimer).append(")");
		stringBuilder.append("RFCQMaxNumRecipients(").append(RFCQMaxNumRecipients).append(")");
		stringBuilder.append("RFCQMaxOffsetSettlement(").append(RFCQMaxOffsetSettlement).append(")");
		stringBuilder.append("RFCQSummaryDelay(").append(RFCQSummaryDelay).append(")");
		stringBuilder.append("RFCQMinAutomaticMatchingTimeout(").append(RFCQMinAutomaticMatchingTimeout).append(")");
		stringBuilder.append("RFCQAcceptanceTimeout(").append(RFCQAcceptanceTimeout).append(")");
		stringBuilder.append("ConcurrentBidAskRFCQFg(").append(ConcurrentBidAskRFCQFg).append(")");
		stringBuilder.append("OutrightRFCQPreTradeTransparencyMinTime(").append(OutrightRFCQPreTradeTransparencyMinTime).append(")");
		stringBuilder.append("OutrightRFCQPreTradeTransparencyMaxTime(").append(OutrightRFCQPreTradeTransparencyMaxTime).append(")");
		stringBuilder.append("EnablePortfolioRFCQFg(").append(EnablePortfolioRFCQFg).append(")");
		stringBuilder.append("EnableMOCfg(").append(EnableMOCfg).append(")");
		stringBuilder.append("MOCFixingTime(").append(MOCFixingTime).append(")");
		stringBuilder.append("MOCCutoff(").append(MOCCutoff).append(")");
		return stringBuilder.toString();
	}
}
