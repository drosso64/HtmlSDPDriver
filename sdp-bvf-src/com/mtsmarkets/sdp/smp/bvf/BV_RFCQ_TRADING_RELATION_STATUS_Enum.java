package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum BV_RFCQ_TRADING_RELATION_STATUS_Enum implements SMPEnum
{
	@SerializedName("0")
	BV_RFCQ_TRADING_RELATION_STATUS_Processing(0),
	@SerializedName("1")
	BV_RFCQ_TRADING_RELATION_STATUS_Accepted(1),
	@SerializedName("2")
	BV_RFCQ_TRADING_RELATION_STATUS_Revoked(2),
	@SerializedName("3")
	BV_RFCQ_TRADING_RELATION_STATUS_Refused(3),
	@SerializedName("4")
	BV_RFCQ_TRADING_RELATION_STATUS_DeletedByGovernance(4);

	private int value;

	BV_RFCQ_TRADING_RELATION_STATUS_Enum(int value)
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
		if (value == BV_RFCQ_TRADING_RELATION_STATUS_Processing.ordinal())
			return "Processing";
		if (value == BV_RFCQ_TRADING_RELATION_STATUS_Accepted.ordinal())
			return "Accepted";
		if (value == BV_RFCQ_TRADING_RELATION_STATUS_Revoked.ordinal())
			return "Revoked";
		if (value == BV_RFCQ_TRADING_RELATION_STATUS_Refused.ordinal())
			return "Refused";
		if (value == BV_RFCQ_TRADING_RELATION_STATUS_DeletedByGovernance.ordinal())
			return "Deleted by Gov.nce";
		return "";
	}
	public static BV_RFCQ_TRADING_RELATION_STATUS_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= BV_RFCQ_TRADING_RELATION_STATUS_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
