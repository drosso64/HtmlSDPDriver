package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_FIX_SESSION_STATUS extends SMPMessage
{
	public static final long CLASS_ID = 100839;

	private long SessionId = 0;
	private TI_FLAG_Enum EnabledFg = TI_FLAG_Enum.TI_FLAG_No;
	private long VersionSn = 0;
	private long SubmitterMemberId = 0;
	private long SubmitterTraderId = 0;
	private String SubmitterTraderName = "";
	private TI_FLAG_Enum ResetRXFg = TI_FLAG_Enum.TI_FLAG_No;
	private long ResetRXSequenceNumber = 0;
	private TI_FLAG_Enum ResetTXFg = TI_FLAG_Enum.TI_FLAG_No;
	private long ResetTXSequenceNumber = 0;
	private long EditTime = 0;
	private TI_FLAG_Enum LoggedFg = TI_FLAG_Enum.TI_FLAG_No;

	public TI_FIX_SESSION_STATUS()
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
	public TI_FLAG_Enum getEnabledFg()
	{
		return EnabledFg;
	}
	public void setEnabledFg(TI_FLAG_Enum value)
	{
		EnabledFg = value;
	}
	public long getVersionSn()
	{
		return VersionSn;
	}
	public void setVersionSn(long value)
	{
		VersionSn = value;
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
	public TI_FLAG_Enum getResetRXFg()
	{
		return ResetRXFg;
	}
	public void setResetRXFg(TI_FLAG_Enum value)
	{
		ResetRXFg = value;
	}
	public long getResetRXSequenceNumber()
	{
		return ResetRXSequenceNumber;
	}
	public void setResetRXSequenceNumber(long value)
	{
		ResetRXSequenceNumber = value;
	}
	public TI_FLAG_Enum getResetTXFg()
	{
		return ResetTXFg;
	}
	public void setResetTXFg(TI_FLAG_Enum value)
	{
		ResetTXFg = value;
	}
	public long getResetTXSequenceNumber()
	{
		return ResetTXSequenceNumber;
	}
	public void setResetTXSequenceNumber(long value)
	{
		ResetTXSequenceNumber = value;
	}
	public long getEditTime()
	{
		return EditTime;
	}
	public void setEditTime(long value)
	{
		EditTime = value;
	}
	public TI_FLAG_Enum getLoggedFg()
	{
		return LoggedFg;
	}
	public void setLoggedFg(TI_FLAG_Enum value)
	{
		LoggedFg = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		SessionId = (long)byteBuffer.readInt();
		EnabledFg = EnabledFg.getEnum(byteBuffer.readInt());
		VersionSn = (long)byteBuffer.readInt();
		SubmitterMemberId = (long)byteBuffer.readInt();
		SubmitterTraderId = (long)byteBuffer.readInt();
		SubmitterTraderName = byteBuffer.readString();
		ResetRXFg = ResetRXFg.getEnum(byteBuffer.readInt());
		ResetRXSequenceNumber = (long)byteBuffer.readInt();
		ResetTXFg = ResetTXFg.getEnum(byteBuffer.readInt());
		ResetTXSequenceNumber = (long)byteBuffer.readInt();
		EditTime = byteBuffer.readLong();
		LoggedFg = LoggedFg.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(SessionId & 0xFFFFFFFFL));
		byteBuffer.writeInt(EnabledFg.getValue());
		byteBuffer.writeInt((int)(VersionSn & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SubmitterMemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SubmitterTraderId & 0xFFFFFFFFL));
		byteBuffer.writeString(SubmitterTraderName);
		byteBuffer.writeInt(ResetRXFg.getValue());
		byteBuffer.writeInt((int)(ResetRXSequenceNumber & 0xFFFFFFFFL));
		byteBuffer.writeInt(ResetTXFg.getValue());
		byteBuffer.writeInt((int)(ResetTXSequenceNumber & 0xFFFFFFFFL));
		byteBuffer.writeLong(EditTime);
		byteBuffer.writeInt(LoggedFg.getValue());

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
		stringBuilder.append("TI_FIX_SESSION_STATUS::");
		stringBuilder.append("SessionId(").append(SessionId).append(")");
		stringBuilder.append("EnabledFg(").append(EnabledFg).append(")");
		stringBuilder.append("VersionSn(").append(VersionSn).append(")");
		stringBuilder.append("SubmitterMemberId(").append(SubmitterMemberId).append(")");
		stringBuilder.append("SubmitterTraderId(").append(SubmitterTraderId).append(")");
		stringBuilder.append("SubmitterTraderName(").append(SubmitterTraderName).append(")");
		stringBuilder.append("ResetRXFg(").append(ResetRXFg).append(")");
		stringBuilder.append("ResetRXSequenceNumber(").append(ResetRXSequenceNumber).append(")");
		stringBuilder.append("ResetTXFg(").append(ResetTXFg).append(")");
		stringBuilder.append("ResetTXSequenceNumber(").append(ResetTXSequenceNumber).append(")");
		stringBuilder.append("EditTime(").append(EditTime).append(")");
		stringBuilder.append("LoggedFg(").append(LoggedFg).append(")");
		return stringBuilder.toString();
	}
}
