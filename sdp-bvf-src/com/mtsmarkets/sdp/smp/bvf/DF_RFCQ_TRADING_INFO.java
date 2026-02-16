package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class DF_RFCQ_TRADING_INFO extends SMPMessage
{
	public static final long CLASS_ID = 107907;

	private long ActiveDeals = 0;
	private long CancDeals = 0;
	private long NewInventoryQuote = 0;
	private long EditInventoryQuote = 0;
	private long DelIventoryQuote = 0;
	private long NewRFCQ = 0;
	private long AcceptedRFCQ = 0;
	private long RefusedRFCQ = 0;
	private long RejectedRFCQ = 0;
	private long ClosedRFCQ = 0;
	private long ClosedByGovRFCQ = 0;
	private long DeletedByGovRFCQ = 0;
	private long NewRFCQQuote = 0;
	private long EditRFCQQuote = 0;
	private long DelRFCQQuote = 0;
	private long NewRFCQOrder = 0;
	private long FilledRFCQOrder = 0;
	private long RefusedRFCQOrder = 0;
	private long DeletedRFCQOrder = 0;
	private long NewStageOrder = 0;
	private long FilledStageOrder = 0;
	private long DoneForDayStageOrder = 0;
	private long CanceledStageOrder = 0;
	private long CanceledByGovStageOrder = 0;
	private long NewInventoryOrder = 0;
	private long FilledInventoryOrder = 0;
	private long RefusedInventoryOrder = 0;
	private long TimeoutInventoryOrder = 0;
	private long DeletedByGovInventoryOrder = 0;
	private long ZeroFilledInventoryOrder = 0;

	public DF_RFCQ_TRADING_INFO()
	{
	}

	public long getActiveDeals()
	{
		return ActiveDeals;
	}
	public void setActiveDeals(long value)
	{
		ActiveDeals = value;
	}
	public long getCancDeals()
	{
		return CancDeals;
	}
	public void setCancDeals(long value)
	{
		CancDeals = value;
	}
	public long getNewInventoryQuote()
	{
		return NewInventoryQuote;
	}
	public void setNewInventoryQuote(long value)
	{
		NewInventoryQuote = value;
	}
	public long getEditInventoryQuote()
	{
		return EditInventoryQuote;
	}
	public void setEditInventoryQuote(long value)
	{
		EditInventoryQuote = value;
	}
	public long getDelIventoryQuote()
	{
		return DelIventoryQuote;
	}
	public void setDelIventoryQuote(long value)
	{
		DelIventoryQuote = value;
	}
	public long getNewRFCQ()
	{
		return NewRFCQ;
	}
	public void setNewRFCQ(long value)
	{
		NewRFCQ = value;
	}
	public long getAcceptedRFCQ()
	{
		return AcceptedRFCQ;
	}
	public void setAcceptedRFCQ(long value)
	{
		AcceptedRFCQ = value;
	}
	public long getRefusedRFCQ()
	{
		return RefusedRFCQ;
	}
	public void setRefusedRFCQ(long value)
	{
		RefusedRFCQ = value;
	}
	public long getRejectedRFCQ()
	{
		return RejectedRFCQ;
	}
	public void setRejectedRFCQ(long value)
	{
		RejectedRFCQ = value;
	}
	public long getClosedRFCQ()
	{
		return ClosedRFCQ;
	}
	public void setClosedRFCQ(long value)
	{
		ClosedRFCQ = value;
	}
	public long getClosedByGovRFCQ()
	{
		return ClosedByGovRFCQ;
	}
	public void setClosedByGovRFCQ(long value)
	{
		ClosedByGovRFCQ = value;
	}
	public long getDeletedByGovRFCQ()
	{
		return DeletedByGovRFCQ;
	}
	public void setDeletedByGovRFCQ(long value)
	{
		DeletedByGovRFCQ = value;
	}
	public long getNewRFCQQuote()
	{
		return NewRFCQQuote;
	}
	public void setNewRFCQQuote(long value)
	{
		NewRFCQQuote = value;
	}
	public long getEditRFCQQuote()
	{
		return EditRFCQQuote;
	}
	public void setEditRFCQQuote(long value)
	{
		EditRFCQQuote = value;
	}
	public long getDelRFCQQuote()
	{
		return DelRFCQQuote;
	}
	public void setDelRFCQQuote(long value)
	{
		DelRFCQQuote = value;
	}
	public long getNewRFCQOrder()
	{
		return NewRFCQOrder;
	}
	public void setNewRFCQOrder(long value)
	{
		NewRFCQOrder = value;
	}
	public long getFilledRFCQOrder()
	{
		return FilledRFCQOrder;
	}
	public void setFilledRFCQOrder(long value)
	{
		FilledRFCQOrder = value;
	}
	public long getRefusedRFCQOrder()
	{
		return RefusedRFCQOrder;
	}
	public void setRefusedRFCQOrder(long value)
	{
		RefusedRFCQOrder = value;
	}
	public long getDeletedRFCQOrder()
	{
		return DeletedRFCQOrder;
	}
	public void setDeletedRFCQOrder(long value)
	{
		DeletedRFCQOrder = value;
	}
	public long getNewStageOrder()
	{
		return NewStageOrder;
	}
	public void setNewStageOrder(long value)
	{
		NewStageOrder = value;
	}
	public long getFilledStageOrder()
	{
		return FilledStageOrder;
	}
	public void setFilledStageOrder(long value)
	{
		FilledStageOrder = value;
	}
	public long getDoneForDayStageOrder()
	{
		return DoneForDayStageOrder;
	}
	public void setDoneForDayStageOrder(long value)
	{
		DoneForDayStageOrder = value;
	}
	public long getCanceledStageOrder()
	{
		return CanceledStageOrder;
	}
	public void setCanceledStageOrder(long value)
	{
		CanceledStageOrder = value;
	}
	public long getCanceledByGovStageOrder()
	{
		return CanceledByGovStageOrder;
	}
	public void setCanceledByGovStageOrder(long value)
	{
		CanceledByGovStageOrder = value;
	}
	public long getNewInventoryOrder()
	{
		return NewInventoryOrder;
	}
	public void setNewInventoryOrder(long value)
	{
		NewInventoryOrder = value;
	}
	public long getFilledInventoryOrder()
	{
		return FilledInventoryOrder;
	}
	public void setFilledInventoryOrder(long value)
	{
		FilledInventoryOrder = value;
	}
	public long getRefusedInventoryOrder()
	{
		return RefusedInventoryOrder;
	}
	public void setRefusedInventoryOrder(long value)
	{
		RefusedInventoryOrder = value;
	}
	public long getTimeoutInventoryOrder()
	{
		return TimeoutInventoryOrder;
	}
	public void setTimeoutInventoryOrder(long value)
	{
		TimeoutInventoryOrder = value;
	}
	public long getDeletedByGovInventoryOrder()
	{
		return DeletedByGovInventoryOrder;
	}
	public void setDeletedByGovInventoryOrder(long value)
	{
		DeletedByGovInventoryOrder = value;
	}
	public long getZeroFilledInventoryOrder()
	{
		return ZeroFilledInventoryOrder;
	}
	public void setZeroFilledInventoryOrder(long value)
	{
		ZeroFilledInventoryOrder = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		ActiveDeals = (long)byteBuffer.readInt();
		CancDeals = (long)byteBuffer.readInt();
		NewInventoryQuote = (long)byteBuffer.readInt();
		EditInventoryQuote = (long)byteBuffer.readInt();
		DelIventoryQuote = (long)byteBuffer.readInt();
		NewRFCQ = (long)byteBuffer.readInt();
		AcceptedRFCQ = (long)byteBuffer.readInt();
		RefusedRFCQ = (long)byteBuffer.readInt();
		RejectedRFCQ = (long)byteBuffer.readInt();
		ClosedRFCQ = (long)byteBuffer.readInt();
		ClosedByGovRFCQ = (long)byteBuffer.readInt();
		DeletedByGovRFCQ = (long)byteBuffer.readInt();
		NewRFCQQuote = (long)byteBuffer.readInt();
		EditRFCQQuote = (long)byteBuffer.readInt();
		DelRFCQQuote = (long)byteBuffer.readInt();
		NewRFCQOrder = (long)byteBuffer.readInt();
		FilledRFCQOrder = (long)byteBuffer.readInt();
		RefusedRFCQOrder = (long)byteBuffer.readInt();
		DeletedRFCQOrder = (long)byteBuffer.readInt();
		NewStageOrder = (long)byteBuffer.readInt();
		FilledStageOrder = (long)byteBuffer.readInt();
		DoneForDayStageOrder = (long)byteBuffer.readInt();
		CanceledStageOrder = (long)byteBuffer.readInt();
		CanceledByGovStageOrder = (long)byteBuffer.readInt();
		NewInventoryOrder = (long)byteBuffer.readInt();
		FilledInventoryOrder = (long)byteBuffer.readInt();
		RefusedInventoryOrder = (long)byteBuffer.readInt();
		TimeoutInventoryOrder = (long)byteBuffer.readInt();
		DeletedByGovInventoryOrder = (long)byteBuffer.readInt();
		ZeroFilledInventoryOrder = (long)byteBuffer.readInt();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(ActiveDeals & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(CancDeals & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(NewInventoryQuote & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(EditInventoryQuote & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(DelIventoryQuote & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(NewRFCQ & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(AcceptedRFCQ & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(RefusedRFCQ & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(RejectedRFCQ & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(ClosedRFCQ & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(ClosedByGovRFCQ & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(DeletedByGovRFCQ & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(NewRFCQQuote & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(EditRFCQQuote & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(DelRFCQQuote & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(NewRFCQOrder & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(FilledRFCQOrder & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(RefusedRFCQOrder & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(DeletedRFCQOrder & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(NewStageOrder & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(FilledStageOrder & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(DoneForDayStageOrder & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(CanceledStageOrder & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(CanceledByGovStageOrder & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(NewInventoryOrder & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(FilledInventoryOrder & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(RefusedInventoryOrder & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(TimeoutInventoryOrder & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(DeletedByGovInventoryOrder & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(ZeroFilledInventoryOrder & 0xFFFFFFFFL));

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
		stringBuilder.append("DF_RFCQ_TRADING_INFO::");
		stringBuilder.append("ActiveDeals(").append(ActiveDeals).append(")");
		stringBuilder.append("CancDeals(").append(CancDeals).append(")");
		stringBuilder.append("NewInventoryQuote(").append(NewInventoryQuote).append(")");
		stringBuilder.append("EditInventoryQuote(").append(EditInventoryQuote).append(")");
		stringBuilder.append("DelIventoryQuote(").append(DelIventoryQuote).append(")");
		stringBuilder.append("NewRFCQ(").append(NewRFCQ).append(")");
		stringBuilder.append("AcceptedRFCQ(").append(AcceptedRFCQ).append(")");
		stringBuilder.append("RefusedRFCQ(").append(RefusedRFCQ).append(")");
		stringBuilder.append("RejectedRFCQ(").append(RejectedRFCQ).append(")");
		stringBuilder.append("ClosedRFCQ(").append(ClosedRFCQ).append(")");
		stringBuilder.append("ClosedByGovRFCQ(").append(ClosedByGovRFCQ).append(")");
		stringBuilder.append("DeletedByGovRFCQ(").append(DeletedByGovRFCQ).append(")");
		stringBuilder.append("NewRFCQQuote(").append(NewRFCQQuote).append(")");
		stringBuilder.append("EditRFCQQuote(").append(EditRFCQQuote).append(")");
		stringBuilder.append("DelRFCQQuote(").append(DelRFCQQuote).append(")");
		stringBuilder.append("NewRFCQOrder(").append(NewRFCQOrder).append(")");
		stringBuilder.append("FilledRFCQOrder(").append(FilledRFCQOrder).append(")");
		stringBuilder.append("RefusedRFCQOrder(").append(RefusedRFCQOrder).append(")");
		stringBuilder.append("DeletedRFCQOrder(").append(DeletedRFCQOrder).append(")");
		stringBuilder.append("NewStageOrder(").append(NewStageOrder).append(")");
		stringBuilder.append("FilledStageOrder(").append(FilledStageOrder).append(")");
		stringBuilder.append("DoneForDayStageOrder(").append(DoneForDayStageOrder).append(")");
		stringBuilder.append("CanceledStageOrder(").append(CanceledStageOrder).append(")");
		stringBuilder.append("CanceledByGovStageOrder(").append(CanceledByGovStageOrder).append(")");
		stringBuilder.append("NewInventoryOrder(").append(NewInventoryOrder).append(")");
		stringBuilder.append("FilledInventoryOrder(").append(FilledInventoryOrder).append(")");
		stringBuilder.append("RefusedInventoryOrder(").append(RefusedInventoryOrder).append(")");
		stringBuilder.append("TimeoutInventoryOrder(").append(TimeoutInventoryOrder).append(")");
		stringBuilder.append("DeletedByGovInventoryOrder(").append(DeletedByGovInventoryOrder).append(")");
		stringBuilder.append("ZeroFilledInventoryOrder(").append(ZeroFilledInventoryOrder).append(")");
		return stringBuilder.toString();
	}
}
