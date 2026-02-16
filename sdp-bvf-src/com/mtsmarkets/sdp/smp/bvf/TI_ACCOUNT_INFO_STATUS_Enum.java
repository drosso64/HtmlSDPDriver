package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_ACCOUNT_INFO_STATUS_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_ACCOUNT_INFO_STATUS_Accepted(0),
	@SerializedName("1")
	TI_ACCOUNT_INFO_STATUS_Invalid(1),
	@SerializedName("2")
	TI_ACCOUNT_INFO_STATUS_Refused(2);

	private int value;

	TI_ACCOUNT_INFO_STATUS_Enum(int value)
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
		if (value == TI_ACCOUNT_INFO_STATUS_Accepted.ordinal())
			return "Accepted";
		if (value == TI_ACCOUNT_INFO_STATUS_Invalid.ordinal())
			return "Invalid";
		if (value == TI_ACCOUNT_INFO_STATUS_Refused.ordinal())
			return "Refused";
		return "";
	}
	public static TI_ACCOUNT_INFO_STATUS_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_ACCOUNT_INFO_STATUS_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
