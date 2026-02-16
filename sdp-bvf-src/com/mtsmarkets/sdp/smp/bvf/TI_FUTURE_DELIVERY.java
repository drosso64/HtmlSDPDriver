package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_FUTURE_DELIVERY extends SMPMessage
{
	public static final long CLASS_ID = 100045;

	private long FinancialInstrumentId = 0;
	private long FutureId = 0;
	private long IssuerId = 0;
	private TI_EXPIRY_TYPE_Enum ExpiryType = TI_EXPIRY_TYPE_Enum.TI_EXPIRY_TYPE_ExFront;
	private String ReutersCode = "";
	private String BloombergCode = "";
	private String FutureDeliveryDesc = "";
	private String FutureDeliveryCode = "";
	private long ExpiryDate = 0;
	private long DeliveryDate = 0;
	private long FutureSize = 0;
	private double ReferencePrice = 0;
	private long ReferencePriceDate = 0;
	private double BPV = 0;
	private String CurrencyCode = "";
	private long RollingDate = 0;

	public TI_FUTURE_DELIVERY()
	{
	}

	public long getFinancialInstrumentId()
	{
		return FinancialInstrumentId;
	}
	public void setFinancialInstrumentId(long value)
	{
		FinancialInstrumentId = value;
	}
	public long getFutureId()
	{
		return FutureId;
	}
	public void setFutureId(long value)
	{
		FutureId = value;
	}
	public long getIssuerId()
	{
		return IssuerId;
	}
	public void setIssuerId(long value)
	{
		IssuerId = value;
	}
	public TI_EXPIRY_TYPE_Enum getExpiryType()
	{
		return ExpiryType;
	}
	public void setExpiryType(TI_EXPIRY_TYPE_Enum value)
	{
		ExpiryType = value;
	}
	public String getReutersCode()
	{
		return ReutersCode;
	}
	public void setReutersCode(String value)
	{
		ReutersCode = value;
	}
	public String getBloombergCode()
	{
		return BloombergCode;
	}
	public void setBloombergCode(String value)
	{
		BloombergCode = value;
	}
	public String getFutureDeliveryDesc()
	{
		return FutureDeliveryDesc;
	}
	public void setFutureDeliveryDesc(String value)
	{
		FutureDeliveryDesc = value;
	}
	public String getFutureDeliveryCode()
	{
		return FutureDeliveryCode;
	}
	public void setFutureDeliveryCode(String value)
	{
		FutureDeliveryCode = value;
	}
	public long getExpiryDate()
	{
		return ExpiryDate;
	}
	public void setExpiryDate(long value)
	{
		ExpiryDate = value;
	}
	public long getDeliveryDate()
	{
		return DeliveryDate;
	}
	public void setDeliveryDate(long value)
	{
		DeliveryDate = value;
	}
	public long getFutureSize()
	{
		return FutureSize;
	}
	public void setFutureSize(long value)
	{
		FutureSize = value;
	}
	public double getReferencePrice()
	{
		return ReferencePrice;
	}
	public void setReferencePrice(double value)
	{
		ReferencePrice = value;
	}
	public long getReferencePriceDate()
	{
		return ReferencePriceDate;
	}
	public void setReferencePriceDate(long value)
	{
		ReferencePriceDate = value;
	}
	public double getBPV()
	{
		return BPV;
	}
	public void setBPV(double value)
	{
		BPV = value;
	}
	public String getCurrencyCode()
	{
		return CurrencyCode;
	}
	public void setCurrencyCode(String value)
	{
		CurrencyCode = value;
	}
	public long getRollingDate()
	{
		return RollingDate;
	}
	public void setRollingDate(long value)
	{
		RollingDate = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		FinancialInstrumentId = (long)byteBuffer.readInt();
		FutureId = (long)byteBuffer.readInt();
		IssuerId = (long)byteBuffer.readInt();
		ExpiryType = ExpiryType.getEnum(byteBuffer.readInt());
		ReutersCode = byteBuffer.readString();
		BloombergCode = byteBuffer.readString();
		FutureDeliveryDesc = byteBuffer.readString();
		FutureDeliveryCode = byteBuffer.readString();
		ExpiryDate = (long)byteBuffer.readInt();
		DeliveryDate = (long)byteBuffer.readInt();
		FutureSize = (long)byteBuffer.readInt();
		ReferencePrice = byteBuffer.readDouble();
		ReferencePriceDate = (long)byteBuffer.readInt();
		BPV = byteBuffer.readDouble();
		CurrencyCode = byteBuffer.readString();
		RollingDate = (long)byteBuffer.readInt();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(FinancialInstrumentId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(FutureId & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(IssuerId & 0xFFFFFFFFL));
		byteBuffer.writeInt(ExpiryType.getValue());
		byteBuffer.writeString(ReutersCode);
		byteBuffer.writeString(BloombergCode);
		byteBuffer.writeString(FutureDeliveryDesc);
		byteBuffer.writeString(FutureDeliveryCode);
		byteBuffer.writeInt((int)(ExpiryDate & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(DeliveryDate & 0xFFFFFFFFL));
		byteBuffer.writeInt((int)(FutureSize & 0xFFFFFFFFL));
		byteBuffer.writeDouble(ReferencePrice);
		byteBuffer.writeInt((int)(ReferencePriceDate & 0xFFFFFFFFL));
		byteBuffer.writeDouble(BPV);
		byteBuffer.writeString(CurrencyCode);
		byteBuffer.writeInt((int)(RollingDate & 0xFFFFFFFFL));

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
		stringBuilder.append("TI_FUTURE_DELIVERY::");
		stringBuilder.append("FinancialInstrumentId(").append(FinancialInstrumentId).append(")");
		stringBuilder.append("FutureId(").append(FutureId).append(")");
		stringBuilder.append("IssuerId(").append(IssuerId).append(")");
		stringBuilder.append("ExpiryType(").append(ExpiryType).append(")");
		stringBuilder.append("ReutersCode(").append(ReutersCode).append(")");
		stringBuilder.append("BloombergCode(").append(BloombergCode).append(")");
		stringBuilder.append("FutureDeliveryDesc(").append(FutureDeliveryDesc).append(")");
		stringBuilder.append("FutureDeliveryCode(").append(FutureDeliveryCode).append(")");
		stringBuilder.append("ExpiryDate(").append(ExpiryDate).append(")");
		stringBuilder.append("DeliveryDate(").append(DeliveryDate).append(")");
		stringBuilder.append("FutureSize(").append(FutureSize).append(")");
		stringBuilder.append("ReferencePrice(").append(ReferencePrice).append(")");
		stringBuilder.append("ReferencePriceDate(").append(ReferencePriceDate).append(")");
		stringBuilder.append("BPV(").append(BPV).append(")");
		stringBuilder.append("CurrencyCode(").append(CurrencyCode).append(")");
		stringBuilder.append("RollingDate(").append(RollingDate).append(")");
		return stringBuilder.toString();
	}
}
