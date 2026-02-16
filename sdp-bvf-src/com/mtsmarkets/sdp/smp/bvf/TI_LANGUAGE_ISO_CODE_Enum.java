package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_LANGUAGE_ISO_CODE_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_LANGUAGE_ISO_CODE_Italian(0),
	@SerializedName("1")
	TI_LANGUAGE_ISO_CODE_English(1);

	private int value;

	TI_LANGUAGE_ISO_CODE_Enum(int value)
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
		if (value == TI_LANGUAGE_ISO_CODE_Italian.ordinal())
			return "Italian";
		if (value == TI_LANGUAGE_ISO_CODE_English.ordinal())
			return "English";
		return "";
	}
	public static TI_LANGUAGE_ISO_CODE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_LANGUAGE_ISO_CODE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
