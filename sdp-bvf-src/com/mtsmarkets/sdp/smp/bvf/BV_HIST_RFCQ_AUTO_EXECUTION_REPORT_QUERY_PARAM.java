package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_HIST_RFCQ_AUTO_EXECUTION_REPORT_QUERY_PARAM extends SMPMessage
{
	public static final long CLASS_ID = 214215;

	private TI_QUERY_OP_Enum StageOrderIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long StageOrderId = 0;
	private TI_QUERY_OP_Enum ManuallyExecutedFgOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private TI_FLAG_Enum ManuallyExecutedFg = TI_FLAG_Enum.TI_FLAG_No;
	private TI_QUERY_OP_Enum AutoExecutionIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long AutoExecutionId = 0;
	private TI_QUERY_OP_Enum StatusOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private BV_RFCQ_AUTO_EXECUTION_REPORT_STATUS_Enum Status = BV_RFCQ_AUTO_EXECUTION_REPORT_STATUS_Enum.BV_RFCQ_AUTO_EXECUTION_REPORT_STATUS_Done;
	private TI_QUERY_OP_Enum CreationDateFromOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long CreationDateFrom = 0;
	private TI_QUERY_OP_Enum CreationDateToOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long CreationDateTo = 0;
	private TI_QUERY_OP_Enum CreationTimeFromOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long CreationTimeFrom = 0;
	private TI_QUERY_OP_Enum CreationTimeToOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long CreationTimeTo = 0;

	public BV_HIST_RFCQ_AUTO_EXECUTION_REPORT_QUERY_PARAM()
	{
	}

	public TI_QUERY_OP_Enum getStageOrderIdOp()
	{
		return StageOrderIdOp;
	}
	public void setStageOrderIdOp(TI_QUERY_OP_Enum value)
	{
		StageOrderIdOp = value;
	}
	public long getStageOrderId()
	{
		return StageOrderId;
	}
	public void setStageOrderId(long value)
	{
		StageOrderId = value;
	}
	public TI_QUERY_OP_Enum getManuallyExecutedFgOp()
	{
		return ManuallyExecutedFgOp;
	}
	public void setManuallyExecutedFgOp(TI_QUERY_OP_Enum value)
	{
		ManuallyExecutedFgOp = value;
	}
	public TI_FLAG_Enum getManuallyExecutedFg()
	{
		return ManuallyExecutedFg;
	}
	public void setManuallyExecutedFg(TI_FLAG_Enum value)
	{
		ManuallyExecutedFg = value;
	}
	public TI_QUERY_OP_Enum getAutoExecutionIdOp()
	{
		return AutoExecutionIdOp;
	}
	public void setAutoExecutionIdOp(TI_QUERY_OP_Enum value)
	{
		AutoExecutionIdOp = value;
	}
	public long getAutoExecutionId()
	{
		return AutoExecutionId;
	}
	public void setAutoExecutionId(long value)
	{
		AutoExecutionId = value;
	}
	public TI_QUERY_OP_Enum getStatusOp()
	{
		return StatusOp;
	}
	public void setStatusOp(TI_QUERY_OP_Enum value)
	{
		StatusOp = value;
	}
	public BV_RFCQ_AUTO_EXECUTION_REPORT_STATUS_Enum getStatus()
	{
		return Status;
	}
	public void setStatus(BV_RFCQ_AUTO_EXECUTION_REPORT_STATUS_Enum value)
	{
		Status = value;
	}
	public TI_QUERY_OP_Enum getCreationDateFromOp()
	{
		return CreationDateFromOp;
	}
	public void setCreationDateFromOp(TI_QUERY_OP_Enum value)
	{
		CreationDateFromOp = value;
	}
	public long getCreationDateFrom()
	{
		return CreationDateFrom;
	}
	public void setCreationDateFrom(long value)
	{
		CreationDateFrom = value;
	}
	public TI_QUERY_OP_Enum getCreationDateToOp()
	{
		return CreationDateToOp;
	}
	public void setCreationDateToOp(TI_QUERY_OP_Enum value)
	{
		CreationDateToOp = value;
	}
	public long getCreationDateTo()
	{
		return CreationDateTo;
	}
	public void setCreationDateTo(long value)
	{
		CreationDateTo = value;
	}
	public TI_QUERY_OP_Enum getCreationTimeFromOp()
	{
		return CreationTimeFromOp;
	}
	public void setCreationTimeFromOp(TI_QUERY_OP_Enum value)
	{
		CreationTimeFromOp = value;
	}
	public long getCreationTimeFrom()
	{
		return CreationTimeFrom;
	}
	public void setCreationTimeFrom(long value)
	{
		CreationTimeFrom = value;
	}
	public TI_QUERY_OP_Enum getCreationTimeToOp()
	{
		return CreationTimeToOp;
	}
	public void setCreationTimeToOp(TI_QUERY_OP_Enum value)
	{
		CreationTimeToOp = value;
	}
	public long getCreationTimeTo()
	{
		return CreationTimeTo;
	}
	public void setCreationTimeTo(long value)
	{
		CreationTimeTo = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		StageOrderIdOp = StageOrderIdOp.getEnum(byteBuffer.readInt());
		StageOrderId = (long)byteBuffer.readInt();
		ManuallyExecutedFgOp = ManuallyExecutedFgOp.getEnum(byteBuffer.readInt());
		ManuallyExecutedFg = ManuallyExecutedFg.getEnum(byteBuffer.readInt());
		AutoExecutionIdOp = AutoExecutionIdOp.getEnum(byteBuffer.readInt());
		AutoExecutionId = (long)byteBuffer.readInt();
		StatusOp = StatusOp.getEnum(byteBuffer.readInt());
		Status = Status.getEnum(byteBuffer.readInt());
		CreationDateFromOp = CreationDateFromOp.getEnum(byteBuffer.readInt());
		CreationDateFrom = (long)byteBuffer.readInt();
		CreationDateToOp = CreationDateToOp.getEnum(byteBuffer.readInt());
		CreationDateTo = (long)byteBuffer.readInt();
		CreationTimeFromOp = CreationTimeFromOp.getEnum(byteBuffer.readInt());
		CreationTimeFrom = byteBuffer.readLong();
		CreationTimeToOp = CreationTimeToOp.getEnum(byteBuffer.readInt());
		CreationTimeTo = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt(StageOrderIdOp.getValue());
		byteBuffer.writeInt((int)(StageOrderId & 0xFFFFFFFFL));
		byteBuffer.writeInt(ManuallyExecutedFgOp.getValue());
		byteBuffer.writeInt(ManuallyExecutedFg.getValue());
		byteBuffer.writeInt(AutoExecutionIdOp.getValue());
		byteBuffer.writeInt((int)(AutoExecutionId & 0xFFFFFFFFL));
		byteBuffer.writeInt(StatusOp.getValue());
		byteBuffer.writeInt(Status.getValue());
		byteBuffer.writeInt(CreationDateFromOp.getValue());
		byteBuffer.writeInt((int)(CreationDateFrom & 0xFFFFFFFFL));
		byteBuffer.writeInt(CreationDateToOp.getValue());
		byteBuffer.writeInt((int)(CreationDateTo & 0xFFFFFFFFL));
		byteBuffer.writeInt(CreationTimeFromOp.getValue());
		byteBuffer.writeLong(CreationTimeFrom);
		byteBuffer.writeInt(CreationTimeToOp.getValue());
		byteBuffer.writeLong(CreationTimeTo);

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
		stringBuilder.append("BV_HIST_RFCQ_AUTO_EXECUTION_REPORT_QUERY_PARAM::");
		stringBuilder.append("StageOrderIdOp(").append(StageOrderIdOp).append(")");
		stringBuilder.append("StageOrderId(").append(StageOrderId).append(")");
		stringBuilder.append("ManuallyExecutedFgOp(").append(ManuallyExecutedFgOp).append(")");
		stringBuilder.append("ManuallyExecutedFg(").append(ManuallyExecutedFg).append(")");
		stringBuilder.append("AutoExecutionIdOp(").append(AutoExecutionIdOp).append(")");
		stringBuilder.append("AutoExecutionId(").append(AutoExecutionId).append(")");
		stringBuilder.append("StatusOp(").append(StatusOp).append(")");
		stringBuilder.append("Status(").append(Status).append(")");
		stringBuilder.append("CreationDateFromOp(").append(CreationDateFromOp).append(")");
		stringBuilder.append("CreationDateFrom(").append(CreationDateFrom).append(")");
		stringBuilder.append("CreationDateToOp(").append(CreationDateToOp).append(")");
		stringBuilder.append("CreationDateTo(").append(CreationDateTo).append(")");
		stringBuilder.append("CreationTimeFromOp(").append(CreationTimeFromOp).append(")");
		stringBuilder.append("CreationTimeFrom(").append(CreationTimeFrom).append(")");
		stringBuilder.append("CreationTimeToOp(").append(CreationTimeToOp).append(")");
		stringBuilder.append("CreationTimeTo(").append(CreationTimeTo).append(")");
		return stringBuilder.toString();
	}
}
