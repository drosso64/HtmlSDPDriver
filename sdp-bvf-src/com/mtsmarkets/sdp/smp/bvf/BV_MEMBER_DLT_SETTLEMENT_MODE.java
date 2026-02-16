package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_MEMBER_DLT_SETTLEMENT_MODE extends SMPMessage
{
	public static final long CLASS_ID = 400060;

	private long MemberId = 0;
	private long TradableInstrumentId = 0;
	private BV_SETTLEMENT_MODE_Enum SettlementMode = BV_SETTLEMENT_MODE_Enum.BV_SETTLEMENT_MODE_Any;
	private long StdSettlementGroupId = 0;
	private long StdSettlementSystemId = 0;
	private long DLTSettlementGroupId = 0;
	private long DLTSettlementSystemId = 0;

	public BV_MEMBER_DLT_SETTLEMENT_MODE()
	{
	}

	public long getMemberId()
	{
		return MemberId;
	}
	public void setMemberId(long value)
	{
		MemberId = value;
	}
	public long getTradableInstrumentId()
	{
		return TradableInstrumentId;
	}
	public void setTradableInstrumentId(long value)
	{
		TradableInstrumentId = value;
	}
	public BV_SETTLEMENT_MODE_Enum getSettlementMode()
	{
		return SettlementMode;
	}
	public void setSettlementMode(BV_SETTLEMENT_MODE_Enum value)
	{
		SettlementMode = value;
	}
	public long getStdSettlementGroupId()
	{
		return StdSettlementGroupId;
	}
	public void setStdSettlementGroupId(long value)
	{
		StdSettlementGroupId = value;
	}
	public long getStdSettlementSystemId()
	{
		return StdSettlementSystemId;
	}
	public void setStdSettlementSystemId(long value)
	{
		StdSettlementSystemId = value;
	}
	public long getDLTSettlementGroupId()
	{
		return DLTSettlementGroupId;
	}
	public void setDLTSettlementGroupId(long value)
	{
		DLTSettlementGroupId = value;
	}
	public long getDLTSettlementSystemId()
	{
		return DLTSettlementSystemId;
	}
	public void setDLTSettlementSystemId(long value)
	{
		DLTSettlementSystemId = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MemberId = (long)byteBuffer.readInt();
		TradableInstrumentId = (long)byteBuffer.readInt();
		SettlementMode = SettlementMode.getEnum(byteBuffer.readInt());
		StdSettlementGroupId = (long)byteBuffer.readInt();
		StdSettlementSystemId = (long)byteBuffer.readInt();
		DLTSettlementGroupId = (long)byteBuffer.readInt();
		DLTSettlementSystemId = (long)byteBuffer.readInt();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(TradableInstrumentId & 0xFFFFFFFFL));
		byteBuffer.writeInt(SettlementMode.getValue());
		byteBuffer.writeInt((int)(StdSettlementGroupId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(StdSettlementSystemId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(DLTSettlementGroupId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(DLTSettlementSystemId & 0xFFFFFFFFL));

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
		stringBuilder.append("BV_MEMBER_DLT_SETTLEMENT_MODE::");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("TradableInstrumentId(").append(TradableInstrumentId).append(")");
		stringBuilder.append("SettlementMode(").append(SettlementMode).append(")");
		stringBuilder.append("StdSettlementGroupId(").append(StdSettlementGroupId).append(")");
		stringBuilder.append("StdSettlementSystemId(").append(StdSettlementSystemId).append(")");
		stringBuilder.append("DLTSettlementGroupId(").append(DLTSettlementGroupId).append(")");
		stringBuilder.append("DLTSettlementSystemId(").append(DLTSettlementSystemId).append(")");
		return stringBuilder.toString();
	}
}
