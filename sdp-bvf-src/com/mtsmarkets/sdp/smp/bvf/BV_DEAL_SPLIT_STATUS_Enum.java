package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum BV_DEAL_SPLIT_STATUS_Enum implements SMPEnum
{
	@SerializedName("0")
	BV_DEAL_SPLIT_STATUS_WaitingForSplit(0),
	@SerializedName("1")
	BV_DEAL_SPLIT_STATUS_Splitted(1),
	@SerializedName("2")
	BV_DEAL_SPLIT_STATUS_None(2);

	private int value;

	BV_DEAL_SPLIT_STATUS_Enum(int value)
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
		if (value == BV_DEAL_SPLIT_STATUS_WaitingForSplit.ordinal())
			return "WaitingForSplit";
		if (value == BV_DEAL_SPLIT_STATUS_Splitted.ordinal())
			return "Splitted";
		if (value == BV_DEAL_SPLIT_STATUS_None.ordinal())
			return "None";
		return "";
	}
	public static BV_DEAL_SPLIT_STATUS_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= BV_DEAL_SPLIT_STATUS_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
