package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_CALCULATION_FIELD_DIRECTION_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_CALCULATION_FIELD_DIRECTION_In(0),
	@SerializedName("1")
	TI_CALCULATION_FIELD_DIRECTION_InOut(1);

	private int value;

	TI_CALCULATION_FIELD_DIRECTION_Enum(int value)
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
		if (value == TI_CALCULATION_FIELD_DIRECTION_In.ordinal())
			return "In";
		if (value == TI_CALCULATION_FIELD_DIRECTION_InOut.ordinal())
			return "Out";
		return "";
	}
	public static TI_CALCULATION_FIELD_DIRECTION_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_CALCULATION_FIELD_DIRECTION_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
