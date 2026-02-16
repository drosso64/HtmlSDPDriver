package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum BV_DEALER_GROUP_EVENT_Enum implements SMPEnum
{
	@SerializedName("0")
	BV_DEALER_GROUP_EVENT_Insert(0),
	@SerializedName("1")
	BV_DEALER_GROUP_EVENT_Delete(1);

	private int value;

	BV_DEALER_GROUP_EVENT_Enum(int value)
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
		if (value == BV_DEALER_GROUP_EVENT_Insert.ordinal())
			return "Insert";
		if (value == BV_DEALER_GROUP_EVENT_Delete.ordinal())
			return "Delete";
		return "";
	}
	public static BV_DEALER_GROUP_EVENT_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= BV_DEALER_GROUP_EVENT_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
