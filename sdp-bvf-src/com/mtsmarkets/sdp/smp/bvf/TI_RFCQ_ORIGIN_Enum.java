package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_RFCQ_ORIGIN_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_RFCQ_ORIGIN_FromScratch(0),
	@SerializedName("1")
	TI_RFCQ_ORIGIN_FromDealer(1),
	@SerializedName("2")
	TI_RFCQ_ORIGIN_FromInventory(2);

	private int value;

	TI_RFCQ_ORIGIN_Enum(int value)
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
		if (value == TI_RFCQ_ORIGIN_FromScratch.ordinal())
			return " ";
		if (value == TI_RFCQ_ORIGIN_FromDealer.ordinal())
			return "From Single Dealer Page";
		if (value == TI_RFCQ_ORIGIN_FromInventory.ordinal())
			return "From Inventory";
		return "";
	}
	public static TI_RFCQ_ORIGIN_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_RFCQ_ORIGIN_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
