package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_TRADE_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_TRADE_TYPE_Normal(0),
	@SerializedName("1")
	TI_TRADE_TYPE_RFQ(1),
	@SerializedName("2")
	TI_TRADE_TYPE_RFCQ(2),
	@SerializedName("3")
	TI_TRADE_TYPE_OTC(3),
	@SerializedName("4")
	TI_TRADE_TYPE_MPC(4),
	@SerializedName("5")
	TI_TRADE_TYPE_IO(5),
	@SerializedName("6")
	TI_TRADE_TYPE_Undefined(6);

	private int value;

	TI_TRADE_TYPE_Enum(int value)
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
		if (value == TI_TRADE_TYPE_Normal.ordinal())
			return "Normal";
		if (value == TI_TRADE_TYPE_RFQ.ordinal())
			return "RFQ";
		if (value == TI_TRADE_TYPE_RFCQ.ordinal())
			return "RFCQ";
		if (value == TI_TRADE_TYPE_OTC.ordinal())
			return "OTC";
		if (value == TI_TRADE_TYPE_MPC.ordinal())
			return "Mid Price Crossing";
		if (value == TI_TRADE_TYPE_IO.ordinal())
			return "Inventory Order";
		if (value == TI_TRADE_TYPE_Undefined.ordinal())
			return "Undefined";
		return "";
	}
	public static TI_TRADE_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_TRADE_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
