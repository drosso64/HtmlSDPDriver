package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum BV_ORDER_STAGING_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	BV_ORDER_STAGING_TYPE_Market(0),
	@SerializedName("1")
	BV_ORDER_STAGING_TYPE_Limit(1),
	@SerializedName("2")
	BV_ORDER_STAGING_TYPE_LimitWithOrWithout(2);

	private int value;

	BV_ORDER_STAGING_TYPE_Enum(int value)
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
		if (value == BV_ORDER_STAGING_TYPE_Market.ordinal())
			return "Market";
		if (value == BV_ORDER_STAGING_TYPE_Limit.ordinal())
			return "Limit";
		if (value == BV_ORDER_STAGING_TYPE_LimitWithOrWithout.ordinal())
			return "Limit With or Without";
		return "";
	}
	public static BV_ORDER_STAGING_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= BV_ORDER_STAGING_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
