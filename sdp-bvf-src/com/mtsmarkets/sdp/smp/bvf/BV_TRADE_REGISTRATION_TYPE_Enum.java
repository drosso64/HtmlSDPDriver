package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum BV_TRADE_REGISTRATION_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	BV_TRADE_REGISTRATION_TYPE_Bond(0),
	@SerializedName("1")
	BV_TRADE_REGISTRATION_TYPE_Basis(1);

	private int value;

	BV_TRADE_REGISTRATION_TYPE_Enum(int value)
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
		if (value == BV_TRADE_REGISTRATION_TYPE_Bond.ordinal())
			return "Bond";
		if (value == BV_TRADE_REGISTRATION_TYPE_Basis.ordinal())
			return "Basis";
		return "";
	}
	public static BV_TRADE_REGISTRATION_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= BV_TRADE_REGISTRATION_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
