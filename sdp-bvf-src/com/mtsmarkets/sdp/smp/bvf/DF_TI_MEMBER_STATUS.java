package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class DF_TI_MEMBER_STATUS extends SMPMessage
{
	public static final long CLASS_ID = 170002;

	private TI_MEMBER_STATUS DFMemberStatus = new TI_MEMBER_STATUS();

	public DF_TI_MEMBER_STATUS()
	{
	}

	public TI_MEMBER_STATUS getDFMemberStatus()
	{
		return DFMemberStatus;
	}
	public void setDFMemberStatus(TI_MEMBER_STATUS value)
	{
		DFMemberStatus = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		DFMemberStatus.readXDR(byteBuffer);
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		DFMemberStatus.writeXDR(byteBuffer);

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
		stringBuilder.append("DF_TI_MEMBER_STATUS::");
		stringBuilder.append("DFMemberStatus(").append(DFMemberStatus.toString()).append(")");
		return stringBuilder.toString();
	}
}
