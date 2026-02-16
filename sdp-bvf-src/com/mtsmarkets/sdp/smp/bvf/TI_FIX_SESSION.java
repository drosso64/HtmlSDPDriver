package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_FIX_SESSION extends SMPMessage
{
	public static final long CLASS_ID = 100837;

	private long SessionId = 0;
	private TI_FIX_SESSION_TYPE_Enum SessionType = TI_FIX_SESSION_TYPE_Enum.TI_FIX_SESSION_TYPE_Dealer;
	private String SessionName = "";
	private TI_FIX_EVENT_Enum Event = TI_FIX_EVENT_Enum.TI_FIX_EVENT_Activate;
	private TI_FIX_STATUS_Enum Status = TI_FIX_STATUS_Enum.TI_FIX_STATUS_Activated;
	private long MemberId = 0;
	private long TraderId = 0;
	private TI_FLAG_Enum OptionalPasswordFg = TI_FLAG_Enum.TI_FLAG_No;
	private String SenderCompId = "";
	private String TargetCompId = "";
	private long EnableTime = 0;
	private long DisableTime = 0;
	private TI_FLAG_Enum HeartbeatLog = TI_FLAG_Enum.TI_FLAG_No;
	private short MsgLogLevelFix = 0;
	private short BufferLogLevelFix = 0;
	private short MsgLogLevelSdp = 0;
	private short BufferLogLevelSdp = 0;
	private String MsgLogProfileSdp = "";
	private long SubmitterMemberId = 0;
	private long SubmitterTraderId = 0;
	private String SubmitterTraderName = "";
	private long CreationDate = 0;
	private long CreationTime = 0;
	private long UpdateDate = 0;
	private long UpdateTime = 0;

	public TI_FIX_SESSION()
	{
	}

	public long getSessionId()
	{
		return SessionId;
	}
	public void setSessionId(long value)
	{
		SessionId = value;
	}
	public TI_FIX_SESSION_TYPE_Enum getSessionType()
	{
		return SessionType;
	}
	public void setSessionType(TI_FIX_SESSION_TYPE_Enum value)
	{
		SessionType = value;
	}
	public String getSessionName()
	{
		return SessionName;
	}
	public void setSessionName(String value)
	{
		SessionName = value;
	}
	public TI_FIX_EVENT_Enum getEvent()
	{
		return Event;
	}
	public void setEvent(TI_FIX_EVENT_Enum value)
	{
		Event = value;
	}
	public TI_FIX_STATUS_Enum getStatus()
	{
		return Status;
	}
	public void setStatus(TI_FIX_STATUS_Enum value)
	{
		Status = value;
	}
	public long getMemberId()
	{
		return MemberId;
	}
	public void setMemberId(long value)
	{
		MemberId = value;
	}
	public long getTraderId()
	{
		return TraderId;
	}
	public void setTraderId(long value)
	{
		TraderId = value;
	}
	public TI_FLAG_Enum getOptionalPasswordFg()
	{
		return OptionalPasswordFg;
	}
	public void setOptionalPasswordFg(TI_FLAG_Enum value)
	{
		OptionalPasswordFg = value;
	}
	public String getSenderCompId()
	{
		return SenderCompId;
	}
	public void setSenderCompId(String value)
	{
		SenderCompId = value;
	}
	public String getTargetCompId()
	{
		return TargetCompId;
	}
	public void setTargetCompId(String value)
	{
		TargetCompId = value;
	}
	public long getEnableTime()
	{
		return EnableTime;
	}
	public void setEnableTime(long value)
	{
		EnableTime = value;
	}
	public long getDisableTime()
	{
		return DisableTime;
	}
	public void setDisableTime(long value)
	{
		DisableTime = value;
	}
	public TI_FLAG_Enum getHeartbeatLog()
	{
		return HeartbeatLog;
	}
	public void setHeartbeatLog(TI_FLAG_Enum value)
	{
		HeartbeatLog = value;
	}
	public short getMsgLogLevelFix()
	{
		return MsgLogLevelFix;
	}
	public void setMsgLogLevelFix(short value)
	{
		MsgLogLevelFix = value;
	}
	public short getBufferLogLevelFix()
	{
		return BufferLogLevelFix;
	}
	public void setBufferLogLevelFix(short value)
	{
		BufferLogLevelFix = value;
	}
	public short getMsgLogLevelSdp()
	{
		return MsgLogLevelSdp;
	}
	public void setMsgLogLevelSdp(short value)
	{
		MsgLogLevelSdp = value;
	}
	public short getBufferLogLevelSdp()
	{
		return BufferLogLevelSdp;
	}
	public void setBufferLogLevelSdp(short value)
	{
		BufferLogLevelSdp = value;
	}
	public String getMsgLogProfileSdp()
	{
		return MsgLogProfileSdp;
	}
	public void setMsgLogProfileSdp(String value)
	{
		MsgLogProfileSdp = value;
	}
	public long getSubmitterMemberId()
	{
		return SubmitterMemberId;
	}
	public void setSubmitterMemberId(long value)
	{
		SubmitterMemberId = value;
	}
	public long getSubmitterTraderId()
	{
		return SubmitterTraderId;
	}
	public void setSubmitterTraderId(long value)
	{
		SubmitterTraderId = value;
	}
	public String getSubmitterTraderName()
	{
		return SubmitterTraderName;
	}
	public void setSubmitterTraderName(String value)
	{
		SubmitterTraderName = value;
	}
	public long getCreationDate()
	{
		return CreationDate;
	}
	public void setCreationDate(long value)
	{
		CreationDate = value;
	}
	public long getCreationTime()
	{
		return CreationTime;
	}
	public void setCreationTime(long value)
	{
		CreationTime = value;
	}
	public long getUpdateDate()
	{
		return UpdateDate;
	}
	public void setUpdateDate(long value)
	{
		UpdateDate = value;
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
		SessionId = (long)byteBuffer.readInt();
		SessionType = SessionType.getEnum(byteBuffer.readInt());
		SessionName = byteBuffer.readString();
		Event = Event.getEnum(byteBuffer.readInt());
		Status = Status.getEnum(byteBuffer.readInt());
		MemberId = (long)byteBuffer.readInt();
		TraderId = (long)byteBuffer.readInt();
		OptionalPasswordFg = OptionalPasswordFg.getEnum(byteBuffer.readInt());
		SenderCompId = byteBuffer.readString();
		TargetCompId = byteBuffer.readString();
		EnableTime = byteBuffer.readLong();
		DisableTime = byteBuffer.readLong();
		HeartbeatLog = HeartbeatLog.getEnum(byteBuffer.readInt());
		MsgLogLevelFix = (short)byteBuffer.readInt();
		BufferLogLevelFix = (short)byteBuffer.readInt();
		MsgLogLevelSdp = (short)byteBuffer.readInt();
		BufferLogLevelSdp = (short)byteBuffer.readInt();
		MsgLogProfileSdp = byteBuffer.readString();
		SubmitterMemberId = (long)byteBuffer.readInt();
		SubmitterTraderId = (long)byteBuffer.readInt();
		SubmitterTraderName = byteBuffer.readString();
		CreationDate = (long)byteBuffer.readInt();
		CreationTime = byteBuffer.readLong();
		UpdateDate = (long)byteBuffer.readInt();
		UpdateTime = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(SessionId & 0xFFFFFFFFL));
		byteBuffer.writeInt(SessionType.getValue());
		byteBuffer.writeString(SessionName);
		byteBuffer.writeInt(Event.getValue());
		byteBuffer.writeInt(Status.getValue());
		byteBuffer.writeInt((int)(MemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(TraderId & 0xFFFFFFFFL));
		byteBuffer.writeInt(OptionalPasswordFg.getValue());
		byteBuffer.writeString(SenderCompId);
		byteBuffer.writeString(TargetCompId);
		byteBuffer.writeLong(EnableTime);
		byteBuffer.writeLong(DisableTime);
		byteBuffer.writeInt(HeartbeatLog.getValue());
		byteBuffer.writeInt((int)(MsgLogLevelFix & 0xFFFFL));
		byteBuffer.writeInt((int)(BufferLogLevelFix & 0xFFFFL));
		byteBuffer.writeInt((int)(MsgLogLevelSdp & 0xFFFFL));
		byteBuffer.writeInt((int)(BufferLogLevelSdp & 0xFFFFL));
		byteBuffer.writeString(MsgLogProfileSdp);
		byteBuffer.writeInt((int)(SubmitterMemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SubmitterTraderId & 0xFFFFFFFFL));
		byteBuffer.writeString(SubmitterTraderName);
		byteBuffer.writeInt((int)(CreationDate & 0xFFFFFFFFL));
		byteBuffer.writeLong(CreationTime);
		byteBuffer.writeInt((int)(UpdateDate & 0xFFFFFFFFL));
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
		stringBuilder.append("TI_FIX_SESSION::");
		stringBuilder.append("SessionId(").append(SessionId).append(")");
		stringBuilder.append("SessionType(").append(SessionType).append(")");
		stringBuilder.append("SessionName(").append(SessionName).append(")");
		stringBuilder.append("Event(").append(Event).append(")");
		stringBuilder.append("Status(").append(Status).append(")");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("TraderId(").append(TraderId).append(")");
		stringBuilder.append("OptionalPasswordFg(").append(OptionalPasswordFg).append(")");
		stringBuilder.append("SenderCompId(").append(SenderCompId).append(")");
		stringBuilder.append("TargetCompId(").append(TargetCompId).append(")");
		stringBuilder.append("EnableTime(").append(EnableTime).append(")");
		stringBuilder.append("DisableTime(").append(DisableTime).append(")");
		stringBuilder.append("HeartbeatLog(").append(HeartbeatLog).append(")");
		stringBuilder.append("MsgLogLevelFix(").append(MsgLogLevelFix).append(")");
		stringBuilder.append("BufferLogLevelFix(").append(BufferLogLevelFix).append(")");
		stringBuilder.append("MsgLogLevelSdp(").append(MsgLogLevelSdp).append(")");
		stringBuilder.append("BufferLogLevelSdp(").append(BufferLogLevelSdp).append(")");
		stringBuilder.append("MsgLogProfileSdp(").append(MsgLogProfileSdp).append(")");
		stringBuilder.append("SubmitterMemberId(").append(SubmitterMemberId).append(")");
		stringBuilder.append("SubmitterTraderId(").append(SubmitterTraderId).append(")");
		stringBuilder.append("SubmitterTraderName(").append(SubmitterTraderName).append(")");
		stringBuilder.append("CreationDate(").append(CreationDate).append(")");
		stringBuilder.append("CreationTime(").append(CreationTime).append(")");
		stringBuilder.append("UpdateDate(").append(UpdateDate).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		return stringBuilder.toString();
	}
}
