package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum BV_TRADE_REGISTRATION_MEMBER_STATUS_Enum implements SMPEnum
{
	@SerializedName("0")
	BV_TRADE_REGISTRATION_MEMBER_STATUS_None(0),
	@SerializedName("1")
	BV_TRADE_REGISTRATION_MEMBER_STATUS_Processing(1),
	@SerializedName("2")
	BV_TRADE_REGISTRATION_MEMBER_STATUS_Error(2),
	@SerializedName("3")
	BV_TRADE_REGISTRATION_MEMBER_STATUS_DoneManual(3),
	@SerializedName("4")
	BV_TRADE_REGISTRATION_MEMBER_STATUS_DoneAuto(4),
	@SerializedName("5")
	BV_TRADE_REGISTRATION_MEMBER_STATUS_Rejected(5),
	@SerializedName("6")
	BV_TRADE_REGISTRATION_MEMBER_STATUS_Deleted(6),
	@SerializedName("7")
	BV_TRADE_REGISTRATION_MEMBER_STATUS_Expired(7);

	private int value;

	BV_TRADE_REGISTRATION_MEMBER_STATUS_Enum(int value)
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
		if (value == BV_TRADE_REGISTRATION_MEMBER_STATUS_None.ordinal())
			return "None";
		if (value == BV_TRADE_REGISTRATION_MEMBER_STATUS_Processing.ordinal())
			return "Processing";
		if (value == BV_TRADE_REGISTRATION_MEMBER_STATUS_Error.ordinal())
			return "Error";
		if (value == BV_TRADE_REGISTRATION_MEMBER_STATUS_DoneManual.ordinal())
			return "Done - Manual";
		if (value == BV_TRADE_REGISTRATION_MEMBER_STATUS_DoneAuto.ordinal())
			return "Done - Auto";
		if (value == BV_TRADE_REGISTRATION_MEMBER_STATUS_Rejected.ordinal())
			return "Rejected";
		if (value == BV_TRADE_REGISTRATION_MEMBER_STATUS_Deleted.ordinal())
			return "Deleted";
		if (value == BV_TRADE_REGISTRATION_MEMBER_STATUS_Expired.ordinal())
			return "Expired";
		return "";
	}
	public static BV_TRADE_REGISTRATION_MEMBER_STATUS_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= BV_TRADE_REGISTRATION_MEMBER_STATUS_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
