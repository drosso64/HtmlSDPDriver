package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_ALLOCATION_REPORT_INSTRUMENT_INFO extends SMPMessage
{
	public static final long CLASS_ID = 410002;

	private long InstrumentId = 0;
	private String InstrumentCode = "";
	private String InstrumentDesc = "";
	private TI_INSTRUMENT_TYPE_Enum InstrumentType = TI_INSTRUMENT_TYPE_Enum.TI_INSTRUMENT_TYPE_Bond;
	private long FinancialInstrumentId = 0;
	private String FinancialInstrumentCode = "";
	private String FinancialInstrumentDesc = "";

	public BV_ALLOCATION_REPORT_INSTRUMENT_INFO()
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
	public long getFinancialInstrumentId()
	{
		return FinancialInstrumentId;
	}
	public void setFinancialInstrumentId(long value)
	{
		FinancialInstrumentId = value;
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

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		InstrumentId = (long)byteBuffer.readInt();
		InstrumentCode = byteBuffer.readString();
		InstrumentDesc = byteBuffer.readString();
		InstrumentType = InstrumentType.getEnum(byteBuffer.readInt());
		FinancialInstrumentId = (long)byteBuffer.readInt();
		FinancialInstrumentCode = byteBuffer.readString();
		FinancialInstrumentDesc = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(InstrumentId & 0xFFFFFFFFL));
		byteBuffer.writeString(InstrumentCode);
		byteBuffer.writeString(InstrumentDesc);
		byteBuffer.writeInt(InstrumentType.getValue());
		byteBuffer.writeInt((int)(FinancialInstrumentId & 0xFFFFFFFFL));
		byteBuffer.writeString(FinancialInstrumentCode);
		byteBuffer.writeString(FinancialInstrumentDesc);

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
		stringBuilder.append("BV_ALLOCATION_REPORT_INSTRUMENT_INFO::");
		stringBuilder.append("InstrumentId(").append(InstrumentId).append(")");
		stringBuilder.append("InstrumentCode(").append(InstrumentCode).append(")");
		stringBuilder.append("InstrumentDesc(").append(InstrumentDesc).append(")");
		stringBuilder.append("InstrumentType(").append(InstrumentType).append(")");
		stringBuilder.append("FinancialInstrumentId(").append(FinancialInstrumentId).append(")");
		stringBuilder.append("FinancialInstrumentCode(").append(FinancialInstrumentCode).append(")");
		stringBuilder.append("FinancialInstrumentDesc(").append(FinancialInstrumentDesc).append(")");
		return stringBuilder.toString();
	}
}
