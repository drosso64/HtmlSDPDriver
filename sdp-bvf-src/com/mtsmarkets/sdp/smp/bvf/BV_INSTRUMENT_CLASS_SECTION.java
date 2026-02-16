package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_INSTRUMENT_CLASS_SECTION extends SMPMessage
{
	public static final long CLASS_ID = 100021;

	private long SectionId = 0;
	private long InstrumentClassId = 0;
	private long SortNumber = 0;
	private long StartDate = 0;
	private long StopDate = 0;
	private TI_FLAG_Enum RFCQStatisticFlag = TI_FLAG_Enum.TI_FLAG_No;
	private TI_FLAG_Enum RFCQLastTradeFlag = TI_FLAG_Enum.TI_FLAG_No;
	private TI_FLAG_Enum RFCQOfficialPriceFlag = TI_FLAG_Enum.TI_FLAG_No;
	private TI_FLAG_Enum IOStatisticFlag = TI_FLAG_Enum.TI_FLAG_No;
	private TI_FLAG_Enum IOLastTradeFlag = TI_FLAG_Enum.TI_FLAG_No;
	private TI_FLAG_Enum IOOfficialPriceFlag = TI_FLAG_Enum.TI_FLAG_No;

	public BV_INSTRUMENT_CLASS_SECTION()
	{
	}

	public long getSectionId()
	{
		return SectionId;
	}
	public void setSectionId(long value)
	{
		SectionId = value;
	}
	public long getInstrumentClassId()
	{
		return InstrumentClassId;
	}
	public void setInstrumentClassId(long value)
	{
		InstrumentClassId = value;
	}
	public long getSortNumber()
	{
		return SortNumber;
	}
	public void setSortNumber(long value)
	{
		SortNumber = value;
	}
	public long getStartDate()
	{
		return StartDate;
	}
	public void setStartDate(long value)
	{
		StartDate = value;
	}
	public long getStopDate()
	{
		return StopDate;
	}
	public void setStopDate(long value)
	{
		StopDate = value;
	}
	public TI_FLAG_Enum getRFCQStatisticFlag()
	{
		return RFCQStatisticFlag;
	}
	public void setRFCQStatisticFlag(TI_FLAG_Enum value)
	{
		RFCQStatisticFlag = value;
	}
	public TI_FLAG_Enum getRFCQLastTradeFlag()
	{
		return RFCQLastTradeFlag;
	}
	public void setRFCQLastTradeFlag(TI_FLAG_Enum value)
	{
		RFCQLastTradeFlag = value;
	}
	public TI_FLAG_Enum getRFCQOfficialPriceFlag()
	{
		return RFCQOfficialPriceFlag;
	}
	public void setRFCQOfficialPriceFlag(TI_FLAG_Enum value)
	{
		RFCQOfficialPriceFlag = value;
	}
	public TI_FLAG_Enum getIOStatisticFlag()
	{
		return IOStatisticFlag;
	}
	public void setIOStatisticFlag(TI_FLAG_Enum value)
	{
		IOStatisticFlag = value;
	}
	public TI_FLAG_Enum getIOLastTradeFlag()
	{
		return IOLastTradeFlag;
	}
	public void setIOLastTradeFlag(TI_FLAG_Enum value)
	{
		IOLastTradeFlag = value;
	}
	public TI_FLAG_Enum getIOOfficialPriceFlag()
	{
		return IOOfficialPriceFlag;
	}
	public void setIOOfficialPriceFlag(TI_FLAG_Enum value)
	{
		IOOfficialPriceFlag = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		SectionId = (long)byteBuffer.readInt();
		InstrumentClassId = (long)byteBuffer.readInt();
		SortNumber = (long)byteBuffer.readInt();
		StartDate = (long)byteBuffer.readInt();
		StopDate = (long)byteBuffer.readInt();
		RFCQStatisticFlag = RFCQStatisticFlag.getEnum(byteBuffer.readInt());
		RFCQLastTradeFlag = RFCQLastTradeFlag.getEnum(byteBuffer.readInt());
		RFCQOfficialPriceFlag = RFCQOfficialPriceFlag.getEnum(byteBuffer.readInt());
		IOStatisticFlag = IOStatisticFlag.getEnum(byteBuffer.readInt());
		IOLastTradeFlag = IOLastTradeFlag.getEnum(byteBuffer.readInt());
		IOOfficialPriceFlag = IOOfficialPriceFlag.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(SectionId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(InstrumentClassId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SortNumber & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(StartDate & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(StopDate & 0xFFFFFFFFL));
		byteBuffer.writeInt(RFCQStatisticFlag.getValue());
		byteBuffer.writeInt(RFCQLastTradeFlag.getValue());
		byteBuffer.writeInt(RFCQOfficialPriceFlag.getValue());
		byteBuffer.writeInt(IOStatisticFlag.getValue());
		byteBuffer.writeInt(IOLastTradeFlag.getValue());
		byteBuffer.writeInt(IOOfficialPriceFlag.getValue());

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
		stringBuilder.append("BV_INSTRUMENT_CLASS_SECTION::");
		stringBuilder.append("SectionId(").append(SectionId).append(")");
		stringBuilder.append("InstrumentClassId(").append(InstrumentClassId).append(")");
		stringBuilder.append("SortNumber(").append(SortNumber).append(")");
		stringBuilder.append("StartDate(").append(StartDate).append(")");
		stringBuilder.append("StopDate(").append(StopDate).append(")");
		stringBuilder.append("RFCQStatisticFlag(").append(RFCQStatisticFlag).append(")");
		stringBuilder.append("RFCQLastTradeFlag(").append(RFCQLastTradeFlag).append(")");
		stringBuilder.append("RFCQOfficialPriceFlag(").append(RFCQOfficialPriceFlag).append(")");
		stringBuilder.append("IOStatisticFlag(").append(IOStatisticFlag).append(")");
		stringBuilder.append("IOLastTradeFlag(").append(IOLastTradeFlag).append(")");
		stringBuilder.append("IOOfficialPriceFlag(").append(IOOfficialPriceFlag).append(")");
		return stringBuilder.toString();
	}
}
