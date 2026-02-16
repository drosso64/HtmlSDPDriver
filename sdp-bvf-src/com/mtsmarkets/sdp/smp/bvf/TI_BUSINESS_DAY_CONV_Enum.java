package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_BUSINESS_DAY_CONV_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_BUSINESS_DAY_CONV_None(0),
	@SerializedName("1")
	TI_BUSINESS_DAY_CONV_Following(1),
	@SerializedName("2")
	TI_BUSINESS_DAY_CONV_ModifiedFollowing(2),
	@SerializedName("3")
	TI_BUSINESS_DAY_CONV_Preceding(3);

	private int value;

	TI_BUSINESS_DAY_CONV_Enum(int value)
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
		if (value == TI_BUSINESS_DAY_CONV_None.ordinal())
			return "None";
		if (value == TI_BUSINESS_DAY_CONV_Following.ordinal())
			return "Following";
		if (value == TI_BUSINESS_DAY_CONV_ModifiedFollowing.ordinal())
			return "Modified Following";
		if (value == TI_BUSINESS_DAY_CONV_Preceding.ordinal())
			return "Preceding";
		return "";
	}
	public static TI_BUSINESS_DAY_CONV_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_BUSINESS_DAY_CONV_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
