package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_EXCEPTION_DATE_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_EXCEPTION_DATE_TYPE_None(0),
	@SerializedName("1")
	TI_EXCEPTION_DATE_TYPE_BlackOut(1),
	@SerializedName("2")
	TI_EXCEPTION_DATE_TYPE_ExDividend(2),
	@SerializedName("3")
	TI_EXCEPTION_DATE_TYPE_AIT(3);

	private int value;

	TI_EXCEPTION_DATE_TYPE_Enum(int value)
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
		if (value == TI_EXCEPTION_DATE_TYPE_None.ordinal())
			return "None";
		if (value == TI_EXCEPTION_DATE_TYPE_BlackOut.ordinal())
			return "BlackOut";
		if (value == TI_EXCEPTION_DATE_TYPE_ExDividend.ordinal())
			return "ExDividend";
		if (value == TI_EXCEPTION_DATE_TYPE_AIT.ordinal())
			return "AIT";
		return "";
	}
	public static TI_EXCEPTION_DATE_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_EXCEPTION_DATE_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
