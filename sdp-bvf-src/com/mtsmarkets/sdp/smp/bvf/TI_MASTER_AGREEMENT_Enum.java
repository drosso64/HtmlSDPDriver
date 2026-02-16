package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_MASTER_AGREEMENT_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_MASTER_AGREEMENT_None(0),
	@SerializedName("1")
	TI_MASTER_AGREEMENT_ISDA(1),
	@SerializedName("2")
	TI_MASTER_AGREEMENT_AFB_FBF(2),
	@SerializedName("3")
	TI_MASTER_AGREEMENT_DERV(3);

	private int value;

	TI_MASTER_AGREEMENT_Enum(int value)
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
		if (value == TI_MASTER_AGREEMENT_None.ordinal())
			return "None";
		if (value == TI_MASTER_AGREEMENT_ISDA.ordinal())
			return "ISDA";
		if (value == TI_MASTER_AGREEMENT_AFB_FBF.ordinal())
			return "AFB/FBF";
		if (value == TI_MASTER_AGREEMENT_DERV.ordinal())
			return "DERV";
		return "";
	}
	public static TI_MASTER_AGREEMENT_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_MASTER_AGREEMENT_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
