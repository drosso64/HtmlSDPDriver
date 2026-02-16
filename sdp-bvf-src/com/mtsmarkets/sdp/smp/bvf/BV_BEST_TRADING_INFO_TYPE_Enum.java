package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum BV_BEST_TRADING_INFO_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	BV_BEST_TRADING_INFO_TYPE_None(0),
	@SerializedName("1")
	BV_BEST_TRADING_INFO_TYPE_PriceYield(1),
	@SerializedName("2")
	BV_BEST_TRADING_INFO_TYPE_MidBVBest(2);

	private int value;

	BV_BEST_TRADING_INFO_TYPE_Enum(int value)
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
		if (value == BV_BEST_TRADING_INFO_TYPE_None.ordinal())
			return "None";
		if (value == BV_BEST_TRADING_INFO_TYPE_PriceYield.ordinal())
			return "Price/Yield";
		if (value == BV_BEST_TRADING_INFO_TYPE_MidBVBest.ordinal())
			return "Mid BV Best";
		return "";
	}
	public static BV_BEST_TRADING_INFO_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= BV_BEST_TRADING_INFO_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
