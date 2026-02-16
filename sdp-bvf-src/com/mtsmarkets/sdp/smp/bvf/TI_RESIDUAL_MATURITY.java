package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_RESIDUAL_MATURITY extends SMPMessage
{
	public static final long CLASS_ID = 100014;

	private long ResidualMaturityId = 0;
	private short Days = 0;
	private String ResidualMaturityDesc = "";

	public TI_RESIDUAL_MATURITY()
	{
	}

	public long getResidualMaturityId()
	{
		return ResidualMaturityId;
	}
	public void setResidualMaturityId(long value)
	{
		ResidualMaturityId = value;
	}
	public short getDays()
	{
		return Days;
	}
	public void setDays(short value)
	{
		Days = value;
	}
	public String getResidualMaturityDesc()
	{
		return ResidualMaturityDesc;
	}
	public void setResidualMaturityDesc(String value)
	{
		ResidualMaturityDesc = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		ResidualMaturityId = (long)byteBuffer.readInt();
		Days = (short)byteBuffer.readInt();
		ResidualMaturityDesc = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(ResidualMaturityId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(Days & 0xFFFFL));
		byteBuffer.writeString(ResidualMaturityDesc);

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
		stringBuilder.append("TI_RESIDUAL_MATURITY::");
		stringBuilder.append("ResidualMaturityId(").append(ResidualMaturityId).append(")");
		stringBuilder.append("Days(").append(Days).append(")");
		stringBuilder.append("ResidualMaturityDesc(").append(ResidualMaturityDesc).append(")");
		return stringBuilder.toString();
	}
}
