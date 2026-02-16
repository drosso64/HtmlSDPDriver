package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum BV_PORTFOLIO_RFCQ_CLOSING_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	BV_PORTFOLIO_RFCQ_CLOSING_TYPE_None(0),
	@SerializedName("1")
	BV_PORTFOLIO_RFCQ_CLOSING_TYPE_MOCClosingPrice(1),
	@SerializedName("2")
	BV_PORTFOLIO_RFCQ_CLOSING_TYPE_MOCDealerPrice(2),
	@SerializedName("3")
	BV_PORTFOLIO_RFCQ_CLOSING_TYPE_Other(3);

	private int value;

	BV_PORTFOLIO_RFCQ_CLOSING_TYPE_Enum(int value)
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
		if (value == BV_PORTFOLIO_RFCQ_CLOSING_TYPE_None.ordinal())
			return "None";
		if (value == BV_PORTFOLIO_RFCQ_CLOSING_TYPE_MOCClosingPrice.ordinal())
			return "Closing Price (MOC)";
		if (value == BV_PORTFOLIO_RFCQ_CLOSING_TYPE_MOCDealerPrice.ordinal())
			return "Dealer Price (MOC) – for Future Use";
		if (value == BV_PORTFOLIO_RFCQ_CLOSING_TYPE_Other.ordinal())
			return "Other (for Future Use)";
		return "";
	}
	public static BV_PORTFOLIO_RFCQ_CLOSING_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= BV_PORTFOLIO_RFCQ_CLOSING_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
