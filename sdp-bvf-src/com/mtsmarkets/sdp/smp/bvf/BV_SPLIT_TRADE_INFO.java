package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_SPLIT_TRADE_INFO extends SMPMessage
{
	public static final long CLASS_ID = 410003;

	private long TradeId = 0;
	private long AccountId = 0;
	private String AccountCode = "";
	private double Qty = 0;
	private double NominalValue = 0;
	private double Percentage = 0;
	private double AccruedInterest = 0;
	private TI_VERB_Enum Verb = TI_VERB_Enum.TI_VERB_Buy;

	public BV_SPLIT_TRADE_INFO()
	{
	}

	public long getTradeId()
	{
		return TradeId;
	}
	public void setTradeId(long value)
	{
		TradeId = value;
	}
	public long getAccountId()
	{
		return AccountId;
	}
	public void setAccountId(long value)
	{
		AccountId = value;
	}
	public String getAccountCode()
	{
		return AccountCode;
	}
	public void setAccountCode(String value)
	{
		AccountCode = value;
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
	public double getPercentage()
	{
		return Percentage;
	}
	public void setPercentage(double value)
	{
		Percentage = value;
	}
	public double getAccruedInterest()
	{
		return AccruedInterest;
	}
	public void setAccruedInterest(double value)
	{
		AccruedInterest = value;
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
		TradeId = (long)byteBuffer.readInt();
		AccountId = (long)byteBuffer.readInt();
		AccountCode = byteBuffer.readString();
		Qty = byteBuffer.readDouble();
		NominalValue = byteBuffer.readDouble();
		Percentage = byteBuffer.readDouble();
		AccruedInterest = byteBuffer.readDouble();
		Verb = Verb.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(TradeId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(AccountId & 0xFFFFFFFFL));
		byteBuffer.writeString(AccountCode);
		byteBuffer.writeDouble(Qty);
		byteBuffer.writeDouble(NominalValue);
		byteBuffer.writeDouble(Percentage);
		byteBuffer.writeDouble(AccruedInterest);
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
		stringBuilder.append("BV_SPLIT_TRADE_INFO::");
		stringBuilder.append("TradeId(").append(TradeId).append(")");
		stringBuilder.append("AccountId(").append(AccountId).append(")");
		stringBuilder.append("AccountCode(").append(AccountCode).append(")");
		stringBuilder.append("Qty(").append(Qty).append(")");
		stringBuilder.append("NominalValue(").append(NominalValue).append(")");
		stringBuilder.append("Percentage(").append(Percentage).append(")");
		stringBuilder.append("AccruedInterest(").append(AccruedInterest).append(")");
		stringBuilder.append("Verb(").append(Verb).append(")");
		return stringBuilder.toString();
	}
}
