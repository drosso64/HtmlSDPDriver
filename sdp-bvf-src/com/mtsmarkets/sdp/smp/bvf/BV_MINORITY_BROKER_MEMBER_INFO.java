package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_MINORITY_BROKER_MEMBER_INFO extends SMPMessage
{
	public static final long CLASS_ID = 100227;

	private long MemberId = 0;
	private String MemberCode = "";
	private String MemberDes = "";
	private String MemberShortDes = "";
	private long BrokerId = 0;
	private String BrokerCode = "";
	private String BrokerDes = "";
	private String BrokerShortDes = "";
	private TI_FLAG_Enum PreferredFg = TI_FLAG_Enum.TI_FLAG_No;

	public BV_MINORITY_BROKER_MEMBER_INFO()
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
	public String getMemberDes()
	{
		return MemberDes;
	}
	public void setMemberDes(String value)
	{
		MemberDes = value;
	}
	public String getMemberShortDes()
	{
		return MemberShortDes;
	}
	public void setMemberShortDes(String value)
	{
		MemberShortDes = value;
	}
	public long getBrokerId()
	{
		return BrokerId;
	}
	public void setBrokerId(long value)
	{
		BrokerId = value;
	}
	public String getBrokerCode()
	{
		return BrokerCode;
	}
	public void setBrokerCode(String value)
	{
		BrokerCode = value;
	}
	public String getBrokerDes()
	{
		return BrokerDes;
	}
	public void setBrokerDes(String value)
	{
		BrokerDes = value;
	}
	public String getBrokerShortDes()
	{
		return BrokerShortDes;
	}
	public void setBrokerShortDes(String value)
	{
		BrokerShortDes = value;
	}
	public TI_FLAG_Enum getPreferredFg()
	{
		return PreferredFg;
	}
	public void setPreferredFg(TI_FLAG_Enum value)
	{
		PreferredFg = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MemberId = (long)byteBuffer.readInt();
		MemberCode = byteBuffer.readString();
		MemberDes = byteBuffer.readString();
		MemberShortDes = byteBuffer.readString();
		BrokerId = (long)byteBuffer.readInt();
		BrokerCode = byteBuffer.readString();
		BrokerDes = byteBuffer.readString();
		BrokerShortDes = byteBuffer.readString();
		PreferredFg = PreferredFg.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MemberId & 0xFFFFFFFFL));
		byteBuffer.writeString(MemberCode);
		byteBuffer.writeString(MemberDes);
		byteBuffer.writeString(MemberShortDes);
		byteBuffer.writeInt((int)(BrokerId & 0xFFFFFFFFL));
		byteBuffer.writeString(BrokerCode);
		byteBuffer.writeString(BrokerDes);
		byteBuffer.writeString(BrokerShortDes);
		byteBuffer.writeInt(PreferredFg.getValue());

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
		stringBuilder.append("BV_MINORITY_BROKER_MEMBER_INFO::");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("MemberCode(").append(MemberCode).append(")");
		stringBuilder.append("MemberDes(").append(MemberDes).append(")");
		stringBuilder.append("MemberShortDes(").append(MemberShortDes).append(")");
		stringBuilder.append("BrokerId(").append(BrokerId).append(")");
		stringBuilder.append("BrokerCode(").append(BrokerCode).append(")");
		stringBuilder.append("BrokerDes(").append(BrokerDes).append(")");
		stringBuilder.append("BrokerShortDes(").append(BrokerShortDes).append(")");
		stringBuilder.append("PreferredFg(").append(PreferredFg).append(")");
		return stringBuilder.toString();
	}
}
