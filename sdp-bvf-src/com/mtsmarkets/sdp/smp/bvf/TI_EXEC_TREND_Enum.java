package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_EXEC_TREND_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_EXEC_TREND_Equal(0),
	@SerializedName("1")
	TI_EXEC_TREND_LessThan(1),
	@SerializedName("2")
	TI_EXEC_TREND_GreaterThan(2),
	@SerializedName("3")
	TI_EXEC_TREND_NotApplicable(3);

	private int value;

	TI_EXEC_TREND_Enum(int value)
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
		if (value == TI_EXEC_TREND_Equal.ordinal())
			return "Equal";
		if (value == TI_EXEC_TREND_LessThan.ordinal())
			return "Less Than";
		if (value == TI_EXEC_TREND_GreaterThan.ordinal())
			return "Greater Than";
		if (value == TI_EXEC_TREND_NotApplicable.ordinal())
			return "Not Applicable";
		return "";
	}
	public static TI_EXEC_TREND_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_EXEC_TREND_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
