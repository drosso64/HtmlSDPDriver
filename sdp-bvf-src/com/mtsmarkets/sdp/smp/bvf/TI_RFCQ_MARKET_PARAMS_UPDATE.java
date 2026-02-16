package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_RFCQ_MARKET_PARAMS_UPDATE extends SMPMessage
{
	public static final long CLASS_ID = 100811;

	private long RequestId = 0;
	private long MarketId = 0;
	private long SwitchRFCQTimer = 0;
	private short SwitchRFCQMaxNumRecipients = 0;
	private short SwitchRFCQMinAutomaticMatchingTimeout = 0;
	private short SwitchRFCQAcceptanceTimeout = 0;
	private long ButterflyRFCQTimer = 0;
	private short ButterflyRFCQMaxNumRecipients = 0;
	private short ButterflyRFCQMinAutomaticMatchingTimeout = 0;
	private short ButterflyRFCQAcceptanceTimeout = 0;
	private long MultilegRFCQTimer = 0;
	private short MultilegRFCQMaxNumRecipients = 0;
	private short MultilegRFCQMinAutomaticMatchingTimeout = 0;
	private short MultilegRFCQAcceptanceTimeout = 0;
	private long DoubleSidedRFCQTimer = 0;
	private short DoubleSidedRFCQMaxNumRecipients = 0;
	private short DoubleSidedRFCQMinAutomaticMatchingTimeout = 0;
	private short DoubleSidedRFCQAcceptanceTimeout = 0;
	private long UpdateTime = 0;

	public TI_RFCQ_MARKET_PARAMS_UPDATE()
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
	public long getMarketId()
	{
		return MarketId;
	}
	public void setMarketId(long value)
	{
		MarketId = value;
	}
	public long getSwitchRFCQTimer()
	{
		return SwitchRFCQTimer;
	}
	public void setSwitchRFCQTimer(long value)
	{
		SwitchRFCQTimer = value;
	}
	public short getSwitchRFCQMaxNumRecipients()
	{
		return SwitchRFCQMaxNumRecipients;
	}
	public void setSwitchRFCQMaxNumRecipients(short value)
	{
		SwitchRFCQMaxNumRecipients = value;
	}
	public short getSwitchRFCQMinAutomaticMatchingTimeout()
	{
		return SwitchRFCQMinAutomaticMatchingTimeout;
	}
	public void setSwitchRFCQMinAutomaticMatchingTimeout(short value)
	{
		SwitchRFCQMinAutomaticMatchingTimeout = value;
	}
	public short getSwitchRFCQAcceptanceTimeout()
	{
		return SwitchRFCQAcceptanceTimeout;
	}
	public void setSwitchRFCQAcceptanceTimeout(short value)
	{
		SwitchRFCQAcceptanceTimeout = value;
	}
	public long getButterflyRFCQTimer()
	{
		return ButterflyRFCQTimer;
	}
	public void setButterflyRFCQTimer(long value)
	{
		ButterflyRFCQTimer = value;
	}
	public short getButterflyRFCQMaxNumRecipients()
	{
		return ButterflyRFCQMaxNumRecipients;
	}
	public void setButterflyRFCQMaxNumRecipients(short value)
	{
		ButterflyRFCQMaxNumRecipients = value;
	}
	public short getButterflyRFCQMinAutomaticMatchingTimeout()
	{
		return ButterflyRFCQMinAutomaticMatchingTimeout;
	}
	public void setButterflyRFCQMinAutomaticMatchingTimeout(short value)
	{
		ButterflyRFCQMinAutomaticMatchingTimeout = value;
	}
	public short getButterflyRFCQAcceptanceTimeout()
	{
		return ButterflyRFCQAcceptanceTimeout;
	}
	public void setButterflyRFCQAcceptanceTimeout(short value)
	{
		ButterflyRFCQAcceptanceTimeout = value;
	}
	public long getMultilegRFCQTimer()
	{
		return MultilegRFCQTimer;
	}
	public void setMultilegRFCQTimer(long value)
	{
		MultilegRFCQTimer = value;
	}
	public short getMultilegRFCQMaxNumRecipients()
	{
		return MultilegRFCQMaxNumRecipients;
	}
	public void setMultilegRFCQMaxNumRecipients(short value)
	{
		MultilegRFCQMaxNumRecipients = value;
	}
	public short getMultilegRFCQMinAutomaticMatchingTimeout()
	{
		return MultilegRFCQMinAutomaticMatchingTimeout;
	}
	public void setMultilegRFCQMinAutomaticMatchingTimeout(short value)
	{
		MultilegRFCQMinAutomaticMatchingTimeout = value;
	}
	public short getMultilegRFCQAcceptanceTimeout()
	{
		return MultilegRFCQAcceptanceTimeout;
	}
	public void setMultilegRFCQAcceptanceTimeout(short value)
	{
		MultilegRFCQAcceptanceTimeout = value;
	}
	public long getDoubleSidedRFCQTimer()
	{
		return DoubleSidedRFCQTimer;
	}
	public void setDoubleSidedRFCQTimer(long value)
	{
		DoubleSidedRFCQTimer = value;
	}
	public short getDoubleSidedRFCQMaxNumRecipients()
	{
		return DoubleSidedRFCQMaxNumRecipients;
	}
	public void setDoubleSidedRFCQMaxNumRecipients(short value)
	{
		DoubleSidedRFCQMaxNumRecipients = value;
	}
	public short getDoubleSidedRFCQMinAutomaticMatchingTimeout()
	{
		return DoubleSidedRFCQMinAutomaticMatchingTimeout;
	}
	public void setDoubleSidedRFCQMinAutomaticMatchingTimeout(short value)
	{
		DoubleSidedRFCQMinAutomaticMatchingTimeout = value;
	}
	public short getDoubleSidedRFCQAcceptanceTimeout()
	{
		return DoubleSidedRFCQAcceptanceTimeout;
	}
	public void setDoubleSidedRFCQAcceptanceTimeout(short value)
	{
		DoubleSidedRFCQAcceptanceTimeout = value;
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
		MarketId = (long)byteBuffer.readInt();
		SwitchRFCQTimer = (long)byteBuffer.readInt();
		SwitchRFCQMaxNumRecipients = (short)byteBuffer.readInt();
		SwitchRFCQMinAutomaticMatchingTimeout = (short)byteBuffer.readInt();
		SwitchRFCQAcceptanceTimeout = (short)byteBuffer.readInt();
		ButterflyRFCQTimer = (long)byteBuffer.readInt();
		ButterflyRFCQMaxNumRecipients = (short)byteBuffer.readInt();
		ButterflyRFCQMinAutomaticMatchingTimeout = (short)byteBuffer.readInt();
		ButterflyRFCQAcceptanceTimeout = (short)byteBuffer.readInt();
		MultilegRFCQTimer = (long)byteBuffer.readInt();
		MultilegRFCQMaxNumRecipients = (short)byteBuffer.readInt();
		MultilegRFCQMinAutomaticMatchingTimeout = (short)byteBuffer.readInt();
		MultilegRFCQAcceptanceTimeout = (short)byteBuffer.readInt();
		DoubleSidedRFCQTimer = (long)byteBuffer.readInt();
		DoubleSidedRFCQMaxNumRecipients = (short)byteBuffer.readInt();
		DoubleSidedRFCQMinAutomaticMatchingTimeout = (short)byteBuffer.readInt();
		DoubleSidedRFCQAcceptanceTimeout = (short)byteBuffer.readInt();
		UpdateTime = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(RequestId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(MarketId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SwitchRFCQTimer & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SwitchRFCQMaxNumRecipients & 0xFFFFL));
		byteBuffer.writeInt((int)(SwitchRFCQMinAutomaticMatchingTimeout & 0xFFFFL));
		byteBuffer.writeInt((int)(SwitchRFCQAcceptanceTimeout & 0xFFFFL));
		byteBuffer.writeInt((int)(ButterflyRFCQTimer & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(ButterflyRFCQMaxNumRecipients & 0xFFFFL));
		byteBuffer.writeInt((int)(ButterflyRFCQMinAutomaticMatchingTimeout & 0xFFFFL));
		byteBuffer.writeInt((int)(ButterflyRFCQAcceptanceTimeout & 0xFFFFL));
		byteBuffer.writeInt((int)(MultilegRFCQTimer & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(MultilegRFCQMaxNumRecipients & 0xFFFFL));
		byteBuffer.writeInt((int)(MultilegRFCQMinAutomaticMatchingTimeout & 0xFFFFL));
		byteBuffer.writeInt((int)(MultilegRFCQAcceptanceTimeout & 0xFFFFL));
		byteBuffer.writeInt((int)(DoubleSidedRFCQTimer & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(DoubleSidedRFCQMaxNumRecipients & 0xFFFFL));
		byteBuffer.writeInt((int)(DoubleSidedRFCQMinAutomaticMatchingTimeout & 0xFFFFL));
		byteBuffer.writeInt((int)(DoubleSidedRFCQAcceptanceTimeout & 0xFFFFL));
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
		stringBuilder.append("TI_RFCQ_MARKET_PARAMS_UPDATE::");
		stringBuilder.append("RequestId(").append(RequestId).append(")");
		stringBuilder.append("MarketId(").append(MarketId).append(")");
		stringBuilder.append("SwitchRFCQTimer(").append(SwitchRFCQTimer).append(")");
		stringBuilder.append("SwitchRFCQMaxNumRecipients(").append(SwitchRFCQMaxNumRecipients).append(")");
		stringBuilder.append("SwitchRFCQMinAutomaticMatchingTimeout(").append(SwitchRFCQMinAutomaticMatchingTimeout).append(")");
		stringBuilder.append("SwitchRFCQAcceptanceTimeout(").append(SwitchRFCQAcceptanceTimeout).append(")");
		stringBuilder.append("ButterflyRFCQTimer(").append(ButterflyRFCQTimer).append(")");
		stringBuilder.append("ButterflyRFCQMaxNumRecipients(").append(ButterflyRFCQMaxNumRecipients).append(")");
		stringBuilder.append("ButterflyRFCQMinAutomaticMatchingTimeout(").append(ButterflyRFCQMinAutomaticMatchingTimeout).append(")");
		stringBuilder.append("ButterflyRFCQAcceptanceTimeout(").append(ButterflyRFCQAcceptanceTimeout).append(")");
		stringBuilder.append("MultilegRFCQTimer(").append(MultilegRFCQTimer).append(")");
		stringBuilder.append("MultilegRFCQMaxNumRecipients(").append(MultilegRFCQMaxNumRecipients).append(")");
		stringBuilder.append("MultilegRFCQMinAutomaticMatchingTimeout(").append(MultilegRFCQMinAutomaticMatchingTimeout).append(")");
		stringBuilder.append("MultilegRFCQAcceptanceTimeout(").append(MultilegRFCQAcceptanceTimeout).append(")");
		stringBuilder.append("DoubleSidedRFCQTimer(").append(DoubleSidedRFCQTimer).append(")");
		stringBuilder.append("DoubleSidedRFCQMaxNumRecipients(").append(DoubleSidedRFCQMaxNumRecipients).append(")");
		stringBuilder.append("DoubleSidedRFCQMinAutomaticMatchingTimeout(").append(DoubleSidedRFCQMinAutomaticMatchingTimeout).append(")");
		stringBuilder.append("DoubleSidedRFCQAcceptanceTimeout(").append(DoubleSidedRFCQAcceptanceTimeout).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		return stringBuilder.toString();
	}
}
