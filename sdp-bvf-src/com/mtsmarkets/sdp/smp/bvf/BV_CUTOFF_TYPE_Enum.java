package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum BV_CUTOFF_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	BV_CUTOFF_TYPE_RFCQSameDaySettlement(0);

	private int value;

	BV_CUTOFF_TYPE_Enum(int value)
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
		if (value == BV_CUTOFF_TYPE_RFCQSameDaySettlement.ordinal())
			return "Same Day Settlement for RFCQ";
		return "";
	}
	public static BV_CUTOFF_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= BV_CUTOFF_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
