package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum BV_ORDER_STAGING_EVENT_Enum implements SMPEnum
{
	@SerializedName("0")
	BV_ORDER_STAGING_EVENT_Insert(0),
	@SerializedName("1")
	BV_ORDER_STAGING_EVENT_Lock(1),
	@SerializedName("2")
	BV_ORDER_STAGING_EVENT_Unlock(2),
	@SerializedName("3")
	BV_ORDER_STAGING_EVENT_Delete(3);

	private int value;

	BV_ORDER_STAGING_EVENT_Enum(int value)
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
		if (value == BV_ORDER_STAGING_EVENT_Insert.ordinal())
			return "Insert";
		if (value == BV_ORDER_STAGING_EVENT_Lock.ordinal())
			return "Lock";
		if (value == BV_ORDER_STAGING_EVENT_Unlock.ordinal())
			return "Unlock";
		if (value == BV_ORDER_STAGING_EVENT_Delete.ordinal())
			return "Delete";
		return "";
	}
	public static BV_ORDER_STAGING_EVENT_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= BV_ORDER_STAGING_EVENT_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
