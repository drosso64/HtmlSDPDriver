package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_SUSP_STATUS_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_SUSP_STATUS_Active(0),
	@SerializedName("1")
	TI_SUSP_STATUS_Suspended(1),
	@SerializedName("2")
	TI_SUSP_STATUS_TradingHalt(2),
	@SerializedName("3")
	TI_SUSP_STATUS_WaitingForContribution(3),
	@SerializedName("4")
	TI_SUSP_STATUS_IntradayUpdate(4);

	private int value;

	TI_SUSP_STATUS_Enum(int value)
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
		if (value == TI_SUSP_STATUS_Active.ordinal())
			return "Active";
		if (value == TI_SUSP_STATUS_Suspended.ordinal())
			return "Suspended";
		if (value == TI_SUSP_STATUS_TradingHalt.ordinal())
			return "Trading Halt";
		if (value == TI_SUSP_STATUS_WaitingForContribution.ordinal())
			return "Waiting For Contribution";
		if (value == TI_SUSP_STATUS_IntradayUpdate.ordinal())
			return "Intraday Update";
		return "";
	}
	public static TI_SUSP_STATUS_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_SUSP_STATUS_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
