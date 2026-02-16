package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_LIQUID_INSTRUMENT_THRESHOLDS extends SMPMessage
{
	public static final long CLASS_ID = 400052;

	private long InstrumentId = 0;
	private long FinancialInstrumentId = 0;
	private short AreaCodeId = 0;
	private TI_FLAG_Enum LiquidFg = TI_FLAG_Enum.TI_FLAG_No;
	private TI_FLAG_Enum MMIFg = TI_FLAG_Enum.TI_FLAG_No;
	private double ECBFxRate = 0;
	private double SSTIPreTradeQty = 0;
	private double SSTIPostTradeQty = 0;
	private double LISPreTradeQty = 0;
	private double LISPostTradeQty = 0;
	private short LISCategory = 0;
	private String RatingCategory = "";
	private String CreditRating = "";
	private short ESMAGroupId = 0;
	private short GroupId = 0;
	private String LISCurrency = "";
	private BV_VALUE LIS = new BV_VALUE();
	private BV_VALUE LIS1 = new BV_VALUE();
	private BV_VALUE LIS2 = new BV_VALUE();
	private BV_VALUE LIS3 = new BV_VALUE();
	private BV_VALUE LIS4 = new BV_VALUE();
	private BV_VALUE LIS5 = new BV_VALUE();
	private BV_VALUE LIS6 = new BV_VALUE();
	private BV_VALUE LIS7 = new BV_VALUE();
	private BV_VALUE LIS8 = new BV_VALUE();
	private BV_VALUE LIS9 = new BV_VALUE();
	private BV_VALUE LIS10 = new BV_VALUE();
	private TI_POST_TRADE_DEFERRAL_Enum BelowLISPostTradeDeferral = TI_POST_TRADE_DEFERRAL_Enum.TI_POST_TRADE_DEFERRAL_None;
	private TI_POST_TRADE_DEFERRAL_Enum AtAboveLISPostTradeDeferral = TI_POST_TRADE_DEFERRAL_Enum.TI_POST_TRADE_DEFERRAL_None;
	private TI_POST_TRADE_DEFERRAL_Enum ATBelowLIS1PostTradeDeferral = TI_POST_TRADE_DEFERRAL_Enum.TI_POST_TRADE_DEFERRAL_None;
	private TI_POST_TRADE_DEFERRAL_Enum AtAboveLIS1PostTradeDeferral = TI_POST_TRADE_DEFERRAL_Enum.TI_POST_TRADE_DEFERRAL_None;
	private TI_POST_TRADE_DEFERRAL_Enum AtAboveLIS2PostTradeDeferral = TI_POST_TRADE_DEFERRAL_Enum.TI_POST_TRADE_DEFERRAL_None;
	private TI_POST_TRADE_DEFERRAL_Enum AtAboveLIS3PostTradeDeferral = TI_POST_TRADE_DEFERRAL_Enum.TI_POST_TRADE_DEFERRAL_None;
	private TI_POST_TRADE_DEFERRAL_Enum NoLISPostTradeDeferral = TI_POST_TRADE_DEFERRAL_Enum.TI_POST_TRADE_DEFERRAL_None;

	public BV_LIQUID_INSTRUMENT_THRESHOLDS()
	{
	}

	public long getInstrumentId()
	{
		return InstrumentId;
	}
	public void setInstrumentId(long value)
	{
		InstrumentId = value;
	}
	public long getFinancialInstrumentId()
	{
		return FinancialInstrumentId;
	}
	public void setFinancialInstrumentId(long value)
	{
		FinancialInstrumentId = value;
	}
	public short getAreaCodeId()
	{
		return AreaCodeId;
	}
	public void setAreaCodeId(short value)
	{
		AreaCodeId = value;
	}
	public TI_FLAG_Enum getLiquidFg()
	{
		return LiquidFg;
	}
	public void setLiquidFg(TI_FLAG_Enum value)
	{
		LiquidFg = value;
	}
	public TI_FLAG_Enum getMMIFg()
	{
		return MMIFg;
	}
	public void setMMIFg(TI_FLAG_Enum value)
	{
		MMIFg = value;
	}
	public double getECBFxRate()
	{
		return ECBFxRate;
	}
	public void setECBFxRate(double value)
	{
		ECBFxRate = value;
	}
	public double getSSTIPreTradeQty()
	{
		return SSTIPreTradeQty;
	}
	public void setSSTIPreTradeQty(double value)
	{
		SSTIPreTradeQty = value;
	}
	public double getSSTIPostTradeQty()
	{
		return SSTIPostTradeQty;
	}
	public void setSSTIPostTradeQty(double value)
	{
		SSTIPostTradeQty = value;
	}
	public double getLISPreTradeQty()
	{
		return LISPreTradeQty;
	}
	public void setLISPreTradeQty(double value)
	{
		LISPreTradeQty = value;
	}
	public double getLISPostTradeQty()
	{
		return LISPostTradeQty;
	}
	public void setLISPostTradeQty(double value)
	{
		LISPostTradeQty = value;
	}
	public short getLISCategory()
	{
		return LISCategory;
	}
	public void setLISCategory(short value)
	{
		LISCategory = value;
	}
	public String getRatingCategory()
	{
		return RatingCategory;
	}
	public void setRatingCategory(String value)
	{
		RatingCategory = value;
	}
	public String getCreditRating()
	{
		return CreditRating;
	}
	public void setCreditRating(String value)
	{
		CreditRating = value;
	}
	public short getESMAGroupId()
	{
		return ESMAGroupId;
	}
	public void setESMAGroupId(short value)
	{
		ESMAGroupId = value;
	}
	public short getGroupId()
	{
		return GroupId;
	}
	public void setGroupId(short value)
	{
		GroupId = value;
	}
	public String getLISCurrency()
	{
		return LISCurrency;
	}
	public void setLISCurrency(String value)
	{
		LISCurrency = value;
	}
	public BV_VALUE getLIS()
	{
		return LIS;
	}
	public void setLIS(BV_VALUE value)
	{
		LIS = value;
	}
	public BV_VALUE getLIS1()
	{
		return LIS1;
	}
	public void setLIS1(BV_VALUE value)
	{
		LIS1 = value;
	}
	public BV_VALUE getLIS2()
	{
		return LIS2;
	}
	public void setLIS2(BV_VALUE value)
	{
		LIS2 = value;
	}
	public BV_VALUE getLIS3()
	{
		return LIS3;
	}
	public void setLIS3(BV_VALUE value)
	{
		LIS3 = value;
	}
	public BV_VALUE getLIS4()
	{
		return LIS4;
	}
	public void setLIS4(BV_VALUE value)
	{
		LIS4 = value;
	}
	public BV_VALUE getLIS5()
	{
		return LIS5;
	}
	public void setLIS5(BV_VALUE value)
	{
		LIS5 = value;
	}
	public BV_VALUE getLIS6()
	{
		return LIS6;
	}
	public void setLIS6(BV_VALUE value)
	{
		LIS6 = value;
	}
	public BV_VALUE getLIS7()
	{
		return LIS7;
	}
	public void setLIS7(BV_VALUE value)
	{
		LIS7 = value;
	}
	public BV_VALUE getLIS8()
	{
		return LIS8;
	}
	public void setLIS8(BV_VALUE value)
	{
		LIS8 = value;
	}
	public BV_VALUE getLIS9()
	{
		return LIS9;
	}
	public void setLIS9(BV_VALUE value)
	{
		LIS9 = value;
	}
	public BV_VALUE getLIS10()
	{
		return LIS10;
	}
	public void setLIS10(BV_VALUE value)
	{
		LIS10 = value;
	}
	public TI_POST_TRADE_DEFERRAL_Enum getBelowLISPostTradeDeferral()
	{
		return BelowLISPostTradeDeferral;
	}
	public void setBelowLISPostTradeDeferral(TI_POST_TRADE_DEFERRAL_Enum value)
	{
		BelowLISPostTradeDeferral = value;
	}
	public TI_POST_TRADE_DEFERRAL_Enum getAtAboveLISPostTradeDeferral()
	{
		return AtAboveLISPostTradeDeferral;
	}
	public void setAtAboveLISPostTradeDeferral(TI_POST_TRADE_DEFERRAL_Enum value)
	{
		AtAboveLISPostTradeDeferral = value;
	}
	public TI_POST_TRADE_DEFERRAL_Enum getATBelowLIS1PostTradeDeferral()
	{
		return ATBelowLIS1PostTradeDeferral;
	}
	public void setATBelowLIS1PostTradeDeferral(TI_POST_TRADE_DEFERRAL_Enum value)
	{
		ATBelowLIS1PostTradeDeferral = value;
	}
	public TI_POST_TRADE_DEFERRAL_Enum getAtAboveLIS1PostTradeDeferral()
	{
		return AtAboveLIS1PostTradeDeferral;
	}
	public void setAtAboveLIS1PostTradeDeferral(TI_POST_TRADE_DEFERRAL_Enum value)
	{
		AtAboveLIS1PostTradeDeferral = value;
	}
	public TI_POST_TRADE_DEFERRAL_Enum getAtAboveLIS2PostTradeDeferral()
	{
		return AtAboveLIS2PostTradeDeferral;
	}
	public void setAtAboveLIS2PostTradeDeferral(TI_POST_TRADE_DEFERRAL_Enum value)
	{
		AtAboveLIS2PostTradeDeferral = value;
	}
	public TI_POST_TRADE_DEFERRAL_Enum getAtAboveLIS3PostTradeDeferral()
	{
		return AtAboveLIS3PostTradeDeferral;
	}
	public void setAtAboveLIS3PostTradeDeferral(TI_POST_TRADE_DEFERRAL_Enum value)
	{
		AtAboveLIS3PostTradeDeferral = value;
	}
	public TI_POST_TRADE_DEFERRAL_Enum getNoLISPostTradeDeferral()
	{
		return NoLISPostTradeDeferral;
	}
	public void setNoLISPostTradeDeferral(TI_POST_TRADE_DEFERRAL_Enum value)
	{
		NoLISPostTradeDeferral = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		InstrumentId = (long)byteBuffer.readInt();
		FinancialInstrumentId = (long)byteBuffer.readInt();
		AreaCodeId = (short)byteBuffer.readInt();
		LiquidFg = LiquidFg.getEnum(byteBuffer.readInt());
		MMIFg = MMIFg.getEnum(byteBuffer.readInt());
		ECBFxRate = byteBuffer.readDouble();
		SSTIPreTradeQty = byteBuffer.readDouble();
		SSTIPostTradeQty = byteBuffer.readDouble();
		LISPreTradeQty = byteBuffer.readDouble();
		LISPostTradeQty = byteBuffer.readDouble();
		LISCategory = (short)byteBuffer.readInt();
		RatingCategory = byteBuffer.readString();
		CreditRating = byteBuffer.readString();
		ESMAGroupId = (short)byteBuffer.readInt();
		GroupId = (short)byteBuffer.readInt();
		LISCurrency = byteBuffer.readString();
		LIS.readXDR(byteBuffer);
		LIS1.readXDR(byteBuffer);
		LIS2.readXDR(byteBuffer);
		LIS3.readXDR(byteBuffer);
		LIS4.readXDR(byteBuffer);
		LIS5.readXDR(byteBuffer);
		LIS6.readXDR(byteBuffer);
		LIS7.readXDR(byteBuffer);
		LIS8.readXDR(byteBuffer);
		LIS9.readXDR(byteBuffer);
		LIS10.readXDR(byteBuffer);
		BelowLISPostTradeDeferral = BelowLISPostTradeDeferral.getEnum(byteBuffer.readInt());
		AtAboveLISPostTradeDeferral = AtAboveLISPostTradeDeferral.getEnum(byteBuffer.readInt());
		ATBelowLIS1PostTradeDeferral = ATBelowLIS1PostTradeDeferral.getEnum(byteBuffer.readInt());
		AtAboveLIS1PostTradeDeferral = AtAboveLIS1PostTradeDeferral.getEnum(byteBuffer.readInt());
		AtAboveLIS2PostTradeDeferral = AtAboveLIS2PostTradeDeferral.getEnum(byteBuffer.readInt());
		AtAboveLIS3PostTradeDeferral = AtAboveLIS3PostTradeDeferral.getEnum(byteBuffer.readInt());
		NoLISPostTradeDeferral = NoLISPostTradeDeferral.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(InstrumentId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(FinancialInstrumentId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(AreaCodeId & 0xFFFFL));
		byteBuffer.writeInt(LiquidFg.getValue());
		byteBuffer.writeInt(MMIFg.getValue());
		byteBuffer.writeDouble(ECBFxRate);
		byteBuffer.writeDouble(SSTIPreTradeQty);
		byteBuffer.writeDouble(SSTIPostTradeQty);
		byteBuffer.writeDouble(LISPreTradeQty);
		byteBuffer.writeDouble(LISPostTradeQty);
		byteBuffer.writeInt((int)(LISCategory & 0xFFFFL));
		byteBuffer.writeString(RatingCategory);
		byteBuffer.writeString(CreditRating);
		byteBuffer.writeInt((int)(ESMAGroupId & 0xFFFFL));
		byteBuffer.writeInt((int)(GroupId & 0xFFFFL));
		byteBuffer.writeString(LISCurrency);
		LIS.writeXDR(byteBuffer);
		LIS1.writeXDR(byteBuffer);
		LIS2.writeXDR(byteBuffer);
		LIS3.writeXDR(byteBuffer);
		LIS4.writeXDR(byteBuffer);
		LIS5.writeXDR(byteBuffer);
		LIS6.writeXDR(byteBuffer);
		LIS7.writeXDR(byteBuffer);
		LIS8.writeXDR(byteBuffer);
		LIS9.writeXDR(byteBuffer);
		LIS10.writeXDR(byteBuffer);
		byteBuffer.writeInt(BelowLISPostTradeDeferral.getValue());
		byteBuffer.writeInt(AtAboveLISPostTradeDeferral.getValue());
		byteBuffer.writeInt(ATBelowLIS1PostTradeDeferral.getValue());
		byteBuffer.writeInt(AtAboveLIS1PostTradeDeferral.getValue());
		byteBuffer.writeInt(AtAboveLIS2PostTradeDeferral.getValue());
		byteBuffer.writeInt(AtAboveLIS3PostTradeDeferral.getValue());
		byteBuffer.writeInt(NoLISPostTradeDeferral.getValue());

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
		stringBuilder.append("BV_LIQUID_INSTRUMENT_THRESHOLDS::");
		stringBuilder.append("InstrumentId(").append(InstrumentId).append(")");
		stringBuilder.append("FinancialInstrumentId(").append(FinancialInstrumentId).append(")");
		stringBuilder.append("AreaCodeId(").append(AreaCodeId).append(")");
		stringBuilder.append("LiquidFg(").append(LiquidFg).append(")");
		stringBuilder.append("MMIFg(").append(MMIFg).append(")");
		stringBuilder.append("ECBFxRate(").append(ECBFxRate).append(")");
		stringBuilder.append("SSTIPreTradeQty(").append(SSTIPreTradeQty).append(")");
		stringBuilder.append("SSTIPostTradeQty(").append(SSTIPostTradeQty).append(")");
		stringBuilder.append("LISPreTradeQty(").append(LISPreTradeQty).append(")");
		stringBuilder.append("LISPostTradeQty(").append(LISPostTradeQty).append(")");
		stringBuilder.append("LISCategory(").append(LISCategory).append(")");
		stringBuilder.append("RatingCategory(").append(RatingCategory).append(")");
		stringBuilder.append("CreditRating(").append(CreditRating).append(")");
		stringBuilder.append("ESMAGroupId(").append(ESMAGroupId).append(")");
		stringBuilder.append("GroupId(").append(GroupId).append(")");
		stringBuilder.append("LISCurrency(").append(LISCurrency).append(")");
		stringBuilder.append("LIS(").append(LIS.toString()).append(")");
		stringBuilder.append("LIS1(").append(LIS1.toString()).append(")");
		stringBuilder.append("LIS2(").append(LIS2.toString()).append(")");
		stringBuilder.append("LIS3(").append(LIS3.toString()).append(")");
		stringBuilder.append("LIS4(").append(LIS4.toString()).append(")");
		stringBuilder.append("LIS5(").append(LIS5.toString()).append(")");
		stringBuilder.append("LIS6(").append(LIS6.toString()).append(")");
		stringBuilder.append("LIS7(").append(LIS7.toString()).append(")");
		stringBuilder.append("LIS8(").append(LIS8.toString()).append(")");
		stringBuilder.append("LIS9(").append(LIS9.toString()).append(")");
		stringBuilder.append("LIS10(").append(LIS10.toString()).append(")");
		stringBuilder.append("BelowLISPostTradeDeferral(").append(BelowLISPostTradeDeferral).append(")");
		stringBuilder.append("AtAboveLISPostTradeDeferral(").append(AtAboveLISPostTradeDeferral).append(")");
		stringBuilder.append("ATBelowLIS1PostTradeDeferral(").append(ATBelowLIS1PostTradeDeferral).append(")");
		stringBuilder.append("AtAboveLIS1PostTradeDeferral(").append(AtAboveLIS1PostTradeDeferral).append(")");
		stringBuilder.append("AtAboveLIS2PostTradeDeferral(").append(AtAboveLIS2PostTradeDeferral).append(")");
		stringBuilder.append("AtAboveLIS3PostTradeDeferral(").append(AtAboveLIS3PostTradeDeferral).append(")");
		stringBuilder.append("NoLISPostTradeDeferral(").append(NoLISPostTradeDeferral).append(")");
		return stringBuilder.toString();
	}
}
