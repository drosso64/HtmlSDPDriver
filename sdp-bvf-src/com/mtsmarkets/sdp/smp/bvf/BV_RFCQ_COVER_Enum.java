package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum BV_RFCQ_COVER_Enum implements SMPEnum
{
	@SerializedName("0")
	BV_RFCQ_COVER_None(0),
	@SerializedName("1")
	BV_RFCQ_COVER_ACCT(1),
	@SerializedName("2")
	BV_RFCQ_COVER_TIED(2),
	@SerializedName("3")
	BV_RFCQ_COVER_COVR(3),
	@SerializedName("4")
	BV_RFCQ_COVER_COVT(4);

	private int value;

	BV_RFCQ_COVER_Enum(int value)
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
		if (value == BV_RFCQ_COVER_None.ordinal())
			return " ";
		if (value == BV_RFCQ_COVER_ACCT.ordinal())
			return "AccT";
		if (value == BV_RFCQ_COVER_TIED.ordinal())
			return "Tied";
		if (value == BV_RFCQ_COVER_COVR.ordinal())
			return "Cov";
		if (value == BV_RFCQ_COVER_COVT.ordinal())
			return "CovT";
		return "";
	}
	public static BV_RFCQ_COVER_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= BV_RFCQ_COVER_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
