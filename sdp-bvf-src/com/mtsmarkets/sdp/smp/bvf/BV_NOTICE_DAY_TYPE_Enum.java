package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum BV_NOTICE_DAY_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	BV_NOTICE_DAY_TYPE_BusinessDays(0),
	@SerializedName("1")
	BV_NOTICE_DAY_TYPE_CalendarDays(1);

	private int value;

	BV_NOTICE_DAY_TYPE_Enum(int value)
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
		if (value == BV_NOTICE_DAY_TYPE_BusinessDays.ordinal())
			return "Business Days";
		if (value == BV_NOTICE_DAY_TYPE_CalendarDays.ordinal())
			return "Calendar Days";
		return "";
	}
	public static BV_NOTICE_DAY_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= BV_NOTICE_DAY_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
