package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_PORTFOLIO_RFCQ_DEPTH_LEG extends SMPMessage
{
	public static final long CLASS_ID = 410020;

	private short LegId = 0;
	private BV_INSTRUMENT_INFO Instrument = new BV_INSTRUMENT_INFO();
	private TI_VERB_Enum Verb = TI_VERB_Enum.TI_VERB_Buy;
	private double Quantity = 0;
	private double BVMidPrice = 0;
	private double BVMidYield = 0;
	private double BVMidProceeds = 0;

	public BV_PORTFOLIO_RFCQ_DEPTH_LEG()
	{
	}

	public short getLegId()
	{
		return LegId;
	}
	public void setLegId(short value)
	{
		LegId = value;
	}
	public BV_INSTRUMENT_INFO getInstrument()
	{
		return Instrument;
	}
	public void setInstrument(BV_INSTRUMENT_INFO value)
	{
		Instrument = value;
	}
	public TI_VERB_Enum getVerb()
	{
		return Verb;
	}
	public void setVerb(TI_VERB_Enum value)
	{
		Verb = value;
	}
	public double getQuantity()
	{
		return Quantity;
	}
	public void setQuantity(double value)
	{
		Quantity = value;
	}
	public double getBVMidPrice()
	{
		return BVMidPrice;
	}
	public void setBVMidPrice(double value)
	{
		BVMidPrice = value;
	}
	public double getBVMidYield()
	{
		return BVMidYield;
	}
	public void setBVMidYield(double value)
	{
		BVMidYield = value;
	}
	public double getBVMidProceeds()
	{
		return BVMidProceeds;
	}
	public void setBVMidProceeds(double value)
	{
		BVMidProceeds = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		LegId = (short)byteBuffer.readInt();
		Instrument.readXDR(byteBuffer);
		Verb = Verb.getEnum(byteBuffer.readInt());
		Quantity = byteBuffer.readDouble();
		BVMidPrice = byteBuffer.readDouble();
		BVMidYield = byteBuffer.readDouble();
		BVMidProceeds = byteBuffer.readDouble();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(LegId & 0xFFFFL));
		Instrument.writeXDR(byteBuffer);
		byteBuffer.writeInt(Verb.getValue());
		byteBuffer.writeDouble(Quantity);
		byteBuffer.writeDouble(BVMidPrice);
		byteBuffer.writeDouble(BVMidYield);
		byteBuffer.writeDouble(BVMidProceeds);

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
		stringBuilder.append("BV_PORTFOLIO_RFCQ_DEPTH_LEG::");
		stringBuilder.append("LegId(").append(LegId).append(")");
		stringBuilder.append("Instrument(").append(Instrument.toString()).append(")");
		stringBuilder.append("Verb(").append(Verb).append(")");
		stringBuilder.append("Quantity(").append(Quantity).append(")");
		stringBuilder.append("BVMidPrice(").append(BVMidPrice).append(")");
		stringBuilder.append("BVMidYield(").append(BVMidYield).append(")");
		stringBuilder.append("BVMidProceeds(").append(BVMidProceeds).append(")");
		return stringBuilder.toString();
	}
}
