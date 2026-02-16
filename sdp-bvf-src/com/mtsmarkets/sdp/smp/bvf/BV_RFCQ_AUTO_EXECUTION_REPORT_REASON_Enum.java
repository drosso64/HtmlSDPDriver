package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum BV_RFCQ_AUTO_EXECUTION_REPORT_REASON_Enum implements SMPEnum
{
	@SerializedName("0")
	BV_RFCQ_AUTO_EXECUTION_REPORT_REASON_None(0),
	@SerializedName("1")
	BV_RFCQ_AUTO_EXECUTION_REPORT_REASON_EligibilityCriteria(1),
	@SerializedName("2")
	BV_RFCQ_AUTO_EXECUTION_REPORT_REASON_DealerSelectionCriteria(2),
	@SerializedName("3")
	BV_RFCQ_AUTO_EXECUTION_REPORT_REASON_InvalidSettlementDate(3),
	@SerializedName("4")
	BV_RFCQ_AUTO_EXECUTION_REPORT_REASON_NoMiFIDInfo(4),
	@SerializedName("5")
	BV_RFCQ_AUTO_EXECUTION_REPORT_REASON_ExecutionCriteria(5),
	@SerializedName("6")
	BV_RFCQ_AUTO_EXECUTION_REPORT_REASON_StageOrderLimit(6),
	@SerializedName("7")
	BV_RFCQ_AUTO_EXECUTION_REPORT_REASON_RefusedByAll(7),
	@SerializedName("8")
	BV_RFCQ_AUTO_EXECUTION_REPORT_REASON_RejectedByGovernance(8),
	@SerializedName("9")
	BV_RFCQ_AUTO_EXECUTION_REPORT_REASON_RejectedBySystem(9),
	@SerializedName("10")
	BV_RFCQ_AUTO_EXECUTION_REPORT_REASON_StoppedByGovernance(10),
	@SerializedName("11")
	BV_RFCQ_AUTO_EXECUTION_REPORT_REASON_OrderKilled(11);

	private int value;

	BV_RFCQ_AUTO_EXECUTION_REPORT_REASON_Enum(int value)
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
		if (value == BV_RFCQ_AUTO_EXECUTION_REPORT_REASON_None.ordinal())
			return "None";
		if (value == BV_RFCQ_AUTO_EXECUTION_REPORT_REASON_EligibilityCriteria.ordinal())
			return "Eligibility Criteria not Fulfilled";
		if (value == BV_RFCQ_AUTO_EXECUTION_REPORT_REASON_DealerSelectionCriteria.ordinal())
			return "Dealer Selection Criteria Not Fulfilled";
		if (value == BV_RFCQ_AUTO_EXECUTION_REPORT_REASON_InvalidSettlementDate.ordinal())
			return "Invalid Settlement Date";
		if (value == BV_RFCQ_AUTO_EXECUTION_REPORT_REASON_NoMiFIDInfo.ordinal())
			return "No MiFID Info Available";
		if (value == BV_RFCQ_AUTO_EXECUTION_REPORT_REASON_ExecutionCriteria.ordinal())
			return "Execution Criteria Not Fulfilled";
		if (value == BV_RFCQ_AUTO_EXECUTION_REPORT_REASON_StageOrderLimit.ordinal())
			return "Stage Order Quotation Limit";
		if (value == BV_RFCQ_AUTO_EXECUTION_REPORT_REASON_RefusedByAll.ordinal())
			return "Refused by All Dealers";
		if (value == BV_RFCQ_AUTO_EXECUTION_REPORT_REASON_RejectedByGovernance.ordinal())
			return "Reject by Governance";
		if (value == BV_RFCQ_AUTO_EXECUTION_REPORT_REASON_RejectedBySystem.ordinal())
			return "Reject by System";
		if (value == BV_RFCQ_AUTO_EXECUTION_REPORT_REASON_StoppedByGovernance.ordinal())
			return "Stop by Governance";
		if (value == BV_RFCQ_AUTO_EXECUTION_REPORT_REASON_OrderKilled.ordinal())
			return "Order Killed";
		return "";
	}
	public static BV_RFCQ_AUTO_EXECUTION_REPORT_REASON_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= BV_RFCQ_AUTO_EXECUTION_REPORT_REASON_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
