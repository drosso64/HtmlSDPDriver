package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_INSTRUMENT_ANALYTICS_INPUT_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_INSTRUMENT_ANALYTICS_INPUT_TYPE_Dirty(0),
	@SerializedName("1")
	TI_INSTRUMENT_ANALYTICS_INPUT_TYPE_Clean(1),
	@SerializedName("2")
	TI_INSTRUMENT_ANALYTICS_INPUT_TYPE_Clean32(2),
	@SerializedName("3")
	TI_INSTRUMENT_ANALYTICS_INPUT_TYPE_Yield(3);

	private int value;

	TI_INSTRUMENT_ANALYTICS_INPUT_TYPE_Enum(int value)
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
		if (value == TI_INSTRUMENT_ANALYTICS_INPUT_TYPE_Dirty.ordinal())
			return "Dirty Price";
		if (value == TI_INSTRUMENT_ANALYTICS_INPUT_TYPE_Clean.ordinal())
			return "Clean Price";
		if (value == TI_INSTRUMENT_ANALYTICS_INPUT_TYPE_Clean32.ordinal())
			return "Clean Price 32";
		if (value == TI_INSTRUMENT_ANALYTICS_INPUT_TYPE_Yield.ordinal())
			return "Yield";
		return "";
	}
	public static TI_INSTRUMENT_ANALYTICS_INPUT_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_INSTRUMENT_ANALYTICS_INPUT_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
