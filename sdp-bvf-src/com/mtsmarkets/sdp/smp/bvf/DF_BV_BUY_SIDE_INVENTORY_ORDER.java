package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class DF_BV_BUY_SIDE_INVENTORY_ORDER extends SMPMessage
{
	public static final long CLASS_ID = 114601;

	private BV_BUY_SIDE_INVENTORY_ORDER DFOr = new BV_BUY_SIDE_INVENTORY_ORDER();

	public DF_BV_BUY_SIDE_INVENTORY_ORDER()
	{
	}

	public BV_BUY_SIDE_INVENTORY_ORDER getDFOr()
	{
		return DFOr;
	}
	public void setDFOr(BV_BUY_SIDE_INVENTORY_ORDER value)
	{
		DFOr = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		DFOr.readXDR(byteBuffer);
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		DFOr.writeXDR(byteBuffer);

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
		stringBuilder.append("DF_BV_BUY_SIDE_INVENTORY_ORDER::");
		stringBuilder.append("DFOr(").append(DFOr.toString()).append(")");
		return stringBuilder.toString();
	}
}
