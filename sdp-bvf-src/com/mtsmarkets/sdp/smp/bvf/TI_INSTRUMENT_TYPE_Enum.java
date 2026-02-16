package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_INSTRUMENT_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_INSTRUMENT_TYPE_Bond(0),
	@SerializedName("1")
	TI_INSTRUMENT_TYPE_Future(1),
	@SerializedName("2")
	TI_INSTRUMENT_TYPE_GC(2),
	@SerializedName("3")
	TI_INSTRUMENT_TYPE_Triparty(3),
	@SerializedName("4")
	TI_INSTRUMENT_TYPE_Basis(4),
	@SerializedName("5")
	TI_INSTRUMENT_TYPE_Spread(5),
	@SerializedName("6")
	TI_INSTRUMENT_TYPE_SpreadFreeDouble(6),
	@SerializedName("7")
	TI_INSTRUMENT_TYPE_SwitchAuction(7),
	@SerializedName("8")
	TI_INSTRUMENT_TYPE_OIS(8),
	@SerializedName("9")
	TI_INSTRUMENT_TYPE_IRS(9);

	private int value;

	TI_INSTRUMENT_TYPE_Enum(int value)
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
		if (value == TI_INSTRUMENT_TYPE_Bond.ordinal())
			return "Bond";
		if (value == TI_INSTRUMENT_TYPE_Future.ordinal())
			return "Future";
		if (value == TI_INSTRUMENT_TYPE_GC.ordinal())
			return "GC";
		if (value == TI_INSTRUMENT_TYPE_Triparty.ordinal())
			return "Triparty";
		if (value == TI_INSTRUMENT_TYPE_Basis.ordinal())
			return "Basis";
		if (value == TI_INSTRUMENT_TYPE_Spread.ordinal())
			return "Spread";
		if (value == TI_INSTRUMENT_TYPE_SpreadFreeDouble.ordinal())
			return "SpreadFreeDouble";
		if (value == TI_INSTRUMENT_TYPE_SwitchAuction.ordinal())
			return "SwitchAuction";
		if (value == TI_INSTRUMENT_TYPE_OIS.ordinal())
			return "OIS";
		if (value == TI_INSTRUMENT_TYPE_IRS.ordinal())
			return "IRS";
		return "";
	}
	public static TI_INSTRUMENT_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_INSTRUMENT_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
