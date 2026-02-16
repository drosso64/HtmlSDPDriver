package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum BV_FIX_ENABLE_ALLOCATION_REPORT_Enum implements SMPEnum
{
	@SerializedName("0")
	BV_FIX_ENABLE_ALLOCATION_REPORT_No(0),
	@SerializedName("1")
	BV_FIX_ENABLE_ALLOCATION_REPORT_Solicited(1),
	@SerializedName("2")
	BV_FIX_ENABLE_ALLOCATION_REPORT_Unsolicited(2),
	@SerializedName("3")
	BV_FIX_ENABLE_ALLOCATION_REPORT_Both(3);

	private int value;

	BV_FIX_ENABLE_ALLOCATION_REPORT_Enum(int value)
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
		if (value == BV_FIX_ENABLE_ALLOCATION_REPORT_No.ordinal())
			return "No";
		if (value == BV_FIX_ENABLE_ALLOCATION_REPORT_Solicited.ordinal())
			return "Solicited";
		if (value == BV_FIX_ENABLE_ALLOCATION_REPORT_Unsolicited.ordinal())
			return "Unsolicited";
		if (value == BV_FIX_ENABLE_ALLOCATION_REPORT_Both.ordinal())
			return "Both";
		return "";
	}
	public static BV_FIX_ENABLE_ALLOCATION_REPORT_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= BV_FIX_ENABLE_ALLOCATION_REPORT_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
