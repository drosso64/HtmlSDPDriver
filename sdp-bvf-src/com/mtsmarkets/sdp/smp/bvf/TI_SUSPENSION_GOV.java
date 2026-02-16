package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_SUSPENSION_GOV extends SMPMessage
{
	public static final long CLASS_ID = 100804;

	private long MarketId = 0;
	private long MemberId = 0;
	private long InstrumentId = 0;
	private long SectionId = 0;
	private long InstrumentClassId = 0;
	private long FinancialInstrumentId = 0;
	private TI_FINANCIAL_INSTRUMENT_TYPE_Enum FinancialInstrumentType = TI_FINANCIAL_INSTRUMENT_TYPE_Enum.TI_FINANCIAL_INSTRUMENT_TYPE_Bond;
	private TI_INSTRUMENT_TYPE_Enum InstrumentType = TI_INSTRUMENT_TYPE_Enum.TI_INSTRUMENT_TYPE_Bond;
	private TI_SUSP_STATUS_Enum SuspensionStatus = TI_SUSP_STATUS_Enum.TI_SUSP_STATUS_Active;
	private long UpdateDate = 0;
	private long UpdateTime = 0;

	public TI_SUSPENSION_GOV()
	{
	}

	public long getMarketId()
	{
		return MarketId;
	}
	public void setMarketId(long value)
	{
		MarketId = value;
	}
	public long getMemberId()
	{
		return MemberId;
	}
	public void setMemberId(long value)
	{
		MemberId = value;
	}
	public long getInstrumentId()
	{
		return InstrumentId;
	}
	public void setInstrumentId(long value)
	{
		InstrumentId = value;
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
	public long getFinancialInstrumentId()
	{
		return FinancialInstrumentId;
	}
	public void setFinancialInstrumentId(long value)
	{
		FinancialInstrumentId = value;
	}
	public TI_FINANCIAL_INSTRUMENT_TYPE_Enum getFinancialInstrumentType()
	{
		return FinancialInstrumentType;
	}
	public void setFinancialInstrumentType(TI_FINANCIAL_INSTRUMENT_TYPE_Enum value)
	{
		FinancialInstrumentType = value;
	}
	public TI_INSTRUMENT_TYPE_Enum getInstrumentType()
	{
		return InstrumentType;
	}
	public void setInstrumentType(TI_INSTRUMENT_TYPE_Enum value)
	{
		InstrumentType = value;
	}
	public TI_SUSP_STATUS_Enum getSuspensionStatus()
	{
		return SuspensionStatus;
	}
	public void setSuspensionStatus(TI_SUSP_STATUS_Enum value)
	{
		SuspensionStatus = value;
	}
	public long getUpdateDate()
	{
		return UpdateDate;
	}
	public void setUpdateDate(long value)
	{
		UpdateDate = value;
	}
	public long getUpdateTime()
	{
		return UpdateTime;
	}
	public void setUpdateTime(long value)
	{
		UpdateTime = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MarketId = (long)byteBuffer.readInt();
		MemberId = (long)byteBuffer.readInt();
		InstrumentId = (long)byteBuffer.readInt();
		SectionId = (long)byteBuffer.readInt();
		InstrumentClassId = (long)byteBuffer.readInt();
		FinancialInstrumentId = (long)byteBuffer.readInt();
		FinancialInstrumentType = FinancialInstrumentType.getEnum(byteBuffer.readInt());
		InstrumentType = InstrumentType.getEnum(byteBuffer.readInt());
		SuspensionStatus = SuspensionStatus.getEnum(byteBuffer.readInt());
		UpdateDate = (long)byteBuffer.readInt();
		UpdateTime = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MarketId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(MemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(InstrumentId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SectionId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(InstrumentClassId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(FinancialInstrumentId & 0xFFFFFFFFL));
		byteBuffer.writeInt(FinancialInstrumentType.getValue());
		byteBuffer.writeInt(InstrumentType.getValue());
		byteBuffer.writeInt(SuspensionStatus.getValue());
		byteBuffer.writeInt((int)(UpdateDate & 0xFFFFFFFFL));
		byteBuffer.writeLong(UpdateTime);

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
		stringBuilder.append("TI_SUSPENSION_GOV::");
		stringBuilder.append("MarketId(").append(MarketId).append(")");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("InstrumentId(").append(InstrumentId).append(")");
		stringBuilder.append("SectionId(").append(SectionId).append(")");
		stringBuilder.append("InstrumentClassId(").append(InstrumentClassId).append(")");
		stringBuilder.append("FinancialInstrumentId(").append(FinancialInstrumentId).append(")");
		stringBuilder.append("FinancialInstrumentType(").append(FinancialInstrumentType).append(")");
		stringBuilder.append("InstrumentType(").append(InstrumentType).append(")");
		stringBuilder.append("SuspensionStatus(").append(SuspensionStatus).append(")");
		stringBuilder.append("UpdateDate(").append(UpdateDate).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		return stringBuilder.toString();
	}
}
