package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum BV_CALL_AMOUNT_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	BV_CALL_AMOUNT_TYPE_FullOnly(0),
	@SerializedName("1")
	BV_CALL_AMOUNT_TYPE_FullOrPartialy(1);

	private int value;

	BV_CALL_AMOUNT_TYPE_Enum(int value)
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
		if (value == BV_CALL_AMOUNT_TYPE_FullOnly.ordinal())
			return "Only in full";
		if (value == BV_CALL_AMOUNT_TYPE_FullOrPartialy.ordinal())
			return "Partially or in full";
		return "";
	}
	public static BV_CALL_AMOUNT_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= BV_CALL_AMOUNT_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
