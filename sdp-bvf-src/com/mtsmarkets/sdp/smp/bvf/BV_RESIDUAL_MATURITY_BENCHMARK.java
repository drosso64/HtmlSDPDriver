package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_RESIDUAL_MATURITY_BENCHMARK extends SMPMessage
{
	public static final long CLASS_ID = 114534;

	private long ResidualMaturityId = 0;
	private long FinancialInstrumentId = 0;
	private String CurrencyCode = "";

	public BV_RESIDUAL_MATURITY_BENCHMARK()
	{
	}

	public long getResidualMaturityId()
	{
		return ResidualMaturityId;
	}
	public void setResidualMaturityId(long value)
	{
		ResidualMaturityId = value;
	}
	public long getFinancialInstrumentId()
	{
		return FinancialInstrumentId;
	}
	public void setFinancialInstrumentId(long value)
	{
		FinancialInstrumentId = value;
	}
	public String getCurrencyCode()
	{
		return CurrencyCode;
	}
	public void setCurrencyCode(String value)
	{
		CurrencyCode = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		ResidualMaturityId = (long)byteBuffer.readInt();
		FinancialInstrumentId = (long)byteBuffer.readInt();
		CurrencyCode = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(ResidualMaturityId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(FinancialInstrumentId & 0xFFFFFFFFL));
		byteBuffer.writeString(CurrencyCode);

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
		stringBuilder.append("BV_RESIDUAL_MATURITY_BENCHMARK::");
		stringBuilder.append("ResidualMaturityId(").append(ResidualMaturityId).append(")");
		stringBuilder.append("FinancialInstrumentId(").append(FinancialInstrumentId).append(")");
		stringBuilder.append("CurrencyCode(").append(CurrencyCode).append(")");
		return stringBuilder.toString();
	}
}
