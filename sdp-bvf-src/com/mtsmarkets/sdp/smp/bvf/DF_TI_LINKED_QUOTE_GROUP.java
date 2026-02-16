package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class DF_TI_LINKED_QUOTE_GROUP extends SMPMessage
{
	public static final long CLASS_ID = 170011;

	private TI_LINKED_QUOTE_GROUP DFLQGrp = new TI_LINKED_QUOTE_GROUP();

	public DF_TI_LINKED_QUOTE_GROUP()
	{
	}

	public TI_LINKED_QUOTE_GROUP getDFLQGrp()
	{
		return DFLQGrp;
	}
	public void setDFLQGrp(TI_LINKED_QUOTE_GROUP value)
	{
		DFLQGrp = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		DFLQGrp.readXDR(byteBuffer);
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		DFLQGrp.writeXDR(byteBuffer);

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
		stringBuilder.append("DF_TI_LINKED_QUOTE_GROUP::");
		stringBuilder.append("DFLQGrp(").append(DFLQGrp.toString()).append(")");
		return stringBuilder.toString();
	}
}
