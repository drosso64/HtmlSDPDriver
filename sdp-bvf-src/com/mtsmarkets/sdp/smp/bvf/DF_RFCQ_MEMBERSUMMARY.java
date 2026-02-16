package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class DF_RFCQ_MEMBERSUMMARY extends SMPMessage
{
	public static final long CLASS_ID = 170027;

	private long MarketId = 0;
	private long MemberId = 0;
	private String CurrencyCode = "";
	private DF_RFCQ_TRADING_INFO TradInfo = new DF_RFCQ_TRADING_INFO();
	private double ActiveDealsNominalValue = 0;
	private DF_RFCQ_SUBTOT_INFO SubTotActiveDeals = new DF_RFCQ_SUBTOT_INFO();
	private double CancDealsNominalValue = 0;
	private DF_RFCQ_SUBTOT_INFO SubTotCancDeals = new DF_RFCQ_SUBTOT_INFO();

	public DF_RFCQ_MEMBERSUMMARY()
	{
	}

	public long getMarketId()
	{
		return MarketId;
	}
	public void setMarketId(long value)
	{
		MarketId = value;
	}
	public long getMemberId()
	{
		return MemberId;
	}
	public void setMemberId(long value)
	{
		MemberId = value;
	}
	public String getCurrencyCode()
	{
		return CurrencyCode;
	}
	public void setCurrencyCode(String value)
	{
		CurrencyCode = value;
	}
	public DF_RFCQ_TRADING_INFO getTradInfo()
	{
		return TradInfo;
	}
	public void setTradInfo(DF_RFCQ_TRADING_INFO value)
	{
		TradInfo = value;
	}
	public double getActiveDealsNominalValue()
	{
		return ActiveDealsNominalValue;
	}
	public void setActiveDealsNominalValue(double value)
	{
		ActiveDealsNominalValue = value;
	}
	public DF_RFCQ_SUBTOT_INFO getSubTotActiveDeals()
	{
		return SubTotActiveDeals;
	}
	public void setSubTotActiveDeals(DF_RFCQ_SUBTOT_INFO value)
	{
		SubTotActiveDeals = value;
	}
	public double getCancDealsNominalValue()
	{
		return CancDealsNominalValue;
	}
	public void setCancDealsNominalValue(double value)
	{
		CancDealsNominalValue = value;
	}
	public DF_RFCQ_SUBTOT_INFO getSubTotCancDeals()
	{
		return SubTotCancDeals;
	}
	public void setSubTotCancDeals(DF_RFCQ_SUBTOT_INFO value)
	{
		SubTotCancDeals = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MarketId = (long)byteBuffer.readInt();
		MemberId = (long)byteBuffer.readInt();
		CurrencyCode = byteBuffer.readString();
		TradInfo.readXDR(byteBuffer);
		ActiveDealsNominalValue = byteBuffer.readDouble();
		SubTotActiveDeals.readXDR(byteBuffer);
		CancDealsNominalValue = byteBuffer.readDouble();
		SubTotCancDeals.readXDR(byteBuffer);
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MarketId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(MemberId & 0xFFFFFFFFL));
		byteBuffer.writeString(CurrencyCode);
		TradInfo.writeXDR(byteBuffer);
		byteBuffer.writeDouble(ActiveDealsNominalValue);
		SubTotActiveDeals.writeXDR(byteBuffer);
		byteBuffer.writeDouble(CancDealsNominalValue);
		SubTotCancDeals.writeXDR(byteBuffer);

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
		stringBuilder.append("DF_RFCQ_MEMBERSUMMARY::");
		stringBuilder.append("MarketId(").append(MarketId).append(")");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("CurrencyCode(").append(CurrencyCode).append(")");
		stringBuilder.append("TradInfo(").append(TradInfo.toString()).append(")");
		stringBuilder.append("ActiveDealsNominalValue(").append(ActiveDealsNominalValue).append(")");
		stringBuilder.append("SubTotActiveDeals(").append(SubTotActiveDeals.toString()).append(")");
		stringBuilder.append("CancDealsNominalValue(").append(CancDealsNominalValue).append(")");
		stringBuilder.append("SubTotCancDeals(").append(SubTotCancDeals.toString()).append(")");
		return stringBuilder.toString();
	}
}
