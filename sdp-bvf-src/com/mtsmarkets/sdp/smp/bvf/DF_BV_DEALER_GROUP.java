package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class DF_BV_DEALER_GROUP extends SMPMessage
{
	public static final long CLASS_ID = 170048;

	private BV_DEALER_GROUP DFBVDealerGroup = new BV_DEALER_GROUP();

	public DF_BV_DEALER_GROUP()
	{
	}

	public BV_DEALER_GROUP getDFBVDealerGroup()
	{
		return DFBVDealerGroup;
	}
	public void setDFBVDealerGroup(BV_DEALER_GROUP value)
	{
		DFBVDealerGroup = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		DFBVDealerGroup.readXDR(byteBuffer);
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		DFBVDealerGroup.writeXDR(byteBuffer);

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
		stringBuilder.append("DF_BV_DEALER_GROUP::");
		stringBuilder.append("DFBVDealerGroup(").append(DFBVDealerGroup.toString()).append(")");
		return stringBuilder.toString();
	}
}
