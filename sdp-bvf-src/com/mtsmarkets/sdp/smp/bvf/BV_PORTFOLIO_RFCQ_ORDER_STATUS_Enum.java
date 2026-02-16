package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum BV_PORTFOLIO_RFCQ_ORDER_STATUS_Enum implements SMPEnum
{
	@SerializedName("0")
	BV_PORTFOLIO_RFCQ_ORDER_STATUS_Processing(0),
	@SerializedName("1")
	BV_PORTFOLIO_RFCQ_ORDER_STATUS_Refused(1),
	@SerializedName("2")
	BV_PORTFOLIO_RFCQ_ORDER_STATUS_CompletelyFilled(2),
	@SerializedName("3")
	BV_PORTFOLIO_RFCQ_ORDER_STATUS_ZeroFilled(3),
	@SerializedName("4")
	BV_PORTFOLIO_RFCQ_ORDER_STATUS_RefusedForRFCQTimeout(4),
	@SerializedName("5")
	BV_PORTFOLIO_RFCQ_ORDER_STATUS_RefusedForAcceptanceTimeout(5);

	private int value;

	BV_PORTFOLIO_RFCQ_ORDER_STATUS_Enum(int value)
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
		if (value == BV_PORTFOLIO_RFCQ_ORDER_STATUS_Processing.ordinal())
			return "Pending";
		if (value == BV_PORTFOLIO_RFCQ_ORDER_STATUS_Refused.ordinal())
			return "Reject";
		if (value == BV_PORTFOLIO_RFCQ_ORDER_STATUS_CompletelyFilled.ordinal())
			return "Done - Manual";
		if (value == BV_PORTFOLIO_RFCQ_ORDER_STATUS_ZeroFilled.ordinal())
			return "Zero Filled";
		if (value == BV_PORTFOLIO_RFCQ_ORDER_STATUS_RefusedForRFCQTimeout.ordinal())
			return "Expired";
		if (value == BV_PORTFOLIO_RFCQ_ORDER_STATUS_RefusedForAcceptanceTimeout.ordinal())
			return "Timeout";
		return "";
	}
	public static BV_PORTFOLIO_RFCQ_ORDER_STATUS_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= BV_PORTFOLIO_RFCQ_ORDER_STATUS_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
