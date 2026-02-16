package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_CALLABLE_BOND extends SMPMessage
{
	public static final long CLASS_ID = 400016;

	private long FinancialInstrumentId = 0;
	private BV_CALL_TYPE_Enum CallType = BV_CALL_TYPE_Enum.BV_CALL_TYPE_OnSpecifiedDates;
	private short CallMinimumNotice = 0;
	private BV_NOTICE_DAY_TYPE_Enum NoticeDayType = BV_NOTICE_DAY_TYPE_Enum.BV_NOTICE_DAY_TYPE_BusinessDays;
	private BV_CALL_AMOUNT_TYPE_Enum CallAmountType = BV_CALL_AMOUNT_TYPE_Enum.BV_CALL_AMOUNT_TYPE_FullOnly;
	private TI_FLAG_Enum CallAnnouncementFg = TI_FLAG_Enum.TI_FLAG_No;

	public BV_CALLABLE_BOND()
	{
	}

	public long getFinancialInstrumentId()
	{
		return FinancialInstrumentId;
	}
	public void setFinancialInstrumentId(long value)
	{
		FinancialInstrumentId = value;
	}
	public BV_CALL_TYPE_Enum getCallType()
	{
		return CallType;
	}
	public void setCallType(BV_CALL_TYPE_Enum value)
	{
		CallType = value;
	}
	public short getCallMinimumNotice()
	{
		return CallMinimumNotice;
	}
	public void setCallMinimumNotice(short value)
	{
		CallMinimumNotice = value;
	}
	public BV_NOTICE_DAY_TYPE_Enum getNoticeDayType()
	{
		return NoticeDayType;
	}
	public void setNoticeDayType(BV_NOTICE_DAY_TYPE_Enum value)
	{
		NoticeDayType = value;
	}
	public BV_CALL_AMOUNT_TYPE_Enum getCallAmountType()
	{
		return CallAmountType;
	}
	public void setCallAmountType(BV_CALL_AMOUNT_TYPE_Enum value)
	{
		CallAmountType = value;
	}
	public TI_FLAG_Enum getCallAnnouncementFg()
	{
		return CallAnnouncementFg;
	}
	public void setCallAnnouncementFg(TI_FLAG_Enum value)
	{
		CallAnnouncementFg = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		FinancialInstrumentId = (long)byteBuffer.readInt();
		CallType = CallType.getEnum(byteBuffer.readInt());
		CallMinimumNotice = (short)byteBuffer.readInt();
		NoticeDayType = NoticeDayType.getEnum(byteBuffer.readInt());
		CallAmountType = CallAmountType.getEnum(byteBuffer.readInt());
		CallAnnouncementFg = CallAnnouncementFg.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(FinancialInstrumentId & 0xFFFFFFFFL));
		byteBuffer.writeInt(CallType.getValue());
		byteBuffer.writeInt((int)(CallMinimumNotice & 0xFFFFL));
		byteBuffer.writeInt(NoticeDayType.getValue());
		byteBuffer.writeInt(CallAmountType.getValue());
		byteBuffer.writeInt(CallAnnouncementFg.getValue());

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
		stringBuilder.append("BV_CALLABLE_BOND::");
		stringBuilder.append("FinancialInstrumentId(").append(FinancialInstrumentId).append(")");
		stringBuilder.append("CallType(").append(CallType).append(")");
		stringBuilder.append("CallMinimumNotice(").append(CallMinimumNotice).append(")");
		stringBuilder.append("NoticeDayType(").append(NoticeDayType).append(")");
		stringBuilder.append("CallAmountType(").append(CallAmountType).append(")");
		stringBuilder.append("CallAnnouncementFg(").append(CallAnnouncementFg).append(")");
		return stringBuilder.toString();
	}
}
