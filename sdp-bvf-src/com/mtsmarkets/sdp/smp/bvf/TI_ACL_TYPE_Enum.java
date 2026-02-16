package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_ACL_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_ACL_TYPE_NoAccess(0),
	@SerializedName("1")
	TI_ACL_TYPE_ACL(1),
	@SerializedName("2")
	TI_ACL_TYPE_FullAccess(2);

	private int value;

	TI_ACL_TYPE_Enum(int value)
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
		if (value == TI_ACL_TYPE_NoAccess.ordinal())
			return "No Access";
		if (value == TI_ACL_TYPE_ACL.ordinal())
			return "ACL";
		if (value == TI_ACL_TYPE_FullAccess.ordinal())
			return "Full Access";
		return "";
	}
	public static TI_ACL_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_ACL_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
