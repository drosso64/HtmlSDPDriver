package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_DESC_FIELD_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_DESC_FIELD_TYPE_TypeNONE(0),
	@SerializedName("1")
	TI_DESC_FIELD_TYPE_TypeINT(1),
	@SerializedName("2")
	TI_DESC_FIELD_TYPE_TypeUINT(2),
	@SerializedName("3")
	TI_DESC_FIELD_TYPE_TypeSHORT(3),
	@SerializedName("4")
	TI_DESC_FIELD_TYPE_TypeUSHORT(4),
	@SerializedName("5")
	TI_DESC_FIELD_TYPE_TypeLONG(5),
	@SerializedName("6")
	TI_DESC_FIELD_TYPE_TypeULONG(6),
	@SerializedName("7")
	TI_DESC_FIELD_TYPE_TypeFLOAT(7),
	@SerializedName("8")
	TI_DESC_FIELD_TYPE_TypeDOUBLE(8),
	@SerializedName("9")
	TI_DESC_FIELD_TYPE_TypeBYTE(9),
	@SerializedName("10")
	TI_DESC_FIELD_TYPE_TypeCHAR(10),
	@SerializedName("11")
	TI_DESC_FIELD_TYPE_TypeUCHAR(11),
	@SerializedName("12")
	TI_DESC_FIELD_TYPE_TypeSTRING(12),
	@SerializedName("13")
	TI_DESC_FIELD_TYPE_TypeLTIME(13),
	@SerializedName("14")
	TI_DESC_FIELD_TYPE_TypeLDATE(14),
	@SerializedName("15")
	TI_DESC_FIELD_TYPE_TypeBOOLEAN(15),
	@SerializedName("16")
	TI_DESC_FIELD_TYPE_TypeMTIME(16),
	@SerializedName("17")
	TI_DESC_FIELD_TYPE_TypeUTIME(17);

	private int value;

	TI_DESC_FIELD_TYPE_Enum(int value)
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
		if (value == TI_DESC_FIELD_TYPE_TypeNONE.ordinal())
			return "TypeNONE";
		if (value == TI_DESC_FIELD_TYPE_TypeINT.ordinal())
			return "TypeINT";
		if (value == TI_DESC_FIELD_TYPE_TypeUINT.ordinal())
			return "TypeUINT";
		if (value == TI_DESC_FIELD_TYPE_TypeSHORT.ordinal())
			return "TypeSHORT";
		if (value == TI_DESC_FIELD_TYPE_TypeUSHORT.ordinal())
			return "TypeUSHORT";
		if (value == TI_DESC_FIELD_TYPE_TypeLONG.ordinal())
			return "TypeLONG";
		if (value == TI_DESC_FIELD_TYPE_TypeULONG.ordinal())
			return "TypeULONG";
		if (value == TI_DESC_FIELD_TYPE_TypeFLOAT.ordinal())
			return "TypeFLOAT";
		if (value == TI_DESC_FIELD_TYPE_TypeDOUBLE.ordinal())
			return "TypeDOUBLE";
		if (value == TI_DESC_FIELD_TYPE_TypeBYTE.ordinal())
			return "TypeBYTE";
		if (value == TI_DESC_FIELD_TYPE_TypeCHAR.ordinal())
			return "TypeCHAR";
		if (value == TI_DESC_FIELD_TYPE_TypeUCHAR.ordinal())
			return "TypeUCHAR";
		if (value == TI_DESC_FIELD_TYPE_TypeSTRING.ordinal())
			return "TypeSTRING";
		if (value == TI_DESC_FIELD_TYPE_TypeLTIME.ordinal())
			return "TypeLTIME";
		if (value == TI_DESC_FIELD_TYPE_TypeLDATE.ordinal())
			return "TypeLDATE";
		if (value == TI_DESC_FIELD_TYPE_TypeBOOLEAN.ordinal())
			return "TypeBOOLEAN";
		if (value == TI_DESC_FIELD_TYPE_TypeMTIME.ordinal())
			return "TypeMTIME";
		if (value == TI_DESC_FIELD_TYPE_TypeUTIME.ordinal())
			return "TypeUTIME";
		return "";
	}
	public static TI_DESC_FIELD_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_DESC_FIELD_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
