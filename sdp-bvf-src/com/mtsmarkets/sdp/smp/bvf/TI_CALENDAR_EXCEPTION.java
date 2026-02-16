package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_CALENDAR_EXCEPTION extends SMPMessage
{
	public static final long CLASS_ID = 100016;

	private long CalendarId = 0;
	private long ExceptionDate = 0;
	private TI_CALENDAR_EXCEPTION_TYPE_Enum ExceptionType = TI_CALENDAR_EXCEPTION_TYPE_Enum.TI_CALENDAR_EXCEPTION_TYPE_Holiday;
	private TI_FLAG_Enum RollingFlag = TI_FLAG_Enum.TI_FLAG_No;

	public TI_CALENDAR_EXCEPTION()
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
	public long getExceptionDate()
	{
		return ExceptionDate;
	}
	public void setExceptionDate(long value)
	{
		ExceptionDate = value;
	}
	public TI_CALENDAR_EXCEPTION_TYPE_Enum getExceptionType()
	{
		return ExceptionType;
	}
	public void setExceptionType(TI_CALENDAR_EXCEPTION_TYPE_Enum value)
	{
		ExceptionType = value;
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
		ExceptionDate = (long)byteBuffer.readInt();
		ExceptionType = ExceptionType.getEnum(byteBuffer.readInt());
		RollingFlag = RollingFlag.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(CalendarId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(ExceptionDate & 0xFFFFFFFFL));
		byteBuffer.writeInt(ExceptionType.getValue());
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
		stringBuilder.append("TI_CALENDAR_EXCEPTION::");
		stringBuilder.append("CalendarId(").append(CalendarId).append(")");
		stringBuilder.append("ExceptionDate(").append(ExceptionDate).append(")");
		stringBuilder.append("ExceptionType(").append(ExceptionType).append(")");
		stringBuilder.append("RollingFlag(").append(RollingFlag).append(")");
		return stringBuilder.toString();
	}
}
