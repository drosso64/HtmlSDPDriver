package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum BV_RFCQ_AUTO_EXECUTION_RULE_STATUS_Enum implements SMPEnum
{
	@SerializedName("0")
	BV_RFCQ_AUTO_EXECUTION_RULE_STATUS_Enabled(0),
	@SerializedName("1")
	BV_RFCQ_AUTO_EXECUTION_RULE_STATUS_Disabled(1),
	@SerializedName("2")
	BV_RFCQ_AUTO_EXECUTION_RULE_STATUS_Deleted(2);

	private int value;

	BV_RFCQ_AUTO_EXECUTION_RULE_STATUS_Enum(int value)
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
		if (value == BV_RFCQ_AUTO_EXECUTION_RULE_STATUS_Enabled.ordinal())
			return "Enabled";
		if (value == BV_RFCQ_AUTO_EXECUTION_RULE_STATUS_Disabled.ordinal())
			return "Disabled";
		if (value == BV_RFCQ_AUTO_EXECUTION_RULE_STATUS_Deleted.ordinal())
			return "Deleted";
		return "";
	}
	public static BV_RFCQ_AUTO_EXECUTION_RULE_STATUS_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= BV_RFCQ_AUTO_EXECUTION_RULE_STATUS_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
