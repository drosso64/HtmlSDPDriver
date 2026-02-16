package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum BV_TRADE_SPLIT_EVENT_Enum implements SMPEnum
{
	@SerializedName("0")
	BV_TRADE_SPLIT_EVENT_PreAllocate(0),
	@SerializedName("1")
	BV_TRADE_SPLIT_EVENT_Allocate(1),
	@SerializedName("2")
	BV_TRADE_SPLIT_EVENT_Update(2),
	@SerializedName("3")
	BV_TRADE_SPLIT_EVENT_Delete(3),
	@SerializedName("4")
	BV_TRADE_SPLIT_EVENT_Lock(4),
	@SerializedName("5")
	BV_TRADE_SPLIT_EVENT_Unlock(5);

	private int value;

	BV_TRADE_SPLIT_EVENT_Enum(int value)
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
		if (value == BV_TRADE_SPLIT_EVENT_PreAllocate.ordinal())
			return "PreAllocate";
		if (value == BV_TRADE_SPLIT_EVENT_Allocate.ordinal())
			return "Allocate";
		if (value == BV_TRADE_SPLIT_EVENT_Update.ordinal())
			return "Update";
		if (value == BV_TRADE_SPLIT_EVENT_Delete.ordinal())
			return "Delete";
		if (value == BV_TRADE_SPLIT_EVENT_Lock.ordinal())
			return "Lock";
		if (value == BV_TRADE_SPLIT_EVENT_Unlock.ordinal())
			return "Unlock";
		return "";
	}
	public static BV_TRADE_SPLIT_EVENT_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= BV_TRADE_SPLIT_EVENT_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
