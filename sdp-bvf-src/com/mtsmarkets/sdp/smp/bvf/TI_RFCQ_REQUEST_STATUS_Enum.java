package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_RFCQ_REQUEST_STATUS_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_RFCQ_REQUEST_STATUS_Processing(0),
	@SerializedName("1")
	TI_RFCQ_REQUEST_STATUS_Accepted(1),
	@SerializedName("2")
	TI_RFCQ_REQUEST_STATUS_LifeTimeout(2),
	@SerializedName("3")
	TI_RFCQ_REQUEST_STATUS_Closed(3),
	@SerializedName("4")
	TI_RFCQ_REQUEST_STATUS_RefusedByAll(4),
	@SerializedName("5")
	TI_RFCQ_REQUEST_STATUS_RejectedBySystem(5),
	@SerializedName("6")
	TI_RFCQ_REQUEST_STATUS_ClosedByGovernance(6),
	@SerializedName("7")
	TI_RFCQ_REQUEST_STATUS_ClosedBySystem(7),
	@SerializedName("8")
	TI_RFCQ_REQUEST_STATUS_DeletedByGovernance(8),
	@SerializedName("9")
	TI_RFCQ_REQUEST_STATUS_Matched(9),
	@SerializedName("10")
	TI_RFCQ_REQUEST_STATUS_PartiallyAccepted(10),
	@SerializedName("11")
	TI_RFCQ_REQUEST_STATUS_WaitingForStart(11),
	@SerializedName("12")
	TI_RFCQ_REQUEST_STATUS_NotTradable(12),
	@SerializedName("13")
	TI_RFCQ_REQUEST_STATUS_ClosedBySponsor(13),
	@SerializedName("14")
	TI_RFCQ_REQUEST_STATUS_PreTrade(14),
	@SerializedName("15")
	TI_RFCQ_REQUEST_STATUS_PreTradeQuoteSelectable(15);

	private int value;

	TI_RFCQ_REQUEST_STATUS_Enum(int value)
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
		if (value == TI_RFCQ_REQUEST_STATUS_Processing.ordinal())
			return "Pending";
		if (value == TI_RFCQ_REQUEST_STATUS_Accepted.ordinal())
			return "Done";
		if (value == TI_RFCQ_REQUEST_STATUS_LifeTimeout.ordinal())
			return "Expired";
		if (value == TI_RFCQ_REQUEST_STATUS_Closed.ordinal())
			return "Closed by Client";
		if (value == TI_RFCQ_REQUEST_STATUS_RefusedByAll.ordinal())
			return "Reject by All";
		if (value == TI_RFCQ_REQUEST_STATUS_RejectedBySystem.ordinal())
			return "Expired";
		if (value == TI_RFCQ_REQUEST_STATUS_ClosedByGovernance.ordinal())
			return "Reject by Gov.nce";
		if (value == TI_RFCQ_REQUEST_STATUS_ClosedBySystem.ordinal())
			return "Reject by System";
		if (value == TI_RFCQ_REQUEST_STATUS_DeletedByGovernance.ordinal())
			return "Stop by Gov.nce";
		if (value == TI_RFCQ_REQUEST_STATUS_Matched.ordinal())
			return "Daw";
		if (value == TI_RFCQ_REQUEST_STATUS_PartiallyAccepted.ordinal())
			return "Done";
		if (value == TI_RFCQ_REQUEST_STATUS_WaitingForStart.ordinal())
			return "Due In Time";
		if (value == TI_RFCQ_REQUEST_STATUS_NotTradable.ordinal())
			return "Not Tradable";
		if (value == TI_RFCQ_REQUEST_STATUS_ClosedBySponsor.ordinal())
			return "Closed By Sponsor";
		if (value == TI_RFCQ_REQUEST_STATUS_PreTrade.ordinal())
			return "Pre-Trade";
		if (value == TI_RFCQ_REQUEST_STATUS_PreTradeQuoteSelectable.ordinal())
			return "Quote Selectable";
		return "";
	}
	public static TI_RFCQ_REQUEST_STATUS_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_RFCQ_REQUEST_STATUS_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
