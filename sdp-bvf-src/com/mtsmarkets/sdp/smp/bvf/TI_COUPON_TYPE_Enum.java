package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_COUPON_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_COUPON_TYPE_ZeroCoupon(0),
	@SerializedName("1")
	TI_COUPON_TYPE_FixedRate(1),
	@SerializedName("2")
	TI_COUPON_TYPE_FloatRate(2),
	@SerializedName("3")
	TI_COUPON_TYPE_IndexedRate(3),
	@SerializedName("4")
	TI_COUPON_TYPE_VariableCoupon(4);

	private int value;

	TI_COUPON_TYPE_Enum(int value)
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
		if (value == TI_COUPON_TYPE_ZeroCoupon.ordinal())
			return "Zero Coupon";
		if (value == TI_COUPON_TYPE_FixedRate.ordinal())
			return "Fixed Rate";
		if (value == TI_COUPON_TYPE_FloatRate.ordinal())
			return "Floating Rate";
		if (value == TI_COUPON_TYPE_IndexedRate.ordinal())
			return "Indexed Rate";
		if (value == TI_COUPON_TYPE_VariableCoupon.ordinal())
			return "VariableCoupon";
		return "";
	}
	public static TI_COUPON_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_COUPON_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
