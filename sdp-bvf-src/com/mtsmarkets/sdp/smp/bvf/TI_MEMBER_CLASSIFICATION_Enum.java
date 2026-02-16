package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_MEMBER_CLASSIFICATION_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_MEMBER_CLASSIFICATION_None(0),
	@SerializedName("1")
	TI_MEMBER_CLASSIFICATION_AssetManager(1),
	@SerializedName("2")
	TI_MEMBER_CLASSIFICATION_Bank(2),
	@SerializedName("3")
	TI_MEMBER_CLASSIFICATION_BankTreasury(3),
	@SerializedName("4")
	TI_MEMBER_CLASSIFICATION_Broker(4),
	@SerializedName("5")
	TI_MEMBER_CLASSIFICATION_CentralBank(5),
	@SerializedName("6")
	TI_MEMBER_CLASSIFICATION_CorporateTreasury(6),
	@SerializedName("7")
	TI_MEMBER_CLASSIFICATION_GovernmentOrganization(7),
	@SerializedName("8")
	TI_MEMBER_CLASSIFICATION_HedgeFund(8),
	@SerializedName("9")
	TI_MEMBER_CLASSIFICATION_Insurance(9),
	@SerializedName("10")
	TI_MEMBER_CLASSIFICATION_PensionFund(10),
	@SerializedName("11")
	TI_MEMBER_CLASSIFICATION_PrimaryDealer(11),
	@SerializedName("12")
	TI_MEMBER_CLASSIFICATION_PrivateBank(12),
	@SerializedName("13")
	TI_MEMBER_CLASSIFICATION_AgenciesAndSupras(13);

	private int value;

	TI_MEMBER_CLASSIFICATION_Enum(int value)
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
		if (value == TI_MEMBER_CLASSIFICATION_None.ordinal())
			return "No Classification";
		if (value == TI_MEMBER_CLASSIFICATION_AssetManager.ordinal())
			return "Asset Manager";
		if (value == TI_MEMBER_CLASSIFICATION_Bank.ordinal())
			return "Bank";
		if (value == TI_MEMBER_CLASSIFICATION_BankTreasury.ordinal())
			return "Bank Treasury";
		if (value == TI_MEMBER_CLASSIFICATION_Broker.ordinal())
			return "Broker";
		if (value == TI_MEMBER_CLASSIFICATION_CentralBank.ordinal())
			return "Central Bank";
		if (value == TI_MEMBER_CLASSIFICATION_CorporateTreasury.ordinal())
			return "Corporate Treasury";
		if (value == TI_MEMBER_CLASSIFICATION_GovernmentOrganization.ordinal())
			return "Government Organization";
		if (value == TI_MEMBER_CLASSIFICATION_HedgeFund.ordinal())
			return "Hedge Fund";
		if (value == TI_MEMBER_CLASSIFICATION_Insurance.ordinal())
			return "Insurance";
		if (value == TI_MEMBER_CLASSIFICATION_PensionFund.ordinal())
			return "Pension Fund";
		if (value == TI_MEMBER_CLASSIFICATION_PrimaryDealer.ordinal())
			return "Primary Dealer";
		if (value == TI_MEMBER_CLASSIFICATION_PrivateBank.ordinal())
			return "Private Bank";
		if (value == TI_MEMBER_CLASSIFICATION_AgenciesAndSupras.ordinal())
			return "Agency and Supras";
		return "";
	}
	public static TI_MEMBER_CLASSIFICATION_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_MEMBER_CLASSIFICATION_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
