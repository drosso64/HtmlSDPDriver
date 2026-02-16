package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class DF_BV_RFCQ_AUTO_EXECUTION_RULE extends SMPMessage
{
	public static final long CLASS_ID = 170045;

	private BV_RFCQ_AUTO_EXECUTION_RULE DFRFCQAutoExecutionRule = new BV_RFCQ_AUTO_EXECUTION_RULE();

	public DF_BV_RFCQ_AUTO_EXECUTION_RULE()
	{
	}

	public BV_RFCQ_AUTO_EXECUTION_RULE getDFRFCQAutoExecutionRule()
	{
		return DFRFCQAutoExecutionRule;
	}
	public void setDFRFCQAutoExecutionRule(BV_RFCQ_AUTO_EXECUTION_RULE value)
	{
		DFRFCQAutoExecutionRule = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		DFRFCQAutoExecutionRule.readXDR(byteBuffer);
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		DFRFCQAutoExecutionRule.writeXDR(byteBuffer);

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
		stringBuilder.append("DF_BV_RFCQ_AUTO_EXECUTION_RULE::");
		stringBuilder.append("DFRFCQAutoExecutionRule(").append(DFRFCQAutoExecutionRule.toString()).append(")");
		return stringBuilder.toString();
	}
}
