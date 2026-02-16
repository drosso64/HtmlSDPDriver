package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum BV_TRANSPARENCY_EXEMPTION_Enum implements SMPEnum
{
	@SerializedName("0")
	BV_TRANSPARENCY_EXEMPTION_None(0),
	@SerializedName("1")
	BV_TRANSPARENCY_EXEMPTION_ILQD(1),
	@SerializedName("2")
	BV_TRANSPARENCY_EXEMPTION_ILQD_Package(2),
	@SerializedName("3")
	BV_TRANSPARENCY_EXEMPTION_LIS(3),
	@SerializedName("4")
	BV_TRANSPARENCY_EXEMPTION_LIS_Package(4),
	@SerializedName("5")
	BV_TRANSPARENCY_EXEMPTION_SSTI(5),
	@SerializedName("6")
	BV_TRANSPARENCY_EXEMPTION_SSTI_Package(6),
	@SerializedName("7")
	BV_TRANSPARENCY_EXEMPTION_TPAC(7),
	@SerializedName("8")
	BV_TRANSPARENCY_EXEMPTION_LRGS(8),
	@SerializedName("9")
	BV_TRANSPARENCY_EXEMPTION_PreTradeExemption(9),
	@SerializedName("10")
	BV_TRANSPARENCY_EXEMPTION_PostTradeExemption(10),
	@SerializedName("11")
	BV_TRANSPARENCY_EXEMPTION_ExemptedMember(11),
	@SerializedName("12")
	BV_TRANSPARENCY_EXEMPTION_LIS1(12),
	@SerializedName("13")
	BV_TRANSPARENCY_EXEMPTION_LIS2(13),
	@SerializedName("14")
	BV_TRANSPARENCY_EXEMPTION_LIS3(14),
	@SerializedName("15")
	BV_TRANSPARENCY_EXEMPTION_LIS4(15),
	@SerializedName("16")
	BV_TRANSPARENCY_EXEMPTION_LIS5(16),
	@SerializedName("17")
	BV_TRANSPARENCY_EXEMPTION_LIS6(17),
	@SerializedName("18")
	BV_TRANSPARENCY_EXEMPTION_LIS7(18),
	@SerializedName("19")
	BV_TRANSPARENCY_EXEMPTION_LIS8(19),
	@SerializedName("20")
	BV_TRANSPARENCY_EXEMPTION_LIS9(20),
	@SerializedName("21")
	BV_TRANSPARENCY_EXEMPTION_LIS10(21),
	@SerializedName("22")
	BV_TRANSPARENCY_EXEMPTION_TP1(22);

	private int value;

	BV_TRANSPARENCY_EXEMPTION_Enum(int value)
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
		if (value == BV_TRANSPARENCY_EXEMPTION_None.ordinal())
			return "None";
		if (value == BV_TRANSPARENCY_EXEMPTION_ILQD.ordinal())
			return "Illiquid Instrument";
		if (value == BV_TRANSPARENCY_EXEMPTION_ILQD_Package.ordinal())
			return "Illiquid Instrument (Package)";
		if (value == BV_TRANSPARENCY_EXEMPTION_LIS.ordinal())
			return "LIS";
		if (value == BV_TRANSPARENCY_EXEMPTION_LIS_Package.ordinal())
			return "Pre-Trade Large In Scale (Package)";
		if (value == BV_TRANSPARENCY_EXEMPTION_SSTI.ordinal())
			return "Size Specific To the Instrument";
		if (value == BV_TRANSPARENCY_EXEMPTION_SSTI_Package.ordinal())
			return "Size Specific To the Instrument (Package)";
		if (value == BV_TRANSPARENCY_EXEMPTION_TPAC.ordinal())
			return "Package Trade";
		if (value == BV_TRANSPARENCY_EXEMPTION_LRGS.ordinal())
			return "LRGS";
		if (value == BV_TRANSPARENCY_EXEMPTION_PreTradeExemption.ordinal())
			return "Pre-Trade Exemption";
		if (value == BV_TRANSPARENCY_EXEMPTION_PostTradeExemption.ordinal())
			return "Post-Trade Exemption";
		if (value == BV_TRANSPARENCY_EXEMPTION_ExemptedMember.ordinal())
			return "Exempted Member";
		if (value == BV_TRANSPARENCY_EXEMPTION_LIS1.ordinal())
			return "LIS1";
		if (value == BV_TRANSPARENCY_EXEMPTION_LIS2.ordinal())
			return "LIS2";
		if (value == BV_TRANSPARENCY_EXEMPTION_LIS3.ordinal())
			return "LIS3";
		if (value == BV_TRANSPARENCY_EXEMPTION_LIS4.ordinal())
			return "LIS4 (for Future Use)";
		if (value == BV_TRANSPARENCY_EXEMPTION_LIS5.ordinal())
			return "LIS5 (for Future Use)";
		if (value == BV_TRANSPARENCY_EXEMPTION_LIS6.ordinal())
			return "LIS6 (for Future Use)";
		if (value == BV_TRANSPARENCY_EXEMPTION_LIS7.ordinal())
			return "LIS7 (for Future Use)";
		if (value == BV_TRANSPARENCY_EXEMPTION_LIS8.ordinal())
			return "LIS8 (for Future Use)";
		if (value == BV_TRANSPARENCY_EXEMPTION_LIS9.ordinal())
			return "LIS9 (for Future Use)";
		if (value == BV_TRANSPARENCY_EXEMPTION_LIS10.ordinal())
			return "LIS10 (for Future Use)";
		if (value == BV_TRANSPARENCY_EXEMPTION_TP1.ordinal())
			return "T+1";
		return "";
	}
	public static BV_TRANSPARENCY_EXEMPTION_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= BV_TRANSPARENCY_EXEMPTION_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
