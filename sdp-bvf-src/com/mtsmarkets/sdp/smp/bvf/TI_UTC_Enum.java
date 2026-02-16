package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_UTC_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_UTC_None(0),
	@SerializedName("1")
	TI_UTC_Minus_1200(1),
	@SerializedName("2")
	TI_UTC_Minus_1100(2),
	@SerializedName("3")
	TI_UTC_Minus_1000(3),
	@SerializedName("4")
	TI_UTC_Minus_0930(4),
	@SerializedName("5")
	TI_UTC_Minus_0900(5),
	@SerializedName("6")
	TI_UTC_Minus_0800(6),
	@SerializedName("7")
	TI_UTC_Minus_0700(7),
	@SerializedName("8")
	TI_UTC_Minus_0600(8),
	@SerializedName("9")
	TI_UTC_Minus_0500(9),
	@SerializedName("10")
	TI_UTC_Minus_0430(10),
	@SerializedName("11")
	TI_UTC_Minus_0400(11),
	@SerializedName("12")
	TI_UTC_Minus_0330(12),
	@SerializedName("13")
	TI_UTC_Minus_0300(13),
	@SerializedName("14")
	TI_UTC_Minus_0200(14),
	@SerializedName("15")
	TI_UTC_Minus_0100(15),
	@SerializedName("16")
	TI_UTC_0000(16),
	@SerializedName("17")
	TI_UTC_Plus_0100(17),
	@SerializedName("18")
	TI_UTC_Plus_0200(18),
	@SerializedName("19")
	TI_UTC_Plus_0300(19),
	@SerializedName("20")
	TI_UTC_Plus_0330(20),
	@SerializedName("21")
	TI_UTC_Plus_0400(21),
	@SerializedName("22")
	TI_UTC_Plus_0430(22),
	@SerializedName("23")
	TI_UTC_Plus_0500(23),
	@SerializedName("24")
	TI_UTC_Plus_0530(24),
	@SerializedName("25")
	TI_UTC_Plus_0545(25),
	@SerializedName("26")
	TI_UTC_Plus_0600(26),
	@SerializedName("27")
	TI_UTC_Plus_0630(27),
	@SerializedName("28")
	TI_UTC_Plus_0700(28),
	@SerializedName("29")
	TI_UTC_Plus_0800(29),
	@SerializedName("30")
	TI_UTC_Plus_0845(30),
	@SerializedName("31")
	TI_UTC_Plus_0900(31),
	@SerializedName("32")
	TI_UTC_Plus_0930(32),
	@SerializedName("33")
	TI_UTC_Plus_1000(33),
	@SerializedName("34")
	TI_UTC_Plus_1030(34),
	@SerializedName("35")
	TI_UTC_Plus_1100(35),
	@SerializedName("36")
	TI_UTC_Plus_1130(36),
	@SerializedName("37")
	TI_UTC_Plus_1200(37),
	@SerializedName("38")
	TI_UTC_Plus_1245(38),
	@SerializedName("39")
	TI_UTC_Plus_1300(39),
	@SerializedName("40")
	TI_UTC_Plus_1400(40);

	private int value;

	TI_UTC_Enum(int value)
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
		if (value == TI_UTC_None.ordinal())
			return "None";
		if (value == TI_UTC_Minus_1200.ordinal())
			return "UTC-12:00";
		if (value == TI_UTC_Minus_1100.ordinal())
			return "UTC-11:00";
		if (value == TI_UTC_Minus_1000.ordinal())
			return "UTC-10:00";
		if (value == TI_UTC_Minus_0930.ordinal())
			return "UTC-09:30";
		if (value == TI_UTC_Minus_0900.ordinal())
			return "UTC-09:00";
		if (value == TI_UTC_Minus_0800.ordinal())
			return "UTC-08:00";
		if (value == TI_UTC_Minus_0700.ordinal())
			return "UTC-07:00";
		if (value == TI_UTC_Minus_0600.ordinal())
			return "UTC-06:00";
		if (value == TI_UTC_Minus_0500.ordinal())
			return "UTC-05:00";
		if (value == TI_UTC_Minus_0430.ordinal())
			return "UTC-04:30";
		if (value == TI_UTC_Minus_0400.ordinal())
			return "UTC-04:00";
		if (value == TI_UTC_Minus_0330.ordinal())
			return "UTC-03:30";
		if (value == TI_UTC_Minus_0300.ordinal())
			return "UTC-03:00";
		if (value == TI_UTC_Minus_0200.ordinal())
			return "UTC-02:00";
		if (value == TI_UTC_Minus_0100.ordinal())
			return "UTC-01:00";
		if (value == TI_UTC_0000.ordinal())
			return "UTC 00:00";
		if (value == TI_UTC_Plus_0100.ordinal())
			return "UTC+01:00";
		if (value == TI_UTC_Plus_0200.ordinal())
			return "UTC+02:00";
		if (value == TI_UTC_Plus_0300.ordinal())
			return "UTC+03:00";
		if (value == TI_UTC_Plus_0330.ordinal())
			return "UTC+03:30";
		if (value == TI_UTC_Plus_0400.ordinal())
			return "UTC+04:00";
		if (value == TI_UTC_Plus_0430.ordinal())
			return "UTC+04:30";
		if (value == TI_UTC_Plus_0500.ordinal())
			return "UTC+05:00";
		if (value == TI_UTC_Plus_0530.ordinal())
			return "UTC+05:30";
		if (value == TI_UTC_Plus_0545.ordinal())
			return "UTC+05:45";
		if (value == TI_UTC_Plus_0600.ordinal())
			return "UTC+06:00";
		if (value == TI_UTC_Plus_0630.ordinal())
			return "UTC+06:30";
		if (value == TI_UTC_Plus_0700.ordinal())
			return "UTC+07:00";
		if (value == TI_UTC_Plus_0800.ordinal())
			return "UTC+08:00";
		if (value == TI_UTC_Plus_0845.ordinal())
			return "UTC+08:45";
		if (value == TI_UTC_Plus_0900.ordinal())
			return "UTC+09:00";
		if (value == TI_UTC_Plus_0930.ordinal())
			return "UTC+09:30";
		if (value == TI_UTC_Plus_1000.ordinal())
			return "UTC+10:00";
		if (value == TI_UTC_Plus_1030.ordinal())
			return "UTC+10:30";
		if (value == TI_UTC_Plus_1100.ordinal())
			return "UTC+11:00";
		if (value == TI_UTC_Plus_1130.ordinal())
			return "UTC+11:30";
		if (value == TI_UTC_Plus_1200.ordinal())
			return "UTC+12:00";
		if (value == TI_UTC_Plus_1245.ordinal())
			return "UTC+12:45";
		if (value == TI_UTC_Plus_1300.ordinal())
			return "UTC+13:00";
		if (value == TI_UTC_Plus_1400.ordinal())
			return "UTC+14:00";
		return "";
	}
	public static TI_UTC_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_UTC_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
