package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_TRADING_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_TRADING_TYPE_CleanPrice(0),
	@SerializedName("1")
	TI_TRADING_TYPE_Yield(1),
	@SerializedName("2")
	TI_TRADING_TYPE_DirtyPrice(2),
	@SerializedName("3")
	TI_TRADING_TYPE_Price32(3),
	@SerializedName("4")
	TI_TRADING_TYPE_YieldDiff(4),
	@SerializedName("5")
	TI_TRADING_TYPE_PriceDiff(5),
	@SerializedName("6")
	TI_TRADING_TYPE_Rate(6),
	@SerializedName("7")
	TI_TRADING_TYPE_RateSpread(7),
	@SerializedName("8")
	TI_TRADING_TYPE_BasisPoint(8),
	@SerializedName("9")
	TI_TRADING_TYPE_BreakEvenSpread(9),
	@SerializedName("10")
	TI_TRADING_TYPE_DiscountRate(10),
	@SerializedName("11")
	TI_TRADING_TYPE_Spread(11);

	private int value;

	TI_TRADING_TYPE_Enum(int value)
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
		if (value == TI_TRADING_TYPE_CleanPrice.ordinal())
			return "Clean Price";
		if (value == TI_TRADING_TYPE_Yield.ordinal())
			return "Yield";
		if (value == TI_TRADING_TYPE_DirtyPrice.ordinal())
			return "Dirty Price";
		if (value == TI_TRADING_TYPE_Price32.ordinal())
			return "Price32";
		if (value == TI_TRADING_TYPE_YieldDiff.ordinal())
			return "Yield Diff";
		if (value == TI_TRADING_TYPE_PriceDiff.ordinal())
			return "Price Diff";
		if (value == TI_TRADING_TYPE_Rate.ordinal())
			return "Rate";
		if (value == TI_TRADING_TYPE_RateSpread.ordinal())
			return "Rate Spread";
		if (value == TI_TRADING_TYPE_BasisPoint.ordinal())
			return "Basis Point";
		if (value == TI_TRADING_TYPE_BreakEvenSpread.ordinal())
			return "Break Even Spread";
		if (value == TI_TRADING_TYPE_DiscountRate.ordinal())
			return "Discount Rate";
		if (value == TI_TRADING_TYPE_Spread.ordinal())
			return "Spread";
		return "";
	}
	public static TI_TRADING_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_TRADING_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
