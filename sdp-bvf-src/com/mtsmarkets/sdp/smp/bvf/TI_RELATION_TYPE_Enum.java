package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_RELATION_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_RELATION_TYPE_Undefined(0),
	@SerializedName("1")
	TI_RELATION_TYPE_Primary(1),
	@SerializedName("2")
	TI_RELATION_TYPE_Secondary(2);

	private int value;

	TI_RELATION_TYPE_Enum(int value)
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
		if (value == TI_RELATION_TYPE_Undefined.ordinal())
			return "Undefined";
		if (value == TI_RELATION_TYPE_Primary.ordinal())
			return "Primary";
		if (value == TI_RELATION_TYPE_Secondary.ordinal())
			return "Secondary";
		return "";
	}
	public static TI_RELATION_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_RELATION_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
