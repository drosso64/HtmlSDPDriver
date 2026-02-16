package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_RELATION_LEVEL_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_RELATION_LEVEL_Member(0),
	@SerializedName("1")
	TI_RELATION_LEVEL_Trader(1);

	private int value;

	TI_RELATION_LEVEL_Enum(int value)
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
		if (value == TI_RELATION_LEVEL_Member.ordinal())
			return "Member";
		if (value == TI_RELATION_LEVEL_Trader.ordinal())
			return "Trader";
		return "";
	}
	public static TI_RELATION_LEVEL_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_RELATION_LEVEL_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
