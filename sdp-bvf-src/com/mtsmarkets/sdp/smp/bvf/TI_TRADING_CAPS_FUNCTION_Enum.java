package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_TRADING_CAPS_FUNCTION_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_TRADING_CAPS_FUNCTION_FirmQuote(0),
	@SerializedName("1")
	TI_TRADING_CAPS_FUNCTION_FASOrders(1),
	@SerializedName("2")
	TI_TRADING_CAPS_FUNCTION_Orders(2),
	@SerializedName("3")
	TI_TRADING_CAPS_FUNCTION_RFQSend(3),
	@SerializedName("4")
	TI_TRADING_CAPS_FUNCTION_RFQRespond(4),
	@SerializedName("5")
	TI_TRADING_CAPS_FUNCTION_RFCQSend(5),
	@SerializedName("6")
	TI_TRADING_CAPS_FUNCTION_RFCQRespond(6),
	@SerializedName("7")
	TI_TRADING_CAPS_FUNCTION_MultilegRFCQSend(7),
	@SerializedName("8")
	TI_TRADING_CAPS_FUNCTION_MultilegRFCQRespond(8),
	@SerializedName("9")
	TI_TRADING_CAPS_FUNCTION_NotUsed(9),
	@SerializedName("10")
	TI_TRADING_CAPS_FUNCTION_InventoryQuote(10),
	@SerializedName("11")
	TI_TRADING_CAPS_FUNCTION_StageOrders(11),
	@SerializedName("12")
	TI_TRADING_CAPS_FUNCTION_SplitFill(12),
	@SerializedName("13")
	TI_TRADING_CAPS_FUNCTION_StrikerFirmQuote(13),
	@SerializedName("14")
	TI_TRADING_CAPS_FUNCTION_StrikerFASOrder(14),
	@SerializedName("15")
	TI_TRADING_CAPS_FUNCTION_MidPriceFASOrder(15),
	@SerializedName("16")
	TI_TRADING_CAPS_FUNCTION_MidPriceFOKOrder(16),
	@SerializedName("17")
	TI_TRADING_CAPS_FUNCTION_InventoryOrderSend(17),
	@SerializedName("18")
	TI_TRADING_CAPS_FUNCTION_InventoryOrderRespond(18),
	@SerializedName("19")
	TI_TRADING_CAPS_FUNCTION_AllBVFunctions(19);

	private int value;

	TI_TRADING_CAPS_FUNCTION_Enum(int value)
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
		if (value == TI_TRADING_CAPS_FUNCTION_FirmQuote.ordinal())
			return "Firm quote";
		if (value == TI_TRADING_CAPS_FUNCTION_FASOrders.ordinal())
			return "FAS orders";
		if (value == TI_TRADING_CAPS_FUNCTION_Orders.ordinal())
			return "FAK/AON orders";
		if (value == TI_TRADING_CAPS_FUNCTION_RFQSend.ordinal())
			return "RFQ Send";
		if (value == TI_TRADING_CAPS_FUNCTION_RFQRespond.ordinal())
			return "RFQ Respond";
		if (value == TI_TRADING_CAPS_FUNCTION_RFCQSend.ordinal())
			return "RFCQ Send";
		if (value == TI_TRADING_CAPS_FUNCTION_RFCQRespond.ordinal())
			return "RFCQ Respond";
		if (value == TI_TRADING_CAPS_FUNCTION_MultilegRFCQSend.ordinal())
			return "Multileg RFCQ Send";
		if (value == TI_TRADING_CAPS_FUNCTION_MultilegRFCQRespond.ordinal())
			return "Multileg RFCQ Respond";
		if (value == TI_TRADING_CAPS_FUNCTION_NotUsed.ordinal())
			return "Not Used";
		if (value == TI_TRADING_CAPS_FUNCTION_InventoryQuote.ordinal())
			return "Inventory quote";
		if (value == TI_TRADING_CAPS_FUNCTION_StageOrders.ordinal())
			return "Stage Orders";
		if (value == TI_TRADING_CAPS_FUNCTION_SplitFill.ordinal())
			return "Split Fill";
		if (value == TI_TRADING_CAPS_FUNCTION_StrikerFirmQuote.ordinal())
			return "Striker firm quote";
		if (value == TI_TRADING_CAPS_FUNCTION_StrikerFASOrder.ordinal())
			return "Striker FAS order";
		if (value == TI_TRADING_CAPS_FUNCTION_MidPriceFASOrder.ordinal())
			return "Mid price FAS order";
		if (value == TI_TRADING_CAPS_FUNCTION_MidPriceFOKOrder.ordinal())
			return "Mid price FOK order";
		if (value == TI_TRADING_CAPS_FUNCTION_InventoryOrderSend.ordinal())
			return "Inventory order send";
		if (value == TI_TRADING_CAPS_FUNCTION_InventoryOrderRespond.ordinal())
			return "Inventory order respond";
		if (value == TI_TRADING_CAPS_FUNCTION_AllBVFunctions.ordinal())
			return "All Bondvision Functions";
		return "";
	}
	public static TI_TRADING_CAPS_FUNCTION_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_TRADING_CAPS_FUNCTION_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
