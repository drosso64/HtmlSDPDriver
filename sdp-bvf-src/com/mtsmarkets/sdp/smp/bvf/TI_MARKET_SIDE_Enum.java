package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_MARKET_SIDE_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_MARKET_SIDE_Bid(0),
	@SerializedName("1")
	TI_MARKET_SIDE_Ask(1);

	private int value;

	TI_MARKET_SIDE_Enum(int value)
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
		if (value == TI_MARKET_SIDE_Bid.ordinal())
			return "Bid";
		if (value == TI_MARKET_SIDE_Ask.ordinal())
			return "Ask";
		return "";
	}
	public static TI_MARKET_SIDE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_MARKET_SIDE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
