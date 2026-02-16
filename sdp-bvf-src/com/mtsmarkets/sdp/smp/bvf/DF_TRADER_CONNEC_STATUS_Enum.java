package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum DF_TRADER_CONNEC_STATUS_Enum implements SMPEnum
{
	@SerializedName("0")
	DF_TRADER_CONNEC_STATUS_LogOn(0),
	@SerializedName("1")
	DF_TRADER_CONNEC_STATUS_LogOff(1);

	private int value;

	DF_TRADER_CONNEC_STATUS_Enum(int value)
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
		if (value == DF_TRADER_CONNEC_STATUS_LogOn.ordinal())
			return "LogOn";
		if (value == DF_TRADER_CONNEC_STATUS_LogOff.ordinal())
			return "LogOff";
		return "";
	}
	public static DF_TRADER_CONNEC_STATUS_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= DF_TRADER_CONNEC_STATUS_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
