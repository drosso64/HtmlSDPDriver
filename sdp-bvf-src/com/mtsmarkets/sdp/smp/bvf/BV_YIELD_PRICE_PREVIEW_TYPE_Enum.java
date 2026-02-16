package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum BV_YIELD_PRICE_PREVIEW_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	BV_YIELD_PRICE_PREVIEW_TYPE_TradingType(0),
	@SerializedName("1")
	BV_YIELD_PRICE_PREVIEW_TYPE_PriceToCMPDYield(1),
	@SerializedName("2")
	BV_YIELD_PRICE_PREVIEW_TYPE_CMPDYieldToPrice(2),
	@SerializedName("3")
	BV_YIELD_PRICE_PREVIEW_TYPE_PriceToDM(3);

	private int value;

	BV_YIELD_PRICE_PREVIEW_TYPE_Enum(int value)
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
		if (value == BV_YIELD_PRICE_PREVIEW_TYPE_TradingType.ordinal())
			return "According to Trading Type";
		if (value == BV_YIELD_PRICE_PREVIEW_TYPE_PriceToCMPDYield.ordinal())
			return "Price to CMPD Yield";
		if (value == BV_YIELD_PRICE_PREVIEW_TYPE_CMPDYieldToPrice.ordinal())
			return "CMPD Yield to Price";
		if (value == BV_YIELD_PRICE_PREVIEW_TYPE_PriceToDM.ordinal())
			return "Price to Discount Margin";
		return "";
	}
	public static BV_YIELD_PRICE_PREVIEW_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= BV_YIELD_PRICE_PREVIEW_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
