package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_TRADING_FUNCTION_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_TRADING_FUNCTION_FirmQuote(0),
	@SerializedName("1")
	TI_TRADING_FUNCTION_FASOrders(1),
	@SerializedName("2")
	TI_TRADING_FUNCTION_Orders(2),
	@SerializedName("3")
	TI_TRADING_FUNCTION_RFQ(3),
	@SerializedName("4")
	TI_TRADING_FUNCTION_RFCQ(4),
	@SerializedName("5")
	TI_TRADING_FUNCTION_NotUsed(5),
	@SerializedName("6")
	TI_TRADING_FUNCTION_InventoryQuote(6),
	@SerializedName("7")
	TI_TRADING_FUNCTION_StageOrder(7),
	@SerializedName("8")
	TI_TRADING_FUNCTION_SplitFill(8),
	@SerializedName("9")
	TI_TRADING_FUNCTION_StrikerFirmQuote(9),
	@SerializedName("10")
	TI_TRADING_FUNCTION_StrikerFASOrder(10),
	@SerializedName("11")
	TI_TRADING_FUNCTION_MidPriceFASOrder(11),
	@SerializedName("12")
	TI_TRADING_FUNCTION_MidPriceFOKOrder(12),
	@SerializedName("13")
	TI_TRADING_FUNCTION_InventoryOrder(13);

	private int value;

	TI_TRADING_FUNCTION_Enum(int value)
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
		if (value == TI_TRADING_FUNCTION_FirmQuote.ordinal())
			return "Firm quote";
		if (value == TI_TRADING_FUNCTION_FASOrders.ordinal())
			return "FAS orders";
		if (value == TI_TRADING_FUNCTION_Orders.ordinal())
			return "FAK/AON orders";
		if (value == TI_TRADING_FUNCTION_RFQ.ordinal())
			return "RFQ";
		if (value == TI_TRADING_FUNCTION_RFCQ.ordinal())
			return "RFCQ";
		if (value == TI_TRADING_FUNCTION_NotUsed.ordinal())
			return "Not Used";
		if (value == TI_TRADING_FUNCTION_InventoryQuote.ordinal())
			return "Inventory quote";
		if (value == TI_TRADING_FUNCTION_StageOrder.ordinal())
			return "Stage Orders";
		if (value == TI_TRADING_FUNCTION_SplitFill.ordinal())
			return "Split Fill";
		if (value == TI_TRADING_FUNCTION_StrikerFirmQuote.ordinal())
			return "Striker Firm Quote";
		if (value == TI_TRADING_FUNCTION_StrikerFASOrder.ordinal())
			return "Striker FAS Order";
		if (value == TI_TRADING_FUNCTION_MidPriceFASOrder.ordinal())
			return "Mid price FAS Order";
		if (value == TI_TRADING_FUNCTION_MidPriceFOKOrder.ordinal())
			return "Mid price FOK Order";
		if (value == TI_TRADING_FUNCTION_InventoryOrder.ordinal())
			return "Inventory Order";
		return "";
	}
	public static TI_TRADING_FUNCTION_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_TRADING_FUNCTION_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
