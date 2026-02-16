package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum BV_WAIVER_INDICATOR_Enum implements SMPEnum
{
	@SerializedName("0")
	BV_WAIVER_INDICATOR_None(0),
	@SerializedName("1")
	BV_WAIVER_INDICATOR_ILQD(1),
	@SerializedName("2")
	BV_WAIVER_INDICATOR_LRGS(2),
	@SerializedName("3")
	BV_WAIVER_INDICATOR_SIZE(3),
	@SerializedName("4")
	BV_WAIVER_INDICATOR_TPAC(4),
	@SerializedName("5")
	BV_WAIVER_INDICATOR_MTSNFPT(5),
	@SerializedName("6")
	BV_WAIVER_INDICATOR_MTSNFPM(6);

	private int value;

	BV_WAIVER_INDICATOR_Enum(int value)
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
		if (value == BV_WAIVER_INDICATOR_None.ordinal())
			return "None";
		if (value == BV_WAIVER_INDICATOR_ILQD.ordinal())
			return "Illiquid Instrument";
		if (value == BV_WAIVER_INDICATOR_LRGS.ordinal())
			return "Large In Scale";
		if (value == BV_WAIVER_INDICATOR_SIZE.ordinal())
			return "Size Specific to the Instrument";
		if (value == BV_WAIVER_INDICATOR_TPAC.ordinal())
			return "Package Transaction";
		if (value == BV_WAIVER_INDICATOR_MTSNFPT.ordinal())
			return "Pre-Trade Instrument Exemption";
		if (value == BV_WAIVER_INDICATOR_MTSNFPM.ordinal())
			return "Exempted Member";
		return "";
	}
	public static BV_WAIVER_INDICATOR_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= BV_WAIVER_INDICATOR_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
