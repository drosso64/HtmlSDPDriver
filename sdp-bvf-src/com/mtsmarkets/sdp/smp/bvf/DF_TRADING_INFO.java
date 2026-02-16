package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class DF_TRADING_INFO extends SMPMessage
{
	public static final long CLASS_ID = 107900;

	private long NewQuote = 0;
	private long EditQuote = 0;
	private long DelQuote = 0;
	private long NewOrder = 0;
	private long AcceptedOrder = 0;
	private long RejectedOrder = 0;
	private double OrderQty = 0;
	private double OrderNominalValue = 0;
	private long NewRFQ = 0;
	private long AcceptedRFQ = 0;
	private long RejectedRFQ = 0;
	private double RFQQty = 0;
	private double RFQNominalValue = 0;
	private long NewOTC = 0;
	private long AcceptedOTC = 0;
	private long RefusedOTC = 0;
	private long LockedOTC = 0;
	private long CancelledByGovOTC = 0;

	public DF_TRADING_INFO()
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
	public long getRejectedOrder()
	{
		return RejectedOrder;
	}
	public void setRejectedOrder(long value)
	{
		RejectedOrder = value;
	}
	public double getOrderQty()
	{
		return OrderQty;
	}
	public void setOrderQty(double value)
	{
		OrderQty = value;
	}
	public double getOrderNominalValue()
	{
		return OrderNominalValue;
	}
	public void setOrderNominalValue(double value)
	{
		OrderNominalValue = value;
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
	public long getRejectedRFQ()
	{
		return RejectedRFQ;
	}
	public void setRejectedRFQ(long value)
	{
		RejectedRFQ = value;
	}
	public double getRFQQty()
	{
		return RFQQty;
	}
	public void setRFQQty(double value)
	{
		RFQQty = value;
	}
	public double getRFQNominalValue()
	{
		return RFQNominalValue;
	}
	public void setRFQNominalValue(double value)
	{
		RFQNominalValue = value;
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
		NewOrder = (long)byteBuffer.readInt();
		AcceptedOrder = (long)byteBuffer.readInt();
		RejectedOrder = (long)byteBuffer.readInt();
		OrderQty = byteBuffer.readDouble();
		OrderNominalValue = byteBuffer.readDouble();
		NewRFQ = (long)byteBuffer.readInt();
		AcceptedRFQ = (long)byteBuffer.readInt();
		RejectedRFQ = (long)byteBuffer.readInt();
		RFQQty = byteBuffer.readDouble();
		RFQNominalValue = byteBuffer.readDouble();
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
		byteBuffer.writeInt((int)(NewOrder & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(AcceptedOrder & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(RejectedOrder & 0xFFFFFFFFL));
		byteBuffer.writeDouble(OrderQty);
		byteBuffer.writeDouble(OrderNominalValue);
		byteBuffer.writeInt((int)(NewRFQ & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(AcceptedRFQ & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(RejectedRFQ & 0xFFFFFFFFL));
		byteBuffer.writeDouble(RFQQty);
		byteBuffer.writeDouble(RFQNominalValue);
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
		stringBuilder.append("DF_TRADING_INFO::");
		stringBuilder.append("NewQuote(").append(NewQuote).append(")");
		stringBuilder.append("EditQuote(").append(EditQuote).append(")");
		stringBuilder.append("DelQuote(").append(DelQuote).append(")");
		stringBuilder.append("NewOrder(").append(NewOrder).append(")");
		stringBuilder.append("AcceptedOrder(").append(AcceptedOrder).append(")");
		stringBuilder.append("RejectedOrder(").append(RejectedOrder).append(")");
		stringBuilder.append("OrderQty(").append(OrderQty).append(")");
		stringBuilder.append("OrderNominalValue(").append(OrderNominalValue).append(")");
		stringBuilder.append("NewRFQ(").append(NewRFQ).append(")");
		stringBuilder.append("AcceptedRFQ(").append(AcceptedRFQ).append(")");
		stringBuilder.append("RejectedRFQ(").append(RejectedRFQ).append(")");
		stringBuilder.append("RFQQty(").append(RFQQty).append(")");
		stringBuilder.append("RFQNominalValue(").append(RFQNominalValue).append(")");
		stringBuilder.append("NewOTC(").append(NewOTC).append(")");
		stringBuilder.append("AcceptedOTC(").append(AcceptedOTC).append(")");
		stringBuilder.append("RefusedOTC(").append(RefusedOTC).append(")");
		stringBuilder.append("LockedOTC(").append(LockedOTC).append(")");
		stringBuilder.append("CancelledByGovOTC(").append(CancelledByGovOTC).append(")");
		return stringBuilder.toString();
	}
}
