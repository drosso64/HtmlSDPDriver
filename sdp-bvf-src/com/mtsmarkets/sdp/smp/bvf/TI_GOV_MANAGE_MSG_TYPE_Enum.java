package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_GOV_MANAGE_MSG_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_GOV_MANAGE_MSG_TYPE_Deal(0),
	@SerializedName("1")
	TI_GOV_MANAGE_MSG_TYPE_Trade(1),
	@SerializedName("2")
	TI_GOV_MANAGE_MSG_TYPE_TradeFuture(2);

	private int value;

	TI_GOV_MANAGE_MSG_TYPE_Enum(int value)
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
		if (value == TI_GOV_MANAGE_MSG_TYPE_Deal.ordinal())
			return "Deal";
		if (value == TI_GOV_MANAGE_MSG_TYPE_Trade.ordinal())
			return "Trade";
		if (value == TI_GOV_MANAGE_MSG_TYPE_TradeFuture.ordinal())
			return "Trade Future";
		return "";
	}
	public static TI_GOV_MANAGE_MSG_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_GOV_MANAGE_MSG_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
