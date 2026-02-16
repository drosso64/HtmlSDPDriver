package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum BV_ANALYTIC_Enum implements SMPEnum
{
	@SerializedName("0")
	BV_ANALYTIC_ISpread(0),
	@SerializedName("1")
	BV_ANALYTIC_ZSpread(1),
	@SerializedName("2")
	BV_ANALYTIC_GSpread(2),
	@SerializedName("3")
	BV_ANALYTIC_OISSpread(3),
	@SerializedName("4")
	BV_ANALYTIC_ASWSpread(4),
	@SerializedName("5")
	BV_ANALYTIC_CDSSpread(5),
	@SerializedName("6")
	BV_ANALYTIC_CDSBasis(6);

	private int value;

	BV_ANALYTIC_Enum(int value)
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
		if (value == BV_ANALYTIC_ISpread.ordinal())
			return "I-Spread";
		if (value == BV_ANALYTIC_ZSpread.ordinal())
			return "Z-Spread";
		if (value == BV_ANALYTIC_GSpread.ordinal())
			return "G-Spread";
		if (value == BV_ANALYTIC_OISSpread.ordinal())
			return "OIS-Spread";
		if (value == BV_ANALYTIC_ASWSpread.ordinal())
			return "ASW-Spread";
		if (value == BV_ANALYTIC_CDSSpread.ordinal())
			return "CDS-Spread";
		if (value == BV_ANALYTIC_CDSBasis.ordinal())
			return "CDS-Basis";
		return "";
	}
	public static BV_ANALYTIC_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= BV_ANALYTIC_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
