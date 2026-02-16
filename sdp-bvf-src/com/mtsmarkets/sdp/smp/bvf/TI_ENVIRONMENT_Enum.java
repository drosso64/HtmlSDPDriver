package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_ENVIRONMENT_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_ENVIRONMENT_LiveMarket(0),
	@SerializedName("1")
	TI_ENVIRONMENT_Test(1),
	@SerializedName("2")
	TI_ENVIRONMENT_PreProduction(2),
	@SerializedName("3")
	TI_ENVIRONMENT_Internal(3),
	@SerializedName("4")
	TI_ENVIRONMENT_Development(4),
	@SerializedName("5")
	TI_ENVIRONMENT_Simulator(5);

	private int value;

	TI_ENVIRONMENT_Enum(int value)
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
		if (value == TI_ENVIRONMENT_LiveMarket.ordinal())
			return "Live Market";
		if (value == TI_ENVIRONMENT_Test.ordinal())
			return "Test";
		if (value == TI_ENVIRONMENT_PreProduction.ordinal())
			return "Pre Production";
		if (value == TI_ENVIRONMENT_Internal.ordinal())
			return "Internal";
		if (value == TI_ENVIRONMENT_Development.ordinal())
			return "Development";
		if (value == TI_ENVIRONMENT_Simulator.ordinal())
			return "Simulator";
		return "";
	}
	public static TI_ENVIRONMENT_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_ENVIRONMENT_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
