package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class DF_BV_MIFID_DEFAULT_INFO extends SMPMessage
{
	public static final long CLASS_ID = 170049;

	private BV_MIFID_DEFAULT_INFO DFBVMiFIDDefaultInfo = new BV_MIFID_DEFAULT_INFO();

	public DF_BV_MIFID_DEFAULT_INFO()
	{
	}

	public BV_MIFID_DEFAULT_INFO getDFBVMiFIDDefaultInfo()
	{
		return DFBVMiFIDDefaultInfo;
	}
	public void setDFBVMiFIDDefaultInfo(BV_MIFID_DEFAULT_INFO value)
	{
		DFBVMiFIDDefaultInfo = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		DFBVMiFIDDefaultInfo.readXDR(byteBuffer);
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		DFBVMiFIDDefaultInfo.writeXDR(byteBuffer);

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
		stringBuilder.append("DF_BV_MIFID_DEFAULT_INFO::");
		stringBuilder.append("DFBVMiFIDDefaultInfo(").append(DFBVMiFIDDefaultInfo.toString()).append(")");
		return stringBuilder.toString();
	}
}
