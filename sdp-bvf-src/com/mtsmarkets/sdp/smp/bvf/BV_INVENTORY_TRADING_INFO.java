package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_INVENTORY_TRADING_INFO extends SMPMessage
{
	public static final long CLASS_ID = 114934;

	private long MemberId = 0;
	private String MemberCode = "";
	private String MemberDesc = "";
	private String MemberShortDesc = "";
	private long QuoteId = 0;
	private String DealerReferenceId = "";
	private TI_FLAG_Enum ExecutableFg = TI_FLAG_Enum.TI_FLAG_No;
	private double Price = 0;
	private double Yield = 0;
	private BV_VALUE YTC = new BV_VALUE();
	private BV_VALUE YTW = new BV_VALUE();
	private BV_VALUE YMWTh = new BV_VALUE();
	private double MWCPriceTh = 0;
	private BV_VALUE YMWExrc = new BV_VALUE();
	private BV_VALUE YTR = new BV_VALUE();
	private double Countervalue = 0;
	private double Qty = 0;
	private double MinExecQty = 0;
	private String QuoteDigest = "";
	private long QuoteUpdateTime = 0;
	private TI_FLAG_Enum AxedBonds = TI_FLAG_Enum.TI_FLAG_No;
	private TI_FLAG_Enum SystematicInternaliserFg = TI_FLAG_Enum.TI_FLAG_No;

	public BV_INVENTORY_TRADING_INFO()
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
	public String getMemberCode()
	{
		return MemberCode;
	}
	public void setMemberCode(String value)
	{
		MemberCode = value;
	}
	public String getMemberDesc()
	{
		return MemberDesc;
	}
	public void setMemberDesc(String value)
	{
		MemberDesc = value;
	}
	public String getMemberShortDesc()
	{
		return MemberShortDesc;
	}
	public void setMemberShortDesc(String value)
	{
		MemberShortDesc = value;
	}
	public long getQuoteId()
	{
		return QuoteId;
	}
	public void setQuoteId(long value)
	{
		QuoteId = value;
	}
	public String getDealerReferenceId()
	{
		return DealerReferenceId;
	}
	public void setDealerReferenceId(String value)
	{
		DealerReferenceId = value;
	}
	public TI_FLAG_Enum getExecutableFg()
	{
		return ExecutableFg;
	}
	public void setExecutableFg(TI_FLAG_Enum value)
	{
		ExecutableFg = value;
	}
	public double getPrice()
	{
		return Price;
	}
	public void setPrice(double value)
	{
		Price = value;
	}
	public double getYield()
	{
		return Yield;
	}
	public void setYield(double value)
	{
		Yield = value;
	}
	public BV_VALUE getYTC()
	{
		return YTC;
	}
	public void setYTC(BV_VALUE value)
	{
		YTC = value;
	}
	public BV_VALUE getYTW()
	{
		return YTW;
	}
	public void setYTW(BV_VALUE value)
	{
		YTW = value;
	}
	public BV_VALUE getYMWTh()
	{
		return YMWTh;
	}
	public void setYMWTh(BV_VALUE value)
	{
		YMWTh = value;
	}
	public double getMWCPriceTh()
	{
		return MWCPriceTh;
	}
	public void setMWCPriceTh(double value)
	{
		MWCPriceTh = value;
	}
	public BV_VALUE getYMWExrc()
	{
		return YMWExrc;
	}
	public void setYMWExrc(BV_VALUE value)
	{
		YMWExrc = value;
	}
	public BV_VALUE getYTR()
	{
		return YTR;
	}
	public void setYTR(BV_VALUE value)
	{
		YTR = value;
	}
	public double getCountervalue()
	{
		return Countervalue;
	}
	public void setCountervalue(double value)
	{
		Countervalue = value;
	}
	public double getQty()
	{
		return Qty;
	}
	public void setQty(double value)
	{
		Qty = value;
	}
	public double getMinExecQty()
	{
		return MinExecQty;
	}
	public void setMinExecQty(double value)
	{
		MinExecQty = value;
	}
	public String getQuoteDigest()
	{
		return QuoteDigest;
	}
	public void setQuoteDigest(String value)
	{
		QuoteDigest = value;
	}
	public long getQuoteUpdateTime()
	{
		return QuoteUpdateTime;
	}
	public void setQuoteUpdateTime(long value)
	{
		QuoteUpdateTime = value;
	}
	public TI_FLAG_Enum getAxedBonds()
	{
		return AxedBonds;
	}
	public void setAxedBonds(TI_FLAG_Enum value)
	{
		AxedBonds = value;
	}
	public TI_FLAG_Enum getSystematicInternaliserFg()
	{
		return SystematicInternaliserFg;
	}
	public void setSystematicInternaliserFg(TI_FLAG_Enum value)
	{
		SystematicInternaliserFg = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MemberId = (long)byteBuffer.readInt();
		MemberCode = byteBuffer.readString();
		MemberDesc = byteBuffer.readString();
		MemberShortDesc = byteBuffer.readString();
		QuoteId = (long)byteBuffer.readInt();
		DealerReferenceId = byteBuffer.readString();
		ExecutableFg = ExecutableFg.getEnum(byteBuffer.readInt());
		Price = byteBuffer.readDouble();
		Yield = byteBuffer.readDouble();
		YTC.readXDR(byteBuffer);
		YTW.readXDR(byteBuffer);
		YMWTh.readXDR(byteBuffer);
		MWCPriceTh = byteBuffer.readDouble();
		YMWExrc.readXDR(byteBuffer);
		YTR.readXDR(byteBuffer);
		Countervalue = byteBuffer.readDouble();
		Qty = byteBuffer.readDouble();
		MinExecQty = byteBuffer.readDouble();
		QuoteDigest = byteBuffer.readString();
		QuoteUpdateTime = byteBuffer.readLong();
		AxedBonds = AxedBonds.getEnum(byteBuffer.readInt());
		SystematicInternaliserFg = SystematicInternaliserFg.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MemberId & 0xFFFFFFFFL));
		byteBuffer.writeString(MemberCode);
		byteBuffer.writeString(MemberDesc);
		byteBuffer.writeString(MemberShortDesc);
		byteBuffer.writeInt((int)(QuoteId & 0xFFFFFFFFL));
		byteBuffer.writeString(DealerReferenceId);
		byteBuffer.writeInt(ExecutableFg.getValue());
		byteBuffer.writeDouble(Price);
		byteBuffer.writeDouble(Yield);
		YTC.writeXDR(byteBuffer);
		YTW.writeXDR(byteBuffer);
		YMWTh.writeXDR(byteBuffer);
		byteBuffer.writeDouble(MWCPriceTh);
		YMWExrc.writeXDR(byteBuffer);
		YTR.writeXDR(byteBuffer);
		byteBuffer.writeDouble(Countervalue);
		byteBuffer.writeDouble(Qty);
		byteBuffer.writeDouble(MinExecQty);
		byteBuffer.writeString(QuoteDigest);
		byteBuffer.writeLong(QuoteUpdateTime);
		byteBuffer.writeInt(AxedBonds.getValue());
		byteBuffer.writeInt(SystematicInternaliserFg.getValue());

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
		stringBuilder.append("BV_INVENTORY_TRADING_INFO::");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("MemberCode(").append(MemberCode).append(")");
		stringBuilder.append("MemberDesc(").append(MemberDesc).append(")");
		stringBuilder.append("MemberShortDesc(").append(MemberShortDesc).append(")");
		stringBuilder.append("QuoteId(").append(QuoteId).append(")");
		stringBuilder.append("DealerReferenceId(").append(DealerReferenceId).append(")");
		stringBuilder.append("ExecutableFg(").append(ExecutableFg).append(")");
		stringBuilder.append("Price(").append(Price).append(")");
		stringBuilder.append("Yield(").append(Yield).append(")");
		stringBuilder.append("YTC(").append(YTC.toString()).append(")");
		stringBuilder.append("YTW(").append(YTW.toString()).append(")");
		stringBuilder.append("YMWTh(").append(YMWTh.toString()).append(")");
		stringBuilder.append("MWCPriceTh(").append(MWCPriceTh).append(")");
		stringBuilder.append("YMWExrc(").append(YMWExrc.toString()).append(")");
		stringBuilder.append("YTR(").append(YTR.toString()).append(")");
		stringBuilder.append("Countervalue(").append(Countervalue).append(")");
		stringBuilder.append("Qty(").append(Qty).append(")");
		stringBuilder.append("MinExecQty(").append(MinExecQty).append(")");
		stringBuilder.append("QuoteDigest(").append(QuoteDigest).append(")");
		stringBuilder.append("QuoteUpdateTime(").append(QuoteUpdateTime).append(")");
		stringBuilder.append("AxedBonds(").append(AxedBonds).append(")");
		stringBuilder.append("SystematicInternaliserFg(").append(SystematicInternaliserFg).append(")");
		return stringBuilder.toString();
	}
}
