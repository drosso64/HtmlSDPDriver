package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_YIELD_FORMULA_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_YIELD_FORMULA_TYPE_None(0),
	@SerializedName("1")
	TI_YIELD_FORMULA_TYPE_ZCSimple(1),
	@SerializedName("2")
	TI_YIELD_FORMULA_TYPE_ZCCompound(2),
	@SerializedName("3")
	TI_YIELD_FORMULA_TYPE_FixedRate(3),
	@SerializedName("4")
	TI_YIELD_FORMULA_TYPE_OneYearToMaturity(4),
	@SerializedName("5")
	TI_YIELD_FORMULA_TYPE_FinFormulae(5);

	private int value;

	TI_YIELD_FORMULA_TYPE_Enum(int value)
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
		if (value == TI_YIELD_FORMULA_TYPE_None.ordinal())
			return "None";
		if (value == TI_YIELD_FORMULA_TYPE_ZCSimple.ordinal())
			return "ZCSimple";
		if (value == TI_YIELD_FORMULA_TYPE_ZCCompound.ordinal())
			return "ZCCompound";
		if (value == TI_YIELD_FORMULA_TYPE_FixedRate.ordinal())
			return "Fixed Rate";
		if (value == TI_YIELD_FORMULA_TYPE_OneYearToMaturity.ordinal())
			return "One Year to Maturity";
		if (value == TI_YIELD_FORMULA_TYPE_FinFormulae.ordinal())
			return "Financial Formulae";
		return "";
	}
	public static TI_YIELD_FORMULA_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_YIELD_FORMULA_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
