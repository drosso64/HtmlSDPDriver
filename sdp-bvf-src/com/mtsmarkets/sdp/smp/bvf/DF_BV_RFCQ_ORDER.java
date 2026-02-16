package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class DF_BV_RFCQ_ORDER extends SMPMessage
{
	public static final long CLASS_ID = 114717;

	private BV_RFCQ_ORDER DFOrder = new BV_RFCQ_ORDER();

	public DF_BV_RFCQ_ORDER()
	{
	}

	public BV_RFCQ_ORDER getDFOrder()
	{
		return DFOrder;
	}
	public void setDFOrder(BV_RFCQ_ORDER value)
	{
		DFOrder = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		DFOrder.readXDR(byteBuffer);
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		DFOrder.writeXDR(byteBuffer);

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
		stringBuilder.append("DF_BV_RFCQ_ORDER::");
		stringBuilder.append("DFOrder(").append(DFOrder.toString()).append(")");
		return stringBuilder.toString();
	}
}
