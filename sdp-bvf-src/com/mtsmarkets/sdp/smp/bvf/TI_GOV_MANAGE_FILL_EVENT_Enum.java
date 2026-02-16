package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_GOV_MANAGE_FILL_EVENT_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_GOV_MANAGE_FILL_EVENT_Activate(0),
	@SerializedName("1")
	TI_GOV_MANAGE_FILL_EVENT_Delete(1),
	@SerializedName("2")
	TI_GOV_MANAGE_FILL_EVENT_DeleteFromSettlement(2),
	@SerializedName("3")
	TI_GOV_MANAGE_FILL_EVENT_ExcludeFromOfficialPrice(3),
	@SerializedName("4")
	TI_GOV_MANAGE_FILL_EVENT_IncludeIntoOfficialPrice(4),
	@SerializedName("5")
	TI_GOV_MANAGE_FILL_EVENT_Reset(5);

	private int value;

	TI_GOV_MANAGE_FILL_EVENT_Enum(int value)
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
		if (value == TI_GOV_MANAGE_FILL_EVENT_Activate.ordinal())
			return "Activate";
		if (value == TI_GOV_MANAGE_FILL_EVENT_Delete.ordinal())
			return "Delete";
		if (value == TI_GOV_MANAGE_FILL_EVENT_DeleteFromSettlement.ordinal())
			return "Delete from Settlement";
		if (value == TI_GOV_MANAGE_FILL_EVENT_ExcludeFromOfficialPrice.ordinal())
			return "Exclude from Official Price";
		if (value == TI_GOV_MANAGE_FILL_EVENT_IncludeIntoOfficialPrice.ordinal())
			return "Include into Official Price";
		if (value == TI_GOV_MANAGE_FILL_EVENT_Reset.ordinal())
			return "Reset";
		return "";
	}
	public static TI_GOV_MANAGE_FILL_EVENT_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_GOV_MANAGE_FILL_EVENT_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
