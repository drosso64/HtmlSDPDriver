package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum BV_INVENTORY_ORDER_EVENT_Enum implements SMPEnum
{
	@SerializedName("0")
	BV_INVENTORY_ORDER_EVENT_Accept(0),
	@SerializedName("1")
	BV_INVENTORY_ORDER_EVENT_AcceptAndReset(1),
	@SerializedName("2")
	BV_INVENTORY_ORDER_EVENT_Counter(2),
	@SerializedName("3")
	BV_INVENTORY_ORDER_EVENT_Refuse(3);

	private int value;

	BV_INVENTORY_ORDER_EVENT_Enum(int value)
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
		if (value == BV_INVENTORY_ORDER_EVENT_Accept.ordinal())
			return "Accept";
		if (value == BV_INVENTORY_ORDER_EVENT_AcceptAndReset.ordinal())
			return "Accept and Reset";
		if (value == BV_INVENTORY_ORDER_EVENT_Counter.ordinal())
			return "Counter";
		if (value == BV_INVENTORY_ORDER_EVENT_Refuse.ordinal())
			return "Refuse";
		return "";
	}
	public static BV_INVENTORY_ORDER_EVENT_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= BV_INVENTORY_ORDER_EVENT_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
