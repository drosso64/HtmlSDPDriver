package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_RFQ_EVENT_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_RFQ_EVENT_Insert(0),
	@SerializedName("1")
	TI_RFQ_EVENT_Accept(1),
	@SerializedName("2")
	TI_RFQ_EVENT_Refuse(2),
	@SerializedName("3")
	TI_RFQ_EVENT_Respond(3),
	@SerializedName("4")
	TI_RFQ_EVENT_Cancel(4);

	private int value;

	TI_RFQ_EVENT_Enum(int value)
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
		if (value == TI_RFQ_EVENT_Insert.ordinal())
			return "Insert";
		if (value == TI_RFQ_EVENT_Accept.ordinal())
			return "Accept";
		if (value == TI_RFQ_EVENT_Refuse.ordinal())
			return "Refuse";
		if (value == TI_RFQ_EVENT_Respond.ordinal())
			return "Respond";
		if (value == TI_RFQ_EVENT_Cancel.ordinal())
			return "Cancel";
		return "";
	}
	public static TI_RFQ_EVENT_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_RFQ_EVENT_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
