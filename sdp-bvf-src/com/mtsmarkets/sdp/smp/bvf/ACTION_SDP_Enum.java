package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum ACTION_SDP_Enum implements SMPEnum
{
	@SerializedName("0")
	ACTION_SDP_ADD(0),
	@SerializedName("1")
	ACTION_SDP_DEL(1),
	@SerializedName("2")
	ACTION_SDP_RWT(2),
	@SerializedName("3")
	ACTION_SDP_KILL(3);

	private int value;

	ACTION_SDP_Enum(int value)
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
		if (value == ACTION_SDP_ADD.ordinal())
			return "ActionADD";
		if (value == ACTION_SDP_DEL.ordinal())
			return "ActionDEL";
		if (value == ACTION_SDP_RWT.ordinal())
			return "ActionRWT";
		if (value == ACTION_SDP_KILL.ordinal())
			return "ActionKILL";
		return "";
	}
	public static ACTION_SDP_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= ACTION_SDP_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
