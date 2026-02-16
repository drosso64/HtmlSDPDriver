package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum BV_ALGO_INFO_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	BV_ALGO_INFO_TYPE_None(0),
	@SerializedName("1")
	BV_ALGO_INFO_TYPE_Algo(1),
	@SerializedName("2")
	BV_ALGO_INFO_TYPE_NoAlgo(2);

	private int value;

	BV_ALGO_INFO_TYPE_Enum(int value)
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
		if (value == BV_ALGO_INFO_TYPE_None.ordinal())
			return "None";
		if (value == BV_ALGO_INFO_TYPE_Algo.ordinal())
			return "Algo";
		if (value == BV_ALGO_INFO_TYPE_NoAlgo.ordinal())
			return "No Algo";
		return "";
	}
	public static BV_ALGO_INFO_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= BV_ALGO_INFO_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
