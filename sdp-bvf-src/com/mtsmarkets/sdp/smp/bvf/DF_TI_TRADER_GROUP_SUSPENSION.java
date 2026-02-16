package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class DF_TI_TRADER_GROUP_SUSPENSION extends SMPMessage
{
	public static final long CLASS_ID = 170009;

	private TI_TRADER_GROUP_SUSPENSION DFTraderGroupSusp = new TI_TRADER_GROUP_SUSPENSION();

	public DF_TI_TRADER_GROUP_SUSPENSION()
	{
	}

	public TI_TRADER_GROUP_SUSPENSION getDFTraderGroupSusp()
	{
		return DFTraderGroupSusp;
	}
	public void setDFTraderGroupSusp(TI_TRADER_GROUP_SUSPENSION value)
	{
		DFTraderGroupSusp = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		DFTraderGroupSusp.readXDR(byteBuffer);
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		DFTraderGroupSusp.writeXDR(byteBuffer);

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
		stringBuilder.append("DF_TI_TRADER_GROUP_SUSPENSION::");
		stringBuilder.append("DFTraderGroupSusp(").append(DFTraderGroupSusp.toString()).append(")");
		return stringBuilder.toString();
	}
}
