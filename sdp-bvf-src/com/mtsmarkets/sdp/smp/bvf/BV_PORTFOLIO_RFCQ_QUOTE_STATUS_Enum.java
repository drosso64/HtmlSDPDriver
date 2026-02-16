package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum BV_PORTFOLIO_RFCQ_QUOTE_STATUS_Enum implements SMPEnum
{
	@SerializedName("0")
	BV_PORTFOLIO_RFCQ_QUOTE_STATUS_Active(0),
	@SerializedName("1")
	BV_PORTFOLIO_RFCQ_QUOTE_STATUS_Suspended(1),
	@SerializedName("2")
	BV_PORTFOLIO_RFCQ_QUOTE_STATUS_ManuallyCompletelyFilled(2),
	@SerializedName("3")
	BV_PORTFOLIO_RFCQ_QUOTE_STATUS_Locked(3),
	@SerializedName("4")
	BV_PORTFOLIO_RFCQ_QUOTE_STATUS_Deleted(4);

	private int value;

	BV_PORTFOLIO_RFCQ_QUOTE_STATUS_Enum(int value)
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
		if (value == BV_PORTFOLIO_RFCQ_QUOTE_STATUS_Active.ordinal())
			return "Active";
		if (value == BV_PORTFOLIO_RFCQ_QUOTE_STATUS_Suspended.ordinal())
			return "Suspended";
		if (value == BV_PORTFOLIO_RFCQ_QUOTE_STATUS_ManuallyCompletelyFilled.ordinal())
			return "Done - Manual";
		if (value == BV_PORTFOLIO_RFCQ_QUOTE_STATUS_Locked.ordinal())
			return "Pending Acceptance";
		if (value == BV_PORTFOLIO_RFCQ_QUOTE_STATUS_Deleted.ordinal())
			return "Deleted";
		return "";
	}
	public static BV_PORTFOLIO_RFCQ_QUOTE_STATUS_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= BV_PORTFOLIO_RFCQ_QUOTE_STATUS_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
