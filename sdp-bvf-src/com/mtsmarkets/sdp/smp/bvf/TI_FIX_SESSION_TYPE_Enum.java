package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_FIX_SESSION_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_FIX_SESSION_TYPE_Dealer(0),
	@SerializedName("1")
	TI_FIX_SESSION_TYPE_TPAClient(1),
	@SerializedName("2")
	TI_FIX_SESSION_TYPE_PrimeBroker(2),
	@SerializedName("3")
	TI_FIX_SESSION_TYPE_Broker(3);

	private int value;

	TI_FIX_SESSION_TYPE_Enum(int value)
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
		if (value == TI_FIX_SESSION_TYPE_Dealer.ordinal())
			return "Dealer";
		if (value == TI_FIX_SESSION_TYPE_TPAClient.ordinal())
			return "TPA Client";
		if (value == TI_FIX_SESSION_TYPE_PrimeBroker.ordinal())
			return "Prime Broker";
		if (value == TI_FIX_SESSION_TYPE_Broker.ordinal())
			return "Broker";
		return "";
	}
	public static TI_FIX_SESSION_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_FIX_SESSION_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
