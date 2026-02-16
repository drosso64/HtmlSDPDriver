package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_WEEK_DAY_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_WEEK_DAY_Undefined(0),
	@SerializedName("1")
	TI_WEEK_DAY_Monday(1),
	@SerializedName("2")
	TI_WEEK_DAY_Tuesday(2),
	@SerializedName("3")
	TI_WEEK_DAY_Wednesday(3),
	@SerializedName("4")
	TI_WEEK_DAY_Thursday(4),
	@SerializedName("5")
	TI_WEEK_DAY_Friday(5),
	@SerializedName("6")
	TI_WEEK_DAY_Saturday(6),
	@SerializedName("7")
	TI_WEEK_DAY_Sunday(7);

	private int value;

	TI_WEEK_DAY_Enum(int value)
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
		if (value == TI_WEEK_DAY_Undefined.ordinal())
			return "Undefined";
		if (value == TI_WEEK_DAY_Monday.ordinal())
			return "Monday";
		if (value == TI_WEEK_DAY_Tuesday.ordinal())
			return "Tuesday";
		if (value == TI_WEEK_DAY_Wednesday.ordinal())
			return "Wednesday";
		if (value == TI_WEEK_DAY_Thursday.ordinal())
			return "Thursday";
		if (value == TI_WEEK_DAY_Friday.ordinal())
			return "Friday";
		if (value == TI_WEEK_DAY_Saturday.ordinal())
			return "Saturday";
		if (value == TI_WEEK_DAY_Sunday.ordinal())
			return "Sunday";
		return "";
	}
	public static TI_WEEK_DAY_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_WEEK_DAY_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
