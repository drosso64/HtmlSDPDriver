package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_INSTRUMENT_ANALYTICS extends SMPMessage
{
	public static final long CLASS_ID = 100083;

	private long CalculationRequestId = 0;
	private long InstrumentId = 0;
	private double InputNominal = 0;
	private double InputValue = 0;
	private TI_INSTRUMENT_ANALYTICS_INPUT_TYPE_Enum InputValueType = TI_INSTRUMENT_ANALYTICS_INPUT_TYPE_Enum.TI_INSTRUMENT_ANALYTICS_INPUT_TYPE_Dirty;
	private long InputYieldTypeId = 0;
	private long SettlementDate = 0;
	private short SettlementOffset = 0;
	private TI_FLAG_Enum SettlementOffsetFg = TI_FLAG_Enum.TI_FLAG_No;
	private TI_FLAG_Enum YieldCalculationFg = TI_FLAG_Enum.TI_FLAG_No;
	private TI_FLAG_Enum AccrualCalculationFg = TI_FLAG_Enum.TI_FLAG_No;
	private TI_FLAG_Enum DurationCalculationFg = TI_FLAG_Enum.TI_FLAG_No;
	private TI_FLAG_Enum ConvexityCalculationFg = TI_FLAG_Enum.TI_FLAG_No;
	private double OutputCleanPrice = 0;
	private double OutputCleanPrice32 = 0;
	private double OutputDirtyPrice = 0;
	private double OutputIndexedCleanPrice = 0;
	private double OutputIndexRatio = 0;
	private double OutputConventionalYield = 0;
	private long OutputConventionalYieldType = 0;
	private TI_INSTRUMENT_ANALYTICS_OUTPUT[] OutputYield = new TI_INSTRUMENT_ANALYTICS_OUTPUT[20];
	private TI_FLAG_Enum AccrualCalculatedFg = TI_FLAG_Enum.TI_FLAG_No;
	private double PrincipalAmount = 0;
	private double AccruedInterest = 0;
	private double IndexedAccruedInterest = 0;
	private double SettlementAmount = 0;
	private double SettlementAmountEUR = 0;
	private short Days = 0;
	private double Discount = 0;
	private TI_FLAG_Enum DurationCalculatedFg = TI_FLAG_Enum.TI_FLAG_No;
	private double MaculayDuration = 0;
	private double HicksDuration = 0;
	private TI_FLAG_Enum ConvexityCalculatedFg = TI_FLAG_Enum.TI_FLAG_No;
	private double Convexity = 0;
	private TI_FLAG_Enum BPVCalculatedFg = TI_FLAG_Enum.TI_FLAG_No;
	private double BPV = 0;

	public TI_INSTRUMENT_ANALYTICS()
	{
		for (int i=0; i < OutputYield.length; ++i)
		{
			OutputYield[i] = new TI_INSTRUMENT_ANALYTICS_OUTPUT();
		}
	}

	public long getCalculationRequestId()
	{
		return CalculationRequestId;
	}
	public void setCalculationRequestId(long value)
	{
		CalculationRequestId = value;
	}
	public long getInstrumentId()
	{
		return InstrumentId;
	}
	public void setInstrumentId(long value)
	{
		InstrumentId = value;
	}
	public double getInputNominal()
	{
		return InputNominal;
	}
	public void setInputNominal(double value)
	{
		InputNominal = value;
	}
	public double getInputValue()
	{
		return InputValue;
	}
	public void setInputValue(double value)
	{
		InputValue = value;
	}
	public TI_INSTRUMENT_ANALYTICS_INPUT_TYPE_Enum getInputValueType()
	{
		return InputValueType;
	}
	public void setInputValueType(TI_INSTRUMENT_ANALYTICS_INPUT_TYPE_Enum value)
	{
		InputValueType = value;
	}
	public long getInputYieldTypeId()
	{
		return InputYieldTypeId;
	}
	public void setInputYieldTypeId(long value)
	{
		InputYieldTypeId = value;
	}
	public long getSettlementDate()
	{
		return SettlementDate;
	}
	public void setSettlementDate(long value)
	{
		SettlementDate = value;
	}
	public short getSettlementOffset()
	{
		return SettlementOffset;
	}
	public void setSettlementOffset(short value)
	{
		SettlementOffset = value;
	}
	public TI_FLAG_Enum getSettlementOffsetFg()
	{
		return SettlementOffsetFg;
	}
	public void setSettlementOffsetFg(TI_FLAG_Enum value)
	{
		SettlementOffsetFg = value;
	}
	public TI_FLAG_Enum getYieldCalculationFg()
	{
		return YieldCalculationFg;
	}
	public void setYieldCalculationFg(TI_FLAG_Enum value)
	{
		YieldCalculationFg = value;
	}
	public TI_FLAG_Enum getAccrualCalculationFg()
	{
		return AccrualCalculationFg;
	}
	public void setAccrualCalculationFg(TI_FLAG_Enum value)
	{
		AccrualCalculationFg = value;
	}
	public TI_FLAG_Enum getDurationCalculationFg()
	{
		return DurationCalculationFg;
	}
	public void setDurationCalculationFg(TI_FLAG_Enum value)
	{
		DurationCalculationFg = value;
	}
	public TI_FLAG_Enum getConvexityCalculationFg()
	{
		return ConvexityCalculationFg;
	}
	public void setConvexityCalculationFg(TI_FLAG_Enum value)
	{
		ConvexityCalculationFg = value;
	}
	public double getOutputCleanPrice()
	{
		return OutputCleanPrice;
	}
	public void setOutputCleanPrice(double value)
	{
		OutputCleanPrice = value;
	}
	public double getOutputCleanPrice32()
	{
		return OutputCleanPrice32;
	}
	public void setOutputCleanPrice32(double value)
	{
		OutputCleanPrice32 = value;
	}
	public double getOutputDirtyPrice()
	{
		return OutputDirtyPrice;
	}
	public void setOutputDirtyPrice(double value)
	{
		OutputDirtyPrice = value;
	}
	public double getOutputIndexedCleanPrice()
	{
		return OutputIndexedCleanPrice;
	}
	public void setOutputIndexedCleanPrice(double value)
	{
		OutputIndexedCleanPrice = value;
	}
	public double getOutputIndexRatio()
	{
		return OutputIndexRatio;
	}
	public void setOutputIndexRatio(double value)
	{
		OutputIndexRatio = value;
	}
	public double getOutputConventionalYield()
	{
		return OutputConventionalYield;
	}
	public void setOutputConventionalYield(double value)
	{
		OutputConventionalYield = value;
	}
	public long getOutputConventionalYieldType()
	{
		return OutputConventionalYieldType;
	}
	public void setOutputConventionalYieldType(long value)
	{
		OutputConventionalYieldType = value;
	}
	public TI_INSTRUMENT_ANALYTICS_OUTPUT[] getOutputYield()
	{
		return OutputYield;
	}
	public void setOutputYield(TI_INSTRUMENT_ANALYTICS_OUTPUT[] value)
	{
		OutputYield = value;
	}
	public TI_FLAG_Enum getAccrualCalculatedFg()
	{
		return AccrualCalculatedFg;
	}
	public void setAccrualCalculatedFg(TI_FLAG_Enum value)
	{
		AccrualCalculatedFg = value;
	}
	public double getPrincipalAmount()
	{
		return PrincipalAmount;
	}
	public void setPrincipalAmount(double value)
	{
		PrincipalAmount = value;
	}
	public double getAccruedInterest()
	{
		return AccruedInterest;
	}
	public void setAccruedInterest(double value)
	{
		AccruedInterest = value;
	}
	public double getIndexedAccruedInterest()
	{
		return IndexedAccruedInterest;
	}
	public void setIndexedAccruedInterest(double value)
	{
		IndexedAccruedInterest = value;
	}
	public double getSettlementAmount()
	{
		return SettlementAmount;
	}
	public void setSettlementAmount(double value)
	{
		SettlementAmount = value;
	}
	public double getSettlementAmountEUR()
	{
		return SettlementAmountEUR;
	}
	public void setSettlementAmountEUR(double value)
	{
		SettlementAmountEUR = value;
	}
	public short getDays()
	{
		return Days;
	}
	public void setDays(short value)
	{
		Days = value;
	}
	public double getDiscount()
	{
		return Discount;
	}
	public void setDiscount(double value)
	{
		Discount = value;
	}
	public TI_FLAG_Enum getDurationCalculatedFg()
	{
		return DurationCalculatedFg;
	}
	public void setDurationCalculatedFg(TI_FLAG_Enum value)
	{
		DurationCalculatedFg = value;
	}
	public double getMaculayDuration()
	{
		return MaculayDuration;
	}
	public void setMaculayDuration(double value)
	{
		MaculayDuration = value;
	}
	public double getHicksDuration()
	{
		return HicksDuration;
	}
	public void setHicksDuration(double value)
	{
		HicksDuration = value;
	}
	public TI_FLAG_Enum getConvexityCalculatedFg()
	{
		return ConvexityCalculatedFg;
	}
	public void setConvexityCalculatedFg(TI_FLAG_Enum value)
	{
		ConvexityCalculatedFg = value;
	}
	public double getConvexity()
	{
		return Convexity;
	}
	public void setConvexity(double value)
	{
		Convexity = value;
	}
	public TI_FLAG_Enum getBPVCalculatedFg()
	{
		return BPVCalculatedFg;
	}
	public void setBPVCalculatedFg(TI_FLAG_Enum value)
	{
		BPVCalculatedFg = value;
	}
	public double getBPV()
	{
		return BPV;
	}
	public void setBPV(double value)
	{
		BPV = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		CalculationRequestId = (long)byteBuffer.readInt();
		InstrumentId = (long)byteBuffer.readInt();
		InputNominal = byteBuffer.readDouble();
		InputValue = byteBuffer.readDouble();
		InputValueType = InputValueType.getEnum(byteBuffer.readInt());
		InputYieldTypeId = (long)byteBuffer.readInt();
		SettlementDate = (long)byteBuffer.readInt();
		SettlementOffset = (short)byteBuffer.readInt();
		SettlementOffsetFg = SettlementOffsetFg.getEnum(byteBuffer.readInt());
		YieldCalculationFg = YieldCalculationFg.getEnum(byteBuffer.readInt());
		AccrualCalculationFg = AccrualCalculationFg.getEnum(byteBuffer.readInt());
		DurationCalculationFg = DurationCalculationFg.getEnum(byteBuffer.readInt());
		ConvexityCalculationFg = ConvexityCalculationFg.getEnum(byteBuffer.readInt());
		OutputCleanPrice = byteBuffer.readDouble();
		OutputCleanPrice32 = byteBuffer.readDouble();
		OutputDirtyPrice = byteBuffer.readDouble();
		OutputIndexedCleanPrice = byteBuffer.readDouble();
		OutputIndexRatio = byteBuffer.readDouble();
		OutputConventionalYield = byteBuffer.readDouble();
		OutputConventionalYieldType = (long)byteBuffer.readInt();
		for (int i=0; i < OutputYield.length; ++i)
		{
			OutputYield[i].readXDR(byteBuffer);
		}
		AccrualCalculatedFg = AccrualCalculatedFg.getEnum(byteBuffer.readInt());
		PrincipalAmount = byteBuffer.readDouble();
		AccruedInterest = byteBuffer.readDouble();
		IndexedAccruedInterest = byteBuffer.readDouble();
		SettlementAmount = byteBuffer.readDouble();
		SettlementAmountEUR = byteBuffer.readDouble();
		Days = (short)byteBuffer.readInt();
		Discount = byteBuffer.readDouble();
		DurationCalculatedFg = DurationCalculatedFg.getEnum(byteBuffer.readInt());
		MaculayDuration = byteBuffer.readDouble();
		HicksDuration = byteBuffer.readDouble();
		ConvexityCalculatedFg = ConvexityCalculatedFg.getEnum(byteBuffer.readInt());
		Convexity = byteBuffer.readDouble();
		BPVCalculatedFg = BPVCalculatedFg.getEnum(byteBuffer.readInt());
		BPV = byteBuffer.readDouble();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(CalculationRequestId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(InstrumentId & 0xFFFFFFFFL));
		byteBuffer.writeDouble(InputNominal);
		byteBuffer.writeDouble(InputValue);
		byteBuffer.writeInt(InputValueType.getValue());
		byteBuffer.writeInt((int)(InputYieldTypeId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SettlementDate & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SettlementOffset & 0xFFFFL));
		byteBuffer.writeInt(SettlementOffsetFg.getValue());
		byteBuffer.writeInt(YieldCalculationFg.getValue());
		byteBuffer.writeInt(AccrualCalculationFg.getValue());
		byteBuffer.writeInt(DurationCalculationFg.getValue());
		byteBuffer.writeInt(ConvexityCalculationFg.getValue());
		byteBuffer.writeDouble(OutputCleanPrice);
		byteBuffer.writeDouble(OutputCleanPrice32);
		byteBuffer.writeDouble(OutputDirtyPrice);
		byteBuffer.writeDouble(OutputIndexedCleanPrice);
		byteBuffer.writeDouble(OutputIndexRatio);
		byteBuffer.writeDouble(OutputConventionalYield);
		byteBuffer.writeInt((int)(OutputConventionalYieldType & 0xFFFFFFFFL));
		for (int i=0; i < OutputYield.length; ++i)
		{
			OutputYield[i].writeXDR(byteBuffer);
		}
		byteBuffer.writeInt(AccrualCalculatedFg.getValue());
		byteBuffer.writeDouble(PrincipalAmount);
		byteBuffer.writeDouble(AccruedInterest);
		byteBuffer.writeDouble(IndexedAccruedInterest);
		byteBuffer.writeDouble(SettlementAmount);
		byteBuffer.writeDouble(SettlementAmountEUR);
		byteBuffer.writeInt((int)(Days & 0xFFFFL));
		byteBuffer.writeDouble(Discount);
		byteBuffer.writeInt(DurationCalculatedFg.getValue());
		byteBuffer.writeDouble(MaculayDuration);
		byteBuffer.writeDouble(HicksDuration);
		byteBuffer.writeInt(ConvexityCalculatedFg.getValue());
		byteBuffer.writeDouble(Convexity);
		byteBuffer.writeInt(BPVCalculatedFg.getValue());
		byteBuffer.writeDouble(BPV);

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
		stringBuilder.append("TI_INSTRUMENT_ANALYTICS::");
		stringBuilder.append("CalculationRequestId(").append(CalculationRequestId).append(")");
		stringBuilder.append("InstrumentId(").append(InstrumentId).append(")");
		stringBuilder.append("InputNominal(").append(InputNominal).append(")");
		stringBuilder.append("InputValue(").append(InputValue).append(")");
		stringBuilder.append("InputValueType(").append(InputValueType).append(")");
		stringBuilder.append("InputYieldTypeId(").append(InputYieldTypeId).append(")");
		stringBuilder.append("SettlementDate(").append(SettlementDate).append(")");
		stringBuilder.append("SettlementOffset(").append(SettlementOffset).append(")");
		stringBuilder.append("SettlementOffsetFg(").append(SettlementOffsetFg).append(")");
		stringBuilder.append("YieldCalculationFg(").append(YieldCalculationFg).append(")");
		stringBuilder.append("AccrualCalculationFg(").append(AccrualCalculationFg).append(")");
		stringBuilder.append("DurationCalculationFg(").append(DurationCalculationFg).append(")");
		stringBuilder.append("ConvexityCalculationFg(").append(ConvexityCalculationFg).append(")");
		stringBuilder.append("OutputCleanPrice(").append(OutputCleanPrice).append(")");
		stringBuilder.append("OutputCleanPrice32(").append(OutputCleanPrice32).append(")");
		stringBuilder.append("OutputDirtyPrice(").append(OutputDirtyPrice).append(")");
		stringBuilder.append("OutputIndexedCleanPrice(").append(OutputIndexedCleanPrice).append(")");
		stringBuilder.append("OutputIndexRatio(").append(OutputIndexRatio).append(")");
		stringBuilder.append("OutputConventionalYield(").append(OutputConventionalYield).append(")");
		stringBuilder.append("OutputConventionalYieldType(").append(OutputConventionalYieldType).append(")");
		for (int i=0; i < OutputYield.length; ++i)
		{
			stringBuilder.append("OutputYield[").append(i).append("](").append(OutputYield[i].toString()).append(")");
		}
		stringBuilder.append("AccrualCalculatedFg(").append(AccrualCalculatedFg).append(")");
		stringBuilder.append("PrincipalAmount(").append(PrincipalAmount).append(")");
		stringBuilder.append("AccruedInterest(").append(AccruedInterest).append(")");
		stringBuilder.append("IndexedAccruedInterest(").append(IndexedAccruedInterest).append(")");
		stringBuilder.append("SettlementAmount(").append(SettlementAmount).append(")");
		stringBuilder.append("SettlementAmountEUR(").append(SettlementAmountEUR).append(")");
		stringBuilder.append("Days(").append(Days).append(")");
		stringBuilder.append("Discount(").append(Discount).append(")");
		stringBuilder.append("DurationCalculatedFg(").append(DurationCalculatedFg).append(")");
		stringBuilder.append("MaculayDuration(").append(MaculayDuration).append(")");
		stringBuilder.append("HicksDuration(").append(HicksDuration).append(")");
		stringBuilder.append("ConvexityCalculatedFg(").append(ConvexityCalculatedFg).append(")");
		stringBuilder.append("Convexity(").append(Convexity).append(")");
		stringBuilder.append("BPVCalculatedFg(").append(BPVCalculatedFg).append(")");
		stringBuilder.append("BPV(").append(BPV).append(")");
		return stringBuilder.toString();
	}
}
