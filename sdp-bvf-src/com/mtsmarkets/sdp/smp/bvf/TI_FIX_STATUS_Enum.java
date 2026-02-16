package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_FIX_STATUS_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_FIX_STATUS_Activated(0),
	@SerializedName("1")
	TI_FIX_STATUS_Deleted(1);

	private int value;

	TI_FIX_STATUS_Enum(int value)
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
		if (value == TI_FIX_STATUS_Activated.ordinal())
			return "Activated";
		if (value == TI_FIX_STATUS_Deleted.ordinal())
			return "Deleted";
		return "";
	}
	public static TI_FIX_STATUS_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_FIX_STATUS_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
