package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum SID_WORKING_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	SID_WORKING_TYPE_Default(0),
	@SerializedName("1")
	SID_WORKING_TYPE_Custom_1(1);

	private int value;

	SID_WORKING_TYPE_Enum(int value)
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
		if (value == SID_WORKING_TYPE_Default.ordinal())
			return "Default working type";
		if (value == SID_WORKING_TYPE_Custom_1.ordinal())
			return "Custom working type 1";
		return "";
	}
	public static SID_WORKING_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= SID_WORKING_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
