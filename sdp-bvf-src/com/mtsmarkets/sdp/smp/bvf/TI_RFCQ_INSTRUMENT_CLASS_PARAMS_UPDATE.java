package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_RFCQ_INSTRUMENT_CLASS_PARAMS_UPDATE extends SMPMessage
{
	public static final long CLASS_ID = 100815;

	private long RequestId = 0;
	private long InstrumentClassId = 0;
	private long RFCQTimer = 0;
	private short RFCQMaxNumRecipients = 0;
	private short RFCQMaxOffsetSettlement = 0;
	private short RFCQMinAutomaticMatchingTimeout = 0;
	private short RFCQAcceptanceTimeout = 0;
	private TI_FLAG_Enum ConcurrentBidAskRFCQFg = TI_FLAG_Enum.TI_FLAG_No;
	private long UpdateTime = 0;

	public TI_RFCQ_INSTRUMENT_CLASS_PARAMS_UPDATE()
	{
	}

	public long getRequestId()
	{
		return RequestId;
	}
	public void setRequestId(long value)
	{
		RequestId = value;
	}
	public long getInstrumentClassId()
	{
		return InstrumentClassId;
	}
	public void setInstrumentClassId(long value)
	{
		InstrumentClassId = value;
	}
	public long getRFCQTimer()
	{
		return RFCQTimer;
	}
	public void setRFCQTimer(long value)
	{
		RFCQTimer = value;
	}
	public short getRFCQMaxNumRecipients()
	{
		return RFCQMaxNumRecipients;
	}
	public void setRFCQMaxNumRecipients(short value)
	{
		RFCQMaxNumRecipients = value;
	}
	public short getRFCQMaxOffsetSettlement()
	{
		return RFCQMaxOffsetSettlement;
	}
	public void setRFCQMaxOffsetSettlement(short value)
	{
		RFCQMaxOffsetSettlement = value;
	}
	public short getRFCQMinAutomaticMatchingTimeout()
	{
		return RFCQMinAutomaticMatchingTimeout;
	}
	public void setRFCQMinAutomaticMatchingTimeout(short value)
	{
		RFCQMinAutomaticMatchingTimeout = value;
	}
	public short getRFCQAcceptanceTimeout()
	{
		return RFCQAcceptanceTimeout;
	}
	public void setRFCQAcceptanceTimeout(short value)
	{
		RFCQAcceptanceTimeout = value;
	}
	public TI_FLAG_Enum getConcurrentBidAskRFCQFg()
	{
		return ConcurrentBidAskRFCQFg;
	}
	public void setConcurrentBidAskRFCQFg(TI_FLAG_Enum value)
	{
		ConcurrentBidAskRFCQFg = value;
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
		RequestId = (long)byteBuffer.readInt();
		InstrumentClassId = (long)byteBuffer.readInt();
		RFCQTimer = (long)byteBuffer.readInt();
		RFCQMaxNumRecipients = (short)byteBuffer.readInt();
		RFCQMaxOffsetSettlement = (short)byteBuffer.readInt();
		RFCQMinAutomaticMatchingTimeout = (short)byteBuffer.readInt();
		RFCQAcceptanceTimeout = (short)byteBuffer.readInt();
		ConcurrentBidAskRFCQFg = ConcurrentBidAskRFCQFg.getEnum(byteBuffer.readInt());
		UpdateTime = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(RequestId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(InstrumentClassId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(RFCQTimer & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(RFCQMaxNumRecipients & 0xFFFFL));
		byteBuffer.writeInt((int)(RFCQMaxOffsetSettlement & 0xFFFFL));
		byteBuffer.writeInt((int)(RFCQMinAutomaticMatchingTimeout & 0xFFFFL));
		byteBuffer.writeInt((int)(RFCQAcceptanceTimeout & 0xFFFFL));
		byteBuffer.writeInt(ConcurrentBidAskRFCQFg.getValue());
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
		stringBuilder.append("TI_RFCQ_INSTRUMENT_CLASS_PARAMS_UPDATE::");
		stringBuilder.append("RequestId(").append(RequestId).append(")");
		stringBuilder.append("InstrumentClassId(").append(InstrumentClassId).append(")");
		stringBuilder.append("RFCQTimer(").append(RFCQTimer).append(")");
		stringBuilder.append("RFCQMaxNumRecipients(").append(RFCQMaxNumRecipients).append(")");
		stringBuilder.append("RFCQMaxOffsetSettlement(").append(RFCQMaxOffsetSettlement).append(")");
		stringBuilder.append("RFCQMinAutomaticMatchingTimeout(").append(RFCQMinAutomaticMatchingTimeout).append(")");
		stringBuilder.append("RFCQAcceptanceTimeout(").append(RFCQAcceptanceTimeout).append(")");
		stringBuilder.append("ConcurrentBidAskRFCQFg(").append(ConcurrentBidAskRFCQFg).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		return stringBuilder.toString();
	}
}
