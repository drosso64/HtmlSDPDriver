package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_BASIS_CONVERSION_FACTOR extends SMPMessage
{
	public static final long CLASS_ID = 400070;

	private long FutureId = 0;
	private long BondId = 0;
	private double ConversionFactor = 0;
	private TI_FLAG_Enum DeliverableFg = TI_FLAG_Enum.TI_FLAG_No;

	public BV_BASIS_CONVERSION_FACTOR()
	{
	}

	public long getFutureId()
	{
		return FutureId;
	}
	public void setFutureId(long value)
	{
		FutureId = value;
	}
	public long getBondId()
	{
		return BondId;
	}
	public void setBondId(long value)
	{
		BondId = value;
	}
	public double getConversionFactor()
	{
		return ConversionFactor;
	}
	public void setConversionFactor(double value)
	{
		ConversionFactor = value;
	}
	public TI_FLAG_Enum getDeliverableFg()
	{
		return DeliverableFg;
	}
	public void setDeliverableFg(TI_FLAG_Enum value)
	{
		DeliverableFg = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		FutureId = (long)byteBuffer.readInt();
		BondId = (long)byteBuffer.readInt();
		ConversionFactor = byteBuffer.readDouble();
		DeliverableFg = DeliverableFg.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(FutureId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(BondId & 0xFFFFFFFFL));
		byteBuffer.writeDouble(ConversionFactor);
		byteBuffer.writeInt(DeliverableFg.getValue());

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
		stringBuilder.append("BV_BASIS_CONVERSION_FACTOR::");
		stringBuilder.append("FutureId(").append(FutureId).append(")");
		stringBuilder.append("BondId(").append(BondId).append(")");
		stringBuilder.append("ConversionFactor(").append(ConversionFactor).append(")");
		stringBuilder.append("DeliverableFg(").append(DeliverableFg).append(")");
		return stringBuilder.toString();
	}
}
