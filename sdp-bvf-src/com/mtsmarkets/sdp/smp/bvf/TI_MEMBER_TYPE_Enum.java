package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_MEMBER_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_MEMBER_TYPE_NormalTrader(0),
	@SerializedName("1")
	TI_MEMBER_TYPE_ClearingHouse(1),
	@SerializedName("2")
	TI_MEMBER_TYPE_Agent(2),
	@SerializedName("3")
	TI_MEMBER_TYPE_Treasury(3),
	@SerializedName("4")
	TI_MEMBER_TYPE_PriceFeed(4),
	@SerializedName("5")
	TI_MEMBER_TYPE_DataFeed(5),
	@SerializedName("6")
	TI_MEMBER_TYPE_Governance(6),
	@SerializedName("7")
	TI_MEMBER_TYPE_Observer(7),
	@SerializedName("8")
	TI_MEMBER_TYPE_FuturesBridge(8),
	@SerializedName("9")
	TI_MEMBER_TYPE_MTSTraderConfig(9),
	@SerializedName("10")
	TI_MEMBER_TYPE_Multimember(10),
	@SerializedName("11")
	TI_MEMBER_TYPE_Broker(11),
	@SerializedName("12")
	TI_MEMBER_TYPE_BrokerPlus(12),
	@SerializedName("13")
	TI_MEMBER_TYPE_DataSubscriber(13),
	@SerializedName("14")
	TI_MEMBER_TYPE_SecLenderAgencyBroker(14),
	@SerializedName("15")
	TI_MEMBER_TYPE_Client(15),
	@SerializedName("16")
	TI_MEMBER_TYPE_MTSDataFeed(16);

	private int value;

	TI_MEMBER_TYPE_Enum(int value)
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
		if (value == TI_MEMBER_TYPE_NormalTrader.ordinal())
			return "NormalTrader";
		if (value == TI_MEMBER_TYPE_ClearingHouse.ordinal())
			return "ClearingHouse";
		if (value == TI_MEMBER_TYPE_Agent.ordinal())
			return "Agent";
		if (value == TI_MEMBER_TYPE_Treasury.ordinal())
			return "Treasury";
		if (value == TI_MEMBER_TYPE_PriceFeed.ordinal())
			return "PriceFeed";
		if (value == TI_MEMBER_TYPE_DataFeed.ordinal())
			return "DataFeed";
		if (value == TI_MEMBER_TYPE_Governance.ordinal())
			return "Governance";
		if (value == TI_MEMBER_TYPE_Observer.ordinal())
			return "Observer";
		if (value == TI_MEMBER_TYPE_FuturesBridge.ordinal())
			return "Futures Bridge";
		if (value == TI_MEMBER_TYPE_MTSTraderConfig.ordinal())
			return "MTSTraderConfig";
		if (value == TI_MEMBER_TYPE_Multimember.ordinal())
			return "Multimember";
		if (value == TI_MEMBER_TYPE_Broker.ordinal())
			return "Broker";
		if (value == TI_MEMBER_TYPE_BrokerPlus.ordinal())
			return "MTS Broker Plus";
		if (value == TI_MEMBER_TYPE_DataSubscriber.ordinal())
			return "Data Subscriber";
		if (value == TI_MEMBER_TYPE_SecLenderAgencyBroker.ordinal())
			return "Security Lender & Agency Broker";
		if (value == TI_MEMBER_TYPE_Client.ordinal())
			return "Client";
		if (value == TI_MEMBER_TYPE_MTSDataFeed.ordinal())
			return "MTS DataFeed";
		return "";
	}
	public static TI_MEMBER_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_MEMBER_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
