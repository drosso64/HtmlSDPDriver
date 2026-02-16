package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_SERVICE_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_SERVICE_IP_Request(0),
	@SerializedName("1")
	TI_SERVICE_TXN(1),
	@SerializedName("2")
	TI_SERVICE_INFO_BRT(2),
	@SerializedName("3")
	TI_SERVICE_INFO_PRIV(3),
	@SerializedName("4")
	TI_SERVICE_TXN_INFO_PRIV(4),
	@SerializedName("5")
	TI_SERVICE_DATAFEED(5),
	@SerializedName("6")
	TI_SERVICE_PRESS(6),
	@SerializedName("7")
	TI_SERVICE_RECOVERY_INFO_BRT(7),
	@SerializedName("8")
	TI_SERVICE_RECOVERY_INFO_PRIV(8),
	@SerializedName("9")
	TI_SERVICE_RECOVERY_DATA_FEED(9),
	@SerializedName("10")
	TI_SERVICE_RECOVERY_PRESS(10),
	@SerializedName("11")
	TI_SERVICE_RECOVERY_ALL(11),
	@SerializedName("12")
	TI_SERVICE_ALL(12);

	private int value;

	TI_SERVICE_Enum(int value)
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
		if (value == TI_SERVICE_IP_Request.ordinal())
			return "IPRequest";
		if (value == TI_SERVICE_TXN.ordinal())
			return "Txn";
		if (value == TI_SERVICE_INFO_BRT.ordinal())
			return "InfoBrt";
		if (value == TI_SERVICE_INFO_PRIV.ordinal())
			return "InfoPriv";
		if (value == TI_SERVICE_TXN_INFO_PRIV.ordinal())
			return "TxnInfoPriv";
		if (value == TI_SERVICE_DATAFEED.ordinal())
			return "DataFeed";
		if (value == TI_SERVICE_PRESS.ordinal())
			return "Press";
		if (value == TI_SERVICE_RECOVERY_INFO_BRT.ordinal())
			return "RecoveryInfoBrt";
		if (value == TI_SERVICE_RECOVERY_INFO_PRIV.ordinal())
			return "RecoveryInfoPriv";
		if (value == TI_SERVICE_RECOVERY_DATA_FEED.ordinal())
			return "RecoveryDataFeed";
		if (value == TI_SERVICE_RECOVERY_PRESS.ordinal())
			return "RecoveryPress";
		if (value == TI_SERVICE_RECOVERY_ALL.ordinal())
			return "RecoveryAll";
		if (value == TI_SERVICE_ALL.ordinal())
			return "All";
		return "";
	}
	public static TI_SERVICE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_SERVICE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
