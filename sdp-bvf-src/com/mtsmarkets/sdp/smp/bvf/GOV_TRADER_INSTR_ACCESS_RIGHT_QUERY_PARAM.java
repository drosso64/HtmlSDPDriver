package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class GOV_TRADER_INSTR_ACCESS_RIGHT_QUERY_PARAM extends SMPMessage
{
	public static final long CLASS_ID = 100820;

	private TI_QUERY_OP_Enum MemberIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long MemberId = 0;
	private TI_QUERY_OP_Enum TraderIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long TraderId = 0;

	public GOV_TRADER_INSTR_ACCESS_RIGHT_QUERY_PARAM()
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
	public TI_QUERY_OP_Enum getTraderIdOp()
	{
		return TraderIdOp;
	}
	public void setTraderIdOp(TI_QUERY_OP_Enum value)
	{
		TraderIdOp = value;
	}
	public long getTraderId()
	{
		return TraderId;
	}
	public void setTraderId(long value)
	{
		TraderId = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MemberIdOp = MemberIdOp.getEnum(byteBuffer.readInt());
		MemberId = (long)byteBuffer.readInt();
		TraderIdOp = TraderIdOp.getEnum(byteBuffer.readInt());
		TraderId = (long)byteBuffer.readInt();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt(MemberIdOp.getValue());
		byteBuffer.writeInt((int)(MemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt(TraderIdOp.getValue());
		byteBuffer.writeInt((int)(TraderId & 0xFFFFFFFFL));

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
		stringBuilder.append("GOV_TRADER_INSTR_ACCESS_RIGHT_QUERY_PARAM::");
		stringBuilder.append("MemberIdOp(").append(MemberIdOp).append(")");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("TraderIdOp(").append(TraderIdOp).append(")");
		stringBuilder.append("TraderId(").append(TraderId).append(")");
		return stringBuilder.toString();
	}
}
