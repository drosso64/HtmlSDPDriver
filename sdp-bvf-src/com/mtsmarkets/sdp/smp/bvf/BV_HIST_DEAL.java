package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_HIST_DEAL extends SMPMessage
{
	public static final long CLASS_ID = 114128;

	private BV_HIST_DEAL_INFO Deal = new BV_HIST_DEAL_INFO();

	public BV_HIST_DEAL()
	{
	}

	public BV_HIST_DEAL_INFO getDeal()
	{
		return Deal;
	}
	public void setDeal(BV_HIST_DEAL_INFO value)
	{
		Deal = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		Deal.readXDR(byteBuffer);
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		Deal.writeXDR(byteBuffer);

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
		stringBuilder.append("BV_HIST_DEAL::");
		stringBuilder.append("Deal(").append(Deal.toString()).append(")");
		return stringBuilder.toString();
	}
}
