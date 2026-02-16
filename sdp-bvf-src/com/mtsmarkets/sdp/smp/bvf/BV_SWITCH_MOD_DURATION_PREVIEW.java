package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class BV_SWITCH_MOD_DURATION_PREVIEW extends SMPMessage
{
	public static final long CLASS_ID = 114286;

	private long SwitchModDurationPreviewId = 0;
	private long FirstLegId = 0;
	private long SecondLegId = 0;
	private double FirstNominalValue = 0;
	private double FirstCleanPrice = 0;
	private double SecondCleanPrice = 0;
	private long FirstSettlementDate = 0;
	private long SecondSettlementDate = 0;
	private double SecondNominalValue = 0;
	private double FirstModDuration = 0;
	private double SecondModDuration = 0;
	private String UserData = "";

	public BV_SWITCH_MOD_DURATION_PREVIEW()
	{
	}

	public long getSwitchModDurationPreviewId()
	{
		return SwitchModDurationPreviewId;
	}
	public void setSwitchModDurationPreviewId(long value)
	{
		SwitchModDurationPreviewId = value;
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
	public double getFirstCleanPrice()
	{
		return FirstCleanPrice;
	}
	public void setFirstCleanPrice(double value)
	{
		FirstCleanPrice = value;
	}
	public double getSecondCleanPrice()
	{
		return SecondCleanPrice;
	}
	public void setSecondCleanPrice(double value)
	{
		SecondCleanPrice = value;
	}
	public long getFirstSettlementDate()
	{
		return FirstSettlementDate;
	}
	public void setFirstSettlementDate(long value)
	{
		FirstSettlementDate = value;
	}
	public long getSecondSettlementDate()
	{
		return SecondSettlementDate;
	}
	public void setSecondSettlementDate(long value)
	{
		SecondSettlementDate = value;
	}
	public double getSecondNominalValue()
	{
		return SecondNominalValue;
	}
	public void setSecondNominalValue(double value)
	{
		SecondNominalValue = value;
	}
	public double getFirstModDuration()
	{
		return FirstModDuration;
	}
	public void setFirstModDuration(double value)
	{
		FirstModDuration = value;
	}
	public double getSecondModDuration()
	{
		return SecondModDuration;
	}
	public void setSecondModDuration(double value)
	{
		SecondModDuration = value;
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
		SwitchModDurationPreviewId = (long)byteBuffer.readInt();
		FirstLegId = (long)byteBuffer.readInt();
		SecondLegId = (long)byteBuffer.readInt();
		FirstNominalValue = byteBuffer.readDouble();
		FirstCleanPrice = byteBuffer.readDouble();
		SecondCleanPrice = byteBuffer.readDouble();
		FirstSettlementDate = (long)byteBuffer.readInt();
		SecondSettlementDate = (long)byteBuffer.readInt();
		SecondNominalValue = byteBuffer.readDouble();
		FirstModDuration = byteBuffer.readDouble();
		SecondModDuration = byteBuffer.readDouble();
		UserData = byteBuffer.readString();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(SwitchModDurationPreviewId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(FirstLegId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SecondLegId & 0xFFFFFFFFL));
		byteBuffer.writeDouble(FirstNominalValue);
		byteBuffer.writeDouble(FirstCleanPrice);
		byteBuffer.writeDouble(SecondCleanPrice);
		byteBuffer.writeInt((int)(FirstSettlementDate & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(SecondSettlementDate & 0xFFFFFFFFL));
		byteBuffer.writeDouble(SecondNominalValue);
		byteBuffer.writeDouble(FirstModDuration);
		byteBuffer.writeDouble(SecondModDuration);
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
		stringBuilder.append("BV_SWITCH_MOD_DURATION_PREVIEW::");
		stringBuilder.append("SwitchModDurationPreviewId(").append(SwitchModDurationPreviewId).append(")");
		stringBuilder.append("FirstLegId(").append(FirstLegId).append(")");
		stringBuilder.append("SecondLegId(").append(SecondLegId).append(")");
		stringBuilder.append("FirstNominalValue(").append(FirstNominalValue).append(")");
		stringBuilder.append("FirstCleanPrice(").append(FirstCleanPrice).append(")");
		stringBuilder.append("SecondCleanPrice(").append(SecondCleanPrice).append(")");
		stringBuilder.append("FirstSettlementDate(").append(FirstSettlementDate).append(")");
		stringBuilder.append("SecondSettlementDate(").append(SecondSettlementDate).append(")");
		stringBuilder.append("SecondNominalValue(").append(SecondNominalValue).append(")");
		stringBuilder.append("FirstModDuration(").append(FirstModDuration).append(")");
		stringBuilder.append("SecondModDuration(").append(SecondModDuration).append(")");
		stringBuilder.append("UserData(").append(UserData).append(")");
		return stringBuilder.toString();
	}
}
