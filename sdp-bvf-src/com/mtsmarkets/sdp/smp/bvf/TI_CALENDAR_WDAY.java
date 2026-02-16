package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_CALENDAR_WDAY extends SMPMessage
{
	public static final long CLASS_ID = 100010;

	private long CalendarId = 0;
	private TI_WEEK_DAY_Enum WeekendDay = TI_WEEK_DAY_Enum.TI_WEEK_DAY_Undefined;

	public TI_CALENDAR_WDAY()
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
	public TI_WEEK_DAY_Enum getWeekendDay()
	{
		return WeekendDay;
	}
	public void setWeekendDay(TI_WEEK_DAY_Enum value)
	{
		WeekendDay = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		CalendarId = (long)byteBuffer.readInt();
		WeekendDay = WeekendDay.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(CalendarId & 0xFFFFFFFFL));
		byteBuffer.writeInt(WeekendDay.getValue());

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
		stringBuilder.append("TI_CALENDAR_WDAY::");
		stringBuilder.append("CalendarId(").append(CalendarId).append(")");
		stringBuilder.append("WeekendDay(").append(WeekendDay).append(")");
		return stringBuilder.toString();
	}
}
