package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum BV_YIELD_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	BV_YIELD_TYPE_None(0),
	@SerializedName("1")
	BV_YIELD_TYPE_Call(1),
	@SerializedName("2")
	BV_YIELD_TYPE_Maturity(2),
	@SerializedName("3")
	BV_YIELD_TYPE_Put(3),
	@SerializedName("4")
	BV_YIELD_TYPE_Worst(4);

	private int value;

	BV_YIELD_TYPE_Enum(int value)
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
		if (value == BV_YIELD_TYPE_None.ordinal())
			return "None";
		if (value == BV_YIELD_TYPE_Call.ordinal())
			return "Call";
		if (value == BV_YIELD_TYPE_Maturity.ordinal())
			return "Maturity";
		if (value == BV_YIELD_TYPE_Put.ordinal())
			return "Put";
		if (value == BV_YIELD_TYPE_Worst.ordinal())
			return "Worst";
		return "";
	}
	public static BV_YIELD_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= BV_YIELD_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
