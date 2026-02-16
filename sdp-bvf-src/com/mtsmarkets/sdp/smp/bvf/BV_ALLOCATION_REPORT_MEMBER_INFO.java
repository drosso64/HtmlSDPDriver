package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_ALLOCATION_REPORT_MEMBER_INFO extends SMPMessage
{
	public static final long CLASS_ID = 410001;

	private long MemberId = 0;
	private String MemberCode = "";
	private String MemberShortDesc = "";
	private String MemberDesc = "";
	private String LeiCode = "";
	private String BICCode = "";
	private long TraderId = 0;
	private String TraderName = "";
	private BV_SHORT_SELLING_INDICATOR_Enum ShortSellingIndicator = BV_SHORT_SELLING_INDICATOR_Enum.BV_SHORT_SELLING_INDICATOR_None;

	public BV_ALLOCATION_REPORT_MEMBER_INFO()
	{
	}

	public long getMemberId()
	{
		return MemberId;
	}
	public void setMemberId(long value)
	{
		MemberId = value;
	}
	public String getMemberCode()
	{
		return MemberCode;
	}
	public void setMemberCode(String value)
	{
		MemberCode = value;
	}
	public String getMemberShortDesc()
	{
		return MemberShortDesc;
	}
	public void setMemberShortDesc(String value)
	{
		MemberShortDesc = value;
	}
	public String getMemberDesc()
	{
		return MemberDesc;
	}
	public void setMemberDesc(String value)
	{
		MemberDesc = value;
	}
	public String getLeiCode()
	{
		return LeiCode;
	}
	public void setLeiCode(String value)
	{
		LeiCode = value;
	}
	public String getBICCode()
	{
		return BICCode;
	}
	public void setBICCode(String value)
	{
		BICCode = value;
	}
	public long getTraderId()
	{
		return TraderId;
	}
	public void setTraderId(long value)
	{
		TraderId = value;
	}
	public String getTraderName()
	{
		return TraderName;
	}
	public void setTraderName(String value)
	{
		TraderName = value;
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
		MemberId = (long)byteBuffer.readInt();
		MemberCode = byteBuffer.readString();
		MemberShortDesc = byteBuffer.readString();
		MemberDesc = byteBuffer.readString();
		LeiCode = byteBuffer.readString();
		BICCode = byteBuffer.readString();
		TraderId = (long)byteBuffer.readInt();
		TraderName = byteBuffer.readString();
		ShortSellingIndicator = ShortSellingIndicator.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MemberId & 0xFFFFFFFFL));
		byteBuffer.writeString(MemberCode);
		byteBuffer.writeString(MemberShortDesc);
		byteBuffer.writeString(MemberDesc);
		byteBuffer.writeString(LeiCode);
		byteBuffer.writeString(BICCode);
		byteBuffer.writeInt((int)(TraderId & 0xFFFFFFFFL));
		byteBuffer.writeString(TraderName);
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
		stringBuilder.append("BV_ALLOCATION_REPORT_MEMBER_INFO::");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("MemberCode(").append(MemberCode).append(")");
		stringBuilder.append("MemberShortDesc(").append(MemberShortDesc).append(")");
		stringBuilder.append("MemberDesc(").append(MemberDesc).append(")");
		stringBuilder.append("LeiCode(").append(LeiCode).append(")");
		stringBuilder.append("BICCode(").append(BICCode).append(")");
		stringBuilder.append("TraderId(").append(TraderId).append(")");
		stringBuilder.append("TraderName(").append(TraderName).append(")");
		stringBuilder.append("ShortSellingIndicator(").append(ShortSellingIndicator).append(")");
		return stringBuilder.toString();
	}
}
