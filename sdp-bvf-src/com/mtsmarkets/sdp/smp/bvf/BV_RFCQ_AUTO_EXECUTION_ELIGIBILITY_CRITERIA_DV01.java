package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_RFCQ_AUTO_EXECUTION_ELIGIBILITY_CRITERIA_DV01 extends SMPMessage
{
	public static final long CLASS_ID = 114997;

	private TI_FLAG_Enum LowerBoundIncludedFg = TI_FLAG_Enum.TI_FLAG_No;
	private double LowerBound = 0;
	private TI_FLAG_Enum UpperBoundIncludedFg = TI_FLAG_Enum.TI_FLAG_No;
	private double UpperBound = 0;

	public BV_RFCQ_AUTO_EXECUTION_ELIGIBILITY_CRITERIA_DV01()
	{
	}

	public TI_FLAG_Enum getLowerBoundIncludedFg()
	{
		return LowerBoundIncludedFg;
	}
	public void setLowerBoundIncludedFg(TI_FLAG_Enum value)
	{
		LowerBoundIncludedFg = value;
	}
	public double getLowerBound()
	{
		return LowerBound;
	}
	public void setLowerBound(double value)
	{
		LowerBound = value;
	}
	public TI_FLAG_Enum getUpperBoundIncludedFg()
	{
		return UpperBoundIncludedFg;
	}
	public void setUpperBoundIncludedFg(TI_FLAG_Enum value)
	{
		UpperBoundIncludedFg = value;
	}
	public double getUpperBound()
	{
		return UpperBound;
	}
	public void setUpperBound(double value)
	{
		UpperBound = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		LowerBoundIncludedFg = LowerBoundIncludedFg.getEnum(byteBuffer.readInt());
		LowerBound = byteBuffer.readDouble();
		UpperBoundIncludedFg = UpperBoundIncludedFg.getEnum(byteBuffer.readInt());
		UpperBound = byteBuffer.readDouble();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt(LowerBoundIncludedFg.getValue());
		byteBuffer.writeDouble(LowerBound);
		byteBuffer.writeInt(UpperBoundIncludedFg.getValue());
		byteBuffer.writeDouble(UpperBound);

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
		stringBuilder.append("BV_RFCQ_AUTO_EXECUTION_ELIGIBILITY_CRITERIA_DV01::");
		stringBuilder.append("LowerBoundIncludedFg(").append(LowerBoundIncludedFg).append(")");
		stringBuilder.append("LowerBound(").append(LowerBound).append(")");
		stringBuilder.append("UpperBoundIncludedFg(").append(UpperBoundIncludedFg).append(")");
		stringBuilder.append("UpperBound(").append(UpperBound).append(")");
		return stringBuilder.toString();
	}
}
