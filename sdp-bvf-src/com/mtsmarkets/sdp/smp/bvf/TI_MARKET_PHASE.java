package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_MARKET_PHASE extends SMPMessage
{
	public static final long CLASS_ID = 100005;

	private long MarketId = 0;
	private TI_PHASE_Enum Phase = TI_PHASE_Enum.TI_PHASE_SystemDown;
	private String MarketPhaseDesc = "";

	public TI_MARKET_PHASE()
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
	public TI_PHASE_Enum getPhase()
	{
		return Phase;
	}
	public void setPhase(TI_PHASE_Enum value)
	{
		Phase = value;
	}
	public String getMarketPhaseDesc()
	{
		return MarketPhaseDesc;
	}
	public void setMarketPhaseDesc(String value)
	{
		MarketPhaseDesc = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MarketId = (long)byteBuffer.readInt();
		Phase = Phase.getEnum(byteBuffer.readInt());
		MarketPhaseDesc = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MarketId & 0xFFFFFFFFL));
		byteBuffer.writeInt(Phase.getValue());
		byteBuffer.writeString(MarketPhaseDesc);

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
		stringBuilder.append("TI_MARKET_PHASE::");
		stringBuilder.append("MarketId(").append(MarketId).append(")");
		stringBuilder.append("Phase(").append(Phase).append(")");
		stringBuilder.append("MarketPhaseDesc(").append(MarketPhaseDesc).append(")");
		return stringBuilder.toString();
	}
}
