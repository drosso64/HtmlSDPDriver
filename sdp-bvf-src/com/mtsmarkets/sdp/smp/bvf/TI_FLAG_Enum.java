package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_FLAG_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_FLAG_No(0),
	@SerializedName("1")
	TI_FLAG_Yes(1);

	private int value;

	TI_FLAG_Enum(int value)
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
		if (value == TI_FLAG_No.ordinal())
			return "No";
		if (value == TI_FLAG_Yes.ordinal())
			return "Yes";
		return "";
	}
	public static TI_FLAG_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_FLAG_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
