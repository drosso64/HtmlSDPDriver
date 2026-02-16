package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_CALCULATION_FIELD_DOMAIN_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_CALCULATION_FIELD_DOMAIN_Long(0),
	@SerializedName("1")
	TI_CALCULATION_FIELD_DOMAIN_Double(1),
	@SerializedName("2")
	TI_CALCULATION_FIELD_DOMAIN_String(2),
	@SerializedName("3")
	TI_CALCULATION_FIELD_DOMAIN_Date(3);

	private int value;

	TI_CALCULATION_FIELD_DOMAIN_Enum(int value)
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
		if (value == TI_CALCULATION_FIELD_DOMAIN_Long.ordinal())
			return "Long";
		if (value == TI_CALCULATION_FIELD_DOMAIN_Double.ordinal())
			return "Double";
		if (value == TI_CALCULATION_FIELD_DOMAIN_String.ordinal())
			return "String";
		if (value == TI_CALCULATION_FIELD_DOMAIN_Date.ordinal())
			return "Date";
		return "";
	}
	public static TI_CALCULATION_FIELD_DOMAIN_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_CALCULATION_FIELD_DOMAIN_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
