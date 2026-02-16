package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_LAST_DAY_RFCQ_SELL_SIDE_SUMMARY extends SMPMessage
{
	public static final long CLASS_ID = 114303;

	private BV_HIST_RFCQ_SELL_SIDE_SUMMARY_INFO Summary = new BV_HIST_RFCQ_SELL_SIDE_SUMMARY_INFO();

	public BV_LAST_DAY_RFCQ_SELL_SIDE_SUMMARY()
	{
	}

	public BV_HIST_RFCQ_SELL_SIDE_SUMMARY_INFO getSummary()
	{
		return Summary;
	}
	public void setSummary(BV_HIST_RFCQ_SELL_SIDE_SUMMARY_INFO value)
	{
		Summary = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		Summary.readXDR(byteBuffer);
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		Summary.writeXDR(byteBuffer);

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
		stringBuilder.append("BV_LAST_DAY_RFCQ_SELL_SIDE_SUMMARY::");
		stringBuilder.append("Summary(").append(Summary.toString()).append(")");
		return stringBuilder.toString();
	}
}
