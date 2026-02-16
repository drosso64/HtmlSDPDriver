package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_RFCQ_TRADING_RELATION_TRADER extends SMPMessage
{
	public static final long CLASS_ID = 100078;

	private long SellSideMemberId = 0;
	private long BuySideMemberId = 0;
	private long TraderId = 0;
	private String TraderName = "";
	private String FirstName = "";
	private String LastName = "";
	private String Email = "";
	private String Phone = "";
	private String Fax = "";

	public BV_RFCQ_TRADING_RELATION_TRADER()
	{
	}

	public long getSellSideMemberId()
	{
		return SellSideMemberId;
	}
	public void setSellSideMemberId(long value)
	{
		SellSideMemberId = value;
	}
	public long getBuySideMemberId()
	{
		return BuySideMemberId;
	}
	public void setBuySideMemberId(long value)
	{
		BuySideMemberId = value;
	}
	public long getTraderId()
	{
		return TraderId;
	}
	public void setTraderId(long value)
	{
		TraderId = value;
	}
	public String getTraderName()
	{
		return TraderName;
	}
	public void setTraderName(String value)
	{
		TraderName = value;
	}
	public String getFirstName()
	{
		return FirstName;
	}
	public void setFirstName(String value)
	{
		FirstName = value;
	}
	public String getLastName()
	{
		return LastName;
	}
	public void setLastName(String value)
	{
		LastName = value;
	}
	public String getEmail()
	{
		return Email;
	}
	public void setEmail(String value)
	{
		Email = value;
	}
	public String getPhone()
	{
		return Phone;
	}
	public void setPhone(String value)
	{
		Phone = value;
	}
	public String getFax()
	{
		return Fax;
	}
	public void setFax(String value)
	{
		Fax = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		SellSideMemberId = (long)byteBuffer.readInt();
		BuySideMemberId = (long)byteBuffer.readInt();
		TraderId = (long)byteBuffer.readInt();
		TraderName = byteBuffer.readString();
		FirstName = byteBuffer.readString();
		LastName = byteBuffer.readString();
		Email = byteBuffer.readString();
		Phone = byteBuffer.readString();
		Fax = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(SellSideMemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(BuySideMemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(TraderId & 0xFFFFFFFFL));
		byteBuffer.writeString(TraderName);
		byteBuffer.writeString(FirstName);
		byteBuffer.writeString(LastName);
		byteBuffer.writeString(Email);
		byteBuffer.writeString(Phone);
		byteBuffer.writeString(Fax);

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
		stringBuilder.append("BV_RFCQ_TRADING_RELATION_TRADER::");
		stringBuilder.append("SellSideMemberId(").append(SellSideMemberId).append(")");
		stringBuilder.append("BuySideMemberId(").append(BuySideMemberId).append(")");
		stringBuilder.append("TraderId(").append(TraderId).append(")");
		stringBuilder.append("TraderName(").append(TraderName).append(")");
		stringBuilder.append("FirstName(").append(FirstName).append(")");
		stringBuilder.append("LastName(").append(LastName).append(")");
		stringBuilder.append("Email(").append(Email).append(")");
		stringBuilder.append("Phone(").append(Phone).append(")");
		stringBuilder.append("Fax(").append(Fax).append(")");
		return stringBuilder.toString();
	}
}
