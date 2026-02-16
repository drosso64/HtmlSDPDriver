package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum BV_CALCULATION_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	BV_CALCULATION_TYPE_DurationWeighted(0),
	@SerializedName("1")
	BV_CALCULATION_TYPE_CashEquivalent(1);

	private int value;

	BV_CALCULATION_TYPE_Enum(int value)
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
		if (value == BV_CALCULATION_TYPE_DurationWeighted.ordinal())
			return "DurationWeighted";
		if (value == BV_CALCULATION_TYPE_CashEquivalent.ordinal())
			return "CashEquivalent";
		return "";
	}
	public static BV_CALCULATION_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= BV_CALCULATION_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
