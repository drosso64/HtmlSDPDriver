package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_TRADER_TRADING_STATUS_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_TRADER_TRADING_STATUS_LogOff(0),
	@SerializedName("1")
	TI_TRADER_TRADING_STATUS_Active(1),
	@SerializedName("2")
	TI_TRADER_TRADING_STATUS_Suspended(2),
	@SerializedName("3")
	TI_TRADER_TRADING_STATUS_FastMarket(3);

	private int value;

	TI_TRADER_TRADING_STATUS_Enum(int value)
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
		if (value == TI_TRADER_TRADING_STATUS_LogOff.ordinal())
			return "LogOff";
		if (value == TI_TRADER_TRADING_STATUS_Active.ordinal())
			return "Active";
		if (value == TI_TRADER_TRADING_STATUS_Suspended.ordinal())
			return "Suspended";
		if (value == TI_TRADER_TRADING_STATUS_FastMarket.ordinal())
			return "FastMarket";
		return "";
	}
	public static TI_TRADER_TRADING_STATUS_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_TRADER_TRADING_STATUS_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
