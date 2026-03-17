package com.mtsmarkets.sdp.smp;

public enum TI_DESC_FIELD_TYPE_Enum {
		TI_DESC_FIELD_TYPE_TypeNONE_1(0),
		TI_DESC_FIELD_TYPE_TypeINT_2(1),
		TI_DESC_FIELD_TYPE_TypeUINT_3(2),
		TI_DESC_FIELD_TYPE_TypeSHORT_4(3),
		TI_DESC_FIELD_TYPE_TypeUSHORT_5(4),
		TI_DESC_FIELD_TYPE_TypeLONG_6(5),
		TI_DESC_FIELD_TYPE_TypeULONG_7(6),
		TI_DESC_FIELD_TYPE_TypeFLOAT_8(7),
		TI_DESC_FIELD_TYPE_TypeDOUBLE_9(8),
		TI_DESC_FIELD_TYPE_TypeBYTE_10(9),
		TI_DESC_FIELD_TYPE_TypeCHAR_11(10),
		TI_DESC_FIELD_TYPE_TypeUCHAR_12(11),
		TI_DESC_FIELD_TYPE_TypeSTRING_13(12),
		TI_DESC_FIELD_TYPE_TypeLTIME_14(13),
		TI_DESC_FIELD_TYPE_TypeLDATE_15(14),
		TI_DESC_FIELD_TYPE_TypeBOOLEAN_16(15),
		TI_DESC_FIELD_TYPE_TypeMTIME_17(16),
        TI_DESC_FIELD_TYPE_TypeUTIME_18(17);

	private int value;

	public String getDesc() {
		return getDesc(value);
	}
	public String getDesc(int value) {
		if (value == TI_DESC_FIELD_TYPE_TypeNONE_1.ordinal())
			return "TypeNONE";
		if (value == TI_DESC_FIELD_TYPE_TypeINT_2.ordinal())
			return "TypeINT";
		if (value == TI_DESC_FIELD_TYPE_TypeUINT_3.ordinal())
			return "TypeUINT";
		if (value == TI_DESC_FIELD_TYPE_TypeSHORT_4.ordinal())
			return "TypeSHORT";
		if (value == TI_DESC_FIELD_TYPE_TypeUSHORT_5.ordinal())
			return "TypeUSHORT";
		if (value == TI_DESC_FIELD_TYPE_TypeLONG_6.ordinal())
			return "TypeLONG";
		if (value == TI_DESC_FIELD_TYPE_TypeULONG_7.ordinal())
			return "TypeULONG";
		if (value == TI_DESC_FIELD_TYPE_TypeFLOAT_8.ordinal())
			return "TypeFLOAT";
		if (value == TI_DESC_FIELD_TYPE_TypeDOUBLE_9.ordinal())
			return "TypeDOUBLE";
		if (value == TI_DESC_FIELD_TYPE_TypeBYTE_10.ordinal())
			return "TypeBYTE";
		if (value == TI_DESC_FIELD_TYPE_TypeCHAR_11.ordinal())
			return "TypeCHAR";
		if (value == TI_DESC_FIELD_TYPE_TypeUCHAR_12.ordinal())
			return "TypeUCHAR";
		if (value == TI_DESC_FIELD_TYPE_TypeSTRING_13.ordinal())
			return "TypeSTRING";
		if (value == TI_DESC_FIELD_TYPE_TypeLTIME_14.ordinal())
			return "TypeLTIME";
		if (value == TI_DESC_FIELD_TYPE_TypeLDATE_15.ordinal())
			return "TypeLDATE";
		if (value == TI_DESC_FIELD_TYPE_TypeBOOLEAN_16.ordinal())
			return "TypeBOOLEAN";
		if (value == TI_DESC_FIELD_TYPE_TypeMTIME_17.ordinal())
			return "TypeMTIME";
        if (value == TI_DESC_FIELD_TYPE_TypeUTIME_18.ordinal())
			return "TypeUTIME";
		return "";
	}
	TI_DESC_FIELD_TYPE_Enum(int value)
	{
		this.value = value;
	}
	public TI_DESC_FIELD_TYPE_Enum getEnum(int val)
	{

        if (val >= 0 && val < TI_DESC_FIELD_TYPE_Enum.values().length) {
            return TI_DESC_FIELD_TYPE_Enum.values()[val];
        }
        return TI_DESC_FIELD_TYPE_TypeNONE_1;  // Default to TypeNONE if out of range
	}
	public int getValue()
	{
		return value;
	}
}