package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_CALCULATION_FIELD_BUSINESS_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_CALCULATION_FIELD_BUSINESS_TYPE_FinInstr(0),
	@SerializedName("1")
	TI_CALCULATION_FIELD_BUSINESS_TYPE_TrdInstr(1),
	@SerializedName("2")
	TI_CALCULATION_FIELD_BUSINESS_TYPE_Price(2),
	@SerializedName("3")
	TI_CALCULATION_FIELD_BUSINESS_TYPE_Rate(3),
	@SerializedName("4")
	TI_CALCULATION_FIELD_BUSINESS_TYPE_Date(4);

	private int value;

	TI_CALCULATION_FIELD_BUSINESS_TYPE_Enum(int value)
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
		if (value == TI_CALCULATION_FIELD_BUSINESS_TYPE_FinInstr.ordinal())
			return "Financial Instrument";
		if (value == TI_CALCULATION_FIELD_BUSINESS_TYPE_TrdInstr.ordinal())
			return "Tradable Instrument";
		if (value == TI_CALCULATION_FIELD_BUSINESS_TYPE_Price.ordinal())
			return "Price";
		if (value == TI_CALCULATION_FIELD_BUSINESS_TYPE_Rate.ordinal())
			return "Rate";
		if (value == TI_CALCULATION_FIELD_BUSINESS_TYPE_Date.ordinal())
			return "Date";
		return "";
	}
	public static TI_CALCULATION_FIELD_BUSINESS_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_CALCULATION_FIELD_BUSINESS_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
