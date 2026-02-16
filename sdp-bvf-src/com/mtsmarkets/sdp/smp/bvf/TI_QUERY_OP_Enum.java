package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_QUERY_OP_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_QUERY_OP_None(0),
	@SerializedName("1")
	TI_QUERY_OP_LT(1),
	@SerializedName("2")
	TI_QUERY_OP_LTE(2),
	@SerializedName("3")
	TI_QUERY_OP_GT(3),
	@SerializedName("4")
	TI_QUERY_OP_GTE(4),
	@SerializedName("5")
	TI_QUERY_OP_EQ(5),
	@SerializedName("6")
	TI_QUERY_OP_LIKE(6);

	private int value;

	TI_QUERY_OP_Enum(int value)
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
		if (value == TI_QUERY_OP_None.ordinal())
			return "All";
		if (value == TI_QUERY_OP_LT.ordinal())
			return "<";
		if (value == TI_QUERY_OP_LTE.ordinal())
			return "<=";
		if (value == TI_QUERY_OP_GT.ordinal())
			return ">";
		if (value == TI_QUERY_OP_GTE.ordinal())
			return ">=";
		if (value == TI_QUERY_OP_EQ.ordinal())
			return "=";
		if (value == TI_QUERY_OP_LIKE.ordinal())
			return "Like";
		return "";
	}
	public static TI_QUERY_OP_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_QUERY_OP_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
