package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_BROKER extends SMPMessage
{
	public static final long CLASS_ID = 100209;

	private long MarketId = 0;
	private long BrokerId = 0;
	private String BrokerCode = "";
	private String BrokerDes = "";
	private String BrokerShortDes = "";
	private String CountryCode = "";
	private String City = "";
	private String Address = "";
	private String Phone = "";
	private String Province = "";
	private String ElectronicMail = "";
	private long MemberId = 0;
	private TI_BROKER_TYPE_Enum BrokerType = TI_BROKER_TYPE_Enum.TI_BROKER_TYPE_None;

	public TI_BROKER()
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
	public long getBrokerId()
	{
		return BrokerId;
	}
	public void setBrokerId(long value)
	{
		BrokerId = value;
	}
	public String getBrokerCode()
	{
		return BrokerCode;
	}
	public void setBrokerCode(String value)
	{
		BrokerCode = value;
	}
	public String getBrokerDes()
	{
		return BrokerDes;
	}
	public void setBrokerDes(String value)
	{
		BrokerDes = value;
	}
	public String getBrokerShortDes()
	{
		return BrokerShortDes;
	}
	public void setBrokerShortDes(String value)
	{
		BrokerShortDes = value;
	}
	public String getCountryCode()
	{
		return CountryCode;
	}
	public void setCountryCode(String value)
	{
		CountryCode = value;
	}
	public String getCity()
	{
		return City;
	}
	public void setCity(String value)
	{
		City = value;
	}
	public String getAddress()
	{
		return Address;
	}
	public void setAddress(String value)
	{
		Address = value;
	}
	public String getPhone()
	{
		return Phone;
	}
	public void setPhone(String value)
	{
		Phone = value;
	}
	public String getProvince()
	{
		return Province;
	}
	public void setProvince(String value)
	{
		Province = value;
	}
	public String getElectronicMail()
	{
		return ElectronicMail;
	}
	public void setElectronicMail(String value)
	{
		ElectronicMail = value;
	}
	public long getMemberId()
	{
		return MemberId;
	}
	public void setMemberId(long value)
	{
		MemberId = value;
	}
	public TI_BROKER_TYPE_Enum getBrokerType()
	{
		return BrokerType;
	}
	public void setBrokerType(TI_BROKER_TYPE_Enum value)
	{
		BrokerType = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MarketId = (long)byteBuffer.readInt();
		BrokerId = (long)byteBuffer.readInt();
		BrokerCode = byteBuffer.readString();
		BrokerDes = byteBuffer.readString();
		BrokerShortDes = byteBuffer.readString();
		CountryCode = byteBuffer.readString();
		City = byteBuffer.readString();
		Address = byteBuffer.readString();
		Phone = byteBuffer.readString();
		Province = byteBuffer.readString();
		ElectronicMail = byteBuffer.readString();
		MemberId = (long)byteBuffer.readInt();
		BrokerType = BrokerType.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(MarketId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(BrokerId & 0xFFFFFFFFL));
		byteBuffer.writeString(BrokerCode);
		byteBuffer.writeString(BrokerDes);
		byteBuffer.writeString(BrokerShortDes);
		byteBuffer.writeString(CountryCode);
		byteBuffer.writeString(City);
		byteBuffer.writeString(Address);
		byteBuffer.writeString(Phone);
		byteBuffer.writeString(Province);
		byteBuffer.writeString(ElectronicMail);
		byteBuffer.writeInt((int)(MemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt(BrokerType.getValue());

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
		stringBuilder.append("TI_BROKER::");
		stringBuilder.append("MarketId(").append(MarketId).append(")");
		stringBuilder.append("BrokerId(").append(BrokerId).append(")");
		stringBuilder.append("BrokerCode(").append(BrokerCode).append(")");
		stringBuilder.append("BrokerDes(").append(BrokerDes).append(")");
		stringBuilder.append("BrokerShortDes(").append(BrokerShortDes).append(")");
		stringBuilder.append("CountryCode(").append(CountryCode).append(")");
		stringBuilder.append("City(").append(City).append(")");
		stringBuilder.append("Address(").append(Address).append(")");
		stringBuilder.append("Phone(").append(Phone).append(")");
		stringBuilder.append("Province(").append(Province).append(")");
		stringBuilder.append("ElectronicMail(").append(ElectronicMail).append(")");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("BrokerType(").append(BrokerType).append(")");
		return stringBuilder.toString();
	}
}
