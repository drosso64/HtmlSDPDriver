package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_RFCQ_QUICK_INFO extends SMPMessage
{
	public static final long CLASS_ID = 114174;

	private long QuoteId = 0;
	private TI_RFCQ_QUOTE_STATUS_Enum Status = TI_RFCQ_QUOTE_STATUS_Enum.TI_RFCQ_QUOTE_STATUS_Active;
	private long EditTime = 0;

	public BV_RFCQ_QUICK_INFO()
	{
	}

	public long getQuoteId()
	{
		return QuoteId;
	}
	public void setQuoteId(long value)
	{
		QuoteId = value;
	}
	public TI_RFCQ_QUOTE_STATUS_Enum getStatus()
	{
		return Status;
	}
	public void setStatus(TI_RFCQ_QUOTE_STATUS_Enum value)
	{
		Status = value;
	}
	public long getEditTime()
	{
		return EditTime;
	}
	public void setEditTime(long value)
	{
		EditTime = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		QuoteId = (long)byteBuffer.readInt();
		Status = Status.getEnum(byteBuffer.readInt());
		EditTime = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(QuoteId & 0xFFFFFFFFL));
		byteBuffer.writeInt(Status.getValue());
		byteBuffer.writeLong(EditTime);

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
		stringBuilder.append("BV_RFCQ_QUICK_INFO::");
		stringBuilder.append("QuoteId(").append(QuoteId).append(")");
		stringBuilder.append("Status(").append(Status).append(")");
		stringBuilder.append("EditTime(").append(EditTime).append(")");
		return stringBuilder.toString();
	}
}
