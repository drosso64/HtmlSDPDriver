package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum BV_PORTFOLIO_RFCQ_REQUEST_EVENT_Enum implements SMPEnum
{
	@SerializedName("0")
	BV_PORTFOLIO_RFCQ_REQUEST_EVENT_Insert(0),
	@SerializedName("1")
	BV_PORTFOLIO_RFCQ_REQUEST_EVENT_Update(1),
	@SerializedName("2")
	BV_PORTFOLIO_RFCQ_REQUEST_EVENT_Send(2),
	@SerializedName("3")
	BV_PORTFOLIO_RFCQ_REQUEST_EVENT_Close(3),
	@SerializedName("4")
	BV_PORTFOLIO_RFCQ_REQUEST_EVENT_Accept(4);

	private int value;

	BV_PORTFOLIO_RFCQ_REQUEST_EVENT_Enum(int value)
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
		if (value == BV_PORTFOLIO_RFCQ_REQUEST_EVENT_Insert.ordinal())
			return "Insert";
		if (value == BV_PORTFOLIO_RFCQ_REQUEST_EVENT_Update.ordinal())
			return "Update";
		if (value == BV_PORTFOLIO_RFCQ_REQUEST_EVENT_Send.ordinal())
			return "Send";
		if (value == BV_PORTFOLIO_RFCQ_REQUEST_EVENT_Close.ordinal())
			return "Close";
		if (value == BV_PORTFOLIO_RFCQ_REQUEST_EVENT_Accept.ordinal())
			return "Accept";
		return "";
	}
	public static BV_PORTFOLIO_RFCQ_REQUEST_EVENT_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= BV_PORTFOLIO_RFCQ_REQUEST_EVENT_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
