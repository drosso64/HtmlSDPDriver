package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_BOND_LISTING_REQUEST extends SMPMessage
{
	public static final long CLASS_ID = 400102;

	private TI_MSG_INFO ListingRequestInfo = new TI_MSG_INFO();
	private long MemberId = 0;
	private String MemberCode = "";
	private String MemberDesc = "";
	private String MemberShortDesc = "";
	private long TraderId = 0;
	private String TraderName = "";
	private String IsinCode = "";
	private BV_BOND_LISTING_REQUEST_STATUS_Enum Status = BV_BOND_LISTING_REQUEST_STATUS_Enum.BV_BOND_LISTING_REQUEST_STATUS_None;
	private BV_BOND_LISTING_REQUEST_REASON_Enum Reason = BV_BOND_LISTING_REQUEST_REASON_Enum.BV_BOND_LISTING_REQUEST_REASON_None;
	private long UpdateTime = 0;

	public BV_BOND_LISTING_REQUEST()
	{
	}

	public TI_MSG_INFO getListingRequestInfo()
	{
		return ListingRequestInfo;
	}
	public void setListingRequestInfo(TI_MSG_INFO value)
	{
		ListingRequestInfo = value;
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
	public String getMemberDesc()
	{
		return MemberDesc;
	}
	public void setMemberDesc(String value)
	{
		MemberDesc = value;
	}
	public String getMemberShortDesc()
	{
		return MemberShortDesc;
	}
	public void setMemberShortDesc(String value)
	{
		MemberShortDesc = value;
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
	public String getIsinCode()
	{
		return IsinCode;
	}
	public void setIsinCode(String value)
	{
		IsinCode = value;
	}
	public BV_BOND_LISTING_REQUEST_STATUS_Enum getStatus()
	{
		return Status;
	}
	public void setStatus(BV_BOND_LISTING_REQUEST_STATUS_Enum value)
	{
		Status = value;
	}
	public BV_BOND_LISTING_REQUEST_REASON_Enum getReason()
	{
		return Reason;
	}
	public void setReason(BV_BOND_LISTING_REQUEST_REASON_Enum value)
	{
		Reason = value;
	}
	public long getUpdateTime()
	{
		return UpdateTime;
	}
	public void setUpdateTime(long value)
	{
		UpdateTime = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		ListingRequestInfo.readXDR(byteBuffer);
		MemberId = (long)byteBuffer.readInt();
		MemberCode = byteBuffer.readString();
		MemberDesc = byteBuffer.readString();
		MemberShortDesc = byteBuffer.readString();
		TraderId = (long)byteBuffer.readInt();
		TraderName = byteBuffer.readString();
		IsinCode = byteBuffer.readString();
		Status = Status.getEnum(byteBuffer.readInt());
		Reason = Reason.getEnum(byteBuffer.readInt());
		UpdateTime = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		ListingRequestInfo.writeXDR(byteBuffer);
		byteBuffer.writeInt((int)(MemberId & 0xFFFFFFFFL));
		byteBuffer.writeString(MemberCode);
		byteBuffer.writeString(MemberDesc);
		byteBuffer.writeString(MemberShortDesc);
		byteBuffer.writeInt((int)(TraderId & 0xFFFFFFFFL));
		byteBuffer.writeString(TraderName);
		byteBuffer.writeString(IsinCode);
		byteBuffer.writeInt(Status.getValue());
		byteBuffer.writeInt(Reason.getValue());
		byteBuffer.writeLong(UpdateTime);

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
		stringBuilder.append("BV_BOND_LISTING_REQUEST::");
		stringBuilder.append("ListingRequestInfo(").append(ListingRequestInfo.toString()).append(")");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("MemberCode(").append(MemberCode).append(")");
		stringBuilder.append("MemberDesc(").append(MemberDesc).append(")");
		stringBuilder.append("MemberShortDesc(").append(MemberShortDesc).append(")");
		stringBuilder.append("TraderId(").append(TraderId).append(")");
		stringBuilder.append("TraderName(").append(TraderName).append(")");
		stringBuilder.append("IsinCode(").append(IsinCode).append(")");
		stringBuilder.append("Status(").append(Status).append(")");
		stringBuilder.append("Reason(").append(Reason).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		return stringBuilder.toString();
	}
}
