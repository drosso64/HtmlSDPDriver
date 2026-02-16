package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_BROKER_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_BROKER_TYPE_None(0),
	@SerializedName("1")
	TI_BROKER_TYPE_Dummy(1),
	@SerializedName("2")
	TI_BROKER_TYPE_MinorityBroker(2);

	private int value;

	TI_BROKER_TYPE_Enum(int value)
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
		if (value == TI_BROKER_TYPE_None.ordinal())
			return "None";
		if (value == TI_BROKER_TYPE_Dummy.ordinal())
			return "Dummy";
		if (value == TI_BROKER_TYPE_MinorityBroker.ordinal())
			return "Minority Broker";
		return "";
	}
	public static TI_BROKER_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_BROKER_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
