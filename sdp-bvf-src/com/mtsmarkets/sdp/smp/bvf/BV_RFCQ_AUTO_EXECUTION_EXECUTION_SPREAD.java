package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_RFCQ_AUTO_EXECUTION_EXECUTION_SPREAD extends SMPMessage
{
	public static final long CLASS_ID = 114960;

	private TI_FLAG_Enum SpreadFg = TI_FLAG_Enum.TI_FLAG_No;
	private double Spread = 0;
	private TI_FLAG_Enum MidFg = TI_FLAG_Enum.TI_FLAG_No;
	private TI_FLAG_Enum PercentageFg = TI_FLAG_Enum.TI_FLAG_No;
	private BV_RFCQ_AUTO_EXECUTION_EXECUTION_BEAT_Enum AlwaysBeat = BV_RFCQ_AUTO_EXECUTION_EXECUTION_BEAT_Enum.BV_RFCQ_AUTO_EXECUTION_EXECUTION_BEAT_None;

	public BV_RFCQ_AUTO_EXECUTION_EXECUTION_SPREAD()
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
	public TI_FLAG_Enum getMidFg()
	{
		return MidFg;
	}
	public void setMidFg(TI_FLAG_Enum value)
	{
		MidFg = value;
	}
	public TI_FLAG_Enum getPercentageFg()
	{
		return PercentageFg;
	}
	public void setPercentageFg(TI_FLAG_Enum value)
	{
		PercentageFg = value;
	}
	public BV_RFCQ_AUTO_EXECUTION_EXECUTION_BEAT_Enum getAlwaysBeat()
	{
		return AlwaysBeat;
	}
	public void setAlwaysBeat(BV_RFCQ_AUTO_EXECUTION_EXECUTION_BEAT_Enum value)
	{
		AlwaysBeat = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		SpreadFg = SpreadFg.getEnum(byteBuffer.readInt());
		Spread = byteBuffer.readDouble();
		MidFg = MidFg.getEnum(byteBuffer.readInt());
		PercentageFg = PercentageFg.getEnum(byteBuffer.readInt());
		AlwaysBeat = AlwaysBeat.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt(SpreadFg.getValue());
		byteBuffer.writeDouble(Spread);
		byteBuffer.writeInt(MidFg.getValue());
		byteBuffer.writeInt(PercentageFg.getValue());
		byteBuffer.writeInt(AlwaysBeat.getValue());

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
		stringBuilder.append("BV_RFCQ_AUTO_EXECUTION_EXECUTION_SPREAD::");
		stringBuilder.append("SpreadFg(").append(SpreadFg).append(")");
		stringBuilder.append("Spread(").append(Spread).append(")");
		stringBuilder.append("MidFg(").append(MidFg).append(")");
		stringBuilder.append("PercentageFg(").append(PercentageFg).append(")");
		stringBuilder.append("AlwaysBeat(").append(AlwaysBeat).append(")");
		return stringBuilder.toString();
	}
}
