package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_RFQ_SETTING_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_RFQ_SETTING_TYPE_Both(0),
	@SerializedName("1")
	TI_RFQ_SETTING_TYPE_OnlyPrice(1),
	@SerializedName("2")
	TI_RFQ_SETTING_TYPE_OnlyQty(2),
	@SerializedName("3")
	TI_RFQ_SETTING_TYPE_None(3);

	private int value;

	TI_RFQ_SETTING_TYPE_Enum(int value)
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
		if (value == TI_RFQ_SETTING_TYPE_Both.ordinal())
			return "Both";
		if (value == TI_RFQ_SETTING_TYPE_OnlyPrice.ordinal())
			return "Only Price/Yield/Rate";
		if (value == TI_RFQ_SETTING_TYPE_OnlyQty.ordinal())
			return "Only Quantity";
		if (value == TI_RFQ_SETTING_TYPE_None.ordinal())
			return "None";
		return "";
	}
	public static TI_RFQ_SETTING_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_RFQ_SETTING_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
