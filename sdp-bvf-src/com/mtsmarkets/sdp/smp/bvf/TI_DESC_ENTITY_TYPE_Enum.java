package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_DESC_ENTITY_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_DESC_ENTITY_TYPE_NoType(0),
	@SerializedName("1")
	TI_DESC_ENTITY_TYPE_StructType(1),
	@SerializedName("2")
	TI_DESC_ENTITY_TYPE_EnumType(2),
	@SerializedName("3")
	TI_DESC_ENTITY_TYPE_UnionType(3);

	private int value;

	TI_DESC_ENTITY_TYPE_Enum(int value)
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
		if (value == TI_DESC_ENTITY_TYPE_NoType.ordinal())
			return "NoType";
		if (value == TI_DESC_ENTITY_TYPE_StructType.ordinal())
			return "StructType";
		if (value == TI_DESC_ENTITY_TYPE_EnumType.ordinal())
			return "EnumType";
		if (value == TI_DESC_ENTITY_TYPE_UnionType.ordinal())
			return "UnionType";
		return "";
	}
	public static TI_DESC_ENTITY_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_DESC_ENTITY_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
