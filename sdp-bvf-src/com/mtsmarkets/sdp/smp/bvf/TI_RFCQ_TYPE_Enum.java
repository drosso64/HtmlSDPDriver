package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_RFCQ_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_RFCQ_TYPE_Outright(0),
	@SerializedName("1")
	TI_RFCQ_TYPE_Switch(1),
	@SerializedName("2")
	TI_RFCQ_TYPE_TradeRegistration(2),
	@SerializedName("3")
	TI_RFCQ_TYPE_MultiLeg(3),
	@SerializedName("4")
	TI_RFCQ_TYPE_ButterflyFree(4),
	@SerializedName("5")
	TI_RFCQ_TYPE_DoubleSided(5),
	@SerializedName("6")
	TI_RFCQ_TYPE_AllRFCQ(6),
	@SerializedName("7")
	TI_RFCQ_TYPE_InventoryOrder(7),
	@SerializedName("8")
	TI_RFCQ_TYPE_None(8),
	@SerializedName("9")
	TI_RFCQ_TYPE_Package(9),
	@SerializedName("10")
	TI_RFCQ_TYPE_Portfolio(10),
	@SerializedName("11")
	TI_RFCQ_TYPE_MarketOnClose(11);

	private int value;

	TI_RFCQ_TYPE_Enum(int value)
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
		if (value == TI_RFCQ_TYPE_Outright.ordinal())
			return "Outright";
		if (value == TI_RFCQ_TYPE_Switch.ordinal())
			return "Switch";
		if (value == TI_RFCQ_TYPE_TradeRegistration.ordinal())
			return "Trade Registration";
		if (value == TI_RFCQ_TYPE_MultiLeg.ordinal())
			return "MultiLeg";
		if (value == TI_RFCQ_TYPE_ButterflyFree.ordinal())
			return "Butterfly-free";
		if (value == TI_RFCQ_TYPE_DoubleSided.ordinal())
			return "Double Sided";
		if (value == TI_RFCQ_TYPE_AllRFCQ.ordinal())
			return "All RFCQ";
		if (value == TI_RFCQ_TYPE_InventoryOrder.ordinal())
			return "Inventory Order";
		if (value == TI_RFCQ_TYPE_None.ordinal())
			return "None";
		if (value == TI_RFCQ_TYPE_Package.ordinal())
			return "Package";
		if (value == TI_RFCQ_TYPE_Portfolio.ordinal())
			return "Portfolio RFCQ";
		if (value == TI_RFCQ_TYPE_MarketOnClose.ordinal())
			return "Portfolio RFCQ Market On Close";
		return "";
	}
	public static TI_RFCQ_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_RFCQ_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
