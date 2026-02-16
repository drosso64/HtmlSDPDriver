package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum BV_BOND_LISTING_REQUEST_REASON_Enum implements SMPEnum
{
	@SerializedName("0")
	BV_BOND_LISTING_REQUEST_REASON_None(0),
	@SerializedName("1")
	BV_BOND_LISTING_REQUEST_REASON_NonCompliant(1),
	@SerializedName("2")
	BV_BOND_LISTING_REQUEST_REASON_NoReferenceData(2),
	@SerializedName("3")
	BV_BOND_LISTING_REQUEST_REASON_TooManyInstruments(3),
	@SerializedName("4")
	BV_BOND_LISTING_REQUEST_REASON_CutoffExpired(4);

	private int value;

	BV_BOND_LISTING_REQUEST_REASON_Enum(int value)
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
		if (value == BV_BOND_LISTING_REQUEST_REASON_None.ordinal())
			return "None";
		if (value == BV_BOND_LISTING_REQUEST_REASON_NonCompliant.ordinal())
			return "Non MTS Compliant";
		if (value == BV_BOND_LISTING_REQUEST_REASON_NoReferenceData.ordinal())
			return "Reference Data Not Available";
		if (value == BV_BOND_LISTING_REQUEST_REASON_TooManyInstruments.ordinal())
			return "Exceeded Daily maximum Number of Listable Bonds";
		if (value == BV_BOND_LISTING_REQUEST_REASON_CutoffExpired.ordinal())
			return "Exceeded Listing Cut-off Time";
		return "";
	}
	public static BV_BOND_LISTING_REQUEST_REASON_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= BV_BOND_LISTING_REQUEST_REASON_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
