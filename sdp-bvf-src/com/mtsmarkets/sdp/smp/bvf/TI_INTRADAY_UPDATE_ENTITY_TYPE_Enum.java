package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_INTRADAY_UPDATE_ENTITY_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_INTRADAY_UPDATE_ENTITY_TYPE_FinancialInstrument(0),
	@SerializedName("1")
	TI_INTRADAY_UPDATE_ENTITY_TYPE_Bond(1),
	@SerializedName("2")
	TI_INTRADAY_UPDATE_ENTITY_TYPE_SwitchAuction(2),
	@SerializedName("3")
	TI_INTRADAY_UPDATE_ENTITY_TYPE_Issuer(3),
	@SerializedName("4")
	TI_INTRADAY_UPDATE_ENTITY_TYPE_Member(4),
	@SerializedName("5")
	TI_INTRADAY_UPDATE_ENTITY_TYPE_InstrumentClass(5),
	@SerializedName("6")
	TI_INTRADAY_UPDATE_ENTITY_TYPE_BenchmarkIndex(6);

	private int value;

	TI_INTRADAY_UPDATE_ENTITY_TYPE_Enum(int value)
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
		if (value == TI_INTRADAY_UPDATE_ENTITY_TYPE_FinancialInstrument.ordinal())
			return "Financial Instrument";
		if (value == TI_INTRADAY_UPDATE_ENTITY_TYPE_Bond.ordinal())
			return "Bond";
		if (value == TI_INTRADAY_UPDATE_ENTITY_TYPE_SwitchAuction.ordinal())
			return "Switch Auction";
		if (value == TI_INTRADAY_UPDATE_ENTITY_TYPE_Issuer.ordinal())
			return "Issuer";
		if (value == TI_INTRADAY_UPDATE_ENTITY_TYPE_Member.ordinal())
			return "Member";
		if (value == TI_INTRADAY_UPDATE_ENTITY_TYPE_InstrumentClass.ordinal())
			return "Instrument Class";
		if (value == TI_INTRADAY_UPDATE_ENTITY_TYPE_BenchmarkIndex.ordinal())
			return "Benchmark Index";
		return "";
	}
	public static TI_INTRADAY_UPDATE_ENTITY_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_INTRADAY_UPDATE_ENTITY_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
