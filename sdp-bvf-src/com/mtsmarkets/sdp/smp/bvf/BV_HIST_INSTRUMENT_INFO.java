package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_HIST_INSTRUMENT_INFO extends SMPMessage
{
	public static final long CLASS_ID = 114957;

	private String SectionCode = "";
	private String SectionDesc = "";
	private String InstrumentCode = "";
	private String InstrumentDesc = "";
	private TI_INSTRUMENT_TYPE_Enum InstrumentType = TI_INSTRUMENT_TYPE_Enum.TI_INSTRUMENT_TYPE_Bond;
	private String FinancialInstrumentCode = "";
	private String FinancialInstrumentDesc = "";
	private String InstrumentClassCode = "";
	private String InstrumentClassDesc = "";

	public BV_HIST_INSTRUMENT_INFO()
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
	public String getSectionDesc()
	{
		return SectionDesc;
	}
	public void setSectionDesc(String value)
	{
		SectionDesc = value;
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
	public TI_INSTRUMENT_TYPE_Enum getInstrumentType()
	{
		return InstrumentType;
	}
	public void setInstrumentType(TI_INSTRUMENT_TYPE_Enum value)
	{
		InstrumentType = value;
	}
	public String getFinancialInstrumentCode()
	{
		return FinancialInstrumentCode;
	}
	public void setFinancialInstrumentCode(String value)
	{
		FinancialInstrumentCode = value;
	}
	public String getFinancialInstrumentDesc()
	{
		return FinancialInstrumentDesc;
	}
	public void setFinancialInstrumentDesc(String value)
	{
		FinancialInstrumentDesc = value;
	}
	public String getInstrumentClassCode()
	{
		return InstrumentClassCode;
	}
	public void setInstrumentClassCode(String value)
	{
		InstrumentClassCode = value;
	}
	public String getInstrumentClassDesc()
	{
		return InstrumentClassDesc;
	}
	public void setInstrumentClassDesc(String value)
	{
		InstrumentClassDesc = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		SectionCode = byteBuffer.readString();
		SectionDesc = byteBuffer.readString();
		InstrumentCode = byteBuffer.readString();
		InstrumentDesc = byteBuffer.readString();
		InstrumentType = InstrumentType.getEnum(byteBuffer.readInt());
		FinancialInstrumentCode = byteBuffer.readString();
		FinancialInstrumentDesc = byteBuffer.readString();
		InstrumentClassCode = byteBuffer.readString();
		InstrumentClassDesc = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeString(SectionCode);
		byteBuffer.writeString(SectionDesc);
		byteBuffer.writeString(InstrumentCode);
		byteBuffer.writeString(InstrumentDesc);
		byteBuffer.writeInt(InstrumentType.getValue());
		byteBuffer.writeString(FinancialInstrumentCode);
		byteBuffer.writeString(FinancialInstrumentDesc);
		byteBuffer.writeString(InstrumentClassCode);
		byteBuffer.writeString(InstrumentClassDesc);

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
		stringBuilder.append("BV_HIST_INSTRUMENT_INFO::");
		stringBuilder.append("SectionCode(").append(SectionCode).append(")");
		stringBuilder.append("SectionDesc(").append(SectionDesc).append(")");
		stringBuilder.append("InstrumentCode(").append(InstrumentCode).append(")");
		stringBuilder.append("InstrumentDesc(").append(InstrumentDesc).append(")");
		stringBuilder.append("InstrumentType(").append(InstrumentType).append(")");
		stringBuilder.append("FinancialInstrumentCode(").append(FinancialInstrumentCode).append(")");
		stringBuilder.append("FinancialInstrumentDesc(").append(FinancialInstrumentDesc).append(")");
		stringBuilder.append("InstrumentClassCode(").append(InstrumentClassCode).append(")");
		stringBuilder.append("InstrumentClassDesc(").append(InstrumentClassDesc).append(")");
		return stringBuilder.toString();
	}
}
