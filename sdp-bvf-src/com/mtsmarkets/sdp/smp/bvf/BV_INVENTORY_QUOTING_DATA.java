package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_INVENTORY_QUOTING_DATA extends SMPMessage
{
	public static final long CLASS_ID = 114931;

	private double Quotation = 0;
	private double TotalQty = 0;
	private double VisibleQty = 0;
	private double MinExecQty = 0;
	private TI_FLAG_Enum AxedBonds = TI_FLAG_Enum.TI_FLAG_No;

	public BV_INVENTORY_QUOTING_DATA()
	{
	}

	public double getQuotation()
	{
		return Quotation;
	}
	public void setQuotation(double value)
	{
		Quotation = value;
	}
	public double getTotalQty()
	{
		return TotalQty;
	}
	public void setTotalQty(double value)
	{
		TotalQty = value;
	}
	public double getVisibleQty()
	{
		return VisibleQty;
	}
	public void setVisibleQty(double value)
	{
		VisibleQty = value;
	}
	public double getMinExecQty()
	{
		return MinExecQty;
	}
	public void setMinExecQty(double value)
	{
		MinExecQty = value;
	}
	public TI_FLAG_Enum getAxedBonds()
	{
		return AxedBonds;
	}
	public void setAxedBonds(TI_FLAG_Enum value)
	{
		AxedBonds = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		Quotation = byteBuffer.readDouble();
		TotalQty = byteBuffer.readDouble();
		VisibleQty = byteBuffer.readDouble();
		MinExecQty = byteBuffer.readDouble();
		AxedBonds = AxedBonds.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeDouble(Quotation);
		byteBuffer.writeDouble(TotalQty);
		byteBuffer.writeDouble(VisibleQty);
		byteBuffer.writeDouble(MinExecQty);
		byteBuffer.writeInt(AxedBonds.getValue());

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
		stringBuilder.append("BV_INVENTORY_QUOTING_DATA::");
		stringBuilder.append("Quotation(").append(Quotation).append(")");
		stringBuilder.append("TotalQty(").append(TotalQty).append(")");
		stringBuilder.append("VisibleQty(").append(VisibleQty).append(")");
		stringBuilder.append("MinExecQty(").append(MinExecQty).append(")");
		stringBuilder.append("AxedBonds(").append(AxedBonds).append(")");
		return stringBuilder.toString();
	}
}
