package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_FILL_STATUS_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_FILL_STATUS_Active(0),
	@SerializedName("1")
	TI_FILL_STATUS_Cancelled(1),
	@SerializedName("2")
	TI_FILL_STATUS_Restored(2),
	@SerializedName("3")
	TI_FILL_STATUS_CancelledForSplit(3),
	@SerializedName("4")
	TI_FILL_STATUS_Modified(4);

	private int value;

	TI_FILL_STATUS_Enum(int value)
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
		if (value == TI_FILL_STATUS_Active.ordinal())
			return "Active";
		if (value == TI_FILL_STATUS_Cancelled.ordinal())
			return "Cancelled";
		if (value == TI_FILL_STATUS_Restored.ordinal())
			return "Restored";
		if (value == TI_FILL_STATUS_CancelledForSplit.ordinal())
			return "Cancelled - Split";
		if (value == TI_FILL_STATUS_Modified.ordinal())
			return "Modified";
		return "";
	}
	public static TI_FILL_STATUS_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_FILL_STATUS_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
