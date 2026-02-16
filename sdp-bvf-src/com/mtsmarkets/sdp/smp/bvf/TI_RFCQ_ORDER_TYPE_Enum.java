package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_RFCQ_ORDER_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_RFCQ_ORDER_TYPE_Normal(0),
	@SerializedName("1")
	TI_RFCQ_ORDER_TYPE_BestPrice(1),
	@SerializedName("2")
	TI_RFCQ_ORDER_TYPE_BestProceeds(2),
	@SerializedName("3")
	TI_RFCQ_ORDER_TYPE_BestGrossYield(3),
	@SerializedName("4")
	TI_RFCQ_ORDER_TYPE_BestRiskWeightedYield(4),
	@SerializedName("5")
	TI_RFCQ_ORDER_TYPE_BestProceedsWeightedYield(5),
	@SerializedName("6")
	TI_RFCQ_ORDER_TYPE_NormalExcludingSubject(6),
	@SerializedName("7")
	TI_RFCQ_ORDER_TYPE_BestPriceExcludingSubject(7);

	private int value;

	TI_RFCQ_ORDER_TYPE_Enum(int value)
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
		if (value == TI_RFCQ_ORDER_TYPE_Normal.ordinal())
			return "At Best - Selected Dealer";
		if (value == TI_RFCQ_ORDER_TYPE_BestPrice.ordinal())
			return "At Best";
		if (value == TI_RFCQ_ORDER_TYPE_BestProceeds.ordinal())
			return "At Best Proceeds";
		if (value == TI_RFCQ_ORDER_TYPE_BestGrossYield.ordinal())
			return "At Best Gross Yield";
		if (value == TI_RFCQ_ORDER_TYPE_BestRiskWeightedYield.ordinal())
			return "At Best Risk Weight";
		if (value == TI_RFCQ_ORDER_TYPE_BestProceedsWeightedYield.ordinal())
			return "At Best Proceeds Weight";
		if (value == TI_RFCQ_ORDER_TYPE_NormalExcludingSubject.ordinal())
			return "At Best - Selected Dealer excluding Subject";
		if (value == TI_RFCQ_ORDER_TYPE_BestPriceExcludingSubject.ordinal())
			return "At Best excluding Subject";
		return "";
	}
	public static TI_RFCQ_ORDER_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_RFCQ_ORDER_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
