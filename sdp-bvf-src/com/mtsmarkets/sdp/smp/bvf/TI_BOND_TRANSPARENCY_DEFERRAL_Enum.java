package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_BOND_TRANSPARENCY_DEFERRAL_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_BOND_TRANSPARENCY_DEFERRAL_None(0),
	@SerializedName("1")
	TI_BOND_TRANSPARENCY_DEFERRAL_Deferred(1),
	@SerializedName("2")
	TI_BOND_TRANSPARENCY_DEFERRAL_RealTime(2),
	@SerializedName("3")
	TI_BOND_TRANSPARENCY_DEFERRAL_15minutes(3),
	@SerializedName("4")
	TI_BOND_TRANSPARENCY_DEFERRAL_EOD(4),
	@SerializedName("5")
	TI_BOND_TRANSPARENCY_DEFERRAL_T1day(5),
	@SerializedName("6")
	TI_BOND_TRANSPARENCY_DEFERRAL_T2days(6),
	@SerializedName("7")
	TI_BOND_TRANSPARENCY_DEFERRAL_T1week(7),
	@SerializedName("8")
	TI_BOND_TRANSPARENCY_DEFERRAL_T2week(8),
	@SerializedName("9")
	TI_BOND_TRANSPARENCY_DEFERRAL_T4week(9),
	@SerializedName("10")
	TI_BOND_TRANSPARENCY_DEFERRAL_T3months(10);

	private int value;

	TI_BOND_TRANSPARENCY_DEFERRAL_Enum(int value)
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
		if (value == TI_BOND_TRANSPARENCY_DEFERRAL_None.ordinal())
			return "None";
		if (value == TI_BOND_TRANSPARENCY_DEFERRAL_Deferred.ordinal())
			return "Deferred";
		if (value == TI_BOND_TRANSPARENCY_DEFERRAL_RealTime.ordinal())
			return "Real-Time";
		if (value == TI_BOND_TRANSPARENCY_DEFERRAL_15minutes.ordinal())
			return "15 minutes";
		if (value == TI_BOND_TRANSPARENCY_DEFERRAL_EOD.ordinal())
			return "EOD";
		if (value == TI_BOND_TRANSPARENCY_DEFERRAL_T1day.ordinal())
			return "T+1 day";
		if (value == TI_BOND_TRANSPARENCY_DEFERRAL_T2days.ordinal())
			return "T+2 days";
		if (value == TI_BOND_TRANSPARENCY_DEFERRAL_T1week.ordinal())
			return "T+1 week";
		if (value == TI_BOND_TRANSPARENCY_DEFERRAL_T2week.ordinal())
			return "T+2 weeks";
		if (value == TI_BOND_TRANSPARENCY_DEFERRAL_T4week.ordinal())
			return "T+4 weeks";
		if (value == TI_BOND_TRANSPARENCY_DEFERRAL_T3months.ordinal())
			return "T+3 months";
		return "";
	}
	public static TI_BOND_TRANSPARENCY_DEFERRAL_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_BOND_TRANSPARENCY_DEFERRAL_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
