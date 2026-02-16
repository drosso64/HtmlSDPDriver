package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_RFCQ_EVENT_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_RFCQ_EVENT_Accept(0),
	@SerializedName("1")
	TI_RFCQ_EVENT_Refuse(1);

	private int value;

	TI_RFCQ_EVENT_Enum(int value)
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
		if (value == TI_RFCQ_EVENT_Accept.ordinal())
			return "Accept";
		if (value == TI_RFCQ_EVENT_Refuse.ordinal())
			return "Refuse";
		return "";
	}
	public static TI_RFCQ_EVENT_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_RFCQ_EVENT_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
