package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class GOV_BV_OFFICIAL_PRICE_PREVIEW extends SMPMessage
{
	public static final long CLASS_ID = 114802;

	private BV_OFFICIAL_PRICE_INFO OffPriceInfo = new BV_OFFICIAL_PRICE_INFO();
	private long OffPriceDate = 0;
	private double MinPrice = 0;
	private double MaxPrice = 0;
	private double AvgPrice = 0;
	private double MinYield = 0;
	private double MaxYield = 0;
	private double AvgYield = 0;
	private double Qty = 0;
	private double NominalValue = 0;
	private double FirstPrice = 0;
	private double FirstYield = 0;
	private double LastPrice = 0;
	private double LastYield = 0;
	private String Currency = "";
	private long NumberOfTrades = 0;
	private long CreateTime = 0;
	private TI_TRADE_TYPE_Enum TradeType = TI_TRADE_TYPE_Enum.TI_TRADE_TYPE_Normal;
	private short MarketAffiliation = 0;
	private short AreaCodeId = 0;

	public GOV_BV_OFFICIAL_PRICE_PREVIEW()
	{
	}

	public BV_OFFICIAL_PRICE_INFO getOffPriceInfo()
	{
		return OffPriceInfo;
	}
	public void setOffPriceInfo(BV_OFFICIAL_PRICE_INFO value)
	{
		OffPriceInfo = value;
	}
	public long getOffPriceDate()
	{
		return OffPriceDate;
	}
	public void setOffPriceDate(long value)
	{
		OffPriceDate = value;
	}
	public double getMinPrice()
	{
		return MinPrice;
	}
	public void setMinPrice(double value)
	{
		MinPrice = value;
	}
	public double getMaxPrice()
	{
		return MaxPrice;
	}
	public void setMaxPrice(double value)
	{
		MaxPrice = value;
	}
	public double getAvgPrice()
	{
		return AvgPrice;
	}
	public void setAvgPrice(double value)
	{
		AvgPrice = value;
	}
	public double getMinYield()
	{
		return MinYield;
	}
	public void setMinYield(double value)
	{
		MinYield = value;
	}
	public double getMaxYield()
	{
		return MaxYield;
	}
	public void setMaxYield(double value)
	{
		MaxYield = value;
	}
	public double getAvgYield()
	{
		return AvgYield;
	}
	public void setAvgYield(double value)
	{
		AvgYield = value;
	}
	public double getQty()
	{
		return Qty;
	}
	public void setQty(double value)
	{
		Qty = value;
	}
	public double getNominalValue()
	{
		return NominalValue;
	}
	public void setNominalValue(double value)
	{
		NominalValue = value;
	}
	public double getFirstPrice()
	{
		return FirstPrice;
	}
	public void setFirstPrice(double value)
	{
		FirstPrice = value;
	}
	public double getFirstYield()
	{
		return FirstYield;
	}
	public void setFirstYield(double value)
	{
		FirstYield = value;
	}
	public double getLastPrice()
	{
		return LastPrice;
	}
	public void setLastPrice(double value)
	{
		LastPrice = value;
	}
	public double getLastYield()
	{
		return LastYield;
	}
	public void setLastYield(double value)
	{
		LastYield = value;
	}
	public String getCurrency()
	{
		return Currency;
	}
	public void setCurrency(String value)
	{
		Currency = value;
	}
	public long getNumberOfTrades()
	{
		return NumberOfTrades;
	}
	public void setNumberOfTrades(long value)
	{
		NumberOfTrades = value;
	}
	public long getCreateTime()
	{
		return CreateTime;
	}
	public void setCreateTime(long value)
	{
		CreateTime = value;
	}
	public TI_TRADE_TYPE_Enum getTradeType()
	{
		return TradeType;
	}
	public void setTradeType(TI_TRADE_TYPE_Enum value)
	{
		TradeType = value;
	}
	public short getMarketAffiliation()
	{
		return MarketAffiliation;
	}
	public void setMarketAffiliation(short value)
	{
		MarketAffiliation = value;
	}
	public short getAreaCodeId()
	{
		return AreaCodeId;
	}
	public void setAreaCodeId(short value)
	{
		AreaCodeId = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		OffPriceInfo.readXDR(byteBuffer);
		OffPriceDate = (long)byteBuffer.readInt();
		MinPrice = byteBuffer.readDouble();
		MaxPrice = byteBuffer.readDouble();
		AvgPrice = byteBuffer.readDouble();
		MinYield = byteBuffer.readDouble();
		MaxYield = byteBuffer.readDouble();
		AvgYield = byteBuffer.readDouble();
		Qty = byteBuffer.readDouble();
		NominalValue = byteBuffer.readDouble();
		FirstPrice = byteBuffer.readDouble();
		FirstYield = byteBuffer.readDouble();
		LastPrice = byteBuffer.readDouble();
		LastYield = byteBuffer.readDouble();
		Currency = byteBuffer.readString();
		NumberOfTrades = (long)byteBuffer.readInt();
		CreateTime = byteBuffer.readLong();
		TradeType = TradeType.getEnum(byteBuffer.readInt());
		MarketAffiliation = (short)byteBuffer.readInt();
		AreaCodeId = (short)byteBuffer.readInt();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		OffPriceInfo.writeXDR(byteBuffer);
		byteBuffer.writeInt((int)(OffPriceDate & 0xFFFFFFFFL));
		byteBuffer.writeDouble(MinPrice);
		byteBuffer.writeDouble(MaxPrice);
		byteBuffer.writeDouble(AvgPrice);
		byteBuffer.writeDouble(MinYield);
		byteBuffer.writeDouble(MaxYield);
		byteBuffer.writeDouble(AvgYield);
		byteBuffer.writeDouble(Qty);
		byteBuffer.writeDouble(NominalValue);
		byteBuffer.writeDouble(FirstPrice);
		byteBuffer.writeDouble(FirstYield);
		byteBuffer.writeDouble(LastPrice);
		byteBuffer.writeDouble(LastYield);
		byteBuffer.writeString(Currency);
		byteBuffer.writeInt((int)(NumberOfTrades & 0xFFFFFFFFL));
		byteBuffer.writeLong(CreateTime);
		byteBuffer.writeInt(TradeType.getValue());
		byteBuffer.writeInt((int)(MarketAffiliation & 0xFFFFL));
		byteBuffer.writeInt((int)(AreaCodeId & 0xFFFFL));

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
		stringBuilder.append("GOV_BV_OFFICIAL_PRICE_PREVIEW::");
		stringBuilder.append("OffPriceInfo(").append(OffPriceInfo.toString()).append(")");
		stringBuilder.append("OffPriceDate(").append(OffPriceDate).append(")");
		stringBuilder.append("MinPrice(").append(MinPrice).append(")");
		stringBuilder.append("MaxPrice(").append(MaxPrice).append(")");
		stringBuilder.append("AvgPrice(").append(AvgPrice).append(")");
		stringBuilder.append("MinYield(").append(MinYield).append(")");
		stringBuilder.append("MaxYield(").append(MaxYield).append(")");
		stringBuilder.append("AvgYield(").append(AvgYield).append(")");
		stringBuilder.append("Qty(").append(Qty).append(")");
		stringBuilder.append("NominalValue(").append(NominalValue).append(")");
		stringBuilder.append("FirstPrice(").append(FirstPrice).append(")");
		stringBuilder.append("FirstYield(").append(FirstYield).append(")");
		stringBuilder.append("LastPrice(").append(LastPrice).append(")");
		stringBuilder.append("LastYield(").append(LastYield).append(")");
		stringBuilder.append("Currency(").append(Currency).append(")");
		stringBuilder.append("NumberOfTrades(").append(NumberOfTrades).append(")");
		stringBuilder.append("CreateTime(").append(CreateTime).append(")");
		stringBuilder.append("TradeType(").append(TradeType).append(")");
		stringBuilder.append("MarketAffiliation(").append(MarketAffiliation).append(")");
		stringBuilder.append("AreaCodeId(").append(AreaCodeId).append(")");
		return stringBuilder.toString();
	}
}
