package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum BV_LINK_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	BV_LINK_TYPE_NoTrading(0),
	@SerializedName("1")
	BV_LINK_TYPE_Multimember(1);

	private int value;

	BV_LINK_TYPE_Enum(int value)
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
		if (value == BV_LINK_TYPE_NoTrading.ordinal())
			return "NoTrading";
		if (value == BV_LINK_TYPE_Multimember.ordinal())
			return "Multimember";
		return "";
	}
	public static BV_LINK_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= BV_LINK_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
