package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum BV_CALL_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	BV_CALL_TYPE_OnSpecifiedDates(0),
	@SerializedName("1")
	BV_CALL_TYPE_Anytime(1);

	private int value;

	BV_CALL_TYPE_Enum(int value)
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
		if (value == BV_CALL_TYPE_OnSpecifiedDates.ordinal())
			return "Only on specified dates";
		if (value == BV_CALL_TYPE_Anytime.ordinal())
			return "On and anytime after specified dates";
		return "";
	}
	public static BV_CALL_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= BV_CALL_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
