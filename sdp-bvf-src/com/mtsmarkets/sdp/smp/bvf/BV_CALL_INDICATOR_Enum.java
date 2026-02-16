package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum BV_CALL_INDICATOR_Enum implements SMPEnum
{
	@SerializedName("0")
	BV_CALL_INDICATOR_Call(0),
	@SerializedName("1")
	BV_CALL_INDICATOR_MWC(1);

	private int value;

	BV_CALL_INDICATOR_Enum(int value)
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
		if (value == BV_CALL_INDICATOR_Call.ordinal())
			return "Call";
		if (value == BV_CALL_INDICATOR_MWC.ordinal())
			return "MWC";
		return "";
	}
	public static BV_CALL_INDICATOR_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= BV_CALL_INDICATOR_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
