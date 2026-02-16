package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_IP_ADDRESS_INFO extends SMPMessage
{
	public static final long CLASS_ID = 100902;

	private String Address = "";

	public TI_IP_ADDRESS_INFO()
	{
	}

	public String getAddress()
	{
		return Address;
	}
	public void setAddress(String value)
	{
		Address = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		Address = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeString(Address);

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
		stringBuilder.append("TI_IP_ADDRESS_INFO::");
		stringBuilder.append("Address(").append(Address).append(")");
		return stringBuilder.toString();
	}
}
