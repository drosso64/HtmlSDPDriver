package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_CREDIT_PROFILE_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_CREDIT_PROFILE_Welcome(0),
	@SerializedName("1")
	TI_CREDIT_PROFILE_Automatic(1),
	@SerializedName("2")
	TI_CREDIT_PROFILE_Unwelcome(2);

	private int value;

	TI_CREDIT_PROFILE_Enum(int value)
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
		if (value == TI_CREDIT_PROFILE_Welcome.ordinal())
			return "Welcome";
		if (value == TI_CREDIT_PROFILE_Automatic.ordinal())
			return "Automatic";
		if (value == TI_CREDIT_PROFILE_Unwelcome.ordinal())
			return "Unwelcome";
		return "";
	}
	public static TI_CREDIT_PROFILE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_CREDIT_PROFILE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
