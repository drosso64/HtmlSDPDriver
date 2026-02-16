package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class DF_BV_IOI_QUERY_PARAM extends SMPMessage
{
	public static final long CLASS_ID = 170041;

	private TI_QUERY_OP_Enum MsgIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long MsgId = 0;
	private TI_QUERY_OP_Enum MsgDateFromOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long MsgDateFrom = 0;
	private TI_QUERY_OP_Enum MsgDateToOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long MsgDateTo = 0;
	private TI_QUERY_OP_Enum MsgTimeFromOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long MsgTimeFrom = 0;
	private TI_QUERY_OP_Enum MsgTimeToOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long MsgTimeTo = 0;
	private TI_QUERY_OP_Enum InstrumentIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long InstrumentId = 0;
	private TI_QUERY_OP_Enum SubmitterIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long SubmitterId = 0;
	private TI_QUERY_OP_Enum MemberIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long MemberId = 0;
	private TI_QUERY_OP_Enum TraderIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long TraderId = 0;
	private TI_QUERY_OP_Enum GroupIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long GroupId = 0;

	public DF_BV_IOI_QUERY_PARAM()
	{
	}

	public TI_QUERY_OP_Enum getMsgIdOp()
	{
		return MsgIdOp;
	}
	public void setMsgIdOp(TI_QUERY_OP_Enum value)
	{
		MsgIdOp = value;
	}
	public long getMsgId()
	{
		return MsgId;
	}
	public void setMsgId(long value)
	{
		MsgId = value;
	}
	public TI_QUERY_OP_Enum getMsgDateFromOp()
	{
		return MsgDateFromOp;
	}
	public void setMsgDateFromOp(TI_QUERY_OP_Enum value)
	{
		MsgDateFromOp = value;
	}
	public long getMsgDateFrom()
	{
		return MsgDateFrom;
	}
	public void setMsgDateFrom(long value)
	{
		MsgDateFrom = value;
	}
	public TI_QUERY_OP_Enum getMsgDateToOp()
	{
		return MsgDateToOp;
	}
	public void setMsgDateToOp(TI_QUERY_OP_Enum value)
	{
		MsgDateToOp = value;
	}
	public long getMsgDateTo()
	{
		return MsgDateTo;
	}
	public void setMsgDateTo(long value)
	{
		MsgDateTo = value;
	}
	public TI_QUERY_OP_Enum getMsgTimeFromOp()
	{
		return MsgTimeFromOp;
	}
	public void setMsgTimeFromOp(TI_QUERY_OP_Enum value)
	{
		MsgTimeFromOp = value;
	}
	public long getMsgTimeFrom()
	{
		return MsgTimeFrom;
	}
	public void setMsgTimeFrom(long value)
	{
		MsgTimeFrom = value;
	}
	public TI_QUERY_OP_Enum getMsgTimeToOp()
	{
		return MsgTimeToOp;
	}
	public void setMsgTimeToOp(TI_QUERY_OP_Enum value)
	{
		MsgTimeToOp = value;
	}
	public long getMsgTimeTo()
	{
		return MsgTimeTo;
	}
	public void setMsgTimeTo(long value)
	{
		MsgTimeTo = value;
	}
	public TI_QUERY_OP_Enum getInstrumentIdOp()
	{
		return InstrumentIdOp;
	}
	public void setInstrumentIdOp(TI_QUERY_OP_Enum value)
	{
		InstrumentIdOp = value;
	}
	public long getInstrumentId()
	{
		return InstrumentId;
	}
	public void setInstrumentId(long value)
	{
		InstrumentId = value;
	}
	public TI_QUERY_OP_Enum getSubmitterIdOp()
	{
		return SubmitterIdOp;
	}
	public void setSubmitterIdOp(TI_QUERY_OP_Enum value)
	{
		SubmitterIdOp = value;
	}
	public long getSubmitterId()
	{
		return SubmitterId;
	}
	public void setSubmitterId(long value)
	{
		SubmitterId = value;
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
	public TI_QUERY_OP_Enum getGroupIdOp()
	{
		return GroupIdOp;
	}
	public void setGroupIdOp(TI_QUERY_OP_Enum value)
	{
		GroupIdOp = value;
	}
	public long getGroupId()
	{
		return GroupId;
	}
	public void setGroupId(long value)
	{
		GroupId = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MsgIdOp = MsgIdOp.getEnum(byteBuffer.readInt());
		MsgId = (long)byteBuffer.readInt();
		MsgDateFromOp = MsgDateFromOp.getEnum(byteBuffer.readInt());
		MsgDateFrom = (long)byteBuffer.readInt();
		MsgDateToOp = MsgDateToOp.getEnum(byteBuffer.readInt());
		MsgDateTo = (long)byteBuffer.readInt();
		MsgTimeFromOp = MsgTimeFromOp.getEnum(byteBuffer.readInt());
		MsgTimeFrom = byteBuffer.readLong();
		MsgTimeToOp = MsgTimeToOp.getEnum(byteBuffer.readInt());
		MsgTimeTo = byteBuffer.readLong();
		InstrumentIdOp = InstrumentIdOp.getEnum(byteBuffer.readInt());
		InstrumentId = (long)byteBuffer.readInt();
		SubmitterIdOp = SubmitterIdOp.getEnum(byteBuffer.readInt());
		SubmitterId = (long)byteBuffer.readInt();
		MemberIdOp = MemberIdOp.getEnum(byteBuffer.readInt());
		MemberId = (long)byteBuffer.readInt();
		TraderIdOp = TraderIdOp.getEnum(byteBuffer.readInt());
		TraderId = (long)byteBuffer.readInt();
		GroupIdOp = GroupIdOp.getEnum(byteBuffer.readInt());
		GroupId = (long)byteBuffer.readInt();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt(MsgIdOp.getValue());
		byteBuffer.writeInt((int)(MsgId & 0xFFFFFFFFL));
		byteBuffer.writeInt(MsgDateFromOp.getValue());
		byteBuffer.writeInt((int)(MsgDateFrom & 0xFFFFFFFFL));
		byteBuffer.writeInt(MsgDateToOp.getValue());
		byteBuffer.writeInt((int)(MsgDateTo & 0xFFFFFFFFL));
		byteBuffer.writeInt(MsgTimeFromOp.getValue());
		byteBuffer.writeLong(MsgTimeFrom);
		byteBuffer.writeInt(MsgTimeToOp.getValue());
		byteBuffer.writeLong(MsgTimeTo);
		byteBuffer.writeInt(InstrumentIdOp.getValue());
		byteBuffer.writeInt((int)(InstrumentId & 0xFFFFFFFFL));
		byteBuffer.writeInt(SubmitterIdOp.getValue());
		byteBuffer.writeInt((int)(SubmitterId & 0xFFFFFFFFL));
		byteBuffer.writeInt(MemberIdOp.getValue());
		byteBuffer.writeInt((int)(MemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt(TraderIdOp.getValue());
		byteBuffer.writeInt((int)(TraderId & 0xFFFFFFFFL));
		byteBuffer.writeInt(GroupIdOp.getValue());
		byteBuffer.writeInt((int)(GroupId & 0xFFFFFFFFL));

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
		stringBuilder.append("DF_BV_IOI_QUERY_PARAM::");
		stringBuilder.append("MsgIdOp(").append(MsgIdOp).append(")");
		stringBuilder.append("MsgId(").append(MsgId).append(")");
		stringBuilder.append("MsgDateFromOp(").append(MsgDateFromOp).append(")");
		stringBuilder.append("MsgDateFrom(").append(MsgDateFrom).append(")");
		stringBuilder.append("MsgDateToOp(").append(MsgDateToOp).append(")");
		stringBuilder.append("MsgDateTo(").append(MsgDateTo).append(")");
		stringBuilder.append("MsgTimeFromOp(").append(MsgTimeFromOp).append(")");
		stringBuilder.append("MsgTimeFrom(").append(MsgTimeFrom).append(")");
		stringBuilder.append("MsgTimeToOp(").append(MsgTimeToOp).append(")");
		stringBuilder.append("MsgTimeTo(").append(MsgTimeTo).append(")");
		stringBuilder.append("InstrumentIdOp(").append(InstrumentIdOp).append(")");
		stringBuilder.append("InstrumentId(").append(InstrumentId).append(")");
		stringBuilder.append("SubmitterIdOp(").append(SubmitterIdOp).append(")");
		stringBuilder.append("SubmitterId(").append(SubmitterId).append(")");
		stringBuilder.append("MemberIdOp(").append(MemberIdOp).append(")");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("TraderIdOp(").append(TraderIdOp).append(")");
		stringBuilder.append("TraderId(").append(TraderId).append(")");
		stringBuilder.append("GroupIdOp(").append(GroupIdOp).append(")");
		stringBuilder.append("GroupId(").append(GroupId).append(")");
		return stringBuilder.toString();
	}
}
