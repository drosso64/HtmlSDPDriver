package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_PERIOD_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_PERIOD_Day(0),
	@SerializedName("1")
	TI_PERIOD_Week(1),
	@SerializedName("2")
	TI_PERIOD_Month(2),
	@SerializedName("3")
	TI_PERIOD_Year(3);

	private int value;

	TI_PERIOD_Enum(int value)
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
		if (value == TI_PERIOD_Day.ordinal())
			return "Day";
		if (value == TI_PERIOD_Week.ordinal())
			return "Week";
		if (value == TI_PERIOD_Month.ordinal())
			return "Month";
		if (value == TI_PERIOD_Year.ordinal())
			return "Year";
		return "";
	}
	public static TI_PERIOD_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_PERIOD_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
