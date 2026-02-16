package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_RFCQ_AUTO_EXECUTION_ELIGIBILITY_CRITERIA_BV_COMPOSITE extends SMPMessage
{
	public static final long CLASS_ID = 410005;

	private TI_FLAG_Enum SpreadFg = TI_FLAG_Enum.TI_FLAG_No;
	private double Spread = 0;
	private TI_FLAG_Enum PercentageFg = TI_FLAG_Enum.TI_FLAG_No;
	private BV_ELIGIBILITY_ALWAYS_BEAT_TYPE_Enum EligibilityAlwaysBeat = BV_ELIGIBILITY_ALWAYS_BEAT_TYPE_Enum.BV_ELIGIBILITY_ALWAYS_BEAT_TYPE_None;

	public BV_RFCQ_AUTO_EXECUTION_ELIGIBILITY_CRITERIA_BV_COMPOSITE()
	{
	}

	public TI_FLAG_Enum getSpreadFg()
	{
		return SpreadFg;
	}
	public void setSpreadFg(TI_FLAG_Enum value)
	{
		SpreadFg = value;
	}
	public double getSpread()
	{
		return Spread;
	}
	public void setSpread(double value)
	{
		Spread = value;
	}
	public TI_FLAG_Enum getPercentageFg()
	{
		return PercentageFg;
	}
	public void setPercentageFg(TI_FLAG_Enum value)
	{
		PercentageFg = value;
	}
	public BV_ELIGIBILITY_ALWAYS_BEAT_TYPE_Enum getEligibilityAlwaysBeat()
	{
		return EligibilityAlwaysBeat;
	}
	public void setEligibilityAlwaysBeat(BV_ELIGIBILITY_ALWAYS_BEAT_TYPE_Enum value)
	{
		EligibilityAlwaysBeat = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		SpreadFg = SpreadFg.getEnum(byteBuffer.readInt());
		Spread = byteBuffer.readDouble();
		PercentageFg = PercentageFg.getEnum(byteBuffer.readInt());
		EligibilityAlwaysBeat = EligibilityAlwaysBeat.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt(SpreadFg.getValue());
		byteBuffer.writeDouble(Spread);
		byteBuffer.writeInt(PercentageFg.getValue());
		byteBuffer.writeInt(EligibilityAlwaysBeat.getValue());

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
		stringBuilder.append("BV_RFCQ_AUTO_EXECUTION_ELIGIBILITY_CRITERIA_BV_COMPOSITE::");
		stringBuilder.append("SpreadFg(").append(SpreadFg).append(")");
		stringBuilder.append("Spread(").append(Spread).append(")");
		stringBuilder.append("PercentageFg(").append(PercentageFg).append(")");
		stringBuilder.append("EligibilityAlwaysBeat(").append(EligibilityAlwaysBeat).append(")");
		return stringBuilder.toString();
	}
}
