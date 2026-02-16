package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_ALLOCATION_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_ALLOCATION_TYPE_Unspecified(0),
	@SerializedName("1")
	TI_ALLOCATION_TYPE_SingleAccount(1),
	@SerializedName("2")
	TI_ALLOCATION_TYPE_PreAllocation(2);

	private int value;

	TI_ALLOCATION_TYPE_Enum(int value)
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
		if (value == TI_ALLOCATION_TYPE_Unspecified.ordinal())
			return "Unspecified";
		if (value == TI_ALLOCATION_TYPE_SingleAccount.ordinal())
			return "Single Account";
		if (value == TI_ALLOCATION_TYPE_PreAllocation.ordinal())
			return "Pre-Allocation";
		return "";
	}
	public static TI_ALLOCATION_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_ALLOCATION_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
