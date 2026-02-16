package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_BUTTERFLY_DUR_WEIGHTED_PREVIEW extends SMPMessage
{
	public static final long CLASS_ID = 114288;

	private long ButterflyDurWeightedPreviewId = 0;
	private long BodyId = 0;
	private long FirstWingId = 0;
	private long SecondWingId = 0;
	private double BodyNominalValue = 0;
	private double FirstWingNominalValue = 0;
	private double SecondWingNominalValue = 0;
	private double BodyBpv = 0;
	private double FirstWingBpv = 0;
	private double SecondWingBpv = 0;
	private String UserData = "";

	public BV_BUTTERFLY_DUR_WEIGHTED_PREVIEW()
	{
	}

	public long getButterflyDurWeightedPreviewId()
	{
		return ButterflyDurWeightedPreviewId;
	}
	public void setButterflyDurWeightedPreviewId(long value)
	{
		ButterflyDurWeightedPreviewId = value;
	}
	public long getBodyId()
	{
		return BodyId;
	}
	public void setBodyId(long value)
	{
		BodyId = value;
	}
	public long getFirstWingId()
	{
		return FirstWingId;
	}
	public void setFirstWingId(long value)
	{
		FirstWingId = value;
	}
	public long getSecondWingId()
	{
		return SecondWingId;
	}
	public void setSecondWingId(long value)
	{
		SecondWingId = value;
	}
	public double getBodyNominalValue()
	{
		return BodyNominalValue;
	}
	public void setBodyNominalValue(double value)
	{
		BodyNominalValue = value;
	}
	public double getFirstWingNominalValue()
	{
		return FirstWingNominalValue;
	}
	public void setFirstWingNominalValue(double value)
	{
		FirstWingNominalValue = value;
	}
	public double getSecondWingNominalValue()
	{
		return SecondWingNominalValue;
	}
	public void setSecondWingNominalValue(double value)
	{
		SecondWingNominalValue = value;
	}
	public double getBodyBpv()
	{
		return BodyBpv;
	}
	public void setBodyBpv(double value)
	{
		BodyBpv = value;
	}
	public double getFirstWingBpv()
	{
		return FirstWingBpv;
	}
	public void setFirstWingBpv(double value)
	{
		FirstWingBpv = value;
	}
	public double getSecondWingBpv()
	{
		return SecondWingBpv;
	}
	public void setSecondWingBpv(double value)
	{
		SecondWingBpv = value;
	}
	public String getUserData()
	{
		return UserData;
	}
	public void setUserData(String value)
	{
		UserData = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		ButterflyDurWeightedPreviewId = (long)byteBuffer.readInt();
		BodyId = (long)byteBuffer.readInt();
		FirstWingId = (long)byteBuffer.readInt();
		SecondWingId = (long)byteBuffer.readInt();
		BodyNominalValue = byteBuffer.readDouble();
		FirstWingNominalValue = byteBuffer.readDouble();
		SecondWingNominalValue = byteBuffer.readDouble();
		BodyBpv = byteBuffer.readDouble();
		FirstWingBpv = byteBuffer.readDouble();
		SecondWingBpv = byteBuffer.readDouble();
		UserData = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(ButterflyDurWeightedPreviewId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(BodyId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(FirstWingId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SecondWingId & 0xFFFFFFFFL));
		byteBuffer.writeDouble(BodyNominalValue);
		byteBuffer.writeDouble(FirstWingNominalValue);
		byteBuffer.writeDouble(SecondWingNominalValue);
		byteBuffer.writeDouble(BodyBpv);
		byteBuffer.writeDouble(FirstWingBpv);
		byteBuffer.writeDouble(SecondWingBpv);
		byteBuffer.writeString(UserData);

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
		stringBuilder.append("BV_BUTTERFLY_DUR_WEIGHTED_PREVIEW::");
		stringBuilder.append("ButterflyDurWeightedPreviewId(").append(ButterflyDurWeightedPreviewId).append(")");
		stringBuilder.append("BodyId(").append(BodyId).append(")");
		stringBuilder.append("FirstWingId(").append(FirstWingId).append(")");
		stringBuilder.append("SecondWingId(").append(SecondWingId).append(")");
		stringBuilder.append("BodyNominalValue(").append(BodyNominalValue).append(")");
		stringBuilder.append("FirstWingNominalValue(").append(FirstWingNominalValue).append(")");
		stringBuilder.append("SecondWingNominalValue(").append(SecondWingNominalValue).append(")");
		stringBuilder.append("BodyBpv(").append(BodyBpv).append(")");
		stringBuilder.append("FirstWingBpv(").append(FirstWingBpv).append(")");
		stringBuilder.append("SecondWingBpv(").append(SecondWingBpv).append(")");
		stringBuilder.append("UserData(").append(UserData).append(")");
		return stringBuilder.toString();
	}
}
