package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class GOV_BV_TRADE_UPDATE extends SMPMessage
{
	public static final long CLASS_ID = 114813;

	private long MsgId = 0;
	private double Price = 0;
	private double Yield = 0;
	private TI_FLAG_Enum YieldFg = TI_FLAG_Enum.TI_FLAG_No;
	private long SettlDate = 0;
	private double Quantity = 0;
	private TI_VERB_Enum Verb = TI_VERB_Enum.TI_VERB_Buy;

	public GOV_BV_TRADE_UPDATE()
	{
	}

	public long getMsgId()
	{
		return MsgId;
	}
	public void setMsgId(long value)
	{
		MsgId = value;
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
	public TI_FLAG_Enum getYieldFg()
	{
		return YieldFg;
	}
	public void setYieldFg(TI_FLAG_Enum value)
	{
		YieldFg = value;
	}
	public long getSettlDate()
	{
		return SettlDate;
	}
	public void setSettlDate(long value)
	{
		SettlDate = value;
	}
	public double getQuantity()
	{
		return Quantity;
	}
	public void setQuantity(double value)
	{
		Quantity = value;
	}
	public TI_VERB_Enum getVerb()
	{
		return Verb;
	}
	public void setVerb(TI_VERB_Enum value)
	{
		Verb = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MsgId = (long)byteBuffer.readInt();
		Price = byteBuffer.readDouble();
		Yield = byteBuffer.readDouble();
		YieldFg = YieldFg.getEnum(byteBuffer.readInt());
		SettlDate = (long)byteBuffer.readInt();
		Quantity = byteBuffer.readDouble();
		Verb = Verb.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MsgId & 0xFFFFFFFFL));
		byteBuffer.writeDouble(Price);
		byteBuffer.writeDouble(Yield);
		byteBuffer.writeInt(YieldFg.getValue());
		byteBuffer.writeInt((int)(SettlDate & 0xFFFFFFFFL));
		byteBuffer.writeDouble(Quantity);
		byteBuffer.writeInt(Verb.getValue());

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
		stringBuilder.append("GOV_BV_TRADE_UPDATE::");
		stringBuilder.append("MsgId(").append(MsgId).append(")");
		stringBuilder.append("Price(").append(Price).append(")");
		stringBuilder.append("Yield(").append(Yield).append(")");
		stringBuilder.append("YieldFg(").append(YieldFg).append(")");
		stringBuilder.append("SettlDate(").append(SettlDate).append(")");
		stringBuilder.append("Quantity(").append(Quantity).append(")");
		stringBuilder.append("Verb(").append(Verb).append(")");
		return stringBuilder.toString();
	}
}
