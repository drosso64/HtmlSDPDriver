package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_INSTRUMENT extends SMPMessage
{
	public static final long CLASS_ID = 100019;

	private long FinancialInstrumentId = 0;
	private String InstrumentCode = "";
	private String InstrumentDesc = "";
	private TI_INSTRUMENT_TIPOLOGY_Enum InstrumentTipology = TI_INSTRUMENT_TIPOLOGY_Enum.TI_INSTRUMENT_TIPOLOGY_Normal;
	private long IssuerId = 0;
	private long IssueDate = 0;
	private long MaturityDate = 0;
	private double CouponRate = 0;
	private short CouponFrequency = 0;
	private TI_COUPON_TYPE_Enum CouponType = TI_COUPON_TYPE_Enum.TI_COUPON_TYPE_ZeroCoupon;
	private long FirstCouponDate = 0;
	private long LastCouponDate = 0;
	private short MaturityBucket = 0;
	private long ResidualMaturityId = 0;
	private long ResidualMaturityDays = 0;
	private long FirstAccrualDate = 0;
	private double AuctionInstrumentPrice = 0;
	private double AuctionInstrumentYield = 0;
	private double RedemptionPrice = 0;
	private TI_FLAG_Enum BenchmarkFlag = TI_FLAG_Enum.TI_FLAG_No;
	private short SettlPeriod = 0;
	private short SettlExpiryPeriod = 0;
	private long FirstSettlDate = 0;
	private short StartExceptionDays = 0;
	private short StopExceptionDays = 0;
	private TI_EXCEPTION_DATE_TYPE_Enum ExceptionDateType = TI_EXCEPTION_DATE_TYPE_Enum.TI_EXCEPTION_DATE_TYPE_None;
	private TI_YIELD_FORMULA_TYPE_Enum YieldFormulaType = TI_YIELD_FORMULA_TYPE_Enum.TI_YIELD_FORMULA_TYPE_None;
	private TI_DISCOUNT_RATE_FORMULA_TYPE_Enum DiscountRateFormulaType = TI_DISCOUNT_RATE_FORMULA_TYPE_Enum.TI_DISCOUNT_RATE_FORMULA_TYPE_None;
	private TI_DAY_COUNT_CONVENTION_TYPE_Enum DayCountConventionType = TI_DAY_COUNT_CONVENTION_TYPE_Enum.TI_DAY_COUNT_CONVENTION_TYPE_ZeroCoupon;
	private short BaseCoefficientIndex = 0;
	private short InflationIndexId = 0;
	private String BondTypology = "";
	private String CurrencyCode = "";
	private String SettlCurrencyCode = "";
	private double BPV = 0;
	private short MTSClassification = 0;
	private String AlternativeCode = "";
	private double Outstanding = 0;
	private TI_FLAG_Enum CCPEligibleFg = TI_FLAG_Enum.TI_FLAG_No;

	public TI_INSTRUMENT()
	{
	}

	public long getFinancialInstrumentId()
	{
		return FinancialInstrumentId;
	}
	public void setFinancialInstrumentId(long value)
	{
		FinancialInstrumentId = value;
	}
	public String getInstrumentCode()
	{
		return InstrumentCode;
	}
	public void setInstrumentCode(String value)
	{
		InstrumentCode = value;
	}
	public String getInstrumentDesc()
	{
		return InstrumentDesc;
	}
	public void setInstrumentDesc(String value)
	{
		InstrumentDesc = value;
	}
	public TI_INSTRUMENT_TIPOLOGY_Enum getInstrumentTipology()
	{
		return InstrumentTipology;
	}
	public void setInstrumentTipology(TI_INSTRUMENT_TIPOLOGY_Enum value)
	{
		InstrumentTipology = value;
	}
	public long getIssuerId()
	{
		return IssuerId;
	}
	public void setIssuerId(long value)
	{
		IssuerId = value;
	}
	public long getIssueDate()
	{
		return IssueDate;
	}
	public void setIssueDate(long value)
	{
		IssueDate = value;
	}
	public long getMaturityDate()
	{
		return MaturityDate;
	}
	public void setMaturityDate(long value)
	{
		MaturityDate = value;
	}
	public double getCouponRate()
	{
		return CouponRate;
	}
	public void setCouponRate(double value)
	{
		CouponRate = value;
	}
	public short getCouponFrequency()
	{
		return CouponFrequency;
	}
	public void setCouponFrequency(short value)
	{
		CouponFrequency = value;
	}
	public TI_COUPON_TYPE_Enum getCouponType()
	{
		return CouponType;
	}
	public void setCouponType(TI_COUPON_TYPE_Enum value)
	{
		CouponType = value;
	}
	public long getFirstCouponDate()
	{
		return FirstCouponDate;
	}
	public void setFirstCouponDate(long value)
	{
		FirstCouponDate = value;
	}
	public long getLastCouponDate()
	{
		return LastCouponDate;
	}
	public void setLastCouponDate(long value)
	{
		LastCouponDate = value;
	}
	public short getMaturityBucket()
	{
		return MaturityBucket;
	}
	public void setMaturityBucket(short value)
	{
		MaturityBucket = value;
	}
	public long getResidualMaturityId()
	{
		return ResidualMaturityId;
	}
	public void setResidualMaturityId(long value)
	{
		ResidualMaturityId = value;
	}
	public long getResidualMaturityDays()
	{
		return ResidualMaturityDays;
	}
	public void setResidualMaturityDays(long value)
	{
		ResidualMaturityDays = value;
	}
	public long getFirstAccrualDate()
	{
		return FirstAccrualDate;
	}
	public void setFirstAccrualDate(long value)
	{
		FirstAccrualDate = value;
	}
	public double getAuctionInstrumentPrice()
	{
		return AuctionInstrumentPrice;
	}
	public void setAuctionInstrumentPrice(double value)
	{
		AuctionInstrumentPrice = value;
	}
	public double getAuctionInstrumentYield()
	{
		return AuctionInstrumentYield;
	}
	public void setAuctionInstrumentYield(double value)
	{
		AuctionInstrumentYield = value;
	}
	public double getRedemptionPrice()
	{
		return RedemptionPrice;
	}
	public void setRedemptionPrice(double value)
	{
		RedemptionPrice = value;
	}
	public TI_FLAG_Enum getBenchmarkFlag()
	{
		return BenchmarkFlag;
	}
	public void setBenchmarkFlag(TI_FLAG_Enum value)
	{
		BenchmarkFlag = value;
	}
	public short getSettlPeriod()
	{
		return SettlPeriod;
	}
	public void setSettlPeriod(short value)
	{
		SettlPeriod = value;
	}
	public short getSettlExpiryPeriod()
	{
		return SettlExpiryPeriod;
	}
	public void setSettlExpiryPeriod(short value)
	{
		SettlExpiryPeriod = value;
	}
	public long getFirstSettlDate()
	{
		return FirstSettlDate;
	}
	public void setFirstSettlDate(long value)
	{
		FirstSettlDate = value;
	}
	public short getStartExceptionDays()
	{
		return StartExceptionDays;
	}
	public void setStartExceptionDays(short value)
	{
		StartExceptionDays = value;
	}
	public short getStopExceptionDays()
	{
		return StopExceptionDays;
	}
	public void setStopExceptionDays(short value)
	{
		StopExceptionDays = value;
	}
	public TI_EXCEPTION_DATE_TYPE_Enum getExceptionDateType()
	{
		return ExceptionDateType;
	}
	public void setExceptionDateType(TI_EXCEPTION_DATE_TYPE_Enum value)
	{
		ExceptionDateType = value;
	}
	public TI_YIELD_FORMULA_TYPE_Enum getYieldFormulaType()
	{
		return YieldFormulaType;
	}
	public void setYieldFormulaType(TI_YIELD_FORMULA_TYPE_Enum value)
	{
		YieldFormulaType = value;
	}
	public TI_DISCOUNT_RATE_FORMULA_TYPE_Enum getDiscountRateFormulaType()
	{
		return DiscountRateFormulaType;
	}
	public void setDiscountRateFormulaType(TI_DISCOUNT_RATE_FORMULA_TYPE_Enum value)
	{
		DiscountRateFormulaType = value;
	}
	public TI_DAY_COUNT_CONVENTION_TYPE_Enum getDayCountConventionType()
	{
		return DayCountConventionType;
	}
	public void setDayCountConventionType(TI_DAY_COUNT_CONVENTION_TYPE_Enum value)
	{
		DayCountConventionType = value;
	}
	public short getBaseCoefficientIndex()
	{
		return BaseCoefficientIndex;
	}
	public void setBaseCoefficientIndex(short value)
	{
		BaseCoefficientIndex = value;
	}
	public short getInflationIndexId()
	{
		return InflationIndexId;
	}
	public void setInflationIndexId(short value)
	{
		InflationIndexId = value;
	}
	public String getBondTypology()
	{
		return BondTypology;
	}
	public void setBondTypology(String value)
	{
		BondTypology = value;
	}
	public String getCurrencyCode()
	{
		return CurrencyCode;
	}
	public void setCurrencyCode(String value)
	{
		CurrencyCode = value;
	}
	public String getSettlCurrencyCode()
	{
		return SettlCurrencyCode;
	}
	public void setSettlCurrencyCode(String value)
	{
		SettlCurrencyCode = value;
	}
	public double getBPV()
	{
		return BPV;
	}
	public void setBPV(double value)
	{
		BPV = value;
	}
	public short getMTSClassification()
	{
		return MTSClassification;
	}
	public void setMTSClassification(short value)
	{
		MTSClassification = value;
	}
	public String getAlternativeCode()
	{
		return AlternativeCode;
	}
	public void setAlternativeCode(String value)
	{
		AlternativeCode = value;
	}
	public double getOutstanding()
	{
		return Outstanding;
	}
	public void setOutstanding(double value)
	{
		Outstanding = value;
	}
	public TI_FLAG_Enum getCCPEligibleFg()
	{
		return CCPEligibleFg;
	}
	public void setCCPEligibleFg(TI_FLAG_Enum value)
	{
		CCPEligibleFg = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		FinancialInstrumentId = (long)byteBuffer.readInt();
		InstrumentCode = byteBuffer.readString();
		InstrumentDesc = byteBuffer.readString();
		InstrumentTipology = InstrumentTipology.getEnum(byteBuffer.readInt());
		IssuerId = (long)byteBuffer.readInt();
		IssueDate = (long)byteBuffer.readInt();
		MaturityDate = (long)byteBuffer.readInt();
		CouponRate = byteBuffer.readDouble();
		CouponFrequency = (short)byteBuffer.readInt();
		CouponType = CouponType.getEnum(byteBuffer.readInt());
		FirstCouponDate = (long)byteBuffer.readInt();
		LastCouponDate = (long)byteBuffer.readInt();
		MaturityBucket = (short)byteBuffer.readInt();
		ResidualMaturityId = (long)byteBuffer.readInt();
		ResidualMaturityDays = (long)byteBuffer.readInt();
		FirstAccrualDate = (long)byteBuffer.readInt();
		AuctionInstrumentPrice = byteBuffer.readDouble();
		AuctionInstrumentYield = byteBuffer.readDouble();
		RedemptionPrice = byteBuffer.readDouble();
		BenchmarkFlag = BenchmarkFlag.getEnum(byteBuffer.readInt());
		SettlPeriod = (short)byteBuffer.readInt();
		SettlExpiryPeriod = (short)byteBuffer.readInt();
		FirstSettlDate = (long)byteBuffer.readInt();
		StartExceptionDays = (short)byteBuffer.readInt();
		StopExceptionDays = (short)byteBuffer.readInt();
		ExceptionDateType = ExceptionDateType.getEnum(byteBuffer.readInt());
		YieldFormulaType = YieldFormulaType.getEnum(byteBuffer.readInt());
		DiscountRateFormulaType = DiscountRateFormulaType.getEnum(byteBuffer.readInt());
		DayCountConventionType = DayCountConventionType.getEnum(byteBuffer.readInt());
		BaseCoefficientIndex = (short)byteBuffer.readInt();
		InflationIndexId = (short)byteBuffer.readInt();
		BondTypology = byteBuffer.readString();
		CurrencyCode = byteBuffer.readString();
		SettlCurrencyCode = byteBuffer.readString();
		BPV = byteBuffer.readDouble();
		MTSClassification = (short)byteBuffer.readInt();
		AlternativeCode = byteBuffer.readString();
		Outstanding = byteBuffer.readDouble();
		CCPEligibleFg = CCPEligibleFg.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(FinancialInstrumentId & 0xFFFFFFFFL));
		byteBuffer.writeString(InstrumentCode);
		byteBuffer.writeString(InstrumentDesc);
		byteBuffer.writeInt(InstrumentTipology.getValue());
		byteBuffer.writeInt((int)(IssuerId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(IssueDate & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(MaturityDate & 0xFFFFFFFFL));
		byteBuffer.writeDouble(CouponRate);
		byteBuffer.writeInt((int)(CouponFrequency & 0xFFFFL));
		byteBuffer.writeInt(CouponType.getValue());
		byteBuffer.writeInt((int)(FirstCouponDate & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(LastCouponDate & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(MaturityBucket & 0xFFFFL));
		byteBuffer.writeInt((int)(ResidualMaturityId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(ResidualMaturityDays & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(FirstAccrualDate & 0xFFFFFFFFL));
		byteBuffer.writeDouble(AuctionInstrumentPrice);
		byteBuffer.writeDouble(AuctionInstrumentYield);
		byteBuffer.writeDouble(RedemptionPrice);
		byteBuffer.writeInt(BenchmarkFlag.getValue());
		byteBuffer.writeInt((int)(SettlPeriod & 0xFFFFL));
		byteBuffer.writeInt((int)(SettlExpiryPeriod & 0xFFFFL));
		byteBuffer.writeInt((int)(FirstSettlDate & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(StartExceptionDays & 0xFFFFL));
		byteBuffer.writeInt((int)(StopExceptionDays & 0xFFFFL));
		byteBuffer.writeInt(ExceptionDateType.getValue());
		byteBuffer.writeInt(YieldFormulaType.getValue());
		byteBuffer.writeInt(DiscountRateFormulaType.getValue());
		byteBuffer.writeInt(DayCountConventionType.getValue());
		byteBuffer.writeInt((int)(BaseCoefficientIndex & 0xFFFFL));
		byteBuffer.writeInt((int)(InflationIndexId & 0xFFFFL));
		byteBuffer.writeString(BondTypology);
		byteBuffer.writeString(CurrencyCode);
		byteBuffer.writeString(SettlCurrencyCode);
		byteBuffer.writeDouble(BPV);
		byteBuffer.writeInt((int)(MTSClassification & 0xFFFFL));
		byteBuffer.writeString(AlternativeCode);
		byteBuffer.writeDouble(Outstanding);
		byteBuffer.writeInt(CCPEligibleFg.getValue());

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
		stringBuilder.append("TI_INSTRUMENT::");
		stringBuilder.append("FinancialInstrumentId(").append(FinancialInstrumentId).append(")");
		stringBuilder.append("InstrumentCode(").append(InstrumentCode).append(")");
		stringBuilder.append("InstrumentDesc(").append(InstrumentDesc).append(")");
		stringBuilder.append("InstrumentTipology(").append(InstrumentTipology).append(")");
		stringBuilder.append("IssuerId(").append(IssuerId).append(")");
		stringBuilder.append("IssueDate(").append(IssueDate).append(")");
		stringBuilder.append("MaturityDate(").append(MaturityDate).append(")");
		stringBuilder.append("CouponRate(").append(CouponRate).append(")");
		stringBuilder.append("CouponFrequency(").append(CouponFrequency).append(")");
		stringBuilder.append("CouponType(").append(CouponType).append(")");
		stringBuilder.append("FirstCouponDate(").append(FirstCouponDate).append(")");
		stringBuilder.append("LastCouponDate(").append(LastCouponDate).append(")");
		stringBuilder.append("MaturityBucket(").append(MaturityBucket).append(")");
		stringBuilder.append("ResidualMaturityId(").append(ResidualMaturityId).append(")");
		stringBuilder.append("ResidualMaturityDays(").append(ResidualMaturityDays).append(")");
		stringBuilder.append("FirstAccrualDate(").append(FirstAccrualDate).append(")");
		stringBuilder.append("AuctionInstrumentPrice(").append(AuctionInstrumentPrice).append(")");
		stringBuilder.append("AuctionInstrumentYield(").append(AuctionInstrumentYield).append(")");
		stringBuilder.append("RedemptionPrice(").append(RedemptionPrice).append(")");
		stringBuilder.append("BenchmarkFlag(").append(BenchmarkFlag).append(")");
		stringBuilder.append("SettlPeriod(").append(SettlPeriod).append(")");
		stringBuilder.append("SettlExpiryPeriod(").append(SettlExpiryPeriod).append(")");
		stringBuilder.append("FirstSettlDate(").append(FirstSettlDate).append(")");
		stringBuilder.append("StartExceptionDays(").append(StartExceptionDays).append(")");
		stringBuilder.append("StopExceptionDays(").append(StopExceptionDays).append(")");
		stringBuilder.append("ExceptionDateType(").append(ExceptionDateType).append(")");
		stringBuilder.append("YieldFormulaType(").append(YieldFormulaType).append(")");
		stringBuilder.append("DiscountRateFormulaType(").append(DiscountRateFormulaType).append(")");
		stringBuilder.append("DayCountConventionType(").append(DayCountConventionType).append(")");
		stringBuilder.append("BaseCoefficientIndex(").append(BaseCoefficientIndex).append(")");
		stringBuilder.append("InflationIndexId(").append(InflationIndexId).append(")");
		stringBuilder.append("BondTypology(").append(BondTypology).append(")");
		stringBuilder.append("CurrencyCode(").append(CurrencyCode).append(")");
		stringBuilder.append("SettlCurrencyCode(").append(SettlCurrencyCode).append(")");
		stringBuilder.append("BPV(").append(BPV).append(")");
		stringBuilder.append("MTSClassification(").append(MTSClassification).append(")");
		stringBuilder.append("AlternativeCode(").append(AlternativeCode).append(")");
		stringBuilder.append("Outstanding(").append(Outstanding).append(")");
		stringBuilder.append("CCPEligibleFg(").append(CCPEligibleFg).append(")");
		return stringBuilder.toString();
	}
}
