package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum BV_INSTRUMENT_GROUP_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	BV_INSTRUMENT_GROUP_TYPE_InfoFilter(0),
	@SerializedName("1")
	BV_INSTRUMENT_GROUP_TYPE_ICClassification(1),
	@SerializedName("2")
	BV_INSTRUMENT_GROUP_TYPE_PublicInfoFilter(2),
	@SerializedName("3")
	BV_INSTRUMENT_GROUP_TYPE_FirmInfoFilter(3),
	@SerializedName("4")
	BV_INSTRUMENT_GROUP_TYPE_IndicativeInfoFilter(4),
	@SerializedName("5")
	BV_INSTRUMENT_GROUP_TYPE_InventoryInfoFilter(5);

	private int value;

	BV_INSTRUMENT_GROUP_TYPE_Enum(int value)
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
		if (value == BV_INSTRUMENT_GROUP_TYPE_InfoFilter.ordinal())
			return "Info Filter";
		if (value == BV_INSTRUMENT_GROUP_TYPE_ICClassification.ordinal())
			return "IC Classification";
		if (value == BV_INSTRUMENT_GROUP_TYPE_PublicInfoFilter.ordinal())
			return "Public Info Filter";
		if (value == BV_INSTRUMENT_GROUP_TYPE_FirmInfoFilter.ordinal())
			return "Firm Info FIlter";
		if (value == BV_INSTRUMENT_GROUP_TYPE_IndicativeInfoFilter.ordinal())
			return "Indicative Info Filter";
		if (value == BV_INSTRUMENT_GROUP_TYPE_InventoryInfoFilter.ordinal())
			return "Inventory Info Filter";
		return "";
	}
	public static BV_INSTRUMENT_GROUP_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= BV_INSTRUMENT_GROUP_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
