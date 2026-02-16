package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum BV_EXEC_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	BV_EXEC_TYPE_NotProcessed(0),
	@SerializedName("1")
	BV_EXEC_TYPE_Processed(1),
	@SerializedName("2")
	BV_EXEC_TYPE_Executed(2),
	@SerializedName("3")
	BV_EXEC_TYPE_NotExecuted(3);

	private int value;

	BV_EXEC_TYPE_Enum(int value)
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
		if (value == BV_EXEC_TYPE_NotProcessed.ordinal())
			return "NotProcessed";
		if (value == BV_EXEC_TYPE_Processed.ordinal())
			return "Processed";
		if (value == BV_EXEC_TYPE_Executed.ordinal())
			return "Executed";
		if (value == BV_EXEC_TYPE_NotExecuted.ordinal())
			return "NotExecuted";
		return "";
	}
	public static BV_EXEC_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= BV_EXEC_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
