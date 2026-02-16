package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_TXN_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_TXN_TYPE_Quote(0),
	@SerializedName("1")
	TI_TXN_TYPE_Order(1),
	@SerializedName("2")
	TI_TXN_TYPE_Rfq(2),
	@SerializedName("3")
	TI_TXN_TYPE_FasOrder(3),
	@SerializedName("4")
	TI_TXN_TYPE_Rfcq(4),
	@SerializedName("5")
	TI_TXN_TYPE_RfcqOrder(5),
	@SerializedName("6")
	TI_TXN_TYPE_RfcqQuote(6),
	@SerializedName("7")
	TI_TXN_TYPE_OTC(7),
	@SerializedName("8")
	TI_TXN_TYPE_MidPriceFASOrder(8),
	@SerializedName("9")
	TI_TXN_TYPE_MidPriceFOKOrder(9),
	@SerializedName("10")
	TI_TXN_TYPE_InventoryOrder(10),
	@SerializedName("11")
	TI_TXN_TYPE_CashOffer(11),
	@SerializedName("12")
	TI_TXN_TYPE_CollateralOffer(12),
	@SerializedName("13")
	TI_TXN_TYPE_RFCQPortfolioQuote(13),
	@SerializedName("14")
	TI_TXN_TYPE_RFCQPortfolioOrder(14),
	@SerializedName("15")
	TI_TXN_TYPE_RFCQMarketOnClose(15);

	private int value;

	TI_TXN_TYPE_Enum(int value)
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
		if (value == TI_TXN_TYPE_Quote.ordinal())
			return "Quote";
		if (value == TI_TXN_TYPE_Order.ordinal())
			return "Order";
		if (value == TI_TXN_TYPE_Rfq.ordinal())
			return "Rfq";
		if (value == TI_TXN_TYPE_FasOrder.ordinal())
			return "FAS Order";
		if (value == TI_TXN_TYPE_Rfcq.ordinal())
			return "RFCQ";
		if (value == TI_TXN_TYPE_RfcqOrder.ordinal())
			return "RFCQ Order";
		if (value == TI_TXN_TYPE_RfcqQuote.ordinal())
			return "RFCQ Quote";
		if (value == TI_TXN_TYPE_OTC.ordinal())
			return "OTC";
		if (value == TI_TXN_TYPE_MidPriceFASOrder.ordinal())
			return "Mid Price FAS Order";
		if (value == TI_TXN_TYPE_MidPriceFOKOrder.ordinal())
			return "Mid Price FOK Order";
		if (value == TI_TXN_TYPE_InventoryOrder.ordinal())
			return "Inventory Order";
		if (value == TI_TXN_TYPE_CashOffer.ordinal())
			return "Auction Cash Offer";
		if (value == TI_TXN_TYPE_CollateralOffer.ordinal())
			return "Auction Collateral Offer";
		if (value == TI_TXN_TYPE_RFCQPortfolioQuote.ordinal())
			return "RFCQ Portfolio Quote";
		if (value == TI_TXN_TYPE_RFCQPortfolioOrder.ordinal())
			return "RFCQ Portfolio Order";
		if (value == TI_TXN_TYPE_RFCQMarketOnClose.ordinal())
			return "RFCQ Market On Close";
		return "";
	}
	public static TI_TXN_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_TXN_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
