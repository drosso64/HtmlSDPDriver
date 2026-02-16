package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum BV_INVENTORY_ORDER_STATUS_Enum implements SMPEnum
{
	@SerializedName("0")
	BV_INVENTORY_ORDER_STATUS_Processing(0),
	@SerializedName("1")
	BV_INVENTORY_ORDER_STATUS_Accepted(1),
	@SerializedName("2")
	BV_INVENTORY_ORDER_STATUS_Refused(2),
	@SerializedName("3")
	BV_INVENTORY_ORDER_STATUS_RefusedCounter(3),
	@SerializedName("4")
	BV_INVENTORY_ORDER_STATUS_Timeout(4),
	@SerializedName("5")
	BV_INVENTORY_ORDER_STATUS_DelForSuspension(5),
	@SerializedName("6")
	BV_INVENTORY_ORDER_STATUS_ZeroFilled(6);

	private int value;

	BV_INVENTORY_ORDER_STATUS_Enum(int value)
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
		if (value == BV_INVENTORY_ORDER_STATUS_Processing.ordinal())
			return "Processing";
		if (value == BV_INVENTORY_ORDER_STATUS_Accepted.ordinal())
			return "Done";
		if (value == BV_INVENTORY_ORDER_STATUS_Refused.ordinal())
			return "Refused";
		if (value == BV_INVENTORY_ORDER_STATUS_RefusedCounter.ordinal())
			return "Counter";
		if (value == BV_INVENTORY_ORDER_STATUS_Timeout.ordinal())
			return "Timeout";
		if (value == BV_INVENTORY_ORDER_STATUS_DelForSuspension.ordinal())
			return "Deleted for Suspension";
		if (value == BV_INVENTORY_ORDER_STATUS_ZeroFilled.ordinal())
			return "Zero Filled";
		return "";
	}
	public static BV_INVENTORY_ORDER_STATUS_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= BV_INVENTORY_ORDER_STATUS_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
