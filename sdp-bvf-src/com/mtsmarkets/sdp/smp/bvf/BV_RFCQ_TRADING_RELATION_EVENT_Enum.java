package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum BV_RFCQ_TRADING_RELATION_EVENT_Enum implements SMPEnum
{
	@SerializedName("0")
	BV_RFCQ_TRADING_RELATION_EVENT_Accept(0),
	@SerializedName("1")
	BV_RFCQ_TRADING_RELATION_EVENT_Refuse(1),
	@SerializedName("2")
	BV_RFCQ_TRADING_RELATION_EVENT_Revoke(2),
	@SerializedName("3")
	BV_RFCQ_TRADING_RELATION_EVENT_Reset(3),
	@SerializedName("4")
	BV_RFCQ_TRADING_RELATION_EVENT_Delete(4);

	private int value;

	BV_RFCQ_TRADING_RELATION_EVENT_Enum(int value)
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
		if (value == BV_RFCQ_TRADING_RELATION_EVENT_Accept.ordinal())
			return "Accept";
		if (value == BV_RFCQ_TRADING_RELATION_EVENT_Refuse.ordinal())
			return "Refuse";
		if (value == BV_RFCQ_TRADING_RELATION_EVENT_Revoke.ordinal())
			return "Revoke";
		if (value == BV_RFCQ_TRADING_RELATION_EVENT_Reset.ordinal())
			return "Reset";
		if (value == BV_RFCQ_TRADING_RELATION_EVENT_Delete.ordinal())
			return "Delete";
		return "";
	}
	public static BV_RFCQ_TRADING_RELATION_EVENT_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= BV_RFCQ_TRADING_RELATION_EVENT_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
