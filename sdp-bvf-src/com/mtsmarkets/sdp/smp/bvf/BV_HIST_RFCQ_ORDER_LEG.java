package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_HIST_RFCQ_ORDER_LEG extends SMPMessage
{
	public static final long CLASS_ID = 114941;

	private String SectionCode = "";
	private BV_HIST_INSTRUMENT_INFO Instrument = new BV_HIST_INSTRUMENT_INFO();
	private double Quotation = 0;
	private TI_FLAG_Enum UseIoIFg = TI_FLAG_Enum.TI_FLAG_No;
	private BV_BEST_TRADING_INFO BVBestBid = new BV_BEST_TRADING_INFO();
	private BV_BEST_TRADING_INFO BVBestAsk = new BV_BEST_TRADING_INFO();
	private double BVBestMidPrice = 0;
	private double BVBestMidYield = 0;
	private BV_VALUE BVBestMidYTC = new BV_VALUE();
	private BV_VALUE BVBestMidYTW = new BV_VALUE();
	private BV_VALUE BvBestMidYMWTh = new BV_VALUE();
	private double BvBestMidMWCPriceTh = 0;
	private BV_VALUE BvBestMidYMWExrc = new BV_VALUE();
	private BV_VALUE BvBestMidYTR = new BV_VALUE();
	private BV_ANALYTICS BvBestMidAnalytics = new BV_ANALYTICS();
	private TI_FLAG_Enum BVBestMidValidityFg = TI_FLAG_Enum.TI_FLAG_No;
	private String BenchmarkISINCode = "";
	private String BenchmarkDescription = "";
	private double BenchmarkPrice = 0;
	private double BenchmarkYield = 0;
	private double BenchmarkSpreadValue = 0;

	public BV_HIST_RFCQ_ORDER_LEG()
	{
	}

	public String getSectionCode()
	{
		return SectionCode;
	}
	public void setSectionCode(String value)
	{
		SectionCode = value;
	}
	public BV_HIST_INSTRUMENT_INFO getInstrument()
	{
		return Instrument;
	}
	public void setInstrument(BV_HIST_INSTRUMENT_INFO value)
	{
		Instrument = value;
	}
	public double getQuotation()
	{
		return Quotation;
	}
	public void setQuotation(double value)
	{
		Quotation = value;
	}
	public TI_FLAG_Enum getUseIoIFg()
	{
		return UseIoIFg;
	}
	public void setUseIoIFg(TI_FLAG_Enum value)
	{
		UseIoIFg = value;
	}
	public BV_BEST_TRADING_INFO getBVBestBid()
	{
		return BVBestBid;
	}
	public void setBVBestBid(BV_BEST_TRADING_INFO value)
	{
		BVBestBid = value;
	}
	public BV_BEST_TRADING_INFO getBVBestAsk()
	{
		return BVBestAsk;
	}
	public void setBVBestAsk(BV_BEST_TRADING_INFO value)
	{
		BVBestAsk = value;
	}
	public double getBVBestMidPrice()
	{
		return BVBestMidPrice;
	}
	public void setBVBestMidPrice(double value)
	{
		BVBestMidPrice = value;
	}
	public double getBVBestMidYield()
	{
		return BVBestMidYield;
	}
	public void setBVBestMidYield(double value)
	{
		BVBestMidYield = value;
	}
	public BV_VALUE getBVBestMidYTC()
	{
		return BVBestMidYTC;
	}
	public void setBVBestMidYTC(BV_VALUE value)
	{
		BVBestMidYTC = value;
	}
	public BV_VALUE getBVBestMidYTW()
	{
		return BVBestMidYTW;
	}
	public void setBVBestMidYTW(BV_VALUE value)
	{
		BVBestMidYTW = value;
	}
	public BV_VALUE getBvBestMidYMWTh()
	{
		return BvBestMidYMWTh;
	}
	public void setBvBestMidYMWTh(BV_VALUE value)
	{
		BvBestMidYMWTh = value;
	}
	public double getBvBestMidMWCPriceTh()
	{
		return BvBestMidMWCPriceTh;
	}
	public void setBvBestMidMWCPriceTh(double value)
	{
		BvBestMidMWCPriceTh = value;
	}
	public BV_VALUE getBvBestMidYMWExrc()
	{
		return BvBestMidYMWExrc;
	}
	public void setBvBestMidYMWExrc(BV_VALUE value)
	{
		BvBestMidYMWExrc = value;
	}
	public BV_VALUE getBvBestMidYTR()
	{
		return BvBestMidYTR;
	}
	public void setBvBestMidYTR(BV_VALUE value)
	{
		BvBestMidYTR = value;
	}
	public BV_ANALYTICS getBvBestMidAnalytics()
	{
		return BvBestMidAnalytics;
	}
	public void setBvBestMidAnalytics(BV_ANALYTICS value)
	{
		BvBestMidAnalytics = value;
	}
	public TI_FLAG_Enum getBVBestMidValidityFg()
	{
		return BVBestMidValidityFg;
	}
	public void setBVBestMidValidityFg(TI_FLAG_Enum value)
	{
		BVBestMidValidityFg = value;
	}
	public String getBenchmarkISINCode()
	{
		return BenchmarkISINCode;
	}
	public void setBenchmarkISINCode(String value)
	{
		BenchmarkISINCode = value;
	}
	public String getBenchmarkDescription()
	{
		return BenchmarkDescription;
	}
	public void setBenchmarkDescription(String value)
	{
		BenchmarkDescription = value;
	}
	public double getBenchmarkPrice()
	{
		return BenchmarkPrice;
	}
	public void setBenchmarkPrice(double value)
	{
		BenchmarkPrice = value;
	}
	public double getBenchmarkYield()
	{
		return BenchmarkYield;
	}
	public void setBenchmarkYield(double value)
	{
		BenchmarkYield = value;
	}
	public double getBenchmarkSpreadValue()
	{
		return BenchmarkSpreadValue;
	}
	public void setBenchmarkSpreadValue(double value)
	{
		BenchmarkSpreadValue = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		SectionCode = byteBuffer.readString();
		Instrument.readXDR(byteBuffer);
		Quotation = byteBuffer.readDouble();
		UseIoIFg = UseIoIFg.getEnum(byteBuffer.readInt());
		BVBestBid.readXDR(byteBuffer);
		BVBestAsk.readXDR(byteBuffer);
		BVBestMidPrice = byteBuffer.readDouble();
		BVBestMidYield = byteBuffer.readDouble();
		BVBestMidYTC.readXDR(byteBuffer);
		BVBestMidYTW.readXDR(byteBuffer);
		BvBestMidYMWTh.readXDR(byteBuffer);
		BvBestMidMWCPriceTh = byteBuffer.readDouble();
		BvBestMidYMWExrc.readXDR(byteBuffer);
		BvBestMidYTR.readXDR(byteBuffer);
		BvBestMidAnalytics.readXDR(byteBuffer);
		BVBestMidValidityFg = BVBestMidValidityFg.getEnum(byteBuffer.readInt());
		BenchmarkISINCode = byteBuffer.readString();
		BenchmarkDescription = byteBuffer.readString();
		BenchmarkPrice = byteBuffer.readDouble();
		BenchmarkYield = byteBuffer.readDouble();
		BenchmarkSpreadValue = byteBuffer.readDouble();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeString(SectionCode);
		Instrument.writeXDR(byteBuffer);
		byteBuffer.writeDouble(Quotation);
		byteBuffer.writeInt(UseIoIFg.getValue());
		BVBestBid.writeXDR(byteBuffer);
		BVBestAsk.writeXDR(byteBuffer);
		byteBuffer.writeDouble(BVBestMidPrice);
		byteBuffer.writeDouble(BVBestMidYield);
		BVBestMidYTC.writeXDR(byteBuffer);
		BVBestMidYTW.writeXDR(byteBuffer);
		BvBestMidYMWTh.writeXDR(byteBuffer);
		byteBuffer.writeDouble(BvBestMidMWCPriceTh);
		BvBestMidYMWExrc.writeXDR(byteBuffer);
		BvBestMidYTR.writeXDR(byteBuffer);
		BvBestMidAnalytics.writeXDR(byteBuffer);
		byteBuffer.writeInt(BVBestMidValidityFg.getValue());
		byteBuffer.writeString(BenchmarkISINCode);
		byteBuffer.writeString(BenchmarkDescription);
		byteBuffer.writeDouble(BenchmarkPrice);
		byteBuffer.writeDouble(BenchmarkYield);
		byteBuffer.writeDouble(BenchmarkSpreadValue);

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
		stringBuilder.append("BV_HIST_RFCQ_ORDER_LEG::");
		stringBuilder.append("SectionCode(").append(SectionCode).append(")");
		stringBuilder.append("Instrument(").append(Instrument.toString()).append(")");
		stringBuilder.append("Quotation(").append(Quotation).append(")");
		stringBuilder.append("UseIoIFg(").append(UseIoIFg).append(")");
		stringBuilder.append("BVBestBid(").append(BVBestBid.toString()).append(")");
		stringBuilder.append("BVBestAsk(").append(BVBestAsk.toString()).append(")");
		stringBuilder.append("BVBestMidPrice(").append(BVBestMidPrice).append(")");
		stringBuilder.append("BVBestMidYield(").append(BVBestMidYield).append(")");
		stringBuilder.append("BVBestMidYTC(").append(BVBestMidYTC.toString()).append(")");
		stringBuilder.append("BVBestMidYTW(").append(BVBestMidYTW.toString()).append(")");
		stringBuilder.append("BvBestMidYMWTh(").append(BvBestMidYMWTh.toString()).append(")");
		stringBuilder.append("BvBestMidMWCPriceTh(").append(BvBestMidMWCPriceTh).append(")");
		stringBuilder.append("BvBestMidYMWExrc(").append(BvBestMidYMWExrc.toString()).append(")");
		stringBuilder.append("BvBestMidYTR(").append(BvBestMidYTR.toString()).append(")");
		stringBuilder.append("BvBestMidAnalytics(").append(BvBestMidAnalytics.toString()).append(")");
		stringBuilder.append("BVBestMidValidityFg(").append(BVBestMidValidityFg).append(")");
		stringBuilder.append("BenchmarkISINCode(").append(BenchmarkISINCode).append(")");
		stringBuilder.append("BenchmarkDescription(").append(BenchmarkDescription).append(")");
		stringBuilder.append("BenchmarkPrice(").append(BenchmarkPrice).append(")");
		stringBuilder.append("BenchmarkYield(").append(BenchmarkYield).append(")");
		stringBuilder.append("BenchmarkSpreadValue(").append(BenchmarkSpreadValue).append(")");
		return stringBuilder.toString();
	}
}
