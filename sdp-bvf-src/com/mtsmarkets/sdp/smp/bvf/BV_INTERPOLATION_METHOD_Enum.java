package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum BV_INTERPOLATION_METHOD_Enum implements SMPEnum
{
	@SerializedName("0")
	BV_INTERPOLATION_METHOD_Linear(0),
	@SerializedName("1")
	BV_INTERPOLATION_METHOD_LogLinear(1),
	@SerializedName("2")
	BV_INTERPOLATION_METHOD_Cubic(2),
	@SerializedName("3")
	BV_INTERPOLATION_METHOD_LogCubic(3),
	@SerializedName("4")
	BV_INTERPOLATION_METHOD_CubicSpline(4);

	private int value;

	BV_INTERPOLATION_METHOD_Enum(int value)
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
		if (value == BV_INTERPOLATION_METHOD_Linear.ordinal())
			return "Linear";
		if (value == BV_INTERPOLATION_METHOD_LogLinear.ordinal())
			return "Log-Linear";
		if (value == BV_INTERPOLATION_METHOD_Cubic.ordinal())
			return "Cubic";
		if (value == BV_INTERPOLATION_METHOD_LogCubic.ordinal())
			return "Log-Cubic";
		if (value == BV_INTERPOLATION_METHOD_CubicSpline.ordinal())
			return "Cubic Spline";
		return "";
	}
	public static BV_INTERPOLATION_METHOD_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= BV_INTERPOLATION_METHOD_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
