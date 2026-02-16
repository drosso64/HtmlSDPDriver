package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class DF_BV_INVENTORY_QUOTE_13 extends SMPMessage
{
	public static final long CLASS_ID = 314783;

	private BV_INVENTORY_QUOTE DFP = new BV_INVENTORY_QUOTE();

	public DF_BV_INVENTORY_QUOTE_13()
	{
	}

	public BV_INVENTORY_QUOTE getDFP()
	{
		return DFP;
	}
	public void setDFP(BV_INVENTORY_QUOTE value)
	{
		DFP = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		DFP.readXDR(byteBuffer);
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		DFP.writeXDR(byteBuffer);

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
		stringBuilder.append("DF_BV_INVENTORY_QUOTE_13::");
		stringBuilder.append("DFP(").append(DFP.toString()).append(")");
		return stringBuilder.toString();
	}
}
