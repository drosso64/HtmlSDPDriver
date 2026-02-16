package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_HIST_SALES_INFO extends SMPMessage
{
	public static final long CLASS_ID = 100914;

	private String TraderName = "";
	private String FirstName = "";
	private String LastName = "";

	public TI_HIST_SALES_INFO()
	{
	}

	public String getTraderName()
	{
		return TraderName;
	}
	public void setTraderName(String value)
	{
		TraderName = value;
	}
	public String getFirstName()
	{
		return FirstName;
	}
	public void setFirstName(String value)
	{
		FirstName = value;
	}
	public String getLastName()
	{
		return LastName;
	}
	public void setLastName(String value)
	{
		LastName = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		TraderName = byteBuffer.readString();
		FirstName = byteBuffer.readString();
		LastName = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeString(TraderName);
		byteBuffer.writeString(FirstName);
		byteBuffer.writeString(LastName);

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
		stringBuilder.append("TI_HIST_SALES_INFO::");
		stringBuilder.append("TraderName(").append(TraderName).append(")");
		stringBuilder.append("FirstName(").append(FirstName).append(")");
		stringBuilder.append("LastName(").append(LastName).append(")");
		return stringBuilder.toString();
	}
}
