package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_YIELD_TYPE extends SMPMessage
{
	public static final long CLASS_ID = 100082;

	private long YieldTypeId = 0;
	private String Label = "";
	private String Description = "";

	public TI_YIELD_TYPE()
	{
	}

	public long getYieldTypeId()
	{
		return YieldTypeId;
	}
	public void setYieldTypeId(long value)
	{
		YieldTypeId = value;
	}
	public String getLabel()
	{
		return Label;
	}
	public void setLabel(String value)
	{
		Label = value;
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
		YieldTypeId = (long)byteBuffer.readInt();
		Label = byteBuffer.readString();
		Description = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(YieldTypeId & 0xFFFFFFFFL));
		byteBuffer.writeString(Label);
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
		stringBuilder.append("TI_YIELD_TYPE::");
		stringBuilder.append("YieldTypeId(").append(YieldTypeId).append(")");
		stringBuilder.append("Label(").append(Label).append(")");
		stringBuilder.append("Description(").append(Description).append(")");
		return stringBuilder.toString();
	}
}
