package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_MULTIMEMBER_TRADER extends SMPMessage
{
	public static final long CLASS_ID = 100075;

	private long MultiMemberId = 0;
	private long MultiMemberTraderId = 0;
	private long MemberId = 0;
	private long TraderId = 0;

	public BV_MULTIMEMBER_TRADER()
	{
	}

	public long getMultiMemberId()
	{
		return MultiMemberId;
	}
	public void setMultiMemberId(long value)
	{
		MultiMemberId = value;
	}
	public long getMultiMemberTraderId()
	{
		return MultiMemberTraderId;
	}
	public void setMultiMemberTraderId(long value)
	{
		MultiMemberTraderId = value;
	}
	public long getMemberId()
	{
		return MemberId;
	}
	public void setMemberId(long value)
	{
		MemberId = value;
	}
	public long getTraderId()
	{
		return TraderId;
	}
	public void setTraderId(long value)
	{
		TraderId = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MultiMemberId = (long)byteBuffer.readInt();
		MultiMemberTraderId = (long)byteBuffer.readInt();
		MemberId = (long)byteBuffer.readInt();
		TraderId = (long)byteBuffer.readInt();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MultiMemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(MultiMemberTraderId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(MemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(TraderId & 0xFFFFFFFFL));

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
		stringBuilder.append("BV_MULTIMEMBER_TRADER::");
		stringBuilder.append("MultiMemberId(").append(MultiMemberId).append(")");
		stringBuilder.append("MultiMemberTraderId(").append(MultiMemberTraderId).append(")");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("TraderId(").append(TraderId).append(")");
		return stringBuilder.toString();
	}
}
