package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_FIX_SESSION_STATISTIC_QUERY_PARAM extends SMPMessage
{
	public static final long CLASS_ID = 100841;

	private TI_QUERY_OP_Enum SessionIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long SessionId = 0;
	private TI_QUERY_OP_Enum MemberIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long MemberId = 0;
	private TI_QUERY_OP_Enum TraderIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long TraderId = 0;
	private TI_QUERY_OP_Enum SenderCompIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String SenderCompId = "";
	private TI_QUERY_OP_Enum TargetCompIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private String TargetCompId = "";

	public TI_FIX_SESSION_STATISTIC_QUERY_PARAM()
	{
	}

	public TI_QUERY_OP_Enum getSessionIdOp()
	{
		return SessionIdOp;
	}
	public void setSessionIdOp(TI_QUERY_OP_Enum value)
	{
		SessionIdOp = value;
	}
	public long getSessionId()
	{
		return SessionId;
	}
	public void setSessionId(long value)
	{
		SessionId = value;
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
	public TI_QUERY_OP_Enum getSenderCompIdOp()
	{
		return SenderCompIdOp;
	}
	public void setSenderCompIdOp(TI_QUERY_OP_Enum value)
	{
		SenderCompIdOp = value;
	}
	public String getSenderCompId()
	{
		return SenderCompId;
	}
	public void setSenderCompId(String value)
	{
		SenderCompId = value;
	}
	public TI_QUERY_OP_Enum getTargetCompIdOp()
	{
		return TargetCompIdOp;
	}
	public void setTargetCompIdOp(TI_QUERY_OP_Enum value)
	{
		TargetCompIdOp = value;
	}
	public String getTargetCompId()
	{
		return TargetCompId;
	}
	public void setTargetCompId(String value)
	{
		TargetCompId = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		SessionIdOp = SessionIdOp.getEnum(byteBuffer.readInt());
		SessionId = (long)byteBuffer.readInt();
		MemberIdOp = MemberIdOp.getEnum(byteBuffer.readInt());
		MemberId = (long)byteBuffer.readInt();
		TraderIdOp = TraderIdOp.getEnum(byteBuffer.readInt());
		TraderId = (long)byteBuffer.readInt();
		SenderCompIdOp = SenderCompIdOp.getEnum(byteBuffer.readInt());
		SenderCompId = byteBuffer.readString();
		TargetCompIdOp = TargetCompIdOp.getEnum(byteBuffer.readInt());
		TargetCompId = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt(SessionIdOp.getValue());
		byteBuffer.writeInt((int)(SessionId & 0xFFFFFFFFL));
		byteBuffer.writeInt(MemberIdOp.getValue());
		byteBuffer.writeInt((int)(MemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt(TraderIdOp.getValue());
		byteBuffer.writeInt((int)(TraderId & 0xFFFFFFFFL));
		byteBuffer.writeInt(SenderCompIdOp.getValue());
		byteBuffer.writeString(SenderCompId);
		byteBuffer.writeInt(TargetCompIdOp.getValue());
		byteBuffer.writeString(TargetCompId);

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
		stringBuilder.append("TI_FIX_SESSION_STATISTIC_QUERY_PARAM::");
		stringBuilder.append("SessionIdOp(").append(SessionIdOp).append(")");
		stringBuilder.append("SessionId(").append(SessionId).append(")");
		stringBuilder.append("MemberIdOp(").append(MemberIdOp).append(")");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("TraderIdOp(").append(TraderIdOp).append(")");
		stringBuilder.append("TraderId(").append(TraderId).append(")");
		stringBuilder.append("SenderCompIdOp(").append(SenderCompIdOp).append(")");
		stringBuilder.append("SenderCompId(").append(SenderCompId).append(")");
		stringBuilder.append("TargetCompIdOp(").append(TargetCompIdOp).append(")");
		stringBuilder.append("TargetCompId(").append(TargetCompId).append(")");
		return stringBuilder.toString();
	}
}
