package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_TRADE_MEMBER_INFO extends SMPMessage
{
	public static final long CLASS_ID = 114906;

	private long SectionId = 0;
	private BV_MEMBER_INFO MemberInfo = new BV_MEMBER_INFO();
	private long RefMsgId = 0;
	private TI_TXN_TYPE_Enum TxnType = TI_TXN_TYPE_Enum.TI_TXN_TYPE_Quote;
	private short SettlSystemId = 0;
	private String ClientOrderId = "";
	private String ClientRefMsgId = "";
	private String ClientExecID = "";
	private long QuoteTraderID = 0;
	private String QuoteTraderName = "";
	private long StageOrderId = 0;
	private String SettlementInfo = "";
	private TI_TIME_ZONE TimeZone = new TI_TIME_ZONE();
	private BV_ALGO_INFO_TYPE_Enum ShortCodeType1 = BV_ALGO_INFO_TYPE_Enum.BV_ALGO_INFO_TYPE_None;
	private BV_ALGO_INFO_TYPE_Enum ShortCodeType2 = BV_ALGO_INFO_TYPE_Enum.BV_ALGO_INFO_TYPE_None;
	private BV_SHORT_SELLING_INDICATOR_Enum ShortSellingIndicator = BV_SHORT_SELLING_INDICATOR_Enum.BV_SHORT_SELLING_INDICATOR_None;

	public BV_TRADE_MEMBER_INFO()
	{
	}

	public long getSectionId()
	{
		return SectionId;
	}
	public void setSectionId(long value)
	{
		SectionId = value;
	}
	public BV_MEMBER_INFO getMemberInfo()
	{
		return MemberInfo;
	}
	public void setMemberInfo(BV_MEMBER_INFO value)
	{
		MemberInfo = value;
	}
	public long getRefMsgId()
	{
		return RefMsgId;
	}
	public void setRefMsgId(long value)
	{
		RefMsgId = value;
	}
	public TI_TXN_TYPE_Enum getTxnType()
	{
		return TxnType;
	}
	public void setTxnType(TI_TXN_TYPE_Enum value)
	{
		TxnType = value;
	}
	public short getSettlSystemId()
	{
		return SettlSystemId;
	}
	public void setSettlSystemId(short value)
	{
		SettlSystemId = value;
	}
	public String getClientOrderId()
	{
		return ClientOrderId;
	}
	public void setClientOrderId(String value)
	{
		ClientOrderId = value;
	}
	public String getClientRefMsgId()
	{
		return ClientRefMsgId;
	}
	public void setClientRefMsgId(String value)
	{
		ClientRefMsgId = value;
	}
	public String getClientExecID()
	{
		return ClientExecID;
	}
	public void setClientExecID(String value)
	{
		ClientExecID = value;
	}
	public long getQuoteTraderID()
	{
		return QuoteTraderID;
	}
	public void setQuoteTraderID(long value)
	{
		QuoteTraderID = value;
	}
	public String getQuoteTraderName()
	{
		return QuoteTraderName;
	}
	public void setQuoteTraderName(String value)
	{
		QuoteTraderName = value;
	}
	public long getStageOrderId()
	{
		return StageOrderId;
	}
	public void setStageOrderId(long value)
	{
		StageOrderId = value;
	}
	public String getSettlementInfo()
	{
		return SettlementInfo;
	}
	public void setSettlementInfo(String value)
	{
		SettlementInfo = value;
	}
	public TI_TIME_ZONE getTimeZone()
	{
		return TimeZone;
	}
	public void setTimeZone(TI_TIME_ZONE value)
	{
		TimeZone = value;
	}
	public BV_ALGO_INFO_TYPE_Enum getShortCodeType1()
	{
		return ShortCodeType1;
	}
	public void setShortCodeType1(BV_ALGO_INFO_TYPE_Enum value)
	{
		ShortCodeType1 = value;
	}
	public BV_ALGO_INFO_TYPE_Enum getShortCodeType2()
	{
		return ShortCodeType2;
	}
	public void setShortCodeType2(BV_ALGO_INFO_TYPE_Enum value)
	{
		ShortCodeType2 = value;
	}
	public BV_SHORT_SELLING_INDICATOR_Enum getShortSellingIndicator()
	{
		return ShortSellingIndicator;
	}
	public void setShortSellingIndicator(BV_SHORT_SELLING_INDICATOR_Enum value)
	{
		ShortSellingIndicator = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		SectionId = (long)byteBuffer.readInt();
		MemberInfo.readXDR(byteBuffer);
		RefMsgId = (long)byteBuffer.readInt();
		TxnType = TxnType.getEnum(byteBuffer.readInt());
		SettlSystemId = (short)byteBuffer.readInt();
		ClientOrderId = byteBuffer.readString();
		ClientRefMsgId = byteBuffer.readString();
		ClientExecID = byteBuffer.readString();
		QuoteTraderID = (long)byteBuffer.readInt();
		QuoteTraderName = byteBuffer.readString();
		StageOrderId = (long)byteBuffer.readInt();
		SettlementInfo = byteBuffer.readString();
		TimeZone.readXDR(byteBuffer);
		ShortCodeType1 = ShortCodeType1.getEnum(byteBuffer.readInt());
		ShortCodeType2 = ShortCodeType2.getEnum(byteBuffer.readInt());
		ShortSellingIndicator = ShortSellingIndicator.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(SectionId & 0xFFFFFFFFL));
		MemberInfo.writeXDR(byteBuffer);
		byteBuffer.writeInt((int)(RefMsgId & 0xFFFFFFFFL));
		byteBuffer.writeInt(TxnType.getValue());
		byteBuffer.writeInt((int)(SettlSystemId & 0xFFFFL));
		byteBuffer.writeString(ClientOrderId);
		byteBuffer.writeString(ClientRefMsgId);
		byteBuffer.writeString(ClientExecID);
		byteBuffer.writeInt((int)(QuoteTraderID & 0xFFFFFFFFL));
		byteBuffer.writeString(QuoteTraderName);
		byteBuffer.writeInt((int)(StageOrderId & 0xFFFFFFFFL));
		byteBuffer.writeString(SettlementInfo);
		TimeZone.writeXDR(byteBuffer);
		byteBuffer.writeInt(ShortCodeType1.getValue());
		byteBuffer.writeInt(ShortCodeType2.getValue());
		byteBuffer.writeInt(ShortSellingIndicator.getValue());

		return byteBuffer.position() - init;
	}
	@Override
	public long getSMPClassId()
	{
		return CLASS_ID;
	}
	@Override
	public String toString()
	{
		StringBuilder stringBuilder = new StringBuilder(1024);
		stringBuilder.append("BV_TRADE_MEMBER_INFO::");
		stringBuilder.append("SectionId(").append(SectionId).append(")");
		stringBuilder.append("MemberInfo(").append(MemberInfo.toString()).append(")");
		stringBuilder.append("RefMsgId(").append(RefMsgId).append(")");
		stringBuilder.append("TxnType(").append(TxnType).append(")");
		stringBuilder.append("SettlSystemId(").append(SettlSystemId).append(")");
		stringBuilder.append("ClientOrderId(").append(ClientOrderId).append(")");
		stringBuilder.append("ClientRefMsgId(").append(ClientRefMsgId).append(")");
		stringBuilder.append("ClientExecID(").append(ClientExecID).append(")");
		stringBuilder.append("QuoteTraderID(").append(QuoteTraderID).append(")");
		stringBuilder.append("QuoteTraderName(").append(QuoteTraderName).append(")");
		stringBuilder.append("StageOrderId(").append(StageOrderId).append(")");
		stringBuilder.append("SettlementInfo(").append(SettlementInfo).append(")");
		stringBuilder.append("TimeZone(").append(TimeZone.toString()).append(")");
		stringBuilder.append("ShortCodeType1(").append(ShortCodeType1).append(")");
		stringBuilder.append("ShortCodeType2(").append(ShortCodeType2).append(")");
		stringBuilder.append("ShortSellingIndicator(").append(ShortSellingIndicator).append(")");
		return stringBuilder.toString();
	}
}
