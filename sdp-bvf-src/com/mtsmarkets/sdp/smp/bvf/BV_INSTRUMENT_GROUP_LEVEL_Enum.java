package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum BV_INSTRUMENT_GROUP_LEVEL_Enum implements SMPEnum
{
	@SerializedName("0")
	BV_INSTRUMENT_GROUP_LEVEL_None(0),
	@SerializedName("1")
	BV_INSTRUMENT_GROUP_LEVEL_First(1),
	@SerializedName("2")
	BV_INSTRUMENT_GROUP_LEVEL_Second(2);

	private int value;

	BV_INSTRUMENT_GROUP_LEVEL_Enum(int value)
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
		if (value == BV_INSTRUMENT_GROUP_LEVEL_None.ordinal())
			return "None";
		if (value == BV_INSTRUMENT_GROUP_LEVEL_First.ordinal())
			return "First";
		if (value == BV_INSTRUMENT_GROUP_LEVEL_Second.ordinal())
			return "Second";
		return "";
	}
	public static BV_INSTRUMENT_GROUP_LEVEL_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= BV_INSTRUMENT_GROUP_LEVEL_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
