package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_VARIABLE_COUPON_BOND_SCHEDULE extends SMPMessage
{
	public static final long CLASS_ID = 400020;

	private long FinancialInstrumentId = 0;
	private long FormulaResetDate = 0;
	private TI_COUPON_TYPE_Enum CouponType = TI_COUPON_TYPE_Enum.TI_COUPON_TYPE_ZeroCoupon;
	private double CouponRate = 0;
	private long BenchmarkId = 0;
	private double Margin = 0;
	private TI_DAY_COUNT_CONVENTION_TYPE_Enum DayCountConventionType = TI_DAY_COUNT_CONVENTION_TYPE_Enum.TI_DAY_COUNT_CONVENTION_TYPE_ZeroCoupon;
	private short CouponFrequency = 0;
	private double Cap = 0;
	private double Floor = 0;

	public BV_VARIABLE_COUPON_BOND_SCHEDULE()
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
	public long getFormulaResetDate()
	{
		return FormulaResetDate;
	}
	public void setFormulaResetDate(long value)
	{
		FormulaResetDate = value;
	}
	public TI_COUPON_TYPE_Enum getCouponType()
	{
		return CouponType;
	}
	public void setCouponType(TI_COUPON_TYPE_Enum value)
	{
		CouponType = value;
	}
	public double getCouponRate()
	{
		return CouponRate;
	}
	public void setCouponRate(double value)
	{
		CouponRate = value;
	}
	public long getBenchmarkId()
	{
		return BenchmarkId;
	}
	public void setBenchmarkId(long value)
	{
		BenchmarkId = value;
	}
	public double getMargin()
	{
		return Margin;
	}
	public void setMargin(double value)
	{
		Margin = value;
	}
	public TI_DAY_COUNT_CONVENTION_TYPE_Enum getDayCountConventionType()
	{
		return DayCountConventionType;
	}
	public void setDayCountConventionType(TI_DAY_COUNT_CONVENTION_TYPE_Enum value)
	{
		DayCountConventionType = value;
	}
	public short getCouponFrequency()
	{
		return CouponFrequency;
	}
	public void setCouponFrequency(short value)
	{
		CouponFrequency = value;
	}
	public double getCap()
	{
		return Cap;
	}
	public void setCap(double value)
	{
		Cap = value;
	}
	public double getFloor()
	{
		return Floor;
	}
	public void setFloor(double value)
	{
		Floor = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		FinancialInstrumentId = (long)byteBuffer.readInt();
		FormulaResetDate = (long)byteBuffer.readInt();
		CouponType = CouponType.getEnum(byteBuffer.readInt());
		CouponRate = byteBuffer.readDouble();
		BenchmarkId = (long)byteBuffer.readInt();
		Margin = byteBuffer.readDouble();
		DayCountConventionType = DayCountConventionType.getEnum(byteBuffer.readInt());
		CouponFrequency = (short)byteBuffer.readInt();
		Cap = byteBuffer.readDouble();
		Floor = byteBuffer.readDouble();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(FinancialInstrumentId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(FormulaResetDate & 0xFFFFFFFFL));
		byteBuffer.writeInt(CouponType.getValue());
		byteBuffer.writeDouble(CouponRate);
		byteBuffer.writeInt((int)(BenchmarkId & 0xFFFFFFFFL));
		byteBuffer.writeDouble(Margin);
		byteBuffer.writeInt(DayCountConventionType.getValue());
		byteBuffer.writeInt((int)(CouponFrequency & 0xFFFFL));
		byteBuffer.writeDouble(Cap);
		byteBuffer.writeDouble(Floor);

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
		stringBuilder.append("BV_VARIABLE_COUPON_BOND_SCHEDULE::");
		stringBuilder.append("FinancialInstrumentId(").append(FinancialInstrumentId).append(")");
		stringBuilder.append("FormulaResetDate(").append(FormulaResetDate).append(")");
		stringBuilder.append("CouponType(").append(CouponType).append(")");
		stringBuilder.append("CouponRate(").append(CouponRate).append(")");
		stringBuilder.append("BenchmarkId(").append(BenchmarkId).append(")");
		stringBuilder.append("Margin(").append(Margin).append(")");
		stringBuilder.append("DayCountConventionType(").append(DayCountConventionType).append(")");
		stringBuilder.append("CouponFrequency(").append(CouponFrequency).append(")");
		stringBuilder.append("Cap(").append(Cap).append(")");
		stringBuilder.append("Floor(").append(Floor).append(")");
		return stringBuilder.toString();
	}
}
