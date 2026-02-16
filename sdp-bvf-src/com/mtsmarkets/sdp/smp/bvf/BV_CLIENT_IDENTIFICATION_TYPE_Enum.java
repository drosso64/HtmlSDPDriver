package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum BV_CLIENT_IDENTIFICATION_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	BV_CLIENT_IDENTIFICATION_TYPE_None(0),
	@SerializedName("1")
	BV_CLIENT_IDENTIFICATION_TYPE_LEI(1),
	@SerializedName("2")
	BV_CLIENT_IDENTIFICATION_TYPE_NationalId(2),
	@SerializedName("3")
	BV_CLIENT_IDENTIFICATION_TYPE_AGGR(3),
	@SerializedName("4")
	BV_CLIENT_IDENTIFICATION_TYPE_PNAL(4);

	private int value;

	BV_CLIENT_IDENTIFICATION_TYPE_Enum(int value)
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
		if (value == BV_CLIENT_IDENTIFICATION_TYPE_None.ordinal())
			return "None";
		if (value == BV_CLIENT_IDENTIFICATION_TYPE_LEI.ordinal())
			return "Legal Entity Identifier";
		if (value == BV_CLIENT_IDENTIFICATION_TYPE_NationalId.ordinal())
			return "National ID";
		if (value == BV_CLIENT_IDENTIFICATION_TYPE_AGGR.ordinal())
			return "Aggregated Orders";
		if (value == BV_CLIENT_IDENTIFICATION_TYPE_PNAL.ordinal())
			return "Pending Allocation";
		return "";
	}
	public static BV_CLIENT_IDENTIFICATION_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= BV_CLIENT_IDENTIFICATION_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
