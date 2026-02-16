package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_CLUSTER_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_CLUSTER_TYPE_MemberType(0),
	@SerializedName("1")
	TI_CLUSTER_TYPE_ProductType(1),
	@SerializedName("2")
	TI_CLUSTER_TYPE_Null(2),
	@SerializedName("3")
	TI_CLUSTER_TYPE_InstrumentClassType(3),
	@SerializedName("4")
	TI_CLUSTER_TYPE_MemberBRTType(4),
	@SerializedName("5")
	TI_CLUSTER_TYPE_MarketType(5),
	@SerializedName("6")
	TI_CLUSTER_TYPE_MemberMarketType(6),
	@SerializedName("7")
	TI_CLUSTER_TYPE_HiddenType(7);

	private int value;

	TI_CLUSTER_TYPE_Enum(int value)
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
		if (value == TI_CLUSTER_TYPE_MemberType.ordinal())
			return "MemberType";
		if (value == TI_CLUSTER_TYPE_ProductType.ordinal())
			return "ProductType";
		if (value == TI_CLUSTER_TYPE_Null.ordinal())
			return "Null";
		if (value == TI_CLUSTER_TYPE_InstrumentClassType.ordinal())
			return "InstrumentClassType";
		if (value == TI_CLUSTER_TYPE_MemberBRTType.ordinal())
			return "MemberBRTType";
		if (value == TI_CLUSTER_TYPE_MarketType.ordinal())
			return "MarketType";
		if (value == TI_CLUSTER_TYPE_MemberMarketType.ordinal())
			return "MemberMarketType";
		if (value == TI_CLUSTER_TYPE_HiddenType.ordinal())
			return "HiddenType";
		return "";
	}
	public static TI_CLUSTER_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_CLUSTER_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
