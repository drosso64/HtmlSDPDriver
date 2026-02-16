package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_FUNCTION_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_FUNCTION_FirmQuote(0),
	@SerializedName("1")
	TI_FUNCTION_FASOrders(1),
	@SerializedName("2")
	TI_FUNCTION_Orders(2),
	@SerializedName("3")
	TI_FUNCTION_RFQSend(3),
	@SerializedName("4")
	TI_FUNCTION_RFQRespond(4),
	@SerializedName("5")
	TI_FUNCTION_RFCQSend(5),
	@SerializedName("6")
	TI_FUNCTION_RFCQRespond(6),
	@SerializedName("7")
	TI_FUNCTION_NotUsed(7),
	@SerializedName("8")
	TI_FUNCTION_InventoryQuote(8),
	@SerializedName("9")
	TI_FUNCTION_StageOrders(9),
	@SerializedName("10")
	TI_FUNCTION_SplitFill(10),
	@SerializedName("11")
	TI_FUNCTION_AccountDefinition(11),
	@SerializedName("12")
	TI_FUNCTION_UserPortfolioDefinition(12),
	@SerializedName("13")
	TI_FUNCTION_TradingRelationship(13),
	@SerializedName("14")
	TI_FUNCTION_TradingCaps(14),
	@SerializedName("15")
	TI_FUNCTION_PrivateInfo(15),
	@SerializedName("16")
	TI_FUNCTION_PublicInfo(16),
	@SerializedName("17")
	TI_FUNCTION_Governance(17),
	@SerializedName("18")
	TI_FUNCTION_FutureBridge(18),
	@SerializedName("19")
	TI_FUNCTION_TraderConfiguration(19),
	@SerializedName("20")
	TI_FUNCTION_Datafeed(20),
	@SerializedName("21")
	TI_FUNCTION_PriceContribution(21),
	@SerializedName("22")
	TI_FUNCTION_FinancialCalculation(22),
	@SerializedName("23")
	TI_FUNCTION_StrikerFirmQuote(23),
	@SerializedName("24")
	TI_FUNCTION_StrikerFASOrder(24),
	@SerializedName("25")
	TI_FUNCTION_MidPriceFASOrder(25),
	@SerializedName("26")
	TI_FUNCTION_MidPriceFOKOrder(26),
	@SerializedName("27")
	TI_FUNCTION_InventoryOrderSend(27),
	@SerializedName("28")
	TI_FUNCTION_InventoryOrderRespond(28),
	@SerializedName("29")
	TI_FUNCTION_IOI(29),
	@SerializedName("30")
	TI_FUNCTION_OTC(30),
	@SerializedName("31")
	TI_FUNCTION_CashOffer(31),
	@SerializedName("32")
	TI_FUNCTION_CollateralOffer(32),
	@SerializedName("33")
	TI_FUNCTION_EOIMessage(33),
	@SerializedName("34")
	TI_FUNCTION_CounterpartyRestriction(34);

	private int value;

	TI_FUNCTION_Enum(int value)
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
		if (value == TI_FUNCTION_FirmQuote.ordinal())
			return "Firm quote";
		if (value == TI_FUNCTION_FASOrders.ordinal())
			return "FAS orders";
		if (value == TI_FUNCTION_Orders.ordinal())
			return "FAK/AON orders";
		if (value == TI_FUNCTION_RFQSend.ordinal())
			return "RFQ Send";
		if (value == TI_FUNCTION_RFQRespond.ordinal())
			return "RFQ Respond";
		if (value == TI_FUNCTION_RFCQSend.ordinal())
			return "RFCQ Send";
		if (value == TI_FUNCTION_RFCQRespond.ordinal())
			return "RFCQ Respond";
		if (value == TI_FUNCTION_NotUsed.ordinal())
			return "Not Used";
		if (value == TI_FUNCTION_InventoryQuote.ordinal())
			return "Inventory quote";
		if (value == TI_FUNCTION_StageOrders.ordinal())
			return "Stage Orders";
		if (value == TI_FUNCTION_SplitFill.ordinal())
			return "Split Fill";
		if (value == TI_FUNCTION_AccountDefinition.ordinal())
			return "Account Definition";
		if (value == TI_FUNCTION_UserPortfolioDefinition.ordinal())
			return "User Portfolio Definition";
		if (value == TI_FUNCTION_TradingRelationship.ordinal())
			return "Trading Relationship";
		if (value == TI_FUNCTION_TradingCaps.ordinal())
			return "Trading Caps";
		if (value == TI_FUNCTION_PrivateInfo.ordinal())
			return "Private Info";
		if (value == TI_FUNCTION_PublicInfo.ordinal())
			return "Public Info";
		if (value == TI_FUNCTION_Governance.ordinal())
			return "Governance";
		if (value == TI_FUNCTION_FutureBridge.ordinal())
			return "FutureBridge";
		if (value == TI_FUNCTION_TraderConfiguration.ordinal())
			return "Trader Configuration";
		if (value == TI_FUNCTION_Datafeed.ordinal())
			return "Datafeed";
		if (value == TI_FUNCTION_PriceContribution.ordinal())
			return "Price Contribution";
		if (value == TI_FUNCTION_FinancialCalculation.ordinal())
			return "Financial Calculation";
		if (value == TI_FUNCTION_StrikerFirmQuote.ordinal())
			return "Striker firm quote";
		if (value == TI_FUNCTION_StrikerFASOrder.ordinal())
			return "Striker FAS order";
		if (value == TI_FUNCTION_MidPriceFASOrder.ordinal())
			return "Mid price FAS order";
		if (value == TI_FUNCTION_MidPriceFOKOrder.ordinal())
			return "Mid price FOK order";
		if (value == TI_FUNCTION_InventoryOrderSend.ordinal())
			return "Inventory order send";
		if (value == TI_FUNCTION_InventoryOrderRespond.ordinal())
			return "Inventory order respond";
		if (value == TI_FUNCTION_IOI.ordinal())
			return "IOI - Indication of Interest";
		if (value == TI_FUNCTION_OTC.ordinal())
			return "OTC";
		if (value == TI_FUNCTION_CashOffer.ordinal())
			return "Cash Offer";
		if (value == TI_FUNCTION_CollateralOffer.ordinal())
			return "Collateral Offer";
		if (value == TI_FUNCTION_EOIMessage.ordinal())
			return "EOI-Message";
		if (value == TI_FUNCTION_CounterpartyRestriction.ordinal())
			return "Counterparty Restriction";
		return "";
	}
	public static TI_FUNCTION_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_FUNCTION_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
