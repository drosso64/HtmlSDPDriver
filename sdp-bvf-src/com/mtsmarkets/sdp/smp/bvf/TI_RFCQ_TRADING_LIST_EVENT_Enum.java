package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_RFCQ_TRADING_LIST_EVENT_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_RFCQ_TRADING_LIST_EVENT_Insert(0),
	@SerializedName("1")
	TI_RFCQ_TRADING_LIST_EVENT_Update(1),
	@SerializedName("2")
	TI_RFCQ_TRADING_LIST_EVENT_Delete(2),
	@SerializedName("3")
	TI_RFCQ_TRADING_LIST_EVENT_Lock(3),
	@SerializedName("4")
	TI_RFCQ_TRADING_LIST_EVENT_Unlock(4);

	private int value;

	TI_RFCQ_TRADING_LIST_EVENT_Enum(int value)
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
		if (value == TI_RFCQ_TRADING_LIST_EVENT_Insert.ordinal())
			return "Insert";
		if (value == TI_RFCQ_TRADING_LIST_EVENT_Update.ordinal())
			return "Update";
		if (value == TI_RFCQ_TRADING_LIST_EVENT_Delete.ordinal())
			return "Delete";
		if (value == TI_RFCQ_TRADING_LIST_EVENT_Lock.ordinal())
			return "Lock";
		if (value == TI_RFCQ_TRADING_LIST_EVENT_Unlock.ordinal())
			return "Unlock";
		return "";
	}
	public static TI_RFCQ_TRADING_LIST_EVENT_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_RFCQ_TRADING_LIST_EVENT_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
