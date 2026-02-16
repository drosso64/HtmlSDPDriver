package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum BV_BOND_LISTING_REQUEST_STATUS_Enum implements SMPEnum
{
	@SerializedName("0")
	BV_BOND_LISTING_REQUEST_STATUS_None(0),
	@SerializedName("1")
	BV_BOND_LISTING_REQUEST_STATUS_Pending(1),
	@SerializedName("2")
	BV_BOND_LISTING_REQUEST_STATUS_Processing(2),
	@SerializedName("3")
	BV_BOND_LISTING_REQUEST_STATUS_Listed(3),
	@SerializedName("4")
	BV_BOND_LISTING_REQUEST_STATUS_NonListable(4);

	private int value;

	BV_BOND_LISTING_REQUEST_STATUS_Enum(int value)
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
		if (value == BV_BOND_LISTING_REQUEST_STATUS_None.ordinal())
			return "None";
		if (value == BV_BOND_LISTING_REQUEST_STATUS_Pending.ordinal())
			return "Pending";
		if (value == BV_BOND_LISTING_REQUEST_STATUS_Processing.ordinal())
			return "Processing";
		if (value == BV_BOND_LISTING_REQUEST_STATUS_Listed.ordinal())
			return "Listed";
		if (value == BV_BOND_LISTING_REQUEST_STATUS_NonListable.ordinal())
			return "Non Listable";
		return "";
	}
	public static BV_BOND_LISTING_REQUEST_STATUS_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= BV_BOND_LISTING_REQUEST_STATUS_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
