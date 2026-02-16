package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class GOV_MEMBER_X_SECTION_X_IC_QUERY_PARAM extends SMPMessage
{
	public static final long CLASS_ID = 100819;

	private TI_QUERY_OP_Enum MemberIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long MemberId = 0;
	private TI_QUERY_OP_Enum SectionIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long SectionId = 0;
	private TI_QUERY_OP_Enum InstrumentClassIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long InstrumentClassId = 0;

	public GOV_MEMBER_X_SECTION_X_IC_QUERY_PARAM()
	{
	}

	public TI_QUERY_OP_Enum getMemberIdOp()
	{
		return MemberIdOp;
	}
	public void setMemberIdOp(TI_QUERY_OP_Enum value)
	{
		MemberIdOp = value;
	}
	public long getMemberId()
	{
		return MemberId;
	}
	public void setMemberId(long value)
	{
		MemberId = value;
	}
	public TI_QUERY_OP_Enum getSectionIdOp()
	{
		return SectionIdOp;
	}
	public void setSectionIdOp(TI_QUERY_OP_Enum value)
	{
		SectionIdOp = value;
	}
	public long getSectionId()
	{
		return SectionId;
	}
	public void setSectionId(long value)
	{
		SectionId = value;
	}
	public TI_QUERY_OP_Enum getInstrumentClassIdOp()
	{
		return InstrumentClassIdOp;
	}
	public void setInstrumentClassIdOp(TI_QUERY_OP_Enum value)
	{
		InstrumentClassIdOp = value;
	}
	public long getInstrumentClassId()
	{
		return InstrumentClassId;
	}
	public void setInstrumentClassId(long value)
	{
		InstrumentClassId = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MemberIdOp = MemberIdOp.getEnum(byteBuffer.readInt());
		MemberId = (long)byteBuffer.readInt();
		SectionIdOp = SectionIdOp.getEnum(byteBuffer.readInt());
		SectionId = (long)byteBuffer.readInt();
		InstrumentClassIdOp = InstrumentClassIdOp.getEnum(byteBuffer.readInt());
		InstrumentClassId = (long)byteBuffer.readInt();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt(MemberIdOp.getValue());
		byteBuffer.writeInt((int)(MemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt(SectionIdOp.getValue());
		byteBuffer.writeInt((int)(SectionId & 0xFFFFFFFFL));
		byteBuffer.writeInt(InstrumentClassIdOp.getValue());
		byteBuffer.writeInt((int)(InstrumentClassId & 0xFFFFFFFFL));

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
		stringBuilder.append("GOV_MEMBER_X_SECTION_X_IC_QUERY_PARAM::");
		stringBuilder.append("MemberIdOp(").append(MemberIdOp).append(")");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("SectionIdOp(").append(SectionIdOp).append(")");
		stringBuilder.append("SectionId(").append(SectionId).append(")");
		stringBuilder.append("InstrumentClassIdOp(").append(InstrumentClassIdOp).append(")");
		stringBuilder.append("InstrumentClassId(").append(InstrumentClassId).append(")");
		return stringBuilder.toString();
	}
}
