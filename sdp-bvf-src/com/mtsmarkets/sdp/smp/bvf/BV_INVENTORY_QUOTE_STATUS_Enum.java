package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum BV_INVENTORY_QUOTE_STATUS_Enum implements SMPEnum
{
	@SerializedName("0")
	BV_INVENTORY_QUOTE_STATUS_Active(0),
	@SerializedName("1")
	BV_INVENTORY_QUOTE_STATUS_Suspended(1),
	@SerializedName("2")
	BV_INVENTORY_QUOTE_STATUS_SuspByGov(2),
	@SerializedName("3")
	BV_INVENTORY_QUOTE_STATUS_DelByGov(3),
	@SerializedName("4")
	BV_INVENTORY_QUOTE_STATUS_DelByMember(4),
	@SerializedName("5")
	BV_INVENTORY_QUOTE_STATUS_SuspBySystem(5);

	private int value;

	BV_INVENTORY_QUOTE_STATUS_Enum(int value)
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
		if (value == BV_INVENTORY_QUOTE_STATUS_Active.ordinal())
			return "Active";
		if (value == BV_INVENTORY_QUOTE_STATUS_Suspended.ordinal())
			return "Suspended";
		if (value == BV_INVENTORY_QUOTE_STATUS_SuspByGov.ordinal())
			return "Suspended By Governance";
		if (value == BV_INVENTORY_QUOTE_STATUS_DelByGov.ordinal())
			return "Deleted By Governance";
		if (value == BV_INVENTORY_QUOTE_STATUS_DelByMember.ordinal())
			return "Deleted By Member";
		if (value == BV_INVENTORY_QUOTE_STATUS_SuspBySystem.ordinal())
			return "Suspended By System";
		return "";
	}
	public static BV_INVENTORY_QUOTE_STATUS_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= BV_INVENTORY_QUOTE_STATUS_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
