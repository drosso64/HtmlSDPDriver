package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class DF_TI_TRADER extends SMPMessage
{
	public static final long CLASS_ID = 170006;

	private TI_TRADER DFTrader = new TI_TRADER();

	public DF_TI_TRADER()
	{
	}

	public TI_TRADER getDFTrader()
	{
		return DFTrader;
	}
	public void setDFTrader(TI_TRADER value)
	{
		DFTrader = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		DFTrader.readXDR(byteBuffer);
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		DFTrader.writeXDR(byteBuffer);

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
		stringBuilder.append("DF_TI_TRADER::");
		stringBuilder.append("DFTrader(").append(DFTrader.toString()).append(")");
		return stringBuilder.toString();
	}
}
