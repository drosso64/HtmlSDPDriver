package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_SETTLEMENT_MODE_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_SETTLEMENT_MODE_None(0),
	@SerializedName("1")
	TI_SETTLEMENT_MODE_CCPOnly(1),
	@SerializedName("2")
	TI_SETTLEMENT_MODE_BilateralOnly(2),
	@SerializedName("3")
	TI_SETTLEMENT_MODE_Both(3);

	private int value;

	TI_SETTLEMENT_MODE_Enum(int value)
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
		if (value == TI_SETTLEMENT_MODE_None.ordinal())
			return "None";
		if (value == TI_SETTLEMENT_MODE_CCPOnly.ordinal())
			return "CCP Only";
		if (value == TI_SETTLEMENT_MODE_BilateralOnly.ordinal())
			return "Bilateral Only";
		if (value == TI_SETTLEMENT_MODE_Both.ordinal())
			return "Both";
		return "";
	}
	public static TI_SETTLEMENT_MODE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_SETTLEMENT_MODE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
