package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_EXPIRY_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_EXPIRY_TYPE_ExFront(0),
	@SerializedName("1")
	TI_EXPIRY_TYPE_Front(1),
	@SerializedName("2")
	TI_EXPIRY_TYPE_Back(2),
	@SerializedName("3")
	TI_EXPIRY_TYPE_NextBack(3);

	private int value;

	TI_EXPIRY_TYPE_Enum(int value)
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
		if (value == TI_EXPIRY_TYPE_ExFront.ordinal())
			return "ExFront";
		if (value == TI_EXPIRY_TYPE_Front.ordinal())
			return "Front";
		if (value == TI_EXPIRY_TYPE_Back.ordinal())
			return "Back";
		if (value == TI_EXPIRY_TYPE_NextBack.ordinal())
			return "NextBack";
		return "";
	}
	public static TI_EXPIRY_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_EXPIRY_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
