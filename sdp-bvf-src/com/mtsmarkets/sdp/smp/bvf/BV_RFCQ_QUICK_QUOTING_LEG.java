package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_RFCQ_QUICK_QUOTING_LEG extends SMPMessage
{
	public static final long CLASS_ID = 114944;

	private long SectionId = 0;
	private BV_INSTRUMENT_INFO Instrument = new BV_INSTRUMENT_INFO();
	private double Quotation = 0;
	private BV_SHORT_SELLING_INDICATOR_Enum ShortSellingIndicator = BV_SHORT_SELLING_INDICATOR_Enum.BV_SHORT_SELLING_INDICATOR_None;

	public BV_RFCQ_QUICK_QUOTING_LEG()
	{
	}

	public long getSectionId()
	{
		return SectionId;
	}
	public void setSectionId(long value)
	{
		SectionId = value;
	}
	public BV_INSTRUMENT_INFO getInstrument()
	{
		return Instrument;
	}
	public void setInstrument(BV_INSTRUMENT_INFO value)
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
		SectionId = (long)byteBuffer.readInt();
		Instrument.readXDR(byteBuffer);
		Quotation = byteBuffer.readDouble();
		ShortSellingIndicator = ShortSellingIndicator.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(SectionId & 0xFFFFFFFFL));
		Instrument.writeXDR(byteBuffer);
		byteBuffer.writeDouble(Quotation);
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
		stringBuilder.append("BV_RFCQ_QUICK_QUOTING_LEG::");
		stringBuilder.append("SectionId(").append(SectionId).append(")");
		stringBuilder.append("Instrument(").append(Instrument.toString()).append(")");
		stringBuilder.append("Quotation(").append(Quotation).append(")");
		stringBuilder.append("ShortSellingIndicator(").append(ShortSellingIndicator).append(")");
		return stringBuilder.toString();
	}
}
