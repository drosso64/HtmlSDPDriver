package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_HIST_VOICE_CONFIRMED_QUOTES extends SMPMessage
{
	public static final long CLASS_ID = 114988;

	private String MemberCode = "";
	private String MemberDesc = "";
	private String MemberShortDesc = "";
	private double Price = 0;
	private double Yield = 0;
	private TI_FLAG_Enum YieldFg = TI_FLAG_Enum.TI_FLAG_No;
	private double YTW = 0;
	private TI_FLAG_Enum YTWFg = TI_FLAG_Enum.TI_FLAG_No;

	public BV_HIST_VOICE_CONFIRMED_QUOTES()
	{
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
	public double getYTW()
	{
		return YTW;
	}
	public void setYTW(double value)
	{
		YTW = value;
	}
	public TI_FLAG_Enum getYTWFg()
	{
		return YTWFg;
	}
	public void setYTWFg(TI_FLAG_Enum value)
	{
		YTWFg = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		MemberCode = byteBuffer.readString();
		MemberDesc = byteBuffer.readString();
		MemberShortDesc = byteBuffer.readString();
		Price = byteBuffer.readDouble();
		Yield = byteBuffer.readDouble();
		YieldFg = YieldFg.getEnum(byteBuffer.readInt());
		YTW = byteBuffer.readDouble();
		YTWFg = YTWFg.getEnum(byteBuffer.readInt());
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeString(MemberCode);
		byteBuffer.writeString(MemberDesc);
		byteBuffer.writeString(MemberShortDesc);
		byteBuffer.writeDouble(Price);
		byteBuffer.writeDouble(Yield);
		byteBuffer.writeInt(YieldFg.getValue());
		byteBuffer.writeDouble(YTW);
		byteBuffer.writeInt(YTWFg.getValue());

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
		stringBuilder.append("BV_HIST_VOICE_CONFIRMED_QUOTES::");
		stringBuilder.append("MemberCode(").append(MemberCode).append(")");
		stringBuilder.append("MemberDesc(").append(MemberDesc).append(")");
		stringBuilder.append("MemberShortDesc(").append(MemberShortDesc).append(")");
		stringBuilder.append("Price(").append(Price).append(")");
		stringBuilder.append("Yield(").append(Yield).append(")");
		stringBuilder.append("YieldFg(").append(YieldFg).append(")");
		stringBuilder.append("YTW(").append(YTW).append(")");
		stringBuilder.append("YTWFg(").append(YTWFg).append(")");
		return stringBuilder.toString();
	}
}
