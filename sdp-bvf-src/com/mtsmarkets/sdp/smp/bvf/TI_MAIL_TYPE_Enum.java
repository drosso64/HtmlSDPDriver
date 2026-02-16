package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_MAIL_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_MAIL_TYPE_MemberToMember(0),
	@SerializedName("1")
	TI_MAIL_TYPE_GovernanceToMember(1);

	private int value;

	TI_MAIL_TYPE_Enum(int value)
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
		if (value == TI_MAIL_TYPE_MemberToMember.ordinal())
			return "Member To Member";
		if (value == TI_MAIL_TYPE_GovernanceToMember.ordinal())
			return "Governance To Member";
		return "";
	}
	public static TI_MAIL_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_MAIL_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
