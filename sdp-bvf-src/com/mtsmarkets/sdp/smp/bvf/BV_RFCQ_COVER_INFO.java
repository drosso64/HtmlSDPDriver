package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_RFCQ_COVER_INFO extends SMPMessage
{
	public static final long CLASS_ID = 114937;

	private BV_RFCQ_COVER_Enum CoverDefinition = BV_RFCQ_COVER_Enum.BV_RFCQ_COVER_None;
	private double CoverValue = 0;

	public BV_RFCQ_COVER_INFO()
	{
	}

	public BV_RFCQ_COVER_Enum getCoverDefinition()
	{
		return CoverDefinition;
	}
	public void setCoverDefinition(BV_RFCQ_COVER_Enum value)
	{
		CoverDefinition = value;
	}
	public double getCoverValue()
	{
		return CoverValue;
	}
	public void setCoverValue(double value)
	{
		CoverValue = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		CoverDefinition = CoverDefinition.getEnum(byteBuffer.readInt());
		CoverValue = byteBuffer.readDouble();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt(CoverDefinition.getValue());
		byteBuffer.writeDouble(CoverValue);

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
		stringBuilder.append("BV_RFCQ_COVER_INFO::");
		stringBuilder.append("CoverDefinition(").append(CoverDefinition).append(")");
		stringBuilder.append("CoverValue(").append(CoverValue).append(")");
		return stringBuilder.toString();
	}
}
