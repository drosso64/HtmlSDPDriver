package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_DAY_COUNT_CONVENTION_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_DAY_COUNT_CONVENTION_TYPE_ZeroCoupon(0),
	@SerializedName("1")
	TI_DAY_COUNT_CONVENTION_TYPE_ActAct(1),
	@SerializedName("2")
	TI_DAY_COUNT_CONVENTION_TYPE_Act365(2),
	@SerializedName("3")
	TI_DAY_COUNT_CONVENTION_TYPE_Act360(3),
	@SerializedName("4")
	TI_DAY_COUNT_CONVENTION_TYPE_Act366(4),
	@SerializedName("5")
	TI_DAY_COUNT_CONVENTION_TYPE_30_360(5),
	@SerializedName("6")
	TI_DAY_COUNT_CONVENTION_TYPE_30E1_360(6),
	@SerializedName("7")
	TI_DAY_COUNT_CONVENTION_TYPE_30E_360(7);

	private int value;

	TI_DAY_COUNT_CONVENTION_TYPE_Enum(int value)
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
		if (value == TI_DAY_COUNT_CONVENTION_TYPE_ZeroCoupon.ordinal())
			return "ZeroCoupon (None)";
		if (value == TI_DAY_COUNT_CONVENTION_TYPE_ActAct.ordinal())
			return "ActAct";
		if (value == TI_DAY_COUNT_CONVENTION_TYPE_Act365.ordinal())
			return "Act365";
		if (value == TI_DAY_COUNT_CONVENTION_TYPE_Act360.ordinal())
			return "Act360";
		if (value == TI_DAY_COUNT_CONVENTION_TYPE_Act366.ordinal())
			return "Act366";
		if (value == TI_DAY_COUNT_CONVENTION_TYPE_30_360.ordinal())
			return "30/360";
		if (value == TI_DAY_COUNT_CONVENTION_TYPE_30E1_360.ordinal())
			return "30E+1/360";
		if (value == TI_DAY_COUNT_CONVENTION_TYPE_30E_360.ordinal())
			return "30E/360";
		return "";
	}
	public static TI_DAY_COUNT_CONVENTION_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_DAY_COUNT_CONVENTION_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
