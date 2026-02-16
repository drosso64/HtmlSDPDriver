package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_RFCQ_LEG extends SMPMessage
{
	public static final long CLASS_ID = 114942;

	private long SectionId = 0;
	private BV_INSTRUMENT_INFO Instrument = new BV_INSTRUMENT_INFO();
	private TI_VERB_Enum Verb = TI_VERB_Enum.TI_VERB_Buy;
	private double Quantity = 0;
	private double MinQty = 0;
	private short SettlementOffset = 0;
	private long SettlementDate = 0;
	private long AccountId = 0;
	private short MarketAffiliation = 0;
	private String SettlementInfo = "";
	private TI_FLAG_Enum QuotationFg = TI_FLAG_Enum.TI_FLAG_No;
	private double Quotation = 0;

	public BV_RFCQ_LEG()
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
	public TI_VERB_Enum getVerb()
	{
		return Verb;
	}
	public void setVerb(TI_VERB_Enum value)
	{
		Verb = value;
	}
	public double getQuantity()
	{
		return Quantity;
	}
	public void setQuantity(double value)
	{
		Quantity = value;
	}
	public double getMinQty()
	{
		return MinQty;
	}
	public void setMinQty(double value)
	{
		MinQty = value;
	}
	public short getSettlementOffset()
	{
		return SettlementOffset;
	}
	public void setSettlementOffset(short value)
	{
		SettlementOffset = value;
	}
	public long getSettlementDate()
	{
		return SettlementDate;
	}
	public void setSettlementDate(long value)
	{
		SettlementDate = value;
	}
	public long getAccountId()
	{
		return AccountId;
	}
	public void setAccountId(long value)
	{
		AccountId = value;
	}
	public short getMarketAffiliation()
	{
		return MarketAffiliation;
	}
	public void setMarketAffiliation(short value)
	{
		MarketAffiliation = value;
	}
	public String getSettlementInfo()
	{
		return SettlementInfo;
	}
	public void setSettlementInfo(String value)
	{
		SettlementInfo = value;
	}
	public TI_FLAG_Enum getQuotationFg()
	{
		return QuotationFg;
	}
	public void setQuotationFg(TI_FLAG_Enum value)
	{
		QuotationFg = value;
	}
	public double getQuotation()
	{
		return Quotation;
	}
	public void setQuotation(double value)
	{
		Quotation = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		SectionId = (long)byteBuffer.readInt();
		Instrument.readXDR(byteBuffer);
		Verb = Verb.getEnum(byteBuffer.readInt());
		Quantity = byteBuffer.readDouble();
		MinQty = byteBuffer.readDouble();
		SettlementOffset = (short)byteBuffer.readInt();
		SettlementDate = (long)byteBuffer.readInt();
		AccountId = (long)byteBuffer.readInt();
		MarketAffiliation = (short)byteBuffer.readInt();
		SettlementInfo = byteBuffer.readString();
		QuotationFg = QuotationFg.getEnum(byteBuffer.readInt());
		Quotation = byteBuffer.readDouble();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(SectionId & 0xFFFFFFFFL));
		Instrument.writeXDR(byteBuffer);
		byteBuffer.writeInt(Verb.getValue());
		byteBuffer.writeDouble(Quantity);
		byteBuffer.writeDouble(MinQty);
		byteBuffer.writeInt((int)(SettlementOffset & 0xFFFFL));
		byteBuffer.writeInt((int)(SettlementDate & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(AccountId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(MarketAffiliation & 0xFFFFL));
		byteBuffer.writeString(SettlementInfo);
		byteBuffer.writeInt(QuotationFg.getValue());
		byteBuffer.writeDouble(Quotation);

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
		stringBuilder.append("BV_RFCQ_LEG::");
		stringBuilder.append("SectionId(").append(SectionId).append(")");
		stringBuilder.append("Instrument(").append(Instrument.toString()).append(")");
		stringBuilder.append("Verb(").append(Verb).append(")");
		stringBuilder.append("Quantity(").append(Quantity).append(")");
		stringBuilder.append("MinQty(").append(MinQty).append(")");
		stringBuilder.append("SettlementOffset(").append(SettlementOffset).append(")");
		stringBuilder.append("SettlementDate(").append(SettlementDate).append(")");
		stringBuilder.append("AccountId(").append(AccountId).append(")");
		stringBuilder.append("MarketAffiliation(").append(MarketAffiliation).append(")");
		stringBuilder.append("SettlementInfo(").append(SettlementInfo).append(")");
		stringBuilder.append("QuotationFg(").append(QuotationFg).append(")");
		stringBuilder.append("Quotation(").append(Quotation).append(")");
		return stringBuilder.toString();
	}
}
