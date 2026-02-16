package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_RFCQ_PROVIDER_STATUS_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_RFCQ_PROVIDER_STATUS_Processing(0),
	@SerializedName("1")
	TI_RFCQ_PROVIDER_STATUS_Quoting(1),
	@SerializedName("2")
	TI_RFCQ_PROVIDER_STATUS_Accepted(2),
	@SerializedName("3")
	TI_RFCQ_PROVIDER_STATUS_Matched(3),
	@SerializedName("4")
	TI_RFCQ_PROVIDER_STATUS_Closed(4),
	@SerializedName("5")
	TI_RFCQ_PROVIDER_STATUS_Refused(5),
	@SerializedName("6")
	TI_RFCQ_PROVIDER_STATUS_Timeout(6),
	@SerializedName("7")
	TI_RFCQ_PROVIDER_STATUS_DeletedByGovernance(7),
	@SerializedName("8")
	TI_RFCQ_PROVIDER_STATUS_InvalidMember(8),
	@SerializedName("9")
	TI_RFCQ_PROVIDER_STATUS_Disconnected(9),
	@SerializedName("10")
	TI_RFCQ_PROVIDER_STATUS_NoTradingRelation(10),
	@SerializedName("11")
	TI_RFCQ_PROVIDER_STATUS_InvalidAccount(11),
	@SerializedName("12")
	TI_RFCQ_PROVIDER_STATUS_InvalidSettlDate(12),
	@SerializedName("13")
	TI_RFCQ_PROVIDER_STATUS_ClosedByGovernance(13),
	@SerializedName("14")
	TI_RFCQ_PROVIDER_STATUS_MemberNotEnabled(14),
	@SerializedName("15")
	TI_RFCQ_PROVIDER_STATUS_RefusedToQuote(15),
	@SerializedName("16")
	TI_RFCQ_PROVIDER_STATUS_Quoted(16),
	@SerializedName("17")
	TI_RFCQ_PROVIDER_STATUS_Winner(17),
	@SerializedName("18")
	TI_RFCQ_PROVIDER_STATUS_ClosedBySystem(18),
	@SerializedName("19")
	TI_RFCQ_PROVIDER_STATUS_DisabledRfcqType(19),
	@SerializedName("20")
	TI_RFCQ_PROVIDER_STATUS_UnseasonedNotEnabled(20),
	@SerializedName("21")
	TI_RFCQ_PROVIDER_STATUS_DisablePartialFill(21),
	@SerializedName("22")
	TI_RFCQ_PROVIDER_STATUS_RejectPreTradeTransparency(22);

	private int value;

	TI_RFCQ_PROVIDER_STATUS_Enum(int value)
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
		if (value == TI_RFCQ_PROVIDER_STATUS_Processing.ordinal())
			return "Pending";
		if (value == TI_RFCQ_PROVIDER_STATUS_Quoting.ordinal())
			return "Quote";
		if (value == TI_RFCQ_PROVIDER_STATUS_Accepted.ordinal())
			return "Done";
		if (value == TI_RFCQ_PROVIDER_STATUS_Matched.ordinal())
			return "DAW";
		if (value == TI_RFCQ_PROVIDER_STATUS_Closed.ordinal())
			return "Reject by Client";
		if (value == TI_RFCQ_PROVIDER_STATUS_Refused.ordinal())
			return "Reject by Dealer";
		if (value == TI_RFCQ_PROVIDER_STATUS_Timeout.ordinal())
			return "Expired";
		if (value == TI_RFCQ_PROVIDER_STATUS_DeletedByGovernance.ordinal())
			return "Stop by Gov.nce";
		if (value == TI_RFCQ_PROVIDER_STATUS_InvalidMember.ordinal())
			return "Invalid Dealer";
		if (value == TI_RFCQ_PROVIDER_STATUS_Disconnected.ordinal())
			return "Dealer not online";
		if (value == TI_RFCQ_PROVIDER_STATUS_NoTradingRelation.ordinal())
			return "Dealer not enabled";
		if (value == TI_RFCQ_PROVIDER_STATUS_InvalidAccount.ordinal())
			return "Invalid Account";
		if (value == TI_RFCQ_PROVIDER_STATUS_InvalidSettlDate.ordinal())
			return "Invalid Settl Date";
		if (value == TI_RFCQ_PROVIDER_STATUS_ClosedByGovernance.ordinal())
			return "Dealer Suspended";
		if (value == TI_RFCQ_PROVIDER_STATUS_MemberNotEnabled.ordinal())
			return "Dealer not enabled";
		if (value == TI_RFCQ_PROVIDER_STATUS_RefusedToQuote.ordinal())
			return "Reject by Dealer";
		if (value == TI_RFCQ_PROVIDER_STATUS_Quoted.ordinal())
			return "Quote";
		if (value == TI_RFCQ_PROVIDER_STATUS_Winner.ordinal())
			return "Done";
		if (value == TI_RFCQ_PROVIDER_STATUS_ClosedBySystem.ordinal())
			return "Reject by System";
		if (value == TI_RFCQ_PROVIDER_STATUS_DisabledRfcqType.ordinal())
			return "Function not enabled";
		if (value == TI_RFCQ_PROVIDER_STATUS_UnseasonedNotEnabled.ordinal())
			return "Unseasoned not enabled";
		if (value == TI_RFCQ_PROVIDER_STATUS_DisablePartialFill.ordinal())
			return "Dealer Not enabled to Partial Fill";
		if (value == TI_RFCQ_PROVIDER_STATUS_RejectPreTradeTransparency.ordinal())
			return "Reject Pre-Trade";
		return "";
	}
	public static TI_RFCQ_PROVIDER_STATUS_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_RFCQ_PROVIDER_STATUS_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
