package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_AXE_INFO extends SMPMessage
{
	public static final long CLASS_ID = 400047;

	private long MemberId = 0;
	private BV_INSTRUMENT_INFO Instrument = new BV_INSTRUMENT_INFO();
	private long SectionId = 0;
	private TI_FLAG_Enum BidFg = TI_FLAG_Enum.TI_FLAG_No;
	private TI_FLAG_Enum AskFg = TI_FLAG_Enum.TI_FLAG_No;
	private long BidAxeNr = 0;
	private double BidAxeSize = 0;
	private long AskAxeNr = 0;
	private double AskAxeSize = 0;
	private long UpdateTime = 0;

	public BV_AXE_INFO()
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
	public BV_INSTRUMENT_INFO getInstrument()
	{
		return Instrument;
	}
	public void setInstrument(BV_INSTRUMENT_INFO value)
	{
		Instrument = value;
	}
	public long getSectionId()
	{
		return SectionId;
	}
	public void setSectionId(long value)
	{
		SectionId = value;
	}
	public TI_FLAG_Enum getBidFg()
	{
		return BidFg;
	}
	public void setBidFg(TI_FLAG_Enum value)
	{
		BidFg = value;
	}
	public TI_FLAG_Enum getAskFg()
	{
		return AskFg;
	}
	public void setAskFg(TI_FLAG_Enum value)
	{
		AskFg = value;
	}
	public long getBidAxeNr()
	{
		return BidAxeNr;
	}
	public void setBidAxeNr(long value)
	{
		BidAxeNr = value;
	}
	public double getBidAxeSize()
	{
		return BidAxeSize;
	}
	public void setBidAxeSize(double value)
	{
		BidAxeSize = value;
	}
	public long getAskAxeNr()
	{
		return AskAxeNr;
	}
	public void setAskAxeNr(long value)
	{
		AskAxeNr = value;
	}
	public double getAskAxeSize()
	{
		return AskAxeSize;
	}
	public void setAskAxeSize(double value)
	{
		AskAxeSize = value;
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
		MemberId = (long)byteBuffer.readInt();
		Instrument.readXDR(byteBuffer);
		SectionId = (long)byteBuffer.readInt();
		BidFg = BidFg.getEnum(byteBuffer.readInt());
		AskFg = AskFg.getEnum(byteBuffer.readInt());
		BidAxeNr = (long)byteBuffer.readInt();
		BidAxeSize = byteBuffer.readDouble();
		AskAxeNr = (long)byteBuffer.readInt();
		AskAxeSize = byteBuffer.readDouble();
		UpdateTime = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MemberId & 0xFFFFFFFFL));
		Instrument.writeXDR(byteBuffer);
		byteBuffer.writeInt((int)(SectionId & 0xFFFFFFFFL));
		byteBuffer.writeInt(BidFg.getValue());
		byteBuffer.writeInt(AskFg.getValue());
		byteBuffer.writeInt((int)(BidAxeNr & 0xFFFFFFFFL));
		byteBuffer.writeDouble(BidAxeSize);
		byteBuffer.writeInt((int)(AskAxeNr & 0xFFFFFFFFL));
		byteBuffer.writeDouble(AskAxeSize);
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
		stringBuilder.append("BV_AXE_INFO::");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("Instrument(").append(Instrument.toString()).append(")");
		stringBuilder.append("SectionId(").append(SectionId).append(")");
		stringBuilder.append("BidFg(").append(BidFg).append(")");
		stringBuilder.append("AskFg(").append(AskFg).append(")");
		stringBuilder.append("BidAxeNr(").append(BidAxeNr).append(")");
		stringBuilder.append("BidAxeSize(").append(BidAxeSize).append(")");
		stringBuilder.append("AskAxeNr(").append(AskAxeNr).append(")");
		stringBuilder.append("AskAxeSize(").append(AskAxeSize).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		return stringBuilder.toString();
	}
}
