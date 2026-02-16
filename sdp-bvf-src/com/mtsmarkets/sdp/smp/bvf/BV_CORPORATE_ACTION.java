package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_CORPORATE_ACTION extends SMPMessage
{
	public static final long CLASS_ID = 400018;

	private long FinancialInstrumentId = 0;
	private long AnnouncementDate = 0;
	private BV_CALL_INDICATOR_Enum Indicator = BV_CALL_INDICATOR_Enum.BV_CALL_INDICATOR_Call;
	private long ExerciseDate = 0;
	private double ExercisePrice = 0;
	private double ExerciseAmount = 0;
	private TI_FLAG_Enum FullAmountFg = TI_FLAG_Enum.TI_FLAG_No;
	private TI_FLAG_Enum CalledFg = TI_FLAG_Enum.TI_FLAG_No;

	public BV_CORPORATE_ACTION()
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
	public long getAnnouncementDate()
	{
		return AnnouncementDate;
	}
	public void setAnnouncementDate(long value)
	{
		AnnouncementDate = value;
	}
	public BV_CALL_INDICATOR_Enum getIndicator()
	{
		return Indicator;
	}
	public void setIndicator(BV_CALL_INDICATOR_Enum value)
	{
		Indicator = value;
	}
	public long getExerciseDate()
	{
		return ExerciseDate;
	}
	public void setExerciseDate(long value)
	{
		ExerciseDate = value;
	}
	public double getExercisePrice()
	{
		return ExercisePrice;
	}
	public void setExercisePrice(double value)
	{
		ExercisePrice = value;
	}
	public double getExerciseAmount()
	{
		return ExerciseAmount;
	}
	public void setExerciseAmount(double value)
	{
		ExerciseAmount = value;
	}
	public TI_FLAG_Enum getFullAmountFg()
	{
		return FullAmountFg;
	}
	public void setFullAmountFg(TI_FLAG_Enum value)
	{
		FullAmountFg = value;
	}
	public TI_FLAG_Enum getCalledFg()
	{
		return CalledFg;
	}
	public void setCalledFg(TI_FLAG_Enum value)
	{
		CalledFg = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		FinancialInstrumentId = (long)byteBuffer.readInt();
		AnnouncementDate = (long)byteBuffer.readInt();
		Indicator = Indicator.getEnum(byteBuffer.readInt());
		ExerciseDate = (long)byteBuffer.readInt();
		ExercisePrice = byteBuffer.readDouble();
		ExerciseAmount = byteBuffer.readDouble();
		FullAmountFg = FullAmountFg.getEnum(byteBuffer.readInt());
		CalledFg = CalledFg.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(FinancialInstrumentId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(AnnouncementDate & 0xFFFFFFFFL));
		byteBuffer.writeInt(Indicator.getValue());
		byteBuffer.writeInt((int)(ExerciseDate & 0xFFFFFFFFL));
		byteBuffer.writeDouble(ExercisePrice);
		byteBuffer.writeDouble(ExerciseAmount);
		byteBuffer.writeInt(FullAmountFg.getValue());
		byteBuffer.writeInt(CalledFg.getValue());

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
		stringBuilder.append("BV_CORPORATE_ACTION::");
		stringBuilder.append("FinancialInstrumentId(").append(FinancialInstrumentId).append(")");
		stringBuilder.append("AnnouncementDate(").append(AnnouncementDate).append(")");
		stringBuilder.append("Indicator(").append(Indicator).append(")");
		stringBuilder.append("ExerciseDate(").append(ExerciseDate).append(")");
		stringBuilder.append("ExercisePrice(").append(ExercisePrice).append(")");
		stringBuilder.append("ExerciseAmount(").append(ExerciseAmount).append(")");
		stringBuilder.append("FullAmountFg(").append(FullAmountFg).append(")");
		stringBuilder.append("CalledFg(").append(CalledFg).append(")");
		return stringBuilder.toString();
	}
}
