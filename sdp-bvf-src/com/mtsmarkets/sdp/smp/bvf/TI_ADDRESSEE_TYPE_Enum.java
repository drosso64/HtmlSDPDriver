package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_ADDRESSEE_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_ADDRESSEE_TYPE_AllMembersSingleMarket(0),
	@SerializedName("1")
	TI_ADDRESSEE_TYPE_AllMembersSingleSection(1),
	@SerializedName("2")
	TI_ADDRESSEE_TYPE_SingleMemberAllMarket(2),
	@SerializedName("3")
	TI_ADDRESSEE_TYPE_ProfileMemberSingleMarket(3),
	@SerializedName("4")
	TI_ADDRESSEE_TYPE_ProfileMemberSingleSection(4);

	private int value;

	TI_ADDRESSEE_TYPE_Enum(int value)
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
		if (value == TI_ADDRESSEE_TYPE_AllMembersSingleMarket.ordinal())
			return "All Members Single Market";
		if (value == TI_ADDRESSEE_TYPE_AllMembersSingleSection.ordinal())
			return "All Members Single Section";
		if (value == TI_ADDRESSEE_TYPE_SingleMemberAllMarket.ordinal())
			return "Single Member All Markets";
		if (value == TI_ADDRESSEE_TYPE_ProfileMemberSingleMarket.ordinal())
			return "Profile Member Single Market";
		if (value == TI_ADDRESSEE_TYPE_ProfileMemberSingleSection.ordinal())
			return "Profile Member Single Section";
		return "";
	}
	public static TI_ADDRESSEE_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_ADDRESSEE_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
