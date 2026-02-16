package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum BV_PRE_TRADE_PUBLISH_FLAG_Enum implements SMPEnum
{
	@SerializedName("0")
	BV_PRE_TRADE_PUBLISH_FLAG_None(0),
	@SerializedName("1")
	BV_PRE_TRADE_PUBLISH_FLAG_Average(1),
	@SerializedName("2")
	BV_PRE_TRADE_PUBLISH_FLAG_AllQuotes(2);

	private int value;

	BV_PRE_TRADE_PUBLISH_FLAG_Enum(int value)
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
		if (value == BV_PRE_TRADE_PUBLISH_FLAG_None.ordinal())
			return "None";
		if (value == BV_PRE_TRADE_PUBLISH_FLAG_Average.ordinal())
			return "Average";
		if (value == BV_PRE_TRADE_PUBLISH_FLAG_AllQuotes.ordinal())
			return "All Quotes";
		return "";
	}
	public static BV_PRE_TRADE_PUBLISH_FLAG_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= BV_PRE_TRADE_PUBLISH_FLAG_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
