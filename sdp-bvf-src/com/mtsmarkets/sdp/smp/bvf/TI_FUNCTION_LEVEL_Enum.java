package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_FUNCTION_LEVEL_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_FUNCTION_LEVEL_Platform(0),
	@SerializedName("1")
	TI_FUNCTION_LEVEL_Market(1);

	private int value;

	TI_FUNCTION_LEVEL_Enum(int value)
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
		if (value == TI_FUNCTION_LEVEL_Platform.ordinal())
			return "Platform";
		if (value == TI_FUNCTION_LEVEL_Market.ordinal())
			return "Market";
		return "";
	}
	public static TI_FUNCTION_LEVEL_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_FUNCTION_LEVEL_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
