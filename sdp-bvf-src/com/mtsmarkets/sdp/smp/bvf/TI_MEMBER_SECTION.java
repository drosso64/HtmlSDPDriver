package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_MEMBER_SECTION extends SMPMessage
{
	public static final long CLASS_ID = 100040;

	private long SectionId = 0;
	private long MemberId = 0;
	private long MarketId = 0;
	private String MarketManager = "";
	private String Address = "";
	private String City = "";
	private String Province = "";
	private String ZIPCode = "";
	private String CountryCode = "";
	private String Phone = "";
	private String Fax = "";
	private String ElectronicMail = "";
	private long StartDate = 0;
	private long EndDate = 0;

	public TI_MEMBER_SECTION()
	{
	}

	public long getSectionId()
	{
		return SectionId;
	}
	public void setSectionId(long value)
	{
		SectionId = value;
	}
	public long getMemberId()
	{
		return MemberId;
	}
	public void setMemberId(long value)
	{
		MemberId = value;
	}
	public long getMarketId()
	{
		return MarketId;
	}
	public void setMarketId(long value)
	{
		MarketId = value;
	}
	public String getMarketManager()
	{
		return MarketManager;
	}
	public void setMarketManager(String value)
	{
		MarketManager = value;
	}
	public String getAddress()
	{
		return Address;
	}
	public void setAddress(String value)
	{
		Address = value;
	}
	public String getCity()
	{
		return City;
	}
	public void setCity(String value)
	{
		City = value;
	}
	public String getProvince()
	{
		return Province;
	}
	public void setProvince(String value)
	{
		Province = value;
	}
	public String getZIPCode()
	{
		return ZIPCode;
	}
	public void setZIPCode(String value)
	{
		ZIPCode = value;
	}
	public String getCountryCode()
	{
		return CountryCode;
	}
	public void setCountryCode(String value)
	{
		CountryCode = value;
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
	public String getElectronicMail()
	{
		return ElectronicMail;
	}
	public void setElectronicMail(String value)
	{
		ElectronicMail = value;
	}
	public long getStartDate()
	{
		return StartDate;
	}
	public void setStartDate(long value)
	{
		StartDate = value;
	}
	public long getEndDate()
	{
		return EndDate;
	}
	public void setEndDate(long value)
	{
		EndDate = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		SectionId = (long)byteBuffer.readInt();
		MemberId = (long)byteBuffer.readInt();
		MarketId = (long)byteBuffer.readInt();
		MarketManager = byteBuffer.readString();
		Address = byteBuffer.readString();
		City = byteBuffer.readString();
		Province = byteBuffer.readString();
		ZIPCode = byteBuffer.readString();
		CountryCode = byteBuffer.readString();
		Phone = byteBuffer.readString();
		Fax = byteBuffer.readString();
		ElectronicMail = byteBuffer.readString();
		StartDate = (long)byteBuffer.readInt();
		EndDate = (long)byteBuffer.readInt();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(SectionId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(MemberId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(MarketId & 0xFFFFFFFFL));
		byteBuffer.writeString(MarketManager);
		byteBuffer.writeString(Address);
		byteBuffer.writeString(City);
		byteBuffer.writeString(Province);
		byteBuffer.writeString(ZIPCode);
		byteBuffer.writeString(CountryCode);
		byteBuffer.writeString(Phone);
		byteBuffer.writeString(Fax);
		byteBuffer.writeString(ElectronicMail);
		byteBuffer.writeInt((int)(StartDate & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(EndDate & 0xFFFFFFFFL));

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
		stringBuilder.append("TI_MEMBER_SECTION::");
		stringBuilder.append("SectionId(").append(SectionId).append(")");
		stringBuilder.append("MemberId(").append(MemberId).append(")");
		stringBuilder.append("MarketId(").append(MarketId).append(")");
		stringBuilder.append("MarketManager(").append(MarketManager).append(")");
		stringBuilder.append("Address(").append(Address).append(")");
		stringBuilder.append("City(").append(City).append(")");
		stringBuilder.append("Province(").append(Province).append(")");
		stringBuilder.append("ZIPCode(").append(ZIPCode).append(")");
		stringBuilder.append("CountryCode(").append(CountryCode).append(")");
		stringBuilder.append("Phone(").append(Phone).append(")");
		stringBuilder.append("Fax(").append(Fax).append(")");
		stringBuilder.append("ElectronicMail(").append(ElectronicMail).append(")");
		stringBuilder.append("StartDate(").append(StartDate).append(")");
		stringBuilder.append("EndDate(").append(EndDate).append(")");
		return stringBuilder.toString();
	}
}
