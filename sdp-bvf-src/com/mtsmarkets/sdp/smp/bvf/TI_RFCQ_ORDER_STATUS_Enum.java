package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_RFCQ_ORDER_STATUS_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_RFCQ_ORDER_STATUS_Processing(0),
	@SerializedName("1")
	TI_RFCQ_ORDER_STATUS_Refused(1),
	@SerializedName("2")
	TI_RFCQ_ORDER_STATUS_RFCQRefused(2),
	@SerializedName("3")
	TI_RFCQ_ORDER_STATUS_CompletelyFilled(3),
	@SerializedName("4")
	TI_RFCQ_ORDER_STATUS_ManuallyCompletelyFilled(4),
	@SerializedName("5")
	TI_RFCQ_ORDER_STATUS_PartiallyFilled(5),
	@SerializedName("6")
	TI_RFCQ_ORDER_STATUS_ZeroFilled(6),
	@SerializedName("7")
	TI_RFCQ_ORDER_STATUS_RefusedForRFCQTimeout(7),
	@SerializedName("8")
	TI_RFCQ_ORDER_STATUS_RefusedForAcceptanceTimeout(8),
	@SerializedName("9")
	TI_RFCQ_ORDER_STATUS_RefusedBySystem(9),
	@SerializedName("10")
	TI_RFCQ_ORDER_STATUS_DeletedByGovernance(10),
	@SerializedName("11")
	TI_RFCQ_ORDER_STATUS_DeletedForSuspension(11),
	@SerializedName("12")
	TI_RFCQ_ORDER_STATUS_PreTradeTransparencyTime(12);

	private int value;

	TI_RFCQ_ORDER_STATUS_Enum(int value)
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
		if (value == TI_RFCQ_ORDER_STATUS_Processing.ordinal())
			return "Pending....";
		if (value == TI_RFCQ_ORDER_STATUS_Refused.ordinal())
			return "Reject";
		if (value == TI_RFCQ_ORDER_STATUS_RFCQRefused.ordinal())
			return "Reject";
		if (value == TI_RFCQ_ORDER_STATUS_CompletelyFilled.ordinal())
			return "Done - Auto";
		if (value == TI_RFCQ_ORDER_STATUS_ManuallyCompletelyFilled.ordinal())
			return "Done - Manual";
		if (value == TI_RFCQ_ORDER_STATUS_PartiallyFilled.ordinal())
			return "Partially Filled";
		if (value == TI_RFCQ_ORDER_STATUS_ZeroFilled.ordinal())
			return "Zero Filled";
		if (value == TI_RFCQ_ORDER_STATUS_RefusedForRFCQTimeout.ordinal())
			return "Expired";
		if (value == TI_RFCQ_ORDER_STATUS_RefusedForAcceptanceTimeout.ordinal())
			return "Timeout";
		if (value == TI_RFCQ_ORDER_STATUS_RefusedBySystem.ordinal())
			return "Reject by System";
		if (value == TI_RFCQ_ORDER_STATUS_DeletedByGovernance.ordinal())
			return "Reject by Gov.nce";
		if (value == TI_RFCQ_ORDER_STATUS_DeletedForSuspension.ordinal())
			return "Reject - Order Suspended";
		if (value == TI_RFCQ_ORDER_STATUS_PreTradeTransparencyTime.ordinal())
			return "Pre-Trade Transparency Time";
		return "";
	}
	public static TI_RFCQ_ORDER_STATUS_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_RFCQ_ORDER_STATUS_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
