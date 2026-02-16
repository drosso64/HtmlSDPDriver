package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_HIST_PORTFOLIO_RFCQ_QUOTING_LEG extends SMPMessage
{
	public static final long CLASS_ID = 410019;

	private short LegId = 0;
	private BV_HIST_INSTRUMENT_INFO Instrument = new BV_HIST_INSTRUMENT_INFO();
	private double Quotation = 0;
	private double CalculatedQuotation = 0;
	private double Quantity = 0;
	private BV_SHORT_SELLING_INDICATOR_Enum ShortSellingIndicator = BV_SHORT_SELLING_INDICATOR_Enum.BV_SHORT_SELLING_INDICATOR_None;

	public BV_HIST_PORTFOLIO_RFCQ_QUOTING_LEG()
	{
	}

	public short getLegId()
	{
		return LegId;
	}
	public void setLegId(short value)
	{
		LegId = value;
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
		LegId = (short)byteBuffer.readInt();
		Instrument.readXDR(byteBuffer);
		Quotation = byteBuffer.readDouble();
		CalculatedQuotation = byteBuffer.readDouble();
		Quantity = byteBuffer.readDouble();
		ShortSellingIndicator = ShortSellingIndicator.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(LegId & 0xFFFFL));
		Instrument.writeXDR(byteBuffer);
		byteBuffer.writeDouble(Quotation);
		byteBuffer.writeDouble(CalculatedQuotation);
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
		stringBuilder.append("BV_HIST_PORTFOLIO_RFCQ_QUOTING_LEG::");
		stringBuilder.append("LegId(").append(LegId).append(")");
		stringBuilder.append("Instrument(").append(Instrument.toString()).append(")");
		stringBuilder.append("Quotation(").append(Quotation).append(")");
		stringBuilder.append("CalculatedQuotation(").append(CalculatedQuotation).append(")");
		stringBuilder.append("Quantity(").append(Quantity).append(")");
		stringBuilder.append("ShortSellingIndicator(").append(ShortSellingIndicator).append(")");
		return stringBuilder.toString();
	}
}
