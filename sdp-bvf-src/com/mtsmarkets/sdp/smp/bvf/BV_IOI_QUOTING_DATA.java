package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_IOI_QUOTING_DATA extends SMPMessage
{
	public static final long CLASS_ID = 114980;

	private double Quantity = 0;
	private double Price = 0;
	private String Currency = "";
	private double Yield = 0;
	private BV_YIELD_TYPE_Enum YieldType = BV_YIELD_TYPE_Enum.BV_YIELD_TYPE_None;
	private TI_FLAG_Enum NaturalFg = TI_FLAG_Enum.TI_FLAG_No;
	private TI_FLAG_Enum AxeFg = TI_FLAG_Enum.TI_FLAG_No;
	private TI_FLAG_Enum MoreBehindFg = TI_FLAG_Enum.TI_FLAG_No;
	private TI_FLAG_Enum InventoryFg = TI_FLAG_Enum.TI_FLAG_No;
	private long BenchmarkId = 0;
	private BV_VALUE Spread = new BV_VALUE();
	private BV_IOI_VALUE ASWSpread = new BV_IOI_VALUE();
	private BV_IOI_VALUE OISSpread = new BV_IOI_VALUE();
	private BV_IOI_VALUE ZSpread = new BV_IOI_VALUE();
	private BV_IOI_VALUE DMSpread = new BV_IOI_VALUE();
	private BV_IOI_VALUE ISpread = new BV_IOI_VALUE();
	private BV_IOI_VALUE OASpread = new BV_IOI_VALUE();
	private BV_IOI_VALUE GSpread = new BV_IOI_VALUE();
	private BV_IOI_VALUE CDSBasis = new BV_IOI_VALUE();
	private BV_IOI_VALUE CDSInterpolatedBasis = new BV_IOI_VALUE();

	public BV_IOI_QUOTING_DATA()
	{
	}

	public double getQuantity()
	{
		return Quantity;
	}
	public void setQuantity(double value)
	{
		Quantity = value;
	}
	public double getPrice()
	{
		return Price;
	}
	public void setPrice(double value)
	{
		Price = value;
	}
	public String getCurrency()
	{
		return Currency;
	}
	public void setCurrency(String value)
	{
		Currency = value;
	}
	public double getYield()
	{
		return Yield;
	}
	public void setYield(double value)
	{
		Yield = value;
	}
	public BV_YIELD_TYPE_Enum getYieldType()
	{
		return YieldType;
	}
	public void setYieldType(BV_YIELD_TYPE_Enum value)
	{
		YieldType = value;
	}
	public TI_FLAG_Enum getNaturalFg()
	{
		return NaturalFg;
	}
	public void setNaturalFg(TI_FLAG_Enum value)
	{
		NaturalFg = value;
	}
	public TI_FLAG_Enum getAxeFg()
	{
		return AxeFg;
	}
	public void setAxeFg(TI_FLAG_Enum value)
	{
		AxeFg = value;
	}
	public TI_FLAG_Enum getMoreBehindFg()
	{
		return MoreBehindFg;
	}
	public void setMoreBehindFg(TI_FLAG_Enum value)
	{
		MoreBehindFg = value;
	}
	public TI_FLAG_Enum getInventoryFg()
	{
		return InventoryFg;
	}
	public void setInventoryFg(TI_FLAG_Enum value)
	{
		InventoryFg = value;
	}
	public long getBenchmarkId()
	{
		return BenchmarkId;
	}
	public void setBenchmarkId(long value)
	{
		BenchmarkId = value;
	}
	public BV_VALUE getSpread()
	{
		return Spread;
	}
	public void setSpread(BV_VALUE value)
	{
		Spread = value;
	}
	public BV_IOI_VALUE getASWSpread()
	{
		return ASWSpread;
	}
	public void setASWSpread(BV_IOI_VALUE value)
	{
		ASWSpread = value;
	}
	public BV_IOI_VALUE getOISSpread()
	{
		return OISSpread;
	}
	public void setOISSpread(BV_IOI_VALUE value)
	{
		OISSpread = value;
	}
	public BV_IOI_VALUE getZSpread()
	{
		return ZSpread;
	}
	public void setZSpread(BV_IOI_VALUE value)
	{
		ZSpread = value;
	}
	public BV_IOI_VALUE getDMSpread()
	{
		return DMSpread;
	}
	public void setDMSpread(BV_IOI_VALUE value)
	{
		DMSpread = value;
	}
	public BV_IOI_VALUE getISpread()
	{
		return ISpread;
	}
	public void setISpread(BV_IOI_VALUE value)
	{
		ISpread = value;
	}
	public BV_IOI_VALUE getOASpread()
	{
		return OASpread;
	}
	public void setOASpread(BV_IOI_VALUE value)
	{
		OASpread = value;
	}
	public BV_IOI_VALUE getGSpread()
	{
		return GSpread;
	}
	public void setGSpread(BV_IOI_VALUE value)
	{
		GSpread = value;
	}
	public BV_IOI_VALUE getCDSBasis()
	{
		return CDSBasis;
	}
	public void setCDSBasis(BV_IOI_VALUE value)
	{
		CDSBasis = value;
	}
	public BV_IOI_VALUE getCDSInterpolatedBasis()
	{
		return CDSInterpolatedBasis;
	}
	public void setCDSInterpolatedBasis(BV_IOI_VALUE value)
	{
		CDSInterpolatedBasis = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		Quantity = byteBuffer.readDouble();
		Price = byteBuffer.readDouble();
		Currency = byteBuffer.readString();
		Yield = byteBuffer.readDouble();
		YieldType = YieldType.getEnum(byteBuffer.readInt());
		NaturalFg = NaturalFg.getEnum(byteBuffer.readInt());
		AxeFg = AxeFg.getEnum(byteBuffer.readInt());
		MoreBehindFg = MoreBehindFg.getEnum(byteBuffer.readInt());
		InventoryFg = InventoryFg.getEnum(byteBuffer.readInt());
		BenchmarkId = (long)byteBuffer.readInt();
		Spread.readXDR(byteBuffer);
		ASWSpread.readXDR(byteBuffer);
		OISSpread.readXDR(byteBuffer);
		ZSpread.readXDR(byteBuffer);
		DMSpread.readXDR(byteBuffer);
		ISpread.readXDR(byteBuffer);
		OASpread.readXDR(byteBuffer);
		GSpread.readXDR(byteBuffer);
		CDSBasis.readXDR(byteBuffer);
		CDSInterpolatedBasis.readXDR(byteBuffer);
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeDouble(Quantity);
		byteBuffer.writeDouble(Price);
		byteBuffer.writeString(Currency);
		byteBuffer.writeDouble(Yield);
		byteBuffer.writeInt(YieldType.getValue());
		byteBuffer.writeInt(NaturalFg.getValue());
		byteBuffer.writeInt(AxeFg.getValue());
		byteBuffer.writeInt(MoreBehindFg.getValue());
		byteBuffer.writeInt(InventoryFg.getValue());
		byteBuffer.writeInt((int)(BenchmarkId & 0xFFFFFFFFL));
		Spread.writeXDR(byteBuffer);
		ASWSpread.writeXDR(byteBuffer);
		OISSpread.writeXDR(byteBuffer);
		ZSpread.writeXDR(byteBuffer);
		DMSpread.writeXDR(byteBuffer);
		ISpread.writeXDR(byteBuffer);
		OASpread.writeXDR(byteBuffer);
		GSpread.writeXDR(byteBuffer);
		CDSBasis.writeXDR(byteBuffer);
		CDSInterpolatedBasis.writeXDR(byteBuffer);

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
		stringBuilder.append("BV_IOI_QUOTING_DATA::");
		stringBuilder.append("Quantity(").append(Quantity).append(")");
		stringBuilder.append("Price(").append(Price).append(")");
		stringBuilder.append("Currency(").append(Currency).append(")");
		stringBuilder.append("Yield(").append(Yield).append(")");
		stringBuilder.append("YieldType(").append(YieldType).append(")");
		stringBuilder.append("NaturalFg(").append(NaturalFg).append(")");
		stringBuilder.append("AxeFg(").append(AxeFg).append(")");
		stringBuilder.append("MoreBehindFg(").append(MoreBehindFg).append(")");
		stringBuilder.append("InventoryFg(").append(InventoryFg).append(")");
		stringBuilder.append("BenchmarkId(").append(BenchmarkId).append(")");
		stringBuilder.append("Spread(").append(Spread.toString()).append(")");
		stringBuilder.append("ASWSpread(").append(ASWSpread.toString()).append(")");
		stringBuilder.append("OISSpread(").append(OISSpread.toString()).append(")");
		stringBuilder.append("ZSpread(").append(ZSpread.toString()).append(")");
		stringBuilder.append("DMSpread(").append(DMSpread.toString()).append(")");
		stringBuilder.append("ISpread(").append(ISpread.toString()).append(")");
		stringBuilder.append("OASpread(").append(OASpread.toString()).append(")");
		stringBuilder.append("GSpread(").append(GSpread.toString()).append(")");
		stringBuilder.append("CDSBasis(").append(CDSBasis.toString()).append(")");
		stringBuilder.append("CDSInterpolatedBasis(").append(CDSInterpolatedBasis.toString()).append(")");
		return stringBuilder.toString();
	}
}
