package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum DF_ACCPT_RANGE_DIRECTION_Enum implements SMPEnum
{
	@SerializedName("0")
	DF_ACCPT_RANGE_DIRECTION_Undefined(0),
	@SerializedName("1")
	DF_ACCPT_RANGE_DIRECTION_Up(1),
	@SerializedName("2")
	DF_ACCPT_RANGE_DIRECTION_Down(2);

	private int value;

	DF_ACCPT_RANGE_DIRECTION_Enum(int value)
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
		if (value == DF_ACCPT_RANGE_DIRECTION_Undefined.ordinal())
			return "Undefined";
		if (value == DF_ACCPT_RANGE_DIRECTION_Up.ordinal())
			return "Up";
		if (value == DF_ACCPT_RANGE_DIRECTION_Down.ordinal())
			return "Down";
		return "";
	}
	public static DF_ACCPT_RANGE_DIRECTION_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= DF_ACCPT_RANGE_DIRECTION_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
