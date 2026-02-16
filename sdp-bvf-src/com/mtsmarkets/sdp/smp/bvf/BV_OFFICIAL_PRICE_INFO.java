package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_OFFICIAL_PRICE_INFO extends SMPMessage
{
	public static final long CLASS_ID = 114907;

	private long SectionId = 0;
	private long InstrumentClassId = 0;
	private long FinancialInstrumentId = 0;
	private TI_INSTRUMENT_TYPE_Enum InstrumentType = TI_INSTRUMENT_TYPE_Enum.TI_INSTRUMENT_TYPE_Bond;

	public BV_OFFICIAL_PRICE_INFO()
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
	public long getInstrumentClassId()
	{
		return InstrumentClassId;
	}
	public void setInstrumentClassId(long value)
	{
		InstrumentClassId = value;
	}
	public long getFinancialInstrumentId()
	{
		return FinancialInstrumentId;
	}
	public void setFinancialInstrumentId(long value)
	{
		FinancialInstrumentId = value;
	}
	public TI_INSTRUMENT_TYPE_Enum getInstrumentType()
	{
		return InstrumentType;
	}
	public void setInstrumentType(TI_INSTRUMENT_TYPE_Enum value)
	{
		InstrumentType = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		SectionId = (long)byteBuffer.readInt();
		InstrumentClassId = (long)byteBuffer.readInt();
		FinancialInstrumentId = (long)byteBuffer.readInt();
		InstrumentType = InstrumentType.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(SectionId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(InstrumentClassId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(FinancialInstrumentId & 0xFFFFFFFFL));
		byteBuffer.writeInt(InstrumentType.getValue());

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
		stringBuilder.append("BV_OFFICIAL_PRICE_INFO::");
		stringBuilder.append("SectionId(").append(SectionId).append(")");
		stringBuilder.append("InstrumentClassId(").append(InstrumentClassId).append(")");
		stringBuilder.append("FinancialInstrumentId(").append(FinancialInstrumentId).append(")");
		stringBuilder.append("InstrumentType(").append(InstrumentType).append(")");
		return stringBuilder.toString();
	}
}
