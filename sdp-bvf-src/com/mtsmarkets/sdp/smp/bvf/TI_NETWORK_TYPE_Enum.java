package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_NETWORK_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_NETWORK_TYPE_Undefined(0),
	@SerializedName("1")
	TI_NETWORK_TYPE_Nexi(1),
	@SerializedName("2")
	TI_NETWORK_TYPE_Internet(2),
	@SerializedName("3")
	TI_NETWORK_TYPE_Radianz(3),
	@SerializedName("4")
	TI_NETWORK_TYPE_CMC(4),
	@SerializedName("5")
	TI_NETWORK_TYPE_Colocation(5),
	@SerializedName("6")
	TI_NETWORK_TYPE_ICE(6),
	@SerializedName("7")
	TI_NETWORK_TYPE_VGUI(7),
	@SerializedName("8")
	TI_NETWORK_TYPE_Options(8),
	@SerializedName("9")
	TI_NETWORK_TYPE_Colt(9),
	@SerializedName("10")
	TI_NETWORK_TYPE_Euronext(10),
	@SerializedName("11")
	TI_NETWORK_TYPE_Pico(11),
	@SerializedName("12")
	TI_NETWORK_TYPE_Transficc(12),
	@SerializedName("13")
	TI_NETWORK_TYPE_X2M(13),
	@SerializedName("14")
	TI_NETWORK_TYPE_Unused2(14),
	@SerializedName("15")
	TI_NETWORK_TYPE_Unused3(15),
	@SerializedName("16")
	TI_NETWORK_TYPE_Unused4(16),
	@SerializedName("17")
	TI_NETWORK_TYPE_Unused5(17),
	@SerializedName("18")
	TI_NETWORK_TYPE_Unused6(18),
	@SerializedName("19")
	TI_NETWORK_TYPE_Unused7(19),
	@SerializedName("20")
	TI_NETWORK_TYPE_Unused8(20);

	private int value;

	TI_NETWORK_TYPE_Enum(int value)
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
		if (value == TI_NETWORK_TYPE_Undefined.ordinal())
			return "Undefined";
		if (value == TI_NETWORK_TYPE_Nexi.ordinal())
			return "Nexi";
		if (value == TI_NETWORK_TYPE_Internet.ordinal())
			return "Internet";
		if (value == TI_NETWORK_TYPE_Radianz.ordinal())
			return "BT Radianz";
		if (value == TI_NETWORK_TYPE_CMC.ordinal())
			return "CMC Direct";
		if (value == TI_NETWORK_TYPE_Colocation.ordinal())
			return "Colocation";
		if (value == TI_NETWORK_TYPE_ICE.ordinal())
			return "ICE Data";
		if (value == TI_NETWORK_TYPE_VGUI.ordinal())
			return "Virtual GUI";
		if (value == TI_NETWORK_TYPE_Options.ordinal())
			return "Options IT";
		if (value == TI_NETWORK_TYPE_Colt.ordinal())
			return "Colt";
		if (value == TI_NETWORK_TYPE_Euronext.ordinal())
			return "Euronext";
		if (value == TI_NETWORK_TYPE_Pico.ordinal())
			return "Pico";
		if (value == TI_NETWORK_TYPE_Transficc.ordinal())
			return "Transficc";
		if (value == TI_NETWORK_TYPE_X2M.ordinal())
			return "X2M";
		if (value == TI_NETWORK_TYPE_Unused2.ordinal())
			return "Unused2";
		if (value == TI_NETWORK_TYPE_Unused3.ordinal())
			return "Unused3";
		if (value == TI_NETWORK_TYPE_Unused4.ordinal())
			return "Unused4";
		if (value == TI_NETWORK_TYPE_Unused5.ordinal())
			return "Unused5";
		if (value == TI_NETWORK_TYPE_Unused6.ordinal())
			return "Unused6";
		if (value == TI_NETWORK_TYPE_Unused7.ordinal())
			return "Unused7";
		if (value == TI_NETWORK_TYPE_Unused8.ordinal())
			return "Unused8";
		return "";
	}
	public static TI_NETWORK_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_NETWORK_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
