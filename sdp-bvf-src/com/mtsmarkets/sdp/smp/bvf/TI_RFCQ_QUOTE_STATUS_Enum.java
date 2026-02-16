package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_RFCQ_QUOTE_STATUS_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_RFCQ_QUOTE_STATUS_Active(0),
	@SerializedName("1")
	TI_RFCQ_QUOTE_STATUS_Suspended(1),
	@SerializedName("2")
	TI_RFCQ_QUOTE_STATUS_DeletedByGovernance(2),
	@SerializedName("3")
	TI_RFCQ_QUOTE_STATUS_CompletelyFilled(3),
	@SerializedName("4")
	TI_RFCQ_QUOTE_STATUS_ManuallyCompletelyFilled(4),
	@SerializedName("5")
	TI_RFCQ_QUOTE_STATUS_Locked(5),
	@SerializedName("6")
	TI_RFCQ_QUOTE_STATUS_Deleted(6);

	private int value;

	TI_RFCQ_QUOTE_STATUS_Enum(int value)
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
		if (value == TI_RFCQ_QUOTE_STATUS_Active.ordinal())
			return "Active";
		if (value == TI_RFCQ_QUOTE_STATUS_Suspended.ordinal())
			return "Suspended";
		if (value == TI_RFCQ_QUOTE_STATUS_DeletedByGovernance.ordinal())
			return "Deleted by Gov.nce";
		if (value == TI_RFCQ_QUOTE_STATUS_CompletelyFilled.ordinal())
			return "Done - Auto";
		if (value == TI_RFCQ_QUOTE_STATUS_ManuallyCompletelyFilled.ordinal())
			return "Done - Manual";
		if (value == TI_RFCQ_QUOTE_STATUS_Locked.ordinal())
			return "Pending Acceptance";
		if (value == TI_RFCQ_QUOTE_STATUS_Deleted.ordinal())
			return "Deleted";
		return "";
	}
	public static TI_RFCQ_QUOTE_STATUS_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_RFCQ_QUOTE_STATUS_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
