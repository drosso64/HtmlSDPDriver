package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_RFQ_SUBSTATUS_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_RFQ_SUBSTATUS_Processing(0),
	@SerializedName("1")
	TI_RFQ_SUBSTATUS_Accepted(1),
	@SerializedName("2")
	TI_RFQ_SUBSTATUS_Refused(2),
	@SerializedName("3")
	TI_RFQ_SUBSTATUS_Timeout(3),
	@SerializedName("4")
	TI_RFQ_SUBSTATUS_Cancelled(4),
	@SerializedName("5")
	TI_RFQ_SUBSTATUS_Suspended(5),
	@SerializedName("6")
	TI_RFQ_SUBSTATUS_CutOff(6),
	@SerializedName("7")
	TI_RFQ_SUBSTATUS_Responded(7);

	private int value;

	TI_RFQ_SUBSTATUS_Enum(int value)
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
		if (value == TI_RFQ_SUBSTATUS_Processing.ordinal())
			return "Processing";
		if (value == TI_RFQ_SUBSTATUS_Accepted.ordinal())
			return "Accepted";
		if (value == TI_RFQ_SUBSTATUS_Refused.ordinal())
			return "Refused";
		if (value == TI_RFQ_SUBSTATUS_Timeout.ordinal())
			return "Timeout";
		if (value == TI_RFQ_SUBSTATUS_Cancelled.ordinal())
			return "Cancelled";
		if (value == TI_RFQ_SUBSTATUS_Suspended.ordinal())
			return "Suspended by Governance";
		if (value == TI_RFQ_SUBSTATUS_CutOff.ordinal())
			return "Cut Off";
		if (value == TI_RFQ_SUBSTATUS_Responded.ordinal())
			return "Responded";
		return "";
	}
	public static TI_RFQ_SUBSTATUS_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_RFQ_SUBSTATUS_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
