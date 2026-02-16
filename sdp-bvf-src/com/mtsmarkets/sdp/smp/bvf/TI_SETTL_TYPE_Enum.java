package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_SETTL_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_SETTL_TYPE_Manual(0),
	@SerializedName("1")
	TI_SETTL_TYPE_PSTA(1),
	@SerializedName("2")
	TI_SETTL_TYPE_RRG(2),
	@SerializedName("3")
	TI_SETTL_TYPE_OnlyReport(3),
	@SerializedName("4")
	TI_SETTL_TYPE_Swapswire_Auto(4),
	@SerializedName("5")
	TI_SETTL_TYPE_Swapswire_Manual(5);

	private int value;

	TI_SETTL_TYPE_Enum(int value)
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
		if (value == TI_SETTL_TYPE_Manual.ordinal())
			return "Manual";
		if (value == TI_SETTL_TYPE_PSTA.ordinal())
			return "PSTA";
		if (value == TI_SETTL_TYPE_RRG.ordinal())
			return "RRG";
		if (value == TI_SETTL_TYPE_OnlyReport.ordinal())
			return "OnlyReport";
		if (value == TI_SETTL_TYPE_Swapswire_Auto.ordinal())
			return "Swapswire Automatic";
		if (value == TI_SETTL_TYPE_Swapswire_Manual.ordinal())
			return "Swapswire Manual";
		return "";
	}
	public static TI_SETTL_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_SETTL_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
