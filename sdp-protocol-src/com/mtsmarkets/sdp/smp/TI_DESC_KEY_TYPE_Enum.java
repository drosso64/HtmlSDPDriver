package com.mtsmarkets.sdp.smp;

public enum TI_DESC_KEY_TYPE_Enum {
		TI_DESC_KEY_TYPE_DuplicateKey_1(0),
		TI_DESC_KEY_TYPE_UniqueKey_2(1);

	private int value;

	public String getDesc() {
		return getDesc(value);
	}
	public String getDesc(int value) {
		if (value == TI_DESC_KEY_TYPE_DuplicateKey_1.ordinal())
			return "DuplicateKey";
		if (value == TI_DESC_KEY_TYPE_UniqueKey_2.ordinal())
			return "UniqueKey";
		return "";
	}
	TI_DESC_KEY_TYPE_Enum(int value)
	{
		this.value = value;
	}
	public TI_DESC_KEY_TYPE_Enum getEnum(int val)
	{
        if (val >= 0 && val < TI_DESC_KEY_TYPE_Enum.values().length) {
            return TI_DESC_KEY_TYPE_Enum.values()[val];
        }
        return TI_DESC_KEY_TYPE_DuplicateKey_1;  // Default to DuplicateKey if out of range	
	}
	public int getValue()
	{
		return value;
	}
}