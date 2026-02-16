package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_RFCQ_ORDER_BUY_SIDE_QUERY_PARAM extends SMPMessage
{
	public static final long CLASS_ID = 214202;

	private TI_QUERY_OP_Enum TransactionIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long TransactionId = 0;
	private TI_QUERY_OP_Enum DateFromOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long DateFrom = 0;
	private TI_QUERY_OP_Enum DateToOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private long DateTo = 0;
	private TI_QUERY_OP_Enum LegIdOp = TI_QUERY_OP_Enum.TI_QUERY_OP_None;
	private short LegId = 0;

	public BV_RFCQ_ORDER_BUY_SIDE_QUERY_PARAM()
	{
	}

	public TI_QUERY_OP_Enum getTransactionIdOp()
	{
		return TransactionIdOp;
	}
	public void setTransactionIdOp(TI_QUERY_OP_Enum value)
	{
		TransactionIdOp = value;
	}
	public long getTransactionId()
	{
		return TransactionId;
	}
	public void setTransactionId(long value)
	{
		TransactionId = value;
	}
	public TI_QUERY_OP_Enum getDateFromOp()
	{
		return DateFromOp;
	}
	public void setDateFromOp(TI_QUERY_OP_Enum value)
	{
		DateFromOp = value;
	}
	public long getDateFrom()
	{
		return DateFrom;
	}
	public void setDateFrom(long value)
	{
		DateFrom = value;
	}
	public TI_QUERY_OP_Enum getDateToOp()
	{
		return DateToOp;
	}
	public void setDateToOp(TI_QUERY_OP_Enum value)
	{
		DateToOp = value;
	}
	public long getDateTo()
	{
		return DateTo;
	}
	public void setDateTo(long value)
	{
		DateTo = value;
	}
	public TI_QUERY_OP_Enum getLegIdOp()
	{
		return LegIdOp;
	}
	public void setLegIdOp(TI_QUERY_OP_Enum value)
	{
		LegIdOp = value;
	}
	public short getLegId()
	{
		return LegId;
	}
	public void setLegId(short value)
	{
		LegId = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		TransactionIdOp = TransactionIdOp.getEnum(byteBuffer.readInt());
		TransactionId = (long)byteBuffer.readInt();
		DateFromOp = DateFromOp.getEnum(byteBuffer.readInt());
		DateFrom = (long)byteBuffer.readInt();
		DateToOp = DateToOp.getEnum(byteBuffer.readInt());
		DateTo = (long)byteBuffer.readInt();
		LegIdOp = LegIdOp.getEnum(byteBuffer.readInt());
		LegId = (short)byteBuffer.readInt();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt(TransactionIdOp.getValue());
		byteBuffer.writeInt((int)(TransactionId & 0xFFFFFFFFL));
		byteBuffer.writeInt(DateFromOp.getValue());
		byteBuffer.writeInt((int)(DateFrom & 0xFFFFFFFFL));
		byteBuffer.writeInt(DateToOp.getValue());
		byteBuffer.writeInt((int)(DateTo & 0xFFFFFFFFL));
		byteBuffer.writeInt(LegIdOp.getValue());
		byteBuffer.writeInt((int)(LegId & 0xFFFFL));

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
		stringBuilder.append("BV_RFCQ_ORDER_BUY_SIDE_QUERY_PARAM::");
		stringBuilder.append("TransactionIdOp(").append(TransactionIdOp).append(")");
		stringBuilder.append("TransactionId(").append(TransactionId).append(")");
		stringBuilder.append("DateFromOp(").append(DateFromOp).append(")");
		stringBuilder.append("DateFrom(").append(DateFrom).append(")");
		stringBuilder.append("DateToOp(").append(DateToOp).append(")");
		stringBuilder.append("DateTo(").append(DateTo).append(")");
		stringBuilder.append("LegIdOp(").append(LegIdOp).append(")");
		stringBuilder.append("LegId(").append(LegId).append(")");
		return stringBuilder.toString();
	}
}
