package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum BV_HANDLING_INSTRUCTION_Enum implements SMPEnum
{
	@SerializedName("0")
	BV_HANDLING_INSTRUCTION_None(0),
	@SerializedName("1")
	BV_HANDLING_INSTRUCTION_AutoExecNoBrokerIntervention(1),
	@SerializedName("2")
	BV_HANDLING_INSTRUCTION_AutoExecBrokerIntervention(2),
	@SerializedName("3")
	BV_HANDLING_INSTRUCTION_ManualExec(3);

	private int value;

	BV_HANDLING_INSTRUCTION_Enum(int value)
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
		if (value == BV_HANDLING_INSTRUCTION_None.ordinal())
			return "None";
		if (value == BV_HANDLING_INSTRUCTION_AutoExecNoBrokerIntervention.ordinal())
			return "Automated Execution No Broker Intervention";
		if (value == BV_HANDLING_INSTRUCTION_AutoExecBrokerIntervention.ordinal())
			return "Automated Execution Broker Intervention";
		if (value == BV_HANDLING_INSTRUCTION_ManualExec.ordinal())
			return "Manual Execution";
		return "";
	}
	public static BV_HANDLING_INSTRUCTION_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= BV_HANDLING_INSTRUCTION_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
