package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_FINANCIAL_INSTRUMENT_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_FINANCIAL_INSTRUMENT_TYPE_Bond(0),
	@SerializedName("1")
	TI_FINANCIAL_INSTRUMENT_TYPE_FutureDelivery(1),
	@SerializedName("2")
	TI_FINANCIAL_INSTRUMENT_TYPE_Rate(2);

	private int value;

	TI_FINANCIAL_INSTRUMENT_TYPE_Enum(int value)
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
		if (value == TI_FINANCIAL_INSTRUMENT_TYPE_Bond.ordinal())
			return "Bond";
		if (value == TI_FINANCIAL_INSTRUMENT_TYPE_FutureDelivery.ordinal())
			return "Future Delivery";
		if (value == TI_FINANCIAL_INSTRUMENT_TYPE_Rate.ordinal())
			return "Rate";
		return "";
	}
	public static TI_FINANCIAL_INSTRUMENT_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_FINANCIAL_INSTRUMENT_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
