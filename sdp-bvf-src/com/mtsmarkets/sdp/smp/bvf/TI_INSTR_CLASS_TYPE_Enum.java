package com.mtsmarkets.sdp.smp.bvf;

import com.google.gson.annotations.SerializedName;
import com.mtsmarkets.sdp.smp.SMPEnum;

public enum TI_INSTR_CLASS_TYPE_Enum implements SMPEnum
{
	@SerializedName("0")
	TI_INSTR_CLASS_TYPE_All(0),
	@SerializedName("1")
	TI_INSTR_CLASS_TYPE_Order(1),
	@SerializedName("2")
	TI_INSTR_CLASS_TYPE_Proposal(2),
	@SerializedName("3")
	TI_INSTR_CLASS_TYPE_Rfq(3),
	@SerializedName("4")
	TI_INSTR_CLASS_TYPE_PublicInfo(4),
	@SerializedName("5")
	TI_INSTR_CLASS_TYPE_PrivateInfo(5),
	@SerializedName("6")
	TI_INSTR_CLASS_TYPE_InventoryQuotes(6),
	@SerializedName("7")
	TI_INSTR_CLASS_TYPE_NotUsed1(7),
	@SerializedName("8")
	TI_INSTR_CLASS_TYPE_NotUsed2(8),
	@SerializedName("9")
	TI_INSTR_CLASS_TYPE_StageOrders(9),
	@SerializedName("10")
	TI_INSTR_CLASS_TYPE_OTC(10),
	@SerializedName("11")
	TI_INSTR_CLASS_TYPE_MidPriceFASOrder(11),
	@SerializedName("12")
	TI_INSTR_CLASS_TYPE_MidPriceFOKOrder(12),
	@SerializedName("13")
	TI_INSTR_CLASS_TYPE_InventoryOrderSend(13),
	@SerializedName("14")
	TI_INSTR_CLASS_TYPE_InventoryOrderRespond(14),
	@SerializedName("15")
	TI_INSTR_CLASS_TYPE_CashOffer(15),
	@SerializedName("16")
	TI_INSTR_CLASS_TYPE_CollateralOffer(16),
	@SerializedName("17")
	TI_INSTR_CLASS_TYPE_MessageBoard(17),
	@SerializedName("18")
	TI_INSTR_CLASS_TYPE_IOI(18);

	private int value;

	TI_INSTR_CLASS_TYPE_Enum(int value)
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
		if (value == TI_INSTR_CLASS_TYPE_All.ordinal())
			return "All";
		if (value == TI_INSTR_CLASS_TYPE_Order.ordinal())
			return "Order";
		if (value == TI_INSTR_CLASS_TYPE_Proposal.ordinal())
			return "Proposal";
		if (value == TI_INSTR_CLASS_TYPE_Rfq.ordinal())
			return "Rfq";
		if (value == TI_INSTR_CLASS_TYPE_PublicInfo.ordinal())
			return "PublicInfo";
		if (value == TI_INSTR_CLASS_TYPE_PrivateInfo.ordinal())
			return "PrivateInfo";
		if (value == TI_INSTR_CLASS_TYPE_InventoryQuotes.ordinal())
			return "Inventory Quotes";
		if (value == TI_INSTR_CLASS_TYPE_NotUsed1.ordinal())
			return "Not Used";
		if (value == TI_INSTR_CLASS_TYPE_NotUsed2.ordinal())
			return "Not Used";
		if (value == TI_INSTR_CLASS_TYPE_StageOrders.ordinal())
			return "Stage Orders";
		if (value == TI_INSTR_CLASS_TYPE_OTC.ordinal())
			return "OTC";
		if (value == TI_INSTR_CLASS_TYPE_MidPriceFASOrder.ordinal())
			return "Mid Price FAS Order";
		if (value == TI_INSTR_CLASS_TYPE_MidPriceFOKOrder.ordinal())
			return "Mid Price FOK Order";
		if (value == TI_INSTR_CLASS_TYPE_InventoryOrderSend.ordinal())
			return "Inventory order send";
		if (value == TI_INSTR_CLASS_TYPE_InventoryOrderRespond.ordinal())
			return "Inventory order respond";
		if (value == TI_INSTR_CLASS_TYPE_CashOffer.ordinal())
			return "Cash Offer";
		if (value == TI_INSTR_CLASS_TYPE_CollateralOffer.ordinal())
			return "Collateral Offer";
		if (value == TI_INSTR_CLASS_TYPE_MessageBoard.ordinal())
			return "Message Board";
		if (value == TI_INSTR_CLASS_TYPE_IOI.ordinal())
			return "IOI - Indication of Interest";
		return "";
	}
	public static TI_INSTR_CLASS_TYPE_Enum getEnum(int value)
	{
		if ((value >= 0) && (value <= TI_INSTR_CLASS_TYPE_Enum.values().length))
			return values()[value];
		return values()[0];
	}
}
