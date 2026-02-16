package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_LOGON_INFO_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_LOGON_INFO_NotAvailable(0),
	@SerializedName("1")
	TI_LOGON_INFO_Compliant(1),
	@SerializedName("2")
	TI_LOGON_INFO_NoInfo(2),
	@SerializedName("3")
	TI_LOGON_INFO_NonCompliantSignature(3),
	@SerializedName("4")
	TI_LOGON_INFO_NonCompliantVersion(4),
	@SerializedName("5")
	TI_LOGON_INFO_NoAcl(5),
	@SerializedName("6")
	TI_LOGON_INFO_NoAccess(6);

	private int value;

	TI_LOGON_INFO_Enum(int value)
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
		if (value == TI_LOGON_INFO_NotAvailable.ordinal())
			return "Not Available";
		if (value == TI_LOGON_INFO_Compliant.ordinal())
			return "Fully Compliant";
		if (value == TI_LOGON_INFO_NoInfo.ordinal())
			return "No Signature or Version";
		if (value == TI_LOGON_INFO_NonCompliantSignature.ordinal())
			return "Non Compliant Signature";
		if (value == TI_LOGON_INFO_NonCompliantVersion.ordinal())
			return "Non Compliant Version";
		if (value == TI_LOGON_INFO_NoAcl.ordinal())
			return "Missing ACL";
		if (value == TI_LOGON_INFO_NoAccess.ordinal())
			return "No Access";
		return "";
	}
	public static TI_LOGON_INFO_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_LOGON_INFO_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
