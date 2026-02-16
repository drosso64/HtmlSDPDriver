package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum BV_MATCH_MODE_Enum implements SMPEnum
{
	@SerializedName("0")
	BV_MATCH_MODE_Automatic(0),
	@SerializedName("1")
	BV_MATCH_MODE_Manual(1);

	private int value;

	BV_MATCH_MODE_Enum(int value)
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
		if (value == BV_MATCH_MODE_Automatic.ordinal())
			return "Automatic";
		if (value == BV_MATCH_MODE_Manual.ordinal())
			return "Manual";
		return "";
	}
	public static BV_MATCH_MODE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= BV_MATCH_MODE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
