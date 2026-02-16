package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_SETTL_ERROR_CODE extends SMPMessage
{
	public static final long CLASS_ID = 100913;

	private String ErrorCode = "";
	private String ErrorInfo = "";

	public TI_SETTL_ERROR_CODE()
	{
	}

	public String getErrorCode()
	{
		return ErrorCode;
	}
	public void setErrorCode(String value)
	{
		ErrorCode = value;
	}
	public String getErrorInfo()
	{
		return ErrorInfo;
	}
	public void setErrorInfo(String value)
	{
		ErrorInfo = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		ErrorCode = byteBuffer.readString();
		ErrorInfo = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeString(ErrorCode);
		byteBuffer.writeString(ErrorInfo);

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
		stringBuilder.append("TI_SETTL_ERROR_CODE::");
		stringBuilder.append("ErrorCode(").append(ErrorCode).append(")");
		stringBuilder.append("ErrorInfo(").append(ErrorInfo).append(")");
		return stringBuilder.toString();
	}
}
