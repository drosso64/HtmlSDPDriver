package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_QUOTE_SEQNO extends SMPMessage
{
	public static final long CLASS_ID = 100901;

	private long MarketId = 0;
	private long SeqNo = 0;

	public TI_QUOTE_SEQNO()
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
	public long getSeqNo()
	{
		return SeqNo;
	}
	public void setSeqNo(long value)
	{
		SeqNo = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MarketId = (long)byteBuffer.readInt();
		SeqNo = (long)byteBuffer.readInt();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MarketId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SeqNo & 0xFFFFFFFFL));

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
		stringBuilder.append("TI_QUOTE_SEQNO::");
		stringBuilder.append("MarketId(").append(MarketId).append(")");
		stringBuilder.append("SeqNo(").append(SeqNo).append(")");
		return stringBuilder.toString();
	}
}
