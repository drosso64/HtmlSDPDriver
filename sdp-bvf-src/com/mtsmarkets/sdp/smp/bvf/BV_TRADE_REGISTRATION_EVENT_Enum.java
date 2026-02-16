package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum BV_TRADE_REGISTRATION_EVENT_Enum implements SMPEnum
{
	@SerializedName("0")
	BV_TRADE_REGISTRATION_EVENT_Send(0),
	@SerializedName("1")
	BV_TRADE_REGISTRATION_EVENT_Accept(1),
	@SerializedName("2")
	BV_TRADE_REGISTRATION_EVENT_Reject(2),
	@SerializedName("3")
	BV_TRADE_REGISTRATION_EVENT_Delete(3);

	private int value;

	BV_TRADE_REGISTRATION_EVENT_Enum(int value)
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
		if (value == BV_TRADE_REGISTRATION_EVENT_Send.ordinal())
			return "Send";
		if (value == BV_TRADE_REGISTRATION_EVENT_Accept.ordinal())
			return "Accept";
		if (value == BV_TRADE_REGISTRATION_EVENT_Reject.ordinal())
			return "Reject";
		if (value == BV_TRADE_REGISTRATION_EVENT_Delete.ordinal())
			return "Delete";
		return "";
	}
	public static BV_TRADE_REGISTRATION_EVENT_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= BV_TRADE_REGISTRATION_EVENT_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
