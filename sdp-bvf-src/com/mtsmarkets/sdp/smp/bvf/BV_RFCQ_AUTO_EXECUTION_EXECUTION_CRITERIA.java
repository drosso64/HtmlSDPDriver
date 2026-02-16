package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_RFCQ_AUTO_EXECUTION_EXECUTION_CRITERIA extends SMPMessage
{
	public static final long CLASS_ID = 114999;

	private short MinimumDealers = 0;
	private short MinNegotiationTime = 0;
	private short MaxNegotiationTime = 0;
	private BV_RFCQ_AUTO_EXECUTION_EXECUTION_SPREAD SpreadVsCMF = new BV_RFCQ_AUTO_EXECUTION_EXECUTION_SPREAD();
	private BV_RFCQ_AUTO_EXECUTION_EXECUTION_SPREAD SpreadVsBV = new BV_RFCQ_AUTO_EXECUTION_EXECUTION_SPREAD();
	private double WideSpread = 0;
	private TI_FLAG_Enum SubjectQuotesFg = TI_FLAG_Enum.TI_FLAG_No;

	public BV_RFCQ_AUTO_EXECUTION_EXECUTION_CRITERIA()
	{
	}

	public short getMinimumDealers()
	{
		return MinimumDealers;
	}
	public void setMinimumDealers(short value)
	{
		MinimumDealers = value;
	}
	public short getMinNegotiationTime()
	{
		return MinNegotiationTime;
	}
	public void setMinNegotiationTime(short value)
	{
		MinNegotiationTime = value;
	}
	public short getMaxNegotiationTime()
	{
		return MaxNegotiationTime;
	}
	public void setMaxNegotiationTime(short value)
	{
		MaxNegotiationTime = value;
	}
	public BV_RFCQ_AUTO_EXECUTION_EXECUTION_SPREAD getSpreadVsCMF()
	{
		return SpreadVsCMF;
	}
	public void setSpreadVsCMF(BV_RFCQ_AUTO_EXECUTION_EXECUTION_SPREAD value)
	{
		SpreadVsCMF = value;
	}
	public BV_RFCQ_AUTO_EXECUTION_EXECUTION_SPREAD getSpreadVsBV()
	{
		return SpreadVsBV;
	}
	public void setSpreadVsBV(BV_RFCQ_AUTO_EXECUTION_EXECUTION_SPREAD value)
	{
		SpreadVsBV = value;
	}
	public double getWideSpread()
	{
		return WideSpread;
	}
	public void setWideSpread(double value)
	{
		WideSpread = value;
	}
	public TI_FLAG_Enum getSubjectQuotesFg()
	{
		return SubjectQuotesFg;
	}
	public void setSubjectQuotesFg(TI_FLAG_Enum value)
	{
		SubjectQuotesFg = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MinimumDealers = (short)byteBuffer.readInt();
		MinNegotiationTime = (short)byteBuffer.readInt();
		MaxNegotiationTime = (short)byteBuffer.readInt();
		SpreadVsCMF.readXDR(byteBuffer);
		SpreadVsBV.readXDR(byteBuffer);
		WideSpread = byteBuffer.readDouble();
		SubjectQuotesFg = SubjectQuotesFg.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MinimumDealers & 0xFFFFL));
		byteBuffer.writeInt((int)(MinNegotiationTime & 0xFFFFL));
		byteBuffer.writeInt((int)(MaxNegotiationTime & 0xFFFFL));
		SpreadVsCMF.writeXDR(byteBuffer);
		SpreadVsBV.writeXDR(byteBuffer);
		byteBuffer.writeDouble(WideSpread);
		byteBuffer.writeInt(SubjectQuotesFg.getValue());

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
		stringBuilder.append("BV_RFCQ_AUTO_EXECUTION_EXECUTION_CRITERIA::");
		stringBuilder.append("MinimumDealers(").append(MinimumDealers).append(")");
		stringBuilder.append("MinNegotiationTime(").append(MinNegotiationTime).append(")");
		stringBuilder.append("MaxNegotiationTime(").append(MaxNegotiationTime).append(")");
		stringBuilder.append("SpreadVsCMF(").append(SpreadVsCMF.toString()).append(")");
		stringBuilder.append("SpreadVsBV(").append(SpreadVsBV.toString()).append(")");
		stringBuilder.append("WideSpread(").append(WideSpread).append(")");
		stringBuilder.append("SubjectQuotesFg(").append(SubjectQuotesFg).append(")");
		return stringBuilder.toString();
	}
}
