package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_MWC_BOND extends SMPMessage
{
	public static final long CLASS_ID = 400019;

	private long FinancialInstrumentId = 0;
	private long TerminationDate = 0;
	private double Margin = 0;
	private long BenchmarkId = 0;
	private short MinimumNotice = 0;
	private BV_NOTICE_DAY_TYPE_Enum NoticeDayType = BV_NOTICE_DAY_TYPE_Enum.BV_NOTICE_DAY_TYPE_BusinessDays;
	private TI_BUSINESS_DAY_CONV_Enum BusinessDayConvention = TI_BUSINESS_DAY_CONV_Enum.TI_BUSINESS_DAY_CONV_None;
	private TI_FLAG_Enum CallAnnouncementFg = TI_FLAG_Enum.TI_FLAG_No;

	public BV_MWC_BOND()
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
	public long getTerminationDate()
	{
		return TerminationDate;
	}
	public void setTerminationDate(long value)
	{
		TerminationDate = value;
	}
	public double getMargin()
	{
		return Margin;
	}
	public void setMargin(double value)
	{
		Margin = value;
	}
	public long getBenchmarkId()
	{
		return BenchmarkId;
	}
	public void setBenchmarkId(long value)
	{
		BenchmarkId = value;
	}
	public short getMinimumNotice()
	{
		return MinimumNotice;
	}
	public void setMinimumNotice(short value)
	{
		MinimumNotice = value;
	}
	public BV_NOTICE_DAY_TYPE_Enum getNoticeDayType()
	{
		return NoticeDayType;
	}
	public void setNoticeDayType(BV_NOTICE_DAY_TYPE_Enum value)
	{
		NoticeDayType = value;
	}
	public TI_BUSINESS_DAY_CONV_Enum getBusinessDayConvention()
	{
		return BusinessDayConvention;
	}
	public void setBusinessDayConvention(TI_BUSINESS_DAY_CONV_Enum value)
	{
		BusinessDayConvention = value;
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
		TerminationDate = (long)byteBuffer.readInt();
		Margin = byteBuffer.readDouble();
		BenchmarkId = (long)byteBuffer.readInt();
		MinimumNotice = (short)byteBuffer.readInt();
		NoticeDayType = NoticeDayType.getEnum(byteBuffer.readInt());
		BusinessDayConvention = BusinessDayConvention.getEnum(byteBuffer.readInt());
		CallAnnouncementFg = CallAnnouncementFg.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(FinancialInstrumentId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(TerminationDate & 0xFFFFFFFFL));
		byteBuffer.writeDouble(Margin);
		byteBuffer.writeInt((int)(BenchmarkId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(MinimumNotice & 0xFFFFL));
		byteBuffer.writeInt(NoticeDayType.getValue());
		byteBuffer.writeInt(BusinessDayConvention.getValue());
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
		stringBuilder.append("BV_MWC_BOND::");
		stringBuilder.append("FinancialInstrumentId(").append(FinancialInstrumentId).append(")");
		stringBuilder.append("TerminationDate(").append(TerminationDate).append(")");
		stringBuilder.append("Margin(").append(Margin).append(")");
		stringBuilder.append("BenchmarkId(").append(BenchmarkId).append(")");
		stringBuilder.append("MinimumNotice(").append(MinimumNotice).append(")");
		stringBuilder.append("NoticeDayType(").append(NoticeDayType).append(")");
		stringBuilder.append("BusinessDayConvention(").append(BusinessDayConvention).append(")");
		stringBuilder.append("CallAnnouncementFg(").append(CallAnnouncementFg).append(")");
		return stringBuilder.toString();
	}
}
