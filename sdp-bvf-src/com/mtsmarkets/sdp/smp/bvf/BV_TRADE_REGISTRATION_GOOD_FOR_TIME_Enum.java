package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum BV_TRADE_REGISTRATION_GOOD_FOR_TIME_Enum implements SMPEnum
{
	@SerializedName("0")
	BV_TRADE_REGISTRATION_GOOD_FOR_TIME_EOD(0),
	@SerializedName("1")
	BV_TRADE_REGISTRATION_GOOD_FOR_TIME_Manual(1);

	private int value;

	BV_TRADE_REGISTRATION_GOOD_FOR_TIME_Enum(int value)
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
		if (value == BV_TRADE_REGISTRATION_GOOD_FOR_TIME_EOD.ordinal())
			return "End Of Day";
		if (value == BV_TRADE_REGISTRATION_GOOD_FOR_TIME_Manual.ordinal())
			return "Manual";
		return "";
	}
	public static BV_TRADE_REGISTRATION_GOOD_FOR_TIME_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= BV_TRADE_REGISTRATION_GOOD_FOR_TIME_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
