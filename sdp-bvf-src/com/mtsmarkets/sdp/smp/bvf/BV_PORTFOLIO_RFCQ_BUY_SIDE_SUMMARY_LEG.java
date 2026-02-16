package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_PORTFOLIO_RFCQ_BUY_SIDE_SUMMARY_LEG extends SMPMessage
{
	public static final long CLASS_ID = 400086;

	private BV_PORTFOLIO_RFCQ_BUY_SIDE_SUMMARY_LEG_INFO LegSummary = new BV_PORTFOLIO_RFCQ_BUY_SIDE_SUMMARY_LEG_INFO();

	public BV_PORTFOLIO_RFCQ_BUY_SIDE_SUMMARY_LEG()
	{
	}

	public BV_PORTFOLIO_RFCQ_BUY_SIDE_SUMMARY_LEG_INFO getLegSummary()
	{
		return LegSummary;
	}
	public void setLegSummary(BV_PORTFOLIO_RFCQ_BUY_SIDE_SUMMARY_LEG_INFO value)
	{
		LegSummary = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		LegSummary.readXDR(byteBuffer);
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		LegSummary.writeXDR(byteBuffer);

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
		stringBuilder.append("BV_PORTFOLIO_RFCQ_BUY_SIDE_SUMMARY_LEG::");
		stringBuilder.append("LegSummary(").append(LegSummary.toString()).append(")");
		return stringBuilder.toString();
	}
}
