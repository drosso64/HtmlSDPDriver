package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum BV_TRADE_SPLIT_STATUS_Enum implements SMPEnum
{
	@SerializedName("0")
	BV_TRADE_SPLIT_STATUS_Accepted(0),
	@SerializedName("1")
	BV_TRADE_SPLIT_STATUS_Processing(1),
	@SerializedName("2")
	BV_TRADE_SPLIT_STATUS_Refused(2),
	@SerializedName("3")
	BV_TRADE_SPLIT_STATUS_Assigned(3),
	@SerializedName("4")
	BV_TRADE_SPLIT_STATUS_Executed(4),
	@SerializedName("5")
	BV_TRADE_SPLIT_STATUS_Locked(5),
	@SerializedName("6")
	BV_TRADE_SPLIT_STATUS_Linked(6),
	@SerializedName("7")
	BV_TRADE_SPLIT_STATUS_Deleted(7),
	@SerializedName("8")
	BV_TRADE_SPLIT_STATUS_DeletedByGov(8),
	@SerializedName("9")
	BV_TRADE_SPLIT_STATUS_LinkedToTradingList(9);

	private int value;

	BV_TRADE_SPLIT_STATUS_Enum(int value)
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
		if (value == BV_TRADE_SPLIT_STATUS_Accepted.ordinal())
			return "Accepted";
		if (value == BV_TRADE_SPLIT_STATUS_Processing.ordinal())
			return "Processing";
		if (value == BV_TRADE_SPLIT_STATUS_Refused.ordinal())
			return "Refused";
		if (value == BV_TRADE_SPLIT_STATUS_Assigned.ordinal())
			return "Assigned";
		if (value == BV_TRADE_SPLIT_STATUS_Executed.ordinal())
			return "Executed";
		if (value == BV_TRADE_SPLIT_STATUS_Locked.ordinal())
			return "Locked";
		if (value == BV_TRADE_SPLIT_STATUS_Linked.ordinal())
			return "Linked";
		if (value == BV_TRADE_SPLIT_STATUS_Deleted.ordinal())
			return "Deleted";
		if (value == BV_TRADE_SPLIT_STATUS_DeletedByGov.ordinal())
			return "Deleted by Governance";
		if (value == BV_TRADE_SPLIT_STATUS_LinkedToTradingList.ordinal())
			return "Linked to a Trading List";
		return "";
	}
	public static BV_TRADE_SPLIT_STATUS_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= BV_TRADE_SPLIT_STATUS_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
