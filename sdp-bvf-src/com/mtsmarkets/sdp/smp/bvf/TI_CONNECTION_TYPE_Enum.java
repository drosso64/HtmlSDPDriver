package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_CONNECTION_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_CONNECTION_TYPE_LeasedLines(0),
	@SerializedName("1")
	TI_CONNECTION_TYPE_Internet(1),
	@SerializedName("2")
	TI_CONNECTION_TYPE_Both(2);

	private int value;

	TI_CONNECTION_TYPE_Enum(int value)
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
		if (value == TI_CONNECTION_TYPE_LeasedLines.ordinal())
			return "Leased Lines";
		if (value == TI_CONNECTION_TYPE_Internet.ordinal())
			return "Internet";
		if (value == TI_CONNECTION_TYPE_Both.ordinal())
			return "Both";
		return "";
	}
	public static TI_CONNECTION_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_CONNECTION_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
