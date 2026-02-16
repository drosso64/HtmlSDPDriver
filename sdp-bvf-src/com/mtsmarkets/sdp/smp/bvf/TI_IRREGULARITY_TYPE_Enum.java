package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_IRREGULARITY_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_IRREGULARITY_TYPE_RegularCoupon(0),
	@SerializedName("1")
	TI_IRREGULARITY_TYPE_FirstCouponLong(1),
	@SerializedName("2")
	TI_IRREGULARITY_TYPE_FirstCouponShort(2),
	@SerializedName("3")
	TI_IRREGULARITY_TYPE_LongCoupon(3),
	@SerializedName("4")
	TI_IRREGULARITY_TYPE_ShortCoupon(4);

	private int value;

	TI_IRREGULARITY_TYPE_Enum(int value)
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
		if (value == TI_IRREGULARITY_TYPE_RegularCoupon.ordinal())
			return "Regular Coupon";
		if (value == TI_IRREGULARITY_TYPE_FirstCouponLong.ordinal())
			return "First CouponLong";
		if (value == TI_IRREGULARITY_TYPE_FirstCouponShort.ordinal())
			return "First CouponShort";
		if (value == TI_IRREGULARITY_TYPE_LongCoupon.ordinal())
			return "Long Coupon";
		if (value == TI_IRREGULARITY_TYPE_ShortCoupon.ordinal())
			return "Short Coupon";
		return "";
	}
	public static TI_IRREGULARITY_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_IRREGULARITY_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
