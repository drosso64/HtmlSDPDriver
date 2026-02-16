package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_HIST_RFCQ_QUOTING_LEG extends SMPMessage
{
	public static final long CLASS_ID = 114940;

	private String SectionCode = "";
	private BV_HIST_INSTRUMENT_INFO Instrument = new BV_HIST_INSTRUMENT_INFO();
	private double Quotation = 0;
	private double CalculatedQuotation = 0;
	private TI_FLAG_Enum AdjustedFg = TI_FLAG_Enum.TI_FLAG_No;
	private double Quantity = 0;
	private BV_SHORT_SELLING_INDICATOR_Enum ShortSellingIndicator = BV_SHORT_SELLING_INDICATOR_Enum.BV_SHORT_SELLING_INDICATOR_None;

	public BV_HIST_RFCQ_QUOTING_LEG()
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
	public double getCalculatedQuotation()
	{
		return CalculatedQuotation;
	}
	public void setCalculatedQuotation(double value)
	{
		CalculatedQuotation = value;
	}
	public TI_FLAG_Enum getAdjustedFg()
	{
		return AdjustedFg;
	}
	public void setAdjustedFg(TI_FLAG_Enum value)
	{
		AdjustedFg = value;
	}
	public double getQuantity()
	{
		return Quantity;
	}
	public void setQuantity(double value)
	{
		Quantity = value;
	}
	public BV_SHORT_SELLING_INDICATOR_Enum getShortSellingIndicator()
	{
		return ShortSellingIndicator;
	}
	public void setShortSellingIndicator(BV_SHORT_SELLING_INDICATOR_Enum value)
	{
		ShortSellingIndicator = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		SectionCode = byteBuffer.readString();
		Instrument.readXDR(byteBuffer);
		Quotation = byteBuffer.readDouble();
		CalculatedQuotation = byteBuffer.readDouble();
		AdjustedFg = AdjustedFg.getEnum(byteBuffer.readInt());
		Quantity = byteBuffer.readDouble();
		ShortSellingIndicator = ShortSellingIndicator.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeString(SectionCode);
		Instrument.writeXDR(byteBuffer);
		byteBuffer.writeDouble(Quotation);
		byteBuffer.writeDouble(CalculatedQuotation);
		byteBuffer.writeInt(AdjustedFg.getValue());
		byteBuffer.writeDouble(Quantity);
		byteBuffer.writeInt(ShortSellingIndicator.getValue());

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
		stringBuilder.append("BV_HIST_RFCQ_QUOTING_LEG::");
		stringBuilder.append("SectionCode(").append(SectionCode).append(")");
		stringBuilder.append("Instrument(").append(Instrument.toString()).append(")");
		stringBuilder.append("Quotation(").append(Quotation).append(")");
		stringBuilder.append("CalculatedQuotation(").append(CalculatedQuotation).append(")");
		stringBuilder.append("AdjustedFg(").append(AdjustedFg).append(")");
		stringBuilder.append("Quantity(").append(Quantity).append(")");
		stringBuilder.append("ShortSellingIndicator(").append(ShortSellingIndicator).append(")");
		return stringBuilder.toString();
	}
}
