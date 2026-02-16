package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum BV_RFCQ_AUTO_EXECUTION_EXECUTION_BEAT_Enum implements SMPEnum
{
	@SerializedName("0")
	BV_RFCQ_AUTO_EXECUTION_EXECUTION_BEAT_None(0),
	@SerializedName("1")
	BV_RFCQ_AUTO_EXECUTION_EXECUTION_BEAT_BidAsk(1),
	@SerializedName("2")
	BV_RFCQ_AUTO_EXECUTION_EXECUTION_BEAT_Mid(2);

	private int value;

	BV_RFCQ_AUTO_EXECUTION_EXECUTION_BEAT_Enum(int value)
	{
		this.value = value;
	}
	public int getValue()
	{
		return value;
	}
	public void setValue(int value)
	{
		this.value = value;
	}
	public String getDesc()
	{
		return getDesc(value);
	}
	public static String getDesc(int value)
	{
		if (value == BV_RFCQ_AUTO_EXECUTION_EXECUTION_BEAT_None.ordinal())
			return "None";
		if (value == BV_RFCQ_AUTO_EXECUTION_EXECUTION_BEAT_BidAsk.ordinal())
			return "Ask/Bid values";
		if (value == BV_RFCQ_AUTO_EXECUTION_EXECUTION_BEAT_Mid.ordinal())
			return "Mid value";
		return "";
	}
	public static BV_RFCQ_AUTO_EXECUTION_EXECUTION_BEAT_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= BV_RFCQ_AUTO_EXECUTION_EXECUTION_BEAT_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
