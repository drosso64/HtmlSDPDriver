package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_PLATFORM_CLASS_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_PLATFORM_CLASS_TYPE_All(0),
	@SerializedName("1")
	TI_PLATFORM_CLASS_TYPE_Message(1),
	@SerializedName("2")
	TI_PLATFORM_CLASS_TYPE_Admin(2),
	@SerializedName("3")
	TI_PLATFORM_CLASS_TYPE_MemberAccount(3),
	@SerializedName("4")
	TI_PLATFORM_CLASS_TYPE_AlgoRegistration(4);

	private int value;

	TI_PLATFORM_CLASS_TYPE_Enum(int value)
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
		if (value == TI_PLATFORM_CLASS_TYPE_All.ordinal())
			return "All";
		if (value == TI_PLATFORM_CLASS_TYPE_Message.ordinal())
			return "Message";
		if (value == TI_PLATFORM_CLASS_TYPE_Admin.ordinal())
			return "Admin";
		if (value == TI_PLATFORM_CLASS_TYPE_MemberAccount.ordinal())
			return "Member Account";
		if (value == TI_PLATFORM_CLASS_TYPE_AlgoRegistration.ordinal())
			return "Algo Registration";
		return "";
	}
	public static TI_PLATFORM_CLASS_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_PLATFORM_CLASS_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
