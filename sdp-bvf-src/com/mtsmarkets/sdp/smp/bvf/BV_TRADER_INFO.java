package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_TRADER_INFO extends SMPMessage
{
	public static final long CLASS_ID = 100099;

	private long BuySideMemberId = 0;
	private long MemberId = 0;
	private long TraderId = 0;
	private String TraderName = "";
	private TI_TRADER_ACCOUNT_STATUS_Enum TraderAccountStatus = TI_TRADER_ACCOUNT_STATUS_Enum.TI_TRADER_ACCOUNT_STATUS_Inactive;
	private TI_TRADER_TYPE_Enum TraderType = TI_TRADER_TYPE_Enum.TI_TRADER_TYPE_Manager;
	private String FirstName = "";
	private String LastName = "";
	private String Email = "";
	private String Phone = "";
	private String Fax = "";

	public BV_TRADER_INFO()
	{
	}

	public long getBuySideMemberId()
	{
		return BuySideMemberId;
	}
	public void setBuySideMemberId(long value)
	{
		BuySideMemberId = value;
	}
	public long getMemberId()
	{
		return MemberId;
	}
	public void setMemberId(long value)
	{
		MemberId = value;
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
	public TI_TRADER_ACCOUNT_STATUS_Enum getTraderAccountStatus()
	{
		return TraderAccountStatus;
	}
	public void setTraderAccountStatus(TI_TRADER_ACCOUNT_STATUS_Enum value)
	{
		TraderAccountStatus = value;
	}
	public TI_TRADER_TYPE_Enum getTraderType()
	{
		return TraderType;
	}
	public void setTraderType(TI_TRADER_TYPE_Enum value)
	{
		TraderType = value;
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
		BuySideMemberId = (long)byteBuffer.readInt();
		MemberId = (long)byteBuffer.readInt();
		TraderId = (long)byteBuffer.readInt();
		TraderName = byteBuffer.readString();
		TraderAccountStatus = TraderAccountStatus.getEnum(byteBuffer.readInt());
		TraderType = TraderType.getEnum(byteBuffer.readInt());
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

		byteBuffer.writeInt((int)(BuySideMemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(MemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(TraderId & 0xFFFFFFFFL));
		byteBuffer.writeString(TraderName);
		byteBuffer.writeInt(TraderAccountStatus.getValue());
		byteBuffer.writeInt(TraderType.getValue());
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
		stringBuilder.append("BV_TRADER_INFO::");
		stringBuilder.append("BuySideMemberId(").append(BuySideMemberId).append(")");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("TraderId(").append(TraderId).append(")");
		stringBuilder.append("TraderName(").append(TraderName).append(")");
		stringBuilder.append("TraderAccountStatus(").append(TraderAccountStatus).append(")");
		stringBuilder.append("TraderType(").append(TraderType).append(")");
		stringBuilder.append("FirstName(").append(FirstName).append(")");
		stringBuilder.append("LastName(").append(LastName).append(")");
		stringBuilder.append("Email(").append(Email).append(")");
		stringBuilder.append("Phone(").append(Phone).append(")");
		stringBuilder.append("Fax(").append(Fax).append(")");
		return stringBuilder.toString();
	}
}
