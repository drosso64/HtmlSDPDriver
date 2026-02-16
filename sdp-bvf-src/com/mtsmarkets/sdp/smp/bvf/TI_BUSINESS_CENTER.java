package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_BUSINESS_CENTER extends SMPMessage
{
	public static final long CLASS_ID = 100039;

	private String BusinessCenterId = "";
	private String BusinessCenterDes = "";

	public TI_BUSINESS_CENTER()
	{
	}

	public String getBusinessCenterId()
	{
		return BusinessCenterId;
	}
	public void setBusinessCenterId(String value)
	{
		BusinessCenterId = value;
	}
	public String getBusinessCenterDes()
	{
		return BusinessCenterDes;
	}
	public void setBusinessCenterDes(String value)
	{
		BusinessCenterDes = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		BusinessCenterId = byteBuffer.readString();
		BusinessCenterDes = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeString(BusinessCenterId);
		byteBuffer.writeString(BusinessCenterDes);

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
		stringBuilder.append("TI_BUSINESS_CENTER::");
		stringBuilder.append("BusinessCenterId(").append(BusinessCenterId).append(")");
		stringBuilder.append("BusinessCenterDes(").append(BusinessCenterDes).append(")");
		return stringBuilder.toString();
	}
}
