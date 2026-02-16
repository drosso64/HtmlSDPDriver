package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum BV_ORDER_STAGING_EXEC_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	BV_ORDER_STAGING_EXEC_TYPE_Undefined(0),
	@SerializedName("1")
	BV_ORDER_STAGING_EXEC_TYPE_OutrightRFCQ(1),
	@SerializedName("2")
	BV_ORDER_STAGING_EXEC_TYPE_SwitchRFCQ(2),
	@SerializedName("3")
	BV_ORDER_STAGING_EXEC_TYPE_TradeRegistration(3),
	@SerializedName("4")
	BV_ORDER_STAGING_EXEC_TYPE_MultipleRFCQ(4),
	@SerializedName("5")
	BV_ORDER_STAGING_EXEC_TYPE_ButterflyFreeRFCQ(5),
	@SerializedName("6")
	BV_ORDER_STAGING_EXEC_TYPE_FAS(6),
	@SerializedName("7")
	BV_ORDER_STAGING_EXEC_TYPE_FAK(7),
	@SerializedName("8")
	BV_ORDER_STAGING_EXEC_TYPE_FOK(8);

	private int value;

	BV_ORDER_STAGING_EXEC_TYPE_Enum(int value)
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
		if (value == BV_ORDER_STAGING_EXEC_TYPE_Undefined.ordinal())
			return "Undefined";
		if (value == BV_ORDER_STAGING_EXEC_TYPE_OutrightRFCQ.ordinal())
			return "Outright RFCQ";
		if (value == BV_ORDER_STAGING_EXEC_TYPE_SwitchRFCQ.ordinal())
			return "Switch RFCQ";
		if (value == BV_ORDER_STAGING_EXEC_TYPE_TradeRegistration.ordinal())
			return "Trade Registration";
		if (value == BV_ORDER_STAGING_EXEC_TYPE_MultipleRFCQ.ordinal())
			return "Multiple RFCQ";
		if (value == BV_ORDER_STAGING_EXEC_TYPE_ButterflyFreeRFCQ.ordinal())
			return "Butterfly-free RFCQ";
		if (value == BV_ORDER_STAGING_EXEC_TYPE_FAS.ordinal())
			return "FAS Order";
		if (value == BV_ORDER_STAGING_EXEC_TYPE_FAK.ordinal())
			return "FAK Order";
		if (value == BV_ORDER_STAGING_EXEC_TYPE_FOK.ordinal())
			return "FOK Order";
		return "";
	}
	public static BV_ORDER_STAGING_EXEC_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= BV_ORDER_STAGING_EXEC_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
