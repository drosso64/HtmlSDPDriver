package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_POSSIBLE_QUOTING_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_POSSIBLE_QUOTING_None(0),
	@SerializedName("1")
	TI_POSSIBLE_QUOTING_Single(1),
	@SerializedName("2")
	TI_POSSIBLE_QUOTING_Double(2),
	@SerializedName("3")
	TI_POSSIBLE_QUOTING_Both(3);

	private int value;

	TI_POSSIBLE_QUOTING_Enum(int value)
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
		if (value == TI_POSSIBLE_QUOTING_None.ordinal())
			return "None";
		if (value == TI_POSSIBLE_QUOTING_Single.ordinal())
			return "Single Side";
		if (value == TI_POSSIBLE_QUOTING_Double.ordinal())
			return "Double Side";
		if (value == TI_POSSIBLE_QUOTING_Both.ordinal())
			return "Both";
		return "";
	}
	public static TI_POSSIBLE_QUOTING_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_POSSIBLE_QUOTING_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
