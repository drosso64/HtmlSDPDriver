package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum BV_TRADE_REGISTRATION_STATUS_Enum implements SMPEnum
{
	@SerializedName("0")
	BV_TRADE_REGISTRATION_STATUS_Processing(0),
	@SerializedName("1")
	BV_TRADE_REGISTRATION_STATUS_Error(1),
	@SerializedName("2")
	BV_TRADE_REGISTRATION_STATUS_Locked(2),
	@SerializedName("3")
	BV_TRADE_REGISTRATION_STATUS_Done(3),
	@SerializedName("4")
	BV_TRADE_REGISTRATION_STATUS_Rejected(4),
	@SerializedName("5")
	BV_TRADE_REGISTRATION_STATUS_Deleted(5),
	@SerializedName("6")
	BV_TRADE_REGISTRATION_STATUS_Expired(6);

	private int value;

	BV_TRADE_REGISTRATION_STATUS_Enum(int value)
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
		if (value == BV_TRADE_REGISTRATION_STATUS_Processing.ordinal())
			return "Processing";
		if (value == BV_TRADE_REGISTRATION_STATUS_Error.ordinal())
			return "Error";
		if (value == BV_TRADE_REGISTRATION_STATUS_Locked.ordinal())
			return "Locked";
		if (value == BV_TRADE_REGISTRATION_STATUS_Done.ordinal())
			return "Done";
		if (value == BV_TRADE_REGISTRATION_STATUS_Rejected.ordinal())
			return "Rejected";
		if (value == BV_TRADE_REGISTRATION_STATUS_Deleted.ordinal())
			return "Deleted";
		if (value == BV_TRADE_REGISTRATION_STATUS_Expired.ordinal())
			return "Expired";
		return "";
	}
	public static BV_TRADE_REGISTRATION_STATUS_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= BV_TRADE_REGISTRATION_STATUS_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
