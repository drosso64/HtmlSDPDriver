package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_PORTFOLIO_RFCQ_DEALER_LIST_INFO extends SMPMessage
{
	public static final long CLASS_ID = 410016;

	private long MemberId = 0;
	private String MemberCode = "";
	private String MemberDesc = "";
	private String MemberShortDesc = "";
	private TI_FLAG_Enum RFCQEnabledFg = TI_FLAG_Enum.TI_FLAG_No;
	private long InventoryNumOfLegs = 0;
	private long AxeNumOfLegs = 0;
	private long AntiAxeNumOfLegs = 0;

	public BV_PORTFOLIO_RFCQ_DEALER_LIST_INFO()
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
	public TI_FLAG_Enum getRFCQEnabledFg()
	{
		return RFCQEnabledFg;
	}
	public void setRFCQEnabledFg(TI_FLAG_Enum value)
	{
		RFCQEnabledFg = value;
	}
	public long getInventoryNumOfLegs()
	{
		return InventoryNumOfLegs;
	}
	public void setInventoryNumOfLegs(long value)
	{
		InventoryNumOfLegs = value;
	}
	public long getAxeNumOfLegs()
	{
		return AxeNumOfLegs;
	}
	public void setAxeNumOfLegs(long value)
	{
		AxeNumOfLegs = value;
	}
	public long getAntiAxeNumOfLegs()
	{
		return AntiAxeNumOfLegs;
	}
	public void setAntiAxeNumOfLegs(long value)
	{
		AntiAxeNumOfLegs = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MemberId = (long)byteBuffer.readInt();
		MemberCode = byteBuffer.readString();
		MemberDesc = byteBuffer.readString();
		MemberShortDesc = byteBuffer.readString();
		RFCQEnabledFg = RFCQEnabledFg.getEnum(byteBuffer.readInt());
		InventoryNumOfLegs = (long)byteBuffer.readInt();
		AxeNumOfLegs = (long)byteBuffer.readInt();
		AntiAxeNumOfLegs = (long)byteBuffer.readInt();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MemberId & 0xFFFFFFFFL));
		byteBuffer.writeString(MemberCode);
		byteBuffer.writeString(MemberDesc);
		byteBuffer.writeString(MemberShortDesc);
		byteBuffer.writeInt(RFCQEnabledFg.getValue());
		byteBuffer.writeInt((int)(InventoryNumOfLegs & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(AxeNumOfLegs & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(AntiAxeNumOfLegs & 0xFFFFFFFFL));

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
		stringBuilder.append("BV_PORTFOLIO_RFCQ_DEALER_LIST_INFO::");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("MemberCode(").append(MemberCode).append(")");
		stringBuilder.append("MemberDesc(").append(MemberDesc).append(")");
		stringBuilder.append("MemberShortDesc(").append(MemberShortDesc).append(")");
		stringBuilder.append("RFCQEnabledFg(").append(RFCQEnabledFg).append(")");
		stringBuilder.append("InventoryNumOfLegs(").append(InventoryNumOfLegs).append(")");
		stringBuilder.append("AxeNumOfLegs(").append(AxeNumOfLegs).append(")");
		stringBuilder.append("AntiAxeNumOfLegs(").append(AntiAxeNumOfLegs).append(")");
		return stringBuilder.toString();
	}
}
