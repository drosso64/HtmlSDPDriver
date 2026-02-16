package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum BV_SETTL_STATUS_Enum implements SMPEnum
{
	@SerializedName("0")
	BV_SETTL_STATUS_Waiting(0),
	@SerializedName("1")
	BV_SETTL_STATUS_Undefined(1),
	@SerializedName("2")
	BV_SETTL_STATUS_Defined(2),
	@SerializedName("3")
	BV_SETTL_STATUS_Manual(3),
	@SerializedName("4")
	BV_SETTL_STATUS_Error(4),
	@SerializedName("5")
	BV_SETTL_STATUS_CancelledFromSettlement(5);

	private int value;

	BV_SETTL_STATUS_Enum(int value)
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
		if (value == BV_SETTL_STATUS_Waiting.ordinal())
			return "Waiting";
		if (value == BV_SETTL_STATUS_Undefined.ordinal())
			return "Undefined";
		if (value == BV_SETTL_STATUS_Defined.ordinal())
			return "Defined";
		if (value == BV_SETTL_STATUS_Manual.ordinal())
			return "Manual";
		if (value == BV_SETTL_STATUS_Error.ordinal())
			return "Error";
		if (value == BV_SETTL_STATUS_CancelledFromSettlement.ordinal())
			return "Cancelled from Settlement";
		return "";
	}
	public static BV_SETTL_STATUS_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= BV_SETTL_STATUS_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
