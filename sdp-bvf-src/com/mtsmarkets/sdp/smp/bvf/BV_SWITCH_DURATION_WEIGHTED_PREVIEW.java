package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_SWITCH_DURATION_WEIGHTED_PREVIEW extends SMPMessage
{
	public static final long CLASS_ID = 114285;

	private long SwitchDurationWeightedPreviewId = 0;
	private long FirstLegId = 0;
	private long SecondLegId = 0;
	private double FirstNominalValue = 0;
	private double SecondNominalValue = 0;
	private double FirstBpv = 0;
	private double SecondBpv = 0;
	private String UserData = "";

	public BV_SWITCH_DURATION_WEIGHTED_PREVIEW()
	{
	}

	public long getSwitchDurationWeightedPreviewId()
	{
		return SwitchDurationWeightedPreviewId;
	}
	public void setSwitchDurationWeightedPreviewId(long value)
	{
		SwitchDurationWeightedPreviewId = value;
	}
	public long getFirstLegId()
	{
		return FirstLegId;
	}
	public void setFirstLegId(long value)
	{
		FirstLegId = value;
	}
	public long getSecondLegId()
	{
		return SecondLegId;
	}
	public void setSecondLegId(long value)
	{
		SecondLegId = value;
	}
	public double getFirstNominalValue()
	{
		return FirstNominalValue;
	}
	public void setFirstNominalValue(double value)
	{
		FirstNominalValue = value;
	}
	public double getSecondNominalValue()
	{
		return SecondNominalValue;
	}
	public void setSecondNominalValue(double value)
	{
		SecondNominalValue = value;
	}
	public double getFirstBpv()
	{
		return FirstBpv;
	}
	public void setFirstBpv(double value)
	{
		FirstBpv = value;
	}
	public double getSecondBpv()
	{
		return SecondBpv;
	}
	public void setSecondBpv(double value)
	{
		SecondBpv = value;
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
		SwitchDurationWeightedPreviewId = (long)byteBuffer.readInt();
		FirstLegId = (long)byteBuffer.readInt();
		SecondLegId = (long)byteBuffer.readInt();
		FirstNominalValue = byteBuffer.readDouble();
		SecondNominalValue = byteBuffer.readDouble();
		FirstBpv = byteBuffer.readDouble();
		SecondBpv = byteBuffer.readDouble();
		UserData = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(SwitchDurationWeightedPreviewId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(FirstLegId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SecondLegId & 0xFFFFFFFFL));
		byteBuffer.writeDouble(FirstNominalValue);
		byteBuffer.writeDouble(SecondNominalValue);
		byteBuffer.writeDouble(FirstBpv);
		byteBuffer.writeDouble(SecondBpv);
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
		stringBuilder.append("BV_SWITCH_DURATION_WEIGHTED_PREVIEW::");
		stringBuilder.append("SwitchDurationWeightedPreviewId(").append(SwitchDurationWeightedPreviewId).append(")");
		stringBuilder.append("FirstLegId(").append(FirstLegId).append(")");
		stringBuilder.append("SecondLegId(").append(SecondLegId).append(")");
		stringBuilder.append("FirstNominalValue(").append(FirstNominalValue).append(")");
		stringBuilder.append("SecondNominalValue(").append(SecondNominalValue).append(")");
		stringBuilder.append("FirstBpv(").append(FirstBpv).append(")");
		stringBuilder.append("SecondBpv(").append(SecondBpv).append(")");
		stringBuilder.append("UserData(").append(UserData).append(")");
		return stringBuilder.toString();
	}
}
