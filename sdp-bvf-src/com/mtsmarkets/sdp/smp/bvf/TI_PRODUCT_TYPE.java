package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_PRODUCT_TYPE extends SMPMessage
{
	public static final long CLASS_ID = 100208;

	private long ProductTypeId = 0;
	private String Code = "";
	private String Description = "";

	public TI_PRODUCT_TYPE()
	{
	}

	public long getProductTypeId()
	{
		return ProductTypeId;
	}
	public void setProductTypeId(long value)
	{
		ProductTypeId = value;
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
		ProductTypeId = (long)byteBuffer.readInt();
		Code = byteBuffer.readString();
		Description = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(ProductTypeId & 0xFFFFFFFFL));
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
		stringBuilder.append("TI_PRODUCT_TYPE::");
		stringBuilder.append("ProductTypeId(").append(ProductTypeId).append(")");
		stringBuilder.append("Code(").append(Code).append(")");
		stringBuilder.append("Description(").append(Description).append(")");
		return stringBuilder.toString();
	}
}
