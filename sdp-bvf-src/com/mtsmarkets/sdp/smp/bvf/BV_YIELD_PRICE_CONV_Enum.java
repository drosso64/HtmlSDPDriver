package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum BV_YIELD_PRICE_CONV_Enum implements SMPEnum
{
	@SerializedName("0")
	BV_YIELD_PRICE_CONV_None(0),
	@SerializedName("1")
	BV_YIELD_PRICE_CONV_Info(1),
	@SerializedName("2")
	BV_YIELD_PRICE_CONV_InfoBest(2);

	private int value;

	BV_YIELD_PRICE_CONV_Enum(int value)
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
		if (value == BV_YIELD_PRICE_CONV_None.ordinal())
			return "None";
		if (value == BV_YIELD_PRICE_CONV_Info.ordinal())
			return "Info";
		if (value == BV_YIELD_PRICE_CONV_InfoBest.ordinal())
			return "InfoBest";
		return "";
	}
	public static BV_YIELD_PRICE_CONV_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= BV_YIELD_PRICE_CONV_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
