package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_ACCESS_RIGHT_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_ACCESS_RIGHT_None(0),
	@SerializedName("1")
	TI_ACCESS_RIGHT_Read(1),
	@SerializedName("2")
	TI_ACCESS_RIGHT_ReadWrite(2);

	private int value;

	TI_ACCESS_RIGHT_Enum(int value)
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
		if (value == TI_ACCESS_RIGHT_None.ordinal())
			return "None";
		if (value == TI_ACCESS_RIGHT_Read.ordinal())
			return "Read";
		if (value == TI_ACCESS_RIGHT_ReadWrite.ordinal())
			return "ReadWrite";
		return "";
	}
	public static TI_ACCESS_RIGHT_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_ACCESS_RIGHT_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
