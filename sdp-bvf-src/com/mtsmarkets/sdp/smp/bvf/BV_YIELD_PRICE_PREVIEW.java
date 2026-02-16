package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_YIELD_PRICE_PREVIEW extends SMPMessage
{
	public static final long CLASS_ID = 114284;

	private long YieldPricePreviewId = 0;
	private long FirstLegId = 0;
	private long SecondLegId = 0;
	private long ThirdLegId = 0;
	private TI_TRADING_MODALITY_Enum TradingModality = TI_TRADING_MODALITY_Enum.TI_TRADING_MODALITY_Cat;
	private BV_YIELD_PRICE_PREVIEW_TYPE_Enum FirstLegPreviewType = BV_YIELD_PRICE_PREVIEW_TYPE_Enum.BV_YIELD_PRICE_PREVIEW_TYPE_TradingType;
	private BV_YIELD_PRICE_PREVIEW_TYPE_Enum SecondLegPreviewType = BV_YIELD_PRICE_PREVIEW_TYPE_Enum.BV_YIELD_PRICE_PREVIEW_TYPE_TradingType;
	private BV_YIELD_PRICE_PREVIEW_TYPE_Enum ThirdLegPreviewType = BV_YIELD_PRICE_PREVIEW_TYPE_Enum.BV_YIELD_PRICE_PREVIEW_TYPE_TradingType;
	private double FirstLegPrice = 0;
	private double SecondLegPrice = 0;
	private double ThirdLegPrice = 0;
	private double FirstLegDiscountRate = 0;
	private double SecondLegDiscountRate = 0;
	private double ThirdLegDiscountRate = 0;
	private double FirstLegCMPDYield = 0;
	private double SecondLegCMPDYield = 0;
	private double ThirdLegCMPDYield = 0;
	private double FirstLegMMEYield = 0;
	private double SecondLegMMEYield = 0;
	private double ThirdLegMMEYield = 0;
	private BV_VALUE FirstLegYTC = new BV_VALUE();
	private BV_VALUE FirstLegYTW = new BV_VALUE();
	private BV_VALUE FirstLegYMWTh = new BV_VALUE();
	private double FirstLegMWCPriceTh = 0;
	private BV_VALUE FirstLegYMWExrc = new BV_VALUE();
	private BV_VALUE FirstLegYTR = new BV_VALUE();
	private BV_ANALYTICS FirstLegAnalytics = new BV_ANALYTICS();
	private BV_VALUE SecondLegYTC = new BV_VALUE();
	private BV_VALUE SecondLegYTW = new BV_VALUE();
	private BV_VALUE SecondLegYMWTh = new BV_VALUE();
	private double SecondLegMWCPriceTh = 0;
	private BV_VALUE SecondLegYMWExrc = new BV_VALUE();
	private BV_VALUE SecondLegYTR = new BV_VALUE();
	private BV_ANALYTICS SecondLegAnalytics = new BV_ANALYTICS();
	private BV_VALUE ThirdLegYTC = new BV_VALUE();
	private BV_VALUE ThirdLegYTW = new BV_VALUE();
	private BV_VALUE ThirdLegYMWTh = new BV_VALUE();
	private double ThirdLegMWCPriceTh = 0;
	private BV_VALUE ThirdLegYMWExrc = new BV_VALUE();
	private BV_VALUE ThirdLegYTR = new BV_VALUE();
	private BV_ANALYTICS ThirdLegAnalytics = new BV_ANALYTICS();
	private long FirstLegSettlementDate = 0;
	private long SecondLegSettlementDate = 0;
	private long ThirdLegSettlementDate = 0;
	private String UserData = "";

	public BV_YIELD_PRICE_PREVIEW()
	{
	}

	public long getYieldPricePreviewId()
	{
		return YieldPricePreviewId;
	}
	public void setYieldPricePreviewId(long value)
	{
		YieldPricePreviewId = value;
	}
	public long getFirstLegId()
	{
		return FirstLegId;
	}
	public void setFirstLegId(long value)
	{
		FirstLegId = value;
	}
	public long getSecondLegId()
	{
		return SecondLegId;
	}
	public void setSecondLegId(long value)
	{
		SecondLegId = value;
	}
	public long getThirdLegId()
	{
		return ThirdLegId;
	}
	public void setThirdLegId(long value)
	{
		ThirdLegId = value;
	}
	public TI_TRADING_MODALITY_Enum getTradingModality()
	{
		return TradingModality;
	}
	public void setTradingModality(TI_TRADING_MODALITY_Enum value)
	{
		TradingModality = value;
	}
	public BV_YIELD_PRICE_PREVIEW_TYPE_Enum getFirstLegPreviewType()
	{
		return FirstLegPreviewType;
	}
	public void setFirstLegPreviewType(BV_YIELD_PRICE_PREVIEW_TYPE_Enum value)
	{
		FirstLegPreviewType = value;
	}
	public BV_YIELD_PRICE_PREVIEW_TYPE_Enum getSecondLegPreviewType()
	{
		return SecondLegPreviewType;
	}
	public void setSecondLegPreviewType(BV_YIELD_PRICE_PREVIEW_TYPE_Enum value)
	{
		SecondLegPreviewType = value;
	}
	public BV_YIELD_PRICE_PREVIEW_TYPE_Enum getThirdLegPreviewType()
	{
		return ThirdLegPreviewType;
	}
	public void setThirdLegPreviewType(BV_YIELD_PRICE_PREVIEW_TYPE_Enum value)
	{
		ThirdLegPreviewType = value;
	}
	public double getFirstLegPrice()
	{
		return FirstLegPrice;
	}
	public void setFirstLegPrice(double value)
	{
		FirstLegPrice = value;
	}
	public double getSecondLegPrice()
	{
		return SecondLegPrice;
	}
	public void setSecondLegPrice(double value)
	{
		SecondLegPrice = value;
	}
	public double getThirdLegPrice()
	{
		return ThirdLegPrice;
	}
	public void setThirdLegPrice(double value)
	{
		ThirdLegPrice = value;
	}
	public double getFirstLegDiscountRate()
	{
		return FirstLegDiscountRate;
	}
	public void setFirstLegDiscountRate(double value)
	{
		FirstLegDiscountRate = value;
	}
	public double getSecondLegDiscountRate()
	{
		return SecondLegDiscountRate;
	}
	public void setSecondLegDiscountRate(double value)
	{
		SecondLegDiscountRate = value;
	}
	public double getThirdLegDiscountRate()
	{
		return ThirdLegDiscountRate;
	}
	public void setThirdLegDiscountRate(double value)
	{
		ThirdLegDiscountRate = value;
	}
	public double getFirstLegCMPDYield()
	{
		return FirstLegCMPDYield;
	}
	public void setFirstLegCMPDYield(double value)
	{
		FirstLegCMPDYield = value;
	}
	public double getSecondLegCMPDYield()
	{
		return SecondLegCMPDYield;
	}
	public void setSecondLegCMPDYield(double value)
	{
		SecondLegCMPDYield = value;
	}
	public double getThirdLegCMPDYield()
	{
		return ThirdLegCMPDYield;
	}
	public void setThirdLegCMPDYield(double value)
	{
		ThirdLegCMPDYield = value;
	}
	public double getFirstLegMMEYield()
	{
		return FirstLegMMEYield;
	}
	public void setFirstLegMMEYield(double value)
	{
		FirstLegMMEYield = value;
	}
	public double getSecondLegMMEYield()
	{
		return SecondLegMMEYield;
	}
	public void setSecondLegMMEYield(double value)
	{
		SecondLegMMEYield = value;
	}
	public double getThirdLegMMEYield()
	{
		return ThirdLegMMEYield;
	}
	public void setThirdLegMMEYield(double value)
	{
		ThirdLegMMEYield = value;
	}
	public BV_VALUE getFirstLegYTC()
	{
		return FirstLegYTC;
	}
	public void setFirstLegYTC(BV_VALUE value)
	{
		FirstLegYTC = value;
	}
	public BV_VALUE getFirstLegYTW()
	{
		return FirstLegYTW;
	}
	public void setFirstLegYTW(BV_VALUE value)
	{
		FirstLegYTW = value;
	}
	public BV_VALUE getFirstLegYMWTh()
	{
		return FirstLegYMWTh;
	}
	public void setFirstLegYMWTh(BV_VALUE value)
	{
		FirstLegYMWTh = value;
	}
	public double getFirstLegMWCPriceTh()
	{
		return FirstLegMWCPriceTh;
	}
	public void setFirstLegMWCPriceTh(double value)
	{
		FirstLegMWCPriceTh = value;
	}
	public BV_VALUE getFirstLegYMWExrc()
	{
		return FirstLegYMWExrc;
	}
	public void setFirstLegYMWExrc(BV_VALUE value)
	{
		FirstLegYMWExrc = value;
	}
	public BV_VALUE getFirstLegYTR()
	{
		return FirstLegYTR;
	}
	public void setFirstLegYTR(BV_VALUE value)
	{
		FirstLegYTR = value;
	}
	public BV_ANALYTICS getFirstLegAnalytics()
	{
		return FirstLegAnalytics;
	}
	public void setFirstLegAnalytics(BV_ANALYTICS value)
	{
		FirstLegAnalytics = value;
	}
	public BV_VALUE getSecondLegYTC()
	{
		return SecondLegYTC;
	}
	public void setSecondLegYTC(BV_VALUE value)
	{
		SecondLegYTC = value;
	}
	public BV_VALUE getSecondLegYTW()
	{
		return SecondLegYTW;
	}
	public void setSecondLegYTW(BV_VALUE value)
	{
		SecondLegYTW = value;
	}
	public BV_VALUE getSecondLegYMWTh()
	{
		return SecondLegYMWTh;
	}
	public void setSecondLegYMWTh(BV_VALUE value)
	{
		SecondLegYMWTh = value;
	}
	public double getSecondLegMWCPriceTh()
	{
		return SecondLegMWCPriceTh;
	}
	public void setSecondLegMWCPriceTh(double value)
	{
		SecondLegMWCPriceTh = value;
	}
	public BV_VALUE getSecondLegYMWExrc()
	{
		return SecondLegYMWExrc;
	}
	public void setSecondLegYMWExrc(BV_VALUE value)
	{
		SecondLegYMWExrc = value;
	}
	public BV_VALUE getSecondLegYTR()
	{
		return SecondLegYTR;
	}
	public void setSecondLegYTR(BV_VALUE value)
	{
		SecondLegYTR = value;
	}
	public BV_ANALYTICS getSecondLegAnalytics()
	{
		return SecondLegAnalytics;
	}
	public void setSecondLegAnalytics(BV_ANALYTICS value)
	{
		SecondLegAnalytics = value;
	}
	public BV_VALUE getThirdLegYTC()
	{
		return ThirdLegYTC;
	}
	public void setThirdLegYTC(BV_VALUE value)
	{
		ThirdLegYTC = value;
	}
	public BV_VALUE getThirdLegYTW()
	{
		return ThirdLegYTW;
	}
	public void setThirdLegYTW(BV_VALUE value)
	{
		ThirdLegYTW = value;
	}
	public BV_VALUE getThirdLegYMWTh()
	{
		return ThirdLegYMWTh;
	}
	public void setThirdLegYMWTh(BV_VALUE value)
	{
		ThirdLegYMWTh = value;
	}
	public double getThirdLegMWCPriceTh()
	{
		return ThirdLegMWCPriceTh;
	}
	public void setThirdLegMWCPriceTh(double value)
	{
		ThirdLegMWCPriceTh = value;
	}
	public BV_VALUE getThirdLegYMWExrc()
	{
		return ThirdLegYMWExrc;
	}
	public void setThirdLegYMWExrc(BV_VALUE value)
	{
		ThirdLegYMWExrc = value;
	}
	public BV_VALUE getThirdLegYTR()
	{
		return ThirdLegYTR;
	}
	public void setThirdLegYTR(BV_VALUE value)
	{
		ThirdLegYTR = value;
	}
	public BV_ANALYTICS getThirdLegAnalytics()
	{
		return ThirdLegAnalytics;
	}
	public void setThirdLegAnalytics(BV_ANALYTICS value)
	{
		ThirdLegAnalytics = value;
	}
	public long getFirstLegSettlementDate()
	{
		return FirstLegSettlementDate;
	}
	public void setFirstLegSettlementDate(long value)
	{
		FirstLegSettlementDate = value;
	}
	public long getSecondLegSettlementDate()
	{
		return SecondLegSettlementDate;
	}
	public void setSecondLegSettlementDate(long value)
	{
		SecondLegSettlementDate = value;
	}
	public long getThirdLegSettlementDate()
	{
		return ThirdLegSettlementDate;
	}
	public void setThirdLegSettlementDate(long value)
	{
		ThirdLegSettlementDate = value;
	}
	public String getUserData()
	{
		return UserData;
	}
	public void setUserData(String value)
	{
		UserData = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		YieldPricePreviewId = (long)byteBuffer.readInt();
		FirstLegId = (long)byteBuffer.readInt();
		SecondLegId = (long)byteBuffer.readInt();
		ThirdLegId = (long)byteBuffer.readInt();
		TradingModality = TradingModality.getEnum(byteBuffer.readInt());
		FirstLegPreviewType = FirstLegPreviewType.getEnum(byteBuffer.readInt());
		SecondLegPreviewType = SecondLegPreviewType.getEnum(byteBuffer.readInt());
		ThirdLegPreviewType = ThirdLegPreviewType.getEnum(byteBuffer.readInt());
		FirstLegPrice = byteBuffer.readDouble();
		SecondLegPrice = byteBuffer.readDouble();
		ThirdLegPrice = byteBuffer.readDouble();
		FirstLegDiscountRate = byteBuffer.readDouble();
		SecondLegDiscountRate = byteBuffer.readDouble();
		ThirdLegDiscountRate = byteBuffer.readDouble();
		FirstLegCMPDYield = byteBuffer.readDouble();
		SecondLegCMPDYield = byteBuffer.readDouble();
		ThirdLegCMPDYield = byteBuffer.readDouble();
		FirstLegMMEYield = byteBuffer.readDouble();
		SecondLegMMEYield = byteBuffer.readDouble();
		ThirdLegMMEYield = byteBuffer.readDouble();
		FirstLegYTC.readXDR(byteBuffer);
		FirstLegYTW.readXDR(byteBuffer);
		FirstLegYMWTh.readXDR(byteBuffer);
		FirstLegMWCPriceTh = byteBuffer.readDouble();
		FirstLegYMWExrc.readXDR(byteBuffer);
		FirstLegYTR.readXDR(byteBuffer);
		FirstLegAnalytics.readXDR(byteBuffer);
		SecondLegYTC.readXDR(byteBuffer);
		SecondLegYTW.readXDR(byteBuffer);
		SecondLegYMWTh.readXDR(byteBuffer);
		SecondLegMWCPriceTh = byteBuffer.readDouble();
		SecondLegYMWExrc.readXDR(byteBuffer);
		SecondLegYTR.readXDR(byteBuffer);
		SecondLegAnalytics.readXDR(byteBuffer);
		ThirdLegYTC.readXDR(byteBuffer);
		ThirdLegYTW.readXDR(byteBuffer);
		ThirdLegYMWTh.readXDR(byteBuffer);
		ThirdLegMWCPriceTh = byteBuffer.readDouble();
		ThirdLegYMWExrc.readXDR(byteBuffer);
		ThirdLegYTR.readXDR(byteBuffer);
		ThirdLegAnalytics.readXDR(byteBuffer);
		FirstLegSettlementDate = (long)byteBuffer.readInt();
		SecondLegSettlementDate = (long)byteBuffer.readInt();
		ThirdLegSettlementDate = (long)byteBuffer.readInt();
		UserData = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(YieldPricePreviewId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(FirstLegId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SecondLegId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(ThirdLegId & 0xFFFFFFFFL));
		byteBuffer.writeInt(TradingModality.getValue());
		byteBuffer.writeInt(FirstLegPreviewType.getValue());
		byteBuffer.writeInt(SecondLegPreviewType.getValue());
		byteBuffer.writeInt(ThirdLegPreviewType.getValue());
		byteBuffer.writeDouble(FirstLegPrice);
		byteBuffer.writeDouble(SecondLegPrice);
		byteBuffer.writeDouble(ThirdLegPrice);
		byteBuffer.writeDouble(FirstLegDiscountRate);
		byteBuffer.writeDouble(SecondLegDiscountRate);
		byteBuffer.writeDouble(ThirdLegDiscountRate);
		byteBuffer.writeDouble(FirstLegCMPDYield);
		byteBuffer.writeDouble(SecondLegCMPDYield);
		byteBuffer.writeDouble(ThirdLegCMPDYield);
		byteBuffer.writeDouble(FirstLegMMEYield);
		byteBuffer.writeDouble(SecondLegMMEYield);
		byteBuffer.writeDouble(ThirdLegMMEYield);
		FirstLegYTC.writeXDR(byteBuffer);
		FirstLegYTW.writeXDR(byteBuffer);
		FirstLegYMWTh.writeXDR(byteBuffer);
		byteBuffer.writeDouble(FirstLegMWCPriceTh);
		FirstLegYMWExrc.writeXDR(byteBuffer);
		FirstLegYTR.writeXDR(byteBuffer);
		FirstLegAnalytics.writeXDR(byteBuffer);
		SecondLegYTC.writeXDR(byteBuffer);
		SecondLegYTW.writeXDR(byteBuffer);
		SecondLegYMWTh.writeXDR(byteBuffer);
		byteBuffer.writeDouble(SecondLegMWCPriceTh);
		SecondLegYMWExrc.writeXDR(byteBuffer);
		SecondLegYTR.writeXDR(byteBuffer);
		SecondLegAnalytics.writeXDR(byteBuffer);
		ThirdLegYTC.writeXDR(byteBuffer);
		ThirdLegYTW.writeXDR(byteBuffer);
		ThirdLegYMWTh.writeXDR(byteBuffer);
		byteBuffer.writeDouble(ThirdLegMWCPriceTh);
		ThirdLegYMWExrc.writeXDR(byteBuffer);
		ThirdLegYTR.writeXDR(byteBuffer);
		ThirdLegAnalytics.writeXDR(byteBuffer);
		byteBuffer.writeInt((int)(FirstLegSettlementDate & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SecondLegSettlementDate & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(ThirdLegSettlementDate & 0xFFFFFFFFL));
		byteBuffer.writeString(UserData);

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
		stringBuilder.append("BV_YIELD_PRICE_PREVIEW::");
		stringBuilder.append("YieldPricePreviewId(").append(YieldPricePreviewId).append(")");
		stringBuilder.append("FirstLegId(").append(FirstLegId).append(")");
		stringBuilder.append("SecondLegId(").append(SecondLegId).append(")");
		stringBuilder.append("ThirdLegId(").append(ThirdLegId).append(")");
		stringBuilder.append("TradingModality(").append(TradingModality).append(")");
		stringBuilder.append("FirstLegPreviewType(").append(FirstLegPreviewType).append(")");
		stringBuilder.append("SecondLegPreviewType(").append(SecondLegPreviewType).append(")");
		stringBuilder.append("ThirdLegPreviewType(").append(ThirdLegPreviewType).append(")");
		stringBuilder.append("FirstLegPrice(").append(FirstLegPrice).append(")");
		stringBuilder.append("SecondLegPrice(").append(SecondLegPrice).append(")");
		stringBuilder.append("ThirdLegPrice(").append(ThirdLegPrice).append(")");
		stringBuilder.append("FirstLegDiscountRate(").append(FirstLegDiscountRate).append(")");
		stringBuilder.append("SecondLegDiscountRate(").append(SecondLegDiscountRate).append(")");
		stringBuilder.append("ThirdLegDiscountRate(").append(ThirdLegDiscountRate).append(")");
		stringBuilder.append("FirstLegCMPDYield(").append(FirstLegCMPDYield).append(")");
		stringBuilder.append("SecondLegCMPDYield(").append(SecondLegCMPDYield).append(")");
		stringBuilder.append("ThirdLegCMPDYield(").append(ThirdLegCMPDYield).append(")");
		stringBuilder.append("FirstLegMMEYield(").append(FirstLegMMEYield).append(")");
		stringBuilder.append("SecondLegMMEYield(").append(SecondLegMMEYield).append(")");
		stringBuilder.append("ThirdLegMMEYield(").append(ThirdLegMMEYield).append(")");
		stringBuilder.append("FirstLegYTC(").append(FirstLegYTC.toString()).append(")");
		stringBuilder.append("FirstLegYTW(").append(FirstLegYTW.toString()).append(")");
		stringBuilder.append("FirstLegYMWTh(").append(FirstLegYMWTh.toString()).append(")");
		stringBuilder.append("FirstLegMWCPriceTh(").append(FirstLegMWCPriceTh).append(")");
		stringBuilder.append("FirstLegYMWExrc(").append(FirstLegYMWExrc.toString()).append(")");
		stringBuilder.append("FirstLegYTR(").append(FirstLegYTR.toString()).append(")");
		stringBuilder.append("FirstLegAnalytics(").append(FirstLegAnalytics.toString()).append(")");
		stringBuilder.append("SecondLegYTC(").append(SecondLegYTC.toString()).append(")");
		stringBuilder.append("SecondLegYTW(").append(SecondLegYTW.toString()).append(")");
		stringBuilder.append("SecondLegYMWTh(").append(SecondLegYMWTh.toString()).append(")");
		stringBuilder.append("SecondLegMWCPriceTh(").append(SecondLegMWCPriceTh).append(")");
		stringBuilder.append("SecondLegYMWExrc(").append(SecondLegYMWExrc.toString()).append(")");
		stringBuilder.append("SecondLegYTR(").append(SecondLegYTR.toString()).append(")");
		stringBuilder.append("SecondLegAnalytics(").append(SecondLegAnalytics.toString()).append(")");
		stringBuilder.append("ThirdLegYTC(").append(ThirdLegYTC.toString()).append(")");
		stringBuilder.append("ThirdLegYTW(").append(ThirdLegYTW.toString()).append(")");
		stringBuilder.append("ThirdLegYMWTh(").append(ThirdLegYMWTh.toString()).append(")");
		stringBuilder.append("ThirdLegMWCPriceTh(").append(ThirdLegMWCPriceTh).append(")");
		stringBuilder.append("ThirdLegYMWExrc(").append(ThirdLegYMWExrc.toString()).append(")");
		stringBuilder.append("ThirdLegYTR(").append(ThirdLegYTR.toString()).append(")");
		stringBuilder.append("ThirdLegAnalytics(").append(ThirdLegAnalytics.toString()).append(")");
		stringBuilder.append("FirstLegSettlementDate(").append(FirstLegSettlementDate).append(")");
		stringBuilder.append("SecondLegSettlementDate(").append(SecondLegSettlementDate).append(")");
		stringBuilder.append("ThirdLegSettlementDate(").append(ThirdLegSettlementDate).append(")");
		stringBuilder.append("UserData(").append(UserData).append(")");
		return stringBuilder.toString();
	}
}
