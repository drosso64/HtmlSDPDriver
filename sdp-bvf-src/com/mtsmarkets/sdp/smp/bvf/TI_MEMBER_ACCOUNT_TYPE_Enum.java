package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_MEMBER_ACCOUNT_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_MEMBER_ACCOUNT_TYPE_None(0),
	@SerializedName("1")
	TI_MEMBER_ACCOUNT_TYPE_CAP(1),
	@SerializedName("2")
	TI_MEMBER_ACCOUNT_TYPE_COP(2);

	private int value;

	TI_MEMBER_ACCOUNT_TYPE_Enum(int value)
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
		if (value == TI_MEMBER_ACCOUNT_TYPE_None.ordinal())
			return "None";
		if (value == TI_MEMBER_ACCOUNT_TYPE_CAP.ordinal())
			return "CAP";
		if (value == TI_MEMBER_ACCOUNT_TYPE_COP.ordinal())
			return "COP";
		return "";
	}
	public static TI_MEMBER_ACCOUNT_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_MEMBER_ACCOUNT_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
