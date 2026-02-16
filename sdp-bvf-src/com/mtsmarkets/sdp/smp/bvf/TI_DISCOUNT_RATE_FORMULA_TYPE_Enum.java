package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_DISCOUNT_RATE_FORMULA_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_DISCOUNT_RATE_FORMULA_TYPE_None(0),
	@SerializedName("1")
	TI_DISCOUNT_RATE_FORMULA_TYPE_FinancialFormula(1);

	private int value;

	TI_DISCOUNT_RATE_FORMULA_TYPE_Enum(int value)
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
		if (value == TI_DISCOUNT_RATE_FORMULA_TYPE_None.ordinal())
			return "None";
		if (value == TI_DISCOUNT_RATE_FORMULA_TYPE_FinancialFormula.ordinal())
			return "Financial Formula";
		return "";
	}
	public static TI_DISCOUNT_RATE_FORMULA_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_DISCOUNT_RATE_FORMULA_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
