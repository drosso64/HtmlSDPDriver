package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_TRADING_MODALITY_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_TRADING_MODALITY_Cat(0),
	@SerializedName("1")
	TI_TRADING_MODALITY_Rfcq(1);

	private int value;

	TI_TRADING_MODALITY_Enum(int value)
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
		if (value == TI_TRADING_MODALITY_Cat.ordinal())
			return "CAT";
		if (value == TI_TRADING_MODALITY_Rfcq.ordinal())
			return "RFCQ";
		return "";
	}
	public static TI_TRADING_MODALITY_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_TRADING_MODALITY_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
