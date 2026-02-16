package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum BV_PORTFOLIO_RFCQ_ORDER_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	BV_PORTFOLIO_RFCQ_ORDER_TYPE_Normal(0),
	@SerializedName("1")
	BV_PORTFOLIO_RFCQ_ORDER_TYPE_BestProceeds(1);

	private int value;

	BV_PORTFOLIO_RFCQ_ORDER_TYPE_Enum(int value)
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
		if (value == BV_PORTFOLIO_RFCQ_ORDER_TYPE_Normal.ordinal())
			return "At Best - Selected Dealer";
		if (value == BV_PORTFOLIO_RFCQ_ORDER_TYPE_BestProceeds.ordinal())
			return "At Best Proceeds";
		return "";
	}
	public static BV_PORTFOLIO_RFCQ_ORDER_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= BV_PORTFOLIO_RFCQ_ORDER_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
