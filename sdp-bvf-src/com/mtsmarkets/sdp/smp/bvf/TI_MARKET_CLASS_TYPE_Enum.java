package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_MARKET_CLASS_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_MARKET_CLASS_TYPE_All(0),
	@SerializedName("1")
	TI_MARKET_CLASS_TYPE_MemberStatus(1),
	@SerializedName("2")
	TI_MARKET_CLASS_TYPE_TraderStatus(2),
	@SerializedName("3")
	TI_MARKET_CLASS_TYPE_Message(3),
	@SerializedName("4")
	TI_MARKET_CLASS_TYPE_Admin(4),
	@SerializedName("5")
	TI_MARKET_CLASS_TYPE_PublicInfo(5),
	@SerializedName("6")
	TI_MARKET_CLASS_TYPE_PrivateInfo(6),
	@SerializedName("7")
	TI_MARKET_CLASS_TYPE_Governance(7),
	@SerializedName("8")
	TI_MARKET_CLASS_TYPE_Issuer(8),
	@SerializedName("9")
	TI_MARKET_CLASS_TYPE_GroupStatus(9),
	@SerializedName("10")
	TI_MARKET_CLASS_TYPE_TradingRelation(10),
	@SerializedName("11")
	TI_MARKET_CLASS_TYPE_TradingCaps(11),
	@SerializedName("12")
	TI_MARKET_CLASS_TYPE_InstrumentClassEnable(12),
	@SerializedName("13")
	TI_MARKET_CLASS_TYPE_Rfcq(13),
	@SerializedName("14")
	TI_MARKET_CLASS_TYPE_FinancialCalculator(14),
	@SerializedName("15")
	TI_MARKET_CLASS_TYPE_SalesConfig(15),
	@SerializedName("16")
	TI_MARKET_CLASS_TYPE_TradeSplitting(16),
	@SerializedName("17")
	TI_MARKET_CLASS_TYPE_AutoExecutionConfiguration(17);

	private int value;

	TI_MARKET_CLASS_TYPE_Enum(int value)
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
		if (value == TI_MARKET_CLASS_TYPE_All.ordinal())
			return "All";
		if (value == TI_MARKET_CLASS_TYPE_MemberStatus.ordinal())
			return "MemberStatus";
		if (value == TI_MARKET_CLASS_TYPE_TraderStatus.ordinal())
			return "TraderStatus";
		if (value == TI_MARKET_CLASS_TYPE_Message.ordinal())
			return "Message";
		if (value == TI_MARKET_CLASS_TYPE_Admin.ordinal())
			return "Admin";
		if (value == TI_MARKET_CLASS_TYPE_PublicInfo.ordinal())
			return "PublicInfo";
		if (value == TI_MARKET_CLASS_TYPE_PrivateInfo.ordinal())
			return "PrivateInfo";
		if (value == TI_MARKET_CLASS_TYPE_Governance.ordinal())
			return "Governance";
		if (value == TI_MARKET_CLASS_TYPE_Issuer.ordinal())
			return "Issuer";
		if (value == TI_MARKET_CLASS_TYPE_GroupStatus.ordinal())
			return "Trader Group Status";
		if (value == TI_MARKET_CLASS_TYPE_TradingRelation.ordinal())
			return "Trading Relation";
		if (value == TI_MARKET_CLASS_TYPE_TradingCaps.ordinal())
			return "Trading Caps";
		if (value == TI_MARKET_CLASS_TYPE_InstrumentClassEnable.ordinal())
			return "Instrument Class Enable";
		if (value == TI_MARKET_CLASS_TYPE_Rfcq.ordinal())
			return "RFCQ";
		if (value == TI_MARKET_CLASS_TYPE_FinancialCalculator.ordinal())
			return "Financial Calculator";
		if (value == TI_MARKET_CLASS_TYPE_SalesConfig.ordinal())
			return "Sales Configuration";
		if (value == TI_MARKET_CLASS_TYPE_TradeSplitting.ordinal())
			return "Trade Splitting";
		if (value == TI_MARKET_CLASS_TYPE_AutoExecutionConfiguration.ordinal())
			return "Auto-Execution Configuration";
		return "";
	}
	public static TI_MARKET_CLASS_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_MARKET_CLASS_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
