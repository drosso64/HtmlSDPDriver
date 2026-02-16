package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_COUPON_PLAN extends SMPMessage
{
	public static final long CLASS_ID = 100018;

	private long FinancialInstrumentId = 0;
	private short SequentialNumber = 0;
	private long StartCouponDate = 0;
	private long StopCouponDate = 0;
	private double CouponRate = 0;
	private TI_IRREGULARITY_TYPE_Enum IrregularityType = TI_IRREGULARITY_TYPE_Enum.TI_IRREGULARITY_TYPE_RegularCoupon;
	private long StartExceptionDate = 0;
	private long StopExceptionDate = 0;

	public TI_COUPON_PLAN()
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
	public short getSequentialNumber()
	{
		return SequentialNumber;
	}
	public void setSequentialNumber(short value)
	{
		SequentialNumber = value;
	}
	public long getStartCouponDate()
	{
		return StartCouponDate;
	}
	public void setStartCouponDate(long value)
	{
		StartCouponDate = value;
	}
	public long getStopCouponDate()
	{
		return StopCouponDate;
	}
	public void setStopCouponDate(long value)
	{
		StopCouponDate = value;
	}
	public double getCouponRate()
	{
		return CouponRate;
	}
	public void setCouponRate(double value)
	{
		CouponRate = value;
	}
	public TI_IRREGULARITY_TYPE_Enum getIrregularityType()
	{
		return IrregularityType;
	}
	public void setIrregularityType(TI_IRREGULARITY_TYPE_Enum value)
	{
		IrregularityType = value;
	}
	public long getStartExceptionDate()
	{
		return StartExceptionDate;
	}
	public void setStartExceptionDate(long value)
	{
		StartExceptionDate = value;
	}
	public long getStopExceptionDate()
	{
		return StopExceptionDate;
	}
	public void setStopExceptionDate(long value)
	{
		StopExceptionDate = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		FinancialInstrumentId = (long)byteBuffer.readInt();
		SequentialNumber = (short)byteBuffer.readInt();
		StartCouponDate = (long)byteBuffer.readInt();
		StopCouponDate = (long)byteBuffer.readInt();
		CouponRate = byteBuffer.readDouble();
		IrregularityType = IrregularityType.getEnum(byteBuffer.readInt());
		StartExceptionDate = (long)byteBuffer.readInt();
		StopExceptionDate = (long)byteBuffer.readInt();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(FinancialInstrumentId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SequentialNumber & 0xFFFFL));
		byteBuffer.writeInt((int)(StartCouponDate & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(StopCouponDate & 0xFFFFFFFFL));
		byteBuffer.writeDouble(CouponRate);
		byteBuffer.writeInt(IrregularityType.getValue());
		byteBuffer.writeInt((int)(StartExceptionDate & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(StopExceptionDate & 0xFFFFFFFFL));

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
		stringBuilder.append("TI_COUPON_PLAN::");
		stringBuilder.append("FinancialInstrumentId(").append(FinancialInstrumentId).append(")");
		stringBuilder.append("SequentialNumber(").append(SequentialNumber).append(")");
		stringBuilder.append("StartCouponDate(").append(StartCouponDate).append(")");
		stringBuilder.append("StopCouponDate(").append(StopCouponDate).append(")");
		stringBuilder.append("CouponRate(").append(CouponRate).append(")");
		stringBuilder.append("IrregularityType(").append(IrregularityType).append(")");
		stringBuilder.append("StartExceptionDate(").append(StartExceptionDate).append(")");
		stringBuilder.append("StopExceptionDate(").append(StopExceptionDate).append(")");
		return stringBuilder.toString();
	}
}
