package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class DF_BV_ORDER_STAGING extends SMPMessage
{
	public static final long CLASS_ID = 114716;

	private BV_ORDER_STAGING DFOrder = new BV_ORDER_STAGING();

	public DF_BV_ORDER_STAGING()
	{
	}

	public BV_ORDER_STAGING getDFOrder()
	{
		return DFOrder;
	}
	public void setDFOrder(BV_ORDER_STAGING value)
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
		stringBuilder.append("DF_BV_ORDER_STAGING::");
		stringBuilder.append("DFOrder(").append(DFOrder.toString()).append(")");
		return stringBuilder.toString();
	}
}
