package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_INSTRUMENT_ALT_CODE extends SMPMessage
{
	public static final long CLASS_ID = 100228;

	private long FinancialInstrumentId = 0;
	private TI_ALTERNATIVE_CODE_TYPE_Enum AlternativeCodeType = TI_ALTERNATIVE_CODE_TYPE_Enum.TI_ALTERNATIVE_CODE_TYPE_BLOOMBERG;
	private String AlternativeCode = "";

	public TI_INSTRUMENT_ALT_CODE()
	{
	}

	public long getFinancialInstrumentId()
	{
		return FinancialInstrumentId;
	}
	public void setFinancialInstrumentId(long value)
	{
		FinancialInstrumentId = value;
	}
	public TI_ALTERNATIVE_CODE_TYPE_Enum getAlternativeCodeType()
	{
		return AlternativeCodeType;
	}
	public void setAlternativeCodeType(TI_ALTERNATIVE_CODE_TYPE_Enum value)
	{
		AlternativeCodeType = value;
	}
	public String getAlternativeCode()
	{
		return AlternativeCode;
	}
	public void setAlternativeCode(String value)
	{
		AlternativeCode = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		FinancialInstrumentId = (long)byteBuffer.readInt();
		AlternativeCodeType = AlternativeCodeType.getEnum(byteBuffer.readInt());
		AlternativeCode = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(FinancialInstrumentId & 0xFFFFFFFFL));
		byteBuffer.writeInt(AlternativeCodeType.getValue());
		byteBuffer.writeString(AlternativeCode);

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
		stringBuilder.append("TI_INSTRUMENT_ALT_CODE::");
		stringBuilder.append("FinancialInstrumentId(").append(FinancialInstrumentId).append(")");
		stringBuilder.append("AlternativeCodeType(").append(AlternativeCodeType).append(")");
		stringBuilder.append("AlternativeCode(").append(AlternativeCode).append(")");
		return stringBuilder.toString();
	}
}
