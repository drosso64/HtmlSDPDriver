package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum BV_SHORT_SELLING_INDICATOR_Enum implements SMPEnum
{
	@SerializedName("0")
	BV_SHORT_SELLING_INDICATOR_None(0),
	@SerializedName("1")
	BV_SHORT_SELLING_INDICATOR_SESH(1),
	@SerializedName("2")
	BV_SHORT_SELLING_INDICATOR_SSEX(2),
	@SerializedName("3")
	BV_SHORT_SELLING_INDICATOR_SELL(3),
	@SerializedName("4")
	BV_SHORT_SELLING_INDICATOR_UNDI(4);

	private int value;

	BV_SHORT_SELLING_INDICATOR_Enum(int value)
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
		if (value == BV_SHORT_SELLING_INDICATOR_None.ordinal())
			return "None";
		if (value == BV_SHORT_SELLING_INDICATOR_SESH.ordinal())
			return "Short sale with no exemption";
		if (value == BV_SHORT_SELLING_INDICATOR_SSEX.ordinal())
			return "Short sale with exemption";
		if (value == BV_SHORT_SELLING_INDICATOR_SELL.ordinal())
			return "No short sale";
		if (value == BV_SHORT_SELLING_INDICATOR_UNDI.ordinal())
			return "Information not available";
		return "";
	}
	public static BV_SHORT_SELLING_INDICATOR_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= BV_SHORT_SELLING_INDICATOR_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
