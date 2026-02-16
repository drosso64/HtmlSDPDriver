package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_RFCQ_AUTO_EXECUTION_ELIGIBILITY_CRITERIA_RESIDUAL_MATURITY extends SMPMessage
{
	public static final long CLASS_ID = 114995;

	private short ResidualMaturityNum = 0;
	private long[] ResidualMaturityId = new long[20];
	private TI_FLAG_Enum LowerBoundIncludedFg = TI_FLAG_Enum.TI_FLAG_No;
	private long LowerBound = 0;
	private TI_FLAG_Enum UpperBoundIncludedFg = TI_FLAG_Enum.TI_FLAG_No;
	private long UpperBound = 0;

	public BV_RFCQ_AUTO_EXECUTION_ELIGIBILITY_CRITERIA_RESIDUAL_MATURITY()
	{
	}

	public short getResidualMaturityNum()
	{
		return ResidualMaturityNum;
	}
	public void setResidualMaturityNum(short value)
	{
		ResidualMaturityNum = value;
	}
	public long[] getResidualMaturityId()
	{
		return ResidualMaturityId;
	}
	public void setResidualMaturityId(long[] value)
	{
		ResidualMaturityId = value;
	}
	public TI_FLAG_Enum getLowerBoundIncludedFg()
	{
		return LowerBoundIncludedFg;
	}
	public void setLowerBoundIncludedFg(TI_FLAG_Enum value)
	{
		LowerBoundIncludedFg = value;
	}
	public long getLowerBound()
	{
		return LowerBound;
	}
	public void setLowerBound(long value)
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
	public long getUpperBound()
	{
		return UpperBound;
	}
	public void setUpperBound(long value)
	{
		UpperBound = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		ResidualMaturityNum = (short)byteBuffer.readInt();
		for (int i=0; i < ResidualMaturityId.length; ++i)
		{
			ResidualMaturityId[i] = (long)byteBuffer.readInt();
		}
		LowerBoundIncludedFg = LowerBoundIncludedFg.getEnum(byteBuffer.readInt());
		LowerBound = (long)byteBuffer.readInt();
		UpperBoundIncludedFg = UpperBoundIncludedFg.getEnum(byteBuffer.readInt());
		UpperBound = (long)byteBuffer.readInt();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(ResidualMaturityNum & 0xFFFFL));
		for (int i=0; i < ResidualMaturityId.length; ++i)
		{
			byteBuffer.writeInt((int)(ResidualMaturityId[i] & 0xFFFFFFFFL));
		}
		byteBuffer.writeInt(LowerBoundIncludedFg.getValue());
		byteBuffer.writeInt((int)(LowerBound & 0xFFFFFFFFL));
		byteBuffer.writeInt(UpperBoundIncludedFg.getValue());
		byteBuffer.writeInt((int)(UpperBound & 0xFFFFFFFFL));

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
		stringBuilder.append("BV_RFCQ_AUTO_EXECUTION_ELIGIBILITY_CRITERIA_RESIDUAL_MATURITY::");
		stringBuilder.append("ResidualMaturityNum(").append(ResidualMaturityNum).append(")");
		for (int i=0; i < ResidualMaturityId.length; ++i)
		{
			stringBuilder.append("ResidualMaturityId[").append(i).append("](").append(ResidualMaturityId[i]).append(")");
		}
		stringBuilder.append("LowerBoundIncludedFg(").append(LowerBoundIncludedFg).append(")");
		stringBuilder.append("LowerBound(").append(LowerBound).append(")");
		stringBuilder.append("UpperBoundIncludedFg(").append(UpperBoundIncludedFg).append(")");
		stringBuilder.append("UpperBound(").append(UpperBound).append(")");
		return stringBuilder.toString();
	}
}
