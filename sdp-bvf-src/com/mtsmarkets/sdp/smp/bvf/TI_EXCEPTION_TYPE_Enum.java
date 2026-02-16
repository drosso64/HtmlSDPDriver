package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_EXCEPTION_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_EXCEPTION_TYPE_NoBondsAllowed(0),
	@SerializedName("1")
	TI_EXCEPTION_TYPE_UBondsAllowed(1),
	@SerializedName("2")
	TI_EXCEPTION_TYPE_UBondsNotAllowed(2);

	private int value;

	TI_EXCEPTION_TYPE_Enum(int value)
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
		if (value == TI_EXCEPTION_TYPE_NoBondsAllowed.ordinal())
			return "No Bonds Allowed";
		if (value == TI_EXCEPTION_TYPE_UBondsAllowed.ordinal())
			return "Unseasoned Bonds Allowed";
		if (value == TI_EXCEPTION_TYPE_UBondsNotAllowed.ordinal())
			return "Unseasoned Bonds Not Allowed";
		return "";
	}
	public static TI_EXCEPTION_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_EXCEPTION_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
