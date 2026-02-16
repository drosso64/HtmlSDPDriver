package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_RFCQ_QUANTITY_CALCULATION_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_RFCQ_QUANTITY_CALCULATION_UserInput(0),
	@SerializedName("1")
	TI_RFCQ_QUANTITY_CALCULATION_Risk(1),
	@SerializedName("2")
	TI_RFCQ_QUANTITY_CALCULATION_ModifiedDuration(2),
	@SerializedName("3")
	TI_RFCQ_QUANTITY_CALCULATION_Proceeds(3);

	private int value;

	TI_RFCQ_QUANTITY_CALCULATION_Enum(int value)
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
		if (value == TI_RFCQ_QUANTITY_CALCULATION_UserInput.ordinal())
			return "User Input";
		if (value == TI_RFCQ_QUANTITY_CALCULATION_Risk.ordinal())
			return "Risk";
		if (value == TI_RFCQ_QUANTITY_CALCULATION_ModifiedDuration.ordinal())
			return "Modified Duration";
		if (value == TI_RFCQ_QUANTITY_CALCULATION_Proceeds.ordinal())
			return "Proceeds";
		return "";
	}
	public static TI_RFCQ_QUANTITY_CALCULATION_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_RFCQ_QUANTITY_CALCULATION_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
