package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_CALENDAR_HOLIDAY extends SMPMessage
{
	public static final long CLASS_ID = 100011;

	private long CalendarId = 0;
	private long HolidayDate = 0;
	private TI_FLAG_Enum RollingFlag = TI_FLAG_Enum.TI_FLAG_No;

	public TI_CALENDAR_HOLIDAY()
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
	public long getHolidayDate()
	{
		return HolidayDate;
	}
	public void setHolidayDate(long value)
	{
		HolidayDate = value;
	}
	public TI_FLAG_Enum getRollingFlag()
	{
		return RollingFlag;
	}
	public void setRollingFlag(TI_FLAG_Enum value)
	{
		RollingFlag = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		CalendarId = (long)byteBuffer.readInt();
		HolidayDate = (long)byteBuffer.readInt();
		RollingFlag = RollingFlag.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(CalendarId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(HolidayDate & 0xFFFFFFFFL));
		byteBuffer.writeInt(RollingFlag.getValue());

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
		stringBuilder.append("TI_CALENDAR_HOLIDAY::");
		stringBuilder.append("CalendarId(").append(CalendarId).append(")");
		stringBuilder.append("HolidayDate(").append(HolidayDate).append(")");
		stringBuilder.append("RollingFlag(").append(RollingFlag).append(")");
		return stringBuilder.toString();
	}
}
