package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class DF_TRAFFIC extends SMPMessage
{
	public static final long CLASS_ID = 170004;

	private long MarketId = 0;
	private long SectionId = 0;
	private int Hour = 0;
	private int Quarter = 0;
	private int Minutes = 0;
	private long NewQuote = 0;
	private long EditQuote = 0;
	private long DelQuote = 0;
	private long NewOrder = 0;
	private long AcceptedOrder = 0;
	private long RejectedOrder = 0;
	private long NewRFQ = 0;
	private long AcceptedRFQ = 0;
	private long RejectedRFQ = 0;

	public DF_TRAFFIC()
	{
	}

	public long getMarketId()
	{
		return MarketId;
	}
	public void setMarketId(long value)
	{
		MarketId = value;
	}
	public long getSectionId()
	{
		return SectionId;
	}
	public void setSectionId(long value)
	{
		SectionId = value;
	}
	public int getHour()
	{
		return Hour;
	}
	public void setHour(int value)
	{
		Hour = value;
	}
	public int getQuarter()
	{
		return Quarter;
	}
	public void setQuarter(int value)
	{
		Quarter = value;
	}
	public int getMinutes()
	{
		return Minutes;
	}
	public void setMinutes(int value)
	{
		Minutes = value;
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

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MarketId = (long)byteBuffer.readInt();
		SectionId = (long)byteBuffer.readInt();
		Hour = (int)byteBuffer.readInt();
		Quarter = (int)byteBuffer.readInt();
		Minutes = (int)byteBuffer.readInt();
		NewQuote = (long)byteBuffer.readInt();
		EditQuote = (long)byteBuffer.readInt();
		DelQuote = (long)byteBuffer.readInt();
		NewOrder = (long)byteBuffer.readInt();
		AcceptedOrder = (long)byteBuffer.readInt();
		RejectedOrder = (long)byteBuffer.readInt();
		NewRFQ = (long)byteBuffer.readInt();
		AcceptedRFQ = (long)byteBuffer.readInt();
		RejectedRFQ = (long)byteBuffer.readInt();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MarketId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SectionId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(Hour & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(Quarter & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(Minutes & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(NewQuote & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(EditQuote & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(DelQuote & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(NewOrder & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(AcceptedOrder & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(RejectedOrder & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(NewRFQ & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(AcceptedRFQ & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(RejectedRFQ & 0xFFFFFFFFL));

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
		stringBuilder.append("DF_TRAFFIC::");
		stringBuilder.append("MarketId(").append(MarketId).append(")");
		stringBuilder.append("SectionId(").append(SectionId).append(")");
		stringBuilder.append("Hour(").append(Hour).append(")");
		stringBuilder.append("Quarter(").append(Quarter).append(")");
		stringBuilder.append("Minutes(").append(Minutes).append(")");
		stringBuilder.append("NewQuote(").append(NewQuote).append(")");
		stringBuilder.append("EditQuote(").append(EditQuote).append(")");
		stringBuilder.append("DelQuote(").append(DelQuote).append(")");
		stringBuilder.append("NewOrder(").append(NewOrder).append(")");
		stringBuilder.append("AcceptedOrder(").append(AcceptedOrder).append(")");
		stringBuilder.append("RejectedOrder(").append(RejectedOrder).append(")");
		stringBuilder.append("NewRFQ(").append(NewRFQ).append(")");
		stringBuilder.append("AcceptedRFQ(").append(AcceptedRFQ).append(")");
		stringBuilder.append("RejectedRFQ(").append(RejectedRFQ).append(")");
		return stringBuilder.toString();
	}
}
