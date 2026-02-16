package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum BV_HEDGE_RATIO_Enum implements SMPEnum
{
	@SerializedName("0")
	BV_HEDGE_RATIO_None(0),
	@SerializedName("1")
	BV_HEDGE_RATIO_PriceFactor(1),
	@SerializedName("2")
	BV_HEDGE_RATIO_Duration(2),
	@SerializedName("3")
	BV_HEDGE_RATIO_Nominal(3);

	private int value;

	BV_HEDGE_RATIO_Enum(int value)
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
		if (value == BV_HEDGE_RATIO_None.ordinal())
			return "None";
		if (value == BV_HEDGE_RATIO_PriceFactor.ordinal())
			return "Price Factor Hedge";
		if (value == BV_HEDGE_RATIO_Duration.ordinal())
			return "Duration Hedge";
		if (value == BV_HEDGE_RATIO_Nominal.ordinal())
			return "Nominal Hedge";
		return "";
	}
	public static BV_HEDGE_RATIO_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= BV_HEDGE_RATIO_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
