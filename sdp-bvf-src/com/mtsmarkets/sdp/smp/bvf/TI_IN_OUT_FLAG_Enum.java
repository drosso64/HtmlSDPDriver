package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_IN_OUT_FLAG_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_IN_OUT_FLAG_Out(0),
	@SerializedName("1")
	TI_IN_OUT_FLAG_In(1);

	private int value;

	TI_IN_OUT_FLAG_Enum(int value)
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
		if (value == TI_IN_OUT_FLAG_Out.ordinal())
			return "Out";
		if (value == TI_IN_OUT_FLAG_In.ordinal())
			return "In";
		return "";
	}
	public static TI_IN_OUT_FLAG_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_IN_OUT_FLAG_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
