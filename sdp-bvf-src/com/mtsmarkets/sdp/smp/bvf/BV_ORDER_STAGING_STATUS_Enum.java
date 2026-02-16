package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum BV_ORDER_STAGING_STATUS_Enum implements SMPEnum
{
	@SerializedName("0")
	BV_ORDER_STAGING_STATUS_Active(0),
	@SerializedName("1")
	BV_ORDER_STAGING_STATUS_Cancelled(1),
	@SerializedName("2")
	BV_ORDER_STAGING_STATUS_RFCQProcessing(2),
	@SerializedName("3")
	BV_ORDER_STAGING_STATUS_Filled(3),
	@SerializedName("4")
	BV_ORDER_STAGING_STATUS_CATProcessing(4),
	@SerializedName("5")
	BV_ORDER_STAGING_STATUS_DoneForDay(5),
	@SerializedName("6")
	BV_ORDER_STAGING_STATUS_CancelledByGov(6),
	@SerializedName("7")
	BV_ORDER_STAGING_STATUS_CancelledByTrader(7),
	@SerializedName("8")
	BV_ORDER_STAGING_STATUS_AutoDeleted(8);

	private int value;

	BV_ORDER_STAGING_STATUS_Enum(int value)
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
		if (value == BV_ORDER_STAGING_STATUS_Active.ordinal())
			return "NEW";
		if (value == BV_ORDER_STAGING_STATUS_Cancelled.ordinal())
			return "Cancelled";
		if (value == BV_ORDER_STAGING_STATUS_RFCQProcessing.ordinal())
			return "RFCQ Processing";
		if (value == BV_ORDER_STAGING_STATUS_Filled.ordinal())
			return "Done - CF";
		if (value == BV_ORDER_STAGING_STATUS_CATProcessing.ordinal())
			return "CAT Processing";
		if (value == BV_ORDER_STAGING_STATUS_DoneForDay.ordinal())
			return "DD";
		if (value == BV_ORDER_STAGING_STATUS_CancelledByGov.ordinal())
			return "Canc. by Gov.nce";
		if (value == BV_ORDER_STAGING_STATUS_CancelledByTrader.ordinal())
			return "Cancelled by Trader";
		if (value == BV_ORDER_STAGING_STATUS_AutoDeleted.ordinal())
			return "Auto Deleted";
		return "";
	}
	public static BV_ORDER_STAGING_STATUS_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= BV_ORDER_STAGING_STATUS_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
