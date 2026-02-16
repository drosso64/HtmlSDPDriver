package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_BUY_SIDE_ALLOCATION_REPORT extends SMPMessage
{
	public static final long CLASS_ID = 400054;

	private BV_ALLOCATION_REPORT_INFO Report = new BV_ALLOCATION_REPORT_INFO();

	public BV_BUY_SIDE_ALLOCATION_REPORT()
	{
	}

	public BV_ALLOCATION_REPORT_INFO getReport()
	{
		return Report;
	}
	public void setReport(BV_ALLOCATION_REPORT_INFO value)
	{
		Report = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		Report.readXDR(byteBuffer);
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		Report.writeXDR(byteBuffer);

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
		stringBuilder.append("BV_BUY_SIDE_ALLOCATION_REPORT::");
		stringBuilder.append("Report(").append(Report.toString()).append(")");
		return stringBuilder.toString();
	}
}
