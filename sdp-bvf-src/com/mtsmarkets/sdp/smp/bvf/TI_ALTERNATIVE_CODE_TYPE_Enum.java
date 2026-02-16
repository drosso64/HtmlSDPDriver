package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_ALTERNATIVE_CODE_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_ALTERNATIVE_CODE_TYPE_BLOOMBERG(0),
	@SerializedName("1")
	TI_ALTERNATIVE_CODE_TYPE_CUSIP(1),
	@SerializedName("2")
	TI_ALTERNATIVE_CODE_TYPE_GC(2),
	@SerializedName("3")
	TI_ALTERNATIVE_CODE_TYPE_ISIN(3),
	@SerializedName("4")
	TI_ALTERNATIVE_CODE_TYPE_NOCODE(4),
	@SerializedName("5")
	TI_ALTERNATIVE_CODE_TYPE_REUTERS(5),
	@SerializedName("6")
	TI_ALTERNATIVE_CODE_TYPE_MARKIT(6),
	@SerializedName("7")
	TI_ALTERNATIVE_CODE_TYPE_TELEKURS(7),
	@SerializedName("8")
	TI_ALTERNATIVE_CODE_TYPE_WKN(8),
	@SerializedName("9")
	TI_ALTERNATIVE_CODE_TYPE_AUSTRALIAN(9),
	@SerializedName("10")
	TI_ALTERNATIVE_CODE_TYPE_AUSTRIAN(10),
	@SerializedName("11")
	TI_ALTERNATIVE_CODE_TYPE_BBEQID(11),
	@SerializedName("12")
	TI_ALTERNATIVE_CODE_TYPE_BBGID(12),
	@SerializedName("13")
	TI_ALTERNATIVE_CODE_TYPE_COMMON(13),
	@SerializedName("14")
	TI_ALTERNATIVE_CODE_TYPE_EURO_COM(14),
	@SerializedName("15")
	TI_ALTERNATIVE_CODE_TYPE_HONG_KONG(15),
	@SerializedName("16")
	TI_ALTERNATIVE_CODE_TYPE_ITALY(16),
	@SerializedName("17")
	TI_ALTERNATIVE_CODE_TYPE_JAPAN(17),
	@SerializedName("18")
	TI_ALTERNATIVE_CODE_TYPE_JPN_SHRT(18),
	@SerializedName("19")
	TI_ALTERNATIVE_CODE_TYPE_MALAYSIAN(19),
	@SerializedName("20")
	TI_ALTERNATIVE_CODE_TYPE_MISC_DOM(20),
	@SerializedName("21")
	TI_ALTERNATIVE_CODE_TYPE_MLNUM(21),
	@SerializedName("22")
	TI_ALTERNATIVE_CODE_TYPE_PRE_COMMON(22),
	@SerializedName("23")
	TI_ALTERNATIVE_CODE_TYPE_PRE_ISIN(23),
	@SerializedName("24")
	TI_ALTERNATIVE_CODE_TYPE_PRE_SEDOL(24),
	@SerializedName("25")
	TI_ALTERNATIVE_CODE_TYPE_SEDOL1(25),
	@SerializedName("26")
	TI_ALTERNATIVE_CODE_TYPE_SEDOL2(26),
	@SerializedName("27")
	TI_ALTERNATIVE_CODE_TYPE_SERIES(27),
	@SerializedName("28")
	TI_ALTERNATIVE_CODE_TYPE_SHORT_CODE(28),
	@SerializedName("29")
	TI_ALTERNATIVE_CODE_TYPE_SINGAPORE(29),
	@SerializedName("30")
	TI_ALTERNATIVE_CODE_TYPE_UK_EPIC(30),
	@SerializedName("31")
	TI_ALTERNATIVE_CODE_TYPE_LOCAL_1(31),
	@SerializedName("32")
	TI_ALTERNATIVE_CODE_TYPE_LOCAL_2(32),
	@SerializedName("33")
	TI_ALTERNATIVE_CODE_TYPE_LOCAL_3(33),
	@SerializedName("34")
	TI_ALTERNATIVE_CODE_TYPE_LOCAL_4(34),
	@SerializedName("35")
	TI_ALTERNATIVE_CODE_TYPE_LOCAL_5(35),
	@SerializedName("36")
	TI_ALTERNATIVE_CODE_TYPE_CUSTOM_1(36),
	@SerializedName("37")
	TI_ALTERNATIVE_CODE_TYPE_CUSTOM_2(37),
	@SerializedName("38")
	TI_ALTERNATIVE_CODE_TYPE_CUSTOM_3(38),
	@SerializedName("39")
	TI_ALTERNATIVE_CODE_TYPE_CUSTOM_4(39),
	@SerializedName("40")
	TI_ALTERNATIVE_CODE_TYPE_CUSTOM_5(40);

	private int value;

	TI_ALTERNATIVE_CODE_TYPE_Enum(int value)
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
		if (value == TI_ALTERNATIVE_CODE_TYPE_BLOOMBERG.ordinal())
			return "BLOOMBERG";
		if (value == TI_ALTERNATIVE_CODE_TYPE_CUSIP.ordinal())
			return "CUSIP";
		if (value == TI_ALTERNATIVE_CODE_TYPE_GC.ordinal())
			return "G.C.";
		if (value == TI_ALTERNATIVE_CODE_TYPE_ISIN.ordinal())
			return "ISIN";
		if (value == TI_ALTERNATIVE_CODE_TYPE_NOCODE.ordinal())
			return "NO CODE";
		if (value == TI_ALTERNATIVE_CODE_TYPE_REUTERS.ordinal())
			return "REUTERS";
		if (value == TI_ALTERNATIVE_CODE_TYPE_MARKIT.ordinal())
			return "MARKIT";
		if (value == TI_ALTERNATIVE_CODE_TYPE_TELEKURS.ordinal())
			return "TELEKURS";
		if (value == TI_ALTERNATIVE_CODE_TYPE_WKN.ordinal())
			return "WKN";
		if (value == TI_ALTERNATIVE_CODE_TYPE_AUSTRALIAN.ordinal())
			return "AUSTRALIAN";
		if (value == TI_ALTERNATIVE_CODE_TYPE_AUSTRIAN.ordinal())
			return "AUSTRIAN";
		if (value == TI_ALTERNATIVE_CODE_TYPE_BBEQID.ordinal())
			return "BBEQID";
		if (value == TI_ALTERNATIVE_CODE_TYPE_BBGID.ordinal())
			return "BBGID";
		if (value == TI_ALTERNATIVE_CODE_TYPE_COMMON.ordinal())
			return "COMMON";
		if (value == TI_ALTERNATIVE_CODE_TYPE_EURO_COM.ordinal())
			return "EURO COM";
		if (value == TI_ALTERNATIVE_CODE_TYPE_HONG_KONG.ordinal())
			return "HONG KONG";
		if (value == TI_ALTERNATIVE_CODE_TYPE_ITALY.ordinal())
			return "ITALY";
		if (value == TI_ALTERNATIVE_CODE_TYPE_JAPAN.ordinal())
			return "JAPAN";
		if (value == TI_ALTERNATIVE_CODE_TYPE_JPN_SHRT.ordinal())
			return "JPN SHRT";
		if (value == TI_ALTERNATIVE_CODE_TYPE_MALAYSIAN.ordinal())
			return "MALAYSIAN";
		if (value == TI_ALTERNATIVE_CODE_TYPE_MISC_DOM.ordinal())
			return "Misc Dom";
		if (value == TI_ALTERNATIVE_CODE_TYPE_MLNUM.ordinal())
			return "MLNUM";
		if (value == TI_ALTERNATIVE_CODE_TYPE_PRE_COMMON.ordinal())
			return "Pre Common";
		if (value == TI_ALTERNATIVE_CODE_TYPE_PRE_ISIN.ordinal())
			return "Pre ISIN";
		if (value == TI_ALTERNATIVE_CODE_TYPE_PRE_SEDOL.ordinal())
			return "Pre Sedol";
		if (value == TI_ALTERNATIVE_CODE_TYPE_SEDOL1.ordinal())
			return "SEDOL_1";
		if (value == TI_ALTERNATIVE_CODE_TYPE_SEDOL2.ordinal())
			return "SEDOL_2";
		if (value == TI_ALTERNATIVE_CODE_TYPE_SERIES.ordinal())
			return "SERIES";
		if (value == TI_ALTERNATIVE_CODE_TYPE_SHORT_CODE.ordinal())
			return "SHORT CODE";
		if (value == TI_ALTERNATIVE_CODE_TYPE_SINGAPORE.ordinal())
			return "SINGAPORE";
		if (value == TI_ALTERNATIVE_CODE_TYPE_UK_EPIC.ordinal())
			return "UK EPIC";
		if (value == TI_ALTERNATIVE_CODE_TYPE_LOCAL_1.ordinal())
			return "Local_1";
		if (value == TI_ALTERNATIVE_CODE_TYPE_LOCAL_2.ordinal())
			return "Local_2";
		if (value == TI_ALTERNATIVE_CODE_TYPE_LOCAL_3.ordinal())
			return "Local_3";
		if (value == TI_ALTERNATIVE_CODE_TYPE_LOCAL_4.ordinal())
			return "Local_4";
		if (value == TI_ALTERNATIVE_CODE_TYPE_LOCAL_5.ordinal())
			return "Local_5";
		if (value == TI_ALTERNATIVE_CODE_TYPE_CUSTOM_1.ordinal())
			return "Custom_1";
		if (value == TI_ALTERNATIVE_CODE_TYPE_CUSTOM_2.ordinal())
			return "Custom_2";
		if (value == TI_ALTERNATIVE_CODE_TYPE_CUSTOM_3.ordinal())
			return "Custom_3";
		if (value == TI_ALTERNATIVE_CODE_TYPE_CUSTOM_4.ordinal())
			return "Custom_4";
		if (value == TI_ALTERNATIVE_CODE_TYPE_CUSTOM_5.ordinal())
			return "Custom_5";
		return "";
	}
	public static TI_ALTERNATIVE_CODE_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_ALTERNATIVE_CODE_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
