package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class GOV_TI_TRADER_MARKET_ACCESS_RIGHT extends SMPMessage
{
	public static final long CLASS_ID = 100852;

	private TI_TRADER_MARKET_ACCESS_RIGHT Info = new TI_TRADER_MARKET_ACCESS_RIGHT();
	private TI_FLAG_Enum PendingFg = TI_FLAG_Enum.TI_FLAG_No;

	public GOV_TI_TRADER_MARKET_ACCESS_RIGHT()
	{
	}

	public TI_TRADER_MARKET_ACCESS_RIGHT getInfo()
	{
		return Info;
	}
	public void setInfo(TI_TRADER_MARKET_ACCESS_RIGHT value)
	{
		Info = value;
	}
	public TI_FLAG_Enum getPendingFg()
	{
		return PendingFg;
	}
	public void setPendingFg(TI_FLAG_Enum value)
	{
		PendingFg = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		Info.readXDR(byteBuffer);
		PendingFg = PendingFg.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		Info.writeXDR(byteBuffer);
		byteBuffer.writeInt(PendingFg.getValue());

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
		stringBuilder.append("GOV_TI_TRADER_MARKET_ACCESS_RIGHT::");
		stringBuilder.append("Info(").append(Info.toString()).append(")");
		stringBuilder.append("PendingFg(").append(PendingFg).append(")");
		return stringBuilder.toString();
	}
}
