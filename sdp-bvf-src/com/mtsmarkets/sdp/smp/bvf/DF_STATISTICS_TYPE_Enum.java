package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum DF_STATISTICS_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	Statistics_Hour(0),
	@SerializedName("1")
	Statistics_Quarter(1),
	@SerializedName("2")
	Statistics_Minute(2);

	private int value;

	DF_STATISTICS_TYPE_Enum(int value)
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
		if (value == Statistics_Hour.ordinal())
			return "Hour";
		if (value == Statistics_Quarter.ordinal())
			return "Quarter";
		if (value == Statistics_Minute.ordinal())
			return "Minute";
		return "";
	}
	public static DF_STATISTICS_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= DF_STATISTICS_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
