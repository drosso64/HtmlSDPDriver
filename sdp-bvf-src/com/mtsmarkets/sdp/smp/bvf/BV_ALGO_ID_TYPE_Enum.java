package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum BV_ALGO_ID_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	BV_ALGO_ID_TYPE_ID(0),
	@SerializedName("1")
	BV_ALGO_ID_TYPE_OE(1),
	@SerializedName("2")
	BV_ALGO_ID_TYPE_IDOE(2);

	private int value;

	BV_ALGO_ID_TYPE_Enum(int value)
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
		if (value == BV_ALGO_ID_TYPE_ID.ordinal())
			return "Investment Decision";
		if (value == BV_ALGO_ID_TYPE_OE.ordinal())
			return "Order Execution";
		if (value == BV_ALGO_ID_TYPE_IDOE.ordinal())
			return "Investment Decision / Order Execution";
		return "";
	}
	public static BV_ALGO_ID_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= BV_ALGO_ID_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
