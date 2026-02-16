package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_TIME_ZONE extends SMPMessage
{
	public static final long CLASS_ID = 100923;

	private TI_UTC_Enum UTC = TI_UTC_Enum.TI_UTC_None;
	private TI_FLAG_Enum DSTFg = TI_FLAG_Enum.TI_FLAG_No;
	private int TimeZoneOffset = 0;

	public TI_TIME_ZONE()
	{
	}

	public TI_UTC_Enum getUTC()
	{
		return UTC;
	}
	public void setUTC(TI_UTC_Enum value)
	{
		UTC = value;
	}
	public TI_FLAG_Enum getDSTFg()
	{
		return DSTFg;
	}
	public void setDSTFg(TI_FLAG_Enum value)
	{
		DSTFg = value;
	}
	public int getTimeZoneOffset()
	{
		return TimeZoneOffset;
	}
	public void setTimeZoneOffset(int value)
	{
		TimeZoneOffset = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		UTC = UTC.getEnum(byteBuffer.readInt());
		DSTFg = DSTFg.getEnum(byteBuffer.readInt());
		TimeZoneOffset = (int)byteBuffer.readInt();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt(UTC.getValue());
		byteBuffer.writeInt(DSTFg.getValue());
		byteBuffer.writeInt((int)(TimeZoneOffset & 0xFFFFFFFFL));

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
		stringBuilder.append("TI_TIME_ZONE::");
		stringBuilder.append("UTC(").append(UTC).append(")");
		stringBuilder.append("DSTFg(").append(DSTFg).append(")");
		stringBuilder.append("TimeZoneOffset(").append(TimeZoneOffset).append(")");
		return stringBuilder.toString();
	}
}
