package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_LIMIT_SPREAD_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_LIMIT_SPREAD_TYPE_None(0),
	@SerializedName("1")
	TI_LIMIT_SPREAD_TYPE_Proceeds(1),
	@SerializedName("2")
	TI_LIMIT_SPREAD_TYPE_GrossYield(2),
	@SerializedName("3")
	TI_LIMIT_SPREAD_TYPE_RiskWeightedYield(3),
	@SerializedName("4")
	TI_LIMIT_SPREAD_TYPE_ProceedsWeightedYield(4);

	private int value;

	TI_LIMIT_SPREAD_TYPE_Enum(int value)
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
		if (value == TI_LIMIT_SPREAD_TYPE_None.ordinal())
			return "None";
		if (value == TI_LIMIT_SPREAD_TYPE_Proceeds.ordinal())
			return "Proceeds";
		if (value == TI_LIMIT_SPREAD_TYPE_GrossYield.ordinal())
			return "Gross Yield";
		if (value == TI_LIMIT_SPREAD_TYPE_RiskWeightedYield.ordinal())
			return "Risk Weight";
		if (value == TI_LIMIT_SPREAD_TYPE_ProceedsWeightedYield.ordinal())
			return "Proceeds Weight";
		return "";
	}
	public static TI_LIMIT_SPREAD_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_LIMIT_SPREAD_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
