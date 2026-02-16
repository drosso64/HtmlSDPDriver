package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_CALLABLE_BOND_SCHEDULE extends SMPMessage
{
	public static final long CLASS_ID = 400017;

	private long FinancialInstrumentId = 0;
	private long CallDate = 0;
	private double CallPrice = 0;

	public BV_CALLABLE_BOND_SCHEDULE()
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
	public long getCallDate()
	{
		return CallDate;
	}
	public void setCallDate(long value)
	{
		CallDate = value;
	}
	public double getCallPrice()
	{
		return CallPrice;
	}
	public void setCallPrice(double value)
	{
		CallPrice = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		FinancialInstrumentId = (long)byteBuffer.readInt();
		CallDate = (long)byteBuffer.readInt();
		CallPrice = byteBuffer.readDouble();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(FinancialInstrumentId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(CallDate & 0xFFFFFFFFL));
		byteBuffer.writeDouble(CallPrice);

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
		stringBuilder.append("BV_CALLABLE_BOND_SCHEDULE::");
		stringBuilder.append("FinancialInstrumentId(").append(FinancialInstrumentId).append(")");
		stringBuilder.append("CallDate(").append(CallDate).append(")");
		stringBuilder.append("CallPrice(").append(CallPrice).append(")");
		return stringBuilder.toString();
	}
}
