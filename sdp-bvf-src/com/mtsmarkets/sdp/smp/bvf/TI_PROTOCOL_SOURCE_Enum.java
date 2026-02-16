package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_PROTOCOL_SOURCE_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_PROTOCOL_SOURCE_Sdp(0),
	@SerializedName("1")
	TI_PROTOCOL_SOURCE_Fix(1);

	private int value;

	TI_PROTOCOL_SOURCE_Enum(int value)
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
		if (value == TI_PROTOCOL_SOURCE_Sdp.ordinal())
			return "SDP";
		if (value == TI_PROTOCOL_SOURCE_Fix.ordinal())
			return "FIX";
		return "";
	}
	public static TI_PROTOCOL_SOURCE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_PROTOCOL_SOURCE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
