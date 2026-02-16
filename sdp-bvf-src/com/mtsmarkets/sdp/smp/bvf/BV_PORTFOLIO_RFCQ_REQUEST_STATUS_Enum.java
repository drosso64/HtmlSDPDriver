package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum BV_PORTFOLIO_RFCQ_REQUEST_STATUS_Enum implements SMPEnum
{
	@SerializedName("0")
	BV_PORTFOLIO_RFCQ_REQUEST_STATUS_Processing(0),
	@SerializedName("1")
	BV_PORTFOLIO_RFCQ_REQUEST_STATUS_Error(1),
	@SerializedName("2")
	BV_PORTFOLIO_RFCQ_REQUEST_STATUS_Active(2),
	@SerializedName("3")
	BV_PORTFOLIO_RFCQ_REQUEST_STATUS_Accepted(3),
	@SerializedName("4")
	BV_PORTFOLIO_RFCQ_REQUEST_STATUS_LifeTimeout(4),
	@SerializedName("5")
	BV_PORTFOLIO_RFCQ_REQUEST_STATUS_Closed(5),
	@SerializedName("6")
	BV_PORTFOLIO_RFCQ_REQUEST_STATUS_RefusedByAll(6),
	@SerializedName("7")
	BV_PORTFOLIO_RFCQ_REQUEST_STATUS_Matched(7),
	@SerializedName("8")
	BV_PORTFOLIO_RFCQ_REQUEST_STATUS_WaitingForStart(8),
	@SerializedName("9")
	BV_PORTFOLIO_RFCQ_REQUEST_STATUS_WaitingForFixing(9),
	@SerializedName("10")
	BV_PORTFOLIO_RFCQ_REQUEST_STATUS_DeletedByGovernance(10);

	private int value;

	BV_PORTFOLIO_RFCQ_REQUEST_STATUS_Enum(int value)
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
		if (value == BV_PORTFOLIO_RFCQ_REQUEST_STATUS_Processing.ordinal())
			return "Pending";
		if (value == BV_PORTFOLIO_RFCQ_REQUEST_STATUS_Error.ordinal())
			return "Error";
		if (value == BV_PORTFOLIO_RFCQ_REQUEST_STATUS_Active.ordinal())
			return "Active";
		if (value == BV_PORTFOLIO_RFCQ_REQUEST_STATUS_Accepted.ordinal())
			return "Done";
		if (value == BV_PORTFOLIO_RFCQ_REQUEST_STATUS_LifeTimeout.ordinal())
			return "Expired";
		if (value == BV_PORTFOLIO_RFCQ_REQUEST_STATUS_Closed.ordinal())
			return "Closed by Client";
		if (value == BV_PORTFOLIO_RFCQ_REQUEST_STATUS_RefusedByAll.ordinal())
			return "Reject by All";
		if (value == BV_PORTFOLIO_RFCQ_REQUEST_STATUS_Matched.ordinal())
			return "DAW (Audit Trail Summary Only)";
		if (value == BV_PORTFOLIO_RFCQ_REQUEST_STATUS_WaitingForStart.ordinal())
			return "Due In Time";
		if (value == BV_PORTFOLIO_RFCQ_REQUEST_STATUS_WaitingForFixing.ordinal())
			return "Awaited Fixing";
		if (value == BV_PORTFOLIO_RFCQ_REQUEST_STATUS_DeletedByGovernance.ordinal())
			return "Cancelled by Governance";
		return "";
	}
	public static BV_PORTFOLIO_RFCQ_REQUEST_STATUS_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= BV_PORTFOLIO_RFCQ_REQUEST_STATUS_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
