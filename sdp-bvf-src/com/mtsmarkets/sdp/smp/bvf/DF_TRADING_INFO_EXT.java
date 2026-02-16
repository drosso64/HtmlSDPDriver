package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class DF_TRADING_INFO_EXT extends SMPMessage
{
	public static final long CLASS_ID = 107901;

	private long NewQuote = 0;
	private long EditQuote = 0;
	private long DelQuote = 0;
	private long NewOrderFAS = 0;
	private long EditOrderFAS = 0;
	private long DelOrderFAS = 0;
	private long NewOrder = 0;
	private long AcceptedOrder = 0;
	private long RefusedOrder = 0;
	private long NewRFQ = 0;
	private long AcceptedRFQ = 0;
	private long RefusedRFQ = 0;
	private long ActiveDeals = 0;
	private long CancDeals = 0;
	private long NewIndicativeQuote = 0;
	private long EditIndicativeQuote = 0;
	private long DelIndicativeQuote = 0;
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
	private long PartiallyFilledStageOrder = 0;
	private long DoneForDayStageOrder = 0;
	private long CanceledStageOrder = 0;
	private long CanceledByGovStageOrder = 0;
	private long NewOTC = 0;
	private long AcceptedOTC = 0;
	private long RefusedOTC = 0;
	private long LockedOTC = 0;
	private long CancelledByGovOTC = 0;

	public DF_TRADING_INFO_EXT()
	{
	}

	public long getNewQuote()
	{
		return NewQuote;
	}
	public void setNewQuote(long value)
	{
		NewQuote = value;
	}
	public long getEditQuote()
	{
		return EditQuote;
	}
	public void setEditQuote(long value)
	{
		EditQuote = value;
	}
	public long getDelQuote()
	{
		return DelQuote;
	}
	public void setDelQuote(long value)
	{
		DelQuote = value;
	}
	public long getNewOrderFAS()
	{
		return NewOrderFAS;
	}
	public void setNewOrderFAS(long value)
	{
		NewOrderFAS = value;
	}
	public long getEditOrderFAS()
	{
		return EditOrderFAS;
	}
	public void setEditOrderFAS(long value)
	{
		EditOrderFAS = value;
	}
	public long getDelOrderFAS()
	{
		return DelOrderFAS;
	}
	public void setDelOrderFAS(long value)
	{
		DelOrderFAS = value;
	}
	public long getNewOrder()
	{
		return NewOrder;
	}
	public void setNewOrder(long value)
	{
		NewOrder = value;
	}
	public long getAcceptedOrder()
	{
		return AcceptedOrder;
	}
	public void setAcceptedOrder(long value)
	{
		AcceptedOrder = value;
	}
	public long getRefusedOrder()
	{
		return RefusedOrder;
	}
	public void setRefusedOrder(long value)
	{
		RefusedOrder = value;
	}
	public long getNewRFQ()
	{
		return NewRFQ;
	}
	public void setNewRFQ(long value)
	{
		NewRFQ = value;
	}
	public long getAcceptedRFQ()
	{
		return AcceptedRFQ;
	}
	public void setAcceptedRFQ(long value)
	{
		AcceptedRFQ = value;
	}
	public long getRefusedRFQ()
	{
		return RefusedRFQ;
	}
	public void setRefusedRFQ(long value)
	{
		RefusedRFQ = value;
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
	public long getNewIndicativeQuote()
	{
		return NewIndicativeQuote;
	}
	public void setNewIndicativeQuote(long value)
	{
		NewIndicativeQuote = value;
	}
	public long getEditIndicativeQuote()
	{
		return EditIndicativeQuote;
	}
	public void setEditIndicativeQuote(long value)
	{
		EditIndicativeQuote = value;
	}
	public long getDelIndicativeQuote()
	{
		return DelIndicativeQuote;
	}
	public void setDelIndicativeQuote(long value)
	{
		DelIndicativeQuote = value;
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
	public long getPartiallyFilledStageOrder()
	{
		return PartiallyFilledStageOrder;
	}
	public void setPartiallyFilledStageOrder(long value)
	{
		PartiallyFilledStageOrder = value;
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
	public long getNewOTC()
	{
		return NewOTC;
	}
	public void setNewOTC(long value)
	{
		NewOTC = value;
	}
	public long getAcceptedOTC()
	{
		return AcceptedOTC;
	}
	public void setAcceptedOTC(long value)
	{
		AcceptedOTC = value;
	}
	public long getRefusedOTC()
	{
		return RefusedOTC;
	}
	public void setRefusedOTC(long value)
	{
		RefusedOTC = value;
	}
	public long getLockedOTC()
	{
		return LockedOTC;
	}
	public void setLockedOTC(long value)
	{
		LockedOTC = value;
	}
	public long getCancelledByGovOTC()
	{
		return CancelledByGovOTC;
	}
	public void setCancelledByGovOTC(long value)
	{
		CancelledByGovOTC = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		NewQuote = (long)byteBuffer.readInt();
		EditQuote = (long)byteBuffer.readInt();
		DelQuote = (long)byteBuffer.readInt();
		NewOrderFAS = (long)byteBuffer.readInt();
		EditOrderFAS = (long)byteBuffer.readInt();
		DelOrderFAS = (long)byteBuffer.readInt();
		NewOrder = (long)byteBuffer.readInt();
		AcceptedOrder = (long)byteBuffer.readInt();
		RefusedOrder = (long)byteBuffer.readInt();
		NewRFQ = (long)byteBuffer.readInt();
		AcceptedRFQ = (long)byteBuffer.readInt();
		RefusedRFQ = (long)byteBuffer.readInt();
		ActiveDeals = (long)byteBuffer.readInt();
		CancDeals = (long)byteBuffer.readInt();
		NewIndicativeQuote = (long)byteBuffer.readInt();
		EditIndicativeQuote = (long)byteBuffer.readInt();
		DelIndicativeQuote = (long)byteBuffer.readInt();
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
		PartiallyFilledStageOrder = (long)byteBuffer.readInt();
		DoneForDayStageOrder = (long)byteBuffer.readInt();
		CanceledStageOrder = (long)byteBuffer.readInt();
		CanceledByGovStageOrder = (long)byteBuffer.readInt();
		NewOTC = (long)byteBuffer.readInt();
		AcceptedOTC = (long)byteBuffer.readInt();
		RefusedOTC = (long)byteBuffer.readInt();
		LockedOTC = (long)byteBuffer.readInt();
		CancelledByGovOTC = (long)byteBuffer.readInt();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(NewQuote & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(EditQuote & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(DelQuote & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(NewOrderFAS & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(EditOrderFAS & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(DelOrderFAS & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(NewOrder & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(AcceptedOrder & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(RefusedOrder & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(NewRFQ & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(AcceptedRFQ & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(RefusedRFQ & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(ActiveDeals & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(CancDeals & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(NewIndicativeQuote & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(EditIndicativeQuote & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(DelIndicativeQuote & 0xFFFFFFFFL));
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
		byteBuffer.writeInt((int)(PartiallyFilledStageOrder & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(DoneForDayStageOrder & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(CanceledStageOrder & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(CanceledByGovStageOrder & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(NewOTC & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(AcceptedOTC & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(RefusedOTC & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(LockedOTC & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(CancelledByGovOTC & 0xFFFFFFFFL));

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
		stringBuilder.append("DF_TRADING_INFO_EXT::");
		stringBuilder.append("NewQuote(").append(NewQuote).append(")");
		stringBuilder.append("EditQuote(").append(EditQuote).append(")");
		stringBuilder.append("DelQuote(").append(DelQuote).append(")");
		stringBuilder.append("NewOrderFAS(").append(NewOrderFAS).append(")");
		stringBuilder.append("EditOrderFAS(").append(EditOrderFAS).append(")");
		stringBuilder.append("DelOrderFAS(").append(DelOrderFAS).append(")");
		stringBuilder.append("NewOrder(").append(NewOrder).append(")");
		stringBuilder.append("AcceptedOrder(").append(AcceptedOrder).append(")");
		stringBuilder.append("RefusedOrder(").append(RefusedOrder).append(")");
		stringBuilder.append("NewRFQ(").append(NewRFQ).append(")");
		stringBuilder.append("AcceptedRFQ(").append(AcceptedRFQ).append(")");
		stringBuilder.append("RefusedRFQ(").append(RefusedRFQ).append(")");
		stringBuilder.append("ActiveDeals(").append(ActiveDeals).append(")");
		stringBuilder.append("CancDeals(").append(CancDeals).append(")");
		stringBuilder.append("NewIndicativeQuote(").append(NewIndicativeQuote).append(")");
		stringBuilder.append("EditIndicativeQuote(").append(EditIndicativeQuote).append(")");
		stringBuilder.append("DelIndicativeQuote(").append(DelIndicativeQuote).append(")");
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
		stringBuilder.append("PartiallyFilledStageOrder(").append(PartiallyFilledStageOrder).append(")");
		stringBuilder.append("DoneForDayStageOrder(").append(DoneForDayStageOrder).append(")");
		stringBuilder.append("CanceledStageOrder(").append(CanceledStageOrder).append(")");
		stringBuilder.append("CanceledByGovStageOrder(").append(CanceledByGovStageOrder).append(")");
		stringBuilder.append("NewOTC(").append(NewOTC).append(")");
		stringBuilder.append("AcceptedOTC(").append(AcceptedOTC).append(")");
		stringBuilder.append("RefusedOTC(").append(RefusedOTC).append(")");
		stringBuilder.append("LockedOTC(").append(LockedOTC).append(")");
		stringBuilder.append("CancelledByGovOTC(").append(CancelledByGovOTC).append(")");
		return stringBuilder.toString();
	}
}
