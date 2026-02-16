package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_FINANCIAL_CALCULATION extends SMPMessage
{
	public static final long CLASS_ID = 100070;

	private long FunctionId = 0;
	private String LabelCode = "";
	private String Description = "";

	public TI_FINANCIAL_CALCULATION()
	{
	}

	public long getFunctionId()
	{
		return FunctionId;
	}
	public void setFunctionId(long value)
	{
		FunctionId = value;
	}
	public String getLabelCode()
	{
		return LabelCode;
	}
	public void setLabelCode(String value)
	{
		LabelCode = value;
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
		FunctionId = (long)byteBuffer.readInt();
		LabelCode = byteBuffer.readString();
		Description = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(FunctionId & 0xFFFFFFFFL));
		byteBuffer.writeString(LabelCode);
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
		stringBuilder.append("TI_FINANCIAL_CALCULATION::");
		stringBuilder.append("FunctionId(").append(FunctionId).append(")");
		stringBuilder.append("LabelCode(").append(LabelCode).append(")");
		stringBuilder.append("Description(").append(Description).append(")");
		return stringBuilder.toString();
	}
}
