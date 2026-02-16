package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_STATISTIC_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_STATISTIC_TYPE_Life(0),
	@SerializedName("1")
	TI_STATISTIC_TYPE_Yesterday(1),
	@SerializedName("2")
	TI_STATISTIC_TYPE_Today(2),
	@SerializedName("3")
	TI_STATISTIC_TYPE_Hour(3);

	private int value;

	TI_STATISTIC_TYPE_Enum(int value)
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
		if (value == TI_STATISTIC_TYPE_Life.ordinal())
			return "Life";
		if (value == TI_STATISTIC_TYPE_Yesterday.ordinal())
			return "Yesterday";
		if (value == TI_STATISTIC_TYPE_Today.ordinal())
			return "Today";
		if (value == TI_STATISTIC_TYPE_Hour.ordinal())
			return "Hour";
		return "";
	}
	public static TI_STATISTIC_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_STATISTIC_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
