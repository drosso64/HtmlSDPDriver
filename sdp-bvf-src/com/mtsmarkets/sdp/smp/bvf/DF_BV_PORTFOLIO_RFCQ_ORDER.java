package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class DF_BV_PORTFOLIO_RFCQ_ORDER extends SMPMessage
{
	public static final long CLASS_ID = 170056;

	private BV_PORTFOLIO_RFCQ_ORDER DFRfcqOrder = new BV_PORTFOLIO_RFCQ_ORDER();

	public DF_BV_PORTFOLIO_RFCQ_ORDER()
	{
	}

	public BV_PORTFOLIO_RFCQ_ORDER getDFRfcqOrder()
	{
		return DFRfcqOrder;
	}
	public void setDFRfcqOrder(BV_PORTFOLIO_RFCQ_ORDER value)
	{
		DFRfcqOrder = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		DFRfcqOrder.readXDR(byteBuffer);
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		DFRfcqOrder.writeXDR(byteBuffer);

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
		stringBuilder.append("DF_BV_PORTFOLIO_RFCQ_ORDER::");
		stringBuilder.append("DFRfcqOrder(").append(DFRfcqOrder.toString()).append(")");
		return stringBuilder.toString();
	}
}
