package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_LAST_DEAL_VERB_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_LAST_DEAL_VERB_Buy(0),
	@SerializedName("1")
	TI_LAST_DEAL_VERB_Sell(1),
	@SerializedName("2")
	TI_LAST_DEAL_VERB_None(2);

	private int value;

	TI_LAST_DEAL_VERB_Enum(int value)
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
		if (value == TI_LAST_DEAL_VERB_Buy.ordinal())
			return "Buy";
		if (value == TI_LAST_DEAL_VERB_Sell.ordinal())
			return "Sell";
		if (value == TI_LAST_DEAL_VERB_None.ordinal())
			return "None";
		return "";
	}
	public static TI_LAST_DEAL_VERB_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_LAST_DEAL_VERB_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
