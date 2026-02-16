package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum BV_RFCQ_DEALER_SELECTION_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	BV_RFCQ_DEALER_SELECTION_Manual(0),
	@SerializedName("1")
	BV_RFCQ_DEALER_SELECTION_TopPick(1),
	@SerializedName("2")
	BV_RFCQ_DEALER_SELECTION_Axes(2),
	@SerializedName("3")
	BV_RFCQ_DEALER_SELECTION_AxesTopPick(3),
	@SerializedName("4")
	BV_RFCQ_DEALER_SELECTION_1_2WayAxes(4),
	@SerializedName("5")
	BV_RFCQ_DEALER_SELECTION_1_2WayAxesTopPick(5);

	private int value;

	BV_RFCQ_DEALER_SELECTION_TYPE_Enum(int value)
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
		if (value == BV_RFCQ_DEALER_SELECTION_Manual.ordinal())
			return "Manual";
		if (value == BV_RFCQ_DEALER_SELECTION_TopPick.ordinal())
			return "Only Top Pick";
		if (value == BV_RFCQ_DEALER_SELECTION_Axes.ordinal())
			return "Only Axes";
		if (value == BV_RFCQ_DEALER_SELECTION_AxesTopPick.ordinal())
			return "Axes-TopPick";
		if (value == BV_RFCQ_DEALER_SELECTION_1_2WayAxes.ordinal())
			return "1/2-way Axes";
		if (value == BV_RFCQ_DEALER_SELECTION_1_2WayAxesTopPick.ordinal())
			return "1/2-way Axes-TopPick";
		return "";
	}
	public static BV_RFCQ_DEALER_SELECTION_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= BV_RFCQ_DEALER_SELECTION_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
