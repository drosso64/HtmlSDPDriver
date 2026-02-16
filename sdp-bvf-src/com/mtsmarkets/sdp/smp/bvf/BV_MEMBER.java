package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_MEMBER extends SMPMessage
{
	public static final long CLASS_ID = 400028;

	private long MemberId = 0;
	private short TotalVariableWindowSize = 0;
	private short MaxVariableWindowSizeTrader = 0;
	private short MaxFixedWindowSizeTrader = 0;
	private short MaxTraderConnected = 0;
	private long StartDate = 0;
	private long EndDate = 0;
	private TI_FLAG_Enum DoubleSidedRFCQEnabledFg = TI_FLAG_Enum.TI_FLAG_No;
	private short AreaCodeId = 0;
	private short MaxCustomInstrumentsInChart = 0;
	private TI_FLAG_Enum UnseasonedBondTradingFg = TI_FLAG_Enum.TI_FLAG_No;
	private String LeiCode = "";
	private long TradingCapacityId = 0;
	private TI_FLAG_Enum ExemptedFromTransparencyFg = TI_FLAG_Enum.TI_FLAG_No;
	private short MaxNumPortfolioRFCQ = 0;

	public BV_MEMBER()
	{
	}

	public long getMemberId()
	{
		return MemberId;
	}
	public void setMemberId(long value)
	{
		MemberId = value;
	}
	public short getTotalVariableWindowSize()
	{
		return TotalVariableWindowSize;
	}
	public void setTotalVariableWindowSize(short value)
	{
		TotalVariableWindowSize = value;
	}
	public short getMaxVariableWindowSizeTrader()
	{
		return MaxVariableWindowSizeTrader;
	}
	public void setMaxVariableWindowSizeTrader(short value)
	{
		MaxVariableWindowSizeTrader = value;
	}
	public short getMaxFixedWindowSizeTrader()
	{
		return MaxFixedWindowSizeTrader;
	}
	public void setMaxFixedWindowSizeTrader(short value)
	{
		MaxFixedWindowSizeTrader = value;
	}
	public short getMaxTraderConnected()
	{
		return MaxTraderConnected;
	}
	public void setMaxTraderConnected(short value)
	{
		MaxTraderConnected = value;
	}
	public long getStartDate()
	{
		return StartDate;
	}
	public void setStartDate(long value)
	{
		StartDate = value;
	}
	public long getEndDate()
	{
		return EndDate;
	}
	public void setEndDate(long value)
	{
		EndDate = value;
	}
	public TI_FLAG_Enum getDoubleSidedRFCQEnabledFg()
	{
		return DoubleSidedRFCQEnabledFg;
	}
	public void setDoubleSidedRFCQEnabledFg(TI_FLAG_Enum value)
	{
		DoubleSidedRFCQEnabledFg = value;
	}
	public short getAreaCodeId()
	{
		return AreaCodeId;
	}
	public void setAreaCodeId(short value)
	{
		AreaCodeId = value;
	}
	public short getMaxCustomInstrumentsInChart()
	{
		return MaxCustomInstrumentsInChart;
	}
	public void setMaxCustomInstrumentsInChart(short value)
	{
		MaxCustomInstrumentsInChart = value;
	}
	public TI_FLAG_Enum getUnseasonedBondTradingFg()
	{
		return UnseasonedBondTradingFg;
	}
	public void setUnseasonedBondTradingFg(TI_FLAG_Enum value)
	{
		UnseasonedBondTradingFg = value;
	}
	public String getLeiCode()
	{
		return LeiCode;
	}
	public void setLeiCode(String value)
	{
		LeiCode = value;
	}
	public long getTradingCapacityId()
	{
		return TradingCapacityId;
	}
	public void setTradingCapacityId(long value)
	{
		TradingCapacityId = value;
	}
	public TI_FLAG_Enum getExemptedFromTransparencyFg()
	{
		return ExemptedFromTransparencyFg;
	}
	public void setExemptedFromTransparencyFg(TI_FLAG_Enum value)
	{
		ExemptedFromTransparencyFg = value;
	}
	public short getMaxNumPortfolioRFCQ()
	{
		return MaxNumPortfolioRFCQ;
	}
	public void setMaxNumPortfolioRFCQ(short value)
	{
		MaxNumPortfolioRFCQ = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MemberId = (long)byteBuffer.readInt();
		TotalVariableWindowSize = (short)byteBuffer.readInt();
		MaxVariableWindowSizeTrader = (short)byteBuffer.readInt();
		MaxFixedWindowSizeTrader = (short)byteBuffer.readInt();
		MaxTraderConnected = (short)byteBuffer.readInt();
		StartDate = (long)byteBuffer.readInt();
		EndDate = (long)byteBuffer.readInt();
		DoubleSidedRFCQEnabledFg = DoubleSidedRFCQEnabledFg.getEnum(byteBuffer.readInt());
		AreaCodeId = (short)byteBuffer.readInt();
		MaxCustomInstrumentsInChart = (short)byteBuffer.readInt();
		UnseasonedBondTradingFg = UnseasonedBondTradingFg.getEnum(byteBuffer.readInt());
		LeiCode = byteBuffer.readString();
		TradingCapacityId = (long)byteBuffer.readInt();
		ExemptedFromTransparencyFg = ExemptedFromTransparencyFg.getEnum(byteBuffer.readInt());
		MaxNumPortfolioRFCQ = (short)byteBuffer.readInt();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(TotalVariableWindowSize & 0xFFFFL));
		byteBuffer.writeInt((int)(MaxVariableWindowSizeTrader & 0xFFFFL));
		byteBuffer.writeInt((int)(MaxFixedWindowSizeTrader & 0xFFFFL));
		byteBuffer.writeInt((int)(MaxTraderConnected & 0xFFFFL));
		byteBuffer.writeInt((int)(StartDate & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(EndDate & 0xFFFFFFFFL));
		byteBuffer.writeInt(DoubleSidedRFCQEnabledFg.getValue());
		byteBuffer.writeInt((int)(AreaCodeId & 0xFFFFL));
		byteBuffer.writeInt((int)(MaxCustomInstrumentsInChart & 0xFFFFL));
		byteBuffer.writeInt(UnseasonedBondTradingFg.getValue());
		byteBuffer.writeString(LeiCode);
		byteBuffer.writeInt((int)(TradingCapacityId & 0xFFFFFFFFL));
		byteBuffer.writeInt(ExemptedFromTransparencyFg.getValue());
		byteBuffer.writeInt((int)(MaxNumPortfolioRFCQ & 0xFFFFL));

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
		stringBuilder.append("BV_MEMBER::");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("TotalVariableWindowSize(").append(TotalVariableWindowSize).append(")");
		stringBuilder.append("MaxVariableWindowSizeTrader(").append(MaxVariableWindowSizeTrader).append(")");
		stringBuilder.append("MaxFixedWindowSizeTrader(").append(MaxFixedWindowSizeTrader).append(")");
		stringBuilder.append("MaxTraderConnected(").append(MaxTraderConnected).append(")");
		stringBuilder.append("StartDate(").append(StartDate).append(")");
		stringBuilder.append("EndDate(").append(EndDate).append(")");
		stringBuilder.append("DoubleSidedRFCQEnabledFg(").append(DoubleSidedRFCQEnabledFg).append(")");
		stringBuilder.append("AreaCodeId(").append(AreaCodeId).append(")");
		stringBuilder.append("MaxCustomInstrumentsInChart(").append(MaxCustomInstrumentsInChart).append(")");
		stringBuilder.append("UnseasonedBondTradingFg(").append(UnseasonedBondTradingFg).append(")");
		stringBuilder.append("LeiCode(").append(LeiCode).append(")");
		stringBuilder.append("TradingCapacityId(").append(TradingCapacityId).append(")");
		stringBuilder.append("ExemptedFromTransparencyFg(").append(ExemptedFromTransparencyFg).append(")");
		stringBuilder.append("MaxNumPortfolioRFCQ(").append(MaxNumPortfolioRFCQ).append(")");
		return stringBuilder.toString();
	}
}
