package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum BV_RFCQ_AUTO_EXECUTION_RULE_EVENT_Enum implements SMPEnum
{
	@SerializedName("0")
	BV_RFCQ_AUTO_EXECUTION_RULE_EVENT_Enable(0),
	@SerializedName("1")
	BV_RFCQ_AUTO_EXECUTION_RULE_EVENT_Disable(1),
	@SerializedName("2")
	BV_RFCQ_AUTO_EXECUTION_RULE_EVENT_Delete(2);

	private int value;

	BV_RFCQ_AUTO_EXECUTION_RULE_EVENT_Enum(int value)
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
		if (value == BV_RFCQ_AUTO_EXECUTION_RULE_EVENT_Enable.ordinal())
			return "Enable";
		if (value == BV_RFCQ_AUTO_EXECUTION_RULE_EVENT_Disable.ordinal())
			return "Disable";
		if (value == BV_RFCQ_AUTO_EXECUTION_RULE_EVENT_Delete.ordinal())
			return "Deleted";
		return "";
	}
	public static BV_RFCQ_AUTO_EXECUTION_RULE_EVENT_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= BV_RFCQ_AUTO_EXECUTION_RULE_EVENT_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
