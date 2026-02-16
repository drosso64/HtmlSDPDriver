package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_DEAL_MEMBER_INFO extends SMPMessage
{
	public static final long CLASS_ID = 114905;

	private long SectionId = 0;
	private BV_MEMBER_INFO MemberInfo = new BV_MEMBER_INFO();
	private long RefMsgId = 0;
	private TI_TXN_TYPE_Enum TxnType = TI_TXN_TYPE_Enum.TI_TXN_TYPE_Quote;
	private String ClientOrderId = "";
	private long StageOrderId = 0;
	private TI_TIME_ZONE TimeZone = new TI_TIME_ZONE();
	private BV_SHORT_SELLING_INDICATOR_Enum ShortSellingIndicator = BV_SHORT_SELLING_INDICATOR_Enum.BV_SHORT_SELLING_INDICATOR_None;

	public BV_DEAL_MEMBER_INFO()
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
	public String getClientOrderId()
	{
		return ClientOrderId;
	}
	public void setClientOrderId(String value)
	{
		ClientOrderId = value;
	}
	public long getStageOrderId()
	{
		return StageOrderId;
	}
	public void setStageOrderId(long value)
	{
		StageOrderId = value;
	}
	public TI_TIME_ZONE getTimeZone()
	{
		return TimeZone;
	}
	public void setTimeZone(TI_TIME_ZONE value)
	{
		TimeZone = value;
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
		ClientOrderId = byteBuffer.readString();
		StageOrderId = (long)byteBuffer.readInt();
		TimeZone.readXDR(byteBuffer);
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
		byteBuffer.writeString(ClientOrderId);
		byteBuffer.writeInt((int)(StageOrderId & 0xFFFFFFFFL));
		TimeZone.writeXDR(byteBuffer);
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
		stringBuilder.append("BV_DEAL_MEMBER_INFO::");
		stringBuilder.append("SectionId(").append(SectionId).append(")");
		stringBuilder.append("MemberInfo(").append(MemberInfo.toString()).append(")");
		stringBuilder.append("RefMsgId(").append(RefMsgId).append(")");
		stringBuilder.append("TxnType(").append(TxnType).append(")");
		stringBuilder.append("ClientOrderId(").append(ClientOrderId).append(")");
		stringBuilder.append("StageOrderId(").append(StageOrderId).append(")");
		stringBuilder.append("TimeZone(").append(TimeZone.toString()).append(")");
		stringBuilder.append("ShortSellingIndicator(").append(ShortSellingIndicator).append(")");
		return stringBuilder.toString();
	}
}
