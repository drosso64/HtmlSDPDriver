package com.mtsmarkets.sdp.sap;

import com.mtsmarkets.sdp.smp.SMPEnum;

public enum Platforms_Enum implements SMPEnum
{
	PAF(2),
        CMF(3),
        MMF(4),
        STF(5),
	BVF(6);

	private int value;

	Platforms_Enum(int value)
	{
		this.value = value;
	}
	public int getValue()
	{
		return value;
	}

	public String getDesc()
	{
		return getDesc(value);
	}
	public static String getDesc(int value)
	{
		if (value == PAF.ordinal())
			return "PAF";
		if (value == CMF.ordinal())
			return "CMF";
                if (value == MMF.ordinal())
			return "MMF";
                if (value == STF.ordinal())
			return "STF";
                if (value == BVF.ordinal())
			return "BVF";
		return "";
	}
	public static Platforms_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= Platforms_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
