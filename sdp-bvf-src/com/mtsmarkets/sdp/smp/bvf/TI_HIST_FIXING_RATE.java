package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_HIST_FIXING_RATE extends SMPMessage
{
	public static final long CLASS_ID = 100032;

	private String FinancialInstrumentCode = "";
	private long ReferenceDate = 0;
	private double FixingRate = 0;

	public TI_HIST_FIXING_RATE()
	{
	}

	public String getFinancialInstrumentCode()
	{
		return FinancialInstrumentCode;
	}
	public void setFinancialInstrumentCode(String value)
	{
		FinancialInstrumentCode = value;
	}
	public long getReferenceDate()
	{
		return ReferenceDate;
	}
	public void setReferenceDate(long value)
	{
		ReferenceDate = value;
	}
	public double getFixingRate()
	{
		return FixingRate;
	}
	public void setFixingRate(double value)
	{
		FixingRate = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		FinancialInstrumentCode = byteBuffer.readString();
		ReferenceDate = (long)byteBuffer.readInt();
		FixingRate = byteBuffer.readDouble();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeString(FinancialInstrumentCode);
		byteBuffer.writeInt((int)(ReferenceDate & 0xFFFFFFFFL));
		byteBuffer.writeDouble(FixingRate);

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
		stringBuilder.append("TI_HIST_FIXING_RATE::");
		stringBuilder.append("FinancialInstrumentCode(").append(FinancialInstrumentCode).append(")");
		stringBuilder.append("ReferenceDate(").append(ReferenceDate).append(")");
		stringBuilder.append("FixingRate(").append(FixingRate).append(")");
		return stringBuilder.toString();
	}
}
