package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_LEI_CODE_X_AREA_CODE extends SMPMessage
{
	public static final long CLASS_ID = 400039;

	private long MemberId = 0;
	private short AreaCodeId = 0;
	private String LeiCode = "";

	public BV_LEI_CODE_X_AREA_CODE()
	{
	}

	public long getMemberId()
	{
		return MemberId;
	}
	public void setMemberId(long value)
	{
		MemberId = value;
	}
	public short getAreaCodeId()
	{
		return AreaCodeId;
	}
	public void setAreaCodeId(short value)
	{
		AreaCodeId = value;
	}
	public String getLeiCode()
	{
		return LeiCode;
	}
	public void setLeiCode(String value)
	{
		LeiCode = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MemberId = (long)byteBuffer.readInt();
		AreaCodeId = (short)byteBuffer.readInt();
		LeiCode = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(AreaCodeId & 0xFFFFL));
		byteBuffer.writeString(LeiCode);

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
		stringBuilder.append("BV_LEI_CODE_X_AREA_CODE::");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("AreaCodeId(").append(AreaCodeId).append(")");
		stringBuilder.append("LeiCode(").append(LeiCode).append(")");
		return stringBuilder.toString();
	}
}
