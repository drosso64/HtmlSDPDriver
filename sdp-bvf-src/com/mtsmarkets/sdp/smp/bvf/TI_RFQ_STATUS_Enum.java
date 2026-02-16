package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_RFQ_STATUS_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_RFQ_STATUS_Processing(0),
	@SerializedName("1")
	TI_RFQ_STATUS_Accepted(1),
	@SerializedName("2")
	TI_RFQ_STATUS_Refused(2),
	@SerializedName("3")
	TI_RFQ_STATUS_Rejected(3),
	@SerializedName("4")
	TI_RFQ_STATUS_LifeTimeOut(4),
	@SerializedName("5")
	TI_RFQ_STATUS_Cancelled(5);

	private int value;

	TI_RFQ_STATUS_Enum(int value)
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
		if (value == TI_RFQ_STATUS_Processing.ordinal())
			return "Processing";
		if (value == TI_RFQ_STATUS_Accepted.ordinal())
			return "Accepted";
		if (value == TI_RFQ_STATUS_Refused.ordinal())
			return "Refused";
		if (value == TI_RFQ_STATUS_Rejected.ordinal())
			return "Rejected by the system";
		if (value == TI_RFQ_STATUS_LifeTimeOut.ordinal())
			return "Life Time Out";
		if (value == TI_RFQ_STATUS_Cancelled.ordinal())
			return "Cancelled";
		return "";
	}
	public static TI_RFQ_STATUS_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_RFQ_STATUS_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
