package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_SECURITY_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_SECURITY_TYPE_PlainTCP(0),
	@SerializedName("1")
	TI_SECURITY_TYPE_SSL(1),
	@SerializedName("2")
	TI_SECURITY_TYPE_SSLCertificate(2);

	private int value;

	TI_SECURITY_TYPE_Enum(int value)
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
		if (value == TI_SECURITY_TYPE_PlainTCP.ordinal())
			return "Plain TCP";
		if (value == TI_SECURITY_TYPE_SSL.ordinal())
			return "SSL (No certificate)";
		if (value == TI_SECURITY_TYPE_SSLCertificate.ordinal())
			return "SSL Certificate";
		return "";
	}
	public static TI_SECURITY_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_SECURITY_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
