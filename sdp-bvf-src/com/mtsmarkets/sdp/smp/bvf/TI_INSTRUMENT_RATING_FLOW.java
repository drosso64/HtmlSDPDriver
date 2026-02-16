package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_INSTRUMENT_RATING_FLOW extends SMPMessage
{
	public static final long CLASS_ID = 100817;

	private long FinancialInstrumentId = 0;
	private TI_INSTRUMENT_TYPE_Enum InstrumentType = TI_INSTRUMENT_TYPE_Enum.TI_INSTRUMENT_TYPE_Bond;
	private String RatingIssuer = "";
	private String RatingValue = "";
	private String AdditionalRatingInfo = "";
	private long UpdateDate = 0;
	private long UpdateTime = 0;

	public TI_INSTRUMENT_RATING_FLOW()
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
	public TI_INSTRUMENT_TYPE_Enum getInstrumentType()
	{
		return InstrumentType;
	}
	public void setInstrumentType(TI_INSTRUMENT_TYPE_Enum value)
	{
		InstrumentType = value;
	}
	public String getRatingIssuer()
	{
		return RatingIssuer;
	}
	public void setRatingIssuer(String value)
	{
		RatingIssuer = value;
	}
	public String getRatingValue()
	{
		return RatingValue;
	}
	public void setRatingValue(String value)
	{
		RatingValue = value;
	}
	public String getAdditionalRatingInfo()
	{
		return AdditionalRatingInfo;
	}
	public void setAdditionalRatingInfo(String value)
	{
		AdditionalRatingInfo = value;
	}
	public long getUpdateDate()
	{
		return UpdateDate;
	}
	public void setUpdateDate(long value)
	{
		UpdateDate = value;
	}
	public long getUpdateTime()
	{
		return UpdateTime;
	}
	public void setUpdateTime(long value)
	{
		UpdateTime = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		FinancialInstrumentId = (long)byteBuffer.readInt();
		InstrumentType = InstrumentType.getEnum(byteBuffer.readInt());
		RatingIssuer = byteBuffer.readString();
		RatingValue = byteBuffer.readString();
		AdditionalRatingInfo = byteBuffer.readString();
		UpdateDate = (long)byteBuffer.readInt();
		UpdateTime = byteBuffer.readLong();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(FinancialInstrumentId & 0xFFFFFFFFL));
		byteBuffer.writeInt(InstrumentType.getValue());
		byteBuffer.writeString(RatingIssuer);
		byteBuffer.writeString(RatingValue);
		byteBuffer.writeString(AdditionalRatingInfo);
		byteBuffer.writeInt((int)(UpdateDate & 0xFFFFFFFFL));
		byteBuffer.writeLong(UpdateTime);

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
		stringBuilder.append("TI_INSTRUMENT_RATING_FLOW::");
		stringBuilder.append("FinancialInstrumentId(").append(FinancialInstrumentId).append(")");
		stringBuilder.append("InstrumentType(").append(InstrumentType).append(")");
		stringBuilder.append("RatingIssuer(").append(RatingIssuer).append(")");
		stringBuilder.append("RatingValue(").append(RatingValue).append(")");
		stringBuilder.append("AdditionalRatingInfo(").append(AdditionalRatingInfo).append(")");
		stringBuilder.append("UpdateDate(").append(UpdateDate).append(")");
		stringBuilder.append("UpdateTime(").append(UpdateTime).append(")");
		return stringBuilder.toString();
	}
}
