package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_BOND extends SMPMessage
{
	public static final long CLASS_ID = 400059;

	private long InstrumentId = 0;
	private String InstrumentCode = "";
	private String InstrumentDesc = "";
	private long FinancialInstrumentId = 0;
	private long UnderlyingInstrumentId = 0;
	private long InstrumentClassId = 0;
	private short AccIntPrecision = 0;
	private TI_FLAG_Enum GreyMarketFlag = TI_FLAG_Enum.TI_FLAG_No;
	private long GreyMarketEndDate = 0;
	private long SettlDate = 0;
	private long SortNumber = 0;
	private TI_FLAG_Enum InventoryQuotingFg = TI_FLAG_Enum.TI_FLAG_No;
	private long Fix2FloatResetDate = 0;
	private short CouponResetFrequency = 0;
	private TI_FLAG_Enum NoYieldConvFg = TI_FLAG_Enum.TI_FLAG_No;
	private TI_FLAG_Enum DLTSettlementEligibleFg = TI_FLAG_Enum.TI_FLAG_No;
	private double BasisMinPriceTick = 0;

	public BV_BOND()
	{
	}

	public long getInstrumentId()
	{
		return InstrumentId;
	}
	public void setInstrumentId(long value)
	{
		InstrumentId = value;
	}
	public String getInstrumentCode()
	{
		return InstrumentCode;
	}
	public void setInstrumentCode(String value)
	{
		InstrumentCode = value;
	}
	public String getInstrumentDesc()
	{
		return InstrumentDesc;
	}
	public void setInstrumentDesc(String value)
	{
		InstrumentDesc = value;
	}
	public long getFinancialInstrumentId()
	{
		return FinancialInstrumentId;
	}
	public void setFinancialInstrumentId(long value)
	{
		FinancialInstrumentId = value;
	}
	public long getUnderlyingInstrumentId()
	{
		return UnderlyingInstrumentId;
	}
	public void setUnderlyingInstrumentId(long value)
	{
		UnderlyingInstrumentId = value;
	}
	public long getInstrumentClassId()
	{
		return InstrumentClassId;
	}
	public void setInstrumentClassId(long value)
	{
		InstrumentClassId = value;
	}
	public short getAccIntPrecision()
	{
		return AccIntPrecision;
	}
	public void setAccIntPrecision(short value)
	{
		AccIntPrecision = value;
	}
	public TI_FLAG_Enum getGreyMarketFlag()
	{
		return GreyMarketFlag;
	}
	public void setGreyMarketFlag(TI_FLAG_Enum value)
	{
		GreyMarketFlag = value;
	}
	public long getGreyMarketEndDate()
	{
		return GreyMarketEndDate;
	}
	public void setGreyMarketEndDate(long value)
	{
		GreyMarketEndDate = value;
	}
	public long getSettlDate()
	{
		return SettlDate;
	}
	public void setSettlDate(long value)
	{
		SettlDate = value;
	}
	public long getSortNumber()
	{
		return SortNumber;
	}
	public void setSortNumber(long value)
	{
		SortNumber = value;
	}
	public TI_FLAG_Enum getInventoryQuotingFg()
	{
		return InventoryQuotingFg;
	}
	public void setInventoryQuotingFg(TI_FLAG_Enum value)
	{
		InventoryQuotingFg = value;
	}
	public long getFix2FloatResetDate()
	{
		return Fix2FloatResetDate;
	}
	public void setFix2FloatResetDate(long value)
	{
		Fix2FloatResetDate = value;
	}
	public short getCouponResetFrequency()
	{
		return CouponResetFrequency;
	}
	public void setCouponResetFrequency(short value)
	{
		CouponResetFrequency = value;
	}
	public TI_FLAG_Enum getNoYieldConvFg()
	{
		return NoYieldConvFg;
	}
	public void setNoYieldConvFg(TI_FLAG_Enum value)
	{
		NoYieldConvFg = value;
	}
	public TI_FLAG_Enum getDLTSettlementEligibleFg()
	{
		return DLTSettlementEligibleFg;
	}
	public void setDLTSettlementEligibleFg(TI_FLAG_Enum value)
	{
		DLTSettlementEligibleFg = value;
	}
	public double getBasisMinPriceTick()
	{
		return BasisMinPriceTick;
	}
	public void setBasisMinPriceTick(double value)
	{
		BasisMinPriceTick = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		InstrumentId = (long)byteBuffer.readInt();
		InstrumentCode = byteBuffer.readString();
		InstrumentDesc = byteBuffer.readString();
		FinancialInstrumentId = (long)byteBuffer.readInt();
		UnderlyingInstrumentId = (long)byteBuffer.readInt();
		InstrumentClassId = (long)byteBuffer.readInt();
		AccIntPrecision = (short)byteBuffer.readInt();
		GreyMarketFlag = GreyMarketFlag.getEnum(byteBuffer.readInt());
		GreyMarketEndDate = (long)byteBuffer.readInt();
		SettlDate = (long)byteBuffer.readInt();
		SortNumber = (long)byteBuffer.readInt();
		InventoryQuotingFg = InventoryQuotingFg.getEnum(byteBuffer.readInt());
		Fix2FloatResetDate = (long)byteBuffer.readInt();
		CouponResetFrequency = (short)byteBuffer.readInt();
		NoYieldConvFg = NoYieldConvFg.getEnum(byteBuffer.readInt());
		DLTSettlementEligibleFg = DLTSettlementEligibleFg.getEnum(byteBuffer.readInt());
		BasisMinPriceTick = byteBuffer.readDouble();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(InstrumentId & 0xFFFFFFFFL));
		byteBuffer.writeString(InstrumentCode);
		byteBuffer.writeString(InstrumentDesc);
		byteBuffer.writeInt((int)(FinancialInstrumentId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(UnderlyingInstrumentId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(InstrumentClassId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(AccIntPrecision & 0xFFFFL));
		byteBuffer.writeInt(GreyMarketFlag.getValue());
		byteBuffer.writeInt((int)(GreyMarketEndDate & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SettlDate & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SortNumber & 0xFFFFFFFFL));
		byteBuffer.writeInt(InventoryQuotingFg.getValue());
		byteBuffer.writeInt((int)(Fix2FloatResetDate & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(CouponResetFrequency & 0xFFFFL));
		byteBuffer.writeInt(NoYieldConvFg.getValue());
		byteBuffer.writeInt(DLTSettlementEligibleFg.getValue());
		byteBuffer.writeDouble(BasisMinPriceTick);

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
		stringBuilder.append("BV_BOND::");
		stringBuilder.append("InstrumentId(").append(InstrumentId).append(")");
		stringBuilder.append("InstrumentCode(").append(InstrumentCode).append(")");
		stringBuilder.append("InstrumentDesc(").append(InstrumentDesc).append(")");
		stringBuilder.append("FinancialInstrumentId(").append(FinancialInstrumentId).append(")");
		stringBuilder.append("UnderlyingInstrumentId(").append(UnderlyingInstrumentId).append(")");
		stringBuilder.append("InstrumentClassId(").append(InstrumentClassId).append(")");
		stringBuilder.append("AccIntPrecision(").append(AccIntPrecision).append(")");
		stringBuilder.append("GreyMarketFlag(").append(GreyMarketFlag).append(")");
		stringBuilder.append("GreyMarketEndDate(").append(GreyMarketEndDate).append(")");
		stringBuilder.append("SettlDate(").append(SettlDate).append(")");
		stringBuilder.append("SortNumber(").append(SortNumber).append(")");
		stringBuilder.append("InventoryQuotingFg(").append(InventoryQuotingFg).append(")");
		stringBuilder.append("Fix2FloatResetDate(").append(Fix2FloatResetDate).append(")");
		stringBuilder.append("CouponResetFrequency(").append(CouponResetFrequency).append(")");
		stringBuilder.append("NoYieldConvFg(").append(NoYieldConvFg).append(")");
		stringBuilder.append("DLTSettlementEligibleFg(").append(DLTSettlementEligibleFg).append(")");
		stringBuilder.append("BasisMinPriceTick(").append(BasisMinPriceTick).append(")");
		return stringBuilder.toString();
	}
}
