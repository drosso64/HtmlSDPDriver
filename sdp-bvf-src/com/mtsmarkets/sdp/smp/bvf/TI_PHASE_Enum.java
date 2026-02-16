package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_PHASE_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_PHASE_SystemDown(0),
	@SerializedName("1")
	TI_PHASE_CloseMarket(1),
	@SerializedName("2")
	TI_PHASE_PreMarket(2),
	@SerializedName("3")
	TI_PHASE_OfferMarket(3),
	@SerializedName("4")
	TI_PHASE_OpenMarket(4),
	@SerializedName("5")
	TI_PHASE_Evaluation(5),
	@SerializedName("6")
	TI_PHASE_Finalisation(6),
	@SerializedName("7")
	TI_PHASE_SplitDefinition(7),
	@SerializedName("8")
	TI_PHASE_AfterHours(8);

	private int value;

	TI_PHASE_Enum(int value)
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
		if (value == TI_PHASE_SystemDown.ordinal())
			return "SystemDown";
		if (value == TI_PHASE_CloseMarket.ordinal())
			return "Close Market";
		if (value == TI_PHASE_PreMarket.ordinal())
			return "Pre-Market";
		if (value == TI_PHASE_OfferMarket.ordinal())
			return "Offer Market";
		if (value == TI_PHASE_OpenMarket.ordinal())
			return "Open Market";
		if (value == TI_PHASE_Evaluation.ordinal())
			return "Evaluation";
		if (value == TI_PHASE_Finalisation.ordinal())
			return "Finalisation";
		if (value == TI_PHASE_SplitDefinition.ordinal())
			return "Split Definition";
		if (value == TI_PHASE_AfterHours.ordinal())
			return "After Hours";
		return "";
	}
	public static TI_PHASE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_PHASE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
