package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_FLOW_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_FLOW_BPV(0),
	@SerializedName("1")
	TI_FLOW_CleanPrice(1),
	@SerializedName("2")
	TI_FLOW_FuturePrice(2),
	@SerializedName("3")
	TI_FLOW_Yield(3),
	@SerializedName("4")
	TI_FLOW_BenchmarkIndexFutureValue(4);

	private int value;

	TI_FLOW_Enum(int value)
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
		if (value == TI_FLOW_BPV.ordinal())
			return "BPV";
		if (value == TI_FLOW_CleanPrice.ordinal())
			return "CleanPrice";
		if (value == TI_FLOW_FuturePrice.ordinal())
			return "FuturePrice";
		if (value == TI_FLOW_Yield.ordinal())
			return "Yield";
		if (value == TI_FLOW_BenchmarkIndexFutureValue.ordinal())
			return "Benchmark Index Future Value";
		return "";
	}
	public static TI_FLOW_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_FLOW_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
