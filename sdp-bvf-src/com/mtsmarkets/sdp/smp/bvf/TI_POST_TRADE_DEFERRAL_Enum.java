package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_POST_TRADE_DEFERRAL_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_POST_TRADE_DEFERRAL_None(0),
	@SerializedName("1")
	TI_POST_TRADE_DEFERRAL_Deferred(1),
	@SerializedName("2")
	TI_POST_TRADE_DEFERRAL_LMTF(2),
	@SerializedName("3")
	TI_POST_TRADE_DEFERRAL_LIS(3),
	@SerializedName("4")
	TI_POST_TRADE_DEFERRAL_VOLO(4),
	@SerializedName("5")
	TI_POST_TRADE_DEFERRAL_FWAF(5),
	@SerializedName("6")
	TI_POST_TRADE_DEFERRAL_IDAF(6),
	@SerializedName("7")
	TI_POST_TRADE_DEFERRAL_COAF(7),
	@SerializedName("8")
	TI_POST_TRADE_DEFERRAL_RealTime(8),
	@SerializedName("9")
	TI_POST_TRADE_DEFERRAL_T2(9),
	@SerializedName("10")
	TI_POST_TRADE_DEFERRAL_PostTradeExemption(10),
	@SerializedName("11")
	TI_POST_TRADE_DEFERRAL_ExemptedMember(11),
	@SerializedName("12")
	TI_POST_TRADE_DEFERRAL_LIS1(12),
	@SerializedName("13")
	TI_POST_TRADE_DEFERRAL_LIS2(13),
	@SerializedName("14")
	TI_POST_TRADE_DEFERRAL_LIS3(14),
	@SerializedName("15")
	TI_POST_TRADE_DEFERRAL_LIS4(15),
	@SerializedName("16")
	TI_POST_TRADE_DEFERRAL_LIS5(16),
	@SerializedName("17")
	TI_POST_TRADE_DEFERRAL_LIS6(17),
	@SerializedName("18")
	TI_POST_TRADE_DEFERRAL_LIS7(18),
	@SerializedName("19")
	TI_POST_TRADE_DEFERRAL_LIS8(19),
	@SerializedName("20")
	TI_POST_TRADE_DEFERRAL_LIS9(20),
	@SerializedName("21")
	TI_POST_TRADE_DEFERRAL_LIS10(21),
	@SerializedName("22")
	TI_POST_TRADE_DEFERRAL_TP1(22),
	@SerializedName("23")
	TI_POST_TRADE_DEFERRAL_MIF1(23),
	@SerializedName("24")
	TI_POST_TRADE_DEFERRAL_MIF2(24),
	@SerializedName("25")
	TI_POST_TRADE_DEFERRAL_MIF3(25),
	@SerializedName("26")
	TI_POST_TRADE_DEFERRAL_MIF4(26),
	@SerializedName("27")
	TI_POST_TRADE_DEFERRAL_MIF5(27),
	@SerializedName("28")
	TI_POST_TRADE_DEFERRAL_MLF1(28),
	@SerializedName("29")
	TI_POST_TRADE_DEFERRAL_MLF2(29),
	@SerializedName("30")
	TI_POST_TRADE_DEFERRAL_MLF3(30),
	@SerializedName("31")
	TI_POST_TRADE_DEFERRAL_MLF4(31),
	@SerializedName("32")
	TI_POST_TRADE_DEFERRAL_MLF5(32),
	@SerializedName("33")
	TI_POST_TRADE_DEFERRAL_LIF1(33),
	@SerializedName("34")
	TI_POST_TRADE_DEFERRAL_LIF2(34),
	@SerializedName("35")
	TI_POST_TRADE_DEFERRAL_LIF3(35),
	@SerializedName("36")
	TI_POST_TRADE_DEFERRAL_LIF4(36),
	@SerializedName("37")
	TI_POST_TRADE_DEFERRAL_LIF5(37),
	@SerializedName("38")
	TI_POST_TRADE_DEFERRAL_LLF1(38),
	@SerializedName("39")
	TI_POST_TRADE_DEFERRAL_LLF2(39),
	@SerializedName("40")
	TI_POST_TRADE_DEFERRAL_LLF3(40),
	@SerializedName("41")
	TI_POST_TRADE_DEFERRAL_LLF4(41),
	@SerializedName("42")
	TI_POST_TRADE_DEFERRAL_LLF5(42),
	@SerializedName("43")
	TI_POST_TRADE_DEFERRAL_VIF1(43),
	@SerializedName("44")
	TI_POST_TRADE_DEFERRAL_VIF2(44),
	@SerializedName("45")
	TI_POST_TRADE_DEFERRAL_VIF3(45),
	@SerializedName("46")
	TI_POST_TRADE_DEFERRAL_VIF4(46),
	@SerializedName("47")
	TI_POST_TRADE_DEFERRAL_VIF5(47),
	@SerializedName("48")
	TI_POST_TRADE_DEFERRAL_VLF1(48),
	@SerializedName("49")
	TI_POST_TRADE_DEFERRAL_VLF2(49),
	@SerializedName("50")
	TI_POST_TRADE_DEFERRAL_VLF3(50),
	@SerializedName("51")
	TI_POST_TRADE_DEFERRAL_VLF4(51),
	@SerializedName("52")
	TI_POST_TRADE_DEFERRAL_VLF5(52),
	@SerializedName("53")
	TI_POST_TRADE_DEFERRAL_AGFW(53),
	@SerializedName("54")
	TI_POST_TRADE_DEFERRAL_OMIS(54),
	@SerializedName("55")
	TI_POST_TRADE_DEFERRAL_DEFF(55);

	private int value;

	TI_POST_TRADE_DEFERRAL_Enum(int value)
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
		if (value == TI_POST_TRADE_DEFERRAL_None.ordinal())
			return "None";
		if (value == TI_POST_TRADE_DEFERRAL_Deferred.ordinal())
			return "Deferred";
		if (value == TI_POST_TRADE_DEFERRAL_LMTF.ordinal())
			return "Limit Detail";
		if (value == TI_POST_TRADE_DEFERRAL_LIS.ordinal())
			return "LIS";
		if (value == TI_POST_TRADE_DEFERRAL_VOLO.ordinal())
			return "Volume Omission";
		if (value == TI_POST_TRADE_DEFERRAL_FWAF.ordinal())
			return "Four Weeks Aggregation";
		if (value == TI_POST_TRADE_DEFERRAL_IDAF.ordinal())
			return "Indefinite Aggregation";
		if (value == TI_POST_TRADE_DEFERRAL_COAF.ordinal())
			return "Consecutive Aggregation";
		if (value == TI_POST_TRADE_DEFERRAL_RealTime.ordinal())
			return "Real-Time";
		if (value == TI_POST_TRADE_DEFERRAL_T2.ordinal())
			return "T+2";
		if (value == TI_POST_TRADE_DEFERRAL_PostTradeExemption.ordinal())
			return "Post-Trade Exemption";
		if (value == TI_POST_TRADE_DEFERRAL_ExemptedMember.ordinal())
			return "Exempted Member";
		if (value == TI_POST_TRADE_DEFERRAL_LIS1.ordinal())
			return "LIS1";
		if (value == TI_POST_TRADE_DEFERRAL_LIS2.ordinal())
			return "LIS2";
		if (value == TI_POST_TRADE_DEFERRAL_LIS3.ordinal())
			return "LIS3";
		if (value == TI_POST_TRADE_DEFERRAL_LIS4.ordinal())
			return "LIS4 (for Future Use)";
		if (value == TI_POST_TRADE_DEFERRAL_LIS5.ordinal())
			return "LIS5 (for Future Use)";
		if (value == TI_POST_TRADE_DEFERRAL_LIS6.ordinal())
			return "LIS6 (for Future Use)";
		if (value == TI_POST_TRADE_DEFERRAL_LIS7.ordinal())
			return "LIS7 (for Future Use)";
		if (value == TI_POST_TRADE_DEFERRAL_LIS8.ordinal())
			return "LIS8 (for Future Use)";
		if (value == TI_POST_TRADE_DEFERRAL_LIS9.ordinal())
			return "LIS9 (for Future Use)";
		if (value == TI_POST_TRADE_DEFERRAL_LIS10.ordinal())
			return "LIS10 (for Future Use)";
		if (value == TI_POST_TRADE_DEFERRAL_TP1.ordinal())
			return "T+1";
		if (value == TI_POST_TRADE_DEFERRAL_MIF1.ordinal())
			return "Medium illiquid flag 1";
		if (value == TI_POST_TRADE_DEFERRAL_MIF2.ordinal())
			return "Medium illiquid flag 2";
		if (value == TI_POST_TRADE_DEFERRAL_MIF3.ordinal())
			return "Medium illiquid flag 3";
		if (value == TI_POST_TRADE_DEFERRAL_MIF4.ordinal())
			return "Medium illiquid flag 4";
		if (value == TI_POST_TRADE_DEFERRAL_MIF5.ordinal())
			return "Medium illiquid flag 5";
		if (value == TI_POST_TRADE_DEFERRAL_MLF1.ordinal())
			return "Medium liquid flag 1";
		if (value == TI_POST_TRADE_DEFERRAL_MLF2.ordinal())
			return "Medium liquid flag 2";
		if (value == TI_POST_TRADE_DEFERRAL_MLF3.ordinal())
			return "Medium liquid flag 3";
		if (value == TI_POST_TRADE_DEFERRAL_MLF4.ordinal())
			return "Medium liquid flag 4";
		if (value == TI_POST_TRADE_DEFERRAL_MLF5.ordinal())
			return "Medium liquid flag 5";
		if (value == TI_POST_TRADE_DEFERRAL_LIF1.ordinal())
			return "Large illiquid flag 1";
		if (value == TI_POST_TRADE_DEFERRAL_LIF2.ordinal())
			return "Large illiquid flag 2";
		if (value == TI_POST_TRADE_DEFERRAL_LIF3.ordinal())
			return "Large illiquid flag 3";
		if (value == TI_POST_TRADE_DEFERRAL_LIF4.ordinal())
			return "Large illiquid flag 4";
		if (value == TI_POST_TRADE_DEFERRAL_LIF5.ordinal())
			return "Large illiquid flag 5";
		if (value == TI_POST_TRADE_DEFERRAL_LLF1.ordinal())
			return "Large liquid flag 1";
		if (value == TI_POST_TRADE_DEFERRAL_LLF2.ordinal())
			return "Large liquid flag 2";
		if (value == TI_POST_TRADE_DEFERRAL_LLF3.ordinal())
			return "Large liquid flag 3";
		if (value == TI_POST_TRADE_DEFERRAL_LLF4.ordinal())
			return "Large liquid flag 4";
		if (value == TI_POST_TRADE_DEFERRAL_LLF5.ordinal())
			return "Large liquid flag 5";
		if (value == TI_POST_TRADE_DEFERRAL_VIF1.ordinal())
			return "Very large illiquid flag 1";
		if (value == TI_POST_TRADE_DEFERRAL_VIF2.ordinal())
			return "Very large illiquid flag 2";
		if (value == TI_POST_TRADE_DEFERRAL_VIF3.ordinal())
			return "Very large illiquid flag 3";
		if (value == TI_POST_TRADE_DEFERRAL_VIF4.ordinal())
			return "Very large illiquid flag 4";
		if (value == TI_POST_TRADE_DEFERRAL_VIF5.ordinal())
			return "Very large illiquid flag 5";
		if (value == TI_POST_TRADE_DEFERRAL_VLF1.ordinal())
			return "Very large liquid flag 1";
		if (value == TI_POST_TRADE_DEFERRAL_VLF2.ordinal())
			return "Very large liquid flag 2";
		if (value == TI_POST_TRADE_DEFERRAL_VLF3.ordinal())
			return "Very large liquid flag 3";
		if (value == TI_POST_TRADE_DEFERRAL_VLF4.ordinal())
			return "Very large liquid flag 4";
		if (value == TI_POST_TRADE_DEFERRAL_VLF5.ordinal())
			return "Very large liquid flag 5";
		if (value == TI_POST_TRADE_DEFERRAL_AGFW.ordinal())
			return "Aggregated Transaction Flag";
		if (value == TI_POST_TRADE_DEFERRAL_OMIS.ordinal())
			return "Volume Omission Flag";
		if (value == TI_POST_TRADE_DEFERRAL_DEFF.ordinal())
			return "DEFF";
		return "";
	}
	public static TI_POST_TRADE_DEFERRAL_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_POST_TRADE_DEFERRAL_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
