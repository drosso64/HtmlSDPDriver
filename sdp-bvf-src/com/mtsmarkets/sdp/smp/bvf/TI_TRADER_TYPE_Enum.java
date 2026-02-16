package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_TRADER_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_TRADER_TYPE_Manager(0),
	@SerializedName("1")
	TI_TRADER_TYPE_Trader(1),
	@SerializedName("2")
	TI_TRADER_TYPE_AutoTrader(2),
	@SerializedName("3")
	TI_TRADER_TYPE_Sales(3),
	@SerializedName("4")
	TI_TRADER_TYPE_PMS(4),
	@SerializedName("5")
	TI_TRADER_TYPE_Ecommerce(5),
	@SerializedName("6")
	TI_TRADER_TYPE_Backoffice(6),
	@SerializedName("7")
	TI_TRADER_TYPE_SuperUser(7),
	@SerializedName("8")
	TI_TRADER_TYPE_Viewer(8),
	@SerializedName("9")
	TI_TRADER_TYPE_APITrader(9);

	private int value;

	TI_TRADER_TYPE_Enum(int value)
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
		if (value == TI_TRADER_TYPE_Manager.ordinal())
			return "Manager";
		if (value == TI_TRADER_TYPE_Trader.ordinal())
			return "Trader";
		if (value == TI_TRADER_TYPE_AutoTrader.ordinal())
			return "AutoTrader";
		if (value == TI_TRADER_TYPE_Sales.ordinal())
			return "Sales";
		if (value == TI_TRADER_TYPE_PMS.ordinal())
			return "PMS";
		if (value == TI_TRADER_TYPE_Ecommerce.ordinal())
			return "E-Commerce";
		if (value == TI_TRADER_TYPE_Backoffice.ordinal())
			return "Back Office";
		if (value == TI_TRADER_TYPE_SuperUser.ordinal())
			return "Super User";
		if (value == TI_TRADER_TYPE_Viewer.ordinal())
			return "Viewer";
		if (value == TI_TRADER_TYPE_APITrader.ordinal())
			return "API Trader";
		return "";
	}
	public static TI_TRADER_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_TRADER_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
