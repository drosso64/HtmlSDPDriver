package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum BV_PORTFOLIO_RFCQ_PROVIDER_STATUS_Enum implements SMPEnum
{
	@SerializedName("0")
	BV_PORTFOLIO_RFCQ_PROVIDER_STATUS_None(0),
	@SerializedName("1")
	BV_PORTFOLIO_RFCQ_PROVIDER_STATUS_Processing(1),
	@SerializedName("2")
	BV_PORTFOLIO_RFCQ_PROVIDER_STATUS_Quoting(2),
	@SerializedName("3")
	BV_PORTFOLIO_RFCQ_PROVIDER_STATUS_Accepted(3),
	@SerializedName("4")
	BV_PORTFOLIO_RFCQ_PROVIDER_STATUS_Matched(4),
	@SerializedName("5")
	BV_PORTFOLIO_RFCQ_PROVIDER_STATUS_Closed(5),
	@SerializedName("6")
	BV_PORTFOLIO_RFCQ_PROVIDER_STATUS_Refused(6),
	@SerializedName("7")
	BV_PORTFOLIO_RFCQ_PROVIDER_STATUS_Timeout(7),
	@SerializedName("8")
	BV_PORTFOLIO_RFCQ_PROVIDER_STATUS_DeletedByGovernance(8),
	@SerializedName("9")
	BV_PORTFOLIO_RFCQ_PROVIDER_STATUS_InvalidMember(9),
	@SerializedName("10")
	BV_PORTFOLIO_RFCQ_PROVIDER_STATUS_Disconnected(10),
	@SerializedName("11")
	BV_PORTFOLIO_RFCQ_PROVIDER_STATUS_NoTradingRelation(11),
	@SerializedName("12")
	BV_PORTFOLIO_RFCQ_PROVIDER_STATUS_InvalidAccount(12),
	@SerializedName("13")
	BV_PORTFOLIO_RFCQ_PROVIDER_STATUS_InvalidSettlDate(13),
	@SerializedName("14")
	BV_PORTFOLIO_RFCQ_PROVIDER_STATUS_ClosedByGovernance(14),
	@SerializedName("15")
	BV_PORTFOLIO_RFCQ_PROVIDER_STATUS_MemberNotEnabled(15),
	@SerializedName("16")
	BV_PORTFOLIO_RFCQ_PROVIDER_STATUS_RefusedToQuote(16),
	@SerializedName("17")
	BV_PORTFOLIO_RFCQ_PROVIDER_STATUS_Quoted(17),
	@SerializedName("18")
	BV_PORTFOLIO_RFCQ_PROVIDER_STATUS_Winner(18),
	@SerializedName("19")
	BV_PORTFOLIO_RFCQ_PROVIDER_STATUS_ClosedBySystem(19),
	@SerializedName("20")
	BV_PORTFOLIO_RFCQ_PROVIDER_STATUS_DisabledRfcqType(20),
	@SerializedName("21")
	BV_PORTFOLIO_RFCQ_PROVIDER_STATUS_UnseasonedNotEnabled(21);

	private int value;

	BV_PORTFOLIO_RFCQ_PROVIDER_STATUS_Enum(int value)
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
		if (value == BV_PORTFOLIO_RFCQ_PROVIDER_STATUS_None.ordinal())
			return "None";
		if (value == BV_PORTFOLIO_RFCQ_PROVIDER_STATUS_Processing.ordinal())
			return "Pending";
		if (value == BV_PORTFOLIO_RFCQ_PROVIDER_STATUS_Quoting.ordinal())
			return "Quote";
		if (value == BV_PORTFOLIO_RFCQ_PROVIDER_STATUS_Accepted.ordinal())
			return "Done";
		if (value == BV_PORTFOLIO_RFCQ_PROVIDER_STATUS_Matched.ordinal())
			return "DAW";
		if (value == BV_PORTFOLIO_RFCQ_PROVIDER_STATUS_Closed.ordinal())
			return "Reject by Client";
		if (value == BV_PORTFOLIO_RFCQ_PROVIDER_STATUS_Refused.ordinal())
			return "Reject by Dealer";
		if (value == BV_PORTFOLIO_RFCQ_PROVIDER_STATUS_Timeout.ordinal())
			return "Expired";
		if (value == BV_PORTFOLIO_RFCQ_PROVIDER_STATUS_DeletedByGovernance.ordinal())
			return "Stop by Gov.nce";
		if (value == BV_PORTFOLIO_RFCQ_PROVIDER_STATUS_InvalidMember.ordinal())
			return "Invalid Dealer";
		if (value == BV_PORTFOLIO_RFCQ_PROVIDER_STATUS_Disconnected.ordinal())
			return "Dealer not online";
		if (value == BV_PORTFOLIO_RFCQ_PROVIDER_STATUS_NoTradingRelation.ordinal())
			return "Dealer not enabled";
		if (value == BV_PORTFOLIO_RFCQ_PROVIDER_STATUS_InvalidAccount.ordinal())
			return "Invalid Account";
		if (value == BV_PORTFOLIO_RFCQ_PROVIDER_STATUS_InvalidSettlDate.ordinal())
			return "Invalid Settl Date";
		if (value == BV_PORTFOLIO_RFCQ_PROVIDER_STATUS_ClosedByGovernance.ordinal())
			return "Dealer Suspended";
		if (value == BV_PORTFOLIO_RFCQ_PROVIDER_STATUS_MemberNotEnabled.ordinal())
			return "Dealer Not enabled";
		if (value == BV_PORTFOLIO_RFCQ_PROVIDER_STATUS_RefusedToQuote.ordinal())
			return "Reject by Dealer";
		if (value == BV_PORTFOLIO_RFCQ_PROVIDER_STATUS_Quoted.ordinal())
			return "Quote";
		if (value == BV_PORTFOLIO_RFCQ_PROVIDER_STATUS_Winner.ordinal())
			return "Done";
		if (value == BV_PORTFOLIO_RFCQ_PROVIDER_STATUS_ClosedBySystem.ordinal())
			return "Reject by System";
		if (value == BV_PORTFOLIO_RFCQ_PROVIDER_STATUS_DisabledRfcqType.ordinal())
			return "Function not enabled";
		if (value == BV_PORTFOLIO_RFCQ_PROVIDER_STATUS_UnseasonedNotEnabled.ordinal())
			return "Unseasoned not enabled";
		return "";
	}
	public static BV_PORTFOLIO_RFCQ_PROVIDER_STATUS_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= BV_PORTFOLIO_RFCQ_PROVIDER_STATUS_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
