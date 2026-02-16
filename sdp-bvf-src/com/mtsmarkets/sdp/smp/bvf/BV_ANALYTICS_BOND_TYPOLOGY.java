package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_ANALYTICS_BOND_TYPOLOGY extends SMPMessage
{
	public static final long CLASS_ID = 400023;

	private String BondTypology = "";
	private long FinancialInstrumentId = 0;
	private BV_ANALYTIC_Enum Analytic = BV_ANALYTIC_Enum.BV_ANALYTIC_ISpread;
	private long RateId = 0;
	private long CurveId = 0;
	private BV_INTERPOLATION_METHOD_Enum InterpolationMethod = BV_INTERPOLATION_METHOD_Enum.BV_INTERPOLATION_METHOD_Linear;

	public BV_ANALYTICS_BOND_TYPOLOGY()
	{
	}

	public String getBondTypology()
	{
		return BondTypology;
	}
	public void setBondTypology(String value)
	{
		BondTypology = value;
	}
	public long getFinancialInstrumentId()
	{
		return FinancialInstrumentId;
	}
	public void setFinancialInstrumentId(long value)
	{
		FinancialInstrumentId = value;
	}
	public BV_ANALYTIC_Enum getAnalytic()
	{
		return Analytic;
	}
	public void setAnalytic(BV_ANALYTIC_Enum value)
	{
		Analytic = value;
	}
	public long getRateId()
	{
		return RateId;
	}
	public void setRateId(long value)
	{
		RateId = value;
	}
	public long getCurveId()
	{
		return CurveId;
	}
	public void setCurveId(long value)
	{
		CurveId = value;
	}
	public BV_INTERPOLATION_METHOD_Enum getInterpolationMethod()
	{
		return InterpolationMethod;
	}
	public void setInterpolationMethod(BV_INTERPOLATION_METHOD_Enum value)
	{
		InterpolationMethod = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		BondTypology = byteBuffer.readString();
		FinancialInstrumentId = (long)byteBuffer.readInt();
		Analytic = Analytic.getEnum(byteBuffer.readInt());
		RateId = (long)byteBuffer.readInt();
		CurveId = (long)byteBuffer.readInt();
		InterpolationMethod = InterpolationMethod.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeString(BondTypology);
		byteBuffer.writeInt((int)(FinancialInstrumentId & 0xFFFFFFFFL));
		byteBuffer.writeInt(Analytic.getValue());
		byteBuffer.writeInt((int)(RateId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(CurveId & 0xFFFFFFFFL));
		byteBuffer.writeInt(InterpolationMethod.getValue());

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
		stringBuilder.append("BV_ANALYTICS_BOND_TYPOLOGY::");
		stringBuilder.append("BondTypology(").append(BondTypology).append(")");
		stringBuilder.append("FinancialInstrumentId(").append(FinancialInstrumentId).append(")");
		stringBuilder.append("Analytic(").append(Analytic).append(")");
		stringBuilder.append("RateId(").append(RateId).append(")");
		stringBuilder.append("CurveId(").append(CurveId).append(")");
		stringBuilder.append("InterpolationMethod(").append(InterpolationMethod).append(")");
		return stringBuilder.toString();
	}
}
