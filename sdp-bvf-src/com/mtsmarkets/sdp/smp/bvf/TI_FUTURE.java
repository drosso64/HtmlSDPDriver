package com.mtsmarkets.sdp.smp.bvf;

import com.mtsmarkets.io.xdr.*;
import com.mtsmarkets.sdp.smp.SMPMessage;
public class TI_FUTURE extends SMPMessage
{
	public static final long CLASS_ID = 100048;

	private long FutureId = 0;
	private String FutureCode = "";
	private String FutureDesc = "";
	private long ExchangeId = 0;
	private TI_FLAG_Enum HasDeliverableFlag = TI_FLAG_Enum.TI_FLAG_No;
	private long SortNumber = 0;

	public TI_FUTURE()
	{
	}

	public long getFutureId()
	{
		return FutureId;
	}
	public void setFutureId(long value)
	{
		FutureId = value;
	}
	public String getFutureCode()
	{
		return FutureCode;
	}
	public void setFutureCode(String value)
	{
		FutureCode = value;
	}
	public String getFutureDesc()
	{
		return FutureDesc;
	}
	public void setFutureDesc(String value)
	{
		FutureDesc = value;
	}
	public long getExchangeId()
	{
		return ExchangeId;
	}
	public void setExchangeId(long value)
	{
		ExchangeId = value;
	}
	public TI_FLAG_Enum getHasDeliverableFlag()
	{
		return HasDeliverableFlag;
	}
	public void setHasDeliverableFlag(TI_FLAG_Enum value)
	{
		HasDeliverableFlag = value;
	}
	public long getSortNumber()
	{
		return SortNumber;
	}
	public void setSortNumber(long value)
	{
		SortNumber = value;
	}

	@Override
	public void readXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		FutureId = (long)byteBuffer.readInt();
		FutureCode = byteBuffer.readString();
		FutureDesc = byteBuffer.readString();
		ExchangeId = (long)byteBuffer.readInt();
		HasDeliverableFlag = HasDeliverableFlag.getEnum(byteBuffer.readInt());
		SortNumber = (long)byteBuffer.readInt();
	}
	@Override
	public int writeXDR(XDRByteBuffer byteBuffer) throws Exception
	{
		int init = byteBuffer.position();

		byteBuffer.writeInt((int)(FutureId & 0xFFFFFFFFL));
		byteBuffer.writeString(FutureCode);
		byteBuffer.writeString(FutureDesc);
		byteBuffer.writeInt((int)(ExchangeId & 0xFFFFFFFFL));
		byteBuffer.writeInt(HasDeliverableFlag.getValue());
		byteBuffer.writeInt((int)(SortNumber & 0xFFFFFFFFL));

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
		stringBuilder.append("TI_FUTURE::");
		stringBuilder.append("FutureId(").append(FutureId).append(")");
		stringBuilder.append("FutureCode(").append(FutureCode).append(")");
		stringBuilder.append("FutureDesc(").append(FutureDesc).append(")");
		stringBuilder.append("ExchangeId(").append(ExchangeId).append(")");
		stringBuilder.append("HasDeliverableFlag(").append(HasDeliverableFlag).append(")");
		stringBuilder.append("SortNumber(").append(SortNumber).append(")");
		return stringBuilder.toString();
	}
}
