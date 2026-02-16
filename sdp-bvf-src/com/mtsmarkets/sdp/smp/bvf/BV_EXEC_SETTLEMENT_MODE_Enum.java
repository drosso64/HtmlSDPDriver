package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum BV_EXEC_SETTLEMENT_MODE_Enum implements SMPEnum
{
	@SerializedName("0")
	BV_EXEC_SETTLEMENT_MODE_None(0),
	@SerializedName("1")
	BV_EXEC_SETTLEMENT_MODE_Standard(1),
	@SerializedName("2")
	BV_EXEC_SETTLEMENT_MODE_DLT(2);

	private int value;

	BV_EXEC_SETTLEMENT_MODE_Enum(int value)
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
		if (value == BV_EXEC_SETTLEMENT_MODE_None.ordinal())
			return "NONE";
		if (value == BV_EXEC_SETTLEMENT_MODE_Standard.ordinal())
			return "STANDARD";
		if (value == BV_EXEC_SETTLEMENT_MODE_DLT.ordinal())
			return "DLT";
		return "";
	}
	public static BV_EXEC_SETTLEMENT_MODE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= BV_EXEC_SETTLEMENT_MODE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
