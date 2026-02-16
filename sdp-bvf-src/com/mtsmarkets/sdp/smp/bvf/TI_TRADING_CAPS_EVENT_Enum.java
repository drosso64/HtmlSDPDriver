package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_TRADING_CAPS_EVENT_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_TRADING_CAPS_EVENT_Enable(0),
	@SerializedName("1")
	TI_TRADING_CAPS_EVENT_Disable(1),
	@SerializedName("2")
	TI_TRADING_CAPS_EVENT_Delete(2);

	private int value;

	TI_TRADING_CAPS_EVENT_Enum(int value)
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
		if (value == TI_TRADING_CAPS_EVENT_Enable.ordinal())
			return "Enable";
		if (value == TI_TRADING_CAPS_EVENT_Disable.ordinal())
			return "Disable";
		if (value == TI_TRADING_CAPS_EVENT_Delete.ordinal())
			return "Delete";
		return "";
	}
	public static TI_TRADING_CAPS_EVENT_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_TRADING_CAPS_EVENT_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
