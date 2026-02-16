package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_Enum implements SMPEnum
{
	@SerializedName("0")
	BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_None(0),
	@SerializedName("1")
	BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_AssetClass(1),
	@SerializedName("2")
	BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_Currency(2),
	@SerializedName("3")
	BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_ResidualMaturity(3),
	@SerializedName("4")
	BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_Size(4),
	@SerializedName("5")
	BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_DV01(5),
	@SerializedName("6")
	BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_NoBestQuotes(6),
	@SerializedName("7")
	BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_NoDealerGroupSelection(7),
	@SerializedName("8")
	BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_HitRatePickUpRate(8),
	@SerializedName("9")
	BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_NotEnoughDealersSelected(9),
	@SerializedName("10")
	BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_SettlementDate(10),
	@SerializedName("11")
	BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_InvalidInvDecId(11),
	@SerializedName("12")
	BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_InvalidOrderExecId(12),
	@SerializedName("13")
	BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_InvalidClientId(13),
	@SerializedName("14")
	BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_InvalidClientIdType(14),
	@SerializedName("15")
	BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_InvalidTradingCapacity(15),
	@SerializedName("16")
	BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_IncompatibleTradingCapacity(16),
	@SerializedName("17")
	BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_InvalidShortSellingInd(17),
	@SerializedName("18")
	BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_NotEnoughDealerResponses(18),
	@SerializedName("19")
	BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_OnlySubjectQuotes(19),
	@SerializedName("20")
	BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_WideSpread(20),
	@SerializedName("21")
	BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_BVBestOutOfRange(21),
	@SerializedName("22")
	BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_CMFBestOutOfRange(22),
	@SerializedName("23")
	BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_LimitPrice(23),
	@SerializedName("24")
	BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_DealerPriceNoLongerAvailable(24),
	@SerializedName("25")
	BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_SubjectQuoteNotAcceptedByDealer(25),
	@SerializedName("26")
	BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_RFQRefusedByAll(26),
	@SerializedName("27")
	BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_ClosedByGovernance(27),
	@SerializedName("28")
	BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_RejectedBySystem(28),
	@SerializedName("29")
	BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_DeletedByGovernance(29),
	@SerializedName("30")
	BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_OrderKilled(30),
	@SerializedName("31")
	BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_ExecutionTimeNotEligible(31),
	@SerializedName("32")
	BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_DealerAxe(32),
	@SerializedName("33")
	BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_BVCompositeNotEligible(33),
	@SerializedName("34")
	BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_ManualOverrideGeneratedRejection(34);

	private int value;

	BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_Enum(int value)
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
		if (value == BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_None.ordinal())
			return "None";
		if (value == BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_AssetClass.ordinal())
			return "Asset Class & Sub-Section Not Eligible";
		if (value == BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_Currency.ordinal())
			return "Currency Not Eligible";
		if (value == BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_ResidualMaturity.ordinal())
			return "Residual Maturity Not Eligible";
		if (value == BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_Size.ordinal())
			return "Size Not Eligible";
		if (value == BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_DV01.ordinal())
			return "DV01 Not Eligible";
		if (value == BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_NoBestQuotes.ordinal())
			return "Best Quotes Dealer Selection not available";
		if (value == BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_NoDealerGroupSelection.ordinal())
			return "Not enough Dealers available in the Group";
		if (value == BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_HitRatePickUpRate.ordinal())
			return "Dealer Hit Rate/Pick up Rate not satisfied";
		if (value == BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_NotEnoughDealersSelected.ordinal())
			return "Not enough Dealers selected";
		if (value == BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_SettlementDate.ordinal())
			return "Invalid Settlement Date";
		if (value == BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_InvalidInvDecId.ordinal())
			return "Invalid Investment Decision Id";
		if (value == BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_InvalidOrderExecId.ordinal())
			return "Invalid Order Execution Id";
		if (value == BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_InvalidClientId.ordinal())
			return "Invalid Client Id";
		if (value == BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_InvalidClientIdType.ordinal())
			return "Invalid Client ID Type";
		if (value == BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_InvalidTradingCapacity.ordinal())
			return "Invalid Trading Capacity";
		if (value == BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_IncompatibleTradingCapacity.ordinal())
			return "Trading Capacity and Client ID not compatible";
		if (value == BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_InvalidShortSellingInd.ordinal())
			return "Invalid Short Selling Indicator";
		if (value == BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_NotEnoughDealerResponses.ordinal())
			return "Not enough Dealer responses";
		if (value == BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_OnlySubjectQuotes.ordinal())
			return "Only subject quotes available";
		if (value == BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_WideSpread.ordinal())
			return "Spreads too wide to execute";
		if (value == BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_BVBestOutOfRange.ordinal())
			return "Execution vs. Benchmark - BondVision Composite: out of range";
		if (value == BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_CMFBestOutOfRange.ordinal())
			return "Execution vs. Benchmark - MTS Cash: out of range";
		if (value == BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_LimitPrice.ordinal())
			return "Limit Price/Yield not reached";
		if (value == BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_DealerPriceNoLongerAvailable.ordinal())
			return "Dealer Price no longer available";
		if (value == BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_SubjectQuoteNotAcceptedByDealer.ordinal())
			return "Subject Quote not accepted by Dealer";
		if (value == BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_RFQRefusedByAll.ordinal())
			return "RFQ refused by all dealers";
		if (value == BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_ClosedByGovernance.ordinal())
			return "Rejected by Governance";
		if (value == BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_RejectedBySystem.ordinal())
			return "Rejected by System";
		if (value == BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_DeletedByGovernance.ordinal())
			return "Stopped by Governance";
		if (value == BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_OrderKilled.ordinal())
			return "OrderKilled";
		if (value == BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_ExecutionTimeNotEligible.ordinal())
			return "Execution Time Not Eligible";
		if (value == BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_DealerAxe.ordinal())
			return "Insufficient Dealer Axe Size";
		if (value == BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_BVCompositeNotEligible.ordinal())
			return "BondVision Composite Bid/Ask Not Eligible";
		if (value == BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_ManualOverrideGeneratedRejection.ordinal())
			return "Manual Override Generated Rejection";
		return "";
	}
	public static BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
