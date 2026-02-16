package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_CALENDAR extends SMPMessage
{
	public static final long CLASS_ID = 100009;

	private long CalendarId = 0;
	private String CalendarDesc = "";

	public TI_CALENDAR()
	{
	}

	public long getCalendarId()
	{
		return CalendarId;
	}
	public void setCalendarId(long value)
	{
		CalendarId = value;
	}
	public String getCalendarDesc()
	{
		return CalendarDesc;
	}
	public void setCalendarDesc(String value)
	{
		CalendarDesc = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		CalendarId = (long)byteBuffer.readInt();
		CalendarDesc = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(CalendarId & 0xFFFFFFFFL));
		byteBuffer.writeString(CalendarDesc);

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
		stringBuilder.append("TI_CALENDAR::");
		stringBuilder.append("CalendarId(").append(CalendarId).append(")");
		stringBuilder.append("CalendarDesc(").append(CalendarDesc).append(")");
		return stringBuilder.toString();
	}
}
