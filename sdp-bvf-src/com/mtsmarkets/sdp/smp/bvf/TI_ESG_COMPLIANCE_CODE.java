package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_ESG_COMPLIANCE_CODE extends SMPMessage
{
	public static final long CLASS_ID = 100238;

	private String Code = "";
	private String Description = "";

	public TI_ESG_COMPLIANCE_CODE()
	{
	}

	public String getCode()
	{
		return Code;
	}
	public void setCode(String value)
	{
		Code = value;
	}
	public String getDescription()
	{
		return Description;
	}
	public void setDescription(String value)
	{
		Description = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		Code = byteBuffer.readString();
		Description = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeString(Code);
		byteBuffer.writeString(Description);

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
		stringBuilder.append("TI_ESG_COMPLIANCE_CODE::");
		stringBuilder.append("Code(").append(Code).append(")");
		stringBuilder.append("Description(").append(Description).append(")");
		return stringBuilder.toString();
	}
}
