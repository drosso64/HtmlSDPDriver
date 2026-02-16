package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_FUNCTION_ACTION_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_FUNCTION_ACTION_None(0),
	@SerializedName("1")
	TI_FUNCTION_ACTION_Read(1),
	@SerializedName("2")
	TI_FUNCTION_ACTION_ReadWrite(2);

	private int value;

	TI_FUNCTION_ACTION_Enum(int value)
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
		if (value == TI_FUNCTION_ACTION_None.ordinal())
			return "None";
		if (value == TI_FUNCTION_ACTION_Read.ordinal())
			return "Read";
		if (value == TI_FUNCTION_ACTION_ReadWrite.ordinal())
			return "Read and Write";
		return "";
	}
	public static TI_FUNCTION_ACTION_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_FUNCTION_ACTION_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
