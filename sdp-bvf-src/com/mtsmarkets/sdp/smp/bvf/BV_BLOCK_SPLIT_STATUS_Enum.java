package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum BV_BLOCK_SPLIT_STATUS_Enum implements SMPEnum
{
	@SerializedName("0")
	BV_BLOCK_SPLIT_STATUS_Valid(0),
	@SerializedName("1")
	BV_BLOCK_SPLIT_STATUS_Invalid(1);

	private int value;

	BV_BLOCK_SPLIT_STATUS_Enum(int value)
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
		if (value == BV_BLOCK_SPLIT_STATUS_Valid.ordinal())
			return "Valid";
		if (value == BV_BLOCK_SPLIT_STATUS_Invalid.ordinal())
			return "Invalid";
		return "";
	}
	public static BV_BLOCK_SPLIT_STATUS_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= BV_BLOCK_SPLIT_STATUS_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
