package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_MEMBER_PROFILE_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_MEMBER_PROFILE_None(0),
	@SerializedName("1")
	TI_MEMBER_PROFILE_Primary(1),
	@SerializedName("2")
	TI_MEMBER_PROFILE_Dealer(2),
	@SerializedName("3")
	TI_MEMBER_PROFILE_MTS_SpA(3),
	@SerializedName("4")
	TI_MEMBER_PROFILE_PrimaryNoRFQ(4),
	@SerializedName("5")
	TI_MEMBER_PROFILE_SIA(5),
	@SerializedName("6")
	TI_MEMBER_PROFILE_Datafeed(6),
	@SerializedName("7")
	TI_MEMBER_PROFILE_Press(7),
	@SerializedName("8")
	TI_MEMBER_PROFILE_Observer(8),
	@SerializedName("9")
	TI_MEMBER_PROFILE_Agent(9),
	@SerializedName("10")
	TI_MEMBER_PROFILE_Custodian(10),
	@SerializedName("11")
	TI_MEMBER_PROFILE_DealerNoFAS(11),
	@SerializedName("12")
	TI_MEMBER_PROFILE_ThirdParty(12),
	@SerializedName("13")
	TI_MEMBER_PROFILE_DataSubscriber(13),
	@SerializedName("14")
	TI_MEMBER_PROFILE_PrimaryIssuer(14),
	@SerializedName("15")
	TI_MEMBER_PROFILE_FuturesBridge(15),
	@SerializedName("16")
	TI_MEMBER_PROFILE_ClearingHouse(16),
	@SerializedName("17")
	TI_MEMBER_PROFILE_PriceFeed(17),
	@SerializedName("18")
	TI_MEMBER_PROFILE_All(18),
	@SerializedName("19")
	TI_MEMBER_PROFILE_DealerOnlyAsk(19),
	@SerializedName("20")
	TI_MEMBER_PROFILE_DealerOnlyBid(20),
	@SerializedName("21")
	TI_MEMBER_PROFILE_ThirdPartyWithSponsorRFQ(21),
	@SerializedName("22")
	TI_MEMBER_PROFILE_MTSTraderConfig(22),
	@SerializedName("23")
	TI_MEMBER_PROFILE_LeadBasisMarketMaker(23),
	@SerializedName("24")
	TI_MEMBER_PROFILE_CashMarketMaker(24),
	@SerializedName("25")
	TI_MEMBER_PROFILE_DealerFASOnlyAsk(25),
	@SerializedName("26")
	TI_MEMBER_PROFILE_DealerFASOnlyBid(26),
	@SerializedName("27")
	TI_MEMBER_PROFILE_DealerNoRFQ(27),
	@SerializedName("28")
	TI_MEMBER_PROFILE_PrimaryNoOTC(28),
	@SerializedName("29")
	TI_MEMBER_PROFILE_PrimaryNoOTCAndRFQ(29),
	@SerializedName("30")
	TI_MEMBER_PROFILE_Broker(30),
	@SerializedName("31")
	TI_MEMBER_PROFILE_BrokerPlus(31);

	private int value;

	TI_MEMBER_PROFILE_Enum(int value)
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
		if (value == TI_MEMBER_PROFILE_None.ordinal())
			return "None";
		if (value == TI_MEMBER_PROFILE_Primary.ordinal())
			return "Primary";
		if (value == TI_MEMBER_PROFILE_Dealer.ordinal())
			return "Dealer";
		if (value == TI_MEMBER_PROFILE_MTS_SpA.ordinal())
			return "MTS_SpA";
		if (value == TI_MEMBER_PROFILE_PrimaryNoRFQ.ordinal())
			return "Primary with No RFQ";
		if (value == TI_MEMBER_PROFILE_SIA.ordinal())
			return "SIA";
		if (value == TI_MEMBER_PROFILE_Datafeed.ordinal())
			return "Datafeed";
		if (value == TI_MEMBER_PROFILE_Press.ordinal())
			return "Press Agency";
		if (value == TI_MEMBER_PROFILE_Observer.ordinal())
			return "Observer";
		if (value == TI_MEMBER_PROFILE_Agent.ordinal())
			return "Agent";
		if (value == TI_MEMBER_PROFILE_Custodian.ordinal())
			return "Custodian";
		if (value == TI_MEMBER_PROFILE_DealerNoFAS.ordinal())
			return "DealerNoFAS";
		if (value == TI_MEMBER_PROFILE_ThirdParty.ordinal())
			return "Third Party Access";
		if (value == TI_MEMBER_PROFILE_DataSubscriber.ordinal())
			return "Data Subscriber";
		if (value == TI_MEMBER_PROFILE_PrimaryIssuer.ordinal())
			return "Primary Issuer";
		if (value == TI_MEMBER_PROFILE_FuturesBridge.ordinal())
			return "Futures Bridge";
		if (value == TI_MEMBER_PROFILE_ClearingHouse.ordinal())
			return "ClearingHouse";
		if (value == TI_MEMBER_PROFILE_PriceFeed.ordinal())
			return "PriceFeed";
		if (value == TI_MEMBER_PROFILE_All.ordinal())
			return "All";
		if (value == TI_MEMBER_PROFILE_DealerOnlyAsk.ordinal())
			return "DealerOnlyAsk";
		if (value == TI_MEMBER_PROFILE_DealerOnlyBid.ordinal())
			return "DealerOnlyBid";
		if (value == TI_MEMBER_PROFILE_ThirdPartyWithSponsorRFQ.ordinal())
			return "ThirdPartyAccessSponsorRFQ";
		if (value == TI_MEMBER_PROFILE_MTSTraderConfig.ordinal())
			return "MTSTraderConfig";
		if (value == TI_MEMBER_PROFILE_LeadBasisMarketMaker.ordinal())
			return "Lead Basis Market Maker";
		if (value == TI_MEMBER_PROFILE_CashMarketMaker.ordinal())
			return "Cash Market Maker";
		if (value == TI_MEMBER_PROFILE_DealerFASOnlyAsk.ordinal())
			return "DealerFASOnlyAsk";
		if (value == TI_MEMBER_PROFILE_DealerFASOnlyBid.ordinal())
			return "DealerFASOnlyBid";
		if (value == TI_MEMBER_PROFILE_DealerNoRFQ.ordinal())
			return "Dealer with No RFQ";
		if (value == TI_MEMBER_PROFILE_PrimaryNoOTC.ordinal())
			return "Primary without OTC";
		if (value == TI_MEMBER_PROFILE_PrimaryNoOTCAndRFQ.ordinal())
			return "Primary without OTC and RFQ";
		if (value == TI_MEMBER_PROFILE_Broker.ordinal())
			return "Broker";
		if (value == TI_MEMBER_PROFILE_BrokerPlus.ordinal())
			return "Broker Plus";
		return "";
	}
	public static TI_MEMBER_PROFILE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_MEMBER_PROFILE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
