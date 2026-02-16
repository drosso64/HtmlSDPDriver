package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_RFCQ_MESSAGE extends SMPMessage
{
	public static final long CLASS_ID = 114295;

	private TI_MSG_INFO RfcqMsgInfo = new TI_MSG_INFO();
	private BV_MEMBER_INFO TraderInfo = new BV_MEMBER_INFO();
	private BV_MEMBER_INFO AddresseeMemberInfo = new BV_MEMBER_INFO();
	private BV_RFCQ_ADDRESSEE_TYPE_Enum AddresseeType = BV_RFCQ_ADDRESSEE_TYPE_Enum.BV_RFCQ_ADDRESSEE_TYPE_Single;
	private long MsgLen = 0;
	private String MsgText = "";
	private long RfcqReqId = 0;

	public BV_RFCQ_MESSAGE()
	{
	}

	public TI_MSG_INFO getRfcqMsgInfo()
	{
		return RfcqMsgInfo;
	}
	public void setRfcqMsgInfo(TI_MSG_INFO value)
	{
		RfcqMsgInfo = value;
	}
	public BV_MEMBER_INFO getTraderInfo()
	{
		return TraderInfo;
	}
	public void setTraderInfo(BV_MEMBER_INFO value)
	{
		TraderInfo = value;
	}
	public BV_MEMBER_INFO getAddresseeMemberInfo()
	{
		return AddresseeMemberInfo;
	}
	public void setAddresseeMemberInfo(BV_MEMBER_INFO value)
	{
		AddresseeMemberInfo = value;
	}
	public BV_RFCQ_ADDRESSEE_TYPE_Enum getAddresseeType()
	{
		return AddresseeType;
	}
	public void setAddresseeType(BV_RFCQ_ADDRESSEE_TYPE_Enum value)
	{
		AddresseeType = value;
	}
	public long getMsgLen()
	{
		return MsgLen;
	}
	public void setMsgLen(long value)
	{
		MsgLen = value;
	}
	public String getMsgText()
	{
		return MsgText;
	}
	public void setMsgText(String value)
	{
		MsgText = value;
	}
	public long getRfcqReqId()
	{
		return RfcqReqId;
	}
	public void setRfcqReqId(long value)
	{
		RfcqReqId = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		RfcqMsgInfo.readXDR(byteBuffer);
		TraderInfo.readXDR(byteBuffer);
		AddresseeMemberInfo.readXDR(byteBuffer);
		AddresseeType = AddresseeType.getEnum(byteBuffer.readInt());
		MsgLen = (long)byteBuffer.readInt();
		MsgText = byteBuffer.readString();
		RfcqReqId = (long)byteBuffer.readInt();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		RfcqMsgInfo.writeXDR(byteBuffer);
		TraderInfo.writeXDR(byteBuffer);
		AddresseeMemberInfo.writeXDR(byteBuffer);
		byteBuffer.writeInt(AddresseeType.getValue());
		byteBuffer.writeInt((int)(MsgLen & 0xFFFFFFFFL));
		byteBuffer.writeString(MsgText);
		byteBuffer.writeInt((int)(RfcqReqId & 0xFFFFFFFFL));

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
		stringBuilder.append("BV_RFCQ_MESSAGE::");
		stringBuilder.append("RfcqMsgInfo(").append(RfcqMsgInfo.toString()).append(")");
		stringBuilder.append("TraderInfo(").append(TraderInfo.toString()).append(")");
		stringBuilder.append("AddresseeMemberInfo(").append(AddresseeMemberInfo.toString()).append(")");
		stringBuilder.append("AddresseeType(").append(AddresseeType).append(")");
		stringBuilder.append("MsgLen(").append(MsgLen).append(")");
		stringBuilder.append("MsgText(").append(MsgText).append(")");
		stringBuilder.append("RfcqReqId(").append(RfcqReqId).append(")");
		return stringBuilder.toString();
	}
}
