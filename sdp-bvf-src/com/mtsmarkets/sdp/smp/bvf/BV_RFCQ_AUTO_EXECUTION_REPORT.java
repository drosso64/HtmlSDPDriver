package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_RFCQ_AUTO_EXECUTION_REPORT extends SMPMessage
{
	public static final long CLASS_ID = 114111;

	private long RuleId = 0;
	private long MemberId = 0;
	private long StageOrderId = 0;
	private long ExecutionId = 0;
	private TI_FLAG_Enum ManuallyExecutedFg = TI_FLAG_Enum.TI_FLAG_No;
	private TI_FLAG_Enum ManualOverrideClosingFg = TI_FLAG_Enum.TI_FLAG_No;
	private TI_FLAG_Enum LastAttemptFg = TI_FLAG_Enum.TI_FLAG_No;
	private BV_RFCQ_AUTO_EXECUTION_REPORT_STATUS_Enum Status = BV_RFCQ_AUTO_EXECUTION_REPORT_STATUS_Enum.BV_RFCQ_AUTO_EXECUTION_REPORT_STATUS_Done;
	private BV_RFCQ_AUTO_EXECUTION_REPORT_REASON_Enum Reason = BV_RFCQ_AUTO_EXECUTION_REPORT_REASON_Enum.BV_RFCQ_AUTO_EXECUTION_REPORT_REASON_None;
	private BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_Enum SubReason = BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_Enum.BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_None;
	private long CreationDate = 0;
	private long CreationTime = 0;
	private long UpdateTime = 0;

	public BV_RFCQ_AUTO_EXECUTION_REPORT()
	{
	}

	public long getRuleId()
	{
		return RuleId;
	}
	public void setRuleId(long value)
	{
		RuleId = value;
	}
	public long getMemberId()
	{
		return MemberId;
	}
	public void setMemberId(long value)
	{
		MemberId = value;
	}
	public long getStageOrderId()
	{
		return StageOrderId;
	}
	public void setStageOrderId(long value)
	{
		StageOrderId = value;
	}
	public long getExecutionId()
	{
		return ExecutionId;
	}
	public void setExecutionId(long value)
	{
		ExecutionId = value;
	}
	public TI_FLAG_Enum getManuallyExecutedFg()
	{
		return ManuallyExecutedFg;
	}
	public void setManuallyExecutedFg(TI_FLAG_Enum value)
	{
		ManuallyExecutedFg = value;
	}
	public TI_FLAG_Enum getManualOverrideClosingFg()
	{
		return ManualOverrideClosingFg;
	}
	public void setManualOverrideClosingFg(TI_FLAG_Enum value)
	{
		ManualOverrideClosingFg = value;
	}
	public TI_FLAG_Enum getLastAttemptFg()
	{
		return LastAttemptFg;
	}
	public void setLastAttemptFg(TI_FLAG_Enum value)
	{
		LastAttemptFg = value;
	}
	public BV_RFCQ_AUTO_EXECUTION_REPORT_STATUS_Enum getStatus()
	{
		return Status;
	}
	public void setStatus(BV_RFCQ_AUTO_EXECUTION_REPORT_STATUS_Enum value)
	{
		Status = value;
	}
	public BV_RFCQ_AUTO_EXECUTION_REPORT_REASON_Enum getReason()
	{
		return Reason;
	}
	public void setReason(BV_RFCQ_AUTO_EXECUTION_REPORT_REASON_Enum value)
	{
		Reason = value;
	}
	public BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_Enum getSubReason()
	{
		return SubReason;
	}
	public void setSubReason(BV_RFCQ_AUTO_EXECUTION_REPORT_SUBREASON_Enum value)
	{
		SubReason = value;
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
		RuleId = (long)byteBuffer.readInt();
		MemberId = (long)byteBuffer.readInt();
		StageOrderId = (long)byteBuffer.readInt();
		ExecutionId = (long)byteBuffer.readInt();
		ManuallyExecutedFg = ManuallyExecutedFg.getEnum(byteBuffer.readInt());
		ManualOverrideClosingFg = ManualOverrideClosingFg.getEnum(byteBuffer.readInt());
		LastAttemptFg = LastAttemptFg.getEnum(byteBuffer.readInt());
		Status = Status.getEnum(byteBuffer.readInt());
		Reason = Reason.getEnum(byteBuffer.readInt());
		SubReason = SubReason.getEnum(byteBuffer.readInt());
		CreationDate = (long)byteBuffer.readInt();
		CreationTime = byteBuffer.readLong();
		UpdateTime = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(RuleId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(MemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(StageOrderId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(ExecutionId & 0xFFFFFFFFL));
		byteBuffer.writeInt(ManuallyExecutedFg.getValue());
		byteBuffer.writeInt(ManualOverrideClosingFg.getValue());
		byteBuffer.writeInt(LastAttemptFg.getValue());
		byteBuffer.writeInt(Status.getValue());
		byteBuffer.writeInt(Reason.getValue());
		byteBuffer.writeInt(SubReason.getValue());
		byteBuffer.writeInt((int)(CreationDate & 0xFFFFFFFFL));
		byteBuffer.writeLong(CreationTime);
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
		stringBuilder.append("BV_RFCQ_AUTO_EXECUTION_REPORT::");
		stringBuilder.append("RuleId(").append(RuleId).append(")");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("StageOrderId(").append(StageOrderId).append(")");
		stringBuilder.append("ExecutionId(").append(ExecutionId).append(")");
		stringBuilder.append("ManuallyExecutedFg(").append(ManuallyExecutedFg).append(")");
		stringBuilder.append("ManualOverrideClosingFg(").append(ManualOverrideClosingFg).append(")");
		stringBuilder.append("LastAttemptFg(").append(LastAttemptFg).append(")");
		stringBuilder.append("Status(").append(Status).append(")");
		stringBuilder.append("Reason(").append(Reason).append(")");
		stringBuilder.append("SubReason(").append(SubReason).append(")");
		stringBuilder.append("CreationDate(").append(CreationDate).append(")");
		stringBuilder.append("CreationTime(").append(CreationTime).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		return stringBuilder.toString();
	}
}
