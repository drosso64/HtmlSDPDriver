package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_DESC_KEY_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_DESC_KEY_TYPE_DuplicateKey(0),
	@SerializedName("1")
	TI_DESC_KEY_TYPE_UniqueKey(1);

	private int value;

	TI_DESC_KEY_TYPE_Enum(int value)
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
		if (value == TI_DESC_KEY_TYPE_DuplicateKey.ordinal())
			return "DuplicateKey";
		if (value == TI_DESC_KEY_TYPE_UniqueKey.ordinal())
			return "UniqueKey";
		return "";
	}
	public static TI_DESC_KEY_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_DESC_KEY_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
