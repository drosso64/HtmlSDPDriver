package com.mtsmarkets.sdp.smp;

public enum TI_DESC_ENTITY_TYPE_Enum   {
		TI_DESC_ENTITY_TYPE_NoType(0),
		TI_DESC_ENTITY_TYPE_StructType(1),
		TI_DESC_ENTITY_TYPE_EnumType(2),
		TI_DESC_ENTITY_TYPE_UnionType(3);

	private int value;

	public String getDesc() {
		return getDesc(value);
	}
	public String getDesc(int value) {
		if (value == TI_DESC_ENTITY_TYPE_NoType.ordinal())
			return "NoType";
		if (value == TI_DESC_ENTITY_TYPE_StructType.ordinal())
			return "StructType";
		if (value == TI_DESC_ENTITY_TYPE_EnumType.ordinal())
			return "EnumType";
		if (value == TI_DESC_ENTITY_TYPE_UnionType.ordinal())
			return "UnionType";
		return "";
	}
	TI_DESC_ENTITY_TYPE_Enum(int value)
	{
		this.value = value;
	}
	public TI_DESC_ENTITY_TYPE_Enum getEnum(int val)
	{
        if (val >= 0 && val < TI_DESC_ENTITY_TYPE_Enum.values().length) {
            return TI_DESC_ENTITY_TYPE_Enum.values()[val];
        }
        return TI_DESC_ENTITY_TYPE_NoType;  // Default to NoType if out of range
	}
	
	public int getValue()
	{
		return value;
	}
}