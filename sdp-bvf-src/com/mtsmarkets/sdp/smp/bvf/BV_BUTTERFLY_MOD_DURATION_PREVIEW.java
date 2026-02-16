package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_BUTTERFLY_MOD_DURATION_PREVIEW extends SMPMessage
{
	public static final long CLASS_ID = 114289;

	private long ButterflyModDurationtPreviewId = 0;
	private long BodyId = 0;
	private long FirstWingId = 0;
	private long SecondWingId = 0;
	private double BodyNominalValue = 0;
	private double FirstWingNominalValue = 0;
	private double SecondWingNominalValue = 0;
	private double BodyCleanPrice = 0;
	private double FirstWingCleanPrice = 0;
	private double SecondWingCleanPrice = 0;
	private long BodySettlementDate = 0;
	private long FirstWingSettlementDate = 0;
	private long SecondWingSettlementDate = 0;
	private double BodyModDuration = 0;
	private double FirstWingModDuration = 0;
	private double SecondWingModDuration = 0;
	private double BodyAccruedInterest = 0;
	private double FirstWingAccruedInterest = 0;
	private double SecondWingAccruedInterest = 0;
	private String UserData = "";

	public BV_BUTTERFLY_MOD_DURATION_PREVIEW()
	{
	}

	public long getButterflyModDurationtPreviewId()
	{
		return ButterflyModDurationtPreviewId;
	}
	public void setButterflyModDurationtPreviewId(long value)
	{
		ButterflyModDurationtPreviewId = value;
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
	public double getBodyCleanPrice()
	{
		return BodyCleanPrice;
	}
	public void setBodyCleanPrice(double value)
	{
		BodyCleanPrice = value;
	}
	public double getFirstWingCleanPrice()
	{
		return FirstWingCleanPrice;
	}
	public void setFirstWingCleanPrice(double value)
	{
		FirstWingCleanPrice = value;
	}
	public double getSecondWingCleanPrice()
	{
		return SecondWingCleanPrice;
	}
	public void setSecondWingCleanPrice(double value)
	{
		SecondWingCleanPrice = value;
	}
	public long getBodySettlementDate()
	{
		return BodySettlementDate;
	}
	public void setBodySettlementDate(long value)
	{
		BodySettlementDate = value;
	}
	public long getFirstWingSettlementDate()
	{
		return FirstWingSettlementDate;
	}
	public void setFirstWingSettlementDate(long value)
	{
		FirstWingSettlementDate = value;
	}
	public long getSecondWingSettlementDate()
	{
		return SecondWingSettlementDate;
	}
	public void setSecondWingSettlementDate(long value)
	{
		SecondWingSettlementDate = value;
	}
	public double getBodyModDuration()
	{
		return BodyModDuration;
	}
	public void setBodyModDuration(double value)
	{
		BodyModDuration = value;
	}
	public double getFirstWingModDuration()
	{
		return FirstWingModDuration;
	}
	public void setFirstWingModDuration(double value)
	{
		FirstWingModDuration = value;
	}
	public double getSecondWingModDuration()
	{
		return SecondWingModDuration;
	}
	public void setSecondWingModDuration(double value)
	{
		SecondWingModDuration = value;
	}
	public double getBodyAccruedInterest()
	{
		return BodyAccruedInterest;
	}
	public void setBodyAccruedInterest(double value)
	{
		BodyAccruedInterest = value;
	}
	public double getFirstWingAccruedInterest()
	{
		return FirstWingAccruedInterest;
	}
	public void setFirstWingAccruedInterest(double value)
	{
		FirstWingAccruedInterest = value;
	}
	public double getSecondWingAccruedInterest()
	{
		return SecondWingAccruedInterest;
	}
	public void setSecondWingAccruedInterest(double value)
	{
		SecondWingAccruedInterest = value;
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
		ButterflyModDurationtPreviewId = (long)byteBuffer.readInt();
		BodyId = (long)byteBuffer.readInt();
		FirstWingId = (long)byteBuffer.readInt();
		SecondWingId = (long)byteBuffer.readInt();
		BodyNominalValue = byteBuffer.readDouble();
		FirstWingNominalValue = byteBuffer.readDouble();
		SecondWingNominalValue = byteBuffer.readDouble();
		BodyCleanPrice = byteBuffer.readDouble();
		FirstWingCleanPrice = byteBuffer.readDouble();
		SecondWingCleanPrice = byteBuffer.readDouble();
		BodySettlementDate = (long)byteBuffer.readInt();
		FirstWingSettlementDate = (long)byteBuffer.readInt();
		SecondWingSettlementDate = (long)byteBuffer.readInt();
		BodyModDuration = byteBuffer.readDouble();
		FirstWingModDuration = byteBuffer.readDouble();
		SecondWingModDuration = byteBuffer.readDouble();
		BodyAccruedInterest = byteBuffer.readDouble();
		FirstWingAccruedInterest = byteBuffer.readDouble();
		SecondWingAccruedInterest = byteBuffer.readDouble();
		UserData = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(ButterflyModDurationtPreviewId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(BodyId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(FirstWingId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SecondWingId & 0xFFFFFFFFL));
		byteBuffer.writeDouble(BodyNominalValue);
		byteBuffer.writeDouble(FirstWingNominalValue);
		byteBuffer.writeDouble(SecondWingNominalValue);
		byteBuffer.writeDouble(BodyCleanPrice);
		byteBuffer.writeDouble(FirstWingCleanPrice);
		byteBuffer.writeDouble(SecondWingCleanPrice);
		byteBuffer.writeInt((int)(BodySettlementDate & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(FirstWingSettlementDate & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SecondWingSettlementDate & 0xFFFFFFFFL));
		byteBuffer.writeDouble(BodyModDuration);
		byteBuffer.writeDouble(FirstWingModDuration);
		byteBuffer.writeDouble(SecondWingModDuration);
		byteBuffer.writeDouble(BodyAccruedInterest);
		byteBuffer.writeDouble(FirstWingAccruedInterest);
		byteBuffer.writeDouble(SecondWingAccruedInterest);
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
		stringBuilder.append("BV_BUTTERFLY_MOD_DURATION_PREVIEW::");
		stringBuilder.append("ButterflyModDurationtPreviewId(").append(ButterflyModDurationtPreviewId).append(")");
		stringBuilder.append("BodyId(").append(BodyId).append(")");
		stringBuilder.append("FirstWingId(").append(FirstWingId).append(")");
		stringBuilder.append("SecondWingId(").append(SecondWingId).append(")");
		stringBuilder.append("BodyNominalValue(").append(BodyNominalValue).append(")");
		stringBuilder.append("FirstWingNominalValue(").append(FirstWingNominalValue).append(")");
		stringBuilder.append("SecondWingNominalValue(").append(SecondWingNominalValue).append(")");
		stringBuilder.append("BodyCleanPrice(").append(BodyCleanPrice).append(")");
		stringBuilder.append("FirstWingCleanPrice(").append(FirstWingCleanPrice).append(")");
		stringBuilder.append("SecondWingCleanPrice(").append(SecondWingCleanPrice).append(")");
		stringBuilder.append("BodySettlementDate(").append(BodySettlementDate).append(")");
		stringBuilder.append("FirstWingSettlementDate(").append(FirstWingSettlementDate).append(")");
		stringBuilder.append("SecondWingSettlementDate(").append(SecondWingSettlementDate).append(")");
		stringBuilder.append("BodyModDuration(").append(BodyModDuration).append(")");
		stringBuilder.append("FirstWingModDuration(").append(FirstWingModDuration).append(")");
		stringBuilder.append("SecondWingModDuration(").append(SecondWingModDuration).append(")");
		stringBuilder.append("BodyAccruedInterest(").append(BodyAccruedInterest).append(")");
		stringBuilder.append("FirstWingAccruedInterest(").append(FirstWingAccruedInterest).append(")");
		stringBuilder.append("SecondWingAccruedInterest(").append(SecondWingAccruedInterest).append(")");
		stringBuilder.append("UserData(").append(UserData).append(")");
		return stringBuilder.toString();
	}
}
